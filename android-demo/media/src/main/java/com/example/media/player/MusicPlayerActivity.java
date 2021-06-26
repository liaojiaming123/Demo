package com.example.media.player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.media.R;

import java.io.IOException;
import java.lang.ref.WeakReference;

@Router(path = "/music_player_activity")
public class MusicPlayerActivity extends AppCompatActivity implements View.OnClickListener{
    private MediaPlayer mediaPlayer;
    private Context context;
    private AssetFileDescriptor assetFileDescriptor;
    private TextView tvPosition, tvLength;
    private TextView musicPlay, musicStop;
    private Switch musicLoop;
    private SeekBar musicSeekBar;
    private boolean isDestroy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        context = getApplicationContext();
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("MediaPlayer");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        musicPlay = (TextView) findViewById(R.id.music_play_play);
        musicPlay.setOnClickListener(this);
        musicStop = (TextView) findViewById(R.id.music_play_stop);
        musicStop.setOnClickListener(this);
        tvPosition = (TextView)findViewById(R.id.tv_music_play_position);
        tvLength = (TextView) findViewById(R.id.tv_music_play_length);
        musicLoop = (Switch) findViewById(R.id.music_loop);
        musicSeekBar = (SeekBar) findViewById(R.id.music_seek_bar);

        musicLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mediaPlayer.setLooping(true);
                    Toast.makeText(context, "循环播放已开启", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.setLooping(false);
                    Toast.makeText(context, "循环播放已关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.music_play_play) {
            musicPlay();
        } else if (id == R.id.music_play_stop) {
            musicStop();
        }
    }

    private static class MyHandler extends Handler {
        private WeakReference<MusicPlayerActivity> weakReference;
        public MyHandler(MusicPlayerActivity activity) {
            weakReference = new WeakReference<MusicPlayerActivity>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    }
    MyHandler myHandler = new MyHandler(this);
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (!isDestroy) {
                int currentTime = Math.round(mediaPlayer.getCurrentPosition() / 1000);
                String currentStr = String.format("%02d:%02d",currentTime / 60, currentTime % 60);
                tvPosition.setText(currentStr);
                musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
                myHandler.postDelayed(this, 1000);
            }
        }
    };

    private void init() throws IOException {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        assetFileDescriptor = context.getAssets().openFd("music/0.mp3");
        mediaPlayer.reset();
        mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        mediaPlayer.prepareAsync();
    }

    private void musicPostDelayed(){
        if (mediaPlayer.isPlaying()){
            int totalTime = Math.round(mediaPlayer.getDuration() / 1000);
            String str = String.format("%02d:%02d", totalTime / 60,totalTime % 60);
            tvLength.setText(str);
            musicSeekBar.setMax(mediaPlayer.getDuration());
            myHandler.postDelayed(runnable,1000);
        }
    }

    class PlayThread extends Thread{
        @Override
        public void run() {
            super.run();
            if (!mediaPlayer.isPlaying()){
                mediaPlayer.start();
            }
        }
    }
    PlayThread playThread = new PlayThread();
    private void playAuto(){
        if (mediaPlayer != null && !mediaPlayer.isPlaying()){
            playThread.run();
        }
    }
    private void musicPlay() {
        if (!mediaPlayer.isPlaying()) {
            playThread.run();
        } else {
            mediaPlayer.pause();
        }
    }

    private void musicStop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.prepareAsync();
            if (!mediaPlayer.isPlaying()){
                musicSeekBar.setProgress(0);
                tvPosition.setText("00:00");
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        musicPostDelayed();
        musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    if (mediaPlayer != null) {
                        mediaPlayer.seekTo(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroy = true;
        mediaPlayer.release();
        mediaPlayer = null;
        try {
            assetFileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            MusicPlayerActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
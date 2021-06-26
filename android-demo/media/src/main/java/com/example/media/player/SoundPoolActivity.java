package com.example.media.player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.didi.drouter.annotation.Router;
import com.example.media.R;

@Router(path = "/sound_pool_activity")
public class SoundPoolActivity extends AppCompatActivity implements View.OnClickListener {
    private SoundPool soundPool;
    private SoundPool.Builder builder;
    private AudioAttributes audioAttributes;
    private AudioAttributes.Builder attrBuilder;
    private Context context;
    private int soundId1,soundId2,soundId3;
    private TextView tvSound1,tvSound2,tvSound3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool);
        ActionBar actionBar = getSupportActionBar();
        context = getApplicationContext();
        assert actionBar != null;
        actionBar.setTitle("SoundPool");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        tvSound1 = (TextView)findViewById(R.id.tv_sound_1);
        tvSound2 = (TextView)findViewById(R.id.tv_sound_2);
        tvSound3 = (TextView)findViewById(R.id.tv_sound_3);
        attrBuilder = new AudioAttributes.Builder();
        attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC);
        audioAttributes = attrBuilder.build();

        tvSound1.setOnClickListener(this);
        tvSound2.setOnClickListener(this);
        tvSound3.setOnClickListener(this);

        init();
    }
    private void init(){
        if (soundPool == null){
            builder = new SoundPool.Builder();
            builder.setMaxStreams(1);
            builder.setAudioAttributes(audioAttributes);
            soundPool = builder.build();
        }
        soundId1 = soundPool.load(context,R.raw.hello,4);
        soundId2= soundPool.load(context,R.raw.dingdong,4);
        soundId3 = soundPool.load(context,R.raw.didi,4);
    }

    SoundPool.OnLoadCompleteListener loadCompleteListener = new SoundPool.OnLoadCompleteListener() {
        @Override
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

        }
    };
    private void soundPlay1(){
        if (soundPool != null){
            soundPool.play(soundId1,1,1,4,0,1);
        }
    }
    private void soundPlay2(){
        if (soundPool != null){
            soundPool.play(soundId2,1,1,4,2,1);
        }
    }
    private void soundPlay3(){
        if (soundPool != null){
            soundPool.play(soundId3,1,1,4,1,1);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            SoundPoolActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_sound_1) {
            soundPlay1();
        } else if (id == R.id.tv_sound_2) {
            soundPlay2();
        } else if (id == R.id.tv_sound_3) {
            soundPlay3();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
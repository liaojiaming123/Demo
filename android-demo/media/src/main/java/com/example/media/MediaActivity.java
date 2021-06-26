package com.example.media;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.didi.drouter.annotation.Router;
import com.didi.drouter.api.DRouter;

@Router(path = "/media_activity")
public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Android Media");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        TextView tv_music_player = (TextView)findViewById(R.id.tv_music_player);
        tv_music_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/music_player_activity").start();
            }
        });
        TextView tv_sound_pool = (TextView)findViewById(R.id.tv_sound_pool);
        tv_sound_pool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/sound_pool_activity").start();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            MediaActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
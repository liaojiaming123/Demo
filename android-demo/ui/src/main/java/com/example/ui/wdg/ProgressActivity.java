package com.example.ui.wdg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

@Router(path = "/progress_activity")
public class ProgressActivity extends AppCompatActivity {
    private ImageView img_progressBar;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("ProgressBar");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        img_progressBar = (ImageView)findViewById(R.id.img_progress);
        animationDrawable = (AnimationDrawable) img_progressBar.getDrawable();
        running();
        img_progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                } else {
                    running();
                }
            }
        });
    }
    private void running() {
        img_progressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        }, 100);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            ProgressActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
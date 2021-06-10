package com.example.ui.wdg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ui.R;

public class ProgressActivity extends AppCompatActivity {
    private ImageView img_progressBar;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
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
}
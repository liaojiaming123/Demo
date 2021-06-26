package com.example.media;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.didi.drouter.annotation.Router;

@Router(path = "/media_activity")
public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
    }
}
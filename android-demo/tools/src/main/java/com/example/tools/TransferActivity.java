package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.didi.drouter.annotation.Router;

@Router(path = "/transfer_activity")
public class TransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
    }
}
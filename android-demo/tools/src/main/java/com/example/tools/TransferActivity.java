package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.common.BaseApplication;
//import com.yanzhenjie.andserver.AndServer;
//import com.yanzhenjie.andserver.Server;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

@Router(path = "/transfer_activity")
public class TransferActivity extends AppCompatActivity {
    private Context context = BaseApplication.getContext();
    private TextView tv_start,tv_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        tv_start = (TextView)findViewById(R.id.server_start);
        tv_stop = (TextView)findViewById(R.id.server_stop);
        tv_start.setOnClickListener((v->{
//            server.startup();
        }));
        tv_stop.setOnClickListener((v -> {
//            server.shutdown();
        }));
    }

//   Server server = AndServer.webServer(context)
//            .port(8080)
//            .timeout(10, TimeUnit.SECONDS)
//            .build();


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (server.isRunning()) {
//            server.shutdown();
//        }
    }

}
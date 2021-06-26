package com.example.helper.net;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.didi.drouter.annotation.Router;
import com.example.helper.R;

import java.io.IOException;

@Router(path = "/http_conn_activity")
public class HttpConnActivity extends AppCompatActivity {
    private Context context;
    private EditText ev_conn_url;
    private TextView tv_conn_get,tv_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_conn);
        context = getApplicationContext();
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("HttpURLConnection");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ev_conn_url = (EditText)findViewById(R.id.ev_conn_url);
        tv_conn_get = (TextView)findViewById(R.id.tv_conn_get);
        tv_res = (TextView)findViewById(R.id.tv_res);

        HttpConnUtil util = new HttpConnUtil(context);
        tv_conn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpConnActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String res = util.getStringAsync(ev_conn_url.getText().toString(),5000,5000);
                        tv_res.setText(res);
                    }
                });
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            HttpConnActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
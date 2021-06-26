package com.example.helper;

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
import com.example.helper.perm.PermActivity;

@Router(path = "/helper_activity")
public class HelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Android Utils");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        TextView tv_permission = findViewById(R.id.tv_permission);
        tv_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/perm_activity").start();
            }
        });
        TextView tv_and_permission = findViewById(R.id.tv_and_permission);
        tv_and_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/and_permission_activity").start();
            }
        });
        TextView tv_easy_permission = findViewById(R.id.tv_easy_permission);
        tv_easy_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/easy_permission_activity").start();
            }
        });

        TextView tv_sp = findViewById(R.id.tv_sp);
        tv_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/sp_activity").start();
            }
        });
        TextView tv_in = findViewById(R.id.tv_in);
        tv_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/internal_activity").start();
            }
        });
        TextView tv_ex = findViewById(R.id.tv_ex);
        tv_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/external_activity").start();
            }
        });
        TextView tv_http_conn = findViewById(R.id.tv_http_conn);
        tv_http_conn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/http_conn_activity").start();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            HelperActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
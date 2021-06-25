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
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            HelperActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
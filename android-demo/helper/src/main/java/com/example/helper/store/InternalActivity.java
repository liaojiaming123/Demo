package com.example.helper.store;

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
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.helper.R;

import java.io.IOException;

@Router(path = "/internal_activity")
public class InternalActivity extends AppCompatActivity {
    private Context context;
    private String in_content;
    private String in_name;
    private EditText ev_content,ev_name;
    private TextView tv_save,tv_read,tv_cache,tv_remove,tv_del,tv_store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        context = getApplicationContext();
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("InternalStore");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ev_content = (EditText)findViewById(R.id.ev_in_content);
        ev_name = (EditText)findViewById(R.id.ev_in_name);
        in_content = ev_content.getText().toString();
        in_name = ev_name.getText().toString();
        tv_save = (TextView)findViewById(R.id.tv_in_save);
        tv_read = (TextView)findViewById(R.id.tv_in_read);
        tv_cache = (TextView)findViewById(R.id.tv_in_cache);
        tv_remove = (TextView)findViewById(R.id.tv_in_remove);
        tv_del = (TextView)findViewById(R.id.tv_in_del);
        tv_store = (TextView)findViewById(R.id.tv_in_store);
        InStoreUtil util = new InStoreUtil(context);

        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    util.saveFile(in_name,in_content);
                    Toast.makeText(context,"保存成功！",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(context,"保存失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(context,util.readFile(in_name),Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(context,"读取失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    util.saveCache(in_name,in_content);
                    Toast.makeText(context,"缓存成功！",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(context,"缓存失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                util.clearCacheAll();
                Toast.makeText(context,"清除成功！",Toast.LENGTH_SHORT).show();
            }
        });
        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                util.deleteFile(in_name);
                Toast.makeText(context,"删除成功！",Toast.LENGTH_SHORT).show();
            }
        });
        tv_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"总空间："+util.getMemorySize()+"；可用空间："+util.getMemoryASize(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            InternalActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
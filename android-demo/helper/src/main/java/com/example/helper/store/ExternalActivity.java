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

@Router(path = "/external_activity")
public class ExternalActivity extends AppCompatActivity {
    private Context context;
    private String ex_content;
    private String ex_name;
    private EditText ev_content,ev_name;
    private TextView tv_check,tv_save,tv_read,tv_del,tv_store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
        context = getApplicationContext();
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("ExternalStore");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ev_content = (EditText)findViewById(R.id.ev_ex_content);
        ev_name = (EditText)findViewById(R.id.ev_ex_name);
        ex_content = ev_content.getText().toString();
        ex_name = ev_name.getText().toString();
        tv_check = (TextView)findViewById(R.id.tv_ex_check);
        tv_save = (TextView)findViewById(R.id.tv_ex_save);
        tv_read = (TextView)findViewById(R.id.tv_ex_read);
        tv_del = (TextView)findViewById(R.id.tv_ex_del);
        tv_store = (TextView)findViewById(R.id.tv_ex_store);
        ExStoreUtil util = new ExStoreUtil(context);

        tv_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ExStoreUtil.hasSDCard()){
                    Toast.makeText(context,"手机SD卡已就绪",Toast.LENGTH_SHORT).show();
                }else {Toast.makeText(context,"手机没有挂载SD卡",Toast.LENGTH_SHORT).show();}
            }
        });
        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    util.saveFile(ex_name,ex_content);
                    Toast.makeText(context,"保存成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(context,"保存失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(context,util.readFile(ex_name),Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                util.deleteFile(ex_name);
                Toast.makeText(context,"删除成功！",Toast.LENGTH_SHORT).show();
            }
        });
        tv_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"总空间："+util.getSDCardSize()+"；可用空间："+util.getSDCardASize(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            ExternalActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
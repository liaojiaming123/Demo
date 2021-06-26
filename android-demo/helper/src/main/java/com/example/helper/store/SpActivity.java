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

@Router(path = "/sp_activity")
public class SpActivity extends AppCompatActivity {
    private Context context;
    private String sp_content;
    private String sp_name;
    private EditText ev_content,ev_name;
    private TextView tv_save,tv_read,tv_remove,tv_del;
    private final int mode = MODE_APPEND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        context = getApplicationContext();
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("SharedPreference");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ev_content = (EditText)findViewById(R.id.ev_sp_content);
        ev_name = (EditText)findViewById(R.id.ev_sp_name);
        sp_content = ev_content.getText().toString();
        sp_name = ev_name.getText().toString();
        tv_save = (TextView)findViewById(R.id.tv_sp_save);
        tv_read = (TextView)findViewById(R.id.tv_sp_read);
        tv_remove = (TextView)findViewById(R.id.tv_sp_remove);
        tv_del = (TextView)findViewById(R.id.tv_sp_del);

        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpUtil.getInstance(context,sp_name,mode).save("mysp",sp_content);
                Toast.makeText(context,"保存成功！",Toast.LENGTH_SHORT).show();
            }
        });
        tv_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,SpUtil.getInstance(context,sp_name,mode).getString("mysp","提示：没有内容"),Toast.LENGTH_SHORT).show();
            }
        });
        tv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpUtil.getInstance(context,sp_name,mode).remove("mysp");
                Toast.makeText(context,"移除成功！",Toast.LENGTH_SHORT).show();
            }
        });
        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpUtil.getInstance(context,sp_name,mode).deleteFile(sp_name);
                Toast.makeText(context,"删除成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            SpActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
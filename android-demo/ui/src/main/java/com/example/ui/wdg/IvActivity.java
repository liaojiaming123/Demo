package com.example.ui.wdg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

@Router(path = "/iv_activity")
public class IvActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv);
        context = this;
        //实现圆角图片
        ImageView imageView = (ImageView)findViewById(R.id.iv_round);
        CornerImageView cornerImageView = new CornerImageView(context);
        cornerImageView.setType(0);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("ImageView");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            IvActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
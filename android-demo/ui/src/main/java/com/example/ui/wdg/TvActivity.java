package com.example.ui.wdg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

@Router(path = "/tv_activity")
public class TvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        TextView tv_text_gradient = (TextView)findViewById(R.id.tv_text_gradient);
        LinearGradient mLinearGradient = new LinearGradient(0, 0, tv_text_gradient.getPaint().getTextSize()* tv_text_gradient.getText()
                .length(), 0, Color.parseColor("#FFFF68FF"), Color.parseColor("#FFFED732"), Shader.TileMode.CLAMP);
        tv_text_gradient.getPaint().setShader(mLinearGradient);
        tv_text_gradient.invalidate();
        //多种颜色渐变
        TextView textView = (TextView)findViewById(R.id.tv_base_fragment_text_gradient_multi);
        setTextViewStyles(textView);

        //跑马灯
        TextView tv_marquee = (TextView)findViewById(R.id.tv_marquee);
        tv_marquee.setFocusable(true);
        tv_marquee.setSelected(true);
        tv_marquee.setFocusableInTouchMode(true);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        //actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));//设置actionbar背景
        actionBar.setTitle("TextView");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
//        actionBar.setHomeAsUpIndicator(R.drawable.icon_close_24);//修改默认返回按钮图片
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    private void setTextViewStyles(TextView textView) {
        //多种颜色文本渐变
        int[] colors = {Color.RED, Color.GREEN, Color.BLUE};//颜色的数组
        float[] position = {0f, 0.7f, 1.0f};//颜色渐变位置的数组
        LinearGradient linearGradient = new LinearGradient(0, 0, textView.getPaint().getTextSize() * textView.getText().length(), 0, colors, position, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(linearGradient);
        textView.invalidate();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            TvActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.ui.wdg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

@Router(path = "/switch_activity")
public class SwitchActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        context = this;
        //ToggleButton 开关按钮
        ToggleButton tgb_on = (ToggleButton)findViewById(R.id.tgb_on);
        tgb_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_off = (ToggleButton)findViewById(R.id.tgb_off);
        tgb_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_disable = (ToggleButton)findViewById(R.id.tgb_disable);
        tgb_disable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        /*
        ToggleButton tgb_on_c = (ToggleButton)findViewById(R.id.tgb_on_c);
        tgb_on_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_off_c = (ToggleButton)findViewById(R.id.tgb_off_c);
        tgb_off_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_disable_c = (ToggleButton)findViewById(R.id.tgb_disable_c);
        tgb_disable_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
         */
        //Switch 开关
        Switch swh_on = (Switch)findViewById(R.id.switch_on);
        swh_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_off = (Switch)findViewById(R.id.switch_off);
        swh_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_disable = (Switch)findViewById(R.id.switch_disable);
        swh_disable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        /*
        Switch swh_on_c = (Switch)findViewById(R.id.switch_on_c);
        swh_on_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_off_c = (Switch)findViewById(R.id.switch_off_c);
        swh_off_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_disable_c = (Switch)findViewById(R.id.switch_disable_c);
        swh_disable_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭", Toast.LENGTH_SHORT).show();
            }
        });

         */

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Switch Toggle");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            SwitchActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
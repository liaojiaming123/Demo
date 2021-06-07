package com.example.ui.wdg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

@Router(path = "/check_activity")
public class CheckActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        context = this;

        //单选按钮组
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group_fruit);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    Toast.makeText(context, "选择了苹果", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioButton2) {
                    Toast.makeText(context, "选择了西瓜", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioButton3) {
                    Toast.makeText(context, "选择了樱桃", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //多选按钮
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了苹果",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了苹果",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了西瓜",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了西瓜",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了樱桃",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了樱桃",Toast.LENGTH_SHORT).show();
            }
        });
/*
        //单选按钮组
        RadioGroup radioGroup_c = (RadioGroup)findViewById(R.id.radio_group_fruit_c);
        radioGroup_c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton_c) {
                    Toast.makeText(context, "选择了苹果", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioButton2_c) {
                    Toast.makeText(context, "选择了西瓜", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioButton3_c) {
                    Toast.makeText(context, "选择了樱桃", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //多选按钮
        CheckBox checkBox_c = (CheckBox)findViewById(R.id.checkBox_c);
        checkBox_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了苹果",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了苹果",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox2_c = (CheckBox)findViewById(R.id.checkBox2_c);
        checkBox2_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了西瓜",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了西瓜",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox3_c = (CheckBox)findViewById(R.id.checkBox3_c);
        checkBox3_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了樱桃",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了樱桃",Toast.LENGTH_SHORT).show();
            }
        });

 */

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("CheckBox Radio");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            CheckActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
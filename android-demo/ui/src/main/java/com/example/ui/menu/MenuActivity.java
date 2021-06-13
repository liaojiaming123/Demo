package com.example.ui.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;
import com.example.ui.wdg.EvActivity;

@Router(path = "/menu_activity")
public class MenuActivity extends AppCompatActivity {
    private Context context;
    private TextView context_menu,popup_menu;
    private Spinner spinner_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = this;
        context_menu = (TextView) findViewById(R.id.context_menu);
        popup_menu = (TextView) findViewById(R.id.popup_menu);
        spinner_menu = (Spinner)findViewById(R.id.spinner_menu);
        registerForContextMenu(context_menu);//注册上下文菜单
        createPopupMenu();
        spinner_menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(context,"点击了选项一",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context,"点击了选项二",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(context,"点击了选项三",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Menu");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(context).inflate(R.menu.context_menu,menu);
        //创建上下文菜单，加载菜单布局
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //上下文菜单选项选择事件
        int itemId = item.getItemId();
        if (itemId == R.id.context1_menu) {
            Toast.makeText(context, "点击了选项1", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.context2_menu) {
            Toast.makeText(context, "点击了选项2", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.context3_menu) {
            Toast.makeText(context, "点击了选项3", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.context1_sub_menu) {
            Toast.makeText(context, "点击了子菜单", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.context2_sub_menu) {
            Toast.makeText(context, "点击了子选项1", Toast.LENGTH_SHORT).show();
            item.setCheckable(true);
        } else if (itemId == R.id.context3_sub_menu) {
            Toast.makeText(context, "点击了子选项2", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
    private void createPopupMenu(){
        //创建弹出菜单
        popup_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,popup_menu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();
                        if (itemId == R.id.popup1) {
                            Toast.makeText(context, "点击了选项1", Toast.LENGTH_SHORT).show();
                        } else if (itemId == R.id.popup2) {
                            Toast.makeText(context, "点击了选项2", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 重写该方法添加选项菜单 也可以在布局文件中设置
        MenuInflater menuInflater = new MenuInflater(context);
        menuInflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.opt_1) {
            Toast.makeText(context,"点击了选项一",Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.opt_2){
            Toast.makeText(context,"点击了选项二",Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.opt_3){
            Toast.makeText(context,"点击了选项三",Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            MenuActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.ui.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ui.R;

public class MenuActivity extends AppCompatActivity {
    private Context context;
    private TextView context_menu,popup_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = this;
        context_menu = (TextView) findViewById(R.id.context_menu);
        popup_menu = (TextView) findViewById(R.id.popup_menu);
        registerForContextMenu(context_menu);//注册上下文菜单
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
}
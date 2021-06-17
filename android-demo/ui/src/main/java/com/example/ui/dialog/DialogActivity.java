package com.example.ui.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ui.R;

public class DialogActivity extends AppCompatActivity {
    private TextView dialog_simple,dialog_list,dialog_single,dialog_multi;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        context = this;
        dialog_simple = (TextView)findViewById(R.id.dialog_alert_simple);
        dialog_list = (TextView)findViewById(R.id.dialog_alert_list);
        dialog_single = (TextView)findViewById(R.id.dialog_alert_single);
        dialog_multi = (TextView)findViewById(R.id.dialog_alert_multi);
        dialog_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlertSimple();
            }
        });
        dialog_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlertList();
            }
        });
        dialog_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlertSingle();
            }
        });
        dialog_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlertMulti();
            }
        });
    }
    private void createAlertSimple(){
        builder = new AlertDialog.Builder(context);
        alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                .setMessage("这是内容")
                .setTitle("标题")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了确定",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了返回",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了取消",Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }
    private void createAlertList(){
        final CharSequence[] items = {"Java","JavaScript","Python","C/C++","PHP"};
        builder = new AlertDialog.Builder(context);
        alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("列表框")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了"+items[which],Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(true)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(context,"点击了取消",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了返回",Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }
    private void createAlertSingle(){
        final CharSequence[] single = {"Apple","Banana","Lemon","Orange","Watermelon"};
        builder = new AlertDialog.Builder(context);
        final int[] position = new int[1];
        alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("单选框")
                .setSingleChoiceItems(single,0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position[0] = which;
                        Toast.makeText(context,"点击了"+single[which],Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        which = position[0];
                        Toast.makeText(context,"选择了"+single[which],Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了取消",Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }
    private void createAlertMulti(){
        final CharSequence[] multi = {"Apple","Banana","Lemon","Orange","Watermelon"};
        builder = new AlertDialog.Builder(context);
        final boolean[] checkItems = new boolean[]{false, false, false, false,false};
        alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("多选框")
                .setMultiChoiceItems(multi, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkItems[which] = isChecked;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for (int i = 0; i < checkItems.length; i++) {
                            if (checkItems[i])
                                result += multi[i] + " ";
                        }
                        Toast.makeText(context, "选择了:" + result, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "点击了取消", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }
}
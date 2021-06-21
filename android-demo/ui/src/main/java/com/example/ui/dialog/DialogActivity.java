package com.example.ui.dialog;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@Router(path = "/dialog_activity")
public class DialogActivity extends AppCompatActivity {
    private TextView dialog_simple,dialog_list,dialog_single,dialog_multi;
    private TextView progress_circle,progress_linear,progress_update;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private Context context;

    private ProgressDialog progressDialog;

    private PopupWindow popupWindow;
    private ListPopupWindow listPopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Dialog");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

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

        progress_circle = (TextView)findViewById(R.id.dialog_progress_circle);
        progress_linear = (TextView)findViewById(R.id.dialog_progress_linear);
        progress_update = (TextView)findViewById(R.id.dialog_progress_update);
        progress_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProgressCircle();
            }
        });
        progress_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProgressLinear();
            }
        });
        progress_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProgressUpdate();
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
    private void createProgressCircle(){
        progressDialog = new ProgressDialog(context);
        progressDialog.setIcon(R.mipmap.ic_launcher_round);
        progressDialog.setTitle("资源加载中");
        progressDialog.setMessage("资源加载中,请稍后...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
    private void createProgressLinear(){
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("软件更新中");
        progressDialog.setMessage("软件更新中，请稍后...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    private int progressStart = 0;
    private int add = 0;

    private static class MyHandler extends Handler {
        private WeakReference<DialogActivity> weakReference;
        private ProgressDialog progressDialog;
        private int progressStart;
        public MyHandler(DialogActivity activity){
            weakReference = new WeakReference<DialogActivity>(activity);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 123) {progressDialog.setProgress(progressStart);}
            //如果当前大于或等于进度条的最大值,调用dismiss()方法关闭对话框
            if(progressStart >= 100){progressDialog.dismiss();}
        }
    }
    private void createProgressUpdate(){
        final MyHandler myHandler = new MyHandler(this);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMax(100);
        progressDialog.setTitle("文件读取中");
        progressDialog.setMessage("文件读取中，请稍后...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        myHandler.progressDialog = progressDialog;
        myHandler.progressStart = progressStart;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(myHandler.progressStart < 100){
                    myHandler.progressStart = 2 * useTime() ;
                    myHandler.sendEmptyMessage(123);
                }
            }
        }.start();
    }

    //这里设置一个耗时的方法:
    private int useTime() {
        add++;
        try{
            Thread.sleep(100);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return add;
    }

    private void createPopupWindowSimple(){
        popupWindow = new PopupWindow();
        popupWindow.setContentView(popupWindowSimple);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue_500)));
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(context,"弹框已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        tv_popup_window_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAsDropDown(tv_popup_window_simple,0,0, Gravity.CENTER);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            DialogActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private View popupWindowSimple;
    private TextView tv_popup_window_simple,tv_popup_window_list;
    private TextView tv_date_picker_dialog,tv_time_picker_dialog;
    @RequiresApi(api = Build.VERSION_CODES.N)
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onStart() {
        super.onStart();
        popupWindowSimple = LayoutInflater.from(context).inflate(R.layout.popup_window_simple,null,false);
        tv_popup_window_simple = findViewById(R.id.popup_window_simple);
        tv_popup_window_list = findViewById(R.id.popup_window_list);
        tv_date_picker_dialog = findViewById(R.id.dialog_date_picker);
        tv_time_picker_dialog = findViewById(R.id.dialog_time_picker);
        createPopupWindowSimple();
        createPopupWindowList();

        tv_date_picker_dialog.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                createDatePickerDialog();
            }
        });
        tv_time_picker_dialog.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                createTimePickerDialog();
            }
        });
    }
    private void createPopupWindowList(){
        List<String> list = new ArrayList<>();
        list.add("Java");list.add("Android");list.add("Python");
        listPopupWindow = new ListPopupWindow(context);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_expandable_list_item_1,list));
        listPopupWindow.setAnchorView(tv_popup_window_list);
        listPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        listPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        listPopupWindow.setModal(true);
        listPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(context,"弹框已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"点击了: "+list.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        tv_popup_window_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPopupWindow.show();
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createDatePickerDialog(){
        DatePickerDialog dialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int m = month+1;
                Toast.makeText(context,year+"-"+m+"-"+dayOfMonth,Toast.LENGTH_SHORT).show();
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createTimePickerDialog(){
        TimePickerDialog dialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(context,hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();
            }
        },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
        dialog.show();
    }
}
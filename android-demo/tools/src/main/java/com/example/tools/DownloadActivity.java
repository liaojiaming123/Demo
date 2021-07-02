package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arialyy.annotations.Download;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.task.DownloadTask;
import com.didi.drouter.annotation.Router;

@Router(path = "/download_activity")
public class DownloadActivity extends AppCompatActivity {
    private EditText download_url;
    private TextView start,stop,cancel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        download_url = (EditText)findViewById(R.id.download_url);
        start = (TextView)findViewById(R.id.download_start);
        stop = (TextView)findViewById(R.id.download_stop);
        cancel = (TextView)findViewById(R.id.download_cancel);
        Aria.download(this).register();
        progressBar = (ProgressBar)findViewById(R.id.download_progress_bar);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskId = simpleDownload();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleStop();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleCancel();
            }
        });
    }
    long taskId;
    private long simpleDownload(){
        return Aria.download(this)
                .load(download_url.getText().toString())
                .setFilePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/demo.m4a").create();
    }
    private void simpleStop(){
        if (Aria.download(this).load(taskId).isRunning()){
            Aria.download(this).load(taskId).stop();
        }else if (Aria.download(this).load(taskId).taskExists()){
            Aria.download(this).load(taskId).resume();
        }else {
            Aria.download(this).load(download_url.getText().toString()).create();
        }
    }
    private void simpleCancel(){
        Aria.download(this).load(taskId).cancel(true);
    }

    @Download.onTaskRunning
    protected void running(DownloadTask task){
        int p = task.getPercent();	//任务进度百分比
        String speed = task.getConvertSpeed();	//转换单位后的下载速度，单位转换需要在配置文件中打开
        long speed1 = task.getSpeed(); //原始byte长度速度
        if (task.getKey().equals(download_url.getText().toString())){
            progressBar.setProgress(p);
        }
    }
    @Download.onTaskComplete
    void taskComplete(DownloadTask task) {
        //在这里处理任务完成的状态
    }
}
package com.example.tools;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;

@Router(path = "/intent_activity")
public class IntentActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_intent);
        recyclerView = findViewById(R.id.rv_intent);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter{
        class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_intent_item);
            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_intent,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            if (position == 0){
                viewHolder.textView.setText("打开系统设置页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startMainSetting();
                    }
                });
            }else if (position == 1){
                viewHolder.textView.setText("打开应用列表页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startAppSetting();
                    }
                });
            }else if (position == 2){
                viewHolder.textView.setText("打开应用详情页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startDetailSetting();
                    }
                });
            }else if (position == 3){
                viewHolder.textView.setText("打开Wifi设置页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startWifiSetting();
                    }
                });
            }else if (position == 4){
                viewHolder.textView.setText("打开壁纸设置页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startWallPagerSetting();
                    }
                });
            }else if (position == 5){
                viewHolder.textView.setText("打开拨号页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startCall();
                    }
                });
            }else if (position == 6){
                viewHolder.textView.setText("打开联系人页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startContact();
                    }
                });
            }else if (position == 7){
                viewHolder.textView.setText("打开通话记录页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startPhone();
                    }
                });
            }else if (position == 8){
                viewHolder.textView.setText("打开发送短信页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startMms();
                    }
                });
            }else if (position == 9){
                viewHolder.textView.setText("打开开发者选项页面");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startDevSetting();
                    }
                });
            }else if (position == 10){
                viewHolder.textView.setText("打开应用商店");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startMarket();
                    }
                });
            }else if (position == 11){
                viewHolder.textView.setText("打开浏览器和网址");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startWeb();
                    }
                });
            }else if (position == 12){
                viewHolder.textView.setText("打开地图和位置");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startMap();
                    }
                });
            }else if (position == 13){
                viewHolder.textView.setText("打开邮件工具");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startEmail();
                    }
                });
            }else if (position == 14){
                viewHolder.textView.setText("打开音乐播放文件");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startMusic();
                    }
                });
            }else if (position == 15){
                viewHolder.textView.setText("打开视频播放文件");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startVideo();
                    }
                });
            }else if (position == 16){
                viewHolder.textView.setText("根据包名卸载程序");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uninstall();
                    }
                });
            }else if (position == 17){
                viewHolder.textView.setText("根据包名安装程序");
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        install();
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }

    private void startMainSetting(){
        startActivity(new Intent(Settings.ACTION_SETTINGS));
    }
    private void startAppSetting(){
        startActivity(new Intent(Settings.ACTION_APPLICATION_SETTINGS));
    }
    private void startDetailSetting(){
        startActivity(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).setData(Uri.fromParts("package", getPackageName(), null)));
    }
    private void startWifiSetting(){
        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }
    private void startWallPagerSetting(){
        startActivity(new Intent(Intent.ACTION_SET_WALLPAPER));
    }
    private void startCall(){
        startActivity(new Intent(Intent.ACTION_DIAL));
    }
    private void startContact(){
        startActivity(new Intent(Intent.ACTION_VIEW).setType("vnd.android.cursor.dir/contact"));
    }
    private void startPhone(){
        startActivity(new Intent(Intent.ACTION_VIEW).setType("vnd.android.cursor.dir/calls"));
    }
    private void startMms(){
        startActivity(new Intent(Intent.ACTION_VIEW).setType("vnd.android-dir/mms-sms").addCategory(Intent.CATEGORY_DEFAULT));
    }
    private void startDevSetting(){
        startActivity(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
    }
    private void startMarket(){
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("market://details?id=" + getPackageName())));
    }
    private void startWeb(){
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.baidu.com/")));
    }
    private void startMap(){
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("androidamap://poi?sourceApplication=softname" + "&keywords=" +"广州市"+ "&dev=0")));
    }
    private void startEmail(){
        startActivity(new Intent(Intent.ACTION_SEND,Uri.parse("mailto:123@qq.com")));
    }
    private void startMusic(){
//        startActivity(new Intent(Intent.ACTION_VIEW).setType("audio/mp3"));
        startActivity(new Intent(Intent.ACTION_VIEW).setDataAndType(Uri.parse("./*"),"audio/mp3"));
//        startActivity(new Intent(Intent.ACTION_VIEW).setComponent(new ComponentName("com.android.music","com.android.music.MusicBrowserActivity")));
    }
    private void startVideo(){
//        startActivity(new Intent(Intent.ACTION_VIEW).setType("video/mp4"));
        startActivity(new Intent(Intent.ACTION_VIEW).setDataAndType(Uri.parse("./*"),"video/mp4"));
//        startActivity(new Intent(Intent.ACTION_VIEW).setComponent(new ComponentName("com.android.video","com.android.video.VideoBrowserActivity")));

    }
    private void uninstall(){
        startActivity(new Intent(Intent.ACTION_DELETE).setData(Uri.fromParts("package","com.kugou.android",null)));
    }
    private void install(){
        startActivity(new Intent(Intent.ACTION_PACKAGE_ADDED).setData(Uri.fromParts("package","com.example.android",null)));
    }
}
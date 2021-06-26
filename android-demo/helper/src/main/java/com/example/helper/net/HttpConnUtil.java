package com.example.helper.net;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class HttpConnUtil {
    private Context context;
    public HttpConnUtil(Context context){
        this.context = context;
    }
    /**
     * get请求 返回字符串 同步请求 应放在子线程中
     * URLString请求的url connectTimeout连接超时 readTimeout响应超时
     * */
    public String getStringSync(String urlString,int connectTimeout,int readTimeout) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        if (connection.getResponseCode() == 200){
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length=inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,length);
            }
            outputStream.close();
            inputStream.close();
            connection.disconnect();
            Log.d(TAG, "getStringSync: "+outputStream.toString("utf-8"));
            return outputStream.toString("utf-8");
        } connection.disconnect();
        return null;
    }
    /**
     * get请求 返回字节数组 同步请求 应放在子线程中
     * URLString请求的url connectTimeout连接超时 readTimeout响应超时
     * */
    public byte[] getBytesSync(String urlString,int connectTimeout,int readTimeout) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        if (connection.getResponseCode() == 200){
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length=inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,length);
            }
            outputStream.close();
            inputStream.close();
            connection.disconnect();
            return outputStream.toByteArray();
        } connection.disconnect();
        return null;
    }
    /**
     * getStringSync方法的异步请求
     * */
    public String getStringAsync(final String urlString, final int connectTimeout, final int readTimeout){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getBytesSync(urlString,connectTimeout,readTimeout);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return null;
    }
    /**
     * get请求 返回字节数组 同步请求 应放在子线程中
     * URLString请求的url connectTimeout连接超时 readTimeout响应超时
     * */
    public InputStream getInputStreamSync(String urlString,int connectTimeout,int readTimeout) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        if (connection.getResponseCode() == 200){
            return connection.getInputStream();
        } connection.disconnect();
        return null;
    }
    /**
     * getBytesSync方法的异步请求
     * */
    public byte[] getBytesAsync(final String urlString, final int connectTimeout, final int readTimeout){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getBytesSync(urlString,connectTimeout,readTimeout);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return null;
    }
    /**
     * post请求 同步请求 返回字符串
     * urlString请求的url connectTimeout连接超时 readTimeout响应超时 post发送的数据
     * */
    public String postRequest(String urlString, int connectTimeout, int readTimeout, Map<String,Object> map) throws IOException {
        StringBuilder builder = new StringBuilder();
        // 组织请求参数
        for (String key : map.keySet()) {
            if(builder.length()!=0){
                builder.append("&");
            }
            builder.append(key).append("=").append(map.get(key));
        }
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("Content-Length", String.valueOf(builder.length()));
        // 设置运行输入 输出 禁止缓存
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
        // 发送请求参数
        printWriter.write(builder.toString());
        printWriter.flush();
        printWriter.close();
        if (connection.getResponseCode() == 200){
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,length);
            }
            outputStream.close();
            inputStream.close();
            connection.disconnect();
            return outputStream.toString("utf-8");
        } connection.disconnect();
        return null;
    }
    /**
     * 下载工具 同步请求 应放在子线程中
     * URLString请求的url connectTimeout连接超时 readTimeout响应超时 FILE_TYPE文件类型
     * */
    public void downloadSync(String urlString,int connectTimeout,int readTimeout,String FILE_TYPE) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        connection.setDoInput(true);
        connection.getContentLength();

        if (connection.getResponseCode() == 200){
            InputStream inputStream = connection.getInputStream();
            int size = inputStream.available();
            String filename = System.currentTimeMillis()+FILE_TYPE;
            File file = null;
            FileOutputStream outputStream = null;
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                file = new File(context.getExternalCacheDir()+"/"+filename);
            }
            if (file != null){
                outputStream = new FileOutputStream(file);
            } else return;
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length=inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,length);
            }
            outputStream.close();
            inputStream.close();
            connection.disconnect();
        } connection.disconnect();
    }
    /**
     * getBytesSync方法的异步请求
     * */
    public void downloadAsync(final String urlString, final int connectTimeout, final int readTimeout, final String FILE_TYPE){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    downloadSync(urlString,connectTimeout,readTimeout,FILE_TYPE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void downloadFile(final String path){
        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    URL url;
                    HttpURLConnection connection;
                    try {
                        url = new URL(path);
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setConnectTimeout(5000);
                        connection.setDoInput(true);
                        connection.setDoOutput(true);
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("Charset", "utf-8");
                        connection.connect();

                        String urlFilePath = connection.getURL().getFile();
                        String filename = urlFilePath.substring(urlFilePath.lastIndexOf(File.separatorChar) + 1);
                        File file = null;
                        FileOutputStream outputStream;
                        int responseCode = connection.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                                file = new File(context.getExternalCacheDir()+"/"+filename);
                            }
                            if (file != null){
                                outputStream = new FileOutputStream(file);
                            } else return;
                            InputStream inputStream = connection.getInputStream();
                            int contentLength = connection.getContentLength();
//                                mPb.setMax(contentLength);
                            BufferedInputStream bfi = new BufferedInputStream(inputStream);
                            int len;
                            int totle = 0;
                            byte[] bytes = new byte[1024];
                            while ((len = bfi.read(bytes)) != -1) {
                                totle += len;
//                                    mPb.setProgress(totle);
                                outputStream.write(bytes, 0, len);
                            }
                            outputStream.close();
                            inputStream.close();
                            bfi.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        ).start();
    }
}

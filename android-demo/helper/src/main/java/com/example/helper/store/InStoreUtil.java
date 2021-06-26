package com.example.helper.store;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InStoreUtil {
    private Context context;
    public InStoreUtil(Context context){
        this.context = context;
    }
    /**
     * 保存文件到内部存储
     * filename 文件名；content 文件内容
     * */
    public void saveFile(String filename,String content) throws IOException {
        FileOutputStream outputStream = context.openFileOutput(filename,Context.MODE_APPEND);
        outputStream.write(content.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    public void saveFile(String filename,byte[] content) throws IOException {
        FileOutputStream outputStream = context.openFileOutput(filename,Context.MODE_APPEND);
        outputStream.write(content);
        outputStream.flush();
        outputStream.close();
    }
    /**
     * 读取内部存储文件 filename文件名
     * */
    public String readFile(String filename) throws IOException {
        FileInputStream inputStream = context.openFileInput(filename);
        byte[] bytes = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        int length = 0;
        while ((length = inputStream.read(bytes)) != -1){
            stringBuilder.append(new String(bytes,0,length));
        }
        inputStream.close();
        return stringBuilder.toString();
    }
    /**
     * 读取文件 二进制
     * */
    public byte[] openFile(String filename) throws IOException {
        FileInputStream inputStream = context.openFileInput(filename);
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int length = 0;
        while ((length = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,length);
        }
        inputStream.close();
        outputStream.close();
        return outputStream.toByteArray();
    }

    /**
     * 删除文件 filename 文件名
     * */
    public void deleteFile(String filename){
        filename = context.getFilesDir().getPath()+"/"+filename;
        File file =new File(filename);
        if (file.exists()){
            file.delete();
        }
    }
    /**
     * 保存文件到缓存目录 字符串
     * */
    public void saveCache(String filename,String content) throws IOException {
        filename = context.getCacheDir().getPath()+"/"+filename;
        FileOutputStream outputStream = new FileOutputStream(filename);
        outputStream.write(content.getBytes());
        outputStream.flush();
        outputStream.close();
    }
    /**
     * 读取缓存文件 字符串
     * */
    public String getCacheString(String filename) throws IOException {
        filename = context.getCacheDir().getPath()+"/"+filename;
        FileInputStream inputStream = new FileInputStream(filename);
        byte[] bytes = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        int length = 0;
        while ((length = inputStream.read(bytes)) != -1){
            stringBuilder.append(new String(bytes,0,length));
        }
        inputStream.close();
        return stringBuilder.toString();
    }
    /**
     * 保存文件到缓存目录 二进制
     * */
    public void saveCache(String filename,byte[] content) throws IOException {
        filename = context.getCacheDir().getPath()+"/"+filename;
        FileOutputStream outputStream = new FileOutputStream(filename);
        outputStream.write(content);
        outputStream.flush();
        outputStream.close();
    }
    /**
     * 读取缓存文件 二进制
     * */
    public byte[] getCacheBytes(String filename) throws IOException {
        filename = context.getCacheDir().getPath()+"/"+filename;
        FileInputStream inputStream = new FileInputStream(filename);
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int length = 0;
        while ((length = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,length);
        }
        inputStream.close();
        outputStream.close();
        return outputStream.toByteArray();
    }
    /**
     * 保存文件到缓存目录 输入流
     * */
    public void saveCache(String filename, InputStream content) throws IOException {
        filename = context.getCacheDir().getPath()+"/"+filename;
        FileOutputStream outputStream = new FileOutputStream(filename);
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = content.read(bytes)) != -1){
            outputStream.write(bytes,0,length);
        }
        outputStream.flush();
        outputStream.close();
        content.close();
    }
    /**
     * 删除缓存文件 filename 文件名
     * */
    public void clearCache(String filename){
        filename = context.getCacheDir().getPath()+"/"+filename;
        File file =new File(filename);
        if (file.exists()){
            file.delete();
        }
    }
    /**
     * 删除全部缓存文件 filename 文件名
     * */
    public void clearCacheAll(){
        String filename = context.getCacheDir().getAbsolutePath();
        File file =new File(filename);
        if (file.exists()){
            file.delete();
        }
    }
    /**
     * 内部存储总空间
     * */
    public long getMemorySize(){
        File file = Environment.getDataDirectory();
        StatFs fs = new StatFs(file.getPath());
        return fs.getTotalBytes();
    }
    /**
     * 内部存储可用空间
     * */
    public long getMemoryASize(){
        File file = Environment.getDataDirectory();
        StatFs fs = new StatFs(file.getPath());
        return fs.getFreeBytes();
    }
}

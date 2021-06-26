package com.example.helper.store;

import android.content.Context;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExStoreUtil {
    private Context context;
    private Boolean hasSDCard = hasSDCard();
    public ExStoreUtil(Context context){this.context = context;}
    /**
     * 判断SD卡是否可用
     * */
    public static Boolean hasSDCard(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
    /**
     * 获取SD卡文件路径 filename 文件名
     * */
    public String getFilePath(String filename){
        if (hasSDCard) {
            File file = new File("");
            return context.getExternalFilesDir(Environment.getExternalStorageState(file)).getPath()+"/"+filename;
        } return null;
    }
    public String getPath(String path){
        if (hasSDCard) {
//            return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath();
            return path;
        } return null;
    }
    /**
     * 获取SD卡缓存路径
     * */
    public String getCacheDir(){
        if (hasSDCard) {
            return context.getExternalCacheDir().getPath();
        } return null;
    }
    /**
     * 保存文件到指定目录 filename文件名 content内容
     * */
    public void saveFile(String filename,String content) throws IOException {
        if (hasSDCard&&getPath(filename)!=null){
            FileOutputStream outputStream = new FileOutputStream(getPath(filename));
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
    /**
     * 读取指定文件 filename文件名
     * */
    public String readFile(String filename) throws IOException {
        if (hasSDCard&&getPath(filename)!=null){
            FileInputStream inputStream = new FileInputStream(getPath(filename));
            byte[] bytes = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int length = 0;
            while ((length = inputStream.read(bytes)) != -1){
                stringBuilder.append(new String(bytes,0,length));
            }
            inputStream.close();
            return stringBuilder.toString();
        } return null;
    }
    /**
     * 保存文件到指定目录 filename文件名 content内容
     * */
    public void saveFile(String filename,byte[] content) throws IOException {
        if (hasSDCard && getPath(filename) != null){
            FileOutputStream outputStream = new FileOutputStream(getPath(filename));
            outputStream.write(content);
            outputStream.flush();
            outputStream.close();
        }
    }
    public byte[] openFile(String filename) throws IOException {
        if (hasSDCard&&getPath(filename)!=null){
            FileInputStream inputStream = new FileInputStream(getPath(filename));
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int length = 0;
            while ((length = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,length);
            }
            inputStream.close();
            outputStream.close();
            return outputStream.toByteArray();
        } return null;
    }
    /**
     * 删除文件
     * */
    public void deleteFile(String filename){
        if (getPath(filename)!=null) {
            File file = new File(getPath(filename));
            if (file.exists()) {
                file.delete();
            }
        }
    }
    /**
     * 获取SD卡总空间
     * */
    public long getSDCardSize(){
        if (hasSDCard && getCacheDir() != null){
            File file = context.getExternalCacheDir();
            return file.getTotalSpace();
        }return -1;
    }
    /**
     * 获取SD卡可用空间
     * */
    public long getSDCardASize(){
        if (hasSDCard && getCacheDir() != null){
            File file = context.getExternalCacheDir();
            return file.getFreeSpace();
        }return -1;
    }
    /**
     * 保存文件到缓存目录 filename文件名 content内容
     * */
    public void saveCacheFile(String filename,String content) throws IOException {
        if (hasSDCard&&getCacheDir()!=null){
            FileOutputStream outputStream = new FileOutputStream(getCacheDir()+"/"+filename);
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
    /**
     * 读取缓存文件 filename文件名
     * */
    public String readCacheFile(String filename) throws IOException {
        if (hasSDCard&&getCacheDir()!=null){
            FileInputStream inputStream = new FileInputStream(getCacheDir()+"/"+filename);
            byte[] bytes = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int length = 0;
            while ((length = inputStream.read(bytes)) != -1){
                stringBuilder.append(new String(bytes,0,length));
            }
            inputStream.close();
            return stringBuilder.toString();
        } return null;
    }
    /**
     * 保存文件到缓存目录 filename文件名 content内容
     * */
    public void saveCacheFile(String filename,byte[] content) throws IOException {
        if (hasSDCard && getCacheDir() != null){
            FileOutputStream outputStream = new FileOutputStream(getCacheDir()+"/"+filename);
            outputStream.write(content);
            outputStream.flush();
            outputStream.close();
        }
    }
    /**
     * 读取缓存文件 filename文件名 返回字节数组
     * */
    public byte[] openCacheFile(String filename) throws IOException {
        if (hasSDCard&&getCacheDir()!=null){
            FileInputStream inputStream = new FileInputStream(getCacheDir()+"/"+filename);
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int length = 0;
            while ((length = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,length);
            }
            inputStream.close();
            outputStream.close();
            return outputStream.toByteArray();
        } return null;
    }
    /**
     * 删除缓存文件 filename 文件名
     * */
    public void clearCache(String filename){
        filename = getCacheDir()+"/"+filename;
        File file =new File(filename);
        if (file.exists()){
            file.delete();
        }
    }
    /**
     * 删除全部缓存文件
     * */
    public void clearCacheAll(){
        String filename = context.getExternalCacheDir().getAbsolutePath();
        File file =new File(filename);
        if (file.exists()){
            file.delete();
        }
    }
    /**
     * 保存文件到缓存目录 输入流
     * */
    public void saveCacheFile(String filename, InputStream content) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = content.read(bytes)) != -1) {
            stream.write(bytes, 0, length);
        }
        stream.toByteArray();
        stream.close();
        content.close();
        if (hasSDCard && getCacheDir() != null) {
            filename = getCacheDir() + "/" + filename;
            FileOutputStream outputStream = new FileOutputStream(filename);
            outputStream.flush();
            outputStream.close();
        }
    }
}

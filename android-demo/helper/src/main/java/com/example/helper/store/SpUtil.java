package com.example.helper.store;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.util.Set;

public class SpUtil {
    private Context context;

    private SpUtil(Context context, String filename, int mode){
        this.context = context;
        this.create(filename,mode);
    }
    private static SpUtil instance;
    /**
     * 单例模式
     * */
    public static SpUtil getInstance(Context context, String filename, int mode){
        if (instance == null) {
            instance = new SpUtil(context,filename,mode);
        } return instance;
    }


    private SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor = null;
    /**
     * 创建SharedPreference
     * filename文件名 mode访问模式
     * */
    private void create(String filename, int mode){
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(filename,mode);
            editor = sharedPreferences.edit();
        }
    }
    /**
     * 保存文件方法
     * key键值对的索引 content内容
     * */
    public void save(String key,String content){
        editor.putString(key,content);
        editor.apply();
    }
    /**
     * 读取文件方法
     * key键值对的索引 defValue默认内容
     * */
    public String getString(String key,String defValue){
        return sharedPreferences.getString(key,defValue);
    }
    /**
     * 保存整型
     * */
    public void save(String key,int content){
        editor.putInt(key,content);
        editor.apply();
    }
    public int getInt(String key,int defValue){
        return sharedPreferences.getInt(key,defValue);
    }
    /**
     * 保存浮点
     * */
    public void save(String key,float content){
        editor.putFloat(key,content);
        editor.apply();
    }
    public Float getFloat(String key,float defValue){
        return sharedPreferences.getFloat(key,defValue);
    }
    /**
     * 保存长整型
     * */
    public void save(String key,long content){
        editor.putLong(key,content);
        editor.apply();
    }
    public long getLong(String key,long defValue){
        return sharedPreferences.getLong(key,defValue);
    }
    /**
     * 保存字符串集合
     * */
    public void save(String key, Set<String> content){
        editor.putStringSet(key,content);
        editor.apply();
    }
    public Set getSetString(String key,Set<String> defValue){
        return sharedPreferences.getStringSet(key,defValue);
    }
    /**
     * 保存布尔类型
     * */
    public void save(String key,Boolean content){
        editor.putBoolean(key,content);
        editor.apply();
    }
    public Boolean getBoolean(String key, boolean defValue){
        return sharedPreferences.getBoolean(key,defValue);
    }

    /**
     * 删除内容方法
     * key要删除内容的键
     * */
    public void remove(String key){
        editor.remove(key);
        editor.clear();
        editor.apply();
    }
    /**
     * 删除文件 filename 文件名
     * */
    public void deleteFile(String filename){
        File file = new File(context.getFilesDir().getParent()+"/shared_prefs/"+filename);
        if (file.exists()){
            file.delete();
        }
    }
}

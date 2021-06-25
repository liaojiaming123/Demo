package com.example.helper.perm;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.common.BaseApplication;

import static android.Manifest.permission.CAMERA;

public class MyPermUtil {
    private volatile static MyPermUtil instance = null;
    private MyPermUtil(){

    }
    public static MyPermUtil getInstance(){
        if (instance == null){
            synchronized (MyPermUtil.class) {
                if (instance == null) {
                    instance = new MyPermUtil();
                }

            }
        }
        return instance;
    }

    /**
     * 请求权限方法
     * @param activity 引用的Activity对象
     * @param perm String类型的权限参数
     * */
    public static void reqPerm(Activity activity, String perm, int requestCode){
        if (BaseApplication.getContext().checkSelfPermission(perm)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(BaseApplication.getContext(),"已获得权限",Toast.LENGTH_SHORT).show();
        }else {
            activity.requestPermissions(new String[]{perm},requestCode);
        }
    }

//    public boolean onReqPermResult(Activity activity,int code){
//
//        activity.onRequestPermissionsResult(code,);
//    }

}

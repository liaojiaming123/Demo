package com.example.helper.perm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.helper.R;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

@Router(path = "/easy_permission_activity")
public class EasyPermissionActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_permission);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("权限申请测试");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        TextView tv_req_easy = (TextView)findViewById(R.id.tv_req_easy);
        tv_req_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reqPerm();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            EasyPermissionActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);

    }
    public void reqPerm(){
        String[] perms = {Manifest.permission.READ_PHONE_STATE};
        EasyPermissions.requestPermissions(
                new PermissionRequest.Builder(this,1, perms)
                        .setRationale("软件需要相关权限才能使用")
                        .setPositiveButtonText("确定")
                        .setNegativeButtonText("取消")
                        .setTheme(R.style.Permission_Theme_Dialog)
                        .build());
    }
    EasyPermissions.RationaleCallbacks rationaleCallbacks = new EasyPermissions.RationaleCallbacks() {
        @Override
        public void onRationaleAccepted(int requestCode) {

        }

        @Override
        public void onRationaleDenied(int requestCode) {

        }
    };

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        String s = perms.get(0);
        Toast.makeText(context,"已获得权限"+s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen, like showing a Toast.
            Toast.makeText(context,"重新申请权限", Toast.LENGTH_SHORT).show();
        }
    }
}
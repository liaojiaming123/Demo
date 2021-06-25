package com.example.helper.perm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.helper.R;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.runtime.Permission;

import java.util.List;

@Router(path = "/and_permission_activity")
public class AndPermissionActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_and_permission);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("权限申请测试");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        TextView tv_req_and = (TextView)findViewById(R.id.tv_req_and);
        tv_req_and.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndPermission.with(context)
                .runtime()
                .permission(Permission.ACCESS_FINE_LOCATION)
                .rationale(mRationale)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        Toast.makeText(context, "已获得权限", Toast.LENGTH_SHORT).show();
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        Toast.makeText(context, "未获得权限", Toast.LENGTH_SHORT).show();

                        if (AndPermission.hasAlwaysDeniedPermission(context, data)) {
                            // 这些权限被用户总是拒绝。
                            new AlertDialog.Builder(context)
                                    .setCancelable(false)
                                    .setTitle("提示")
                                    .setMessage("您已禁止弹出权限申请框，请在设置页同意")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            AndPermission.with(context)
                                                    .runtime()
                                                    .setting()
                                                    .start(10);
                                        }
                                    })
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(context, "已取消", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .show();
                        }
                    }
                })
                .start();
            }
        });
    }

    private Rationale mRationale = new Rationale() {
        @Override
        public void showRationale(Context context, Object data, final RequestExecutor executor) {
            List<String> permissionNames = Permission.transformText(context,data.toString());
            String message = "请授权该下的权限" + "\n" + permissionNames +"\n" + "不给权限你就看不到附近的小姐姐啦";

            new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle("提示")
                .setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        executor.execute();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        executor.cancel();
                    }
                })
                .show();
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            AndPermissionActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
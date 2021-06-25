package com.example.helper.perm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.helper.R;

@Router(path = "/perm_activity")
public class PermActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perm);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("权限申请测试");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        TextView tv_req_perm = (TextView) findViewById(R.id.tv_req_perm);
        tv_req_perm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyPermUtil.reqPerm(PermActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE,5);
                if (context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(context,"已获取权限",Toast.LENGTH_SHORT).show();
                }else {
                    PermActivity.this.requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},5);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            PermActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 5){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(context,"申请成功",Toast.LENGTH_SHORT).show();
            }else {Toast.makeText(context,"申请拒绝",Toast.LENGTH_SHORT).show();}
        }
    }
}
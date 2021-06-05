package com.example.my;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

//import com.sankuai.waimai.router.annotation.RouterUri;
import com.didi.drouter.annotation.Router;

@Router(path = "/my_activity")
//@RouterUri(path = "/my_activity")
public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }
}
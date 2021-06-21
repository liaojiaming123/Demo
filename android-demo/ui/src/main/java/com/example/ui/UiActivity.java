package com.example.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.didi.drouter.annotation.Router;
import com.didi.drouter.api.DRouter;
import com.example.ui.dialog.DialogActivity;

@Router(path = "/ui_activity")
public class UiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_activity);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Android UI");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        TextView wdg_tv = findViewById(R.id.wdg_tv);
        wdg_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/tv_activity").start();
            }
        });
        TextView wdg_ev = findViewById(R.id.wdg_ev);
        wdg_ev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/ev_activity").start();
            }
        });
        TextView wdg_iv = findViewById(R.id.wdg_iv);
        wdg_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/iv_activity").start();
            }
        });
        TextView wdg_btn = findViewById(R.id.wdg_btn);
        wdg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/btn_activity").start();
            }
        });
        TextView wdg_check = findViewById(R.id.wdg_check);
        wdg_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/check_activity").start();
            }
        });
        TextView wdg_switch = findViewById(R.id.wdg_switch);
        wdg_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/switch_activity").start();
            }
        });
        TextView wdg_date_picker = findViewById(R.id.wdg_date_picker);
        wdg_date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/date_picker_activity").start();
            }
        });
        TextView wdg_time_picker = findViewById(R.id.wdg_time_picker);
        wdg_time_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/time_picker_activity").start();
            }
        });
        TextView wdg_progress = findViewById(R.id.wdg_progress);
        wdg_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/progress_activity").start();
            }
        });
        TextView wdg_seek = findViewById(R.id.wdg_seek);
        wdg_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/seek_activity").start();
            }
        });
        TextView wdg_rating_bar = findViewById(R.id.wdg_rating_bar);
        wdg_rating_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/rating_bar_activity").start();
            }
        });
        TextView wdg_menu = findViewById(R.id.wdg_menu);
        wdg_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/menu_activity").start();
            }
        });
        TextView wdg_dialog = findViewById(R.id.wdg_dialog);
        wdg_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/dialog_activity").start();
            }
        });
        TextView wdg_view_pager = findViewById(R.id.wdg_view_pager);
        wdg_view_pager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/view_pager_activity").start();
            }
        });
        TextView wdg_view_flipper = findViewById(R.id.wdg_view_flipper);
        wdg_view_flipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/view_flipper_activity").start();
            }
        });
        TextView wdg_recycler_view = findViewById(R.id.wdg_recycler_view);
        wdg_recycler_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/recycler_view_activity").start();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            UiActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.ui.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

import java.util.ArrayList;
import java.util.List;

@Router(path = "/view_flipper_activity")
public class ViewFlipperActivity extends AppCompatActivity {
    private Context context;
    private TextView tvf1, tvf2, tvf3, tvf4;
    private TextView tvfBack,tvfNext;
    private List<TextView> tvfs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("ViewFlipper");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        final ViewFlipper viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper_simple);
        tvf1 = (TextView) findViewById(R.id.vf_tv1);
        tvf2 = (TextView) findViewById(R.id.vf_tv2);
        tvf3 = (TextView) findViewById(R.id.vf_tv3);
        tvf4 = (TextView) findViewById(R.id.vf_tv4);
        tvfBack = (TextView) findViewById(R.id.vf_tv_back);
        tvfNext = (TextView) findViewById(R.id.vf_tv_next);
        tvfs.add(tvf1);tvfs.add(tvf2);tvfs.add(tvf3);tvfs.add(tvf4);
        final View view1 = LayoutInflater.from(context).inflate(R.layout.viewflipper1,null);
        final View view2 = LayoutInflater.from(context).inflate(R.layout.viewflipper2,null);
        final View view3 = LayoutInflater.from(context).inflate(R.layout.viewflipper3,null);
        final View view4 = LayoutInflater.from(context).inflate(R.layout.viewflipper4,null);
//        views.add(view1);views.add(view2);views.add(view3);views.add(view4);
        ImageView vf1 = (ImageView)view1.findViewById(R.id.vf1);
        ImageView vf2 = (ImageView)view2.findViewById(R.id.vf2);
        ImageView vf3 = (ImageView)view3.findViewById(R.id.vf3);
        ImageView vf4 = (ImageView)view4.findViewById(R.id.vf4);
        vf1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf1));
        vf2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf2));
        vf3.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf3));
        vf4.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf4));
        vf1.setScaleType(ImageView.ScaleType.FIT_XY);
        vf2.setScaleType(ImageView.ScaleType.FIT_XY);
        vf3.setScaleType(ImageView.ScaleType.FIT_XY);
        vf4.setScaleType(ImageView.ScaleType.FIT_XY);
        viewFlipper.addView(view1);
        viewFlipper.addView(view2);
        viewFlipper.addView(view3);
        viewFlipper.addView(view4);
        viewFlipper.setInAnimation(context,R.anim.right_in);
        viewFlipper.setOutAnimation(context,R.anim.right_out);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        viewFlipper.startFlipping();

        tvf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(view1));
                Toast.makeText(context,"第一页",Toast.LENGTH_SHORT).show();
            }
        });
        tvf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(view2));
                Toast.makeText(context,"第二页",Toast.LENGTH_SHORT).show();
            }
        });
        tvf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(view3));
                Toast.makeText(context,"第三页",Toast.LENGTH_SHORT).show();
            }
        });
        tvf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(view4));
                Toast.makeText(context,"第四页",Toast.LENGTH_SHORT).show();
            }
        });
        tvfNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
                Toast.makeText(context,"后一页",Toast.LENGTH_SHORT).show();
            }
        });
        tvfBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
                Toast.makeText(context,"前一页",Toast.LENGTH_SHORT).show();
            }
        });
        viewFlipper.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    tvfs.get(viewFlipper.getDisplayedChild()).setTextColor(getResources().getColor(R.color.pink_200));
                }
            }
        });
        viewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                View currentView = viewFlipper.getCurrentView();
                if (currentView.isFocused()){
                    tvfs.get(viewFlipper.getDisplayedChild()).setTextColor(getResources().getColor(R.color.pink_200));
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            ViewFlipperActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.ui.list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

import java.util.ArrayList;
import java.util.List;

@Router(path = "/view_pager_activity")
public class ViewPagerActivity extends AppCompatActivity {
    private Context context;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<View> views = new ArrayList<>();
    private List<CharSequence> charSequences = new ArrayList<>();
    private TextView tvp1, tvp2, tvp3, tvp4;
    private ImageView ivp1, ivp2, ivp3, ivp4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("ViewPager");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_view_pager);
        View view1 = LayoutInflater.from(context).inflate(R.layout.viewflipper1,null);
        View view2 = LayoutInflater.from(context).inflate(R.layout.viewflipper2,null);
        View view3 = LayoutInflater.from(context).inflate(R.layout.viewflipper3,null);
        View view4 = LayoutInflater.from(context).inflate(R.layout.viewflipper4,null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        ivp1 = (ImageView)view1.findViewById(R.id.vf1);
        ivp2 = (ImageView)view2.findViewById(R.id.vf2);
        ivp3 = (ImageView)view3.findViewById(R.id.vf3);
        ivp4 = (ImageView)view4.findViewById(R.id.vf4);
        ivp1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf1));
        ivp2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf2));
        ivp3.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf3));
        ivp4.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf4));
        ivp1.setScaleType(ImageView.ScaleType.FIT_XY);
        ivp2.setScaleType(ImageView.ScaleType.FIT_XY);
        ivp3.setScaleType(ImageView.ScaleType.FIT_XY);
        ivp4.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvp1 = (TextView) findViewById(R.id.vp_tv1);
        tvp2 = (TextView) findViewById(R.id.vp_tv2);
        tvp3 = (TextView) findViewById(R.id.vp_tv3);
        tvp4 = (TextView) findViewById(R.id.vp_tv4);
        charSequences.add(tvp1.getText());
        charSequences.add(tvp2.getText());
        charSequences.add(tvp3.getText());
        charSequences.add(tvp4.getText());
        viewPagerAdapter = new ViewPagerAdapter(views, charSequences, context);
        viewPager = (ViewPager) findViewById(R.id.view_pager_simple);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        tvp1.setTextColor(getResources().getColor(R.color.yellow_400));
                        tvp2.setTextColor(getResources().getColor(R.color.green_900));
                        tvp3.setTextColor(getResources().getColor(R.color.green_900));
                        tvp4.setTextColor(getResources().getColor(R.color.green_900));
                        break;
                    case 1:
                        tvp2.setTextColor(getResources().getColor(R.color.yellow_400));
                        tvp1.setTextColor(getResources().getColor(R.color.green_900));
                        tvp3.setTextColor(getResources().getColor(R.color.green_900));
                        tvp4.setTextColor(getResources().getColor(R.color.green_900));
                        break;
                    case 2:
                        tvp3.setTextColor(getResources().getColor(R.color.yellow_400));
                        tvp2.setTextColor(getResources().getColor(R.color.green_900));
                        tvp1.setTextColor(getResources().getColor(R.color.green_900));
                        tvp4.setTextColor(getResources().getColor(R.color.green_900));
                        break;
                    case 3:
                        tvp4.setTextColor(getResources().getColor(R.color.yellow_400));
                        tvp2.setTextColor(getResources().getColor(R.color.green_900));
                        tvp3.setTextColor(getResources().getColor(R.color.green_900));
                        tvp1.setTextColor(getResources().getColor(R.color.green_900));
                        break;
                }
            }
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(context,charSequences.get(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tvp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0,true);
            }
        });
        tvp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1,true);
            }
        });
        tvp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2,true);
            }
        });
        tvp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3,true);
            }
        });
    }

    static class ViewPagerAdapter extends PagerAdapter {
        private List<View> views;
        private Context context;
        private List<CharSequence> charSequences;

        public ViewPagerAdapter(List<View> views,List<CharSequence> charSequences,Context context){
            this.views = views;
            this.charSequences = charSequences;
            this.context = context;
        }

        @Override
        public int getCount() {
            return views.size();
        }


        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
            container.removeView((View) object);

        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return super.getItemPosition(views);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            Toast.makeText(context,charSequences.get(position).toString(),Toast.LENGTH_SHORT).show();
            return charSequences.get(position);
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            ViewPagerActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
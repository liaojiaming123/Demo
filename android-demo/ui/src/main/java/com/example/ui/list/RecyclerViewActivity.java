package com.example.ui.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.didi.drouter.annotation.Router;
import com.example.ui.R;

import java.util.ArrayList;
import java.util.List;

@Router(path = "/recycler_view_activity")
public class RecyclerViewActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<String> strings = new ArrayList<>();
    private List<String> chars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("RecyclerView");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_simple);
        initChars();initData();
        createVertical();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.recycler_simple_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.recycler_simple_orientation) {
            Toast.makeText(context, "请选择布局", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.vertical) {
            createVertical();
        } else if (itemId == R.id.horizontal) {
            createHorizontal();
        } else if (itemId == R.id.grid) {
            createGrid();
        } else if (itemId == R.id.stagger) {
            createStagger();
        }else if (item.getItemId() == android.R.id.home){
            RecyclerViewActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void createVertical(){
        adapter = new RecyclerSimpleAdapter(context,strings);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }
    private void createHorizontal(){
        adapter = new RecyclerSimpleAdapter(context,chars);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void createGrid(){
        adapter = new RecyclerSimpleAdapter(context,strings);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setAdapter(adapter);
    }
    private void createStagger(){
        adapter = new RecyclerSimpleAdapter(context,strings);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    static class RecyclerSimpleAdapter extends RecyclerView.Adapter {
        private Context context;
        private List<String> strings;
        public RecyclerSimpleAdapter(Context context,List<String> strings){
            this.context = context;
            this.strings = strings;
        }
        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            CardView cardView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cardView = (CardView)itemView.findViewById(R.id.cardview_recycler_simple);
                textView = (TextView)itemView.findViewById(R.id.tv_item_recycler_simple);
            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycle_simple, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textView.setText(strings.get(position));
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,strings.get(position),Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"当前列表项为："+position,Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }
    }

    private void initData(){
        strings.add("待我荣华富贵，许你十里桃花。");
        strings.add("待我名满华夏，许你当歌纵马。");
        strings.add("待我高头大马，许你嫁衣红霞。");
        strings.add("待我功成名达，许你花前月下。");
        strings.add("待我半生戎马，许你共话桑麻。");
        strings.add("待我君临天下，许你四海为家。");
        strings.add("待我了无牵挂，许你浪迹天涯。");
        strings.add("晓看天色暮看云，行也思君，坐也思君。");
        strings.add("春赏百花冬观雪，醒亦念卿，梦亦念卿。");
        strings.add("I like you, but I just like you!");
        strings.add("纵然万劫不复，纵然相思入骨，我也待你，眉眼如初，岁月如故！");
        strings.add("吾闻此间山水奇，钟灵毓秀似仙居。意气风发神往矣，君愿伴余共赴之。");
        strings.add("我倚窗前思红颜，喜雨漫洒串珠帘。欢舞翩翩飘倩影，你笑嫣然似花仙。");
        strings.add("嫁与春风不用媒，我倚窗前思故人。可知明月伴我心，好山长在水长流。");
        strings.add("你欲情丝断红颜，想入莺飞可奈何。得意皓月怎当空，美忆情兮醉今生。");
        strings.add("I love three things in the world, sun moon and you, sun for morning, moon for night, and you forever!");
        strings.add("浮世三千，吾爱有三：日月与卿，日为朝，月为暮，卿为朝朝暮暮。");
        strings.add("何为江湖？剑未佩妥，出门已是江湖，酒尙余温，入口不识乾坤。");
        strings.add("何为英雄？愿你长枪穿云，一人可破山河。");
        strings.add("何为孤独？人生天地间，忽如远行客。");
        strings.add("为何无人懂我？苍天不懂人间暖，冷眼看花尽是悲。");
        strings.add("余晖晚霞，生如夏花！我曾纵马向天涯，");
        strings.add("只影如枫叶飘零，要落谁家？你如酒，醉我年华！");
        strings.add("嫁衣锦绣，龙吟凤啸。给你八荒四海，");
        strings.add("我沙场，逞英豪。可愿随我，征战天下，好人相伴，风尘笑傲。");
    }
    private void initChars(){
        chars.add("推荐");chars.add("喜欢");chars.add("短视屏");chars.add("音乐");
        chars.add("直播");chars.add("游戏");chars.add("电影");chars.add("电视剧");
    }
}
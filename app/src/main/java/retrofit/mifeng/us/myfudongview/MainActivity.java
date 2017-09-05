package retrofit.mifeng.us.myfudongview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyScrollView.OnScrollViewListener, OnRefreshListener, OnLoadMoreListener {

    private static final String TAG = "e";
    private LinearLayout jing;
    private TextView tv;
    private MyScrollView sv;
    private SwipeToLoadLayout swipeToLoadLayout;
    ArrayList<String> list = new ArrayList<>();
    MyList lv;
    private ProgressBar dibu;
    int ixii=0;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==999){
                ixii=0;
                //得到自定义ScrollView onScrollChanged方法发过来的底部Y，减去底部ProgressBar的高度
                int i= (int) msg.obj;
                int height = dibu.getHeight();
                int i1 = i - height;
                sv.smoothScrollTo(0, i1);
                list.add("bbbb");
                myListAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "加载更多", Toast.LENGTH_SHORT).show();

            }
        }
    };
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            list.add("aaaaaaa" + i);
        }
        initView();
    }

    private void initView() {
        dibu = (ProgressBar) findViewById(R.id.dibu);
        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
        //下拉刷新的滑动事件
        swipeToLoadLayout.setOnRefreshListener(this);
        //上来加载的滑动事件
        swipeToLoadLayout.setOnLoadMoreListener(this);
        lv = (MyList) findViewById(R.id.lv);
        myListAdapter = new MyListAdapter(this, list);
        lv.setAdapter(myListAdapter);

        jing = (LinearLayout) findViewById(R.id.jing);
        tv = (TextView) findViewById(R.id.tv);
        sv = (MyScrollView) findViewById(R.id.swipe_target);
        sv.smoothScrollTo(0, 0);
        sv.setOnScrollViewListener(this);
        findViewById(R.id.layout).getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        // TODO 自动生成的方法存根
                        onScrollY(sv.getHeight());
                    }
                });
    }

    @Override
    public void onScrollY(int scrollY) {
        // TODO 自动生成的方法存根
        int max = Math.max(scrollY, tv.getHeight());
        jing.layout(0, max, jing.getWidth(), max + jing.getHeight());
    }

    @Override
    public void onScrollY2(int i) {
        if (ixii==0){
            ixii=1;
            Message message = new Message();
            message.what=999;
            message.obj=i;
            handler.sendMessageDelayed(message,2000);
        }

    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                //设置是否下拉刷新中
                swipeToLoadLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "bbbb", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                //设置是否上拉加载中
                swipeToLoadLayout.setLoadingMore(false);
                Toast.makeText(MainActivity.this, "aaaa", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }

}

package retrofit.mifeng.us.myfudongview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyScrollView.OnScrollViewListener {

    private LinearLayout jing;
    private LinearLayout dong;
    /*private int biaoji=999;
    int[] locationdong=new int[2];
    int[] locationjing=new int[2];
    //handler接受消息后得到Location设置显示隐藏
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==biaoji){
                dong.getLocationOnScreen(locationdong);
                jing.getLocationOnScreen(locationjing);
                if (locationdong[1]>locationjing[1]){
                    jing.setVisibility(View.GONE);
                    dong.setVisibility(View.VISIBLE);
                }else {
                    jing.setVisibility(View.VISIBLE);
                    dong.setVisibility(View.GONE);
                }
            }
        }
    };*/
    private TextView tv;
    private MyScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        jing = (LinearLayout) findViewById(R.id.jing);
        dong = (LinearLayout) findViewById(R.id.dong);
        tv = (TextView) findViewById(R.id.tv);
        sv = (MyScrollView) findViewById(R.id.scrollView);
        /*
        //ScrollView的点击监听事件
        sv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
            //滑动时往handler发送消息
                if (event.getAction()==MotionEvent.ACTION_MOVE){
                    handler.sendEmptyMessage(biaoji);
                }else if (event.getAction()==MotionEvent.ACTION_UP){//手指抬起时往handler发送消息
                    handler.sendEmptyMessageAtTime(biaoji,5);
                }
                return false;
            }
        });*/
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
        jing.layout(0, max, jing.getWidth(),max+jing.getHeight());
    }
}

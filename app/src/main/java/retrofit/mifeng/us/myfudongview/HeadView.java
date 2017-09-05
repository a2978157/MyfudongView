package retrofit.mifeng.us.myfudongview;

import android.content.Context;
import android.util.AttributeSet;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

/**
 * Created by 21903 on 2017/9/4.
 */

public class HeadView extends android.support.v7.widget.AppCompatTextView implements SwipeRefreshTrigger, SwipeTrigger {
    public HeadView(Context context) {
        super(context);
    }

    public HeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onRefresh() {
        setText("正在拼命加载数据...");
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onSwipe(int i, boolean b) {
        setText("释放刷新");

    }

    @Override
    public void onRelease() {


    }

    @Override
    public void complete() {
        setText("刷新成功");
    }

    @Override
    public void onReset() {

    }
}

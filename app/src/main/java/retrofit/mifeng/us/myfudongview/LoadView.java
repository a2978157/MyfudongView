package retrofit.mifeng.us.myfudongview;

import android.content.Context;
import android.util.AttributeSet;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

/**
 * Created by 21903 on 2017/9/4.
 */

public class LoadView extends android.support.v7.widget.AppCompatTextView implements SwipeLoadMoreTrigger,SwipeTrigger {
    public LoadView(Context context) {
        super(context);
    }

    public LoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onLoadMore() {
        setText("正在拼命加载数据...");
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onSwipe(int i, boolean b) {

    }

    @Override
    public void onRelease() {

        setText("刷新成功");
    }

    @Override
    public void complete() {
        setText("释放刷新");

    }

    @Override
    public void onReset() {

    }
}

package retrofit.mifeng.us.myfudongview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
    private static final String TAG = "e";
    private OnScrollViewListener onScrollChangedListener;

    public MyScrollView(Context context) {
        super(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, -1);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //写一个方法，用来初始化接口对象
    public void setOnScrollViewListener(OnScrollViewListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dibu);
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollY(t);
            //得到底部布局的高度，动态减去滑动的距离，滑到最底部布局的位置加载
            View view = (View) getChildAt(getChildCount() - 1);
            int d = view.getBottom();
            d -= (getHeight() + getScrollY());//getHeight()屏幕的高度加上滑动的距离就是最终的高度
            Log.e(TAG, "onScrollChanged: "+d);
            if (d-dimensionPixelOffset <=0) {
                //you are at the end of the list in scrollview
                //do what you wanna do here
                onScrollChangedListener.onScrollY2(getScrollY());
            } else {
                super.onScrollChanged(l, t, oldl, oldt);
            }
        }
    }

    //写一个接口，实现滑动悬停控件的高度
    public interface OnScrollViewListener {
        //scrollY指停止位置控件的高度
        public void onScrollY(int scrollY);
        public void onScrollY2(int i);
    }


}

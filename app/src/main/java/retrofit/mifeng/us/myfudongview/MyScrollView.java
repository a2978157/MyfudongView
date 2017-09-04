package retrofit.mifeng.us.myfudongview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView{
	private OnScrollViewListener onScrollChangedListener;
	public MyScrollView(Context context) {
		super(context,null);
	}
	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs,-1);
	}
	public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	//写一个方法，用来初始化接口对象
	public void setOnScrollViewListener(OnScrollViewListener onScrollChangedListener){
		this.onScrollChangedListener=onScrollChangedListener;
	}
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (onScrollChangedListener!=null) {
			onScrollChangedListener.onScrollY(t);
		}
	}
	//写一个接口，实现滑动悬停控件的高度
	public interface OnScrollViewListener{
		//scrollY指停止位置控件的高度
		public void onScrollY(int scrollY);
	}
	
	

}

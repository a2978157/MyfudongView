package retrofit.mifeng.us.myfudongview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 21903 on 2017/4/21.
 */

public class MyList extends ListView {
    public MyList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public MyList(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //右移2位空出前两位的测量单位，得到最总的最大值
        int i = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, i);
    }
}

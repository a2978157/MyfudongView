package retrofit.mifeng.us.myfudongview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 21903 on 2017/4/21.
 */

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> list=new ArrayList<>();
    public MyListAdapter(Context context, ArrayList<String> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHerdle viewHerdle=null;
        if (view==null){
            view= View.inflate(context, R.layout.list_item,null);
            viewHerdle =  new ViewHerdle();
            viewHerdle.tv= (TextView) view.findViewById(R.id.tv);
            view.setTag(viewHerdle);
        }else {
            viewHerdle= (ViewHerdle) view.getTag();
        }
        viewHerdle.tv.setText(list.get(i));
        return view;
    }
    class ViewHerdle{
        TextView tv;
    }

}

package io.bookit.bookit.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.bookit.R;

/**
 * Created by rishabh on 8/6/15.
 */

public class DemoPageAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<Integer> items;
    private Context context;

    public DemoPageAdapter(ArrayList<Integer> listOfItems,Context context) {
        this.items = listOfItems;
        this.context = context ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_demopageritems, container,false);

        TextView tView = (TextView)view.findViewById(R.id.PageNumber);

        tView.setText(items.get(position).toString());

        ((ViewPager) container).addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View)obj);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        ((ViewPager) container).removeView(view);
    }
}
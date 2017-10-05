package pl.tomasz.intents.prezentacje.pv;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 30.09.2017.
 */

public class MyPagerAdapter2 extends PagerAdapter {

    private Context context;
    private List<Integer> data;
    LayoutInflater mLayoutInflater;

    public MyPagerAdapter2(Context context, List<Integer> data){
        this.context = context;
        this.data = data;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mLayoutInflater.inflate(R.layout.item_pager, container, false);

        ImageView image;
        image = (ImageView) view.findViewById(R.id.pager_image);
        image.setImageDrawable(context.getResources().getDrawable(data.get(position)));

        container.addView(view);

        return view;
    }
}

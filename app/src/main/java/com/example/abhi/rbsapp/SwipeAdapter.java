package com.example.abhi.rbsapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Abhi on 28-02-2017.
 */

public class SwipeAdapter extends PagerAdapter {
    public int[] img_res={R.drawable.rbsh,R.drawable.faculty,R.drawable.courses,R.drawable.newimg};
    private Context ctx;
    private LayoutInflater layoutinflater;
    public SwipeAdapter(Context ctx){
        this.ctx=ctx;
    }
    @Override
    public int getCount() {
        return img_res.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        layoutinflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutinflater.inflate(R.layout.slider_home,vg, false);
        ImageView imageview= (ImageView) item_view.findViewById(R.id.img1);
        imageview.setBackgroundResource(img_res[position]);
        imageview.setScaleType(ImageView.ScaleType.FIT_XY);

        vg.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}

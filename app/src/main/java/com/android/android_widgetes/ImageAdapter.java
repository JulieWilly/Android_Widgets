package com.android.android_widgetes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class ImageAdapter extends PagerAdapter {

    Context context;

    ImageAdapter(Context context) {
        this.context = context;
    }

    private int[] sliderImageId = new int[]{R.drawable.image2,R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8};

    public Object instantiatedItem(ViewGroup container, int position) {
        ImageView imgView = new ImageView(context);
        imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgView.setImageResource(sliderImageId[position]);
        ((ViewPager2) container).addView(imgView, 0);
        return imgView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager2)container).removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return sliderImageId.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView) object);
    }
}

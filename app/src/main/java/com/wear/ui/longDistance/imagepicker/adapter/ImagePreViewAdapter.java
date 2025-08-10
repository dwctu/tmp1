package com.wear.ui.longDistance.imagepicker.adapter;

import android.content.ContentUris;
import android.content.Context;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.longDistance.imagepicker.view.PinchImageView;
import dc.f93;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class ImagePreViewAdapter extends PagerAdapter {
    public LinkedList<PinchImageView> a = new LinkedList<>();
    public Context b;
    public List<MediaFile> c;

    public ImagePreViewAdapter(Context context, List<MediaFile> list) {
        this.b = context;
        this.c = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        PinchImageView pinchImageView = (PinchImageView) obj;
        viewGroup.removeView(pinchImageView);
        this.a.add(pinchImageView);
    }

    @Override // androidx.viewpager.widget.PagerAdapter, com.githang.viewpagerindicator.IconPagerAdapter
    public int getCount() {
        List<MediaFile> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        PinchImageView pinchImageView;
        if (this.a.size() > 0) {
            pinchImageView = this.a.remove();
            pinchImageView.t();
        } else {
            pinchImageView = new PinchImageView(this.b);
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                f93.b().a().O(pinchImageView, this.c.get(i).b() > 0 ? ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.c.get(i).e()) : ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.c.get(i).e()));
            } else {
                f93.b().a().I(pinchImageView, this.c.get(i).f());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewGroup.addView(pinchImageView);
        return pinchImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}

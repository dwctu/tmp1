package com.wear.adapter.longdistance;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lovense.wear.R;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.main.longDistance.EmojisManagerActivity;
import com.wear.util.WearUtils;
import dc.he3;
import dc.ie3;
import dc.pj3;
import dc.pl1;
import dc.sg3;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class EmojisFavoritePagerAdapter extends PagerAdapter {
    public Activity a;
    public ie3 b;
    public ie3.m c;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (view.getTag(R.id.imageview_favorite_image) == null || view.getTag(R.id.relativelayout_favorite_image) == null) {
                return;
            }
            String string = view.getTag(R.id.imageview_favorite_image).toString();
            String string2 = view.getTag(R.id.relativelayout_favorite_image).toString();
            if (WearUtils.e1(string)) {
                return;
            }
            if (string.equals(he3.a)) {
                if (WearUtils.E.size() >= 81) {
                    sg3.i(EmojisFavoritePagerAdapter.this.a, R.string.add_favorite_faile_maxcount);
                    return;
                } else {
                    pj3.o(EmojisFavoritePagerAdapter.this.a, EmojisManagerActivity.class, 545);
                    return;
                }
            }
            if (WearUtils.e1(string2)) {
                return;
            }
            EmojisFavoritePagerAdapter.this.c.o2(new File(WearUtils.Y(), WearUtils.r0(string)), "emoji", string2, string);
        }
    }

    public final List<FavoriteEmojisBean> b(int i) {
        ArrayList arrayList = new ArrayList();
        if (getCount() > 0) {
            List<FavoriteEmojisBean> listG = he3.g();
            int size = listG.size();
            int i2 = i * 15;
            int i3 = i2 + 15 > size ? size - i2 : 15;
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(listG.get(i2 + i4));
            }
            if (arrayList.size() < 15) {
                for (int size2 = arrayList.size(); size2 < 15; size2++) {
                    arrayList.add(new FavoriteEmojisBean());
                }
            }
        }
        return arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter, com.githang.viewpagerindicator.IconPagerAdapter
    public int getCount() {
        if (WearUtils.E == null) {
            return 1;
        }
        int size = he3.g().size();
        return (size / 15) + (size % 15 == 0 ? 0 : 1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View viewInflate = this.a.getLayoutInflater().inflate(R.layout.item_viewpage_emojis, (ViewGroup) null);
        GridView gridView = (GridView) viewInflate.findViewById(R.id.expression_gridview);
        gridView.setNumColumns(5);
        pl1 pl1Var = new pl1(this.a, this.c, this.b);
        pl1Var.e(b(i));
        gridView.setAdapter((ListAdapter) pl1Var);
        this.b.N(gridView);
        gridView.setOnItemClickListener(new a());
        ((ViewPager) viewGroup).addView(viewInflate, 0);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}

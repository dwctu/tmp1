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
import dc.ie3;
import dc.ql1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class EmojisPagerAdapter extends PagerAdapter {
    public Activity a;
    public ie3 b;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (view.getTag(R.id.imageview_smiley_image) != null) {
                EmojisPagerAdapter.this.b.x(view.getTag(R.id.imageview_smiley_image).toString());
            }
        }
    }

    public final List<String> a(int i) {
        ArrayList arrayList = new ArrayList();
        if (getCount() > 0) {
            int size = this.b.b.size();
            int i2 = i * 34;
            int i3 = i2 + 34 > size ? size - i2 : 34;
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(this.b.b.get(i2 + i4));
            }
            if (arrayList.size() == 34) {
                arrayList.add(this.b.a);
            } else if (arrayList.size() < 34) {
                for (int size2 = arrayList.size(); size2 <= 34; size2++) {
                    if (size2 == 34) {
                        arrayList.add(this.b.a);
                    } else {
                        arrayList.add("");
                    }
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
        ie3 ie3Var;
        if (this.a == null || (ie3Var = this.b) == null) {
            return 0;
        }
        int size = ie3Var.b.size();
        return (size / 34) + (size % 34 != 0 ? 1 : 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View viewInflate = this.a.getLayoutInflater().inflate(R.layout.item_viewpage_emojis, (ViewGroup) null);
        GridView gridView = (GridView) viewInflate.findViewById(R.id.expression_gridview);
        gridView.setNumColumns(7);
        ql1 ql1Var = new ql1(this.a, this.b);
        ql1Var.d(a(i));
        gridView.setAdapter((ListAdapter) ql1Var);
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

package com.wear.widget.llong;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lovense.wear.R;
import dc.ah4;
import dc.ce3;
import dc.kf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes4.dex */
public class DSGuideViewpager extends RelativeLayout implements ViewPager.OnPageChangeListener {
    public Context a;
    public ViewPager b;
    public LinearLayout c;
    public TextView d;
    public List<Integer> e;
    public List<View> f;
    public c g;
    public int h;
    public b i;

    public class a implements View.OnClickListener {
        public final /* synthetic */ Integer a;

        public a(Integer num) {
            this.a = num;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "onClick img: " + this.a;
            if (DSGuideViewpager.this.i != null) {
                DSGuideViewpager.this.i.a(this.a);
            }
        }
    }

    public interface b {
        void a(Integer num);
    }

    public class c extends PagerAdapter {
        public List<View> a;

        public c(DSGuideViewpager dSGuideViewpager, List<View> list) {
            this.a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i < getCount()) {
                viewGroup.removeView(this.a.get(i));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter, com.githang.viewpagerindicator.IconPagerAdapter
        public int getCount() {
            List<View> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.a.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public DSGuideViewpager(Context context) {
        super(context);
    }

    private void setCur(int i) {
        if (i < 0 || i > 2 || this.h == i) {
            return;
        }
        this.c.getChildAt(i).setEnabled(true);
        this.c.getChildAt(this.h).setEnabled(false);
        this.h = i;
        if (i == 0) {
            this.d.setText(ah4.e(R.string.ds_release_notice_pic_title1));
        } else if (i == 1) {
            this.d.setText(ah4.e(R.string.ds_release_notice_pic_title2));
        } else {
            this.d.setText(ah4.e(R.string.ds_release_notice_pic_title3));
        }
    }

    public final void b() {
        this.c.removeAllViews();
        for (int i = 0; i < this.e.size(); i++) {
            GifImageView gifImageView = new GifImageView(this.a);
            gifImageView.setBackgroundResource(R.drawable.dot_selector_gray);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(16, 16);
            layoutParams.rightMargin = 16;
            gifImageView.setLayoutParams(layoutParams);
            gifImageView.setEnabled(false);
            this.c.addView(gifImageView);
        }
        this.h = 0;
        if (this.c.getChildCount() > 0) {
            this.c.getChildAt(this.h).setEnabled(true);
        }
    }

    public final void c() {
        List<View> list = this.f;
        if (list == null) {
            this.f = new ArrayList();
        } else {
            list.clear();
        }
        for (Integer num : this.e) {
            GifImageView gifImageView = new GifImageView(this.a);
            gifImageView.setLayoutParams(new ViewGroup.LayoutParams(-2, ce3.a(this.a, 330.0f)));
            kf.w(this.a).t(num).A0(gifImageView);
            gifImageView.setOnClickListener(new a(num));
            this.f.add(gifImageView);
        }
    }

    public final void d() {
        LayoutInflater.from(this.a).inflate(R.layout.dsguide_viewpager, this);
        this.d = (TextView) findViewById(R.id.dsguide_viewpager_title);
        this.b = (ViewPager) findViewById(R.id.dsguide_viewpager_views);
        this.c = (LinearLayout) findViewById(R.id.dsguide_viewpager_dots);
        this.e = new ArrayList();
        c();
        b();
        c cVar = new c(this, this.f);
        this.g = cVar;
        this.b.setAdapter(cVar);
        this.b.addOnPageChangeListener(this);
    }

    public void e(boolean z) {
        if (z) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }

    public int getCurrentIndex() {
        return this.h;
    }

    public List<String> getListImgUri() {
        this.a.getResources();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next()));
        }
        return arrayList;
    }

    public List<Integer> getListImgs() {
        return this.e;
    }

    public Integer getViewId() {
        return this.e.get(this.h);
    }

    public List<GifImageView> getViews() {
        ArrayList arrayList = new ArrayList();
        Iterator<View> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add((GifImageView) it.next());
        }
        return arrayList;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        setCur(i);
    }

    public void setListImgs(List<Integer> list) {
        this.e.clear();
        this.e.addAll(list);
        c();
        b();
        c cVar = new c(this, this.f);
        this.g = cVar;
        this.b.setAdapter(cVar);
        this.g.notifyDataSetChanged();
    }

    public void setiPageClickListener(b bVar) {
        this.i = bVar;
    }

    public DSGuideViewpager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        d();
    }
}

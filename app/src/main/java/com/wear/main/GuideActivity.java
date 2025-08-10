package com.wear.main;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.exoplayer2.ExoPlayer;
import com.lovense.wear.R;
import com.wear.dao.DaoUtils;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.eg3;
import dc.pj3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    public ViewPager a;
    public d b;
    public int[] c = {R.drawable.splashscreen};
    public List<View> d;
    public ImageView e;
    public View f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.f.setEnabled(false);
            GuideActivity.this.t4();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GuideActivity.this.a.setEnabled(true);
            GuideActivity.this.f.setVisibility(0);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GuideActivity.this.f.setVisibility(8);
            GuideActivity.this.t4();
        }
    }

    public class d extends PagerAdapter {
        public List<View> a;

        public class a implements View.OnClickListener {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.setEnabled(false);
                GuideActivity.this.t4();
            }
        }

        public d(List<View> list, Activity activity) {
            this.a = list;
        }

        public final void a(View view) {
            view.setOnClickListener(new a(view));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.a.get(i));
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
            viewGroup.addView(this.a.get(i), 0);
            if (i == this.a.size() - 1) {
                a(viewGroup.findViewById(R.id.iv_start));
            }
            return this.a.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.system_guide);
        u4();
        DaoUtils.getHotPoingDao().cleanRecords();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f.setVisibility(i == this.c.length + (-1) ? 8 : 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MyApplication.N().q0(this);
    }

    public final void t4() {
        eg3.i(this, "show_guide_start_key", WearUtils.q);
        pj3.f(this, MainActivity.class);
        finish();
    }

    public final void u4() {
        this.d = new ArrayList();
        this.e = (ImageView) findViewById(R.id.guide_flash);
        View viewFindViewById = findViewById(R.id.iv_skin);
        this.f = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        int[] iArr = this.c;
        if (iArr.length <= 1) {
            if (iArr.length == 1) {
                this.e.setVisibility(0);
                this.e.setImageResource(this.c[0]);
                new Handler().postDelayed(new c(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            }
            return;
        }
        for (int i = 0; i < this.c.length; i++) {
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.system_guide_one, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.guide_image);
            View viewFindViewById2 = viewInflate.findViewById(R.id.iv_start);
            imageView.setImageResource(this.c[i]);
            int[] iArr2 = this.c;
            if (i != iArr2.length - 1 || iArr2.length == 1) {
                viewFindViewById2.setVisibility(4);
            } else {
                viewFindViewById2.setVisibility(0);
            }
            this.d.add(viewInflate);
        }
        this.b = new d(this.d, this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        this.a = viewPager;
        viewPager.setAdapter(this.b);
        this.a.addOnPageChangeListener(this);
        this.a.setEnabled(false);
        new Handler().postDelayed(new b(), 1500L);
    }
}

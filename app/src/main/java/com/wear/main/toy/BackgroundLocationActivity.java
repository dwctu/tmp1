package com.wear.main.toy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.phonertc.RequestPermissionActivity;
import dc.pp1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BackgroundLocationActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    public c a;
    public List<View> b;
    public int[] c = {R.drawable.screenshot_1, R.drawable.screenshot_2, R.drawable.screenshot_3};
    public ImageView[] d;

    @BindView(R.id.dot_layout)
    public LinearLayout dotLayout;
    public int e;

    @BindView(R.id.iv_close)
    public ImageView ivClose;

    @BindView(R.id.to_setting)
    public TextView toSetting;

    @BindView(R.id.viewpager)
    public ViewPager viewpager;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RequestPermissionActivity.s4(BackgroundLocationActivity.this);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("locationResult", 0);
            BackgroundLocationActivity.this.setResult(-1, intent);
            BackgroundLocationActivity.this.finish();
        }
    }

    public class c extends PagerAdapter {
        public List<View> a;

        public c(BackgroundLocationActivity backgroundLocationActivity, List<View> list) {
            this.a = list;
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
            View view = this.a.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_setting);
        ButterKnife.bind(this);
        s4();
        pp1.b = false;
        this.toSetting.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.b = new ArrayList();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(this.c[i]);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b.add(imageView);
        }
        c cVar = new c(this, this.b);
        this.a = cVar;
        this.viewpager.setAdapter(cVar);
        this.viewpager.addOnPageChangeListener(this);
        this.ivClose.setOnClickListener(new b());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        t4(i);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void s4() {
        this.d = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(R.drawable.dot_selector_gray);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(16, 16);
            layoutParams.rightMargin = 16;
            imageView.setLayoutParams(layoutParams);
            imageView.setEnabled(false);
            this.d[i] = imageView;
            this.dotLayout.addView(imageView);
        }
        this.e = 0;
        this.d[0].setEnabled(true);
    }

    public final void t4(int i) {
        if (i < 0 || i > 2 || this.e == i) {
            return;
        }
        System.out.println("positon=" + i);
        this.d[i].setEnabled(true);
        System.out.println("currentIndex=" + this.e);
        this.d[this.e].setEnabled(false);
        this.e = i;
    }
}

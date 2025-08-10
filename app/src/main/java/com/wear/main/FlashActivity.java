package com.wear.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.activity.orgySetting.OrgyActivityBean;
import com.wear.activity.orgySetting.OrgyEventTrackUtil;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.activity.orgySetting.OrgyWebViewActivity;
import com.wear.bean.EntryPoint;
import com.wear.bean.OpenAppBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ay;
import dc.eg3;
import dc.nd3;
import dc.of3;
import dc.pe3;
import dc.pj3;
import dc.qv1;
import dc.ti1;
import dc.we3;
import dc.ye3;
import dc.zx;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.i18n.MessageBundle;

/* loaded from: classes3.dex */
public class FlashActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.constraint_layout)
    public ConstraintLayout constraintLayout;

    @BindView(R.id.dot_layout)
    public LinearLayout dotLayout;
    public OrgyActivityBean.StageListBean g;
    public OrgyActivityBean h;
    public f i;

    @BindView(R.id.iv_activity)
    public ImageView ivActivity;
    public List<View> j;
    public ImageView[] k;
    public int l;

    @BindView(R.id.ll_progress)
    public LinearLayout llProgress;

    @BindView(R.id.proBar)
    public ProgressBar proBar;

    @BindView(R.id.rl_activity)
    public RelativeLayout rlActivity;

    @BindView(R.id.screan_root_layout)
    public RelativeLayout screanRootLayout;

    @BindView(R.id.textView3)
    public ImageView textview3;

    @BindView(R.id.tv_progress)
    public TextView tvProgress;

    @BindView(R.id.tv_skip)
    public TextView tvSkip;

    @BindView(R.id.viewpager)
    public ViewPager viewpager;
    public boolean a = false;
    public List<OrgyActivityBean.StageListBean.AppStartImgBean> b = new ArrayList();
    public String c = "";
    public String d = "";
    public Handler e = new Handler();
    public int f = 1;

    public class a implements ay {
        public a(FlashActivity flashActivity) {
        }

        @Override // dc.ay
        public void a(boolean z) {
            String str = "onResult: " + z;
            if (z) {
                WearUtils.D = false;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyApplication.z0(FlashActivity.this);
            ye3.W();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FlashActivity.this.e.removeCallbacksAndMessages(null);
            FlashActivity.this.f = -2;
            of3.h().e("startup_picture_skip", FlashActivity.this.h, FlashActivity.this.g);
            FlashActivity.this.x4();
        }
    }

    public class d implements View.OnClickListener {
        public d(FlashActivity flashActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FlashActivity.this.A4();
        }
    }

    public class f extends PagerAdapter {
        public List<View> a;

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FlashActivity.this.A4();
            }
        }

        public f(List<View> list) {
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
            view.setOnClickListener(new a());
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public final void A4() {
        OrgyActivityBean.StageListBean stageListBean;
        if (this.f == -2) {
            return;
        }
        of3.h().e("startup_picture_click", this.h, this.g);
        if (this.h == null || (stageListBean = this.g) == null || stageListBean.getOrgyPhaseMark() != 1 || WearUtils.e1(this.g.getOrgyPhaseUrl())) {
            return;
        }
        String eventTrack = OrgyEventTrackUtil.getEventTrack("11", this.h.getId() + "", this.h.getUserGroupId());
        String strConcatenateURL = (this.g.getWayJoinType() == 0 || this.h.getJoinStatus().equals("no") || WearUtils.e1(this.h.getJoinId())) ? OrgySetting.getInstance().concatenateURL(this.g.getOrgyPhaseUrl(), null, eventTrack, EntryPoint.Flash) : OrgySetting.getInstance().concatenateURL(this.g.getOrgyPhaseUrl(), this.h.getJoinId(), eventTrack, EntryPoint.Flash);
        this.f = 0;
        this.e.removeCallbacksAndMessages(null);
        if ("chat".equals(this.d)) {
            try {
                this.c = nd3.h(this.c);
            } catch (Exception unused) {
                this.c = "";
            }
        } else if ("dating".equals(this.d)) {
            OpenAppBean openAppBean = new OpenAppBean();
            openAppBean.type = 1;
            MyApplication.v0(openAppBean);
        }
        if (!TextUtils.isEmpty(this.c)) {
            OpenAppBean openAppBean2 = new OpenAppBean();
            openAppBean2.type = -1;
            openAppBean2.userId = this.c;
            MyApplication.v0(openAppBean2);
        }
        if (this.h.getOpenType().equals("1")) {
            Bundle bundle = new Bundle();
            bundle.putString(ImagesContract.URL, strConcatenateURL);
            bundle.putInt("isOrgyJump", 1);
            ti1.b().d(1);
            pj3.g(this, MainActivity.class, bundle);
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MessageBundle.TITLE_ENTRY, this.h.getName());
            bundle2.putString(ImagesContract.URL, strConcatenateURL);
            bundle2.putInt("from", 1);
            ti1.b().d(1);
            pj3.g(this, OrgyWebViewActivity.class, bundle2);
        }
        finish();
    }

    public final void B4(int i) {
        if (i < 0 || i > this.g.getAppStartImg().size() - 1 || this.l == i) {
            return;
        }
        System.out.println("positon=" + i);
        this.k[i].setEnabled(true);
        System.out.println("currentIndex=" + this.l);
        this.k[this.l].setEnabled(false);
        this.l = i;
    }

    public final void C4() {
        if (this.a) {
            this.tvSkip.setVisibility(0);
            if (WearUtils.e1(this.g.getAppStartDisplayType()) || !this.g.getAppStartDisplayType().equals("pictureSwitching")) {
                this.rlActivity.setVisibility(8);
                this.ivActivity.setVisibility(0);
            } else {
                this.rlActivity.setVisibility(0);
                this.ivActivity.setVisibility(8);
            }
        } else {
            this.constraintLayout.setVisibility(0);
            this.tvSkip.setVisibility(8);
            this.rlActivity.setVisibility(8);
            this.ivActivity.setVisibility(8);
        }
        Uri data = getIntent().getData();
        if (data != null) {
            if (data.getScheme().equals("remotelink")) {
                y4(data);
                return;
            }
            we3.r(data, this);
        }
        this.e.post(new qv1(this));
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

    /* JADX WARN: Removed duplicated region for block: B:92:0x0339  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init() {
        /*
            Method dump skipped, instructions count: 867
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.FlashActivity.init():void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WearUtils.C(this);
        setContentView(R.layout.system_flash);
        ButterKnife.bind(this);
        this.c = getIntent() == null ? "" : getIntent().getStringExtra("user_id");
        this.d = getIntent() != null ? getIntent().getStringExtra("type") : "";
        this.llProgress.setVisibility(4);
        zx.r(false);
        zx.i(getIntent(), new a(this));
        new Handler(Looper.getMainLooper()).postDelayed(new b(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        init();
        if (isTaskRoot()) {
            return;
        }
        Intent intent = getIntent();
        String action = intent.getAction();
        if (intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(action)) {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        String str = "结束时间===" + System.currentTimeMillis();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        B4(i);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ye3.l = System.currentTimeMillis();
        C4();
        int iD = pe3.d("SKIN");
        if (iD == 0) {
            if (getApplication().getResources().getConfiguration().uiMode != 33) {
                this.constraintLayout.setBackgroundResource(R.color.flash_background_color_white);
                return;
            } else {
                this.constraintLayout.setBackgroundResource(R.color.flash_background_color_black);
                this.textview3.setBackgroundResource(R.drawable.lovense_newlogo_white);
                return;
            }
        }
        if (iD != 2) {
            this.constraintLayout.setBackgroundResource(R.color.flash_background_color_white);
        } else {
            this.constraintLayout.setBackgroundResource(R.color.flash_background_color_black);
            this.textview3.setBackgroundResource(R.drawable.lovense_newlogo_white);
        }
    }

    public final void w4() {
        if (this.g.getAppStartImg().size() <= 1) {
            this.dotLayout.setVisibility(8);
        } else {
            this.dotLayout.setVisibility(0);
        }
        this.k = new ImageView[this.g.getAppStartImg().size()];
        for (int i = 0; i < this.g.getAppStartImg().size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(R.drawable.dot_selector);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(16, 16);
            layoutParams.rightMargin = 16;
            imageView.setLayoutParams(layoutParams);
            imageView.setEnabled(false);
            this.k[i] = imageView;
            this.dotLayout.addView(imageView);
        }
        this.l = 0;
        this.k[0].setEnabled(true);
    }

    public final void x4() {
        if (this.f > 0) {
            this.tvSkip.setText(ah4.e(R.string.common_skip) + " " + this.f + "s");
            this.f = this.f - 1;
            this.e.postDelayed(new qv1(this), 1000L);
            return;
        }
        String strH = eg3.h(WearUtils.x, "show_guide_start_key", null);
        if (!WearUtils.e1(strH)) {
            strH.equals(WearUtils.q);
        }
        if (this.a && this.f != -2) {
            of3.h().e("startup_picture_countdown_timer_ended", this.h, this.g);
        }
        if ("chat".equals(this.d)) {
            try {
                this.c = nd3.h(this.c);
            } catch (Exception unused) {
                this.c = "";
            }
        } else if ("dating".equals(this.d)) {
            OpenAppBean openAppBean = new OpenAppBean();
            openAppBean.type = 1;
            MyApplication.v0(openAppBean);
            ti1.b().d(1);
            pj3.f(this, MainActivity.class);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(this.c) && ("chat".equals(this.d) || "groupchat".equals(this.d))) {
            OpenAppBean openAppBean2 = new OpenAppBean();
            openAppBean2.type = -1;
            openAppBean2.userId = this.c;
            MyApplication.v0(openAppBean2);
        }
        if (!TextUtils.isEmpty(this.c) && "controllink".equals(this.d)) {
            OpenAppBean openAppBean3 = new OpenAppBean();
            openAppBean3.type = 5;
            openAppBean3.data = this.c;
            MyApplication.v0(openAppBean3);
        }
        if (!TextUtils.isEmpty(this.d) && TextUtils.equals(this.d, "official_msg")) {
            OpenAppBean openAppBean4 = new OpenAppBean();
            openAppBean4.type = 11;
            openAppBean4.data = this.d;
            MyApplication.v0(openAppBean4);
        }
        ti1.b().d(1);
        pj3.f(this, MainActivity.class);
        finish();
    }

    public final void y4(Uri uri) {
        String queryParameter = uri.getQueryParameter("appcationUrl");
        if (WearUtils.e1(queryParameter)) {
            return;
        }
        we3.q(this, queryParameter, null);
    }
}

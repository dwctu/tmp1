package com.wear.util;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.llong.CircularProgressView;
import dc.g12;
import dc.h12;
import dc.mv1;
import dc.na2;
import dc.nd3;
import dc.pj3;
import dc.rf3;
import dc.ve2;
import dc.xe2;
import dc.y12;
import dc.zt3;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class HomePatternPlayUtil extends mv1 implements View.OnClickListener {
    public ve2 a;
    public List<Pattern> b;
    public List<Pattern> c;
    public Pattern d;

    @BindView(R.id.home_pattern_cpv)
    public CircularProgressView homePatternCpv;

    @BindView(R.id.home_pattern_ll_type)
    public LinearLayout homePatternLlType;

    @BindView(R.id.home_pattern_next)
    public ImageView homePatternNext;

    @BindView(R.id.home_pattern_play)
    public ImageView homePatternPlay;

    @BindView(R.id.home_pattern_previous)
    public ImageView homePatternPrevious;

    @BindView(R.id.home_pattern_title)
    public MediumBoldTextView homePatternTitle;

    @BindView(R.id.home_pattern_toy_type_1)
    public ImageView homePatternToyType1;

    @BindView(R.id.home_pattern_toy_type_2)
    public ImageView homePatternToyType2;

    @BindView(R.id.home_pattern_toy_type_3)
    public ImageView homePatternToyType3;

    @BindView(R.id.ll_pattern_play)
    public LinearLayout llPatternPlay;

    public class a implements View.OnClickListener {
        public final /* synthetic */ BaseActivity a;

        public a(BaseActivity baseActivity) {
            this.a = baseActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (na2.m().i()) {
                na2.m().t();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("pattern", HomePatternPlayUtil.this.d);
            if (PatternPlayManagerImpl.O().c0() && PatternPlayManagerImpl.O().T().getId().equals(HomePatternPlayUtil.this.d.getId())) {
                bundle.putSerializable("intoType", 1);
            } else {
                bundle.putSerializable("intoType", 0);
            }
            bundle.putSerializable("from", "MianActivity");
            ((xe2) xe2.L0()).J1(new ArrayList(HomePatternPlayUtil.this.b));
            pj3.g(this.a, PatternPlayActivity.class, bundle);
        }
    }

    public HomePatternPlayUtil(BaseActivity baseActivity, MyApplication myApplication, g12 g12Var, View view) {
        xe2.L0();
        this.a = (ve2) xe2.L0();
        this.b = new ArrayList();
        new ArrayList();
        new ConcurrentHashMap();
        ButterKnife.bind(this, view);
        this.homePatternPlay.setOnClickListener(this);
        this.homePatternPrevious.setOnClickListener(this);
        this.homePatternNext.setOnClickListener(this);
        this.llPatternPlay.setOnClickListener(new a(baseActivity));
    }

    @Override // dc.hv1
    public void A3(Pattern pattern, int i) {
        if (i == 0) {
            this.d = pattern;
            l();
        }
    }

    @Override // dc.hv1
    public void D2(Pattern pattern, int i) {
        if (i == 0) {
            ImageView imageView = this.homePatternPlay;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.home_pause_new);
                i(true);
                this.homePatternCpv.setProgress(0);
                return;
            }
            return;
        }
        ImageView imageView2 = this.homePatternPlay;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.home_play_new);
            this.homePatternCpv.setProgress(0);
            i(false);
        }
    }

    @Override // dc.hv1
    public void V1(boolean z, int i) {
        ImageView imageView = this.homePatternPlay;
        if (imageView != null) {
            imageView.setImageResource(z ? R.drawable.home_play_new : R.drawable.home_pause_new);
            i(!z);
        }
    }

    @Override // dc.hv1
    public void X3(String str, int i, int i2, String str2) {
        CircularProgressView circularProgressView;
        if (i2 != 0 || (circularProgressView = this.homePatternCpv) == null) {
            return;
        }
        circularProgressView.setProgress(i);
    }

    public void c() {
        PatternPlayManagerImpl.O().G(this);
    }

    public Pattern d() {
        String value = zt3.k;
        if (WearUtils.e1(value)) {
            value = DaoUtils.getTestValueDao().getValue(TestValueDao.SAVE_KEY_LAST_LI_KEY, TestValueDao.SAVE_KEY_LAST_LI_TYPE);
        }
        if (WearUtils.e1(value)) {
            return null;
        }
        return (Pattern) WearUtils.A.fromJson(nd3.i(DaoUtils.getTestValueDao().getValue(value, TestValueDao.HOME_PLAY_PATTERN_HIS)), Pattern.class);
    }

    public void e() {
        if (PatternPlayManagerImpl.O().c0()) {
            this.d = PatternPlayManagerImpl.O().T();
            this.c = PatternPlayManagerImpl.O().S();
        } else if (this.d == null) {
            k();
            Pattern patternD = d();
            if (patternD != null) {
                for (Pattern pattern : this.b) {
                    if (pattern.getId().equals(patternD.getId())) {
                        this.d = pattern;
                    }
                }
            }
            if (this.d == null) {
                this.d = this.b.get(0);
            }
        }
        l();
    }

    public void f() {
    }

    public void g() {
        PatternPlayManagerImpl.O().N0(this);
    }

    public void h() {
        if (PatternPlayManagerImpl.O().c0()) {
            this.d = PatternPlayManagerImpl.O().T();
            this.c = PatternPlayManagerImpl.O().S();
        } else {
            k();
        }
        l();
    }

    public final void i(boolean z) {
        if (z) {
            this.homePatternTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        } else {
            this.homePatternTitle.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void j() {
        k();
        List<Pattern> list = this.b;
        if (list != null && list.size() > 0) {
            this.d = this.b.get(0);
        }
        l();
    }

    public void k() {
        List<Pattern> listY = xe2.L0().y(WearUtils.y.r());
        this.b.clear();
        if (listY != null && listY.size() > 0) {
            if (listY.size() > 4) {
                for (int i = 0; i < 4; i++) {
                    Pattern pattern = listY.get(i);
                    pattern.setDataNoCheckFormat(WearUtils.N1(pattern.getFile().getPath()));
                }
            } else {
                for (Pattern pattern2 : listY) {
                    pattern2.setDataNoCheckFormat(WearUtils.N1(pattern2.getFile().getPath()));
                }
            }
            this.b.addAll(listY);
        }
        this.b.addAll(rf3.j());
    }

    public final void l() {
        MediumBoldTextView mediumBoldTextView = this.homePatternTitle;
        if (mediumBoldTextView != null) {
            Pattern pattern = this.d;
            if (pattern != null) {
                mediumBoldTextView.setText(pattern.getName());
                if (WearUtils.e1(this.d.getToyFunc())) {
                    this.homePatternToyType1.setImageResource(R.drawable.icon_label_toy_function_vibration);
                    this.homePatternToyType2.setVisibility(8);
                } else {
                    this.homePatternToyType1.setImageResource(R.drawable.icon_label_toy_function_vibration);
                    this.homePatternToyType3.setVisibility(8);
                    if (this.d.getToyFunc().equals("v,r")) {
                        this.homePatternToyType2.setVisibility(0);
                        this.homePatternToyType2.setImageResource(R.drawable.icon_label_toy_function_rotation);
                    } else if (this.d.getToyFunc().equals("v,p")) {
                        this.homePatternToyType2.setVisibility(0);
                        this.homePatternToyType2.setImageResource(R.drawable.icon_label_toy_function_contraction);
                    } else if (this.d.getToyFunc().equals("v1,v2")) {
                        this.homePatternToyType2.setVisibility(0);
                        this.homePatternToyType2.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
                    } else if (!TextUtils.isEmpty(this.d.getToyFeature()) && this.d.getToyFeature().toLowerCase().equals(Toy.TOY_FEATURE_XMACHINE)) {
                        this.homePatternToyType1.setImageResource(R.drawable.icon_label_toy_function_thrusting);
                        this.homePatternToyType2.setVisibility(8);
                    } else if (this.d.getToyFunc().equals("s")) {
                        this.homePatternToyType1.setImageResource(R.drawable.icon_white_function_suction);
                        this.homePatternToyType2.setVisibility(8);
                    } else if (this.d.getToyFunc().equals("v1,v2,f")) {
                        this.homePatternToyType2.setVisibility(0);
                        this.homePatternToyType2.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
                        this.homePatternToyType3.setVisibility(0);
                        this.homePatternToyType3.setImageResource(R.drawable.icon_label_toy_function_fingering);
                    } else if (this.d.getToyFunc().equals("v1,v2,v3")) {
                        this.homePatternToyType2.setVisibility(0);
                        this.homePatternToyType2.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
                        this.homePatternToyType3.setVisibility(0);
                        this.homePatternToyType3.setImageResource(R.drawable.dark_home_wave);
                    } else if (this.d.getToyFunc().equals("v,f")) {
                        this.homePatternToyType1.setImageResource(R.drawable.icon_label_toy_function_vibration);
                        this.homePatternToyType2.setVisibility(0);
                        this.homePatternToyType2.setImageResource(R.drawable.icon_label_toy_function_fingering);
                        this.homePatternToyType3.setVisibility(8);
                    } else if (this.d.getToyFunc().equals("t,d")) {
                        this.homePatternToyType1.setImageResource(R.drawable.icon_label_toy_function_thrusting);
                        this.homePatternToyType2.setVisibility(0);
                        this.homePatternToyType2.setImageResource(R.drawable.icon_label_toy_function_depth);
                        this.homePatternToyType3.setVisibility(8);
                    } else if (this.d.getToyFunc().equals("v,t")) {
                        this.homePatternToyType1.setImageResource(R.drawable.icon_label_toy_function_vibration);
                        this.homePatternToyType2.setVisibility(0);
                        this.homePatternToyType2.setImageResource(R.drawable.icon_label_toy_function_speed);
                        this.homePatternToyType3.setVisibility(8);
                    } else if (this.d.getToyFunc().equals("pos")) {
                        this.homePatternToyType1.setImageResource(R.drawable.icon_velvo_position);
                        this.homePatternToyType2.setVisibility(8);
                        this.homePatternToyType3.setVisibility(8);
                    } else {
                        this.homePatternToyType2.setVisibility(8);
                    }
                }
            }
            boolean zC0 = PatternPlayManagerImpl.O().c0();
            int i = R.drawable.home_play_new;
            if (!zC0) {
                this.homePatternPlay.setImageResource(R.drawable.home_play_new);
                this.homePatternCpv.setProgress(0);
                i(false);
            } else {
                ImageView imageView = this.homePatternPlay;
                if (!PatternPlayManagerImpl.O().d0()) {
                    i = R.drawable.home_pause_new;
                }
                imageView.setImageResource(i);
                i(!PatternPlayManagerImpl.O().d0());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (na2.m().i()) {
            na2.m().t();
        }
        if (y12.c.a().s(y12.c.TYPE_PATTERN)) {
            PatternPlayManagerImpl.O().C0();
            MusicControl.h0().S();
            c();
            h12.D.isPlayPatternOnHomePattern = true;
            switch (view.getId()) {
                case R.id.home_pattern_next /* 2131362933 */:
                    if (!PatternPlayManagerImpl.O().c0()) {
                        PatternPlayManagerImpl.O().X(this.b, 0);
                        PatternPlayManagerImpl.O().I0(this.d, 1);
                        break;
                    } else {
                        PatternPlayManagerImpl.O().H0(1);
                        break;
                    }
                case R.id.home_pattern_play /* 2131362934 */:
                    if (!PatternPlayManagerImpl.O().c0()) {
                        PatternPlayManagerImpl.O().X(this.b, 0);
                        PatternPlayManagerImpl.O().G0(this.d);
                        break;
                    } else if (!PatternPlayManagerImpl.O().T().getId().equals(this.d.getId())) {
                        PatternPlayManagerImpl.O().X(this.b, 0);
                        PatternPlayManagerImpl.O().G0(this.d);
                        break;
                    } else {
                        PatternPlayManagerImpl.O().E0();
                        break;
                    }
                case R.id.home_pattern_previous /* 2131362935 */:
                    if (!PatternPlayManagerImpl.O().c0()) {
                        PatternPlayManagerImpl.O().X(this.b, 0);
                        PatternPlayManagerImpl.O().I0(this.d, -1);
                        break;
                    } else {
                        PatternPlayManagerImpl.O().H0(-1);
                        break;
                    }
            }
        }
    }

    @Override // dc.hv1
    public void z1() {
        ImageView imageView = this.homePatternPlay;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.home_play_new);
            this.homePatternCpv.setProgress(0);
            i(false);
        }
    }
}

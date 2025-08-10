package com.wear.ui.discover.speedMode;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.bean.event.NinjaSpeedModeChangeEvent;
import com.wear.bean.event.NotificationSpeedModeCloseEvent;
import com.wear.main.toy.ToyActivity;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.ui.discover.speedMode.SpeedModeControl;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import dc.ah4;
import dc.be3;
import dc.cs3;
import dc.fk2;
import dc.is3;
import dc.ke3;
import dc.me3;
import dc.pc1;
import dc.pj3;
import dc.q61;
import dc.sg3;
import dc.t51;
import dc.th4;
import dc.u51;
import dc.ye3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class SpeedModeActivity extends BaseActivity implements SpeedModeControl.h {
    public static final String f = SpeedModeActivity.class.getName();
    public Dialog a;
    public ValueAnimator b;

    @BindView(R.id.actionbar)
    public MyActionBar bar;
    public float c = 0.0f;

    @BindView(R.id.container)
    public View container;
    public long d;
    public long e;

    @BindView(R.id.iv_play_or_pause)
    public ImageView ivPlayOrPause;

    @BindView(R.id.lav_speed_mode)
    public LottieAnimationView lavSpeed;

    @BindView(R.id.lav_speed_mode_bg)
    public LottieAnimationView lavSpeedBg;

    @BindView(R.id.ll_sensitivity_tip)
    public SkinRoundAutoLinearLayout llSensitivityTip;

    @BindView(R.id.seek_bar_level)
    public SeekBar sbLevel;

    @BindView(R.id.seek_bar_sensitivity)
    public SeekBar sbSensitivity;

    @BindView(R.id.sv_debug)
    public ScrollView sv_debug;

    @BindView(R.id.tv_debug)
    public TextView tv_debug;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(SpeedModeActivity.this, ToyActivity.class);
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            SpeedModeActivity.this.onBackPressed();
        }
    }

    public class c implements SeekBar.OnSeekBarChangeListener {
        public c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SpeedModeControl.C().W(i, 0);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SpeedModeActivity.this.t4(1, seekBar.getProgress());
        }
    }

    public class d implements SeekBar.OnSeekBarChangeListener {
        public d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SpeedModeControl.C().S(i);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SpeedModeActivity.this.t4(2, seekBar.getProgress());
        }
    }

    public class e implements u51 {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(SpeedModeActivity.this);
            }
        }

        public class b implements is3.c {
            public b(e eVar) {
            }

            @Override // dc.is3.c
            public void doCancel() {
            }
        }

        public e() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            is3.b bVar = new is3.b(SpeedModeActivity.this);
            bVar.p(ah4.e(R.string.notification_location_permission_speed));
            bVar.o(ah4.e(R.string.button_continue));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.c(new b(this));
            bVar.d(new a());
            cs3.h(bVar).show();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                fk2.a.m(SoundPlayActivity.class, SpeedModeControl.C().K());
                if (!SpeedModeControl.C().L() || SpeedModeControl.C().K()) {
                    SpeedModeControl.C().X();
                    SpeedModeActivity speedModeActivity = SpeedModeActivity.this;
                    speedModeActivity.ivPlayOrPause.setImageDrawable(th4.d(speedModeActivity, R.drawable.speedmode_pause));
                    SpeedModeActivity.this.lavSpeedBg.r();
                }
            }
        }
    }

    public class f implements is3.d {
        public f() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(SpeedModeActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x4(ValueAnimator valueAnimator) {
        this.lavSpeed.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @Override // com.wear.ui.discover.speedMode.SpeedModeControl.h
    public void S2(float f2) {
        if (f2 > 1.0f) {
            f2 = (float) Math.pow(f2, 0.4d);
        }
        float f3 = f2 / 8.0f;
        if (f3 < 0.02d) {
            f3 = 0.0f;
            this.lavSpeed.setProgress(0.0f);
        } else {
            this.b.setFloatValues(this.c, f3);
            this.b.start();
            this.c = f3;
        }
        String str = "acceleration:" + f2 + ",  progress:" + f3;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i != 1) {
                if (i == 2) {
                    Dialog dialog = this.a;
                    if (dialog != null && dialog.isShowing()) {
                        this.a.dismiss();
                    }
                    u4();
                    return;
                }
                return;
            }
            if (intent.getBooleanExtra("grant_all", false)) {
                u4();
                return;
            }
            is3.b bVar = new is3.b(this);
            bVar.p(ah4.e(R.string.notification_location_refused));
            bVar.o(ah4.e(R.string.button_go_to_settings));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new f());
            cs3.h(bVar).show();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!SpeedModeControl.C().K()) {
            SpeedModeControl.C().a0();
            finish();
        } else if (checkFloatWindowsPermission()) {
            finish();
        }
    }

    @OnClick({R.id.actionbar_title, R.id.iv_play_or_pause, R.id.iv_sensitivity_tip_close})
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int id = view.getId();
        if (id != R.id.iv_play_or_pause) {
            if (id != R.id.iv_sensitivity_tip_close) {
                return;
            }
            this.llSensitivityTip.setVisibility(8);
            ke3.c("function_sensitivity_replaced_speed_mode");
            return;
        }
        if (SpeedModeControl.C().L()) {
            SpeedModeControl.C().N();
        } else if (u4()) {
            SpeedModeControl.C().V();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        me3.c(me3.c.SPEED_MODE_UI_ENTER);
        ye3.c("speed mode", "into page", null);
        setContentView(R.layout.discover_speed_mode_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        SpeedModeControl.C().T(this);
        v4();
        u4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        me3.c(me3.c.SPEED_MODE_UI_EXIT);
        EventBus.getDefault().unregister(this);
        this.bar.s();
        this.b.cancel();
        this.lavSpeedBg.g();
        this.lavSpeed.g();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaSpeedModeChangeEvent ninjaSpeedModeChangeEvent) {
        if (ninjaSpeedModeChangeEvent.getChangeStatus() == 4) {
            this.sbSensitivity.setProgress(ninjaSpeedModeChangeEvent.getSensitivity());
            return;
        }
        if (ninjaSpeedModeChangeEvent.getChangeStatus() == 1) {
            this.ivPlayOrPause.setImageDrawable(th4.d(this, ninjaSpeedModeChangeEvent.isPlayOrPause() ? R.drawable.speedmode_play : R.drawable.speedmode_pause));
            if (ninjaSpeedModeChangeEvent.isPlayOrPause()) {
                this.lavSpeedBg.q();
            } else {
                this.lavSpeedBg.s();
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SpeedModeControl.C().V();
    }

    @Override // com.wear.ui.discover.speedMode.SpeedModeControl.h
    public void r0(float f2) {
        float f3 = f2 / 10.0f;
        if (f3 < 0.4f) {
            f3 = 0.4f;
        } else if (f3 > 2.0f) {
            f3 = 2.0f;
        }
        this.lavSpeedBg.setSpeed(-f3);
    }

    public final void t4(int i, int i2) {
        long jR = be3.r();
        if (i == 1) {
            if (jR - this.d < 1000) {
                return;
            } else {
                this.d = jR;
            }
        } else if (jR - this.e < 1000) {
            return;
        } else {
            this.e = jR;
        }
        HashMap map = new HashMap();
        map.put("mode_type", 1);
        map.put("slide_type", Integer.valueOf(i));
        map.put(FirebaseAnalytics.Param.LEVEL, Integer.valueOf(i2));
        ArrayList<Toy> arrayListP = pc1.a.P();
        ArrayList arrayList = new ArrayList();
        Iterator<Toy> it = arrayListP.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAddress().toLowerCase().replace(SignatureImpl.INNER_SEP, ""));
        }
        map.put("toy_mac", WearUtils.A.toJson(arrayList));
        ye3.d("C0017", WearUtils.A.toJson(map));
    }

    public final boolean u4() {
        if (!SpeedModeControl.C().J()) {
            sg3.l(ah4.e(R.string.app_trun_on_gps_notice));
            return false;
        }
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.ACCESS_FINE_LOCATION");
        q61VarM.h("android.permission.ACCESS_COARSE_LOCATION");
        q61VarM.j(new e());
        return true;
    }

    public final void v4() {
        this.bar.setToysAction(new a(), false, this);
        this.bar.setBackAction(new b());
        this.bar.n();
        this.sbSensitivity.setProgress(SpeedModeControl.C().E());
        this.sbSensitivity.setOnSeekBarChangeListener(new c());
        this.llSensitivityTip.setVisibility(ke3.b("new_feature", "function_sensitivity_replaced_speed_mode", false) ? 0 : 8);
        this.llSensitivityTip.setRadius(8.0f);
        this.sbLevel.setProgress(SpeedModeControl.C().B());
        this.sbLevel.setOnSeekBarChangeListener(new d());
        this.lavSpeed.setImageAssetsFolder("speed_mode_dashboard/images/");
        this.lavSpeed.setAnimation(th4.e().p() ? "speed_mode_dashboard/data_light.json" : "speed_mode_dashboard/data_dark.json");
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(100L);
        this.b = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dc.sy2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.x4(valueAnimator);
            }
        });
        this.lavSpeedBg.setImageAssetsFolder(th4.e().p() ? "speed_mode_horizon_light/images/" : "speed_mode_horizon_dark/images/");
        this.lavSpeedBg.setAnimation(th4.e().p() ? "speed_mode_horizon_light/data.json" : "speed_mode_horizon_dark/data.json");
        this.lavSpeedBg.q();
        this.lavSpeedBg.setSpeed(-0.5f);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationSpeedModeCloseEvent notificationSpeedModeCloseEvent) {
        this.ivPlayOrPause.setImageDrawable(th4.d(this, R.drawable.speedmode_play));
        this.lavSpeedBg.g();
    }
}

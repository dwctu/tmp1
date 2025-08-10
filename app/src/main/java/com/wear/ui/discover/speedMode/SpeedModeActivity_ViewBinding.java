package com.wear.ui.discover.speedMode;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class SpeedModeActivity_ViewBinding implements Unbinder {
    public SpeedModeActivity a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SpeedModeActivity a;

        public a(SpeedModeActivity_ViewBinding speedModeActivity_ViewBinding, SpeedModeActivity speedModeActivity) {
            this.a = speedModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SpeedModeActivity a;

        public b(SpeedModeActivity_ViewBinding speedModeActivity_ViewBinding, SpeedModeActivity speedModeActivity) {
            this.a = speedModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ SpeedModeActivity a;

        public c(SpeedModeActivity_ViewBinding speedModeActivity_ViewBinding, SpeedModeActivity speedModeActivity) {
            this.a = speedModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SpeedModeActivity_ViewBinding(SpeedModeActivity speedModeActivity, View view) {
        this.a = speedModeActivity;
        speedModeActivity.container = Utils.findRequiredView(view, R.id.container, "field 'container'");
        speedModeActivity.bar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'bar'", MyActionBar.class);
        speedModeActivity.llSensitivityTip = (SkinRoundAutoLinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_sensitivity_tip, "field 'llSensitivityTip'", SkinRoundAutoLinearLayout.class);
        speedModeActivity.lavSpeed = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.lav_speed_mode, "field 'lavSpeed'", LottieAnimationView.class);
        speedModeActivity.lavSpeedBg = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.lav_speed_mode_bg, "field 'lavSpeedBg'", LottieAnimationView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_play_or_pause, "field 'ivPlayOrPause' and method 'onClick'");
        speedModeActivity.ivPlayOrPause = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_play_or_pause, "field 'ivPlayOrPause'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, speedModeActivity));
        speedModeActivity.sbSensitivity = (SeekBar) Utils.findRequiredViewAsType(view, R.id.seek_bar_sensitivity, "field 'sbSensitivity'", SeekBar.class);
        speedModeActivity.sbLevel = (SeekBar) Utils.findRequiredViewAsType(view, R.id.seek_bar_level, "field 'sbLevel'", SeekBar.class);
        speedModeActivity.sv_debug = (ScrollView) Utils.findRequiredViewAsType(view, R.id.sv_debug, "field 'sv_debug'", ScrollView.class);
        speedModeActivity.tv_debug = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_debug, "field 'tv_debug'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.actionbar_title, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, speedModeActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_sensitivity_tip_close, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, speedModeActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SpeedModeActivity speedModeActivity = this.a;
        if (speedModeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        speedModeActivity.container = null;
        speedModeActivity.bar = null;
        speedModeActivity.llSensitivityTip = null;
        speedModeActivity.lavSpeed = null;
        speedModeActivity.lavSpeedBg = null;
        speedModeActivity.ivPlayOrPause = null;
        speedModeActivity.sbSensitivity = null;
        speedModeActivity.sbLevel = null;
        speedModeActivity.sv_debug = null;
        speedModeActivity.tv_debug = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}

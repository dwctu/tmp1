package com.wear.main.toy;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.main.toy.newtoy.seekbar.SignSeekBar;
import com.wear.widget.MyActionBar;
import com.wear.widget.seekbar.RangeSeekBar;

/* loaded from: classes3.dex */
public class ToyStrengthActivity_ViewBinding implements Unbinder {
    public ToyStrengthActivity a;

    @UiThread
    public ToyStrengthActivity_ViewBinding(ToyStrengthActivity toyStrengthActivity, View view) {
        this.a = toyStrengthActivity;
        toyStrengthActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        toyStrengthActivity.ivVibration = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_vibration, "field 'ivVibration'", ImageView.class);
        toyStrengthActivity.tvVibration = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vibration, "field 'tvVibration'", TextView.class);
        toyStrengthActivity.llVibration = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_vibration, "field 'llVibration'", LinearLayout.class);
        toyStrengthActivity.ivRotate = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_rotate, "field 'ivRotate'", ImageView.class);
        toyStrengthActivity.tvRotate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rotate, "field 'tvRotate'", TextView.class);
        toyStrengthActivity.llRotate = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_rotate, "field 'llRotate'", LinearLayout.class);
        toyStrengthActivity.ivAir = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_air, "field 'ivAir'", ImageView.class);
        toyStrengthActivity.tvAir = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_air, "field 'tvAir'", TextView.class);
        toyStrengthActivity.llAir = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_air, "field 'llAir'", LinearLayout.class);
        toyStrengthActivity.ivVibration1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_vibration_1, "field 'ivVibration1'", ImageView.class);
        toyStrengthActivity.tvVibration1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vibration_1, "field 'tvVibration1'", TextView.class);
        toyStrengthActivity.llVibration1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_vibration_1, "field 'llVibration1'", LinearLayout.class);
        toyStrengthActivity.ivVibration2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_vibration_2, "field 'ivVibration2'", ImageView.class);
        toyStrengthActivity.tvVibration2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vibration_2, "field 'tvVibration2'", TextView.class);
        toyStrengthActivity.llVibration2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_vibration_2, "field 'llVibration2'", LinearLayout.class);
        toyStrengthActivity.ivVibration3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_vibration_3, "field 'ivVibration3'", ImageView.class);
        toyStrengthActivity.tvVibration3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vibration_3, "field 'tvVibration3'", TextView.class);
        toyStrengthActivity.llVibration3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_vibration_3, "field 'llVibration3'", LinearLayout.class);
        toyStrengthActivity.ivThrusting = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_thrusting, "field 'ivThrusting'", ImageView.class);
        toyStrengthActivity.tvThrusting = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_thrusting, "field 'tvThrusting'", TextView.class);
        toyStrengthActivity.llThrusting = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_thrusting, "field 'llThrusting'", LinearLayout.class);
        toyStrengthActivity.llFingering = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_fingering, "field 'llFingering'", LinearLayout.class);
        toyStrengthActivity.ivFingering = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_fingering, "field 'ivFingering'", ImageView.class);
        toyStrengthActivity.tvFingering = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fingering, "field 'tvFingering'", TextView.class);
        toyStrengthActivity.llDepth = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_depth, "field 'llDepth'", LinearLayout.class);
        toyStrengthActivity.ivDepth = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_depth, "field 'ivDepth'", ImageView.class);
        toyStrengthActivity.tvDepth = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_depth, "field 'tvDepth'", TextView.class);
        toyStrengthActivity.llSpeed = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_speed, "field 'llSpeed'", LinearLayout.class);
        toyStrengthActivity.llControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_stroke, "field 'llControl'", LinearLayout.class);
        toyStrengthActivity.tvThrustSpeed = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_thrust_speed, "field 'tvThrustSpeed'", TextView.class);
        toyStrengthActivity.ivThrustSpeed = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_speed, "field 'ivThrustSpeed'", ImageView.class);
        toyStrengthActivity.vibrationControl = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.vibration_control, "field 'vibrationControl'", SignSeekBar.class);
        toyStrengthActivity.vibrationControl1 = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.vibration_control_1, "field 'vibrationControl1'", SignSeekBar.class);
        toyStrengthActivity.vibrationControl2 = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.vibration_control_2, "field 'vibrationControl2'", SignSeekBar.class);
        toyStrengthActivity.vibrationControl3 = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.vibration_control_3, "field 'vibrationControl3'", SignSeekBar.class);
        toyStrengthActivity.rotateControl = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.rotate_control, "field 'rotateControl'", SignSeekBar.class);
        toyStrengthActivity.airControl = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.air_control, "field 'airControl'", SignSeekBar.class);
        toyStrengthActivity.thrustingControl = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.thrusting_control, "field 'thrustingControl'", SignSeekBar.class);
        toyStrengthActivity.fingeringControl = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.fingering_control, "field 'fingeringControl'", SignSeekBar.class);
        toyStrengthActivity.depthControl = (SignSeekBar) Utils.findRequiredViewAsType(view, R.id.depth_control, "field 'depthControl'", SignSeekBar.class);
        toyStrengthActivity.speedControl = (RangeSeekBar) Utils.findRequiredViewAsType(view, R.id.speed_control, "field 'speedControl'", RangeSeekBar.class);
        toyStrengthActivity.strokeControl = (RangeSeekBar) Utils.findRequiredViewAsType(view, R.id.stroke_seekbar, "field 'strokeControl'", RangeSeekBar.class);
        toyStrengthActivity.tvTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tips, "field 'tvTips'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyStrengthActivity toyStrengthActivity = this.a;
        if (toyStrengthActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyStrengthActivity.actionbar = null;
        toyStrengthActivity.ivVibration = null;
        toyStrengthActivity.tvVibration = null;
        toyStrengthActivity.llVibration = null;
        toyStrengthActivity.ivRotate = null;
        toyStrengthActivity.tvRotate = null;
        toyStrengthActivity.llRotate = null;
        toyStrengthActivity.ivAir = null;
        toyStrengthActivity.tvAir = null;
        toyStrengthActivity.llAir = null;
        toyStrengthActivity.ivVibration1 = null;
        toyStrengthActivity.tvVibration1 = null;
        toyStrengthActivity.llVibration1 = null;
        toyStrengthActivity.ivVibration2 = null;
        toyStrengthActivity.tvVibration2 = null;
        toyStrengthActivity.llVibration2 = null;
        toyStrengthActivity.ivVibration3 = null;
        toyStrengthActivity.tvVibration3 = null;
        toyStrengthActivity.llVibration3 = null;
        toyStrengthActivity.ivThrusting = null;
        toyStrengthActivity.tvThrusting = null;
        toyStrengthActivity.llThrusting = null;
        toyStrengthActivity.llFingering = null;
        toyStrengthActivity.ivFingering = null;
        toyStrengthActivity.tvFingering = null;
        toyStrengthActivity.llDepth = null;
        toyStrengthActivity.ivDepth = null;
        toyStrengthActivity.tvDepth = null;
        toyStrengthActivity.llSpeed = null;
        toyStrengthActivity.llControl = null;
        toyStrengthActivity.tvThrustSpeed = null;
        toyStrengthActivity.ivThrustSpeed = null;
        toyStrengthActivity.vibrationControl = null;
        toyStrengthActivity.vibrationControl1 = null;
        toyStrengthActivity.vibrationControl2 = null;
        toyStrengthActivity.vibrationControl3 = null;
        toyStrengthActivity.rotateControl = null;
        toyStrengthActivity.airControl = null;
        toyStrengthActivity.thrustingControl = null;
        toyStrengthActivity.fingeringControl = null;
        toyStrengthActivity.depthControl = null;
        toyStrengthActivity.speedControl = null;
        toyStrengthActivity.strokeControl = null;
        toyStrengthActivity.tvTips = null;
    }
}

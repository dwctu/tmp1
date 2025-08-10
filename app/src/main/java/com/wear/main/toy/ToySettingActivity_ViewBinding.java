package com.wear.main.toy;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import com.wear.widget.roundwidget.SkinRoundView;

/* loaded from: classes3.dex */
public class ToySettingActivity_ViewBinding implements Unbinder {
    public ToySettingActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ToySettingActivity a;

        public a(ToySettingActivity_ViewBinding toySettingActivity_ViewBinding, ToySettingActivity toySettingActivity) {
            this.a = toySettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked();
        }
    }

    @UiThread
    public ToySettingActivity_ViewBinding(ToySettingActivity toySettingActivity, View view) {
        this.a = toySettingActivity;
        toySettingActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        toySettingActivity.toyReName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_reName, "field 'toyReName'", TextView.class);
        toySettingActivity.settingName = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_name, "field 'settingName'", RelativeLayout.class);
        toySettingActivity.settingProgram = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_program, "field 'settingProgram'", RelativeLayout.class);
        toySettingActivity.settingFunction = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.setting_function, "field 'settingFunction'", ConstraintLayout.class);
        toySettingActivity.vSettingFunctionTop = (ImageView) Utils.findRequiredViewAsType(view, R.id.v_setting_function_top, "field 'vSettingFunctionTop'", ImageView.class);
        toySettingActivity.ivFunRedDot = Utils.findRequiredView(view, R.id.iv_fun_red_dot, "field 'ivFunRedDot'");
        toySettingActivity.tvCurrMode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_curr_mode, "field 'tvCurrMode'", TextView.class);
        toySettingActivity.vSettingProgramTop = (ImageView) Utils.findRequiredViewAsType(view, R.id.v_setting_program_top, "field 'vSettingProgramTop'", ImageView.class);
        toySettingActivity.settingProgramTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.setting_program_title, "field 'settingProgramTitle'", TextView.class);
        toySettingActivity.settingLedTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.setting_led_title, "field 'settingLedTitle'", TextView.class);
        toySettingActivity.settingAutoSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_auto_swith, "field 'settingAutoSwith'", SwitchView.class);
        toySettingActivity.settingRunLastLevel = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_run_lastLevel, "field 'settingRunLastLevel'", SwitchView.class);
        toySettingActivity.settingLedSwitch = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_led_switch, "field 'settingLedSwitch'", SwitchView.class);
        toySettingActivity.llSettingLedLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_setting_led_layout, "field 'llSettingLedLayout'", LinearLayout.class);
        toySettingActivity.llSettingToyReconnect = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_setting_toy_reconnect, "field 'llSettingToyReconnect'", LinearLayout.class);
        toySettingActivity.tvToyTurnOff = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toy_turn_off, "field 'tvToyTurnOff'", TextView.class);
        toySettingActivity.tvToyLastLeven = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toy_last_leven, "field 'tvToyLastLeven'", TextView.class);
        toySettingActivity.vLedColor = Utils.findRequiredView(view, R.id.v_led_color, "field 'vLedColor'");
        toySettingActivity.tvLedColor = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_led_color, "field 'tvLedColor'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_led_color, "field 'rlLedColor' and method 'onViewClicked'");
        toySettingActivity.rlLedColor = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.rl_led_color, "field 'rlLedColor'", RelativeLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, toySettingActivity));
        toySettingActivity.tvLedColorLeft = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_led_color_left, "field 'tvLedColorLeft'", TextView.class);
        toySettingActivity.tvDepthControl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_depth_control, "field 'tvDepthControl'", TextView.class);
        toySettingActivity.rlDepthControl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_depth_control, "field 'rlDepthControl'", RelativeLayout.class);
        toySettingActivity.tvDepthControlStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_depth_control_status, "field 'tvDepthControlStatus'", TextView.class);
        toySettingActivity.ivDepthControl = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_depth_control, "field 'ivDepthControl'", ImageView.class);
        toySettingActivity.settingStrengthTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.setting_strength_title, "field 'settingStrengthTitle'", TextView.class);
        toySettingActivity.settingStrength = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_strength, "field 'settingStrength'", RelativeLayout.class);
        toySettingActivity.roundViewSettingTip = (SkinRoundView) Utils.findRequiredViewAsType(view, R.id.round_view_setting_tip, "field 'roundViewSettingTip'", SkinRoundView.class);
        toySettingActivity.ivThreshold = (ImageView) Utils.findRequiredViewAsType(view, R.id.v_threshold_top, "field 'ivThreshold'", ImageView.class);
        toySettingActivity.settingThresholdTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.setting_threshold_title, "field 'settingThresholdTitle'", TextView.class);
        toySettingActivity.settingThreshold = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_threshold, "field 'settingThreshold'", RelativeLayout.class);
        toySettingActivity.vAutoSwith = Utils.findRequiredView(view, R.id.v_auto_swith, "field 'vAutoSwith'");
        toySettingActivity.vRunLastLevel = Utils.findRequiredView(view, R.id.v_run_lastLevel, "field 'vRunLastLevel'");
        toySettingActivity.vLedSwitch = Utils.findRequiredView(view, R.id.v_led_switch, "field 'vLedSwitch'");
        toySettingActivity.tvToyDisconnectShow = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toy_disconnect_show, "field 'tvToyDisconnectShow'", TextView.class);
        toySettingActivity.vDepthControlTop = (ImageView) Utils.findRequiredViewAsType(view, R.id.v_depth_control_top, "field 'vDepthControlTop'", ImageView.class);
        toySettingActivity.vLedColorTop = (ImageView) Utils.findRequiredViewAsType(view, R.id.v_led_color_top, "field 'vLedColorTop'", ImageView.class);
        toySettingActivity.tvToyFirmware = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toy_firmware, "field 'tvToyFirmware'", TextView.class);
        toySettingActivity.toyUpToDate = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_up_to_date, "field 'toyUpToDate'", TextView.class);
        toySettingActivity.toyUpdate = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_update, "field 'toyUpdate'", TextView.class);
        toySettingActivity.rlToyUpload = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_toy_upload, "field 'rlToyUpload'", RelativeLayout.class);
        toySettingActivity.deleteToy = (TextView) Utils.findRequiredViewAsType(view, R.id.delete_toy, "field 'deleteToy'", TextView.class);
        toySettingActivity.vPinControlTop = (ImageView) Utils.findRequiredViewAsType(view, R.id.v_pin_control_top, "field 'vPinControlTop'", ImageView.class);
        toySettingActivity.tvPinControl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pin_control, "field 'tvPinControl'", TextView.class);
        toySettingActivity.ivPinControlStatus = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pin_control_status, "field 'ivPinControlStatus'", ImageView.class);
        toySettingActivity.tvPinControlStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pin_control_status, "field 'tvPinControlStatus'", TextView.class);
        toySettingActivity.ivPinControl = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pin_control, "field 'ivPinControl'", ImageView.class);
        toySettingActivity.rlPinControl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_pin_control, "field 'rlPinControl'", RelativeLayout.class);
        toySettingActivity.settingSexMachineUpliftTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.setting_sex_machine_uplift_title, "field 'settingSexMachineUpliftTitle'", TextView.class);
        toySettingActivity.sexMachineNewFeatureDot = (ImageView) Utils.findRequiredViewAsType(view, R.id.sex_machine_new_feature_dot, "field 'sexMachineNewFeatureDot'", ImageView.class);
        toySettingActivity.settingSexMachineUplift = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_sex_machine_uplift, "field 'settingSexMachineUplift'", RelativeLayout.class);
        toySettingActivity.settingSerialNum = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_serial_num, "field 'settingSerialNum'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToySettingActivity toySettingActivity = this.a;
        if (toySettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toySettingActivity.actionbar = null;
        toySettingActivity.toyReName = null;
        toySettingActivity.settingName = null;
        toySettingActivity.settingProgram = null;
        toySettingActivity.settingFunction = null;
        toySettingActivity.vSettingFunctionTop = null;
        toySettingActivity.ivFunRedDot = null;
        toySettingActivity.tvCurrMode = null;
        toySettingActivity.vSettingProgramTop = null;
        toySettingActivity.settingProgramTitle = null;
        toySettingActivity.settingLedTitle = null;
        toySettingActivity.settingAutoSwith = null;
        toySettingActivity.settingRunLastLevel = null;
        toySettingActivity.settingLedSwitch = null;
        toySettingActivity.llSettingLedLayout = null;
        toySettingActivity.llSettingToyReconnect = null;
        toySettingActivity.tvToyTurnOff = null;
        toySettingActivity.tvToyLastLeven = null;
        toySettingActivity.vLedColor = null;
        toySettingActivity.tvLedColor = null;
        toySettingActivity.rlLedColor = null;
        toySettingActivity.tvLedColorLeft = null;
        toySettingActivity.tvDepthControl = null;
        toySettingActivity.rlDepthControl = null;
        toySettingActivity.tvDepthControlStatus = null;
        toySettingActivity.ivDepthControl = null;
        toySettingActivity.settingStrengthTitle = null;
        toySettingActivity.settingStrength = null;
        toySettingActivity.roundViewSettingTip = null;
        toySettingActivity.ivThreshold = null;
        toySettingActivity.settingThresholdTitle = null;
        toySettingActivity.settingThreshold = null;
        toySettingActivity.vAutoSwith = null;
        toySettingActivity.vRunLastLevel = null;
        toySettingActivity.vLedSwitch = null;
        toySettingActivity.tvToyDisconnectShow = null;
        toySettingActivity.vDepthControlTop = null;
        toySettingActivity.vLedColorTop = null;
        toySettingActivity.tvToyFirmware = null;
        toySettingActivity.toyUpToDate = null;
        toySettingActivity.toyUpdate = null;
        toySettingActivity.rlToyUpload = null;
        toySettingActivity.deleteToy = null;
        toySettingActivity.vPinControlTop = null;
        toySettingActivity.tvPinControl = null;
        toySettingActivity.ivPinControlStatus = null;
        toySettingActivity.tvPinControlStatus = null;
        toySettingActivity.ivPinControl = null;
        toySettingActivity.rlPinControl = null;
        toySettingActivity.settingSexMachineUpliftTitle = null;
        toySettingActivity.sexMachineNewFeatureDot = null;
        toySettingActivity.settingSexMachineUplift = null;
        toySettingActivity.settingSerialNum = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}

package com.wear.main.toy.pin;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ToyPinSettingActivity_ViewBinding implements Unbinder {
    public ToyPinSettingActivity a;

    @UiThread
    public ToyPinSettingActivity_ViewBinding(ToyPinSettingActivity toyPinSettingActivity, View view) {
        this.a = toyPinSettingActivity;
        toyPinSettingActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        toyPinSettingActivity.enablePin = (TextView) Utils.findRequiredViewAsType(view, R.id.enable_pin, "field 'enablePin'", TextView.class);
        toyPinSettingActivity.disablePin = (TextView) Utils.findRequiredViewAsType(view, R.id.disable_pin, "field 'disablePin'", TextView.class);
        toyPinSettingActivity.changePin = (TextView) Utils.findRequiredViewAsType(view, R.id.change_pin, "field 'changePin'", TextView.class);
        toyPinSettingActivity.llSecurityPin = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_security_pin, "field 'llSecurityPin'", LinearLayout.class);
        toyPinSettingActivity.tvPinSuccess = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pin_success, "field 'tvPinSuccess'", TextView.class);
        toyPinSettingActivity.setSuccessOk = (TextView) Utils.findRequiredViewAsType(view, R.id.set_success_ok, "field 'setSuccessOk'", TextView.class);
        toyPinSettingActivity.llSetPinSuccess = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_set_pin_success, "field 'llSetPinSuccess'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyPinSettingActivity toyPinSettingActivity = this.a;
        if (toyPinSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyPinSettingActivity.actionbar = null;
        toyPinSettingActivity.enablePin = null;
        toyPinSettingActivity.disablePin = null;
        toyPinSettingActivity.changePin = null;
        toyPinSettingActivity.llSecurityPin = null;
        toyPinSettingActivity.tvPinSuccess = null;
        toyPinSettingActivity.setSuccessOk = null;
        toyPinSettingActivity.llSetPinSuccess = null;
    }
}

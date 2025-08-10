package com.wear.main.toy.pin;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ToyPinSetCodeActivity_ViewBinding implements Unbinder {
    public ToyPinSetCodeActivity a;

    @UiThread
    public ToyPinSetCodeActivity_ViewBinding(ToyPinSetCodeActivity toyPinSetCodeActivity, View view) {
        this.a = toyPinSetCodeActivity;
        toyPinSetCodeActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        toyPinSetCodeActivity.tip = (TextView) Utils.findRequiredViewAsType(view, R.id.tip, "field 'tip'", TextView.class);
        toyPinSetCodeActivity.edPassword1 = (EditText) Utils.findRequiredViewAsType(view, R.id.password1, "field 'edPassword1'", EditText.class);
        toyPinSetCodeActivity.point1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point1, "field 'point1'", ImageView.class);
        toyPinSetCodeActivity.edPassword2 = (EditText) Utils.findRequiredViewAsType(view, R.id.password2, "field 'edPassword2'", EditText.class);
        toyPinSetCodeActivity.point2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point2, "field 'point2'", ImageView.class);
        toyPinSetCodeActivity.edPassword3 = (EditText) Utils.findRequiredViewAsType(view, R.id.password3, "field 'edPassword3'", EditText.class);
        toyPinSetCodeActivity.point3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point3, "field 'point3'", ImageView.class);
        toyPinSetCodeActivity.edPassword4 = (EditText) Utils.findRequiredViewAsType(view, R.id.password4, "field 'edPassword4'", EditText.class);
        toyPinSetCodeActivity.point4 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point4, "field 'point4'", ImageView.class);
        toyPinSetCodeActivity.edPassword5 = (EditText) Utils.findRequiredViewAsType(view, R.id.password5, "field 'edPassword5'", EditText.class);
        toyPinSetCodeActivity.point5 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point5, "field 'point5'", ImageView.class);
        toyPinSetCodeActivity.edPassword6 = (EditText) Utils.findRequiredViewAsType(view, R.id.password6, "field 'edPassword6'", EditText.class);
        toyPinSetCodeActivity.point6 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point6, "field 'point6'", ImageView.class);
        toyPinSetCodeActivity.passwordfild = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.passwordfild, "field 'passwordfild'", LinearLayout.class);
        toyPinSetCodeActivity.kLayout1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.k_layout1, "field 'kLayout1'", LinearLayout.class);
        toyPinSetCodeActivity.kLayout2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.k_layout2, "field 'kLayout2'", LinearLayout.class);
        toyPinSetCodeActivity.errorTip = (TextView) Utils.findRequiredViewAsType(view, R.id.error_tip, "field 'errorTip'", TextView.class);
        toyPinSetCodeActivity.inputBottomBar = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.input_bottom_bar, "field 'inputBottomBar'", LinearLayout.class);
        toyPinSetCodeActivity.inputCode = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.input_code, "field 'inputCode'", LinearLayout.class);
        toyPinSetCodeActivity.tvPinSuccess = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pin_success, "field 'tvPinSuccess'", TextView.class);
        toyPinSetCodeActivity.setSuccessOk = (TextView) Utils.findRequiredViewAsType(view, R.id.set_success_ok, "field 'setSuccessOk'", TextView.class);
        toyPinSetCodeActivity.llSetPinSuccess = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_set_pin_success, "field 'llSetPinSuccess'", LinearLayout.class);
        toyPinSetCodeActivity.tvPinFail = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pin_fail, "field 'tvPinFail'", TextView.class);
        toyPinSetCodeActivity.setFailOk = (TextView) Utils.findRequiredViewAsType(view, R.id.set_fail_ok, "field 'setFailOk'", TextView.class);
        toyPinSetCodeActivity.llSetPinFail = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_set_pin_fail, "field 'llSetPinFail'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyPinSetCodeActivity toyPinSetCodeActivity = this.a;
        if (toyPinSetCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyPinSetCodeActivity.actionbar = null;
        toyPinSetCodeActivity.tip = null;
        toyPinSetCodeActivity.edPassword1 = null;
        toyPinSetCodeActivity.point1 = null;
        toyPinSetCodeActivity.edPassword2 = null;
        toyPinSetCodeActivity.point2 = null;
        toyPinSetCodeActivity.edPassword3 = null;
        toyPinSetCodeActivity.point3 = null;
        toyPinSetCodeActivity.edPassword4 = null;
        toyPinSetCodeActivity.point4 = null;
        toyPinSetCodeActivity.edPassword5 = null;
        toyPinSetCodeActivity.point5 = null;
        toyPinSetCodeActivity.edPassword6 = null;
        toyPinSetCodeActivity.point6 = null;
        toyPinSetCodeActivity.passwordfild = null;
        toyPinSetCodeActivity.kLayout1 = null;
        toyPinSetCodeActivity.kLayout2 = null;
        toyPinSetCodeActivity.errorTip = null;
        toyPinSetCodeActivity.inputBottomBar = null;
        toyPinSetCodeActivity.inputCode = null;
        toyPinSetCodeActivity.tvPinSuccess = null;
        toyPinSetCodeActivity.setSuccessOk = null;
        toyPinSetCodeActivity.llSetPinSuccess = null;
        toyPinSetCodeActivity.tvPinFail = null;
        toyPinSetCodeActivity.setFailOk = null;
        toyPinSetCodeActivity.llSetPinFail = null;
    }
}

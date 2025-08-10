package com.wear.main.account;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class PasscodeActivity_ViewBinding implements Unbinder {
    public PasscodeActivity a;

    @UiThread
    public PasscodeActivity_ViewBinding(PasscodeActivity passcodeActivity, View view) {
        this.a = passcodeActivity;
        passcodeActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionBar'", MyActionBar.class);
        passcodeActivity.passcodeEnable = (Button) Utils.findRequiredViewAsType(view, R.id.passcode_enable, "field 'passcodeEnable'", Button.class);
        passcodeActivity.passcodeChange = (Button) Utils.findRequiredViewAsType(view, R.id.passcode_change, "field 'passcodeChange'", Button.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PasscodeActivity passcodeActivity = this.a;
        if (passcodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        passcodeActivity.actionBar = null;
        passcodeActivity.passcodeEnable = null;
        passcodeActivity.passcodeChange = null;
    }
}

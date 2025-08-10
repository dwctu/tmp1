package com.wear.main.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class MyAccountActivity_ViewBinding implements Unbinder {
    public MyAccountActivity a;

    @UiThread
    public MyAccountActivity_ViewBinding(MyAccountActivity myAccountActivity, View view) {
        this.a = myAccountActivity;
        myAccountActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        myAccountActivity.settingChangePassword = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_change_password, "field 'settingChangePassword'", RelativeLayout.class);
        myAccountActivity.settingPasscodeSettings = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_passcode_settings, "field 'settingPasscodeSettings'", RelativeLayout.class);
        myAccountActivity.changeReddot = Utils.findRequiredView(view, R.id.my_account_reddot_change, "field 'changeReddot'");
        myAccountActivity.settingDeleteAccount = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_delete_account, "field 'settingDeleteAccount'", RelativeLayout.class);
        myAccountActivity.actionbar_back = (ImageView) Utils.findRequiredViewAsType(view, R.id.actionbar_back, "field 'actionbar_back'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyAccountActivity myAccountActivity = this.a;
        if (myAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        myAccountActivity.actionbar = null;
        myAccountActivity.settingChangePassword = null;
        myAccountActivity.settingPasscodeSettings = null;
        myAccountActivity.changeReddot = null;
        myAccountActivity.settingDeleteAccount = null;
        myAccountActivity.actionbar_back = null;
    }
}

package com.wear.main.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class LockActivity_ViewBinding implements Unbinder {
    public LockActivity a;

    @UiThread
    public LockActivity_ViewBinding(LockActivity lockActivity, View view) {
        this.a = lockActivity;
        lockActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionBar'", MyActionBar.class);
        lockActivity.tip = (TextView) Utils.findRequiredViewAsType(view, R.id.tip, "field 'tip'", TextView.class);
        lockActivity.relativeLayout1 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.relativeLayout1, "field 'relativeLayout1'", RelativeLayout.class);
        lockActivity.edPassword1 = (EditText) Utils.findRequiredViewAsType(view, R.id.password1, "field 'edPassword1'", EditText.class);
        lockActivity.point1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point1, "field 'point1'", ImageView.class);
        lockActivity.edPassword2 = (EditText) Utils.findRequiredViewAsType(view, R.id.password2, "field 'edPassword2'", EditText.class);
        lockActivity.point2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point2, "field 'point2'", ImageView.class);
        lockActivity.edPassword3 = (EditText) Utils.findRequiredViewAsType(view, R.id.password3, "field 'edPassword3'", EditText.class);
        lockActivity.point3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point3, "field 'point3'", ImageView.class);
        lockActivity.edPassword4 = (EditText) Utils.findRequiredViewAsType(view, R.id.password4, "field 'edPassword4'", EditText.class);
        lockActivity.point4 = (ImageView) Utils.findRequiredViewAsType(view, R.id.point4, "field 'point4'", ImageView.class);
        lockActivity.passwordfild = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.passwordfild, "field 'passwordfild'", LinearLayout.class);
        lockActivity.noticeForgotBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.notice_forgot_btn, "field 'noticeForgotBtn'", TextView.class);
        lockActivity.startFinger = (ImageView) Utils.findRequiredViewAsType(view, R.id.start_finger, "field 'startFinger'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LockActivity lockActivity = this.a;
        if (lockActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        lockActivity.actionBar = null;
        lockActivity.tip = null;
        lockActivity.relativeLayout1 = null;
        lockActivity.edPassword1 = null;
        lockActivity.point1 = null;
        lockActivity.edPassword2 = null;
        lockActivity.point2 = null;
        lockActivity.edPassword3 = null;
        lockActivity.point3 = null;
        lockActivity.edPassword4 = null;
        lockActivity.point4 = null;
        lockActivity.passwordfild = null;
        lockActivity.noticeForgotBtn = null;
        lockActivity.startFinger = null;
    }
}

package com.wear.main.account.login;

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
public class ForgetPassActivity_ViewBinding implements Unbinder {
    public ForgetPassActivity a;

    @UiThread
    public ForgetPassActivity_ViewBinding(ForgetPassActivity forgetPassActivity, View view) {
        this.a = forgetPassActivity;
        forgetPassActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionBar'", MyActionBar.class);
        forgetPassActivity.email = (EditText) Utils.findRequiredViewAsType(view, R.id.email, "field 'email'", EditText.class);
        forgetPassActivity.emailContentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.email_content_delete, "field 'emailContentDelete'", ImageView.class);
        forgetPassActivity.tvSendVerificationCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_send_verification_code, "field 'tvSendVerificationCode'", TextView.class);
        forgetPassActivity.llVerificationCode = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_verification_code, "field 'llVerificationCode'", LinearLayout.class);
        forgetPassActivity.verificationCode = (EditText) Utils.findRequiredViewAsType(view, R.id.verification_code, "field 'verificationCode'", EditText.class);
        forgetPassActivity.verificationCodeContentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.verification_code_content_delete, "field 'verificationCodeContentDelete'", ImageView.class);
        forgetPassActivity.verificationCodeShow = (ImageView) Utils.findRequiredViewAsType(view, R.id.verification_code_show, "field 'verificationCodeShow'", ImageView.class);
        forgetPassActivity.sendEmailBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.send_email_btn, "field 'sendEmailBtn'", TextView.class);
        forgetPassActivity.actionbarBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.actionbar_back, "field 'actionbarBack'", ImageView.class);
        forgetPassActivity.errorTip = (TextView) Utils.findRequiredViewAsType(view, R.id.error_tip, "field 'errorTip'", TextView.class);
        forgetPassActivity.errorCodeTip = (TextView) Utils.findRequiredViewAsType(view, R.id.error_code_tip, "field 'errorCodeTip'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ForgetPassActivity forgetPassActivity = this.a;
        if (forgetPassActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        forgetPassActivity.actionBar = null;
        forgetPassActivity.email = null;
        forgetPassActivity.emailContentDelete = null;
        forgetPassActivity.tvSendVerificationCode = null;
        forgetPassActivity.llVerificationCode = null;
        forgetPassActivity.verificationCode = null;
        forgetPassActivity.verificationCodeContentDelete = null;
        forgetPassActivity.verificationCodeShow = null;
        forgetPassActivity.sendEmailBtn = null;
        forgetPassActivity.actionbarBack = null;
        forgetPassActivity.errorTip = null;
        forgetPassActivity.errorCodeTip = null;
    }
}

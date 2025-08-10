package com.wear.main.account.login;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class SignUpActivity_ViewBinding implements Unbinder {
    public SignUpActivity a;

    @UiThread
    public SignUpActivity_ViewBinding(SignUpActivity signUpActivity, View view) {
        this.a = signUpActivity;
        signUpActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionBar'", MyActionBar.class);
        signUpActivity.userName = (EditText) Utils.findRequiredViewAsType(view, R.id.nickname, "field 'userName'", EditText.class);
        signUpActivity.nicknameContentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.nickname_content_delete, "field 'nicknameContentDelete'", ImageView.class);
        signUpActivity.email = (EditText) Utils.findRequiredViewAsType(view, R.id.email, "field 'email'", EditText.class);
        signUpActivity.emailContentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.email_content_delete, "field 'emailContentDelete'", ImageView.class);
        signUpActivity.password = (EditText) Utils.findRequiredViewAsType(view, R.id.password, "field 'password'", EditText.class);
        signUpActivity.passwordContentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.password_content_delete, "field 'passwordContentDelete'", ImageView.class);
        signUpActivity.passwordContentShow = (ImageView) Utils.findRequiredViewAsType(view, R.id.password_content_show, "field 'passwordContentShow'", ImageView.class);
        signUpActivity.signUpBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.signUp_btn, "field 'signUpBtn'", TextView.class);
        signUpActivity.privacyCbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.privacy_cbox, "field 'privacyCbox'", CheckBox.class);
        signUpActivity.webLink = (TextView) Utils.findRequiredViewAsType(view, R.id.web_link, "field 'webLink'", TextView.class);
        signUpActivity.rootLayout = Utils.findRequiredView(view, R.id.root_layout, "field 'rootLayout'");
        signUpActivity.tvNameNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name_notice, "field 'tvNameNotice'", TextView.class);
        signUpActivity.tvEmailNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_email_notice, "field 'tvEmailNotice'", TextView.class);
        signUpActivity.tvPasswordNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_password_notice, "field 'tvPasswordNotice'", TextView.class);
        signUpActivity.actionbarBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.actionbar_back, "field 'actionbarBack'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SignUpActivity signUpActivity = this.a;
        if (signUpActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signUpActivity.actionBar = null;
        signUpActivity.userName = null;
        signUpActivity.nicknameContentDelete = null;
        signUpActivity.email = null;
        signUpActivity.emailContentDelete = null;
        signUpActivity.password = null;
        signUpActivity.passwordContentDelete = null;
        signUpActivity.passwordContentShow = null;
        signUpActivity.signUpBtn = null;
        signUpActivity.privacyCbox = null;
        signUpActivity.webLink = null;
        signUpActivity.rootLayout = null;
        signUpActivity.tvNameNotice = null;
        signUpActivity.tvEmailNotice = null;
        signUpActivity.tvPasswordNotice = null;
        signUpActivity.actionbarBack = null;
    }
}

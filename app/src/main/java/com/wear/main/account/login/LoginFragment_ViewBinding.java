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
import com.wear.widget.AnimationButton;
import com.wear.widget.loading.Loading;
import com.wear.widget.roundwidget.SkinRoundAutoRelativeLayout;

/* loaded from: classes3.dex */
public class LoginFragment_ViewBinding implements Unbinder {
    public LoginFragment a;

    @UiThread
    public LoginFragment_ViewBinding(LoginFragment loginFragment, View view) {
        this.a = loginFragment;
        loginFragment.topView = Utils.findRequiredView(view, R.id.top_view, "field 'topView'");
        loginFragment.email = (EditText) Utils.findRequiredViewAsType(view, R.id.email, "field 'email'", EditText.class);
        loginFragment.emailContentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.email_content_delete, "field 'emailContentDelete'", ImageView.class);
        loginFragment.password = (EditText) Utils.findRequiredViewAsType(view, R.id.password, "field 'password'", EditText.class);
        loginFragment.passwordContentShow = (ImageView) Utils.findRequiredViewAsType(view, R.id.password_content_show, "field 'passwordContentShow'", ImageView.class);
        loginFragment.forgetPasswordBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.forgetPassword_btn, "field 'forgetPasswordBtn'", TextView.class);
        loginFragment.signUpBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.signUp_btn, "field 'signUpBtn'", TextView.class);
        loginFragment.exploreBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.explore_btn, "field 'exploreBtn'", TextView.class);
        loginFragment.llPassword = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_password, "field 'llPassword'", LinearLayout.class);
        loginFragment.ivDeletePsw = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_delete_psw, "field 'ivDeletePsw'", ImageView.class);
        loginFragment.loginBtnLoading = (AnimationButton) Utils.findRequiredViewAsType(view, R.id.login_btn_loading, "field 'loginBtnLoading'", AnimationButton.class);
        loginFragment.loginBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.login_btn, "field 'loginBtn'", TextView.class);
        loginFragment.screanRootLayout = (SkinRoundAutoRelativeLayout) Utils.findRequiredViewAsType(view, R.id.screan_root_layout, "field 'screanRootLayout'", SkinRoundAutoRelativeLayout.class);
        loginFragment.loginBtnProgress = (Loading) Utils.findRequiredViewAsType(view, R.id.login_btn_Progress, "field 'loginBtnProgress'", Loading.class);
        loginFragment.webLink = (TextView) Utils.findRequiredViewAsType(view, R.id.web_link, "field 'webLink'", TextView.class);
        loginFragment.loginClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.login_close, "field 'loginClose'", ImageView.class);
        loginFragment.errorTip = (TextView) Utils.findRequiredViewAsType(view, R.id.error_tip, "field 'errorTip'", TextView.class);
        loginFragment.googleSignIv = (ImageView) Utils.findRequiredViewAsType(view, R.id.google_sign_iv, "field 'googleSignIv'", ImageView.class);
        loginFragment.loginAboveLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.login_above_layout, "field 'loginAboveLayout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LoginFragment loginFragment = this.a;
        if (loginFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        loginFragment.topView = null;
        loginFragment.email = null;
        loginFragment.emailContentDelete = null;
        loginFragment.password = null;
        loginFragment.passwordContentShow = null;
        loginFragment.forgetPasswordBtn = null;
        loginFragment.signUpBtn = null;
        loginFragment.exploreBtn = null;
        loginFragment.llPassword = null;
        loginFragment.ivDeletePsw = null;
        loginFragment.loginBtnLoading = null;
        loginFragment.loginBtn = null;
        loginFragment.screanRootLayout = null;
        loginFragment.loginBtnProgress = null;
        loginFragment.webLink = null;
        loginFragment.loginClose = null;
        loginFragment.errorTip = null;
        loginFragment.googleSignIv = null;
        loginFragment.loginAboveLayout = null;
    }
}

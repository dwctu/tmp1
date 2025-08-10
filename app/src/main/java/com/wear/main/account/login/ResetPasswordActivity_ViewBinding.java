package com.wear.main.account.login;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes3.dex */
public class ResetPasswordActivity_ViewBinding implements Unbinder {
    public ResetPasswordActivity a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ResetPasswordActivity a;

        public a(ResetPasswordActivity_ViewBinding resetPasswordActivity_ViewBinding, ResetPasswordActivity resetPasswordActivity) {
            this.a = resetPasswordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ResetPasswordActivity a;

        public b(ResetPasswordActivity_ViewBinding resetPasswordActivity_ViewBinding, ResetPasswordActivity resetPasswordActivity) {
            this.a = resetPasswordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ResetPasswordActivity a;

        public c(ResetPasswordActivity_ViewBinding resetPasswordActivity_ViewBinding, ResetPasswordActivity resetPasswordActivity) {
            this.a = resetPasswordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ResetPasswordActivity a;

        public d(ResetPasswordActivity_ViewBinding resetPasswordActivity_ViewBinding, ResetPasswordActivity resetPasswordActivity) {
            this.a = resetPasswordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ResetPasswordActivity a;

        public e(ResetPasswordActivity_ViewBinding resetPasswordActivity_ViewBinding, ResetPasswordActivity resetPasswordActivity) {
            this.a = resetPasswordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ResetPasswordActivity_ViewBinding(ResetPasswordActivity resetPasswordActivity, View view) {
        this.a = resetPasswordActivity;
        resetPasswordActivity.bar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'bar'", MyActionBar.class);
        resetPasswordActivity.etPassword1 = (EditText) Utils.findRequiredViewAsType(view, R.id.et_password_1, "field 'etPassword1'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_password_1_delete, "field 'ivPasswordDelete1' and method 'onClick'");
        resetPasswordActivity.ivPasswordDelete1 = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_password_1_delete, "field 'ivPasswordDelete1'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, resetPasswordActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_password_1_show, "field 'ivPasswordShow1' and method 'onClick'");
        resetPasswordActivity.ivPasswordShow1 = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_password_1_show, "field 'ivPasswordShow1'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, resetPasswordActivity));
        resetPasswordActivity.etPassword2 = (EditText) Utils.findRequiredViewAsType(view, R.id.et_password_2, "field 'etPassword2'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_password_2_delete, "field 'ivPasswordDelete2' and method 'onClick'");
        resetPasswordActivity.ivPasswordDelete2 = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_password_2_delete, "field 'ivPasswordDelete2'", ImageView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, resetPasswordActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_password_2_show, "field 'ivPasswordShow2' and method 'onClick'");
        resetPasswordActivity.ivPasswordShow2 = (ImageView) Utils.castView(viewFindRequiredView4, R.id.iv_password_2_show, "field 'ivPasswordShow2'", ImageView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, resetPasswordActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_confirm, "field 'btnConfirm' and method 'onClick'");
        resetPasswordActivity.btnConfirm = (TextView) Utils.castView(viewFindRequiredView5, R.id.btn_confirm, "field 'btnConfirm'", TextView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, resetPasswordActivity));
        resetPasswordActivity.actionbarBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.actionbar_back, "field 'actionbarBack'", ImageView.class);
        resetPasswordActivity.tvConfirmNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm_notice, "field 'tvConfirmNotice'", TextView.class);
        resetPasswordActivity.tvPasswordNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_password_notice, "field 'tvPasswordNotice'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ResetPasswordActivity resetPasswordActivity = this.a;
        if (resetPasswordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        resetPasswordActivity.bar = null;
        resetPasswordActivity.etPassword1 = null;
        resetPasswordActivity.ivPasswordDelete1 = null;
        resetPasswordActivity.ivPasswordShow1 = null;
        resetPasswordActivity.etPassword2 = null;
        resetPasswordActivity.ivPasswordDelete2 = null;
        resetPasswordActivity.ivPasswordShow2 = null;
        resetPasswordActivity.btnConfirm = null;
        resetPasswordActivity.actionbarBack = null;
        resetPasswordActivity.tvConfirmNotice = null;
        resetPasswordActivity.tvPasswordNotice = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}

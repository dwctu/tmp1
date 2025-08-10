package com.wear.main.account.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.CheckEmailCodeBean;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.ap2;
import dc.gm2;
import dc.kg3;
import dc.lg3;
import dc.pj3;
import dc.sg3;
import dc.th4;
import dc.ue3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class ForgetPassActivity extends BaseActivity implements View.OnClickListener, ap2 {
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionBar;

    @BindView(R.id.actionbar_back)
    public ImageView actionbarBack;
    public Disposable b;
    public gm2 c;

    @BindView(R.id.email)
    public EditText email;

    @BindView(R.id.email_content_delete)
    public ImageView emailContentDelete;

    @BindView(R.id.error_code_tip)
    public TextView errorCodeTip;

    @BindView(R.id.error_tip)
    public TextView errorTip;

    @BindView(R.id.ll_verification_code)
    public LinearLayout llVerificationCode;

    @BindView(R.id.send_email_btn)
    public TextView sendEmailBtn;

    @BindView(R.id.tv_send_verification_code)
    public TextView tvSendVerificationCode;

    @BindView(R.id.verification_code)
    public EditText verificationCode;

    @BindView(R.id.verification_code_content_delete)
    public ImageView verificationCodeContentDelete;

    @BindView(R.id.verification_code_show)
    public ImageView verificationCodeShow;
    public boolean d = false;
    public TextWatcher e = new a();
    public TextWatcher f = new b();

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WearUtils.e1(ForgetPassActivity.this.email.getText().toString())) {
                ForgetPassActivity.this.emailContentDelete.setVisibility(8);
                if (ForgetPassActivity.this.b == null || ForgetPassActivity.this.b.isDisposed()) {
                    ForgetPassActivity.this.E4(false);
                }
            } else {
                ForgetPassActivity.this.emailContentDelete.setVisibility(0);
                if (ForgetPassActivity.this.b == null || ForgetPassActivity.this.b.isDisposed()) {
                    if (ForgetPassActivity.this.w4()) {
                        ForgetPassActivity.this.E4(true);
                    } else {
                        ForgetPassActivity.this.E4(false);
                    }
                }
            }
            ForgetPassActivity.this.errorTip.setVisibility(8);
            ForgetPassActivity.this.D4();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WearUtils.e1(ForgetPassActivity.this.verificationCode.getText().toString())) {
                ForgetPassActivity.this.verificationCodeContentDelete.setVisibility(8);
                ForgetPassActivity.this.verificationCodeShow.setVisibility(8);
            } else {
                ForgetPassActivity.this.verificationCodeContentDelete.setVisibility(0);
                ForgetPassActivity.this.verificationCodeShow.setVisibility(0);
            }
            ForgetPassActivity.this.errorCodeTip.setVisibility(8);
            ForgetPassActivity.this.D4();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class c implements Consumer<Long> {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            ForgetPassActivity.this.tvSendVerificationCode.setText((this.a - l.longValue()) + "s");
            if (l.longValue() == this.a) {
                ForgetPassActivity.this.tvSendVerificationCode.setText(ah4.e(R.string.common_send));
                ForgetPassActivity.this.E4(!WearUtils.e1(r7.email.getText().toString()));
                ForgetPassActivity.this.b.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(View view, boolean z) {
        if (z || WearUtils.e1(this.email.getText().toString()) || w4()) {
            return;
        }
        this.errorTip.setVisibility(0);
        this.errorTip.setText(ah4.e(R.string.system_email_error));
    }

    public final void B4() {
        String strTrim = this.email.getText().toString().trim();
        this.a = strTrim;
        String strI = WearUtils.i(strTrim);
        this.a = strI;
        if (WearUtils.e1(strI) || !WearUtils.G2(this.a)) {
            sg3.i(this, R.string.system_email_error);
            return;
        }
        ue3.a(this.email, this);
        showLoadingProgress();
        HashMap map = new HashMap();
        map.put("email", this.a);
        map.put("useCode", Boolean.TRUE);
        map.put("language", lg3.c(lg3.e(this)));
        this.c.i(false, map);
    }

    public final void C4() {
        ue3.a(this.email, this);
        String strTrim = this.email.getText().toString().trim();
        this.a = strTrim;
        String strI = WearUtils.i(strTrim);
        this.a = strI;
        if (!WearUtils.e1(strI) && WearUtils.G2(this.a)) {
            B4();
        } else {
            this.errorTip.setVisibility(0);
            this.errorTip.setText(R.string.system_email_error);
        }
    }

    public final void D4() {
        boolean z = (WearUtils.e1(this.email.getText().toString().trim()) || WearUtils.e1(this.verificationCode.getText().toString().trim())) ? false : true;
        this.sendEmailBtn.setEnabled(z);
        this.sendEmailBtn.setTextColor(th4.b(this, z ? R.color.login_send_email_enable_text_color : R.color.login_send_email_disable_text_color));
    }

    public final void E4(boolean z) {
        this.tvSendVerificationCode.setEnabled(z);
        this.tvSendVerificationCode.setTextColor(th4.b(this, z ? R.color.login_forgot_password_send_text_enable_color : R.color.login_forgot_password_send_text_disable_color));
    }

    @Override // dc.ap2
    public void T2(boolean z, CheckEmailCodeBean checkEmailCodeBean) {
        dismissLoadingProgress();
        if (!checkEmailCodeBean.isResult()) {
            this.errorCodeTip.setVisibility(8);
            sg3.l(ah4.e(R.string.wrong_email_verification));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("email", this.a);
            bundle.putString(XHTMLText.CODE, this.verificationCode.getText().toString().trim());
            pj3.p(this, ResetPasswordActivity.class, 1, bundle);
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.k(this);
        this.mPresenter = this.c;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back /* 2131362006 */:
                finish();
                break;
            case R.id.email_content_delete /* 2131362596 */:
                this.email.setText("");
                this.emailContentDelete.setVisibility(8);
                break;
            case R.id.send_email_btn /* 2131364478 */:
                x4();
                break;
            case R.id.tv_send_verification_code /* 2131365301 */:
                C4();
                break;
            case R.id.verification_code_content_delete /* 2131365555 */:
                this.verificationCode.setText("");
                this.verificationCodeContentDelete.setVisibility(8);
                this.verificationCodeShow.setVisibility(8);
                break;
            case R.id.verification_code_show /* 2131365556 */:
                this.d = !this.d;
                EditText editText = this.verificationCode;
                editText.setText(editText.getText());
                EditText editText2 = this.verificationCode;
                editText2.setSelection(editText2.length());
                if (!this.d) {
                    this.verificationCode.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
                    this.verificationCodeShow.setImageResource(R.drawable.icon_eye_close);
                    break;
                } else {
                    this.verificationCode.setInputType(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA);
                    this.verificationCodeShow.setImageResource(R.drawable.icon_eye_open);
                    break;
                }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forget_pass_new);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        this.actionBar.getBarView().setBackgroundResource(R.color.transparent);
        this.actionBar.q(R.string.common_cancel);
        this.sendEmailBtn.setOnClickListener(this);
        this.emailContentDelete.setOnClickListener(this);
        this.email.addTextChangedListener(this.e);
        this.tvSendVerificationCode.setOnClickListener(this);
        E4(false);
        this.verificationCodeContentDelete.setOnClickListener(this);
        this.verificationCodeShow.setOnClickListener(this);
        this.actionbarBack.setOnClickListener(this);
        this.verificationCode.addTextChangedListener(this.f);
        this.llVerificationCode.setVisibility(0);
        this.tvSendVerificationCode.setVisibility(0);
        this.sendEmailBtn.setText(ah4.e(R.string.ds_button_next));
        this.email.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.dy1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.A4(view, z);
            }
        });
        D4();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        Disposable disposable = this.b;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.b.dispose();
    }

    @Override // dc.ap2
    public void s1(boolean z, BaseResponseBean baseResponseBean) {
        dismissLoadingProgress();
        if (!baseResponseBean.isResult()) {
            baseResponseBean.getCode();
            sg3.k(this, baseResponseBean.getMessage());
        } else {
            sg3.k(this, String.format(ah4.e(R.string.login_forget_emailSuccess), this.a));
            y4();
            E4(false);
        }
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        dismissLoadingProgress();
        this.errorTip.setVisibility(8);
        sg3.k(this, str);
    }

    public final boolean w4() {
        return WearUtils.G2(this.email.getText().toString().trim());
    }

    public final void x4() {
        showLoadingProgress();
        ue3.a(this.email, this);
        HashMap map = new HashMap();
        map.put("email", this.email.getText().toString().trim());
        map.put(XHTMLText.CODE, this.verificationCode.getText().toString().trim());
        this.c.h(false, map);
    }

    public final void y4() {
        Disposable disposable = this.b;
        if (disposable != null && !disposable.isDisposed()) {
            this.b.dispose();
        }
        this.b = Observable.intervalRange(1L, 60, 0L, 1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(60));
    }
}

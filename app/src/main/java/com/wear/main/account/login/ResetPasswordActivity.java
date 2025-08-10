package com.wear.main.account.login;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.im2;
import dc.kg3;
import dc.mp2;
import dc.sg3;
import dc.ue3;
import dc.xf3;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class ResetPasswordActivity extends BaseActivity implements mp2 {
    public String a;

    @BindView(R.id.actionbar_back)
    public ImageView actionbarBack;
    public String b;

    @BindView(R.id.actionbar)
    public MyActionBar bar;

    @BindView(R.id.btn_confirm)
    public TextView btnConfirm;
    public boolean c = false;
    public boolean d = false;
    public im2 e;

    @BindView(R.id.et_password_1)
    public EditText etPassword1;

    @BindView(R.id.et_password_2)
    public EditText etPassword2;

    @BindView(R.id.iv_password_1_delete)
    public ImageView ivPasswordDelete1;

    @BindView(R.id.iv_password_2_delete)
    public ImageView ivPasswordDelete2;

    @BindView(R.id.iv_password_1_show)
    public ImageView ivPasswordShow1;

    @BindView(R.id.iv_password_2_show)
    public ImageView ivPasswordShow2;

    @BindView(R.id.tv_confirm_notice)
    public TextView tvConfirmNotice;

    @BindView(R.id.tv_password_notice)
    public TextView tvPasswordNotice;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ResetPasswordActivity.this.ivPasswordDelete1.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
            ResetPasswordActivity.this.ivPasswordShow1.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
            ResetPasswordActivity.this.tvPasswordNotice.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ResetPasswordActivity.this.D4();
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ResetPasswordActivity.this.tvConfirmNotice.setVisibility(8);
            ResetPasswordActivity.this.ivPasswordDelete2.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
            ResetPasswordActivity.this.ivPasswordShow2.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ResetPasswordActivity.this.D4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x4(View view, boolean z) {
        if (WearUtils.e1(this.etPassword1.getText().toString().trim())) {
            this.tvPasswordNotice.setVisibility(8);
        } else if (WearUtils.t1(this.etPassword1.getText().toString().trim())) {
            this.tvPasswordNotice.setVisibility(8);
        } else {
            this.tvPasswordNotice.setVisibility(0);
            this.tvPasswordNotice.setText(ah4.e(R.string.signup_password_notice));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z4(View view, boolean z) {
        if (WearUtils.e1(this.etPassword2.getText().toString().trim())) {
            this.tvConfirmNotice.setVisibility(8);
        } else if (TextUtils.equals(this.etPassword1.getText().toString().trim(), this.etPassword2.getText().toString().trim())) {
            this.tvConfirmNotice.setVisibility(8);
        } else {
            this.tvConfirmNotice.setVisibility(0);
            this.tvConfirmNotice.setText(ah4.e(R.string.account_password_notEq));
        }
    }

    public final void C4() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ue3.a(this.etPassword2, this);
        String strTrim = this.etPassword1.getText().toString().trim();
        this.etPassword2.getText().toString().trim();
        showLoadingProgress();
        String strA = xf3.a(strTrim, "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883", "010001");
        HashMap map = new HashMap();
        map.put("email", this.b);
        map.put(XHTMLText.CODE, this.a);
        map.put("password", strA);
        this.e.h(false, map);
    }

    public final void D4() {
        String strTrim = this.etPassword1.getText().toString().trim();
        boolean z = WearUtils.t1(strTrim) && TextUtils.equals(strTrim, this.etPassword2.getText().toString().trim());
        if (z != this.btnConfirm.isEnabled()) {
            this.btnConfirm.setEnabled(z);
        }
    }

    @Override // dc.mp2
    public void F0(BaseResponseBean baseResponseBean) {
        dismissLoadingProgress();
        sg3.l(ah4.e(R.string.patterns_result_update_name));
        setResult(-1);
        finish();
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.b(this);
        this.mPresenter = this.e;
    }

    @OnClick({R.id.iv_password_1_delete, R.id.iv_password_2_delete, R.id.btn_confirm, R.id.iv_password_1_show, R.id.iv_password_2_show})
    public void onClick(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        int id = view.getId();
        if (id == R.id.btn_confirm) {
            C4();
        }
        switch (id) {
            case R.id.iv_password_1_delete /* 2131363229 */:
                this.etPassword1.setText("");
                break;
            case R.id.iv_password_1_show /* 2131363230 */:
                this.c = !this.c;
                EditText editText = this.etPassword1;
                editText.setText(editText.getText());
                EditText editText2 = this.etPassword1;
                editText2.setSelection(editText2.length());
                if (!this.c) {
                    this.etPassword1.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
                    this.ivPasswordShow1.setImageResource(R.drawable.icon_eye_close);
                    break;
                } else {
                    this.etPassword1.setInputType(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA);
                    this.ivPasswordShow1.setImageResource(R.drawable.icon_eye_open);
                    break;
                }
            case R.id.iv_password_2_delete /* 2131363231 */:
                this.etPassword2.setText("");
                break;
            case R.id.iv_password_2_show /* 2131363232 */:
                this.d = !this.d;
                EditText editText3 = this.etPassword2;
                editText3.setText(editText3.getText());
                EditText editText4 = this.etPassword2;
                editText4.setSelection(editText4.length());
                if (!this.d) {
                    this.etPassword2.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
                    this.ivPasswordShow2.setImageResource(R.drawable.icon_eye_close);
                    break;
                } else {
                    this.etPassword2.setInputType(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA);
                    this.ivPasswordShow2.setImageResource(R.drawable.icon_eye_open);
                    break;
                }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_reset_password_new);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.a = extras.getString(XHTMLText.CODE);
            this.b = extras.getString("email");
        }
        t4();
        this.actionbarBack.setOnClickListener(new View.OnClickListener() { // from class: dc.ty1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.B4(view);
            }
        });
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        super.showErrorMsg(str, z);
        dismissLoadingProgress();
        sg3.k(this, str);
    }

    public final void t4() {
        this.bar.setBackAction(new MyActionBar.f() { // from class: dc.uy1
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.v4(view);
            }
        });
        this.etPassword1.addTextChangedListener(new a());
        this.etPassword2.addTextChangedListener(new b());
        this.btnConfirm.setEnabled(false);
        this.etPassword1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.vy1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.x4(view, z);
            }
        });
        this.etPassword2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.sy1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.z4(view, z);
            }
        });
    }
}

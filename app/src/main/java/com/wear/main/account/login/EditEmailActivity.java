package com.wear.main.account.login;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.EditEmailEvent;
import com.wear.bean.response.BaseResponseStringBean;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.SignUpCodeBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.dialog.NewUserVerifyDialog;
import dc.ah4;
import dc.cs3;
import dc.is3;
import dc.jn2;
import dc.kg3;
import dc.lg3;
import dc.op2;
import dc.pj3;
import dc.sg3;
import dc.tn2;
import dc.ue3;
import dc.xf3;
import dc.yn2;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.NoSuchPaddingException;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class EditEmailActivity extends BaseActivity implements View.OnClickListener, op2 {
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionBar;

    @BindView(R.id.actionbar_back)
    public ImageView actionbarBack;
    public String b;
    public String c;
    public jn2 d;
    public TextWatcher e = new a();

    @BindView(R.id.email)
    public EditText email;

    @BindView(R.id.email_content_delete)
    public ImageView emailContentDelete;

    @BindView(R.id.send_email_btn)
    public TextView sendEmailBtn;

    @BindView(R.id.tv_email_notice)
    public TextView tv_email_notice;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditEmailActivity.this.tv_email_notice.setVisibility(8);
            if (WearUtils.e1(EditEmailActivity.this.email.getText().toString())) {
                EditEmailActivity.this.emailContentDelete.setVisibility(8);
                EditEmailActivity.this.sendEmailBtn.setEnabled(false);
            } else {
                EditEmailActivity.this.emailContentDelete.setVisibility(0);
                EditEmailActivity.this.sendEmailBtn.setEnabled(true);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements yn2<BaseResponseStringBean> {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseStringBean baseResponseStringBean) {
            EditEmailActivity.this.dissDialog();
            EditEmailActivity.this.u4(this.a);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            EditEmailActivity.this.dissDialog();
            sg3.k(EditEmailActivity.this.activity, netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class c implements is3.c {
        public c(EditEmailActivity editEmailActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            WearUtils.x.q("verifyemail_edit_click", null);
        }
    }

    public class d implements is3.d {
        public d() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            pj3.h(EditEmailActivity.this.activity, LoginActivity.class, "isChange", 2);
            EditEmailActivity.this.finish();
        }
    }

    @Override // dc.op2
    public void H(boolean z, GenTokenBean genTokenBean) {
    }

    @Override // dc.op2
    public void H0(boolean z, BaseResponseBean baseResponseBean) {
    }

    @Override // dc.op2
    public void f(boolean z, String str, String str2) {
    }

    @Override // dc.op2
    public void h(boolean z, QueryRemoteAccountInfoBean queryRemoteAccountInfoBean) {
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.v(this);
        this.mPresenter = this.d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.actionbar_back) {
            finish();
            return;
        }
        if (id == R.id.email_content_delete) {
            this.email.setText("");
            this.emailContentDelete.setVisibility(8);
        } else {
            if (id != R.id.send_email_btn) {
                return;
            }
            t4();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_email_new);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        this.actionBar.getBarView().setBackgroundResource(R.color.transparent);
        this.sendEmailBtn.setOnClickListener(this);
        this.emailContentDelete.setOnClickListener(this);
        this.actionbarBack.setOnClickListener(this);
        this.email.addTextChangedListener(this.e);
        this.b = getIntent().getStringExtra("userName");
        this.c = getIntent().getStringExtra("password");
        getIntent().getStringExtra("oldEmail");
    }

    public final void t4() {
        showDialog();
        String strTrim = this.email.getText().toString().trim();
        this.a = strTrim;
        String strF = WearUtils.f(strTrim);
        this.a = strF;
        if (WearUtils.G2(strF)) {
            ue3.a(this.email, this);
            this.d.j(false);
        } else {
            this.tv_email_notice.setVisibility(0);
            this.tv_email_notice.setText(R.string.system_email_error);
            dissDialog();
        }
    }

    public final void u4(String str) {
        EventBus.getDefault().post(new EditEmailEvent());
        is3.b bVar = new is3.b(this);
        bVar.e(str);
        bVar.d(new d());
        bVar.c(new c(this));
        bVar.u(R.id.tv_confirm);
        bVar.t(R.id.tv_skip);
        bVar.n(ah4.e(R.string.button_edit));
        bVar.o(ah4.e(R.string.button_login));
        NewUserVerifyDialog newUserVerifyDialog = (NewUserVerifyDialog) cs3.i(bVar, NewUserVerifyDialog.class);
        newUserVerifyDialog.setEditEmail(true);
        newUserVerifyDialog.show();
    }

    public final void v4(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("userName", WearUtils.f(str));
        map.put("password", str3);
        map.put("email", str2);
        map.put("pf", "remote-android");
        map.put("language", lg3.b(this));
        tn2.x(this).p("/api/account/updateEmail", map, new b(str2));
    }

    @Override // dc.op2
    public void w(boolean z, LoginUserBean loginUserBean) {
    }

    @Override // dc.op2
    public void x(boolean z, SignUpCodeBean signUpCodeBean) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        v4(this.b, this.a, xf3.a(this.c, signUpCodeBean.getModulus(), signUpCodeBean.getExponent()));
    }
}

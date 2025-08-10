package com.wear.main.account;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.bean.Setting;
import com.wear.bean.event.ApiisWeakPasswordEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.SettingDao;
import com.wear.main.account.login.ForgetPassActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.SignUpCodeBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ch3;
import dc.cs3;
import dc.eg3;
import dc.is3;
import dc.kg3;
import dc.nd3;
import dc.sg3;
import dc.tn2;
import dc.tz;
import dc.uo2;
import dc.vf3;
import dc.wg3;
import dc.xf3;
import dc.xl2;
import dc.ye3;
import dc.zd3;
import dc.zn2;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.roster.packet.RosterVer;

/* loaded from: classes3.dex */
public class ChangePasswordActivity extends BaseActivity implements uo2, View.OnClickListener {
    public MyApplication a;
    public EditText b;
    public EditText c;
    public EditText d;
    public TextView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public xl2 q;
    public Setting s;
    public boolean t;
    public EditText u;
    public Dialog w;
    public TextWatcher v = new b();
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChangePasswordActivity.this.showLoadingProgress();
            String string = ChangePasswordActivity.this.b.getText().toString();
            String string2 = ChangePasswordActivity.this.c.getText().toString();
            String string3 = ChangePasswordActivity.this.d.getText().toString();
            if (WearUtils.e1(string)) {
                ChangePasswordActivity.this.m.setVisibility(0);
                ChangePasswordActivity.this.m.setText(ah4.e(R.string.account_password_empty));
                ChangePasswordActivity.this.dismissLoadingProgress();
                return;
            }
            if (!string2.equals(string3)) {
                ChangePasswordActivity.this.o.setVisibility(0);
                ChangePasswordActivity.this.o.setText(ah4.e(R.string.account_password_notEq));
                ChangePasswordActivity.this.dismissLoadingProgress();
            } else if (!WearUtils.t1(string2)) {
                ChangePasswordActivity.this.n.setVisibility(0);
                ChangePasswordActivity.this.n.setText(ah4.e(R.string.signup_password_notice));
                ChangePasswordActivity.this.dismissLoadingProgress();
            } else {
                if (!ChangePasswordActivity.this.P4(string3)) {
                    ChangePasswordActivity.this.q.i(false);
                    return;
                }
                ChangePasswordActivity.this.o.setVisibility(0);
                ChangePasswordActivity.this.o.setText(ah4.e(R.string.password_is_weak1));
                ChangePasswordActivity.this.dismissLoadingProgress();
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string = ChangePasswordActivity.this.b.getText().toString();
            String string2 = ChangePasswordActivity.this.c.getText().toString();
            String string3 = ChangePasswordActivity.this.d.getText().toString();
            if (WearUtils.e1(string) || WearUtils.e1(string2) || WearUtils.e1(string3) || !WearUtils.t1(string2) || !TextUtils.equals(string2, string3)) {
                ChangePasswordActivity.this.e.setEnabled(false);
            } else {
                ChangePasswordActivity.this.e.setEnabled(true);
            }
            if (WearUtils.e1(string)) {
                ChangePasswordActivity.this.h.setVisibility(8);
                ChangePasswordActivity.this.l.setVisibility(8);
            } else {
                ChangePasswordActivity.this.h.setVisibility(0);
                ChangePasswordActivity.this.l.setVisibility(0);
            }
            if (WearUtils.e1(string2)) {
                ChangePasswordActivity.this.g.setVisibility(8);
                ChangePasswordActivity.this.k.setVisibility(8);
            } else {
                ChangePasswordActivity.this.g.setVisibility(0);
                ChangePasswordActivity.this.k.setVisibility(0);
            }
            if (WearUtils.e1(string3)) {
                ChangePasswordActivity.this.f.setVisibility(8);
                ChangePasswordActivity.this.j.setVisibility(8);
            } else {
                ChangePasswordActivity.this.f.setVisibility(0);
                ChangePasswordActivity.this.j.setVisibility(0);
            }
            if (ChangePasswordActivity.this.u == ChangePasswordActivity.this.b) {
                ChangePasswordActivity.this.m.setVisibility(8);
            } else if (ChangePasswordActivity.this.u == ChangePasswordActivity.this.c) {
                ChangePasswordActivity.this.n.setVisibility(8);
            } else if (ChangePasswordActivity.this.u == ChangePasswordActivity.this.d) {
                ChangePasswordActivity.this.o.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class c implements zn2<String> {
        public final /* synthetic */ BaseResponseBean a;
        public final /* synthetic */ String b;

        public c(BaseResponseBean baseResponseBean, String str) {
            this.a = baseResponseBean;
            this.b = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            ChangePasswordActivity.this.dismissLoadingProgress();
            GenTokenBean genTokenBean = (GenTokenBean) new Gson().fromJson(str, GenTokenBean.class);
            if (genTokenBean == null) {
                sg3.j(ChangePasswordActivity.this, R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
            }
            if (!genTokenBean.isResult() || genTokenBean.getData() == null) {
                sg3.k(ChangePasswordActivity.this, genTokenBean.getMessage());
                return;
            }
            eg3.i(ChangePasswordActivity.this.a, "gen_token_Key", nd3.u(genTokenBean.getData().getGtoken()));
            eg3.i(ChangePasswordActivity.this.a, "r_token_Key", nd3.u(genTokenBean.getData().getRtoken()));
            WearUtils.s = nd3.u(genTokenBean.getData().getGtoken());
            WearUtils.t = nd3.u(genTokenBean.getData().getRtoken());
            WearUtils.w2(genTokenBean.getData().getX(), genTokenBean.getData().getY());
            eg3.i(ChangePasswordActivity.this.a, "xmpp_password", nd3.u(ChangePasswordActivity.this.c.getText().toString()));
            sg3.k(ChangePasswordActivity.this, this.a.getMessage());
            zd3.f("userName", this.b.toLowerCase());
            ChangePasswordActivity.this.finish();
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ChangePasswordActivity.this.dismissLoadingProgress();
            sg3.k(ChangePasswordActivity.this, netException.getMessage());
        }
    }

    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ChangePasswordActivity.this.w = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K4(View view, boolean z) {
        if (z) {
            Q4(this.b);
            return;
        }
        if (!WearUtils.e1(this.c.getText().toString()) && !WearUtils.e1(this.b.getText().toString())) {
            if (!this.c.getText().toString().equals(this.b.getText().toString())) {
                this.n.setVisibility(8);
                return;
            } else {
                this.n.setVisibility(0);
                this.n.setText(ah4.e(R.string.new_password_same_as_old_password));
                return;
            }
        }
        if (WearUtils.e1(this.b.getText().toString())) {
            this.m.setVisibility(8);
            this.m.setText(ah4.e(R.string.account_password_empty));
            this.n.setVisibility(8);
        } else if (WearUtils.e1(this.c.getText().toString())) {
            this.n.setVisibility(8);
        } else if (!this.c.getText().toString().equals(this.b.getText().toString())) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
            this.n.setText(ah4.e(R.string.new_password_same_as_old_password));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M4(View view, boolean z) {
        if (z) {
            Q4(this.c);
            return;
        }
        if (WearUtils.e1(this.c.getText().toString())) {
            this.n.setVisibility(8);
            return;
        }
        if (this.c.getText().toString().equals(zd3.b(this, "xmpp_email_simple_name")) || this.c.getText().toString().equals(ch3.n().o().getEmail())) {
            this.n.setVisibility(0);
            this.n.setText(ah4.e(R.string.password_is_weak1));
        } else if (this.c.getText().toString().equals(this.b.getText().toString())) {
            this.n.setVisibility(0);
            this.n.setText(ah4.e(R.string.new_password_same_as_old_password));
        } else if (WearUtils.t1(this.c.getText().toString())) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
            this.n.setText(ah4.e(R.string.signup_password_notice));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O4(View view, boolean z) {
        if (z) {
            Q4(this.d);
            return;
        }
        if (WearUtils.e1(this.d.getText().toString())) {
            this.o.setVisibility(8);
        } else if (this.c.getText().toString().equals(this.d.getText().toString())) {
            this.n.setVisibility(8);
        } else {
            this.o.setVisibility(0);
            this.o.setText(ah4.e(R.string.account_password_notEq));
        }
    }

    @Override // dc.uo2
    public void P2(boolean z, BaseResponseBean baseResponseBean) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (baseResponseBean == null) {
            dismissLoadingProgress();
            sg3.i(this, R.string.common_serverError);
            return;
        }
        if (!baseResponseBean.isResult()) {
            dismissLoadingProgress();
            sg3.k(this, baseResponseBean.getMessage());
            return;
        }
        if (this.t) {
            ye3.d("A0018", "");
        } else {
            ye3.d("A0020", "");
        }
        vf3.a("A0029", -1, -1);
        String strA = xf3.a(this.c.getText().toString(), "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883", "010001");
        HashMap map = new HashMap();
        Account accountU = WearUtils.y.u();
        String userName = accountU != null ? accountU.getUserName() : WearUtils.f(zd3.b(WearUtils.x, "xmpp_email_simple_name"));
        map.put("email", userName.toLowerCase());
        map.put("password", strA);
        map.put("pf", wg3.a());
        map.put(RosterVer.ELEMENT, WearUtils.q);
        map.put("signature", wg3.b(userName.toLowerCase() + "##" + strA));
        map.put("tag", "changePwd");
        map.put("sessionId", ye3.x());
        map.put("deviceId", tz.i());
        map.put("deviceName", Build.MODEL);
        tn2.x(WearUtils.x).l("/api/wear/genGtoken", map, new c(baseResponseBean, userName));
    }

    public final boolean P4(String str) {
        if (!WearUtils.e1(str)) {
            String userName = ch3.n().u().getUserName();
            String id = ch3.n().u().getId();
            if (str.equals(userName) || str.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void Q4(EditText editText) {
        this.u = editText;
    }

    public final void R4(EditText editText, ImageView imageView, Boolean bool) {
        editText.setText(editText.getText());
        editText.setSelection(editText.length());
        if (bool.booleanValue()) {
            editText.setInputType(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA);
            imageView.setImageResource(R.drawable.icon_eye_open);
        } else {
            editText.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
            imageView.setImageResource(R.drawable.icon_eye_close);
        }
    }

    public final void S4() {
        is3 is3VarJ = cs3.j(this, ah4.e(R.string.password_is_weak2));
        this.w = is3VarJ;
        is3VarJ.show();
        this.w.setOnDismissListener(new d());
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.w(this);
        this.mPresenter = this.q;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back /* 2131362006 */:
                finish();
                break;
            case R.id.forgetPassword_btn /* 2131362797 */:
                startActivity(new Intent(this, (Class<?>) ForgetPassActivity.class));
                break;
            case R.id.iv_delete_psw /* 2131363147 */:
                this.b.setText("");
                break;
            case R.id.iv_delete_psw_confirm /* 2131363148 */:
                this.d.setText("");
                break;
            case R.id.iv_delete_psw_new /* 2131363149 */:
                this.c.setText("");
                break;
            case R.id.password_confirm_show /* 2131364005 */:
                boolean z = !this.z;
                this.z = z;
                R4(this.d, this.f, Boolean.valueOf(z));
                break;
            case R.id.password_new_show /* 2131364009 */:
                boolean z2 = !this.y;
                this.y = z2;
                R4(this.c, this.g, Boolean.valueOf(z2));
                break;
            case R.id.password_old_show /* 2131364010 */:
                boolean z3 = !this.x;
                this.x = z3;
                R4(this.b, this.h, Boolean.valueOf(z3));
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_setting_password_new);
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        this.a = (MyApplication) getApplication();
        TextView textView = (TextView) findViewById(R.id.done_tv);
        this.e = textView;
        textView.setEnabled(false);
        this.m = (TextView) findViewById(R.id.error_old_tip);
        this.n = (TextView) findViewById(R.id.error_new_tip);
        this.o = (TextView) findViewById(R.id.error_confirm_tip);
        this.f = (ImageView) findViewById(R.id.password_confirm_show);
        this.g = (ImageView) findViewById(R.id.password_new_show);
        this.h = (ImageView) findViewById(R.id.password_old_show);
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.f.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.actionbar_back);
        this.i = imageView;
        imageView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.forgetPassword_btn);
        this.p = textView2;
        textView2.setOnClickListener(this);
        this.j = (ImageView) findViewById(R.id.iv_delete_psw_confirm);
        this.k = (ImageView) findViewById(R.id.iv_delete_psw_new);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_delete_psw);
        this.l = imageView2;
        imageView2.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.e.setOnClickListener(new a());
        this.b = (EditText) findViewById(R.id.current_pass);
        this.c = (EditText) findViewById(R.id.new_pass1);
        this.d = (EditText) findViewById(R.id.new_pass2);
        Setting settingS = this.a.S();
        this.s = settingS;
        if (settingS == null) {
            finish();
            return;
        }
        this.t = getIntent().getBooleanExtra("fromDialog", false);
        if (this.s.getWeakPasswordV() > this.s.getWeakPasswordRed()) {
            ye3.d("A0019", "");
        }
        Setting setting = this.s;
        setting.setWeakPasswordRed(setting.getWeakPasswordV());
        DaoUtils.getSettingDao().update((SettingDao) this.s);
        EventBus.getDefault().post(new ApiisWeakPasswordEvent());
        EventBus.getDefault().register(this);
        this.b.addTextChangedListener(this.v);
        this.c.addTextChangedListener(this.v);
        this.d.addTextChangedListener(this.v);
        this.b.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.ix1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.K4(view, z);
            }
        });
        this.c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.kx1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.M4(view, z);
            }
        });
        this.d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.jx1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.O4(view, z);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        dismissLoadingProgress();
        if (str.contains("[50019]")) {
            sg3.k(this, ah4.e(R.string.old_password_not_correct) + " [50019]");
            return;
        }
        if (str.contains("[50016]")) {
            sg3.k(this, ah4.e(R.string.new_password_same_as_old_password) + " [50016]");
            return;
        }
        if (str.contains("[50087]")) {
            S4();
        } else {
            sg3.k(this, str);
        }
    }

    @Override // dc.uo2
    public void x(boolean z, SignUpCodeBean signUpCodeBean) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String string = this.b.getText().toString();
        String string2 = this.c.getText().toString();
        String string3 = this.d.getText().toString();
        String modulus = signUpCodeBean.getModulus();
        String exponent = signUpCodeBean.getExponent();
        String strA = xf3.a(string, modulus, exponent);
        String strA2 = xf3.a(string2, modulus, exponent);
        String strA3 = xf3.a(string3, modulus, exponent);
        Account accountU = WearUtils.y.u();
        HashMap map = new HashMap();
        map.put("email", accountU.getId());
        map.put("password", strA);
        map.put("newPassword", strA2);
        map.put("newPasswordRepeat", strA3);
        this.q.h(false, map);
    }
}

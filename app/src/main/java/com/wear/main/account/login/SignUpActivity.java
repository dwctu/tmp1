package com.wear.main.account.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.PolicyListBean;
import com.wear.bean.User;
import com.wear.bean.XYBean;
import com.wear.bean.event.EditEmailEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.MainActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.SignUpCodeBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.dialog.NewUserVerifyDialog;
import dc.ah4;
import dc.bu3;
import dc.cs3;
import dc.do3;
import dc.eg3;
import dc.hu3;
import dc.is3;
import dc.jn2;
import dc.kg3;
import dc.lg3;
import dc.nd3;
import dc.op2;
import dc.pj3;
import dc.sg3;
import dc.ue3;
import dc.wg3;
import dc.xf3;
import dc.ye3;
import dc.zd3;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.roster.packet.RosterVer;

/* loaded from: classes3.dex */
public class SignUpActivity extends BaseActivity implements View.OnClickListener, op2, bu3 {
    public jn2 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionBar;

    @BindView(R.id.actionbar_back)
    public ImageView actionbarBack;
    public String c;
    public String d;
    public String e;

    @BindView(R.id.email)
    public EditText email;

    @BindView(R.id.email_content_delete)
    public ImageView emailContentDelete;
    public hu3 g;
    public String h;
    public Dialog k;
    public EditText l;

    @BindView(R.id.nickname_content_delete)
    public ImageView nicknameContentDelete;

    @BindView(R.id.password)
    public EditText password;

    @BindView(R.id.password_content_delete)
    public ImageView passwordContentDelete;

    @BindView(R.id.password_content_show)
    public ImageView passwordContentShow;

    @BindView(R.id.privacy_cbox)
    public CheckBox privacyCbox;

    @BindView(R.id.root_layout)
    public View rootLayout;

    @BindView(R.id.signUp_btn)
    public TextView signUpBtn;

    @BindView(R.id.tv_email_notice)
    public TextView tvEmailNotice;

    @BindView(R.id.tv_name_notice)
    public TextView tvNameNotice;

    @BindView(R.id.tv_password_notice)
    public TextView tvPasswordNotice;

    @BindView(R.id.nickname)
    public EditText userName;

    @BindView(R.id.web_link)
    public TextView webLink;
    public TextWatcher b = new a();
    public boolean f = false;
    public boolean i = false;
    public boolean j = false;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WearUtils.e1(SignUpActivity.this.userName.getText().toString())) {
                SignUpActivity.this.nicknameContentDelete.setVisibility(8);
            } else {
                SignUpActivity.this.nicknameContentDelete.setVisibility(0);
            }
            if (WearUtils.e1(SignUpActivity.this.email.getText().toString())) {
                SignUpActivity.this.emailContentDelete.setVisibility(8);
            } else {
                SignUpActivity.this.emailContentDelete.setVisibility(0);
            }
            if (WearUtils.e1(SignUpActivity.this.password.getText().toString())) {
                SignUpActivity.this.passwordContentDelete.setVisibility(8);
                SignUpActivity.this.passwordContentShow.setVisibility(8);
            } else {
                SignUpActivity.this.passwordContentDelete.setVisibility(0);
                SignUpActivity.this.passwordContentShow.setVisibility(0);
            }
            EditText editText = SignUpActivity.this.l;
            SignUpActivity signUpActivity = SignUpActivity.this;
            if (editText == signUpActivity.userName) {
                signUpActivity.tvNameNotice.setVisibility(8);
            } else {
                EditText editText2 = signUpActivity.l;
                SignUpActivity signUpActivity2 = SignUpActivity.this;
                if (editText2 == signUpActivity2.email) {
                    signUpActivity2.tvEmailNotice.setVisibility(8);
                } else {
                    EditText editText3 = signUpActivity2.l;
                    SignUpActivity signUpActivity3 = SignUpActivity.this;
                    if (editText3 == signUpActivity3.password) {
                        signUpActivity3.tvPasswordNotice.setVisibility(8);
                    }
                }
            }
            if (WearUtils.e1(SignUpActivity.this.userName.getText().toString()) || WearUtils.e1(SignUpActivity.this.email.getText().toString()) || WearUtils.e1(SignUpActivity.this.password.getText().toString())) {
                SignUpActivity.this.signUpBtn.setEnabled(false);
            } else if (SignUpActivity.this.B4(true) && SignUpActivity.this.y4(true) && !SignUpActivity.this.M4(true) && SignUpActivity.this.z4()) {
                SignUpActivity.this.signUpBtn.setEnabled(true);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SignUpActivity.this.B4(false);
        }
    }

    public class c extends ClickableSpan {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        public c(List list, String str) {
            this.a = list;
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.a.isEmpty()) {
                return;
            }
            String str = ((String) this.a.get(0)) + "?pf=" + wg3.a() + "&lang=" + this.b;
            String str2 = "协议URL====" + str;
            pj3.w(SignUpActivity.this, str);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(SignUpActivity.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
        }
    }

    public class d extends ClickableSpan {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        public d(List list, String str) {
            this.a = list;
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.a.size() >= 2) {
                pj3.w(SignUpActivity.this, ((String) this.a.get(1)) + "?pf=" + wg3.a() + "&lang=" + this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(SignUpActivity.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
        }
    }

    public class e extends ClickableSpan {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        public e(List list, String str) {
            this.a = list;
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.a.size() >= 3) {
                pj3.w(SignUpActivity.this, ((String) this.a.get(2)) + "?pf=" + wg3.a() + "&lang=" + this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(SignUpActivity.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
        }
    }

    public class f implements is3.c {
        public final /* synthetic */ GenTokenBean.DataBean a;

        public f(GenTokenBean.DataBean dataBean) {
            this.a = dataBean;
        }

        @Override // dc.is3.c
        public void doCancel() {
            WearUtils.x.q("signup_verifyemail_edit_click", null);
            SignUpActivity.this.dissDialog();
            Intent intent = new Intent(SignUpActivity.this.activity, (Class<?>) EditEmailActivity.class);
            intent.putExtra("userName", SignUpActivity.this.userName.getText().toString());
            intent.putExtra("password", SignUpActivity.this.password.getText().toString());
            intent.putExtra("oldEmail", this.a.getUserEmail());
            SignUpActivity.this.startActivity(intent);
        }
    }

    public class g implements is3.d {
        public g() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            SignUpActivity.this.dissDialog();
            pj3.h(SignUpActivity.this.activity, LoginActivity.class, "isChange", 2);
            SignUpActivity.this.finish();
        }
    }

    public class h implements DialogInterface.OnDismissListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            SignUpActivity.this.k = null;
        }
    }

    public class i implements DialogInterface.OnDismissListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            SignUpActivity.this.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F4(View view, boolean z) {
        if (z) {
            O4(this.userName);
        } else {
            z4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H4(View view, boolean z) {
        if (z) {
            O4(this.email);
        } else {
            y4(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J4(View view, boolean z) {
        if (z) {
            O4(this.password);
        } else {
            A4(true);
            M4(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L4(List list, List list2) {
        if (list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = "解密后的好友邮箱===" + ((User) list.get(i2)).getId();
                XYBean xYBeanQ0 = WearUtils.Q0();
                if (WearUtils.e1(((User) list.get(i2)).getRemoteAccountId()) && !WearUtils.e1(nd3.x(((User) list.get(i2)).getId(), xYBeanQ0.x, xYBeanQ0.y))) {
                    list2.add(nd3.x(((User) list.get(i2)).getId(), xYBeanQ0.x, xYBeanQ0.y));
                }
            }
        }
        if (list2.size() > 0) {
            this.a.l((String[]) list2.toArray(new String[list2.size()]));
        }
    }

    public final boolean A4(boolean z) {
        String string = this.password.getText().toString();
        if (!WearUtils.e1(string)) {
            if (WearUtils.t1(string)) {
                return true;
            }
            if (z) {
                this.tvPasswordNotice.setText(ah4.e(R.string.signup_password_notice));
                this.tvPasswordNotice.setVisibility(0);
            }
        }
        return false;
    }

    public final boolean B4(boolean z) {
        return true;
    }

    public final void C4(GenTokenBean.DataBean dataBean) {
        if (dataBean.isVerify() || TextUtils.isEmpty(dataBean.getPopupVer())) {
            this.a.k(true);
            return;
        }
        is3.b bVar = new is3.b(this);
        bVar.e(dataBean.getUserEmail());
        bVar.d(new g());
        bVar.c(new f(dataBean));
        bVar.g(true);
        bVar.u(R.id.tv_confirm);
        bVar.t(R.id.tv_skip);
        bVar.n(ah4.e(R.string.button_edit));
        bVar.o(ah4.e(R.string.button_login));
        is3 is3VarI = cs3.i(bVar, NewUserVerifyDialog.class);
        this.k = is3VarI;
        is3VarI.show();
        this.k.setOnDismissListener(new h());
    }

    public final void D4() {
        String strE = ah4.e(R.string.privacy_policy);
        String strE2 = ah4.e(R.string.terms_and_conditions);
        String strE3 = ah4.e(R.string.wokin_eula);
        String str = String.format(ah4.e(R.string.register_agree_license), strE, strE2, strE3);
        ArrayList arrayList = new ArrayList();
        PolicyListBean policyListBean = (PolicyListBean) new Gson().fromJson(eg3.h(this, "new_argement_list", ""), PolicyListBean.class);
        if (policyListBean != null && policyListBean.getData() != null && policyListBean.getData().size() > 0) {
            for (int i2 = 0; i2 < policyListBean.getData().size(); i2++) {
                arrayList.add(policyListBean.getData().get(i2).getUrl());
            }
        }
        String strC = lg3.c(lg3.e(this));
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.indexOf(strE);
        if (iIndexOf != -1) {
            spannableString.setSpan(new c(arrayList, strC), iIndexOf, strE.length() + iIndexOf, 17);
        }
        int iIndexOf2 = str.indexOf(strE2);
        if (iIndexOf2 != -1) {
            spannableString.setSpan(new d(arrayList, strC), iIndexOf2, strE2.length() + iIndexOf2, 17);
        }
        this.webLink.setMovementMethod(LinkMovementMethod.getInstance());
        this.webLink.setText(spannableString);
        this.webLink.setHighlightColor(0);
        int iIndexOf3 = str.indexOf(strE3);
        if (iIndexOf3 != -1) {
            spannableString.setSpan(new e(arrayList, strC), iIndexOf3, strE3.length() + iIndexOf3, 17);
        }
        this.webLink.setMovementMethod(LinkMovementMethod.getInstance());
        this.webLink.setText(spannableString);
    }

    @Override // dc.op2
    public void H(boolean z, GenTokenBean genTokenBean) {
        ye3.K(2);
        eg3.i(this.application, "gen_token_Key", nd3.u(genTokenBean.getData().getGtoken()));
        eg3.i(this.application, "r_token_Key", nd3.u(genTokenBean.getData().getRtoken()));
        WearUtils.s = nd3.u(genTokenBean.getData().getGtoken());
        WearUtils.t = nd3.u(genTokenBean.getData().getRtoken());
        WearUtils.w2(genTokenBean.getData().getX(), genTokenBean.getData().getY());
        ye3.K(4);
        C4(genTokenBean.getData());
    }

    @Override // dc.op2
    public void H0(boolean z, BaseResponseBean baseResponseBean) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        this.a.h(false, this.d, this.c);
    }

    @Override // dc.bu3
    public void I1(String str) {
        zd3.d(this.application, "xmpp_email_simple_name", this.e);
        WearUtils.k2(this.e);
        WearUtils.y.u().setName(this.e);
        hu3.v0(false);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setFlags(268468224);
        intent.putExtra("SignUpAction", true);
        startActivity(intent);
        dismissLoadingProgress();
        finish();
    }

    public final boolean M4(boolean z) {
        String string = this.password.getText().toString();
        if (!WearUtils.e1(string)) {
            String string2 = this.userName.getText().toString();
            String string3 = this.email.getText().toString();
            if (string.equals(string2) || string.equals(string3)) {
                if (!z) {
                    return true;
                }
                this.tvPasswordNotice.setText(ah4.e(R.string.password_is_weak1));
                this.tvPasswordNotice.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final void N4() {
        final List<User> listFindAll = DaoUtils.getUserDao().findAll();
        if (listFindAll == null || listFindAll.isEmpty()) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        new Thread(new Runnable() { // from class: dc.yy1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.L4(listFindAll, arrayList);
            }
        }).start();
    }

    public void O4(EditText editText) {
        this.l = editText;
    }

    public final void P4() {
        is3 is3VarJ = cs3.j(this, ah4.e(R.string.password_is_weak2));
        this.k = is3VarJ;
        is3VarJ.show();
        this.k.setOnDismissListener(new i());
    }

    public void Q4() {
        showLoadingProgress();
        String strTrim = this.email.getText().toString().trim();
        this.h = strTrim;
        this.h = WearUtils.i(strTrim);
        if (!B4(true)) {
            dismissLoadingProgress();
            return;
        }
        if (!z4()) {
            dismissLoadingProgress();
            return;
        }
        if (!y4(true)) {
            dismissLoadingProgress();
            return;
        }
        if (!A4(true)) {
            dismissLoadingProgress();
        } else if (M4(true)) {
            dismissLoadingProgress();
        } else {
            ue3.a(this.password, this);
            this.a.j(false);
        }
    }

    @Override // dc.op2
    public void f(boolean z, String str, String str2) {
        try {
            if (Integer.parseInt(str2) == 40) {
                dismissLoadingProgress();
                sg3.d(R.string.string_hava_regist);
                return;
            }
        } catch (Exception unused) {
        }
        dismissLoadingProgress();
        if (str.contains("[50087]")) {
            P4();
        } else {
            sg3.k(this, str);
        }
        ye3.p(0, z ? 6 : 3, str2, str);
    }

    @Override // dc.op2
    public void h(boolean z, QueryRemoteAccountInfoBean queryRemoteAccountInfoBean) {
        if (queryRemoteAccountInfoBean.getData() == null || queryRemoteAccountInfoBean.getData().getList() == null || queryRemoteAccountInfoBean.getData().getList().size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < queryRemoteAccountInfoBean.getData().getList().size(); i2++) {
            XYBean xYBeanQ0 = WearUtils.Q0();
            String str = "解密后的邮箱：" + nd3.k(queryRemoteAccountInfoBean.getData().getList().get(i2).getEmail(), xYBeanQ0.x, xYBeanQ0.y);
            arrayList.add(nd3.k(queryRemoteAccountInfoBean.getData().getList().get(i2).getEmail(), xYBeanQ0.x, xYBeanQ0.y));
            arrayList2.add(queryRemoteAccountInfoBean.getData().getList().get(i2).getRemoteAccountId());
        }
        List<User> listFindAll = DaoUtils.getUserDao().findAll();
        for (int i3 = 0; i3 < listFindAll.size(); i3++) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (WearUtils.e1(listFindAll.get(i3).getRemoteAccountId())) {
                    if (Objects.equals(listFindAll.get(i3).getId(), arrayList.get(i4))) {
                        listFindAll.get(i3).setRemoteAccountId((String) arrayList2.get(i4));
                        DaoUtils.getUserDao().update(listFindAll.get(i3));
                    }
                } else if (listFindAll.get(i3).getRemoteAccountId().equals(arrayList2.get(i4))) {
                    String str2 = "friendEmail====333" + ((String) arrayList.get(i4));
                    if (!Objects.equals(listFindAll.get(i3).getId(), arrayList.get(i4))) {
                        DaoUtils.updateFriendEmail(listFindAll.get(i3).getId(), (String) arrayList.get(i4));
                        DaoUtils.getUserDao().delT(listFindAll.get(i3));
                        listFindAll.get(i3).setId((String) arrayList.get(i4));
                        DaoUtils.getUserDao().add(listFindAll.get(i3));
                    }
                }
            }
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.s(this);
        this.mPresenter = this.a;
    }

    @Override // dc.bu3
    public void l3(String str) {
        dismissLoadingProgress();
        pj3.f(this, LoginActivity.class);
        finish();
        MyApplication.Q = 1;
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
            case R.id.nickname_content_delete /* 2131363924 */:
                this.userName.setText("");
                this.nicknameContentDelete.setVisibility(8);
                break;
            case R.id.password_content_delete /* 2131364006 */:
                this.password.setText("");
                this.passwordContentDelete.setVisibility(8);
                break;
            case R.id.password_content_show /* 2131364007 */:
                this.f = !this.f;
                EditText editText = this.password;
                editText.setText(editText.getText());
                EditText editText2 = this.password;
                editText2.setSelection(editText2.length());
                if (!this.f) {
                    this.password.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
                    this.passwordContentShow.setImageResource(R.drawable.icon_eye_open);
                    break;
                } else {
                    this.password.setInputType(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA);
                    this.passwordContentShow.setImageResource(R.drawable.icon_eye_close);
                    break;
                }
            case R.id.privacy_cbox /* 2131364137 */:
                if (!this.j) {
                    this.privacyCbox.setChecked(false);
                    sg3.i(this, R.string.signup_privacy_hint);
                    break;
                } else if (!this.i) {
                    this.i = true;
                    this.privacyCbox.setChecked(true);
                    break;
                } else {
                    this.i = false;
                    this.privacyCbox.setChecked(false);
                    break;
                }
            case R.id.signUp_btn /* 2131364557 */:
                Q4();
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.signup_new);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        this.signUpBtn.setOnClickListener(this);
        this.actionbarBack.setOnClickListener(this);
        this.userName.addTextChangedListener(this.b);
        this.email.addTextChangedListener(this.b);
        this.password.addTextChangedListener(this.b);
        this.userName.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.zy1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.F4(view, z);
            }
        });
        this.email.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.wy1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.H4(view, z);
            }
        });
        this.password.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.xy1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.J4(view, z);
            }
        });
        this.nicknameContentDelete.setOnClickListener(this);
        this.emailContentDelete.setOnClickListener(this);
        this.passwordContentDelete.setOnClickListener(this);
        this.passwordContentShow.setOnClickListener(this);
        this.userName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(99)});
        this.privacyCbox.setChecked(false);
        this.i = false;
        this.privacyCbox.setOnClickListener(this);
        D4();
        this.signUpBtn.setEnabled(false);
        this.privacyCbox.setOnCheckedChangeListener(new b());
        do3.d(this.userName, "^[A-Za-z0-9_-]{0,20}$", null);
        hu3.z(this).l(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hu3.z(this).c0(this);
        dismissLoadingProgress();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EditEmailEvent editEmailEvent) {
        Dialog dialog;
        if (editEmailEvent == null || (dialog = this.k) == null) {
            return;
        }
        dialog.dismiss();
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        dismissLoadingProgress();
        sg3.k(this, str);
    }

    @Override // dc.bu3
    public void u1(String str) {
        l3(str);
    }

    @Override // dc.op2
    public void w(boolean z, LoginUserBean loginUserBean) {
        ye3.K(5);
        this.e = this.d;
        ye3.L(loginUserBean);
        this.g = hu3.z(this);
        DaoUtils.upDateEmail(loginUserBean);
        synchronized (this) {
            N4();
            this.g.s(this.h, this.c, null, null);
        }
    }

    @Override // dc.op2
    public void x(boolean z, SignUpCodeBean signUpCodeBean) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        this.c = this.password.getText().toString();
        this.d = this.userName.getText().toString().trim();
        String strA = xf3.a(this.c, signUpCodeBean.getModulus(), signUpCodeBean.getExponent());
        HashMap map = new HashMap();
        map.put("email", this.h);
        map.put("password", strA);
        map.put("passwordRepeat", strA);
        if (WearUtils.e1(WearUtils.q)) {
            WearUtils.q = MyApplication.Q(this) == null ? "" : MyApplication.Q(this).versionName;
        }
        map.put(RosterVer.ELEMENT, WearUtils.q);
        map.put("language", lg3.b(this));
        map.put("nickName", this.d);
        map.put("gender", "");
        map.put("timezone", "");
        map.put("isNewApp", 1);
        map.put("agreePolicy", "ht");
        this.a.i(z, map);
    }

    public final boolean y4(boolean z) {
        String strI = WearUtils.i(this.email.getText().toString().trim());
        if (!WearUtils.e1(strI)) {
            if (WearUtils.G2(strI)) {
                return true;
            }
            if (z) {
                this.tvEmailNotice.setText(ah4.e(R.string.system_email_error));
                this.tvEmailNotice.setVisibility(0);
            }
        }
        return false;
    }

    public final boolean z4() {
        String lowerCase = this.userName.getText().toString().trim().toLowerCase();
        if (WearUtils.e1(lowerCase)) {
            return false;
        }
        if (lowerCase.length() >= 6 && lowerCase.length() <= 20) {
            return true;
        }
        this.tvNameNotice.setVisibility(0);
        this.tvNameNotice.setText(ah4.e(R.string.register_name_error));
        return false;
    }
}

package com.wear.main.account;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.ManagerRDBean;
import com.wear.bean.Setting;
import com.wear.bean.event.ApiisWeakPasswordEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.network.presenter.bean.UrlBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.dialog.NewEmailVerifyDialog;
import com.wear.widget.dialog.VerifyDialog;
import dc.ah4;
import dc.cs3;
import dc.ge3;
import dc.is3;
import dc.kg3;
import dc.pj3;
import dc.sg3;
import dc.tn2;
import dc.vf3;
import dc.yn2;
import dc.zd3;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class MyAccountActivity extends BaseActivity implements View.OnClickListener, ge3.b {
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.actionbar_back)
    public ImageView actionbar_back;
    public Dialog b;
    public Dialog c;

    @BindView(R.id.my_account_reddot_change)
    public View changeReddot;

    @BindView(R.id.setting_change_password)
    public RelativeLayout settingChangePassword;

    @BindView(R.id.setting_delete_account)
    public RelativeLayout settingDeleteAccount;

    @BindView(R.id.setting_passcode_settings)
    public RelativeLayout settingPasscodeSettings;

    public class a extends Dialog {
        public a(MyAccountActivity myAccountActivity, Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = -2;
            attributes.width = -1;
            attributes.gravity = 17;
            getWindow().setAttributes(attributes);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public b(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            pj3.f(MyAccountActivity.this, HelpActivity.class);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public c(MyAccountActivity myAccountActivity, Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class d implements is3.d {
        public d(MyAccountActivity myAccountActivity) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class e implements DialogInterface.OnDismissListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MyAccountActivity.this.b = null;
        }
    }

    public class f implements NewEmailVerifyDialog.c {
        public f() {
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void a() {
            MyAccountActivity.this.b.dismiss();
            vf3.a("A0024", 1, 2);
            MyAccountActivity.this.F4();
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void b(int i) {
            vf3.a("A0024", 1, 3);
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void c() {
            vf3.a("A0024", 1, 4);
        }
    }

    public class g implements yn2<UrlBean> {
        public g() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(UrlBean urlBean) {
            if (urlBean.getResult().booleanValue() && urlBean.getCode().equals(0) && urlBean.getData() != null) {
                MyAccountActivity.this.a = urlBean.getData().getUrl();
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(String str) {
        vf3.a("A0022", 3, 2);
        ge3.b(str, false, str, this);
    }

    public final void D4(Activity activity) {
        a aVar = new a(this, activity, R.style.dialog);
        aVar.setContentView(R.layout.dialog_cn_country_code);
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        TextView textView = (TextView) aVar.findViewById(R.id.ok);
        TextView textView2 = (TextView) aVar.findViewById(R.id.cancel);
        textView.setOnClickListener(new b(aVar));
        textView2.setOnClickListener(new c(this, aVar));
        aVar.show();
    }

    public void E4(String str) {
        is3.b bVar = new is3.b(this);
        bVar.d(new d(this));
        bVar.c(new is3.c() { // from class: dc.px1
            @Override // dc.is3.c
            public final void doCancel() {
                vf3.a("A0024", 1, 1);
            }
        });
        bVar.h(true);
        bVar.u(R.id.tv_confirm);
        bVar.t(R.id.tv_cancel);
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.o(ah4.e(R.string.button_verified));
        bVar.e(str);
        is3 is3VarI = cs3.i(bVar, NewEmailVerifyDialog.class);
        this.b = is3VarI;
        is3VarI.setOnDismissListener(new e());
        ((NewEmailVerifyDialog) this.b).setiVerifyEmailListener(new f());
        ((NewEmailVerifyDialog) this.b).setAutoSend(false);
        this.b.show();
        vf3.a("A0023", 1, -1);
    }

    public final void F4() {
        pj3.f(this, ChangePasswordActivity.class);
    }

    @Override // dc.ge3.b
    public void R1(int i, String str) {
        if (i == 50000) {
            sg3.l(ah4.e(R.string.error_verify_reach_limit));
        } else {
            sg3.l(str);
        }
    }

    @Override // dc.ge3.b
    public void i0(String str) {
        Dialog dialog = this.c;
        if (dialog != null && dialog.isShowing()) {
            this.c.dismiss();
        }
        E4(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back /* 2131362006 */:
                finish();
                break;
            case R.id.setting_change_password /* 2131364491 */:
                w4();
                break;
            case R.id.setting_delete_account /* 2131364496 */:
                if (!WearUtils.D) {
                    if (!TextUtils.isEmpty(this.a)) {
                        MyApplication.y0(this, this.a);
                        break;
                    }
                } else {
                    D4(this);
                    break;
                }
                break;
            case R.id.setting_passcode_settings /* 2131364508 */:
                pj3.f(this, PasscodeActivity.class);
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_account);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        this.settingChangePassword.setOnClickListener(this);
        this.settingPasscodeSettings.setOnClickListener(this);
        this.actionbar_back.setOnClickListener(this);
        this.settingDeleteAccount.setOnClickListener(new View.OnClickListener() { // from class: dc.hx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        y4();
        EventBus.getDefault().register(this);
        x4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ApiisWeakPasswordEvent apiisWeakPasswordEvent) {
        y4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    public final void w4() {
        if (VerifyDialog.h) {
            F4();
            return;
        }
        final String strF = WearUtils.f(zd3.b(this, "xmpp_email"));
        DaoUtils.getTestValueDao().save(strF, System.currentTimeMillis() + "", TestValueDao.SHOW_VERIFY_EMAIL_DIALOG_TYPE);
        is3 is3VarF = cs3.f(this, ah4.e(R.string.notif_titile), ah4.e(R.string.notification_verify_email2), ah4.e(R.string.button_verify), ah4.e(R.string.button_not_now_1), true, new is3.d() { // from class: dc.qx1
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.A4(strF);
            }
        }, new is3.c() { // from class: dc.rx1
            @Override // dc.is3.c
            public final void doCancel() {
                vf3.a("A0022", 3, 1);
            }
        });
        this.c = is3VarF;
        is3VarF.show();
        vf3.a("A0021", 3, -1);
    }

    public final void x4() {
        tn2.x(this).d("/app/delAccountUrl", new g());
    }

    public final void y4() {
        Setting settingS = this.application.S();
        if (settingS != null) {
            boolean z = settingS.getWeakPasswordV() > settingS.getWeakPasswordRed();
            ManagerRDBean.getManager().setShowChangePassword(z);
            this.changeReddot.setVisibility(z ? 0 : 8);
            ManagerRDBean.saveManager();
            EventBus.getDefault().post(ManagerRDBean.getManager());
        }
    }
}

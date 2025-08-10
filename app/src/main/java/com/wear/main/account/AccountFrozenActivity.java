package com.wear.main.account;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.request.RecoverAccountRequest;
import com.wear.main.account.login.LoginActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.ro2;
import dc.sg3;
import dc.tn2;
import dc.zn2;
import java.util.Date;

/* loaded from: classes3.dex */
public class AccountFrozenActivity extends BaseActivity {
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public boolean b;
    public String c;

    @BindView(R.id.image)
    public ImageView image;

    @BindView(R.id.linear)
    public LinearLayout linear;

    @BindView(R.id.recover_account)
    public Button recoverAccount;

    @BindView(R.id.text_1)
    public TextView text1;

    @BindView(R.id.text_2)
    public TextView text2;

    @BindView(R.id.title)
    public TextView title;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            AccountFrozenActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountFrozenActivity.this.x4();
        }
    }

    public class c implements zn2<String> {
        public c() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            BaseResponseBean baseResponseBean = (BaseResponseBean) ro2.a(str, BaseResponseBean.class);
            if (baseResponseBean != null) {
                if (baseResponseBean.isResult() && baseResponseBean.getCode().equals("0")) {
                    AccountFrozenActivity.this.y4();
                } else {
                    onError(new NetException(baseResponseBean.getCode(), baseResponseBean.getMessage()));
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            if (netException.getCode().equals(50116)) {
                sg3.l(netException.getMessage());
            } else {
                sg3.h(R.string.notification_activate_account_failed);
            }
        }
    }

    public class d implements Runnable {

        public class a extends Dialog {
            public a(d dVar, Context context, int i) {
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
                if (AccountFrozenActivity.this.b) {
                    AccountFrozenActivity.this.finish();
                } else {
                    AccountFrozenActivity.this.startActivity(new Intent(AccountFrozenActivity.this, (Class<?>) LoginActivity.class));
                    AccountFrozenActivity.this.finish();
                }
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = new a(this, AccountFrozenActivity.this, R.style.dialog);
            aVar.setContentView(R.layout.dialog_frozen_account_layout);
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            ((Button) aVar.findViewById(R.id.button)).setOnClickListener(new b(aVar));
            if (AccountFrozenActivity.this.isDestroyed() || AccountFrozenActivity.this.isFinishing()) {
                return;
            }
            aVar.show();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_account_frozen);
        ButterKnife.bind(this);
        w4();
    }

    public final void v4() {
        long longExtra = getIntent().getLongExtra("frozenTime", 0L);
        this.b = getIntent().getBooleanExtra("from_login", false);
        this.c = getIntent().getStringExtra("recover_account_code");
        this.a = be3.i(be3.j, new Date(longExtra));
        String str = String.format(ah4.e(R.string.login_deleted_account1), this.a);
        this.a = str;
        this.text1.setText(str);
    }

    public final void w4() {
        this.actionbar.setBackVisibility(0);
        this.actionbar.setBackAction(new a());
        this.recoverAccount.setOnClickListener(new b());
        v4();
    }

    public final void x4() {
        if (TextUtils.isEmpty(this.c)) {
            sg3.h(R.string.default_error_msg);
        } else {
            tn2.x(this).m("/app/recoverAccount", ro2.c(new RecoverAccountRequest(this.c)), new c());
        }
    }

    public final void y4() {
        runOnMainThread(new d());
    }
}

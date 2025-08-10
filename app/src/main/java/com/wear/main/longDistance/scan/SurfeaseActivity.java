package com.wear.main.longDistance.scan;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.bean.socketio.display.SurfeaseLoginInfBean;
import dc.ch3;
import dc.uf2;

/* loaded from: classes3.dex */
public class SurfeaseActivity extends BaseActivity {
    public String a;

    @BindView(R.id.iv_close)
    public ImageView ivClose;

    @BindView(R.id.logo)
    public ImageView logo;

    @BindView(R.id.sufease_login)
    public ImageView sufeaseLogin;

    @BindView(R.id.sufease_login_cancel)
    public TextView sufeaseLoginCancel;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SurfeaseLoginInfBean surfeaseLoginInfBean = new SurfeaseLoginInfBean();
            surfeaseLoginInfBean.setDeviceId(SurfeaseActivity.this.a);
            SurfeaseLoginInfBean.UserInfo userInfo = new SurfeaseLoginInfBean.UserInfo();
            Account accountU = ch3.n().u();
            userInfo.setAvatar(accountU.getAvatar());
            userInfo.setNickName(accountU.getUserName());
            userInfo.setRemark(accountU.getRemark());
            surfeaseLoginInfBean.setUserInfo(userInfo);
            uf2.v().E(surfeaseLoginInfBean);
            SurfeaseActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SurfeaseActivity.this.finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        setContentView(R.layout.activity_sufease_login);
        ButterKnife.bind(this);
        this.a = getIntent().getStringExtra("data");
        this.sufeaseLogin.setOnClickListener(new a());
        this.sufeaseLoginCancel.setOnClickListener(new b());
    }
}

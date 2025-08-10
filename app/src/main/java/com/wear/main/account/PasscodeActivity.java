package com.wear.main.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.eg3;
import dc.kn3;
import dc.pj3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class PasscodeActivity extends BaseActivity implements View.OnClickListener {
    public static final String b = PasscodeActivity.class.getName();
    public boolean a = false;

    @BindView(R.id.actionbar)
    public MyActionBar actionBar;

    @BindView(R.id.passcode_change)
    public Button passcodeChange;

    @BindView(R.id.passcode_enable)
    public Button passcodeEnable;

    public class a implements kn3.d {
        public a() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            PasscodeActivity.this.passcodeEnable.setText(ah4.e(R.string.common_enable));
            eg3.m(PasscodeActivity.this, "passcode_code_key");
            PasscodeActivity passcodeActivity = PasscodeActivity.this;
            passcodeActivity.a = false;
            passcodeActivity.passcodeChange.setVisibility(8);
            PasscodeActivity.this.addAnalyticsEventId("removePasscode", null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.passcode_change /* 2131363996 */:
                Bundle bundle = new Bundle();
                bundle.putInt("isChange", 1);
                pj3.g(this, LockActivity.class, bundle);
                addAnalyticsEventId("setPasscode", null);
                break;
            case R.id.passcode_enable /* 2131363997 */:
                if (!this.a) {
                    pj3.f(this, LockActivity.class);
                    addAnalyticsEventId("setPasscode", null);
                    break;
                } else {
                    kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.setting_passcode_settings_disable_hint), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), false, (kn3.d) new a());
                    kn3Var.show();
                    kn3Var.l();
                    break;
                }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_setting_passcode);
        ButterKnife.bind(this);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionBar = myActionBar;
        myActionBar.setTitle(ah4.e(R.string.setting_passcode_change));
        this.passcodeEnable.setOnClickListener(this);
        this.passcodeChange.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String str = "passcode=" + eg3.h(this, "passcode_code_key", "");
        if (eg3.a(this, "passcode_code_key")) {
            this.passcodeEnable.setText(ah4.e(R.string.common_disable));
            this.a = true;
            this.passcodeChange.setVisibility(0);
        } else {
            this.passcodeEnable.setText(ah4.e(R.string.common_enable));
            this.a = false;
            this.passcodeChange.setVisibility(8);
        }
    }
}

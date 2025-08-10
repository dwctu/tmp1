package com.wear.main.account.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import dc.ep1;
import dc.kg3;

/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity {
    public LoginFragment a;

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.a.R(i, i2, intent);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_container);
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle2 = new Bundle();
        int intExtra = getIntent().getIntExtra("isChange", 0);
        int intExtra2 = getIntent().getIntExtra("intoType", 0);
        String stringExtra = getIntent().getStringExtra("email");
        String stringExtra2 = getIntent().getStringExtra("gotoVerify");
        bundle2.putInt("isChange", intExtra);
        bundle2.putInt("intoType", intExtra2);
        bundle2.putString("email", stringExtra);
        bundle2.putString("gotoVerify", stringExtra2);
        LoginFragment loginFragmentX0 = LoginFragment.x0(bundle2);
        this.a = loginFragmentX0;
        fragmentTransactionBeginTransaction.add(R.id.fragment_container, loginFragmentX0);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ep1.b().l();
        int intExtra = intent.getIntExtra("isChange", 0);
        if (intExtra != 0) {
            this.a.A0(intExtra);
        }
    }
}

package com.wear.main.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.UpdateVersionBean;
import com.wear.bean.event.VersionUpdataEvent;
import com.wear.main.account.UpdateActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.cs3;
import dc.ee3;
import dc.is3;
import dc.nn3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class UpdateActivity extends BaseActivity {
    public TextView a;
    public Button b;

    public class a implements View.OnClickListener {
        public final /* synthetic */ UpdateVersionBean a;

        /* renamed from: com.wear.main.account.UpdateActivity$a$a, reason: collision with other inner class name */
        public class C0088a implements nn3.e {
            public C0088a() {
            }

            @Override // dc.nn3.e
            public void doCancel() {
                MyApplication.R = true;
                if (a.this.a.isForce()) {
                    MyApplication.D();
                }
            }
        }

        public a(UpdateVersionBean updateVersionBean) {
            this.a = updateVersionBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.M(UpdateActivity.this).contains("remote")) {
                new nn3(UpdateActivity.this, this.a.getApkUrl(), this.a.isForce(), new C0088a()).show();
                return;
            }
            MyApplication.R = true;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.a.getUrl()));
            UpdateActivity.this.startActivity(intent);
            MyApplication.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t4() {
        startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + WearUtils.x.getPackageName())), 10086);
    }

    public static /* synthetic */ void u4(boolean z) {
        if (z) {
            MyApplication.D();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        UpdateVersionBean updateVersionBean;
        if (i == 10086) {
            if (i2 == -1) {
                ee3.p(this, ee3.o());
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (getPackageManager().canRequestPackageInstalls()) {
                    ee3.p(this, ee3.o());
                    return;
                }
                VersionUpdataEvent versionUpdataEvent = MyApplication.S;
                if (versionUpdataEvent == null || (updateVersionBean = versionUpdataEvent.versionBean) == null) {
                    return;
                }
                final boolean zIsForce = updateVersionBean.isForce();
                String strE = ah4.e(R.string.common_cancel);
                if (zIsForce) {
                    strE = ah4.e(R.string.common_exit);
                }
                cs3.d(this, ah4.e(R.string.apk_update_fail_android_o_permission), ah4.e(R.string.common_update), strE, new is3.d() { // from class: dc.tx1
                    @Override // dc.is3.d
                    public final void doConfirm() {
                        this.a.t4();
                    }
                }, new is3.c() { // from class: dc.sx1
                    @Override // dc.is3.c
                    public final void doCancel() {
                        UpdateActivity.u4(zIsForce);
                    }
                }).show();
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        UpdateVersionBean updateVersionBean;
        super.onCreate(bundle);
        setContentView(R.layout.account_update);
        this.a = (TextView) findViewById(R.id.app_version);
        if (WearUtils.e1(WearUtils.q)) {
            WearUtils.q = MyApplication.Q(this) == null ? "" : MyApplication.Q(this).versionName;
        }
        TextView textView = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append(ah4.e(R.string.app_name));
        sb.append(" ");
        sb.append(WearUtils.q);
        sb.append(WearUtils.v ? "_t" : "");
        textView.setText(sb.toString());
        Button button = (Button) findViewById(R.id.update_btn);
        this.b = button;
        VersionUpdataEvent versionUpdataEvent = MyApplication.S;
        if (versionUpdataEvent == null || (updateVersionBean = versionUpdataEvent.versionBean) == null) {
            button.setEnabled(false);
            this.b.setText(ah4.e(R.string.system_update_notices_latest));
        } else if (WearUtils.e1(updateVersionBean.getVersion()) || WearUtils.e1(updateVersionBean.getApkUrl())) {
            this.b.setEnabled(false);
            this.b.setText(ah4.e(R.string.system_update_notices_latest));
        } else {
            this.b.setEnabled(true);
            this.b.setText(String.format(ah4.e(R.string.system_update_notices), updateVersionBean.getVersion()));
            this.b.setOnClickListener(new a(updateVersionBean));
        }
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
    }
}

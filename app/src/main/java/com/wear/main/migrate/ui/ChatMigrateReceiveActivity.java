package com.wear.main.migrate.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import dc.ah4;
import dc.cs3;
import dc.dd2;
import dc.is3;
import dc.jd2;
import dc.ye3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ChatMigrateReceiveActivity extends BaseActivity implements jd2.d {

    @BindView(R.id.ac_migrate_receive_iv_transfer)
    public ImageView ivTransfer;

    @BindView(R.id.ac_migrate_receive_interrupted)
    public TextView tvInterrupted;

    @BindView(R.id.ac_migrate_receive_ok)
    public TextView tvMigratedOk;

    @BindView(R.id.ac_migrate_receive_screen_tip)
    public TextView tvScreenTip;

    @BindView(R.id.ac_migrate_receive_status)
    public TextView tvStatus;

    @BindView(R.id.ac_migrate_receive_stop)
    public TextView tvStop;

    @BindView(R.id.ac_migrate_receive_trying)
    public TextView tvTrying;

    public class a implements is3.d {
        public a() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            jd2.x().s();
            jd2.x().w();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) (dd2.F().K() == 0 ? DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE : "ios"));
            ye3.d("M0025", jSONObject.toString());
            ChatMigrateReceiveActivity.this.finish();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateReceiveActivity.this.B4();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateReceiveActivity.this.B4();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateReceiveActivity.this.finish();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateReceiveActivity.this.x4();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateReceiveActivity.this.A4();
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateReceiveActivity.this.y4(this.a);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateReceiveActivity.this.D4();
        }
    }

    @Override // dc.jd2.d
    public void A(String str) {
        C4(str);
    }

    public final void A4() {
        this.tvStatus.setVisibility(0);
        this.tvStatus.setText(ah4.e(R.string.unzip_chats_des) + " 0.0%");
        this.tvInterrupted.setVisibility(8);
        this.tvTrying.setVisibility(8);
        this.tvStop.setVisibility(8);
        this.tvScreenTip.setVisibility(8);
        this.ivTransfer.setImageResource(R.drawable.chathistorymigrationicon_unzip);
    }

    public final void B4() {
        this.tvStatus.setVisibility(0);
        this.tvStatus.setText(ah4.e(R.string.transfer_chats_des) + " 0.0% (0.0MB/s)");
        this.tvInterrupted.setVisibility(8);
        this.tvTrying.setVisibility(8);
        this.tvStop.setVisibility(8);
        this.tvScreenTip.setVisibility(0);
        this.ivTransfer.setImageResource(R.drawable.chathistorymigrationicon_before);
    }

    public final void C4(String str) {
        this.tvStatus.setText(ah4.e(R.string.unzip_chats_des) + " " + str);
    }

    @Override // dc.jd2.d
    public void D1() {
    }

    public final void D4() {
        this.tvStatus.setVisibility(0);
        this.tvStatus.setText(ah4.e(R.string.migration_successful_des));
        this.tvInterrupted.setVisibility(8);
        this.tvTrying.setVisibility(8);
        this.tvStop.setVisibility(8);
        this.tvScreenTip.setVisibility(8);
        this.ivTransfer.setImageResource(R.drawable.chathistorymigrationicon_succeed);
        this.tvMigratedOk.setVisibility(0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) (dd2.F().K() == 0 ? DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE : "ios"));
        ye3.d("M0024", jSONObject.toString());
    }

    @Override // dc.jd2.d
    public void F2() {
    }

    @Override // dc.jd2.d
    public void J(String str) {
        runOnMainThread(new g(str));
    }

    @Override // dc.jd2.d
    public void L() {
        runOnMainThread(new e());
    }

    @Override // dc.jd2.d
    public void Y1() {
    }

    @Override // dc.jd2.d
    public void e3() {
    }

    @Override // dc.jd2.d
    public void f0() {
        runOnMainThread(new c());
    }

    @Override // dc.jd2.d
    public void j() {
        runOnMainThread(new f());
    }

    @Override // dc.jd2.d
    public void j0() {
    }

    @OnClick({R.id.ac_migrate_receive_stop, R.id.ac_migrate_receive_ok})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ac_migrate_receive_ok) {
            jd2.x().w();
            finish();
        } else {
            if (id != R.id.ac_migrate_receive_stop) {
                return;
            }
            z4();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_migrate_receive);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        getWindow().addFlags(128);
        B4();
        jd2.x().M(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        getWindow().clearFlags(128);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // dc.jd2.d
    public void p() {
    }

    @Override // dc.jd2.d
    public void p1() {
        runOnMainThread(new d());
    }

    @Override // dc.jd2.d
    public void u() {
        runOnMainThread(new h());
    }

    @Override // dc.jd2.d
    public void v3() {
        runOnMainThread(new b());
    }

    public final void x4() {
        this.tvStatus.setVisibility(8);
        this.tvInterrupted.setVisibility(0);
        this.tvTrying.setVisibility(0);
        this.tvStop.setVisibility(0);
        this.tvScreenTip.setVisibility(8);
        this.ivTransfer.setImageResource(R.drawable.migrate_overtime);
    }

    @Override // dc.jd2.d
    public void y1() {
    }

    public final void y4(String str) {
        this.tvStatus.setText(ah4.e(R.string.transfer_chats_des) + " " + str);
    }

    public void z4() {
        cs3.e(this, ah4.e(R.string.notification_stop_transfer1) + "?", ah4.e(R.string.notification_stop_transfer2), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), new a(), null).show();
    }
}

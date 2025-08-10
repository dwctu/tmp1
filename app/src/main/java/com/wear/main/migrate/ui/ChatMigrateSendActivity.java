package com.wear.main.migrate.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import dc.ah4;
import dc.kd2;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ChatMigrateSendActivity extends BaseActivity implements kd2.d {

    @BindView(R.id.ac_migrate_transfer_iv)
    public ImageView ivTransfer;

    @BindView(R.id.ac_migrate_receive_interrupted)
    public TextView tvInterrupted;

    @BindView(R.id.ac_migrate_transfer_unzip_ok)
    public TextView tvMigratedOk;

    @BindView(R.id.ac_migrate_transfer_screen_tip)
    public TextView tvScreenTip;

    @BindView(R.id.ac_migrate_transfer_status)
    public TextView tvStatus;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.D4();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.B4();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.C4();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.finish();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.finish();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.z4();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.B4();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.y4();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            kd2.C().B(2);
            ChatMigrateSendActivity.this.finish();
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ String a;

        public j(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateSendActivity.this.A4(this.a);
        }
    }

    public final void A4(String str) {
        this.tvStatus.setText(ah4.e(R.string.transfer_chats_des) + " " + str);
    }

    public final void B4() {
        this.tvStatus.setText(ah4.e(R.string.migration_connection_successful_des2));
        this.tvInterrupted.setVisibility(8);
        this.tvScreenTip.setVisibility(8);
        this.ivTransfer.setImageResource(R.drawable.chathistorymigrationicon_ing);
    }

    public final void C4() {
        this.tvStatus.setText(ah4.e(R.string.transfer_chats_des));
        this.tvInterrupted.setVisibility(8);
        this.tvScreenTip.setVisibility(0);
        this.ivTransfer.setImageResource(R.drawable.chathistorymigrationicon_ing);
    }

    public final void D4() {
        this.tvStatus.setVisibility(0);
        this.tvStatus.setText(ah4.e(R.string.migration_successful_des));
        this.tvInterrupted.setVisibility(8);
        this.tvScreenTip.setVisibility(8);
        this.ivTransfer.setImageResource(R.drawable.chathistorymigrationicon_succeed);
        this.tvMigratedOk.setVisibility(0);
    }

    @Override // dc.kd2.d
    public void J(String str) {
        runOnMainThread(new j(str));
    }

    @Override // dc.kd2.d
    public void L() {
        runOnMainThread(new f());
    }

    @Override // dc.kd2.d
    public void P0() {
        runOnMainThread(new c());
    }

    @Override // dc.kd2.d
    public void X1() {
        runOnMainThread(new e());
    }

    @Override // dc.kd2.d
    public void c2() {
        runOnMainThread(new g());
    }

    @Override // dc.kd2.d
    public void j() {
        runOnMainThread(new h());
    }

    @Override // dc.kd2.d
    public void l0(String str) {
    }

    @Override // dc.kd2.d
    public void n2() {
        runOnMainThread(new i());
    }

    @OnClick({R.id.ac_migrate_transfer_unzip_ok})
    public void onClick(View view) {
        if (view.getId() != R.id.ac_migrate_transfer_unzip_ok) {
            return;
        }
        kd2.C().B(1);
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_migrate_send);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        getWindow().addFlags(128);
        kd2.C().N(this);
        kd2.r = true;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        kd2.r = false;
        EventBus.getDefault().unregister(this);
        getWindow().clearFlags(128);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // dc.kd2.d
    public void t1() {
        runOnMainThread(new b());
    }

    @Override // dc.kd2.d
    public void u() {
        runOnMainThread(new a());
    }

    @Override // dc.kd2.d
    public void v0() {
        runOnMainThread(new d());
    }

    public final void y4() {
        this.tvStatus.setText(ah4.e(R.string.transfer_chats_des) + " 100% (0.0KB/s)");
        this.tvInterrupted.setVisibility(8);
        this.tvScreenTip.setVisibility(0);
        this.ivTransfer.setImageResource(R.drawable.chathistorymigrationicon_ing);
    }

    public final void z4() {
        if (kd2.p == 3) {
            this.tvStatus.setText(ah4.e(R.string.transfer_interrupted_des1));
            this.tvStatus.setText(ah4.e(R.string.transfer_interrupted_des2));
            this.tvInterrupted.setVisibility(0);
        } else {
            this.tvStatus.setText(ah4.e(R.string.migration_connect_failed_des1));
            this.tvInterrupted.setVisibility(8);
        }
        this.tvScreenTip.setVisibility(8);
        this.ivTransfer.setImageResource(R.drawable.migrate_overtime);
    }
}

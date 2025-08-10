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
import com.wear.bean.migrate.MigrateAdapterBean;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.dd2;
import dc.jd2;
import dc.pj3;
import dc.ye3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ChatMigrateConnectActivity extends BaseActivity implements jd2.d {
    public boolean a = false;

    @BindView(R.id.ac_migrate_connect_tv_battery_tip)
    public TextView batteryTip;

    @BindView(R.id.ac_migrate_connect_iv_transfer)
    public ImageView ivTransfer;

    @BindView(R.id.actionbar)
    public MyActionBar myActionBar;

    @BindView(R.id.ac_migrate_connect_tv_authfail)
    public TextView tvAuthFail;

    @BindView(R.id.ac_migrate_connect_tv_exit)
    public TextView tvExit;

    @BindView(R.id.ac_migrate_connect_tv_retry)
    public TextView tvRetry;

    @BindView(R.id.ac_migrate_connect_tv_tip)
    public TextView tvTip;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateConnectActivity.this.finish();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateConnectActivity.this.F4();
        }
    }

    public class c implements MyActionBar.f {
        public c() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatMigrateConnectActivity.this.b();
        }
    }

    public class d implements Observer<Boolean> {
        public d() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Boolean bool) {
            if (bool.booleanValue()) {
                ChatMigrateConnectActivity.this.I4();
            } else {
                ChatMigrateConnectActivity.this.E4();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    public class e implements ObservableOnSubscribe<Boolean> {
        public e(ChatMigrateConnectActivity chatMigrateConnectActivity) {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
            try {
                observableEmitter.onNext(Boolean.valueOf(MigrateAdapterBean.checkFields()));
            } catch (Exception e) {
                e.printStackTrace();
                observableEmitter.onNext(Boolean.FALSE);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateConnectActivity.this.tvTip.setText(ah4.e(R.string.toy_connecting));
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateConnectActivity.this.F4();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateConnectActivity.this.G4();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateConnectActivity.this.D4();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateConnectActivity.this.H4();
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMigrateConnectActivity.this.dissDialog();
            pj3.f(ChatMigrateConnectActivity.this, ChatMigrateReceiveActivity.class);
            ChatMigrateConnectActivity.this.finish();
        }
    }

    @Override // dc.jd2.d
    public void A(String str) {
    }

    public void A4() {
        Observable.create(new e(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d());
    }

    public final void B4() {
        this.tvRetry.setEnabled(false);
        jd2.x().t();
    }

    public final void C4(boolean z) {
        this.myActionBar.setImageBackBtnVisibility(z ? 0 : 8);
    }

    @Override // dc.jd2.d
    public void D1() {
        runOnMainThread(new j());
    }

    public final void D4() {
        this.tvRetry.setVisibility(8);
        this.tvExit.setVisibility(8);
        this.tvAuthFail.setVisibility(0);
        this.tvTip.setText(ah4.e(R.string.migration_connect_failed_des2));
        this.ivTransfer.setImageResource(R.drawable.migrate_overtime);
        C4(true);
        this.batteryTip.setVisibility(8);
    }

    public final void E4() {
        H4();
    }

    @Override // dc.jd2.d
    public void F2() {
        runOnMainThread(new k());
    }

    public final void F4() {
        dissDialog();
        this.tvTip.setText(ah4.e(R.string.migration_connect_failed_des1));
        this.tvRetry.setText(ah4.e(R.string.button_retry));
        this.tvExit.setText(ah4.e(R.string.common_exit));
        this.tvRetry.setVisibility(0);
        this.tvExit.setVisibility(0);
        this.tvRetry.setEnabled(true);
        this.tvExit.setEnabled(true);
        this.tvAuthFail.setVisibility(8);
        C4(false);
        this.a = true;
        this.ivTransfer.setImageResource(R.drawable.migrate_overtime);
    }

    public final void G4() {
        this.tvTip.setText(ah4.e(R.string.migration_connection_successful_des1));
        this.tvRetry.setText(ah4.e(R.string.common_yes));
        this.tvExit.setText(ah4.e(R.string.common_cancel));
        this.tvRetry.setVisibility(0);
        this.tvExit.setVisibility(0);
        this.tvAuthFail.setVisibility(8);
        this.tvRetry.setEnabled(true);
        this.tvExit.setEnabled(true);
        C4(false);
        this.a = false;
        this.ivTransfer.setImageResource(R.drawable.chathistorymigrationicon_before);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) (dd2.F().K() == 0 ? DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE : "ios"));
        ye3.d("M0022", jSONObject.toString());
    }

    public final void H4() {
        this.tvRetry.setVisibility(8);
        this.tvExit.setVisibility(8);
        this.tvAuthFail.setVisibility(8);
        this.tvTip.setText(ah4.e(R.string.migration_connect_failed_des4));
        this.ivTransfer.setImageResource(R.drawable.migrate_overtime);
        C4(true);
        this.batteryTip.setVisibility(8);
    }

    public final void I4() {
        jd2.x().N(getIntent().getStringExtra("websocketUrl"));
        dd2.F().O();
        jd2.x().G();
        jd2.x().M(this);
        jd2.x().t();
        z4();
        jd2.x().o(this);
    }

    @Override // dc.jd2.d
    public void J(String str) {
    }

    @Override // dc.jd2.d
    public void L() {
        runOnMainThread(new b());
    }

    @Override // dc.jd2.d
    public void Y1() {
        runOnMainThread(new f());
    }

    public final void b() {
        jd2.x().s();
        finish();
    }

    @Override // dc.jd2.d
    public void e3() {
        runOnMainThread(new g());
    }

    @Override // dc.jd2.d
    public void f0() {
        runOnMainThread(new h());
    }

    @Override // dc.jd2.d
    public void j() {
    }

    @Override // dc.jd2.d
    public void j0() {
        runOnMainThread(new a());
    }

    @OnClick({R.id.ac_migrate_connect_tv_retry, R.id.ac_migrate_connect_tv_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_migrate_connect_tv_exit /* 2131361872 */:
                if (!this.a) {
                    jd2.x().Q(false);
                    break;
                } else {
                    b();
                    break;
                }
            case R.id.ac_migrate_connect_tv_retry /* 2131361873 */:
                if (!this.a) {
                    showDialog();
                    jd2.x().Q(true);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", (Object) (dd2.F().K() == 0 ? DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE : "ios"));
                    ye3.d("M0023", jSONObject.toString());
                    break;
                } else {
                    B4();
                    break;
                }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_migrate_connect);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        if (dd2.F().P()) {
            finish();
            return;
        }
        getWindow().addFlags(128);
        this.myActionBar.setImageBackAction(Integer.valueOf(R.drawable.nav_migrate_close), new c(), 8);
        C4(false);
        A4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        getWindow().clearFlags(128);
        jd2.x().K(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // dc.jd2.d
    public void p() {
    }

    @Override // dc.jd2.d
    public void p1() {
    }

    @Override // dc.jd2.d
    public void u() {
    }

    @Override // dc.jd2.d
    public void v3() {
    }

    @Override // dc.jd2.d
    public void y1() {
        runOnMainThread(new i());
    }

    public final void z4() {
        WearUtils.K();
        String str = "systemBattery" + this.application.a;
        if (this.application.a < 20) {
            this.batteryTip.setVisibility(0);
        } else {
            this.batteryTip.setVisibility(8);
        }
    }
}

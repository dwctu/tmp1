package com.wear.main.migrate.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.annotations.NotNull;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.migrate.MigrateAdapterBean;
import com.wear.bean.socketio.scan.ScanBean;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.ch3;
import dc.ed2;
import dc.kd2;
import dc.nd3;
import dc.pj3;
import dc.sg3;
import dc.ye3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class ChatMigrateQrcodeActivity extends BaseActivity implements kd2.d {
    public String a;
    public String b;

    @BindView(R.id.ac_migrate_qrcode_tv_battery_tip)
    public TextView batteryTip;
    public List<IPeopleInfo> c;

    @BindView(R.id.ac_migrate_qrcode)
    public ImageView ivQrCode;

    @BindView(R.id.ac_migrate_qrcode_lott)
    public LottieAnimationView ivQrCodeLott;

    @BindView(R.id.actionbar)
    public MyActionBar myActionBar;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatMigrateQrcodeActivity.this.finish();
        }
    }

    public class b implements Observer<Boolean> {
        public b() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Boolean bool) {
            if (bool.booleanValue()) {
                ChatMigrateQrcodeActivity.this.J4();
            } else {
                ChatMigrateQrcodeActivity.this.I4();
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

    public class c implements ObservableOnSubscribe<Boolean> {
        public c(ChatMigrateQrcodeActivity chatMigrateQrcodeActivity) {
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

    public class d implements Observer<Bitmap> {
        public d() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@NotNull Bitmap bitmap) {
            ChatMigrateQrcodeActivity.this.B4();
            ChatMigrateQrcodeActivity.this.ivQrCode.setImageBitmap(bitmap);
            ye3.d("M0021", "");
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(@NotNull Throwable th) {
            ChatMigrateQrcodeActivity.this.B4();
            sg3.l("二维码创建失败");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(@NotNull Disposable disposable) {
        }
    }

    public class e implements ObservableOnSubscribe<Bitmap> {
        public e() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(@NotNull ObservableEmitter<Bitmap> observableEmitter) throws Exception {
            try {
                if (ChatMigrateQrcodeActivity.this.c == null || ChatMigrateQrcodeActivity.this.c.size() == 0) {
                    ChatMigrateQrcodeActivity chatMigrateQrcodeActivity = ChatMigrateQrcodeActivity.this;
                    chatMigrateQrcodeActivity.c = chatMigrateQrcodeActivity.F4();
                    List listG4 = ChatMigrateQrcodeActivity.this.G4();
                    if (listG4 != null && listG4.size() > 0) {
                        ChatMigrateQrcodeActivity.this.c.addAll(listG4);
                    }
                }
                ed2.x().R(ChatMigrateQrcodeActivity.this.b);
                ed2.x().P(ChatMigrateQrcodeActivity.this.c);
                ed2.x().s();
                ScanBean scanBean = new ScanBean();
                scanBean.setA(StreamManagement.AckRequest.ELEMENT);
                scanBean.setT(15);
                scanBean.setD(ChatMigrateQrcodeActivity.this.a);
                String json = WearUtils.A.toJson(scanBean);
                String strT = nd3.t(json);
                String str = "createQrcode qrStr: " + json;
                Bitmap bitmapBuildBitmap = null;
                try {
                    bitmapBuildBitmap = ScanUtil.buildBitmap(strT, 0, 500, 500, new HmsBuildBitmapOption.Creator().create());
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                if (bitmapBuildBitmap != null) {
                    observableEmitter.onNext(bitmapBuildBitmap);
                } else {
                    observableEmitter.onError(new Throwable(""));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                observableEmitter.onError(new Throwable(""));
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pj3.f(ChatMigrateQrcodeActivity.this, ChatMigrateSendActivity.class);
        }
    }

    public final void B4() {
        this.ivQrCodeLott.setVisibility(8);
        this.ivQrCodeLott.g();
    }

    public final void C4() {
        WearUtils.K();
        String str = "systemBattery" + this.application.a;
        if (this.application.a < 20) {
            this.batteryTip.setVisibility(0);
        } else {
            this.batteryTip.setVisibility(8);
        }
    }

    public void D4() {
        Observable.create(new c(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b());
    }

    public final void E4() {
        Observable.create(new e()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d());
    }

    public final List<IPeopleInfo> F4() {
        ArrayList arrayList = new ArrayList();
        List<IPeopleInfo> list = ch3.i;
        if (list != null && list.size() > 0) {
            for (IPeopleInfo iPeopleInfo : ch3.i) {
                if (DaoUtils.getCommunMessageDao().findHaveMsgs(iPeopleInfo.isGroup() ? WearUtils.k0(iPeopleInfo.getId()) : WearUtils.i0(iPeopleInfo.getId()))) {
                    arrayList.add(iPeopleInfo);
                }
            }
        }
        return arrayList;
    }

    public final List<IPeopleInfo> G4() {
        ArrayList arrayList = new ArrayList();
        List<String> listF = this.application.i.f(0);
        if (listF != null && listF.size() > 0) {
            for (String str : listF) {
                if (DaoUtils.getCommunMessageDao().findHaveMsgs(str)) {
                    User user = new User();
                    user.setId(WearUtils.X(str));
                    arrayList.add(user);
                }
            }
        }
        return arrayList;
    }

    public final void H4(boolean z) throws Settings.SettingNotFoundException {
        int i;
        try {
            i = Settings.System.getInt(WearUtils.x.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            i = 255;
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = (z ? 250.0f : i + 0.0f) / 255.0f;
        window.setAttributes(attributes);
    }

    public final void I4() {
        sg3.l(ah4.e(R.string.migration_connect_failed_des4));
        finish();
    }

    @Override // dc.kd2.d
    public void J(String str) {
    }

    public final void J4() {
        kd2.C().N(this);
        String strQ = WearUtils.y.q();
        if (!WearUtils.e1(strQ)) {
            DaoUtils.getTestValueDao().save(TestValueDao.CHAT_MIGRATE_USERJID_WEARABLE_KEY, nd3.u(strQ), TestValueDao.CHAT_MIGRATE_USERJID_WEARABLE_TYPE);
        }
        kd2.C().z();
        C4();
        kd2.r = true;
    }

    @Override // dc.kd2.d
    public void L() {
    }

    @Override // dc.kd2.d
    public void P0() {
    }

    @Override // dc.kd2.d
    public void X1() {
    }

    @Override // dc.kd2.d
    public void c2() {
    }

    @Override // dc.kd2.d
    public void j() {
    }

    @Override // dc.kd2.d
    public void l0(String str) {
        this.a = str;
        E4();
    }

    @Override // dc.kd2.d
    public void n2() {
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_migrate_qrcode);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        getWindow().addFlags(128);
        this.a = getIntent().getStringExtra("websocketUrl");
        int i = MyApplication.m0;
        if (i == 2 || (i == 0 && MyApplication.l0)) {
            this.ivQrCodeLott.setAnimation("migrate_qrcode_dark.json");
        } else {
            this.ivQrCodeLott.setAnimation("migrate_qrcode_white.json");
        }
        this.ivQrCodeLott.p(true);
        this.ivQrCodeLott.r();
        this.c = (ArrayList) getIntent().getSerializableExtra("listSelected");
        String strP = WearUtils.y.p();
        this.b = strP;
        if (WearUtils.e1(strP)) {
            finish();
        } else {
            this.myActionBar.setImageBackAction(Integer.valueOf(R.drawable.nav_migrate_close), new a(), 8);
            D4();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(128);
        if (kd2.p <= 1) {
            kd2.r = false;
            kd2.C().y();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() throws Settings.SettingNotFoundException {
        super.onPause();
        H4(false);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws Settings.SettingNotFoundException {
        super.onResume();
        kd2.C().N(this);
        H4(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        kd2.C().J(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        kd2.C().s(this);
    }

    @Override // dc.kd2.d
    public void t1() {
        runOnMainThread(new f());
    }

    @Override // dc.kd2.d
    public void u() {
    }

    @Override // dc.kd2.d
    public void v0() {
    }
}

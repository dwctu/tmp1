package com.wear;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.KeepScreenSetting;
import com.wear.bean.event.ChangeDiscoverEvent;
import com.wear.bean.event.LanguageEvent;
import com.wear.bean.event.SystemChangeEvent;
import com.wear.bean.event.UpdateDiscoverAdsEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.FlashActivity;
import com.wear.main.MainActivity;
import com.wear.main.account.ChangePasswordActivity;
import com.wear.main.account.LockActivity;
import com.wear.main.account.MyAccountActivity;
import com.wear.main.account.login.EditEmailActivity;
import com.wear.main.account.login.ForgetPassActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.account.login.ResetPasswordActivity;
import com.wear.main.account.login.SignUpActivity;
import com.wear.main.account.login.ThirdBindAccountActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.ChatRoomInfoActivity;
import com.wear.main.longDistance.FriendProfileActivity;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.main.longDistance.controllink.ControlLinkActivity;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.longDistance.CameraNewActivity;
import com.wear.ui.longDistance.officialaccount.OfficialAccountActivity;
import com.wear.ui.longDistance.officialaccount.OfficialAccountInfoActivity;
import com.wear.ui.longDistance.video.VideoPlayerActivity;
import com.wear.ui.me.ControlRouletteNoticeActivity;
import com.wear.ui.me.ControlRouletteReportActivity;
import com.wear.ui.me.ControlRouletteReportSuccessActivity;
import com.wear.ui.me.ProfileActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.chatMic.ChatEmojisPanel;
import com.wear.widget.chatMic.ChatInputPanelPto;
import com.wear.widget.chatMic.ChatMorePanelPto;
import dc.ah4;
import dc.be3;
import dc.bh0;
import dc.cs3;
import dc.eg3;
import dc.ep1;
import dc.fl2;
import dc.gh0;
import dc.hl2;
import dc.is3;
import dc.kg3;
import dc.kn3;
import dc.l12;
import dc.lg3;
import dc.ll2;
import dc.nd3;
import dc.od3;
import dc.pe3;
import dc.pj3;
import dc.sg3;
import dc.ti1;
import dc.ul2;
import dc.vl2;
import dc.vr3;
import dc.ye3;
import dc.zd3;
import dc.zg4;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class BaseActivity<P extends vl2> extends AppCompatActivity implements ul2, cs3.b {
    private static final long THREE_MINUTES = 180000;
    private static final int TRIGGER_THRESHOLD = 2;
    private static long lastTriggerTime;
    private static int triggerCount;
    public MyApplication application;
    public bh0 keyboardHelper;
    public fl2 mActivityComponent;
    private String mActivityJumpTag;
    private long mClickTime;
    public FirebaseAnalytics mFirebaseAnalytics;
    public P mPresenter;
    public vr3 progressDialog;
    public Handler parentHandler = new Handler(Looper.getMainLooper());
    public Activity activity = this;
    public Handler delayHandler = new Handler(Looper.getMainLooper());
    private Runnable r = new c();

    public class a implements zg4.b {
        public a() {
        }

        @Override // dc.zg4.b
        public void a(String str) {
            String str2 = "onFailed: " + str;
        }

        @Override // dc.zg4.b
        public void onStart() {
        }

        @Override // dc.zg4.b
        public void onSuccess() {
            if (be3.D()) {
                EventBus.getDefault().post(new ChangeDiscoverEvent());
            }
            EventBus.getDefault().post(new UpdateDiscoverAdsEvent());
            BaseActivity.this.settingBarColor();
            BaseActivity.this.loadSkinSuccessInvoke();
        }
    }

    public class b implements kn3.d {
        public b(BaseActivity baseActivity) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ep1.b().e("任务超時了啦");
            BaseActivity.this.onCancel();
            BaseActivity.this.dissDialog();
            sg3.h(R.string.net_connect_error_tip);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;
        public final /* synthetic */ ChatInputPanelPto c;
        public final /* synthetic */ ChatEmojisPanel d;
        public final /* synthetic */ ChatMorePanelPto e;

        public class a implements bh0.b {
            public a(d dVar) {
            }

            @Override // dc.bh0.b
            public void a(int i) {
            }

            @Override // dc.bh0.b
            public void onClosed() {
            }
        }

        public class b implements ChatInputPanelPto.c {
            public b() {
            }

            @Override // com.wear.widget.chatMic.ChatInputPanelPto.c
            public void a() {
                d.this.d.setVisibility(8);
                d.this.e.setVisibility(8);
            }

            @Override // com.wear.widget.chatMic.ChatInputPanelPto.c
            public void b() {
                BaseActivity.this.onSoftKeyboardOpened();
            }
        }

        public d(View view, View view2, ChatInputPanelPto chatInputPanelPto, ChatEmojisPanel chatEmojisPanel, ChatMorePanelPto chatMorePanelPto) {
            this.a = view;
            this.b = view2;
            this.c = chatInputPanelPto;
            this.d = chatEmojisPanel;
            this.e = chatMorePanelPto;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseActivity baseActivity = BaseActivity.this;
            if (baseActivity.keyboardHelper == null) {
                baseActivity.keyboardHelper = new bh0();
            }
            String value = DaoUtils.getTestValueDao().getValue(TestValueDao.CHAT_KEYBOARD_HEIGHT_KEY, TestValueDao.CHAT_KEYBOARD_HEIGHT_TYPE);
            if (WearUtils.e1(value)) {
                DaoUtils.getTestValueDao().save(TestValueDao.CHAT_KEYBOARD_HEIGHT_KEY, "0", TestValueDao.CHAT_KEYBOARD_HEIGHT_TYPE);
                value = "0";
            }
            try {
                int iIntValue = Integer.valueOf(value).intValue();
                int iB = gh0.a.b(WearUtils.x);
                if (iIntValue == 0) {
                    iIntValue = (iB * 2) / 5;
                }
                int i = iIntValue < iB / 3 ? (iB * 2) / 5 : iIntValue;
                BaseActivity baseActivity2 = BaseActivity.this;
                bh0 bh0Var = baseActivity2.keyboardHelper;
                bh0Var.p(baseActivity2);
                bh0Var.n(this.a);
                bh0Var.j(this.b);
                bh0Var.l(this.c);
                bh0Var.k(this.d);
                bh0Var.m(this.e);
                bh0Var.v(false);
                bh0Var.s(iIntValue);
                bh0Var.t(new a(this));
                String str = "keyBoardHeight: " + iIntValue;
                this.c.setiSoftListener(new b());
                this.d.setHeight(i);
                this.e.setHeight(i);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable(d.class.getSimpleName() + " KeyboardStatePopupWindow 异常：", e2));
            }
        }
    }

    public class e implements is3.c {
        public e() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            BaseActivity.this.finish();
        }
    }

    public class f implements is3.d {
        public f() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            od3.d(BaseActivity.this.activity);
        }
    }

    private void delayTimeOut() {
        this.delayHandler.postDelayed(this.r, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }

    private void initComponent() {
        hl2.b bVarA = hl2.A();
        bVarA.b(MyApplication.F());
        bVarA.a(new ll2(this));
        this.mActivityComponent = bVarA.c();
        initInject();
    }

    private boolean notNeedResultMainActivity() {
        return ((this instanceof MainActivity) || (this instanceof LoginActivity) || (this instanceof SignUpActivity) || (this instanceof ForgetPassActivity) || (this instanceof EditEmailActivity)) ? false : true;
    }

    private void protectApp() {
        new Thread(new Runnable() { // from class: dc.si1
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.a.r4();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r4() throws InterruptedException {
        try {
            Thread.sleep(200L);
            Intent intent = new Intent(this, (Class<?>) FlashActivity.class);
            intent.addFlags(268468224);
            startActivity(intent);
            MyApplication.D();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void validateAppStatus() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (ti1.b().a() == -1) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable(getClass().getSimpleName() + "内存异常退出了"));
            eg3.j(WearUtils.x, "need_upload_cold_restart", true);
            ye3.j("Remote", "remote_exception", "", "", "", "1", "", -1L);
            protectApp();
        }
    }

    public void addAnalyticsEventId(String str, HashMap<String, String> map) {
        FirebaseAnalytics firebaseAnalytics = this.mFirebaseAnalytics;
        if (firebaseAnalytics != null) {
            WearUtils.x.p(firebaseAnalytics, str, map);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(lg3.h(context));
    }

    public void cancleDelay() {
        this.delayHandler.removeCallbacks(this.r);
        ep1.b().e("关闭超时计算");
    }

    public boolean checkDoubleClick(Intent intent) {
        String action;
        boolean z = true;
        if (intent.getComponent() == null) {
            if (intent.getAction() != null) {
                action = intent.getAction();
            }
            return z;
        }
        action = intent.getComponent().getClassName();
        if (action.equals(this.mActivityJumpTag) && this.mClickTime >= SystemClock.uptimeMillis() - 500) {
            z = false;
        }
        this.mActivityJumpTag = action;
        this.mClickTime = SystemClock.uptimeMillis();
        return z;
    }

    public boolean checkFloatWindowsPermission() {
        if (od3.c(this)) {
            return true;
        }
        is3.b bVar = new is3.b(this);
        String strE = ah4.e(R.string.enable_floating_window_des);
        bVar.q(ah4.e(R.string.enable_floating_window_title));
        bVar.p(strE);
        bVar.o(ah4.e(R.string.common_ok));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new f());
        bVar.c(new e());
        cs3.h(bVar).show();
        return false;
    }

    public void clearReferences() {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null || !fragmentActivityH.equals(this)) {
            return;
        }
        this.application.q0(null);
    }

    public void dismissLoadingProgress() {
        vr3 vr3Var;
        if (isFinishing() || isDestroyed() || (vr3Var = this.progressDialog) == null || !vr3Var.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    public void dissDialog() {
        this.delayHandler.removeCallbacks(this.r);
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    @NonNull
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    public void initInject() {
    }

    public void initTheme(int i, boolean z) {
        a aVar = new a();
        if (i == 2) {
            zg4.m().w("skinman.apk", aVar, 0);
            if (z) {
                pe3.i("SKIN", 2);
                MyApplication.m0 = 2;
            }
        } else {
            if (z) {
                pe3.i("SKIN", 1);
                MyApplication.m0 = 1;
            }
            zg4.m().y(aVar);
        }
        settingBarColor();
    }

    public boolean isLoadingProgressShowing() {
        vr3 vr3Var = this.progressDialog;
        return vr3Var != null && vr3Var.isShowing();
    }

    public void keyboardHelperInit(View view, View view2, ChatInputPanelPto chatInputPanelPto, ChatEmojisPanel chatEmojisPanel, ChatMorePanelPto chatMorePanelPto) {
        this.parentHandler.postDelayed(new d(view, view2, chatInputPanelPto, chatEmojisPanel, chatMorePanelPto), 0L);
    }

    public void loadSkinSuccessInvoke() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1337) {
            MusicControl.h0().e.x(i, i2, intent);
            return;
        }
        MusicControl.h0();
        if (i == 119 && i2 == -1) {
            intent.getBooleanExtra("grant_all", false);
            intent.getIntArrayExtra("grant_results");
        }
    }

    @Override // dc.cs3.b
    public void onCancel() {
        this.delayHandler.removeCallbacks(this.r);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (MyApplication.m0 != 0) {
            return;
        }
        int i = configuration.uiMode & 48;
        if (i == 16) {
            MyApplication.l0 = false;
            initTheme(1, false);
        } else if (i == 32) {
            MyApplication.l0 = true;
            initTheme(2, false);
        }
        EventBus.getDefault().post(new SystemChangeEvent());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 26) {
            getWindow().getDecorView().setImportantForAutofill(8);
        }
        if (DaoUtils.getTestValueDao().getExistKey(nd3.u(TestValueDao.SAVE_KEY_KEEP_SCREEN_KEY), TestValueDao.SAVE_KEY_KEEP_SCREEN_TYPE) != null) {
            getWindow().setFlags(128, 128);
        } else {
            getWindow().clearFlags(128);
        }
        MyApplication myApplication = WearUtils.x;
        this.application = myApplication;
        myApplication.q0(this);
        setRequestedOrientation(1);
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        initComponent();
        P p = this.mPresenter;
        if (p != null) {
            p.c(this);
            this.mPresenter.onCreate();
        }
        this.progressDialog = new vr3(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        clearReferences();
        EventBus.getDefault().unregister(this);
        Handler handler = this.parentHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
        P p = this.mPresenter;
        if (p != null) {
            p.onDestroy();
            this.mPresenter = null;
        }
        vr3 vr3Var = this.progressDialog;
        if (vr3Var != null) {
            vr3Var.dismiss();
        }
        this.delayHandler.removeCallbacksAndMessages(null);
        bh0 bh0Var = this.keyboardHelper;
        if (bh0Var != null) {
            bh0Var.q();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LanguageEvent languageEvent) {
        recreate();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(KeepScreenSetting keepScreenSetting) {
        if (keepScreenSetting != null) {
            if (keepScreenSetting.isKeepOn()) {
                getWindow().setFlags(128, 128);
            } else if (!(this instanceof ChatActivity)) {
                getWindow().clearFlags(128);
            } else if (DaoUtils.getTestValueDao().getExistKey(nd3.u(TestValueDao.SAVE_KEY_KEEP_SCREEN_KEY), TestValueDao.SAVE_KEY_KEEP_SCREEN_TYPE) == null) {
                getWindow().clearFlags(128);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.application.r0(null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!WearUtils.e1(zd3.b(this, "xmpp_password")) && eg3.d(this, "is_enable_cold_restart", false)) {
            validateAppStatus();
        }
        if (this.application.n) {
            pj3.h(this, LockActivity.class, "open_passcode_lock", 0);
        }
        this.application.q0(this);
        if (this.application.g0()) {
            ye3.l = System.currentTimeMillis();
            ye3.d("A0008", "");
            if (eg3.a(this, "passcode_code_key")) {
                MyApplication myApplication = this.application;
                myApplication.n = true;
                myApplication.p0(false);
                String str = "yrb" + this.activity.getLocalClassName();
                if (!this.activity.getClass().getSimpleName().equals("LockActivity")) {
                    pj3.h(this, LockActivity.class, "open_passcode_lock", 0);
                }
            }
        }
        settingBarColor();
    }

    public void onSoftKeyboardOpened() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        try {
            super.onStop();
        } catch (Exception unused) {
            super.onStop();
        }
        MyApplication myApplication = this.application;
        myApplication.p0(myApplication.f0());
    }

    public final void runOnMainThread(Runnable runnable) {
        if (this.parentHandler == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.parentHandler.post(runnable);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(R.layout.activity_base);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.fl_root_view);
        relativeLayout.removeAllViews();
        relativeLayout.addView(getLayoutInflater().inflate(i, (ViewGroup) null), new FrameLayout.LayoutParams(-1, -1));
        settingBarColor();
    }

    public void setCurrentScreen(@Nullable Activity activity, @Nullable String str, @Nullable String str2) {
        FirebaseAnalytics firebaseAnalytics = this.mFirebaseAnalytics;
        if (firebaseAnalytics != null) {
            firebaseAnalytics.setCurrentScreen(activity, str, str2);
        }
    }

    public void settingBarColor() {
        if ((ChatVideoControl.a1().r != null && ChatVideoControl.a1().r.isShowing()) || skipBaseSettingBarColor() || (this instanceof ProfileActivity) || (this instanceof CameraNewActivity) || (this instanceof VideoPlayerActivity) || (this instanceof LoginActivity) || (this instanceof ForgetPassActivity) || (this instanceof SignUpActivity) || (this instanceof ResetPasswordActivity) || (this instanceof ChangePasswordActivity) || (this instanceof EditEmailActivity) || (this instanceof MyAccountActivity) || (this instanceof ThirdBindAccountActivity) || (this instanceof FriendProfileActivity) || (this instanceof ChatRoomInfoActivity) || (this instanceof ChatActivity) || (this instanceof ChatRoomActivity) || (this instanceof NewChatActivity) || (this instanceof OfficialAccountInfoActivity) || (this instanceof OfficialAccountActivity) || (this instanceof ControlLinkActivity)) {
            return;
        }
        boolean z = this instanceof MainActivity;
        if (!z) {
            kg3.f(this.activity, true);
        }
        if (z || (this instanceof ControlRouletteReportActivity) || (this instanceof ControlRouletteReportSuccessActivity) || (this instanceof ControlRouletteNoticeActivity)) {
            return;
        }
        kg3.f(this.activity, true);
        kg3.j(this.activity);
        kg3.l(this);
    }

    public void showDialog() {
        vr3 vr3Var;
        if (isFinishing() || isDestroyed() || (vr3Var = this.progressDialog) == null || vr3Var.isShowing()) {
            return;
        }
        this.progressDialog.show();
        delayTimeOut();
    }

    @Override // dc.ul2
    public void showErrorMsg(String str, boolean z) {
    }

    public void showLoadingProgress() {
        vr3 vr3Var;
        if (isFinishing() || isDestroyed() || (vr3Var = this.progressDialog) == null || vr3Var.isShowing()) {
            return;
        }
        this.progressDialog.show();
    }

    public void showUnlockAccount() {
        kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.offline_unlock_account), ah4.e(R.string.common_ok), false, false, (kn3.d) new b(this));
        kn3Var.show();
        kn3Var.n();
    }

    public boolean skipBaseSettingBarColor() {
        return false;
    }

    public void spotifyCheckIn(boolean z, l12.k kVar) {
        if (MusicControl.h0().e != null) {
            if (z) {
                MusicControl.h0().e.C(kVar);
                return;
            }
            MusicControl.h0().e.D(kVar);
            if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 1) {
                return;
            }
            MusicControl.h0().S();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        if (checkDoubleClick(intent)) {
            super.startActivityForResult(intent, i, bundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(R.layout.activity_base);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.fl_root_view);
        relativeLayout.removeAllViews();
        relativeLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        settingBarColor();
    }
}

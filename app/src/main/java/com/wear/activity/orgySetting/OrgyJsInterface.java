package com.wear.activity.orgySetting;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.activity.orgySetting.OrgyActivityBean;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.main.account.login.LoginFragment;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.TouchControlView;
import com.wear.widget.dialog.ToyDialog;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.gu3;
import dc.hu3;
import dc.mp1;
import dc.na2;
import dc.pc1;
import dc.pd3;
import dc.pj3;
import dc.qf3;
import dc.rf3;
import dc.rn3;
import dc.rq1;
import dc.sg3;
import dc.sz1;
import dc.tz1;
import dc.wq1;
import dc.xe3;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class OrgyJsInterface implements tz1 {
    private OrgyWebViewActivity activity;
    public boolean canControlIng = true;
    private boolean controlIng;
    public int index;
    private boolean isPlaying;
    private String[] patternArr;
    private Pattern playPattern;
    public List<Pattern> sysPatterns;
    private Timer timerPlay;
    private WebView webView;

    public OrgyJsInterface(OrgyWebViewActivity orgyWebViewActivity, WebView webView) {
        this.activity = orgyWebViewActivity;
        this.webView = webView;
        initCanControlIng();
        sz1.d().n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GetActivityInfoAndAutoJoin() {
        OrgySetting.getInstance().syncOrgyActivity(new OrgySetting.OnGetOrgyActivityListener() { // from class: com.wear.activity.orgySetting.OrgyJsInterface.1
            @Override // com.wear.activity.orgySetting.OrgySetting.OnGetOrgyActivityListener
            public void onGetOrgyActivity(OrgyActivityBean orgyActivityBean) {
                if (orgyActivityBean != null) {
                    if (TextUtils.isEmpty(orgyActivityBean.getJoinId())) {
                        OrgySetting.getInstance().joinOrgyActionByJs();
                        return;
                    }
                    OrgyActivityBean.StageListBean currentOrgyStageBean = OrgySetting.getInstance().getCurrentOrgyStageBean();
                    if (currentOrgyStageBean != null) {
                        EventBus.getDefault().post(new OrgyReloadUrlEvent(2, OrgySetting.getInstance().concatenateURL(currentOrgyStageBean.getOrgyPhaseUrl(), orgyActivityBean.getJoinId(), null, null)));
                    }
                }
            }

            @Override // com.wear.activity.orgySetting.OrgySetting.OnGetOrgyActivityListener
            public void onGetOrgyActivityFail() {
                EventBus.getDefault().post(new OrgyReloadUrlEvent(0, null));
                sg3.h(R.string.orgy_event_unable_join_notice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        ArrayList<Toy> arrayListP = pc1.a.P();
        if (arrayListP.isEmpty()) {
            return;
        }
        String[] strArr = new String[arrayListP.size()];
        for (int i = 0; i < arrayListP.size(); i++) {
            strArr[i] = arrayListP.get(i).getName();
        }
        this.webView.evaluateJavascript("javascript:getConnectToys('" + WearUtils.A.toJson(strArr) + "')", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getConnectToys() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: dc.cj1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        });
    }

    private void initCanControlIng() {
        rn3 rn3Var;
        User user;
        this.canControlIng = true;
        if (MusicControl.h0().O()) {
            this.canControlIng = false;
        }
        if (na2.m().f()) {
            this.canControlIng = false;
        }
        if (sz1.d().e() > 1) {
            this.canControlIng = false;
        }
        ChatActivity chatActivity = null;
        Iterator<Activity> it = pd3.j().a.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next instanceof ChatActivity) {
                chatActivity = (ChatActivity) next;
            }
        }
        if (chatActivity != null && (user = chatActivity.z) != null && user.isDateIng()) {
            this.canControlIng = false;
        }
        gu3 gu3Var = hu3.p;
        if (gu3Var != null && (rn3Var = gu3Var.a) != null && rn3Var.d()) {
            this.canControlIng = false;
        }
        if (qf3.a) {
            this.canControlIng = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playPattern(String str) throws Throwable {
        initCanControlIng();
        if (!this.canControlIng) {
            boolean z = this.controlIng;
            if (z && this.isPlaying) {
                stopPlay(z);
            }
            this.controlIng = false;
            return;
        }
        xe3.a("PatternPlayUtil", "开始webview Pattern" + this.isPlaying + "  path:" + str);
        this.controlIng = true;
        realPlayPattern(str);
    }

    private void realPlayPattern(final String str) throws Throwable {
        String strN1 = WearUtils.N1(str);
        if (TextUtils.isEmpty(strN1) || strN1.contains("result")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            sg3.h(R.string.file_notfound);
            return;
        }
        try {
            Timer timer = this.timerPlay;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.timerPlay = new Timer();
        this.index = 0;
        Pattern pattern = new Pattern();
        this.playPattern = pattern;
        pattern.setData(strN1);
        if (this.playPattern.getHead() == null) {
            this.patternArr = this.playPattern.getData().split(",");
        } else {
            this.patternArr = this.playPattern.getData().split(TouchControlView.P);
        }
        this.isPlaying = true;
        xe3.a("PatternPlayUtil", "realPlayPattern:");
        this.timerPlay.schedule(new TimerTask() { // from class: com.wear.activity.orgySetting.OrgyJsInterface.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws Throwable {
                if (!OrgyJsInterface.this.isPlaying) {
                    if (OrgyJsInterface.this.timerPlay != null) {
                        OrgyJsInterface.this.timerPlay.cancel();
                        return;
                    }
                    return;
                }
                int i = 0;
                if (OrgyJsInterface.this.patternArr != null) {
                    OrgyJsInterface orgyJsInterface = OrgyJsInterface.this;
                    if (orgyJsInterface.index + 1 < orgyJsInterface.patternArr.length) {
                        if (OrgyJsInterface.this.isPlaying) {
                            String str2 = OrgyJsInterface.this.patternArr[OrgyJsInterface.this.index];
                            xe3.a("PatternPlayUtil", "webview  Pattern数据:" + str2);
                            if (!WearUtils.e1(str2) && OrgyJsInterface.this.isPlaying) {
                                if (OrgyJsInterface.this.playPattern.getHead() == null) {
                                    try {
                                        rq1.d.e(Integer.parseInt(str2), new ToyControlBuilder(false, true, false, ToyControlBuilder.a.SPEED));
                                    } catch (NumberFormatException e2) {
                                        e2.printStackTrace();
                                    }
                                } else if (mp1.h()) {
                                    wq1.a(str2, OrgyJsInterface.this.playPattern, new ToyControlBuilder(false, true, false, ToyControlBuilder.a.SPEED));
                                } else {
                                    List<String> listCreateCommands = OrgyJsInterface.this.playPattern.getHead().createCommands(str2);
                                    if (listCreateCommands != null && OrgyJsInterface.this.isPlaying) {
                                        for (String str3 : listCreateCommands) {
                                            if (!OrgyJsInterface.this.isPlaying) {
                                                break;
                                            }
                                            if (listCreateCommands.size() == 1 || i < listCreateCommands.size() - 1) {
                                                WearUtils.x.G().f(str3);
                                            }
                                            i++;
                                            if (i >= listCreateCommands.size()) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            OrgyJsInterface.this.index++;
                            return;
                        }
                        return;
                    }
                }
                OrgyJsInterface orgyJsInterface2 = OrgyJsInterface.this;
                orgyJsInterface2.index = 0;
                orgyJsInterface2.isPlaying = false;
                OrgyJsInterface.this.playPattern(str);
            }
        }, 100L, 100L);
    }

    private void stopPlay(boolean z) {
        if (z) {
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.wear.activity.orgySetting.OrgyJsInterface.3
                    @Override // java.lang.Runnable
                    public void run() {
                        rq1.d.q();
                    }
                }, 500L);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Timer timer = this.timerPlay;
        if (timer != null) {
            timer.cancel();
        }
    }

    public void callJsMethod(String str) {
        if (this.webView != null) {
            showSupperFunction(str, ah4.e(R.string.orgy_event_join_notice));
        }
    }

    @JavascriptInterface
    public void connectToysInfoEvent() {
        getConnectToys();
    }

    @Override // dc.tz1
    public int getPriority() {
        return 1;
    }

    @JavascriptInterface
    public void giftCardActionPattern(String str) {
        int i;
        synchronized (this) {
            if (this.sysPatterns == null) {
                this.sysPatterns = rf3.f();
            }
            try {
                xe3.a("PatternPlayUtil", "giftCardActionPattern==>" + str);
                i = (Integer.parseInt(str) + (-1)) % this.sysPatterns.size();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i < this.sysPatterns.size()) {
                playPattern(this.sysPatterns.get(i).getFile().getAbsolutePath());
            }
        }
    }

    @JavascriptInterface
    public void gotoConnectToyPageEvent() {
        ToyDialog toyDialogA = ToyDialog.j.a();
        toyDialogA.z0(new ToyDialog.b() { // from class: dc.dj1
            @Override // com.wear.widget.dialog.ToyDialog.b
            public final void onDismiss() {
                this.a.getConnectToys();
            }
        });
        toyDialogA.show(this.activity.getSupportFragmentManager(), "");
    }

    public void onDestroy() {
        synchronized (this) {
            boolean z = this.controlIng;
            this.canControlIng = false;
            this.controlIng = false;
            stopPlay(z);
        }
    }

    @JavascriptInterface
    public void openOrgySyncVibrateButtonEvent() {
        if (OrgySetting.getInstance().isJoinIn()) {
            return;
        }
        OrgySetting.getInstance().joinOrgyAction();
    }

    @JavascriptInterface
    public void orgyJoin() {
        if (MyApplication.O) {
            if (OrgySetting.getInstance().hasOrgys()) {
                OrgySetting.getInstance().joinOrgyActionByJs();
                return;
            } else {
                GetActivityInfoAndAutoJoin();
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("intoType", 1);
        bundle.putBoolean("isDialogTheme", true);
        LoginFragment loginFragmentX0 = LoginFragment.x0(bundle);
        loginFragmentX0.J0(new LoginFragment.s() { // from class: dc.bj1
            @Override // com.wear.main.account.login.LoginFragment.s
            public final void a() {
                this.a.GetActivityInfoAndAutoJoin();
            }
        });
        loginFragmentX0.show(this.activity.getSupportFragmentManager(), "");
    }

    @JavascriptInterface
    public void orgyLovenseWeb(String str) {
        OrgyWebViewActivity orgyWebViewActivity = this.activity;
        if (orgyWebViewActivity == null || orgyWebViewActivity.isFinishing() || this.activity.isDestroyed()) {
            return;
        }
        try {
            pj3.w(this.activity, str);
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public void showSupperFunction(String str, String str2) {
        EventBus.getDefault().post(new OrgyReloadUrlEvent(2, str));
    }

    @Override // dc.tz1
    public void stop(int i) {
        this.canControlIng = false;
        if (this.controlIng) {
            onDestroy();
        }
    }

    @JavascriptInterface
    public boolean stopMusic() {
        this.activity.runOnMainThread(new Runnable() { // from class: com.wear.activity.orgySetting.OrgyJsInterface.2
            @Override // java.lang.Runnable
            public void run() {
                if (MusicControl.h0().r) {
                    MusicControl.h0().S();
                }
            }
        });
        return MusicControl.h0().r;
    }
}

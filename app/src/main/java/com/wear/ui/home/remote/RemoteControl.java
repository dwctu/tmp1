package com.wear.ui.home.remote;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.SyncAccessActivity;
import com.wear.bean.event.NinjaRemoteChangeEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.event.NotificationRemoteCloseEvent;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.ninja.NinjaLockActivity;
import com.wear.main.ninja.service.PlayService;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.multiToys.MultiControlPanel;
import dc.ah4;
import dc.cj3;
import dc.g12;
import dc.h12;
import dc.ka2;
import dc.mk2;
import dc.pc1;
import dc.pd3;
import dc.q53;
import dc.qf3;
import dc.tz1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class RemoteControl implements tz1, pd3.b, cj3.c {
    public static List<String> l;
    public static RemoteControl m;
    public boolean b;
    public PlayReceiver d;
    public q53 e;
    public MultiControlPanel f;
    public int g;
    public Handler h;
    public int i;
    public MyApplication j;
    public boolean k;
    public boolean a = false;
    public boolean c = false;

    public class PlayReceiver extends BroadcastReceiver {
        public PlayReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (PlayService.R) {
                    RemoteControl.this.r();
                    if ("com.wear.remote.notify.prev".equals(action)) {
                        RemoteControl remoteControl = RemoteControl.this;
                        remoteControl.i -= 20;
                        if (RemoteControl.this.i <= 0) {
                            RemoteControl.this.i = 0;
                        }
                        RemoteControl.this.f.setAllProgress(RemoteControl.this.i);
                        RemoteControl remoteControl2 = RemoteControl.this;
                        q53 q53Var = remoteControl2.e;
                        if (q53Var != null) {
                            q53Var.s(remoteControl2.i, RemoteControl.this.c);
                        }
                        if (RemoteControl.this.c) {
                            EventBus.getDefault().post(new NinjaRemoteChangeEvent(false, RemoteControl.this.i));
                        }
                        EventBus.getDefault().post(new NinjaRemoteChangeEvent(RemoteControl.this.i));
                        RemoteControl remoteControl3 = RemoteControl.this;
                        remoteControl3.c = false;
                        remoteControl3.g = 2;
                        return;
                    }
                    if ("com.wear.remote.notify.play_state".equals(action)) {
                        RemoteControl remoteControl4 = RemoteControl.this;
                        remoteControl4.c = remoteControl4.c ? false : true;
                        remoteControl4.w();
                        RemoteControl.this.g = 2;
                        return;
                    }
                    if (!"com.wear.remote.notify.next".equals(action)) {
                        if ("com.wear.remote.notify.close".equals(action)) {
                            RemoteControl.this.g();
                            RemoteControl remoteControl5 = RemoteControl.this;
                            remoteControl5.c = true;
                            q53 q53Var2 = remoteControl5.e;
                            if (q53Var2 != null) {
                                q53Var2.F();
                            }
                            EventBus.getDefault().post(new NotificationCloseEvent());
                            return;
                        }
                        return;
                    }
                    RemoteControl.this.i += 20;
                    if (RemoteControl.this.i >= 100) {
                        RemoteControl.this.i = 100;
                    }
                    RemoteControl.this.f.setAllProgress(RemoteControl.this.i);
                    RemoteControl remoteControl6 = RemoteControl.this;
                    q53 q53Var3 = remoteControl6.e;
                    if (q53Var3 != null) {
                        q53Var3.s(remoteControl6.i, RemoteControl.this.c);
                    }
                    if (RemoteControl.this.c) {
                        EventBus.getDefault().post(new NinjaRemoteChangeEvent(false, RemoteControl.this.i));
                    }
                    EventBus.getDefault().post(new NinjaRemoteChangeEvent(RemoteControl.this.i));
                    RemoteControl remoteControl7 = RemoteControl.this;
                    remoteControl7.c = false;
                    remoteControl7.g = 2;
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public class a implements ka2.k {
        public final /* synthetic */ MultiControlPanel a;

        public a(RemoteControl remoteControl, MultiControlPanel multiControlPanel) {
            this.a = multiControlPanel;
        }

        @Override // dc.ka2.k
        public void a() {
            this.a.k0(true);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteControl remoteControl = RemoteControl.this;
            if (remoteControl.c) {
                remoteControl.i = 0;
                RemoteControl.this.f.setAllProgress(RemoteControl.this.i);
            } else {
                remoteControl.i = 20;
                RemoteControl.this.f.setAllProgress(RemoteControl.this.i);
            }
            RemoteControl remoteControl2 = RemoteControl.this;
            q53 q53Var = remoteControl2.e;
            if (q53Var != null) {
                q53Var.s(remoteControl2.i, RemoteControl.this.c);
            }
            EventBus eventBus = EventBus.getDefault();
            RemoteControl remoteControl3 = RemoteControl.this;
            eventBus.post(new NinjaRemoteChangeEvent(remoteControl3.c, remoteControl3.i));
            EventBus.getDefault().post(new NinjaRemoteChangeEvent(RemoteControl.this.i));
        }
    }

    public RemoteControl() {
        new LinkedList();
        this.h = new Handler(Looper.getMainLooper());
        this.i = 0;
        this.k = false;
    }

    public static RemoteControl j() {
        if (m == null) {
            synchronized (RemoteControl.class) {
                if (m == null) {
                    m = new RemoteControl();
                }
            }
        }
        return m;
    }

    public void A() {
        this.a = true;
        this.c = false;
        m();
        if (mk2.P().h0()) {
            mk2.P().n0(true);
        }
    }

    @Override // dc.cj3.c
    public void a() {
        h();
    }

    public void f(Activity activity) {
        boolean z = this.b;
        if (z || z || !PlayService.R || (activity instanceof SyncAccessActivity) || (activity instanceof RemoteMultiControlActivity) || (activity instanceof NinjaLockActivity)) {
            return;
        }
        EventBus.getDefault().post(new NotificationRemoteCloseEvent());
    }

    public void g() {
        if (this.a) {
            q53 q53Var = this.e;
            if (q53Var != null) {
                q53Var.F();
            }
            this.a = false;
            this.h.removeCallbacksAndMessages(null);
            this.j.G().u0();
            if (this.k) {
                this.j.unregisterReceiver(this.d);
                this.k = false;
            }
            EventBus.getDefault().post(new NotificationRemoteCloseEvent());
            if (mk2.P().h0()) {
                mk2.P().n0(false);
            }
        }
        this.g = 0;
        List<String> list = l;
        if (list != null) {
            list.clear();
        }
        this.b = false;
        this.c = false;
        this.e = null;
        this.i = 0;
        pc1.a.I();
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    public void h() {
    }

    public int i() {
        return this.g;
    }

    public int k() {
        return this.i;
    }

    public void l(MyApplication myApplication, MultiControlPanel multiControlPanel) {
        this.j = myApplication;
        this.f = multiControlPanel;
        l = new ArrayList();
        v();
        ka2.C(true, null, new a(this, multiControlPanel));
    }

    public final void m() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.wear.remote.notify.prev");
        intentFilter.addAction("com.wear.remote.notify.play_state");
        intentFilter.addAction("com.wear.remote.notify.next");
        intentFilter.addAction("com.wear.remote.notify.close");
        PlayReceiver playReceiver = new PlayReceiver();
        this.d = playReceiver;
        if (Build.VERSION.SDK_INT >= 33) {
            this.j.registerReceiver(playReceiver, intentFilter, 4);
        } else {
            this.j.registerReceiver(playReceiver, intentFilter);
        }
        this.k = true;
    }

    @Override // dc.pd3.b
    public void n() {
    }

    public void o(Activity activity) {
    }

    @Override // dc.pd3.b
    public void p() {
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.pd3.b
    public void q() {
    }

    public void r() {
        MusicControl.h0();
        if (!h12.D.playPatternPause || WearUtils.r1()) {
            return;
        }
        MusicControl.h0();
        h12.D.playPatternPause = false;
        qf3.C();
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public void s() {
        if (this.c) {
            this.e = null;
            g();
        }
    }

    @Override // dc.tz1
    public void stop(int i) {
        g();
    }

    public final void t(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.h.post(runnable);
        }
    }

    public void u(int i) {
        this.g = i;
    }

    public void v() {
        try {
            if (PlayService.R) {
                EventBus.getDefault().post(new NinjaRemoteChangeEvent(ah4.e(R.string.ninja_control_running), this.c, this.i));
            } else {
                Intent intent = new Intent(this.j, (Class<?>) PlayService.class);
                intent.setAction("remote_start");
                intent.putExtra("remote_sensitivity", this.i);
                intent.putExtra("play_name", ah4.e(R.string.ninja_control_running));
                if (Build.VERSION.SDK_INT >= 26) {
                    this.j.startForegroundService(intent);
                } else {
                    this.j.startService(intent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public void w() {
        t(new b());
    }

    public void x() {
        EventBus.getDefault().post(new NinjaRemoteChangeEvent(this.c, this.i));
    }

    public void y(q53 q53Var) {
        this.e = q53Var;
    }

    public void z(Activity activity, g12.f fVar) {
    }
}

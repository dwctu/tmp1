package com.wear.main.longDistance.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.event.NinjaLiveChangeEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.event.NotificationLiveCloseEvent;
import com.wear.main.ninja.service.PlayService;
import com.wear.util.WearUtils;
import com.wear.widget.control.multiToys.MultiControlPanel;
import dc.ah4;
import dc.pc1;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class LiveControlNin {
    public static LiveControlNin h;
    public PlayReceiver b;
    public MultiControlPanel c;
    public boolean a = false;
    public int d = 0;
    public int e = 0;
    public boolean f = false;
    public Handler g = new Handler(Looper.getMainLooper());

    public class PlayReceiver extends BroadcastReceiver {
        public PlayReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (PlayService.R) {
                    boolean z = true;
                    if ("com.wear.live.notify.prev".equals(action)) {
                        LiveControlNin liveControlNin = LiveControlNin.this;
                        liveControlNin.d -= 20;
                        if (LiveControlNin.this.d <= 0) {
                            LiveControlNin.this.d = 0;
                        }
                        LiveControlNin.this.c.setAllProgress(LiveControlNin.this.d);
                        if (!LiveControlNin.this.a) {
                            EventBus.getDefault().post(new NinjaLiveChangeEvent(false, LiveControlNin.this.d));
                        }
                        EventBus.getDefault().post(new NinjaLiveChangeEvent(LiveControlNin.this.d));
                        LiveControlNin.this.a = true;
                        return;
                    }
                    if ("com.wear.live.notify.play_state".equals(action)) {
                        LiveControlNin liveControlNin2 = LiveControlNin.this;
                        if (liveControlNin2.a) {
                            z = false;
                        }
                        liveControlNin2.a = z;
                        liveControlNin2.j();
                        return;
                    }
                    if (!"com.wear.live.notify.next".equals(action)) {
                        if ("com.wear.live.notify.close".equals(action)) {
                            ChatLiveControl.q0().a();
                            return;
                        }
                        return;
                    }
                    LiveControlNin.this.d += 20;
                    if (LiveControlNin.this.d >= 100) {
                        LiveControlNin.this.d = 100;
                    }
                    LiveControlNin.this.c.setAllProgress(LiveControlNin.this.d);
                    if (!LiveControlNin.this.a) {
                        EventBus.getDefault().post(new NinjaLiveChangeEvent(false, LiveControlNin.this.d));
                    }
                    EventBus.getDefault().post(new NinjaLiveChangeEvent(LiveControlNin.this.d));
                    LiveControlNin.this.a = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LiveControlNin liveControlNin = LiveControlNin.this;
            if (liveControlNin.a) {
                liveControlNin.d = 20;
                LiveControlNin.this.c.setAllProgress(LiveControlNin.this.d);
            } else {
                liveControlNin.d = 0;
                LiveControlNin.this.c.setAllProgress(LiveControlNin.this.d);
            }
            EventBus.getDefault().post(new NinjaLiveChangeEvent(!r2.a, LiveControlNin.this.d));
            EventBus.getDefault().post(new NinjaLiveChangeEvent(LiveControlNin.this.d));
        }
    }

    public static LiveControlNin e() {
        if (h == null) {
            synchronized (LiveControlNin.class) {
                if (h == null) {
                    h = new LiveControlNin();
                }
            }
        }
        return h;
    }

    public void d() {
        if (this.a) {
            this.a = false;
        }
        this.g.removeCallbacksAndMessages(null);
        WearUtils.x.G().u0();
        if (this.f) {
            WearUtils.x.unregisterReceiver(this.b);
            this.f = false;
        }
        EventBus.getDefault().post(new NotificationLiveCloseEvent());
        EventBus.getDefault().post(new NotificationCloseEvent());
        this.d = 0;
        pc1.a.I();
    }

    public void f(MultiControlPanel multiControlPanel) {
        this.c = multiControlPanel;
        k();
        i();
    }

    public final void g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.wear.live.notify.prev");
        intentFilter.addAction("com.wear.live.notify.play_state");
        intentFilter.addAction("com.wear.live.notify.next");
        intentFilter.addAction("com.wear.live.notify.close");
        PlayReceiver playReceiver = new PlayReceiver();
        this.b = playReceiver;
        if (Build.VERSION.SDK_INT >= 33) {
            WearUtils.x.registerReceiver(playReceiver, intentFilter, 4);
        } else {
            WearUtils.x.registerReceiver(playReceiver, intentFilter);
        }
        this.f = true;
    }

    public final void h(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.g.post(runnable);
        }
    }

    public void i() {
        try {
            this.e = ChatLiveControl.q0().t0();
            if (PlayService.R) {
                EventBus.getDefault().post(new NinjaLiveChangeEvent(this.e > 0 ? ah4.e(R.string.ninja_control_running) : ah4.e(R.string.ninja_live_no_toy), !this.a, this.d));
                return;
            }
            Intent intent = new Intent(WearUtils.x, (Class<?>) PlayService.class);
            intent.setAction("live_start");
            intent.putExtra("live_sensitivity", this.d);
            intent.putExtra("play_name", this.e > 0 ? ah4.e(R.string.ninja_control_running) : ah4.e(R.string.ninja_live_no_toy));
            if (Build.VERSION.SDK_INT >= 26) {
                WearUtils.x.startForegroundService(intent);
            } else {
                WearUtils.x.startService(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public void j() {
        h(new a());
    }

    public void k() {
        this.a = true;
        g();
    }

    public void l(int i) {
        int i2 = this.e;
        if (i2 == 0 && i == 0) {
            return;
        }
        if (i2 <= 0 || i <= 0) {
            this.e = i;
            EventBus.getDefault().post(new NinjaLiveChangeEvent(ah4.e(i > 0 ? R.string.ninja_control_running : R.string.ninja_live_no_toy), !this.a, this.d));
        }
    }
}

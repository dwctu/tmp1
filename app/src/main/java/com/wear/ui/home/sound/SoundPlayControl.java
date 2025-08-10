package com.wear.ui.home.sound;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.SyncAccessActivity;
import com.wear.bean.Toy;
import com.wear.bean.event.NinjaSoundChangeEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.event.NotificationSoundCloseEvent;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.MusicRecordPreviewActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.alarm.AlarmSoundPlayActivity;
import com.wear.main.game.ui.GameActivity;
import com.wear.main.longDistance.player.ui.PlayerActivity;
import com.wear.main.ninja.NinjaLockActivity;
import com.wear.main.ninja.service.PlayService;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.ui.discover.speedMode.SpeedModeActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.ControlExpandDialog;
import dc.Event;
import dc.ExpandData;
import dc.a22;
import dc.ah4;
import dc.be3;
import dc.c22;
import dc.cs3;
import dc.e22;
import dc.eg3;
import dc.f22;
import dc.g22;
import dc.h12;
import dc.h22;
import dc.is3;
import dc.me3;
import dc.mk2;
import dc.pc1;
import dc.pj3;
import dc.qf3;
import dc.sg3;
import dc.u53;
import dc.w12;
import dc.x12;
import dc.y12;
import dc.ye3;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class SoundPlayControl implements x12 {
    public static final String A = SoundPlayActivity.class.getSimpleName();
    public PlayReceiver d;
    public u53 e;
    public File g;
    public int m;
    public int n;
    public MyApplication p;
    public TextView q;
    public long s;
    public f22 t;
    public h22 u;
    public g22 v;
    public e22 w;
    public List<Class<? extends Activity>> x;
    public WeakReference<ControlExpandDialog> y;
    public boolean a = false;
    public boolean b = false;
    public long c = 0;
    public MediaRecorder f = null;
    public int h = 1;
    public int i = 55;
    public LinkedList<Integer> j = new LinkedList<>();
    public int k = 5;
    public Handler l = new Handler(Looper.getMainLooper());
    public int o = 75;
    public boolean r = false;
    public Runnable z = new d();

    public class PlayReceiver extends BroadcastReceiver {
        public PlayReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (PlayService.R) {
                    SoundPlayControl.this.R();
                    if ("com.wear.sound.notify.prev".equals(action)) {
                        if (SoundPlayControl.this.b) {
                            EventBus.getDefault().post(new NinjaSoundChangeEvent(false, SoundPlayControl.this.o));
                        }
                        SoundPlayControl.this.b = false;
                        r4.o -= 20;
                        if (SoundPlayControl.this.o <= 0) {
                            SoundPlayControl.this.o = 0;
                        }
                        eg3.i(SoundPlayControl.this.p, "sensitivity_seek", Integer.valueOf(SoundPlayControl.this.o));
                        SoundPlayControl soundPlayControl = SoundPlayControl.this;
                        u53 u53Var = soundPlayControl.e;
                        if (u53Var != null) {
                            u53Var.s(soundPlayControl.o, SoundPlayControl.this.b);
                        }
                        EventBus.getDefault().post(new NinjaSoundChangeEvent(SoundPlayControl.this.o));
                        return;
                    }
                    if ("com.wear.sound.notify.play_state".equals(action)) {
                        SoundPlayControl.this.U();
                        return;
                    }
                    if (!"com.wear.sound.notify.next".equals(action)) {
                        if ("com.wear.sound.notify.close".equals(action)) {
                            SoundPlayControl.this.K();
                            SoundPlayControl soundPlayControl2 = SoundPlayControl.this;
                            soundPlayControl2.b = true;
                            u53 u53Var2 = soundPlayControl2.e;
                            if (u53Var2 != null) {
                                u53Var2.F();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (SoundPlayControl.this.b) {
                        EventBus.getDefault().post(new NinjaSoundChangeEvent(false, SoundPlayControl.this.o));
                    }
                    SoundPlayControl soundPlayControl3 = SoundPlayControl.this;
                    soundPlayControl3.b = false;
                    soundPlayControl3.o += 20;
                    if (SoundPlayControl.this.o >= 100) {
                        SoundPlayControl.this.o = 100;
                    }
                    eg3.i(SoundPlayControl.this.p, "sensitivity_seek", Integer.valueOf(SoundPlayControl.this.o));
                    SoundPlayControl soundPlayControl4 = SoundPlayControl.this;
                    u53 u53Var3 = soundPlayControl4.e;
                    if (u53Var3 != null) {
                        u53Var3.s(soundPlayControl4.o, SoundPlayControl.this.b);
                    }
                    EventBus.getDefault().post(new NinjaSoundChangeEvent(SoundPlayControl.this.o));
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public class a extends h22 {
        public a(SoundPlayControl soundPlayControl) {
        }

        @Override // dc.f22
        public void b(Map map) {
        }

        @Override // dc.f22
        public void c(Map map) {
        }
    }

    public class b extends g22 {
        public b() {
        }

        @Override // dc.g22, dc.f22
        public void b(Map map) throws IllegalStateException, IOException {
            super.b(map);
            SoundPlayControl soundPlayControl = SoundPlayControl.this;
            soundPlayControl.a = true;
            soundPlayControl.b = false;
            soundPlayControl.s = be3.r();
            WearUtils.y();
            SoundPlayControl.this.T();
            SoundPlayControl.this.Z();
            SoundPlayControl.this.P();
            if (mk2.P().h0()) {
                mk2.P().n0(true);
            }
            me3.e(me3.a.SOUND_CONTROL);
        }

        @Override // dc.f22
        public void c(Map map) {
            SoundPlayControl soundPlayControl = SoundPlayControl.this;
            if (soundPlayControl.a) {
                if (soundPlayControl.g != null) {
                    try {
                        WearUtils.R1(SoundPlayControl.this.g);
                    } catch (Exception unused) {
                    }
                }
                u53 u53Var = SoundPlayControl.this.e;
                if (u53Var != null) {
                    u53Var.F();
                }
                if (mk2.P().h0()) {
                    mk2.P().n0(false);
                }
                if (SoundPlayControl.this.a) {
                    me3.e(me3.a.OTHERS);
                }
                SoundPlayControl soundPlayControl2 = SoundPlayControl.this;
                soundPlayControl2.a = false;
                soundPlayControl2.l.removeCallbacksAndMessages(null);
                SoundPlayControl.this.p.G().u0();
                if (SoundPlayControl.this.r) {
                    SoundPlayControl.this.r = false;
                    SoundPlayControl.this.p.unregisterReceiver(SoundPlayControl.this.d);
                }
                SoundPlayControl.this.L();
                EventBus.getDefault().post(new NotificationSoundCloseEvent());
                EventBus.getDefault().post(new NotificationCloseEvent());
                SoundPlayControl.this.H();
            }
            SoundPlayControl soundPlayControl3 = SoundPlayControl.this;
            soundPlayControl3.b = false;
            soundPlayControl3.e = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SoundPlayControl soundPlayControl = SoundPlayControl.this;
            if (soundPlayControl.b) {
                soundPlayControl.b = false;
                soundPlayControl.s = be3.r();
            } else {
                soundPlayControl.b = true;
                soundPlayControl.H();
                SoundPlayControl.this.p.G().u0();
            }
            SoundPlayControl soundPlayControl2 = SoundPlayControl.this;
            if (soundPlayControl2.b) {
                soundPlayControl2.w.e();
            } else {
                soundPlayControl2.w.c();
            }
            SoundPlayControl soundPlayControl3 = SoundPlayControl.this;
            u53 u53Var = soundPlayControl3.e;
            if (u53Var != null) {
                u53Var.s(soundPlayControl3.o, SoundPlayControl.this.b);
            }
            EventBus eventBus = EventBus.getDefault();
            SoundPlayControl soundPlayControl4 = SoundPlayControl.this;
            eventBus.post(new NinjaSoundChangeEvent(soundPlayControl4.b, soundPlayControl4.o));
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SoundPlayControl.this.a0();
            SoundPlayControl soundPlayControl = SoundPlayControl.this;
            u53 u53Var = soundPlayControl.e;
            if (u53Var != null) {
                if (soundPlayControl.b) {
                    u53Var.M2(0, soundPlayControl.o, 0);
                } else {
                    u53Var.M2(soundPlayControl.m, SoundPlayControl.this.o, SoundPlayControl.this.n);
                }
            }
        }
    }

    public class e implements is3.d {
        public final /* synthetic */ Activity a;

        public e(SoundPlayControl soundPlayControl, Activity activity) {
            this.a = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            pj3.f(this.a, SoundPlayActivity.class);
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            SoundPlayControl.this.y = null;
            SoundPlayControl.this.q = null;
        }
    }

    public class g implements is3.c {
        public g() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            SoundPlayControl.this.w.b();
        }
    }

    public class h implements ControlExpandDialog.c {
        public h() {
        }

        @Override // com.wear.widget.dialog.ControlExpandDialog.c
        public void end() {
            SoundPlayControl.this.K();
        }
    }

    public SoundPlayControl(e22 e22Var) {
        this.w = e22Var;
        N();
    }

    public static SoundPlayControl M() {
        return (SoundPlayControl) y12.c.a().i(y12.c.TYPE_SOUND);
    }

    public final void H() {
        long jR = be3.r();
        long j = this.s;
        int i = (int) ((jR - j) / 1000);
        if (j > 0 && i >= 5) {
            HashMap map = new HashMap();
            map.put(TypedValues.TransitionType.S_DURATION, Integer.valueOf(i));
            ArrayList arrayList = new ArrayList();
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getDeviceId());
            }
            map.put("toy_mac", arrayList);
            ye3.d("M0048", WearUtils.A.toJson(map));
        }
        this.s = 0L;
    }

    public final int I() {
        int iIntValue = 0;
        if (this.j.size() == 0) {
            return 0;
        }
        Iterator<Integer> it = this.j.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next != null) {
                iIntValue += next.intValue();
            }
        }
        return iIntValue / this.j.size();
    }

    public void J() {
        this.e = null;
    }

    public void K() {
        h(new Event(c22.EVENT_STOP, null));
    }

    public final synchronized void L() {
        MediaRecorder mediaRecorder = this.f;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
                this.f.release();
                this.f = null;
            } catch (Exception unused) {
            }
        }
    }

    public void N() {
        this.p = WearUtils.x;
        Q();
        O();
    }

    public final void O() {
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        arrayList.add(SyncAccessActivity.class);
        this.x.add(NinjaLockActivity.class);
        this.x.add(SoundPlayActivity.class);
    }

    public final void P() {
        if (this.r) {
            return;
        }
        this.r = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.wear.sound.notify.prev");
        intentFilter.addAction("com.wear.sound.notify.play_state");
        intentFilter.addAction("com.wear.sound.notify.next");
        intentFilter.addAction("com.wear.sound.notify.close");
        PlayReceiver playReceiver = new PlayReceiver();
        this.d = playReceiver;
        if (Build.VERSION.SDK_INT >= 33) {
            this.p.registerReceiver(playReceiver, intentFilter, 4);
        } else {
            this.p.registerReceiver(playReceiver, intentFilter);
        }
    }

    public final void Q() {
        a aVar = new a(this);
        this.u = aVar;
        this.v = new b();
        this.t = aVar;
    }

    public void R() {
        if (!h12.D.playPatternPause || WearUtils.r1()) {
            return;
        }
        h12.D.playPatternPause = false;
        qf3.C();
    }

    public final void S(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.l.post(runnable);
        }
    }

    public void T() {
        try {
            if (PlayService.R) {
                EventBus.getDefault().post(new NinjaSoundChangeEvent(ah4.e(R.string.closeRange_sound), this.b, this.o));
            } else {
                Intent intent = new Intent(this.p, (Class<?>) PlayService.class);
                intent.setAction("sound_start");
                intent.putExtra("sound_sensitivity", this.o);
                intent.putExtra("play_name", ah4.e(R.string.closeRange_sound));
                if (Build.VERSION.SDK_INT >= 26) {
                    this.p.startForegroundService(intent);
                } else {
                    this.p.startService(intent);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public void U() {
        S(new c());
    }

    public void V() {
        if (this.b) {
            this.w.e();
        } else {
            this.w.c();
        }
        EventBus.getDefault().post(new NinjaSoundChangeEvent(this.b, this.o));
    }

    public void W(int i) {
        this.o = i;
        EventBus.getDefault().post(new NinjaSoundChangeEvent(i));
    }

    public void X(u53 u53Var) {
        this.e = u53Var;
    }

    public void Y() {
        h(new Event(c22.EVENT_START, null));
    }

    public final void Z() throws IllegalStateException, IOException {
        MediaRecorder mediaRecorder = this.f;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (IllegalStateException unused) {
                this.f = null;
                this.f = new MediaRecorder();
            }
            this.f.release();
            this.f = null;
        }
        this.g = new File(WearUtils.K);
        MediaRecorder mediaRecorder2 = new MediaRecorder();
        this.f = mediaRecorder2;
        try {
            mediaRecorder2.setAudioSource(1);
            this.f.setOutputFormat(3);
            this.f.setAudioEncoder(0);
            this.f.setOutputFile(this.g.getAbsolutePath());
            try {
                this.f.prepare();
            } catch (Exception unused2) {
                MediaRecorder mediaRecorder3 = this.f;
                if (mediaRecorder3 != null) {
                    mediaRecorder3.release();
                }
                this.f = null;
                MediaRecorder mediaRecorder4 = new MediaRecorder();
                this.f = mediaRecorder4;
                mediaRecorder4.setAudioSource(1);
                this.f.setOutputFormat(3);
                this.f.setAudioEncoder(0);
                this.f.setOutputFile(this.g.getAbsolutePath());
                try {
                    this.f.prepare();
                } catch (Exception unused3) {
                }
            }
            MediaRecorder mediaRecorder5 = this.f;
            if (mediaRecorder5 == null) {
                sg3.i(this.p, R.string.sound_recorder_start_error);
                u53 u53Var = this.e;
                if (u53Var != null) {
                    u53Var.F();
                    return;
                }
                return;
            }
            try {
                mediaRecorder5.start();
                a0();
            } catch (Exception unused4) {
                sg3.i(this.p, R.string.sound_recorder_start_error);
                u53 u53Var2 = this.e;
                if (u53Var2 != null) {
                    u53Var2.F();
                }
            }
        } catch (Exception unused5) {
            sg3.i(this.p, R.string.sound_recorder_start_error);
            u53 u53Var3 = this.e;
            if (u53Var3 != null) {
                u53Var3.F();
            }
        }
    }

    @Override // dc.x12
    public boolean a() {
        WeakReference<ControlExpandDialog> weakReference = this.y;
        return (weakReference == null || weakReference.get() == null || !this.y.get().isShowing()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a0() {
        /*
            r10 = this;
            android.media.MediaRecorder r0 = r10.f
            if (r0 == 0) goto Ld3
            boolean r1 = r10.b
            r2 = 0
            if (r1 != 0) goto Lc5
            int r0 = r0.getMaxAmplitude()
            int r1 = r10.h
            int r0 = r0 / r1
            r1 = 30
            r3 = 1
            if (r0 <= r3) goto L30
            r4 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r6 = (double) r0
            double r6 = java.lang.Math.log10(r6)
            double r6 = r6 * r4
            int r0 = (int) r6
            r10.n = r0
            int r4 = r0 + (-45)
            if (r4 >= 0) goto L32
            int r5 = java.lang.Math.abs(r4)
            if (r5 >= r1) goto L31
            int r4 = java.lang.Math.abs(r4)
            goto L32
        L30:
            r0 = 0
        L31:
            r4 = 0
        L32:
            r10.m = r4
            long r5 = r10.c
            r7 = 1
            long r5 = r5 + r7
            r10.c = r5
            r7 = 5
            long r5 = r5 % r7
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto Lc9
            r10.c = r7
            java.util.LinkedList<java.lang.Integer> r5 = r10.j
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r5.add(r6)
            java.util.LinkedList<java.lang.Integer> r5 = r10.j
            int r5 = r5.size()
            int r6 = r10.k
            if (r5 <= r6) goto L5e
            java.util.LinkedList<java.lang.Integer> r5 = r10.j
            r5.remove()
        L5e:
            int r5 = r10.I()
            if (r5 < r1) goto L69
        L64:
            int r1 = r4 - r5
            int r1 = r1 + 12
            goto L79
        L69:
            r1 = 25
            if (r5 < r1) goto L6e
            goto L64
        L6e:
            r1 = 10
            if (r5 < r1) goto L77
            int r1 = r4 - r5
            int r1 = r1 + 8
            goto L79
        L77:
            int r1 = r4 / 3
        L79:
            int r1 = r1 * 5
            int r6 = r10.o
            r7 = 100
            int r6 = r6 + r7
            int r1 = r1 * r6
            int r1 = r1 / r7
            int r1 = java.lang.Math.min(r1, r7)
            int r1 = java.lang.Math.max(r1, r3)
            int r6 = r10.o
            int r1 = r1 * r6
            int r1 = r1 / r7
            java.lang.String r6 = com.wear.ui.home.sound.SoundPlayControl.A
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "分贝值："
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = " "
            r7.append(r5)
            r7.append(r0)
            r7.append(r5)
            r7.append(r4)
            r7.append(r5)
            r7.append(r1)
            java.lang.String r0 = r7.toString()
            dc.xe3.a(r6, r0)
            dc.rq1 r0 = dc.rq1.d
            dc.tq1 r4 = new dc.tq1
            r4.<init>(r3, r3, r2)
            r0.e(r1, r4)
            goto Lc9
        Lc5:
            r10.n = r2
            r10.m = r2
        Lc9:
            android.os.Handler r0 = r10.l
            java.lang.Runnable r1 = r10.z
            int r2 = r10.i
            long r2 = (long) r2
            r0.postDelayed(r1, r2)
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.home.sound.SoundPlayControl.a0():void");
    }

    @Override // dc.x12
    public /* synthetic */ boolean b(f22 f22Var, Map map) {
        return w12.a(this, f22Var, map);
    }

    @Override // dc.x12
    public void c(@Nullable f22 f22Var) {
        this.t = f22Var;
    }

    @Override // dc.x12
    @Nullable
    public String d() {
        return null;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: e */
    public f22 getI() {
        return this.t;
    }

    @Override // dc.x12
    public boolean f() {
        return true;
    }

    @Override // dc.x12
    public void g() {
        WeakReference<ControlExpandDialog> weakReference = this.y;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.y.get().dismiss();
    }

    @Override // dc.x12
    @NonNull
    public a22 getPriority() {
        return a22.PRIORITY_1;
    }

    @Override // dc.x12
    public /* synthetic */ boolean h(Event event) {
        return w12.b(this, event);
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: i */
    public h22 getJ() {
        return this.u;
    }

    @Override // dc.x12
    public void j(boolean z, int i, int i2) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null || fragmentActivityH.isDestroyed() || fragmentActivityH.isFinishing()) {
            return;
        }
        this.w.f();
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.d(new e(this, fragmentActivityH));
        ExpandData expandData = new ExpandData();
        expandData.k(z);
        expandData.p(i);
        expandData.q(i2);
        expandData.l(ah4.e(R.string.closeRange_sound));
        expandData.j(R.drawable.full_control_sound);
        bVar.e(expandData);
        bVar.f(new f());
        bVar.c(new g());
        WeakReference<ControlExpandDialog> weakReference = new WeakReference<>((ControlExpandDialog) cs3.i(bVar, ControlExpandDialog.class));
        this.y = weakReference;
        weakReference.get().p(fragmentActivityH);
        this.y.get().show();
        this.y.get().setListener(new h());
        TextView textView = (TextView) this.y.get().findViewById(R.id.tv_time);
        this.q = textView;
        textView.setVisibility(8);
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: k */
    public e22 getA() {
        return this.w;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: l */
    public g22 getK() {
        return this.v;
    }

    @Override // dc.x12
    public void m(Activity activity) {
        if ((activity instanceof MusicRecordActivity) || (activity instanceof AlarmSoundPlayActivity) || (activity instanceof RemoteControlActivity) || (activity instanceof RemoteMultiControlActivity) || (activity instanceof CreatePatternActivity) || (activity instanceof PatternPlayActivity) || (activity instanceof MusicRecordPreviewActivity) || (activity instanceof GameActivity) || (activity instanceof PlayerActivity) || (activity instanceof SpeedModeActivity)) {
            K();
        }
    }

    @Override // dc.x12
    @Nullable
    public List<Class<? extends Activity>> n() {
        return this.x;
    }

    @Override // dc.x12
    @Nullable
    public String o() {
        return "sound_data.json";
    }
}

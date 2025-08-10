package com.wear.ui.discover.speedMode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.SyncAccessActivity;
import com.wear.bean.Toy;
import com.wear.bean.ToySelectEvent;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.bean.event.NinjaSpeedModeChangeEvent;
import com.wear.bean.event.NotificationSpeedModeCloseEvent;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.alarm.AlarmSoundPlayActivity;
import com.wear.main.game.ui.GameActivity;
import com.wear.main.longDistance.player.ui.PlayerActivity;
import com.wear.main.ninja.NinjaLockActivity;
import com.wear.main.ninja.service.PlayService;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.main.toy.EditToyNameActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.main.toy.ToyConnectActivity;
import com.wear.main.toy.ToyDepthControlActivity;
import com.wear.main.toy.ToyDfuActivity;
import com.wear.main.toy.ToyProgramActivity;
import com.wear.main.toy.ToySearchActivity;
import com.wear.main.toy.ToySettingActivity;
import com.wear.main.toy.ToyStrengthActivity;
import com.wear.main.toy.pin.ToyPinSettingActivity;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.SpeedModeExpandDialog;
import dc.Event;
import dc.ExpandData;
import dc.a22;
import dc.ah4;
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
import dc.rq1;
import dc.w12;
import dc.x12;
import dc.xc1;
import dc.y12;
import dc.ye3;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SpeedModeControl implements x12 {
    public static final String z = "com.wear.ui.discover.speedMode.SpeedModeControl";
    public Context a;
    public PlayReceiver b;
    public int d;
    public int e;
    public float f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public LocationManager n;
    public LocationListener o;
    public SensorManager p;
    public Sensor q;
    public SensorEventListener r;
    public WeakReference<h> s;
    public f22 t;
    public h22 u;
    public g22 v;
    public e22 w;
    public List<Class<? extends Activity>> x;
    public WeakReference<SpeedModeExpandDialog> y;
    public boolean c = false;
    public Map<String, Toy> l = new HashMap();
    public Handler m = new Handler(Looper.getMainLooper());

    public class PlayReceiver extends BroadcastReceiver {
        public PlayReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                String unused = SpeedModeControl.z;
                String str = "onReceive：" + action;
                if (PlayService.R) {
                    if ("com.wear.speed_mode.notify.prev".equals(action)) {
                        SpeedModeControl.this.W(0, 2);
                    } else if ("com.wear.speed_mode.notify.play_state".equals(action)) {
                        SpeedModeControl.this.N();
                    } else if ("com.wear.speed_mode.notify.next".equals(action)) {
                        SpeedModeControl.this.W(0, 1);
                    } else if ("com.wear.speed_mode.notify.close".equals(action)) {
                        SpeedModeControl.this.a0();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public class a extends h22 {
        public a(SpeedModeControl speedModeControl) {
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
        public void b(Map map) throws JSONException {
            super.b(map);
            SpeedModeControl.this.O();
        }

        @Override // dc.f22
        public void c(Map map) throws JSONException {
            SpeedModeControl.this.P();
        }
    }

    public class c implements LocationListener {
        public c() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            String unused = SpeedModeControl.z;
            String str = "time:" + System.currentTimeMillis() + ", lat:" + location.getLatitude() + ", long:" + location.getLongitude() + ", speed:" + location.getSpeed() + ", provider:" + location.getProvider();
            SpeedModeControl.this.f = location.getSpeed();
            if (SpeedModeControl.this.s == null || SpeedModeControl.this.s.get() == null) {
                return;
            }
            ((h) SpeedModeControl.this.s.get()).r0(SpeedModeControl.this.f);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public class d implements SensorEventListener {
        public d() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float fSqrt = (float) Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d));
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - SpeedModeControl.this.g >= 100) {
                SpeedModeControl.this.g = jCurrentTimeMillis;
                rq1.d.j(SpeedModeControl.this.D(fSqrt));
            }
            if (jCurrentTimeMillis - SpeedModeControl.this.h >= 100) {
                SpeedModeControl.this.h = jCurrentTimeMillis;
                if (SpeedModeControl.this.s == null || SpeedModeControl.this.s.get() == null) {
                    return;
                }
                ((h) SpeedModeControl.this.s.get()).S2(fSqrt);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpeedModeControl.this.c) {
                SpeedModeControl.this.w.c();
            } else {
                SpeedModeControl.this.w.e();
            }
        }
    }

    public class f implements is3.d {
        public final /* synthetic */ Activity a;

        public f(SpeedModeControl speedModeControl, Activity activity) {
            this.a = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            pj3.f(this.a, SpeedModeActivity.class);
        }
    }

    public class g implements is3.c {
        public g() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            SpeedModeControl.this.w.b();
        }
    }

    public interface h {
        void S2(float f);

        void r0(float f);
    }

    public SpeedModeControl(e22 e22Var) {
        Context applicationContext = MyApplication.N().getApplicationContext();
        this.a = applicationContext;
        this.d = eg3.f(applicationContext, "speed_mode_sensitivity", 75);
        this.e = eg3.f(this.a, "speed_mode_base_level", 3);
        this.w = e22Var;
        I();
        F();
        G();
        H();
        EventBus.getDefault().register(this);
    }

    public static SpeedModeControl C() {
        return (SpeedModeControl) y12.c.a().i(y12.c.TYPE_SPEED_MODE);
    }

    public final void A(int i) throws JSONException {
        if (this.l.isEmpty()) {
            return;
        }
        if (this.i != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.j = jCurrentTimeMillis;
            this.k += jCurrentTimeMillis - this.i;
        }
        if (this.k > 1000) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mode_type", 1);
                jSONObject.put("end_type", i);
                jSONObject.put(TypedValues.TransitionType.S_DURATION, this.k / 1000);
                ArrayList arrayList = new ArrayList();
                Iterator<Toy> it = this.l.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getAddress().toLowerCase().replace(SignatureImpl.INNER_SEP, ""));
                }
                jSONObject.put("toy_mac", WearUtils.A.toJson(arrayList));
                ye3.d("C0013", jSONObject.toString());
                String str = z + "_addLog";
                jSONObject.toString();
                this.k = 0L;
                this.i = 0L;
                this.j = 0L;
                this.l.clear();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public int B() {
        return this.e;
    }

    public final int D(float f2) {
        if (this.f == 0.0f) {
        }
        int i = (int) (this.e + f2);
        if (i > 20) {
            return 20;
        }
        return i;
    }

    public int E() {
        return this.d;
    }

    public final void F() {
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        arrayList.add(SpeedModeActivity.class);
        this.x.add(SyncAccessActivity.class);
        this.x.add(NinjaLockActivity.class);
        this.x.add(ToyActivity.class);
        this.x.add(ToySearchActivity.class);
        this.x.add(ToySettingActivity.class);
        this.x.add(EditToyNameActivity.class);
        this.x.add(ToyProgramActivity.class);
        this.x.add(ToyStrengthActivity.class);
        this.x.add(ToyDepthControlActivity.class);
        this.x.add(ToyDfuActivity.class);
        this.x.add(ToyPinSettingActivity.class);
        this.x.add(ToyConnectActivity.class);
    }

    public final void G() {
        if (this.n == null) {
            this.n = (LocationManager) this.a.getSystemService(FirebaseAnalytics.Param.LOCATION);
        }
        if (this.o == null) {
            this.o = new c();
        }
    }

    public final void H() {
        if (this.p == null) {
            this.p = (SensorManager) this.a.getSystemService("sensor");
        }
        if (this.q == null) {
            this.q = this.p.getDefaultSensor(10);
        }
        if (this.r == null) {
            this.r = new d();
        }
    }

    public final void I() {
        a aVar = new a(this);
        this.u = aVar;
        this.v = new b();
        this.t = aVar;
    }

    public boolean J() {
        return this.n.isProviderEnabled("gps") || this.n.isProviderEnabled("network");
    }

    public boolean K() {
        return this.c;
    }

    public boolean L() {
        return this.t == this.v;
    }

    public void M() {
        if (!h12.D.playPatternPause || WearUtils.r1()) {
            return;
        }
        h12.D.playPatternPause = false;
        qf3.C();
    }

    public void N() {
        this.c = !this.c;
        EventBus.getDefault().post(new NinjaSpeedModeChangeEvent(1, !this.c, this.d));
        if (this.c) {
            Y();
            Z();
            M();
            if (!pc1.a.P().isEmpty()) {
                this.i = System.currentTimeMillis();
            }
        } else {
            b0();
            c0();
            pc1.a.u0();
            if (this.i != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.j = jCurrentTimeMillis;
                this.k += jCurrentTimeMillis - this.i;
                this.i = 0L;
                this.j = 0L;
            }
        }
        R(new e());
    }

    public void O() throws JSONException {
        me3.e(me3.a.SPEED_MODE);
        this.c = true;
        Y();
        Z();
        M();
        U();
        if (mk2.P().h0()) {
            mk2.P().n0(true);
        }
    }

    public void P() throws JSONException {
        if (this.c) {
            b0();
            c0();
        }
        if (mk2.P().h0() && L()) {
            mk2.P().n0(false);
        }
        me3.e(me3.a.OTHERS);
        this.c = false;
        d0();
        EventBus.getDefault().post(new NotificationSpeedModeCloseEvent());
        pc1.a.u0();
        A(0);
    }

    public final void Q() {
        if (this.b == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.wear.speed_mode.notify.prev");
            intentFilter.addAction("com.wear.speed_mode.notify.play_state");
            intentFilter.addAction("com.wear.speed_mode.notify.next");
            intentFilter.addAction("com.wear.speed_mode.notify.close");
            PlayReceiver playReceiver = new PlayReceiver();
            this.b = playReceiver;
            if (Build.VERSION.SDK_INT >= 33) {
                this.a.registerReceiver(playReceiver, intentFilter, 4);
            } else {
                this.a.registerReceiver(playReceiver, intentFilter);
            }
        }
    }

    public final void R(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.m.post(runnable);
        }
    }

    public void S(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.e = i;
        eg3.k(this.a, "speed_mode_base_level", i);
    }

    public void T(h hVar) {
        this.s = new WeakReference<>(hVar);
    }

    public final void U() throws JSONException {
        ArrayList<Toy> arrayListP = pc1.a.P();
        String str = z + "_addLog";
        String str2 = "toyList.size:" + arrayListP.size();
        if (arrayListP.isEmpty()) {
            A(1);
            return;
        }
        Iterator<Toy> it = arrayListP.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (!this.l.containsKey(next.getAddress())) {
                this.l.put(next.getAddress(), next);
            }
        }
        String str3 = z + "_addLog";
        String str4 = "controlStartTime:" + this.i + ", isPlaying:" + this.c;
        if (this.i == 0 && this.c) {
            this.i = System.currentTimeMillis();
        }
    }

    public void V() {
        if (L()) {
            try {
                boolean z2 = true;
                if (PlayService.R) {
                    EventBus eventBus = EventBus.getDefault();
                    if (this.c) {
                        z2 = false;
                    }
                    eventBus.post(new NinjaSpeedModeChangeEvent(0, z2, this.d));
                    return;
                }
                Intent intent = new Intent(this.a, (Class<?>) PlayService.class);
                intent.setAction("speed_mode_start");
                intent.putExtra("play_name", ah4.e(R.string.discover_speed_mode));
                if (this.c) {
                    z2 = false;
                }
                intent.putExtra("pattern_pause", z2);
                intent.putExtra("speed_mode_sensitivity", this.d);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.a.startForegroundService(intent);
                } else {
                    this.a.startService(intent);
                }
                Q();
            } catch (Exception e2) {
                e2.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
        }
    }

    public void W(int i, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i2 == 0) {
            this.d = i;
        } else if (i2 == 1) {
            int i3 = this.d;
            if (i3 < 20) {
                this.d = 20;
            } else if (i3 < 40) {
                this.d = 40;
            } else if (i3 < 60) {
                this.d = 60;
            } else if (i3 < 80) {
                this.d = 80;
            } else {
                this.d = 100;
            }
        } else if (i2 == 2) {
            int i4 = this.d;
            if (i4 > 80) {
                this.d = 80;
            } else if (i4 > 60) {
                this.d = 60;
            } else if (i4 > 40) {
                this.d = 40;
            } else if (i4 > 20) {
                this.d = 20;
            } else {
                this.d = 0;
            }
        }
        eg3.k(this.a, "speed_mode_sensitivity", this.d);
        EventBus.getDefault().post(new NinjaSpeedModeChangeEvent(4, true ^ this.c, this.d));
    }

    public boolean X() {
        return h(new Event(c22.EVENT_START, null));
    }

    public final void Y() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setSpeedRequired(true);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        String bestProvider = this.n.getBestProvider(criteria, true);
        if (!TextUtils.isEmpty(bestProvider)) {
            this.n.requestLocationUpdates(bestProvider, 100L, 0.0f, this.o);
            return;
        }
        Iterator<String> it = this.n.getProviders(true).iterator();
        while (it.hasNext()) {
            this.n.requestLocationUpdates(it.next(), 100L, 0.0f, this.o);
        }
    }

    public final void Z() {
        this.p.registerListener(this.r, this.q, 0);
    }

    @Override // dc.x12
    public boolean a() {
        WeakReference<SpeedModeExpandDialog> weakReference = this.y;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.y.get().isShowing();
    }

    public void a0() {
        h(new Event(c22.EVENT_STOP, null));
    }

    @Override // dc.x12
    public /* synthetic */ boolean b(f22 f22Var, Map map) {
        return w12.a(this, f22Var, map);
    }

    public final void b0() {
        this.f = 0.0f;
        this.n.removeUpdates(this.o);
    }

    @Override // dc.x12
    public void c(@Nullable f22 f22Var) {
        this.t = f22Var;
    }

    public final void c0() {
        this.p.unregisterListener(this.r);
    }

    @Override // dc.x12
    @Nullable
    public String d() {
        return "SpeedMode is controlling";
    }

    public final void d0() {
        PlayReceiver playReceiver = this.b;
        if (playReceiver != null) {
            this.a.unregisterReceiver(playReceiver);
            this.b = null;
        }
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: e */
    public f22 getB() {
        return this.t;
    }

    @Override // dc.x12
    public boolean f() {
        return true;
    }

    @Override // dc.x12
    public void g() {
        WeakReference<SpeedModeExpandDialog> weakReference = this.y;
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
    public h22 getC() {
        return this.u;
    }

    @Override // dc.x12
    public void j(boolean z2, int i, int i2) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null || fragmentActivityH.isDestroyed() || fragmentActivityH.isFinishing()) {
            return;
        }
        this.w.f();
        ExpandData expandData = new ExpandData();
        expandData.k(z2);
        expandData.p(i);
        expandData.q(i2);
        expandData.l(ah4.e(R.string.discover_speed_mode));
        expandData.j(R.drawable.full_control_speedmode_expand);
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.e(expandData);
        bVar.d(new f(this, fragmentActivityH));
        bVar.c(new g());
        SpeedModeExpandDialog speedModeExpandDialog = (SpeedModeExpandDialog) cs3.i(bVar, SpeedModeExpandDialog.class);
        speedModeExpandDialog.p(fragmentActivityH);
        speedModeExpandDialog.show();
        this.y = new WeakReference<>(speedModeExpandDialog);
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
    public g22 getD() {
        return this.v;
    }

    @Override // dc.x12
    public void m(Activity activity) {
        if ((activity instanceof SoundPlayActivity) || (activity instanceof CreatePatternActivity) || (activity instanceof PatternPlayActivity) || (activity instanceof AlarmSoundPlayActivity) || (activity instanceof RemoteControlActivity) || (activity instanceof RemoteMultiControlActivity) || (activity instanceof MusicRecordActivity) || (activity instanceof GameActivity) || (activity instanceof PlayerActivity)) {
            a0();
        }
    }

    @Override // dc.x12
    @NonNull
    public List<Class<? extends Activity>> n() {
        return this.x;
    }

    @Override // dc.x12
    @Nullable
    public String o() {
        return "speed_mode_anim.json";
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ChangeToyEvent changeToyEvent) throws JSONException {
        U();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToySelectEvent toySelectEvent) throws JSONException {
        U();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(xc1 xc1Var) throws JSONException {
        U();
    }
}

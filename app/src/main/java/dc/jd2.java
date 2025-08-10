package dc;

import android.app.Activity;
import android.net.TrafficStats;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.bean.migrate.MigrateAdapterBean;
import com.wear.bean.migrate.MigrateAuthTcBean;
import com.wear.bean.migrate.MigrateAuthTsBean;
import com.wear.bean.migrate.MigrateMsgsTsBean;
import com.wear.bean.migrate.MigrateReadyTcBean;
import com.wear.bean.migrate.MigrateReadyTsBean;
import com.wear.bean.migrate.MigrateSocketBean;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.dd2;
import dc.hd2;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.SoftReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.java_websocket.WebSocket;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;

/* compiled from: WebSocketClientUtils.java */
/* loaded from: classes3.dex */
public class jd2 implements dd2.l {
    public static int s;
    public static int t;
    public static jd2 u;
    public boolean a;
    public boolean b;
    public String c;
    public Timer d;
    public TimerTask e;
    public int f;
    public int g;
    public boolean h;
    public Disposable i;
    public long j;
    public long k;
    public long l;
    public long m;
    public int n;
    public hd2 o;
    public boolean p;
    public List<SoftReference<Activity>> q;
    public d r;

    /* compiled from: WebSocketClientUtils.java */
    public class a implements hd2.a {
        public a() {
        }

        @Override // dc.hd2.a
        public void a() {
            if (jd2.this.r != null) {
                jd2.this.r.e3();
            }
        }

        @Override // dc.hd2.a
        public void b(int i, String str, boolean z) {
            String str2 = "orgwebsocket onClose code:" + i + ",reason:" + str + ",remote:" + z;
            if (jd2.this.a || jd2.this.b || jd2.this.r == null) {
                return;
            }
            jd2.this.r.e3();
        }

        @Override // dc.hd2.a
        public void c(String str) {
            String str2 = "orgwebsocket onMessage s:" + str;
            try {
                jd2.this.v(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.hd2.a
        public void d(byte[] bArr) {
            try {
                jd2.this.u(bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.hd2.a
        public void onOpen() {
            if (jd2.this.r != null) {
                jd2.this.r.p();
            }
            jd2.s = 1;
            jd2.this.r();
        }

        @Override // dc.hd2.a
        public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        }
    }

    /* compiled from: WebSocketClientUtils.java */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            jd2.g(jd2.this, 10);
            jd2.i(jd2.this, 10);
            String str = "startHeartTimer run receiveTimes: " + jd2.this.g;
            if (jd2.this.f % 30 == 0) {
                jd2.this.F();
            }
            if (jd2.this.g >= 50) {
                jd2.this.I();
            } else if (jd2.this.f % 180 == 0 && jd2.this.n > 0 && jd2.this.n == dd2.F().E()) {
                jd2.this.I();
            }
            jd2.this.n = dd2.F().E();
        }
    }

    /* compiled from: WebSocketClientUtils.java */
    public class c implements Observer<Long> {
        public c() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Long l) {
            jd2.this.y();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            jd2.this.i = disposable;
        }
    }

    /* compiled from: WebSocketClientUtils.java */
    public interface d {
        void A(String str);

        void D1();

        void F2();

        void J(String str);

        void L();

        void Y1();

        void e3();

        void f0();

        void j();

        void j0();

        void p();

        void p1();

        void u();

        void v3();

        void y1();
    }

    public jd2() {
        EventBus.getDefault().register(this);
    }

    public static /* synthetic */ int g(jd2 jd2Var, int i) {
        int i2 = jd2Var.f + i;
        jd2Var.f = i2;
        return i2;
    }

    public static /* synthetic */ int i(jd2 jd2Var, int i) {
        int i2 = jd2Var.g + i;
        jd2Var.g = i2;
        return i2;
    }

    public static jd2 x() {
        if (u == null) {
            synchronized (jd2.class) {
                if (u == null) {
                    u = new jd2();
                }
            }
        }
        return u;
    }

    @Override // dc.dd2.l
    public void A(String str) {
        d dVar = this.r;
        if (dVar != null) {
            dVar.A(str);
        }
    }

    @Override // dc.dd2.l
    public void B(MigrateMsgsTsBean migrateMsgsTsBean) {
        L(MigrateSocketBean.Builder.buildMsgsTs(migrateMsgsTsBean));
    }

    @Override // dc.dd2.l
    public void C(boolean z) {
    }

    @Override // dc.dd2.l
    public void D(boolean z) {
        s = 9;
        if (z) {
            L(MigrateSocketBean.Builder.buildUnzipTs());
        }
        s();
        d dVar = this.r;
        if (dVar != null) {
            dVar.u();
        }
    }

    @Override // dc.dd2.l
    public void E(boolean z) {
        if (z && this.p) {
            S();
        }
    }

    public final void F() {
        L(MigrateSocketBean.Builder.buildHeartBeatTs());
    }

    public void G() {
        s = 0;
        t = 0;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
    }

    public void H() {
        d dVar = this.r;
        if (dVar != null) {
            dVar.p1();
        }
    }

    public final void I() {
        if (!this.h) {
            this.h = true;
        }
        d dVar = this.r;
        if (dVar != null) {
            if (s >= 8) {
                return;
            } else {
                dVar.L();
            }
        }
        int i = s;
        if (i < 3) {
            s = 4;
        } else if (i == 3) {
            s = 5;
            t = 3;
        }
        q();
        J();
    }

    public final void J() {
        t();
    }

    public void K(@NonNull Activity activity) {
        List<SoftReference<Activity>> list = this.q;
        if (list == null || list.size() == 0) {
            return;
        }
        SoftReference softReference = new SoftReference(activity);
        if (this.q.contains(softReference)) {
            this.q.remove(softReference);
        }
    }

    public void L(String str) {
        if (this.o != null) {
            try {
                String str2 = "sendMessage msgs: " + str;
                this.o.send(str);
            } catch (WebsocketNotConnectedException unused) {
            }
        }
    }

    public void M(d dVar) {
        this.r = dVar;
    }

    public void N(String str) {
        this.c = str;
    }

    public final void O() {
        p();
        this.d = new Timer();
        b bVar = new b();
        this.e = bVar;
        this.d.schedule(bVar, 0L, 10000L);
    }

    public final void P() {
        if (dd2.F().J() <= 0) {
            return;
        }
        q();
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(new c());
    }

    public void Q(boolean z) {
        MigrateReadyTsBean migrateReadyTsBean = new MigrateReadyTsBean(z, dd2.F().E());
        String str = "transferAction migrateReadyTsBean: " + WearUtils.A.toJson(migrateReadyTsBean);
        L(MigrateSocketBean.Builder.buildReadyTs(migrateReadyTsBean));
    }

    public void R(boolean z) {
        if (!z) {
            s = 6;
            s();
            d dVar = this.r;
            if (dVar != null) {
                dVar.j0();
                return;
            }
            return;
        }
        s = 3;
        d dVar2 = this.r;
        if (dVar2 != null) {
            dVar2.F2();
        }
        dd2.F().B();
        P();
        DaoUtils.getTestValueDao().save(TestValueDao.CHAT_MIGRATE_KEY, "1", TestValueDao.CHAT_MIGRATE_TYPE);
    }

    public final void S() {
        s = 8;
        L(MigrateSocketBean.Builder.buildTransferCompleteTs());
        q();
        d dVar = this.r;
        if (dVar != null) {
            dVar.j();
        }
        dd2.F().c0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void netWorkEvent(gd2 gd2Var) {
        String str = "netWorkEvent: " + gd2Var.a();
        if (gd2Var.a() == 1) {
            return;
        }
        gd2Var.a();
    }

    public void o(@NonNull Activity activity) {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.add(new SoftReference<>(activity));
    }

    public final void p() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
        TimerTask timerTask = this.e;
        if (timerTask != null) {
            timerTask.cancel();
            this.e = null;
        }
    }

    public final void q() {
        Disposable disposable = this.i;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.i.dispose();
        this.i = null;
    }

    public void r() {
        L(MigrateSocketBean.Builder.buildAuthTs(new MigrateAuthTsBean(ch3.n().q(), DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE, MyApplication.U(), MigrateAdapterBean.getAllFields())));
    }

    public void s() {
        hd2 hd2Var = this.o;
        if (hd2Var != null) {
            hd2Var.close();
            this.o = null;
        }
        p();
    }

    public void t() {
        s = 0;
        dd2.F().W(this);
        this.a = false;
        this.b = false;
        dd2.F().Y(false);
        if (dd2.F().K() == 1) {
            this.p = false;
        }
        try {
            hd2 hd2Var = new hd2(this.c);
            this.o = hd2Var;
            hd2Var.a(new a());
            this.o.connect();
            d dVar = this.r;
            if (dVar != null) {
                dVar.Y1();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public final synchronized void u(byte[] bArr) {
        try {
            this.g = 0;
            this.k += bArr.length;
            if (dd2.F().K() == 0) {
                dd2.F().R(bArr);
            } else {
                v(oe3.e(bArr, "ISO-8859-1"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("消息迁移--dispobleBytes", e));
            L(MigrateSocketBean.Builder.buildMsgsTs(new MigrateMsgsTsBean(dd2.F().G(), false, dd2.F().H())));
        }
    }

    public void v(String str) throws Exception {
        MigrateSocketBean migrateSocketBean;
        this.g = 0;
        if (WearUtils.e1(str) || (migrateSocketBean = (MigrateSocketBean) WearUtils.A.fromJson(str, MigrateSocketBean.class)) == null) {
            return;
        }
        String event = migrateSocketBean.getEvent();
        event.hashCode();
        switch (event) {
            case "mig_transfer_complete_tc":
                if (dd2.F().K() != 1) {
                    S();
                    return;
                }
                this.p = true;
                if (dd2.F().Q()) {
                    return;
                }
                S();
                return;
            case "mig_heart_beat_tc":
                if (this.h) {
                    this.h = false;
                    d dVar = this.r;
                    if (dVar != null) {
                        dVar.v3();
                        return;
                    }
                    return;
                }
                return;
            case "mig_auth_tc":
                MigrateAuthTcBean migrateAuthTcBean = (MigrateAuthTcBean) WearUtils.A.fromJson(migrateSocketBean.getdecryptDate(), MigrateAuthTcBean.class);
                if (migrateAuthTcBean.getCode() != 1) {
                    if (migrateAuthTcBean.getCode() == 2) {
                        this.a = true;
                        d dVar2 = this.r;
                        if (dVar2 != null) {
                            dVar2.y1();
                        }
                        s();
                        return;
                    }
                    this.b = true;
                    d dVar3 = this.r;
                    if (dVar3 != null) {
                        dVar3.D1();
                    }
                    s();
                    return;
                }
                d dVar4 = this.r;
                if (dVar4 != null) {
                    dVar4.f0();
                }
                dd2.F().X(migrateAuthTcBean.getMsgNums());
                dd2.F().Z(migrateAuthTcBean.getPlatformInt());
                O();
                if (this.h) {
                    this.h = false;
                    d dVar5 = this.r;
                    if (dVar5 != null) {
                        dVar5.v3();
                    }
                }
                if (dd2.F().E() > 0 || t == 3) {
                    Q(true);
                }
                t = 0;
                s = 2;
                return;
            case "mig_transfer_msgs_tc":
                try {
                    JSONObject jSONObject = (JSONObject) JSON.parseObject(str).get("data");
                    dd2.F().S(jSONObject.getInteger(FirebaseAnalytics.Param.INDEX).intValue(), jSONObject.getString("messages"), jSONObject.getBytes("attachments"), jSONObject.getInteger("flag").intValue());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            case "mig_ready_tc":
                R(((MigrateReadyTcBean) WearUtils.A.fromJson(migrateSocketBean.getdecryptDate(), MigrateReadyTcBean.class)).isAccept());
                return;
            case "mig_interrupted_tc":
                H();
                return;
            default:
                return;
        }
    }

    public void w() {
        List<SoftReference<Activity>> list = this.q;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<SoftReference<Activity>> it = this.q.iterator();
        while (it.hasNext()) {
            Activity activity = it.next().get();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void y() {
        long jZ = z();
        this.m = jZ;
        long j = this.l;
        long j2 = j > 0 ? jZ - j : 0L;
        long j3 = this.k - this.j;
        String str = "getSpeed stepLengMobile:" + j2 + ", stepLeng: " + j3;
        long j4 = (j3 + j2) / 2;
        if (j4 < 0) {
            j4 = 0;
        }
        boolean z = true;
        float f = j4 / 1024.0f;
        if (f > 1024.0f) {
            f /= 1024.0f;
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(Math.round(f * 10.0f) / 10.0f);
        sb.append(z ? "KB/s" : "MB/s");
        sb.append(")");
        String string = sb.toString();
        String str2 = "getSpeed CurMsgsIndex:" + dd2.F().E() + ", MsgNums: " + dd2.F().J();
        float fE = (dd2.F().E() + 0.0f) / (dd2.F().J() + 0.0f);
        if (fE > 1.0f) {
            fE = 1.0f;
        }
        String str3 = (Math.round(fE * 1000.0f) / 10.0f) + "%";
        this.j = this.k - 0;
        this.l = this.m;
        d dVar = this.r;
        if (dVar == null || s != 3) {
            return;
        }
        dVar.J(str3 + " " + string);
    }

    public final long z() {
        if (TrafficStats.getUidTxBytes(WearUtils.x.getApplicationInfo().uid) == -1) {
            return 0L;
        }
        return TrafficStats.getTotalRxBytes();
    }
}

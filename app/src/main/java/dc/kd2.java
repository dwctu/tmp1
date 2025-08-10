package dc;

import android.app.Activity;
import android.net.TrafficStats;
import com.wear.bean.migrate.MigrateAuthTsBean;
import com.wear.bean.migrate.MigrateMsgsTsBean;
import com.wear.bean.migrate.MigrateReadyTcBean;
import com.wear.bean.migrate.MigrateReadyTsBean;
import com.wear.bean.migrate.MigrateSocketBean;
import com.wear.main.account.ChatSettingActivity;
import com.wear.main.migrate.ui.ChatMigratePtoActivity;
import com.wear.main.migrate.ui.ChatMigrateQrcodeActivity;
import com.wear.main.migrate.ui.MigrateChatHistoryActivity;
import com.wear.ui.me.SettingActivity;
import com.wear.util.WearUtils;
import dc.cd2;
import dc.ed2;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.SoftReference;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;

/* compiled from: WebSocketServerUtils.java */
/* loaded from: classes3.dex */
public class kd2 implements ed2.d {
    public static String o = "/migrate";
    public static int p = 0;
    public static kd2 q = null;
    public static boolean r = false;
    public static int s = 34666;
    public String a;
    public Timer b;
    public TimerTask c;
    public int d;
    public List<SoftReference<Activity>> e;
    public boolean f;
    public Disposable g;
    public long h;
    public long i;
    public long j;
    public long k;
    public WebSocket l;
    public boolean m;
    public d n;

    /* compiled from: WebSocketServerUtils.java */
    public class a implements cd2.a {
        public a() {
        }

        @Override // dc.cd2.a
        public void a(WebSocket webSocket, String str) {
            String str2 = "initServerManager onStringAvailable: " + str;
            kd2.this.A(str);
        }

        @Override // dc.cd2.a
        public void b(WebSocket webSocket, ClientHandshake clientHandshake) {
            InetSocketAddress remoteSocketAddress;
            if (kd2.this.l == null || !kd2.this.m) {
                kd2.this.l = webSocket;
                kd2.this.m = false;
                kd2.p = 1;
                return;
            }
            try {
                InetSocketAddress remoteSocketAddress2 = webSocket.getRemoteSocketAddress();
                StringBuilder sb = new StringBuilder();
                sb.append("initServerManager onOpen remoteInetSocketAddress==null: ");
                sb.append(remoteSocketAddress2 == null);
                sb.toString();
                String hostAddress = "";
                String hostAddress2 = remoteSocketAddress2 != null ? remoteSocketAddress2.getAddress().getHostAddress() : "";
                if (webSocket != null && (remoteSocketAddress = kd2.this.l.getRemoteSocketAddress()) != null) {
                    hostAddress = remoteSocketAddress.getAddress().getHostAddress();
                }
                if (WearUtils.e1(hostAddress2)) {
                    return;
                }
                if (!hostAddress2.equals(hostAddress)) {
                    webSocket.close();
                    return;
                }
                kd2.this.l.close();
                kd2.this.l = webSocket;
                kd2.this.m = false;
                kd2.p = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.cd2.a
        public void c(WebSocket webSocket, int i, String str, boolean z) {
            String str2 = "initServerManager onClose code: " + i + ",reason:" + str + ",remote:" + z;
            kd2.this.l = null;
        }

        @Override // dc.cd2.a
        public void d(WebSocket webSocket, ByteBuffer byteBuffer) {
        }

        @Override // dc.cd2.a
        public void e(WebSocket webSocket, Exception exc) {
            kd2.this.l = null;
            if (exc.getMessage().contains("Address already in use")) {
                int i = kd2.s + 1;
                kd2.s = i;
                if (i <= 34676) {
                    kd2.this.G();
                }
            }
        }

        @Override // dc.cd2.a
        public void onStart() {
            kd2.this.a = "ws://" + WearUtils.f0() + SignatureImpl.INNER_SEP + kd2.s + kd2.o;
            StringBuilder sb = new StringBuilder();
            sb.append("createWebsocketServer createSuccess websocketUrl:");
            sb.append(kd2.this.a);
            sb.toString();
            if (kd2.this.n != null) {
                kd2.this.n.l0(kd2.this.a);
            }
        }

        @Override // dc.cd2.a
        public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        }
    }

    /* compiled from: WebSocketServerUtils.java */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            kd2.o(kd2.this, 10);
            if (kd2.this.d >= 50) {
                kd2.this.I();
            }
        }
    }

    /* compiled from: WebSocketServerUtils.java */
    public class c implements Observer<Long> {
        public c() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Long l) {
            kd2.this.D();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            kd2.this.g = disposable;
        }
    }

    /* compiled from: WebSocketServerUtils.java */
    public interface d {
        void J(String str);

        void L();

        void P0();

        void X1();

        void c2();

        void j();

        void l0(String str);

        void n2();

        void t1();

        void u();

        void v0();
    }

    public kd2() {
        EventBus.getDefault().register(this);
    }

    public static kd2 C() {
        if (q == null) {
            synchronized (kd2.class) {
                if (q == null) {
                    q = new kd2();
                }
            }
        }
        return q;
    }

    public static /* synthetic */ int o(kd2 kd2Var, int i) {
        int i2 = kd2Var.d + i;
        kd2Var.d = i2;
        return i2;
    }

    public final void A(String str) {
        MigrateSocketBean migrateSocketBean;
        this.d = 0;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (WearUtils.e1(str) || (migrateSocketBean = (MigrateSocketBean) WearUtils.A.fromJson(str, MigrateSocketBean.class)) == null) {
            return;
        }
        switch (migrateSocketBean.getEvent()) {
            case "mig_auth_ts":
                w((MigrateAuthTsBean) WearUtils.A.fromJson(migrateSocketBean.getdecryptDate(), MigrateAuthTsBean.class));
                break;
            case "mig_ready_ts":
                String str2 = "migrateSocketBean : " + migrateSocketBean.getdecryptDate();
                MigrateReadyTsBean migrateReadyTsBean = (MigrateReadyTsBean) WearUtils.A.fromJson(migrateSocketBean.getdecryptDate(), MigrateReadyTsBean.class);
                boolean zIsAccept = migrateReadyTsBean.isAccept();
                L(MigrateSocketBean.Builder.buildReadyTc(new MigrateReadyTcBean(zIsAccept, 0)));
                if (!zIsAccept) {
                    v();
                    break;
                } else {
                    Q(migrateReadyTsBean.getTransferedCount());
                    break;
                }
            case "mig_interrupted_ts":
                H();
                break;
            case "mig_heart_beat_ts":
                this.d = 0;
                if (this.f) {
                    this.f = false;
                    d dVar = this.n;
                    if (dVar != null) {
                        dVar.c2();
                    }
                }
                K();
                break;
            case "mig_transfer_msgs_ts":
                MigrateMsgsTsBean migrateMsgsTsBean = (MigrateMsgsTsBean) WearUtils.A.fromJson(migrateSocketBean.getdecryptDate(), MigrateMsgsTsBean.class);
                String str3 = "客户端回应接收聊天消息 index: " + migrateMsgsTsBean.getIndex() + ", isSuccess: " + migrateMsgsTsBean.isResult();
                if (!migrateMsgsTsBean.isResult()) {
                    ed2.x().V();
                    break;
                } else {
                    ed2.x().U(migrateMsgsTsBean.getIndex());
                    break;
                }
            case "mig_transfer_complete_ts":
                R();
                break;
            case "mig_unzip_ts":
                S();
                break;
        }
    }

    public void B(int i) {
        List<SoftReference<Activity>> list = this.e;
        if (list == null) {
            return;
        }
        Iterator<SoftReference<Activity>> it = list.iterator();
        while (it.hasNext()) {
            Activity activity = it.next().get();
            if (i != 0 || activity == null || !(activity instanceof ChatMigrateQrcodeActivity)) {
                if (activity != null) {
                    activity.finish();
                }
            }
        }
        this.e.clear();
    }

    public final void D() {
        long jE = E();
        this.k = jE;
        long j = this.j;
        long j2 = j > 0 ? jE - j : 0L;
        String str = "getSpeed stepLengMobile:" + j2 + ", stepLeng: " + (this.i - this.h);
        this.h = this.i;
        this.j = this.k;
        boolean z = true;
        float f = ((r0 + j2) / 2) / 1024.0f;
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
        String str2 = "getSpeed CurSendMsgsIndex:" + ed2.x().F() + ", AllMsgNums: " + ed2.x().t();
        float F = (ed2.x().F() + 0.0f) / (ed2.x().t() + 0.0f);
        if (F > 1.0f) {
            F = 1.0f;
        }
        String str3 = (Math.round(F * 1000.0f) / 10.0f) + "%";
        String str4 = "getSpeed progress:" + str3 + ", speed: " + string;
        d dVar = this.n;
        if (dVar == null || p != 3) {
            return;
        }
        dVar.J(str3 + " " + string);
    }

    public final long E() {
        if (TrafficStats.getUidTxBytes(WearUtils.x.getApplicationInfo().uid) == -1) {
            return 0L;
        }
        return TrafficStats.getTotalRxBytes();
    }

    public final void F() {
        ed2.x().Q(this);
    }

    public final void G() {
        id2.a().c(s);
        id2.a().b(new a());
    }

    public final void H() {
        L(MigrateSocketBean.Builder.buildInterruptedTc());
        d dVar = this.n;
        if (dVar != null) {
            dVar.X1();
        }
        y();
    }

    public final void I() {
        d dVar;
        if (!this.f) {
            this.f = true;
            d dVar2 = this.n;
            if (dVar2 != null) {
                if (p < 8) {
                    dVar2.L();
                } else {
                    dVar2.n2();
                }
            }
            x();
            int i = p;
            if (i < 3) {
                p = 4;
            } else if (i == 3) {
                p = 5;
            }
        }
        if (this.d <= 160 || (dVar = this.n) == null) {
            return;
        }
        dVar.v0();
        t();
        u();
    }

    public void J(Activity activity) {
        if (this.e == null || activity == null) {
            return;
        }
        if ((activity instanceof SettingActivity) || (activity instanceof ChatSettingActivity) || (activity instanceof MigrateChatHistoryActivity) || (activity instanceof ChatMigratePtoActivity) || (activity instanceof ChatMigrateQrcodeActivity)) {
            SoftReference softReference = new SoftReference(activity);
            if (this.e.contains(softReference)) {
                this.e.remove(softReference);
            }
        }
    }

    public final void K() {
        L(MigrateSocketBean.Builder.buildHeartBeatTc());
    }

    public final void L(String str) {
        String str2 = "sendMessage: " + str;
        WebSocket webSocket = this.l;
        if (webSocket != null) {
            try {
                webSocket.send(str);
            } catch (Exception unused) {
            }
        }
    }

    public final void M(byte[] bArr) {
        String str = "sendMessagesBytes bytes.length: " + bArr.length;
        try {
            if (this.l != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.l.send(bArr);
                K();
                long jCurrentTimeMillis2 = (System.currentTimeMillis() - jCurrentTimeMillis) / 1000;
                this.i += bArr.length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void N(d dVar) {
        this.n = dVar;
    }

    public final void O() {
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.c;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.f = false;
        this.d = 0;
        this.b = new Timer();
        b bVar = new b();
        this.c = bVar;
        this.b.schedule(bVar, 10L, 10000L);
    }

    public final void P() {
        if (ed2.x().t() <= 0) {
            return;
        }
        u();
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(new c());
    }

    public final void Q(int i) {
        p = 3;
        d dVar = this.n;
        if (dVar != null) {
            dVar.P0();
        }
        ed2.x().r();
        P();
        ed2.x().T(i);
    }

    public final void R() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.j();
        }
    }

    public final void S() {
        p = 9;
        d dVar = this.n;
        if (dVar != null) {
            dVar.u();
        }
        y();
    }

    @Override // dc.ed2.d
    public void j() {
        L(MigrateSocketBean.Builder.buildTransferCompleteTc());
        u();
        p = 8;
    }

    @Override // dc.ed2.d
    public void k(byte[] bArr) {
        M(bArr);
    }

    @Override // dc.ed2.d
    public void l() {
    }

    @Override // dc.ed2.d
    public void m(String str) {
        L(str);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void netWorkEvent(gd2 gd2Var) {
        String str = "netWorkEvent: " + gd2Var.a();
        if (gd2Var.a() == 1) {
            return;
        }
        gd2Var.a();
    }

    public void s(Activity activity) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        if (activity != null) {
            if ((activity instanceof SettingActivity) || (activity instanceof ChatSettingActivity) || (activity instanceof MigrateChatHistoryActivity) || (activity instanceof ChatMigratePtoActivity) || (activity instanceof ChatMigrateQrcodeActivity)) {
                this.e.add(new SoftReference<>(activity));
            }
        }
    }

    public final void t() {
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b = null;
        }
        TimerTask timerTask = this.c;
        if (timerTask != null) {
            timerTask.cancel();
            this.c = null;
        }
    }

    public final void u() {
        Disposable disposable = this.g;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.g.dispose();
        this.g = null;
    }

    public final void v() {
        p = 6;
        t();
        x();
        d dVar = this.n;
        if (dVar != null) {
            dVar.v0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w(com.wear.bean.migrate.MigrateAuthTsBean r11) {
        /*
            r10 = this;
            com.wear.dao.TestValueDao r0 = com.wear.dao.DaoUtils.getTestValueDao()
            java.lang.String r1 = "chat_migrate_userjid_wearable_key"
            java.lang.String r2 = "chat_migrate_userjid_wearable_type"
            java.lang.String r0 = r0.getValue(r1, r2)
            boolean r1 = com.wear.util.WearUtils.e1(r0)
            if (r1 != 0) goto L1d
            dc.ed2 r1 = dc.ed2.x()
            java.lang.String r0 = dc.nd3.i(r0)
            r1.S(r0)
        L1d:
            dc.ed2 r0 = dc.ed2.x()
            java.lang.String r0 = r0.H()
            boolean r0 = com.wear.util.WearUtils.e1(r0)
            r1 = 2
            r2 = 1
            if (r0 != 0) goto L42
            dc.ed2 r0 = dc.ed2.x()
            java.lang.String r0 = r0.H()
            java.lang.String r3 = r11.getJid()
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L40
            goto L42
        L40:
            r0 = 1
            goto L43
        L42:
            r0 = 2
        L43:
            r3 = 3
            java.lang.String r4 = "android"
            if (r0 != r2) goto L93
            java.lang.String r5 = r11.getPlatform()
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L5d
            int r5 = r11.getAppVersion()
            int r6 = com.wear.util.MyApplication.U()
            if (r5 >= r6) goto L93
            goto L92
        L5d:
            java.util.List r5 = r11.getTabFields()
            if (r5 == 0) goto L93
            int r5 = r5.size()
            if (r5 <= 0) goto L93
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.Class<com.wear.bean.migrate.MigrateAdapterBean> r6 = com.wear.bean.migrate.MigrateAdapterBean.class
            java.lang.reflect.Field[] r6 = r6.getDeclaredFields()
            int r7 = r6.length
            r8 = 0
        L76:
            if (r8 >= r7) goto L84
            r9 = r6[r8]
            java.lang.String r9 = r9.getName()
            r5.add(r9)
            int r8 = r8 + 1
            goto L76
        L84:
            java.util.List r6 = r11.getTabFields()
            int r6 = r6.size()
            int r5 = r5.size()
            if (r6 >= r5) goto L93
        L92:
            r0 = 3
        L93:
            if (r0 != r2) goto Lb3
            r10.m = r2
            dc.kd2.p = r1
            r10.O()
            dc.ed2 r1 = dc.ed2.x()
            java.lang.String r11 = r11.getPlatform()
            boolean r11 = r4.equals(r11)
            r11 = r11 ^ r2
            r1.N(r11)
            dc.kd2$d r11 = r10.n
            if (r11 == 0) goto Lb3
            r11.t1()
        Lb3:
            dc.ed2 r11 = dc.ed2.x()
            r11.p()
            com.wear.bean.migrate.MigrateAuthTcBean r11 = new com.wear.bean.migrate.MigrateAuthTcBean
            dc.ed2 r1 = dc.ed2.x()
            long r5 = r1.t()
            int r1 = (int) r5
            r11.<init>(r0, r1, r4)
            java.lang.String r11 = com.wear.bean.migrate.MigrateSocketBean.Builder.buildAuthTc(r11)
            r10.L(r11)
            if (r0 == r2) goto Ld4
            r10.x()
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.kd2.w(com.wear.bean.migrate.MigrateAuthTsBean):void");
    }

    public final void x() {
        WebSocket webSocket = this.l;
        if (webSocket != null) {
            webSocket.close();
        }
    }

    public void y() {
        x();
        t();
        kf2.m().E();
    }

    public void z() {
        F();
        ed2.x().S("");
        ed2.x().O(ch3.n().u());
        ed2.x().M(zb2.O().U());
        G();
    }
}

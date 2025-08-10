package dc;

import androidx.core.app.NotificationCompat;
import com.epicgames.unreal.psoservices.PSOProgramService;
import dc.ac4;
import dc.ed4;
import dc.pw3;
import dc.uw3;
import io.socket.engineio.client.EngineIOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.json.JSONException;

/* compiled from: Socket.java */
/* loaded from: classes4.dex */
public class tw3 extends pw3 {
    public static final Logger C = Logger.getLogger(tw3.class.getName());
    public static boolean D = false;
    public static ed4.a E;
    public static ac4.a F;
    public static vc4 G;
    public ScheduledExecutorService A;
    public final pw3.a B;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public long j;
    public long k;
    public String l;
    public String m;
    public String n;
    public String o;
    public List<String> p;
    public Map<String, uw3.d> q;
    public List<String> r;
    public Map<String, String> s;
    public LinkedList<zw3> t;
    public uw3 u;
    public Future v;
    public Future w;
    public ed4.a x;
    public ac4.a y;
    public w z;

    /* compiled from: Socket.java */
    public class a implements pw3.a {
        public final /* synthetic */ uw3[] a;
        public final /* synthetic */ pw3.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ tw3 d;

        public a(tw3 tw3Var, uw3[] uw3VarArr, pw3.a aVar, String str, tw3 tw3Var2) {
            this.a = uw3VarArr;
            this.b = aVar;
            this.c = str;
            this.d = tw3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            EngineIOException engineIOException;
            Object obj = objArr[0];
            if (obj instanceof Exception) {
                engineIOException = new EngineIOException("probe error", (Exception) obj);
            } else if (obj instanceof String) {
                engineIOException = new EngineIOException("probe error: " + ((String) obj));
            } else {
                engineIOException = new EngineIOException("probe error");
            }
            engineIOException.transport = this.a[0].c;
            this.b.call(new Object[0]);
            if (tw3.C.isLoggable(Level.FINE)) {
                tw3.C.fine(String.format("probe transport \"%s\" failed because of error: %s", this.c, obj));
            }
            this.d.a("upgradeError", engineIOException);
        }
    }

    /* compiled from: Socket.java */
    public class b implements pw3.a {
        public final /* synthetic */ pw3.a a;

        public b(tw3 tw3Var, pw3.a aVar) {
            this.a = aVar;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.call("transport closed");
        }
    }

    /* compiled from: Socket.java */
    public class c implements pw3.a {
        public final /* synthetic */ pw3.a a;

        public c(tw3 tw3Var, pw3.a aVar) {
            this.a = aVar;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.call("socket closed");
        }
    }

    /* compiled from: Socket.java */
    public class d implements pw3.a {
        public final /* synthetic */ uw3[] a;
        public final /* synthetic */ pw3.a b;

        public d(tw3 tw3Var, uw3[] uw3VarArr, pw3.a aVar) {
            this.a = uw3VarArr;
            this.b = aVar;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            uw3 uw3Var = (uw3) objArr[0];
            uw3[] uw3VarArr = this.a;
            if (uw3VarArr[0] == null || uw3Var.c.equals(uw3VarArr[0].c)) {
                return;
            }
            if (tw3.C.isLoggable(Level.FINE)) {
                tw3.C.fine(String.format("'%s' works - aborting '%s'", uw3Var.c, this.a[0].c));
            }
            this.b.call(new Object[0]);
        }
    }

    /* compiled from: Socket.java */
    public class e implements Runnable {
        public final /* synthetic */ uw3[] a;
        public final /* synthetic */ pw3.a b;
        public final /* synthetic */ pw3.a c;
        public final /* synthetic */ pw3.a d;
        public final /* synthetic */ tw3 e;
        public final /* synthetic */ pw3.a f;
        public final /* synthetic */ pw3.a g;

        public e(tw3 tw3Var, uw3[] uw3VarArr, pw3.a aVar, pw3.a aVar2, pw3.a aVar3, tw3 tw3Var2, pw3.a aVar4, pw3.a aVar5) {
            this.a = uw3VarArr;
            this.b = aVar;
            this.c = aVar2;
            this.d = aVar3;
            this.e = tw3Var2;
            this.f = aVar4;
            this.g = aVar5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a[0].e("open", this.b);
            this.a[0].e("error", this.c);
            this.a[0].e(Close.ELEMENT, this.d);
            this.e.e(Close.ELEMENT, this.f);
            this.e.e("upgrading", this.g);
        }
    }

    /* compiled from: Socket.java */
    public class f implements Runnable {
        public final /* synthetic */ tw3 a;

        /* compiled from: Socket.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.a.z == w.CLOSED) {
                    return;
                }
                f.this.a.K("ping timeout");
            }
        }

        public f(tw3 tw3Var, tw3 tw3Var2) {
            this.a = tw3Var2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jx3.h(new a());
        }
    }

    /* compiled from: Socket.java */
    public class g implements Runnable {
        public final /* synthetic */ tw3 a;

        /* compiled from: Socket.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (tw3.C.isLoggable(Level.FINE)) {
                    tw3.C.fine(String.format("writing ping packet - expecting pong within %sms", Long.valueOf(g.this.a.k)));
                }
                g.this.a.T();
                tw3 tw3Var = g.this.a;
                tw3Var.P(tw3Var.k);
            }
        }

        public g(tw3 tw3Var, tw3 tw3Var2) {
            this.a = tw3Var2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jx3.h(new a());
        }
    }

    /* compiled from: Socket.java */
    public class h implements Runnable {

        /* compiled from: Socket.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                tw3.this.a(Ping.ELEMENT, new Object[0]);
            }
        }

        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            tw3.this.Y(Ping.ELEMENT, new a());
        }
    }

    /* compiled from: Socket.java */
    public class i implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Runnable b;

        public i(String str, Runnable runnable) {
            this.a = str;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            tw3.this.Z("message", this.a, this.b);
        }
    }

    /* compiled from: Socket.java */
    public class j implements Runnable {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ Runnable b;

        public j(byte[] bArr, Runnable runnable) {
            this.a = bArr;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            tw3.this.a0("message", this.a, this.b);
        }
    }

    /* compiled from: Socket.java */
    public class k implements pw3.a {
        public k() {
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            tw3.this.P(objArr.length > 0 ? ((Long) objArr[0]).longValue() : 0L);
        }
    }

    /* compiled from: Socket.java */
    public class l implements pw3.a {
        public final /* synthetic */ Runnable a;

        public l(tw3 tw3Var, Runnable runnable) {
            this.a = runnable;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.run();
        }
    }

    /* compiled from: Socket.java */
    public class m implements Runnable {

        /* compiled from: Socket.java */
        public class a implements Runnable {
            public final /* synthetic */ tw3 a;

            public a(m mVar, tw3 tw3Var) {
                this.a = tw3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.K("forced close");
                tw3.C.fine("socket closing - telling transport to close");
                this.a.u.i();
            }
        }

        /* compiled from: Socket.java */
        public class b implements pw3.a {
            public final /* synthetic */ tw3 a;
            public final /* synthetic */ pw3.a[] b;
            public final /* synthetic */ Runnable c;

            public b(m mVar, tw3 tw3Var, pw3.a[] aVarArr, Runnable runnable) {
                this.a = tw3Var;
                this.b = aVarArr;
                this.c = runnable;
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                this.a.e("upgrade", this.b[0]);
                this.a.e("upgradeError", this.b[0]);
                this.c.run();
            }
        }

        /* compiled from: Socket.java */
        public class c implements Runnable {
            public final /* synthetic */ tw3 a;
            public final /* synthetic */ pw3.a[] b;

            public c(m mVar, tw3 tw3Var, pw3.a[] aVarArr) {
                this.a = tw3Var;
                this.b = aVarArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.g("upgrade", this.b[0]);
                this.a.g("upgradeError", this.b[0]);
            }
        }

        /* compiled from: Socket.java */
        public class d implements pw3.a {
            public final /* synthetic */ Runnable a;
            public final /* synthetic */ Runnable b;

            public d(Runnable runnable, Runnable runnable2) {
                this.a = runnable;
                this.b = runnable2;
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                if (tw3.this.e) {
                    this.a.run();
                } else {
                    this.b.run();
                }
            }
        }

        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (tw3.this.z == w.OPENING || tw3.this.z == w.OPEN) {
                tw3.this.z = w.CLOSING;
                tw3 tw3Var = tw3.this;
                a aVar = new a(this, tw3Var);
                pw3.a[] aVarArr = new pw3.a[1];
                aVarArr[0] = new b(this, tw3Var, aVarArr, aVar);
                c cVar = new c(this, tw3Var, aVarArr);
                if (tw3Var.t.size() > 0) {
                    tw3.this.g("drain", new d(cVar, aVar));
                } else if (tw3.this.e) {
                    cVar.run();
                } else {
                    aVar.run();
                }
            }
        }
    }

    /* compiled from: Socket.java */
    public class n extends Handler {
        public n(tw3 tw3Var) {
        }

        @Override // java.util.logging.Handler
        public void close() throws SecurityException {
        }

        @Override // java.util.logging.Handler
        public void flush() {
        }

        @Override // java.util.logging.Handler
        public void publish(LogRecord logRecord) {
        }
    }

    /* compiled from: Socket.java */
    public class o implements Runnable {

        /* compiled from: Socket.java */
        public class a implements Runnable {
            public final /* synthetic */ tw3 a;

            public a(o oVar, tw3 tw3Var) {
                this.a = tw3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.a("error", new EngineIOException("No transports status_available"));
            }
        }

        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = "websocket";
            if (!tw3.this.f || !tw3.D || !tw3.this.p.contains("websocket")) {
                if (tw3.this.p.size() == 0) {
                    jx3.j(new a(this, tw3.this));
                    return;
                }
                str = (String) tw3.this.p.get(0);
            }
            tw3.this.z = w.OPENING;
            uw3 uw3VarF = tw3.this.F(str);
            tw3.this.c0(uw3VarF);
            uw3VarF.r();
        }
    }

    /* compiled from: Socket.java */
    public class p implements pw3.a {
        public final /* synthetic */ tw3 a;

        public p(tw3 tw3Var, tw3 tw3Var2) {
            this.a = tw3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.K("transport close");
        }
    }

    /* compiled from: Socket.java */
    public class q implements pw3.a {
        public final /* synthetic */ tw3 a;

        public q(tw3 tw3Var, tw3 tw3Var2) {
            this.a = tw3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.N(objArr.length > 0 ? (Exception) objArr[0] : null);
        }
    }

    /* compiled from: Socket.java */
    public class r implements pw3.a {
        public final /* synthetic */ tw3 a;

        public r(tw3 tw3Var, tw3 tw3Var2) {
            this.a = tw3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.R(objArr.length > 0 ? (zw3) objArr[0] : null);
        }
    }

    /* compiled from: Socket.java */
    public class s implements pw3.a {
        public final /* synthetic */ tw3 a;

        public s(tw3 tw3Var, tw3 tw3Var2) {
            this.a = tw3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.M();
        }
    }

    /* compiled from: Socket.java */
    public class t implements pw3.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean[] b;
        public final /* synthetic */ uw3[] c;
        public final /* synthetic */ tw3 d;
        public final /* synthetic */ Runnable[] e;

        /* compiled from: Socket.java */
        public class a implements pw3.a {

            /* compiled from: Socket.java */
            /* renamed from: dc.tw3$t$a$a, reason: collision with other inner class name */
            public class RunnableC0220a implements Runnable {
                public RunnableC0220a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    t tVar = t.this;
                    if (tVar.b[0] || w.CLOSED == tVar.d.z) {
                        return;
                    }
                    tw3.C.fine("changing transport and sending upgrade packet");
                    t.this.e[0].run();
                    t tVar2 = t.this;
                    tVar2.d.c0(tVar2.c[0]);
                    t.this.c[0].s(new zw3[]{new zw3("upgrade")});
                    t tVar3 = t.this;
                    tVar3.d.a("upgrade", tVar3.c[0]);
                    t tVar4 = t.this;
                    tVar4.c[0] = null;
                    tVar4.d.e = false;
                    t.this.d.H();
                }
            }

            public a() {
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                if (t.this.b[0]) {
                    return;
                }
                zw3 zw3Var = (zw3) objArr[0];
                if (!"pong".equals(zw3Var.a) || !"probe".equals(zw3Var.b)) {
                    if (tw3.C.isLoggable(Level.FINE)) {
                        tw3.C.fine(String.format("probe transport '%s' failed", t.this.a));
                    }
                    EngineIOException engineIOException = new EngineIOException("probe error");
                    t tVar = t.this;
                    engineIOException.transport = tVar.c[0].c;
                    tVar.d.a("upgradeError", engineIOException);
                    return;
                }
                Logger logger = tw3.C;
                Level level = Level.FINE;
                if (logger.isLoggable(level)) {
                    tw3.C.fine(String.format("probe transport '%s' pong", t.this.a));
                }
                t.this.d.e = true;
                t tVar2 = t.this;
                tVar2.d.a("upgrading", tVar2.c[0]);
                uw3[] uw3VarArr = t.this.c;
                if (uw3VarArr[0] == null) {
                    return;
                }
                boolean unused = tw3.D = "websocket".equals(uw3VarArr[0].c);
                if (tw3.C.isLoggable(level)) {
                    tw3.C.fine(String.format("pausing current transport '%s'", t.this.d.u.c));
                }
                ((vw3) t.this.d.u).H(new RunnableC0220a());
            }
        }

        public t(tw3 tw3Var, String str, boolean[] zArr, uw3[] uw3VarArr, tw3 tw3Var2, Runnable[] runnableArr) {
            this.a = str;
            this.b = zArr;
            this.c = uw3VarArr;
            this.d = tw3Var2;
            this.e = runnableArr;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            ej4.a(String.format("probe transport '%s' opened", this.a) + " " + this.b[0]);
            if (this.b[0]) {
                return;
            }
            if (tw3.C.isLoggable(Level.FINE)) {
                tw3.C.fine(String.format("probe transport '%s' opened", this.a));
            }
            this.c[0].s(new zw3[]{new zw3(Ping.ELEMENT, "probe")});
            this.c[0].g("packet", new a());
        }
    }

    /* compiled from: Socket.java */
    public class u implements pw3.a {
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ Runnable[] b;
        public final /* synthetic */ uw3[] c;

        public u(tw3 tw3Var, boolean[] zArr, Runnable[] runnableArr, uw3[] uw3VarArr) {
            this.a = zArr;
            this.b = runnableArr;
            this.c = uw3VarArr;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.b[0].run();
            this.c[0].i();
            this.c[0] = null;
        }
    }

    /* compiled from: Socket.java */
    public static class v extends uw3.d {
        public String[] l;
        public boolean m = true;
        public boolean n;
        public String o;
        public String p;
        public Map<String, uw3.d> q;

        public static v b(URI uri, v vVar) {
            if (vVar == null) {
                vVar = new v();
            }
            vVar.o = uri.getHost();
            vVar.d = "https".equals(uri.getScheme()) || "wss".equals(uri.getScheme());
            vVar.f = uri.getPort();
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null) {
                vVar.p = rawQuery;
            }
            return vVar;
        }
    }

    /* compiled from: Socket.java */
    public enum w {
        OPENING,
        OPEN,
        CLOSING,
        CLOSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public tw3() {
        this(new v());
    }

    public tw3 E() {
        jx3.h(new m());
        return this;
    }

    public final uw3 F(String str) {
        uw3 ww3Var;
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("creating transport '%s'", str));
        }
        HashMap map = new HashMap(this.s);
        map.put("EIO", String.valueOf(3));
        map.put(NotificationCompat.CATEGORY_TRANSPORT, str);
        String str2 = this.l;
        if (str2 != null) {
            map.put(PSOProgramService.ServiceID_Key, str2);
        }
        uw3.d dVar = this.q.get(str);
        uw3.d dVar2 = new uw3.d();
        dVar2.h = map;
        dVar2.i = this;
        dVar2.a = dVar != null ? dVar.a : this.m;
        dVar2.f = dVar != null ? dVar.f : this.g;
        dVar2.d = dVar != null ? dVar.d : this.b;
        dVar2.b = dVar != null ? dVar.b : this.n;
        dVar2.e = dVar != null ? dVar.e : this.d;
        dVar2.c = dVar != null ? dVar.c : this.o;
        dVar2.g = dVar != null ? dVar.g : this.h;
        dVar2.k = dVar != null ? dVar.k : this.y;
        dVar2.j = dVar != null ? dVar.j : this.x;
        if ("websocket".equals(str)) {
            ww3Var = new xw3(dVar2);
        } else {
            if (!"polling".equals(str)) {
                throw new RuntimeException();
            }
            ww3Var = new ww3(dVar2);
        }
        a(NotificationCompat.CATEGORY_TRANSPORT, ww3Var);
        return ww3Var;
    }

    public List<String> G(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (this.p.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final void H() {
        if (this.z == w.CLOSED || !this.u.b || this.e || this.t.size() == 0) {
            return;
        }
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("flushing %d packets in socket", Integer.valueOf(this.t.size())));
        }
        this.i = this.t.size();
        uw3 uw3Var = this.u;
        LinkedList<zw3> linkedList = this.t;
        uw3Var.s((zw3[]) linkedList.toArray(new zw3[linkedList.size()]));
        a("flush", new Object[0]);
    }

    public final ScheduledExecutorService I() {
        ScheduledExecutorService scheduledExecutorService = this.A;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.A = Executors.newSingleThreadScheduledExecutor();
        }
        return this.A;
    }

    public String J() {
        return this.l;
    }

    public final void K(String str) {
        L(str, null);
    }

    public final void L(String str, Exception exc) {
        w wVar = w.OPENING;
        w wVar2 = this.z;
        if (wVar == wVar2 || w.OPEN == wVar2 || w.CLOSING == wVar2) {
            Logger logger = C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("socket close with reason: %s", str));
            }
            Future future = this.w;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.v;
            if (future2 != null) {
                future2.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.A;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.u.d(Close.ELEMENT);
            this.u.i();
            this.u.c();
            this.z = w.CLOSED;
            this.l = null;
            a(Close.ELEMENT, str, exc);
            this.t.clear();
            this.i = 0;
        }
    }

    public final void M() {
        for (int i2 = 0; i2 < this.i; i2++) {
            this.t.poll();
        }
        this.i = 0;
        if (this.t.size() == 0) {
            a("drain", new Object[0]);
        } else {
            H();
        }
    }

    public final void N(Exception exc) {
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("socket error %s", exc));
        }
        D = false;
        a("error", exc);
        L("transport error", exc);
    }

    public final void O(sw3 sw3Var) {
        ej4.a("onHandshake");
        a("handshake", sw3Var);
        String str = sw3Var.a;
        this.l = str;
        this.u.d.put(PSOProgramService.ServiceID_Key, str);
        this.r = G(Arrays.asList(sw3Var.b));
        this.j = sw3Var.c;
        this.k = sw3Var.d;
        Q();
        if (w.CLOSED == this.z) {
            return;
        }
        b0();
        e("heartbeat", this.B);
        f("heartbeat", this.B);
    }

    public final void P(long j2) {
        Future future = this.v;
        if (future != null) {
            future.cancel(false);
        }
        if (j2 <= 0) {
            j2 = this.j + this.k;
        }
        this.v = I().schedule(new f(this, this), j2, TimeUnit.MILLISECONDS);
    }

    public final void Q() {
        ej4.a("onOpen()");
        Logger logger = C;
        logger.fine("socket open");
        w wVar = w.OPEN;
        this.z = wVar;
        D = "websocket".equals(this.u.c);
        a("open", new Object[0]);
        H();
        if (this.z == wVar && this.c && (this.u instanceof vw3)) {
            logger.fine("starting upgrade probes");
            Iterator<String> it = this.r.iterator();
            while (it.hasNext()) {
                U(it.next());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R(zw3 zw3Var) {
        w wVar = this.z;
        if (wVar != w.OPENING && wVar != w.OPEN && wVar != w.CLOSING) {
            Logger logger = C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("packet received with socket readyState '%s'", this.z));
                return;
            }
            return;
        }
        Logger logger2 = C;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("socket received: type '%s', data '%s'", zw3Var.a, zw3Var.b));
        }
        ej4.a("onPacket == " + this.z + "  " + String.format("socket received: type '%s', data '%s'", zw3Var.a, zw3Var.b));
        a("packet", zw3Var);
        a("heartbeat", new Object[0]);
        if ("open".equals(zw3Var.a)) {
            try {
                O(new sw3((String) zw3Var.b));
                return;
            } catch (JSONException e2) {
                a("error", new EngineIOException(e2));
                return;
            }
        }
        if ("pong".equals(zw3Var.a)) {
            b0();
            a("pong", new Object[0]);
        } else if ("error".equals(zw3Var.a)) {
            EngineIOException engineIOException = new EngineIOException("server error");
            engineIOException.code = zw3Var.b;
            N(engineIOException);
        } else if ("message".equals(zw3Var.a)) {
            a("data", zw3Var.b);
            a("message", zw3Var.b);
        }
    }

    public tw3 S() {
        jx3.h(new o());
        return this;
    }

    public final void T() {
        jx3.h(new h());
    }

    public final void U(String str) {
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("probing transport '%s'", str));
        }
        ej4.a("probe()" + str);
        uw3[] uw3VarArr = {F(str)};
        boolean[] zArr = {false};
        D = false;
        Runnable[] runnableArr = {new e(this, uw3VarArr, tVar, aVar, bVar, this, cVar, dVar)};
        t tVar = new t(this, str, zArr, uw3VarArr, this, runnableArr);
        u uVar = new u(this, zArr, runnableArr, uw3VarArr);
        a aVar = new a(this, uw3VarArr, uVar, str, this);
        b bVar = new b(this, aVar);
        c cVar = new c(this, aVar);
        d dVar = new d(this, uw3VarArr, uVar);
        uw3VarArr[0].g("open", tVar);
        uw3VarArr[0].g("error", aVar);
        uw3VarArr[0].g(Close.ELEMENT, bVar);
        g(Close.ELEMENT, cVar);
        g("upgrading", dVar);
        uw3VarArr[0].r();
    }

    public void V(String str, Runnable runnable) {
        jx3.h(new i(str, runnable));
    }

    public void W(byte[] bArr, Runnable runnable) {
        jx3.h(new j(bArr, runnable));
    }

    public final void X(zw3 zw3Var, Runnable runnable) {
        w wVar = w.CLOSING;
        w wVar2 = this.z;
        if (wVar == wVar2 || w.CLOSED == wVar2) {
            return;
        }
        a("packetCreate", zw3Var);
        this.t.offer(zw3Var);
        if (runnable != null) {
            g("flush", new l(this, runnable));
        }
        H();
    }

    public final void Y(String str, Runnable runnable) {
        X(new zw3(str), runnable);
    }

    public final void Z(String str, String str2, Runnable runnable) {
        X(new zw3(str, str2), runnable);
    }

    public final void a0(String str, byte[] bArr, Runnable runnable) {
        X(new zw3(str, bArr), runnable);
    }

    public final void b0() {
        Future future = this.w;
        if (future != null) {
            future.cancel(false);
        }
        this.w = I().schedule(new g(this, this), this.j, TimeUnit.MILLISECONDS);
    }

    public final void c0(uw3 uw3Var) {
        Logger logger = C;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("setting transport %s", uw3Var.c));
        }
        if (this.u != null) {
            if (logger.isLoggable(level)) {
                logger.fine(String.format("clearing existing transport %s", this.u.c));
            }
            this.u.c();
        }
        this.u = uw3Var;
        uw3Var.f("drain", new s(this, this));
        uw3Var.f("packet", new r(this, this));
        uw3Var.f("error", new q(this, this));
        uw3Var.f(Close.ELEMENT, new p(this, this));
    }

    public void d0(String str) {
        e0(str, null);
    }

    public void e0(String str, Runnable runnable) {
        V(str, runnable);
    }

    public void f0(byte[] bArr) {
        g0(bArr, null);
    }

    public void g0(byte[] bArr, Runnable runnable) {
        W(bArr, runnable);
    }

    public tw3(URI uri, v vVar) {
        this(uri != null ? v.b(uri, vVar) : vVar);
    }

    public tw3(v vVar) throws SecurityException {
        this.t = new LinkedList<>();
        this.B = new k();
        String strSubstring = vVar.o;
        if (strSubstring != null) {
            if (strSubstring.split(SignatureImpl.INNER_SEP).length > 2) {
                int iIndexOf = strSubstring.indexOf(91);
                strSubstring = iIndexOf != -1 ? strSubstring.substring(iIndexOf + 1) : strSubstring;
                int iLastIndexOf = strSubstring.lastIndexOf(93);
                if (iLastIndexOf != -1) {
                    strSubstring = strSubstring.substring(0, iLastIndexOf);
                }
            }
            vVar.a = strSubstring;
        }
        boolean z = vVar.d;
        this.b = z;
        if (vVar.f == -1) {
            vVar.f = z ? 443 : 80;
        }
        String str = vVar.a;
        this.m = str == null ? "localhost" : str;
        this.g = vVar.f;
        String str2 = vVar.p;
        this.s = str2 != null ? ex3.a(str2) : new HashMap<>();
        this.c = vVar.m;
        StringBuilder sb = new StringBuilder();
        String str3 = vVar.b;
        sb.append((str3 == null ? "/engine.io" : str3).replaceAll("/$", ""));
        sb.append("/");
        this.n = sb.toString();
        String str4 = vVar.c;
        this.o = str4 == null ? "t" : str4;
        this.d = vVar.e;
        String[] strArr = vVar.l;
        this.p = new ArrayList(Arrays.asList(strArr == null ? new String[]{"polling", "websocket"} : strArr));
        Map<String, uw3.d> map = vVar.q;
        this.q = map == null ? new HashMap<>() : map;
        int i2 = vVar.g;
        this.h = i2 == 0 ? 843 : i2;
        this.f = vVar.n;
        ac4.a aVar = vVar.k;
        aVar = aVar == null ? F : aVar;
        this.y = aVar;
        ed4.a aVar2 = vVar.j;
        this.x = aVar2 == null ? E : aVar2;
        if (aVar == null) {
            if (G == null) {
                G = new vc4();
            }
            this.y = G;
        }
        if (this.x == null) {
            if (G == null) {
                G = new vc4();
            }
            this.x = G;
        }
        Logger logger = C;
        logger.setLevel(Level.FINEST);
        logger.addHandler(new n(this));
    }
}

package dc;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dc.ac4;
import dc.ed4;
import dc.gx3;
import dc.ix3;
import dc.mw3;
import dc.pw3;
import dc.tw3;
import io.socket.client.SocketIOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.ping.packet.Ping;

/* compiled from: Manager.java */
/* loaded from: classes4.dex */
public class lw3 extends pw3 {
    public static final Logger w = Logger.getLogger(lw3.class.getName());
    public static ed4.a x;
    public static ac4.a y;
    public p b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public long h;
    public long i;
    public double j;
    public iw3 k;
    public long l;
    public Set<nw3> m;
    public Date n;
    public URI o;
    public List<hx3> p;
    public Queue<mw3.b> q;
    public o r;
    public tw3 s;
    public ix3.b t;
    public ix3.a u;
    public ConcurrentHashMap<String, nw3> v;

    /* compiled from: Manager.java */
    public class a implements Runnable {
        public final /* synthetic */ n a;

        /* compiled from: Manager.java */
        /* renamed from: dc.lw3$a$a, reason: collision with other inner class name */
        public class C0198a implements pw3.a {
            public final /* synthetic */ lw3 a;

            public C0198a(a aVar, lw3 lw3Var) {
                this.a = lw3Var;
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                this.a.a(NotificationCompat.CATEGORY_TRANSPORT, objArr);
            }
        }

        /* compiled from: Manager.java */
        public class b implements pw3.a {
            public final /* synthetic */ lw3 a;

            public b(lw3 lw3Var) {
                this.a = lw3Var;
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                this.a.T();
                n nVar = a.this.a;
                if (nVar != null) {
                    nVar.a(null);
                }
            }
        }

        /* compiled from: Manager.java */
        public class c implements pw3.a {
            public final /* synthetic */ lw3 a;

            public c(lw3 lw3Var) {
                this.a = lw3Var;
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                Object obj = objArr.length > 0 ? objArr[0] : null;
                lw3.w.fine("connect_error");
                this.a.I();
                lw3 lw3Var = this.a;
                lw3Var.b = p.CLOSED;
                lw3Var.L("connect_error", obj);
                if (a.this.a != null) {
                    a.this.a.a(new SocketIOException("Connection error", obj instanceof Exception ? (Exception) obj : null));
                } else {
                    this.a.N();
                }
            }
        }

        /* compiled from: Manager.java */
        public class d extends TimerTask {
            public final /* synthetic */ long a;
            public final /* synthetic */ mw3.b b;
            public final /* synthetic */ tw3 c;
            public final /* synthetic */ lw3 d;

            /* compiled from: Manager.java */
            /* renamed from: dc.lw3$a$d$a, reason: collision with other inner class name */
            public class RunnableC0199a implements Runnable {
                public RunnableC0199a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    lw3.w.fine(String.format("connect attempt timed out after %d", Long.valueOf(d.this.a)));
                    d.this.b.destroy();
                    d.this.c.E();
                    d.this.c.a("error", new SocketIOException("timeout"));
                    d dVar = d.this;
                    dVar.d.L("connect_timeout", Long.valueOf(dVar.a));
                }
            }

            public d(a aVar, long j, mw3.b bVar, tw3 tw3Var, lw3 lw3Var) {
                this.a = j;
                this.b = bVar;
                this.c = tw3Var;
                this.d = lw3Var;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                jx3.h(new RunnableC0199a());
            }
        }

        /* compiled from: Manager.java */
        public class e implements mw3.b {
            public final /* synthetic */ Timer a;

            public e(a aVar, Timer timer) {
                this.a = timer;
            }

            @Override // dc.mw3.b
            public void destroy() {
                this.a.cancel();
            }
        }

        public a(n nVar) {
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar;
            Logger logger = lw3.w;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                lw3.w.fine(String.format("readyState %s", lw3.this.b));
            }
            p pVar2 = lw3.this.b;
            if (pVar2 == p.OPEN || pVar2 == (pVar = p.OPENING)) {
                return;
            }
            if (lw3.w.isLoggable(level)) {
                lw3.w.fine(String.format("opening %s", lw3.this.o));
            }
            lw3.this.s = new m(lw3.this.o, lw3.this.r);
            lw3 lw3Var = lw3.this;
            tw3 tw3Var = lw3Var.s;
            lw3Var.b = pVar;
            lw3Var.d = false;
            tw3Var.f(NotificationCompat.CATEGORY_TRANSPORT, new C0198a(this, lw3Var));
            mw3.b bVarA = mw3.a(tw3Var, "open", new b(lw3Var));
            mw3.b bVarA2 = mw3.a(tw3Var, "error", new c(lw3Var));
            if (lw3.this.l >= 0) {
                long j = lw3.this.l;
                lw3.w.fine(String.format("connection attempt will timeout after %d", Long.valueOf(j)));
                Timer timer = new Timer();
                timer.schedule(new d(this, j, bVarA, tw3Var, lw3Var), j);
                lw3.this.q.add(new e(this, timer));
            }
            lw3.this.q.add(bVarA);
            lw3.this.q.add(bVarA2);
            lw3.this.s.S();
        }
    }

    /* compiled from: Manager.java */
    public class b implements ix3.b.a {
        public final /* synthetic */ lw3 a;

        public b(lw3 lw3Var, lw3 lw3Var2) {
            this.a = lw3Var2;
        }

        @Override // dc.ix3.b.a
        public void call(Object[] objArr) {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    this.a.s.d0((String) obj);
                } else if (obj instanceof byte[]) {
                    this.a.s.f0((byte[]) obj);
                }
            }
            this.a.f = false;
            this.a.a0();
        }
    }

    /* compiled from: Manager.java */
    public class c extends TimerTask {
        public final /* synthetic */ lw3 a;

        /* compiled from: Manager.java */
        public class a implements Runnable {

            /* compiled from: Manager.java */
            /* renamed from: dc.lw3$c$a$a, reason: collision with other inner class name */
            public class C0200a implements n {
                public C0200a() {
                }

                @Override // dc.lw3.n
                public void a(Exception exc) {
                    if (exc == null) {
                        lw3.w.fine("reconnect success");
                        c.this.a.W();
                    } else {
                        lw3.w.fine("reconnect attempt error");
                        c.this.a.e = false;
                        c.this.a.d0();
                        c.this.a.L("reconnect_error", exc);
                    }
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a.d) {
                    return;
                }
                lw3.w.fine("attempting reconnect");
                int iB = c.this.a.k.b();
                c.this.a.L("reconnect_attempt", Integer.valueOf(iB));
                c.this.a.L("reconnecting", Integer.valueOf(iB));
                if (c.this.a.d) {
                    return;
                }
                c.this.a.Y(new C0200a());
            }
        }

        public c(lw3 lw3Var, lw3 lw3Var2) {
            this.a = lw3Var2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            jx3.h(new a());
        }
    }

    /* compiled from: Manager.java */
    public class d implements mw3.b {
        public final /* synthetic */ Timer a;

        public d(lw3 lw3Var, Timer timer) {
            this.a = timer;
        }

        @Override // dc.mw3.b
        public void destroy() {
            this.a.cancel();
        }
    }

    /* compiled from: Manager.java */
    public class e implements pw3.a {
        public e() {
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                lw3.this.P((String) obj);
            } else if (obj instanceof byte[]) {
                lw3.this.Q((byte[]) obj);
            }
        }
    }

    /* compiled from: Manager.java */
    public class f implements pw3.a {
        public f() {
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            lw3.this.U();
        }
    }

    /* compiled from: Manager.java */
    public class g implements pw3.a {
        public g() {
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            lw3.this.V();
        }
    }

    /* compiled from: Manager.java */
    public class h implements pw3.a {
        public h() {
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            lw3.this.S((Exception) objArr[0]);
        }
    }

    /* compiled from: Manager.java */
    public class i implements pw3.a {
        public i() {
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            lw3.this.O((String) objArr[0]);
        }
    }

    /* compiled from: Manager.java */
    public class j implements ix3.a.InterfaceC0188a {
        public j() {
        }

        @Override // dc.ix3.a.InterfaceC0188a
        public void a(hx3 hx3Var) {
            ej4.a("decoder onDecoded");
            lw3.this.R(hx3Var);
        }
    }

    /* compiled from: Manager.java */
    public class k implements pw3.a {
        public final /* synthetic */ lw3 a;
        public final /* synthetic */ nw3 b;

        public k(lw3 lw3Var, lw3 lw3Var2, nw3 nw3Var) {
            this.a = lw3Var2;
            this.b = nw3Var;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.m.add(this.b);
        }
    }

    /* compiled from: Manager.java */
    public class l implements pw3.a {
        public final /* synthetic */ nw3 a;
        public final /* synthetic */ lw3 b;
        public final /* synthetic */ String c;

        public l(lw3 lw3Var, nw3 nw3Var, lw3 lw3Var2, String str) {
            this.a = nw3Var;
            this.b = lw3Var2;
            this.c = str;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            this.a.b = this.b.M(this.c);
        }
    }

    /* compiled from: Manager.java */
    public static class m extends tw3 {
        public m(URI uri, tw3.v vVar) {
            super(uri, vVar);
        }
    }

    /* compiled from: Manager.java */
    public interface n {
        void a(Exception exc);
    }

    /* compiled from: Manager.java */
    public static class o extends tw3.v {
        public int s;
        public long t;
        public long u;
        public double v;
        public ix3.b w;
        public ix3.a x;
        public boolean r = true;
        public long y = SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
    }

    /* compiled from: Manager.java */
    public enum p {
        CLOSED,
        OPENING,
        OPEN
    }

    public lw3() {
        this(null, null);
    }

    public final void I() {
        w.fine("cleanup");
        while (true) {
            mw3.b bVarPoll = this.q.poll();
            if (bVarPoll == null) {
                this.u.a(null);
                this.p.clear();
                this.f = false;
                this.n = null;
                this.u.destroy();
                return;
            }
            bVarPoll.destroy();
        }
    }

    public void J() {
        w.fine("disconnect");
        this.d = true;
        this.e = false;
        if (this.b != p.OPEN) {
            I();
        }
        this.k.c();
        this.b = p.CLOSED;
        tw3 tw3Var = this.s;
        if (tw3Var != null) {
            tw3Var.E();
        }
    }

    public void K(nw3 nw3Var) {
        this.m.remove(nw3Var);
        if (this.m.isEmpty()) {
            J();
        }
    }

    public final void L(String str, Object... objArr) {
        a(str, objArr);
        Iterator<nw3> it = this.v.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, objArr);
        }
    }

    public final String M(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if ("/".equals(str)) {
            str2 = "";
        } else {
            str2 = str + "#";
        }
        sb.append(str2);
        sb.append(this.s.J());
        return sb.toString();
    }

    public final void N() {
        if (!this.e && this.c && this.k.b() == 0) {
            d0();
        }
    }

    public final void O(String str) {
        w.fine("onclose");
        I();
        this.k.c();
        this.b = p.CLOSED;
        a(Close.ELEMENT, str);
        if (!this.c || this.d) {
            return;
        }
        d0();
    }

    public final void P(String str) {
        this.u.add(str);
    }

    public final void Q(byte[] bArr) {
        this.u.add(bArr);
    }

    public final void R(hx3 hx3Var) {
        a("packet", hx3Var);
    }

    public final void S(Exception exc) {
        w.log(Level.FINE, "error", (Throwable) exc);
        L("error", exc);
    }

    public final void T() {
        w.fine("open");
        I();
        this.b = p.OPEN;
        a("open", new Object[0]);
        tw3 tw3Var = this.s;
        this.q.add(mw3.a(tw3Var, "data", new e()));
        this.q.add(mw3.a(tw3Var, Ping.ELEMENT, new f()));
        this.q.add(mw3.a(tw3Var, "pong", new g()));
        this.q.add(mw3.a(tw3Var, "error", new h()));
        this.q.add(mw3.a(tw3Var, Close.ELEMENT, new i()));
        this.u.a(new j());
    }

    public final void U() {
        this.n = new Date();
        L(Ping.ELEMENT, new Object[0]);
    }

    public final void V() {
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(this.n != null ? new Date().getTime() - this.n.getTime() : 0L);
        L("pong", objArr);
    }

    public final void W() {
        int iB = this.k.b();
        this.e = false;
        this.k.c();
        m0();
        L("reconnect", Integer.valueOf(iB));
    }

    public lw3 X() {
        Y(null);
        return this;
    }

    public lw3 Y(n nVar) {
        jx3.h(new a(nVar));
        return this;
    }

    public void Z(hx3 hx3Var) {
        Logger logger = w;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("writing packet %s", hx3Var));
        }
        String str = hx3Var.f;
        if (str != null && !str.isEmpty() && hx3Var.a == 0) {
            hx3Var.c += "?" + hx3Var.f;
        }
        if (this.f) {
            this.p.add(hx3Var);
        } else {
            this.f = true;
            this.t.a(hx3Var, new b(this, this));
        }
    }

    public final void a0() {
        if (this.p.isEmpty() || this.f) {
            return;
        }
        Z(this.p.remove(0));
    }

    public final double b0() {
        return this.j;
    }

    public lw3 c0(double d2) {
        this.j = d2;
        iw3 iw3Var = this.k;
        if (iw3Var != null) {
            iw3Var.d(d2);
        }
        return this;
    }

    public final void d0() {
        if (this.e || this.d) {
            return;
        }
        if (this.k.b() >= this.g) {
            w.fine("reconnect failed");
            this.k.c();
            L("reconnect_failed", new Object[0]);
            this.e = false;
            return;
        }
        long jA = this.k.a();
        w.fine(String.format("will wait %dms before reconnect attempt", Long.valueOf(jA)));
        this.e = true;
        Timer timer = new Timer();
        timer.schedule(new c(this, this), jA);
        this.q.add(new d(this, timer));
    }

    public lw3 e0(boolean z) {
        this.c = z;
        return this;
    }

    public lw3 f0(int i2) {
        this.g = i2;
        return this;
    }

    public final long g0() {
        return this.h;
    }

    public lw3 h0(long j2) {
        this.h = j2;
        iw3 iw3Var = this.k;
        if (iw3Var != null) {
            iw3Var.f(j2);
        }
        return this;
    }

    public final long i0() {
        return this.i;
    }

    public lw3 j0(long j2) {
        this.i = j2;
        iw3 iw3Var = this.k;
        if (iw3Var != null) {
            iw3Var.e(j2);
        }
        return this;
    }

    public nw3 k0(String str, o oVar) {
        nw3 nw3Var = this.v.get(str);
        if (nw3Var != null) {
            return nw3Var;
        }
        nw3 nw3Var2 = new nw3(this, str, oVar);
        nw3 nw3VarPutIfAbsent = this.v.putIfAbsent(str, nw3Var2);
        if (nw3VarPutIfAbsent != null) {
            return nw3VarPutIfAbsent;
        }
        nw3Var2.f("connecting", new k(this, this, nw3Var2));
        nw3Var2.f("connect", new l(this, nw3Var2, this, str));
        return nw3Var2;
    }

    public lw3 l0(long j2) {
        this.l = j2;
        return this;
    }

    public final void m0() {
        for (Map.Entry<String, nw3> entry : this.v.entrySet()) {
            String key = entry.getKey();
            entry.getValue().b = M(key);
        }
    }

    public lw3(URI uri, o oVar) {
        this.m = new HashSet();
        oVar = oVar == null ? new o() : oVar;
        if (oVar.b == null) {
            oVar.b = "/socket.io";
        }
        if (oVar.j == null) {
            oVar.j = x;
        }
        if (oVar.k == null) {
            oVar.k = y;
        }
        this.r = oVar;
        this.v = new ConcurrentHashMap<>();
        this.q = new LinkedList();
        e0(oVar.r);
        int i2 = oVar.s;
        f0(i2 == 0 ? Integer.MAX_VALUE : i2);
        long j2 = oVar.t;
        h0(j2 == 0 ? 1000L : j2);
        long j3 = oVar.u;
        j0(j3 == 0 ? 5000L : j3);
        double d2 = oVar.v;
        c0(d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0.5d : d2);
        iw3 iw3Var = new iw3();
        iw3Var.f(g0());
        iw3Var.e(i0());
        iw3Var.d(b0());
        this.k = iw3Var;
        l0(oVar.y);
        this.b = p.CLOSED;
        this.o = uri;
        this.f = false;
        this.p = new ArrayList();
        ix3.b bVar = oVar.w;
        this.t = bVar == null ? new gx3.c() : bVar;
        ix3.a aVar = oVar.x;
        this.u = aVar == null ? new gx3.b() : aVar;
    }
}

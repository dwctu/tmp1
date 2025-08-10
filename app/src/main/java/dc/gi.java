package dc;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.GlideException;
import dc.ei;
import dc.hi;
import dc.xp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
public class gi<R> implements ei.a, Runnable, Comparable<gi<?>>, xp.f {
    public sg A;
    public ih<?> B;
    public volatile ei C;
    public volatile boolean D;
    public volatile boolean E;
    public final e d;
    public final Pools.Pool<gi<?>> e;
    public mf h;
    public xg i;
    public of j;
    public mi k;
    public int l;
    public int m;
    public ii n;
    public ah o;
    public b<R> p;
    public int q;
    public h r;
    public g s;
    public long t;
    public boolean u;
    public Object v;
    public Thread w;
    public xg x;
    public xg y;
    public Object z;
    public final fi<R> a = new fi<>();
    public final List<Throwable> b = new ArrayList();
    public final zp c = zp.a();
    public final d<?> f = new d<>();
    public final f g = new f();

    /* compiled from: DecodeJob.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ug.values().length];
            c = iArr;
            try {
                iArr[ug.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[ug.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[h.values().length];
            b = iArr2;
            try {
                iArr2[h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: DecodeJob.java */
    public interface b<R> {
        void b(GlideException glideException);

        void c(ti<R> tiVar, sg sgVar);

        void e(gi<?> giVar);
    }

    /* compiled from: DecodeJob.java */
    public final class c<Z> implements hi.a<Z> {
        public final sg a;

        public c(sg sgVar) {
            this.a = sgVar;
        }

        @Override // dc.hi.a
        @NonNull
        public ti<Z> a(@NonNull ti<Z> tiVar) {
            return gi.this.v(this.a, tiVar);
        }
    }

    /* compiled from: DecodeJob.java */
    public static class d<Z> {
        public xg a;
        public dh<Z> b;
        public si<Z> c;

        public void a() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        public void b(e eVar, ah ahVar) {
            yp.a("DecodeJob.encode");
            try {
                eVar.a().a(this.a, new di(this.b, this.c, ahVar));
            } finally {
                this.c.g();
                yp.d();
            }
        }

        public boolean c() {
            return this.c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <X> void d(xg xgVar, dh<X> dhVar, si<X> siVar) {
            this.a = xgVar;
            this.b = dhVar;
            this.c = siVar;
        }
    }

    /* compiled from: DecodeJob.java */
    public interface e {
        mj a();
    }

    /* compiled from: DecodeJob.java */
    public static class f {
        public boolean a;
        public boolean b;
        public boolean c;

        public final boolean a(boolean z) {
            return (this.c || z || this.b) && this.a;
        }

        public synchronized boolean b() {
            this.b = true;
            return a(false);
        }

        public synchronized boolean c() {
            this.c = true;
            return a(false);
        }

        public synchronized boolean d(boolean z) {
            this.a = true;
            return a(z);
        }

        public synchronized void e() {
            this.b = false;
            this.a = false;
            this.c = false;
        }
    }

    /* compiled from: DecodeJob.java */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* compiled from: DecodeJob.java */
    public enum h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public gi(e eVar, Pools.Pool<gi<?>> pool) {
        this.d = eVar;
        this.e = pool;
    }

    public final void A() {
        int i = a.a[this.s.ordinal()];
        if (i == 1) {
            this.r = k(h.INITIALIZE);
            this.C = j();
            y();
        } else if (i == 2) {
            y();
        } else {
            if (i == 3) {
                i();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    public final void B() {
        Throwable th;
        this.c.c();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    public boolean C() {
        h hVarK = k(h.INITIALIZE);
        return hVarK == h.RESOURCE_CACHE || hVarK == h.DATA_CACHE;
    }

    @Override // dc.ei.a
    public void a(xg xgVar, Exception exc, ih<?> ihVar, sg sgVar) {
        ihVar.a();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.j(xgVar, sgVar, ihVar.getDataClass());
        this.b.add(glideException);
        if (Thread.currentThread() == this.w) {
            y();
        } else {
            this.s = g.SWITCH_TO_SOURCE_SERVICE;
            this.p.e(this);
        }
    }

    @Override // dc.ei.a
    public void b() {
        this.s = g.SWITCH_TO_SOURCE_SERVICE;
        this.p.e(this);
    }

    public void c() {
        this.E = true;
        ei eiVar = this.C;
        if (eiVar != null) {
            eiVar.cancel();
        }
    }

    @Override // dc.xp.f
    @NonNull
    public zp d() {
        return this.c;
    }

    @Override // dc.ei.a
    public void e(xg xgVar, Object obj, ih<?> ihVar, sg sgVar, xg xgVar2) {
        this.x = xgVar;
        this.z = obj;
        this.B = ihVar;
        this.A = sgVar;
        this.y = xgVar2;
        if (Thread.currentThread() != this.w) {
            this.s = g.DECODE_DATA;
            this.p.e(this);
        } else {
            yp.a("DecodeJob.decodeFromRetrievedData");
            try {
                i();
            } finally {
                yp.d();
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull gi<?> giVar) {
        int iM = m() - giVar.m();
        return iM == 0 ? this.q - giVar.q : iM;
    }

    public final <Data> ti<R> g(ih<?> ihVar, Data data, sg sgVar) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long jB = rp.b();
            ti<R> tiVarH = h(data, sgVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + tiVarH, jB);
            }
            return tiVarH;
        } finally {
            ihVar.a();
        }
    }

    public final <Data> ti<R> h(Data data, sg sgVar) throws GlideException {
        return z(data, sgVar, this.a.h(data.getClass()));
    }

    public final void i() {
        if (Log.isLoggable("DecodeJob", 2)) {
            p("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        ti<R> tiVarG = null;
        try {
            tiVarG = g(this.B, this.z, this.A);
        } catch (GlideException e2) {
            e2.i(this.y, this.A);
            this.b.add(e2);
        }
        if (tiVarG != null) {
            r(tiVarG, this.A);
        } else {
            y();
        }
    }

    public final ei j() {
        int i = a.b[this.r.ordinal()];
        if (i == 1) {
            return new ui(this.a, this);
        }
        if (i == 2) {
            return new bi(this.a, this);
        }
        if (i == 3) {
            return new xi(this.a, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    public final h k(h hVar) {
        int i = a.b[hVar.ordinal()];
        if (i == 1) {
            return this.n.a() ? h.DATA_CACHE : k(h.DATA_CACHE);
        }
        if (i == 2) {
            return this.u ? h.FINISHED : h.SOURCE;
        }
        if (i == 3 || i == 4) {
            return h.FINISHED;
        }
        if (i == 5) {
            return this.n.b() ? h.RESOURCE_CACHE : k(h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + hVar);
    }

    @NonNull
    public final ah l(sg sgVar) {
        ah ahVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return ahVar;
        }
        boolean z = sgVar == sg.RESOURCE_DISK_CACHE || this.a.w();
        zg<Boolean> zgVar = rl.j;
        Boolean bool = (Boolean) ahVar.c(zgVar);
        if (bool != null && (!bool.booleanValue() || z)) {
            return ahVar;
        }
        ah ahVar2 = new ah();
        ahVar2.d(this.o);
        ahVar2.e(zgVar, Boolean.valueOf(z));
        return ahVar2;
    }

    public final int m() {
        return this.j.ordinal();
    }

    public gi<R> n(mf mfVar, Object obj, mi miVar, xg xgVar, int i, int i2, Class<?> cls, Class<R> cls2, of ofVar, ii iiVar, Map<Class<?>, eh<?>> map, boolean z, boolean z2, boolean z3, ah ahVar, b<R> bVar, int i3) {
        this.a.u(mfVar, obj, xgVar, i, i2, iiVar, cls, cls2, ofVar, ahVar, map, z, z2, this.d);
        this.h = mfVar;
        this.i = xgVar;
        this.j = ofVar;
        this.k = miVar;
        this.l = i;
        this.m = i2;
        this.n = iiVar;
        this.u = z3;
        this.o = ahVar;
        this.p = bVar;
        this.q = i3;
        this.s = g.INITIALIZE;
        this.v = obj;
        return this;
    }

    public final void o(String str, long j) {
        p(str, j, null);
    }

    public final void p(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(rp.a(j));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.toString();
    }

    public final void q(ti<R> tiVar, sg sgVar) {
        B();
        this.p.c(tiVar, sgVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(ti<R> tiVar, sg sgVar) {
        if (tiVar instanceof pi) {
            ((pi) tiVar).initialize();
        }
        si siVar = 0;
        if (this.f.c()) {
            tiVar = si.e(tiVar);
            siVar = tiVar;
        }
        q(tiVar, sgVar);
        this.r = h.ENCODE;
        try {
            if (this.f.c()) {
                this.f.b(this.d, this.o);
            }
            t();
        } finally {
            if (siVar != 0) {
                siVar.g();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        yp.b("DecodeJob#run(model=%s)", this.v);
        ih<?> ihVar = this.B;
        try {
            try {
                try {
                    if (this.E) {
                        s();
                        if (ihVar != null) {
                            ihVar.a();
                        }
                        yp.d();
                        return;
                    }
                    A();
                    if (ihVar != null) {
                        ihVar.a();
                    }
                    yp.d();
                } catch (Throwable th) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        String str = "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r;
                    }
                    if (this.r != h.ENCODE) {
                        this.b.add(th);
                        s();
                    }
                    if (!this.E) {
                        throw th;
                    }
                    throw th;
                }
            } catch (ai e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            if (ihVar != null) {
                ihVar.a();
            }
            yp.d();
            throw th2;
        }
    }

    public final void s() {
        B();
        this.p.b(new GlideException("Failed to load resource", new ArrayList(this.b)));
        u();
    }

    public final void t() {
        if (this.g.b()) {
            x();
        }
    }

    public final void u() {
        if (this.g.c()) {
            x();
        }
    }

    @NonNull
    public <Z> ti<Z> v(sg sgVar, @NonNull ti<Z> tiVar) {
        ti<Z> tiVarA;
        eh<Z> ehVar;
        ug ugVarB;
        xg ciVar;
        Class<?> cls = tiVar.get().getClass();
        dh<Z> dhVarN = null;
        if (sgVar != sg.RESOURCE_DISK_CACHE) {
            eh<Z> ehVarR = this.a.r(cls);
            ehVar = ehVarR;
            tiVarA = ehVarR.a(this.h, tiVar, this.l, this.m);
        } else {
            tiVarA = tiVar;
            ehVar = null;
        }
        if (!tiVar.equals(tiVarA)) {
            tiVar.recycle();
        }
        if (this.a.v(tiVarA)) {
            dhVarN = this.a.n(tiVarA);
            ugVarB = dhVarN.b(this.o);
        } else {
            ugVarB = ug.NONE;
        }
        dh dhVar = dhVarN;
        if (!this.n.d(!this.a.x(this.x), sgVar, ugVarB)) {
            return tiVarA;
        }
        if (dhVar == null) {
            throw new Registry.NoResultEncoderAvailableException(tiVarA.get().getClass());
        }
        int i = a.c[ugVarB.ordinal()];
        if (i == 1) {
            ciVar = new ci(this.x, this.i);
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + ugVarB);
            }
            ciVar = new vi(this.a.b(), this.x, this.i, this.l, this.m, ehVar, cls, this.o);
        }
        si siVarE = si.e(tiVarA);
        this.f.d(ciVar, dhVar, siVarE);
        return siVarE;
    }

    public void w(boolean z) {
        if (this.g.d(z)) {
            x();
        }
    }

    public final void x() {
        this.g.e();
        this.f.a();
        this.a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.b.clear();
        this.e.release(this);
    }

    public final void y() {
        this.w = Thread.currentThread();
        this.t = rp.b();
        boolean zC = false;
        while (!this.E && this.C != null && !(zC = this.C.c())) {
            this.r = k(this.r);
            this.C = j();
            if (this.r == h.SOURCE) {
                b();
                return;
            }
        }
        if ((this.r == h.FINISHED || this.E) && !zC) {
            s();
        }
    }

    public final <Data, ResourceType> ti<R> z(Data data, sg sgVar, ri<Data, ResourceType, R> riVar) throws GlideException {
        ah ahVarL = l(sgVar);
        jh<Data> jhVarL = this.h.h().l(data);
        try {
            return riVar.a(jhVarL, ahVarL, this.l, this.m, new c(sgVar));
        } finally {
            jhVarL.a();
        }
    }
}

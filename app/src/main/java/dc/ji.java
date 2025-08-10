package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import dc.gi;
import dc.mj;
import dc.oi;
import dc.tj;
import dc.xp;
import java.util.Map;
import java.util.concurrent.Executor;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class ji implements li, tj.a, oi.a {
    public static final boolean i = Log.isLoggable("Engine", 2);
    public final qi a;
    public final ni b;
    public final tj c;
    public final b d;
    public final wi e;
    public final c f;
    public final a g;
    public final zh h;

    /* compiled from: Engine.java */
    @VisibleForTesting
    public static class a {
        public final gi.e a;
        public final Pools.Pool<gi<?>> b = xp.d(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, new C0191a());
        public int c;

        /* compiled from: Engine.java */
        /* renamed from: dc.ji$a$a, reason: collision with other inner class name */
        public class C0191a implements xp.d<gi<?>> {
            public C0191a() {
            }

            @Override // dc.xp.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public gi<?> a() {
                a aVar = a.this;
                return new gi<>(aVar.a, aVar.b);
            }
        }

        public a(gi.e eVar) {
            this.a = eVar;
        }

        public <R> gi<R> a(mf mfVar, Object obj, mi miVar, xg xgVar, int i, int i2, Class<?> cls, Class<R> cls2, of ofVar, ii iiVar, Map<Class<?>, eh<?>> map, boolean z, boolean z2, boolean z3, ah ahVar, gi.b<R> bVar) {
            gi giVarAcquire = this.b.acquire();
            vp.d(giVarAcquire);
            gi giVar = giVarAcquire;
            int i3 = this.c;
            this.c = i3 + 1;
            giVar.n(mfVar, obj, miVar, xgVar, i, i2, cls, cls2, ofVar, iiVar, map, z, z2, z3, ahVar, bVar, i3);
            return giVar;
        }
    }

    /* compiled from: Engine.java */
    @VisibleForTesting
    public static class b {
        public final wj a;
        public final wj b;
        public final wj c;
        public final wj d;
        public final li e;
        public final oi.a f;
        public final Pools.Pool<ki<?>> g = xp.d(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, new a());

        /* compiled from: Engine.java */
        public class a implements xp.d<ki<?>> {
            public a() {
            }

            @Override // dc.xp.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ki<?> a() {
                b bVar = b.this;
                return new ki<>(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        public b(wj wjVar, wj wjVar2, wj wjVar3, wj wjVar4, li liVar, oi.a aVar) {
            this.a = wjVar;
            this.b = wjVar2;
            this.c = wjVar3;
            this.d = wjVar4;
            this.e = liVar;
            this.f = aVar;
        }

        public <R> ki<R> a(xg xgVar, boolean z, boolean z2, boolean z3, boolean z4) {
            ki kiVarAcquire = this.g.acquire();
            vp.d(kiVarAcquire);
            ki kiVar = kiVarAcquire;
            kiVar.l(xgVar, z, z2, z3, z4);
            return kiVar;
        }
    }

    /* compiled from: Engine.java */
    public static class c implements gi.e {
        public final mj.a a;
        public volatile mj b;

        public c(mj.a aVar) {
            this.a = aVar;
        }

        @Override // dc.gi.e
        public mj a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.a.build();
                    }
                    if (this.b == null) {
                        this.b = new nj();
                    }
                }
            }
            return this.b;
        }
    }

    /* compiled from: Engine.java */
    public class d {
        public final ki<?> a;
        public final ro b;

        public d(ro roVar, ki<?> kiVar) {
            this.b = roVar;
            this.a = kiVar;
        }

        public void a() {
            synchronized (ji.this) {
                this.a.r(this.b);
            }
        }
    }

    public ji(tj tjVar, mj.a aVar, wj wjVar, wj wjVar2, wj wjVar3, wj wjVar4, boolean z) {
        this(tjVar, aVar, wjVar, wjVar2, wjVar3, wjVar4, null, null, null, null, null, null, z);
    }

    public static void j(String str, long j, xg xgVar) {
        String str2 = str + " in " + rp.a(j) + "ms, key: " + xgVar;
    }

    @Override // dc.tj.a
    public void a(@NonNull ti<?> tiVar) {
        this.e.a(tiVar, true);
    }

    @Override // dc.li
    public synchronized void b(ki<?> kiVar, xg xgVar, oi<?> oiVar) {
        if (oiVar != null) {
            if (oiVar.e()) {
                this.h.a(xgVar, oiVar);
            }
            this.a.d(xgVar, kiVar);
        } else {
            this.a.d(xgVar, kiVar);
        }
    }

    @Override // dc.li
    public synchronized void c(ki<?> kiVar, xg xgVar) {
        this.a.d(xgVar, kiVar);
    }

    @Override // dc.oi.a
    public void d(xg xgVar, oi<?> oiVar) {
        this.h.d(xgVar);
        if (oiVar.e()) {
            this.c.c(xgVar, oiVar);
        } else {
            this.e.a(oiVar, false);
        }
    }

    public final oi<?> e(xg xgVar) {
        ti<?> tiVarD = this.c.d(xgVar);
        if (tiVarD == null) {
            return null;
        }
        return tiVarD instanceof oi ? (oi) tiVarD : new oi<>(tiVarD, true, true, xgVar, this);
    }

    public <R> d f(mf mfVar, Object obj, xg xgVar, int i2, int i3, Class<?> cls, Class<R> cls2, of ofVar, ii iiVar, Map<Class<?>, eh<?>> map, boolean z, boolean z2, ah ahVar, boolean z3, boolean z4, boolean z5, boolean z6, ro roVar, Executor executor) {
        long jB = i ? rp.b() : 0L;
        mi miVarA = this.b.a(obj, xgVar, i2, i3, map, cls, cls2, ahVar);
        synchronized (this) {
            oi<?> oiVarI = i(miVarA, z3, jB);
            if (oiVarI == null) {
                return l(mfVar, obj, xgVar, i2, i3, cls, cls2, ofVar, iiVar, map, z, z2, ahVar, z3, z4, z5, z6, roVar, executor, miVarA, jB);
            }
            roVar.c(oiVarI, sg.MEMORY_CACHE);
            return null;
        }
    }

    @Nullable
    public final oi<?> g(xg xgVar) {
        oi<?> oiVarE = this.h.e(xgVar);
        if (oiVarE != null) {
            oiVarE.a();
        }
        return oiVarE;
    }

    public final oi<?> h(xg xgVar) {
        oi<?> oiVarE = e(xgVar);
        if (oiVarE != null) {
            oiVarE.a();
            this.h.a(xgVar, oiVarE);
        }
        return oiVarE;
    }

    @Nullable
    public final oi<?> i(mi miVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        oi<?> oiVarG = g(miVar);
        if (oiVarG != null) {
            if (i) {
                j("Loaded resource from active resources", j, miVar);
            }
            return oiVarG;
        }
        oi<?> oiVarH = h(miVar);
        if (oiVarH == null) {
            return null;
        }
        if (i) {
            j("Loaded resource from cache", j, miVar);
        }
        return oiVarH;
    }

    public void k(ti<?> tiVar) {
        if (!(tiVar instanceof oi)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((oi) tiVar).f();
    }

    public final <R> d l(mf mfVar, Object obj, xg xgVar, int i2, int i3, Class<?> cls, Class<R> cls2, of ofVar, ii iiVar, Map<Class<?>, eh<?>> map, boolean z, boolean z2, ah ahVar, boolean z3, boolean z4, boolean z5, boolean z6, ro roVar, Executor executor, mi miVar, long j) {
        ki<?> kiVarA = this.a.a(miVar, z6);
        if (kiVarA != null) {
            kiVarA.a(roVar, executor);
            if (i) {
                j("Added to existing load", j, miVar);
            }
            return new d(roVar, kiVarA);
        }
        ki<R> kiVarA2 = this.d.a(miVar, z3, z4, z5, z6);
        gi<R> giVarA = this.g.a(mfVar, obj, miVar, xgVar, i2, i3, cls, cls2, ofVar, iiVar, map, z, z2, z6, ahVar, kiVarA2);
        this.a.c(miVar, kiVarA2);
        kiVarA2.a(roVar, executor);
        kiVarA2.s(giVarA);
        if (i) {
            j("Started new load", j, miVar);
        }
        return new d(roVar, kiVarA2);
    }

    @VisibleForTesting
    public ji(tj tjVar, mj.a aVar, wj wjVar, wj wjVar2, wj wjVar3, wj wjVar4, qi qiVar, ni niVar, zh zhVar, b bVar, a aVar2, wi wiVar, boolean z) {
        this.c = tjVar;
        c cVar = new c(aVar);
        this.f = cVar;
        zh zhVar2 = zhVar == null ? new zh(z) : zhVar;
        this.h = zhVar2;
        zhVar2.f(this);
        this.b = niVar == null ? new ni() : niVar;
        this.a = qiVar == null ? new qi() : qiVar;
        this.d = bVar == null ? new b(wjVar, wjVar2, wjVar3, wjVar4, this, this) : bVar;
        this.g = aVar2 == null ? new a(cVar) : aVar2;
        this.e = wiVar == null ? new wi() : wiVar;
        tjVar.e(this);
    }
}

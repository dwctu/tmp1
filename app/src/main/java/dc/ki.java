package dc;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.GlideException;
import dc.gi;
import dc.oi;
import dc.xp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
public class ki<R> implements gi.b<R>, xp.f {
    public static final c y = new c();
    public final e a;
    public final zp b;
    public final oi.a c;
    public final Pools.Pool<ki<?>> d;
    public final c e;
    public final li f;
    public final wj g;
    public final wj h;
    public final wj i;
    public final wj j;
    public final AtomicInteger k;
    public xg l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public ti<?> q;
    public sg r;
    public boolean s;
    public GlideException t;
    public boolean u;
    public oi<?> v;
    public gi<R> w;
    public volatile boolean x;

    /* compiled from: EngineJob.java */
    public class a implements Runnable {
        public final ro a;

        public a(ro roVar) {
            this.a = roVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.f()) {
                synchronized (ki.this) {
                    if (ki.this.a.b(this.a)) {
                        ki.this.f(this.a);
                    }
                    ki.this.i();
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    public class b implements Runnable {
        public final ro a;

        public b(ro roVar) {
            this.a = roVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.f()) {
                synchronized (ki.this) {
                    if (ki.this.a.b(this.a)) {
                        ki.this.v.a();
                        ki.this.g(this.a);
                        ki.this.r(this.a);
                    }
                    ki.this.i();
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    @VisibleForTesting
    public static class c {
        public <R> oi<R> a(ti<R> tiVar, boolean z, xg xgVar, oi.a aVar) {
            return new oi<>(tiVar, z, true, xgVar, aVar);
        }
    }

    /* compiled from: EngineJob.java */
    public static final class d {
        public final ro a;
        public final Executor b;

        public d(ro roVar, Executor executor) {
            this.a = roVar;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* compiled from: EngineJob.java */
    public static final class e implements Iterable<d> {
        public final List<d> a;

        public e() {
            this(new ArrayList(2));
        }

        public static d d(ro roVar) {
            return new d(roVar, qp.a());
        }

        public void a(ro roVar, Executor executor) {
            this.a.add(new d(roVar, executor));
        }

        public boolean b(ro roVar) {
            return this.a.contains(d(roVar));
        }

        public e c() {
            return new e(new ArrayList(this.a));
        }

        public void clear() {
            this.a.clear();
        }

        public void e(ro roVar) {
            this.a.remove(d(roVar));
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.a.iterator();
        }

        public int size() {
            return this.a.size();
        }

        public e(List<d> list) {
            this.a = list;
        }
    }

    public ki(wj wjVar, wj wjVar2, wj wjVar3, wj wjVar4, li liVar, oi.a aVar, Pools.Pool<ki<?>> pool) {
        this(wjVar, wjVar2, wjVar3, wjVar4, liVar, aVar, pool, y);
    }

    public synchronized void a(ro roVar, Executor executor) {
        this.b.c();
        this.a.a(roVar, executor);
        boolean z = true;
        if (this.s) {
            k(1);
            executor.execute(new b(roVar));
        } else if (this.u) {
            k(1);
            executor.execute(new a(roVar));
        } else {
            if (this.x) {
                z = false;
            }
            vp.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @Override // dc.gi.b
    public void b(GlideException glideException) {
        synchronized (this) {
            this.t = glideException;
        }
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.gi.b
    public void c(ti<R> tiVar, sg sgVar) {
        synchronized (this) {
            this.q = tiVar;
            this.r = sgVar;
        }
        o();
    }

    @Override // dc.xp.f
    @NonNull
    public zp d() {
        return this.b;
    }

    @Override // dc.gi.b
    public void e(gi<?> giVar) {
        j().execute(giVar);
    }

    @GuardedBy("this")
    public void f(ro roVar) {
        try {
            roVar.b(this.t);
        } catch (Throwable th) {
            throw new ai(th);
        }
    }

    @GuardedBy("this")
    public void g(ro roVar) {
        try {
            roVar.c(this.v, this.r);
        } catch (Throwable th) {
            throw new ai(th);
        }
    }

    public void h() {
        if (m()) {
            return;
        }
        this.x = true;
        this.w.c();
        this.f.c(this, this.l);
    }

    public void i() {
        oi<?> oiVar;
        synchronized (this) {
            this.b.c();
            vp.a(m(), "Not yet complete!");
            int iDecrementAndGet = this.k.decrementAndGet();
            vp.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                oiVar = this.v;
                q();
            } else {
                oiVar = null;
            }
        }
        if (oiVar != null) {
            oiVar.f();
        }
    }

    public final wj j() {
        return this.n ? this.i : this.o ? this.j : this.h;
    }

    public synchronized void k(int i) {
        oi<?> oiVar;
        vp.a(m(), "Not yet complete!");
        if (this.k.getAndAdd(i) == 0 && (oiVar = this.v) != null) {
            oiVar.a();
        }
    }

    @VisibleForTesting
    public synchronized ki<R> l(xg xgVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.l = xgVar;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        return this;
    }

    public final boolean m() {
        return this.u || this.s || this.x;
    }

    public void n() {
        synchronized (this) {
            this.b.c();
            if (this.x) {
                q();
                return;
            }
            if (this.a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.u) {
                throw new IllegalStateException("Already failed once");
            }
            this.u = true;
            xg xgVar = this.l;
            e eVarC = this.a.c();
            k(eVarC.size() + 1);
            this.f.b(this, xgVar, null);
            Iterator<d> it = eVarC.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.b.execute(new a(next.a));
            }
            i();
        }
    }

    public void o() {
        synchronized (this) {
            this.b.c();
            if (this.x) {
                this.q.recycle();
                q();
                return;
            }
            if (this.a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.s) {
                throw new IllegalStateException("Already have resource");
            }
            this.v = this.e.a(this.q, this.m, this.l, this.c);
            this.s = true;
            e eVarC = this.a.c();
            k(eVarC.size() + 1);
            this.f.b(this, this.l, this.v);
            Iterator<d> it = eVarC.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.b.execute(new b(next.a));
            }
            i();
        }
    }

    public boolean p() {
        return this.p;
    }

    public final synchronized void q() {
        if (this.l == null) {
            throw new IllegalArgumentException();
        }
        this.a.clear();
        this.l = null;
        this.v = null;
        this.q = null;
        this.u = false;
        this.x = false;
        this.s = false;
        this.w.w(false);
        this.w = null;
        this.t = null;
        this.r = null;
        this.d.release(this);
    }

    public synchronized void r(ro roVar) {
        this.b.c();
        this.a.e(roVar);
        if (this.a.isEmpty()) {
            h();
            if ((this.s || this.u) && this.k.get() == 0) {
                q();
            }
        }
    }

    public synchronized void s(gi<R> giVar) {
        this.w = giVar;
        (giVar.C() ? this.g : j()).execute(giVar);
    }

    @VisibleForTesting
    public ki(wj wjVar, wj wjVar2, wj wjVar3, wj wjVar4, li liVar, oi.a aVar, Pools.Pool<ki<?>> pool, c cVar) {
        this.a = new e();
        this.b = zp.a();
        this.k = new AtomicInteger();
        this.g = wjVar;
        this.h = wjVar2;
        this.i = wjVar3;
        this.j = wjVar4;
        this.f = liVar;
        this.c = aVar;
        this.d = pool;
        this.e = cVar;
    }
}

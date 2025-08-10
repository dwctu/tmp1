package dc;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import dc.xp;

/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
public final class si<Z> implements ti<Z>, xp.f {
    public static final Pools.Pool<si<?>> e = xp.d(20, new a());
    public final zp a = zp.a();
    public ti<Z> b;
    public boolean c;
    public boolean d;

    /* compiled from: LockedResource.java */
    public class a implements xp.d<si<?>> {
        @Override // dc.xp.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public si<?> a() {
            return new si<>();
        }
    }

    @NonNull
    public static <Z> si<Z> e(ti<Z> tiVar) {
        si siVarAcquire = e.acquire();
        vp.d(siVarAcquire);
        si siVar = siVarAcquire;
        siVar.a(tiVar);
        return siVar;
    }

    public final void a(ti<Z> tiVar) {
        this.d = false;
        this.c = true;
        this.b = tiVar;
    }

    @Override // dc.ti
    public int b() {
        return this.b.b();
    }

    @Override // dc.ti
    @NonNull
    public Class<Z> c() {
        return this.b.c();
    }

    @Override // dc.xp.f
    @NonNull
    public zp d() {
        return this.a;
    }

    public final void f() {
        this.b = null;
        e.release(this);
    }

    public synchronized void g() {
        this.a.c();
        if (!this.c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.c = false;
        if (this.d) {
            recycle();
        }
    }

    @Override // dc.ti
    @NonNull
    public Z get() {
        return this.b.get();
    }

    @Override // dc.ti
    public synchronized void recycle() {
        this.a.c();
        this.d = true;
        if (!this.c) {
            this.b.recycle();
            f();
        }
    }
}

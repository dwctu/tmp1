package dc;

import androidx.annotation.NonNull;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
public class oi<Z> implements ti<Z> {
    public final boolean a;
    public final boolean b;
    public final ti<Z> c;
    public final a d;
    public final xg e;
    public int f;
    public boolean g;

    /* compiled from: EngineResource.java */
    public interface a {
        void d(xg xgVar, oi<?> oiVar);
    }

    public oi(ti<Z> tiVar, boolean z, boolean z2, xg xgVar, a aVar) {
        vp.d(tiVar);
        this.c = tiVar;
        this.a = z;
        this.b = z2;
        this.e = xgVar;
        vp.d(aVar);
        this.d = aVar;
    }

    public synchronized void a() {
        if (this.g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f++;
    }

    @Override // dc.ti
    public int b() {
        return this.c.b();
    }

    @Override // dc.ti
    @NonNull
    public Class<Z> c() {
        return this.c.c();
    }

    public ti<Z> d() {
        return this.c;
    }

    public boolean e() {
        return this.a;
    }

    public void f() {
        boolean z;
        synchronized (this) {
            int i = this.f;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.f = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.d.d(this.e, this);
        }
    }

    @Override // dc.ti
    @NonNull
    public Z get() {
        return this.c.get();
    }

    @Override // dc.ti
    public synchronized void recycle() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.g = true;
        if (this.b) {
            this.c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + MessageFormatter.DELIM_STOP;
    }
}

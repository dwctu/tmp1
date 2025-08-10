package dc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.GlideException;
import dc.ji;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: SingleRequest.java */
/* loaded from: classes.dex */
public final class so<R> implements mo, bp, ro {
    public static final boolean D = Log.isLoggable("Request", 2);

    @GuardedBy("requestLock")
    public int A;

    @GuardedBy("requestLock")
    public boolean B;

    @Nullable
    public RuntimeException C;

    @Nullable
    public final String a;
    public final zp b;
    public final Object c;

    @Nullable
    public final po<R> d;
    public final no e;
    public final Context f;
    public final mf g;

    @Nullable
    public final Object h;
    public final Class<R> i;
    public final jo<?> j;
    public final int k;
    public final int l;
    public final of m;
    public final cp<R> n;

    @Nullable
    public final List<po<R>> o;
    public final ip<? super R> p;
    public final Executor q;

    @GuardedBy("requestLock")
    public ti<R> r;

    @GuardedBy("requestLock")
    public ji.d s;

    @GuardedBy("requestLock")
    public long t;
    public volatile ji u;

    @GuardedBy("requestLock")
    public a v;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable w;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable x;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable y;

    @GuardedBy("requestLock")
    public int z;

    /* compiled from: SingleRequest.java */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public so(Context context, mf mfVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, jo<?> joVar, int i, int i2, of ofVar, cp<R> cpVar, @Nullable po<R> poVar, @Nullable List<po<R>> list, no noVar, ji jiVar, ip<? super R> ipVar, Executor executor) {
        this.a = D ? String.valueOf(super.hashCode()) : null;
        this.b = zp.a();
        this.c = obj;
        this.f = context;
        this.g = mfVar;
        this.h = obj2;
        this.i = cls;
        this.j = joVar;
        this.k = i;
        this.l = i2;
        this.m = ofVar;
        this.n = cpVar;
        this.d = poVar;
        this.o = list;
        this.e = noVar;
        this.u = jiVar;
        this.p = ipVar;
        this.q = executor;
        this.v = a.PENDING;
        if (this.C == null && mfVar.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    public static int t(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    public static <R> so<R> w(Context context, mf mfVar, Object obj, Object obj2, Class<R> cls, jo<?> joVar, int i, int i2, of ofVar, cp<R> cpVar, po<R> poVar, @Nullable List<po<R>> list, no noVar, ji jiVar, ip<? super R> ipVar, Executor executor) {
        return new so<>(context, mfVar, obj, obj2, cls, joVar, i, i2, ofVar, cpVar, poVar, list, noVar, jiVar, ipVar, executor);
    }

    @Override // dc.mo
    public boolean a() {
        boolean z;
        synchronized (this.c) {
            z = this.v == a.COMPLETE;
        }
        return z;
    }

    @Override // dc.ro
    public void b(GlideException glideException) {
        x(glideException, 5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r6 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        r5.u.k(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ad, code lost:
    
        if (r6 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
    
        r5.u.k(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.ro
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(dc.ti<?> r6, dc.sg r7) {
        /*
            r5 = this;
            dc.zp r0 = r5.b
            r0.c()
            r0 = 0
            java.lang.Object r1 = r5.c     // Catch: java.lang.Throwable -> Lbc
            monitor-enter(r1)     // Catch: java.lang.Throwable -> Lbc
            r5.s = r0     // Catch: java.lang.Throwable -> Lb9
            if (r6 != 0) goto L2f
            com.bumptech.glide.load.engine.GlideException r6 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r7.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = "Expected to receive a Resource<R> with an object of "
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.Class<R> r2 = r5.i     // Catch: java.lang.Throwable -> Lb9
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = " inside, but instead got null."
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb9
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lb9
            r5.b(r6)     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb9
            return
        L2f:
            java.lang.Object r2 = r6.get()     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L5c
            java.lang.Class<R> r3 = r5.i     // Catch: java.lang.Throwable -> Lb9
            java.lang.Class r4 = r2.getClass()     // Catch: java.lang.Throwable -> Lb9
            boolean r3 = r3.isAssignableFrom(r4)     // Catch: java.lang.Throwable -> Lb9
            if (r3 != 0) goto L42
            goto L5c
        L42:
            boolean r3 = r5.l()     // Catch: java.lang.Throwable -> Lb9
            if (r3 != 0) goto L57
            r5.r = r0     // Catch: java.lang.Throwable -> Lb5
            dc.so$a r7 = dc.so.a.COMPLETE     // Catch: java.lang.Throwable -> Lb5
            r5.v = r7     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb5
            if (r6 == 0) goto L56
            dc.ji r7 = r5.u
            r7.k(r6)
        L56:
            return
        L57:
            r5.y(r6, r2, r7)     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb9
            return
        L5c:
            r5.r = r0     // Catch: java.lang.Throwable -> Lb5
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            r0.<init>()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "Expected to receive an object of "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.Class<R> r3 = r5.i     // Catch: java.lang.Throwable -> Lb5
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = " but instead got "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            if (r2 == 0) goto L7b
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Throwable -> Lb5
            goto L7d
        L7b:
            java.lang.String r3 = ""
        L7d:
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            r0.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "} inside Resource{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            r0.append(r6)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "}."
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            if (r2 == 0) goto L9d
            java.lang.String r2 = ""
            goto L9f
        L9d:
            java.lang.String r2 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L9f:
            r0.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lb5
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lb5
            r5.b(r7)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb5
            if (r6 == 0) goto Lb4
            dc.ji r7 = r5.u
            r7.k(r6)
        Lb4:
            return
        Lb5:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto Lba
        Lb9:
            r6 = move-exception
        Lba:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb9
            throw r6     // Catch: java.lang.Throwable -> Lbc
        Lbc:
            r6 = move-exception
            if (r0 == 0) goto Lc4
            dc.ji r7 = r5.u
            r7.k(r0)
        Lc4:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.so.c(dc.ti, dc.sg):void");
    }

    @Override // dc.mo
    public void clear() {
        synchronized (this.c) {
            i();
            this.b.c();
            a aVar = this.v;
            a aVar2 = a.CLEARED;
            if (aVar == aVar2) {
                return;
            }
            m();
            ti<R> tiVar = this.r;
            if (tiVar != null) {
                this.r = null;
            } else {
                tiVar = null;
            }
            if (j()) {
                this.n.e(p());
            }
            this.v = aVar2;
            if (tiVar != null) {
                this.u.k(tiVar);
            }
        }
    }

    @Override // dc.bp
    public void d(int i, int i2) throws Throwable {
        Object obj;
        this.b.c();
        Object obj2 = this.c;
        synchronized (obj2) {
            try {
                try {
                    boolean z = D;
                    if (z) {
                        s("Got onSizeReady in " + rp.a(this.t));
                    }
                    if (this.v == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        this.v = aVar;
                        float fB = this.j.B();
                        this.z = t(i, fB);
                        this.A = t(i2, fB);
                        if (z) {
                            s("finished setup for calling load in " + rp.a(this.t));
                        }
                        obj = obj2;
                        try {
                            this.s = this.u.f(this.g, this.h, this.j.A(), this.z, this.A, this.j.z(), this.i, this.m, this.j.n(), this.j.D(), this.j.M(), this.j.I(), this.j.t(), this.j.G(), this.j.F(), this.j.E(), this.j.s(), this, this.q);
                            if (this.v != aVar) {
                                this.s = null;
                            }
                            if (z) {
                                s("finished onSizeReady in " + rp.a(this.t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @Override // dc.mo
    public boolean e() {
        boolean z;
        synchronized (this.c) {
            z = this.v == a.CLEARED;
        }
        return z;
    }

    @Override // dc.ro
    public Object f() {
        this.b.c();
        return this.c;
    }

    @Override // dc.mo
    public boolean g(mo moVar) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        jo<?> joVar;
        of ofVar;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        jo<?> joVar2;
        of ofVar2;
        int size2;
        if (!(moVar instanceof so)) {
            return false;
        }
        synchronized (this.c) {
            i = this.k;
            i2 = this.l;
            obj = this.h;
            cls = this.i;
            joVar = this.j;
            ofVar = this.m;
            List<po<R>> list = this.o;
            size = list != null ? list.size() : 0;
        }
        so soVar = (so) moVar;
        synchronized (soVar.c) {
            i3 = soVar.k;
            i4 = soVar.l;
            obj2 = soVar.h;
            cls2 = soVar.i;
            joVar2 = soVar.j;
            ofVar2 = soVar.m;
            List<po<R>> list2 = soVar.o;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i == i3 && i2 == i4 && wp.c(obj, obj2) && cls.equals(cls2) && joVar.equals(joVar2) && ofVar == ofVar2 && size == size2;
    }

    @Override // dc.mo
    public void h() {
        synchronized (this.c) {
            i();
            this.b.c();
            this.t = rp.b();
            if (this.h == null) {
                if (wp.t(this.k, this.l)) {
                    this.z = this.k;
                    this.A = this.l;
                }
                x(new GlideException("Received null model"), o() == null ? 5 : 3);
                return;
            }
            a aVar = this.v;
            a aVar2 = a.RUNNING;
            if (aVar == aVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (aVar == a.COMPLETE) {
                c(this.r, sg.MEMORY_CACHE);
                return;
            }
            a aVar3 = a.WAITING_FOR_SIZE;
            this.v = aVar3;
            if (wp.t(this.k, this.l)) {
                d(this.k, this.l);
            } else {
                this.n.i(this);
            }
            a aVar4 = this.v;
            if ((aVar4 == aVar2 || aVar4 == aVar3) && k()) {
                this.n.a(p());
            }
            if (D) {
                s("finished run method in " + rp.a(this.t));
            }
        }
    }

    @GuardedBy("requestLock")
    public final void i() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // dc.mo
    public boolean isComplete() {
        boolean z;
        synchronized (this.c) {
            z = this.v == a.COMPLETE;
        }
        return z;
    }

    @Override // dc.mo
    public boolean isRunning() {
        boolean z;
        synchronized (this.c) {
            a aVar = this.v;
            z = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final boolean j() {
        no noVar = this.e;
        return noVar == null || noVar.i(this);
    }

    @GuardedBy("requestLock")
    public final boolean k() {
        no noVar = this.e;
        return noVar == null || noVar.b(this);
    }

    @GuardedBy("requestLock")
    public final boolean l() {
        no noVar = this.e;
        return noVar == null || noVar.c(this);
    }

    @GuardedBy("requestLock")
    public final void m() {
        i();
        this.b.c();
        this.n.b(this);
        ji.d dVar = this.s;
        if (dVar != null) {
            dVar.a();
            this.s = null;
        }
    }

    @GuardedBy("requestLock")
    public final Drawable n() {
        if (this.w == null) {
            Drawable drawableP = this.j.p();
            this.w = drawableP;
            if (drawableP == null && this.j.o() > 0) {
                this.w = r(this.j.o());
            }
        }
        return this.w;
    }

    @GuardedBy("requestLock")
    public final Drawable o() {
        if (this.y == null) {
            Drawable drawableQ = this.j.q();
            this.y = drawableQ;
            if (drawableQ == null && this.j.r() > 0) {
                this.y = r(this.j.r());
            }
        }
        return this.y;
    }

    @GuardedBy("requestLock")
    public final Drawable p() {
        if (this.x == null) {
            Drawable drawableW = this.j.w();
            this.x = drawableW;
            if (drawableW == null && this.j.x() > 0) {
                this.x = r(this.j.x());
            }
        }
        return this.x;
    }

    @Override // dc.mo
    public void pause() {
        synchronized (this.c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @GuardedBy("requestLock")
    public final boolean q() {
        no noVar = this.e;
        return noVar == null || !noVar.getRoot().a();
    }

    @GuardedBy("requestLock")
    public final Drawable r(@DrawableRes int i) {
        return km.a(this.g, i, this.j.C() != null ? this.j.C() : this.f.getTheme());
    }

    public final void s(String str) {
        String str2 = str + " this: " + this.a;
    }

    @GuardedBy("requestLock")
    public final void u() {
        no noVar = this.e;
        if (noVar != null) {
            noVar.d(this);
        }
    }

    @GuardedBy("requestLock")
    public final void v() {
        no noVar = this.e;
        if (noVar != null) {
            noVar.f(this);
        }
    }

    public final void x(GlideException glideException, int i) {
        boolean zC;
        this.b.c();
        synchronized (this.c) {
            glideException.k(this.C);
            int iG = this.g.g();
            if (iG <= i) {
                String str = "Load failed for " + this.h + " with size [" + this.z + "x" + this.A + "]";
                if (iG <= 4) {
                    glideException.g("Glide");
                }
            }
            this.s = null;
            this.v = a.FAILED;
            boolean z = true;
            this.B = true;
            try {
                List<po<R>> list = this.o;
                if (list != null) {
                    Iterator<po<R>> it = list.iterator();
                    zC = false;
                    while (it.hasNext()) {
                        zC |= it.next().c(glideException, this.h, this.n, q());
                    }
                } else {
                    zC = false;
                }
                po<R> poVar = this.d;
                if (poVar == null || !poVar.c(glideException, this.h, this.n, q())) {
                    z = false;
                }
                if (!(zC | z)) {
                    z();
                }
                this.B = false;
                u();
            } catch (Throwable th) {
                this.B = false;
                throw th;
            }
        }
    }

    @GuardedBy("requestLock")
    public final void y(ti<R> tiVar, R r, sg sgVar) {
        boolean zD;
        boolean zQ = q();
        this.v = a.COMPLETE;
        this.r = tiVar;
        if (this.g.g() <= 3) {
            String str = "Finished loading " + r.getClass().getSimpleName() + " from " + sgVar + " for " + this.h + " with size [" + this.z + "x" + this.A + "] in " + rp.a(this.t) + " ms";
        }
        boolean z = true;
        this.B = true;
        try {
            List<po<R>> list = this.o;
            if (list != null) {
                Iterator<po<R>> it = list.iterator();
                zD = false;
                while (it.hasNext()) {
                    zD |= it.next().d(r, this.h, this.n, sgVar, zQ);
                }
            } else {
                zD = false;
            }
            po<R> poVar = this.d;
            if (poVar == null || !poVar.d(r, this.h, this.n, sgVar, zQ)) {
                z = false;
            }
            if (!(z | zD)) {
                this.n.f(r, this.p.a(sgVar, zQ));
            }
            this.B = false;
            v();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @GuardedBy("requestLock")
    public final void z() {
        if (k()) {
            Drawable drawableO = this.h == null ? o() : null;
            if (drawableO == null) {
                drawableO = n();
            }
            if (drawableO == null) {
                drawableO = p();
            }
            this.n.h(drawableO);
        }
    }
}

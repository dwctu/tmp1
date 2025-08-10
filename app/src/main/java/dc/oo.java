package dc;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.GlideException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFutureTarget.java */
/* loaded from: classes.dex */
public class oo<R> implements lo<R>, po<R> {
    public static final a k = new a();
    public final int a;
    public final int b;
    public final boolean c;
    public final a d;

    @Nullable
    @GuardedBy("this")
    public R e;

    @Nullable
    @GuardedBy("this")
    public mo f;

    @GuardedBy("this")
    public boolean g;

    @GuardedBy("this")
    public boolean h;

    @GuardedBy("this")
    public boolean i;

    @Nullable
    @GuardedBy("this")
    public GlideException j;

    /* compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    public static class a {
        public void a(Object obj) {
            obj.notifyAll();
        }

        public void b(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public oo(int i, int i2) {
        this(i, i2, true, k);
    }

    @Override // dc.cp
    public void a(@Nullable Drawable drawable) {
    }

    @Override // dc.cp
    public void b(@NonNull bp bpVar) {
    }

    @Override // dc.po
    public synchronized boolean c(@Nullable GlideException glideException, Object obj, cp<R> cpVar, boolean z) {
        this.i = true;
        this.j = glideException;
        this.d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.g = true;
            this.d.a(this);
            mo moVar = null;
            if (z) {
                mo moVar2 = this.f;
                this.f = null;
                moVar = moVar2;
            }
            if (moVar != null) {
                moVar.clear();
            }
            return true;
        }
    }

    @Override // dc.po
    public synchronized boolean d(R r, Object obj, cp<R> cpVar, sg sgVar, boolean z) {
        this.h = true;
        this.e = r;
        this.d.a(this);
        return false;
    }

    @Override // dc.cp
    public void e(@Nullable Drawable drawable) {
    }

    @Override // dc.cp
    public synchronized void f(@NonNull R r, @Nullable hp<? super R> hpVar) {
    }

    @Override // dc.cp
    public synchronized void g(@Nullable mo moVar) {
        this.f = moVar;
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return j(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // dc.cp
    @Nullable
    public synchronized mo getRequest() {
        return this.f;
    }

    @Override // dc.cp
    public synchronized void h(@Nullable Drawable drawable) {
    }

    @Override // dc.cp
    public void i(@NonNull bp bpVar) {
        bpVar.d(this.a, this.b);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.g     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.h     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.i     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto Le
            goto L10
        Le:
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            monitor-exit(r1)
            return r0
        L13:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.oo.isDone():boolean");
    }

    public final synchronized R j(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.c && !isDone()) {
            wp.a();
        }
        if (this.g) {
            throw new CancellationException();
        }
        if (this.i) {
            throw new ExecutionException(this.j);
        }
        if (this.h) {
            return this.e;
        }
        if (l == null) {
            this.d.b(this, 0L);
        } else if (l.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                this.d.b(this, jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.i) {
            throw new ExecutionException(this.j);
        }
        if (this.g) {
            throw new CancellationException();
        }
        if (!this.h) {
            throw new TimeoutException();
        }
        return this.e;
    }

    @Override // dc.qn
    public void onDestroy() {
    }

    @Override // dc.qn
    public void onStart() {
    }

    @Override // dc.qn
    public void onStop() {
    }

    public oo(int i, int i2, boolean z, a aVar) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = aVar;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return j(Long.valueOf(timeUnit.toMillis(j)));
    }
}

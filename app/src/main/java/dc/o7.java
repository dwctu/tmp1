package dc;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public class o7<T> {
    public static Executor e = Executors.newCachedThreadPool();
    public final Set<j7<T>> a;
    public final Set<j7<Throwable>> b;
    public final Handler c;

    @Nullable
    public volatile n7<T> d;

    /* compiled from: LottieTask.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o7.this.d == null) {
                return;
            }
            n7 n7Var = o7.this.d;
            if (n7Var.b() != null) {
                o7.this.i(n7Var.b());
            } else {
                o7.this.g(n7Var.a());
            }
        }
    }

    /* compiled from: LottieTask.java */
    public class b extends FutureTask<n7<T>> {
        public b(Callable<n7<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                o7.this.l(get());
            } catch (InterruptedException | ExecutionException e) {
                o7.this.l(new n7(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public o7(Callable<n7<T>> callable) {
        this(callable, false);
    }

    public synchronized o7<T> e(j7<Throwable> j7Var) {
        if (this.d != null && this.d.a() != null) {
            j7Var.onResult(this.d.a());
        }
        this.b.add(j7Var);
        return this;
    }

    public synchronized o7<T> f(j7<T> j7Var) {
        if (this.d != null && this.d.b() != null) {
            j7Var.onResult(this.d.b());
        }
        this.a.add(j7Var);
        return this;
    }

    public final synchronized void g(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            dd.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((j7) it.next()).onResult(th);
        }
    }

    public final void h() {
        this.c.post(new a());
    }

    public final synchronized void i(T t) {
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((j7) it.next()).onResult(t);
        }
    }

    public synchronized o7<T> j(j7<Throwable> j7Var) {
        this.b.remove(j7Var);
        return this;
    }

    public synchronized o7<T> k(j7<T> j7Var) {
        this.a.remove(j7Var);
        return this;
    }

    public final void l(@Nullable n7<T> n7Var) {
        if (this.d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.d = n7Var;
        h();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public o7(Callable<n7<T>> callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (!z) {
            e.execute(new b(callable));
            return;
        }
        try {
            l(callable.call());
        } catch (Throwable th) {
            l(new n7<>(th));
        }
    }
}

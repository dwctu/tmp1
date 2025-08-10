package dc;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import dc.oi;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: ActiveResources.java */
/* loaded from: classes.dex */
public final class zh {
    public final boolean a;
    public final Executor b;

    @VisibleForTesting
    public final Map<xg, d> c;
    public final ReferenceQueue<oi<?>> d;
    public oi.a e;
    public volatile boolean f;

    @Nullable
    public volatile c g;

    /* compiled from: ActiveResources.java */
    public class a implements ThreadFactory {

        /* compiled from: ActiveResources.java */
        /* renamed from: dc.zh$a$a, reason: collision with other inner class name */
        public class RunnableC0235a implements Runnable {
            public final /* synthetic */ Runnable a;

            public RunnableC0235a(a aVar, Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(10);
                this.a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0235a(this, runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zh.this.b();
        }
    }

    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    public interface c {
        void a();
    }

    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    public static final class d extends WeakReference<oi<?>> {
        public final xg a;
        public final boolean b;

        @Nullable
        public ti<?> c;

        public d(@NonNull xg xgVar, @NonNull oi<?> oiVar, @NonNull ReferenceQueue<? super oi<?>> referenceQueue, boolean z) {
            ti<?> tiVar;
            super(oiVar, referenceQueue);
            vp.d(xgVar);
            this.a = xgVar;
            if (oiVar.e() && z) {
                ti<?> tiVarD = oiVar.d();
                vp.d(tiVarD);
                tiVar = tiVarD;
            } else {
                tiVar = null;
            }
            this.c = tiVar;
            this.b = oiVar.e();
        }

        public void a() {
            this.c = null;
            clear();
        }
    }

    public zh(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new a()));
    }

    public synchronized void a(xg xgVar, oi<?> oiVar) {
        d dVarPut = this.c.put(xgVar, new d(xgVar, oiVar, this.d, this.a));
        if (dVarPut != null) {
            dVarPut.a();
        }
    }

    public void b() {
        while (!this.f) {
            try {
                c((d) this.d.remove());
                c cVar = this.g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(@NonNull d dVar) {
        ti<?> tiVar;
        synchronized (this) {
            this.c.remove(dVar.a);
            if (dVar.b && (tiVar = dVar.c) != null) {
                this.e.d(dVar.a, new oi<>(tiVar, true, false, dVar.a, this.e));
            }
        }
    }

    public synchronized void d(xg xgVar) {
        d dVarRemove = this.c.remove(xgVar);
        if (dVarRemove != null) {
            dVarRemove.a();
        }
    }

    @Nullable
    public synchronized oi<?> e(xg xgVar) {
        d dVar = this.c.get(xgVar);
        if (dVar == null) {
            return null;
        }
        oi<?> oiVar = dVar.get();
        if (oiVar == null) {
            c(dVar);
        }
        return oiVar;
    }

    public void f(oi.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.e = aVar;
            }
        }
    }

    @VisibleForTesting
    public zh(boolean z, Executor executor) {
        this.c = new HashMap();
        this.d = new ReferenceQueue<>();
        this.a = z;
        this.b = executor;
        executor.execute(new b());
    }
}

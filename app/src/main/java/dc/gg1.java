package dc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Cleaner.java */
/* loaded from: classes3.dex */
public class gg1 {
    public static final gg1 d = new gg1();
    public final ReferenceQueue<Object> a = new ReferenceQueue<>();
    public final Thread b;
    public c c;

    /* compiled from: Cleaner.java */
    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            while (true) {
                try {
                    Reference referenceRemove = gg1.this.a.remove();
                    if (referenceRemove instanceof c) {
                        ((c) referenceRemove).a();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    Logger.getLogger(gg1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e);
                }
            }
        }
    }

    /* compiled from: Cleaner.java */
    public interface b {
        void a();
    }

    /* compiled from: Cleaner.java */
    public static class c extends PhantomReference<Object> implements b {
        public final gg1 a;
        public final Runnable b;
        public c c;
        public c d;

        public c(gg1 gg1Var, Object obj, ReferenceQueue<? super Object> referenceQueue, Runnable runnable) {
            super(obj, referenceQueue);
            this.a = gg1Var;
            this.b = runnable;
        }

        @Override // dc.gg1.b
        public void a() {
            if (this.a.f(this)) {
                this.b.run();
            }
        }

        public c b() {
            return this.d;
        }

        public c c() {
            return this.c;
        }

        public void d(c cVar) {
            this.d = cVar;
        }

        public void e(c cVar) {
            this.c = cVar;
        }
    }

    public gg1() {
        a aVar = new a();
        this.b = aVar;
        aVar.setName("JNA Cleaner");
        aVar.setDaemon(true);
        aVar.start();
    }

    public static gg1 d() {
        return d;
    }

    public final synchronized c c(c cVar) {
        c cVar2 = this.c;
        if (cVar2 == null) {
            this.c = cVar;
        } else {
            cVar.d(cVar2);
            this.c.e(cVar);
            this.c = cVar;
        }
        return cVar;
    }

    public synchronized b e(Object obj, Runnable runnable) {
        c cVar;
        cVar = new c(this, obj, this.a, runnable);
        c(cVar);
        return cVar;
    }

    public final synchronized boolean f(c cVar) {
        boolean z;
        boolean z2 = false;
        z = true;
        if (cVar == this.c) {
            this.c = cVar.b();
            z2 = true;
        }
        if (cVar.c() != null) {
            cVar.c().d(cVar.b());
        }
        if (cVar.b() != null) {
            cVar.b().e(cVar.c());
        }
        if (cVar.c() == null && cVar.b() == null) {
            z = z2;
        }
        cVar.d(null);
        cVar.e(null);
        return z;
    }
}

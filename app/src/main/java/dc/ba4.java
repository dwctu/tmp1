package dc;

import dc.y94;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: AsyncZipTask.java */
/* loaded from: classes5.dex */
public abstract class ba4<T> {
    public final y94 a;
    public final boolean b;
    public final ExecutorService c;

    /* compiled from: AsyncZipTask.java */
    public class a implements Runnable {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ba4 ba4Var = ba4.this;
                ba4Var.i(this.a, ba4Var.a);
            } catch (ZipException unused) {
            } catch (Throwable th) {
                ba4.this.c.shutdown();
                throw th;
            }
            ba4.this.c.shutdown();
        }
    }

    /* compiled from: AsyncZipTask.java */
    public static class b {
        public final y94 a;
        public final boolean b;
        public final ExecutorService c;

        public b(ExecutorService executorService, boolean z, y94 y94Var) {
            this.c = executorService;
            this.b = z;
            this.a = y94Var;
        }
    }

    public ba4(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public abstract long d(T t) throws ZipException;

    public void e(T t) throws ZipException {
        if (this.b && y94.b.BUSY.equals(this.a.d())) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        h();
        if (!this.b) {
            i(t, this.a);
            return;
        }
        this.a.k(d(t));
        this.c.execute(new a(t));
    }

    public abstract void f(T t, y94 y94Var) throws IOException;

    public abstract y94.c g();

    public final void h() {
        this.a.c();
        this.a.j(y94.b.BUSY);
        this.a.g(g());
    }

    public final void i(T t, y94 y94Var) throws ZipException {
        try {
            f(t, y94Var);
            y94Var.a();
        } catch (ZipException e) {
            y94Var.b(e);
            throw e;
        } catch (Exception e2) {
            y94Var.b(e2);
            throw new ZipException(e2);
        }
    }

    public void j() throws ZipException {
        if (this.a.e()) {
            this.a.i(y94.a.CANCELLED);
            this.a.j(y94.b.READY);
            throw new ZipException("Task cancelled", ZipException.a.TASK_CANCELLED_EXCEPTION);
        }
    }
}

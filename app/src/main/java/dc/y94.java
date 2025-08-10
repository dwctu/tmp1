package dc;

/* compiled from: ProgressMonitor.java */
/* loaded from: classes5.dex */
public class y94 {
    public b a;
    public long b;
    public long c;
    public int d;
    public boolean e;
    public boolean f;

    /* compiled from: ProgressMonitor.java */
    public enum a {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    /* compiled from: ProgressMonitor.java */
    public enum b {
        READY,
        BUSY
    }

    /* compiled from: ProgressMonitor.java */
    public enum c {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public y94() {
        f();
    }

    public void a() {
        a aVar = a.SUCCESS;
        this.d = 100;
        f();
    }

    public void b(Exception exc) {
        a aVar = a.ERROR;
        f();
    }

    public void c() {
        f();
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
    }

    public b d() {
        return this.a;
    }

    public boolean e() {
        return this.e;
    }

    public final void f() {
        c cVar = c.NONE;
        this.a = b.READY;
    }

    public void g(c cVar) {
    }

    public void h(String str) {
    }

    public void i(a aVar) {
    }

    public void j(b bVar) {
        this.a = bVar;
    }

    public void k(long j) {
        this.b = j;
    }

    public void l(long j) throws InterruptedException {
        long j2 = this.c + j;
        this.c = j2;
        long j3 = this.b;
        if (j3 > 0) {
            int i = (int) ((j2 * 100) / j3);
            this.d = i;
            if (i > 100) {
                this.d = 100;
            }
        }
        while (this.f) {
            try {
                Thread.sleep(150L);
            } catch (InterruptedException unused) {
            }
        }
    }
}

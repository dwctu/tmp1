package dc;

/* compiled from: ProgressListener.java */
/* loaded from: classes4.dex */
public abstract class ew3 implements cw3 {
    public boolean a;
    public long b = 0;
    public long c = 0;
    public int d = 100;

    @Override // dc.cw3
    public final void a(long j, long j2, float f) {
        if (!this.a) {
            d(j2);
            this.a = true;
        }
        if (j == -1 && j2 == -1 && f == -1.0f) {
            b(-1L, -1L, -1.0f, -1.0f);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = this.b;
        if (jCurrentTimeMillis - j3 >= this.d || j == j2 || f >= 1.0f) {
            long j4 = jCurrentTimeMillis - j3;
            if (j4 == 0) {
                j4++;
            }
            b(j, j2, f, (j - this.c) / j4);
            this.b = System.currentTimeMillis();
            this.c = j;
        }
        if (j == j2 || f >= 1.0f) {
            c();
        }
    }

    public abstract void b(long j, long j2, float f, float f2);

    public abstract void c();

    public abstract void d(long j);
}

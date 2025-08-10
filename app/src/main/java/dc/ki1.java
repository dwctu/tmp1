package dc;

/* compiled from: SpeedControlUtil.kt */
/* loaded from: classes3.dex */
public final class ki1 {
    public long b;
    public long c;
    public long d;
    public final long a = 1000000;
    public boolean e = true;

    public final void a(long j) throws InterruptedException {
        long j2 = this.c;
        long j3 = 0;
        if (j2 == 0) {
            this.c = System.nanoTime() / 1000;
            this.b = j;
            return;
        }
        if (this.e) {
            this.b = j - (this.a / 30);
            this.e = false;
        }
        long j4 = this.d;
        if (j4 == 0) {
            j4 = j - this.b;
        }
        if (j4 >= 0) {
            long j5 = this.a;
            j3 = j4 > ((long) 10) * j5 ? j5 * 5 : j4;
        }
        long j6 = j2 + j3;
        long jNanoTime = System.nanoTime();
        long j7 = 1000;
        while (true) {
            long j8 = jNanoTime / j7;
            if (j8 >= j6 - 100) {
                this.c += j3;
                this.b += j3;
                return;
            }
            long j9 = j6 - j8;
            if (j9 > 500000) {
                j9 = 500000;
            }
            try {
                Thread.sleep(j9 / j7, ((int) (j9 % j7)) * 1000);
            } catch (InterruptedException e) {
                xh1.c.c("AnimPlayer.SpeedControlUtil", "e=" + e, e);
            }
            jNanoTime = System.nanoTime();
        }
    }

    public final void b() {
        this.b = 0L;
        this.c = 0L;
    }

    public final void c(int i) {
        if (i <= 0) {
            return;
        }
        this.d = this.a / i;
    }
}

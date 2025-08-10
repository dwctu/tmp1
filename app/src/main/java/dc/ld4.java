package dc;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout.java */
/* loaded from: classes5.dex */
public class ld4 extends ge4 {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    public static ld4 head;
    private boolean inQueue;
    private ld4 next;
    private long timeoutAt;

    /* compiled from: AsyncTimeout.java */
    public class a implements ee4 {
        public final /* synthetic */ ee4 a;

        public a(ee4 ee4Var) {
            this.a = ee4Var;
        }

        @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ld4.this.enter();
            try {
                try {
                    this.a.close();
                    ld4.this.exit(true);
                } catch (IOException e) {
                    throw ld4.this.exit(e);
                }
            } catch (Throwable th) {
                ld4.this.exit(false);
                throw th;
            }
        }

        @Override // dc.ee4, java.io.Flushable
        public void flush() throws IOException {
            ld4.this.enter();
            try {
                try {
                    this.a.flush();
                    ld4.this.exit(true);
                } catch (IOException e) {
                    throw ld4.this.exit(e);
                }
            } catch (Throwable th) {
                ld4.this.exit(false);
                throw th;
            }
        }

        @Override // dc.ee4
        public ge4 timeout() {
            return ld4.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.a + ")";
        }

        @Override // dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            he4.b(nd4Var.b, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                be4 be4Var = nd4Var.a;
                while (true) {
                    if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        break;
                    }
                    j2 += be4Var.c - be4Var.b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    be4Var = be4Var.f;
                }
                ld4.this.enter();
                try {
                    try {
                        this.a.write(nd4Var, j2);
                        j -= j2;
                        ld4.this.exit(true);
                    } catch (IOException e) {
                        throw ld4.this.exit(e);
                    }
                } catch (Throwable th) {
                    ld4.this.exit(false);
                    throw th;
                }
            }
        }
    }

    /* compiled from: AsyncTimeout.java */
    public class b implements fe4 {
        public final /* synthetic */ fe4 a;

        public b(fe4 fe4Var) {
            this.a = fe4Var;
        }

        @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            ld4.this.enter();
            try {
                try {
                    this.a.close();
                    ld4.this.exit(true);
                } catch (IOException e) {
                    throw ld4.this.exit(e);
                }
            } catch (Throwable th) {
                ld4.this.exit(false);
                throw th;
            }
        }

        @Override // dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            ld4.this.enter();
            try {
                try {
                    long j2 = this.a.read(nd4Var, j);
                    ld4.this.exit(true);
                    return j2;
                } catch (IOException e) {
                    throw ld4.this.exit(e);
                }
            } catch (Throwable th) {
                ld4.this.exit(false);
                throw th;
            }
        }

        @Override // dc.fe4
        public ge4 timeout() {
            return ld4.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.a + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<dc.ld4> r0 = dc.ld4.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                dc.ld4 r1 = dc.ld4.awaitTimeout()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                dc.ld4 r2 = dc.ld4.head     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                dc.ld4.head = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.ld4.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static ld4 awaitTimeout() throws InterruptedException {
        ld4 ld4Var = head.next;
        if (ld4Var == null) {
            long jNanoTime = System.nanoTime();
            ld4.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - jNanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long jRemainingNanos = ld4Var.remainingNanos(System.nanoTime());
        if (jRemainingNanos > 0) {
            long j = jRemainingNanos / 1000000;
            ld4.class.wait(j, (int) (jRemainingNanos - (1000000 * j)));
            return null;
        }
        head.next = ld4Var.next;
        ld4Var.next = null;
        return ld4Var;
    }

    private static synchronized boolean cancelScheduledTimeout(ld4 ld4Var) {
        ld4 ld4Var2 = head;
        while (ld4Var2 != null) {
            ld4 ld4Var3 = ld4Var2.next;
            if (ld4Var3 == ld4Var) {
                ld4Var2.next = ld4Var.next;
                ld4Var.next = null;
                return false;
            }
            ld4Var2 = ld4Var3;
        }
        return true;
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(ld4 ld4Var, long j, boolean z) {
        if (head == null) {
            head = new ld4();
            new c().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            ld4Var.timeoutAt = Math.min(j, ld4Var.deadlineNanoTime() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            ld4Var.timeoutAt = j + jNanoTime;
        } else {
            if (!z) {
                throw new AssertionError();
            }
            ld4Var.timeoutAt = ld4Var.deadlineNanoTime();
        }
        long jRemainingNanos = ld4Var.remainingNanos(jNanoTime);
        ld4 ld4Var2 = head;
        while (true) {
            ld4 ld4Var3 = ld4Var2.next;
            if (ld4Var3 == null || jRemainingNanos < ld4Var3.remainingNanos(jNanoTime)) {
                break;
            } else {
                ld4Var2 = ld4Var2.next;
            }
        }
        ld4Var.next = ld4Var2.next;
        ld4Var2.next = ld4Var;
        if (ld4Var2 == head) {
            ld4.class.notify();
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final ee4 sink(ee4 ee4Var) {
        return new a(ee4Var);
    }

    public final fe4 source(fe4 fe4Var) {
        return new b(fe4Var);
    }

    public void timedOut() {
    }

    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    public final IOException exit(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }
}

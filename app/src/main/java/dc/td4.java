package dc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* loaded from: classes5.dex */
public class td4 extends ge4 {
    public ge4 a;

    public td4(ge4 ge4Var) {
        if (ge4Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = ge4Var;
    }

    public final ge4 a() {
        return this.a;
    }

    public final td4 b(ge4 ge4Var) {
        if (ge4Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = ge4Var;
        return this;
    }

    @Override // dc.ge4
    public ge4 clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // dc.ge4
    public ge4 clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // dc.ge4
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // dc.ge4
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // dc.ge4
    public void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }

    @Override // dc.ge4
    public ge4 timeout(long j, TimeUnit timeUnit) {
        return this.a.timeout(j, timeUnit);
    }

    @Override // dc.ge4
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // dc.ge4
    public ge4 deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }
}

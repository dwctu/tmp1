package dc;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RealConnectionPool;

/* compiled from: ConnectionPool.java */
/* loaded from: classes5.dex */
public final class gc4 {
    public final RealConnectionPool a;

    public gc4() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public gc4(int i, long j, TimeUnit timeUnit) {
        this.a = new RealConnectionPool(i, j, timeUnit);
    }
}

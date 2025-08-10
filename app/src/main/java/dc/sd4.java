package dc;

import java.io.IOException;

/* compiled from: ForwardingSource.java */
/* loaded from: classes5.dex */
public abstract class sd4 implements fe4 {
    private final fe4 delegate;

    public sd4(fe4 fe4Var) {
        if (fe4Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = fe4Var;
    }

    @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.delegate.close();
    }

    public final fe4 delegate() {
        return this.delegate;
    }

    @Override // dc.fe4
    public long read(nd4 nd4Var, long j) throws IOException {
        return this.delegate.read(nd4Var, j);
    }

    @Override // dc.fe4
    public ge4 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}

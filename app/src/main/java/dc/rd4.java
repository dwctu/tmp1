package dc;

import java.io.IOException;

/* compiled from: ForwardingSink.java */
/* loaded from: classes5.dex */
public abstract class rd4 implements ee4 {
    private final ee4 delegate;

    public rd4(ee4 ee4Var) {
        if (ee4Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = ee4Var;
    }

    @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final ee4 delegate() {
        return this.delegate;
    }

    @Override // dc.ee4, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // dc.ee4
    public ge4 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }

    @Override // dc.ee4
    public void write(nd4 nd4Var, long j) throws IOException {
        this.delegate.write(nd4Var, j);
    }
}

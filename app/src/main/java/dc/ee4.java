package dc;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink.java */
/* loaded from: classes5.dex */
public interface ee4 extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    @Override // java.io.Flushable
    void flush() throws IOException;

    ge4 timeout();

    void write(nd4 nd4Var, long j) throws IOException;
}

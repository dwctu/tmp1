package dc;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source.java */
/* loaded from: classes5.dex */
public interface fe4 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close() throws IOException;

    long read(nd4 nd4Var, long j) throws IOException;

    ge4 timeout();
}

package dc;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: DataSource.java */
/* loaded from: classes2.dex */
public interface i41 extends Closeable {
    void G(long j) throws IOException;

    ByteBuffer S(long j, long j2) throws IOException;

    long c(long j, long j2, WritableByteChannel writableByteChannel) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long o() throws IOException;
}

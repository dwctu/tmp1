package dc;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.java */
/* loaded from: classes5.dex */
public interface od4 extends ee4, WritableByteChannel {
    od4 F(long j) throws IOException;

    od4 R(long j) throws IOException;

    od4 U(qd4 qd4Var) throws IOException;

    OutputStream Y();

    nd4 a();

    od4 d() throws IOException;

    @Override // dc.ee4, java.io.Flushable
    void flush() throws IOException;

    od4 l() throws IOException;

    od4 s(String str) throws IOException;

    od4 v(String str, int i, int i2) throws IOException;

    long w(fe4 fe4Var) throws IOException;

    od4 write(byte[] bArr) throws IOException;

    od4 write(byte[] bArr, int i, int i2) throws IOException;

    od4 writeByte(int i) throws IOException;

    od4 writeInt(int i) throws IOException;

    od4 writeShort(int i) throws IOException;
}

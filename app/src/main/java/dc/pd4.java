package dc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.java */
/* loaded from: classes5.dex */
public interface pd4 extends fe4, ReadableByteChannel {
    byte[] B(long j) throws IOException;

    short D() throws IOException;

    void E(long j) throws IOException;

    long H(byte b) throws IOException;

    qd4 J(long j) throws IOException;

    byte[] M() throws IOException;

    boolean N() throws IOException;

    long P() throws IOException;

    String Q(Charset charset) throws IOException;

    int T() throws IOException;

    long W(ee4 ee4Var) throws IOException;

    long Z() throws IOException;

    @Deprecated
    nd4 a();

    InputStream a0();

    int c0(xd4 xd4Var) throws IOException;

    long g(qd4 qd4Var) throws IOException;

    nd4 h();

    void i(nd4 nd4Var, long j) throws IOException;

    long k(qd4 qd4Var) throws IOException;

    String n(long j) throws IOException;

    pd4 peek();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    boolean request(long j) throws IOException;

    void skip(long j) throws IOException;

    boolean t(long j, qd4 qd4Var) throws IOException;

    String z() throws IOException;
}

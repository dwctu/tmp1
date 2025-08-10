package dc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: DecompressedInputStream.java */
/* loaded from: classes5.dex */
public abstract class s84 extends InputStream {
    public r84<?> a;
    public byte[] b = new byte[1];

    public s84(r84<?> r84Var) {
        this.a = r84Var;
    }

    public void b(InputStream inputStream, int i) throws IOException {
        this.a.e(inputStream, i);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public byte[] e() {
        return this.a.j();
    }

    public int f(PushbackInputStream pushbackInputStream) throws IOException {
        return 0;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.b) == -1) {
            return -1;
        }
        return this.b[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.a.read(bArr, i, i2);
    }
}

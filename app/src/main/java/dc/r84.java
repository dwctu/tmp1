package dc;

import dc.f84;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: CipherInputStream.java */
/* loaded from: classes5.dex */
public abstract class r84<T extends f84> extends InputStream {
    public z84 a;
    public T b;
    public byte[] c;
    public byte[] d = new byte[1];

    public r84(z84 z84Var, l94 l94Var, char[] cArr, int i, boolean z) throws IOException {
        this.a = z84Var;
        this.b = (T) m(l94Var, cArr, z);
        if (ja4.g(l94Var).equals(v94.DEFLATE)) {
            this.c = new byte[i];
        }
    }

    public final void b(byte[] bArr, int i) {
        byte[] bArr2 = this.c;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public void e(InputStream inputStream, int i) throws IOException {
    }

    public T f() {
        return this.b;
    }

    public byte[] j() {
        return this.c;
    }

    public abstract T m(l94 l94Var, char[] cArr, boolean z) throws IOException;

    public int p(byte[] bArr) throws IOException {
        return this.a.b(bArr);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.d) == -1) {
            return -1;
        }
        return this.d[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iJ = ja4.j(this.a, bArr, i, i2);
        if (iJ > 0) {
            b(bArr, iJ);
            this.b.a(bArr, i, iJ);
        }
        return iJ;
    }
}

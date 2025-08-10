package dc;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: ZipEntryInputStream.java */
/* loaded from: classes5.dex */
public class z84 extends InputStream {
    public InputStream a;
    public long b = 0;
    public byte[] c = new byte[1];
    public long d;

    public z84(InputStream inputStream, long j) {
        this.a = inputStream;
        this.d = j;
    }

    public int b(byte[] bArr) throws IOException {
        int iE = this.a.read(bArr);
        if (iE == -1) {
            throw new IOException("Unexpected EOF reached when trying to read stream");
        }
        if (iE == bArr.length || (iE = e(bArr, iE)) == bArr.length) {
            return iE;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public final int e(byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int i2 = 0;
        for (int i3 = 0; i < bArr.length && i2 != -1 && i3 < 15; i3++) {
            i2 += this.a.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.d;
        if (j != -1) {
            long j2 = this.b;
            if (j2 >= j) {
                return -1;
            }
            if (i2 > j - j2) {
                i2 = (int) (j - j2);
            }
        }
        int i3 = this.a.read(bArr, i, i2);
        if (i3 > 0) {
            this.b += i3;
        }
        return i3;
    }
}

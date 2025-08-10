package dc;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: RawIO.java */
/* loaded from: classes5.dex */
public class ha4 {
    public final byte[] a = new byte[2];
    public final byte[] b = new byte[4];
    public final byte[] c = new byte[8];

    public final void a(InputStream inputStream, byte[] bArr, int i) throws IOException {
        if (ja4.j(inputStream, bArr, 0, i) != i) {
            throw new ZipException("Could not fill buffer");
        }
    }

    public int b(InputStream inputStream) throws IOException {
        a(inputStream, this.b, 4);
        return d(this.b);
    }

    public int c(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.b);
        return d(this.b);
    }

    public int d(byte[] bArr) {
        return e(bArr, 0);
    }

    public int e(byte[] bArr, int i) {
        return ((((bArr[i + 3] & 255) << 8) | (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    public long f(InputStream inputStream) throws IOException {
        byte[] bArr = this.c;
        a(inputStream, bArr, bArr.length);
        return j(this.c, 0);
    }

    public long g(InputStream inputStream, int i) throws IOException {
        n(this.c);
        a(inputStream, this.c, i);
        return j(this.c, 0);
    }

    public long h(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.c);
        return j(this.c, 0);
    }

    public long i(RandomAccessFile randomAccessFile, int i) throws IOException {
        n(this.c);
        randomAccessFile.readFully(this.c, 0, i);
        return j(this.c, 0);
    }

    public long j(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            n(this.c);
        }
        System.arraycopy(bArr, i, this.c, 0, Math.min(bArr.length - i, 8));
        byte[] bArr2 = this.c;
        return ((((((((((((((0 | (bArr2[7] & 255)) << 8) | (bArr2[6] & 255)) << 8) | (bArr2[5] & 255)) << 8) | (bArr2[4] & 255)) << 8) | (bArr2[3] & 255)) << 8) | (bArr2[2] & 255)) << 8) | (bArr2[1] & 255)) << 8) | (bArr2[0] & 255);
    }

    public int k(InputStream inputStream) throws IOException {
        byte[] bArr = this.a;
        a(inputStream, bArr, bArr.length);
        return m(this.a, 0);
    }

    public int l(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.a);
        return m(this.a, 0);
    }

    public int m(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public final void n(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }
}

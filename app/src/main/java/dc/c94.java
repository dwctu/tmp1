package dc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: ZipStandardSplitFileInputStream.java */
/* loaded from: classes5.dex */
public class c94 extends x84 {
    public RandomAccessFile a;
    public File b;
    public int c;
    public boolean d;
    public int e;
    public byte[] f = new byte[1];

    public c94(File file, boolean z, int i) throws FileNotFoundException {
        this.e = 0;
        this.a = new RandomAccessFile(file, x94.READ.getValue());
        this.b = file;
        this.d = z;
        this.c = i;
        if (z) {
            this.e = i;
        }
    }

    @Override // dc.x84
    public void b(k94 k94Var) throws IOException {
        if (this.d && this.e != k94Var.K()) {
            f(k94Var.K());
            this.e = k94Var.K();
        }
        this.a.seek(k94Var.M());
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public File e(int i) throws IOException {
        if (i == this.c) {
            return this.b;
        }
        String canonicalPath = this.b.getCanonicalPath();
        return new File(canonicalPath.substring(0, canonicalPath.lastIndexOf(".")) + (i >= 9 ? ".z" : ".z0") + (i + 1));
    }

    public void f(int i) throws IOException {
        File fileE = e(i);
        if (fileE.exists()) {
            this.a.close();
            this.a = new RandomAccessFile(fileE, x94.READ.getValue());
        } else {
            throw new FileNotFoundException("zip split file does not exist: " + fileE);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f) == -1) {
            return -1;
        }
        return this.f[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.a.read(bArr, i, i2);
        if ((i3 == i2 && i3 != -1) || !this.d) {
            return i3;
        }
        f(this.e + 1);
        this.e++;
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.a.read(bArr, i3, i2 - i3);
        return i4 > 0 ? i3 + i4 : i3;
    }
}

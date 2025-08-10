package dc;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: NumberedSplitFileInputStream.java */
/* loaded from: classes5.dex */
public class v84 extends x84 {
    public RandomAccessFile a;

    public v84(File file) throws IOException {
        this.a = new w84(file, x94.READ.getValue());
    }

    @Override // dc.x84
    public void b(k94 k94Var) throws IOException {
        this.a.seek(k94Var.M());
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.a.read();
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

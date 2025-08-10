package dc;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: NumberedSplitRandomAccessFile.java */
/* loaded from: classes5.dex */
public class w84 extends RandomAccessFile {
    public long a;
    public File[] b;
    public RandomAccessFile c;
    public byte[] d;
    public int e;
    public String f;

    public w84(File file, String str) throws IOException {
        this(file, str, ea4.d(file));
    }

    public final void b(File[] fileArr) throws IOException {
        int i = 1;
        for (File file : fileArr) {
            String strE = ea4.e(file);
            try {
                if (i != Integer.parseInt(strE)) {
                    throw new IOException("Split file number " + i + " does not exist");
                }
                i++;
            } catch (NumberFormatException unused) {
                throw new IOException("Split file extension not in expected format. Found: " + strE + " expected of format: .001, .002, etc");
            }
        }
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.c;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        super.close();
    }

    public void e() throws IOException {
        f(this.b.length - 1);
    }

    public final void f(int i) throws IOException {
        if (this.e == i) {
            return;
        }
        if (i > this.b.length - 1) {
            throw new IOException("split counter greater than number of split files");
        }
        RandomAccessFile randomAccessFile = this.c;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.c = new RandomAccessFile(this.b[i], this.f);
        this.e = i;
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() throws IOException {
        return this.c.getFilePointer();
    }

    public void j(long j) throws IOException {
        this.c.seek(j);
    }

    @Override // java.io.RandomAccessFile
    public long length() throws IOException {
        return this.c.length();
    }

    @Override // java.io.RandomAccessFile
    public int read() throws IOException {
        if (read(this.d) == -1) {
            return -1;
        }
        return this.d[0] & 255;
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j) throws IOException {
        int i = (int) (j / this.a);
        if (i != this.e) {
            f(i);
        }
        this.c.seek(j - (i * this.a));
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    public w84(File file, String str, File[] fileArr) throws IOException {
        super(file, str);
        this.d = new byte[1];
        this.e = 0;
        super.close();
        if (x94.WRITE.getValue().equals(str)) {
            throw new IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
        }
        b(fileArr);
        this.c = new RandomAccessFile(file, str);
        this.b = fileArr;
        this.a = file.length();
        this.f = str;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
        throw null;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.c.read(bArr, i, i2);
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.e;
        if (i4 == this.b.length - 1) {
            return -1;
        }
        f(i4 + 1);
        return read(bArr, i, i2);
    }
}

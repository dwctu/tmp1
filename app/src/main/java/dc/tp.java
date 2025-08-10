package dc;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class tp extends FilterInputStream {
    public int a;

    public tp(@NonNull InputStream inputStream) {
        super(inputStream);
        this.a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    public final long b(long j) {
        int i = this.a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    public final void e(long j) {
        int i = this.a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.a = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (b(1L) == -1) {
            return -1;
        }
        int i = super.read();
        e(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jB = b(j);
        if (jB == -1) {
            return 0L;
        }
        long jSkip = super.skip(jB);
        e(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int iB = (int) b(i2);
        if (iB == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iB);
        e(i3);
        return i3;
    }
}

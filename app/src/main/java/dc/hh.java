package dc;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* loaded from: classes.dex */
public final class hh extends OutputStream {

    @NonNull
    public final OutputStream a;
    public byte[] b;
    public zi c;
    public int d;

    public hh(@NonNull OutputStream outputStream, @NonNull zi ziVar) {
        this(outputStream, ziVar, 65536);
    }

    public final void b() throws IOException {
        int i = this.d;
        if (i > 0) {
            this.a.write(this.b, 0, i);
            this.d = 0;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.a.close();
            release();
        } catch (Throwable th) {
            this.a.close();
            throw th;
        }
    }

    public final void e() throws IOException {
        if (this.d == this.b.length) {
            b();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        b();
        this.a.flush();
    }

    public final void release() {
        byte[] bArr = this.b;
        if (bArr != null) {
            this.c.put(bArr);
            this.b = null;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
        bArr[i2] = (byte) i;
        e();
    }

    @VisibleForTesting
    public hh(@NonNull OutputStream outputStream, zi ziVar, int i) {
        this.a = outputStream;
        this.c = ziVar;
        this.b = (byte[]) ziVar.c(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.d;
            if (i6 == 0 && i4 >= this.b.length) {
                this.a.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.b.length - i6);
            System.arraycopy(bArr, i5, this.b, this.d, iMin);
            this.d += iMin;
            i3 += iMin;
            e();
        } while (i3 < i2);
    }
}

package dc;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProgressOutputStream.java */
/* loaded from: classes4.dex */
public class fw3 extends OutputStream {
    public final OutputStream a;
    public final cw3 b;
    public long c;
    public long d;

    public fw3(OutputStream outputStream, cw3 cw3Var, long j) {
        this.a = outputStream;
        this.b = cw3Var;
        this.c = j;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.a;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this.a;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
        long j = this.c;
        if (j < 0) {
            this.b.a(-1L, -1L, -1.0f);
            return;
        }
        if (i2 < bArr.length) {
            this.d += i2;
        } else {
            this.d += bArr.length;
        }
        cw3 cw3Var = this.b;
        long j2 = this.d;
        cw3Var.a(j2, j, (j2 * 1.0f) / j);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.a.write(i);
        long j = this.c;
        if (j < 0) {
            this.b.a(-1L, -1L, -1.0f);
            return;
        }
        long j2 = 1 + this.d;
        this.d = j2;
        this.b.a(j2, j, (j2 * 1.0f) / j);
    }
}

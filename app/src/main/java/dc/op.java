package dc;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class op extends FilterInputStream {
    public final long a;
    public int b;

    public op(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    @NonNull
    public static InputStream e(@NonNull InputStream inputStream, long j) {
        return new op(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.a - this.b, ((FilterInputStream) this).in.available());
    }

    public final int b(int i) throws IOException {
        if (i >= 0) {
            this.b += i;
        } else if (this.a - this.b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i;
        i = super.read();
        b(i >= 0 ? 1 : -1);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        i3 = super.read(bArr, i, i2);
        b(i3);
        return i3;
    }
}

package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class LengthCheckInputStream extends SdkFilterInputStream {
    public final long a;
    public final boolean b;
    public long c;
    public long d;

    public LengthCheckInputStream(InputStream inputStream, long j, boolean z) {
        super(inputStream);
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        this.a = j;
        this.b = z;
    }

    public final void j(boolean z) {
        if (z) {
            if (this.c == this.a) {
                return;
            }
            throw new AmazonClientException("Data read (" + this.c + ") has a different length than the expected (" + this.a + ")");
        }
        if (this.c <= this.a) {
            return;
        }
        throw new AmazonClientException("More data read (" + this.c + ") than expected (" + this.a + ")");
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.d = this.c;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i >= 0) {
            this.c++;
        }
        j(i == -1);
        return i;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        if (super.markSupported()) {
            this.c = this.d;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(j);
        if (this.b && jSkip > 0) {
            this.c += jSkip;
            j(false);
        }
        return jSkip;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        this.c += i3 >= 0 ? i3 : 0L;
        j(i3 == -1);
        return i3;
    }
}

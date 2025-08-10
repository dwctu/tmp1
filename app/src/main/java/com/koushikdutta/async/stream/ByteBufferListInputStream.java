package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class ByteBufferListInputStream extends InputStream {
    public ByteBufferList bb;

    public ByteBufferListInputStream(ByteBufferList byteBufferList) {
        this.bb = byteBufferList;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bb.remaining() <= 0) {
            return -1;
        }
        return this.bb.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.bb.remaining() <= 0) {
            return -1;
        }
        int iMin = Math.min(i2, this.bb.remaining());
        this.bb.get(bArr, i, iMin);
        return iMin;
    }
}

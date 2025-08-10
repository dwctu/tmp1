package com.broadcom.bt.util.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public synchronized int getCount() {
        long byteCount;
        byteCount = getByteCount();
        if (byteCount > 2147483647L) {
            throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
        }
        return (int) byteCount;
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.count;
        this.count = 0L;
        return j;
    }

    public synchronized int resetCount() {
        long jResetByteCount;
        jResetByteCount = resetByteCount();
        if (jResetByteCount > 2147483647L) {
            throw new ArithmeticException("The byte count " + jResetByteCount + " is too large to be converted to an int");
        }
        return (int) jResetByteCount;
    }

    @Override // com.broadcom.bt.util.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.count += bArr.length;
        super.write(bArr);
    }

    @Override // com.broadcom.bt.util.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.count += i2;
        super.write(bArr, i, i2);
    }

    @Override // com.broadcom.bt.util.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.count++;
        super.write(i);
    }
}

package com.broadcom.bt.util.mime4j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class CloseShieldInputStream extends InputStream {
    private InputStream is;

    public CloseShieldInputStream(InputStream inputStream) {
        this.is = inputStream;
    }

    private void checkIfClosed() throws IOException {
        if (this.is == null) {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        checkIfClosed();
        return this.is.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.is = null;
    }

    public InputStream getUnderlyingStream() {
        return this.is;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        InputStream inputStream = this.is;
        if (inputStream != null) {
            inputStream.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.is;
        if (inputStream == null) {
            return false;
        }
        return inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        checkIfClosed();
        return this.is.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        checkIfClosed();
        this.is.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        checkIfClosed();
        return this.is.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        checkIfClosed();
        return this.is.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        checkIfClosed();
        return this.is.read(bArr, i, i2);
    }
}

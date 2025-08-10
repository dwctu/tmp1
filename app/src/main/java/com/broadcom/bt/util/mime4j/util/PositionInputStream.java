package com.broadcom.bt.util.mime4j.util;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class PositionInputStream extends InputStream {
    private final InputStream inputStream;
    public long position = 0;
    private long markedPosition = 0;

    public PositionInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inputStream.close();
    }

    public long getPosition() {
        return this.position;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.inputStream.mark(i);
        this.markedPosition = this.position;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.inputStream.read();
        if (i != -1) {
            this.position++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.inputStream.reset();
        this.position = this.markedPosition;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.inputStream.skip(j);
        this.position += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.inputStream.read(bArr);
        this.position += i;
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.inputStream.read(bArr, i, i2);
        this.position += i3;
        return i3;
    }
}

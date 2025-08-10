package com.broadcom.bt.util.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes.dex */
public abstract class ProxyReader extends FilterReader {
    public ProxyReader(Reader reader) {
        super(reader);
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterReader) this).in.close();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void mark(int i) throws IOException {
        ((FilterReader) this).in.mark(i);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean markSupported() {
        return ((FilterReader) this).in.markSupported();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        return ((FilterReader) this).in.read();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() throws IOException {
        return ((FilterReader) this).in.ready();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void reset() throws IOException {
        ((FilterReader) this).in.reset();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long j) throws IOException {
        return ((FilterReader) this).in.skip(j);
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return ((FilterReader) this).in.read(cArr);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        return ((FilterReader) this).in.read(cArr, i, i2);
    }
}

package org.jivesoftware.smack.util;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ObservableReader extends Reader {
    public List<ReaderListener> listeners = new ArrayList();
    public Reader wrappedReader;

    public ObservableReader(Reader reader) {
        this.wrappedReader = null;
        this.wrappedReader = reader;
    }

    public void addReaderListener(ReaderListener readerListener) {
        if (readerListener == null) {
            return;
        }
        synchronized (this.listeners) {
            if (!this.listeners.contains(readerListener)) {
                this.listeners.add(readerListener);
            }
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.wrappedReader.close();
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        this.wrappedReader.mark(i);
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return this.wrappedReader.markSupported();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int size;
        ReaderListener[] readerListenerArr;
        int i3 = this.wrappedReader.read(cArr, i, i2);
        if (i3 > 0) {
            String str = new String(cArr, i, i3);
            synchronized (this.listeners) {
                size = this.listeners.size();
                readerListenerArr = new ReaderListener[size];
                this.listeners.toArray(readerListenerArr);
            }
            for (int i4 = 0; i4 < size; i4++) {
                readerListenerArr[i4].read(str);
            }
        }
        return i3;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        return this.wrappedReader.ready();
    }

    public void removeReaderListener(ReaderListener readerListener) {
        synchronized (this.listeners) {
            this.listeners.remove(readerListener);
        }
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        this.wrappedReader.reset();
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        return this.wrappedReader.skip(j);
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        return this.wrappedReader.read();
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return this.wrappedReader.read(cArr);
    }
}

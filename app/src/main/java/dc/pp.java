package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class pp extends InputStream {
    public static final Queue<pp> c = wp.f(0);
    public InputStream a;
    public IOException b;

    @NonNull
    public static pp e(@NonNull InputStream inputStream) {
        pp ppVarPoll;
        Queue<pp> queue = c;
        synchronized (queue) {
            ppVarPoll = queue.poll();
        }
        if (ppVarPoll == null) {
            ppVarPoll = new pp();
        }
        ppVarPoll.f(inputStream);
        return ppVarPoll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.a.available();
    }

    @Nullable
    public IOException b() {
        return this.b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public void f(@NonNull InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.a.read(bArr);
        } catch (IOException e) {
            this.b = e;
            return -1;
        }
    }

    public void release() {
        this.b = null;
        this.a = null;
        Queue<pp> queue = c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.a.skip(j);
        } catch (IOException e) {
            this.b = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.a.read(bArr, i, i2);
        } catch (IOException e) {
            this.b = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.a.read();
        } catch (IOException e) {
            this.b = e;
            return -1;
        }
    }
}

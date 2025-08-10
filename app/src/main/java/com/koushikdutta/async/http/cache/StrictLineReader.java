package com.koushikdutta.async.http.cache;

import com.koushikdutta.async.util.Charsets;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    public StrictLineReader(InputStream inputStream) {
        this(inputStream, 8192);
    }

    private void fillBuf() throws IOException {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    public int readInt() throws IOException {
        String line = readLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException unused) {
            throw new IOException("expected an int but was \"" + line + "\"");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String readLine() throws java.io.IOException {
        /*
            r6 = this;
            java.io.InputStream r0 = r6.in
            monitor-enter(r0)
            byte[] r1 = r6.buf     // Catch: java.lang.Throwable -> L85
            if (r1 == 0) goto L7d
            int r1 = r6.pos     // Catch: java.lang.Throwable -> L85
            int r2 = r6.end     // Catch: java.lang.Throwable -> L85
            if (r1 < r2) goto L10
            r6.fillBuf()     // Catch: java.lang.Throwable -> L85
        L10:
            int r1 = r6.pos     // Catch: java.lang.Throwable -> L85
        L12:
            int r2 = r6.end     // Catch: java.lang.Throwable -> L85
            r3 = 10
            if (r1 == r2) goto L3f
            byte[] r2 = r6.buf     // Catch: java.lang.Throwable -> L85
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L85
            if (r4 != r3) goto L3c
            int r3 = r6.pos     // Catch: java.lang.Throwable -> L85
            if (r1 == r3) goto L2b
            int r3 = r1 + (-1)
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L85
            r4 = 13
            if (r2 != r4) goto L2b
            goto L2c
        L2b:
            r3 = r1
        L2c:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L85
            byte[] r4 = r6.buf     // Catch: java.lang.Throwable -> L85
            int r5 = r6.pos     // Catch: java.lang.Throwable -> L85
            int r3 = r3 - r5
            r2.<init>(r4, r5, r3)     // Catch: java.lang.Throwable -> L85
            int r1 = r1 + 1
            r6.pos = r1     // Catch: java.lang.Throwable -> L85
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L85
            return r2
        L3c:
            int r1 = r1 + 1
            goto L12
        L3f:
            com.koushikdutta.async.http.cache.StrictLineReader$1 r1 = new com.koushikdutta.async.http.cache.StrictLineReader$1     // Catch: java.lang.Throwable -> L85
            int r2 = r6.end     // Catch: java.lang.Throwable -> L85
            int r4 = r6.pos     // Catch: java.lang.Throwable -> L85
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L85
        L4b:
            byte[] r2 = r6.buf     // Catch: java.lang.Throwable -> L85
            int r4 = r6.pos     // Catch: java.lang.Throwable -> L85
            int r5 = r6.end     // Catch: java.lang.Throwable -> L85
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L85
            r2 = -1
            r6.end = r2     // Catch: java.lang.Throwable -> L85
            r6.fillBuf()     // Catch: java.lang.Throwable -> L85
            int r2 = r6.pos     // Catch: java.lang.Throwable -> L85
        L5d:
            int r4 = r6.end     // Catch: java.lang.Throwable -> L85
            if (r2 == r4) goto L4b
            byte[] r4 = r6.buf     // Catch: java.lang.Throwable -> L85
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L85
            if (r5 != r3) goto L7a
            int r3 = r6.pos     // Catch: java.lang.Throwable -> L85
            if (r2 == r3) goto L70
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L85
        L70:
            int r2 = r2 + 1
            r6.pos = r2     // Catch: java.lang.Throwable -> L85
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L85
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L85
            return r1
        L7a:
            int r2 = r2 + 1
            goto L5d
        L7d:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L85
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L85
            throw r1     // Catch: java.lang.Throwable -> L85
        L85:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L85
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.cache.StrictLineReader.readLine():java.lang.String");
    }

    public StrictLineReader(InputStream inputStream, int i) {
        this(inputStream, i, Charsets.US_ASCII);
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        java.util.Objects.requireNonNull(inputStream, "in == null");
        java.util.Objects.requireNonNull(charset, "charset == null");
        if (i >= 0) {
            if (!charset.equals(Charsets.US_ASCII) && !charset.equals(Charsets.UTF_8)) {
                throw new IllegalArgumentException("Unsupported encoding");
            }
            this.in = inputStream;
            this.buf = new byte[i];
            return;
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}

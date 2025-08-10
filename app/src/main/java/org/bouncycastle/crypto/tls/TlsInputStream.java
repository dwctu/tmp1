package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class TlsInputStream extends InputStream {
    private byte[] buf = new byte[1];
    private TlsProtocol handler;

    public TlsInputStream(TlsProtocol tlsProtocol) {
        this.handler = null;
        this.handler = tlsProtocol;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.handler.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.buf) < 0) {
            return -1;
        }
        return this.buf[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.handler.readApplicationData(bArr, i, i2);
    }
}

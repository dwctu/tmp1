package com.broadcom.bt.util.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class TeeInputStream extends ProxyInputStream {
    private final OutputStream branch;
    private final boolean closeBranch;

    public TeeInputStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, false);
    }

    @Override // com.broadcom.bt.util.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (this.closeBranch) {
                this.branch.close();
            }
        }
    }

    @Override // com.broadcom.bt.util.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i != -1) {
            this.branch.write(i);
        }
        return i;
    }

    public TeeInputStream(InputStream inputStream, OutputStream outputStream, boolean z) {
        super(inputStream);
        this.branch = outputStream;
        this.closeBranch = z;
    }

    @Override // com.broadcom.bt.util.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 != -1) {
            this.branch.write(bArr, i, i3);
        }
        return i3;
    }

    @Override // com.broadcom.bt.util.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = super.read(bArr);
        if (i != -1) {
            this.branch.write(bArr, 0, i);
        }
        return i;
    }
}

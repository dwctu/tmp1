package com.broadcom.bt.util.mime4j.util;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class PartialInputStream extends PositionInputStream {
    private final long limit;

    public PartialInputStream(InputStream inputStream, long j, long j2) throws IOException {
        super(inputStream);
        inputStream.skip(j);
        this.limit = j + j2;
    }

    private int getBytesLeft() {
        return (int) Math.min(2147483647L, this.limit - this.position);
    }

    @Override // com.broadcom.bt.util.mime4j.util.PositionInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(super.available(), getBytesLeft());
    }

    @Override // com.broadcom.bt.util.mime4j.util.PositionInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.limit > this.position) {
            return super.read();
        }
        return -1;
    }

    @Override // com.broadcom.bt.util.mime4j.util.PositionInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        return super.skip(Math.min(j, getBytesLeft()));
    }

    @Override // com.broadcom.bt.util.mime4j.util.PositionInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.broadcom.bt.util.mime4j.util.PositionInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return super.read(bArr, i, Math.min(i2, getBytesLeft()));
    }
}

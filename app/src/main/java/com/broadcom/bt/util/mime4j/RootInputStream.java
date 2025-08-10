package com.broadcom.bt.util.mime4j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RootInputStream extends InputStream {
    private InputStream is;
    private int lineNumber = 1;
    private int prev = -1;
    private boolean truncated = false;

    public RootInputStream(InputStream inputStream) {
        this.is = null;
        this.is = inputStream;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.truncated) {
            return -1;
        }
        int i = this.is.read();
        if (this.prev == 13 && i == 10) {
            this.lineNumber++;
        }
        this.prev = i;
        return i;
    }

    public void truncate() {
        this.truncated = true;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.truncated) {
            return -1;
        }
        int i3 = this.is.read(bArr, i, i2);
        for (int i4 = i; i4 < i + i3; i4++) {
            if (this.prev == 13 && bArr[i4] == 10) {
                this.lineNumber++;
            }
            this.prev = bArr[i4];
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}

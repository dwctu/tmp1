package com.broadcom.bt.util.mime4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes.dex */
public class MimeBoundaryInputStream extends InputStream {
    private byte[] boundary;
    private PushbackInputStream s;
    private boolean first = true;
    private boolean eof = false;
    private boolean parenteof = false;
    private boolean moreParts = true;

    public MimeBoundaryInputStream(InputStream inputStream, String str) throws IOException {
        this.s = null;
        this.boundary = null;
        int i = 0;
        this.s = new PushbackInputStream(inputStream, str.length() + 4);
        String str2 = "--" + str;
        this.boundary = new byte[str2.length()];
        while (true) {
            byte[] bArr = this.boundary;
            if (i >= bArr.length) {
                break;
            }
            bArr[i] = (byte) str2.charAt(i);
            i++;
        }
        int i2 = read();
        if (i2 != -1) {
            this.s.unread(i2);
        }
    }

    private boolean matchBoundary() throws IOException {
        for (int i = 0; i < this.boundary.length; i++) {
            int i2 = this.s.read();
            if (i2 != this.boundary[i]) {
                if (i2 != -1) {
                    this.s.unread(i2);
                }
                for (int i3 = i - 1; i3 >= 0; i3--) {
                    this.s.unread(this.boundary[i3]);
                }
                return false;
            }
        }
        int i4 = this.s.read();
        int i5 = this.s.read();
        this.moreParts = (i4 == 45 && i5 == 45) ? false : true;
        while (true) {
            int i6 = i5;
            int i7 = i4;
            i4 = i6;
            if (i4 == 10 && i7 == 13) {
                break;
            }
            i5 = this.s.read();
            if (i5 == -1) {
                i4 = i5;
                break;
            }
        }
        if (i4 == -1) {
            this.moreParts = false;
            this.parenteof = true;
        }
        this.eof = true;
        return true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.s.close();
    }

    public void consume() throws IOException {
        while (read() != -1) {
        }
    }

    public boolean hasMoreParts() {
        return this.moreParts;
    }

    public boolean parentEOF() {
        return this.parenteof;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.eof) {
            return -1;
        }
        if (this.first) {
            this.first = false;
            if (matchBoundary()) {
                return -1;
            }
        }
        int i = this.s.read();
        int i2 = this.s.read();
        if (i == 13 && i2 == 10 && matchBoundary()) {
            return -1;
        }
        if (i2 != -1) {
            this.s.unread(i2);
        }
        boolean z = i == -1;
        this.parenteof = z;
        this.eof = z;
        return i;
    }
}

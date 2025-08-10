package com.broadcom.bt.util.mime4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes.dex */
public class EOLConvertingInputStream extends InputStream {
    public static final int CONVERT_BOTH = 3;
    public static final int CONVERT_CR = 1;
    public static final int CONVERT_LF = 2;
    private int flags;
    private PushbackInputStream in;
    private int previous;

    public EOLConvertingInputStream(InputStream inputStream) {
        this(inputStream, 3);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.in.read();
        if (i == -1) {
            return -1;
        }
        int i2 = this.flags;
        if ((i2 & 1) != 0 && i == 13) {
            int i3 = this.in.read();
            if (i3 != -1) {
                this.in.unread(i3);
            }
            if (i3 != 10) {
                this.in.unread(10);
            }
        } else if ((i2 & 2) != 0 && i == 10 && this.previous != 13) {
            this.in.unread(10);
            i = 13;
        }
        this.previous = i;
        return i;
    }

    public EOLConvertingInputStream(InputStream inputStream, int i) {
        this.in = null;
        this.previous = 0;
        this.flags = 3;
        this.in = new PushbackInputStream(inputStream, 2);
        this.flags = i;
    }
}

package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RepeatableFileInputStream extends SdkInputStream {
    public static final Log e = LogFactory.c("RepeatableFIS");
    public final File a;
    public FileInputStream b;
    public long c = 0;
    public long d = 0;

    public RepeatableFileInputStream(File file) throws FileNotFoundException {
        this.b = null;
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        this.b = new FileInputStream(file);
        this.a = file;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        f();
        return this.b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
        f();
    }

    @Override // com.amazonaws.internal.SdkInputStream
    public InputStream j() {
        return this.b;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        f();
        this.d += this.c;
        this.c = 0L;
        Log log = e;
        if (log.isDebugEnabled()) {
            log.a("Input stream marked at " + this.d + " bytes");
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        f();
        int i = this.b.read();
        if (i == -1) {
            return -1;
        }
        this.c++;
        return i;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.b.close();
        f();
        this.b = new FileInputStream(this.a);
        long jSkip = this.d;
        while (jSkip > 0) {
            jSkip -= this.b.skip(jSkip);
        }
        Log log = e;
        if (log.isDebugEnabled()) {
            log.a("Reset to mark point " + this.d + " after returning " + this.c + " bytes");
        }
        this.c = 0L;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        f();
        long jSkip = this.b.skip(j);
        this.c += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        f();
        int i3 = this.b.read(bArr, i, i2);
        this.c += i3;
        return i3;
    }
}

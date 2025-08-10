package com.amazonaws.event;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ProgressReportingInputStream extends SdkFilterInputStream {
    public int a;
    public final ProgressListenerCallbackExecutor b;
    public int c;
    public boolean d;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListenerCallbackExecutor progressListenerCallbackExecutor) {
        super(inputStream);
        this.a = 8192;
        this.b = progressListenerCallbackExecutor;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i = this.c;
        if (i > 0) {
            this.b.c(new ProgressEvent(i));
            this.c = 0;
        }
        super.close();
    }

    public final void j(int i) {
        int i2 = this.c + i;
        this.c = i2;
        if (i2 >= this.a) {
            this.b.c(new ProgressEvent(i2));
            this.c = 0;
        }
    }

    public final void m() {
        if (this.d) {
            ProgressEvent progressEvent = new ProgressEvent(this.c);
            progressEvent.c(4);
            this.c = 0;
            this.b.c(progressEvent);
        }
    }

    public void p(boolean z) {
        this.d = z;
    }

    public void q(int i) {
        this.a = i * 1024;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i == -1) {
            m();
        } else {
            j(1);
        }
        return i;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent(this.c);
        progressEvent.c(32);
        this.b.c(progressEvent);
        this.c = 0;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 == -1) {
            m();
        }
        if (i3 != -1) {
            j(i3);
        }
        return i3;
    }
}

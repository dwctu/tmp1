package com.broadcom.bt.util.io.output;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class CloseShieldOutputStream extends ProxyOutputStream {
    public CloseShieldOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // com.broadcom.bt.util.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out = new ClosedOutputStream();
    }
}

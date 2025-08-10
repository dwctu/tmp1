package org.jivesoftware.smack.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class XMPPInputOutputStream {
    public static FlushMethod flushMethod;
    public final String compressionMethod;

    public enum FlushMethod {
        FULL_FLUSH,
        SYNC_FLUSH
    }

    public XMPPInputOutputStream(String str) {
        this.compressionMethod = str;
    }

    public static void setFlushMethod(FlushMethod flushMethod2) {
        flushMethod = flushMethod2;
    }

    public String getCompressionMethod() {
        return this.compressionMethod;
    }

    public abstract InputStream getInputStream(InputStream inputStream) throws IOException;

    public abstract OutputStream getOutputStream(OutputStream outputStream) throws IOException;

    public abstract boolean isSupported();
}

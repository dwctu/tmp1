package org.jivesoftware.smackx.bytestreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public interface BytestreamSession {
    void close() throws IOException;

    InputStream getInputStream() throws IOException;

    OutputStream getOutputStream() throws IOException;

    int getReadTimeout() throws IOException;

    void setReadTimeout(int i) throws IOException;
}

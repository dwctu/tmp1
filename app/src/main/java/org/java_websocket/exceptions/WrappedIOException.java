package org.java_websocket.exceptions;

import java.io.IOException;
import org.java_websocket.WebSocket;

/* loaded from: classes5.dex */
public class WrappedIOException extends Exception {
    private final transient WebSocket connection;
    private final IOException ioException;

    public WrappedIOException(WebSocket webSocket, IOException iOException) {
        this.connection = webSocket;
        this.ioException = iOException;
    }

    public WebSocket getConnection() {
        return this.connection;
    }

    public IOException getIOException() {
        return this.ioException;
    }
}

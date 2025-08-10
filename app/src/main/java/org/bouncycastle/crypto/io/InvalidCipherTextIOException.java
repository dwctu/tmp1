package org.bouncycastle.crypto.io;

import java.io.IOException;

/* loaded from: classes5.dex */
public class InvalidCipherTextIOException extends IOException {
    private static final long serialVersionUID = 1;
    private final Throwable cause;

    public InvalidCipherTextIOException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}

package org.bouncycastle.crypto.tls;

/* loaded from: classes5.dex */
public class TlsRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1928023487348344086L;
    public Throwable e;

    public TlsRuntimeException(String str) {
        super(str);
    }

    public TlsRuntimeException(String str, Throwable th) {
        super(str);
        this.e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.e;
    }
}

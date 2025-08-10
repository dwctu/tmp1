package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;

/* loaded from: classes5.dex */
public interface TlsContext {
    byte[] exportKeyingMaterial(String str, byte[] bArr, int i);

    ProtocolVersion getClientVersion();

    TlsSession getResumableSession();

    SecureRandom getSecureRandom();

    SecurityParameters getSecurityParameters();

    ProtocolVersion getServerVersion();

    Object getUserObject();

    boolean isServer();

    void setUserObject(Object obj);
}

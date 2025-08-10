package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;

/* loaded from: classes5.dex */
public class TlsClientContextImpl extends AbstractTlsContext implements TlsClientContext {
    public TlsClientContextImpl(SecureRandom secureRandom, SecurityParameters securityParameters) {
        super(secureRandom, securityParameters);
    }

    @Override // org.bouncycastle.crypto.tls.TlsContext
    public boolean isServer() {
        return false;
    }
}

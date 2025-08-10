package org.bouncycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class AbstractTlsPeer implements TlsPeer {
    @Override // org.bouncycastle.crypto.tls.TlsPeer
    public void notifyAlertRaised(short s, short s2, String str, Exception exc) {
    }

    @Override // org.bouncycastle.crypto.tls.TlsPeer
    public void notifyAlertReceived(short s, short s2) {
    }

    @Override // org.bouncycastle.crypto.tls.TlsPeer
    public void notifyHandshakeComplete() throws IOException {
    }

    @Override // org.bouncycastle.crypto.tls.TlsPeer
    public void notifySecureRenegotiation(boolean z) throws IOException {
        if (!z) {
            throw new TlsFatalAlert((short) 40);
        }
    }
}

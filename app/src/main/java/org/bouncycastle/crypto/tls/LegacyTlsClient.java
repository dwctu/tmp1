package org.bouncycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes5.dex */
public class LegacyTlsClient extends DefaultTlsClient {
    public CertificateVerifyer verifyer;

    public LegacyTlsClient(CertificateVerifyer certificateVerifyer) {
        this.verifyer = certificateVerifyer;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public TlsAuthentication getAuthentication() throws IOException {
        return new LegacyTlsAuthentication(this.verifyer);
    }
}

package org.bouncycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes5.dex */
public class LegacyTlsAuthentication extends ServerOnlyTlsAuthentication {
    public CertificateVerifyer verifyer;

    public LegacyTlsAuthentication(CertificateVerifyer certificateVerifyer) {
        this.verifyer = certificateVerifyer;
    }

    @Override // org.bouncycastle.crypto.tls.TlsAuthentication
    public void notifyServerCertificate(Certificate certificate) throws IOException {
        if (!this.verifyer.isValid(certificate.getCertificateList())) {
            throw new TlsFatalAlert((short) 90);
        }
    }
}

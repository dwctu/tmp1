package org.bouncycastle.crypto.tls;

/* loaded from: classes5.dex */
public class AlwaysValidVerifyer implements CertificateVerifyer {
    @Override // org.bouncycastle.crypto.tls.CertificateVerifyer
    public boolean isValid(org.bouncycastle.asn1.x509.Certificate[] certificateArr) {
        return true;
    }
}

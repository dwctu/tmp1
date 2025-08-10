package com.google.android.play.core.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzg extends zzh {
    private final byte[] zza;

    public zzg(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.zza = bArr;
    }

    @Override // com.google.android.play.core.internal.zzh, java.security.cert.Certificate
    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.zza;
    }
}

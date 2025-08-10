package org.bouncycastle.crypto.params;

/* loaded from: classes5.dex */
public class ECKeyParameters extends AsymmetricKeyParameter {
    public ECDomainParameters params;

    public ECKeyParameters(boolean z, ECDomainParameters eCDomainParameters) {
        super(z);
        this.params = eCDomainParameters;
    }

    public ECDomainParameters getParameters() {
        return this.params;
    }
}

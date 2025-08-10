package org.bouncycastle.jcajce.provider.config;

import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;

/* loaded from: classes5.dex */
public interface ProviderConfiguration {
    DHParameterSpec getDHDefaultParameters(int i);

    ECParameterSpec getEcImplicitlyCa();
}

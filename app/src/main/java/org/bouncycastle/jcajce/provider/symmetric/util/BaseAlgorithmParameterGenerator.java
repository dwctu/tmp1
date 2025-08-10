package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.SecureRandom;

/* loaded from: classes5.dex */
public abstract class BaseAlgorithmParameterGenerator extends AlgorithmParameterGeneratorSpi {
    public SecureRandom random;
    public int strength = 1024;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }
}

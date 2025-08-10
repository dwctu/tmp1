package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.pqc.crypto.rainbow.RainbowKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowKeyPairGenerator;
import org.bouncycastle.pqc.crypto.rainbow.RainbowParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.RainbowParameterSpec;

/* loaded from: classes5.dex */
public class RainbowKeyPairGeneratorSpi extends KeyPairGenerator {
    public RainbowKeyPairGenerator engine;
    public boolean initialised;
    public RainbowKeyGenerationParameters param;
    public SecureRandom random;
    public int strength;

    public RainbowKeyPairGeneratorSpi() {
        super("Rainbow");
        this.engine = new RainbowKeyPairGenerator();
        this.strength = 1024;
        this.random = new SecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            RainbowKeyGenerationParameters rainbowKeyGenerationParameters = new RainbowKeyGenerationParameters(this.random, new RainbowParameters(new RainbowParameterSpec().getVi()));
            this.param = rainbowKeyGenerationParameters;
            this.engine.init(rainbowKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCRainbowPublicKey((RainbowPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCRainbowPrivateKey((RainbowPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof RainbowParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a RainbowParameterSpec");
        }
        RainbowKeyGenerationParameters rainbowKeyGenerationParameters = new RainbowKeyGenerationParameters(secureRandom, new RainbowParameters(((RainbowParameterSpec) algorithmParameterSpec).getVi()));
        this.param = rainbowKeyGenerationParameters;
        this.engine.init(rainbowKeyGenerationParameters);
        this.initialised = true;
    }
}

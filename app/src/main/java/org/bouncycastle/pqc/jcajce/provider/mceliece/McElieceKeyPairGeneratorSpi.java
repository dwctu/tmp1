package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.ECCKeyGenParameterSpec;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;

/* loaded from: classes5.dex */
public abstract class McElieceKeyPairGeneratorSpi extends KeyPairGenerator {

    public static class McEliece extends McElieceKeyPairGeneratorSpi {
        public McElieceKeyPairGenerator kpg;

        public McEliece() {
            super("McEliece");
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.kpg.generateKeyPair();
            return new KeyPair(new BCMcEliecePublicKey((McEliecePublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCMcEliecePrivateKey((McEliecePrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i, SecureRandom secureRandom) {
            try {
                initialize(new ECCKeyGenParameterSpec());
            } catch (InvalidAlgorithmParameterException unused) {
            }
        }

        @Override // java.security.KeyPairGenerator
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
            this.kpg = new McElieceKeyPairGenerator();
            super.initialize(algorithmParameterSpec);
            ECCKeyGenParameterSpec eCCKeyGenParameterSpec = (ECCKeyGenParameterSpec) algorithmParameterSpec;
            this.kpg.init(new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters(eCCKeyGenParameterSpec.getM(), eCCKeyGenParameterSpec.getT())));
        }
    }

    public static class McElieceCCA2 extends McElieceKeyPairGeneratorSpi {
        public McElieceCCA2KeyPairGenerator kpg;

        public McElieceCCA2() {
            super("McElieceCCA-2");
        }

        public McElieceCCA2(String str) {
            super(str);
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.kpg.generateKeyPair();
            return new KeyPair(new BCMcElieceCCA2PublicKey((McElieceCCA2PublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCMcElieceCCA2PrivateKey((McElieceCCA2PrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i, SecureRandom secureRandom) {
            try {
                initialize(new McElieceCCA2ParameterSpec());
            } catch (InvalidAlgorithmParameterException unused) {
            }
        }

        @Override // java.security.KeyPairGenerator
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
            this.kpg = new McElieceCCA2KeyPairGenerator();
            super.initialize(algorithmParameterSpec);
            ECCKeyGenParameterSpec eCCKeyGenParameterSpec = (ECCKeyGenParameterSpec) algorithmParameterSpec;
            this.kpg.init(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters(eCCKeyGenParameterSpec.getM(), eCCKeyGenParameterSpec.getT())));
        }
    }

    public McElieceKeyPairGeneratorSpi(String str) {
        super(str);
    }
}

package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* loaded from: classes5.dex */
public class AlgorithmParameterGeneratorSpi extends java.security.AlgorithmParameterGeneratorSpi {
    public SecureRandom random;
    public int strength = 1024;
    private int l = 0;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException, NoSuchProviderException {
        DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
        SecureRandom secureRandom = this.random;
        if (secureRandom != null) {
            dHParametersGenerator.init(this.strength, 20, secureRandom);
        } else {
            dHParametersGenerator.init(this.strength, 20, new SecureRandom());
        }
        DHParameters dHParametersGenerateParameters = dHParametersGenerator.generateParameters();
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("DH", BouncyCastleProvider.PROVIDER_NAME);
            algorithmParameters.init(new DHParameterSpec(dHParametersGenerateParameters.getP(), dHParametersGenerateParameters.getG(), this.l));
            return algorithmParameters;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        }
        DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
        this.strength = dHGenParameterSpec.getPrimeSize();
        this.l = dHGenParameterSpec.getExponentSize();
        this.random = secureRandom;
    }
}

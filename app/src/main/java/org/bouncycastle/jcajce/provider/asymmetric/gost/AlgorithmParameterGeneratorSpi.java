package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.crypto.generators.GOST3410ParametersGenerator;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

/* loaded from: classes5.dex */
public abstract class AlgorithmParameterGeneratorSpi extends java.security.AlgorithmParameterGeneratorSpi {
    public SecureRandom random;
    public int strength = 1024;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException, NoSuchProviderException {
        GOST3410ParametersGenerator gOST3410ParametersGenerator = new GOST3410ParametersGenerator();
        SecureRandom secureRandom = this.random;
        if (secureRandom != null) {
            gOST3410ParametersGenerator.init(this.strength, 2, secureRandom);
        } else {
            gOST3410ParametersGenerator.init(this.strength, 2, new SecureRandom());
        }
        GOST3410Parameters gOST3410ParametersGenerateParameters = gOST3410ParametersGenerator.generateParameters();
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("GOST3410", BouncyCastleProvider.PROVIDER_NAME);
            algorithmParameters.init(new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410ParametersGenerateParameters.getP(), gOST3410ParametersGenerateParameters.getQ(), gOST3410ParametersGenerateParameters.getA())));
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
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST3410 parameter generation.");
    }
}

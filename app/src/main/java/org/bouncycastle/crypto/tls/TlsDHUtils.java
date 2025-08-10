package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes5.dex */
public class TlsDHUtils {
    public static final BigInteger ONE = BigInteger.valueOf(1);
    public static final BigInteger TWO = BigInteger.valueOf(2);

    public static boolean areCompatibleParameters(DHParameters dHParameters, DHParameters dHParameters2) {
        return dHParameters.getP().equals(dHParameters2.getP()) && dHParameters.getG().equals(dHParameters2.getG());
    }

    public static byte[] calculateDHBasicAgreement(DHPublicKeyParameters dHPublicKeyParameters, DHPrivateKeyParameters dHPrivateKeyParameters) {
        DHBasicAgreement dHBasicAgreement = new DHBasicAgreement();
        dHBasicAgreement.init(dHPrivateKeyParameters);
        return BigIntegers.asUnsignedByteArray(dHBasicAgreement.calculateAgreement(dHPublicKeyParameters));
    }

    public static AsymmetricCipherKeyPair generateDHKeyPair(SecureRandom secureRandom, DHParameters dHParameters) {
        DHBasicKeyPairGenerator dHBasicKeyPairGenerator = new DHBasicKeyPairGenerator();
        dHBasicKeyPairGenerator.init(new DHKeyGenerationParameters(secureRandom, dHParameters));
        return dHBasicKeyPairGenerator.generateKeyPair();
    }

    public static DHPrivateKeyParameters generateEphemeralClientKeyExchange(SecureRandom secureRandom, DHParameters dHParameters, OutputStream outputStream) throws IOException {
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateDHKeyPair = generateDHKeyPair(secureRandom, dHParameters);
        writeDHParameter(((DHPublicKeyParameters) asymmetricCipherKeyPairGenerateDHKeyPair.getPublic()).getY(), outputStream);
        return (DHPrivateKeyParameters) asymmetricCipherKeyPairGenerateDHKeyPair.getPrivate();
    }

    public static DHPrivateKeyParameters generateEphemeralServerKeyExchange(SecureRandom secureRandom, DHParameters dHParameters, OutputStream outputStream) throws IOException {
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateDHKeyPair = generateDHKeyPair(secureRandom, dHParameters);
        new ServerDHParams((DHPublicKeyParameters) asymmetricCipherKeyPairGenerateDHKeyPair.getPublic()).encode(outputStream);
        return (DHPrivateKeyParameters) asymmetricCipherKeyPairGenerateDHKeyPair.getPrivate();
    }

    public static BigInteger readDHParameter(InputStream inputStream) throws IOException {
        return new BigInteger(1, TlsUtils.readOpaque16(inputStream));
    }

    public static DHPublicKeyParameters validateDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) throws IOException {
        BigInteger y = dHPublicKeyParameters.getY();
        DHParameters parameters = dHPublicKeyParameters.getParameters();
        BigInteger p = parameters.getP();
        BigInteger g = parameters.getG();
        if (!p.isProbablePrime(2)) {
            throw new TlsFatalAlert((short) 47);
        }
        BigInteger bigInteger = TWO;
        if (g.compareTo(bigInteger) < 0 || g.compareTo(p.subtract(bigInteger)) > 0) {
            throw new TlsFatalAlert((short) 47);
        }
        if (y.compareTo(bigInteger) < 0 || y.compareTo(p.subtract(ONE)) > 0) {
            throw new TlsFatalAlert((short) 47);
        }
        return dHPublicKeyParameters;
    }

    public static void writeDHParameter(BigInteger bigInteger, OutputStream outputStream) throws IOException {
        TlsUtils.writeOpaque16(BigIntegers.asUnsignedByteArray(bigInteger), outputStream);
    }
}

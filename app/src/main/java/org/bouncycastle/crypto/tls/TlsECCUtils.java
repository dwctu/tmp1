package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

/* loaded from: classes5.dex */
public class TlsECCUtils {
    public static final Integer EXT_elliptic_curves = Integers.valueOf(10);
    public static final Integer EXT_ec_point_formats = Integers.valueOf(11);
    private static final String[] curveNames = {"sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1"};

    public static void addSupportedEllipticCurvesExtension(Hashtable hashtable, int[] iArr) throws IOException {
        hashtable.put(EXT_elliptic_curves, createSupportedEllipticCurvesExtension(iArr));
    }

    public static void addSupportedPointFormatsExtension(Hashtable hashtable, short[] sArr) throws IOException {
        hashtable.put(EXT_ec_point_formats, createSupportedPointFormatsExtension(sArr));
    }

    public static boolean areOnSameCurve(ECDomainParameters eCDomainParameters, ECDomainParameters eCDomainParameters2) {
        return eCDomainParameters.getCurve().equals(eCDomainParameters2.getCurve()) && eCDomainParameters.getG().equals(eCDomainParameters2.getG()) && eCDomainParameters.getN().equals(eCDomainParameters2.getN()) && eCDomainParameters.getH().equals(eCDomainParameters2.getH());
    }

    public static byte[] calculateECDHBasicAgreement(ECPublicKeyParameters eCPublicKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters) {
        ECDHBasicAgreement eCDHBasicAgreement = new ECDHBasicAgreement();
        eCDHBasicAgreement.init(eCPrivateKeyParameters);
        return BigIntegers.asUnsignedByteArray(eCDHBasicAgreement.getFieldSize(), eCDHBasicAgreement.calculateAgreement(eCPublicKeyParameters));
    }

    private static void checkNamedCurve(int[] iArr, int i) throws IOException {
        if (iArr != null && !Arrays.contains(iArr, i)) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    public static boolean containsECCCipherSuites(int[] iArr) {
        for (int i : iArr) {
            if (isECCCipherSuite(i)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] createSupportedEllipticCurvesExtension(int[] iArr) throws IOException {
        if (iArr == null || iArr.length < 1) {
            throw new TlsFatalAlert((short) 80);
        }
        return TlsUtils.encodeUint16ArrayWithUint16Length(iArr);
    }

    public static byte[] createSupportedPointFormatsExtension(short[] sArr) throws IOException {
        if (sArr == null) {
            sArr = new short[]{0};
        } else if (!Arrays.contains(sArr, (short) 0)) {
            short[] sArr2 = new short[sArr.length + 1];
            System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
            sArr2[sArr.length] = 0;
            sArr = sArr2;
        }
        return TlsUtils.encodeUint8ArrayWithUint8Length(sArr);
    }

    public static BigInteger deserializeECFieldElement(int i, byte[] bArr) throws IOException {
        if (bArr.length == (i + 7) / 8) {
            return new BigInteger(1, bArr);
        }
        throw new TlsFatalAlert((short) 50);
    }

    public static ECPoint deserializeECPoint(short[] sArr, ECCurve eCCurve, byte[] bArr) throws IOException {
        return eCCurve.decodePoint(bArr);
    }

    public static ECPublicKeyParameters deserializeECPublicKey(short[] sArr, ECDomainParameters eCDomainParameters, byte[] bArr) throws IOException {
        try {
            return new ECPublicKeyParameters(deserializeECPoint(sArr, eCDomainParameters.getCurve(), bArr), eCDomainParameters);
        } catch (RuntimeException unused) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    public static AsymmetricCipherKeyPair generateECKeyPair(SecureRandom secureRandom, ECDomainParameters eCDomainParameters) {
        ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
        eCKeyPairGenerator.init(new ECKeyGenerationParameters(eCDomainParameters, secureRandom));
        return eCKeyPairGenerator.generateKeyPair();
    }

    public static ECPrivateKeyParameters generateEphemeralClientKeyExchange(SecureRandom secureRandom, short[] sArr, ECDomainParameters eCDomainParameters, OutputStream outputStream) throws IOException {
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateECKeyPair = generateECKeyPair(secureRandom, eCDomainParameters);
        writeECPoint(sArr, ((ECPublicKeyParameters) asymmetricCipherKeyPairGenerateECKeyPair.getPublic()).getQ(), outputStream);
        return (ECPrivateKeyParameters) asymmetricCipherKeyPairGenerateECKeyPair.getPrivate();
    }

    public static String getNameOfNamedCurve(int i) {
        if (isSupportedNamedCurve(i)) {
            return curveNames[i - 1];
        }
        return null;
    }

    public static ECDomainParameters getParametersForNamedCurve(int i) {
        X9ECParameters byName;
        String nameOfNamedCurve = getNameOfNamedCurve(i);
        if (nameOfNamedCurve == null || (byName = ECNamedCurveTable.getByName(nameOfNamedCurve)) == null) {
            return null;
        }
        return new ECDomainParameters(byName.getCurve(), byName.getG(), byName.getN(), byName.getH(), byName.getSeed());
    }

    public static int[] getSupportedEllipticCurvesExtension(Hashtable hashtable) throws IOException {
        byte[] extensionData = TlsUtils.getExtensionData(hashtable, EXT_elliptic_curves);
        if (extensionData == null) {
            return null;
        }
        return readSupportedEllipticCurvesExtension(extensionData);
    }

    public static short[] getSupportedPointFormatsExtension(Hashtable hashtable) throws IOException {
        byte[] extensionData = TlsUtils.getExtensionData(hashtable, EXT_ec_point_formats);
        if (extensionData == null) {
            return null;
        }
        return readSupportedPointFormatsExtension(extensionData);
    }

    public static boolean hasAnySupportedNamedCurves() {
        return curveNames.length > 0;
    }

    public static boolean isCompressionPreferred(short[] sArr, short s) {
        short s2;
        if (sArr == null) {
            return false;
        }
        for (int i = 0; i < sArr.length && (s2 = sArr[i]) != 0; i++) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static boolean isECCCipherSuite(int i) {
        switch (i) {
            case CipherSuite.TLS_ECDH_ECDSA_WITH_NULL_SHA /* 49153 */:
            case CipherSuite.TLS_ECDH_ECDSA_WITH_RC4_128_SHA /* 49154 */:
            case CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA /* 49155 */:
            case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA /* 49156 */:
            case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA /* 49157 */:
            case CipherSuite.TLS_ECDHE_ECDSA_WITH_NULL_SHA /* 49158 */:
            case CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA /* 49159 */:
            case CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA /* 49160 */:
            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA /* 49161 */:
            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA /* 49162 */:
            case CipherSuite.TLS_ECDH_RSA_WITH_NULL_SHA /* 49163 */:
            case CipherSuite.TLS_ECDH_RSA_WITH_RC4_128_SHA /* 49164 */:
            case CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA /* 49165 */:
            case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA /* 49166 */:
            case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA /* 49167 */:
            case CipherSuite.TLS_ECDHE_RSA_WITH_NULL_SHA /* 49168 */:
            case CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA /* 49169 */:
            case CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA /* 49170 */:
            case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA /* 49171 */:
            case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA /* 49172 */:
            case CipherSuite.TLS_ECDH_anon_WITH_NULL_SHA /* 49173 */:
            case CipherSuite.TLS_ECDH_anon_WITH_RC4_128_SHA /* 49174 */:
            case CipherSuite.TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA /* 49175 */:
            case CipherSuite.TLS_ECDH_anon_WITH_AES_128_CBC_SHA /* 49176 */:
            case CipherSuite.TLS_ECDH_anon_WITH_AES_256_CBC_SHA /* 49177 */:
                return true;
            default:
                switch (i) {
                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 /* 49187 */:
                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 /* 49188 */:
                    case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 /* 49189 */:
                    case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 /* 49190 */:
                    case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 /* 49191 */:
                    case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 /* 49192 */:
                    case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 /* 49193 */:
                    case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 /* 49194 */:
                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 /* 49195 */:
                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 /* 49196 */:
                    case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 /* 49197 */:
                    case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 /* 49198 */:
                    case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 /* 49199 */:
                    case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 /* 49200 */:
                    case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 /* 49201 */:
                    case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 /* 49202 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_RC4_128_SHA /* 49203 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_3DES_EDE_CBC_SHA /* 49204 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA /* 49205 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA /* 49206 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256 /* 49207 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA384 /* 49208 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_NULL_SHA /* 49209 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_NULL_SHA256 /* 49210 */:
                    case CipherSuite.TLS_ECDHE_PSK_WITH_NULL_SHA384 /* 49211 */:
                        return true;
                    default:
                        switch (i) {
                            case CipherSuite.TLS_ECDHE_RSA_WITH_ESTREAM_SALSA20_SHA1 /* 65284 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_SALSA20_SHA1 /* 65285 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_ESTREAM_SALSA20_SHA1 /* 65286 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_SALSA20_SHA1 /* 65287 */:
                                return true;
                            default:
                                switch (i) {
                                    case CipherSuite.TLS_ECDHE_PSK_WITH_ESTREAM_SALSA20_SHA1 /* 65294 */:
                                    case CipherSuite.TLS_ECDHE_PSK_WITH_SALSA20_SHA1 /* 65295 */:
                                        return true;
                                    default:
                                        switch (i) {
                                            case CipherSuite.TLS_ECDHE_RSA_WITH_ESTREAM_SALSA20_UMAC96 /* 65300 */:
                                            case CipherSuite.TLS_ECDHE_RSA_WITH_SALSA20_UMAC96 /* 65301 */:
                                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_ESTREAM_SALSA20_UMAC96 /* 65302 */:
                                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_SALSA20_UMAC96 /* 65303 */:
                                                return true;
                                            default:
                                                switch (i) {
                                                    case CipherSuite.TLS_ECDHE_PSK_WITH_ESTREAM_SALSA20_UMAC96 /* 65310 */:
                                                    case CipherSuite.TLS_ECDHE_PSK_WITH_SALSA20_UMAC96 /* 65311 */:
                                                        return true;
                                                    default:
                                                        return false;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static boolean isSupportedNamedCurve(int i) {
        return i > 0 && i <= curveNames.length;
    }

    public static int readECExponent(int i, InputStream inputStream) throws IOException {
        int iIntValue;
        BigInteger eCParameter = readECParameter(inputStream);
        if (eCParameter.bitLength() >= 32 || (iIntValue = eCParameter.intValue()) <= 0 || iIntValue >= i) {
            throw new TlsFatalAlert((short) 47);
        }
        return iIntValue;
    }

    public static BigInteger readECFieldElement(int i, InputStream inputStream) throws IOException {
        return deserializeECFieldElement(i, TlsUtils.readOpaque8(inputStream));
    }

    public static BigInteger readECParameter(InputStream inputStream) throws IOException {
        return new BigInteger(1, TlsUtils.readOpaque8(inputStream));
    }

    public static ECDomainParameters readECParameters(int[] iArr, short[] sArr, InputStream inputStream) throws IOException {
        ECCurve.F2m f2m;
        try {
            short uint8 = TlsUtils.readUint8(inputStream);
            if (uint8 == 1) {
                checkNamedCurve(iArr, 65281);
                BigInteger eCParameter = readECParameter(inputStream);
                ECCurve.Fp fp = new ECCurve.Fp(eCParameter, readECFieldElement(eCParameter.bitLength(), inputStream), readECFieldElement(eCParameter.bitLength(), inputStream));
                return new ECDomainParameters(fp, deserializeECPoint(sArr, fp, TlsUtils.readOpaque8(inputStream)), readECParameter(inputStream), readECParameter(inputStream));
            }
            if (uint8 != 2) {
                if (uint8 != 3) {
                    throw new TlsFatalAlert((short) 47);
                }
                int uint16 = TlsUtils.readUint16(inputStream);
                if (!NamedCurve.refersToASpecificNamedCurve(uint16)) {
                    throw new TlsFatalAlert((short) 47);
                }
                checkNamedCurve(iArr, uint16);
                return getParametersForNamedCurve(uint16);
            }
            checkNamedCurve(iArr, 65282);
            int uint162 = TlsUtils.readUint16(inputStream);
            short uint82 = TlsUtils.readUint8(inputStream);
            if (uint82 == 1) {
                f2m = new ECCurve.F2m(uint162, readECExponent(uint162, inputStream), readECFieldElement(uint162, inputStream), readECFieldElement(uint162, inputStream));
            } else {
                if (uint82 != 2) {
                    throw new TlsFatalAlert((short) 47);
                }
                f2m = new ECCurve.F2m(uint162, readECExponent(uint162, inputStream), readECExponent(uint162, inputStream), readECExponent(uint162, inputStream), readECFieldElement(uint162, inputStream), readECFieldElement(uint162, inputStream));
            }
            return new ECDomainParameters(f2m, deserializeECPoint(sArr, f2m, TlsUtils.readOpaque8(inputStream)), readECParameter(inputStream), readECParameter(inputStream));
        } catch (RuntimeException unused) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    public static int[] readSupportedEllipticCurvesExtension(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        int uint16 = TlsUtils.readUint16(byteArrayInputStream);
        if (uint16 < 2 || (uint16 & 1) != 0) {
            throw new TlsFatalAlert((short) 50);
        }
        int[] uint16Array = TlsUtils.readUint16Array(uint16 / 2, byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        return uint16Array;
    }

    public static short[] readSupportedPointFormatsExtension(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        short uint8 = TlsUtils.readUint8(byteArrayInputStream);
        if (uint8 < 1) {
            throw new TlsFatalAlert((short) 50);
        }
        short[] uint8Array = TlsUtils.readUint8Array(uint8, byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        if (Arrays.contains(uint8Array, (short) 0)) {
            return uint8Array;
        }
        throw new TlsFatalAlert((short) 47);
    }

    public static byte[] serializeECFieldElement(int i, BigInteger bigInteger) throws IOException {
        return BigIntegers.asUnsignedByteArray((i + 7) / 8, bigInteger);
    }

    public static byte[] serializeECPoint(short[] sArr, ECPoint eCPoint) throws IOException {
        boolean zIsCompressionPreferred;
        short s;
        ECCurve curve = eCPoint.getCurve();
        if (curve instanceof ECCurve.F2m) {
            s = 2;
        } else {
            if (!(curve instanceof ECCurve.Fp)) {
                zIsCompressionPreferred = false;
                return eCPoint.getEncoded(zIsCompressionPreferred);
            }
            s = 1;
        }
        zIsCompressionPreferred = isCompressionPreferred(sArr, s);
        return eCPoint.getEncoded(zIsCompressionPreferred);
    }

    public static byte[] serializeECPublicKey(short[] sArr, ECPublicKeyParameters eCPublicKeyParameters) throws IOException {
        return serializeECPoint(sArr, eCPublicKeyParameters.getQ());
    }

    public static ECPublicKeyParameters validateECPublicKey(ECPublicKeyParameters eCPublicKeyParameters) throws IOException {
        return eCPublicKeyParameters;
    }

    public static void writeECExponent(int i, OutputStream outputStream) throws IOException {
        writeECParameter(BigInteger.valueOf(i), outputStream);
    }

    public static void writeECFieldElement(int i, BigInteger bigInteger, OutputStream outputStream) throws IOException {
        TlsUtils.writeOpaque8(serializeECFieldElement(i, bigInteger), outputStream);
    }

    public static void writeECFieldElement(ECFieldElement eCFieldElement, OutputStream outputStream) throws IOException {
        TlsUtils.writeOpaque8(eCFieldElement.getEncoded(), outputStream);
    }

    public static void writeECParameter(BigInteger bigInteger, OutputStream outputStream) throws IOException {
        TlsUtils.writeOpaque8(BigIntegers.asUnsignedByteArray(bigInteger), outputStream);
    }

    public static void writeECPoint(short[] sArr, ECPoint eCPoint, OutputStream outputStream) throws IOException {
        TlsUtils.writeOpaque8(serializeECPoint(sArr, eCPoint), outputStream);
    }

    public static void writeExplicitECParameters(short[] sArr, ECDomainParameters eCDomainParameters, OutputStream outputStream) throws IOException {
        int k3;
        ECCurve curve = eCDomainParameters.getCurve();
        if (curve instanceof ECCurve.Fp) {
            TlsUtils.writeUint8((short) 1, outputStream);
            writeECParameter(((ECCurve.Fp) curve).getQ(), outputStream);
        } else {
            if (!(curve instanceof ECCurve.F2m)) {
                throw new IllegalArgumentException("'ecParameters' not a known curve type");
            }
            TlsUtils.writeUint8((short) 2, outputStream);
            ECCurve.F2m f2m = (ECCurve.F2m) curve;
            int m = f2m.getM();
            TlsUtils.checkUint16(m);
            TlsUtils.writeUint16(m, outputStream);
            if (f2m.isTrinomial()) {
                TlsUtils.writeUint8((short) 1, outputStream);
                k3 = f2m.getK1();
            } else {
                TlsUtils.writeUint8((short) 2, outputStream);
                writeECExponent(f2m.getK1(), outputStream);
                writeECExponent(f2m.getK2(), outputStream);
                k3 = f2m.getK3();
            }
            writeECExponent(k3, outputStream);
        }
        writeECFieldElement(curve.getA(), outputStream);
        writeECFieldElement(curve.getB(), outputStream);
        TlsUtils.writeOpaque8(serializeECPoint(sArr, eCDomainParameters.getG()), outputStream);
        writeECParameter(eCDomainParameters.getN(), outputStream);
        writeECParameter(eCDomainParameters.getH(), outputStream);
    }

    public static void writeNamedECParameters(int i, OutputStream outputStream) throws IOException {
        if (!NamedCurve.refersToASpecificNamedCurve(i)) {
            throw new TlsFatalAlert((short) 80);
        }
        TlsUtils.writeUint8((short) 3, outputStream);
        TlsUtils.checkUint16(i);
        TlsUtils.writeUint16(i, outputStream);
    }
}

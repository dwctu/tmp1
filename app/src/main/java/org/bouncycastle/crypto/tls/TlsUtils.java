package org.bouncycastle.crypto.tls;

import com.google.common.primitives.UnsignedInts;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes5.dex */
public class TlsUtils {
    public static byte[] EMPTY_BYTES = new byte[0];
    public static final Integer EXT_signature_algorithms = Integers.valueOf(13);
    public static final byte[] SSL_CLIENT = {67, 76, 78, 84};
    public static final byte[] SSL_SERVER = {83, 82, 86, 82};
    public static final byte[][] SSL3_CONST = genConst();

    public static byte[] PRF(TlsContext tlsContext, byte[] bArr, String str, byte[] bArr2, int i) {
        if (tlsContext.getServerVersion().isSSL()) {
            throw new IllegalStateException("No PRF available for SSLv3 session");
        }
        byte[] byteArray = Strings.toByteArray(str);
        byte[] bArrConcat = concat(byteArray, bArr2);
        int prfAlgorithm = tlsContext.getSecurityParameters().getPrfAlgorithm();
        if (prfAlgorithm == 0) {
            return PRF_legacy(bArr, byteArray, bArrConcat, i);
        }
        byte[] bArr3 = new byte[i];
        hmac_hash(createPRFHash(prfAlgorithm), bArr, bArrConcat, bArr3);
        return bArr3;
    }

    public static byte[] PRF_legacy(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int length = (bArr.length + 1) / 2;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, 0, bArr4, 0, length);
        System.arraycopy(bArr, bArr.length - length, bArr5, 0, length);
        byte[] bArr6 = new byte[i];
        byte[] bArr7 = new byte[i];
        hmac_hash(new MD5Digest(), bArr4, bArr3, bArr6);
        hmac_hash(new SHA1Digest(), bArr5, bArr3, bArr7);
        for (int i2 = 0; i2 < i; i2++) {
            bArr6[i2] = (byte) (bArr6[i2] ^ bArr7[i2]);
        }
        return bArr6;
    }

    public static void addSignatureAlgorithmsExtension(Hashtable hashtable, Vector vector) throws IOException {
        hashtable.put(EXT_signature_algorithms, createSignatureAlgorithmsExtension(vector));
    }

    public static byte[] calculateKeyBlock(TlsContext tlsContext, int i) {
        SecurityParameters securityParameters = tlsContext.getSecurityParameters();
        byte[] masterSecret = securityParameters.getMasterSecret();
        byte[] bArrConcat = concat(securityParameters.getServerRandom(), securityParameters.getClientRandom());
        return isSSL(tlsContext) ? calculateKeyBlock_SSL(masterSecret, bArrConcat, i) : PRF(tlsContext, masterSecret, ExporterLabel.key_expansion, bArrConcat, i);
    }

    public static byte[] calculateKeyBlock_SSL(byte[] bArr, byte[] bArr2, int i) {
        MD5Digest mD5Digest = new MD5Digest();
        SHA1Digest sHA1Digest = new SHA1Digest();
        int digestSize = mD5Digest.getDigestSize();
        int digestSize2 = sHA1Digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        byte[] bArr4 = new byte[i + digestSize];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            byte[] bArr5 = SSL3_CONST[i3];
            sHA1Digest.update(bArr5, 0, bArr5.length);
            sHA1Digest.update(bArr, 0, bArr.length);
            sHA1Digest.update(bArr2, 0, bArr2.length);
            sHA1Digest.doFinal(bArr3, 0);
            mD5Digest.update(bArr, 0, bArr.length);
            mD5Digest.update(bArr3, 0, digestSize2);
            mD5Digest.doFinal(bArr4, i2);
            i2 += digestSize;
            i3++;
        }
        byte[] bArr6 = new byte[i];
        System.arraycopy(bArr4, 0, bArr6, 0, i);
        return bArr6;
    }

    public static byte[] calculateMasterSecret(TlsContext tlsContext, byte[] bArr) {
        SecurityParameters securityParameters = tlsContext.getSecurityParameters();
        byte[] bArrConcat = concat(securityParameters.getClientRandom(), securityParameters.getServerRandom());
        return isSSL(tlsContext) ? calculateMasterSecret_SSL(bArr, bArrConcat) : PRF(tlsContext, bArr, ExporterLabel.master_secret, bArrConcat, 48);
    }

    public static byte[] calculateMasterSecret_SSL(byte[] bArr, byte[] bArr2) {
        MD5Digest mD5Digest = new MD5Digest();
        SHA1Digest sHA1Digest = new SHA1Digest();
        int digestSize = mD5Digest.getDigestSize();
        int digestSize2 = sHA1Digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        byte[] bArr4 = new byte[digestSize * 3];
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            byte[] bArr5 = SSL3_CONST[i2];
            sHA1Digest.update(bArr5, 0, bArr5.length);
            sHA1Digest.update(bArr, 0, bArr.length);
            sHA1Digest.update(bArr2, 0, bArr2.length);
            sHA1Digest.doFinal(bArr3, 0);
            mD5Digest.update(bArr, 0, bArr.length);
            mD5Digest.update(bArr3, 0, digestSize2);
            mD5Digest.doFinal(bArr4, i);
            i += digestSize;
        }
        return bArr4;
    }

    public static byte[] calculateVerifyData(TlsContext tlsContext, String str, byte[] bArr) {
        if (isSSL(tlsContext)) {
            return bArr;
        }
        SecurityParameters securityParameters = tlsContext.getSecurityParameters();
        return PRF(tlsContext, securityParameters.getMasterSecret(), str, bArr, securityParameters.getVerifyDataLength());
    }

    public static void checkUint16(int i) throws IOException {
        if (!isValidUint16(i)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint24(int i) throws IOException {
        if (!isValidUint24(i)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint32(long j) throws IOException {
        if (!isValidUint32(j)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint48(long j) throws IOException {
        if (!isValidUint48(j)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint64(long j) throws IOException {
        if (!isValidUint64(j)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint8(int i) throws IOException {
        if (!isValidUint8(i)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint8(short s) throws IOException {
        if (!isValidUint8(s)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static final Digest cloneHash(short s, Digest digest) {
        switch (s) {
            case 1:
                return new MD5Digest((MD5Digest) digest);
            case 2:
                return new SHA1Digest((SHA1Digest) digest);
            case 3:
                return new SHA224Digest((SHA224Digest) digest);
            case 4:
                return new SHA256Digest((SHA256Digest) digest);
            case 5:
                return new SHA384Digest((SHA384Digest) digest);
            case 6:
                return new SHA512Digest((SHA512Digest) digest);
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static final Digest clonePRFHash(int i, Digest digest) {
        return i != 0 ? cloneHash(getHashAlgorithmForPRFAlgorithm(i), digest) : new CombinedHash((CombinedHash) digest);
    }

    public static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static final Digest createHash(short s) {
        switch (s) {
            case 1:
                return new MD5Digest();
            case 2:
                return new SHA1Digest();
            case 3:
                return new SHA224Digest();
            case 4:
                return new SHA256Digest();
            case 5:
                return new SHA384Digest();
            case 6:
                return new SHA512Digest();
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static final Digest createPRFHash(int i) {
        return i != 0 ? createHash(getHashAlgorithmForPRFAlgorithm(i)) : new CombinedHash();
    }

    public static byte[] createSignatureAlgorithmsExtension(Vector vector) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encodeSupportedSignatureAlgorithms(vector, false, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static TlsSigner createTlsSigner(short s) {
        if (s == 1) {
            return new TlsRSASigner();
        }
        if (s == 2) {
            return new TlsDSSSigner();
        }
        if (s == 64) {
            return new TlsECDSASigner();
        }
        throw new IllegalArgumentException("'clientCertificateType' is not a type with signing capability");
    }

    public static byte[] encodeOpaque8(byte[] bArr) throws IOException {
        checkUint8(bArr.length);
        return Arrays.prepend(bArr, (byte) bArr.length);
    }

    public static void encodeSupportedSignatureAlgorithms(Vector vector, boolean z, OutputStream outputStream) throws IOException {
        if (vector == null || vector.size() < 1 || vector.size() >= 32768) {
            throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
        }
        int size = vector.size() * 2;
        checkUint16(size);
        writeUint16(size, outputStream);
        for (int i = 0; i < vector.size(); i++) {
            SignatureAndHashAlgorithm signatureAndHashAlgorithm = (SignatureAndHashAlgorithm) vector.elementAt(i);
            if (!z && signatureAndHashAlgorithm.getSignature() == 0) {
                throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
            }
            signatureAndHashAlgorithm.encode(outputStream);
        }
    }

    public static byte[] encodeUint16ArrayWithUint16Length(int[] iArr) throws IOException {
        byte[] bArr = new byte[(iArr.length * 2) + 2];
        writeUint16ArrayWithUint16Length(iArr, bArr, 0);
        return bArr;
    }

    public static byte[] encodeUint8ArrayWithUint8Length(short[] sArr) throws IOException {
        byte[] bArr = new byte[sArr.length + 1];
        writeUint8ArrayWithUint8Length(sArr, bArr, 0);
        return bArr;
    }

    private static byte[][] genConst() {
        byte[][] bArr = new byte[10][];
        int i = 0;
        while (i < 10) {
            int i2 = i + 1;
            byte[] bArr2 = new byte[i2];
            Arrays.fill(bArr2, (byte) (i + 65));
            bArr[i] = bArr2;
            i = i2;
        }
        return bArr;
    }

    public static short getClientCertificateType(Certificate certificate, Certificate certificate2) throws IOException {
        AsymmetricKeyParameter asymmetricKeyParameterCreateKey;
        if (certificate.isEmpty()) {
            return (short) -1;
        }
        org.bouncycastle.asn1.x509.Certificate certificateAt = certificate.getCertificateAt(0);
        try {
            asymmetricKeyParameterCreateKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
        } catch (Exception unused) {
        }
        if (asymmetricKeyParameterCreateKey.isPrivate()) {
            throw new TlsFatalAlert((short) 80);
        }
        if (asymmetricKeyParameterCreateKey instanceof RSAKeyParameters) {
            validateKeyUsage(certificateAt, 128);
            return (short) 1;
        }
        if (asymmetricKeyParameterCreateKey instanceof DSAPublicKeyParameters) {
            validateKeyUsage(certificateAt, 128);
            return (short) 2;
        }
        if (asymmetricKeyParameterCreateKey instanceof ECPublicKeyParameters) {
            validateKeyUsage(certificateAt, 128);
            return (short) 64;
        }
        throw new TlsFatalAlert((short) 43);
    }

    public static Vector getDefaultDSSSignatureAlgorithms() {
        return vectorOfOne(new SignatureAndHashAlgorithm((short) 2, (short) 2));
    }

    public static Vector getDefaultECDSASignatureAlgorithms() {
        return vectorOfOne(new SignatureAndHashAlgorithm((short) 2, (short) 3));
    }

    public static Vector getDefaultRSASignatureAlgorithms() {
        return vectorOfOne(new SignatureAndHashAlgorithm((short) 2, (short) 1));
    }

    public static byte[] getExtensionData(Hashtable hashtable, Integer num) {
        if (hashtable == null) {
            return null;
        }
        return (byte[]) hashtable.get(num);
    }

    public static final short getHashAlgorithmForPRFAlgorithm(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("legacy PRF not a valid algorithm");
        }
        if (i == 1) {
            return (short) 4;
        }
        if (i == 2) {
            return (short) 5;
        }
        throw new IllegalArgumentException("unknown PRFAlgorithm");
    }

    public static ASN1ObjectIdentifier getOIDForHashAlgorithm(short s) {
        switch (s) {
            case 1:
                return PKCSObjectIdentifiers.md5;
            case 2:
                return X509ObjectIdentifiers.id_SHA1;
            case 3:
                return NISTObjectIdentifiers.id_sha224;
            case 4:
                return NISTObjectIdentifiers.id_sha256;
            case 5:
                return NISTObjectIdentifiers.id_sha384;
            case 6:
                return NISTObjectIdentifiers.id_sha512;
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static Vector getSignatureAlgorithmsExtension(Hashtable hashtable) throws IOException {
        byte[] extensionData = getExtensionData(hashtable, EXT_signature_algorithms);
        if (extensionData == null) {
            return null;
        }
        return readSignatureAlgorithmsExtension(extensionData);
    }

    public static boolean hasExpectedEmptyExtensionData(Hashtable hashtable, Integer num, short s) throws IOException {
        byte[] extensionData = getExtensionData(hashtable, num);
        if (extensionData == null) {
            return false;
        }
        if (extensionData.length == 0) {
            return true;
        }
        throw new TlsFatalAlert(s);
    }

    public static boolean hasSigningCapability(short s) {
        return s == 1 || s == 2 || s == 64;
    }

    public static void hmac_hash(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        HMac hMac = new HMac(digest);
        KeyParameter keyParameter = new KeyParameter(bArr);
        int digestSize = digest.getDigestSize();
        int length = ((bArr3.length + digestSize) - 1) / digestSize;
        int macSize = hMac.getMacSize();
        byte[] bArr4 = new byte[macSize];
        byte[] bArr5 = new byte[hMac.getMacSize()];
        byte[] bArr6 = bArr2;
        int i = 0;
        while (i < length) {
            hMac.init(keyParameter);
            hMac.update(bArr6, 0, bArr6.length);
            hMac.doFinal(bArr4, 0);
            hMac.init(keyParameter);
            hMac.update(bArr4, 0, macSize);
            hMac.update(bArr2, 0, bArr2.length);
            hMac.doFinal(bArr5, 0);
            int i2 = digestSize * i;
            System.arraycopy(bArr5, 0, bArr3, i2, Math.min(digestSize, bArr3.length - i2));
            i++;
            bArr6 = bArr4;
        }
    }

    public static TlsSession importSession(byte[] bArr, SessionParameters sessionParameters) {
        return new TlsSessionImpl(bArr, sessionParameters);
    }

    public static boolean isSSL(TlsContext tlsContext) {
        return tlsContext.getServerVersion().isSSL();
    }

    public static boolean isSignatureAlgorithmsExtensionAllowed(ProtocolVersion protocolVersion) {
        return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(protocolVersion.getEquivalentTLSVersion());
    }

    public static boolean isTLSv11(TlsContext tlsContext) {
        return ProtocolVersion.TLSv11.isEqualOrEarlierVersionOf(tlsContext.getServerVersion().getEquivalentTLSVersion());
    }

    public static boolean isTLSv12(TlsContext tlsContext) {
        return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(tlsContext.getServerVersion().getEquivalentTLSVersion());
    }

    public static boolean isValidUint16(int i) {
        return (65535 & i) == i;
    }

    public static boolean isValidUint24(int i) {
        return (16777215 & i) == i;
    }

    public static boolean isValidUint32(long j) {
        return (UnsignedInts.INT_MASK & j) == j;
    }

    public static boolean isValidUint48(long j) {
        return (281474976710655L & j) == j;
    }

    public static boolean isValidUint64(long j) {
        return true;
    }

    public static boolean isValidUint8(int i) {
        return (i & 255) == i;
    }

    public static boolean isValidUint8(short s) {
        return (s & 255) == s;
    }

    public static Vector parseSupportedSignatureAlgorithms(boolean z, InputStream inputStream) throws IOException {
        int uint16 = readUint16(inputStream);
        if (uint16 < 2 || (uint16 & 1) != 0) {
            throw new TlsFatalAlert((short) 50);
        }
        int i = uint16 / 2;
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 < i; i2++) {
            SignatureAndHashAlgorithm signatureAndHashAlgorithm = SignatureAndHashAlgorithm.parse(inputStream);
            if (!z && signatureAndHashAlgorithm.getSignature() == 0) {
                throw new TlsFatalAlert((short) 47);
            }
            vector.addElement(signatureAndHashAlgorithm);
        }
        return vector;
    }

    public static ASN1Primitive readASN1Object(byte[] bArr) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        ASN1Primitive object = aSN1InputStream.readObject();
        if (object == null) {
            throw new TlsFatalAlert((short) 50);
        }
        if (aSN1InputStream.readObject() == null) {
            return object;
        }
        throw new TlsFatalAlert((short) 50);
    }

    public static byte[] readAllOrNothing(int i, InputStream inputStream) throws IOException {
        if (i < 1) {
            return EMPTY_BYTES;
        }
        byte[] bArr = new byte[i];
        int fully = Streams.readFully(inputStream, bArr);
        if (fully == 0) {
            return null;
        }
        if (fully == i) {
            return bArr;
        }
        throw new EOFException();
    }

    public static ASN1Primitive readDERObject(byte[] bArr) throws IOException {
        ASN1Primitive aSN1Object = readASN1Object(bArr);
        if (Arrays.areEqual(aSN1Object.getEncoded(ASN1Encoding.DER), bArr)) {
            return aSN1Object;
        }
        throw new TlsFatalAlert((short) 50);
    }

    public static void readFully(byte[] bArr, InputStream inputStream) throws IOException {
        int length = bArr.length;
        if (length > 0 && length != Streams.readFully(inputStream, bArr)) {
            throw new EOFException();
        }
    }

    public static byte[] readFully(int i, InputStream inputStream) throws IOException {
        if (i < 1) {
            return EMPTY_BYTES;
        }
        byte[] bArr = new byte[i];
        if (i == Streams.readFully(inputStream, bArr)) {
            return bArr;
        }
        throw new EOFException();
    }

    public static byte[] readOpaque16(InputStream inputStream) throws IOException {
        return readFully(readUint16(inputStream), inputStream);
    }

    public static byte[] readOpaque24(InputStream inputStream) throws IOException {
        return readFully(readUint24(inputStream), inputStream);
    }

    public static byte[] readOpaque8(InputStream inputStream) throws IOException {
        return readFully(readUint8(inputStream), inputStream);
    }

    public static Vector readSignatureAlgorithmsExtension(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Vector supportedSignatureAlgorithms = parseSupportedSignatureAlgorithms(false, byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        return supportedSignatureAlgorithms;
    }

    public static int readUint16(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        if (i2 >= 0) {
            return i2 | (i << 8);
        }
        throw new EOFException();
    }

    public static int readUint16(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public static int[] readUint16Array(int i, InputStream inputStream) throws IOException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readUint16(inputStream);
        }
        return iArr;
    }

    public static int readUint24(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();
        if (i3 >= 0) {
            return i3 | (i << 16) | (i2 << 8);
        }
        throw new EOFException();
    }

    public static int readUint24(byte[] bArr, int i) {
        int i2 = (bArr[i] & 255) << 16;
        int i3 = i + 1;
        return (bArr[i3 + 1] & 255) | i2 | ((bArr[i3] & 255) << 8);
    }

    public static long readUint32(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();
        int i4 = inputStream.read();
        if (i4 < 0) {
            throw new EOFException();
        }
        return (i2 << 16) | (i << 24) | (i3 << 8) | i4;
    }

    public static long readUint48(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();
        int i4 = inputStream.read();
        int i5 = inputStream.read();
        int i6 = inputStream.read();
        if (i6 < 0) {
            throw new EOFException();
        }
        return (i2 << 32) | (i << 40) | (i3 << 24) | (i4 << 16) | (i5 << 8) | i6;
    }

    public static long readUint48(byte[] bArr, int i) {
        int uint24 = readUint24(bArr, i);
        return (readUint24(bArr, i + 3) & UnsignedInts.INT_MASK) | ((uint24 & UnsignedInts.INT_MASK) << 24);
    }

    public static short readUint8(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i >= 0) {
            return (short) i;
        }
        throw new EOFException();
    }

    public static short readUint8(byte[] bArr, int i) {
        return bArr[i];
    }

    public static short[] readUint8Array(int i, InputStream inputStream) throws IOException {
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = readUint8(inputStream);
        }
        return sArr;
    }

    public static ProtocolVersion readVersion(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        if (i2 >= 0) {
            return ProtocolVersion.get(i, i2);
        }
        throw new EOFException();
    }

    public static ProtocolVersion readVersion(byte[] bArr, int i) throws IOException {
        return ProtocolVersion.get(bArr[i] & 255, bArr[i + 1] & 255);
    }

    public static int readVersionRaw(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        if (i2 >= 0) {
            return i2 | (i << 8);
        }
        throw new EOFException();
    }

    public static int readVersionRaw(byte[] bArr, int i) throws IOException {
        return bArr[i + 1] | (bArr[i] << 8);
    }

    public static void trackHashAlgorithms(TlsHandshakeHash tlsHandshakeHash, Vector vector) {
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {
                tlsHandshakeHash.trackHashAlgorithm(((SignatureAndHashAlgorithm) vector.elementAt(i)).getHash());
            }
        }
    }

    public static void validateKeyUsage(org.bouncycastle.asn1.x509.Certificate certificate, int i) throws IOException {
        KeyUsage keyUsageFromExtensions;
        Extensions extensions = certificate.getTBSCertificate().getExtensions();
        if (extensions != null && (keyUsageFromExtensions = KeyUsage.fromExtensions(extensions)) != null && (keyUsageFromExtensions.getBytes()[0] & 255 & i) != i) {
            throw new TlsFatalAlert((short) 46);
        }
    }

    private static Vector vectorOfOne(Object obj) {
        Vector vector = new Vector(1);
        vector.addElement(obj);
        return vector;
    }

    public static void writeGMTUnixTime(byte[] bArr, int i) {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        bArr[i] = (byte) (iCurrentTimeMillis >> 24);
        bArr[i + 1] = (byte) (iCurrentTimeMillis >> 16);
        bArr[i + 2] = (byte) (iCurrentTimeMillis >> 8);
        bArr[i + 3] = (byte) iCurrentTimeMillis;
    }

    public static void writeOpaque16(byte[] bArr, OutputStream outputStream) throws IOException {
        checkUint16(bArr.length);
        writeUint16(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeOpaque24(byte[] bArr, OutputStream outputStream) throws IOException {
        checkUint24(bArr.length);
        writeUint24(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeOpaque8(byte[] bArr, OutputStream outputStream) throws IOException {
        checkUint8(bArr.length);
        writeUint8(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeUint16(int i, OutputStream outputStream) throws IOException {
        outputStream.write(i >> 8);
        outputStream.write(i);
    }

    public static void writeUint16(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 8);
        bArr[i2 + 1] = (byte) i;
    }

    public static void writeUint16Array(int[] iArr, OutputStream outputStream) throws IOException {
        for (int i : iArr) {
            writeUint16(i, outputStream);
        }
    }

    public static void writeUint16Array(int[] iArr, byte[] bArr, int i) throws IOException {
        for (int i2 : iArr) {
            writeUint16(i2, bArr, i);
            i += 2;
        }
    }

    public static void writeUint16ArrayWithUint16Length(int[] iArr, OutputStream outputStream) throws IOException {
        int length = iArr.length * 2;
        checkUint16(length);
        writeUint16(length, outputStream);
        writeUint16Array(iArr, outputStream);
    }

    public static void writeUint16ArrayWithUint16Length(int[] iArr, byte[] bArr, int i) throws IOException {
        int length = iArr.length * 2;
        checkUint16(length);
        writeUint16(length, bArr, i);
        writeUint16Array(iArr, bArr, i + 2);
    }

    public static void writeUint24(int i, OutputStream outputStream) throws IOException {
        outputStream.write(i >> 16);
        outputStream.write(i >> 8);
        outputStream.write(i);
    }

    public static void writeUint24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) i;
    }

    public static void writeUint32(long j, OutputStream outputStream) throws IOException {
        outputStream.write((int) (j >> 24));
        outputStream.write((int) (j >> 16));
        outputStream.write((int) (j >> 8));
        outputStream.write((int) j);
    }

    public static void writeUint32(long j, byte[] bArr, int i) {
        bArr[i] = (byte) (j >> 24);
        bArr[i + 1] = (byte) (j >> 16);
        bArr[i + 2] = (byte) (j >> 8);
        bArr[i + 3] = (byte) j;
    }

    public static void writeUint48(long j, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j >> 40));
        outputStream.write((byte) (j >> 32));
        outputStream.write((byte) (j >> 24));
        outputStream.write((byte) (j >> 16));
        outputStream.write((byte) (j >> 8));
        outputStream.write((byte) j);
    }

    public static void writeUint48(long j, byte[] bArr, int i) {
        bArr[i] = (byte) (j >> 40);
        bArr[i + 1] = (byte) (j >> 32);
        bArr[i + 2] = (byte) (j >> 24);
        bArr[i + 3] = (byte) (j >> 16);
        bArr[i + 4] = (byte) (j >> 8);
        bArr[i + 5] = (byte) j;
    }

    public static void writeUint64(long j, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j >> 56));
        outputStream.write((byte) (j >> 48));
        outputStream.write((byte) (j >> 40));
        outputStream.write((byte) (j >> 32));
        outputStream.write((byte) (j >> 24));
        outputStream.write((byte) (j >> 16));
        outputStream.write((byte) (j >> 8));
        outputStream.write((byte) j);
    }

    public static void writeUint64(long j, byte[] bArr, int i) {
        bArr[i] = (byte) (j >> 56);
        bArr[i + 1] = (byte) (j >> 48);
        bArr[i + 2] = (byte) (j >> 40);
        bArr[i + 3] = (byte) (j >> 32);
        bArr[i + 4] = (byte) (j >> 24);
        bArr[i + 5] = (byte) (j >> 16);
        bArr[i + 6] = (byte) (j >> 8);
        bArr[i + 7] = (byte) j;
    }

    public static void writeUint8(int i, OutputStream outputStream) throws IOException {
        outputStream.write(i);
    }

    public static void writeUint8(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
    }

    public static void writeUint8(short s, OutputStream outputStream) throws IOException {
        outputStream.write(s);
    }

    public static void writeUint8(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
    }

    public static void writeUint8Array(short[] sArr, OutputStream outputStream) throws IOException {
        for (short s : sArr) {
            writeUint8(s, outputStream);
        }
    }

    public static void writeUint8Array(short[] sArr, byte[] bArr, int i) throws IOException {
        for (short s : sArr) {
            writeUint8(s, bArr, i);
            i++;
        }
    }

    public static void writeUint8ArrayWithUint8Length(short[] sArr, OutputStream outputStream) throws IOException {
        checkUint8(sArr.length);
        writeUint8(sArr.length, outputStream);
        writeUint8Array(sArr, outputStream);
    }

    public static void writeUint8ArrayWithUint8Length(short[] sArr, byte[] bArr, int i) throws IOException {
        checkUint8(sArr.length);
        writeUint8(sArr.length, bArr, i);
        writeUint8Array(sArr, bArr, i + 1);
    }

    public static void writeVersion(ProtocolVersion protocolVersion, OutputStream outputStream) throws IOException {
        outputStream.write(protocolVersion.getMajorVersion());
        outputStream.write(protocolVersion.getMinorVersion());
    }

    public static void writeVersion(ProtocolVersion protocolVersion, byte[] bArr, int i) {
        bArr[i] = (byte) protocolVersion.getMajorVersion();
        bArr[i + 1] = (byte) protocolVersion.getMinorVersion();
    }
}

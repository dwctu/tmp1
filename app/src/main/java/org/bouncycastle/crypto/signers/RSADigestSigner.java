package org.bouncycastle.crypto.signers;

import java.io.IOException;
import java.util.Hashtable;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class RSADigestSigner implements Signer {
    private static final Hashtable oidMap;
    private final AlgorithmIdentifier algId;
    private final Digest digest;
    private boolean forSigning;
    private final AsymmetricBlockCipher rsaEngine;

    static {
        Hashtable hashtable = new Hashtable();
        oidMap = hashtable;
        hashtable.put("RIPEMD128", TeleTrusTObjectIdentifiers.ripemd128);
        hashtable.put("RIPEMD160", TeleTrusTObjectIdentifiers.ripemd160);
        hashtable.put("RIPEMD256", TeleTrusTObjectIdentifiers.ripemd256);
        hashtable.put("SHA-1", X509ObjectIdentifiers.id_SHA1);
        hashtable.put("SHA-224", NISTObjectIdentifiers.id_sha224);
        hashtable.put(MessageDigestAlgorithms.SHA_256, NISTObjectIdentifiers.id_sha256);
        hashtable.put(MessageDigestAlgorithms.SHA_384, NISTObjectIdentifiers.id_sha384);
        hashtable.put(MessageDigestAlgorithms.SHA_512, NISTObjectIdentifiers.id_sha512);
        hashtable.put(MessageDigestAlgorithms.MD2, PKCSObjectIdentifiers.md2);
        hashtable.put("MD4", PKCSObjectIdentifiers.md4);
        hashtable.put("MD5", PKCSObjectIdentifiers.md5);
    }

    public RSADigestSigner(Digest digest) {
        this(digest, (ASN1ObjectIdentifier) oidMap.get(digest.getAlgorithmName()));
    }

    public RSADigestSigner(Digest digest, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.rsaEngine = new PKCS1Encoding(new RSABlindedEngine());
        this.digest = digest;
        this.algId = new AlgorithmIdentifier(aSN1ObjectIdentifier, (ASN1Encodable) DERNull.INSTANCE);
    }

    private byte[] derEncode(byte[] bArr) throws IOException {
        return new DigestInfo(this.algId, bArr).getEncoded(ASN1Encoding.DER);
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws DataLengthException, CryptoException {
        if (!this.forSigning) {
            throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        try {
            byte[] bArrDerEncode = derEncode(bArr);
            return this.rsaEngine.processBlock(bArrDerEncode, 0, bArrDerEncode.length);
        } catch (IOException e) {
            throw new CryptoException("unable to encode signature: " + e.getMessage(), e);
        }
    }

    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "withRSA";
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        AsymmetricKeyParameter asymmetricKeyParameter = cipherParameters instanceof ParametersWithRandom ? (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters() : (AsymmetricKeyParameter) cipherParameters;
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("signing requires private key");
        }
        if (!z && asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("verification requires public key");
        }
        reset();
        this.rsaEngine.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b) {
        this.digest.update(b);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        if (this.forSigning) {
            throw new IllegalStateException("RSADigestSigner not initialised for verification");
        }
        int digestSize = this.digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        this.digest.doFinal(bArr2, 0);
        try {
            byte[] bArrProcessBlock = this.rsaEngine.processBlock(bArr, 0, bArr.length);
            byte[] bArrDerEncode = derEncode(bArr2);
            if (bArrProcessBlock.length == bArrDerEncode.length) {
                return Arrays.constantTimeAreEqual(bArrProcessBlock, bArrDerEncode);
            }
            if (bArrProcessBlock.length != bArrDerEncode.length - 2) {
                return false;
            }
            int length = (bArrProcessBlock.length - digestSize) - 2;
            int length2 = (bArrDerEncode.length - digestSize) - 2;
            bArrDerEncode[1] = (byte) (bArrDerEncode[1] - 2);
            bArrDerEncode[3] = (byte) (bArrDerEncode[3] - 2);
            int i = 0;
            for (int i2 = 0; i2 < digestSize; i2++) {
                i |= bArrProcessBlock[length + i2] ^ bArrDerEncode[length2 + i2];
            }
            for (int i3 = 0; i3 < length; i3++) {
                i |= bArrProcessBlock[i3] ^ bArrDerEncode[i3];
            }
            return i == 0;
        } catch (Exception unused) {
            return false;
        }
    }
}

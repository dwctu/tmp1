package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;

/* loaded from: classes5.dex */
public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi {
    private static final Hashtable algorithms;
    private BigInteger g;
    private BigInteger p;
    private BigInteger result;
    private BigInteger x;

    static {
        Hashtable hashtable = new Hashtable();
        algorithms = hashtable;
        Integer numValueOf = Integers.valueOf(64);
        Integer numValueOf2 = Integers.valueOf(192);
        Integer numValueOf3 = Integers.valueOf(128);
        Integer numValueOf4 = Integers.valueOf(256);
        hashtable.put("DES", numValueOf);
        hashtable.put("DESEDE", numValueOf2);
        hashtable.put("BLOWFISH", numValueOf3);
        hashtable.put("AES", numValueOf4);
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        int iBitLength = (this.p.bitLength() + 7) / 8;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == iBitLength) {
            return byteArray;
        }
        if (byteArray[0] != 0 || byteArray.length != iBitLength + 1) {
            byte[] bArr = new byte[iBitLength];
            System.arraycopy(byteArray, 0, bArr, iBitLength - byteArray.length, byteArray.length);
            return bArr;
        }
        int length = byteArray.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(byteArray, 1, bArr2, 0, length);
        return bArr2;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws IllegalStateException, InvalidKeyException {
        if (this.x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        if (!(key instanceof DHPublicKey)) {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
        DHPublicKey dHPublicKey = (DHPublicKey) key;
        if (!dHPublicKey.getParams().getG().equals(this.g) || !dHPublicKey.getParams().getP().equals(this.p)) {
            throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
        }
        if (z) {
            this.result = dHPublicKey.getY().modPow(this.x, this.p);
            return null;
        }
        BigInteger bigIntegerModPow = dHPublicKey.getY().modPow(this.x, this.p);
        this.result = bigIntegerModPow;
        return new BCDHPublicKey(bigIntegerModPow, dHPublicKey.getParams());
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        if (this.x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        byte[] bArrBigIntToBytes = bigIntToBytes(this.result);
        if (bArr.length - i < bArrBigIntToBytes.length) {
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        }
        System.arraycopy(bArrBigIntToBytes, 0, bArr, i, bArrBigIntToBytes.length);
        return bArrBigIntToBytes.length;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        if (this.x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        String upperCase = Strings.toUpperCase(str);
        byte[] bArrBigIntToBytes = bigIntToBytes(this.result);
        Hashtable hashtable = algorithms;
        if (!hashtable.containsKey(upperCase)) {
            return new SecretKeySpec(bArrBigIntToBytes, str);
        }
        int iIntValue = ((Integer) hashtable.get(upperCase)).intValue() / 8;
        byte[] bArr = new byte[iIntValue];
        System.arraycopy(bArrBigIntToBytes, 0, bArr, 0, iIntValue);
        if (upperCase.startsWith("DES")) {
            DESParameters.setOddParity(bArr);
        }
        return new SecretKeySpec(bArr, str);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.x != null) {
            return bigIntToBytes(this.result);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
        this.p = dHPrivateKey.getParams().getP();
        this.g = dHPrivateKey.getParams().getG();
        BigInteger x = dHPrivateKey.getX();
        this.result = x;
        this.x = x;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        DHParameterSpec params;
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
        if (algorithmParameterSpec == null) {
            this.p = dHPrivateKey.getParams().getP();
            params = dHPrivateKey.getParams();
        } else {
            if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            params = (DHParameterSpec) algorithmParameterSpec;
            this.p = params.getP();
        }
        this.g = params.getG();
        BigInteger x = dHPrivateKey.getX();
        this.result = x;
        this.x = x;
    }
}

package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes5.dex */
public class RSAKeyEncapsulation implements KeyEncapsulation {
    private DerivationFunction kdf;
    private RSAKeyParameters key;
    private SecureRandom rnd;
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger ONE = BigInteger.valueOf(1);

    public RSAKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.kdf = derivationFunction;
        this.rnd = secureRandom;
    }

    public CipherParameters decrypt(byte[] bArr, int i) {
        return decrypt(bArr, 0, bArr.length, i);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public CipherParameters decrypt(byte[] bArr, int i, int i2, int i3) throws DataLengthException, IllegalArgumentException {
        if (!this.key.isPrivate()) {
            throw new IllegalArgumentException("Private key required for decryption");
        }
        BigInteger modulus = this.key.getModulus();
        BigInteger exponent = this.key.getExponent();
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.kdf.init(new KDFParameters(BigIntegers.asUnsignedByteArray((modulus.bitLength() + 7) / 8, new BigInteger(1, bArr2).modPow(exponent, modulus)), null));
        byte[] bArr3 = new byte[i3];
        this.kdf.generateBytes(bArr3, 0, i3);
        return new KeyParameter(bArr3);
    }

    public CipherParameters encrypt(byte[] bArr, int i) {
        return encrypt(bArr, 0, i);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public CipherParameters encrypt(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        if (this.key.isPrivate()) {
            throw new IllegalArgumentException("Public key required for encryption");
        }
        BigInteger modulus = this.key.getModulus();
        BigInteger exponent = this.key.getExponent();
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(ZERO, modulus.subtract(ONE), this.rnd);
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray((modulus.bitLength() + 7) / 8, bigIntegerCreateRandomInRange);
        byte[] bArrAsUnsignedByteArray2 = BigIntegers.asUnsignedByteArray((modulus.bitLength() + 7) / 8, bigIntegerCreateRandomInRange.modPow(exponent, modulus));
        System.arraycopy(bArrAsUnsignedByteArray2, 0, bArr, i, bArrAsUnsignedByteArray2.length);
        this.kdf.init(new KDFParameters(bArrAsUnsignedByteArray, null));
        byte[] bArr2 = new byte[i2];
        this.kdf.generateBytes(bArr2, 0, i2);
        return new KeyParameter(bArr2);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (!(cipherParameters instanceof RSAKeyParameters)) {
            throw new IllegalArgumentException("RSA key required");
        }
        this.key = (RSAKeyParameters) cipherParameters;
    }
}

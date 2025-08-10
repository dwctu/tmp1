package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes5.dex */
public class ECIESKeyEncapsulation implements KeyEncapsulation {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private boolean CofactorMode;
    private boolean OldCofactorMode;
    private boolean SingleHashMode;
    private DerivationFunction kdf;
    private ECKeyParameters key;
    private SecureRandom rnd;

    public ECIESKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.kdf = derivationFunction;
        this.rnd = secureRandom;
        this.CofactorMode = false;
        this.OldCofactorMode = false;
        this.SingleHashMode = false;
    }

    public ECIESKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom, boolean z, boolean z2, boolean z3) {
        this.kdf = derivationFunction;
        this.rnd = secureRandom;
        this.CofactorMode = z;
        this.OldCofactorMode = z2;
        this.SingleHashMode = z3;
    }

    public CipherParameters decrypt(byte[] bArr, int i) {
        return decrypt(bArr, 0, bArr.length, i);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public CipherParameters decrypt(byte[] bArr, int i, int i2, int i3) throws DataLengthException, IllegalArgumentException {
        ECKeyParameters eCKeyParameters = this.key;
        if (!(eCKeyParameters instanceof ECPrivateKeyParameters)) {
            throw new IllegalArgumentException("Private key required for encryption");
        }
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) eCKeyParameters;
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        ECCurve curve = parameters.getCurve();
        BigInteger n = parameters.getN();
        BigInteger h = parameters.getH();
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        ECPoint eCPointDecodePoint = curve.decodePoint(bArr2);
        if (this.CofactorMode || this.OldCofactorMode) {
            eCPointDecodePoint = eCPointDecodePoint.multiply(h);
        }
        BigInteger d = eCPrivateKeyParameters.getD();
        if (this.CofactorMode) {
            d = d.multiply(h.modInverse(n)).mod(n);
        }
        byte[] encoded = eCPointDecodePoint.multiply(d).normalize().getAffineXCoord().getEncoded();
        if (this.SingleHashMode) {
            byte[] bArr3 = new byte[encoded.length + i2];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            System.arraycopy(encoded, 0, bArr3, i2, encoded.length);
            encoded = bArr3;
        }
        this.kdf.init(new KDFParameters(encoded, null));
        byte[] bArr4 = new byte[i3];
        this.kdf.generateBytes(bArr4, 0, i3);
        return new KeyParameter(bArr4);
    }

    public CipherParameters encrypt(byte[] bArr, int i) {
        return encrypt(bArr, 0, i);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public CipherParameters encrypt(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        ECKeyParameters eCKeyParameters = this.key;
        if (!(eCKeyParameters instanceof ECPublicKeyParameters)) {
            throw new IllegalArgumentException("Public key required for encryption");
        }
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) eCKeyParameters;
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        ECCurve curve = parameters.getCurve();
        BigInteger n = parameters.getN();
        BigInteger h = parameters.getH();
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(ONE, n, this.rnd);
        ECPoint[] eCPointArr = {parameters.getG().multiply(bigIntegerCreateRandomInRange), eCPublicKeyParameters.getQ().multiply(this.CofactorMode ? bigIntegerCreateRandomInRange.multiply(h).mod(n) : bigIntegerCreateRandomInRange)};
        curve.normalizeAll(eCPointArr);
        ECPoint eCPoint = eCPointArr[0];
        ECPoint eCPoint2 = eCPointArr[1];
        byte[] encoded = eCPoint.getEncoded();
        System.arraycopy(encoded, 0, bArr, i, encoded.length);
        byte[] encoded2 = eCPoint2.getAffineXCoord().getEncoded();
        if (this.SingleHashMode) {
            byte[] bArr2 = new byte[encoded.length + encoded2.length];
            System.arraycopy(encoded, 0, bArr2, 0, encoded.length);
            System.arraycopy(encoded2, 0, bArr2, encoded.length, encoded2.length);
            encoded2 = bArr2;
        }
        this.kdf.init(new KDFParameters(encoded2, null));
        byte[] bArr3 = new byte[i2];
        this.kdf.generateBytes(bArr3, 0, i2);
        return new KeyParameter(bArr3);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (!(cipherParameters instanceof ECKeyParameters)) {
            throw new IllegalArgumentException("EC key required");
        }
        this.key = (ECKeyParameters) cipherParameters;
    }
}

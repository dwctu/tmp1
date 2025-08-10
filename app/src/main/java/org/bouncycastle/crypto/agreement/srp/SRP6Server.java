package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes5.dex */
public class SRP6Server {
    public BigInteger A;
    public BigInteger B;
    public BigInteger N;
    public BigInteger S;
    public BigInteger b;
    public Digest digest;
    public BigInteger g;
    public SecureRandom random;
    public BigInteger u;
    public BigInteger v;

    private BigInteger calculateS() {
        return this.v.modPow(this.u, this.N).multiply(this.A).mod(this.N).modPow(this.b, this.N);
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger bigIntegerValidatePublicValue = SRP6Util.validatePublicValue(this.N, bigInteger);
        this.A = bigIntegerValidatePublicValue;
        this.u = SRP6Util.calculateU(this.digest, this.N, bigIntegerValidatePublicValue, this.B);
        BigInteger bigIntegerCalculateS = calculateS();
        this.S = bigIntegerCalculateS;
        return bigIntegerCalculateS;
    }

    public BigInteger generateServerCredentials() {
        BigInteger bigIntegerCalculateK = SRP6Util.calculateK(this.digest, this.N, this.g);
        this.b = selectPrivateValue();
        BigInteger bigIntegerMod = bigIntegerCalculateK.multiply(this.v).mod(this.N).add(this.g.modPow(this.b, this.N)).mod(this.N);
        this.B = bigIntegerMod;
        return bigIntegerMod;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest, SecureRandom secureRandom) {
        this.N = bigInteger;
        this.g = bigInteger2;
        this.v = bigInteger3;
        this.random = secureRandom;
        this.digest = digest;
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.N, this.g, this.random);
    }
}

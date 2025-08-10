package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes5.dex */
public class ECMQVBasicAgreement implements BasicAgreement {
    public MQVPrivateParameters privParams;

    private ECPoint calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        BigInteger n = eCDomainParameters.getN();
        int iBitLength = (n.bitLength() + 1) / 2;
        BigInteger bigIntegerShiftLeft = ECConstants.ONE.shiftLeft(iBitLength);
        ECCurve curve = eCDomainParameters.getCurve();
        ECPoint[] eCPointArr = new ECPoint[3];
        eCPointArr[0] = ECAlgorithms.importPoint(curve, eCPublicKeyParameters == null ? eCDomainParameters.getG().multiply(eCPrivateKeyParameters2.getD()) : eCPublicKeyParameters.getQ());
        eCPointArr[1] = ECAlgorithms.importPoint(curve, eCPublicKeyParameters2.getQ());
        eCPointArr[2] = ECAlgorithms.importPoint(curve, eCPublicKeyParameters3.getQ());
        curve.normalizeAll(eCPointArr);
        ECPoint eCPoint = eCPointArr[0];
        ECPoint eCPoint2 = eCPointArr[1];
        ECPoint eCPoint3 = eCPointArr[2];
        BigInteger bigIntegerMod = eCPrivateKeyParameters.getD().multiply(eCPoint.getAffineXCoord().toBigInteger().mod(bigIntegerShiftLeft).setBit(iBitLength)).add(eCPrivateKeyParameters2.getD()).mod(n);
        BigInteger bit = eCPoint3.getAffineXCoord().toBigInteger().mod(bigIntegerShiftLeft).setBit(iBitLength);
        BigInteger bigIntegerMod2 = eCDomainParameters.getH().multiply(bigIntegerMod).mod(n);
        return ECAlgorithms.sumOfTwoMultiplies(eCPoint2, bit.multiply(bigIntegerMod2).mod(n), eCPoint3, bigIntegerMod2);
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
        ECPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
        ECPoint eCPointNormalize = calculateMqvAgreement(staticPrivateKey.getParameters(), staticPrivateKey, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey()).normalize();
        if (eCPointNormalize.isInfinity()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
        }
        return eCPointNormalize.getAffineXCoord().toBigInteger();
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters cipherParameters) {
        this.privParams = (MQVPrivateParameters) cipherParameters;
    }
}

package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

/* loaded from: classes5.dex */
public class ECUtil {
    public static BigInteger generateK(BigInteger bigInteger, SecureRandom secureRandom) {
        int iBitLength = bigInteger.bitLength();
        BigInteger bigInteger2 = new BigInteger(iBitLength, secureRandom);
        while (true) {
            if (!bigInteger2.equals(ECConstants.ZERO) && bigInteger2.compareTo(bigInteger) < 0) {
                return bigInteger2;
            }
            bigInteger2 = new BigInteger(iBitLength, secureRandom);
        }
    }
}

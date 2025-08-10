package org.jivesoftware.smack.sm;

import java.math.BigInteger;

/* loaded from: classes5.dex */
public class SMUtils {
    private static long MASK_32_BIT;

    static {
        BigInteger bigInteger = BigInteger.ONE;
        MASK_32_BIT = bigInteger.shiftLeft(32).subtract(bigInteger).longValue();
    }

    public static long calculateDelta(long j, long j2) {
        return (j - j2) & MASK_32_BIT;
    }

    public static long incrementHeight(long j) {
        return (j + 1) & MASK_32_BIT;
    }
}

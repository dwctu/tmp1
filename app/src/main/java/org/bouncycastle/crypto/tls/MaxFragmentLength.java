package org.bouncycastle.crypto.tls;

/* loaded from: classes5.dex */
public class MaxFragmentLength {
    public static short pow2_10 = 2;
    public static short pow2_11 = 3;
    public static short pow2_12 = 4;
    public static short pow2_9 = 1;

    public static boolean isValid(short s) {
        return s >= pow2_9 && s <= pow2_12;
    }
}

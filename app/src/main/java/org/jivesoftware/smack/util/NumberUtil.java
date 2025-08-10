package org.jivesoftware.smack.util;

import com.google.common.primitives.UnsignedInts;

/* loaded from: classes5.dex */
public class NumberUtil {
    public static void checkIfInUInt32Range(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("unsigned 32-bit integers can't be negative");
        }
        if (j > UnsignedInts.INT_MASK) {
            throw new IllegalArgumentException("unsigned 32-bit integers can't be greater then 2^32 - 1");
        }
    }
}

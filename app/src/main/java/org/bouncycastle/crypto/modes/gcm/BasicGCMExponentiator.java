package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class BasicGCMExponentiator implements GCMExponentiator {
    private int[] x;

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long j, byte[] bArr) {
        int[] iArrOneAsInts = GCMUtil.oneAsInts();
        if (j > 0) {
            int[] iArrClone = Arrays.clone(this.x);
            do {
                if ((1 & j) != 0) {
                    GCMUtil.multiply(iArrOneAsInts, iArrClone);
                }
                GCMUtil.multiply(iArrClone, iArrClone);
                j >>>= 1;
            } while (j > 0);
        }
        GCMUtil.asBytes(iArrOneAsInts, bArr);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] bArr) {
        this.x = GCMUtil.asInts(bArr);
    }
}

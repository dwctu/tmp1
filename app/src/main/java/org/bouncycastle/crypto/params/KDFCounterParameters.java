package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public final class KDFCounterParameters implements DerivationParameters {
    private final byte[] fixedInputData;
    private final byte[] ki;
    private final int r;

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == null) {
            throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
        }
        this.ki = Arrays.clone(bArr);
        if (bArr2 == null) {
            this.fixedInputData = new byte[0];
        } else {
            this.fixedInputData = Arrays.clone(bArr2);
        }
        if (i != 8 && i != 16 && i != 24 && i != 32) {
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        this.r = i;
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputData);
    }

    public byte[] getKI() {
        return this.ki;
    }

    public int getR() {
        return this.r;
    }
}

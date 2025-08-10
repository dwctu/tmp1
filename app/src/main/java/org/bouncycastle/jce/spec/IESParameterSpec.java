package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes5.dex */
public class IESParameterSpec implements AlgorithmParameterSpec {
    private int cipherKeySize;
    private byte[] derivation;
    private byte[] encoding;
    private int macKeySize;

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i) {
        this(bArr, bArr2, i, -1);
    }

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr != null) {
            byte[] bArr3 = new byte[bArr.length];
            this.derivation = bArr3;
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        } else {
            this.derivation = null;
        }
        if (bArr2 != null) {
            byte[] bArr4 = new byte[bArr2.length];
            this.encoding = bArr4;
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        } else {
            this.encoding = null;
        }
        this.macKeySize = i;
        this.cipherKeySize = i2;
    }

    public int getCipherKeySize() {
        return this.cipherKeySize;
    }

    public byte[] getDerivationV() {
        return this.derivation;
    }

    public byte[] getEncodingV() {
        return this.encoding;
    }

    public int getMacKeySize() {
        return this.macKeySize;
    }
}

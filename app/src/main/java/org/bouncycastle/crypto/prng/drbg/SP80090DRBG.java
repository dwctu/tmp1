package org.bouncycastle.crypto.prng.drbg;

/* loaded from: classes5.dex */
public interface SP80090DRBG {
    int generate(byte[] bArr, byte[] bArr2, boolean z);

    void reseed(byte[] bArr);
}

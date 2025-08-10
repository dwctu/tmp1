package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.K;

/* compiled from: DataBlock.java */
/* loaded from: classes3.dex */
public final class D {
    private final int a;
    private final byte[] b;

    private D(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public static D[] a(byte[] bArr, K k) {
        K.b bVarC = k.c();
        K.a[] aVarArrA = bVarC.a();
        int iA = 0;
        for (K.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        D[] dArr = new D[iA];
        int i = 0;
        for (K.a aVar2 : aVarArrA) {
            int i2 = 0;
            while (i2 < aVar2.a()) {
                int iB = aVar2.b();
                dArr[i] = new D(iB, new byte[bVarC.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = dArr[0].b.length - bVarC.b();
        int i3 = length - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            while (i6 < i) {
                dArr[i6].b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        boolean z = k.g() == 24;
        int i7 = z ? 8 : i;
        int i8 = 0;
        while (i8 < i7) {
            dArr[i8].b[i3] = bArr[i4];
            i8++;
            i4++;
        }
        int length2 = dArr[0].b.length;
        while (length < length2) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = z ? (i9 + 8) % i : i9;
                dArr[i10].b[(!z || i10 <= 7) ? length : length - 1] = bArr[i4];
                i9++;
                i4++;
            }
            length++;
        }
        if (i4 == bArr.length) {
            return dArr;
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.a;
    }

    public byte[] a() {
        return this.b;
    }
}

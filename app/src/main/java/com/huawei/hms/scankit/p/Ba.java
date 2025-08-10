package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.Ya;

/* compiled from: DataBlock.java */
/* loaded from: classes3.dex */
public final class Ba {
    private final int a;
    private final byte[] b;

    private Ba(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public static Ba[] a(byte[] bArr, Ya ya, Pa pa) throws Exception {
        if (bArr.length != ya.d()) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                throw e;
            }
        }
        Ya.b bVarA = ya.a(pa);
        Ya.a[] aVarArrA = bVarA.a();
        int iA = 0;
        for (Ya.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        Ba[] baArr = new Ba[iA];
        int i = 0;
        for (Ya.a aVar2 : aVarArrA) {
            int i2 = 0;
            while (i2 < aVar2.a()) {
                int iB = aVar2.b();
                baArr[i] = new Ba(iB, new byte[bVarA.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = baArr[0].b.length;
        int i3 = iA - 1;
        while (i3 >= 0 && baArr[i3].b.length != length) {
            i3--;
        }
        return a(baArr, bArr, length, bVarA, i, i3 + 1);
    }

    public int b() {
        return this.a;
    }

    private static Ba[] a(Ba[] baArr, byte[] bArr, int i, Ya.b bVar, int i2, int i3) {
        int iB = i - bVar.b();
        int i4 = 0;
        for (int i5 = 0; i5 < iB; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                baArr[i6].b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        int i7 = i3;
        while (i7 < i2) {
            baArr[i7].b[iB] = bArr[i4];
            i7++;
            i4++;
        }
        int length = baArr[0].b.length;
        while (iB < length) {
            int i8 = 0;
            while (i8 < i2) {
                int i9 = i8 < i3 ? iB : iB + 1;
                if (i8 >= 0) {
                    try {
                        if (i8 < baArr.length && com.huawei.hms.scankit.util.b.a(baArr[i8].b, i9) && com.huawei.hms.scankit.util.b.a(bArr, i4)) {
                            baArr[i8].b[i9] = bArr[i4];
                            i8++;
                            i4++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw e;
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            iB++;
        }
        return baArr;
    }

    public byte[] a() {
        return this.b;
    }
}

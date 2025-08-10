package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: BarcodeMatrix.java */
/* renamed from: com.huawei.hms.scankit.p.yc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0420yc {
    private final zc[] a;
    private int b;
    private final int c;
    private final int d;

    public C0420yc(int i, int i2) {
        zc[] zcVarArr = new zc[i];
        this.a = zcVarArr;
        int length = zcVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.a[i3] = new zc(((i2 + 4) * 17) + 1);
        }
        this.d = i2 * 17;
        this.c = i;
        this.b = -1;
    }

    public zc a() {
        try {
            int i = this.b;
            if (i >= 0) {
                zc[] zcVarArr = this.a;
                if (i < zcVarArr.length) {
                    return zcVarArr[i];
                }
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    public void b() {
        this.b++;
    }

    public byte[][] a(int i, int i2) {
        int i3 = this.c * i2;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, i3, this.d * i);
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.a[i4 / i2].a(i);
        }
        return bArr;
    }
}

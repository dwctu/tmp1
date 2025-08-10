package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: BinaryBitmap.java */
/* renamed from: com.huawei.hms.scankit.p.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0409w {
    private final AbstractC0405v a;
    private C0417y b;

    public C0409w(AbstractC0405v abstractC0405v) throws Exception {
        if (abstractC0405v != null) {
            this.a = abstractC0405v;
        } else {
            try {
                throw new IllegalArgumentException("Binarizer must be non-null.");
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public C0413x a(int i, int i2) throws C0309a {
        int i3;
        int iE = e();
        if (iE < 45) {
            throw C0309a.a();
        }
        C0413x c0413x = new C0413x(iE);
        byte[] bArr = new byte[iE];
        a().c().a(i, bArr);
        int[] iArr = new int[iE];
        int[] iArr2 = new int[iE];
        iArr[0] = bArr[0] & 255;
        iArr2[0] = iArr[0] * iArr[0];
        for (int i4 = 1; i4 < iE; i4++) {
            iArr[i4] = iArr[i4 - 1] + (bArr[i4] & 255);
        }
        if (i2 != 0) {
            return a(45, iE, iArr, iArr2, bArr, 22);
        }
        int i5 = 23;
        while (true) {
            i3 = iE - 22;
            if (i5 >= i3) {
                break;
            }
            if ((bArr[i5] & 255) + 5 < (iArr[i5 + 22] - iArr[(i5 - 22) - 1]) / 45) {
                c0413x.d(i5);
            }
            i5++;
        }
        if (c0413x.a(23)) {
            c0413x.c(0, 23);
        }
        if (c0413x.a(i3 - 1)) {
            c0413x.c(i3, iE);
        }
        return c0413x;
    }

    public C0417y b() throws C0309a {
        if (this.b == null) {
            this.b = this.a.a();
        }
        return this.b;
    }

    public int c() {
        return this.a.b();
    }

    public byte[] d() {
        return this.a.c().b();
    }

    public int e() {
        return this.a.d();
    }

    private C0413x a(int i, int i2, int[] iArr, int[] iArr2, byte[] bArr, int i3) {
        int i4;
        C0413x c0413x = new C0413x(i2);
        for (int i5 = 1; i5 < i2; i5++) {
            iArr2[i5] = iArr2[i5 - 1] + ((bArr[i5] & 255) * (bArr[i5] & 255));
        }
        int i6 = i3 + 1;
        int i7 = i6;
        while (true) {
            i4 = i2 - i3;
            if (i7 >= i4) {
                break;
            }
            double d = iArr[i7 + i3] - iArr[(i7 - i3) - 1];
            double d2 = i;
            if ((bArr[i7] & 255) <= (d / d2) * ((0.5f * (Math.sqrt(((iArr2[r6] - iArr2[r8]) - ((d * d) / d2)) / (i - 1)) / 127)) + 1.0d)) {
                c0413x.d(i7);
            }
            i7++;
        }
        if (c0413x.a(i6)) {
            c0413x.c(0, i6);
        }
        if (c0413x.a(i4 - 1)) {
            c0413x.c(i4, i2);
        }
        return c0413x;
    }

    public C0413x a(int i, C0413x c0413x) throws C0309a {
        return this.a.a(i, c0413x);
    }

    public void a(C0417y c0417y) {
        this.b = c0417y;
    }

    public C0409w a(int i, int i2, int i3, int i4) {
        return new C0409w(this.a.a(this.a.c().a(i, i2, i3, i4)));
    }

    public AbstractC0405v a() {
        return this.a;
    }
}

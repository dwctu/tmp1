package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: CodaBarReader.java */
/* loaded from: classes3.dex */
public final class O extends Y {
    public static final char[] a = "0123456789-$:/.+ABCD".toCharArray();
    public static final int[] b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] c = {'A', 'B', 'C', 'D'};
    private final StringBuilder d = new StringBuilder(20);
    private int[] e = new int[80];
    private int f = 0;
    private int g;

    private int b() throws C0309a {
        for (int i = 1; i < this.f; i += 2) {
            int iB = b(i);
            if (iB != -1 && a(c, a[iB])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.e[i3];
                }
                if (i == 1 || this.e[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw C0309a.a();
    }

    private void c(int i) throws C0309a {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.d.length() - 1;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = b[this.d.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) * 2);
                iArr[i7] = iArr[i7] + this.e[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            fArr2[i9] = ((iArr[i8] / iArr2[i8]) + (iArr[i9] / iArr2[i9])) / 2.0f;
            fArr[i8] = fArr2[i9];
            fArr[i9] = ((iArr[i9] * 2.0f) + 1.5f) / iArr2[i9];
        }
        loop3: while (true) {
            int i10 = b[this.d.charAt(i2)];
            for (int i11 = 6; i11 >= 0; i11--) {
                int i12 = (i11 & 1) + ((i10 & 1) * 2);
                float f = this.e[i + i11];
                if (f < fArr2[i12] || f > fArr[i12]) {
                    break loop3;
                }
                i10 >>= 1;
            }
            if (i2 >= length) {
                return;
            }
            i += 8;
            i2++;
        }
        throw C0309a.a();
    }

    @Override // com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        Arrays.fill(this.e, 0);
        a(c0413x);
        int[] iArrA = a();
        int i2 = iArrA[0];
        int i3 = iArrA[1];
        for (int i4 = 0; i4 < this.d.length(); i4++) {
            StringBuilder sb = this.d;
            sb.setCharAt(i4, a[sb.charAt(i4)]);
        }
        char cCharAt = this.d.charAt(0);
        char[] cArr = c;
        if (!a(cArr, cCharAt)) {
            throw C0309a.a();
        }
        StringBuilder sb2 = this.d;
        if (!a(cArr, sb2.charAt(sb2.length() - 1))) {
            throw C0309a.a();
        }
        if (this.d.length() <= 3) {
            throw C0309a.a();
        }
        int i5 = this.g;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 += this.e[i6];
        }
        float f = i5;
        while (i2 < i3 - 1) {
            i5 += this.e[i2];
            i2++;
        }
        float f2 = i;
        return new com.huawei.hms.scankit.aiscan.common.x(this.d.toString(), null, new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z(f, f2), new com.huawei.hms.scankit.aiscan.common.z(i5, f2)}, BarcodeFormat.CODABAR);
    }

    private int b(int i) {
        int i2 = i + 7;
        if (i2 >= this.f) {
            return -1;
        }
        int[] iArr = this.e;
        HashSet hashSet = new HashSet();
        for (int i3 = i; i3 < i2; i3++) {
            hashSet.add(Integer.valueOf(iArr[i3]));
        }
        Iterator it = hashSet.iterator();
        int i4 = 0;
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Integer) it.next()).intValue();
        }
        if (hashSet.size() > 0) {
            int size = iIntValue / hashSet.size();
            int i5 = 128;
            int i6 = 0;
            for (int i7 = 0; i7 < 7; i7++) {
                i5 >>= 1;
                if (iArr[i + i7] > size) {
                    i6 |= i5;
                }
            }
            while (true) {
                int[] iArr2 = b;
                if (i4 >= iArr2.length) {
                    break;
                }
                if (iArr2[i4] == i6) {
                    return i4;
                }
                i4++;
            }
        }
        return -1;
    }

    private int[] a() throws C0309a {
        int iB = b();
        this.d.setLength(0);
        int i = iB;
        do {
            int iB2 = b(i);
            if (iB2 != -1) {
                this.d.append((char) iB2);
                i += 8;
                if (this.d.length() > 1 && a(c, a[iB2])) {
                    break;
                }
            } else {
                throw C0309a.a();
            }
        } while (i < this.f);
        int i2 = this.e[i - 1];
        int i3 = 0;
        for (int i4 = -8; i4 < -1; i4++) {
            i3 += this.e[i + i4];
        }
        if (i < this.f && i2 < i3 / 2) {
            throw C0309a.a();
        }
        c(iB);
        return new int[]{iB, i};
    }

    private void a(C0413x c0413x) throws C0309a {
        int i = 0;
        this.f = 0;
        int iC = c0413x.c(0);
        this.g = iC;
        int iD = c0413x.d();
        if (iC < iD) {
            boolean z = true;
            while (iC < iD) {
                if (c0413x.a(iC) != z) {
                    i++;
                } else {
                    a(i);
                    z = !z;
                    i = 1;
                }
                iC++;
            }
            a(i);
            return;
        }
        throw C0309a.a();
    }

    private void a(int i) throws C0309a {
        try {
            int[] iArr = this.e;
            int i2 = this.f;
            iArr[i2] = i;
            int i3 = i2 + 1;
            this.f = i3;
            if (i3 >= iArr.length) {
                int[] iArr2 = new int[i3 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.e = iArr2;
            }
        } catch (NumberFormatException unused) {
            throw C0309a.a();
        }
    }

    public static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}

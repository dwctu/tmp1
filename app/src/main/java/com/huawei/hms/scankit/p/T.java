package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: EAN13Reader.java */
/* loaded from: classes3.dex */
public final class T extends AbstractC0335da {
    public static final int[] h = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private String j = "";
    private final int[] i = new int[4];

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(int i, int i2, C0413x c0413x) {
        return c0413x.a(i2, (i2 - i) + i2, false, false);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public int a(C0413x c0413x, int[] iArr, StringBuilder sb) throws C0309a {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iD = c0413x.d();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 6 && i < iD; i3++) {
            int iA = AbstractC0335da.a(c0413x, iArr2, i, AbstractC0335da.e);
            sb.append((char) ((iA % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (iA >= 10) {
                i2 |= 1 << (5 - i3);
            }
        }
        a(sb, i2);
        this.j = sb.substring(0, 1);
        int i5 = AbstractC0335da.a(c0413x, i, true, AbstractC0335da.b)[1];
        for (int i6 = 0; i6 < 6 && i5 < iD; i6++) {
            sb.append((char) (AbstractC0335da.a(c0413x, iArr2, i5, AbstractC0335da.d) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        if (a(sb)) {
            return i5;
        }
        throw C0309a.a();
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public BarcodeFormat a() {
        return BarcodeFormat.EAN_13;
    }

    private static void a(StringBuilder sb, int i) throws C0309a {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == h[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw C0309a.a();
    }

    private static boolean a(StringBuilder sb) {
        int iCharAt = sb.charAt(sb.length() - 1) - '0';
        int iCharAt2 = 0;
        for (int i = 0; i < sb.length() - 1; i++) {
            iCharAt2 += i % 2 == 0 ? sb.charAt(i) - '0' : (sb.charAt(i) - '0') * 3;
        }
        return (iCharAt2 + iCharAt) % 10 == 0;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(int[] iArr, int[] iArr2) throws C0309a {
        int iRound = (int) Math.round((iArr2[1] - iArr[0]) / (((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0])) / 6.0d));
        return this.j.equals("0") ? ((double) Math.abs(iRound + (-95))) <= 18.05d || ((double) Math.abs(iRound + (-113))) <= 21.47d : ((double) Math.abs(iRound + (-95))) <= 18.05d;
    }
}

package com.huawei.hms.scankit.p;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.base.Ascii;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code93Reader.java */
/* loaded from: classes3.dex */
public final class S extends Y {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    public static final int[] b;
    private static final int c;
    private final StringBuilder d = new StringBuilder(20);
    private final int[] e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, TypedValues.CycleType.TYPE_WAVE_OFFSET, TypedValues.CycleType.TYPE_EASING, 418, 404, TypedValues.CycleType.TYPE_VISIBILITY, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, Constants.STATUS_NOT_ACCEPTABLE, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        b = iArr;
        c = iArr[47];
    }

    private static int b(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = Math.round((iArr[i4] * 9.0f) / i);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    @Override // com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        int iB = c0413x.b(a(c0413x)[1]);
        int iD = c0413x.d();
        int[] iArr = this.e;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.d;
        sb.setLength(0);
        while (true) {
            Y.a(c0413x, iB, iArr);
            int iB2 = b(iArr);
            if (iB2 < 0) {
                throw C0309a.a();
            }
            char cA = a(iB2);
            sb.append(cA);
            int i2 = iB;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iB3 = c0413x.b(i2);
            if (cA == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (iB3 == iD || !c0413x.a(iB3)) {
                    throw C0309a.a();
                }
                if (sb.length() < 2) {
                    throw C0309a.a();
                }
                a(sb);
                sb.setLength(sb.length() - 2);
                float f = i;
                return new com.huawei.hms.scankit.aiscan.common.x(b(sb), null, new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z(r14[0], f), new com.huawei.hms.scankit.aiscan.common.z(iB + ((i4 * 10) / 9), f)}, BarcodeFormat.CODE_93);
            }
            iB = iB3;
        }
    }

    private static String b(CharSequence charSequence) throws C0309a {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 'a' || cCharAt > 'd') {
                sb.append(cCharAt);
            } else if (i < length - 1) {
                i++;
                sb.append(a(cCharAt, charSequence.charAt(i)));
            } else {
                throw C0309a.a();
            }
            i++;
        }
        return sb.toString();
    }

    private int[] a(C0413x c0413x) throws C0309a {
        int iD = c0413x.d();
        int iB = c0413x.b(0);
        Arrays.fill(this.e, 0);
        int[] iArr = this.e;
        int length = iArr.length;
        int i = iB;
        boolean z = false;
        int i2 = 0;
        while (iB < iD) {
            if (c0413x.a(iB) != z) {
                if (i2 >= 0 && i2 < iArr.length) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    throw C0309a.a();
                }
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (b(iArr) == c) {
                        return new int[]{i, iB};
                    }
                    i += iArr[0] + iArr[1];
                    int i3 = i2 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i2] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                z = !z;
            }
            iB++;
        }
        throw C0309a.a();
    }

    private static char a(int i) throws C0309a {
        int i2 = 0;
        while (true) {
            int[] iArr = b;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return a[i2];
                }
                i2++;
            } else {
                throw C0309a.a();
            }
        }
    }

    private static char a(char c2, char c3) throws C0309a {
        int i;
        switch (c2) {
            case 'a':
                if (c3 >= 'A' && c3 <= 'Z') {
                    i = c3 - '@';
                    break;
                } else {
                    throw C0309a.a();
                }
            case 'b':
                if (c3 >= 'A' && c3 <= 'E') {
                    i = c3 - '&';
                    break;
                } else if (c3 >= 'F' && c3 <= 'J') {
                    i = c3 - 11;
                    break;
                } else if (c3 >= 'K' && c3 <= 'O') {
                    i = c3 + 16;
                    break;
                } else if (c3 >= 'P' && c3 <= 'S') {
                    i = c3 + '+';
                    break;
                } else {
                    if (c3 < 'T' || c3 > 'Z') {
                        throw C0309a.a();
                    }
                    return Ascii.MAX;
                }
                break;
            case 'c':
                if (c3 >= 'A' && c3 <= 'O') {
                    i = c3 - ' ';
                    break;
                } else {
                    if (c3 == 'Z') {
                        return ':';
                    }
                    throw C0309a.a();
                }
            case 'd':
                if (c3 >= 'A' && c3 <= 'Z') {
                    i = c3 + ' ';
                    break;
                } else {
                    throw C0309a.a();
                }
            default:
                return (char) 0;
        }
        return (char) i;
    }

    private static void a(CharSequence charSequence) throws C0309a {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i, int i2) throws C0309a {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != a[iIndexOf % 47]) {
            throw C0309a.a();
        }
    }
}

package com.huawei.hms.scankit.p;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.common.base.Ascii;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Arrays;
import java.util.Map;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: Code39Reader.java */
/* loaded from: classes3.dex */
public final class Q extends Y {
    public static final int[] a = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 400, 208, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 388, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 162, 138, 42};
    private final boolean b;
    private final boolean c;
    private final StringBuilder d;
    private final int[] e;

    public Q() {
        this(false);
    }

    private static boolean b(int[] iArr) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 < i) {
                i = i3;
            }
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2 / i > 6;
    }

    private static int c(int[] iArr) {
        int length = iArr.length;
        if (b(iArr)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i6 |= 1 << ((length - 1) - i7);
                    i4++;
                    i5 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if (i10 * 2 >= i5) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    @Override // com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        int[] iArr = this.e;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.d;
        sb.setLength(0);
        int[] iArrA = a(c0413x, iArr);
        int iB = c0413x.b(iArrA[1]);
        int iD = c0413x.d();
        while (true) {
            Y.a(c0413x, iB, iArr);
            int iC = c(iArr);
            if (iC < 0) {
                throw C0309a.a();
            }
            char cA = a(iC);
            sb.append(cA);
            int i2 = iB;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iB2 = c0413x.b(i2);
            if (cA == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (iB2 - iB) - i4;
                if (iB2 == iD || i6 * 5 >= i4) {
                    return a(sb, iArrA, iB, i4, i);
                }
                throw C0309a.a();
            }
            iB = iB2;
        }
    }

    public Q(boolean z) {
        this(z, false);
    }

    public Q(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
        this.d = new StringBuilder(20);
        this.e = new int[9];
    }

    private com.huawei.hms.scankit.aiscan.common.x a(StringBuilder sb, int[] iArr, int i, int i2, int i3) throws C0309a {
        String string;
        if (this.b) {
            int length = sb.length() - 1;
            int iIndexOf = 0;
            for (int i4 = 0; i4 < length; i4++) {
                iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.d.charAt(i4));
            }
            if (sb.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                sb.setLength(length);
            } else {
                throw C0309a.a();
            }
        }
        if (sb.length() != 0) {
            if (this.c) {
                string = a(sb);
            } else {
                string = sb.toString();
            }
            float f = i3;
            return new com.huawei.hms.scankit.aiscan.common.x(string, null, new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z(iArr[0], f), new com.huawei.hms.scankit.aiscan.common.z(i + i2, f)}, BarcodeFormat.CODE_39);
        }
        throw C0309a.a();
    }

    private static int[] a(C0413x c0413x, int[] iArr) throws C0309a {
        int iD = c0413x.d();
        int iB = c0413x.b(0);
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
                    if (c(iArr) == 148 && c0413x.a(Math.max(0, i - ((iB - i) / 5)), i, false, true)) {
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
            int[] iArr = a;
            if (i2 >= iArr.length) {
                if (i == 148) {
                    return '*';
                }
                throw C0309a.a();
            }
            if (iArr[i2] == i) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i2);
            }
            i2++;
        }
    }

    private static String a(CharSequence charSequence) throws C0309a {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '+' && cCharAt != '$' && cCharAt != '%' && cCharAt != '/') {
                sb.append(cCharAt);
            } else {
                i++;
                sb.append(a(cCharAt, charSequence.charAt(i)));
            }
            i++;
        }
        return sb.toString();
    }

    private static char a(char c, char c2) throws C0309a {
        int i;
        if (c != '$') {
            if (c != '%') {
                if (c != '+') {
                    if (c == '/') {
                        if (c2 < 'A' || c2 > 'O') {
                            if (c2 == 'Z') {
                                return ':';
                            }
                            throw C0309a.a();
                        }
                        i = c2 - ' ';
                    }
                    return (char) 0;
                }
                if (c2 < 'A' || c2 > 'Z') {
                    throw C0309a.a();
                }
                i = c2 + ' ';
            } else if (c2 >= 'A' && c2 <= 'E') {
                i = c2 - '&';
            } else if (c2 >= 'F' && c2 <= 'J') {
                i = c2 - 11;
            } else if (c2 >= 'K' && c2 <= 'O') {
                i = c2 + 16;
            } else {
                if (c2 < 'P' || c2 > 'T') {
                    if (c2 != 'U') {
                        if (c2 == 'V') {
                            return '@';
                        }
                        if (c2 == 'W') {
                            return '`';
                        }
                        if (c2 == 'X' || c2 == 'Y' || c2 == 'Z') {
                            return Ascii.MAX;
                        }
                        throw C0309a.a();
                    }
                    return (char) 0;
                }
                i = c2 + '+';
            }
        } else {
            if (c2 < 'A' || c2 > 'Z') {
                throw C0309a.a();
            }
            i = c2 - '@';
        }
        return (char) i;
    }
}

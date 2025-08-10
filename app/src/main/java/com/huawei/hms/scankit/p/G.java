package com.huawei.hms.scankit.p;

import com.broadcom.bt.util.io.FilenameUtils;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.codec.net.RFC1522Codec;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes3.dex */
public final class G {
    private static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO};
    private static final char[] b;
    private static final char[] c;
    private static final char[] d;
    private static final char[] e;

    /* compiled from: DecodedBitStreamParser.java */
    public enum a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        UPPER_ENCODE
    }

    static {
        char[] cArr = {'!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', SignatureImpl.SEP, FilenameUtils.EXTENSION_SEPARATOR, IOUtils.DIR_SEPARATOR_UNIX, ':', ';', Typography.less, '=', Typography.greater, RFC1522Codec.SEP, '@', '[', IOUtils.DIR_SEPARATOR_WINDOWS, ']', '^', '_'};
        b = cArr;
        c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        d = cArr;
        e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, MessageFormatter.DELIM_START, '|', MessageFormatter.DELIM_STOP, '~', Ascii.MAX};
    }

    public static C0313e a(byte[] bArr, Map<EnumC0312d, ?> map) throws Exception {
        C0421z c0421z = new C0421z(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        a aVarA = a.ASCII_ENCODE;
        do {
            a aVar = a.ASCII_ENCODE;
            if (aVarA == aVar) {
                aVarA = a(c0421z, sb, sb2);
            } else {
                int i = F.a[aVarA.ordinal()];
                if (i == 1) {
                    b(c0421z, sb);
                } else if (i == 2) {
                    d(c0421z, sb);
                } else if (i == 3) {
                    a(c0421z, sb);
                } else if (i == 4) {
                    c(c0421z, sb);
                } else {
                    if (i != 5) {
                        throw C0309a.a("AIScanException");
                    }
                    a(c0421z, sb, arrayList);
                }
                aVarA = aVar;
            }
            if (aVarA == a.PAD_ENCODE) {
                break;
            }
        } while (c0421z.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        int length = sb.length();
        byte[] bArr2 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = (byte) sb.charAt(i2);
        }
        try {
            String str = new String(bArr2, com.huawei.hms.scankit.aiscan.common.B.a(bArr2, map));
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new C0313e(bArr, str, arrayList, null);
        } catch (UnsupportedEncodingException unused) {
            throw C0309a.a();
        }
    }

    private static void b(C0421z c0421z, StringBuilder sb) throws C0309a {
        int iA;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (c0421z.a() != 8 && (iA = c0421z.a(8)) != 254) {
            a(iA, c0421z.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArrB = b(sb, i, iArr[i2], z);
                i = iArrB[0];
                z = iArrB[1] == 1;
            }
            if (c0421z.a() <= 0) {
                return;
            }
        }
    }

    private static void c(C0421z c0421z, StringBuilder sb) throws Exception {
        while (c0421z.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int iA = c0421z.a(6);
                if (iA == 31) {
                    int iB = 8 - c0421z.b();
                    if (iB != 8) {
                        c0421z.a(iB);
                        return;
                    }
                    return;
                }
                if ((iA & 32) == 0) {
                    iA |= 64;
                }
                sb.append((char) iA);
            }
            if (c0421z.a() <= 0) {
                return;
            }
        }
    }

    private static void d(C0421z c0421z, StringBuilder sb) throws C0309a {
        int iA;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (c0421z.a() != 8 && (iA = c0421z.a(8)) != 254) {
            a(iA, c0421z.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArrA = a(sb, i, iArr[i2], z);
                i = iArrA[0];
                z = iArrA[1] == 1;
            }
            if (c0421z.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private static int[] b(StringBuilder sb, int i, int i2, boolean z) throws C0309a {
        ?? r9;
        boolean z2;
        if (i != 0) {
            if (i == 1) {
                if (z) {
                    i2 += 128;
                }
                sb.append((char) i2);
            } else if (i == 2) {
                char[] cArr = b;
                if (i2 < cArr.length) {
                    char c2 = cArr[i2];
                    if (z) {
                        c2 = (char) (c2 + 128);
                    }
                    sb.append(c2);
                    z2 = false;
                } else if (i2 == 27) {
                    sb.append((char) 29);
                    z2 = z;
                } else {
                    if (i2 != 30) {
                        throw C0309a.a("AIScanException");
                    }
                    z2 = true;
                }
                i = 0;
                r9 = z2;
            } else if (i == 3) {
                sb.append((char) (z ? i2 + 224 : i2 + 96));
            } else {
                throw C0309a.a("AIScanException");
            }
            i = 0;
            r9 = 0;
        } else if (i2 < 3) {
            i = i2 + 1;
            r9 = z;
        } else {
            char[] cArr2 = a;
            if (i2 < cArr2.length) {
                char c3 = cArr2[i2];
                if (z) {
                    c3 = (char) (c3 + 128);
                }
                sb.append(c3);
                r9 = 0;
            } else {
                throw C0309a.a("AIScanException");
            }
        }
        return new int[]{i, r9};
    }

    private static a a(C0421z c0421z, StringBuilder sb, StringBuilder sb2) throws Exception {
        boolean z = false;
        do {
            int iA = c0421z.a(8);
            if (iA == 0) {
                throw C0309a.a("AIScanException");
            }
            if (iA <= 128) {
                if (z) {
                    iA += 128;
                }
                sb.append((char) (iA - 1));
                return a.ASCII_ENCODE;
            }
            if (iA == 129) {
                return a.PAD_ENCODE;
            }
            if (iA <= 229) {
                int i = iA - 130;
                if (i < 10) {
                    sb.append('0');
                }
                sb.append(i);
            } else {
                a aVarA = a(iA, sb, sb2, c0421z);
                if (aVarA != null) {
                    if (aVarA != a.UPPER_ENCODE) {
                        return aVarA;
                    }
                    z = true;
                }
            }
        } while (c0421z.a() > 0);
        return a.ASCII_ENCODE;
    }

    private static a a(int i, StringBuilder sb, StringBuilder sb2, C0421z c0421z) throws C0309a {
        switch (i) {
            case 230:
                return a.C40_ENCODE;
            case 231:
                return a.BASE256_ENCODE;
            case 232:
                sb.append((char) 29);
                return null;
            case 233:
            case 234:
            case 241:
                return null;
            case 235:
                return a.UPPER_ENCODE;
            case 236:
                sb.append("[)>\u001e05\u001d");
                sb2.insert(0, "\u001e\u0004");
                return null;
            case 237:
                sb.append("[)>\u001e06\u001d");
                sb2.insert(0, "\u001e\u0004");
                return null;
            case 238:
                return a.ANSIX12_ENCODE;
            case 239:
                return a.TEXT_ENCODE;
            case PsExtractor.VIDEO_STREAM_MASK /* 240 */:
                return a.EDIFACT_ENCODE;
            default:
                if (i == 254 && c0421z.a() == 0) {
                    return null;
                }
                throw C0309a.a("AIScanException");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private static int[] a(StringBuilder sb, int i, int i2, boolean z) throws C0309a {
        ?? r9;
        boolean z2;
        if (i != 0) {
            if (i == 1) {
                if (z) {
                    i2 = (char) (i2 + 128);
                }
                sb.append(i2);
            } else if (i == 2) {
                char[] cArr = d;
                if (i2 < cArr.length) {
                    char c2 = cArr[i2];
                    if (z) {
                        c2 = (char) (c2 + 128);
                    }
                    sb.append(c2);
                    z2 = false;
                } else if (i2 == 27) {
                    sb.append((char) 29);
                    z2 = z;
                } else {
                    if (i2 != 30) {
                        throw C0309a.a("AIScanException");
                    }
                    z2 = true;
                }
                i = 0;
                r9 = z2;
            } else if (i == 3) {
                char[] cArr2 = e;
                if (i2 < cArr2.length) {
                    char c3 = cArr2[i2];
                    if (z) {
                        c3 = (char) (c3 + 128);
                    }
                    sb.append(c3);
                } else {
                    throw C0309a.a("AIScanException");
                }
            } else {
                throw C0309a.a("AIScanException");
            }
            i = 0;
            r9 = 0;
        } else if (i2 < 3) {
            i = i2 + 1;
            r9 = z;
        } else {
            char[] cArr3 = c;
            if (i2 < cArr3.length) {
                char c4 = cArr3[i2];
                if (z) {
                    c4 = (char) (c4 + 128);
                }
                sb.append(c4);
                r9 = 0;
            } else {
                throw C0309a.a("AIScanException");
            }
        }
        return new int[]{i, r9};
    }

    private static void a(C0421z c0421z, StringBuilder sb) throws C0309a {
        int iA;
        int[] iArr = new int[3];
        while (c0421z.a() != 8 && (iA = c0421z.a(8)) != 254) {
            a(iA, c0421z.a(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append(Typography.greater);
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else if (i2 < 40) {
                    sb.append((char) (i2 + 51));
                } else {
                    throw C0309a.a("AIScanException");
                }
            }
            if (c0421z.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void a(C0421z c0421z, StringBuilder sb, Collection<byte[]> collection) throws C0309a {
        int iC = c0421z.c() + 1;
        int i = iC + 1;
        int iA = a(c0421z.a(8), iC);
        if (iA == 0) {
            iA = c0421z.a() / 8;
        } else if (iA >= 250) {
            iA = ((iA - 249) * 250) + a(c0421z.a(8), i);
            i++;
        }
        if (iA >= 0) {
            byte[] bArr = new byte[iA];
            int i2 = 0;
            while (i2 < iA) {
                if (c0421z.a() >= 8) {
                    bArr[i2] = (byte) a(c0421z.a(8), i);
                    i2++;
                    i++;
                } else {
                    throw C0309a.a("AIScanException");
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: " + e2);
            }
        }
        throw C0309a.a("AIScanException");
    }

    private static int a(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}

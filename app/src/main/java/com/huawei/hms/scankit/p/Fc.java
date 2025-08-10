package com.huawei.hms.scankit.p;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.primitives.SignedBytes;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.EnumC0311c;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.apache.commons.codec.net.URLCodec;

/* compiled from: PDF417HighLevelEncoder.java */
/* loaded from: classes3.dex */
public final class Fc {
    private static final byte[] c;
    private static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, URLCodec.ESCAPE_CHAR, ExifInterface.START_CODE, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] b = {59, 60, 62, SignedBytes.MAX_POWER_OF_TWO, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, ExifInterface.START_CODE, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] d = new byte[128];
    private static final Charset e = StandardCharsets.ISO_8859_1;

    static {
        byte[] bArr = new byte[128];
        c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i2];
            if (b2 > 0) {
                c[b2] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(d, (byte) -1);
        while (true) {
            byte[] bArr3 = b;
            if (i >= bArr3.length) {
                return;
            }
            byte b3 = bArr3[i];
            if (b3 > 0) {
                d[b3] = (byte) i;
            }
            i++;
        }
    }

    public static String a(String str, Ac ac, Charset charset) throws WriterException {
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = e;
        } else if (e.equals(charset)) {
            com.huawei.hms.scankit.util.a.a("PDF417", "else");
        } else {
            EnumC0311c enumC0311cA = EnumC0311c.a(charset.name());
            if (enumC0311cA != null) {
                a(enumC0311cA.a(), sb);
            }
        }
        int length = str.length();
        int i = Ec.a[ac.ordinal()];
        if (i == 1) {
            a(str, 0, length, sb, 0);
        } else if (i == 2) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, 0, bytes.length, 1, sb);
        } else if (i != 3) {
            int i2 = 0;
            int i3 = 0;
            loop0: while (true) {
                int iA = 0;
                while (i2 < length) {
                    int iA2 = a(str, i2);
                    if (iA2 >= 13) {
                        sb.append((char) 902);
                        a(str, i2, iA2, sb);
                        i2 += iA2;
                        i3 = 2;
                    } else {
                        int iB = b(str, i2);
                        if (iB >= 5 || iA2 == length) {
                            if (i3 != 0) {
                                sb.append((char) 900);
                                i3 = 0;
                                iA = 0;
                            }
                            iA = a(str, i2, iB, sb, iA);
                            i2 += iB;
                        } else {
                            int iA3 = a(str, i2, charset);
                            if (iA3 == 0) {
                                iA3 = 1;
                            }
                            int i4 = iA3 + i2;
                            byte[] bytes2 = str.substring(i2, i4).getBytes(charset);
                            if (bytes2.length == 1 && i3 == 0) {
                                a(bytes2, 0, 1, 0, sb);
                                i2 = i4;
                            } else {
                                a(bytes2, 0, bytes2.length, i3, sb);
                                i2 = i4;
                                i3 = 1;
                            }
                        }
                    }
                }
                break loop0;
            }
        } else {
            sb.append((char) 902);
            a(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static boolean a(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    private static int b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && c(cCharAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    cCharAt = charSequence.charAt(i2);
                }
            }
            if (i3 >= 13) {
                return (i2 - i) - i3;
            }
            if (i3 <= 0) {
                if (!f(charSequence.charAt(i2))) {
                    break;
                }
                i2++;
            }
        }
        return i2 - i;
    }

    private static boolean b(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean c(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean d(char c2) {
        try {
            byte[] bArr = c;
            if (com.huawei.hms.scankit.util.b.a(bArr, (int) c2)) {
                return bArr[c2] != -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    private static boolean e(char c2) {
        try {
            if (com.huawei.hms.scankit.util.b.a(c, (int) c2)) {
                return d[c2] != -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    private static boolean f(char c2) {
        return c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= '~');
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00f6 A[EDGE_INSN: B:76:0x00f6->B:55:0x00f6 BREAK  A[LOOP:0: B:3:0x0011->B:93:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0011 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Fc.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void a(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append((char) 913);
        } else if (i2 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + (bArr[i4 + i5] & 255);
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) (j % 900);
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    private static void a(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int iMin = Math.min(44, i2 - i3);
            if (str.length() > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append('1');
                int i4 = i + i3;
                sb3.append(str.substring(i4, i4 + iMin));
                BigInteger bigInteger = new BigInteger(sb3.toString());
                do {
                    sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                    bigInteger = bigInteger.divide(bigIntegerValueOf);
                } while (!bigInteger.equals(bigIntegerValueOf2));
            }
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += iMin;
        }
    }

    private static int a(CharSequence charSequence, int i) {
        return C0353hc.a(charSequence, i);
    }

    private static int a(String str, int i, Charset charset) throws WriterException {
        int i2;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i3 = i;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && c(cCharAt) && (i2 = i3 + (i4 = i4 + 1)) < length) {
                cCharAt = str.charAt(i2);
            }
            if (i4 >= 13) {
                return i3 - i;
            }
            char cCharAt2 = str.charAt(i3);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new WriterException("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i3++;
        }
        return i3 - i;
    }

    private static void a(int i, StringBuilder sb) throws WriterException {
        if (i >= 0 && i < 900) {
            sb.append((char) 927);
            sb.append((char) i);
            return;
        }
        if (i < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i / TypedValues.Custom.TYPE_INT) - 1));
            sb.append((char) (i % TypedValues.Custom.TYPE_INT));
        } else if (i < 811800) {
            sb.append((char) 925);
            sb.append((char) (810900 - i));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i);
        }
    }
}

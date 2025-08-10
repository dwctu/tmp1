package com.huawei.hms.scankit.p;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: DecodedBitStreamParser.java */
/* renamed from: com.huawei.hms.scankit.p.ka, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0363ka {
    private static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] c;

    /* compiled from: DecodedBitStreamParser.java */
    /* renamed from: com.huawei.hms.scankit.p.ka$a */
    public enum a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r6.length() == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r8 != java.nio.charset.StandardCharsets.ISO_8859_1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        r9 = r6.length();
        r2 = new byte[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (r0 >= r9) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        r2[r0] = (byte) r6.charAt(r0);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        r9 = new com.huawei.hms.scankit.aiscan.common.C0313e(null, new java.lang.String(r2, com.huawei.hms.scankit.aiscan.common.B.a(r2, r11)), null, r10);
        r9.a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        throw com.huawei.hms.scankit.aiscan.common.C0309a.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        r9 = new com.huawei.hms.scankit.aiscan.common.C0313e(null, r6.toString(), null, r10);
        r9.a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
    
        throw com.huawei.hms.scankit.aiscan.common.C0309a.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.scankit.aiscan.common.C0313e a(int[] r9, java.lang.String r10, java.util.Map<com.huawei.hms.scankit.aiscan.common.EnumC0312d, ?> r11) throws com.huawei.hms.scankit.aiscan.common.C0309a {
        /*
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r0 = r9.length
            r1 = 2
            int r0 = r0 * 2
            r6.<init>(r0)
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = 1
            r2 = r9[r2]
            com.huawei.hms.scankit.p.wa r7 = new com.huawei.hms.scankit.p.wa
            r7.<init>()
            r8 = r0
            r1 = r2
            r3 = 2
        L16:
            r0 = 0
            r2 = r9[r0]
            if (r3 > r2) goto L51
            r2 = r9[r0]
            if (r3 != r2) goto L26
            int r2 = r6.length()
            if (r2 <= 0) goto L26
            goto L51
        L26:
            r0 = 927(0x39f, float:1.299E-42)
            if (r1 != r0) goto L3c
            int r0 = r3 + 1
            r1 = r9[r3]
            com.huawei.hms.scankit.aiscan.common.c r1 = com.huawei.hms.scankit.aiscan.common.EnumC0311c.a(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            r8 = r1
            goto L44
        L3c:
            r0 = r6
            r2 = r9
            r4 = r8
            r5 = r7
            int r0 = a(r0, r1, r2, r3, r4, r5)
        L44:
            int r1 = r9.length
            if (r0 >= r1) goto L4c
            int r3 = r0 + 1
            r1 = r9[r0]
            goto L16
        L4c:
            com.huawei.hms.scankit.aiscan.common.a r9 = com.huawei.hms.scankit.aiscan.common.C0309a.a()
            throw r9
        L51:
            int r9 = r6.length()
            if (r9 == 0) goto L92
            java.nio.charset.Charset r9 = java.nio.charset.StandardCharsets.ISO_8859_1
            r1 = 0
            if (r8 != r9) goto L85
            int r9 = r6.length()
            byte[] r2 = new byte[r9]
        L62:
            if (r0 >= r9) goto L6e
            char r3 = r6.charAt(r0)
            byte r3 = (byte) r3
            r2[r0] = r3
            int r0 = r0 + 1
            goto L62
        L6e:
            java.lang.String r9 = com.huawei.hms.scankit.aiscan.common.B.a(r2, r11)
            java.lang.String r11 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L80
            r11.<init>(r2, r9)     // Catch: java.io.UnsupportedEncodingException -> L80
            com.huawei.hms.scankit.aiscan.common.e r9 = new com.huawei.hms.scankit.aiscan.common.e
            r9.<init>(r1, r11, r1, r10)
            r9.a(r7)
            return r9
        L80:
            com.huawei.hms.scankit.aiscan.common.a r9 = com.huawei.hms.scankit.aiscan.common.C0309a.a()
            throw r9
        L85:
            com.huawei.hms.scankit.aiscan.common.e r9 = new com.huawei.hms.scankit.aiscan.common.e
            java.lang.String r11 = r6.toString()
            r9.<init>(r1, r11, r1, r10)
            r9.a(r7)
            return r9
        L92:
            com.huawei.hms.scankit.aiscan.common.a r9 = com.huawei.hms.scankit.aiscan.common.C0309a.a()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.C0363ka.a(int[], java.lang.String, java.util.Map):com.huawei.hms.scankit.aiscan.common.e");
    }

    private static boolean a(int i) {
        return i == 901 || i == 924 || i == 902 || i == 928 || i == 923 || i == 922;
    }

    private static int b(int[] iArr, int i, StringBuilder sb) throws C0309a {
        int[] iArr2 = new int[(iArr[0] - i) * 2];
        int[] iArr3 = new int[(iArr[0] - i) * 2];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 == 900) {
                iArr2[i2] = 900;
                i2++;
            } else if (i4 == 913) {
                iArr2[i2] = 913;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            } else {
                if (!a(i4)) {
                    throw C0309a.a();
                }
                i = i3 - 1;
                z = true;
            }
            i = i3;
        }
        a(iArr2, iArr3, i2, sb);
        return i;
    }

    private static a[] c(StringBuilder sb, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0309a {
        a aVar3;
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 97);
        } else {
            int i = iArr2[1];
            if (i == 900) {
                aVar = a.ALPHA;
            } else if (i != 913) {
                switch (i) {
                    case 26:
                        iArr2[2] = 32;
                        break;
                    case 27:
                        aVar3 = a.ALPHA_SHIFT;
                        aVar2 = aVar;
                        aVar = aVar3;
                        break;
                    case 28:
                        aVar = a.MIXED;
                        break;
                    case 29:
                        aVar3 = a.PUNCT_SHIFT;
                        aVar2 = aVar;
                        aVar = aVar3;
                        break;
                    default:
                        throw C0309a.a();
                }
            } else {
                sb.append((char) iArr[iArr2[0]]);
            }
        }
        return new a[]{aVar, aVar2};
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.huawei.hms.scankit.p.C0363ka.a[] d(java.lang.StringBuilder r5, int[] r6, com.huawei.hms.scankit.p.C0363ka.a r7, com.huawei.hms.scankit.p.C0363ka.a r8, int[] r9) throws com.huawei.hms.scankit.aiscan.common.C0309a {
        /*
            r0 = 1
            r1 = r9[r0]
            r2 = 0
            r3 = 2
            r4 = 25
            if (r1 >= r4) goto L12
            char[] r5 = com.huawei.hms.scankit.p.C0363ka.b
            r6 = r9[r0]
            char r5 = r5[r6]
            r9[r3] = r5
            goto L3f
        L12:
            r1 = r9[r0]
            r4 = 900(0x384, float:1.261E-42)
            if (r1 == r4) goto L3d
            r4 = 913(0x391, float:1.28E-42)
            if (r1 == r4) goto L34
            switch(r1) {
                case 25: goto L31;
                case 26: goto L2c;
                case 27: goto L29;
                case 28: goto L3d;
                case 29: goto L24;
                default: goto L1f;
            }
        L1f:
            com.huawei.hms.scankit.aiscan.common.a r5 = com.huawei.hms.scankit.aiscan.common.C0309a.a()
            throw r5
        L24:
            com.huawei.hms.scankit.p.ka$a r5 = com.huawei.hms.scankit.p.C0363ka.a.PUNCT_SHIFT
            r8 = r7
            r7 = r5
            goto L3f
        L29:
            com.huawei.hms.scankit.p.ka$a r7 = com.huawei.hms.scankit.p.C0363ka.a.LOWER
            goto L3f
        L2c:
            r5 = 32
            r9[r3] = r5
            goto L3f
        L31:
            com.huawei.hms.scankit.p.ka$a r7 = com.huawei.hms.scankit.p.C0363ka.a.PUNCT
            goto L3f
        L34:
            r9 = r9[r2]
            r6 = r6[r9]
            char r6 = (char) r6
            r5.append(r6)
            goto L3f
        L3d:
            com.huawei.hms.scankit.p.ka$a r7 = com.huawei.hms.scankit.p.C0363ka.a.ALPHA
        L3f:
            com.huawei.hms.scankit.p.ka$a[] r5 = new com.huawei.hms.scankit.p.C0363ka.a[r3]
            r5[r2] = r7
            r5[r0] = r8
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.C0363ka.d(java.lang.StringBuilder, int[], com.huawei.hms.scankit.p.ka$a, com.huawei.hms.scankit.p.ka$a, int[]):com.huawei.hms.scankit.p.ka$a[]");
    }

    private static a[] e(StringBuilder sb, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0309a {
        if (iArr2[1] < 29) {
            iArr2[2] = a[iArr2[1]];
        } else {
            int i = iArr2[1];
            if (i == 29 || i == 900) {
                aVar = a.ALPHA;
            } else {
                if (i != 913) {
                    throw C0309a.a();
                }
                sb.append((char) iArr[iArr2[0]]);
            }
        }
        return new a[]{aVar, aVar2};
    }

    private static a[] f(StringBuilder sb, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0309a {
        a aVar3;
        if (iArr2[1] < 29) {
            iArr2[2] = a[iArr2[1]];
        } else {
            int i = iArr2[1];
            if (i == 29 || i == 900) {
                aVar3 = a.ALPHA;
                return new a[]{aVar3, aVar2};
            }
            if (i != 913) {
                throw C0309a.a();
            }
            sb.append((char) iArr[iArr2[0]]);
        }
        aVar3 = aVar2;
        return new a[]{aVar3, aVar2};
    }

    private static a[] b(StringBuilder sb, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0309a {
        a aVar3;
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 65);
        } else {
            int i = iArr2[1];
            if (i != 26) {
                if (i == 900) {
                    aVar3 = a.ALPHA;
                    return new a[]{aVar3, aVar2};
                }
                throw C0309a.a();
            }
            iArr2[2] = 32;
        }
        aVar3 = aVar2;
        return new a[]{aVar3, aVar2};
    }

    private static int a(StringBuilder sb, int i, int[] iArr, int i2, Charset charset, C0410wa c0410wa) throws C0309a {
        if (i == 913) {
            int i3 = i2 + 1;
            sb.append((char) iArr[i2]);
            return i3;
        }
        if (i != 928) {
            switch (i) {
                case TypedValues.Custom.TYPE_INT /* 900 */:
                    return b(iArr, i2, sb);
                case 901:
                    break;
                case TypedValues.Custom.TYPE_COLOR /* 902 */:
                    return a(iArr, i2, sb);
                default:
                    switch (i) {
                        case 922:
                        case 923:
                            throw C0309a.a();
                        case 924:
                            break;
                        case 925:
                            return i2 + 1;
                        case 926:
                            return i2 + 2;
                        default:
                            return b(iArr, i2 - 1, sb);
                    }
            }
            return a(i, iArr, charset, i2, sb);
        }
        return a(iArr, i2, c0410wa);
    }

    public static int a(int[] iArr, int i, C0410wa c0410wa) throws C0309a {
        int i2 = 0;
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            while (i2 < 2) {
                iArr2[i2] = iArr[i];
                i2++;
                i++;
            }
            try {
                c0410wa.c(Integer.parseInt(a(iArr2, 2)));
                StringBuilder sb = new StringBuilder();
                int iB = b(iArr, i, sb);
                c0410wa.b(sb.toString());
                int i3 = iArr[iB] == 923 ? iB + 1 : -1;
                a(iB, iArr, c0410wa);
                if (i3 != -1) {
                    int i4 = iB - i3;
                    if (c0410wa.a()) {
                        i4--;
                    }
                    c0410wa.a(Arrays.copyOfRange(iArr, i3, i4 + i3));
                }
                return iB;
            } catch (Exception unused) {
                throw C0309a.a();
            }
        }
        throw C0309a.a();
    }

    private static void a(int i, int[] iArr, C0410wa c0410wa) throws C0309a {
        while (i < iArr[0]) {
            if (iArr[i] == 923) {
                int i2 = i + 1;
                if (iArr[i2] == 0) {
                    StringBuilder sb = new StringBuilder();
                    i = b(iArr, i2 + 1, sb);
                    c0410wa.c(sb.toString());
                } else if (iArr[i2] == 3) {
                    StringBuilder sb2 = new StringBuilder();
                    i = b(iArr, i2 + 1, sb2);
                    c0410wa.d(sb2.toString());
                } else if (iArr[i2] == 4) {
                    StringBuilder sb3 = new StringBuilder();
                    i = b(iArr, i2 + 1, sb3);
                    c0410wa.a(sb3.toString());
                } else if (iArr[i2] == 1) {
                    StringBuilder sb4 = new StringBuilder();
                    i = a(iArr, i2 + 1, sb4);
                    c0410wa.b(Integer.parseInt(sb4.toString()));
                } else if (iArr[i2] == 2) {
                    StringBuilder sb5 = new StringBuilder();
                    i = a(iArr, i2 + 1, sb5);
                    c0410wa.b(Long.parseLong(sb5.toString()));
                } else if (iArr[i2] == 6) {
                    StringBuilder sb6 = new StringBuilder();
                    i = a(iArr, i2 + 1, sb6);
                    c0410wa.a(Integer.parseInt(sb6.toString()));
                } else if (iArr[i2] == 5) {
                    StringBuilder sb7 = new StringBuilder();
                    i = a(iArr, i2 + 1, sb7);
                    c0410wa.a(Long.parseLong(sb7.toString()));
                } else {
                    throw C0309a.a();
                }
            } else if (iArr[i] == 922) {
                i++;
                c0410wa.a(true);
            } else {
                throw C0309a.a();
            }
        }
    }

    private static void a(int[] iArr, int[] iArr2, int i, StringBuilder sb) throws C0309a {
        a aVar = a.ALPHA;
        a aVar2 = aVar;
        int i2 = 0;
        while (i2 < i) {
            int[] iArr3 = {i2, iArr[i2], 0};
            a[] aVarArrA = {aVar, aVar2};
            switch (C0359ja.a[aVar.ordinal()]) {
                case 1:
                    aVarArrA = a(sb, iArr2, aVar, aVar2, iArr3);
                    break;
                case 2:
                    aVarArrA = c(sb, iArr2, aVar, aVar2, iArr3);
                    break;
                case 3:
                    aVarArrA = d(sb, iArr2, aVar, aVar2, iArr3);
                    break;
                case 4:
                    aVarArrA = e(sb, iArr2, aVar, aVar2, iArr3);
                    break;
                case 5:
                    aVarArrA = b(sb, iArr2, aVar, aVar2, iArr3);
                    break;
                case 6:
                    aVarArrA = f(sb, iArr2, aVar, aVar2, iArr3);
                    break;
            }
            aVar = aVarArrA[0];
            aVar2 = aVarArrA[1];
            int i3 = iArr3[0];
            int i4 = iArr3[1];
            char c2 = (char) iArr3[2];
            if (c2 != 0) {
                sb.append(c2);
            }
            i2 = 1 + i3;
        }
    }

    private static a[] a(StringBuilder sb, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0309a {
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 65);
        } else {
            int i = iArr2[1];
            if (i == 900) {
                aVar = a.ALPHA;
            } else if (i != 913) {
                switch (i) {
                    case 26:
                        iArr2[2] = 32;
                        break;
                    case 27:
                        aVar = a.LOWER;
                        break;
                    case 28:
                        aVar = a.MIXED;
                        break;
                    case 29:
                        aVar2 = aVar;
                        aVar = a.PUNCT_SHIFT;
                        break;
                    default:
                        throw C0309a.a();
                }
            } else {
                sb.append((char) iArr[iArr2[0]]);
            }
        }
        return new a[]{aVar, aVar2};
    }

    private static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) throws C0309a {
        int iA;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        long j = 0;
        boolean z = false;
        if (i == 901) {
            int[] iArr2 = new int[6];
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            while (i4 < iArr[0] && !z) {
                int i6 = i3 + 1;
                iArr2[i3] = i5;
                j = (j * 900) + i5;
                int i7 = i4 + 1;
                i5 = iArr[i4];
                if (i5 != 928) {
                    switch (i5) {
                        case TypedValues.Custom.TYPE_INT /* 900 */:
                        case 901:
                        case TypedValues.Custom.TYPE_COLOR /* 902 */:
                            break;
                        default:
                            switch (i5) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    if (i6 % 5 != 0 || i6 <= 0) {
                                        i4 = i7;
                                        i3 = i6;
                                        break;
                                    } else {
                                        for (int i8 = 0; i8 < 6; i8++) {
                                            byteArrayOutputStream.write((byte) (j >> ((5 - i8) * 8)));
                                        }
                                        j = 0;
                                        i4 = i7;
                                        i3 = 0;
                                        break;
                                    }
                                    break;
                            }
                    }
                }
                i4 = i7 - 1;
                z = true;
                i3 = i6;
            }
            if (i4 == iArr[0] && i5 < 900) {
                iArr2[i3] = i5;
                i3++;
            }
            for (int i9 = 0; i9 < i3; i9++) {
                byteArrayOutputStream.write((byte) iArr2[i9]);
            }
            iA = i4;
        } else {
            iA = i == 924 ? a(i2, iArr, false, 0, 0L, byteArrayOutputStream) : i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return iA;
    }

    private static int a(int i, int[] iArr, boolean z, int i2, long j, ByteArrayOutputStream byteArrayOutputStream) throws C0309a {
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                i2++;
                j = (j * 900) + i4;
                i = i3;
            } else {
                if (i4 != 928) {
                    switch (i4) {
                        default:
                            switch (i4) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    throw C0309a.a();
                            }
                        case TypedValues.Custom.TYPE_INT /* 900 */:
                        case 901:
                        case TypedValues.Custom.TYPE_COLOR /* 902 */:
                            i = i3 - 1;
                            z = true;
                            break;
                    }
                }
                i = i3 - 1;
                z = true;
            }
            if (i2 % 5 == 0 && i2 > 0) {
                for (int i5 = 0; i5 < 6; i5++) {
                    byteArrayOutputStream.write((byte) (j >> ((5 - i5) * 8)));
                }
                j = 0;
                i2 = 0;
            }
        }
        return i;
    }

    private static int a(int[] iArr, int i, StringBuilder sb) throws C0309a {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
            } else {
                if (i4 != 900 && i4 != 901 && i4 != 928) {
                    switch (i4) {
                        case 922:
                        case 923:
                        case 924:
                            break;
                        default:
                            throw C0309a.a();
                    }
                }
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                sb.append(a(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String a(int[] iArr, int i) throws C0309a {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw C0309a.a();
    }
}

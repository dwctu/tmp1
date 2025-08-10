package okhttp3.internal.http;

import com.koushikdutta.async.http.AsyncHttpHead;
import dc.ad4;
import dc.dc4;
import dc.ic4;
import dc.jc4;
import dc.nd4;
import dc.qc4;
import dc.qd4;
import dc.rc4;
import dc.yc4;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.internal.Util;

/* loaded from: classes5.dex */
public final class HttpHeaders {
    private static final qd4 QUOTED_STRING_DELIMITERS = qd4.h("\"\\");
    private static final qd4 TOKEN_DELIMITERS = qd4.h("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(ad4 ad4Var) {
        return contentLength(ad4Var.q());
    }

    public static boolean hasBody(ad4 ad4Var) {
        if (ad4Var.L().g().equals(AsyncHttpHead.METHOD)) {
            return false;
        }
        int iF = ad4Var.f();
        return (((iF >= 100 && iF < 200) || iF == 204 || iF == 304) && contentLength(ad4Var) == -1 && !"chunked".equalsIgnoreCase(ad4Var.m(com.google.common.net.HttpHeaders.TRANSFER_ENCODING))) ? false : true;
    }

    public static boolean hasVaryAll(ad4 ad4Var) {
        return hasVaryAll(ad4Var.q());
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x007d, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x007d, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseChallengeHeader(java.util.List<dc.dc4> r8, dc.nd4 r9) {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            skipWhitespaceAndCommas(r9)
            java.lang.String r1 = readToken(r9)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = skipWhitespaceAndCommas(r9)
            java.lang.String r3 = readToken(r9)
            if (r3 != 0) goto L2c
            boolean r9 = r9.N()
            if (r9 != 0) goto L1f
            return
        L1f:
            dc.dc4 r9 = new dc.dc4
            java.util.Map r0 = java.util.Collections.emptyMap()
            r9.<init>(r1, r0)
            r8.add(r9)
            return
        L2c:
            r4 = 61
            int r5 = skipAll(r9, r4)
            boolean r6 = skipWhitespaceAndCommas(r9)
            if (r2 != 0) goto L60
            if (r6 != 0) goto L40
            boolean r2 = r9.N()
            if (r2 == 0) goto L60
        L40:
            dc.dc4 r2 = new dc.dc4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            java.lang.String r3 = repeat(r4, r5)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L60:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = skipAll(r9, r4)
            int r5 = r5 + r6
        L6a:
            if (r3 != 0) goto L7b
            java.lang.String r3 = readToken(r9)
            boolean r5 = skipWhitespaceAndCommas(r9)
            if (r5 == 0) goto L77
            goto L7d
        L77:
            int r5 = skipAll(r9, r4)
        L7b:
            if (r5 != 0) goto L88
        L7d:
            dc.dc4 r4 = new dc.dc4
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L88:
            r6 = 1
            if (r5 <= r6) goto L8c
            return
        L8c:
            boolean r6 = skipWhitespaceAndCommas(r9)
            if (r6 == 0) goto L93
            return
        L93:
            boolean r6 = r9.N()
            if (r6 != 0) goto La8
            r6 = 0
            byte r6 = r9.q(r6)
            r7 = 34
            if (r6 != r7) goto La8
            java.lang.String r6 = readQuotedString(r9)
            goto Lac
        La8:
            java.lang.String r6 = readToken(r9)
        Lac:
            if (r6 != 0) goto Laf
            return
        Laf:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lb8
            return
        Lb8:
            boolean r3 = skipWhitespaceAndCommas(r9)
            if (r3 != 0) goto Lc5
            boolean r3 = r9.N()
            if (r3 != 0) goto Lc5
            return
        Lc5:
            r3 = r0
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.parseChallengeHeader(java.util.List, dc.nd4):void");
    }

    public static List<dc4> parseChallenges(qc4 qc4Var, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < qc4Var.h(); i++) {
            if (str.equalsIgnoreCase(qc4Var.e(i))) {
                nd4 nd4Var = new nd4();
                nd4Var.u0(qc4Var.j(i));
                parseChallengeHeader(arrayList, nd4Var);
            }
        }
        return arrayList;
    }

    public static int parseSeconds(String str, int i) throws NumberFormatException {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    private static String readQuotedString(nd4 nd4Var) {
        if (nd4Var.readByte() != 34) {
            throw new IllegalArgumentException();
        }
        nd4 nd4Var2 = new nd4();
        while (true) {
            long jK = nd4Var.k(QUOTED_STRING_DELIMITERS);
            if (jK == -1) {
                return null;
            }
            if (nd4Var.q(jK) == 34) {
                nd4Var2.write(nd4Var, jK);
                nd4Var.readByte();
                return nd4Var2.V();
            }
            if (nd4Var.f0() == jK + 1) {
                return null;
            }
            nd4Var2.write(nd4Var, jK);
            nd4Var.readByte();
            nd4Var2.write(nd4Var, 1L);
        }
    }

    private static String readToken(nd4 nd4Var) {
        try {
            long jK = nd4Var.k(TOKEN_DELIMITERS);
            if (jK == -1) {
                jK = nd4Var.f0();
            }
            if (jK != 0) {
                return nd4Var.X(jK);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public static void receiveHeaders(jc4 jc4Var, rc4 rc4Var, qc4 qc4Var) {
        if (jc4Var == jc4.a) {
            return;
        }
        List<ic4> listK = ic4.k(rc4Var, qc4Var);
        if (listK.isEmpty()) {
            return;
        }
        jc4Var.saveFromResponse(rc4Var, listK);
    }

    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    private static int skipAll(nd4 nd4Var, byte b) {
        int i = 0;
        while (!nd4Var.N() && nd4Var.q(0L) == b) {
            i++;
            nd4Var.readByte();
        }
        return i;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    private static boolean skipWhitespaceAndCommas(nd4 nd4Var) {
        boolean z = false;
        while (!nd4Var.N()) {
            byte bQ = nd4Var.q(0L);
            if (bQ != 44) {
                if (bQ != 32 && bQ != 9) {
                    break;
                }
                nd4Var.readByte();
            } else {
                nd4Var.readByte();
                z = true;
            }
        }
        return z;
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private static Set<String> varyFields(ad4 ad4Var) {
        return varyFields(ad4Var.q());
    }

    public static qc4 varyHeaders(ad4 ad4Var) {
        return varyHeaders(ad4Var.y().L().e(), ad4Var.q());
    }

    public static boolean varyMatches(ad4 ad4Var, qc4 qc4Var, yc4 yc4Var) {
        for (String str : varyFields(ad4Var)) {
            if (!Objects.equals(qc4Var.k(str), yc4Var.d(str))) {
                return false;
            }
        }
        return true;
    }

    public static long contentLength(qc4 qc4Var) {
        return stringToLong(qc4Var.c(com.google.common.net.HttpHeaders.CONTENT_LENGTH));
    }

    public static boolean hasVaryAll(qc4 qc4Var) {
        return varyFields(qc4Var).contains("*");
    }

    public static Set<String> varyFields(qc4 qc4Var) {
        Set<String> setEmptySet = Collections.emptySet();
        int iH = qc4Var.h();
        for (int i = 0; i < iH; i++) {
            if (com.google.common.net.HttpHeaders.VARY.equalsIgnoreCase(qc4Var.e(i))) {
                String strJ = qc4Var.j(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strJ.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static qc4 varyHeaders(qc4 qc4Var, qc4 qc4Var2) {
        Set<String> setVaryFields = varyFields(qc4Var2);
        if (setVaryFields.isEmpty()) {
            return Util.EMPTY_HEADERS;
        }
        qc4.a aVar = new qc4.a();
        int iH = qc4Var.h();
        for (int i = 0; i < iH; i++) {
            String strE = qc4Var.e(i);
            if (setVaryFields.contains(strE)) {
                aVar.a(strE, qc4Var.j(i));
            }
        }
        return aVar.f();
    }
}

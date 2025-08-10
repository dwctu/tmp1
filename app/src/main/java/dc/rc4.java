package dc;

import com.broadcom.bt.util.io.IOUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import org.apache.commons.codec.language.bm.ResourceConstants;
import org.apache.commons.codec.net.RFC1522Codec;

/* compiled from: HttpUrl.java */
/* loaded from: classes5.dex */
public final class rc4 {
    public static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final List<String> f;
    public final List<String> g;
    public final String h;
    public final String i;

    /* compiled from: HttpUrl.java */
    public static final class a {
        public String a;
        public String d;
        public final List<String> f;
        public List<String> g;
        public String h;
        public String b = "";
        public String c = "";
        public int e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        public static String e(String str, int i, int i2) {
            return Util.canonicalizeHost(rc4.w(str, i, i2, false));
        }

        public static int n(String str, int i, int i2) throws NumberFormatException {
            int i3;
            try {
                i3 = Integer.parseInt(rc4.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }

        public static int r(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        public static int x(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int y(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public a a(String str) {
            Objects.requireNonNull(str, "encodedPathSegment == null");
            s(str, 0, str.length(), false, true);
            return this;
        }

        public a b(String str, String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(rc4.b(str, " \"'<>#&=", true, false, true, true));
            this.g.add(str2 != null ? rc4.b(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public a c(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(rc4.b(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.g.add(str2 != null ? rc4.b(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        public rc4 d() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d != null) {
                return new rc4(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int f() {
            int i = this.e;
            return i != -1 ? i : rc4.e(this.a);
        }

        public a g(String str) {
            Objects.requireNonNull(str, "encodedPath == null");
            if (str.startsWith("/")) {
                v(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException("unexpected encodedPath: " + str);
        }

        public a h(String str) {
            this.g = str != null ? rc4.D(rc4.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a i(String str) {
            this.h = str != null ? rc4.b(str, "", false, false, false, false) : null;
            return this;
        }

        public a j(String str) {
            Objects.requireNonNull(str, "host == null");
            String strE = e(str, 0, str.length());
            if (strE != null) {
                this.d = strE;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final boolean k(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public final boolean l(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a m(rc4 rc4Var, String str) throws NumberFormatException {
            int iDelimiterOffset;
            int i;
            int iSkipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int iSkipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, iSkipLeadingAsciiWhitespace, str.length());
            int iX = x(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            if (iX != -1) {
                if (str.regionMatches(true, iSkipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.a = "https";
                    iSkipLeadingAsciiWhitespace += 6;
                } else {
                    if (!str.regionMatches(true, iSkipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iX) + "'");
                    }
                    this.a = "http";
                    iSkipLeadingAsciiWhitespace += 5;
                }
            } else {
                if (rc4Var == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.a = rc4Var.a;
            }
            int iY = y(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            char c = RFC1522Codec.SEP;
            char c2 = '#';
            if (iY >= 2 || rc4Var == null || !rc4Var.a.equals(this.a)) {
                int i2 = iSkipLeadingAsciiWhitespace + iY;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(str, i2, iSkipTrailingAsciiWhitespace, "@/\\?#");
                    char cCharAt = iDelimiterOffset != iSkipTrailingAsciiWhitespace ? str.charAt(iDelimiterOffset) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c2 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c) {
                        break;
                    }
                    if (cCharAt == '@') {
                        if (z) {
                            i = iDelimiterOffset;
                            this.c += "%40" + rc4.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(str, i2, iDelimiterOffset, ':');
                            i = iDelimiterOffset;
                            String strA = rc4.a(str, i2, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strA = this.b + "%40" + strA;
                            }
                            this.b = strA;
                            if (iDelimiterOffset2 != i) {
                                this.c = rc4.a(str, iDelimiterOffset2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c = RFC1522Codec.SEP;
                    c2 = '#';
                }
                int iR = r(str, i2, iDelimiterOffset);
                int i3 = iR + 1;
                if (i3 < iDelimiterOffset) {
                    this.d = e(str, i2, iR);
                    int iN = n(str, i3, iDelimiterOffset);
                    this.e = iN;
                    if (iN == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, iDelimiterOffset) + Typography.quote);
                    }
                } else {
                    this.d = e(str, i2, iR);
                    this.e = rc4.e(this.a);
                }
                if (this.d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, iR) + Typography.quote);
                }
                iSkipLeadingAsciiWhitespace = iDelimiterOffset;
            } else {
                this.b = rc4Var.k();
                this.c = rc4Var.g();
                this.d = rc4Var.d;
                this.e = rc4Var.e;
                this.f.clear();
                this.f.addAll(rc4Var.i());
                if (iSkipLeadingAsciiWhitespace == iSkipTrailingAsciiWhitespace || str.charAt(iSkipLeadingAsciiWhitespace) == '#') {
                    h(rc4Var.j());
                }
            }
            int iDelimiterOffset3 = Util.delimiterOffset(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace, "?#");
            v(str, iSkipLeadingAsciiWhitespace, iDelimiterOffset3);
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = Util.delimiterOffset(str, iDelimiterOffset3, iSkipTrailingAsciiWhitespace, '#');
                this.g = rc4.D(rc4.a(str, iDelimiterOffset3 + 1, iDelimiterOffset4, " \"'<>#", true, false, true, true, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '#') {
                this.h = rc4.a(str, 1 + iDelimiterOffset3, iSkipTrailingAsciiWhitespace, "", true, false, false, false, null);
            }
            return this;
        }

        public a o(String str) {
            Objects.requireNonNull(str, "password == null");
            this.c = rc4.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public final void p() {
            if (!this.f.remove(r0.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
            } else {
                this.f.set(r0.size() - 1, "");
            }
        }

        public a q(int i) {
            if (i > 0 && i <= 65535) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public final void s(String str, int i, int i2, boolean z, boolean z2) {
            String strA = rc4.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (k(strA)) {
                return;
            }
            if (l(strA)) {
                p();
                return;
            }
            if (this.f.get(r11.size() - 1).isEmpty()) {
                this.f.set(r11.size() - 1, strA);
            } else {
                this.f.add(strA);
            }
            if (z) {
                this.f.add("");
            }
        }

        public a t() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, rc4.b(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, rc4.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = rc4.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append(ResourceConstants.CMT);
            }
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.d);
                    sb.append(']');
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.a != null) {
                int iF = f();
                String str3 = this.a;
                if (str3 == null || iF != rc4.e(str3)) {
                    sb.append(':');
                    sb.append(iF);
                }
            }
            rc4.u(sb, this.f);
            if (this.g != null) {
                sb.append(RFC1522Codec.SEP);
                rc4.p(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        public a u(int i) {
            this.f.remove(i);
            if (this.f.isEmpty()) {
                this.f.add("");
            }
            return this;
        }

        public final void v(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                List<String> list = this.f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = Util.delimiterOffset(str, i3, i2, "/\\");
                boolean z = i < i2;
                s(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        public a w(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.a = "https";
            }
            return this;
        }

        public a z(String str) {
            Objects.requireNonNull(str, "username == null");
            this.b = rc4.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    public rc4(a aVar) {
        this.a = aVar.a;
        this.b = x(aVar.b, false);
        this.c = x(aVar.c, false);
        this.d = aVar.d;
        this.e = aVar.f();
        this.f = y(aVar.f, false);
        List<String> list = aVar.g;
        this.g = list != null ? y(list, true) : null;
        String str = aVar.h;
        this.h = str != null ? x(str, false) : null;
        this.i = aVar.toString();
    }

    public static boolean A(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && Util.decodeHexDigit(str.charAt(i + 1)) != -1 && Util.decodeHexDigit(str.charAt(i3)) != -1;
    }

    public static List<String> D(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && z4)) {
                nd4 nd4Var = new nd4();
                nd4Var.v0(str, i, iCharCount);
                d(nd4Var, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return nd4Var.V();
            }
            if (str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z || (z2 && !A(str, iCharCount, i2)))) || (iCodePointAt == 43 && z3))) {
                nd4 nd4Var2 = new nd4();
                nd4Var2.v0(str, i, iCharCount);
                d(nd4Var2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return nd4Var2.V();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i, i2);
    }

    public static String b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    public static String c(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    public static void d(nd4 nd4Var, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        nd4 nd4Var2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    nd4Var.u0(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !A(str, i, i2)))))) {
                    if (nd4Var2 == null) {
                        nd4Var2 = new nd4();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        nd4Var2.w0(iCodePointAt);
                    } else {
                        nd4Var2.s0(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!nd4Var2.N()) {
                        int i3 = nd4Var2.readByte() & 255;
                        nd4Var.m0(37);
                        char[] cArr = j;
                        nd4Var.m0(cArr[(i3 >> 4) & 15]);
                        nd4Var.m0(cArr[i3 & 15]);
                    }
                } else {
                    nd4Var.w0(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static int e(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static rc4 m(String str) throws NumberFormatException {
        a aVar = new a();
        aVar.m(null, str);
        return aVar.d();
    }

    public static void p(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static rc4 s(String str) {
        try {
            return m(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void u(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(list.get(i));
        }
    }

    public static String w(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                nd4 nd4Var = new nd4();
                nd4Var.v0(str, i, i3);
                z(nd4Var, str, i3, i2, z);
                return nd4Var.V();
            }
        }
        return str.substring(i, i2);
    }

    public static String x(String str, boolean z) {
        return w(str, 0, str.length(), z);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void z(dc.nd4 r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = okhttp3.internal.Util.decodeHexDigit(r2)
            char r3 = r6.charAt(r1)
            int r3 = okhttp3.internal.Util.decodeHexDigit(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.m0(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.m0(r1)
            goto L3c
        L39:
            r5.w0(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.rc4.z(dc.nd4, java.lang.String, int, int, boolean):void");
    }

    public int B() {
        return this.e;
    }

    public String C() {
        if (this.g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        p(sb, this.g);
        return sb.toString();
    }

    public String E() {
        a aVarR = r("/...");
        aVarR.z("");
        aVarR.o("");
        return aVarR.d().toString();
    }

    public rc4 F(String str) {
        a aVarR = r(str);
        if (aVarR != null) {
            return aVarR.d();
        }
        return null;
    }

    public String G() {
        return this.a;
    }

    public URI H() {
        a aVarQ = q();
        aVarQ.t();
        String string = aVarQ.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof rc4) && ((rc4) obj).i.equals(this.i);
    }

    public String f() {
        if (this.h == null) {
            return null;
        }
        return this.i.substring(this.i.indexOf(35) + 1);
    }

    public String g() {
        if (this.c.isEmpty()) {
            return "";
        }
        return this.i.substring(this.i.indexOf(58, this.a.length() + 3) + 1, this.i.indexOf(64));
    }

    public String h() {
        int iIndexOf = this.i.indexOf(47, this.a.length() + 3);
        String str = this.i;
        return this.i.substring(iIndexOf, Util.delimiterOffset(str, iIndexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public List<String> i() {
        int iIndexOf = this.i.indexOf(47, this.a.length() + 3);
        String str = this.i;
        int iDelimiterOffset = Util.delimiterOffset(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iDelimiterOffset) {
            int i = iIndexOf + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.i, i, iDelimiterOffset, IOUtils.DIR_SEPARATOR_UNIX);
            arrayList.add(this.i.substring(i, iDelimiterOffset2));
            iIndexOf = iDelimiterOffset2;
        }
        return arrayList;
    }

    public String j() {
        if (this.g == null) {
            return null;
        }
        int iIndexOf = this.i.indexOf(63) + 1;
        String str = this.i;
        return this.i.substring(iIndexOf, Util.delimiterOffset(str, iIndexOf, str.length(), '#'));
    }

    public String k() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        return this.i.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public String l() {
        return this.h;
    }

    public String n() {
        return this.d;
    }

    public boolean o() {
        return this.a.equals("https");
    }

    public a q() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = k();
        aVar.c = g();
        aVar.d = this.d;
        aVar.e = this.e != e(this.a) ? this.e : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.h(j());
        aVar.h = f();
        return aVar;
    }

    public a r(String str) {
        try {
            a aVar = new a();
            aVar.m(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public List<String> t() {
        return this.f;
    }

    public String toString() {
        return this.i;
    }

    public int v() {
        return this.f.size();
    }

    public final List<String> y(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? x(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }
}

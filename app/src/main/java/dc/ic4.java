package dc;

import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

/* compiled from: Cookie.java */
/* loaded from: classes5.dex */
public final class ic4 {
    public static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* compiled from: Cookie.java */
    public static final class a {
        public String a;
        public String b;
        public String d;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public long c = HttpDate.MAX_DATE;
        public String e = "/";

        public ic4 a() {
            return new ic4(this);
        }

        public a b(String str) {
            c(str, false);
            return this;
        }

        public final a c(String str, boolean z) {
            Objects.requireNonNull(str, "domain == null");
            String strCanonicalizeHost = Util.canonicalizeHost(str);
            if (strCanonicalizeHost != null) {
                this.d = strCanonicalizeHost;
                this.i = z;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        public a d(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > HttpDate.MAX_DATE) {
                j = 253402300799999L;
            }
            this.c = j;
            this.h = true;
            return this;
        }

        public a e(String str) {
            c(str, true);
            return this;
        }

        public a f() {
            this.g = true;
            return this;
        }

        public a g(String str) {
            Objects.requireNonNull(str, "name == null");
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.a = str;
            return this;
        }

        public a h(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.e = str;
            return this;
        }

        public a i() {
            this.f = true;
            return this;
        }

        public a j(String str) {
            Objects.requireNonNull(str, "value == null");
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.b = str;
            return this;
        }
    }

    public ic4(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.i = z3;
        this.h = z4;
    }

    public static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean c(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[PHI: r0
  0x00c0: PHI (r0v15 long) = (r0v2 long), (r0v5 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static dc.ic4 i(long r23, dc.rc4 r25, java.lang.String r26) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ic4.i(long, dc.rc4, java.lang.String):dc.ic4");
    }

    public static ic4 j(rc4 rc4Var, String str) {
        return i(System.currentTimeMillis(), rc4Var, str);
    }

    public static List<ic4> k(rc4 rc4Var, qc4 qc4Var) {
        List<String> listK = qc4Var.k(HttpHeaders.SET_COOKIE);
        int size = listK.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ic4 ic4VarJ = j(rc4Var, listK.get(i));
            if (ic4VarJ != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ic4VarJ);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public static String l(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strCanonicalizeHost = Util.canonicalizeHost(str);
        if (strCanonicalizeHost != null) {
            return strCanonicalizeHost;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m(java.lang.String r12, int r13, int r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ic4.m(java.lang.String, int, int):long");
    }

    public static long n(String str) throws NumberFormatException {
        try {
            long j2 = Long.parseLong(str);
            if (j2 <= 0) {
                return Long.MIN_VALUE;
            }
            return j2;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith(Constants.FILENAME_SEQUENCE_SEPARATOR) ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    public static boolean p(rc4 rc4Var, String str) {
        String strH = rc4Var.h();
        if (strH.equals(str)) {
            return true;
        }
        if (strH.startsWith(str)) {
            return str.endsWith("/") || strH.charAt(str.length()) == '/';
        }
        return false;
    }

    public String b() {
        return this.d;
    }

    public long d() {
        return this.c;
    }

    public boolean e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ic4)) {
            return false;
        }
        ic4 ic4Var = (ic4) obj;
        return ic4Var.a.equals(this.a) && ic4Var.b.equals(this.b) && ic4Var.d.equals(this.d) && ic4Var.e.equals(this.e) && ic4Var.c == this.c && ic4Var.f == this.f && ic4Var.g == this.g && ic4Var.h == this.h && ic4Var.i == this.i;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g(rc4 rc4Var) {
        if ((this.i ? rc4Var.n().equals(this.d) : c(rc4Var.n(), this.d)) && p(rc4Var, this.e)) {
            return !this.f || rc4Var.o();
        }
        return false;
    }

    public String h() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long j2 = this.c;
        return ((((((((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f ? 1 : 0)) * 31) + (!this.g ? 1 : 0)) * 31) + (!this.h ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }

    public String o() {
        return this.e;
    }

    public boolean q() {
        return this.h;
    }

    public boolean r() {
        return this.f;
    }

    public String s(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('=');
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String t() {
        return this.b;
    }

    public String toString() {
        return s(false);
    }

    public ic4(a aVar) {
        String str = aVar.a;
        Objects.requireNonNull(str, "builder.name == null");
        String str2 = aVar.b;
        Objects.requireNonNull(str2, "builder.value == null");
        String str3 = aVar.d;
        Objects.requireNonNull(str3, "builder.domain == null");
        this.a = str;
        this.b = str2;
        this.c = aVar.c;
        this.d = str3;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
    }
}

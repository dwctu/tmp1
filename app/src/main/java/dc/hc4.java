package dc;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes5.dex */
public final class hc4 {
    public static final ec4[] e;
    public static final ec4[] f;
    public static final hc4 g;
    public static final hc4 h;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    static {
        ec4 ec4Var = ec4.q;
        ec4 ec4Var2 = ec4.r;
        ec4 ec4Var3 = ec4.s;
        ec4 ec4Var4 = ec4.k;
        ec4 ec4Var5 = ec4.m;
        ec4 ec4Var6 = ec4.l;
        ec4 ec4Var7 = ec4.n;
        ec4 ec4Var8 = ec4.p;
        ec4 ec4Var9 = ec4.o;
        ec4[] ec4VarArr = {ec4Var, ec4Var2, ec4Var3, ec4Var4, ec4Var5, ec4Var6, ec4Var7, ec4Var8, ec4Var9};
        e = ec4VarArr;
        ec4[] ec4VarArr2 = {ec4Var, ec4Var2, ec4Var3, ec4Var4, ec4Var5, ec4Var6, ec4Var7, ec4Var8, ec4Var9, ec4.i, ec4.j, ec4.g, ec4.h, ec4.e, ec4.f, ec4.d};
        f = ec4VarArr2;
        a aVar = new a(true);
        aVar.c(ec4VarArr);
        dd4 dd4Var = dd4.TLS_1_3;
        dd4 dd4Var2 = dd4.TLS_1_2;
        aVar.f(dd4Var, dd4Var2);
        aVar.d(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.c(ec4VarArr2);
        aVar2.f(dd4Var, dd4Var2);
        aVar2.d(true);
        g = aVar2.a();
        a aVar3 = new a(true);
        aVar3.c(ec4VarArr2);
        aVar3.f(dd4Var, dd4Var2, dd4.TLS_1_1, dd4.TLS_1_0);
        aVar3.d(true);
        aVar3.a();
        h = new a(false).a();
    }

    public hc4(a aVar) {
        this.a = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.b = aVar.d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        hc4 hc4VarE = e(sSLSocket, z);
        String[] strArr = hc4VarE.d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = hc4VarE.c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List<ec4> b() {
        String[] strArr = this.c;
        if (strArr != null) {
            return ec4.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !Util.nonEmptyIntersection(Util.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || Util.nonEmptyIntersection(ec4.b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.a;
    }

    public final hc4 e(SSLSocket sSLSocket, boolean z) {
        String[] strArrIntersect = this.c != null ? Util.intersect(ec4.b, sSLSocket.getEnabledCipherSuites(), this.c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrIntersect2 = this.d != null ? Util.intersect(Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iIndexOf = Util.indexOf(ec4.b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iIndexOf != -1) {
            strArrIntersect = Util.concat(strArrIntersect, supportedCipherSuites[iIndexOf]);
        }
        a aVar = new a(this);
        aVar.b(strArrIntersect);
        aVar.e(strArrIntersect2);
        return aVar.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof hc4)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        hc4 hc4Var = (hc4) obj;
        boolean z = this.a;
        if (z != hc4Var.a) {
            return false;
        }
        return !z || (Arrays.equals(this.c, hc4Var.c) && Arrays.equals(this.d, hc4Var.d) && this.b == hc4Var.b);
    }

    public boolean f() {
        return this.b;
    }

    public List<dd4> g() {
        String[] strArr = this.d;
        if (strArr != null) {
            return dd4.forJavaNames(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.a) {
            return ((((527 + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(g(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + ")";
    }

    /* compiled from: ConnectionSpec.java */
    public static final class a {
        public boolean a;
        public String[] b;
        public String[] c;
        public boolean d;

        public a(boolean z) {
            this.a = z;
        }

        public hc4 a() {
            return new hc4(this);
        }

        public a b(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.b = (String[]) strArr.clone();
            return this;
        }

        public a c(ec4... ec4VarArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[ec4VarArr.length];
            for (int i = 0; i < ec4VarArr.length; i++) {
                strArr[i] = ec4VarArr[i].a;
            }
            b(strArr);
            return this;
        }

        public a d(boolean z) {
            if (!this.a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public a e(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.c = (String[]) strArr.clone();
            return this;
        }

        public a f(dd4... dd4VarArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[dd4VarArr.length];
            for (int i = 0; i < dd4VarArr.length; i++) {
                strArr[i] = dd4VarArr[i].javaName;
            }
            e(strArr);
            return this;
        }

        public a(hc4 hc4Var) {
            this.a = hc4Var.a;
            this.b = hc4Var.c;
            this.c = hc4Var.d;
            this.d = hc4Var.b;
        }
    }
}

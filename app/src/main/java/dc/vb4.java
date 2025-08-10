package dc;

import dc.rc4;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: Address.java */
/* loaded from: classes5.dex */
public final class vb4 {
    public final rc4 a;
    public final mc4 b;
    public final SocketFactory c;
    public final xb4 d;
    public final List<wc4> e;
    public final List<hc4> f;
    public final ProxySelector g;
    public final Proxy h;
    public final SSLSocketFactory i;
    public final HostnameVerifier j;
    public final cc4 k;

    public vb4(String str, int i, mc4 mc4Var, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, cc4 cc4Var, xb4 xb4Var, Proxy proxy, List<wc4> list, List<hc4> list2, ProxySelector proxySelector) {
        rc4.a aVar = new rc4.a();
        aVar.w(sSLSocketFactory != null ? "https" : "http");
        aVar.j(str);
        aVar.q(i);
        this.a = aVar.d();
        Objects.requireNonNull(mc4Var, "dns == null");
        this.b = mc4Var;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.c = socketFactory;
        Objects.requireNonNull(xb4Var, "proxyAuthenticator == null");
        this.d = xb4Var;
        Objects.requireNonNull(list, "protocols == null");
        this.e = Util.immutableList(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f = Util.immutableList(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = cc4Var;
    }

    public cc4 a() {
        return this.k;
    }

    public List<hc4> b() {
        return this.f;
    }

    public mc4 c() {
        return this.b;
    }

    public boolean d(vb4 vb4Var) {
        return this.b.equals(vb4Var.b) && this.d.equals(vb4Var.d) && this.e.equals(vb4Var.e) && this.f.equals(vb4Var.f) && this.g.equals(vb4Var.g) && Objects.equals(this.h, vb4Var.h) && Objects.equals(this.i, vb4Var.i) && Objects.equals(this.j, vb4Var.j) && Objects.equals(this.k, vb4Var.k) && l().B() == vb4Var.l().B();
    }

    public HostnameVerifier e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof vb4) {
            vb4 vb4Var = (vb4) obj;
            if (this.a.equals(vb4Var.a) && d(vb4Var)) {
                return true;
            }
        }
        return false;
    }

    public List<wc4> f() {
        return this.e;
    }

    public Proxy g() {
        return this.h;
    }

    public xb4 h() {
        return this.d;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Objects.hashCode(this.h)) * 31) + Objects.hashCode(this.i)) * 31) + Objects.hashCode(this.j)) * 31) + Objects.hashCode(this.k);
    }

    public ProxySelector i() {
        return this.g;
    }

    public SocketFactory j() {
        return this.c;
    }

    public SSLSocketFactory k() {
        return this.i;
    }

    public rc4 l() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.a.n());
        sb.append(SignatureImpl.INNER_SEP);
        sb.append(this.a.B());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append("}");
        return sb.toString();
    }
}

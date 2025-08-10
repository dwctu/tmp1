package dc;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/* compiled from: Route.java */
/* loaded from: classes5.dex */
public final class cd4 {
    public final vb4 a;
    public final Proxy b;
    public final InetSocketAddress c;

    public cd4(vb4 vb4Var, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(vb4Var, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.a = vb4Var;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public vb4 a() {
        return this.a;
    }

    public Proxy b() {
        return this.b;
    }

    public boolean c() {
        return this.a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof cd4) {
            cd4 cd4Var = (cd4) obj;
            if (cd4Var.a.equals(this.a) && cd4Var.b.equals(this.b) && cd4Var.c.equals(this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Route{" + this.c + "}";
    }
}

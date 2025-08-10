package dc;

import dc.ac4;
import dc.ad4;
import dc.ed4;
import dc.nc4;
import dc.qc4;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: OkHttpClient.java */
/* loaded from: classes5.dex */
public class vc4 implements Cloneable, ac4.a, ed4.a {
    public static final List<wc4> C = Util.immutableList(wc4.HTTP_2, wc4.HTTP_1_1);
    public static final List<hc4> D = Util.immutableList(hc4.g, hc4.h);
    public final int A;
    public final int B;
    public final kc4 a;
    public final Proxy b;
    public final List<wc4> c;
    public final List<hc4> d;
    public final List<sc4> e;
    public final List<sc4> f;
    public final nc4.b g;
    public final ProxySelector h;
    public final jc4 i;
    public final yb4 j;
    public final InternalCache k;
    public final SocketFactory l;
    public final SSLSocketFactory m;
    public final CertificateChainCleaner n;
    public final HostnameVerifier o;
    public final cc4 p;
    public final xb4 q;
    public final xb4 r;
    public final gc4 s;
    public final mc4 t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final int x;
    public final int y;
    public final int z;

    /* compiled from: OkHttpClient.java */
    public class a extends Internal {
        @Override // okhttp3.internal.Internal
        public void addLenient(qc4.a aVar, String str) {
            aVar.c(str);
        }

        @Override // okhttp3.internal.Internal
        public void apply(hc4 hc4Var, SSLSocket sSLSocket, boolean z) {
            hc4Var.a(sSLSocket, z);
        }

        @Override // okhttp3.internal.Internal
        public int code(ad4.a aVar) {
            return aVar.c;
        }

        @Override // okhttp3.internal.Internal
        public boolean equalsNonHost(vb4 vb4Var, vb4 vb4Var2) {
            return vb4Var.d(vb4Var2);
        }

        @Override // okhttp3.internal.Internal
        public Exchange exchange(ad4 ad4Var) {
            return ad4Var.m;
        }

        @Override // okhttp3.internal.Internal
        public void initExchange(ad4.a aVar, Exchange exchange) {
            aVar.k(exchange);
        }

        @Override // okhttp3.internal.Internal
        public ac4 newWebSocketCall(vc4 vc4Var, yc4 yc4Var) {
            return xc4.d(vc4Var, yc4Var, true);
        }

        @Override // okhttp3.internal.Internal
        public RealConnectionPool realConnectionPool(gc4 gc4Var) {
            return gc4Var.a;
        }

        @Override // okhttp3.internal.Internal
        public void addLenient(qc4.a aVar, String str, String str2) {
            aVar.d(str, str2);
        }
    }

    static {
        Internal.instance = new a();
    }

    public vc4() {
        this(new b());
    }

    public static SSLSocketFactory u(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS", e);
        }
    }

    public int A() {
        return this.z;
    }

    public boolean B() {
        return this.w;
    }

    public SocketFactory C() {
        return this.l;
    }

    public SSLSocketFactory D() {
        return this.m;
    }

    public int E() {
        return this.A;
    }

    @Override // dc.ac4.a
    public ac4 a(yc4 yc4Var) {
        return xc4.d(this, yc4Var, false);
    }

    @Override // dc.ed4.a
    public ed4 b(yc4 yc4Var, fd4 fd4Var) {
        RealWebSocket realWebSocket = new RealWebSocket(yc4Var, fd4Var, new Random(), this.B);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public xb4 c() {
        return this.r;
    }

    public int d() {
        return this.x;
    }

    public cc4 e() {
        return this.p;
    }

    public int f() {
        return this.y;
    }

    public gc4 g() {
        return this.s;
    }

    public List<hc4> h() {
        return this.d;
    }

    public jc4 i() {
        return this.i;
    }

    public kc4 k() {
        return this.a;
    }

    public mc4 l() {
        return this.t;
    }

    public nc4.b m() {
        return this.g;
    }

    public boolean n() {
        return this.v;
    }

    public boolean o() {
        return this.u;
    }

    public HostnameVerifier p() {
        return this.o;
    }

    public List<sc4> q() {
        return this.e;
    }

    public InternalCache r() {
        yb4 yb4Var = this.j;
        return yb4Var != null ? yb4Var.a : this.k;
    }

    public List<sc4> s() {
        return this.f;
    }

    public b t() {
        return new b(this);
    }

    public int v() {
        return this.B;
    }

    public List<wc4> w() {
        return this.c;
    }

    public Proxy x() {
        return this.b;
    }

    public xb4 y() {
        return this.q;
    }

    public ProxySelector z() {
        return this.h;
    }

    public vc4(b bVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z;
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        List<hc4> list = bVar.d;
        this.d = list;
        this.e = Util.immutableList(bVar.e);
        this.f = Util.immutableList(bVar.f);
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        Iterator<hc4> it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().d();
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.m;
        if (sSLSocketFactory == null && z) {
            X509TrustManager x509TrustManagerPlatformTrustManager = Util.platformTrustManager();
            this.m = u(x509TrustManagerPlatformTrustManager);
            this.n = CertificateChainCleaner.get(x509TrustManagerPlatformTrustManager);
        } else {
            this.m = sSLSocketFactory;
            this.n = bVar.n;
        }
        if (this.m != null) {
            Platform.get().configureSslSocketFactory(this.m);
        }
        this.o = bVar.o;
        this.p = bVar.p.f(this.n);
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        this.x = bVar.x;
        this.y = bVar.y;
        this.z = bVar.z;
        this.A = bVar.A;
        this.B = bVar.B;
        if (this.e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.e);
        }
        if (this.f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f);
        }
    }

    /* compiled from: OkHttpClient.java */
    public static final class b {
        public int A;
        public int B;
        public kc4 a;
        public Proxy b;
        public List<wc4> c;
        public List<hc4> d;
        public final List<sc4> e;
        public final List<sc4> f;
        public nc4.b g;
        public ProxySelector h;
        public jc4 i;
        public yb4 j;
        public InternalCache k;
        public SocketFactory l;
        public SSLSocketFactory m;
        public CertificateChainCleaner n;
        public HostnameVerifier o;
        public cc4 p;
        public xb4 q;
        public xb4 r;
        public gc4 s;
        public mc4 t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public b() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = new kc4();
            this.c = vc4.C;
            this.d = vc4.D;
            this.g = nc4.k(nc4.a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new NullProxySelector();
            }
            this.i = jc4.a;
            this.l = SocketFactory.getDefault();
            this.o = OkHostnameVerifier.INSTANCE;
            this.p = cc4.c;
            xb4 xb4Var = xb4.a;
            this.q = xb4Var;
            this.r = xb4Var;
            this.s = new gc4();
            this.t = mc4.a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public b a(sc4 sc4Var) {
            if (sc4Var == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.e.add(sc4Var);
            return this;
        }

        public vc4 b() {
            return new vc4(this);
        }

        public b c(yb4 yb4Var) {
            this.j = yb4Var;
            this.k = null;
            return this;
        }

        public b d(long j, TimeUnit timeUnit) {
            this.y = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public b e(jc4 jc4Var) {
            Objects.requireNonNull(jc4Var, "cookieJar == null");
            this.i = jc4Var;
            return this;
        }

        public b f(nc4 nc4Var) {
            Objects.requireNonNull(nc4Var, "eventListener == null");
            this.g = nc4.k(nc4Var);
            return this;
        }

        public b g(nc4.b bVar) {
            Objects.requireNonNull(bVar, "eventListenerFactory == null");
            this.g = bVar;
            return this;
        }

        public b h(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.o = hostnameVerifier;
            return this;
        }

        public b i(long j, TimeUnit timeUnit) {
            this.B = Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        public b j(List<wc4> list) {
            ArrayList arrayList = new ArrayList(list);
            wc4 wc4Var = wc4.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(wc4Var) && !arrayList.contains(wc4.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(wc4Var) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(wc4.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(wc4.SPDY_3);
            this.c = Collections.unmodifiableList(arrayList);
            return this;
        }

        public b k(long j, TimeUnit timeUnit) {
            this.z = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public b l(boolean z) {
            this.w = z;
            return this;
        }

        public b m(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.m = sSLSocketFactory;
            this.n = CertificateChainCleaner.get(x509TrustManager);
            return this;
        }

        public b n(long j, TimeUnit timeUnit) {
            this.A = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public b(vc4 vc4Var) {
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            this.a = vc4Var.a;
            this.b = vc4Var.b;
            this.c = vc4Var.c;
            this.d = vc4Var.d;
            arrayList.addAll(vc4Var.e);
            arrayList2.addAll(vc4Var.f);
            this.g = vc4Var.g;
            this.h = vc4Var.h;
            this.i = vc4Var.i;
            this.k = vc4Var.k;
            this.j = vc4Var.j;
            this.l = vc4Var.l;
            this.m = vc4Var.m;
            this.n = vc4Var.n;
            this.o = vc4Var.o;
            this.p = vc4Var.p;
            this.q = vc4Var.q;
            this.r = vc4Var.r;
            this.s = vc4Var.s;
            this.t = vc4Var.t;
            this.u = vc4Var.u;
            this.v = vc4Var.v;
            this.w = vc4Var.w;
            this.x = vc4Var.x;
            this.y = vc4Var.y;
            this.z = vc4Var.z;
            this.A = vc4Var.A;
            this.B = vc4Var.B;
        }
    }
}

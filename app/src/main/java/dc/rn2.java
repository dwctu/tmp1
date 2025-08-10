package dc;

import com.wear.util.MyApplication;
import dc.nc4;
import io.reactivex.annotations.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: HttpEventListener.java */
/* loaded from: classes3.dex */
public class rn2 extends nc4 {
    public static final String e = "dc.rn2";
    public static final nc4.b f = new a();
    public final long b;
    public String c;
    public StringBuilder d;

    /* compiled from: HttpEventListener.java */
    public class a implements nc4.b {
        public final AtomicLong a = new AtomicLong(1);

        @Override // dc.nc4.b
        public nc4 a(ac4 ac4Var) {
            return new rn2(this.a.getAndIncrement(), ac4Var.request().j(), System.currentTimeMillis());
        }
    }

    public rn2(long j, rc4 rc4Var, long j2) {
        this.b = j2;
        StringBuilder sb = new StringBuilder(rc4Var.toString());
        sb.append(" ");
        sb.append(j);
        sb.append(SignatureImpl.INNER_SEP);
        this.d = sb;
        this.c = rc4Var.toString();
    }

    @Override // dc.nc4
    public void a(ac4 ac4Var) {
        super.a(ac4Var);
        y("callEnd");
    }

    @Override // dc.nc4
    public void b(ac4 ac4Var, IOException iOException) {
        super.b(ac4Var, iOException);
        y("callFailed");
    }

    @Override // dc.nc4
    public void c(ac4 ac4Var) {
        super.c(ac4Var);
        y("callStart");
    }

    @Override // dc.nc4
    public void d(ac4 ac4Var, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable wc4 wc4Var) {
        super.d(ac4Var, inetSocketAddress, proxy, wc4Var);
        y("connectEnd");
    }

    @Override // dc.nc4
    public void e(ac4 ac4Var, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable wc4 wc4Var, IOException iOException) {
        super.e(ac4Var, inetSocketAddress, proxy, wc4Var, iOException);
        y("connectFailed");
    }

    @Override // dc.nc4
    public void f(ac4 ac4Var, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.f(ac4Var, inetSocketAddress, proxy);
        y("connectStart");
    }

    @Override // dc.nc4
    public void g(ac4 ac4Var, fc4 fc4Var) {
        super.g(ac4Var, fc4Var);
        y("connectionAcquired");
    }

    @Override // dc.nc4
    public void h(ac4 ac4Var, fc4 fc4Var) {
        super.h(ac4Var, fc4Var);
        y("connectionReleased");
    }

    @Override // dc.nc4
    public void i(ac4 ac4Var, String str, List<InetAddress> list) {
        super.i(ac4Var, str, list);
        y("dnsEnd");
    }

    @Override // dc.nc4
    public void j(ac4 ac4Var, String str) {
        super.j(ac4Var, str);
        y("dnsStart");
    }

    @Override // dc.nc4
    public void m(ac4 ac4Var, long j) {
        super.m(ac4Var, j);
        y("requestBodyEnd");
    }

    @Override // dc.nc4
    public void n(ac4 ac4Var) {
        super.n(ac4Var);
        y("requestBodyStart");
    }

    @Override // dc.nc4
    public void p(ac4 ac4Var, yc4 yc4Var) {
        super.p(ac4Var, yc4Var);
        y("requestHeadersEnd");
    }

    @Override // dc.nc4
    public void q(ac4 ac4Var) {
        super.q(ac4Var);
        y("requestHeadersStart");
        if (this.c.contains("/date-web-api/api/server/timestamp")) {
            MyApplication.N().d = System.currentTimeMillis();
            mk2.P().a = System.currentTimeMillis();
        }
    }

    @Override // dc.nc4
    public void r(ac4 ac4Var, long j) {
        super.r(ac4Var, j);
        y("responseBodyEnd");
        if (this.c.contains("/date-web-api/api/server/timestamp")) {
            MyApplication.N().e = System.currentTimeMillis();
            mk2.P().b = System.currentTimeMillis();
        }
    }

    @Override // dc.nc4
    public void s(ac4 ac4Var) {
        super.s(ac4Var);
        y("responseBodyStart");
    }

    @Override // dc.nc4
    public void u(ac4 ac4Var, ad4 ad4Var) {
        super.u(ac4Var, ad4Var);
        y("responseHeadersEnd");
    }

    @Override // dc.nc4
    public void v(ac4 ac4Var) {
        super.v(ac4Var);
        y("responseHeadersStart");
    }

    @Override // dc.nc4
    public void w(ac4 ac4Var, @Nullable pc4 pc4Var) {
        super.w(ac4Var, pc4Var);
        y("secureConnectEnd");
    }

    @Override // dc.nc4
    public void x(ac4 ac4Var) {
        super.x(ac4Var);
        y("secureConnectStart");
    }

    public final void y(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        StringBuilder sb = this.d;
        sb.append(String.format(Locale.CHINA, "%s-%s", Double.valueOf(jCurrentTimeMillis / 1000000.0d), str));
        sb.append(";");
        if (str.equalsIgnoreCase("callEnd") || str.equalsIgnoreCase("callFailed")) {
            xe3.a(e, this.d.toString());
        }
    }
}

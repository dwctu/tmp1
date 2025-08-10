package okhttp3.internal.http;

import dc.ac4;
import dc.ad4;
import dc.fc4;
import dc.sc4;
import dc.yc4;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.Transmitter;

/* loaded from: classes5.dex */
public final class RealInterceptorChain implements sc4.a {
    private final ac4 call;
    private int calls;
    private final int connectTimeout;
    private final Exchange exchange;
    private final int index;
    private final List<sc4> interceptors;
    private final int readTimeout;
    private final yc4 request;
    private final Transmitter transmitter;
    private final int writeTimeout;

    public RealInterceptorChain(List<sc4> list, Transmitter transmitter, Exchange exchange, int i, yc4 yc4Var, ac4 ac4Var, int i2, int i3, int i4) {
        this.interceptors = list;
        this.transmitter = transmitter;
        this.exchange = exchange;
        this.index = i;
        this.request = yc4Var;
        this.call = ac4Var;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    public ac4 call() {
        return this.call;
    }

    @Override // dc.sc4.a
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // dc.sc4.a
    public fc4 connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.connection();
        }
        return null;
    }

    public Exchange exchange() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange;
        }
        throw new IllegalStateException();
    }

    @Override // dc.sc4.a
    public ad4 proceed(yc4 yc4Var) throws IOException {
        return proceed(yc4Var, this.transmitter, this.exchange);
    }

    @Override // dc.sc4.a
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // dc.sc4.a
    public yc4 request() {
        return this.request;
    }

    public Transmitter transmitter() {
        return this.transmitter;
    }

    @Override // dc.sc4.a
    public sc4.a withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, Util.checkDuration("timeout", i, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // dc.sc4.a
    public sc4.a withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, Util.checkDuration("timeout", i, timeUnit), this.writeTimeout);
    }

    @Override // dc.sc4.a
    public sc4.a withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", i, timeUnit));
    }

    @Override // dc.sc4.a
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public ad4 proceed(yc4 yc4Var, Transmitter transmitter, Exchange exchange) throws IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.calls++;
        Exchange exchange2 = this.exchange;
        if (exchange2 != null && !exchange2.connection().supportsUrl(yc4Var.j())) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
        }
        if (this.exchange != null && this.calls > 1) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, transmitter, exchange, this.index + 1, yc4Var, this.call, this.connectTimeout, this.readTimeout, this.writeTimeout);
        sc4 sc4Var = this.interceptors.get(this.index);
        ad4 ad4VarIntercept = sc4Var.intercept(realInterceptorChain);
        if (exchange != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
            throw new IllegalStateException("network interceptor " + sc4Var + " must call proceed() exactly once");
        }
        if (ad4VarIntercept == null) {
            throw new NullPointerException("interceptor " + sc4Var + " returned null");
        }
        if (ad4VarIntercept.b() != null) {
            return ad4VarIntercept;
        }
        throw new IllegalStateException("interceptor " + sc4Var + " returned a response with no body");
    }
}

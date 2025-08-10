package okhttp3.internal.connection;

import dc.ad4;
import dc.sc4;
import dc.vc4;
import dc.yc4;
import java.io.IOException;
import okhttp3.internal.http.RealInterceptorChain;

/* loaded from: classes5.dex */
public final class ConnectInterceptor implements sc4 {
    public final vc4 client;

    public ConnectInterceptor(vc4 vc4Var) {
        this.client = vc4Var;
    }

    @Override // dc.sc4
    public ad4 intercept(sc4.a aVar) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) aVar;
        yc4 yc4VarRequest = realInterceptorChain.request();
        Transmitter transmitter = realInterceptorChain.transmitter();
        return realInterceptorChain.proceed(yc4VarRequest, transmitter, transmitter.newExchange(aVar, !yc4VarRequest.g().equals("GET")));
    }
}

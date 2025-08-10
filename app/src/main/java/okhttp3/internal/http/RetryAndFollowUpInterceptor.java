package okhttp3.internal.http;

import com.koushikdutta.async.http.AsyncHttpHead;
import dc.ad4;
import dc.cd4;
import dc.rc4;
import dc.sc4;
import dc.vc4;
import dc.yc4;
import dc.zc4;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http2.ConnectionShutdownException;

/* loaded from: classes5.dex */
public final class RetryAndFollowUpInterceptor implements sc4 {
    private static final int MAX_FOLLOW_UPS = 20;
    private final vc4 client;

    public RetryAndFollowUpInterceptor(vc4 vc4Var) {
        this.client = vc4Var;
    }

    private yc4 followUpRequest(ad4 ad4Var, cd4 cd4Var) throws IOException {
        String strM;
        rc4 rc4VarF;
        if (ad4Var == null) {
            throw new IllegalStateException();
        }
        int iF = ad4Var.f();
        String strG = ad4Var.L().g();
        if (iF == 307 || iF == 308) {
            if (!strG.equals("GET") && !strG.equals(AsyncHttpHead.METHOD)) {
                return null;
            }
        } else {
            if (iF == 401) {
                return this.client.c().a(cd4Var, ad4Var);
            }
            if (iF == 503) {
                if ((ad4Var.C() == null || ad4Var.C().f() != 503) && retryAfter(ad4Var, Integer.MAX_VALUE) == 0) {
                    return ad4Var.L();
                }
                return null;
            }
            if (iF == 407) {
                if ((cd4Var != null ? cd4Var.b() : this.client.x()).type() == Proxy.Type.HTTP) {
                    return this.client.y().a(cd4Var, ad4Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iF == 408) {
                if (!this.client.B()) {
                    return null;
                }
                zc4 zc4VarA = ad4Var.L().a();
                if (zc4VarA != null && zc4VarA.isOneShot()) {
                    return null;
                }
                if ((ad4Var.C() == null || ad4Var.C().f() != 408) && retryAfter(ad4Var, 0) <= 0) {
                    return ad4Var.L();
                }
                return null;
            }
            switch (iF) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.client.n() || (strM = ad4Var.m(com.google.common.net.HttpHeaders.LOCATION)) == null || (rc4VarF = ad4Var.L().j().F(strM)) == null) {
            return null;
        }
        if (!rc4VarF.G().equals(ad4Var.L().j().G()) && !this.client.o()) {
            return null;
        }
        yc4.a aVarH = ad4Var.L().h();
        if (HttpMethod.permitsRequestBody(strG)) {
            boolean zRedirectsWithBody = HttpMethod.redirectsWithBody(strG);
            if (HttpMethod.redirectsToGet(strG)) {
                aVarH.g("GET", null);
            } else {
                aVarH.g(strG, zRedirectsWithBody ? ad4Var.L().a() : null);
            }
            if (!zRedirectsWithBody) {
                aVarH.i(com.google.common.net.HttpHeaders.TRANSFER_ENCODING);
                aVarH.i(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
                aVarH.i("Content-Type");
            }
        }
        if (!Util.sameConnection(ad4Var.L().j(), rc4VarF)) {
            aVarH.i(com.google.common.net.HttpHeaders.AUTHORIZATION);
        }
        aVarH.l(rc4VarF);
        return aVarH.b();
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean recover(IOException iOException, Transmitter transmitter, boolean z, yc4 yc4Var) {
        if (this.client.B()) {
            return !(z && requestIsOneShot(iOException, yc4Var)) && isRecoverable(iOException, z) && transmitter.canRetry();
        }
        return false;
    }

    private boolean requestIsOneShot(IOException iOException, yc4 yc4Var) {
        zc4 zc4VarA = yc4Var.a();
        return (zc4VarA != null && zc4VarA.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private int retryAfter(ad4 ad4Var, int i) {
        String strM = ad4Var.m(com.google.common.net.HttpHeaders.RETRY_AFTER);
        if (strM == null) {
            return i;
        }
        if (strM.matches("\\d+")) {
            return Integer.valueOf(strM).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // dc.sc4
    public ad4 intercept(sc4.a aVar) throws IOException {
        Exchange exchange;
        yc4 yc4VarFollowUpRequest;
        yc4 yc4VarRequest = aVar.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) aVar;
        Transmitter transmitter = realInterceptorChain.transmitter();
        ad4 ad4Var = null;
        int i = 0;
        while (true) {
            transmitter.prepareToConnect(yc4VarRequest);
            if (transmitter.isCanceled()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    try {
                        ad4 ad4VarProceed = realInterceptorChain.proceed(yc4VarRequest, transmitter, null);
                        if (ad4Var != null) {
                            ad4.a aVarA = ad4VarProceed.A();
                            ad4.a aVarA2 = ad4Var.A();
                            aVarA2.b(null);
                            aVarA.n(aVarA2.c());
                            ad4VarProceed = aVarA.c();
                        }
                        ad4Var = ad4VarProceed;
                        exchange = Internal.instance.exchange(ad4Var);
                        yc4VarFollowUpRequest = followUpRequest(ad4Var, exchange != null ? exchange.connection().route() : null);
                    } catch (RouteException e) {
                        if (!recover(e.getLastConnectException(), transmitter, false, yc4VarRequest)) {
                            throw e.getFirstConnectException();
                        }
                    }
                } catch (IOException e2) {
                    if (!recover(e2, transmitter, !(e2 instanceof ConnectionShutdownException), yc4VarRequest)) {
                        throw e2;
                    }
                }
                if (yc4VarFollowUpRequest == null) {
                    if (exchange != null && exchange.isDuplex()) {
                        transmitter.timeoutEarlyExit();
                    }
                    return ad4Var;
                }
                zc4 zc4VarA = yc4VarFollowUpRequest.a();
                if (zc4VarA != null && zc4VarA.isOneShot()) {
                    return ad4Var;
                }
                Util.closeQuietly(ad4Var.b());
                if (transmitter.hasExchange()) {
                    exchange.detachWithViolence();
                }
                i++;
                if (i > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i);
                }
                yc4VarRequest = yc4VarFollowUpRequest;
            } finally {
                transmitter.exchangeDoneDueToException();
            }
        }
    }
}

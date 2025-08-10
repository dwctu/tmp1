package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.HttpClient;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.amazonaws.util.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class AmazonWebServiceClient {
    public static final Log j = LogFactory.b(AmazonWebServiceClient.class);
    public volatile URI a;
    public volatile String b;
    public ClientConfiguration c;
    public AmazonHttpClient d;
    public final List<RequestHandler2> e = new CopyOnWriteArrayList();
    public long f;
    public volatile Signer g;
    public volatile String h;
    public volatile String i;

    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.c = clientConfiguration;
        this.d = new AmazonHttpClient(clientConfiguration, httpClient);
    }

    @Deprecated
    public static boolean r() {
        return System.getProperty("com.amazonaws.sdk.enableRuntimeProfiling") != null;
    }

    public final String g() {
        int i;
        String simpleName = Classes.childClassOf(AmazonWebServiceClient.class, this).getSimpleName();
        String serviceName = ServiceNameFactory.getServiceName(simpleName);
        if (serviceName != null) {
            return serviceName;
        }
        int iIndexOf = simpleName.indexOf("JavaClient");
        if (iIndexOf == -1 && (iIndexOf = simpleName.indexOf("Client")) == -1) {
            throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + simpleName);
        }
        int iIndexOf2 = simpleName.indexOf("Amazon");
        if (iIndexOf2 == -1) {
            iIndexOf2 = simpleName.indexOf("AWS");
            if (iIndexOf2 == -1) {
                throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + simpleName);
            }
            i = 3;
        } else {
            i = 6;
        }
        if (iIndexOf2 < iIndexOf) {
            return StringUtils.b(simpleName.substring(iIndexOf2 + i, iIndexOf));
        }
        throw new IllegalStateException("Unrecognized AWS http client class name " + simpleName);
    }

    public final Signer h(String str, String str2, String str3, boolean z) {
        String strE = this.c.e();
        Signer signerB = strE == null ? SignerFactory.b(str, str2) : SignerFactory.c(strE, str);
        if (signerB instanceof RegionAwareSigner) {
            RegionAwareSigner regionAwareSigner = (RegionAwareSigner) signerB;
            if (str3 != null) {
                regionAwareSigner.setRegionName(str3);
            } else if (str2 != null && z) {
                regionAwareSigner.setRegionName(str2);
            }
        }
        synchronized (this) {
            Region.e(str2);
        }
        return signerB;
    }

    public final Signer i(URI uri, String str, boolean z) {
        if (uri == null) {
            throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
        }
        String strO = o();
        return h(strO, AwsHostNameUtils.a(uri.getHost(), strO), str, z);
    }

    @Deprecated
    public final void j(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response) {
        k(aWSRequestMetrics, request, response, false);
    }

    @Deprecated
    public final void k(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response, boolean z) {
        if (request != null) {
            aWSRequestMetrics.b(AWSRequestMetrics.Field.ClientExecuteTime);
            aWSRequestMetrics.c().c();
            l(request).a(request, response);
        }
        if (z) {
            aWSRequestMetrics.e();
        }
    }

    @Deprecated
    public final RequestMetricCollector l(Request<?> request) {
        RequestMetricCollector requestMetricCollectorF = request.m().f();
        if (requestMetricCollectorF != null) {
            return requestMetricCollectorF;
        }
        RequestMetricCollector requestMetricCollectorN = n();
        return requestMetricCollectorN == null ? AwsSdkMetrics.getRequestMetricCollector() : requestMetricCollectorN;
    }

    public String m() {
        return this.i;
    }

    @Deprecated
    public RequestMetricCollector n() {
        return this.d.f();
    }

    public String o() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = g();
                    return this.h;
                }
            }
        }
        return this.h;
    }

    public Signer p(URI uri) {
        return i(uri, this.b, true);
    }

    public final String q() {
        return this.b;
    }

    @Deprecated
    public final boolean s() {
        RequestMetricCollector requestMetricCollectorU = u();
        return requestMetricCollectorU != null && requestMetricCollectorU.b();
    }

    @Deprecated
    public final boolean t(AmazonWebServiceRequest amazonWebServiceRequest) {
        RequestMetricCollector requestMetricCollectorF = amazonWebServiceRequest.f();
        if (requestMetricCollectorF == null || !requestMetricCollectorF.b()) {
            return s();
        }
        return true;
    }

    @Deprecated
    public RequestMetricCollector u() {
        RequestMetricCollector requestMetricCollectorF = this.d.f();
        return requestMetricCollectorF == null ? AwsSdkMetrics.getRequestMetricCollector() : requestMetricCollectorF;
    }

    public void v(String str) {
        URI uriX = x(str);
        Signer signerI = i(uriX, this.b, false);
        synchronized (this) {
            this.a = uriX;
            this.g = signerI;
        }
    }

    public void w(Region region) {
        String strF;
        if (region == null) {
            throw new IllegalArgumentException("No region provided");
        }
        String strO = o();
        if (region.h(strO)) {
            strF = region.f(strO);
            int iIndexOf = strF.indexOf("://");
            if (iIndexOf >= 0) {
                strF = strF.substring(iIndexOf + 3);
            }
        } else {
            strF = String.format("%s.%s.%s", m(), region.d(), region.a());
        }
        URI uriX = x(strF);
        Signer signerH = h(strO, region.d(), this.b, false);
        synchronized (this) {
            this.a = uriX;
            this.g = signerH;
        }
    }

    public final URI x(String str) {
        if (!str.contains("://")) {
            str = this.c.c().toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

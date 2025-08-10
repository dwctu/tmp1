package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;

/* loaded from: classes.dex */
public class ExecutionContext {
    public final AWSRequestMetrics a;
    public final List<RequestHandler2> b;
    public String c;
    public AWSCredentials d;

    public ExecutionContext(List<RequestHandler2> list, boolean z, AmazonWebServiceClient amazonWebServiceClient) {
        this.b = list;
        this.a = z ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics();
    }

    @Deprecated
    public AWSRequestMetrics a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public AWSCredentials c() {
        return this.d;
    }

    public List<RequestHandler2> d() {
        return this.b;
    }

    public Signer e(URI uri) {
        throw null;
    }

    public void f(AWSCredentials aWSCredentials) {
        this.d = aWSCredentials;
    }

    public void g(Signer signer) {
        throw null;
    }
}

package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;

/* loaded from: classes.dex */
public final class RequestHandler2Adaptor extends RequestHandler2 {
    public final RequestHandler a;

    public RequestHandler2Adaptor(RequestHandler requestHandler) {
        if (requestHandler == null) {
            throw new IllegalArgumentException();
        }
        this.a = requestHandler;
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void b(Request<?> request, Response<?> response, Exception exc) {
        this.a.b(request, exc);
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void c(Request<?> request, Response<?> response) {
        AWSRequestMetrics aWSRequestMetricsB = request == null ? null : request.b();
        this.a.c(request, response == null ? null : response.a(), aWSRequestMetricsB != null ? aWSRequestMetricsB.c() : null);
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void d(Request<?> request) {
        this.a.a(request);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RequestHandler2Adaptor) {
            return this.a.equals(((RequestHandler2Adaptor) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

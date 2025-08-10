package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;

/* loaded from: classes.dex */
public abstract class RequestHandler2 {
    public static RequestHandler2 a(RequestHandler requestHandler) {
        return new RequestHandler2Adaptor(requestHandler);
    }

    public abstract void b(Request<?> request, Response<?> response, Exception exc);

    public abstract void c(Request<?> request, Response<?> response);

    public abstract void d(Request<?> request);
}

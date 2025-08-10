package com.amazonaws.http;

/* loaded from: classes.dex */
public interface HttpResponseHandler<T> {
    T a(HttpResponse httpResponse) throws Exception;

    boolean b();
}

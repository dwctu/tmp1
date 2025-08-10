package com.amazonaws;

import com.amazonaws.http.HttpResponse;

/* loaded from: classes.dex */
public final class Response<T> {
    public final T a;

    public Response(T t, HttpResponse httpResponse) {
        this.a = t;
    }

    public T a() {
        return this.a;
    }
}

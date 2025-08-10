package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;

/* loaded from: classes.dex */
public interface HeaderHandler<T> {
    void a(T t, HttpResponse httpResponse);
}

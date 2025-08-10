package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public interface ThenFutureCallback<T, F> {
    Future<T> then(F f) throws Exception;
}

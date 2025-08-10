package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public interface ThenCallback<T, F> {
    T then(F f) throws Exception;
}

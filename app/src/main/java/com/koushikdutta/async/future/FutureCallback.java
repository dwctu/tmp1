package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public interface FutureCallback<T> {
    void onCompleted(Exception exc, T t);
}

package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public interface FailRecoverCallback<T> {
    Future<T> fail(Exception exc) throws Exception;
}

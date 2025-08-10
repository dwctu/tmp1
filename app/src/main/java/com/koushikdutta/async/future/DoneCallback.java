package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public interface DoneCallback<T> {
    void done(Exception exc, T t) throws Exception;
}

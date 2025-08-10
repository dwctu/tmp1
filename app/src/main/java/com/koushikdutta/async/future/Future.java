package com.koushikdutta.async.future;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public interface Future<T> extends Cancellable, java.util.concurrent.Future<T> {
    Future<T> done(DoneCallback<T> doneCallback);

    Future<T> executorThread(Executor executor);

    Future<T> fail(FailCallback failCallback);

    Future<T> failConvert(FailConvertCallback<T> failConvertCallback);

    Future<T> failRecover(FailRecoverCallback<T> failRecoverCallback);

    void setCallback(FutureCallback<T> futureCallback);

    Future<T> success(SuccessCallback<T> successCallback);

    <R> Future<R> then(ThenFutureCallback<R, T> thenFutureCallback);

    <R> Future<R> thenConvert(ThenCallback<R, T> thenCallback);

    T tryGet();

    Exception tryGetException();
}

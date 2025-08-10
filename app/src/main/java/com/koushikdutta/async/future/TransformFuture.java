package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public abstract class TransformFuture<T, F> extends SimpleFuture<T> implements FutureCallback<F> {
    public TransformFuture(F f) {
        onCompleted(null, f);
    }

    public void error(Exception exc) {
        setComplete(exc);
    }

    @Override // com.koushikdutta.async.future.FutureCallback
    public void onCompleted(Exception exc, F f) {
        if (isCancelled()) {
            return;
        }
        if (exc != null) {
            error(exc);
            return;
        }
        try {
            transform(f);
        } catch (Exception e) {
            error(e);
        }
    }

    public abstract void transform(F f) throws Exception;

    public TransformFuture() {
    }
}

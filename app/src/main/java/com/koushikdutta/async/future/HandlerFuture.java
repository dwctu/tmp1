package com.koushikdutta.async.future;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class HandlerFuture<T> extends SimpleFuture<T> {
    public Handler handler;

    /* renamed from: com.koushikdutta.async.future.HandlerFuture$1, reason: invalid class name */
    public class AnonymousClass1 implements FutureCallback<T> {
        public final /* synthetic */ FutureCallback val$callback;

        public AnonymousClass1(FutureCallback futureCallback) {
            this.val$callback = futureCallback;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        public void onCompleted(final Exception exc, final T t) {
            if (Looper.myLooper() == HandlerFuture.this.handler.getLooper()) {
                this.val$callback.onCompleted(exc, t);
            } else {
                HandlerFuture.this.handler.post(new Runnable() { // from class: com.koushikdutta.async.future.HandlerFuture.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.onCompleted(exc, t);
                    }
                });
            }
        }
    }

    public HandlerFuture() {
        Looper looperMyLooper = Looper.myLooper();
        this.handler = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
    }

    @Override // com.koushikdutta.async.future.SimpleFuture, com.koushikdutta.async.future.Future
    public void setCallback(FutureCallback<T> futureCallback) {
        super.setCallback(new AnonymousClass1(futureCallback));
    }
}

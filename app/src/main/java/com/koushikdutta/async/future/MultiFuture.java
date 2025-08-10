package com.koushikdutta.async.future;

import com.koushikdutta.async.future.SimpleFuture;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MultiFuture<T> extends SimpleFuture<T> {
    private final SimpleFuture.FutureCallbackInternal<T> internalCallback;
    private ArrayList<SimpleFuture.FutureCallbackInternal<T>> internalCallbacks;

    public MultiFuture() {
        this.internalCallback = new SimpleFuture.FutureCallbackInternal() { // from class: dc.l91
            @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                this.a.n(exc, obj, futureCallsite);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
        ArrayList<SimpleFuture.FutureCallbackInternal<T>> arrayList;
        synchronized (this) {
            arrayList = this.internalCallbacks;
            this.internalCallbacks = null;
        }
        if (arrayList == null) {
            return;
        }
        Iterator<SimpleFuture.FutureCallbackInternal<T>> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onCompleted(exc, obj, futureCallsite);
        }
    }

    @Override // com.koushikdutta.async.future.SimpleFuture
    public void setCallbackInternal(SimpleFuture.FutureCallsite futureCallsite, SimpleFuture.FutureCallbackInternal<T> futureCallbackInternal) {
        synchronized (this) {
            if (futureCallbackInternal != null) {
                if (this.internalCallbacks == null) {
                    this.internalCallbacks = new ArrayList<>();
                }
                this.internalCallbacks.add(futureCallbackInternal);
            }
        }
        super.setCallbackInternal(futureCallsite, this.internalCallback);
    }

    public MultiFuture(T t) {
        super(t);
        this.internalCallback = new SimpleFuture.FutureCallbackInternal() { // from class: dc.l91
            @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                this.a.n(exc, obj, futureCallsite);
            }
        };
    }

    public MultiFuture(Exception exc) {
        super(exc);
        this.internalCallback = new SimpleFuture.FutureCallbackInternal() { // from class: dc.l91
            @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
            public final void onCompleted(Exception exc2, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                this.a.n(exc2, obj, futureCallsite);
            }
        };
    }

    public MultiFuture(Future<T> future) {
        super((Future) future);
        this.internalCallback = new SimpleFuture.FutureCallbackInternal() { // from class: dc.l91
            @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
            public final void onCompleted(Exception exc2, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                this.a.n(exc2, obj, futureCallsite);
            }
        };
    }
}

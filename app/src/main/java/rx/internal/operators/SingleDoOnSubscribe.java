package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

/* loaded from: classes5.dex */
public final class SingleDoOnSubscribe<T> implements Single.OnSubscribe<T> {
    public final Action0 onSubscribe;
    public final Single.OnSubscribe<T> source;

    public SingleDoOnSubscribe(Single.OnSubscribe<T> onSubscribe, Action0 action0) {
        this.source = onSubscribe;
        this.onSubscribe = action0;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        try {
            this.onSubscribe.call();
            this.source.call(singleSubscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleSubscriber.onError(th);
        }
    }
}

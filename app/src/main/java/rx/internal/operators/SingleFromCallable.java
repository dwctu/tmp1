package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;

/* loaded from: classes5.dex */
public final class SingleFromCallable<T> implements Single.OnSubscribe<T> {
    public final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        try {
            singleSubscriber.onSuccess(this.callable.call());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleSubscriber.onError(th);
        }
    }
}

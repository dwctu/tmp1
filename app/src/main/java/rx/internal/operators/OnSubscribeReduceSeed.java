package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

/* loaded from: classes5.dex */
public final class OnSubscribeReduceSeed<T, R> implements Observable.OnSubscribe<R> {
    public final R initialValue;
    public final Func2<R, ? super T, R> reducer;
    public final Observable<T> source;

    public static final class ReduceSeedSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        public final Func2<R, ? super T, R> reducer;

        public ReduceSeedSubscriber(Subscriber<? super R> subscriber, R r, Func2<R, ? super T, R> func2) {
            super(subscriber);
            this.value = r;
            this.hasValue = true;
            this.reducer = func2;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            try {
                this.value = this.reducer.call(this.value, t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                unsubscribe();
                this.actual.onError(th);
            }
        }
    }

    public OnSubscribeReduceSeed(Observable<T> observable, R r, Func2<R, ? super T, R> func2) {
        this.source = observable;
        this.initialValue = r;
        this.reducer = func2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        new ReduceSeedSubscriber(subscriber, this.initialValue, this.reducer).subscribeTo(this.source);
    }
}

package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* loaded from: classes5.dex */
public final class OnSubscribeTakeLastOne<T> implements Observable.OnSubscribe<T> {
    public final Observable<T> source;

    public static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscriber<T, T> {
        public static final Object EMPTY = new Object();

        /* JADX WARN: Type inference failed for: r1v1, types: [R, java.lang.Object] */
        public TakeLastOneSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.value = EMPTY;
        }

        @Override // rx.internal.operators.DeferredScalarSubscriber, rx.Observer
        public void onCompleted() {
            Object obj = this.value;
            if (obj == EMPTY) {
                complete();
            } else {
                complete(obj);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(T t) {
            this.value = t;
        }
    }

    public OnSubscribeTakeLastOne(Observable<T> observable) {
        this.source = observable;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        new TakeLastOneSubscriber(subscriber).subscribeTo(this.source);
    }
}

package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class OnSubscribeReduce<T> implements Observable.OnSubscribe<T> {
    public final Func2<T, T, T> reducer;
    public final Observable<T> source;

    public static final class ReduceSubscriber<T> extends Subscriber<T> {
        public static final Object EMPTY = new Object();
        public final Subscriber<? super T> actual;
        public boolean done;
        public final Func2<T, T, T> reducer;
        public T value = (T) EMPTY;

        public ReduceSubscriber(Subscriber<? super T> subscriber, Func2<T, T, T> func2) {
            this.actual = subscriber;
            this.reducer = func2;
            request(0L);
        }

        public void downstreamRequest(long j) {
            if (j >= 0) {
                if (j != 0) {
                    request(Long.MAX_VALUE);
                }
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t = this.value;
            if (t == EMPTY) {
                this.actual.onError(new NoSuchElementException());
            } else {
                this.actual.onNext(t);
                this.actual.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            T t2 = this.value;
            if (t2 == EMPTY) {
                this.value = t;
                return;
            }
            try {
                this.value = this.reducer.call(t2, t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public OnSubscribeReduce(Observable<T> observable, Func2<T, T, T> func2) {
        this.source = observable;
        this.reducer = func2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        final ReduceSubscriber reduceSubscriber = new ReduceSubscriber(subscriber, this.reducer);
        subscriber.add(reduceSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeReduce.1
            @Override // rx.Producer
            public void request(long j) {
                reduceSubscriber.downstreamRequest(j);
            }
        });
        this.source.unsafeSubscribe(reduceSubscriber);
    }
}

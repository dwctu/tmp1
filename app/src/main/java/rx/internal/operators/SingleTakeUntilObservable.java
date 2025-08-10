package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class SingleTakeUntilObservable<T, U> implements Single.OnSubscribe<T> {
    public final Observable<? extends U> other;
    public final Single.OnSubscribe<T> source;

    public static final class TakeUntilSourceSubscriber<T, U> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final Subscriber<U> other;

        public final class OtherSubscriber extends Subscriber<U> {
            public OtherSubscriber() {
            }

            @Override // rx.Observer
            public void onCompleted() {
                onError(new CancellationException("Single::takeUntil(Observable) - Stream was canceled before emitting a terminal event."));
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                TakeUntilSourceSubscriber.this.onError(th);
            }

            @Override // rx.Observer
            public void onNext(U u) {
                onCompleted();
            }
        }

        public TakeUntilSourceSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
            OtherSubscriber otherSubscriber = new OtherSubscriber();
            this.other = otherSubscriber;
            add(otherSubscriber);
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                RxJavaHooks.onError(th);
            } else {
                unsubscribe();
                this.actual.onError(th);
            }
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onSuccess(t);
            }
        }
    }

    public SingleTakeUntilObservable(Single.OnSubscribe<T> onSubscribe, Observable<? extends U> observable) {
        this.source = onSubscribe;
        this.other = observable;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        TakeUntilSourceSubscriber takeUntilSourceSubscriber = new TakeUntilSourceSubscriber(singleSubscriber);
        singleSubscriber.add(takeUntilSourceSubscriber);
        this.other.subscribe((Subscriber<? super Object>) takeUntilSourceSubscriber.other);
        this.source.call(takeUntilSourceSubscriber);
    }
}

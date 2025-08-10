package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;
import rx.SingleSubscriber;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class SingleTakeUntilSingle<T, U> implements Single.OnSubscribe<T> {
    public final Single<? extends U> other;
    public final Single.OnSubscribe<T> source;

    public static final class TakeUntilSourceSubscriber<T, U> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final SingleSubscriber<U> other;

        public final class OtherSubscriber extends SingleSubscriber<U> {
            public OtherSubscriber() {
            }

            @Override // rx.SingleSubscriber
            public void onError(Throwable th) {
                TakeUntilSourceSubscriber.this.onError(th);
            }

            @Override // rx.SingleSubscriber
            public void onSuccess(U u) {
                onError(new CancellationException("Single::takeUntil(Single) - Stream was canceled before emitting a terminal event."));
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

    public SingleTakeUntilSingle(Single.OnSubscribe<T> onSubscribe, Single<? extends U> single) {
        this.source = onSubscribe;
        this.other = single;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        TakeUntilSourceSubscriber takeUntilSourceSubscriber = new TakeUntilSourceSubscriber(singleSubscriber);
        singleSubscriber.add(takeUntilSourceSubscriber);
        this.other.subscribe((SingleSubscriber<? super Object>) takeUntilSourceSubscriber.other);
        this.source.call(takeUntilSourceSubscriber);
    }
}

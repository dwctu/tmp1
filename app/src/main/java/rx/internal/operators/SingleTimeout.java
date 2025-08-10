package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class SingleTimeout<T> implements Single.OnSubscribe<T> {
    public final Single.OnSubscribe<? extends T> other;
    public final Scheduler scheduler;
    public final Single.OnSubscribe<T> source;
    public final long timeout;
    public final TimeUnit unit;

    public static final class TimeoutSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        public final SingleSubscriber<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final Single.OnSubscribe<? extends T> other;

        public static final class OtherSubscriber<T> extends SingleSubscriber<T> {
            public final SingleSubscriber<? super T> actual;

            public OtherSubscriber(SingleSubscriber<? super T> singleSubscriber) {
                this.actual = singleSubscriber;
            }

            @Override // rx.SingleSubscriber
            public void onError(Throwable th) {
                this.actual.onError(th);
            }

            @Override // rx.SingleSubscriber
            public void onSuccess(T t) {
                this.actual.onSuccess(t);
            }
        }

        public TimeoutSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Single.OnSubscribe<? extends T> onSubscribe) {
            this.actual = singleSubscriber;
            this.other = onSubscribe;
        }

        @Override // rx.functions.Action0
        public void call() {
            if (this.once.compareAndSet(false, true)) {
                try {
                    Single.OnSubscribe<? extends T> onSubscribe = this.other;
                    if (onSubscribe == null) {
                        this.actual.onError(new TimeoutException());
                    } else {
                        OtherSubscriber otherSubscriber = new OtherSubscriber(this.actual);
                        this.actual.add(otherSubscriber);
                        onSubscribe.call(otherSubscriber);
                    }
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                RxJavaHooks.onError(th);
                return;
            }
            try {
                this.actual.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            if (this.once.compareAndSet(false, true)) {
                try {
                    this.actual.onSuccess(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    public SingleTimeout(Single.OnSubscribe<T> onSubscribe, long j, TimeUnit timeUnit, Scheduler scheduler, Single.OnSubscribe<? extends T> onSubscribe2) {
        this.source = onSubscribe;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = onSubscribe2;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        TimeoutSingleSubscriber timeoutSingleSubscriber = new TimeoutSingleSubscriber(singleSubscriber, this.other);
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        timeoutSingleSubscriber.add(workerCreateWorker);
        singleSubscriber.add(timeoutSingleSubscriber);
        workerCreateWorker.schedule(timeoutSingleSubscriber, this.timeout, this.unit);
        this.source.call(timeoutSingleSubscriber);
    }
}

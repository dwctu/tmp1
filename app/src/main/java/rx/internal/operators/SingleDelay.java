package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;

/* loaded from: classes5.dex */
public final class SingleDelay<T> implements Single.OnSubscribe<T> {
    public final long delay;
    public final Scheduler scheduler;
    public final Single.OnSubscribe<T> source;
    public final TimeUnit unit;

    public static final class ObserveOnSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        public final SingleSubscriber<? super T> actual;
        public final long delay;
        public Throwable error;
        public final TimeUnit unit;
        public T value;
        public final Scheduler.Worker w;

        public ObserveOnSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Scheduler.Worker worker, long j, TimeUnit timeUnit) {
            this.actual = singleSubscriber;
            this.w = worker;
            this.delay = j;
            this.unit = timeUnit;
        }

        @Override // rx.functions.Action0
        public void call() {
            try {
                Throwable th = this.error;
                if (th != null) {
                    this.error = null;
                    this.actual.onError(th);
                } else {
                    T t = this.value;
                    this.value = null;
                    this.actual.onSuccess(t);
                }
            } finally {
                this.w.unsubscribe();
            }
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            this.error = th;
            this.w.schedule(this, this.delay, this.unit);
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            this.value = t;
            this.w.schedule(this, this.delay, this.unit);
        }
    }

    public SingleDelay(Single.OnSubscribe<T> onSubscribe, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.source = onSubscribe;
        this.scheduler = scheduler;
        this.delay = j;
        this.unit = timeUnit;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        ObserveOnSingleSubscriber observeOnSingleSubscriber = new ObserveOnSingleSubscriber(singleSubscriber, workerCreateWorker, this.delay, this.unit);
        singleSubscriber.add(workerCreateWorker);
        singleSubscriber.add(observeOnSingleSubscriber);
        this.source.call(observeOnSingleSubscriber);
    }
}

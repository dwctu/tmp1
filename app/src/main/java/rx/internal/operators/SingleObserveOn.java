package rx.internal.operators;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;

/* loaded from: classes5.dex */
public final class SingleObserveOn<T> implements Single.OnSubscribe<T> {
    public final Scheduler scheduler;
    public final Single.OnSubscribe<T> source;

    public static final class ObserveOnSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        public final SingleSubscriber<? super T> actual;
        public Throwable error;
        public T value;
        public final Scheduler.Worker w;

        public ObserveOnSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Scheduler.Worker worker) {
            this.actual = singleSubscriber;
            this.w = worker;
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
            this.w.schedule(this);
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            this.value = t;
            this.w.schedule(this);
        }
    }

    public SingleObserveOn(Single.OnSubscribe<T> onSubscribe, Scheduler scheduler) {
        this.source = onSubscribe;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        ObserveOnSingleSubscriber observeOnSingleSubscriber = new ObserveOnSingleSubscriber(singleSubscriber, workerCreateWorker);
        singleSubscriber.add(workerCreateWorker);
        singleSubscriber.add(observeOnSingleSubscriber);
        this.source.call(observeOnSingleSubscriber);
    }
}

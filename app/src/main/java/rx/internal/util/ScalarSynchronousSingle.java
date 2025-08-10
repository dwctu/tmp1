package rx.internal.util;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

/* loaded from: classes5.dex */
public final class ScalarSynchronousSingle<T> extends Single<T> {
    public final T value;

    public static final class DirectScheduledEmission<T> implements Single.OnSubscribe<T> {
        private final EventLoopsScheduler es;
        private final T value;

        public DirectScheduledEmission(EventLoopsScheduler eventLoopsScheduler, T t) {
            this.es = eventLoopsScheduler;
            this.value = t;
        }

        @Override // rx.functions.Action1
        public void call(SingleSubscriber<? super T> singleSubscriber) {
            singleSubscriber.add(this.es.scheduleDirect(new ScalarSynchronousSingleAction(singleSubscriber, this.value)));
        }
    }

    public static final class NormalScheduledEmission<T> implements Single.OnSubscribe<T> {
        private final Scheduler scheduler;
        private final T value;

        public NormalScheduledEmission(Scheduler scheduler, T t) {
            this.scheduler = scheduler;
            this.value = t;
        }

        @Override // rx.functions.Action1
        public void call(SingleSubscriber<? super T> singleSubscriber) {
            Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
            singleSubscriber.add(workerCreateWorker);
            workerCreateWorker.schedule(new ScalarSynchronousSingleAction(singleSubscriber, this.value));
        }
    }

    public static final class ScalarSynchronousSingleAction<T> implements Action0 {
        private final SingleSubscriber<? super T> subscriber;
        private final T value;

        public ScalarSynchronousSingleAction(SingleSubscriber<? super T> singleSubscriber, T t) {
            this.subscriber = singleSubscriber;
            this.value = t;
        }

        @Override // rx.functions.Action0
        public void call() {
            try {
                this.subscriber.onSuccess(this.value);
            } catch (Throwable th) {
                this.subscriber.onError(th);
            }
        }
    }

    public ScalarSynchronousSingle(final T t) {
        super(new Single.OnSubscribe<T>() { // from class: rx.internal.util.ScalarSynchronousSingle.1
            @Override // rx.functions.Action1
            public void call(SingleSubscriber<? super T> singleSubscriber) {
                singleSubscriber.onSuccess((Object) t);
            }
        });
        this.value = t;
    }

    public static <T> ScalarSynchronousSingle<T> create(T t) {
        return new ScalarSynchronousSingle<>(t);
    }

    public T get() {
        return this.value;
    }

    public <R> Single<R> scalarFlatMap(final Func1<? super T, ? extends Single<? extends R>> func1) {
        return Single.create(new Single.OnSubscribe<R>() { // from class: rx.internal.util.ScalarSynchronousSingle.2
            @Override // rx.functions.Action1
            public void call(final SingleSubscriber<? super R> singleSubscriber) {
                Single single = (Single) func1.call(ScalarSynchronousSingle.this.value);
                if (single instanceof ScalarSynchronousSingle) {
                    singleSubscriber.onSuccess(((ScalarSynchronousSingle) single).value);
                    return;
                }
                SingleSubscriber<R> singleSubscriber2 = new SingleSubscriber<R>() { // from class: rx.internal.util.ScalarSynchronousSingle.2.1
                    @Override // rx.SingleSubscriber
                    public void onError(Throwable th) {
                        singleSubscriber.onError(th);
                    }

                    @Override // rx.SingleSubscriber
                    public void onSuccess(R r) {
                        singleSubscriber.onSuccess(r);
                    }
                };
                singleSubscriber.add(singleSubscriber2);
                single.subscribe(singleSubscriber2);
            }
        });
    }

    public Single<T> scalarScheduleOn(Scheduler scheduler) {
        return scheduler instanceof EventLoopsScheduler ? Single.create(new DirectScheduledEmission((EventLoopsScheduler) scheduler, this.value)) : Single.create(new NormalScheduledEmission(scheduler, this.value));
    }
}

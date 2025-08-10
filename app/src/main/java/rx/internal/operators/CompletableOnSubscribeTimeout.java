package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

/* loaded from: classes5.dex */
public final class CompletableOnSubscribeTimeout implements Completable.OnSubscribe {
    public final Completable other;
    public final Scheduler scheduler;
    public final Completable source;
    public final long timeout;
    public final TimeUnit unit;

    public CompletableOnSubscribeTimeout(Completable completable, long j, TimeUnit timeUnit, Scheduler scheduler, Completable completable2) {
        this.source = completable;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = completable2;
    }

    @Override // rx.functions.Action1
    public void call(final CompletableSubscriber completableSubscriber) {
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.onSubscribe(compositeSubscription);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        compositeSubscription.add(workerCreateWorker);
        workerCreateWorker.schedule(new Action0() { // from class: rx.internal.operators.CompletableOnSubscribeTimeout.1
            @Override // rx.functions.Action0
            public void call() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeSubscription.clear();
                    Completable completable = CompletableOnSubscribeTimeout.this.other;
                    if (completable == null) {
                        completableSubscriber.onError(new TimeoutException());
                    } else {
                        completable.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeTimeout.1.1
                            @Override // rx.CompletableSubscriber
                            public void onCompleted() {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onCompleted();
                            }

                            @Override // rx.CompletableSubscriber
                            public void onError(Throwable th) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onError(th);
                            }

                            @Override // rx.CompletableSubscriber
                            public void onSubscribe(Subscription subscription) {
                                compositeSubscription.add(subscription);
                            }
                        });
                    }
                }
            }
        }, this.timeout, this.unit);
        this.source.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeTimeout.2
            @Override // rx.CompletableSubscriber
            public void onCompleted() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeSubscription.unsubscribe();
                    completableSubscriber.onCompleted();
                }
            }

            @Override // rx.CompletableSubscriber
            public void onError(Throwable th) {
                if (!atomicBoolean.compareAndSet(false, true)) {
                    RxJavaHooks.onError(th);
                } else {
                    compositeSubscription.unsubscribe();
                    completableSubscriber.onError(th);
                }
            }

            @Override // rx.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
                compositeSubscription.add(subscription);
            }
        });
    }
}

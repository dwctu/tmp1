package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

/* loaded from: classes5.dex */
public final class OperatorRetryWithPredicate<T> implements Observable.Operator<T, Observable<T>> {
    public final Func2<Integer, Throwable, Boolean> predicate;

    public static final class SourceSubscriber<T> extends Subscriber<Observable<T>> {
        public final AtomicInteger attempts = new AtomicInteger();
        public final Subscriber<? super T> child;
        public final Scheduler.Worker inner;
        public final ProducerArbiter pa;
        public final Func2<Integer, Throwable, Boolean> predicate;
        public final SerialSubscription serialSubscription;

        public SourceSubscriber(Subscriber<? super T> subscriber, Func2<Integer, Throwable, Boolean> func2, Scheduler.Worker worker, SerialSubscription serialSubscription, ProducerArbiter producerArbiter) {
            this.child = subscriber;
            this.predicate = func2;
            this.inner = worker;
            this.serialSubscription = serialSubscription;
            this.pa = producerArbiter;
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.child.onError(th);
        }

        @Override // rx.Observer
        public void onNext(final Observable<T> observable) {
            this.inner.schedule(new Action0() { // from class: rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    SourceSubscriber.this.attempts.incrementAndGet();
                    Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1.1
                        public boolean done;

                        @Override // rx.Observer
                        public void onCompleted() {
                            if (this.done) {
                                return;
                            }
                            this.done = true;
                            SourceSubscriber.this.child.onCompleted();
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th) {
                            if (this.done) {
                                return;
                            }
                            this.done = true;
                            SourceSubscriber sourceSubscriber = SourceSubscriber.this;
                            if (!sourceSubscriber.predicate.call(Integer.valueOf(sourceSubscriber.attempts.get()), th).booleanValue() || SourceSubscriber.this.inner.isUnsubscribed()) {
                                SourceSubscriber.this.child.onError(th);
                            } else {
                                SourceSubscriber.this.inner.schedule(this);
                            }
                        }

                        @Override // rx.Observer
                        public void onNext(T t) {
                            if (this.done) {
                                return;
                            }
                            SourceSubscriber.this.child.onNext(t);
                            SourceSubscriber.this.pa.produced(1L);
                        }

                        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                        public void setProducer(Producer producer) {
                            SourceSubscriber.this.pa.setProducer(producer);
                        }
                    };
                    SourceSubscriber.this.serialSubscription.set(subscriber);
                    observable.unsafeSubscribe(subscriber);
                }
            });
        }
    }

    public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
        this.predicate = func2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super Observable<T>> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerCreateWorker = Schedulers.trampoline().createWorker();
        subscriber.add(workerCreateWorker);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        ProducerArbiter producerArbiter = new ProducerArbiter();
        subscriber.setProducer(producerArbiter);
        return new SourceSubscriber(subscriber, this.predicate, workerCreateWorker, serialSubscription, producerArbiter);
    }
}

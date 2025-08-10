package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* loaded from: classes5.dex */
public final class OperatorDelay<T> implements Observable.Operator<T, T> {
    public final long delay;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    /* renamed from: rx.internal.operators.OperatorDelay$1, reason: invalid class name */
    public class AnonymousClass1 extends Subscriber<T> {
        public boolean done;
        public final /* synthetic */ Subscriber val$child;
        public final /* synthetic */ Scheduler.Worker val$worker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Subscriber subscriber, Scheduler.Worker worker, Subscriber subscriber2) {
            super(subscriber);
            this.val$worker = worker;
            this.val$child = subscriber2;
        }

        @Override // rx.Observer
        public void onCompleted() {
            Scheduler.Worker worker = this.val$worker;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorDelay.1.1
                @Override // rx.functions.Action0
                public void call() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (anonymousClass1.done) {
                        return;
                    }
                    anonymousClass1.done = true;
                    anonymousClass1.val$child.onCompleted();
                }
            };
            OperatorDelay operatorDelay = OperatorDelay.this;
            worker.schedule(action0, operatorDelay.delay, operatorDelay.unit);
        }

        @Override // rx.Observer
        public void onError(final Throwable th) {
            this.val$worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorDelay.1.2
                @Override // rx.functions.Action0
                public void call() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (anonymousClass1.done) {
                        return;
                    }
                    anonymousClass1.done = true;
                    anonymousClass1.val$child.onError(th);
                    AnonymousClass1.this.val$worker.unsubscribe();
                }
            });
        }

        @Override // rx.Observer
        public void onNext(final T t) {
            Scheduler.Worker worker = this.val$worker;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorDelay.1.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.functions.Action0
                public void call() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (anonymousClass1.done) {
                        return;
                    }
                    anonymousClass1.val$child.onNext(t);
                }
            };
            OperatorDelay operatorDelay = OperatorDelay.this;
            worker.schedule(action0, operatorDelay.delay, operatorDelay.unit);
        }
    }

    public OperatorDelay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        subscriber.add(workerCreateWorker);
        return new AnonymousClass1(subscriber, workerCreateWorker, subscriber);
    }
}

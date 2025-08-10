package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.subjects.PublishSubject;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public class SchedulerWhen extends Scheduler implements Subscription {
    public static final Subscription SUBSCRIBED = new Subscription() { // from class: rx.internal.schedulers.SchedulerWhen.3
        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    };
    public static final Subscription UNSUBSCRIBED = Subscriptions.unsubscribed();
    private final Scheduler actualScheduler;
    private final Subscription subscription;
    private final Observer<Observable<Completable>> workerObserver;

    public static class DelayedAction extends ScheduledAction {
        private final Action0 action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Action0 action0, long j, TimeUnit timeUnit) {
            this.action = action0;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public Subscription callActual(Scheduler.Worker worker, CompletableSubscriber completableSubscriber) {
            return worker.schedule(new OnCompletedAction(this.action, completableSubscriber), this.delayTime, this.unit);
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        private final Action0 action;

        public ImmediateAction(Action0 action0) {
            this.action = action0;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public Subscription callActual(Scheduler.Worker worker, CompletableSubscriber completableSubscriber) {
            return worker.schedule(new OnCompletedAction(this.action, completableSubscriber));
        }
    }

    public static class OnCompletedAction implements Action0 {
        private Action0 action;
        private CompletableSubscriber actionCompletable;

        public OnCompletedAction(Action0 action0, CompletableSubscriber completableSubscriber) {
            this.action = action0;
            this.actionCompletable = completableSubscriber;
        }

        @Override // rx.functions.Action0
        public void call() {
            try {
                this.action.call();
            } finally {
                this.actionCompletable.onCompleted();
            }
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<Subscription> implements Subscription {
        public ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(Scheduler.Worker worker, CompletableSubscriber completableSubscriber) {
            Subscription subscription;
            Subscription subscription2 = get();
            if (subscription2 != SchedulerWhen.UNSUBSCRIBED && subscription2 == (subscription = SchedulerWhen.SUBSCRIBED)) {
                Subscription subscriptionCallActual = callActual(worker, completableSubscriber);
                if (compareAndSet(subscription, subscriptionCallActual)) {
                    return;
                }
                subscriptionCallActual.unsubscribe();
            }
        }

        public abstract Subscription callActual(Scheduler.Worker worker, CompletableSubscriber completableSubscriber);

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            Subscription subscription;
            Subscription subscription2 = SchedulerWhen.UNSUBSCRIBED;
            do {
                subscription = get();
                if (subscription == SchedulerWhen.UNSUBSCRIBED) {
                    return;
                }
            } while (!compareAndSet(subscription, subscription2));
            if (subscription != SchedulerWhen.SUBSCRIBED) {
                subscription.unsubscribe();
            }
        }
    }

    public SchedulerWhen(Func1<Observable<Observable<Completable>>, Completable> func1, Scheduler scheduler) {
        this.actualScheduler = scheduler;
        PublishSubject publishSubjectCreate = PublishSubject.create();
        this.workerObserver = new SerializedObserver(publishSubjectCreate);
        this.subscription = func1.call(publishSubjectCreate.onBackpressureBuffer()).subscribe();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        final Scheduler.Worker workerCreateWorker = this.actualScheduler.createWorker();
        BufferUntilSubscriber bufferUntilSubscriberCreate = BufferUntilSubscriber.create();
        final SerializedObserver serializedObserver = new SerializedObserver(bufferUntilSubscriberCreate);
        Object map = bufferUntilSubscriberCreate.map(new Func1<ScheduledAction, Completable>() { // from class: rx.internal.schedulers.SchedulerWhen.1
            @Override // rx.functions.Func1
            public Completable call(final ScheduledAction scheduledAction) {
                return Completable.create(new Completable.OnSubscribe() { // from class: rx.internal.schedulers.SchedulerWhen.1.1
                    @Override // rx.functions.Action1
                    public void call(CompletableSubscriber completableSubscriber) {
                        completableSubscriber.onSubscribe(scheduledAction);
                        scheduledAction.call(workerCreateWorker, completableSubscriber);
                    }
                });
            }
        });
        Scheduler.Worker worker = new Scheduler.Worker() { // from class: rx.internal.schedulers.SchedulerWhen.2
            private final AtomicBoolean unsubscribed = new AtomicBoolean();

            @Override // rx.Subscription
            public boolean isUnsubscribed() {
                return this.unsubscribed.get();
            }

            @Override // rx.Scheduler.Worker
            public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
                DelayedAction delayedAction = new DelayedAction(action0, j, timeUnit);
                serializedObserver.onNext(delayedAction);
                return delayedAction;
            }

            @Override // rx.Subscription
            public void unsubscribe() {
                if (this.unsubscribed.compareAndSet(false, true)) {
                    workerCreateWorker.unsubscribe();
                    serializedObserver.onCompleted();
                }
            }

            @Override // rx.Scheduler.Worker
            public Subscription schedule(Action0 action0) {
                ImmediateAction immediateAction = new ImmediateAction(action0);
                serializedObserver.onNext(immediateAction);
                return immediateAction;
            }
        };
        this.workerObserver.onNext(map);
        return worker;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.subscription.isUnsubscribed();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.subscription.unsubscribe();
    }
}

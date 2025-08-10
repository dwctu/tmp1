package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.schedulers.TestScheduler;
import rx.subjects.SubjectSubscriptionManager;

/* loaded from: classes5.dex */
public final class TestSubject<T> extends Subject<T, T> {
    private final Scheduler.Worker innerScheduler;
    private final SubjectSubscriptionManager<T> state;

    public TestSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager, TestScheduler testScheduler) {
        super(onSubscribe);
        this.state = subjectSubscriptionManager;
        this.innerScheduler = testScheduler.createWorker();
    }

    public static <T> TestSubject<T> create(TestScheduler testScheduler) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        Action1<SubjectSubscriptionManager.SubjectObserver<T>> action1 = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.TestSubject.1
            @Override // rx.functions.Action1
            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) throws Throwable {
                subjectObserver.emitFirst(subjectSubscriptionManager.getLatest());
            }
        };
        subjectSubscriptionManager.onAdded = action1;
        subjectSubscriptionManager.onTerminated = action1;
        return new TestSubject<>(subjectSubscriptionManager, subjectSubscriptionManager, testScheduler);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }

    public void internalOnCompleted() {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.state;
        if (subjectSubscriptionManager.active) {
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : subjectSubscriptionManager.terminate(NotificationLite.completed())) {
                subjectObserver.onCompleted();
            }
        }
    }

    public void internalOnError(Throwable th) {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.state;
        if (subjectSubscriptionManager.active) {
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : subjectSubscriptionManager.terminate(NotificationLite.error(th))) {
                subjectObserver.onError(th);
            }
        }
    }

    public void internalOnNext(T t) {
        for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.observers()) {
            subjectObserver.onNext(t);
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        onCompleted(0L);
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        onError(th, 0L);
    }

    @Override // rx.Observer
    public void onNext(T t) {
        onNext(t, 0L);
    }

    public void onCompleted(long j) {
        this.innerScheduler.schedule(new Action0() { // from class: rx.subjects.TestSubject.2
            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnCompleted();
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public void onError(final Throwable th, long j) {
        this.innerScheduler.schedule(new Action0() { // from class: rx.subjects.TestSubject.3
            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnError(th);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public void onNext(final T t, long j) {
        this.innerScheduler.schedule(new Action0() { // from class: rx.subjects.TestSubject.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnNext(t);
            }
        }, j, TimeUnit.MILLISECONDS);
    }
}

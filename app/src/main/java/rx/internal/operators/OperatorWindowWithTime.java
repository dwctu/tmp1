package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class OperatorWindowWithTime<T> implements Observable.Operator<Observable<T>, T> {
    public static final Object NEXT_SUBJECT = new Object();
    public final Scheduler scheduler;
    public final int size;
    public final long timeshift;
    public final long timespan;
    public final TimeUnit unit;

    public static final class CountedSerializedSubject<T> {
        public final Observer<T> consumer;
        public int count;
        public final Observable<T> producer;

        public CountedSerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    public final class ExactSubscriber extends Subscriber<T> {
        public final Subscriber<? super Observable<T>> child;
        public boolean emitting;
        public List<Object> queue;
        public final Scheduler.Worker worker;
        public final Object guard = new Object();
        public volatile State<T> state = State.empty();

        public ExactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker) {
            this.child = new SerializedSubscriber(subscriber);
            this.worker = worker;
            subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    if (ExactSubscriber.this.state.consumer == null) {
                        ExactSubscriber.this.unsubscribe();
                    }
                }
            }));
        }

        public void complete() {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
        
            return true;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean drain(java.util.List<java.lang.Object> r5) {
            /*
                r4 = this;
                r0 = 1
                if (r5 != 0) goto L4
                return r0
            L4:
                java.util.Iterator r5 = r5.iterator()
            L8:
                boolean r1 = r5.hasNext()
                if (r1 == 0) goto L3d
                java.lang.Object r1 = r5.next()
                java.lang.Object r2 = rx.internal.operators.OperatorWindowWithTime.NEXT_SUBJECT
                r3 = 0
                if (r1 != r2) goto L1e
                boolean r1 = r4.replaceSubject()
                if (r1 != 0) goto L8
                return r3
            L1e:
                boolean r2 = rx.internal.operators.NotificationLite.isError(r1)
                if (r2 == 0) goto L2c
                java.lang.Throwable r5 = rx.internal.operators.NotificationLite.getError(r1)
                r4.error(r5)
                goto L3d
            L2c:
                boolean r2 = rx.internal.operators.NotificationLite.isCompleted(r1)
                if (r2 == 0) goto L36
                r4.complete()
                goto L3d
            L36:
                boolean r1 = r4.emitValue(r1)
                if (r1 != 0) goto L8
                return r3
            L3d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.drain(java.util.List):boolean");
        }

        public boolean emitValue(T t) {
            State<T> next;
            State<T> state = this.state;
            if (state.consumer == null) {
                if (!replaceSubject()) {
                    return false;
                }
                state = this.state;
            }
            state.consumer.onNext(t);
            if (state.count == OperatorWindowWithTime.this.size - 1) {
                state.consumer.onCompleted();
                next = state.clear();
            } else {
                next = state.next();
            }
            this.state = next;
            return true;
        }

        public void error(Throwable th) {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        public void nextWindow() throws Throwable {
            boolean z;
            List<Object> list;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithTime.NEXT_SUBJECT);
                    return;
                }
                boolean z2 = true;
                this.emitting = true;
                try {
                    if (!replaceSubject()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.queue;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.queue = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        z = z2;
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } while (drain(list));
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(NotificationLite.completed());
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                this.emitting = true;
                try {
                    drain(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(NotificationLite.error(th));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) throws Throwable {
            List<Object> list;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(t);
                    return;
                }
                boolean z = true;
                this.emitting = true;
                try {
                    if (!emitValue(t)) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.queue;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.queue = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } while (drain(list));
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public boolean replaceSubject() {
            Observer<T> observer = this.state.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.state = this.state.clear();
                unsubscribe();
                return false;
            }
            UnicastSubject unicastSubjectCreate = UnicastSubject.create();
            this.state = this.state.create(unicastSubjectCreate, unicastSubjectCreate);
            this.child.onNext(unicastSubjectCreate);
            return true;
        }

        public void scheduleExact() {
            Scheduler.Worker worker = this.worker;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.2
                @Override // rx.functions.Action0
                public void call() throws Throwable {
                    ExactSubscriber.this.nextWindow();
                }
            };
            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
            worker.schedulePeriodically(action0, 0L, operatorWindowWithTime.timespan, operatorWindowWithTime.unit);
        }
    }

    public final class InexactSubscriber extends Subscriber<T> {
        public final Subscriber<? super Observable<T>> child;
        public final List<CountedSerializedSubject<T>> chunks;
        public boolean done;
        public final Object guard;
        public final Scheduler.Worker worker;

        public InexactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker) {
            super(subscriber);
            this.child = subscriber;
            this.worker = worker;
            this.guard = new Object();
            this.chunks = new LinkedList();
        }

        public CountedSerializedSubject<T> createCountedSerializedSubject() {
            UnicastSubject unicastSubjectCreate = UnicastSubject.create();
            return new CountedSerializedSubject<>(unicastSubjectCreate, unicastSubjectCreate);
        }

        @Override // rx.Observer
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.done = true;
                ArrayList arrayList = new ArrayList(this.chunks);
                this.chunks.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((CountedSerializedSubject) it.next()).consumer.onCompleted();
                }
                this.child.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.done = true;
                ArrayList arrayList = new ArrayList(this.chunks);
                this.chunks.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((CountedSerializedSubject) it.next()).consumer.onError(th);
                }
                this.child.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                ArrayList<CountedSerializedSubject> arrayList = new ArrayList(this.chunks);
                Iterator<CountedSerializedSubject<T>> it = this.chunks.iterator();
                while (it.hasNext()) {
                    CountedSerializedSubject<T> next = it.next();
                    int i = next.count + 1;
                    next.count = i;
                    if (i == OperatorWindowWithTime.this.size) {
                        it.remove();
                    }
                }
                for (CountedSerializedSubject countedSerializedSubject : arrayList) {
                    countedSerializedSubject.consumer.onNext(t);
                    if (countedSerializedSubject.count == OperatorWindowWithTime.this.size) {
                        countedSerializedSubject.consumer.onCompleted();
                    }
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void scheduleChunk() {
            Scheduler.Worker worker = this.worker;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            };
            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
            long j = operatorWindowWithTime.timeshift;
            worker.schedulePeriodically(action0, j, j, operatorWindowWithTime.unit);
        }

        public void startNewChunk() {
            final CountedSerializedSubject<T> countedSerializedSubjectCreateCountedSerializedSubject = createCountedSerializedSubject();
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.chunks.add(countedSerializedSubjectCreateCountedSerializedSubject);
                try {
                    this.child.onNext(countedSerializedSubjectCreateCountedSerializedSubject.producer);
                    Scheduler.Worker worker = this.worker;
                    Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.2
                        @Override // rx.functions.Action0
                        public void call() {
                            InexactSubscriber.this.terminateChunk(countedSerializedSubjectCreateCountedSerializedSubject);
                        }
                    };
                    OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
                    worker.schedule(action0, operatorWindowWithTime.timespan, operatorWindowWithTime.unit);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        public void terminateChunk(CountedSerializedSubject<T> countedSerializedSubject) {
            boolean z;
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                Iterator<CountedSerializedSubject<T>> it = this.chunks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == countedSerializedSubject) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    countedSerializedSubject.consumer.onCompleted();
                }
            }
        }
    }

    public static final class State<T> {
        public static final State<Object> EMPTY = new State<>(null, null, 0);
        public final Observer<T> consumer;
        public final int count;
        public final Observable<T> producer;

        public State(Observer<T> observer, Observable<T> observable, int i) {
            this.consumer = observer;
            this.producer = observable;
            this.count = i;
        }

        public static <T> State<T> empty() {
            return (State<T>) EMPTY;
        }

        public State<T> clear() {
            return empty();
        }

        public State<T> create(Observer<T> observer, Observable<T> observable) {
            return new State<>(observer, observable, 0);
        }

        public State<T> next() {
            return new State<>(this.consumer, this.producer, this.count + 1);
        }
    }

    public OperatorWindowWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler) {
        this.timespan = j;
        this.timeshift = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(subscriber, workerCreateWorker);
            exactSubscriber.add(workerCreateWorker);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(subscriber, workerCreateWorker);
        inexactSubscriber.add(workerCreateWorker);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }
}

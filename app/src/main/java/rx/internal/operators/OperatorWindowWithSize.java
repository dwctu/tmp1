package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.subjects.Subject;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class OperatorWindowWithSize<T> implements Observable.Operator<Observable<T>, T> {
    public final int size;
    public final int skip;

    public static final class WindowExact<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super Observable<T>> actual;
        public final Subscription cancel;
        public int index;
        public final int size;
        public Subject<T, T> window;
        public final AtomicInteger wip = new AtomicInteger(1);

        public WindowExact(Subscriber<? super Observable<T>> subscriber, int i) {
            this.actual = subscriber;
            this.size = i;
            Subscription subscriptionCreate = Subscriptions.create(this);
            this.cancel = subscriptionCreate;
            add(subscriptionCreate);
            request(0L);
        }

        @Override // rx.functions.Action0
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public Producer createProducer() {
            return new Producer() { // from class: rx.internal.operators.OperatorWindowWithSize.WindowExact.1
                @Override // rx.Producer
                public void request(long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("n >= 0 required but it was " + j);
                    }
                    if (j != 0) {
                        WindowExact.this.request(BackpressureUtils.multiplyCap(WindowExact.this.size, j));
                    }
                }
            };
        }

        @Override // rx.Observer
        public void onCompleted() {
            Subject<T, T> subject = this.window;
            if (subject != null) {
                this.window = null;
                subject.onCompleted();
            }
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            Subject<T, T> subject = this.window;
            if (subject != null) {
                this.window = null;
                subject.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            int i = this.index;
            UnicastSubject unicastSubjectCreate = this.window;
            if (i == 0) {
                this.wip.getAndIncrement();
                unicastSubjectCreate = UnicastSubject.create(this.size, this);
                this.window = unicastSubjectCreate;
                this.actual.onNext(unicastSubjectCreate);
            }
            int i2 = i + 1;
            unicastSubjectCreate.onNext(t);
            if (i2 != this.size) {
                this.index = i2;
                return;
            }
            this.index = 0;
            this.window = null;
            unicastSubjectCreate.onCompleted();
        }
    }

    public static final class WindowOverlap<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super Observable<T>> actual;
        public final Subscription cancel;
        public volatile boolean done;
        public Throwable error;
        public int index;
        public int produced;
        public final Queue<Subject<T, T>> queue;
        public final int size;
        public final int skip;
        public final AtomicInteger wip = new AtomicInteger(1);
        public final ArrayDeque<Subject<T, T>> windows = new ArrayDeque<>();
        public final AtomicInteger drainWip = new AtomicInteger();
        public final AtomicLong requested = new AtomicLong();

        public final class WindowOverlapProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 4625807964358024108L;

            public WindowOverlapProducer() {
            }

            @Override // rx.Producer
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                }
                if (j != 0) {
                    WindowOverlap windowOverlap = WindowOverlap.this;
                    if (get() || !compareAndSet(false, true)) {
                        WindowOverlap.this.request(BackpressureUtils.multiplyCap(windowOverlap.skip, j));
                    } else {
                        windowOverlap.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(windowOverlap.skip, j - 1), windowOverlap.size));
                    }
                    BackpressureUtils.getAndAddRequest(windowOverlap.requested, j);
                    windowOverlap.drain();
                }
            }
        }

        public WindowOverlap(Subscriber<? super Observable<T>> subscriber, int i, int i2) {
            this.actual = subscriber;
            this.size = i;
            this.skip = i2;
            Subscription subscriptionCreate = Subscriptions.create(this);
            this.cancel = subscriptionCreate;
            add(subscriptionCreate);
            request(0L);
            this.queue = new SpscLinkedArrayQueue((i + (i2 - 1)) / i2);
        }

        @Override // rx.functions.Action0
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super Subject<T, T>> subscriber, Queue<Subject<T, T>> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                queue.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        public Producer createProducer() {
            return new WindowOverlapProducer();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drain() {
            AtomicInteger atomicInteger = this.drainWip;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Observable<T>> subscriber = this.actual;
            Queue<Subject<T, T>> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Subject<T, T> subjectPoll = queue.poll();
                    boolean z2 = subjectPoll == null;
                    if (checkTerminated(z, z2, subscriber, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(subjectPoll);
                    j2++;
                }
                if (j2 == j && checkTerminated(this.done, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                iAddAndGet = atomicInteger.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // rx.Observer
        public void onCompleted() {
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.windows.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            int i = this.index;
            ArrayDeque<Subject<T, T>> arrayDeque = this.windows;
            if (i == 0 && !this.actual.isUnsubscribed()) {
                this.wip.getAndIncrement();
                UnicastSubject unicastSubjectCreate = UnicastSubject.create(16, this);
                arrayDeque.offer(unicastSubjectCreate);
                this.queue.offer(unicastSubjectCreate);
                drain();
            }
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            int i2 = this.produced + 1;
            if (i2 == this.size) {
                this.produced = i2 - this.skip;
                Subject<T, T> subjectPoll = arrayDeque.poll();
                if (subjectPoll != null) {
                    subjectPoll.onCompleted();
                }
            } else {
                this.produced = i2;
            }
            int i3 = i + 1;
            if (i3 == this.skip) {
                this.index = 0;
            } else {
                this.index = i3;
            }
        }
    }

    public static final class WindowSkip<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super Observable<T>> actual;
        public final Subscription cancel;
        public int index;
        public final int size;
        public final int skip;
        public Subject<T, T> window;
        public final AtomicInteger wip = new AtomicInteger(1);

        public final class WindowSkipProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 4625807964358024108L;

            public WindowSkipProducer() {
            }

            @Override // rx.Producer
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                }
                if (j != 0) {
                    WindowSkip windowSkip = WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        windowSkip.request(BackpressureUtils.multiplyCap(j, windowSkip.skip));
                    } else {
                        windowSkip.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(j, windowSkip.size), BackpressureUtils.multiplyCap(windowSkip.skip - windowSkip.size, j - 1)));
                    }
                }
            }
        }

        public WindowSkip(Subscriber<? super Observable<T>> subscriber, int i, int i2) {
            this.actual = subscriber;
            this.size = i;
            this.skip = i2;
            Subscription subscriptionCreate = Subscriptions.create(this);
            this.cancel = subscriptionCreate;
            add(subscriptionCreate);
            request(0L);
        }

        @Override // rx.functions.Action0
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public Producer createProducer() {
            return new WindowSkipProducer();
        }

        @Override // rx.Observer
        public void onCompleted() {
            Subject<T, T> subject = this.window;
            if (subject != null) {
                this.window = null;
                subject.onCompleted();
            }
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            Subject<T, T> subject = this.window;
            if (subject != null) {
                this.window = null;
                subject.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            int i = this.index;
            UnicastSubject unicastSubjectCreate = this.window;
            if (i == 0) {
                this.wip.getAndIncrement();
                unicastSubjectCreate = UnicastSubject.create(this.size, this);
                this.window = unicastSubjectCreate;
                this.actual.onNext(unicastSubjectCreate);
            }
            int i2 = i + 1;
            if (unicastSubjectCreate != null) {
                unicastSubjectCreate.onNext(t);
            }
            if (i2 == this.size) {
                this.index = i2;
                this.window = null;
                unicastSubjectCreate.onCompleted();
            } else if (i2 == this.skip) {
                this.index = 0;
            } else {
                this.index = i2;
            }
        }
    }

    public OperatorWindowWithSize(int i, int i2) {
        this.size = i;
        this.skip = i2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        int i = this.skip;
        int i2 = this.size;
        if (i == i2) {
            WindowExact windowExact = new WindowExact(subscriber, i2);
            subscriber.add(windowExact.cancel);
            subscriber.setProducer(windowExact.createProducer());
            return windowExact;
        }
        if (i > i2) {
            WindowSkip windowSkip = new WindowSkip(subscriber, i2, i);
            subscriber.add(windowSkip.cancel);
            subscriber.setProducer(windowSkip.createProducer());
            return windowSkip;
        }
        WindowOverlap windowOverlap = new WindowOverlap(subscriber, i2, i);
        subscriber.add(windowOverlap.cancel);
        subscriber.setProducer(windowOverlap.createProducer());
        return windowOverlap;
    }
}

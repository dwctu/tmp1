package rx.internal.operators;

import android.Manifest;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    public final boolean delayError;

    public static final class Holder {
        public static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);
    }

    public static final class HolderDelayError {
        public static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);
    }

    public static final class InnerSubscriber<T> extends Subscriber<T> {
        private final long id;
        private final SwitchSubscriber<T> parent;

        public InnerSubscriber(long j, SwitchSubscriber<T> switchSubscriber) {
            this.id = j;
            this.parent = switchSubscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.parent.complete(this.id);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.parent.error(th, this.id);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.parent.emit(t, this);
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.parent.innerProducer(producer, this.id);
        }
    }

    public static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        public static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        public final Subscriber<? super T> child;
        public final boolean delayError;
        public boolean emitting;
        public Throwable error;
        public boolean innerActive;
        public volatile boolean mainDone;
        public boolean missed;
        public Producer producer;
        public long requested;
        public final SerialSubscription serial = new SerialSubscription();
        public final AtomicLong index = new AtomicLong();
        public final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);

        public SwitchSubscriber(Subscriber<? super T> subscriber, boolean z) {
            this.child = subscriber;
            this.delayError = z;
        }

        public boolean checkTerminated(boolean z, boolean z2, Throwable th, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z3) {
            if (this.delayError) {
                if (!z || z2 || !z3) {
                    return false;
                }
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            }
            if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z || z2 || !z3) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        public void childRequested(long j) {
            Producer producer;
            synchronized (this) {
                producer = this.producer;
                this.requested = BackpressureUtils.addCap(this.requested, j);
            }
            if (producer != null) {
                producer.request(j);
            }
            drain();
        }

        public void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        public void complete(long j) {
            synchronized (this) {
                if (this.index.get() != j) {
                    return;
                }
                this.innerActive = false;
                this.producer = null;
                drain();
            }
        }

        public void drain() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                boolean z = this.innerActive;
                long j = this.requested;
                Throwable th3 = this.error;
                if (th3 != null && th3 != (th2 = TERMINAL_ERROR) && !this.delayError) {
                    this.error = th2;
                }
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                AtomicLong atomicLong = this.index;
                Subscriber<? super T> subscriber = this.child;
                long j2 = j;
                Throwable th4 = th3;
                boolean z2 = this.mainDone;
                while (true) {
                    long j3 = 0;
                    while (j3 != j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        boolean zIsEmpty = spscLinkedArrayQueue.isEmpty();
                        if (checkTerminated(z2, z, th4, spscLinkedArrayQueue, subscriber, zIsEmpty)) {
                            return;
                        }
                        if (zIsEmpty) {
                            break;
                        }
                        InnerSubscriber innerSubscriber = (InnerSubscriber) spscLinkedArrayQueue.poll();
                        Manifest manifest = (Object) NotificationLite.getValue(spscLinkedArrayQueue.poll());
                        if (atomicLong.get() == innerSubscriber.id) {
                            subscriber.onNext(manifest);
                            j3++;
                        }
                    }
                    if (j3 == j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (checkTerminated(this.mainDone, z, th4, spscLinkedArrayQueue, subscriber, spscLinkedArrayQueue.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j4 = this.requested;
                        if (j4 != Long.MAX_VALUE) {
                            j4 -= j3;
                            this.requested = j4;
                        }
                        j2 = j4;
                        if (!this.missed) {
                            this.emitting = false;
                            return;
                        }
                        this.missed = false;
                        z2 = this.mainDone;
                        z = this.innerActive;
                        th4 = this.error;
                        if (th4 != null && th4 != (th = TERMINAL_ERROR) && !this.delayError) {
                            this.error = th;
                        }
                    }
                }
            }
        }

        public void emit(T t, InnerSubscriber<T> innerSubscriber) {
            synchronized (this) {
                if (this.index.get() != ((InnerSubscriber) innerSubscriber).id) {
                    return;
                }
                this.queue.offer(innerSubscriber, NotificationLite.next(t));
                drain();
            }
        }

        public void error(Throwable th, long j) {
            boolean zUpdateError;
            synchronized (this) {
                if (this.index.get() == j) {
                    zUpdateError = updateError(th);
                    this.innerActive = false;
                    this.producer = null;
                } else {
                    zUpdateError = true;
                }
            }
            if (zUpdateError) {
                drain();
            } else {
                pluginError(th);
            }
        }

        public void init() {
            this.child.add(this.serial);
            this.child.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorSwitch.SwitchSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorSwitch.SwitchSubscriber.2
                @Override // rx.Producer
                public void request(long j) {
                    if (j > 0) {
                        SwitchSubscriber.this.childRequested(j);
                    } else {
                        if (j >= 0) {
                            return;
                        }
                        throw new IllegalArgumentException("n >= 0 expected but it was " + j);
                    }
                }
            });
        }

        public void innerProducer(Producer producer, long j) {
            synchronized (this) {
                if (this.index.get() != j) {
                    return;
                }
                long j2 = this.requested;
                this.producer = producer;
                producer.request(j2);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.mainDone = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            boolean zUpdateError;
            synchronized (this) {
                zUpdateError = updateError(th);
            }
            if (!zUpdateError) {
                pluginError(th);
            } else {
                this.mainDone = true;
                drain();
            }
        }

        public void pluginError(Throwable th) {
            RxJavaHooks.onError(th);
        }

        public boolean updateError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == TERMINAL_ERROR) {
                return false;
            }
            if (th2 == null) {
                this.error = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.error = new CompositeException(arrayList);
            } else {
                this.error = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // rx.Observer
        public void onNext(Observable<? extends T> observable) {
            InnerSubscriber innerSubscriber;
            long jIncrementAndGet = this.index.incrementAndGet();
            Subscription subscription = this.serial.get();
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                innerSubscriber = new InnerSubscriber(jIncrementAndGet, this);
                this.innerActive = true;
                this.producer = null;
            }
            this.serial.set(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
        }
    }

    public OperatorSwitch(boolean z) {
        this.delayError = z;
    }

    public static <T> OperatorSwitch<T> instance(boolean z) {
        return z ? (OperatorSwitch<T>) HolderDelayError.INSTANCE : (OperatorSwitch<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        SwitchSubscriber switchSubscriber = new SwitchSubscriber(subscriber, this.delayError);
        subscriber.add(switchSubscriber);
        switchSubscriber.init();
        return switchSubscriber;
    }
}

package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* loaded from: classes5.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    public static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    public static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final ParentSubscriber<T> parent;
    public final int prefetch;
    public volatile Producer producer;
    public final Queue<T> queue;
    public volatile PublishProducer<T>[] subscribers;

    public static final class ParentSubscriber<T> extends Subscriber<T> {
        public final OnSubscribePublishMulticast<T> state;

        public ParentSubscriber(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.state = onSubscribePublishMulticast;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.state.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.state.onNext(t);
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.state.setProducer(producer);
        }
    }

    public static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        public final Subscriber<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber<? super T> subscriber, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = subscriber;
            this.parent = onSubscribePublishMulticast;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j != 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                this.parent.drain();
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
        }
        this.prefetch = i;
        this.delayError = z;
        if (UnsafeAccess.isUnsafeAvailable()) {
            this.queue = new SpscArrayQueue(i);
        } else {
            this.queue = new SpscAtomicArrayQueue(i);
        }
        this.subscribers = (PublishProducer<T>[]) EMPTY;
        this.parent = new ParentSubscriber<>(this);
    }

    public boolean add(PublishProducer<T> publishProducer) {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (publishProducerArr == publishProducerArr2) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr3 = this.subscribers;
            if (publishProducerArr3 == publishProducerArr2) {
                return false;
            }
            int length = publishProducerArr3.length;
            PublishProducer<T>[] publishProducerArr4 = new PublishProducer[length + 1];
            System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, length);
            publishProducerArr4[length] = publishProducer;
            this.subscribers = publishProducerArr4;
            return true;
        }
    }

    public boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    PublishProducer<T>[] publishProducerArrTerminate = terminate();
                    int length = publishProducerArrTerminate.length;
                    while (i < length) {
                        publishProducerArrTerminate[i].actual.onError(th);
                        i++;
                    }
                    return true;
                }
                if (z2) {
                    PublishProducer<T>[] publishProducerArrTerminate2 = terminate();
                    int length2 = publishProducerArrTerminate2.length;
                    while (i < length2) {
                        publishProducerArrTerminate2[i].actual.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else if (z2) {
                PublishProducer<T>[] publishProducerArrTerminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = publishProducerArrTerminate3.length;
                    while (i < length3) {
                        publishProducerArrTerminate3[i].actual.onError(th2);
                        i++;
                    }
                } else {
                    int length4 = publishProducerArrTerminate3.length;
                    while (i < length4) {
                        publishProducerArrTerminate3[i].actual.onCompleted();
                        i++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        Queue<T> queue = this.queue;
        int iAddAndGet = 0;
        do {
            long jMin = Long.MAX_VALUE;
            PublishProducer<T>[] publishProducerArr = this.subscribers;
            int length = publishProducerArr.length;
            for (PublishProducer<T> publishProducer : publishProducerArr) {
                jMin = Math.min(jMin, publishProducer.get());
            }
            if (length != 0) {
                long j = 0;
                while (j != jMin) {
                    boolean z = this.done;
                    T tPoll = queue.poll();
                    boolean z2 = tPoll == null;
                    if (checkTerminated(z, z2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                        publishProducer2.actual.onNext(tPoll);
                    }
                    j++;
                }
                if (j == jMin && checkTerminated(this.done, queue.isEmpty())) {
                    return;
                }
                if (j != 0) {
                    Producer producer = this.producer;
                    if (producer != null) {
                        producer.request(j);
                    }
                    for (PublishProducer<T> publishProducer3 : publishProducerArr) {
                        BackpressureUtils.produced(publishProducer3, j);
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    public void remove(PublishProducer<T> publishProducer) {
        PublishProducer<?>[] publishProducerArr;
        PublishProducer[] publishProducerArr2;
        PublishProducer<T>[] publishProducerArr3 = this.subscribers;
        PublishProducer<?>[] publishProducerArr4 = TERMINATED;
        if (publishProducerArr3 == publishProducerArr4 || publishProducerArr3 == (publishProducerArr = EMPTY)) {
            return;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr5 = this.subscribers;
            if (publishProducerArr5 != publishProducerArr4 && publishProducerArr5 != publishProducerArr) {
                int i = -1;
                int length = publishProducerArr5.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (publishProducerArr5[i2] == publishProducer) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    publishProducerArr2 = EMPTY;
                } else {
                    PublishProducer[] publishProducerArr6 = new PublishProducer[length - 1];
                    System.arraycopy(publishProducerArr5, 0, publishProducerArr6, 0, i);
                    System.arraycopy(publishProducerArr5, i + 1, publishProducerArr6, i, (length - i) - 1);
                    publishProducerArr2 = publishProducerArr6;
                }
                this.subscribers = publishProducerArr2;
            }
        }
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
        producer.request(this.prefetch);
    }

    public Subscriber<T> subscriber() {
        return this.parent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<T>[] publishProducerArr2 = (PublishProducer<T>[]) TERMINATED;
        if (publishProducerArr != publishProducerArr2) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != publishProducerArr2) {
                    this.subscribers = publishProducerArr2;
                }
            }
        }
        return publishProducerArr;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        PublishProducer<T> publishProducer = new PublishProducer<>(subscriber, this);
        subscriber.add(publishProducer);
        subscriber.setProducer(publishProducer);
        if (add(publishProducer)) {
            if (publishProducer.isUnsubscribed()) {
                remove(publishProducer);
                return;
            } else {
                drain();
                return;
            }
        }
        Throwable th = this.error;
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onCompleted();
        }
    }
}

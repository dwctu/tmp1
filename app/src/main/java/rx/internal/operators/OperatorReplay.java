package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.util.OpenHashSet;
import rx.observables.ConnectableObservable;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class OperatorReplay<T> extends ConnectableObservable<T> implements Subscription {
    public static final Func0 DEFAULT_UNBOUNDED_FACTORY = new Func0() { // from class: rx.internal.operators.OperatorReplay.1
        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    public final Func0<? extends ReplayBuffer<T>> bufferFactory;
    public final AtomicReference<ReplaySubscriber<T>> current;
    public final Observable<? extends T> source;

    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public long index;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = initialHead.get();
                if (initialHead == null) {
                    return;
                }
                Object objLeaveTransform = leaveTransform(initialHead.value);
                if (NotificationLite.isCompleted(objLeaveTransform) || NotificationLite.isError(objLeaveTransform)) {
                    return;
                } else {
                    collection.add((Object) NotificationLite.getValue(objLeaveTransform));
                }
            }
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void complete() {
            Object objEnterTransform = enterTransform(NotificationLite.completed());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(objEnterTransform, j));
            truncateFinal();
        }

        public Object enterTransform(Object obj) {
            return obj;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void error(Throwable th) {
            Object objEnterTransform = enterTransform(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(objEnterTransform, j));
            truncateFinal();
        }

        public Node getInitialHead() {
            return get();
        }

        public boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isCompleted(leaveTransform(obj));
        }

        public boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isError(leaveTransform(obj));
        }

        public Object leaveTransform(Object obj) {
            return obj;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void next(T t) {
            Object objEnterTransform = enterTransform(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(objEnterTransform, j));
            truncate();
        }

        public final void removeFirst() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(node);
        }

        public final void removeSome(int i) {
            Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void replay(InnerProducer<T> innerProducer) {
            Subscriber<? super T> subscriber;
            Node node;
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
                while (!innerProducer.isUnsubscribed()) {
                    Node initialHead = (Node) innerProducer.index();
                    if (initialHead == null) {
                        initialHead = getInitialHead();
                        innerProducer.index = initialHead;
                        innerProducer.addTotalRequested(initialHead.index);
                    }
                    if (innerProducer.isUnsubscribed() || (subscriber = innerProducer.child) == null) {
                        return;
                    }
                    long j = innerProducer.get();
                    long j2 = 0;
                    while (j2 != j && (node = initialHead.get()) != null) {
                        Object objLeaveTransform = leaveTransform(node.value);
                        try {
                            if (NotificationLite.accept(subscriber, objLeaveTransform)) {
                                innerProducer.index = null;
                                return;
                            }
                            j2++;
                            if (innerProducer.isUnsubscribed()) {
                                return;
                            } else {
                                initialHead = node;
                            }
                        } catch (Throwable th) {
                            innerProducer.index = null;
                            Exceptions.throwIfFatal(th);
                            innerProducer.unsubscribe();
                            if (NotificationLite.isError(objLeaveTransform) || NotificationLite.isCompleted(objLeaveTransform)) {
                                return;
                            }
                            subscriber.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.getValue(objLeaveTransform)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerProducer.index = initialHead;
                        if (j != Long.MAX_VALUE) {
                            innerProducer.produced(j2);
                        }
                    }
                    synchronized (innerProducer) {
                        if (!innerProducer.missed) {
                            innerProducer.emitting = false;
                            return;
                        }
                        innerProducer.missed = false;
                    }
                }
            }
        }

        public final void setFirst(Node node) {
            set(node);
        }

        public void truncate() {
        }

        public void truncateFinal() {
        }
    }

    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        public static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        public Subscriber<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final ReplaySubscriber<T> parent;
        public final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        public void addTotalRequested(long j) {
            long j2;
            long j3;
            do {
                j2 = this.totalRequested.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(j2, j3));
        }

        public <U> U index() {
            return (U) this.index;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // rx.Producer
        public void request(long j) {
            long j2;
            long j3;
            if (j < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j2, j3));
            addTotalRequested(j);
            this.parent.manageRequests(this);
            this.parent.buffer.replay(this);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.remove(this);
            this.parent.manageRequests(this);
            this.child = null;
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        public final long index;
        public final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    public static final class ReplaySubscriber<T> extends Subscriber<T> implements Subscription {
        public static final InnerProducer[] EMPTY = new InnerProducer[0];
        public static final InnerProducer[] TERMINATED = new InnerProducer[0];
        public final ReplayBuffer<T> buffer;
        public boolean coordinateAll;
        public List<InnerProducer<T>> coordinationQueue;
        public boolean done;
        public boolean emitting;
        public long maxChildRequested;
        public long maxUpstreamRequested;
        public boolean missed;
        public volatile Producer producer;
        public long producersCacheVersion;
        public volatile long producersVersion;
        public volatile boolean terminated;
        public final OpenHashSet<InnerProducer<T>> producers = new OpenHashSet<>();
        public InnerProducer<T>[] producersCache = EMPTY;
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            request(0L);
        }

        public boolean add(InnerProducer<T> innerProducer) {
            Objects.requireNonNull(innerProducer);
            if (this.terminated) {
                return false;
            }
            synchronized (this.producers) {
                if (this.terminated) {
                    return false;
                }
                this.producers.add(innerProducer);
                this.producersVersion++;
                return true;
            }
        }

        public InnerProducer<T>[] copyProducers() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.producers) {
                InnerProducer<T>[] innerProducerArrValues = this.producers.values();
                int length = innerProducerArrValues.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(innerProducerArrValues, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        public void init() {
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorReplay.ReplaySubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    if (ReplaySubscriber.this.terminated) {
                        return;
                    }
                    synchronized (ReplaySubscriber.this.producers) {
                        if (!ReplaySubscriber.this.terminated) {
                            ReplaySubscriber.this.producers.terminate();
                            ReplaySubscriber.this.producersVersion++;
                            ReplaySubscriber.this.terminated = true;
                        }
                    }
                }
            }));
        }

        public void makeRequest(long j, long j2) {
            long j3 = this.maxUpstreamRequested;
            Producer producer = this.producer;
            long j4 = j - j2;
            if (j4 == 0) {
                if (j3 == 0 || producer == null) {
                    return;
                }
                this.maxUpstreamRequested = 0L;
                producer.request(j3);
                return;
            }
            this.maxChildRequested = j;
            if (producer == null) {
                long j5 = j3 + j4;
                if (j5 < 0) {
                    j5 = Long.MAX_VALUE;
                }
                this.maxUpstreamRequested = j5;
                return;
            }
            if (j3 == 0) {
                producer.request(j4);
            } else {
                this.maxUpstreamRequested = 0L;
                producer.request(j3 + j4);
            }
        }

        public void manageRequests(InnerProducer<T> innerProducer) {
            long jMax;
            List<InnerProducer<T>> list;
            boolean z;
            long jMax2;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.emitting) {
                    if (innerProducer != null) {
                        List arrayList = this.coordinationQueue;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.coordinationQueue = arrayList;
                        }
                        arrayList.add(innerProducer);
                    } else {
                        this.coordinateAll = true;
                    }
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                long j = this.maxChildRequested;
                if (innerProducer != null) {
                    jMax = Math.max(j, innerProducer.totalRequested.get());
                } else {
                    long jMax3 = j;
                    for (InnerProducer<T> innerProducer2 : copyProducers()) {
                        if (innerProducer2 != null) {
                            jMax3 = Math.max(jMax3, innerProducer2.totalRequested.get());
                        }
                    }
                    jMax = jMax3;
                }
                makeRequest(jMax, j);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.missed) {
                            this.emitting = false;
                            return;
                        }
                        this.missed = false;
                        list = this.coordinationQueue;
                        this.coordinationQueue = null;
                        z = this.coordinateAll;
                        this.coordinateAll = false;
                    }
                    long j2 = this.maxChildRequested;
                    if (list != null) {
                        Iterator<InnerProducer<T>> it = list.iterator();
                        jMax2 = j2;
                        while (it.hasNext()) {
                            jMax2 = Math.max(jMax2, it.next().totalRequested.get());
                        }
                    } else {
                        jMax2 = j2;
                    }
                    if (z) {
                        for (InnerProducer<T> innerProducer3 : copyProducers()) {
                            if (innerProducer3 != null) {
                                jMax2 = Math.max(jMax2, innerProducer3.totalRequested.get());
                            }
                        }
                    }
                    makeRequest(jMax2, j2);
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            try {
                this.buffer.complete();
                replay();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.done) {
                return;
            }
            this.done = true;
            try {
                this.buffer.error(th);
                replay();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        public void remove(InnerProducer<T> innerProducer) {
            if (this.terminated) {
                return;
            }
            synchronized (this.producers) {
                if (this.terminated) {
                    return;
                }
                this.producers.remove(innerProducer);
                if (this.producers.isEmpty()) {
                    this.producersCache = EMPTY;
                }
                this.producersVersion++;
            }
        }

        public void replay() {
            InnerProducer<T>[] innerProducerArr = this.producersCache;
            if (this.producersCacheVersion != this.producersVersion) {
                synchronized (this.producers) {
                    innerProducerArr = this.producersCache;
                    InnerProducer<T>[] innerProducerArrValues = this.producers.values();
                    int length = innerProducerArrValues.length;
                    if (innerProducerArr.length != length) {
                        innerProducerArr = new InnerProducer[length];
                        this.producersCache = innerProducerArr;
                    }
                    System.arraycopy(innerProducerArrValues, 0, innerProducerArr, 0, length);
                    this.producersCacheVersion = this.producersVersion;
                }
            }
            ReplayBuffer<T> replayBuffer = this.buffer;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    replayBuffer.replay(innerProducer);
                }
            }
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            if (this.producer != null) {
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
            this.producer = producer;
            manageRequests(null);
            replay();
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAgeInMillis;
        public final Scheduler scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, Scheduler scheduler) {
            this.scheduler = scheduler;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            return new Timestamped(this.scheduler.now(), obj);
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Node getInitialHead() {
            Node node;
            long jNow = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                Object obj = node2.value;
                Object objLeaveTransform = leaveTransform(obj);
                if (NotificationLite.isCompleted(objLeaveTransform) || NotificationLite.isError(objLeaveTransform) || ((Timestamped) obj).getTimestampMillis() > jNow) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            return ((Timestamped) obj).getValue();
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            long jNow = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i2 = this.size;
                    if (i2 <= this.limit) {
                        if (((Timestamped) node2.value).getTimestampMillis() > jNow) {
                            break;
                        }
                        i++;
                        this.size--;
                        node3 = node2.get();
                    } else {
                        i++;
                        this.size = i2 - 1;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncateFinal() {
            Node node;
            long jNow = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || this.size <= 1 || ((Timestamped) node2.value).getTimestampMillis() > jNow) {
                    break;
                }
                i++;
                this.size--;
                node3 = node2.get();
            }
            if (i != 0) {
                setFirst(node);
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.completed());
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void replay(InnerProducer<T> innerProducer) {
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
                while (!innerProducer.isUnsubscribed()) {
                    int i = this.size;
                    Integer num = (Integer) innerProducer.index();
                    int iIntValue = num != null ? num.intValue() : 0;
                    Subscriber<? super T> subscriber = innerProducer.child;
                    if (subscriber == null) {
                        return;
                    }
                    long j = innerProducer.get();
                    long j2 = 0;
                    while (j2 != j && iIntValue < i) {
                        Object obj = get(iIntValue);
                        try {
                            if (NotificationLite.accept(subscriber, obj) || innerProducer.isUnsubscribed()) {
                                return;
                            }
                            iIntValue++;
                            j2++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            innerProducer.unsubscribe();
                            if (NotificationLite.isError(obj) || NotificationLite.isCompleted(obj)) {
                                return;
                            }
                            subscriber.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.getValue(obj)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerProducer.index = Integer.valueOf(iIntValue);
                        if (j != Long.MAX_VALUE) {
                            innerProducer.produced(j2);
                        }
                    }
                    synchronized (innerProducer) {
                        if (!innerProducer.missed) {
                            innerProducer.emitting = false;
                            return;
                        }
                        innerProducer.missed = false;
                    }
                }
            }
        }
    }

    private OperatorReplay(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<ReplaySubscriber<T>> atomicReference, Func0<? extends ReplayBuffer<T>> func0) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
        this.bufferFactory = func0;
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable) {
        return create(observable, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T, U, R> Observable<R> multicastSelector(final Func0<? extends ConnectableObservable<U>> func0, final Func1<? super Observable<U>, ? extends Observable<R>> func1) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<R>() { // from class: rx.internal.operators.OperatorReplay.2
            @Override // rx.functions.Action1
            public void call(final Subscriber<? super R> subscriber) {
                try {
                    ConnectableObservable connectableObservable = (ConnectableObservable) func0.call();
                    ((Observable) func1.call(connectableObservable)).subscribe((Subscriber) subscriber);
                    connectableObservable.connect(new Action1<Subscription>() { // from class: rx.internal.operators.OperatorReplay.2.1
                        @Override // rx.functions.Action1
                        public void call(Subscription subscription) {
                            subscriber.add(subscription);
                        }
                    });
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber);
                }
            }
        });
    }

    public static <T> ConnectableObservable<T> observeOn(final ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        final Observable<T> observableObserveOn = connectableObservable.observeOn(scheduler);
        return new ConnectableObservable<T>(new Observable.OnSubscribe<T>() { // from class: rx.internal.operators.OperatorReplay.3
            @Override // rx.functions.Action1
            public void call(final Subscriber<? super T> subscriber) {
                observableObserveOn.unsafeSubscribe(new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorReplay.3.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    @Override // rx.Observer
                    public void onNext(T t) {
                        subscriber.onNext(t);
                    }
                });
            }
        }) { // from class: rx.internal.operators.OperatorReplay.4
            @Override // rx.observables.ConnectableObservable
            public void connect(Action1<? super Subscription> action1) {
                connectableObservable.connect(action1);
            }
        };
    }

    @Override // rx.observables.ConnectableObservable
    public void connect(Action1<? super Subscription> action1) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isUnsubscribed()) {
                break;
            }
            ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.call());
            replaySubscriber2.init();
            if (this.current.compareAndSet(replaySubscriber, replaySubscriber2)) {
                replaySubscriber = replaySubscriber2;
                break;
            }
        }
        boolean z = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        action1.call(replaySubscriber);
        if (z) {
            this.source.unsafeSubscribe(replaySubscriber);
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        ReplaySubscriber<T> replaySubscriber = this.current.get();
        return replaySubscriber == null || replaySubscriber.isUnsubscribed();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.current.lazySet(null);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, final int i) {
        return i == Integer.MAX_VALUE ? create(observable) : create(observable, new Func0<ReplayBuffer<T>>() { // from class: rx.internal.operators.OperatorReplay.5
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeBoundReplayBuffer(i);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(observable, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j, TimeUnit timeUnit, final Scheduler scheduler, final int i) {
        final long millis = timeUnit.toMillis(j);
        return create(observable, new Func0<ReplayBuffer<T>>() { // from class: rx.internal.operators.OperatorReplay.6
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeAndTimeBoundReplayBuffer(i, millis, scheduler);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, final Func0<? extends ReplayBuffer<T>> func0) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new Observable.OnSubscribe<T>() { // from class: rx.internal.operators.OperatorReplay.7
            @Override // rx.functions.Action1
            public void call(Subscriber<? super T> subscriber) {
                ReplaySubscriber replaySubscriber;
                while (true) {
                    replaySubscriber = (ReplaySubscriber) atomicReference.get();
                    if (replaySubscriber != null) {
                        break;
                    }
                    ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) func0.call());
                    replaySubscriber2.init();
                    if (atomicReference.compareAndSet(replaySubscriber, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                }
                InnerProducer<T> innerProducer = new InnerProducer<>(replaySubscriber, subscriber);
                replaySubscriber.add((InnerProducer) innerProducer);
                subscriber.add(innerProducer);
                replaySubscriber.buffer.replay(innerProducer);
                subscriber.setProducer(innerProducer);
            }
        }, observable, atomicReference, func0);
    }
}

package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.UtilityFunctions;
import rx.observables.GroupedObservable;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class OperatorGroupBy<T, K, V> implements Observable.Operator<GroupedObservable<K, V>, T> {
    public final int bufferSize;
    public final boolean delayError;
    public final Func1<? super T, ? extends K> keySelector;
    public final Func1<Action1<K>, Map<K, Object>> mapFactory;
    public final Func1<? super T, ? extends V> valueSelector;

    public static final class GroupByProducer implements Producer {
        public final GroupBySubscriber<?, ?, ?> parent;

        public GroupByProducer(GroupBySubscriber<?, ?, ?> groupBySubscriber) {
            this.parent = groupBySubscriber;
        }

        @Override // rx.Producer
        public void request(long j) {
            this.parent.requestMore(j);
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        public final State<T, K> state;

        public GroupedUnicast(K k, State<T, K> state) {
            super(k, state);
            this.state = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new GroupedUnicast<>(k, new State(i, groupBySubscriber, k, z));
        }

        public void onComplete() {
            this.state.onComplete();
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }
    }

    public static final class State<T, K> extends AtomicInteger implements Producer, Subscription, Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public final GroupBySubscriber<?, K, T> parent;
        public final Queue<Object> queue = new ConcurrentLinkedQueue();
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        public final AtomicBoolean once = new AtomicBoolean();
        public final AtomicLong requested = new AtomicLong();

        public State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Queue<Object> queue = this.queue;
            boolean z = this.delayError;
            Subscriber<? super T> subscriber = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (subscriber != null) {
                    if (checkTerminated(this.done, queue.isEmpty(), subscriber, z)) {
                        return;
                    }
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z2 = this.done;
                        Object objPoll = queue.poll();
                        boolean z3 = objPoll == null;
                        if (checkTerminated(z2, z3, subscriber, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        subscriber.onNext((Object) NotificationLite.getValue(objPoll));
                        j2++;
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            BackpressureUtils.produced(this.requested, j2);
                        }
                        this.parent.s.request(j2);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            if (t == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.next(t));
            }
            drain();
        }

        @Override // rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
            if (j != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.parent.cancel(this.key);
            }
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            if (!this.once.compareAndSet(false, true)) {
                subscriber.onError(new IllegalStateException("Only one Subscriber allowed!"));
                return;
            }
            subscriber.add(this);
            subscriber.setProducer(this);
            this.actual.lazySet(subscriber);
            drain();
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1) {
        this(func1, UtilityFunctions.identity(), RxRingBuffer.SIZE, false, null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, RxRingBuffer.SIZE, false, null);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> subscriber) {
        try {
            final GroupBySubscriber groupBySubscriber = new GroupBySubscriber(subscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, this.mapFactory);
            subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorGroupBy.1
                @Override // rx.functions.Action0
                public void call() {
                    groupBySubscriber.cancel();
                }
            }));
            subscriber.setProducer(groupBySubscriber.producer);
            return groupBySubscriber;
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
            Subscriber<? super T> subscriberEmpty = Subscribers.empty();
            subscriberEmpty.unsubscribe();
            return subscriberEmpty;
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends Subscriber<T> {
        public static final Object NULL_KEY = new Object();
        public final Subscriber<? super GroupedObservable<K, V>> actual;
        public final int bufferSize;
        public final AtomicBoolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final Queue<K> evictedKeys;
        public final AtomicInteger groupCount;
        public final Map<Object, GroupedUnicast<K, V>> groups;
        public final Func1<? super T, ? extends K> keySelector;
        public final GroupByProducer producer;
        public final Queue<GroupedObservable<K, V>> queue = new ConcurrentLinkedQueue();
        public final AtomicLong requested;
        public final ProducerArbiter s;
        public final Func1<? super T, ? extends V> valueSelector;
        public final AtomicInteger wip;

        public static class EvictionAction<K> implements Action1<K> {
            public final Queue<K> evictedKeys;

            public EvictionAction(Queue<K> queue) {
                this.evictedKeys = queue;
            }

            @Override // rx.functions.Action1
            public void call(K k) {
                this.evictedKeys.offer(k);
            }
        }

        public GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> subscriber, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i, boolean z, Func1<Action1<K>, Map<K, Object>> func13) {
            this.actual = subscriber;
            this.keySelector = func1;
            this.valueSelector = func12;
            this.bufferSize = i;
            this.delayError = z;
            ProducerArbiter producerArbiter = new ProducerArbiter();
            this.s = producerArbiter;
            producerArbiter.request(i);
            this.producer = new GroupByProducer(this);
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.wip = new AtomicInteger();
            if (func13 == null) {
                this.groups = new ConcurrentHashMap();
                this.evictedKeys = null;
            } else {
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                this.evictedKeys = concurrentLinkedQueue;
                this.groups = createMap(func13, new EvictionAction(concurrentLinkedQueue));
            }
        }

        private Map<Object, GroupedUnicast<K, V>> createMap(Func1<Action1<K>, Map<K, Object>> func1, Action1<K> action1) {
            return func1.call(action1);
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue) {
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                errorAll(subscriber, queue, th);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.actual.onCompleted();
            return true;
        }

        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Queue<GroupedObservable<K, V>> queue = this.queue;
            Subscriber<? super GroupedObservable<K, V>> subscriber = this.actual;
            int iAddAndGet = 1;
            while (!checkTerminated(this.done, queue.isEmpty(), subscriber, queue)) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    GroupedObservable<K, V> groupedObservablePoll = queue.poll();
                    boolean z2 = groupedObservablePoll == null;
                    if (checkTerminated(z, z2, subscriber, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(groupedObservablePoll);
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        BackpressureUtils.produced(this.requested, j2);
                    }
                    this.s.request(j2);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public void errorAll(Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue, Throwable th) {
            queue.clear();
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Queue<K> queue2 = this.evictedKeys;
            if (queue2 != null) {
                queue2.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).onError(th);
            }
            subscriber.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            Iterator<GroupedUnicast<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groups.clear();
            Queue<K> queue = this.evictedKeys;
            if (queue != null) {
                queue.clear();
            }
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            Queue<?> queue = this.queue;
            Subscriber<? super GroupedObservable<K, V>> subscriber = this.actual;
            try {
                K kCall = this.keySelector.call(t);
                boolean z = false;
                Object obj = kCall != null ? kCall : NULL_KEY;
                GroupedUnicast<K, V> groupedUnicastCreateWith = this.groups.get(obj);
                if (groupedUnicastCreateWith == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    groupedUnicastCreateWith = GroupedUnicast.createWith(kCall, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, groupedUnicastCreateWith);
                    this.groupCount.getAndIncrement();
                    z = true;
                }
                try {
                    groupedUnicastCreateWith.onNext(this.valueSelector.call(t));
                    if (this.evictedKeys != null) {
                        while (true) {
                            K kPoll = this.evictedKeys.poll();
                            if (kPoll == null) {
                                break;
                            }
                            GroupedUnicast<K, V> groupedUnicast = this.groups.get(kPoll);
                            if (groupedUnicast != null) {
                                groupedUnicast.onComplete();
                            }
                        }
                    }
                    if (z) {
                        queue.offer(groupedUnicastCreateWith);
                        drain();
                    }
                } catch (Throwable th) {
                    unsubscribe();
                    errorAll(subscriber, queue, th);
                }
            } catch (Throwable th2) {
                unsubscribe();
                errorAll(subscriber, queue, th2);
            }
        }

        public void requestMore(long j) {
            if (j >= 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.s.setProducer(producer);
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            if (this.groups.remove(k) == null || this.groupCount.decrementAndGet() != 0) {
                return;
            }
            unsubscribe();
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func1<Action1<K>, Map<K, Object>> func13) {
        this(func1, func12, RxRingBuffer.SIZE, false, func13);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i, boolean z, Func1<Action1<K>, Map<K, Object>> func13) {
        this.keySelector = func1;
        this.valueSelector = func12;
        this.bufferSize = i;
        this.delayError = z;
        this.mapFactory = func13;
    }
}

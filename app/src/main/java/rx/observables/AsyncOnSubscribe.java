package rx.observables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Beta;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

@Beta
/* loaded from: classes5.dex */
public abstract class AsyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {

    public static final class AsyncOuterManager<S, T> implements Producer, Subscription, Observer<Observable<? extends T>> {
        public Producer concatProducer;
        public boolean emitting;
        public long expectedDelivery;
        private boolean hasTerminated;
        private final UnicastSubject<Observable<T>> merger;
        private boolean onNextCalled;
        private final AsyncOnSubscribe<S, T> parent;
        public List<Long> requests;
        private S state;
        public final CompositeSubscription subscriptions = new CompositeSubscription();
        private final SerializedObserver<Observable<? extends T>> serializedSubscriber = new SerializedObserver<>(this);
        public final AtomicBoolean isUnsubscribed = new AtomicBoolean();

        public AsyncOuterManager(AsyncOnSubscribe<S, T> asyncOnSubscribe, S s, UnicastSubject<Observable<T>> unicastSubject) {
            this.parent = asyncOnSubscribe;
            this.state = s;
            this.merger = unicastSubject;
        }

        private void handleThrownError(Throwable th) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(th);
                return;
            }
            this.hasTerminated = true;
            this.merger.onError(th);
            cleanup();
        }

        private void subscribeBufferToObservable(Observable<? extends T> observable) {
            BufferUntilSubscriber bufferUntilSubscriberCreate = BufferUntilSubscriber.create();
            final Subscriber<T> subscriber = new Subscriber<T>(this.expectedDelivery, bufferUntilSubscriberCreate) { // from class: rx.observables.AsyncOnSubscribe.AsyncOuterManager.1
                public long remaining;
                public final /* synthetic */ BufferUntilSubscriber val$buffer;
                public final /* synthetic */ long val$expected;

                {
                    this.val$expected = j;
                    this.val$buffer = bufferUntilSubscriberCreate;
                    this.remaining = j;
                }

                @Override // rx.Observer
                public void onCompleted() {
                    this.val$buffer.onCompleted();
                    long j = this.remaining;
                    if (j > 0) {
                        AsyncOuterManager.this.requestRemaining(j);
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    this.val$buffer.onError(th);
                }

                @Override // rx.Observer
                public void onNext(T t) {
                    this.remaining--;
                    this.val$buffer.onNext(t);
                }
            };
            this.subscriptions.add(subscriber);
            observable.doOnTerminate(new Action0() { // from class: rx.observables.AsyncOnSubscribe.AsyncOuterManager.2
                @Override // rx.functions.Action0
                public void call() {
                    AsyncOuterManager.this.subscriptions.remove(subscriber);
                }
            }).subscribe((Subscriber<? super Object>) subscriber);
            this.merger.onNext(bufferUntilSubscriberCreate);
        }

        public void cleanup() {
            this.subscriptions.unsubscribe();
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable th) {
                handleThrownError(th);
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.isUnsubscribed.get();
        }

        public void nextIteration(long j) {
            this.state = this.parent.next(this.state, j, this.serializedSubscriber);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.merger.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.merger.onError(th);
        }

        @Override // rx.Producer
        public void request(long j) {
            boolean z;
            if (j == 0) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException("Request can't be negative! " + j);
            }
            synchronized (this) {
                z = true;
                if (this.emitting) {
                    List arrayList = this.requests;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        this.requests = arrayList;
                    }
                    arrayList.add(Long.valueOf(j));
                } else {
                    this.emitting = true;
                    z = false;
                }
            }
            this.concatProducer.request(j);
            if (z || tryEmit(j)) {
                return;
            }
            while (true) {
                synchronized (this) {
                    List<Long> list = this.requests;
                    if (list == null) {
                        this.emitting = false;
                        return;
                    }
                    this.requests = null;
                    Iterator<Long> it = list.iterator();
                    while (it.hasNext()) {
                        if (tryEmit(it.next().longValue())) {
                            return;
                        }
                    }
                }
            }
        }

        public void requestRemaining(long j) {
            if (j == 0) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException("Request can't be negative! " + j);
            }
            synchronized (this) {
                if (this.emitting) {
                    List arrayList = this.requests;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        this.requests = arrayList;
                    }
                    arrayList.add(Long.valueOf(j));
                    return;
                }
                this.emitting = true;
                if (tryEmit(j)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list = this.requests;
                        if (list == null) {
                            this.emitting = false;
                            return;
                        }
                        this.requests = null;
                        Iterator<Long> it = list.iterator();
                        while (it.hasNext()) {
                            if (tryEmit(it.next().longValue())) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        public void setConcatProducer(Producer producer) {
            if (this.concatProducer != null) {
                throw new IllegalStateException("setConcatProducer may be called at most once!");
            }
            this.concatProducer = producer;
        }

        public boolean tryEmit(long j) {
            if (isUnsubscribed()) {
                cleanup();
                return true;
            }
            try {
                this.onNextCalled = false;
                this.expectedDelivery = j;
                nextIteration(j);
                if (!this.hasTerminated && !isUnsubscribed()) {
                    if (this.onNextCalled) {
                        return false;
                    }
                    handleThrownError(new IllegalStateException("No events emitted!"));
                    return true;
                }
                cleanup();
                return true;
            } catch (Throwable th) {
                handleThrownError(th);
                return true;
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.isUnsubscribed.compareAndSet(false, true)) {
                synchronized (this) {
                    if (!this.emitting) {
                        this.emitting = true;
                        cleanup();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        this.requests = arrayList;
                        arrayList.add(0L);
                    }
                }
            }
        }

        @Override // rx.Observer
        public void onNext(Observable<? extends T> observable) {
            if (this.onNextCalled) {
                throw new IllegalStateException("onNext called multiple times!");
            }
            this.onNextCalled = true;
            if (this.hasTerminated) {
                return;
            }
            subscribeBufferToObservable(observable);
        }
    }

    public static final class UnicastSubject<T> extends Observable<T> implements Observer<T> {
        private final State<T> state;

        public static final class State<T> implements Observable.OnSubscribe<T> {
            public Subscriber<? super T> subscriber;

            @Override // rx.functions.Action1
            public void call(Subscriber<? super T> subscriber) {
                synchronized (this) {
                    if (this.subscriber == null) {
                        this.subscriber = subscriber;
                    } else {
                        subscriber.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }

        public UnicastSubject(State<T> state) {
            super(state);
            this.state = state;
        }

        public static <T> UnicastSubject<T> create() {
            return new UnicastSubject<>(new State());
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.subscriber.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.state.subscriber.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.state.subscriber.onNext(t);
        }
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() { // from class: rx.observables.AsyncOnSubscribe.1
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Object call(Object obj, Long l, Object obj2) {
                return call((AnonymousClass1) obj, l, (Observer) obj2);
            }

            public S call(S s, Long l, Observer<Observable<? extends T>> observer) {
                action3.call(s, l, observer);
                return s;
            }
        });
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, func3, action1);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() { // from class: rx.observables.AsyncOnSubscribe.3
            @Override // rx.functions.Func3
            public Void call(Void r2, Long l, Observer<Observable<? extends T>> observer) {
                action2.call(l, observer);
                return r2;
            }
        });
    }

    public abstract S generateState();

    public abstract S next(S s, long j, Observer<Observable<? extends T>> observer);

    public void onUnsubscribe(S s) {
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
        return new AsyncOnSubscribeImpl(func0, func3);
    }

    @Override // rx.functions.Action1
    public final void call(final Subscriber<? super T> subscriber) {
        try {
            S sGenerateState = generateState();
            UnicastSubject unicastSubjectCreate = UnicastSubject.create();
            final AsyncOuterManager asyncOuterManager = new AsyncOuterManager(this, sGenerateState, unicastSubjectCreate);
            Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.observables.AsyncOnSubscribe.6
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

                @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                public void setProducer(Producer producer) {
                    asyncOuterManager.setConcatProducer(producer);
                }
            };
            unicastSubjectCreate.onBackpressureBuffer().concatMap(new Func1<Observable<T>, Observable<T>>() { // from class: rx.observables.AsyncOnSubscribe.7
                @Override // rx.functions.Func1
                public Observable<T> call(Observable<T> observable) {
                    return observable.onBackpressureBuffer();
                }
            }).unsafeSubscribe(subscriber2);
            subscriber.add(subscriber2);
            subscriber.add(asyncOuterManager);
            subscriber.setProducer(asyncOuterManager);
        } catch (Throwable th) {
            subscriber.onError(th);
        }
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() { // from class: rx.observables.AsyncOnSubscribe.2
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Object call(Object obj, Long l, Object obj2) {
                return call((AnonymousClass2) obj, l, (Observer) obj2);
            }

            public S call(S s, Long l, Observer<Observable<? extends T>> observer) {
                action3.call(s, l, observer);
                return s;
            }
        }, action1);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2, final Action0 action0) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() { // from class: rx.observables.AsyncOnSubscribe.4
            @Override // rx.functions.Func3
            public Void call(Void r1, Long l, Observer<Observable<? extends T>> observer) {
                action2.call(l, observer);
                return null;
            }
        }, new Action1<Void>() { // from class: rx.observables.AsyncOnSubscribe.5
            @Override // rx.functions.Action1
            public void call(Void r1) {
                action0.call();
            }
        });
    }

    public static final class AsyncOnSubscribeImpl<S, T> extends AsyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
            this.generator = func0;
            this.next = func3;
            this.onUnsubscribe = action1;
        }

        @Override // rx.observables.AsyncOnSubscribe, rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((Subscriber) obj);
        }

        @Override // rx.observables.AsyncOnSubscribe
        public S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        @Override // rx.observables.AsyncOnSubscribe
        public S next(S s, long j, Observer<Observable<? extends T>> observer) {
            return this.next.call(s, Long.valueOf(j), observer);
        }

        @Override // rx.observables.AsyncOnSubscribe
        public void onUnsubscribe(S s) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(s);
            }
        }

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
            this(func0, func3, null);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3, Action1<? super S> action1) {
            this(null, func3, action1);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3) {
            this(null, func3, null);
        }
    }
}

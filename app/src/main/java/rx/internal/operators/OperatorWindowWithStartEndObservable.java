package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.CompositeSubscription;

/* loaded from: classes5.dex */
public final class OperatorWindowWithStartEndObservable<T, U, V> implements Observable.Operator<Observable<T>, T> {
    public final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
    public final Observable<? extends U> windowOpenings;

    public static final class SerializedSubject<T> {
        public final Observer<T> consumer;
        public final Observable<T> producer;

        public SerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    public final class SourceSubscriber extends Subscriber<T> {
        public final Subscriber<? super Observable<T>> child;
        public final CompositeSubscription composite;
        public boolean done;
        public final Object guard = new Object();
        public final List<SerializedSubject<T>> chunks = new LinkedList();

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber, CompositeSubscription compositeSubscription) {
            this.child = new SerializedSubscriber(subscriber);
            this.composite = compositeSubscription;
        }

        public void beginWindow(U u) {
            final SerializedSubject<T> serializedSubjectCreateSerializedSubject = createSerializedSubject();
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.chunks.add(serializedSubjectCreateSerializedSubject);
                this.child.onNext(serializedSubjectCreateSerializedSubject.producer);
                try {
                    Observable<? extends V> observableCall = OperatorWindowWithStartEndObservable.this.windowClosingSelector.call(u);
                    Subscriber<V> subscriber = new Subscriber<V>() { // from class: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.1
                        public boolean once = true;

                        @Override // rx.Observer
                        public void onCompleted() {
                            if (this.once) {
                                this.once = false;
                                SourceSubscriber.this.endWindow(serializedSubjectCreateSerializedSubject);
                                SourceSubscriber.this.composite.remove(this);
                            }
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th) {
                            SourceSubscriber.this.onError(th);
                        }

                        @Override // rx.Observer
                        public void onNext(V v) {
                            onCompleted();
                        }
                    };
                    this.composite.add(subscriber);
                    observableCall.unsafeSubscribe(subscriber);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        public SerializedSubject<T> createSerializedSubject() {
            UnicastSubject unicastSubjectCreate = UnicastSubject.create();
            return new SerializedSubject<>(unicastSubjectCreate, unicastSubjectCreate);
        }

        public void endWindow(SerializedSubject<T> serializedSubject) {
            boolean z;
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                Iterator<SerializedSubject<T>> it = this.chunks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == serializedSubject) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    serializedSubject.consumer.onCompleted();
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                synchronized (this.guard) {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    ArrayList arrayList = new ArrayList(this.chunks);
                    this.chunks.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((SerializedSubject) it.next()).consumer.onCompleted();
                    }
                    this.child.onCompleted();
                }
            } finally {
                this.composite.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            try {
                synchronized (this.guard) {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    ArrayList arrayList = new ArrayList(this.chunks);
                    this.chunks.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((SerializedSubject) it.next()).consumer.onError(th);
                    }
                    this.child.onError(th);
                }
            } finally {
                this.composite.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                Iterator it = new ArrayList(this.chunks).iterator();
                while (it.hasNext()) {
                    ((SerializedSubject) it.next()).consumer.onNext(t);
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorWindowWithStartEndObservable(Observable<? extends U> observable, Func1<? super U, ? extends Observable<? extends V>> func1) {
        this.windowOpenings = observable;
        this.windowClosingSelector = func1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        subscriber.add(compositeSubscription);
        final SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber, compositeSubscription);
        Subscriber<U> subscriber2 = new Subscriber<U>() { // from class: rx.internal.operators.OperatorWindowWithStartEndObservable.1
            @Override // rx.Observer
            public void onCompleted() {
                sourceSubscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                sourceSubscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(U u) {
                sourceSubscriber.beginWindow(u);
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
        compositeSubscription.add(sourceSubscriber);
        compositeSubscription.add(subscriber2);
        this.windowOpenings.unsafeSubscribe(subscriber2);
        return sourceSubscriber;
    }
}

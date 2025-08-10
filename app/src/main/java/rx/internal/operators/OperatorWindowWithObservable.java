package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;

/* loaded from: classes5.dex */
public final class OperatorWindowWithObservable<T, U> implements Observable.Operator<Observable<T>, T> {
    public static final Object NEXT_SUBJECT = new Object();
    public final Observable<U> other;

    public static final class BoundarySubscriber<T, U> extends Subscriber<U> {
        public final SourceSubscriber<T> sub;

        public BoundarySubscriber(SourceSubscriber<T> sourceSubscriber) {
            this.sub = sourceSubscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.sub.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.sub.onError(th);
        }

        @Override // rx.Observer
        public void onNext(U u) throws Throwable {
            this.sub.replaceWindow();
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public static final class SourceSubscriber<T> extends Subscriber<T> {
        public final Subscriber<? super Observable<T>> child;
        public Observer<T> consumer;
        public boolean emitting;
        public final Object guard = new Object();
        public Observable<T> producer;
        public List<Object> queue;

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber) {
            this.child = new SerializedSubscriber(subscriber);
        }

        public void complete() {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        public void createNewWindow() {
            UnicastSubject unicastSubjectCreate = UnicastSubject.create();
            this.consumer = unicastSubjectCreate;
            this.producer = unicastSubjectCreate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drain(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == OperatorWindowWithObservable.NEXT_SUBJECT) {
                    replaceSubject();
                } else if (NotificationLite.isError(obj)) {
                    error(NotificationLite.getError(obj));
                    return;
                } else {
                    if (NotificationLite.isCompleted(obj)) {
                        complete();
                        return;
                    }
                    emitValue(obj);
                }
            }
        }

        public void emitValue(T t) {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onNext(t);
            }
        }

        public void error(Throwable th) {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
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
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(t);
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                boolean z = true;
                this.emitting = true;
                boolean z2 = true;
                while (true) {
                    try {
                        drain(list);
                        if (z2) {
                            emitValue(t);
                            z2 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    List<Object> list2 = this.queue;
                                    this.queue = null;
                                    if (list2 == null) {
                                        this.emitting = false;
                                        return;
                                    } else {
                                        if (this.child.isUnsubscribed()) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        list = list2;
                                    }
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
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void replaceSubject() {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            createNewWindow();
            this.child.onNext(this.producer);
        }

        public void replaceWindow() throws Throwable {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithObservable.NEXT_SUBJECT);
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                boolean z = true;
                this.emitting = true;
                boolean z2 = true;
                while (true) {
                    try {
                        drain(list);
                        if (z2) {
                            replaceSubject();
                            z2 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    List<Object> list2 = this.queue;
                                    this.queue = null;
                                    if (list2 == null) {
                                        this.emitting = false;
                                        return;
                                    } else {
                                        if (this.child.isUnsubscribed()) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        list = list2;
                                    }
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
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }
    }

    public OperatorWindowWithObservable(Observable<U> observable) {
        this.other = observable;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) throws Throwable {
        SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber);
        BoundarySubscriber boundarySubscriber = new BoundarySubscriber(sourceSubscriber);
        subscriber.add(sourceSubscriber);
        subscriber.add(boundarySubscriber);
        sourceSubscriber.replaceWindow();
        this.other.unsafeSubscribe(boundarySubscriber);
        return sourceSubscriber;
    }
}

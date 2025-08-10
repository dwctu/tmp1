package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class BufferUntilSubscriber<T> extends Subject<T, T> {
    public static final Observer EMPTY_OBSERVER = new Observer() { // from class: rx.internal.operators.BufferUntilSubscriber.1
        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
        }

        @Override // rx.Observer
        public void onNext(Object obj) {
        }
    };
    private boolean forward;
    public final State<T> state;

    public static final class OnSubscribeAction<T> implements Observable.OnSubscribe<T> {
        public final State<T> state;

        public OnSubscribeAction(State<T> state) {
            this.state = state;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            boolean z;
            if (!this.state.casObserverRef(null, subscriber)) {
                subscriber.onError(new IllegalStateException("Only one subscriber allowed!"));
                return;
            }
            subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction.1
                @Override // rx.functions.Action0
                public void call() {
                    OnSubscribeAction.this.state.set(BufferUntilSubscriber.EMPTY_OBSERVER);
                }
            }));
            synchronized (this.state.guard) {
                State<T> state = this.state;
                z = true;
                if (state.emitting) {
                    z = false;
                } else {
                    state.emitting = true;
                }
            }
            if (!z) {
                return;
            }
            while (true) {
                Object objPoll = this.state.buffer.poll();
                if (objPoll != null) {
                    NotificationLite.accept(this.state.get(), objPoll);
                } else {
                    synchronized (this.state.guard) {
                        if (this.state.buffer.isEmpty()) {
                            this.state.emitting = false;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final class State<T> extends AtomicReference<Observer<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(Observer<? super T> observer, Observer<? super T> observer2) {
            return compareAndSet(observer, observer2);
        }
    }

    private BufferUntilSubscriber(State<T> state) {
        super(new OnSubscribeAction(state));
        this.state = state;
    }

    public static <T> BufferUntilSubscriber<T> create() {
        return new BufferUntilSubscriber<>(new State());
    }

    private void emit(Object obj) {
        synchronized (this.state.guard) {
            this.state.buffer.add(obj);
            if (this.state.get() != null) {
                State<T> state = this.state;
                if (!state.emitting) {
                    this.forward = true;
                    state.emitting = true;
                }
            }
        }
        if (!this.forward) {
            return;
        }
        while (true) {
            Object objPoll = this.state.buffer.poll();
            if (objPoll == null) {
                return;
            } else {
                NotificationLite.accept(this.state.get(), objPoll);
            }
        }
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        boolean z;
        synchronized (this.state.guard) {
            z = this.state.get() != null;
        }
        return z;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.forward) {
            this.state.get().onCompleted();
        } else {
            emit(NotificationLite.completed());
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        if (this.forward) {
            this.state.get().onError(th);
        } else {
            emit(NotificationLite.error(th));
        }
    }

    @Override // rx.Observer
    public void onNext(T t) {
        if (this.forward) {
            this.state.get().onNext(t);
        } else {
            emit(NotificationLite.next(t));
        }
    }
}

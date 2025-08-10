package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableRefCount<T> extends Flowable<T> {
    public RefConnection connection;
    public final int n;
    public final Scheduler scheduler;
    public final ConnectableFlowable<T> source;
    public final long timeout;
    public final TimeUnit unit;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        public boolean connected;
        public boolean disconnectedEarly;
        public final FlowableRefCount<?> parent;
        public long subscriberCount;
        public Disposable timer;

        public RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.timeout(this);
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ResettableConnectable) this.parent.source).resetIf(disposable);
                }
            }
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        public final RefConnection connection;
        public final Subscriber<? super T> downstream;
        public final FlowableRefCount<T> parent;
        public Subscription upstream;

        public RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.downstream = subscriber;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.cancel(this.connection);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                RxJavaPlugins.onError(th);
            } else {
                this.parent.terminated(this.connection);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    public void cancel(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.connection;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0 && refConnection.connected) {
                    if (this.timeout == 0) {
                        timeout(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.replace(this.scheduler.scheduleDirect(refConnection, this.timeout, this.unit));
                }
            }
        }
    }

    public void clearTimer(RefConnection refConnection) {
        Disposable disposable = refConnection.timer;
        if (disposable != null) {
            disposable.dispose();
            refConnection.timer = null;
        }
    }

    public void reset(RefConnection refConnection) {
        ConnectableFlowable<T> connectableFlowable = this.source;
        if (connectableFlowable instanceof Disposable) {
            ((Disposable) connectableFlowable).dispose();
        } else if (connectableFlowable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableFlowable).resetIf(refConnection.get());
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z;
        Disposable disposable;
        synchronized (this) {
            refConnection = this.connection;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.connection = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && (disposable = refConnection.timer) != null) {
                disposable.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != this.n) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.source.subscribe((FlowableSubscriber) new RefCountSubscriber(subscriber, this, refConnection));
        if (z) {
            this.source.connect(refConnection);
        }
    }

    public void terminated(RefConnection refConnection) {
        synchronized (this) {
            if (this.source instanceof FlowablePublishClassic) {
                RefConnection refConnection2 = this.connection;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.connection = null;
                    clearTimer(refConnection);
                }
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0) {
                    reset(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.connection;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    clearTimer(refConnection);
                    long j2 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j2;
                    if (j2 == 0) {
                        this.connection = null;
                        reset(refConnection);
                    }
                }
            }
        }
    }

    public void timeout(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                this.connection = null;
                Disposable disposable = refConnection.get();
                DisposableHelper.dispose(refConnection);
                ConnectableFlowable<T> connectableFlowable = this.source;
                if (connectableFlowable instanceof Disposable) {
                    ((Disposable) connectableFlowable).dispose();
                } else if (connectableFlowable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) connectableFlowable).resetIf(disposable);
                    }
                }
            }
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.source = connectableFlowable;
        this.n = i;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }
}

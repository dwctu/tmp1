package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public class OperatorOnBackpressureDrop<T> implements Observable.Operator<T, T> {
    public final Action1<? super T> onDrop;

    public static final class Holder {
        public static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop<>();
    }

    public OperatorOnBackpressureDrop() {
        this(null);
    }

    public static <T> OperatorOnBackpressureDrop<T> instance() {
        return (OperatorOnBackpressureDrop<T>) Holder.INSTANCE;
    }

    public OperatorOnBackpressureDrop(Action1<? super T> action1) {
        this.onDrop = action1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final AtomicLong atomicLong = new AtomicLong();
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorOnBackpressureDrop.1
            @Override // rx.Producer
            public void request(long j) {
                BackpressureUtils.getAndAddRequest(atomicLong, j);
            }
        });
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorOnBackpressureDrop.2
            public boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (this.done) {
                    RxJavaHooks.onError(th);
                } else {
                    this.done = true;
                    subscriber.onError(th);
                }
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (this.done) {
                    return;
                }
                if (atomicLong.get() > 0) {
                    subscriber.onNext(t);
                    atomicLong.decrementAndGet();
                    return;
                }
                Action1<? super T> action1 = OperatorOnBackpressureDrop.this.onDrop;
                if (action1 != null) {
                    try {
                        action1.call(t);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this, t);
                    }
                }
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
    }
}

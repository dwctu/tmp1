package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public final class OperatorDistinctUntilChanged<T, U> implements Observable.Operator<T, T>, Func2<U, U, Boolean> {
    public final Func2<? super U, ? super U, Boolean> comparator;
    public final Func1<? super T, ? extends U> keySelector;

    public static final class Holder {
        public static final OperatorDistinctUntilChanged<?, ?> INSTANCE = new OperatorDistinctUntilChanged<>(UtilityFunctions.identity());
    }

    public OperatorDistinctUntilChanged(Func1<? super T, ? extends U> func1) {
        this.keySelector = func1;
        this.comparator = this;
    }

    public static <T> OperatorDistinctUntilChanged<T, T> instance() {
        return (OperatorDistinctUntilChanged<T, T>) Holder.INSTANCE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.Func2
    public Boolean call(U u, U u2) {
        return Boolean.valueOf(u == u2 || (u != null && u.equals(u2)));
    }

    public OperatorDistinctUntilChanged(Func2<? super U, ? super U, Boolean> func2) {
        this.keySelector = UtilityFunctions.identity();
        this.comparator = func2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorDistinctUntilChanged.1
            public boolean hasPrevious;
            public U previousKey;

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
                try {
                    U uCall = OperatorDistinctUntilChanged.this.keySelector.call(t);
                    U u = this.previousKey;
                    this.previousKey = uCall;
                    if (!this.hasPrevious) {
                        this.hasPrevious = true;
                        subscriber.onNext(t);
                        return;
                    }
                    try {
                        if (OperatorDistinctUntilChanged.this.comparator.call(u, uCall).booleanValue()) {
                            request(1L);
                        } else {
                            subscriber.onNext(t);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, subscriber, uCall);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, subscriber, t);
                }
            }
        };
    }
}

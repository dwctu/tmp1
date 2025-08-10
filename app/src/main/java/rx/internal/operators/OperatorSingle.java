package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.internal.producers.SingleProducer;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class OperatorSingle<T> implements Observable.Operator<T, T> {
    private final T defaultValue;
    private final boolean hasDefaultValue;

    public static final class Holder {
        public static final OperatorSingle<?> INSTANCE = new OperatorSingle<>();
    }

    public static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;
        private final T defaultValue;
        private final boolean hasDefaultValue;
        private boolean hasTooManyElements;
        private boolean isNonEmpty;
        private T value;

        public ParentSubscriber(Subscriber<? super T> subscriber, boolean z, T t) {
            this.child = subscriber;
            this.hasDefaultValue = z;
            this.defaultValue = t;
            request(2L);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.hasTooManyElements) {
                return;
            }
            if (this.isNonEmpty) {
                this.child.setProducer(new SingleProducer(this.child, this.value));
            } else if (this.hasDefaultValue) {
                this.child.setProducer(new SingleProducer(this.child, this.defaultValue));
            } else {
                this.child.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.hasTooManyElements) {
                RxJavaHooks.onError(th);
            } else {
                this.child.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.hasTooManyElements) {
                return;
            }
            if (!this.isNonEmpty) {
                this.value = t;
                this.isNonEmpty = true;
            } else {
                this.hasTooManyElements = true;
                this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            }
        }
    }

    public OperatorSingle() {
        this(false, null);
    }

    public static <T> OperatorSingle<T> instance() {
        return (OperatorSingle<T>) Holder.INSTANCE;
    }

    public OperatorSingle(T t) {
        this(true, t);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber, this.hasDefaultValue, this.defaultValue);
        subscriber.add(parentSubscriber);
        return parentSubscriber;
    }

    private OperatorSingle(boolean z, T t) {
        this.hasDefaultValue = z;
        this.defaultValue = t;
    }
}

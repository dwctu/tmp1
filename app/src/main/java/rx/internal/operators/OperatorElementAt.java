package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* loaded from: classes5.dex */
public final class OperatorElementAt<T> implements Observable.Operator<T, T> {
    public final T defaultValue;
    public final boolean hasDefault;
    public final int index;

    public static class InnerProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 1;
        public final Producer actual;

        public InnerProducer(Producer producer) {
            this.actual = producer;
        }

        @Override // rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j <= 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.request(Long.MAX_VALUE);
        }
    }

    public OperatorElementAt(int i) {
        this(i, null, false);
    }

    public OperatorElementAt(int i, T t) {
        this(i, t, true);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorElementAt.1
            private int currentIndex;

            @Override // rx.Observer
            public void onCompleted() {
                int i = this.currentIndex;
                OperatorElementAt operatorElementAt = OperatorElementAt.this;
                if (i <= operatorElementAt.index) {
                    if (operatorElementAt.hasDefault) {
                        subscriber.onNext(operatorElementAt.defaultValue);
                        subscriber.onCompleted();
                        return;
                    }
                    subscriber.onError(new IndexOutOfBoundsException(OperatorElementAt.this.index + " is out of bounds"));
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                int i = this.currentIndex;
                this.currentIndex = i + 1;
                if (i == OperatorElementAt.this.index) {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                    unsubscribe();
                }
            }

            @Override // rx.Subscriber, rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                subscriber.setProducer(new InnerProducer(producer));
            }
        };
        subscriber.add(subscriber2);
        return subscriber2;
    }

    private OperatorElementAt(int i, T t, boolean z) {
        if (i >= 0) {
            this.index = i;
            this.defaultValue = t;
            this.hasDefault = z;
        } else {
            throw new IndexOutOfBoundsException(i + " is out of bounds");
        }
    }
}

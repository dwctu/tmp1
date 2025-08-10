package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* loaded from: classes5.dex */
public final class OperatorSkip<T> implements Observable.Operator<T, T> {
    public final int toSkip;

    public OperatorSkip(int i) {
        if (i >= 0) {
            this.toSkip = i;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorSkip.1
            public int skipped;

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
                int i = this.skipped;
                if (i >= OperatorSkip.this.toSkip) {
                    subscriber.onNext(t);
                } else {
                    this.skipped = i + 1;
                }
            }

            @Override // rx.Subscriber, rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                subscriber.setProducer(producer);
                producer.request(OperatorSkip.this.toSkip);
            }
        };
    }
}

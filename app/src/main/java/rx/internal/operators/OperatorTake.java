package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* loaded from: classes5.dex */
public final class OperatorTake<T> implements Observable.Operator<T, T> {
    public final int limit;

    /* renamed from: rx.internal.operators.OperatorTake$1, reason: invalid class name */
    public class AnonymousClass1 extends Subscriber<T> {
        public boolean completed;
        public int count;
        public final /* synthetic */ Subscriber val$child;

        public AnonymousClass1(Subscriber subscriber) {
            this.val$child = subscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.completed) {
                return;
            }
            this.completed = true;
            this.val$child.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            try {
                this.val$child.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (isUnsubscribed()) {
                return;
            }
            int i = this.count;
            int i2 = i + 1;
            this.count = i2;
            int i3 = OperatorTake.this.limit;
            if (i < i3) {
                boolean z = i2 == i3;
                this.val$child.onNext(t);
                if (!z || this.completed) {
                    return;
                }
                this.completed = true;
                try {
                    this.val$child.onCompleted();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(final Producer producer) {
            this.val$child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTake.1.1
                public final AtomicLong requested = new AtomicLong(0);

                @Override // rx.Producer
                public void request(long j) {
                    long j2;
                    long jMin;
                    if (j <= 0 || AnonymousClass1.this.completed) {
                        return;
                    }
                    do {
                        j2 = this.requested.get();
                        jMin = Math.min(j, OperatorTake.this.limit - j2);
                        if (jMin == 0) {
                            return;
                        }
                    } while (!this.requested.compareAndSet(j2, j2 + jMin));
                    producer.request(jMin);
                }
            });
        }
    }

    public OperatorTake(int i) {
        if (i >= 0) {
            this.limit = i;
            return;
        }
        throw new IllegalArgumentException("limit >= 0 required but it was " + i);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(subscriber);
        if (this.limit == 0) {
            subscriber.onCompleted();
            anonymousClass1.unsubscribe();
        }
        subscriber.add(anonymousClass1);
        return anonymousClass1;
    }
}

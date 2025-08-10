package rx.internal.operators;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/* loaded from: classes5.dex */
public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {
    public final Iterable<? extends T> is;

    public static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final Subscriber<? super T> o;

        public IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.o = subscriber;
            this.it = it;
        }

        public void fastPath() {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it = this.it;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext(it.next());
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            subscriber.onCompleted();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, subscriber);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, subscriber);
                    return;
                }
            }
        }

        @Override // rx.Producer
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else {
                if (j <= 0 || BackpressureUtils.getAndAddRequest(this, j) != 0) {
                    return;
                }
                slowPath(j);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
        
            r9 = rx.internal.operators.BackpressureUtils.produced(r8, r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void slowPath(long r9) {
            /*
                r8 = this;
                rx.Subscriber<? super T> r0 = r8.o
                java.util.Iterator<? extends T> r1 = r8.it
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L3e
                boolean r6 = r0.isUnsubscribed()
                if (r6 == 0) goto L12
                return
            L12:
                java.lang.Object r6 = r1.next()     // Catch: java.lang.Throwable -> L39
                r0.onNext(r6)
                boolean r6 = r0.isUnsubscribed()
                if (r6 == 0) goto L20
                return
            L20:
                boolean r6 = r1.hasNext()     // Catch: java.lang.Throwable -> L34
                if (r6 != 0) goto L30
                boolean r9 = r0.isUnsubscribed()
                if (r9 != 0) goto L2f
                r0.onCompleted()
            L2f:
                return
            L30:
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L34:
                r9 = move-exception
                rx.exceptions.Exceptions.throwOrReport(r9, r0)
                return
            L39:
                r9 = move-exception
                rx.exceptions.Exceptions.throwOrReport(r9, r0)
                return
            L3e:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = rx.internal.operators.BackpressureUtils.produced(r8, r4)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeFromIterable.IterableProducer.slowPath(long):void");
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "iterable must not be null");
        this.is = iterable;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends T> it = this.is.iterator();
            boolean zHasNext = it.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (zHasNext) {
                subscriber.setProducer(new IterableProducer(subscriber, it));
            } else {
                subscriber.onCompleted();
            }
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
        }
    }
}

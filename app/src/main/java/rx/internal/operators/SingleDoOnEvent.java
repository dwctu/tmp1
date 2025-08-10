package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;

/* loaded from: classes5.dex */
public final class SingleDoOnEvent<T> implements Single.OnSubscribe<T> {
    public final Action1<Throwable> onError;
    public final Action1<? super T> onSuccess;
    public final Single<T> source;

    public static final class SingleDoOnEventSubscriber<T> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super T> actual;
        public final Action1<Throwable> onError;
        public final Action1<? super T> onSuccess;

        public SingleDoOnEventSubscriber(SingleSubscriber<? super T> singleSubscriber, Action1<? super T> action1, Action1<Throwable> action12) {
            this.actual = singleSubscriber;
            this.onSuccess = action1;
            this.onError = action12;
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            try {
                this.onError.call(th);
                this.actual.onError(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            try {
                this.onSuccess.call(t);
                this.actual.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this, t);
            }
        }
    }

    public SingleDoOnEvent(Single<T> single, Action1<? super T> action1, Action1<Throwable> action12) {
        this.source = single;
        this.onSuccess = action1;
        this.onError = action12;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        SingleDoOnEventSubscriber singleDoOnEventSubscriber = new SingleDoOnEventSubscriber(singleSubscriber, this.onSuccess, this.onError);
        singleSubscriber.add(singleDoOnEventSubscriber);
        this.source.subscribe(singleDoOnEventSubscriber);
    }
}

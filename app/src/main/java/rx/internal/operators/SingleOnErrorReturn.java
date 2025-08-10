package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

/* loaded from: classes5.dex */
public final class SingleOnErrorReturn<T> implements Single.OnSubscribe<T> {
    public final Func1<Throwable, ? extends T> resumeFunction;
    public final Single.OnSubscribe<T> source;

    public static final class OnErrorReturnsSingleSubscriber<T> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super T> actual;
        public final Func1<Throwable, ? extends T> resumeFunction;

        public OnErrorReturnsSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Func1<Throwable, ? extends T> func1) {
            this.actual = singleSubscriber;
            this.resumeFunction = func1;
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            try {
                this.actual.onSuccess(this.resumeFunction.call(th));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(th2);
            }
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public SingleOnErrorReturn(Single.OnSubscribe<T> onSubscribe, Func1<Throwable, ? extends T> func1) {
        this.source = onSubscribe;
        this.resumeFunction = func1;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        OnErrorReturnsSingleSubscriber onErrorReturnsSingleSubscriber = new OnErrorReturnsSingleSubscriber(singleSubscriber, this.resumeFunction);
        singleSubscriber.add(onErrorReturnsSingleSubscriber);
        this.source.call(onErrorReturnsSingleSubscriber);
    }
}

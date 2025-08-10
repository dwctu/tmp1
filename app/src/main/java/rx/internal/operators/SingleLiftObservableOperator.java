package rx.internal.operators;

import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.SingleFromObservable;
import rx.internal.producers.SingleProducer;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class SingleLiftObservableOperator<T, R> implements Single.OnSubscribe<R> {
    public final Observable.Operator<? extends R, ? super T> lift;
    public final Single.OnSubscribe<T> source;

    public static final class WrapSubscriberIntoSingle<T> extends SingleSubscriber<T> {
        public final Subscriber<? super T> actual;

        public WrapSubscriberIntoSingle(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            this.actual.setProducer(new SingleProducer(this.actual, t));
        }
    }

    public SingleLiftObservableOperator(Single.OnSubscribe<T> onSubscribe, Observable.Operator<? extends R, ? super T> operator) {
        this.source = onSubscribe;
        this.lift = operator;
    }

    public static <T> SingleSubscriber<T> wrap(Subscriber<T> subscriber) {
        WrapSubscriberIntoSingle wrapSubscriberIntoSingle = new WrapSubscriberIntoSingle(subscriber);
        subscriber.add(wrapSubscriberIntoSingle);
        return wrapSubscriberIntoSingle;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super R> singleSubscriber) {
        SingleFromObservable.WrapSingleIntoSubscriber wrapSingleIntoSubscriber = new SingleFromObservable.WrapSingleIntoSubscriber(singleSubscriber);
        singleSubscriber.add(wrapSingleIntoSubscriber);
        try {
            Subscriber<? super T> subscriberCall = RxJavaHooks.onSingleLift(this.lift).call(wrapSingleIntoSubscriber);
            SingleSubscriber singleSubscriberWrap = wrap(subscriberCall);
            subscriberCall.onStart();
            this.source.call(singleSubscriberWrap);
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, singleSubscriber);
        }
    }
}

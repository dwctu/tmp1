package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class SingleFromObservable<T> implements Single.OnSubscribe<T> {
    public final Observable.OnSubscribe<T> source;

    public static final class WrapSingleIntoSubscriber<T> extends Subscriber<T> {
        public static final int STATE_DONE = 2;
        public static final int STATE_EMPTY = 0;
        public static final int STATE_HAS_VALUE = 1;
        public final SingleSubscriber<? super T> actual;
        public int state;
        public T value;

        public WrapSingleIntoSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            int i = this.state;
            if (i == 0) {
                this.actual.onError(new NoSuchElementException());
            } else if (i == 1) {
                this.state = 2;
                T t = this.value;
                this.value = null;
                this.actual.onSuccess(t);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.state == 2) {
                RxJavaHooks.onError(th);
            } else {
                this.value = null;
                this.actual.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            int i = this.state;
            if (i == 0) {
                this.state = 1;
                this.value = t;
            } else if (i == 1) {
                this.state = 2;
                this.actual.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public SingleFromObservable(Observable.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        WrapSingleIntoSubscriber wrapSingleIntoSubscriber = new WrapSingleIntoSubscriber(singleSubscriber);
        singleSubscriber.add(wrapSingleIntoSubscriber);
        this.source.call(wrapSingleIntoSubscriber);
    }
}

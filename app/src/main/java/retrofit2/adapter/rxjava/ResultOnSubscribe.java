package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ResultOnSubscribe<T> implements Observable.OnSubscribe<Result<T>> {
    private final Observable.OnSubscribe<Response<T>> upstream;

    public static class ResultSubscriber<R> extends Subscriber<Response<R>> {
        private final Subscriber<? super Result<R>> subscriber;

        public ResultSubscriber(Subscriber<? super Result<R>> subscriber) {
            super(subscriber);
            this.subscriber = subscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.subscriber.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            try {
                this.subscriber.onNext(Result.error(th));
                this.subscriber.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.subscriber.onError(th2);
                } catch (OnCompletedFailedException e) {
                    e = e;
                    RxJavaPlugins.getInstance().getErrorHandler().handleError(e);
                } catch (OnErrorFailedException e2) {
                    e = e2;
                    RxJavaPlugins.getInstance().getErrorHandler().handleError(e);
                } catch (OnErrorNotImplementedException e3) {
                    e = e3;
                    RxJavaPlugins.getInstance().getErrorHandler().handleError(e);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.getInstance().getErrorHandler().handleError(new CompositeException(th2, th3));
                }
            }
        }

        @Override // rx.Observer
        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }
    }

    public ResultOnSubscribe(Observable.OnSubscribe<Response<T>> onSubscribe) {
        this.upstream = onSubscribe;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super Result<T>> subscriber) {
        this.upstream.call(new ResultSubscriber(subscriber));
    }
}

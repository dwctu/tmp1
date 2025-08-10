package rx.internal.operators;

import rx.Completable;
import rx.CompletableSubscriber;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

/* loaded from: classes5.dex */
public final class CompletableFlatMapSingleToCompletable<T> implements Completable.OnSubscribe {
    public final Func1<? super T, ? extends Completable> mapper;
    public final Single<T> source;

    public static final class SourceSubscriber<T> extends SingleSubscriber<T> implements CompletableSubscriber {
        public final CompletableSubscriber actual;
        public final Func1<? super T, ? extends Completable> mapper;

        public SourceSubscriber(CompletableSubscriber completableSubscriber, Func1<? super T, ? extends Completable> func1) {
            this.actual = completableSubscriber;
            this.mapper = func1;
        }

        @Override // rx.CompletableSubscriber
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // rx.CompletableSubscriber
        public void onSubscribe(Subscription subscription) {
            add(subscription);
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            try {
                Completable completableCall = this.mapper.call(t);
                if (completableCall == null) {
                    onError(new NullPointerException("The mapper returned a null Completable"));
                } else {
                    completableCall.subscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }
    }

    public CompletableFlatMapSingleToCompletable(Single<T> single, Func1<? super T, ? extends Completable> func1) {
        this.source = single;
        this.mapper = func1;
    }

    @Override // rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        SourceSubscriber sourceSubscriber = new SourceSubscriber(completableSubscriber, this.mapper);
        completableSubscriber.onSubscribe(sourceSubscriber);
        this.source.subscribe(sourceSubscriber);
    }
}

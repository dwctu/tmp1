package rx.internal.operators;

import java.util.Objects;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

/* loaded from: classes5.dex */
public final class SingleOperatorOnErrorResumeNext<T> implements Single.OnSubscribe<T> {
    private final Single<? extends T> originalSingle;
    public final Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError;

    private SingleOperatorOnErrorResumeNext(Single<? extends T> single, Func1<Throwable, ? extends Single<? extends T>> func1) {
        Objects.requireNonNull(single, "originalSingle must not be null");
        Objects.requireNonNull(func1, "resumeFunctionInCaseOfError must not be null");
        this.originalSingle = single;
        this.resumeFunctionInCaseOfError = func1;
    }

    public static <T> SingleOperatorOnErrorResumeNext<T> withFunction(Single<? extends T> single, Func1<Throwable, ? extends Single<? extends T>> func1) {
        return new SingleOperatorOnErrorResumeNext<>(single, func1);
    }

    public static <T> SingleOperatorOnErrorResumeNext<T> withOther(Single<? extends T> single, final Single<? extends T> single2) {
        Objects.requireNonNull(single2, "resumeSingleInCaseOfError must not be null");
        return new SingleOperatorOnErrorResumeNext<>(single, new Func1<Throwable, Single<? extends T>>() { // from class: rx.internal.operators.SingleOperatorOnErrorResumeNext.1
            @Override // rx.functions.Func1
            public Single<? extends T> call(Throwable th) {
                return single2;
            }
        });
    }

    @Override // rx.functions.Action1
    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        SingleSubscriber<T> singleSubscriber2 = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOperatorOnErrorResumeNext.2
            @Override // rx.SingleSubscriber
            public void onError(Throwable th) {
                try {
                    SingleOperatorOnErrorResumeNext.this.resumeFunctionInCaseOfError.call(th).subscribe(singleSubscriber);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (SingleSubscriber<?>) singleSubscriber);
                }
            }

            @Override // rx.SingleSubscriber
            public void onSuccess(T t) {
                singleSubscriber.onSuccess(t);
            }
        };
        singleSubscriber.add(singleSubscriber2);
        this.originalSingle.subscribe((SingleSubscriber<? super Object>) singleSubscriber2);
    }
}

package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

/* loaded from: classes5.dex */
public final class OperatorSkipWhile<T> implements Observable.Operator<T, T> {
    public final Func2<? super T, Integer, Boolean> predicate;

    public OperatorSkipWhile(Func2<? super T, Integer, Boolean> func2) {
        this.predicate = func2;
    }

    public static <T> Func2<T, Integer, Boolean> toPredicate2(final Func1<? super T, Boolean> func1) {
        return new Func2<T, Integer, Boolean>() { // from class: rx.internal.operators.OperatorSkipWhile.2
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
                return call2((AnonymousClass2) obj, num);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public Boolean call2(T t, Integer num) {
                return (Boolean) func1.call(t);
            }
        };
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorSkipWhile.1
            public int index;
            public boolean skipping = true;

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
                if (!this.skipping) {
                    subscriber.onNext(t);
                    return;
                }
                try {
                    Func2<? super T, Integer, Boolean> func2 = OperatorSkipWhile.this.predicate;
                    int i = this.index;
                    this.index = i + 1;
                    if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                        request(1L);
                    } else {
                        this.skipping = false;
                        subscriber.onNext(t);
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber, t);
                }
            }
        };
    }
}

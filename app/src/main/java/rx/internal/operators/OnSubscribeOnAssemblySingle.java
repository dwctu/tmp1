package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.AssemblyStackTraceException;

/* loaded from: classes5.dex */
public final class OnSubscribeOnAssemblySingle<T> implements Single.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    public final Single.OnSubscribe<T> source;
    public final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    public static final class OnAssemblySingleSubscriber<T> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super T> actual;
        public final String stacktrace;

        public OnAssemblySingleSubscriber(SingleSubscriber<? super T> singleSubscriber, String str) {
            this.actual = singleSubscriber;
            this.stacktrace = str;
            singleSubscriber.add(this);
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(th);
            this.actual.onError(th);
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public OnSubscribeOnAssemblySingle(Single.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        this.source.call(new OnAssemblySingleSubscriber(singleSubscriber, this.stacktrace));
    }
}

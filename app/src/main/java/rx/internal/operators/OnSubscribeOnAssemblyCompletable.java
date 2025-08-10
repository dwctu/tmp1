package rx.internal.operators;

import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.exceptions.AssemblyStackTraceException;

/* loaded from: classes5.dex */
public final class OnSubscribeOnAssemblyCompletable<T> implements Completable.OnSubscribe {
    public static volatile boolean fullStackTrace;
    public final Completable.OnSubscribe source;
    public final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    public static final class OnAssemblyCompletableSubscriber implements CompletableSubscriber {
        public final CompletableSubscriber actual;
        public final String stacktrace;

        public OnAssemblyCompletableSubscriber(CompletableSubscriber completableSubscriber, String str) {
            this.actual = completableSubscriber;
            this.stacktrace = str;
        }

        @Override // rx.CompletableSubscriber
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.CompletableSubscriber
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(th);
            this.actual.onError(th);
        }

        @Override // rx.CompletableSubscriber
        public void onSubscribe(Subscription subscription) {
            this.actual.onSubscribe(subscription);
        }
    }

    public OnSubscribeOnAssemblyCompletable(Completable.OnSubscribe onSubscribe) {
        this.source = onSubscribe;
    }

    @Override // rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        this.source.call(new OnAssemblyCompletableSubscriber(completableSubscriber, this.stacktrace));
    }
}

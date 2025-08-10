package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.AssemblyStackTraceException;

/* loaded from: classes5.dex */
public final class OnSubscribeOnAssembly<T> implements Observable.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    public final Observable.OnSubscribe<T> source;
    public final String stacktrace = createStacktrace();

    public static final class OnAssemblySubscriber<T> extends Subscriber<T> {
        public final Subscriber<? super T> actual;
        public final String stacktrace;

        public OnAssemblySubscriber(Subscriber<? super T> subscriber, String str) {
            super(subscriber);
            this.actual = subscriber;
            this.stacktrace = str;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(th);
            this.actual.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }
    }

    public OnSubscribeOnAssembly(Observable.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    public static String createStacktrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("Assembly trace:");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String string = stackTraceElement.toString();
            if (fullStackTrace || (stackTraceElement.getLineNumber() > 1 && !string.contains("RxJavaHooks.") && !string.contains("OnSubscribeOnAssembly") && !string.contains(".junit.runner") && !string.contains(".junit4.runner") && !string.contains(".junit.internal") && !string.contains("sun.reflect") && !string.contains("java.lang.Thread.") && !string.contains("ThreadPoolExecutor") && !string.contains("org.apache.catalina.") && !string.contains("org.apache.tomcat."))) {
                sb.append("\n at ");
                sb.append(string);
            }
        }
        sb.append("\nOriginal exception:");
        return sb.toString();
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        this.source.call(new OnAssemblySubscriber(subscriber, this.stacktrace));
    }
}

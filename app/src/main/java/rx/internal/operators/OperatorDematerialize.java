package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;

/* loaded from: classes5.dex */
public final class OperatorDematerialize<T> implements Observable.Operator<T, Notification<T>> {

    /* renamed from: rx.internal.operators.OperatorDematerialize$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$rx$Notification$Kind;

        static {
            int[] iArr = new int[Notification.Kind.values().length];
            $SwitchMap$rx$Notification$Kind = iArr;
            try {
                iArr[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$rx$Notification$Kind[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$rx$Notification$Kind[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class Holder {
        public static final OperatorDematerialize<Object> INSTANCE = new OperatorDematerialize<>();
    }

    public static OperatorDematerialize instance() {
        return Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super Notification<T>> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<Notification<T>>(subscriber) { // from class: rx.internal.operators.OperatorDematerialize.1
            public boolean terminated;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.terminated) {
                    return;
                }
                this.terminated = true;
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (this.terminated) {
                    return;
                }
                this.terminated = true;
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(Notification<T> notification) {
                int i = AnonymousClass2.$SwitchMap$rx$Notification$Kind[notification.getKind().ordinal()];
                if (i == 1) {
                    if (this.terminated) {
                        return;
                    }
                    subscriber.onNext(notification.getValue());
                } else {
                    if (i == 2) {
                        onError(notification.getThrowable());
                        return;
                    }
                    if (i == 3) {
                        onCompleted();
                        return;
                    }
                    onError(new IllegalArgumentException("Unsupported notification type: " + notification));
                }
            }
        };
    }
}

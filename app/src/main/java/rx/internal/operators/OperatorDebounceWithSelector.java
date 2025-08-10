package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* loaded from: classes5.dex */
public final class OperatorDebounceWithSelector<T, U> implements Observable.Operator<T, T> {
    public final Func1<? super T, ? extends Observable<U>> selector;

    /* renamed from: rx.internal.operators.OperatorDebounceWithSelector$1, reason: invalid class name */
    public class AnonymousClass1 extends Subscriber<T> {
        public final Subscriber<?> self;
        public final OperatorDebounceWithTime.DebounceState<T> state;
        public final /* synthetic */ SerializedSubscriber val$s;
        public final /* synthetic */ SerialSubscription val$serial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Subscriber subscriber, SerializedSubscriber serializedSubscriber, SerialSubscription serialSubscription) {
            super(subscriber);
            this.val$s = serializedSubscriber;
            this.val$serial = serialSubscription;
            this.state = new OperatorDebounceWithTime.DebounceState<>();
            this.self = this;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.emitAndComplete(this.val$s, this);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.val$s.onError(th);
            unsubscribe();
            this.state.clear();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            try {
                Observable<U> observableCall = OperatorDebounceWithSelector.this.selector.call(t);
                final int next = this.state.next(t);
                Subscriber<U> subscriber = new Subscriber<U>() { // from class: rx.internal.operators.OperatorDebounceWithSelector.1.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.state.emit(next, anonymousClass1.val$s, anonymousClass1.self);
                        unsubscribe();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        AnonymousClass1.this.self.onError(th);
                    }

                    @Override // rx.Observer
                    public void onNext(U u) {
                        onCompleted();
                    }
                };
                this.val$serial.set(subscriber);
                observableCall.unsafeSubscribe(subscriber);
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this);
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> func1) {
        this.selector = func1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        return new AnonymousClass1(subscriber, serializedSubscriber, serialSubscription);
    }
}

package rx.internal.operators;

import java.util.Arrays;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class SingleOnSubscribeUsing<T, Resource> implements Single.OnSubscribe<T> {
    public final Action1<? super Resource> disposeAction;
    public final boolean disposeEagerly;
    public final Func0<Resource> resourceFactory;
    public final Func1<? super Resource, ? extends Single<? extends T>> singleFactory;

    public SingleOnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Single<? extends T>> func1, Action1<? super Resource> action1, boolean z) {
        this.resourceFactory = func0;
        this.singleFactory = func1;
        this.disposeAction = action1;
        this.disposeEagerly = z;
    }

    public void handleSubscriptionTimeError(SingleSubscriber<? super T> singleSubscriber, Resource resource, Throwable th) {
        Exceptions.throwIfFatal(th);
        if (this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(Arrays.asList(th, th2));
            }
        }
        singleSubscriber.onError(th);
        if (this.disposeEagerly) {
            return;
        }
        try {
            this.disposeAction.call(resource);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaHooks.onError(th3);
        }
    }

    @Override // rx.functions.Action1
    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        try {
            final Resource resourceCall = this.resourceFactory.call();
            try {
                Single<? extends T> singleCall = this.singleFactory.call(resourceCall);
                if (singleCall == null) {
                    handleSubscriptionTimeError(singleSubscriber, resourceCall, new NullPointerException("The single"));
                    return;
                }
                SingleSubscriber<T> singleSubscriber2 = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOnSubscribeUsing.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // rx.SingleSubscriber
                    public void onError(Throwable th) {
                        SingleOnSubscribeUsing.this.handleSubscriptionTimeError(singleSubscriber, resourceCall, th);
                    }

                    @Override // rx.SingleSubscriber
                    public void onSuccess(T t) {
                        SingleOnSubscribeUsing singleOnSubscribeUsing = SingleOnSubscribeUsing.this;
                        if (singleOnSubscribeUsing.disposeEagerly) {
                            try {
                                singleOnSubscribeUsing.disposeAction.call((Object) resourceCall);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                singleSubscriber.onError(th);
                                return;
                            }
                        }
                        singleSubscriber.onSuccess(t);
                        SingleOnSubscribeUsing singleOnSubscribeUsing2 = SingleOnSubscribeUsing.this;
                        if (singleOnSubscribeUsing2.disposeEagerly) {
                            return;
                        }
                        try {
                            singleOnSubscribeUsing2.disposeAction.call((Object) resourceCall);
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            RxJavaHooks.onError(th2);
                        }
                    }
                };
                singleSubscriber.add(singleSubscriber2);
                singleCall.subscribe((SingleSubscriber<? super Object>) singleSubscriber2);
            } catch (Throwable th) {
                handleSubscriptionTimeError(singleSubscriber, resourceCall, th);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            singleSubscriber.onError(th2);
        }
    }
}

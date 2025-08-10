package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/* loaded from: classes5.dex */
public final class CallExecuteOnSubscribe<T> implements Observable.OnSubscribe<Response<T>> {
    private final Call<T> originalCall;

    public CallExecuteOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super Response<T>> subscriber) {
        Call<T> callClone = this.originalCall.clone();
        CallArbiter callArbiter = new CallArbiter(callClone, subscriber);
        subscriber.add(callArbiter);
        subscriber.setProducer(callArbiter);
        try {
            callArbiter.emitResponse(callClone.execute());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            callArbiter.emitError(th);
        }
    }
}

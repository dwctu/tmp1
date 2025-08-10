package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import rx.Scheduler;

/* loaded from: classes5.dex */
public final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final Scheduler scheduler;

    public RxJavaCallAdapter(Type type, Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.responseType = type;
        this.scheduler = scheduler;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isSingle = z4;
        this.isCompletable = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    @Override // retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object adapt(retrofit2.Call<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.isAsync
            if (r0 == 0) goto La
            retrofit2.adapter.rxjava.CallEnqueueOnSubscribe r0 = new retrofit2.adapter.rxjava.CallEnqueueOnSubscribe
            r0.<init>(r2)
            goto Lf
        La:
            retrofit2.adapter.rxjava.CallExecuteOnSubscribe r0 = new retrofit2.adapter.rxjava.CallExecuteOnSubscribe
            r0.<init>(r2)
        Lf:
            boolean r2 = r1.isResult
            if (r2 == 0) goto L1a
            retrofit2.adapter.rxjava.ResultOnSubscribe r2 = new retrofit2.adapter.rxjava.ResultOnSubscribe
            r2.<init>(r0)
        L18:
            r0 = r2
            goto L24
        L1a:
            boolean r2 = r1.isBody
            if (r2 == 0) goto L24
            retrofit2.adapter.rxjava.BodyOnSubscribe r2 = new retrofit2.adapter.rxjava.BodyOnSubscribe
            r2.<init>(r0)
            goto L18
        L24:
            rx.Observable r2 = rx.Observable.create(r0)
            rx.Scheduler r0 = r1.scheduler
            if (r0 == 0) goto L30
            rx.Observable r2 = r2.subscribeOn(r0)
        L30:
            boolean r0 = r1.isSingle
            if (r0 == 0) goto L39
            rx.Single r2 = r2.toSingle()
            return r2
        L39:
            boolean r0 = r1.isCompletable
            if (r0 == 0) goto L41
            rx.Completable r2 = r2.toCompletable()
        L41:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava.RxJavaCallAdapter.adapt(retrofit2.Call):java.lang.Object");
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}

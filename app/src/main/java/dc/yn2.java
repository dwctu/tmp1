package dc;

import com.wear.network.protocol.exception.NetException;

/* compiled from: ResponseCallBack.java */
/* loaded from: classes3.dex */
public interface yn2<T> extends zn2<T> {
    void onCompleted();

    @Override // dc.zn2
    void onError(NetException netException);

    void onStart();

    @Override // dc.zn2
    void onSuccess(T t);
}

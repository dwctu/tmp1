package dc;

import com.wear.network.protocol.exception.NetException;

/* compiled from: ResponseSimpleCallBack.java */
/* loaded from: classes3.dex */
public interface zn2<T> {
    void onError(NetException netException);

    void onSuccess(T t);
}

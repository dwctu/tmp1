package dc;

import com.wear.network.protocol.exception.NetException;

/* compiled from: ResponseByteCallBack.java */
/* loaded from: classes3.dex */
public interface xn2<T> extends zn2<T> {
    void a(byte[] bArr);

    void onCompleted();

    @Override // dc.zn2
    void onError(NetException netException);

    void onStart();
}

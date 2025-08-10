package dc;

import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;

/* compiled from: NetBytesSubscriber.java */
/* loaded from: classes3.dex */
public class no2<T> extends vn2<bd4> implements Serializable {
    private xn2<T> callBack;

    public no2(String str, xn2<T> xn2Var) {
        this.url = tn2.w(str) + str;
        this.callBack = xn2Var;
    }

    @Override // rx.Observer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onNext(bd4 bd4Var) {
        try {
            byte[] bArrBytes = bd4Var.bytes();
            if (this.callBack != null) {
                try {
                    if (WearUtils.i1(bArrBytes)) {
                        throw new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2());
                    }
                    this.callBack.onSuccess(bArrBytes);
                } catch (Exception e) {
                    e.printStackTrace();
                    xn2<T> xn2Var = this.callBack;
                    if (xn2Var != null) {
                        xn2Var.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            xn2<T> xn2Var2 = this.callBack;
            if (xn2Var2 != null) {
                xn2Var2.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
            }
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        xn2<T> xn2Var = this.callBack;
        if (xn2Var != null) {
            xn2Var.onCompleted();
        }
    }

    @Override // dc.vn2, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        th.printStackTrace();
        xn2<T> xn2Var = this.callBack;
        if (xn2Var != null) {
            if (th instanceof SocketTimeoutException) {
                xn2Var.onError(new NetException(NetException.API_REQUEST_TIME_OUT, WearUtils.b2()));
                return;
            }
            if (th instanceof HttpException) {
                xn2Var.onError(new NetException(NetException.API_REQUEST_FAILED, WearUtils.a2()));
                return;
            }
            if (th instanceof ConnectException) {
                xn2Var.onError(new NetException(NetException.SERVER_REQUEST_FAILED, WearUtils.a2()));
                return;
            }
            if (th instanceof TimeoutException) {
                xn2Var.onError(new NetException(NetException.SOCKET_TIME_OUT, WearUtils.a2()));
                return;
            }
            if (th instanceof SocketException) {
                xn2Var.onError(new NetException(NetException.SOCKET_CONNECT_ERROR, WearUtils.a2()));
            } else if (!(th instanceof NullPointerException)) {
                xn2Var.onError(new NetException(NetException.LOCAL_UN_DEFINE_ERROR, WearUtils.a2()));
            } else {
                if (WearUtils.e1(WearUtils.t)) {
                    return;
                }
                this.callBack.onError(new NetException(NetException.NULL_PORINT_ERROR, WearUtils.a2()));
            }
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        super.onStart();
        if (d(WearUtils.x)) {
            xn2<T> xn2Var = this.callBack;
            if (xn2Var != null) {
                xn2Var.onStart();
                return;
            }
            return;
        }
        this.callBack.onError(new NetException(NetException.NET_CONNECT_ERROR, WearUtils.Y1()));
        if (isUnsubscribed()) {
            return;
        }
        unsubscribe();
    }
}

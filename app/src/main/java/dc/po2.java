package dc;

import android.text.TextUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONObject;
import retrofit2.HttpException;

/* compiled from: NetOldModeSubscriber.java */
/* loaded from: classes3.dex */
public class po2<T> extends vn2<bd4> implements Serializable {
    private yn2<T> callBack;
    private Type finalNeedType;

    public po2(String str, Type type, yn2<T> yn2Var) {
        this.url = tn2.w(str) + str;
        this.finalNeedType = type;
        this.callBack = yn2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.Observer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onNext(bd4 bd4Var) {
        try {
            String str = new String(bd4Var.bytes());
            String str2 = "====ResponseBody:====" + str;
            if (this.callBack != null) {
                try {
                    if (WearUtils.e1(str)) {
                        a(NetException.SERVICE_DATA_ERROR, "");
                        throw new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2());
                    }
                    if (ro2.b(str, this.finalNeedType) == null) {
                        a(NetException.SERVICE_DATA_ERROR, "");
                        throw new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2());
                    }
                    Object objFromJson = WearUtils.A.fromJson(str, this.finalNeedType);
                    if (!TextUtils.isEmpty(str)) {
                        new JSONObject(str).optString(XHTMLText.CODE, NetException.SERVER_UN_DEFINE_ERROR);
                    }
                    try {
                        this.callBack.onSuccess(objFromJson);
                    } catch (Exception e) {
                        e.printStackTrace();
                        FirebaseCrashlytics.getInstance().recordException(e);
                        if (this.callBack != null) {
                            a(NetException.SERVICE_DATA_ERROR, e.getMessage());
                            this.callBack.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (this.callBack != null) {
                        a(NetException.SERVICE_DATA_ERROR, e2.getMessage());
                        this.callBack.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (this.callBack != null) {
                a(NetException.SERVICE_DATA_ERROR, e3.getMessage());
                this.callBack.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
            }
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        yn2<T> yn2Var = this.callBack;
        if (yn2Var != null) {
            yn2Var.onCompleted();
        }
    }

    @Override // dc.vn2, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        yn2<T> yn2Var = this.callBack;
        if (yn2Var != null) {
            if (th instanceof SocketTimeoutException) {
                yn2Var.onError(new NetException(NetException.API_REQUEST_TIME_OUT, WearUtils.b2()));
                return;
            }
            if (th instanceof HttpException) {
                yn2Var.onError(new NetException(NetException.API_REQUEST_FAILED, WearUtils.a2()));
                return;
            }
            if (th instanceof ConnectException) {
                yn2Var.onError(new NetException(NetException.SERVER_REQUEST_FAILED, WearUtils.a2()));
                return;
            }
            if (th instanceof TimeoutException) {
                yn2Var.onError(new NetException(NetException.SOCKET_TIME_OUT, WearUtils.a2()));
                return;
            }
            if (th instanceof SocketException) {
                yn2Var.onError(new NetException(NetException.SOCKET_CONNECT_ERROR, WearUtils.a2()));
            } else if (!(th instanceof NullPointerException)) {
                yn2Var.onError(new NetException(NetException.LOCAL_UN_DEFINE_ERROR, WearUtils.a2()));
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
            yn2<T> yn2Var = this.callBack;
            if (yn2Var != null) {
                yn2Var.onStart();
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

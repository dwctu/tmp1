package dc;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.wear.bean.FrozenData;
import com.wear.main.account.AccountFrozenActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;

/* compiled from: NetLoginSubscriber.java */
/* loaded from: classes3.dex */
public class oo2<T> extends vn2<bd4> implements Serializable {
    private yn2<T> callBack;
    private Type finalNeedType;

    /* compiled from: NetLoginSubscriber.java */
    public class a implements Runnable {
        public final /* synthetic */ FrozenData a;

        public a(oo2 oo2Var, FrozenData frozenData) {
            this.a = frozenData;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH.isFinishing() || fragmentActivityH.isDestroyed()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("recover_account_code", this.a.getAppRecoverAccountCode());
            intent.putExtra("frozenTime", this.a.getFrozenTimestamp());
            intent.setClass(fragmentActivityH, AccountFrozenActivity.class);
            boolean z = fragmentActivityH instanceof LoginActivity;
            intent.putExtra("from_login", z);
            fragmentActivityH.startActivity(intent);
            if (z) {
                return;
            }
            fragmentActivityH.finish();
        }
    }

    public oo2(String str, Type type, yn2<T> yn2Var) {
        this.url = tn2.w(str) + str;
        this.finalNeedType = type;
        this.callBack = yn2Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(java.lang.String r11) throws org.json.JSONException, com.google.gson.JsonSyntaxException {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.oo2.e(java.lang.String):void");
    }

    @Override // rx.Observer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onNext(bd4 bd4Var) {
        try {
            String str = new String(bd4Var.bytes());
            ye3.f("A0011");
            if (this.callBack != null) {
                if (WearUtils.e1(str)) {
                    this.callBack.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
                    c("other", "NetLoginSubscriber 空数据");
                }
                try {
                    e(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.callBack != null) {
                        this.callBack.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
                    }
                    c("XYError", "NetLoginSubscriber json 解析出错   data = " + str + "  error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            yn2<T> yn2Var = this.callBack;
            if (yn2Var != null) {
                yn2Var.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
            }
            c("XYError", "NetLoginSubscriber onNext   error = " + e2.getMessage());
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
        if (this.callBack != null) {
            if (th instanceof SocketTimeoutException) {
                c("other", "NetLoginSubscriber onError " + th.getMessage());
                this.callBack.onError(new NetException(NetException.API_REQUEST_TIME_OUT, WearUtils.b2()));
                return;
            }
            if (th instanceof HttpException) {
                c("other", "NetLoginSubscriber onError " + th.getMessage());
                this.callBack.onError(new NetException(NetException.API_REQUEST_FAILED, WearUtils.a2()));
                return;
            }
            if (th instanceof ConnectException) {
                c("other", "NetLoginSubscriber onError " + th.getMessage());
                this.callBack.onError(new NetException(NetException.SERVER_REQUEST_FAILED, WearUtils.a2()));
                return;
            }
            if (th instanceof TimeoutException) {
                c("other", "NetLoginSubscriber onError " + th.getMessage());
                this.callBack.onError(new NetException(NetException.SOCKET_TIME_OUT, WearUtils.a2()));
                return;
            }
            if (th instanceof SocketException) {
                c("other", "NetLoginSubscriber onError " + th.getMessage());
                this.callBack.onError(new NetException(NetException.SOCKET_CONNECT_ERROR, WearUtils.a2()));
                return;
            }
            if (!(th instanceof NullPointerException)) {
                c("NSPForbiden", "NetLoginSubscriber onError " + th.getMessage());
                this.callBack.onError(new NetException(NetException.LOCAL_UN_DEFINE_ERROR, WearUtils.a2()));
                return;
            }
            if (WearUtils.e1(WearUtils.t)) {
                return;
            }
            c("other", "NetLoginSubscriber onError " + th.getMessage());
            this.callBack.onError(new NetException(NetException.NULL_PORINT_ERROR, WearUtils.a2()));
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

package dc;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.NetworkCodeEnum;
import com.wear.main.account.login.LoginActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import dc.is3;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.HttpException;

/* compiled from: NetAsyncSubscriber.java */
/* loaded from: classes3.dex */
public class mo2 extends vn2<bd4> implements Serializable {
    private zn2<String> callBack;

    /* compiled from: NetAsyncSubscriber.java */
    public class a implements Runnable {
        public a(mo2 mo2Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH.isFinishing() || fragmentActivityH.isDestroyed()) {
                return;
            }
            ep1.b().g();
            sg3.h(R.string.delete_account_tips2);
        }
    }

    public mo2(String str, zn2<String> zn2Var) {
        this.url = tn2.w(str) + str;
        this.callBack = zn2Var;
    }

    public static /* synthetic */ void f(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) LoginActivity.class);
        intent.addFlags(268468224);
        activity.startActivity(intent);
    }

    public static /* synthetic */ void g() {
        final FragmentActivity fragmentActivityH = MyApplication.H();
        ep1.b().h(1);
        cs3.k(fragmentActivityH, ah4.e(R.string.notification_change_email2), new is3.d() { // from class: dc.jo2
            @Override // dc.is3.d
            public final void doConfirm() {
                mo2.f(fragmentActivityH);
            }
        }).show();
    }

    public final void e(String str) throws JSONException {
        if (ro2.a(str, NormalResponse.class) != null) {
            JSONObject jSONObject = new JSONObject(str);
            boolean zOptBoolean = jSONObject.optBoolean("result", true);
            String strOptString = jSONObject.optString("message", WearUtils.a2());
            String strOptString2 = jSONObject.optString(XHTMLText.CODE, NetException.SERVER_UN_DEFINE_ERROR);
            if (!zOptBoolean) {
                if (strOptString2.equals("500410")) {
                    MyApplication.N().m.post(new a(this));
                } else if ("500412".equals(strOptString2) && WearUtils.y.u() != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: dc.io2
                        @Override // java.lang.Runnable
                        public final void run() {
                            mo2.g();
                        }
                    });
                }
                jSONObject.put(XHTMLText.CODE, NetworkCodeEnum.ErrorCode.fromString(strOptString2, strOptString).getCode());
                a(strOptString2, strOptString);
                try {
                    this.callBack.onSuccess(jSONObject.toString());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    return;
                }
            }
        }
        this.callBack.onSuccess(str);
    }

    @Override // rx.Observer
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onNext(bd4 bd4Var) {
        try {
            String str = new String(bd4Var.bytes());
            if (this.callBack != null) {
                e(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            zn2<String> zn2Var = this.callBack;
            if (zn2Var != null) {
                zn2Var.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
            }
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // dc.vn2, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        zn2<String> zn2Var = this.callBack;
        if (zn2Var != null) {
            if (th instanceof SocketTimeoutException) {
                a(NetException.API_REQUEST_TIME_OUT, th.getMessage());
                this.callBack.onError(new NetException(NetException.API_REQUEST_TIME_OUT, WearUtils.b2()));
                return;
            }
            if (th instanceof HttpException) {
                zn2Var.onError(new NetException(NetException.API_REQUEST_FAILED, WearUtils.a2()));
                return;
            }
            if (th instanceof ConnectException) {
                zn2Var.onError(new NetException(NetException.SERVER_REQUEST_FAILED, WearUtils.a2()));
                return;
            }
            if (th instanceof TimeoutException) {
                zn2Var.onError(new NetException(NetException.SOCKET_TIME_OUT, WearUtils.a2()));
                return;
            }
            if (th instanceof SocketException) {
                zn2Var.onError(new NetException(NetException.SOCKET_CONNECT_ERROR, WearUtils.a2()));
            } else if (!(th instanceof NullPointerException)) {
                zn2Var.onError(new NetException(NetException.LOCAL_UN_DEFINE_ERROR, WearUtils.a2()));
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
            return;
        }
        this.callBack.onError(new NetException(NetException.NET_CONNECT_ERROR, WearUtils.Y1()));
        if (isUnsubscribed()) {
            return;
        }
        unsubscribe();
    }
}

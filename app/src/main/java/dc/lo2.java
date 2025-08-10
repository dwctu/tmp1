package dc;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.lovense.wear.R;
import com.wear.bean.FrozenData;
import com.wear.main.account.AccountFrozenActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;

/* compiled from: NetAllSubscriber.java */
/* loaded from: classes3.dex */
public class lo2<T> extends vn2<bd4> implements Serializable {
    private yn2<T> callBack;
    private Type finalNeedType;

    /* compiled from: NetAllSubscriber.java */
    public class a implements Runnable {
        public final /* synthetic */ FrozenData a;

        public a(lo2 lo2Var, FrozenData frozenData) {
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

    /* compiled from: NetAllSubscriber.java */
    public class b implements Runnable {
        public b(lo2 lo2Var) {
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

    public lo2(String str, Type type, yn2<T> yn2Var) {
        this.url = tn2.w(str) + str;
        this.finalNeedType = type;
        this.callBack = yn2Var;
    }

    public static /* synthetic */ void f(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) LoginActivity.class);
        intent.addFlags(268468224);
        activity.startActivity(intent);
    }

    public static /* synthetic */ void g() {
        final FragmentActivity fragmentActivityH = MyApplication.H();
        ep1.b().h(1);
        cs3.k(fragmentActivityH, ah4.e(R.string.notification_change_email2), new is3.d() { // from class: dc.go2
            @Override // dc.is3.d
            public final void doConfirm() {
                lo2.f(fragmentActivityH);
            }
        }).show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(java.lang.String r7) throws org.json.JSONException, com.google.gson.JsonSyntaxException {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.lo2.e(java.lang.String):void");
    }

    @Override // rx.Observer
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onNext(bd4 bd4Var) {
        try {
            String str = new String(bd4Var.bytes());
            if (this.callBack != null) {
                try {
                    if (WearUtils.e1(str)) {
                        throw new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2());
                    }
                    if (ro2.b(str, this.finalNeedType) == null) {
                        throw new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2());
                    }
                    e(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    yn2<T> yn2Var = this.callBack;
                    if (yn2Var != null) {
                        yn2Var.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            yn2<T> yn2Var2 = this.callBack;
            if (yn2Var2 != null) {
                yn2Var2.onError(new NetException(NetException.SERVICE_DATA_ERROR, WearUtils.a2()));
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
        th.printStackTrace();
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

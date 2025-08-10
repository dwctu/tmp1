package dc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;
import rx.Subscriber;

/* compiled from: BaseSubscriber.java */
/* loaded from: classes3.dex */
public abstract class vn2<T> extends Subscriber<T> {
    public String url;

    public void a(String str, String str2) {
        try {
            if (WearUtils.e1(str2)) {
                str2 = WearUtils.Y1();
            }
            ye3.d("S0005", this.url + "#" + str + "#" + str2);
        } catch (Exception unused) {
        }
    }

    public final void b(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            a(NetException.API_REQUEST_TIME_OUT, th.getMessage());
            return;
        }
        if (th instanceof HttpException) {
            a(NetException.API_REQUEST_FAILED, th.getMessage());
            return;
        }
        if (th instanceof ConnectException) {
            a(NetException.SERVER_REQUEST_FAILED, th.getMessage());
            return;
        }
        if (th instanceof TimeoutException) {
            a(NetException.SOCKET_TIME_OUT, th.getMessage());
            return;
        }
        if (th instanceof SocketException) {
            a(NetException.SOCKET_CONNECT_ERROR, th.getMessage());
        } else if (th instanceof NullPointerException) {
            a(NetException.NULL_PORINT_ERROR, th.getMessage());
        } else {
            a(NetException.LOCAL_UN_DEFINE_ERROR, th.getMessage());
        }
    }

    public void c(String str, String str2) {
        try {
            if (WearUtils.e1(str2)) {
                str2 = WearUtils.Y1();
            }
            ye3.I(str, this.url + " # " + str2 + " #  X = " + WearUtils.H + "  Y = " + WearUtils.I);
        } catch (Exception unused) {
        }
    }

    public boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            return activeNetworkInfo.isAvailable();
        }
        a(NetException.NET_CONNECT_ERROR, "Network Not Connected");
        return false;
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        b(th);
    }
}

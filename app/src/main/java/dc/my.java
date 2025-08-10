package dc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.component.dxhttp.NetException;
import io.reactivex.subscribers.DisposableSubscriber;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;

/* compiled from: BaseSubscriber.java */
/* loaded from: classes.dex */
public abstract class my<T> extends DisposableSubscriber<T> {
    public String url;

    public void a(String str, String str2) {
        de0.l(this.url + " # " + str + " # " + str2);
    }

    public final void b(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            a(NetException.d, th.getMessage());
            return;
        }
        if (th instanceof HttpException) {
            a(NetException.e, th.getMessage());
            return;
        }
        if (th instanceof ConnectException) {
            a(NetException.f, th.getMessage());
            return;
        }
        if (th instanceof TimeoutException) {
            a(NetException.g, th.getMessage());
            return;
        }
        if (th instanceof SocketException) {
            a(NetException.h, th.getMessage());
        } else if (th instanceof NullPointerException) {
            a(NetException.i, th.getMessage());
        } else {
            a(NetException.a, th.getMessage());
        }
    }

    public boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            a(NetException.b, "Network Not Connected");
            return false;
        }
        boolean zIsAvailable = activeNetworkInfo.isAvailable();
        if (!zIsAvailable) {
            a(NetException.b, "Network Not Connected");
        }
        return zIsAvailable;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        b(th);
    }
}

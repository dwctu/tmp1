package dc;

import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.config.BleConnectConfigBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleConnectRequest.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006'"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleConnectRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/ServiceDiscoverListener;", "connectOptions", "Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "curConnectCount", "", "curServiceDiscoverCount", "getResponse", "()Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "doDiscoverService", "", "doOpenNewGatt", "doing", "", "getTimeoutMillis", "", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "onConnectStatusChanged", "connectedOrDisconnected", "onConnectSuccess", "onServiceDiscoverFailed", "onServicesDiscovered", "status", "processConnect", "processConnectTimeout", "processDiscoverService", "processDiscoverServiceTimeout", "processRequest", "retryConnectIfNeeded", "retryConnectLater", "retryDiscoverServiceIfNeeded", "retryDiscoverServiceLater", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class kv extends jv implements eu {

    @NotNull
    public final BleConnectConfigBean i;

    @Nullable
    public final zv j;
    public int k;
    public int l;

    /* compiled from: BleConnectRequest.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[lt.values().length];
            iArr[lt.CONNECTED.ordinal()] = 1;
            iArr[lt.DISCONNECTED.ordinal()] = 2;
            iArr[lt.SERVICE_READY.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kv(@NotNull BleConnectConfigBean connectOptions, @Nullable zv zvVar) {
        super(zvVar);
        Intrinsics.checkNotNullParameter(connectOptions, "connectOptions");
        this.i = connectOptions;
        this.j = zvVar;
    }

    @Override // dc.jv
    public void G() {
        o();
    }

    @Override // dc.eu
    public void a(int i) {
        s().removeMessages(4);
        if (i == 0) {
            c0();
        } else {
            d0();
        }
    }

    public final boolean a0() {
        this.l++;
        return n();
    }

    public final boolean b0() {
        this.k++;
        return E();
    }

    public final void c0() {
        J("extra_response", nt.c(kt.a, t()));
        z(mt.REQUEST_SUCCESS);
    }

    public final void d0() {
        rw.a.d("onServiceDiscoverFailed");
        O();
        s().sendEmptyMessage(5);
    }

    public final void e0() {
        s().removeCallbacksAndMessages(null);
        int i = a.a[p().ordinal()];
        if (i == 1) {
            g0();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            c0();
        } else if (b0()) {
            s().sendEmptyMessageDelayed(3, this.i.getConnectTimeout());
        } else {
            m(mt.CONNECT_FAILED_BY_GATT);
        }
    }

    public final void f0() {
        y("connect timeout");
        s().removeCallbacksAndMessages(null);
        m(mt.CONNECT_FAILED_BY_CONNECT_TIMEOUT);
    }

    public final void g0() {
        rw.a.d(Intrinsics.stringPlus("processDiscoverService, status = ", p()));
        int i = a.a[p().ordinal()];
        if (i == 1) {
            if (a0()) {
                s().sendEmptyMessageDelayed(4, this.i.getServiceDiscoverTimeout());
                return;
            } else {
                d0();
                return;
            }
        }
        if (i == 2) {
            i0();
        } else {
            if (i != 3) {
                return;
            }
            c0();
        }
    }

    public final void h0() {
        y("service discover timeout");
        s().removeCallbacksAndMessages(null);
        m(mt.CONNECT_FAILED_BY_SERVICE_TIMEOUT);
    }

    @Override // dc.jv, android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i = msg.what;
        if (i == 1) {
            e0();
        } else if (i == 2) {
            g0();
        } else if (i == 3) {
            f0();
        } else if (i == 4) {
            h0();
        } else if (i == 5) {
            k0();
        }
        return super.handleMessage(msg);
    }

    @Override // dc.jv, dc.ht
    public void i(boolean z) {
        s().removeMessages(3);
        if (z) {
            s().sendEmptyMessageDelayed(2, 300L);
        } else {
            s().removeCallbacksAndMessages(null);
            i0();
        }
    }

    public final void i0() {
        if (this.k < this.i.getConnectRetryCount() + 1) {
            j0();
        } else {
            z(mt.REQUEST_FAILED);
        }
    }

    public final void j0() {
        y("retry connect later");
        s().removeCallbacksAndMessages(null);
        s().sendEmptyMessageDelayed(1, 1000L);
    }

    public final void k0() {
        if (this.l < this.i.getServiceDiscoverRetryCount() + 1) {
            l0();
        } else {
            m(mt.CONNECT_FAILED_SERVICE_RETRY_COUNT);
        }
    }

    public final void l0() {
        y("retry discover service later");
        s().removeCallbacksAndMessages(null);
        s().sendEmptyMessageDelayed(2, 1000L);
    }

    @Override // dc.jv
    public void o() {
        e0();
    }

    @Override // dc.jv
    public long u() {
        return (this.i.getConnectTimeout() * (this.i.getConnectRetryCount() + 1)) + (this.i.getServiceDiscoverTimeout() * (this.i.getServiceDiscoverRetryCount() + 1));
    }
}

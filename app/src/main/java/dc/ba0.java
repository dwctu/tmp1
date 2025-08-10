package dc;

import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.config.BleConnectConfigBean;
import com.component.dxbluetooth.lib.bean.config.BleSearchConfigBean;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sun.jna.Callback;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: ToyBleBridge.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J0\u0010\u0017\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0016J0\u0010\u0018\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0016J:\u0010\u001a\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001d\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010#\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010)H\u0016J+\u0010*\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010/2\b\u0010\r\u001a\u0004\u0018\u000100H\u0016J?\u00101\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u00010\b2\b\u00103\u001a\u0004\u0018\u00010\b2\b\u00104\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0004H\u0016J0\u00107\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u000108H\u0016J0\u00109\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010:\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010;\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010<\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010=\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010)H\u0016JB\u0010>\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\r\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u0016H\u0016JD\u0010C\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00122\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\r\u001a\u0004\u0018\u00010AH\u0016JB\u0010D\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\r\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u0016H\u0016¨\u0006E"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/ble/ToyBleBridge;", "Lcom/component/dxbluetooth/lib/listener/IBleApi;", "()V", "clearRequest", "", "mac", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "connect", "configBean", "Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleConnectResponse;", "disconnect", "indicate", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "Lcom/component/dxbluetooth/lib/response/BleNotifyResponse;", "intercept", "", "notify", "read", "Lcom/component/dxbluetooth/lib/response/BleReadResponse;", "readDescriptor", "descriptor", "readPhy", "readRssi", "Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "refreshGattCache", "registerBluetoothBondListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxbluetooth/lib/listener/IBluetoothBondListener;", "registerBluetoothPhyCallback", Callback.METHOD_NAME, "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "registerBluetoothStateListener", "Lcom/component/dxbluetooth/lib/listener/IBluetoothStateListener;", "registerConnectStatusListener", "Lcom/component/dxbluetooth/lib/listener/IBleConnectStatusListener;", "requestMtu", "mtu", "Lcom/component/dxbluetooth/lib/response/BleMtuResponse;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleMtuResponse;)V", FirebaseAnalytics.Event.SEARCH, "Lcom/component/dxbluetooth/lib/bean/config/BleSearchConfigBean;", "Lcom/component/dxbluetooth/lib/response/BleSearchResponse;", "setPhy", "txPhy", "rxPhy", "options", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleReadResponse;)V", "stopSearch", "unindicate", "Lcom/component/dxbluetooth/lib/response/BleUnnotifyResponse;", "unnotify", "unregisterBluetoothBondListener", "unregisterBluetoothPhyCallback", "unregisterBluetoothStateListener", "unregisterConnectStatusListener", "write", "value", "", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "isWaitCallback", "writeDescriptor", "writeNoRsp", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ba0 {

    @NotNull
    public static final ba0 a = new ba0();

    public void a(@Nullable String str, @Nullable Integer num) {
        if (d(str)) {
            return;
        }
        dt.a.a(str, num);
    }

    public void b(@Nullable String str, @Nullable BleConnectConfigBean bleConnectConfigBean, @Nullable yv yvVar) {
        if (d(str)) {
            return;
        }
        dt.a.b(str, bleConnectConfigBean, yvVar);
    }

    public void c(@Nullable String str) {
        if (d(str)) {
            return;
        }
        dt.a.c(str);
    }

    public final boolean d(String str) {
        if (!(str == null || str.length() == 0)) {
            nb0 nb0Var = hb0.a.e().get(str);
            if (!(nb0Var != null && nb0Var.getIsVirtualToy())) {
                return false;
            }
        }
        return true;
    }

    public void e(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable bw bwVar) {
        if (d(str)) {
            return;
        }
        dt.a.d(str, uuid, uuid2, bwVar);
    }

    public void f(@Nullable String str, @Nullable cw cwVar) {
        if (d(str)) {
            return;
        }
        dt.a.e(str, cwVar);
    }

    public void g(@Nullable String str, @Nullable dw dwVar) {
        if (d(str)) {
            return;
        }
        dt.a.f(str, dwVar);
    }

    public void h(@Nullable ut utVar) {
        dt.a.g(utVar);
    }

    public void i(@Nullable String str, @Nullable vt vtVar) {
        dt.a.h(str, vtVar);
    }

    public void j(@Nullable wt wtVar) {
        dt.a.i(wtVar);
    }

    public void k(@Nullable rt rtVar) {
        dt.a.j(rtVar);
    }

    public void l(@Nullable String str, @Nullable Integer num, @Nullable aw awVar) {
        if (d(str)) {
            return;
        }
        dt.a.k(str, num, awVar);
    }

    public void m(@Nullable BleSearchConfigBean bleSearchConfigBean, @Nullable ew ewVar) {
        dt.a.l(bleSearchConfigBean, ewVar);
    }

    public void n(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable cw cwVar) {
        if (d(str)) {
            return;
        }
        dt.a.m(str, num, num2, num3, cwVar);
    }

    public void o() {
        dt.a.n();
    }

    public void p(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        if (d(str)) {
            return;
        }
        dt.a.o(str, uuid, uuid2, bArr, fwVar, z);
    }

    public void q(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        if (d(str)) {
            return;
        }
        dt.a.p(str, uuid, uuid2, bArr, fwVar, z);
    }
}

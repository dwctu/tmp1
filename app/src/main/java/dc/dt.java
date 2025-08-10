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

/* compiled from: BleApi.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0016J0\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0016J0\u0010\u0016\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\u0016J:\u0010\u0018\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010!\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010'H\u0016J+\u0010(\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0002\u0010+J\u001c\u0010,\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010-2\b\u0010\r\u001a\u0004\u0018\u00010.H\u0016J?\u0010/\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u00100\u001a\u0004\u0018\u00010\b2\b\u00101\u001a\u0004\u0018\u00010\b2\b\u00102\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u0004H\u0016J0\u00105\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u000106H\u0016J0\u00107\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u000106H\u0016J\u0012\u00108\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001c\u00109\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010:\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010;\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010'H\u0016JB\u0010<\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\r\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020AH\u0016JD\u0010B\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\r\u001a\u0004\u0018\u00010?H\u0016JB\u0010C\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\r\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020AH\u0016¨\u0006D"}, d2 = {"Lcom/component/dxbluetooth/lib/BleApi;", "Lcom/component/dxbluetooth/lib/listener/IBleApi;", "()V", "clearRequest", "", "mac", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "connect", "configBean", "Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleConnectResponse;", "disconnect", "indicate", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "Lcom/component/dxbluetooth/lib/response/BleNotifyResponse;", "notify", "read", "Lcom/component/dxbluetooth/lib/response/BleReadResponse;", "readDescriptor", "descriptor", "readPhy", "readRssi", "Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "refreshGattCache", "registerBluetoothBondListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxbluetooth/lib/listener/IBluetoothBondListener;", "registerBluetoothPhyCallback", Callback.METHOD_NAME, "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "registerBluetoothStateListener", "Lcom/component/dxbluetooth/lib/listener/IBluetoothStateListener;", "registerConnectStatusListener", "Lcom/component/dxbluetooth/lib/listener/IBleConnectStatusListener;", "requestMtu", "mtu", "Lcom/component/dxbluetooth/lib/response/BleMtuResponse;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleMtuResponse;)V", FirebaseAnalytics.Event.SEARCH, "Lcom/component/dxbluetooth/lib/bean/config/BleSearchConfigBean;", "Lcom/component/dxbluetooth/lib/response/BleSearchResponse;", "setPhy", "txPhy", "rxPhy", "options", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleReadResponse;)V", "stopSearch", "unindicate", "Lcom/component/dxbluetooth/lib/response/BleUnnotifyResponse;", "unnotify", "unregisterBluetoothBondListener", "unregisterBluetoothPhyCallback", "unregisterBluetoothStateListener", "unregisterConnectStatusListener", "write", "value", "", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "isWaitCallback", "", "writeDescriptor", "writeNoRsp", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class dt {

    @NotNull
    public static final dt a = new dt();

    public void a(@Nullable String str, @Nullable Integer num) {
        pu.a(nu.a, str, num);
    }

    public void b(@Nullable String str, @Nullable BleConnectConfigBean bleConnectConfigBean, @Nullable yv yvVar) {
        pu.b(nu.a, str, bleConnectConfigBean, yvVar);
    }

    public void c(@Nullable String str) {
        pu.d(nu.a, str);
    }

    public void d(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable bw bwVar) {
        pu.e(nu.a, str, uuid, uuid2, bwVar);
    }

    public void e(@Nullable String str, @Nullable cw cwVar) {
        pu.f(nu.a, str, cwVar);
    }

    public void f(@Nullable String str, @Nullable dw dwVar) {
        pu.g(nu.a, str, dwVar);
    }

    public void g(@Nullable ut utVar) {
        ou.a(nu.a, utVar);
    }

    public void h(@Nullable String str, @Nullable vt vtVar) {
        ou.b(nu.a, str, vtVar);
    }

    public void i(@Nullable wt wtVar) {
        ou.c(nu.a, wtVar);
    }

    public void j(@Nullable rt rtVar) {
        ou.d(nu.a, rtVar);
    }

    public void k(@Nullable String str, @Nullable Integer num, @Nullable aw awVar) {
        pu.h(nu.a, str, num, awVar);
    }

    public void l(@Nullable BleSearchConfigBean bleSearchConfigBean, @Nullable ew ewVar) {
        pu.i(nu.a, bleSearchConfigBean, ewVar);
    }

    public void m(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable cw cwVar) {
        pu.j(nu.a, str, num, num2, num3, cwVar);
    }

    public void n() {
        pu.k(nu.a);
    }

    public void o(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        pu.l(nu.a, str, uuid, uuid2, bArr, fwVar, z);
    }

    public void p(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        pu.m(nu.a, str, uuid, uuid2, bArr, fwVar, z);
    }
}

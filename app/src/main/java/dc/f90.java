package dc;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sun.jna.Callback;
import dc.q90;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: ToyCoreApi.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/api/ToyCoreApi;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class f90 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCoreApi.kt */
    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010\u001c\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001fJ\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J+\u0010!\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(J,\u0010&\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\u000fJ:\u0010,\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010)\u001a\u0004\u0018\u0001002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010*J&\u0010,\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010)\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010*J:\u00101\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010)\u001a\u0004\u0018\u0001002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010*J=\u00102\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00103\u001a\u0004\u0018\u00010#2\b\u00104\u001a\u0004\u0018\u00010#2\b\u00105\u001a\u0004\u0018\u00010#2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u000fH\u0016J\u001a\u00109\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010:\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001f¨\u0006;"}, d2 = {"Lcom/component/dxtoy/core/api/ToyCoreApi$Companion;", "Lcom/component/dxtoy/core/bluetooth/listenter/IToyBtApi;", "Lcom/component/dxtoy/core/api/listenter/IToySchedule;", "()V", "addScheduledTask", "", "task", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "interval", "", "cancelAll", "mac", "", "deviceScan", "isStart", "", "disconnect", "init", "appEngine", "Lcom/component/dxtoy/core/api/engine/IToyAppEngine;", "readPhy", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleReadResponse;", "readRssi", "Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "registerBluetoothPhyCallback", Callback.METHOD_NAME, "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "registerDispatcher", ExifInterface.GPS_DIRECTION_TRUE, "handler", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "removeScheduledTask", "requestMtu", "mtu", "", "Lcom/component/dxbluetooth/lib/response/BleMtuResponse;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleMtuResponse;)V", "sendCommand", "commandBean", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "value", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "isWaitCallback", "sendCommandByWrite", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "", "sendCommandByWriteNoResp", "setPhy", "txPhy", "rxPhy", "options", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleReadResponse;)V", "setScanAllDeviceSwitch", "isOn", "unregisterBluetoothPhyCallback", "unregisterDispatcher", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void m(a aVar, String str, String str2, fw fwVar, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                fwVar = null;
            }
            if ((i & 8) != 0) {
                z = true;
            }
            aVar.l(str, str2, fwVar, z);
        }

        public void a(@NotNull q90.b task, long j) {
            Intrinsics.checkNotNullParameter(task, "task");
            q90.c.e(task, j);
        }

        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            ia0.a.a(mac);
        }

        public void c(boolean z) {
            z90.a.a(z);
        }

        public void d(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            z90.a.b(mac);
        }

        public final void e(@NotNull g90 appEngine) {
            Intrinsics.checkNotNullParameter(appEngine, "appEngine");
            gb0 gb0Var = gb0.a;
            hb0.a.i(appEngine);
            z90 z90Var = z90.a;
        }

        public final void f(@Nullable String str, @Nullable cw cwVar) {
            ca0.a.d(str, cwVar);
        }

        public final void g(@Nullable String str, @Nullable dw dwVar) {
            ca0.a.e(str, dwVar);
        }

        public final void h(@Nullable String str, @Nullable vt vtVar) {
            ba0.a.i(str, vtVar);
        }

        public void i(@NotNull q90.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            q90.c.f(task);
        }

        public final void j(@Nullable String str, @Nullable Integer num, @Nullable aw awVar) {
            ca0.a.f(str, num, awVar);
        }

        public final void k(@NotNull ToyCommandBean commandBean) {
            Intrinsics.checkNotNullParameter(commandBean, "commandBean");
            ia0.a.h(commandBean);
        }

        public final void l(@NotNull String mac, @NotNull String value, @Nullable fw fwVar, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            ia0.a.i(mac, value, fwVar, z);
        }

        public final void n(@Nullable String str, @Nullable String str2, @Nullable fw fwVar) {
            ca0.j(ca0.a, str, str2, fwVar, false, 8, null);
        }

        public final void o(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar) {
            ca0.k(ca0.a, str, uuid, uuid2, bArr, fwVar, false, 32, null);
        }

        public final void p(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable cw cwVar) {
            ca0.a.g(str, num, num2, num3, cwVar);
        }

        public void q(boolean z) {
            z90.a.h(z);
        }
    }
}

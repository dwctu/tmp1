package dc;

import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.BleDeviceBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.bw;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyBleListener.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/ble/ToyBleListener;", "", "()V", "connectResponseMap", "Ljava/util/HashMap;", "", "Lcom/component/dxtoy/core/bluetooth/ble/ToyBleListener$BtConnectResponse;", "getConnectResponseMap", "()Ljava/util/HashMap;", "connectResponseMap$delegate", "Lkotlin/Lazy;", "notifyResponseMap", "Lcom/component/dxtoy/core/bluetooth/ble/ToyBleListener$BtNotifyResponse;", "getNotifyResponseMap", "notifyResponseMap$delegate", "getConnectResponse", "mac", "getNotifyResponse", "BtConnectResponse", "BtNotifyResponse", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class da0 {

    @NotNull
    public static final da0 a = new da0();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(d.a);

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(c.a);

    /* compiled from: ToyBleListener.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/ble/ToyBleListener$BtConnectResponse;", "Lcom/component/dxbluetooth/lib/response/BleConnectResponse;", "mac", "", "(Ljava/lang/String;)V", "getMac", "()Ljava/lang/String;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "onResponse", "data", "Lcom/component/dxbluetooth/lib/bean/BleDeviceBean;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements yv {

        @NotNull
        public final String a;

        public a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            this.a = mac;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            de0.i("ble__connectResponse__onError " + code + ' ' + str);
            z90.a.c().p(this.a, mt.toResultBean$default(code, null, 1, null));
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable BleDeviceBean bleDeviceBean) {
            Intrinsics.checkNotNullParameter(code, "code");
            de0.i("ble__connectResponse__onResponse " + code + ' ' + bleDeviceBean);
            z90.a.c().q(code, bleDeviceBean);
        }
    }

    /* compiled from: ToyBleListener.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/ble/ToyBleListener$BtNotifyResponse;", "Lcom/component/dxbluetooth/lib/response/BleNotifyResponse;", "mac", "", "(Ljava/lang/String;)V", "getMac", "()Ljava/lang/String;", "onNotify", "", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "value", "", "onResponse", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "data", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements bw {

        @NotNull
        public final String a;

        public b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            this.a = mac;
        }

        @Override // dc.qt
        public void b(@NotNull mt mtVar, @Nullable String str) {
            bw.a.a(this, mtVar, str);
        }

        @Override // dc.bw
        public void c(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr) {
            if (bArr != null) {
                ja0 ja0VarE = ia0.a.e();
                String str = this.a;
                String strC = qd0.c(bArr);
                Intrinsics.checkNotNullExpressionValue(strC, "bytes2String(value)");
                ja0VarE.c(str, strC, bArr);
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable byte[] bArr) {
            Intrinsics.checkNotNullParameter(code, "code");
            z90.a.c().r(this.a);
        }
    }

    /* compiled from: ToyBleListener.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/component/dxtoy/core/bluetooth/ble/ToyBleListener$BtConnectResponse;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<HashMap<String, a>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, a> invoke() {
            return new HashMap<>();
        }
    }

    /* compiled from: ToyBleListener.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/component/dxtoy/core/bluetooth/ble/ToyBleListener$BtNotifyResponse;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<HashMap<String, b>> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, b> invoke() {
            return new HashMap<>();
        }
    }

    @NotNull
    public final synchronized a a(@NotNull String mac) {
        a aVar;
        Intrinsics.checkNotNullParameter(mac, "mac");
        aVar = b().get(mac);
        if (aVar == null) {
            aVar = new a(mac);
            b().put(mac, aVar);
        }
        return aVar;
    }

    public final HashMap<String, a> b() {
        return (HashMap) c.getValue();
    }

    @NotNull
    public final synchronized b c(@NotNull String mac) {
        b bVar;
        Intrinsics.checkNotNullParameter(mac, "mac");
        bVar = d().get(mac);
        if (bVar == null) {
            bVar = new b(mac);
            d().put(mac, bVar);
        }
        return bVar;
    }

    public final HashMap<String, b> d() {
        return (HashMap) b.getValue();
    }
}

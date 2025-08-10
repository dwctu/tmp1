package dc;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.config.BleConnectConfigBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleDevice.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u001c\u00103\u001a\u0002002\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u000200H\u0016J&\u00109\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u00106\u001a\u0004\u0018\u000107H\u0016J&\u0010=\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u00106\u001a\u0004\u0018\u000107H\u0016J&\u0010>\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u00106\u001a\u0004\u0018\u000107H\u0016J0\u0010?\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010@\u001a\u0004\u0018\u00010;2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010A\u001a\u0002002\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010B\u001a\u0002002\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010C\u001a\u000200H\u0016J\u001a\u0010D\u001a\u0002002\u0006\u0010E\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0016J*\u0010F\u001a\u0002002\u0006\u0010G\u001a\u0002022\u0006\u0010H\u001a\u0002022\u0006\u0010I\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0016J&\u0010J\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u00106\u001a\u0004\u0018\u000107H\u0016J8\u0010K\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010N\u001a\u00020OH\u0016J:\u0010P\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010@\u001a\u0004\u0018\u00010;2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u00106\u001a\u0004\u0018\u000107H\u0016J8\u0010Q\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010N\u001a\u00020OH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006R"}, d2 = {"Lcom/component/dxbluetooth/lib/manager/BleDevice;", "Lcom/component/dxbluetooth/lib/listener/IBleQueue;", "mac", "", "(Ljava/lang/String;)V", "bleConnect", "Lcom/component/dxbluetooth/lib/connect/BleConnect;", "getBleConnect", "()Lcom/component/dxbluetooth/lib/connect/BleConnect;", "bleConnect$delegate", "Lkotlin/Lazy;", "bleQueue", "Lcom/component/dxbluetooth/lib/connect/BleQueue;", "getBleQueue", "()Lcom/component/dxbluetooth/lib/connect/BleQueue;", "bleQueue$delegate", "bleWorker", "Lcom/component/dxbluetooth/lib/connect/BleWorker;", "getBleWorker", "()Lcom/component/dxbluetooth/lib/connect/BleWorker;", "bleWorker$delegate", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevice", "()Landroid/bluetooth/BluetoothDevice;", "setBluetoothDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "bluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "getBluetoothGatt", "()Landroid/bluetooth/BluetoothGatt;", "setBluetoothGatt", "(Landroid/bluetooth/BluetoothGatt;)V", "getMac", "()Ljava/lang/String;", "phyCallback", "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "getPhyCallback", "()Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "setPhyCallback", "(Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;)V", "status", "Lcom/component/dxbluetooth/lib/data/BleEum$DevcieStatus;", "getStatus", "()Lcom/component/dxbluetooth/lib/data/BleEum$DevcieStatus;", "setStatus", "(Lcom/component/dxbluetooth/lib/data/BleEum$DevcieStatus;)V", "clearRequest", "", "clearType", "", "connect", "configBean", "Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "disconnect", "indicate", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "notify", "read", "readDescriptor", "descriptor", "readPhy", "readRemoteRssi", "refreshGattCache", "requestMtu", "mtu", "setPhy", "txPhy", "rxPhy", "phyOptions", "unnotify", "write", "bytes", "", "isWaitCallback", "", "writeDescriptor", "writeNoRsp", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class lu {

    @NotNull
    public final String a;

    @NotNull
    public lt b;

    @NotNull
    public final Lazy c;

    @NotNull
    public final Lazy d;

    @NotNull
    public final Lazy e;

    @Nullable
    public BluetoothGatt f;

    @Nullable
    public BluetoothDevice g;

    @Nullable
    public vt h;

    /* compiled from: BleDevice.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxbluetooth/lib/connect/BleConnect;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<et> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final et invoke() {
            return new et(lu.this.getA());
        }
    }

    /* compiled from: BleDevice.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxbluetooth/lib/connect/BleQueue;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<ft> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ft invoke() {
            return new ft(lu.this.getA());
        }
    }

    /* compiled from: BleDevice.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxbluetooth/lib/connect/BleWorker;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function0<gt> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final gt invoke() {
            return new gt(lu.this.getA());
        }
    }

    public lu(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
        this.b = lt.DISCONNECTED;
        this.c = LazyKt__LazyJVMKt.lazy(new a());
        this.d = LazyKt__LazyJVMKt.lazy(new b());
        this.e = LazyKt__LazyJVMKt.lazy(new c());
    }

    public void A(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable zv zvVar, boolean z) {
        e().w(uuid, uuid2, bArr, zvVar, z);
    }

    public void a(int i) {
        e().c(i);
    }

    public void b(@Nullable BleConnectConfigBean bleConnectConfigBean, @Nullable zv zvVar) {
        d().a(bleConnectConfigBean, zvVar);
    }

    public void c() {
        d().b();
    }

    public final et d() {
        return (et) this.c.getValue();
    }

    @NotNull
    public final ft e() {
        return (ft) this.d.getValue();
    }

    @NotNull
    public final gt f() {
        return (gt) this.e.getValue();
    }

    @Nullable
    public final BluetoothDevice g() {
        if (this.g == null) {
            this.g = sw.a.d(this.a);
        }
        return this.g;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final BluetoothGatt getF() {
        return this.f;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getA() {
        return this.a;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final vt getH() {
        return this.h;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final lt getB() {
        return this.b;
    }

    public void l(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        e().h(uuid, uuid2, zvVar);
    }

    public void m(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        e().j(uuid, uuid2, zvVar);
    }

    public void n(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        e().k(uuid, uuid2, zvVar);
    }

    public void o(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable zv zvVar) {
        e().l(uuid, uuid2, uuid3, zvVar);
    }

    public void p(@Nullable zv zvVar) {
        e().m(zvVar);
    }

    public void q(@Nullable zv zvVar) {
        e().n(zvVar);
    }

    public void r() {
        e().o();
    }

    public void s(int i, @Nullable zv zvVar) {
        e().p(i, zvVar);
    }

    public final void t(@Nullable BluetoothGatt bluetoothGatt) {
        this.f = bluetoothGatt;
    }

    public void u(int i, int i2, int i3, @Nullable zv zvVar) {
        e().s(i, i2, i3, zvVar);
    }

    public final void v(@Nullable vt vtVar) {
        this.h = vtVar;
    }

    public final void w(@NotNull lt ltVar) {
        Intrinsics.checkNotNullParameter(ltVar, "<set-?>");
        this.b = ltVar;
    }

    public void x(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        e().t(uuid, uuid2, zvVar);
    }

    public void y(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable zv zvVar, boolean z) {
        e().u(uuid, uuid2, bArr, zvVar, z);
    }

    public void z(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable byte[] bArr, @Nullable zv zvVar) {
        e().v(uuid, uuid2, uuid3, bArr, zvVar);
    }
}

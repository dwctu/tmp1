package dc;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.service.BleService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: BleWorker.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J-\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0016J\u001f\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0017J\u001e\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u001e\u0010)\u001a\u0004\u0018\u00010&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001e\u0010*\u001a\u0004\u0018\u00010&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020&2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010.\u001a\u00020\u00112\u0006\u0010,\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010/\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0019H\u0016J\"\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u00104\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J(\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J(\u0010;\u001a\u00020\u00112\u0006\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010>\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010?\u001a\u00020$H\u0017J\u001c\u0010@\u001a\u00020$2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010,\u001a\u0004\u0018\u00010\u0013H\u0017J&\u0010A\u001a\u00020$2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010,\u001a\u0004\u0018\u00010\u00132\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0017J\b\u0010B\u001a\u00020$H\u0017J\b\u0010C\u001a\u00020$H\u0017J\b\u0010D\u001a\u00020\u0011H\u0002J\b\u0010E\u001a\u00020$H\u0016J\u0012\u0010F\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010G\u001a\u00020$2\u0006\u00106\u001a\u00020\u0019H\u0017J-\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020J2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010KJ$\u0010L\u001a\u00020$2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010M\u001a\u00020$H\u0017J$\u0010N\u001a\u00020$2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010M\u001a\u00020$H\u0017J\u0010\u0010O\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020JH\u0002J \u0010P\u001a\u00020$2\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\u0019H\u0017J&\u0010T\u001a\u00020$2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J&\u0010U\u001a\u00020$2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J0\u0010V\u001a\u00020$2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010,\u001a\u0004\u0018\u00010\u00132\b\u00102\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/component/dxbluetooth/lib/connect/BleWorker;", "Lcom/component/dxbluetooth/lib/listener/IBleWorker;", "Lcom/component/dxbluetooth/lib/connect/listener/IBluetoothGattResponse;", "mac", "", "(Ljava/lang/String;)V", "bleDevice", "Lcom/component/dxbluetooth/lib/manager/BleDevice;", "getBleDevice", "()Lcom/component/dxbluetooth/lib/manager/BleDevice;", "bleDevice$delegate", "Lkotlin/Lazy;", "getMac", "()Ljava/lang/String;", "responseListener", "Lcom/component/dxbluetooth/lib/connect/listener/GattResponseListener;", "broadcastCharacterChanged", "", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "value", "", "broadcastConnectStatus", "status", "", "failedResult", "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "failedResultStatus", "(ILcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "clearGattResponseListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "closeGatt", "result", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "discoverService", "", "getBleDeviceCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "getBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "getCharacter", "getGattCharacteristic", "onCharacteristicChanged", "characteristic", "onCharacteristicRead", "onCharacteristicWrite", "onConnectionStateChange", DownloaderClientMarshaller.PARAM_NEW_STATE, "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWrite", "onMtuChanged", "mtu", "onPhyRead", "gatt", "txPhy", "rxPhy", "onPhyUpdate", "onReadRemoteRssi", "rssi", "onServicesDiscovered", "openGatt", "readCharacteristic", "readDescriptor", "readPhy", "readRemoteRssi", "refreshCharacteristicMap", "refreshDeviceCache", "registerGattResponseListener", "requestMtu", "setBleDeviceStatus", "state", "Lcom/component/dxbluetooth/lib/data/BleEum$DevcieStatus;", "(Lcom/component/dxbluetooth/lib/data/BleEum$DevcieStatus;Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "setCharacteristicIndication", StreamManagement.Enable.ELEMENT, "setCharacteristicNotification", "setConnectStatus", "setPreferredPhy", "tx", "rx", "phyOptions", "writeCharacteristic", "writeCharacteristicWithNoRsp", "writeDescriptor", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class gt implements tt, it {

    @NotNull
    public final String a;

    @NotNull
    public final Lazy b;

    @Nullable
    public ht c;

    /* compiled from: BleWorker.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[lt.values().length];
            iArr[lt.SERVICE_READY.ordinal()] = 1;
            iArr[lt.CONNECTED.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: BleWorker.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxbluetooth/lib/manager/BleDevice;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<lu> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lu invoke() {
            return ot.a(kt.a, gt.this.getA());
        }
    }

    public gt(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
        this.b = LazyKt__LazyJVMKt.lazy(new b());
    }

    public static /* synthetic */ void G(gt gtVar, lt ltVar, mt mtVar, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            mtVar = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        gtVar.F(ltVar, mtVar, num);
    }

    @SuppressLint({"MissingPermission"})
    public boolean A() {
        rw rwVar = rw.a;
        rwVar.d(Intrinsics.stringPlus("readRemoteRssi for ", this.a));
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (bluetoothGattS.readRemoteRssi()) {
            return true;
        }
        rwVar.b("readRemoteRssi failed");
        return false;
    }

    public final void B() {
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            return;
        }
        BluetoothDevice bluetoothDeviceG = q().g();
        if (bluetoothDeviceG != null) {
            rw.a.d(Intrinsics.stringPlus("refreshServiceProfile for ", bluetoothDeviceG.getAddress()));
        }
        kt ktVar = kt.a;
        String a2 = getA();
        List<BluetoothGattService> services = bluetoothGattS.getServices();
        Intrinsics.checkNotNullExpressionValue(services, "it.services");
        nt.a(ktVar, a2, services);
    }

    public boolean C() {
        rw rwVar = rw.a;
        rwVar.d(Intrinsics.stringPlus("refreshDeviceCache for ", this.a));
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (sw.a.i(bluetoothGattS)) {
            return true;
        }
        rwVar.b("refreshDeviceCache failed");
        return false;
    }

    public void D(@Nullable ht htVar) {
        this.c = htVar;
    }

    @SuppressLint({"MissingPermission"})
    public boolean E(int i) {
        rw rwVar = rw.a;
        rwVar.d("requestMtu for " + this.a + ", mtu = " + i);
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (bluetoothGattS.requestMtu(i)) {
            return true;
        }
        rwVar.b("requestMtu failed");
        return false;
    }

    public final void F(lt ltVar, mt mtVar, Integer num) {
        J(ltVar);
        int i = a.a[ltVar.ordinal()];
        if (i == 1) {
            n(lt.CONNECTED.getStatus(), mtVar, num);
        } else if (i != 2) {
            n(ltVar.getStatus(), mtVar, num);
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean H(@Nullable UUID uuid, @Nullable UUID uuid2, boolean z) {
        rw rwVar = rw.a;
        rwVar.d("setCharacteristicIndication for " + this.a + " enable = " + z);
        BluetoothGattCharacteristic bluetoothGattCharacteristicT = t(uuid, uuid2);
        if (bluetoothGattCharacteristicT == null) {
            rwVar.b("characteristic not exist!");
            return false;
        }
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (!bluetoothGattS.setCharacteristicNotification(bluetoothGattCharacteristicT, z)) {
            rwVar.b("setCharacteristicIndication failed");
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicT.getDescriptor(jt.a.a());
        if (descriptor == null) {
            rwVar.b("getDescriptor for indicate null!");
            return false;
        }
        if (!descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
            rwVar.b("setValue for indicate descriptor failed!");
            return false;
        }
        if (bluetoothGattS.writeDescriptor(descriptor)) {
            return true;
        }
        rwVar.b("writeDescriptor for indicate failed");
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean I(@Nullable UUID uuid, @Nullable UUID uuid2, boolean z) {
        rw rwVar = rw.a;
        rwVar.d("setCharacteristicNotification for " + this.a + " enable = " + z);
        BluetoothGattCharacteristic bluetoothGattCharacteristicT = t(uuid, uuid2);
        if (bluetoothGattCharacteristicT == null) {
            rwVar.b("characteristic not exist!");
            return false;
        }
        if (!sw.a.g(bluetoothGattCharacteristicT)) {
            rwVar.b("characteristic not notifyable!");
            return false;
        }
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (!bluetoothGattS.setCharacteristicNotification(bluetoothGattCharacteristicT, z)) {
            rwVar.b("setCharacteristicNotification failed");
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicT.getDescriptor(jt.a.a());
        if (descriptor == null) {
            rwVar.b("getDescriptor for notify null!");
            return false;
        }
        if (!descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
            rwVar.b("setValue for notify descriptor failed!");
            return false;
        }
        if (bluetoothGattS.writeDescriptor(descriptor)) {
            return true;
        }
        rwVar.b("writeDescriptor for notify failed");
        return false;
    }

    public final void J(lt ltVar) {
        rw.a.d(Intrinsics.stringPlus("setConnectStatus status = ", ltVar));
        q().w(ltVar);
    }

    @SuppressLint({"MissingPermission"})
    public boolean K(int i, int i2, int i3) {
        rw rwVar = rw.a;
        rwVar.d("setPreferredPhy for " + i + ", " + i2 + ", " + i3);
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        bluetoothGattS.setPreferredPhy(i, i2, i3);
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public boolean L(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr) {
        String string;
        rw rwVar = rw.a;
        StringBuilder sb = new StringBuilder();
        sb.append("writeCharacteristic for ");
        sb.append(this.a);
        sb.append(" value = ");
        sb.append((Object) qd0.c(bArr));
        sb.append(", byte = ");
        if (bArr == null) {
            string = null;
        } else {
            string = Arrays.toString(bArr);
            Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        }
        sb.append((Object) string);
        rwVar.d(sb.toString());
        BluetoothGattCharacteristic bluetoothGattCharacteristicT = t(uuid, uuid2);
        if (bluetoothGattCharacteristicT == null) {
            rwVar.b("characteristic not exist!");
            return false;
        }
        if (!sw.a.h(bluetoothGattCharacteristicT)) {
            rwVar.b("characteristic not writable!");
            return false;
        }
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        bluetoothGattCharacteristicT.setValue(bArr);
        bluetoothGattCharacteristicT.setWriteType(2);
        if (bluetoothGattS.writeCharacteristic(bluetoothGattCharacteristicT)) {
            return true;
        }
        rwVar.b("writeCharacteristic failed");
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean M(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr) {
        String string;
        rw rwVar = rw.a;
        StringBuilder sb = new StringBuilder();
        sb.append("writeCharacteristicWithNoRsp for ");
        sb.append(this.a);
        sb.append(" value = ");
        sb.append((Object) qd0.c(bArr));
        sb.append(" byte = ");
        if (bArr == null) {
            string = null;
        } else {
            string = Arrays.toString(bArr);
            Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        }
        sb.append((Object) string);
        rwVar.d(sb.toString());
        BluetoothGattCharacteristic bluetoothGattCharacteristicT = t(uuid, uuid2);
        if (bluetoothGattCharacteristicT == null) {
            rwVar.b("characteristic not exist!");
            return false;
        }
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        bluetoothGattCharacteristicT.setValue(bArr);
        bluetoothGattCharacteristicT.setWriteType(1);
        if (bluetoothGattS.writeCharacteristic(bluetoothGattCharacteristicT)) {
            return true;
        }
        rwVar.b("writeCharacteristicWithNoRsp failed");
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean N(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable byte[] bArr) {
        rw rwVar = rw.a;
        rwVar.d("writeDescriptor for " + this.a + " descriptor = " + uuid3 + " value = " + ((Object) qd0.c(bArr)));
        BluetoothGattCharacteristic bluetoothGattCharacteristicT = t(uuid, uuid2);
        if (bluetoothGattCharacteristicT == null) {
            rwVar.b("characteristic not exist!");
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicT.getDescriptor(uuid3);
        if (descriptor == null) {
            rwVar.b("descriptor not exist");
            return false;
        }
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        descriptor.setValue(bArr);
        if (bluetoothGattS.writeDescriptor(descriptor)) {
            return true;
        }
        rwVar.b("writeDescriptor failed");
        return false;
    }

    @Override // dc.it
    public void a(int i) {
        rw.a.d("onServicesDiscovered for " + this.a + ": status = " + i);
        if (i == 0) {
            G(this, lt.SERVICE_READY, null, null, 6, null);
            B();
        }
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof eu)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.ServiceDiscoverListener");
        ((eu) htVar).a(i);
    }

    @Override // dc.it
    public void b(@NotNull BluetoothGattDescriptor descriptor, int i, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        rw.a.d("onDescriptorRead for " + this.a + " status = " + i + " descriptor = 0x" + descriptor.getUuid());
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof zt)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.ReadDescriptorListener");
        ((zt) htVar).b(descriptor, i, bArr);
    }

    @Override // dc.it
    public void c(@NotNull BluetoothGattCharacteristic characteristic, int i, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        rw.a.d("onCharacteristicRead for " + this.a + " status = " + i + " value = " + ((Object) qd0.c(bArr)));
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof yt)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.ReadCharacterListener");
        ((yt) htVar).c(characteristic, i, bArr);
    }

    @Override // dc.it
    public void d(int i, int i2) {
        rw.a.d("onReadRemoteRssi for " + this.a + ", rssi = " + i + ", status = " + i2);
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof au)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.ReadRssiListener");
        ((au) htVar).d(i, i2);
    }

    @Override // dc.it
    public void e(int i, int i2) {
        rw.a.d("onMtuChanged for " + this.a + ", mtu = " + i + ", status = " + i2);
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof bu)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.RequestMtuListener");
        ((bu) htVar).e(i, i2);
    }

    @Override // dc.it
    public void f(@NotNull BluetoothGattCharacteristic characteristic, int i, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        rw.a.d("onCharacteristicWrite for " + this.a + " status = " + i + " value = " + ((Object) qd0.c(bArr)));
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof fu)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.WriteCharacterListener");
        ((fu) htVar).f(characteristic, i, bArr);
    }

    @Override // dc.it
    public void g(@NotNull BluetoothGattDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        rw.a.d("onDescriptorWrite for " + this.a + " status = " + i + " descriptor = 0x" + descriptor.getUuid());
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof gu)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.WriteDescriptorListener");
        ((gu) htVar).g(descriptor, i);
    }

    @Override // dc.tt
    @SuppressLint({"MissingPermission"})
    public void h(@NotNull mt result, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(result, "result");
        rw.a.d("closeGatt for " + this.a + " result = " + result);
        try {
            F(lt.DISCONNECTED, result, num);
            ht htVar = this.c;
            if (htVar != null) {
                htVar.i(false);
            }
            BluetoothGatt bluetoothGattS = s();
            if (bluetoothGattS != null) {
                bluetoothGattS.disconnect();
            }
            C();
            BluetoothGatt bluetoothGattS2 = s();
            if (bluetoothGattS2 != null) {
                bluetoothGattS2.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        q().t(null);
    }

    @Override // dc.it
    public void i(@NotNull BluetoothGatt gatt, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        rw.a.d("onPhyUpdate for " + this.a + ", txPhy = " + i + ", rxPhy = " + i2 + ", status = " + i3);
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof du)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.RequestSetPhyListener");
        ((du) htVar).h(i, i2, i3);
    }

    @Override // dc.it
    public void j(int i, int i2) {
        rw.a.d("onConnectionStateChange address = " + this.a + " status = " + i + ", newState = " + i2);
        if (i != 0 || i2 != 2) {
            h(mt.CONNECT_FAILED_BY_STATE_CHANGE, Integer.valueOf(i));
            return;
        }
        G(this, lt.CONNECTED, null, null, 6, null);
        ht htVar = this.c;
        if (htVar == null) {
            return;
        }
        htVar.i(true);
    }

    @Override // dc.it
    public void k(@NotNull BluetoothGattCharacteristic characteristic, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        rw.a.d("onCharacteristicChanged for " + this.a + " value = " + ((Object) qd0.c(bArr)));
        UUID uuid = characteristic.getService().getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "characteristic.service.uuid");
        UUID uuid2 = characteristic.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid2, "characteristic.uuid");
        m(uuid, uuid2, bArr);
    }

    @Override // dc.it
    public void l(@NotNull BluetoothGatt gatt, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        rw.a.d("onPhyRead for " + this.a + ", txPhy = " + i + ", rxPhy = " + i2 + ", status = " + i3);
        ht htVar = this.c;
        if (htVar == null || !(htVar instanceof cu)) {
            return;
        }
        Objects.requireNonNull(htVar, "null cannot be cast to non-null type com.component.dxbluetooth.lib.listener.request.RequestReadPhyListener");
        ((cu) htVar).j(i, i2, i3);
    }

    public final void m(UUID uuid, UUID uuid2, byte[] bArr) {
        Intent intent = new Intent("action_character_changed");
        intent.putExtra("extra_mac", this.a);
        intent.putExtra("extra_service_uuid", uuid);
        intent.putExtra("extra_character_uuid", uuid2);
        intent.putExtra("extra_byte_value", bArr);
        sw.a.k(intent);
    }

    public final void n(int i, mt mtVar, Integer num) {
        Intent intent = new Intent("action_connect_status_changed");
        intent.putExtra("extra_mac", this.a);
        intent.putExtra("extra_status", i);
        intent.putExtra("extra_result", mtVar == null ? null : mtVar.toResultBean(num));
        sw.a.k(intent);
    }

    public void o(@Nullable ht htVar) {
        if (this.c == htVar) {
            this.c = null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean p() {
        rw rwVar = rw.a;
        rwVar.d(Intrinsics.stringPlus("discoverService for ", this.a));
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("discoverService but gatt is null!");
            return false;
        }
        if (bluetoothGattS.discoverServices()) {
            return true;
        }
        rwVar.b("discoverServices failed");
        return false;
    }

    public final lu q() {
        return (lu) this.b.getValue();
    }

    public final BluetoothGattCharacteristic r(UUID uuid, UUID uuid2) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicB = nt.b(kt.a, this.a, uuid, uuid2);
        if (bluetoothGattCharacteristicB == null) {
            return null;
        }
        return bluetoothGattCharacteristicB;
    }

    public final BluetoothGatt s() {
        return q().getF();
    }

    public final BluetoothGattCharacteristic t(UUID uuid, UUID uuid2) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicR = r(uuid, uuid2);
        return bluetoothGattCharacteristicR == null ? u(uuid, uuid2) : bluetoothGattCharacteristicR;
    }

    public final BluetoothGattCharacteristic u(UUID uuid, UUID uuid2) {
        BluetoothGattService service;
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null || (service = bluetoothGattS.getService(uuid)) == null) {
            return null;
        }
        return service.getCharacteristic(uuid2);
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final String getA() {
        return this.a;
    }

    @SuppressLint({"MissingPermission"})
    public boolean w() {
        rw rwVar = rw.a;
        rwVar.d(Intrinsics.stringPlus("openGatt for ", this.a));
        if (s() != null) {
            rwVar.b("Previous gatt not closed");
            return true;
        }
        BleService bleServiceB = qw.a.b();
        gw gwVar = new gw(this);
        lu luVarQ = q();
        BluetoothGatt bluetoothGattConnectGatt = null;
        if (Build.VERSION.SDK_INT >= 23) {
            BluetoothDevice bluetoothDeviceG = q().g();
            if (bluetoothDeviceG != null) {
                bluetoothGattConnectGatt = bluetoothDeviceG.connectGatt(bleServiceB, false, gwVar, 2);
            }
        } else {
            BluetoothDevice bluetoothDeviceG2 = q().g();
            if (bluetoothDeviceG2 != null) {
                bluetoothGattConnectGatt = bluetoothDeviceG2.connectGatt(bleServiceB, false, gwVar);
            }
        }
        luVarQ.t(bluetoothGattConnectGatt);
        if (s() == null) {
            rwVar.b("openGatt failed: connectGatt return null!");
            return false;
        }
        G(this, lt.CONNECTING, null, null, 6, null);
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public boolean x(@Nullable UUID uuid, @Nullable UUID uuid2) {
        rw rwVar = rw.a;
        rwVar.d("readCharacteristic for " + this.a + ": service = " + uuid + ", character = " + uuid2);
        BluetoothGattCharacteristic bluetoothGattCharacteristicT = t(uuid, uuid2);
        if (bluetoothGattCharacteristicT == null) {
            rwVar.b("characteristic not exist!");
            return false;
        }
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (bluetoothGattS.readCharacteristic(bluetoothGattCharacteristicT)) {
            return true;
        }
        rwVar.b("readCharacteristic failed");
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean y(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3) {
        rw rwVar = rw.a;
        rwVar.d("readDescriptor for " + this.a + " descriptor = " + uuid3);
        BluetoothGattCharacteristic bluetoothGattCharacteristicT = t(uuid, uuid2);
        if (bluetoothGattCharacteristicT == null) {
            rwVar.b("characteristic not exist!");
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicT.getDescriptor(uuid3);
        if (descriptor == null) {
            rwVar.b("descriptor not exist");
            return false;
        }
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (bluetoothGattS.readDescriptor(descriptor)) {
            return true;
        }
        rwVar.b("readDescriptor failed");
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean z() {
        rw rwVar = rw.a;
        rwVar.d(Intrinsics.stringPlus("readPhy for ", this.a));
        BluetoothGatt bluetoothGattS = s();
        if (bluetoothGattS == null) {
            rwVar.b("ble gatt null");
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        bluetoothGattS.readPhy();
        return true;
    }
}

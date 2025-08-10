package dc;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* compiled from: BleUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbluetooth/lib/utils/BleUtils;", "", "()V", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class sw {

    @Nullable
    public static BluetoothManager b;

    @Nullable
    public static BluetoothAdapter c;

    @NotNull
    public static final b a = new b(null);

    @NotNull
    public static final Lazy<Handler> d = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: BleUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<Handler> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* compiled from: BleUtils.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007J\u0014\u0010 \u001a\u0004\u0018\u00010\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\b\u0010!\u001a\u00020\u0014H\u0007J\b\u0010\"\u001a\u00020\u0014H\u0007J\u0010\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010&\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010'\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010(\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010)\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%J\u0012\u0010*\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\b\u0010+\u001a\u00020\u0014H\u0007J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0007J\u000e\u00105\u001a\u0002002\u0006\u00106\u001a\u000207J\u0010\u00105\u001a\u0002002\b\u00108\u001a\u0004\u0018\u00010\u001aJ\u0010\u00109\u001a\u0002002\u0006\u00106\u001a\u000207H\u0002J\u000e\u0010:\u001a\u0002002\u0006\u00101\u001a\u000202R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006;"}, d2 = {"Lcom/component/dxbluetooth/lib/utils/BleUtils$Companion;", "", "()V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "setBluetoothAdapter", "(Landroid/bluetooth/BluetoothAdapter;)V", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getBluetoothManager", "()Landroid/bluetooth/BluetoothManager;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "checkMainThread", "", "closeBluetooth", "getBluetoothState", "", "getBondState", "mac", "", "getBondedBluetoothClassicDeviceList", "", "Landroid/bluetooth/BluetoothDevice;", "getConnectStatus", "getConnectedBluetoothLeDeviceList", "getRemoteDevice", "isBleSupported", "isBluetoothEnabled", "isCharacteristicIndicatable", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "isCharacteristicNoRspWritable", "isCharacteristicNotifyable", "isCharacteristicReadable", "isCharacteristicWritable", "isDeviceConnected", "openBluetooth", "refreshGattCache", "gatt", "Landroid/bluetooth/BluetoothGatt;", "registerReceiver", "", "receiver", "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "sendBroadcast", "intent", "Landroid/content/Intent;", AMPExtension.Action.ATTRIBUTE_NAME, "sendGlobalBroadcast", "unregisterReceiver", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final BluetoothAdapter a() {
            if (sw.c == null) {
                BluetoothManager bluetoothManagerB = b();
                sw.c = bluetoothManagerB == null ? null : bluetoothManagerB.getAdapter();
            }
            return sw.c;
        }

        public final BluetoothManager b() {
            if (sw.b == null) {
                Object systemService = ve0.a().getSystemService("bluetooth");
                sw.b = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
            }
            return sw.b;
        }

        @NotNull
        public final Handler c() {
            return (Handler) sw.d.getValue();
        }

        @JvmStatic
        @Nullable
        public final BluetoothDevice d(@Nullable String str) {
            BluetoothAdapter bluetoothAdapterA;
            if (TextUtils.isEmpty(str) || (bluetoothAdapterA = a()) == null) {
                return null;
            }
            return bluetoothAdapterA.getRemoteDevice(str);
        }

        @JvmStatic
        public final boolean e() {
            return ve0.a().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }

        @JvmStatic
        public final boolean f() {
            BluetoothAdapter bluetoothAdapterA = a();
            if (bluetoothAdapterA == null) {
                return false;
            }
            return bluetoothAdapterA.isEnabled();
        }

        public final boolean g(@Nullable BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 16) == 0) ? false : true;
        }

        public final boolean h(@Nullable BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 8) == 0) ? false : true;
        }

        public final boolean i(@NotNull BluetoothGatt gatt) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
                method.setAccessible(true);
                Object objInvoke = method.invoke(gatt, new Object[0]);
                if (objInvoke != null) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            } catch (Exception unused) {
                return false;
            }
        }

        @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
        public final void j(@NotNull BroadcastReceiver receiver, @NotNull IntentFilter filter) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            Intrinsics.checkNotNullParameter(filter, "filter");
            ve0.a().registerReceiver(receiver, filter);
        }

        public final void k(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            l(intent);
        }

        public final void l(Intent intent) {
            ve0.a().sendBroadcast(intent);
        }
    }
}

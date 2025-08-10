package dc;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import dc.lw;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BluetoothBleSearcher.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0017J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017J\b\u0010\u000e\u001a\u00020\nH\u0017R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/component/dxbluetooth/lib/search/BluetoothBleSearcher;", "Lcom/component/dxbluetooth/lib/search/BaseBluetoothBleSearcher;", "()V", "mLeScanCallback", "Landroid/bluetooth/BluetoothAdapter$LeScanCallback;", "getMLeScanCallback", "()Landroid/bluetooth/BluetoothAdapter$LeScanCallback;", "mLeScanCallback$delegate", "Lkotlin/Lazy;", "cancelScanBluetooth", "", "startScanBluetooth", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/search/BluetoothSearchResponse;", "stopScanBluetooth", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class lw extends jw {

    @NotNull
    public static final lw b = new lw();

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: BluetoothBleSearcher.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/bluetooth/BluetoothAdapter$LeScanCallback;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<BluetoothAdapter.LeScanCallback> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        public static final void b(BluetoothDevice device, int i, byte[] bArr) {
            lw lwVar = lw.b;
            Intrinsics.checkNotNullExpressionValue(device, "device");
            lwVar.b(new BleSearchDeviceBean(device, i, bArr));
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BluetoothAdapter.LeScanCallback invoke() {
            return new BluetoothAdapter.LeScanCallback() { // from class: dc.iw
                @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
                public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                    lw.a.b(bluetoothDevice, i, bArr);
                }
            };
        }
    }

    @Override // dc.jw
    @SuppressLint({"MissingPermission"})
    public void a() {
        try {
            BluetoothAdapter bluetoothAdapterA = sw.a.a();
            if (bluetoothAdapterA != null) {
                bluetoothAdapterA.stopLeScan(h());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.a();
    }

    @Override // dc.jw
    @SuppressLint({"MissingPermission"})
    public void f(@Nullable mw mwVar) {
        super.f(mwVar);
        BluetoothAdapter bluetoothAdapterA = sw.a.a();
        if (bluetoothAdapterA == null) {
            return;
        }
        bluetoothAdapterA.startLeScan(h());
    }

    @Override // dc.jw
    @SuppressLint({"MissingPermission"})
    public void g() {
        try {
            BluetoothAdapter bluetoothAdapterA = sw.a.a();
            if (bluetoothAdapterA != null) {
                bluetoothAdapterA.stopLeScan(h());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.g();
    }

    public final BluetoothAdapter.LeScanCallback h() {
        return (BluetoothAdapter.LeScanCallback) c.getValue();
    }
}

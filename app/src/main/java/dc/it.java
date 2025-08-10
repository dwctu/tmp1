package dc;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IBluetoothGattResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH&J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u001d"}, d2 = {"Lcom/component/dxbluetooth/lib/connect/listener/IBluetoothGattResponse;", "", "onCharacteristicChanged", "", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "value", "", "onCharacteristicRead", "status", "", "onCharacteristicWrite", "onConnectionStateChange", DownloaderClientMarshaller.PARAM_NEW_STATE, "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWrite", "onMtuChanged", "mtu", "onPhyRead", "gatt", "Landroid/bluetooth/BluetoothGatt;", "txPhy", "rxPhy", "onPhyUpdate", "onReadRemoteRssi", "rssi", "onServicesDiscovered", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface it {
    void a(int i);

    void b(@NotNull BluetoothGattDescriptor bluetoothGattDescriptor, int i, @Nullable byte[] bArr);

    void c(@NotNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, @Nullable byte[] bArr);

    void d(int i, int i2);

    void e(int i, int i2);

    void f(@NotNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, @Nullable byte[] bArr);

    void g(@NotNull BluetoothGattDescriptor bluetoothGattDescriptor, int i);

    void i(@NotNull BluetoothGatt bluetoothGatt, int i, int i2, int i3);

    void j(int i, int i2);

    void k(@NotNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @Nullable byte[] bArr);

    void l(@NotNull BluetoothGatt bluetoothGatt, int i, int i2, int i3);
}

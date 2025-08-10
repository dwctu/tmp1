package dc;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BluetoothGattResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/component/dxbluetooth/lib/response/BluetoothGattResponse;", "Landroid/bluetooth/BluetoothGattCallback;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/connect/listener/IBluetoothGattResponse;", "(Lcom/component/dxbluetooth/lib/connect/listener/IBluetoothGattResponse;)V", "onCharacteristicChanged", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicRead", "status", "", "onCharacteristicWrite", "onConnectionStateChange", DownloaderClientMarshaller.PARAM_NEW_STATE, "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWrite", "onMtuChanged", "mtu", "onPhyRead", "txPhy", "rxPhy", "onPhyUpdate", "onReadRemoteRssi", "rssi", "onServicesDiscovered", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class gw extends BluetoothGattCallback {

    @NotNull
    public final it a;

    public gw(@NotNull it response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.a = response;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(@NotNull BluetoothGatt gatt, @NotNull BluetoothGattCharacteristic characteristic) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        this.a.k(characteristic, characteristic.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(@NotNull BluetoothGatt gatt, @NotNull BluetoothGattCharacteristic characteristic, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        this.a.c(characteristic, status, characteristic.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(@NotNull BluetoothGatt gatt, @NotNull BluetoothGattCharacteristic characteristic, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        this.a.f(characteristic, status, characteristic.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(@NotNull BluetoothGatt gatt, int status, int newState) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        this.a.j(status, newState);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(@NotNull BluetoothGatt gatt, @NotNull BluetoothGattDescriptor descriptor, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.a.b(descriptor, status, descriptor.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(@NotNull BluetoothGatt gatt, @NotNull BluetoothGattDescriptor descriptor, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.a.g(descriptor, status);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onMtuChanged(@NotNull BluetoothGatt gatt, int mtu, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        this.a.e(mtu, status);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onPhyRead(@NotNull BluetoothGatt gatt, int txPhy, int rxPhy, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        this.a.l(gatt, txPhy, rxPhy, status);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onPhyUpdate(@NotNull BluetoothGatt gatt, int txPhy, int rxPhy, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        this.a.i(gatt, txPhy, rxPhy, status);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(@NotNull BluetoothGatt gatt, int rssi, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        this.a.d(rssi, status);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(@NotNull BluetoothGatt gatt, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        this.a.a(status);
    }
}

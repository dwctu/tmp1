package dc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.BleDeviceBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleDataDeviceBeanExt.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a(\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e¨\u0006\u0012"}, d2 = {"addDeviceBean", "", "Lcom/component/dxbluetooth/lib/data/BleData;", "mac", "", "serviceList", "", "Landroid/bluetooth/BluetoothGattService;", "getCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "getDeviceBean", "Lcom/component/dxbluetooth/lib/bean/BleDeviceBean;", "removeDeviceBean", "setDeviceBean", "deviceBean", "hytto-apps.android.components.core:dxbluetooth"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class nt {
    public static final synchronized void a(@NotNull kt ktVar, @NotNull String mac, @NotNull List<? extends BluetoothGattService> serviceList) {
        Intrinsics.checkNotNullParameter(ktVar, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(serviceList, "serviceList");
        BleDeviceBean bleDeviceBeanC = c(ktVar, mac);
        if (bleDeviceBeanC != null) {
            bleDeviceBeanC.setServiceList(serviceList);
        } else {
            ktVar.a().put(mac, new BleDeviceBean(mac, serviceList));
        }
    }

    @Nullable
    public static final synchronized BluetoothGattCharacteristic b(@NotNull kt ktVar, @NotNull String mac, @Nullable UUID uuid, @Nullable UUID uuid2) {
        Intrinsics.checkNotNullParameter(ktVar, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        BleDeviceBean bleDeviceBeanC = c(kt.a, mac);
        if (bleDeviceBeanC == null) {
            return null;
        }
        return bleDeviceBeanC.getCharacteristic(uuid, uuid2);
    }

    @Nullable
    public static final synchronized BleDeviceBean c(@NotNull kt ktVar, @NotNull String mac) {
        Intrinsics.checkNotNullParameter(ktVar, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return ktVar.a().get(mac);
    }
}

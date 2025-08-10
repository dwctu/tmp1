package dc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.BleDeviceBean;
import com.component.dxtoy.core.bluetooth.bean.ToyBtDeviceBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyBleCharacter.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016J+\u0010\u0017\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ=\u0010\u001c\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010 JD\u0010!\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'J0\u0010!\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'J0\u0010!\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010#\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'JD\u0010(\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'J0\u0010(\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'J0\u0010(\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010#\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'¨\u0006)"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/ble/ToyBleCharacter;", "", "()V", "characteristicHandler", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "data", "Lcom/component/dxbluetooth/lib/bean/BleDeviceBean;", "getBtDeviceBean", "Lcom/component/dxtoy/core/bluetooth/bean/ToyBtDeviceBean;", "mac", "", "openNotify", FirebaseAnalytics.Param.CHARACTER, "Landroid/bluetooth/BluetoothGattCharacteristic;", NotificationCompat.CATEGORY_SERVICE, "Landroid/bluetooth/BluetoothGattService;", "readPhy", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleReadResponse;", "readRssi", "Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "requestMtu", "mtu", "", "Lcom/component/dxbluetooth/lib/response/BleMtuResponse;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleMtuResponse;)V", "setPhy", "txPhy", "rxPhy", "options", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleReadResponse;)V", "write", "Ljava/util/UUID;", "value", "", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "isWaitCallback", "", "writeNoRsp", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ca0 {

    @NotNull
    public static final ca0 a = new ca0();

    public static /* synthetic */ void j(ca0 ca0Var, String str, String str2, fw fwVar, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            fwVar = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        ca0Var.h(str, str2, fwVar, z);
    }

    public static /* synthetic */ void k(ca0 ca0Var, String str, UUID uuid, UUID uuid2, byte[] bArr, fw fwVar, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            fwVar = null;
        }
        ca0Var.i(str, uuid, uuid2, bArr, fwVar, (i & 32) != 0 ? true : z);
    }

    public final void a(@NotNull mt code, @NotNull BleDeviceBean data) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(data, "data");
        for (BluetoothGattService bluetoothGattService : data.getServiceList()) {
            List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
            Intrinsics.checkNotNullExpressionValue(characteristics, "service.characteristics");
            for (BluetoothGattCharacteristic character : characteristics) {
                if (sw.a.h(character)) {
                    ConcurrentHashMap<String, ToyBtDeviceBean> concurrentHashMapC = hb0.a.c();
                    String mac = data.getMac();
                    String mac2 = data.getMac();
                    List<BluetoothGattService> serviceList = data.getServiceList();
                    Intrinsics.checkNotNullExpressionValue(character, "character");
                    UUID uuid = bluetoothGattService.getUuid();
                    Intrinsics.checkNotNullExpressionValue(uuid, "service.uuid");
                    UUID uuid2 = character.getUuid();
                    Intrinsics.checkNotNullExpressionValue(uuid2, "character.uuid");
                    concurrentHashMapC.put(mac, new ToyBtDeviceBean(mac2, serviceList, character, uuid, uuid2));
                }
            }
        }
        if (hb0.a.c().get(data.getMac()) != null) {
            for (BluetoothGattService bluetoothGattService2 : data.getServiceList()) {
                List<BluetoothGattCharacteristic> characteristics2 = bluetoothGattService2.getCharacteristics();
                Intrinsics.checkNotNullExpressionValue(characteristics2, "service.characteristics");
                for (BluetoothGattCharacteristic character2 : characteristics2) {
                    ca0 ca0Var = a;
                    Intrinsics.checkNotNullExpressionValue(character2, "character");
                    ca0Var.c(character2, data, bluetoothGattService2);
                }
            }
        }
    }

    public final ToyBtDeviceBean b(String str) {
        return hb0.a.c().get(str);
    }

    public final void c(BluetoothGattCharacteristic bluetoothGattCharacteristic, BleDeviceBean bleDeviceBean, BluetoothGattService bluetoothGattService) {
        if (sw.a.g(bluetoothGattCharacteristic)) {
            ba0.a.e(bleDeviceBean.getMac(), bluetoothGattService.getUuid(), bluetoothGattCharacteristic.getUuid(), da0.a.c(bleDeviceBean.getMac()));
        }
    }

    public final void d(@Nullable String str, @Nullable cw cwVar) {
        if (str == null || str.length() == 0) {
            if (cwVar != null) {
                cwVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
            }
        } else if (b(str) != null) {
            ba0.a.f(str, cwVar);
        }
    }

    public final void e(@Nullable String str, @Nullable dw dwVar) {
        if (!(str == null || str.length() == 0)) {
            ba0.a.g(str, dwVar);
        } else if (dwVar != null) {
            dwVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
        }
    }

    public final void f(@Nullable String str, @Nullable Integer num, @Nullable aw awVar) {
        if (!(str == null || str.length() == 0) && num != null) {
            ba0.a.l(str, num, awVar);
        } else if (awVar != null) {
            awVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
        }
    }

    public final void g(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable cw cwVar) {
        if (str == null || str.length() == 0) {
            if (cwVar != null) {
                cwVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
            }
        } else if (b(str) != null) {
            ba0.a.n(str, num, num2, num3, cwVar);
        }
    }

    public final void h(@Nullable String str, @Nullable String str2, @Nullable fw fwVar, boolean z) {
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                ToyBtDeviceBean toyBtDeviceBeanB = b(str);
                if (toyBtDeviceBeanB != null) {
                    ba0 ba0Var = ba0.a;
                    UUID serviceUUID = toyBtDeviceBeanB.getServiceUUID();
                    UUID characterUUID = toyBtDeviceBeanB.getCharacterUUID();
                    byte[] bytes = str2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    ba0Var.p(str, serviceUUID, characterUUID, bytes, fwVar, z);
                    return;
                }
                return;
            }
        }
        if (fwVar != null) {
            fwVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
        }
    }

    public final void i(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        boolean z2 = false;
        if (!(str == null || str.length() == 0)) {
            if (bArr != null) {
                if (!(!(bArr.length == 0))) {
                    z2 = true;
                }
            }
            if (!z2 && uuid != null && uuid2 != null) {
                ba0.a.p(str, uuid, uuid2, bArr, fwVar, z);
                return;
            }
        }
        if (fwVar != null) {
            fwVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
        }
    }

    public final void l(@Nullable String str, @Nullable String str2, @Nullable fw fwVar, boolean z) {
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                ToyBtDeviceBean toyBtDeviceBeanB = b(str);
                if (toyBtDeviceBeanB != null) {
                    ca0 ca0Var = a;
                    UUID serviceUUID = toyBtDeviceBeanB.getServiceUUID();
                    UUID characterUUID = toyBtDeviceBeanB.getCharacterUUID();
                    byte[] bytes = str2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    ca0Var.m(str, serviceUUID, characterUUID, bytes, fwVar, z);
                    return;
                }
                return;
            }
        }
        if (fwVar != null) {
            fwVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
        }
    }

    public final void m(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        boolean z2 = false;
        if (!(str == null || str.length() == 0)) {
            if (bArr != null) {
                if (!(!(bArr.length == 0))) {
                    z2 = true;
                }
            }
            if (!z2 && uuid != null && uuid2 != null) {
                ba0.a.q(str, uuid, uuid2, bArr, fwVar, z);
                return;
            }
        }
        if (fwVar != null) {
            fwVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
        }
    }

    public final void n(@Nullable String str, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        if (!(str == null || str.length() == 0) && bArr != null) {
            if (!(bArr.length == 0)) {
                ToyBtDeviceBean toyBtDeviceBeanB = b(str);
                if (toyBtDeviceBeanB != null) {
                    a.m(str, toyBtDeviceBeanB.getServiceUUID(), toyBtDeviceBeanB.getCharacterUUID(), bArr, fwVar, z);
                    return;
                }
                return;
            }
        }
        if (fwVar != null) {
            fwVar.b(mt.ILLEGAL_ARGUMENT, "参数错误");
        }
    }
}

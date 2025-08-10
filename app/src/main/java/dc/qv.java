package dc;

import android.bluetooth.BluetoothGattCharacteristic;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleReadRequest.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleReadRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/ReadCharacterListener;", "mServiceUUID", "Ljava/util/UUID;", "mCharacterUUID", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Ljava/util/UUID;Ljava/util/UUID;Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "doing", "", "onCharacteristicRead", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "status", "", "value", "", "startRead", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class qv extends jv implements yt {

    @Nullable
    public final UUID i;

    @Nullable
    public final UUID j;

    public qv(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        super(zvVar);
        this.i = uuid;
        this.j = uuid2;
    }

    public final void a0() {
        if (K(this.i, this.j)) {
            V();
        } else {
            z(mt.REQUEST_FAILED);
        }
    }

    @Override // dc.yt
    public void c(@NotNull BluetoothGattCharacteristic characteristic, int i, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        W();
        if (i != 0) {
            z(mt.REQUEST_FAILED);
        } else {
            H("extra_response", bArr);
            z(mt.REQUEST_SUCCESS);
        }
    }

    @Override // dc.jv
    public void o() {
        a0();
    }
}

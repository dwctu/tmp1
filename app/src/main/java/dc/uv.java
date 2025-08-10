package dc;

import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleUnnotifyRequest.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleUnnotifyRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/WriteDescriptorListener;", "mServiceUUID", "Ljava/util/UUID;", "mCharacterUUID", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Ljava/util/UUID;Ljava/util/UUID;Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "closeNotify", "", "doing", "onDescriptorWrite", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "status", "", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class uv extends jv implements gu {

    @Nullable
    public final UUID i;

    @Nullable
    public final UUID j;

    public uv(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        super(zvVar);
        this.i = uuid;
        this.j = uuid2;
    }

    public final void a0() {
        if (S(this.i, this.j, false)) {
            V();
        } else {
            z(mt.REQUEST_FAILED);
        }
    }

    @Override // dc.gu
    public void g(@NotNull BluetoothGattDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        W();
        if (i == 0) {
            z(mt.REQUEST_SUCCESS);
        } else {
            z(mt.REQUEST_FAILED);
        }
    }

    @Override // dc.jv
    public void o() {
        a0();
    }
}

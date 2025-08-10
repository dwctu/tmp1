package dc;

import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleReadDescriptorRequest.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleReadDescriptorRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/ReadDescriptorListener;", "mServiceUUID", "Ljava/util/UUID;", "mCharacterUUID", "mDescriptorUUID", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "doing", "", "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "status", "", "value", "", "startRead", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ov extends jv implements zt {

    @Nullable
    public final UUID i;

    @Nullable
    public final UUID j;

    @Nullable
    public final UUID k;

    public ov(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable zv zvVar) {
        super(zvVar);
        this.i = uuid;
        this.j = uuid2;
        this.k = uuid3;
    }

    public final void a0() {
        if (L(this.i, this.j, this.k)) {
            V();
        } else {
            z(mt.REQUEST_FAILED);
        }
    }

    @Override // dc.zt
    public void b(@NotNull BluetoothGattDescriptor descriptor, int i, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
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

package dc;

import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleWriteDescriptorRequest.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleWriteDescriptorRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/WriteDescriptorListener;", "mServiceUUID", "Ljava/util/UUID;", "mCharacterUUID", "mDescriptorUUID", "mBytes", "", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;[BLcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "doing", "", "onDescriptorWrite", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "status", "", "startWrite", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class vv extends jv implements gu {

    @Nullable
    public final UUID i;

    @Nullable
    public final UUID j;

    @Nullable
    public final UUID k;

    @Nullable
    public final byte[] l;

    public vv(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable byte[] bArr, @Nullable zv zvVar) {
        super(zvVar);
        this.i = uuid;
        this.j = uuid2;
        this.k = uuid3;
        this.l = bArr;
    }

    public final void a0() {
        if (Z(this.i, this.j, this.k, this.l)) {
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

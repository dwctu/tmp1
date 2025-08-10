package dc;

import android.bluetooth.BluetoothGattCharacteristic;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleWriteRequest.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleWriteRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/WriteCharacterListener;", "mServiceUUID", "Ljava/util/UUID;", "mCharacterUUID", "mBytes", "", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "isWaitCallback", "", "(Ljava/util/UUID;Ljava/util/UUID;[BLcom/component/dxbluetooth/lib/response/BleGeneralResponse;Z)V", "getMBytes", "()[B", "doing", "", "isOnCharacteristicWrite", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "status", "", "value", "onCharacteristicWrite", "startWrite", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class xv extends jv implements fu {

    @Nullable
    public final UUID i;

    @Nullable
    public final UUID j;

    @Nullable
    public final byte[] k;
    public final boolean l;

    public xv(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable zv zvVar, boolean z) {
        super(zvVar);
        this.i = uuid;
        this.j = uuid2;
        this.k = bArr;
        this.l = z;
    }

    @Nullable
    /* renamed from: a0, reason: from getter */
    public final byte[] getK() {
        return this.k;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b0(android.bluetooth.BluetoothGattCharacteristic r4, int r5, byte[] r6) {
        /*
            r3 = this;
            java.util.UUID r0 = r3.i
            android.bluetooth.BluetoothGattService r1 = r4.getService()
            java.util.UUID r1 = r1.getUuid()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L34
            java.util.UUID r0 = r3.j
            java.util.UUID r4 = r4.getUuid()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r4 == 0) goto L34
            if (r5 != 0) goto L35
            byte[] r4 = r3.k
            if (r4 != 0) goto L26
        L24:
            r4 = 0
            goto L31
        L26:
            if (r6 != 0) goto L2a
            byte[] r6 = new byte[r2]
        L2a:
            boolean r4 = java.util.Arrays.equals(r4, r6)
            if (r4 != r1) goto L24
            r4 = 1
        L31:
            if (r4 == 0) goto L34
            goto L35
        L34:
            r1 = 0
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.xv.b0(android.bluetooth.BluetoothGattCharacteristic, int, byte[]):boolean");
    }

    public final void c0() {
        if (!X(this.i, this.j, this.k)) {
            z(mt.REQUEST_FAILED);
        } else if (this.l) {
            V();
        } else {
            A(mt.REQUEST_SUCCESS, 80L);
        }
    }

    @Override // dc.fu
    public void f(@NotNull BluetoothGattCharacteristic characteristic, int i, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        if (b0(characteristic, i, bArr)) {
            W();
            if (i == 0) {
                z(mt.REQUEST_SUCCESS);
            } else {
                z(mt.REQUEST_FAILED);
            }
        }
    }

    @Override // dc.jv
    public void o() {
        c0();
    }
}

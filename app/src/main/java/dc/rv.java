package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleReadRssiRequest.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleReadRssiRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/ReadRssiListener;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "doing", "", "onReadRemoteRssi", "rssi", "", "status", "startReadRssi", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class rv extends jv implements au {
    public rv(@Nullable zv zvVar) {
        super(zvVar);
    }

    public final void a0() {
        if (!N()) {
            z(mt.REQUEST_FAILED);
        } else {
            V();
            A(mt.REQUEST_TIMEOUT, 1500L);
        }
    }

    @Override // dc.au
    public void d(int i, int i2) {
        W();
        if (i2 != 0) {
            z(mt.REQUEST_FAILED);
        } else {
            I("extra_response", i);
            z(mt.REQUEST_SUCCESS);
        }
    }

    @Override // dc.jv
    public void o() {
        a0();
    }
}

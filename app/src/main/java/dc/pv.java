package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleReadPhyRequest.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleReadPhyRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/RequestReadPhyListener;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "doReadPhy", "", "doing", "onPhyRead", "txPhy", "", "rxPhy", "status", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class pv extends jv implements cu {
    public pv(@Nullable zv zvVar) {
        super(zvVar);
    }

    public final void a0() {
        if (M()) {
            A(mt.REQUEST_SUCCESS, 600L);
            return;
        }
        z(mt.REQUEST_FAILED);
        vt h = ot.a(kt.a, t()).getH();
        if (h == null) {
            return;
        }
        h.a(-996, 0, 0);
    }

    @Override // dc.cu
    public void j(int i, int i2, int i3) {
        W();
        if (i3 == 0) {
            z(mt.REQUEST_SUCCESS);
        } else {
            z(mt.REQUEST_FAILED);
        }
        vt h = ot.a(kt.a, t()).getH();
        if (h == null) {
            return;
        }
        h.b(i3, i, i2);
    }

    @Override // dc.jv
    public void o() {
        a0();
    }
}

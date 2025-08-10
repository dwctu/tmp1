package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleSetPhyRequest.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleSetPhyRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/RequestSetPhyListener;", "txPhy", "", "rxPhy", "phyOptions", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(IIILcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "doSetPhy", "", "doing", "onPhyUpdate", "status", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class tv extends jv implements du {
    public final int i;
    public final int j;
    public final int k;

    public tv(int i, int i2, int i3, @Nullable zv zvVar) {
        super(zvVar);
        this.i = i;
        this.j = i2;
        this.k = i3;
    }

    public final void a0() {
        if (U(this.i, this.j, this.k)) {
            A(mt.REQUEST_SUCCESS, 600L);
            return;
        }
        z(mt.REQUEST_FAILED);
        vt h = ot.a(kt.a, t()).getH();
        if (h == null) {
            return;
        }
        h.a(-997, 0, 0);
    }

    @Override // dc.du
    public void h(int i, int i2, int i3) {
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
        h.a(i3, i, i2);
    }

    @Override // dc.jv
    public void o() {
        a0();
    }
}

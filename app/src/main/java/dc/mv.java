package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleMtuRequest.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleMtuRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/RequestMtuListener;", "mMtu", "", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(ILcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "doing", "", "onMtuChanged", "mtu", "status", "requestMtu", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class mv extends jv implements bu {
    public final int i;

    public mv(int i, @Nullable zv zvVar) {
        super(zvVar);
        this.i = i;
    }

    public final void a0() {
        if (Q(this.i)) {
            V();
        } else {
            z(mt.REQUEST_FAILED);
        }
    }

    @Override // dc.bu
    public void e(int i, int i2) {
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

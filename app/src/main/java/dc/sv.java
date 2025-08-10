package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleRefreshCacheRequest.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BleRefreshCacheRequest;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "doing", "", "processRequest", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class sv extends jv {
    public sv(@Nullable zv zvVar) {
        super(zvVar);
    }

    public static final void a0(sv this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z(mt.REQUEST_SUCCESS);
    }

    @Override // dc.jv
    public void G() {
        o();
    }

    @Override // dc.jv
    public void o() {
        O();
        se0.g(new Runnable() { // from class: dc.iv
            @Override // java.lang.Runnable
            public final void run() {
                sv.a0(this.a);
            }
        }, 3000L);
    }
}

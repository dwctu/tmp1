package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdBridgeReceive.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeReceive;", "", "()V", "onEvent", "", "event", "Lcom/component/dxtoy/core/api/event/ToyOnReceiveCommandEvent;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class lq1 {
    public lq1() {
        wb0.a.b(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull j90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        kq1.f.a("Receive mac = " + event.getA() + " cmd = " + event.getB());
        jc1.b(event.getA(), event.getB(), event.getC());
    }
}

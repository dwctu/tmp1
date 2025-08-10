package dc;

import dc.oa0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdBtSwitch.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/btswitch/ToyCmdBtSwitch;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class c00 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdBtSwitch.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/business/btswitch/ToyCmdBtSwitch$Companion;", "Lcom/component/dxtoy/command/base/BaseToyCmd;", "()V", "getAutoSwitch", "", "mac", "", "setAutoSwitch", "turnOn1", "", "turnOn2", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends m40 {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void d(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            d00.b.d(mac);
        }

        public final void e(@NotNull String mac, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            c50 c50Var = new c50(mac, z, z2);
            c50Var.addSendType(new oa0.e(false, null, 2, null));
            c50Var.e();
        }
    }
}

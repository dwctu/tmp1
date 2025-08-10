package dc;

import dc.oa0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdWaggleOld.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/waggle/old/ToyCmdWaggleOld;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class z30 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdWaggleOld.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/business/waggle/old/ToyCmdWaggleOld$Companion;", "", "()V", "setGsensor", "", "mac", "", "startMoveOld", "stopMoveOld", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            s70 s70Var = new s70(mac);
            s70Var.addSendType(new oa0.c(0, 1, null));
            s70Var.e();
        }

        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            m80 m80Var = new m80(mac);
            m80Var.addSendType(new oa0.c(0, 1, null));
            m80Var.e();
        }

        public final void c(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            n80 n80Var = new n80(mac);
            n80Var.addSendType(new oa0.c(0, 1, null));
            n80Var.e();
        }
    }
}

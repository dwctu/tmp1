package dc;

import dc.oa0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdBMS.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/waggle/bms/ToyCmdBMS;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class q30 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdBMS.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/component/dxtoy/business/waggle/bms/ToyCmdBMS$Companion;", "", "()V", "getBms", "", "mac", "", "getSnrState", "setBms", "value", "", "setBt", "turnOn", "", "setMirr", "startBm", "stopEm", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            r30.b.d(mac);
        }

        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            s30.b.d(mac);
        }

        public final void c(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new m70(mac, i).e();
        }

        public final void d(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new n70(mac, z).e();
        }

        public final void e(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new y70(mac, z).e();
        }

        public final void f(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            e50 e50Var = new e50(mac);
            e50Var.addSendType(new oa0.c(0, 1, null));
            e50Var.e();
        }

        public final void g(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            k50 k50Var = new k50(mac);
            k50Var.addSendType(new oa0.c(0, 1, null));
            k50Var.e();
        }
    }
}

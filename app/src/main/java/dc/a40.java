package dc;

import dc.oa0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdXMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/waggle/xmachine/ToyCmdXMachine;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class a40 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdXMachine.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f¨\u0006\u0013"}, d2 = {"Lcom/component/dxtoy/business/waggle/xmachine/ToyCmdXMachine$Companion;", "", "()V", "enterSingleCtrl", "", "mac", "", "getDly", "getMode", "getRotateBtnState", "getThreshold", "value", "", "setDly", "turnOn", "", "setThreshold", "value1", "value2", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            a90 a90Var = new a90(mac);
            a90Var.addSendType(new oa0.c(0, 1, null));
            a90Var.e();
        }

        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            g40.b.d(mac);
        }

        public final void c(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            h40.b.d(mac);
        }

        public final void d(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            i40.b.d(mac);
        }

        public final void e(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            f40.b.d(mac, i);
        }

        public final void f(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new r70(mac, z).e();
        }

        public final void g(@NotNull String mac, int i, int i2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            j40.b.d(mac, i, i2);
        }
    }
}

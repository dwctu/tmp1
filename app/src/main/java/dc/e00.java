package dc;

import com.component.dxtoy.core.commandcore.bean.BaseToyCommandBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdClock.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/clock/ToyCmdClock;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class e00 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdClock.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J.\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n¨\u0006\u0014"}, d2 = {"Lcom/component/dxtoy/business/clock/ToyCmdClock$Companion;", "", "()V", "getAI", "", "mac", "", "getAllClock", "getClock", "value", "", "getExecutingClock", "removeAllClock", "removeClock", "setAIW", "setClock", "value1", "value2", "value3", "value4", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            f00.b.d(mac);
        }

        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            g00.b.d(mac);
        }

        public final void c(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            h00.b.d(mac, i);
        }

        public final void d(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            i00.b.d(mac);
        }

        public final void e(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            j00.b.d(mac);
        }

        public final void f(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            k00.b.d(mac, i);
        }

        public final void g(@NotNull String mac, @NotNull String value) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            r40 r40Var = new r40(mac, value);
            r40Var.addSendType(BaseToyCommandBean.INSTANCE.getDefaultResend());
            r40Var.e();
        }

        public final void h(@NotNull String mac, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            o70 o70Var = new o70(mac, i, i2, i3, i4);
            o70Var.addSendType(BaseToyCommandBean.INSTANCE.getDefaultResend());
            o70Var.e();
        }
    }
}

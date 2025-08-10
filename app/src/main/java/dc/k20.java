package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdProgramPatten.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/program/ToyCmdProgramPatten;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class k20 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdProgramPatten.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ.\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006¨\u0006\u0016"}, d2 = {"Lcom/component/dxtoy/business/program/ToyCmdProgramPatten$Companion;", "", "()V", "getAllPattenName", "", "mac", "", "getAllSpace", "getFreeSpace", "getPatten", "value", "", "preset", "removeAllPatten", "removeAllPattenToDefault", "removePatten", "setLongPatten", "value1", "value2", "value3", "value4", "setShortPatten", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            m20.b.d(mac);
        }

        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            n20.b.d(mac);
        }

        public final void c(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            o20.b.d(mac);
        }

        public final void d(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            p20.b.d(mac, i);
        }

        public final void e(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new x60(mac, i).e();
        }

        public final void f(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new u60(mac).e();
        }

        public final void g(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            r20.b.d(mac);
        }

        public final void h(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            q20.b.d(mac, i);
        }

        public final void i(@NotNull String mac, int i, int i2, int i3, @NotNull String value4) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value4, "value4");
            new v60(mac, i, i2, i3, value4).e();
        }

        public final void j(@NotNull String mac, int i, @NotNull String value2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value2, "value2");
            new y60(mac, i, value2).e();
        }
    }
}

package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdLevel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/level/ToyCmdLevel;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class w00 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdLevel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b¨\u0006\u0010"}, d2 = {"Lcom/component/dxtoy/business/level/ToyCmdLevel$Companion;", "", "()V", "exeM2", "", "mac", "", "value", "", "getLevel", "getM2", FirebaseAnalytics.Param.LEVEL, "setLevel", "value1", "value2", "setM2", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new l50(mac, i).e();
        }

        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            x00.b.d(mac);
        }

        public final void c(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            y00.b.d(mac);
        }

        public final void d(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new q60(mac, i).e();
        }

        public final void e(@NotNull String mac, int i, int i2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new v70(mac, i, i2).e();
        }

        public final void f(@NotNull String mac, int i, int i2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            new x70(mac, i, i2).e();
        }
    }
}

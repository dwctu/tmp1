package dc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import dc.oa0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdLong.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/longc/ToyCmdLong;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class f10 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdLong.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006¨\u0006\u000e"}, d2 = {"Lcom/component/dxtoy/business/longc/ToyCmdLong$Companion;", "", "()V", "sendAA", "", "mac", "", "type", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "sendAP", "value", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac, byte b, @NotNull List<byte[]> params) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(params, "params");
            m10.b.f(mac, b, params);
        }

        public final void b(@NotNull String mac, @NotNull String value) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            s40 s40Var = new s40(mac, value);
            s40Var.addSendType(new oa0.c(0, 1, null));
            s40Var.e();
        }
    }
}

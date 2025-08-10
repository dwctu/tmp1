package dc;

import com.sun.jna.Callback;
import dc.ec0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyTurnoverApi.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/turnover/ToyTurnoverApi;", "", "()V", "Companion", "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ac0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyTurnoverApi.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/component/dxtoy/turnover/ToyTurnoverApi$Companion;", "", "()V", "init", "", "networkEngine", "Lcom/component/dxtoy/turnover/listener/INetworkEngine;", "appDataEngine", "Lcom/component/dxtoy/turnover/listener/IAppDataEngine;", "reportToyInfo", "macId", "", "status", "Lcom/component/dxtoy/turnover/data/ToyTurnoverEum$ConnectState;", Callback.METHOD_NAME, "Lcom/component/dxtoy/turnover/listener/INetworkEngine$ICallback;", "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull ec0 networkEngine, @NotNull dc0 appDataEngine) {
            Intrinsics.checkNotNullParameter(networkEngine, "networkEngine");
            Intrinsics.checkNotNullParameter(appDataEngine, "appDataEngine");
            bc0.a.d(networkEngine, appDataEngine);
        }

        @JvmStatic
        public final void b(@NotNull String macId, @NotNull cc0 status, @Nullable ec0.a aVar) {
            Intrinsics.checkNotNullParameter(macId, "macId");
            Intrinsics.checkNotNullParameter(status, "status");
            bc0.a.e(macId, status, aVar);
        }
    }
}

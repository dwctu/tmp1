package dc;

import com.component.dxtoy.turnover.bean.ToyTurnoverInfoBean;
import com.sun.jna.Callback;
import dc.ec0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyTurnoverModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/turnover/model/ToyTurnoverModel;", "", "()V", "Companion", "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class fc0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyTurnoverModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/turnover/model/ToyTurnoverModel$Companion;", "", "()V", "getReportToyInfoUrl", "", "networkReportToyInfo", "", "macId", "status", "Lcom/component/dxtoy/turnover/data/ToyTurnoverEum$ConnectState;", Callback.METHOD_NAME, "Lcom/component/dxtoy/turnover/listener/INetworkEngine$ICallback;", "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* compiled from: ToyTurnoverModel.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: dc.fc0$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0178a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[dy.values().length];
                iArr[dy.REMOTE.ordinal()] = 1;
                a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            dc0 dc0VarB = bc0.a.b();
            dy dyVarB = dc0VarB == null ? null : dc0VarB.b();
            if ((dyVarB == null ? -1 : C0178a.a[dyVarB.ordinal()]) == 1) {
                return "/api/toyCircle/reportToyInfo";
            }
            return null;
        }

        public final void b(@NotNull String macId, @NotNull cc0 status, @Nullable ec0.a aVar) {
            Intrinsics.checkNotNullParameter(macId, "macId");
            Intrinsics.checkNotNullParameter(status, "status");
            String data = qx.b(xd0.j(ToyTurnoverInfoBean.INSTANCE.build(macId, status)));
            String strA = a();
            ec0 ec0VarC = bc0.a.c();
            if (ec0VarC == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(data, "data");
            ec0VarC.a(data, strA, aVar);
        }
    }
}

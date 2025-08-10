package dc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* compiled from: SocketIO.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0005"}, d2 = {"startActionWithRetry", "", "Lcom/wear/main/socketio/SocketIoClient;", AMPExtension.Action.ATTRIBUTE_NAME, "Lkotlin/Function0;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ru1 {

    /* compiled from: SocketIO.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ext/SocketIOKt$startActionWithRetry$socketConnectListener$1", "Lcom/wear/main/socketio/SocketConnectListener;", "connectSuc", "", "disConnect", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements tf2 {
        public final /* synthetic */ uf2 a;
        public final /* synthetic */ Function0<Unit> b;

        public a(uf2 uf2Var, Function0<Unit> function0) {
            this.a = uf2Var;
            this.b = function0;
        }

        @Override // dc.tf2
        public void connectSuc() {
            this.a.C(this);
            this.b.invoke();
        }

        @Override // dc.tf2
        public void disConnect() {
            this.a.C(this);
        }
    }

    public static final void a(@NotNull uf2 uf2Var, @NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(uf2Var, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        if (uf2Var.q()) {
            action.invoke();
        } else {
            uf2Var.o(new a(uf2Var, action));
            uf2Var.B();
        }
    }
}

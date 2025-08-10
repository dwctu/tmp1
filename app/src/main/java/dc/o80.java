package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Single.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/component/dxtoy/command/code/CmdSuck;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "", "(Ljava/lang/String;I)V", "verifyValues", "", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class o80 extends b90 {

    @NotNull
    public static final a f = new a(null);

    /* compiled from: ToyCommandCode+Single.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/command/code/CmdSuck$Companion;", "", "()V", "initToyCommandConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "mac", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final la0 a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            nb0 nb0Var = hb0.a.e().get(mac);
            return (nb0Var == null || !ub0.l(nb0Var)) ? ma0.a.B() : ma0.a.F();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o80(@NotNull String mac, int i) {
        super(f.a(mac), mac, i);
        Intrinsics.checkNotNullParameter(mac, "mac");
    }

    @Override // dc.b90
    public boolean g() {
        if (Intrinsics.areEqual(getF(), ma0.a.B())) {
            nb0 nb0VarC = c();
            if (!(nb0VarC != null ? tb0.x(nb0VarC) : false)) {
                onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
                return false;
            }
        }
        return super.g();
    }
}

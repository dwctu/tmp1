package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/command/code/CmdSetPinS;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "turnOn", "", "(Ljava/lang/String;Z)V", "value", "", "verifyValues", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class c80 extends b90 {

    @NotNull
    public static final a g = new a(null);
    public final int f;

    /* compiled from: ToyCommandCode+Function.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/command/code/CmdSetPinS$Companion;", "", "()V", "initToyCommandConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "mac", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final la0 b(String str) {
            pa0 pa0Var = pa0.a;
            la0 la0VarQ0 = pa0Var.q0();
            nb0 nb0Var = hb0.a.e().get(str);
            boolean z = false;
            if (!(nb0Var != null ? ub0.h(nb0Var) : false)) {
                return la0VarQ0;
            }
            if (nb0Var != null && nb0Var.getVersion() == 206) {
                z = true;
            }
            return z ? pa0Var.r0() : la0VarQ0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c80(@NotNull String mac, boolean z) {
        super(g.b(mac), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.f = z ? 1 : 0;
    }

    @Override // dc.b90
    public boolean g() {
        nb0 nb0VarC = c();
        if (nb0VarC != null ? tb0.s(nb0VarC) : false) {
            setValues(String.valueOf(this.f));
            return true;
        }
        onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
        return false;
    }
}

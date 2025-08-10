package dc;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Single.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/command/code/CmdAirIn;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "", "(Ljava/lang/String;I)V", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class w40 extends b90 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w40(@NotNull String mac, int i) {
        super(ma0.a.e(), mac, i);
        Intrinsics.checkNotNullParameter(mac, "mac");
        f(CollectionsKt__CollectionsJVMKt.listOf(new IntRange(1, 3)));
    }

    @Override // dc.b90
    public boolean g() {
        nb0 nb0VarC = c();
        if (nb0VarC != null ? tb0.v(nb0VarC) : false) {
            return super.g();
        }
        onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
        return false;
    }
}

package dc;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Single.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/component/dxtoy/command/code/CmdAirNLoop;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value1", "", "value2", "(Ljava/lang/String;II)V", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class z40 extends b90 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z40(@NotNull String mac, int i, int i2) {
        super(ma0.a.h(), mac, i, i2);
        Intrinsics.checkNotNullParameter(mac, "mac");
        f(CollectionsKt__CollectionsKt.listOf((Object[]) new IntRange[]{new IntRange(10, 7510), new IntRange(10, 7510)}));
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

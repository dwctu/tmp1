package dc;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Multiply.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00020\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/command/code/CmdMply;", "Lcom/component/dxtoy/command/code/CmdMultiply;", "mac", "", "values", "", "", "(Ljava/lang/String;[I)V", "verifyValues", "", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class r60 extends s60 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r60(@NotNull String mac, @NotNull int... values) {
        super(ma0.a.s(), mac, Arrays.copyOf(values, values.length));
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(values, "values");
    }

    @Override // dc.s60, dc.b90
    public boolean g() {
        nb0 nb0VarC = c();
        if (!((nb0VarC == null || tb0.p(nb0VarC)) ? false : true)) {
            return h();
        }
        onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
        return false;
    }
}

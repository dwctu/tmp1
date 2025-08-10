package dc;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Single.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/command/code/CmdDepth;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "", "(Ljava/lang/String;I)V", "isChangeValue", "", "changeValue", "", "verifyValues", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class h50 extends b90 {
    public boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h50(@NotNull String mac, int i) {
        super(ma0.a.j(), mac, i);
        Intrinsics.checkNotNullParameter(mac, "mac");
        f(CollectionsKt__CollectionsJVMKt.listOf(new IntRange(0, 3)));
    }

    @Override // dc.b90
    public boolean g() {
        nb0 nb0VarC = c();
        if (nb0VarC != null ? tb0.h(nb0VarC) : false) {
            h();
            return super.g();
        }
        onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
        return false;
    }

    public final void h() {
        if (this.f) {
            return;
        }
        int i = 0;
        Integer num = b().get(0);
        if (num == null || num.intValue() != 0) {
            Intrinsics.checkNotNullExpressionValue(num, "");
            int iIntValue = num.intValue();
            if (1 <= iIntValue && iIntValue < 8) {
                i = 1;
            } else {
                int iIntValue2 = num.intValue();
                if (8 <= iIntValue2 && iIntValue2 < 15) {
                    i = 1;
                }
                i = i != 0 ? 2 : 3;
            }
        }
        b().clear();
        b().add(Integer.valueOf(i));
        this.f = true;
    }
}

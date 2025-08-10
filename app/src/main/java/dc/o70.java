package dc;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/component/dxtoy/command/code/CmdSetClock;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value1", "", "value2", "value3", "value4", "(Ljava/lang/String;IIII)V", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class o70 extends b90 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o70(@NotNull String mac, int i, int i2, int i3, int i4) {
        super(pa0.a.c0(), mac, i, i2, i3, i4);
        Intrinsics.checkNotNullParameter(mac, "mac");
        f(CollectionsKt__CollectionsKt.listOf((Object[]) new IntRange[]{new IntRange(0, 9), new IntRange(1, 7), RangesKt___RangesKt.until(1, Integer.MAX_VALUE), RangesKt___RangesKt.until(1, Integer.MAX_VALUE)}));
    }
}

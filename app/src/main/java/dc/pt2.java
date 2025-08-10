package dc;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContentScrollMeasurer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\r2%\u0010\u0003\u001a!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\tJ\u0010\u0010\u0003\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\r2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\fR1\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\u0004\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurerBuilder;", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurer;", "()V", "getScrollDistance", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "defaultDistance", "Lcom/wear/ui/chat/pancel/helper/interfaces/GetScrollDistance;", "getScrollViewId", "Lkotlin/Function0;", "Lcom/wear/ui/chat/pancel/helper/interfaces/GetScrollViewId;", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class pt2 implements ot2 {

    @Nullable
    public Function1<? super Integer, Integer> a;

    @Nullable
    public Function0<Integer> b;

    @Override // dc.ot2
    public int a(int i) {
        Function1<? super Integer, Integer> function1 = this.a;
        if (function1 != null) {
            return function1.invoke(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    @Override // dc.ot2
    public int b() {
        Function0<Integer> function0 = this.b;
        if (function0 != null) {
            return function0.invoke().intValue();
        }
        return -1;
    }

    public final void c(@NotNull Function1<? super Integer, Integer> getScrollDistance) {
        Intrinsics.checkNotNullParameter(getScrollDistance, "getScrollDistance");
        this.a = getScrollDistance;
    }

    public final void d(@NotNull Function0<Integer> getScrollViewId) {
        Intrinsics.checkNotNullParameter(getScrollViewId, "getScrollViewId");
        this.b = getScrollViewId;
    }
}

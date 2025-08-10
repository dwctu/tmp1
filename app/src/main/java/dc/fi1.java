package dc;

import android.widget.FrameLayout;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScaleTypeUtil.kt */
/* loaded from: classes3.dex */
public final class fi1 implements bi1 {
    public int a;
    public int b;

    @Override // dc.bi1
    @NotNull
    public FrameLayout.LayoutParams a(int i, int i2, int i3, int i4, @NotNull FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "layoutParams");
        Pair<Integer, Integer> pairB = b(i, i2, i3, i4);
        int iIntValue = pairB.component1().intValue();
        int iIntValue2 = pairB.component2().intValue();
        if (iIntValue <= 0 && iIntValue2 <= 0) {
            return layoutParams;
        }
        this.a = iIntValue;
        this.b = iIntValue2;
        layoutParams.width = iIntValue;
        layoutParams.height = iIntValue2;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public final Pair<Integer, Integer> b(int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i2;
        float f3 = i3 / i4;
        if (f / f2 > f3) {
            i = (int) (f3 * f2);
        } else {
            i2 = (int) (f / f3);
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // dc.bi1
    @NotNull
    public Pair<Integer, Integer> getRealSize() {
        return new Pair<>(Integer.valueOf(this.a), Integer.valueOf(this.b));
    }
}

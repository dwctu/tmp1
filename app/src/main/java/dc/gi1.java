package dc;

import android.widget.FrameLayout;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScaleTypeUtil.kt */
/* loaded from: classes3.dex */
public final class gi1 implements bi1 {
    public int a;
    public int b;

    @Override // dc.bi1
    @NotNull
    public FrameLayout.LayoutParams a(int i, int i2, int i3, int i4, @NotNull FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "layoutParams");
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.a = i;
        this.b = i2;
        return layoutParams;
    }

    @Override // dc.bi1
    @NotNull
    public Pair<Integer, Integer> getRealSize() {
        return new Pair<>(Integer.valueOf(this.a), Integer.valueOf(this.b));
    }
}

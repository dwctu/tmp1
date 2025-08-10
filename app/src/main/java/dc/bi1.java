package dc;

import android.widget.FrameLayout;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScaleTypeUtil.kt */
/* loaded from: classes3.dex */
public interface bi1 {
    @NotNull
    FrameLayout.LayoutParams a(int i, int i2, int i3, int i4, @NotNull FrameLayout.LayoutParams layoutParams);

    @NotNull
    Pair<Integer, Integer> getRealSize();
}

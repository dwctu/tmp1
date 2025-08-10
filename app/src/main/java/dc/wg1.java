package dc;

import android.graphics.SurfaceTexture;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IAnimView.kt */
/* loaded from: classes3.dex */
public interface wg1 {
    void a();

    @NotNull
    Pair<Integer, Integer> getRealSize();

    @Nullable
    SurfaceTexture getSurfaceTexture();
}

package dc;

import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: RectShape.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/hyy/highlightpro/shape/RectShape;", "Lcom/hyy/highlightpro/shape/HighlightShape;", "rx", "", "ry", "radius", "(FFF)V", "initRect", "", "rectF", "Landroid/graphics/RectF;", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class y71 extends x71 {
    public final float e;
    public final float f;

    public y71(float f, float f2, float f3) {
        super(f3);
        this.e = f;
        this.f = f2;
    }

    @Override // dc.x71
    public void d(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        super.d(rectF);
        RectF d = getD();
        if (d != null) {
            b().reset();
            b().addRoundRect(d, this.e, this.f, Path.Direction.CW);
        }
    }
}

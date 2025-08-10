package dc;

import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CircleShape.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/hyy/highlightpro/shape/CircleShape;", "Lcom/hyy/highlightpro/shape/HighlightShape;", "radius", "", "(F)V", "initRect", "", "rectF", "Landroid/graphics/RectF;", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w71 extends x71 {
    public w71() {
        this(0.0f, 1, null);
    }

    public w71(float f) {
        super(f);
    }

    @Override // dc.x71
    public void d(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        super.d(rectF);
        RectF d = getD();
        if (d != null) {
            b().reset();
            float f = 2;
            b().addCircle((d.left + d.right) / f, (d.top + d.bottom) / f, Math.max(d.height(), d.width()) / f, Path.Direction.CW);
        }
    }

    public /* synthetic */ w71(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f);
    }
}

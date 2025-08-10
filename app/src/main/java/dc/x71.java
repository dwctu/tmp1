package dc;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HighlightShape.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/hyy/highlightpro/shape/HighlightShape;", "", "blurRadius", "", "(F)V", "getBlurRadius", "()F", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "getPath$highlight_pro_release", "()Landroid/graphics/Path;", "path$delegate", "Lkotlin/Lazy;", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "setRect", "(Landroid/graphics/RectF;)V", "drawPath", "", "canvas", "Landroid/graphics/Canvas;", "initRect", "rectF", "setPaint", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class x71 {
    public final float a;
    public Paint b;

    @NotNull
    public final Lazy c = LazyKt__LazyJVMKt.lazy(a.a);

    @Nullable
    public RectF d;

    /* compiled from: HighlightShape.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Path;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<Path> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Path invoke() {
            return new Path();
        }
    }

    public x71(float f) {
        this.a = f;
        Paint paint = new Paint(1);
        paint.setDither(true);
        paint.setColor(-1);
        this.b = paint;
        if (f > 0.0f) {
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint = null;
            }
            paint.setMaskFilter(new BlurMaskFilter(f, BlurMaskFilter.Blur.SOLID));
        }
    }

    public final void a(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        RectF rectF = this.d;
        if (rectF == null || rectF.isEmpty()) {
            return;
        }
        Path pathB = b();
        Paint paint = this.b;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint = null;
        }
        canvas.drawPath(pathB, paint);
    }

    @NotNull
    public final Path b() {
        return (Path) this.c.getValue();
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final RectF getD() {
        return this.d;
    }

    public void d(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        this.d = rectF;
    }

    public final void e(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.b = paint;
    }
}

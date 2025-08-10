package dc;

import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewUtils.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\f\u0010\r\u001a\u00020\u000e*\u0004\u0018\u00010\u000f\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u000f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0012"}, d2 = {"dp", "", "getDp", "(F)F", "", "(I)I", "sp", "getSp", "calculateHighLightViewRect", "", "Lcom/hyy/highlightpro/parameter/HighlightParameter;", "rootView", "Landroid/view/ViewGroup;", "getRectOnScreen", "Landroid/graphics/RectF;", "Landroid/view/View;", "isAttachToWindow", "", "highlight_pro_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class z71 {
    public static final void a(@NotNull u71 u71Var, @NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(u71Var, "<this>");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (u71Var.getB() == null) {
            return;
        }
        RectF rectFC = c(u71Var.getB());
        rootView.getLocationOnScreen(new int[2]);
        float f = rectFC.left - r1[0];
        rectFC.left = f;
        rectFC.right -= r1[0];
        rectFC.top -= r1[1];
        rectFC.bottom -= r1[1];
        rectFC.left = f - rootView.getPaddingLeft();
        rectFC.right -= rootView.getPaddingLeft();
        rectFC.top -= rootView.getPaddingTop();
        rectFC.bottom -= rootView.getPaddingTop();
        u71Var.r(rectFC);
        RectF f2 = u71Var.getF();
        f2.left -= u71Var.getG();
        f2.top -= u71Var.getH();
        f2.right += u71Var.getG();
        f2.bottom += u71Var.getH();
        x71 e = u71Var.getE();
        if (e != null) {
            e.d(f2);
        }
    }

    public static final float b(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    @NotNull
    public static final RectF c(@Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        view.getLocationOnScreen(new int[]{0, 0});
        RectF rectF = new RectF();
        rectF.left = r0[0];
        rectF.top = r0[1];
        rectF.right = r0[0] + view.getWidth();
        rectF.bottom = r0[1] + view.getHeight();
        return rectF;
    }

    public static final boolean d(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }
}

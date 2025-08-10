package dc;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.databinding.BindingAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ViewExtensions.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0007\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0007\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004\u001a\u0012\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\rH\u0007\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0004\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\rH\u0007¨\u0006\u001c"}, d2 = {"setBgColor", "", "Landroid/view/View;", "resId", "", "setBgDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setBgDrawableId", "setBottomPadding", "bottomPadding", "setClipShape", TypedValues.Custom.S_BOOLEAN, "", "setEnable", StreamManagement.Enable.ELEMENT, "setInvisible", "flag", "setLeftPadding", "leftPadding", "setRightPadding", "rightPadding", "setSelected", "isSelected", "setTopPadding", "topPadding", "setVisible", "visible", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class wi1 {
    @BindingAdapter({StreamManagement.Enable.ELEMENT})
    public static final void a(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setEnabled(z);
    }

    @BindingAdapter({"isSelected"})
    public static final void b(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setSelected(z);
    }

    @BindingAdapter({"isVisible"})
    public static final void c(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }
}

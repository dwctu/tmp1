package dc;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;

/* compiled from: SkinCompatDrawableUtils.java */
/* loaded from: classes5.dex */
public class sh4 {
    public static boolean a(@NonNull Drawable drawable) {
        Drawable drawable2;
        int i = Build.VERSION.SDK_INT;
        if (i < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (i < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (i < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (!(drawable instanceof DrawableContainer)) {
            if (mi4.d(drawable)) {
                return a(mi4.a(drawable));
            }
            if (mi4.e(drawable)) {
                return a(mi4.b(drawable));
            }
            if (mi4.f(drawable)) {
                return a(mi4.c(drawable));
            }
            if (!(drawable instanceof ScaleDrawable) || (drawable2 = ((ScaleDrawable) drawable).getDrawable()) == null) {
                return true;
            }
            return a(drawable2);
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return true;
        }
        for (Drawable drawable3 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
            if (!a(drawable3)) {
                return false;
            }
        }
        return true;
    }

    public static void b(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    public static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(uh4.l);
        } else {
            drawable.setState(uh4.n);
        }
        drawable.setState(state);
    }
}

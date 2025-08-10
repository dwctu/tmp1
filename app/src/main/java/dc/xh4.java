package dc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;

/* compiled from: SkinCompatVectorResources.java */
/* loaded from: classes5.dex */
public class xh4 implements yh4 {
    public static xh4 a;

    public xh4() {
        th4.e().a(this);
    }

    public static Drawable a(Context context, int i) {
        return b().c(context, i);
    }

    public static xh4 b() {
        if (a == null) {
            synchronized (xh4.class) {
                if (a == null) {
                    a = new xh4();
                }
            }
        }
        return a;
    }

    public final Drawable c(Context context, int i) {
        int iM;
        Drawable drawableL;
        ColorStateList colorStateListK;
        Drawable drawableL2;
        ColorStateList colorStateListK2;
        if (!AppCompatDelegate.isCompatVectorFromResourcesEnabled()) {
            if (!vh4.g().n() && (colorStateListK = vh4.g().k(i)) != null) {
                return new ColorDrawable(colorStateListK.getDefaultColor());
            }
            if (!vh4.g().o() && (drawableL = vh4.g().l(i)) != null) {
                return drawableL;
            }
            Drawable drawableL3 = th4.e().l(context, i);
            return drawableL3 != null ? drawableL3 : (th4.e().p() || (iM = th4.e().m(context, i)) == 0) ? AppCompatResources.getDrawable(context, i) : th4.e().i().getDrawable(iM);
        }
        if (!th4.e().p()) {
            try {
                return rh4.n().p(context, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!vh4.g().n() && (colorStateListK2 = vh4.g().k(i)) != null) {
            return new ColorDrawable(colorStateListK2.getDefaultColor());
        }
        if (!vh4.g().o() && (drawableL2 = vh4.g().l(i)) != null) {
            return drawableL2;
        }
        Drawable drawableL4 = th4.e().l(context, i);
        return drawableL4 != null ? drawableL4 : AppCompatResources.getDrawable(context, i);
    }

    @Override // dc.yh4
    public void clear() {
        rh4.n().f();
    }
}

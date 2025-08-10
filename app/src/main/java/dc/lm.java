package dc;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class lm<T extends Drawable> implements ti<T>, pi {
    public final T a;

    public lm(T t) {
        vp.d(t);
        this.a = t;
    }

    @Override // dc.ti
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        return constantState == null ? this.a : (T) constantState.newDrawable();
    }

    @Override // dc.pi
    public void initialize() {
        T t = this.a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).e().prepareToDraw();
        }
    }
}

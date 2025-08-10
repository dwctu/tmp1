package dc;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: NonOwnedDrawableResource.java */
/* loaded from: classes.dex */
public final class nm extends lm<Drawable> {
    public nm(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    public static ti<Drawable> d(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new nm(drawable);
        }
        return null;
    }

    @Override // dc.ti
    public int b() {
        return Math.max(1, this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * 4);
    }

    @Override // dc.ti
    @NonNull
    public Class<Drawable> c() {
        return this.a.getClass();
    }

    @Override // dc.ti
    public void recycle() {
    }
}

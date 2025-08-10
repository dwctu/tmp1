package dc;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: DrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class xo extends yo<Drawable> {
    public xo(ImageView imageView) {
        super(imageView);
    }

    @Override // dc.yo
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(@Nullable Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }
}

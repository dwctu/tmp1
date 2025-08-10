package dc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: BitmapDrawableTranscoder.java */
/* loaded from: classes.dex */
public class cn implements fn<Bitmap, BitmapDrawable> {
    public final Resources a;

    public cn(@NonNull Resources resources) {
        vp.d(resources);
        this.a = resources;
    }

    @Override // dc.fn
    @Nullable
    public ti<BitmapDrawable> a(@NonNull ti<Bitmap> tiVar, @NonNull ah ahVar) {
        return zl.d(this.a, tiVar);
    }
}

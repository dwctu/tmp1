package dc;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class kl implements eh<Bitmap> {
    @Override // dc.eh
    @NonNull
    public final ti<Bitmap> a(@NonNull Context context, @NonNull ti<Bitmap> tiVar, int i, int i2) {
        if (!wp.t(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        cj cjVarF = kf.c(context).f();
        Bitmap bitmap = tiVar.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(cjVarF, bitmap, i, i2);
        return bitmap.equals(bitmapC) ? tiVar : jl.d(bitmapC, cjVarF);
    }

    public abstract Bitmap c(@NonNull cj cjVar, @NonNull Bitmap bitmap, int i, int i2);
}

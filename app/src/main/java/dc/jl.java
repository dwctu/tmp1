package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class jl implements ti<Bitmap>, pi {
    public final Bitmap a;
    public final cj b;

    public jl(@NonNull Bitmap bitmap, @NonNull cj cjVar) {
        vp.e(bitmap, "Bitmap must not be null");
        this.a = bitmap;
        vp.e(cjVar, "BitmapPool must not be null");
        this.b = cjVar;
    }

    @Nullable
    public static jl d(@Nullable Bitmap bitmap, @NonNull cj cjVar) {
        if (bitmap == null) {
            return null;
        }
        return new jl(bitmap, cjVar);
    }

    @Override // dc.ti
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.a;
    }

    @Override // dc.ti
    public int b() {
        return wp.h(this.a);
    }

    @Override // dc.ti
    @NonNull
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    @Override // dc.pi
    public void initialize() {
        this.a.prepareToDraw();
    }

    @Override // dc.ti
    public void recycle() {
        this.b.c(this.a);
    }
}

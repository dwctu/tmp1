package dc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: classes.dex */
public final class zl implements ti<BitmapDrawable>, pi {
    public final Resources a;
    public final ti<Bitmap> b;

    public zl(@NonNull Resources resources, @NonNull ti<Bitmap> tiVar) {
        vp.d(resources);
        this.a = resources;
        vp.d(tiVar);
        this.b = tiVar;
    }

    @Nullable
    public static ti<BitmapDrawable> d(@NonNull Resources resources, @Nullable ti<Bitmap> tiVar) {
        if (tiVar == null) {
            return null;
        }
        return new zl(resources, tiVar);
    }

    @Override // dc.ti
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.a, this.b.get());
    }

    @Override // dc.ti
    public int b() {
        return this.b.b();
    }

    @Override // dc.ti
    @NonNull
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    @Override // dc.pi
    public void initialize() {
        ti<Bitmap> tiVar = this.b;
        if (tiVar instanceof pi) {
            ((pi) tiVar).initialize();
        }
    }

    @Override // dc.ti
    public void recycle() {
        this.b.recycle();
    }
}

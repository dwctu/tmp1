package dc;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* compiled from: DrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public final class dn implements fn<Drawable, byte[]> {
    public final cj a;
    public final fn<Bitmap, byte[]> b;
    public final fn<GifDrawable, byte[]> c;

    public dn(@NonNull cj cjVar, @NonNull fn<Bitmap, byte[]> fnVar, @NonNull fn<GifDrawable, byte[]> fnVar2) {
        this.a = cjVar;
        this.b = fnVar;
        this.c = fnVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static ti<GifDrawable> b(@NonNull ti<Drawable> tiVar) {
        return tiVar;
    }

    @Override // dc.fn
    @Nullable
    public ti<byte[]> a(@NonNull ti<Drawable> tiVar, @NonNull ah ahVar) {
        Drawable drawable = tiVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(jl.d(((BitmapDrawable) drawable).getBitmap(), this.a), ahVar);
        }
        if (!(drawable instanceof GifDrawable)) {
            return null;
        }
        fn<GifDrawable, byte[]> fnVar = this.c;
        b(tiVar);
        return fnVar.a(tiVar, ahVar);
    }
}

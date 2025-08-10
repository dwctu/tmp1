package dc;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class wm implements eh<GifDrawable> {
    public final eh<Bitmap> b;

    public wm(eh<Bitmap> ehVar) {
        vp.d(ehVar);
        this.b = ehVar;
    }

    @Override // dc.eh
    @NonNull
    public ti<GifDrawable> a(@NonNull Context context, @NonNull ti<GifDrawable> tiVar, int i, int i2) {
        GifDrawable gifDrawable = tiVar.get();
        ti<Bitmap> jlVar = new jl(gifDrawable.e(), kf.c(context).f());
        ti<Bitmap> tiVarA = this.b.a(context, jlVar, i, i2);
        if (!jlVar.equals(tiVarA)) {
            jlVar.recycle();
        }
        gifDrawable.m(this.b, tiVarA.get());
        return tiVar;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (obj instanceof wm) {
            return this.b.equals(((wm) obj).b);
        }
        return false;
    }

    @Override // dc.xg
    public int hashCode() {
        return this.b.hashCode();
    }
}

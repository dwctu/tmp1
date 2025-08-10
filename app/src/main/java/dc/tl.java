package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation.java */
/* loaded from: classes.dex */
public class tl implements eh<Drawable> {
    public final eh<Bitmap> b;
    public final boolean c;

    public tl(eh<Bitmap> ehVar, boolean z) {
        this.b = ehVar;
        this.c = z;
    }

    @Override // dc.eh
    @NonNull
    public ti<Drawable> a(@NonNull Context context, @NonNull ti<Drawable> tiVar, int i, int i2) {
        cj cjVarF = kf.c(context).f();
        Drawable drawable = tiVar.get();
        ti<Bitmap> tiVarA = sl.a(cjVarF, drawable, i, i2);
        if (tiVarA != null) {
            ti<Bitmap> tiVarA2 = this.b.a(context, tiVarA, i, i2);
            if (!tiVarA2.equals(tiVarA)) {
                return d(context, tiVarA2);
            }
            tiVarA2.recycle();
            return tiVar;
        }
        if (!this.c) {
            return tiVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    public eh<BitmapDrawable> c() {
        return this;
    }

    public final ti<Drawable> d(Context context, ti<Bitmap> tiVar) {
        return zl.d(context.getResources(), tiVar);
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (obj instanceof tl) {
            return this.b.equals(((tl) obj).b);
        }
        return false;
    }

    @Override // dc.xg
    public int hashCode() {
        return this.b.hashCode();
    }
}

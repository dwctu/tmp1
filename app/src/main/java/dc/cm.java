package dc;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: ResourceBitmapDecoder.java */
/* loaded from: classes.dex */
public class cm implements ch<Uri, Bitmap> {
    public final om a;
    public final cj b;

    public cm(om omVar, cj cjVar) {
        this.a = omVar;
        this.b = cjVar;
    }

    @Override // dc.ch
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        ti<Drawable> tiVarB = this.a.b(uri, i, i2, ahVar);
        if (tiVarB == null) {
            return null;
        }
        return sl.a(this.b, tiVarB.get(), i, i2);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri, @NonNull ah ahVar) {
        return "android.resource".equals(uri.getScheme());
    }
}

package dc;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* compiled from: BitmapDrawableEncoder.java */
/* loaded from: classes.dex */
public class gl implements dh<BitmapDrawable> {
    public final cj a;
    public final dh<Bitmap> b;

    public gl(cj cjVar, dh<Bitmap> dhVar) {
        this.a = cjVar;
        this.b = dhVar;
    }

    @Override // dc.dh
    @NonNull
    public ug b(@NonNull ah ahVar) {
        return this.b.b(ahVar);
    }

    @Override // dc.vg
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ti<BitmapDrawable> tiVar, @NonNull File file, @NonNull ah ahVar) {
        return this.b.a(new jl(tiVar.get().getBitmap(), this.a), file, ahVar);
    }
}

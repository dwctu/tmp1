package dc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: BitmapDrawableDecoder.java */
/* loaded from: classes.dex */
public class fl<DataType> implements ch<DataType, BitmapDrawable> {
    public final ch<DataType, Bitmap> a;
    public final Resources b;

    public fl(@NonNull Resources resources, @NonNull ch<DataType, Bitmap> chVar) {
        vp.d(resources);
        this.b = resources;
        vp.d(chVar);
        this.a = chVar;
    }

    @Override // dc.ch
    public boolean a(@NonNull DataType datatype, @NonNull ah ahVar) throws IOException {
        return this.a.a(datatype, ahVar);
    }

    @Override // dc.ch
    public ti<BitmapDrawable> b(@NonNull DataType datatype, int i, int i2, @NonNull ah ahVar) throws IOException {
        return zl.d(this.b, this.a.b(datatype, i, i2, ahVar));
    }
}

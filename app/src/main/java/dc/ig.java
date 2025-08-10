package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamAnimatedBitmapDecoder.java */
/* loaded from: classes.dex */
public class ig implements ch<InputStream, Bitmap> {
    public final eg a;

    public ig(eg egVar) {
        this.a = egVar;
    }

    @Override // dc.ch
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull InputStream inputStream, int i, int i2, @NonNull ah ahVar) throws IOException {
        return this.a.a(inputStream, i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull ah ahVar) throws IOException {
        return this.a.c(inputStream, ahVar);
    }
}

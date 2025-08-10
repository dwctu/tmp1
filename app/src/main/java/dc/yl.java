package dc;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class yl implements ch<InputStream, Bitmap> {
    public final il a = new il();

    @Override // dc.ch
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull InputStream inputStream, int i, int i2, @NonNull ah ahVar) throws IOException {
        return this.a.b(ImageDecoder.createSource(np.b(inputStream)), i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull ah ahVar) throws IOException {
        return true;
    }
}

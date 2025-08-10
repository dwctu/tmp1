package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder.java */
/* loaded from: classes.dex */
public class bn implements fn<Bitmap, byte[]> {
    public final Bitmap.CompressFormat a;
    public final int b;

    public bn() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // dc.fn
    @Nullable
    public ti<byte[]> a(@NonNull ti<Bitmap> tiVar, @NonNull ah ahVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        tiVar.get().compress(this.a, this.b, byteArrayOutputStream);
        tiVar.recycle();
        return new jm(byteArrayOutputStream.toByteArray());
    }

    public bn(@NonNull Bitmap.CompressFormat compressFormat, int i) {
        this.a = compressFormat;
        this.b = i;
    }
}

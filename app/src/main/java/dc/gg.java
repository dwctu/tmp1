package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapWebpDecoder.java */
/* loaded from: classes.dex */
public class gg implements ch<ByteBuffer, Bitmap> {
    public final ng a;

    public gg(ng ngVar) {
        this.a = ngVar;
    }

    @Override // dc.ch
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull ah ahVar) throws IOException {
        return this.a.d(np.f(byteBuffer), i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull ah ahVar) throws IOException {
        return this.a.m(byteBuffer, ahVar);
    }
}

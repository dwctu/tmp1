package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder.java */
/* loaded from: classes.dex */
public class ll implements ch<ByteBuffer, Bitmap> {
    public final rl a;

    public ll(rl rlVar) {
        this.a = rlVar;
    }

    @Override // dc.ch
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull ah ahVar) throws IOException {
        return this.a.f(np.f(byteBuffer), i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull ah ahVar) {
        return this.a.q(byteBuffer);
    }
}

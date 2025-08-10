package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferAnimatedBitmapDecoder.java */
/* loaded from: classes.dex */
public class fg implements ch<ByteBuffer, Bitmap> {
    public final eg a;

    public fg(eg egVar) {
        this.a = egVar;
    }

    @Override // dc.ch
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull ah ahVar) throws IOException {
        return this.a.b(byteBuffer, i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull ah ahVar) throws IOException {
        return this.a.d(byteBuffer, ahVar);
    }
}

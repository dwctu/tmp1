package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: StreamWebpDecoder.java */
/* loaded from: classes.dex */
public class kg implements ch<InputStream, WebpDrawable> {
    public static final zg<Boolean> c = zg.f("com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder.DisableAnimation", Boolean.FALSE);
    public final ch<ByteBuffer, WebpDrawable> a;
    public final zi b;

    public kg(ch<ByteBuffer, WebpDrawable> chVar, zi ziVar) {
        this.a = chVar;
        this.b = ziVar;
    }

    @Override // dc.ch
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<WebpDrawable> b(@NonNull InputStream inputStream, int i, int i2, @NonNull ah ahVar) throws IOException {
        byte[] bArrB = lg.b(inputStream);
        if (bArrB == null) {
            return null;
        }
        return this.a.b(ByteBuffer.wrap(bArrB), i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull ah ahVar) throws IOException {
        if (((Boolean) ahVar.c(c)).booleanValue()) {
            return false;
        }
        return dg.e(dg.b(inputStream, this.b));
    }
}

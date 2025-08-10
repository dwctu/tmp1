package dc;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferWebpDecoder.java */
/* loaded from: classes.dex */
public class hg implements ch<ByteBuffer, WebpDrawable> {
    public static final zg<Boolean> d = zg.f("com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", Boolean.FALSE);
    public final Context a;
    public final cj b;
    public final tm c;

    public hg(Context context, zi ziVar, cj cjVar) {
        this.a = context.getApplicationContext();
        this.b = cjVar;
        this.c = new tm(cjVar, ziVar);
    }

    @Override // dc.ch
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<WebpDrawable> b(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull ah ahVar) throws IOException {
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        WebpImage webpImageCreate = WebpImage.create(bArr);
        mg mgVar = new mg(this.c, webpImageCreate, byteBuffer, lg.a(webpImageCreate.getWidth(), webpImageCreate.getHeight(), i, i2), (qg) ahVar.c(rg.t));
        mgVar.a();
        Bitmap nextFrame = mgVar.getNextFrame();
        if (nextFrame == null) {
            return null;
        }
        return new pg(new WebpDrawable(this.a, mgVar, this.b, el.c(), i, i2, nextFrame));
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull ah ahVar) throws IOException {
        if (((Boolean) ahVar.c(d)).booleanValue()) {
            return false;
        }
        return dg.e(dg.c(byteBuffer));
    }
}

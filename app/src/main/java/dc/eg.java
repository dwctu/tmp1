package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.integration.webp.WebpImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: AnimatedWebpBitmapDecoder.java */
/* loaded from: classes.dex */
public class eg {
    public static final zg<Boolean> d = zg.f("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);
    public final zi a;
    public final cj b;
    public final tm c;

    public eg(zi ziVar, cj cjVar) {
        this.a = ziVar;
        this.b = cjVar;
        this.c = new tm(cjVar, ziVar);
    }

    public ti<Bitmap> a(InputStream inputStream, int i, int i2, ah ahVar) throws IOException {
        byte[] bArrB = lg.b(inputStream);
        if (bArrB == null) {
            return null;
        }
        return b(ByteBuffer.wrap(bArrB), i, i2, ahVar);
    }

    public ti<Bitmap> b(ByteBuffer byteBuffer, int i, int i2, ah ahVar) throws IOException {
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        WebpImage webpImageCreate = WebpImage.create(bArr);
        mg mgVar = new mg(this.c, webpImageCreate, byteBuffer, lg.a(webpImageCreate.getWidth(), webpImageCreate.getHeight(), i, i2));
        try {
            mgVar.a();
            return jl.d(mgVar.getNextFrame(), this.b);
        } finally {
            mgVar.clear();
        }
    }

    public boolean c(InputStream inputStream, @NonNull ah ahVar) throws IOException {
        if (((Boolean) ahVar.c(d)).booleanValue()) {
            return false;
        }
        return dg.e(dg.b(inputStream, this.a));
    }

    public boolean d(ByteBuffer byteBuffer, @NonNull ah ahVar) throws IOException {
        if (((Boolean) ahVar.c(d)).booleanValue()) {
            return false;
        }
        return dg.e(dg.c(byteBuffer));
    }
}

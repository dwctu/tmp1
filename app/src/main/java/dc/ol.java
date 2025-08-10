package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: CenterInside.java */
/* loaded from: classes.dex */
public class ol extends kl {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(xg.a);

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // dc.kl
    public Bitmap c(@NonNull cj cjVar, @NonNull Bitmap bitmap, int i, int i2) {
        return fm.c(cjVar, bitmap, i, i2);
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        return obj instanceof ol;
    }

    @Override // dc.xg
    public int hashCode() {
        return -670243078;
    }
}

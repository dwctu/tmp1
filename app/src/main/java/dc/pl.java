package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: CircleCrop.java */
/* loaded from: classes.dex */
public class pl extends kl {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(xg.a);

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // dc.kl
    public Bitmap c(@NonNull cj cjVar, @NonNull Bitmap bitmap, int i, int i2) {
        return fm.d(cjVar, bitmap, i, i2);
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        return obj instanceof pl;
    }

    @Override // dc.xg
    public int hashCode() {
        return 1101716364;
    }
}

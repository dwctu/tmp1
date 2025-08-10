package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: FitCenter.java */
/* loaded from: classes.dex */
public class vl extends kl {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(xg.a);

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // dc.kl
    public Bitmap c(@NonNull cj cjVar, @NonNull Bitmap bitmap, int i, int i2) {
        return fm.f(cjVar, bitmap, i, i2);
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        return obj instanceof vl;
    }

    @Override // dc.xg
    public int hashCode() {
        return 1572326941;
    }
}

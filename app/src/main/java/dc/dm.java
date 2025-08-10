package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: RoundedCorners.java */
/* loaded from: classes.dex */
public final class dm extends kl {
    public static final byte[] c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(xg.a);
    public final int b;

    public dm(int i) {
        vp.a(i > 0, "roundingRadius must be greater than 0.");
        this.b = i;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // dc.kl
    public Bitmap c(@NonNull cj cjVar, @NonNull Bitmap bitmap, int i, int i2) {
        return fm.o(cjVar, bitmap, this.b);
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        return (obj instanceof dm) && this.b == ((dm) obj).b;
    }

    @Override // dc.xg
    public int hashCode() {
        return wp.n(-569625254, wp.m(this.b));
    }
}

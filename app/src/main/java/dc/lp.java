package dc;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: EmptySignature.java */
/* loaded from: classes.dex */
public final class lp implements xg {
    public static final lp b = new lp();

    @NonNull
    public static lp c() {
        return b;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}

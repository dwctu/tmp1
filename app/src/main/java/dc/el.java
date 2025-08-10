package dc;

import android.content.Context;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: UnitTransformation.java */
/* loaded from: classes.dex */
public final class el<T> implements eh<T> {
    public static final eh<?> b = new el();

    @NonNull
    public static <T> el<T> c() {
        return (el) b;
    }

    @Override // dc.eh
    @NonNull
    public ti<T> a(@NonNull Context context, @NonNull ti<T> tiVar, int i, int i2) {
        return tiVar;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
    }
}

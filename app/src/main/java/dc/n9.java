package dc;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* compiled from: LottieCompositionCache.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class n9 {
    public static final n9 b = new n9();
    public final LruCache<String, f7> a = new LruCache<>(20);

    @VisibleForTesting
    public n9() {
    }

    public static n9 b() {
        return b;
    }

    @Nullable
    public f7 a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str);
    }

    public void c(@Nullable String str, f7 f7Var) {
        if (str == null) {
            return;
        }
        this.a.put(str, f7Var);
    }
}

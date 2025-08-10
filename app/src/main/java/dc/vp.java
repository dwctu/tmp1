package dc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class vp {
    public static void a(boolean z, @NonNull String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static String b(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T c(@NonNull T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    @NonNull
    public static <T> T d(@Nullable T t) {
        e(t, "Argument must not be null");
        return t;
    }

    @NonNull
    public static <T> T e(@Nullable T t, @NonNull String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}

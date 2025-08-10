package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: Option.java */
/* loaded from: classes.dex */
public final class zg<T> {
    public static final b<Object> e = new a();
    public final T a;
    public final b<T> b;
    public final String c;
    public volatile byte[] d;

    /* compiled from: Option.java */
    public class a implements b<Object> {
        @Override // dc.zg.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option.java */
    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public zg(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        vp.b(str);
        this.c = str;
        this.a = t;
        vp.d(bVar);
        this.b = bVar;
    }

    @NonNull
    public static <T> zg<T> a(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        return new zg<>(str, t, bVar);
    }

    @NonNull
    public static <T> b<T> b() {
        return (b<T>) e;
    }

    @NonNull
    public static <T> zg<T> e(@NonNull String str) {
        return new zg<>(str, null, b());
    }

    @NonNull
    public static <T> zg<T> f(@NonNull String str, @NonNull T t) {
        return new zg<>(str, t, b());
    }

    @Nullable
    public T c() {
        return this.a;
    }

    @NonNull
    public final byte[] d() {
        if (this.d == null) {
            this.d = this.c.getBytes(xg.a);
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof zg) {
            return this.c.equals(((zg) obj).c);
        }
        return false;
    }

    public void g(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.b.a(d(), t, messageDigest);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.c + '\'' + MessageFormatter.DELIM_STOP;
    }
}

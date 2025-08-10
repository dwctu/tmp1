package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class ah implements xg {
    public final ArrayMap<zg<?>, Object> b = new CachedHashCodeArrayMap();

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(@NonNull zg<T> zgVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        zgVar.g(obj, messageDigest);
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.b.size(); i++) {
            f(this.b.keyAt(i), this.b.valueAt(i), messageDigest);
        }
    }

    @Nullable
    public <T> T c(@NonNull zg<T> zgVar) {
        return this.b.containsKey(zgVar) ? (T) this.b.get(zgVar) : zgVar.c();
    }

    public void d(@NonNull ah ahVar) {
        this.b.putAll((SimpleArrayMap<? extends zg<?>, ? extends Object>) ahVar.b);
    }

    @NonNull
    public <T> ah e(@NonNull zg<T> zgVar, @NonNull T t) {
        this.b.put(zgVar, t);
        return this;
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (obj instanceof ah) {
            return this.b.equals(((ah) obj).b);
        }
        return false;
    }

    @Override // dc.xg
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + MessageFormatter.DELIM_STOP;
    }
}

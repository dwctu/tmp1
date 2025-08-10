package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class up {
    public Class<?> a;
    public Class<?> b;
    public Class<?> c;

    public up() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || up.class != obj.getClass()) {
            return false;
        }
        up upVar = (up) obj;
        return this.a.equals(upVar.a) && this.b.equals(upVar.b) && wp.d(this.c, upVar.c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Class<?> cls = this.c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + MessageFormatter.DELIM_STOP;
    }

    public up(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}

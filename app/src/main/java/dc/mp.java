package dc;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ObjectKey.java */
/* loaded from: classes.dex */
public final class mp implements xg {
    public final Object b;

    public mp(@NonNull Object obj) {
        vp.d(obj);
        this.b = obj;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(xg.a));
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (obj instanceof mp) {
            return this.b.equals(((mp) obj).b);
        }
        return false;
    }

    @Override // dc.xg
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.b + MessageFormatter.DELIM_STOP;
    }
}

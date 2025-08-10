package dc;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: DataCacheKey.java */
/* loaded from: classes.dex */
public final class ci implements xg {
    public final xg b;
    public final xg c;

    public ci(xg xgVar, xg xgVar2) {
        this.b = xgVar;
        this.c = xgVar2;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        this.b.b(messageDigest);
        this.c.b(messageDigest);
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (!(obj instanceof ci)) {
            return false;
        }
        ci ciVar = (ci) obj;
        return this.b.equals(ciVar.b) && this.c.equals(ciVar.c);
    }

    @Override // dc.xg
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + MessageFormatter.DELIM_STOP;
    }
}

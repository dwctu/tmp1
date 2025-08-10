package dc;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
public class mi implements xg {
    public final Object b;
    public final int c;
    public final int d;
    public final Class<?> e;
    public final Class<?> f;
    public final xg g;
    public final Map<Class<?>, eh<?>> h;
    public final ah i;
    public int j;

    public mi(Object obj, xg xgVar, int i, int i2, Map<Class<?>, eh<?>> map, Class<?> cls, Class<?> cls2, ah ahVar) {
        vp.d(obj);
        this.b = obj;
        vp.e(xgVar, "Signature must not be null");
        this.g = xgVar;
        this.c = i;
        this.d = i2;
        vp.d(map);
        this.h = map;
        vp.e(cls, "Resource class must not be null");
        this.e = cls;
        vp.e(cls2, "Transcode class must not be null");
        this.f = cls2;
        vp.d(ahVar);
        this.i = ahVar;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (!(obj instanceof mi)) {
            return false;
        }
        mi miVar = (mi) obj;
        return this.b.equals(miVar.b) && this.g.equals(miVar.g) && this.d == miVar.d && this.c == miVar.c && this.h.equals(miVar.h) && this.e.equals(miVar.e) && this.f.equals(miVar.f) && this.i.equals(miVar.i);
    }

    @Override // dc.xg
    public int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.b.hashCode();
            this.j = iHashCode;
            int iHashCode2 = (iHashCode * 31) + this.g.hashCode();
            this.j = iHashCode2;
            int i = (iHashCode2 * 31) + this.c;
            this.j = i;
            int i2 = (i * 31) + this.d;
            this.j = i2;
            int iHashCode3 = (i2 * 31) + this.h.hashCode();
            this.j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.e.hashCode();
            this.j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f.hashCode();
            this.j = iHashCode5;
            this.j = (iHashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + MessageFormatter.DELIM_STOP;
    }
}

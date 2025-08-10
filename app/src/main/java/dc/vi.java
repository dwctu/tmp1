package dc;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ResourceCacheKey.java */
/* loaded from: classes.dex */
public final class vi implements xg {
    public static final sp<Class<?>, byte[]> j = new sp<>(50);
    public final zi b;
    public final xg c;
    public final xg d;
    public final int e;
    public final int f;
    public final Class<?> g;
    public final ah h;
    public final eh<?> i;

    public vi(zi ziVar, xg xgVar, xg xgVar2, int i, int i2, eh<?> ehVar, Class<?> cls, ah ahVar) {
        this.b = ziVar;
        this.c = xgVar;
        this.d = xgVar2;
        this.e = i;
        this.f = i2;
        this.i = ehVar;
        this.g = cls;
        this.h = ahVar;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(bArr);
        eh<?> ehVar = this.i;
        if (ehVar != null) {
            ehVar.b(messageDigest);
        }
        this.h.b(messageDigest);
        messageDigest.update(c());
        this.b.put(bArr);
    }

    public final byte[] c() {
        sp<Class<?>, byte[]> spVar = j;
        byte[] bArrG = spVar.g(this.g);
        if (bArrG != null) {
            return bArrG;
        }
        byte[] bytes = this.g.getName().getBytes(xg.a);
        spVar.k(this.g, bytes);
        return bytes;
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (!(obj instanceof vi)) {
            return false;
        }
        vi viVar = (vi) obj;
        return this.f == viVar.f && this.e == viVar.e && wp.d(this.i, viVar.i) && this.g.equals(viVar.g) && this.c.equals(viVar.c) && this.d.equals(viVar.d) && this.h.equals(viVar.h);
    }

    @Override // dc.xg
    public int hashCode() {
        int iHashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        eh<?> ehVar = this.i;
        if (ehVar != null) {
            iHashCode = (iHashCode * 31) + ehVar.hashCode();
        }
        return (((iHashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + MessageFormatter.DELIM_STOP;
    }
}

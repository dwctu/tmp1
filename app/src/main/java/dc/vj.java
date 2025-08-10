package dc;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import dc.xp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class vj {
    public final sp<xg, String> a = new sp<>(1000);
    public final Pools.Pool<b> b = xp.d(10, new a(this));

    /* compiled from: SafeKeyGenerator.java */
    public class a implements xp.d<b> {
        public a(vj vjVar) {
        }

        @Override // dc.xp.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: SafeKeyGenerator.java */
    public static final class b implements xp.f {
        public final MessageDigest a;
        public final zp b = zp.a();

        public b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // dc.xp.f
        @NonNull
        public zp d() {
            return this.b;
        }
    }

    public final String a(xg xgVar) {
        b bVarAcquire = this.b.acquire();
        vp.d(bVarAcquire);
        b bVar = bVarAcquire;
        try {
            xgVar.b(bVar.a);
            return wp.u(bVar.a.digest());
        } finally {
            this.b.release(bVar);
        }
    }

    public String b(xg xgVar) {
        String strG;
        synchronized (this.a) {
            strG = this.a.g(xgVar);
        }
        if (strG == null) {
            strG = a(xgVar);
        }
        synchronized (this.a) {
            this.a.k(xgVar, strG);
        }
        return strG;
    }
}

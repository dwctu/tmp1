package dc;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class ek implements xg {
    public final fk b;

    @Nullable
    public final URL c;

    @Nullable
    public final String d;

    @Nullable
    public String e;

    @Nullable
    public URL f;

    @Nullable
    public volatile byte[] g;
    public int h;

    public ek(URL url) {
        this(url, fk.a);
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        URL url = this.c;
        vp.d(url);
        return url.toString();
    }

    public final byte[] d() {
        if (this.g == null) {
            this.g = c().getBytes(xg.a);
        }
        return this.g;
    }

    public Map<String, String> e() {
        return this.b.getHeaders();
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (!(obj instanceof ek)) {
            return false;
        }
        ek ekVar = (ek) obj;
        return c().equals(ekVar.c()) && this.b.equals(ekVar.b);
    }

    public final String f() {
        if (TextUtils.isEmpty(this.e)) {
            String string = this.d;
            if (TextUtils.isEmpty(string)) {
                URL url = this.c;
                vp.d(url);
                string = url.toString();
            }
            this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }

    public final URL g() throws MalformedURLException {
        if (this.f == null) {
            this.f = new URL(f());
        }
        return this.f;
    }

    public URL h() throws MalformedURLException {
        return g();
    }

    @Override // dc.xg
    public int hashCode() {
        if (this.h == 0) {
            int iHashCode = c().hashCode();
            this.h = iHashCode;
            this.h = (iHashCode * 31) + this.b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return c();
    }

    public ek(String str) {
        this(str, fk.a);
    }

    public ek(URL url, fk fkVar) {
        vp.d(url);
        this.c = url;
        this.d = null;
        vp.d(fkVar);
        this.b = fkVar;
    }

    public ek(String str, fk fkVar) {
        this.c = null;
        vp.b(str);
        this.d = str;
        vp.d(fkVar);
        this.b = fkVar;
    }
}

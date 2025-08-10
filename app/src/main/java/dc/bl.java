package dc;

import androidx.annotation.NonNull;
import dc.lk;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class bl implements lk<URL, InputStream> {
    public final lk<ek, InputStream> a;

    /* compiled from: UrlLoader.java */
    public static class a implements mk<URL, InputStream> {
        @Override // dc.mk
        @NonNull
        public lk<URL, InputStream> b(pk pkVar) {
            return new bl(pkVar.d(ek.class, InputStream.class));
        }
    }

    public bl(lk<ek, InputStream> lkVar) {
        this.a = lkVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<InputStream> b(@NonNull URL url, int i, int i2, @NonNull ah ahVar) {
        return this.a.b(new ek(url), i, i2, ahVar);
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull URL url) {
        return true;
    }
}

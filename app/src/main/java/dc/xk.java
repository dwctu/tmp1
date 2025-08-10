package dc;

import android.net.Uri;
import androidx.annotation.NonNull;
import dc.lk;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader.java */
/* loaded from: classes.dex */
public class xk implements lk<Uri, InputStream> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    public final lk<ek, InputStream> a;

    /* compiled from: HttpUriLoader.java */
    public static class a implements mk<Uri, InputStream> {
        @Override // dc.mk
        @NonNull
        public lk<Uri, InputStream> b(pk pkVar) {
            return new xk(pkVar.d(ek.class, InputStream.class));
        }
    }

    public xk(lk<ek, InputStream> lkVar) {
        this.a = lkVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<InputStream> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        return this.a.b(new ek(uri.toString()), i, i2, ahVar);
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}

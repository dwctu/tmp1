package dc;

import android.net.Uri;
import androidx.annotation.NonNull;
import dc.lk;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class vk<Data> implements lk<Uri, Data> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    public final lk<ek, Data> a;

    /* compiled from: UrlUriLoader.java */
    public static class a implements mk<Uri, InputStream> {
        @Override // dc.mk
        @NonNull
        public lk<Uri, InputStream> b(pk pkVar) {
            return new vk(pkVar.d(ek.class, InputStream.class));
        }
    }

    public vk(lk<ek, Data> lkVar) {
        this.a = lkVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<Data> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        return this.a.b(new ek(uri.toString()), i, i2, ahVar);
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}

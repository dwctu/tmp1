package dc;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.lk;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader.java */
/* loaded from: classes.dex */
public class zk implements lk<Uri, InputStream> {
    public final Context a;

    /* compiled from: MediaStoreVideoThumbLoader.java */
    public static class a implements mk<Uri, InputStream> {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // dc.mk
        @NonNull
        public lk<Uri, InputStream> b(pk pkVar) {
            return new zk(this.a);
        }
    }

    public zk(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // dc.lk
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<InputStream> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        if (vh.d(i, i2) && e(ahVar)) {
            return new lk.a<>(new mp(uri), wh.f(this.a, uri));
        }
        return null;
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return vh.c(uri);
    }

    public final boolean e(ah ahVar) {
        Long l = (Long) ahVar.c(hm.d);
        return l != null && l.longValue() == -1;
    }
}

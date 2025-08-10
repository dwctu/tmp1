package dc;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import dc.lk;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader.java */
/* loaded from: classes.dex */
public class yk implements lk<Uri, InputStream> {
    public final Context a;

    /* compiled from: MediaStoreImageThumbLoader.java */
    public static class a implements mk<Uri, InputStream> {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // dc.mk
        @NonNull
        public lk<Uri, InputStream> b(pk pkVar) {
            return new yk(this.a);
        }
    }

    public yk(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<InputStream> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        if (vh.d(i, i2)) {
            return new lk.a<>(new mp(uri), wh.e(this.a, uri));
        }
        return null;
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return vh.a(uri);
    }
}

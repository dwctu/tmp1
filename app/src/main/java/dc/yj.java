package dc;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import dc.lk;
import java.io.InputStream;

/* compiled from: AssetUriLoader.java */
/* loaded from: classes.dex */
public class yj<Data> implements lk<Uri, Data> {
    public static final int c = 22;
    public final AssetManager a;
    public final a<Data> b;

    /* compiled from: AssetUriLoader.java */
    public interface a<Data> {
        ih<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    public static class b implements mk<Uri, ParcelFileDescriptor>, a<ParcelFileDescriptor> {
        public final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // dc.yj.a
        public ih<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new mh(assetManager, str);
        }

        @Override // dc.mk
        @NonNull
        public lk<Uri, ParcelFileDescriptor> b(pk pkVar) {
            return new yj(this.a, this);
        }
    }

    /* compiled from: AssetUriLoader.java */
    public static class c implements mk<Uri, InputStream>, a<InputStream> {
        public final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // dc.yj.a
        public ih<InputStream> a(AssetManager assetManager, String str) {
            return new sh(assetManager, str);
        }

        @Override // dc.mk
        @NonNull
        public lk<Uri, InputStream> b(pk pkVar) {
            return new yj(this.a, this);
        }
    }

    public yj(AssetManager assetManager, a<Data> aVar) {
        this.a = assetManager;
        this.b = aVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<Data> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(uri), this.b.a(this.a, uri.toString().substring(c)));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}

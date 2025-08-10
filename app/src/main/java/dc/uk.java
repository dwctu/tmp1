package dc;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.lk;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public class uk<Data> implements lk<Uri, Data> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", FirebaseAnalytics.Param.CONTENT)));
    public final c<Data> a;

    /* compiled from: UriLoader.java */
    public static final class a implements mk<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {
        public final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // dc.uk.c
        public ih<AssetFileDescriptor> a(Uri uri) {
            return new fh(this.a, uri);
        }

        @Override // dc.mk
        public lk<Uri, AssetFileDescriptor> b(pk pkVar) {
            return new uk(this);
        }
    }

    /* compiled from: UriLoader.java */
    public static class b implements mk<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {
        public final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // dc.uk.c
        public ih<ParcelFileDescriptor> a(Uri uri) {
            return new nh(this.a, uri);
        }

        @Override // dc.mk
        @NonNull
        public lk<Uri, ParcelFileDescriptor> b(pk pkVar) {
            return new uk(this);
        }
    }

    /* compiled from: UriLoader.java */
    public interface c<Data> {
        ih<Data> a(Uri uri);
    }

    /* compiled from: UriLoader.java */
    public static class d implements mk<Uri, InputStream>, c<InputStream> {
        public final ContentResolver a;

        public d(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // dc.uk.c
        public ih<InputStream> a(Uri uri) {
            return new th(this.a, uri);
        }

        @Override // dc.mk
        @NonNull
        public lk<Uri, InputStream> b(pk pkVar) {
            return new uk(this);
        }
    }

    public uk(c<Data> cVar) {
        this.a = cVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<Data> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(uri), this.a.a(uri));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}

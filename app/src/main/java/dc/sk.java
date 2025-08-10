package dc;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.lk;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class sk<Data> implements lk<String, Data> {
    public final lk<Uri, Data> a;

    /* compiled from: StringLoader.java */
    public static final class a implements mk<String, AssetFileDescriptor> {
        @Override // dc.mk
        public lk<String, AssetFileDescriptor> b(@NonNull pk pkVar) {
            return new sk(pkVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    public static class b implements mk<String, ParcelFileDescriptor> {
        @Override // dc.mk
        @NonNull
        public lk<String, ParcelFileDescriptor> b(@NonNull pk pkVar) {
            return new sk(pkVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    public static class c implements mk<String, InputStream> {
        @Override // dc.mk
        @NonNull
        public lk<String, InputStream> b(@NonNull pk pkVar) {
            return new sk(pkVar.d(Uri.class, InputStream.class));
        }
    }

    public sk(lk<Uri, Data> lkVar) {
        this.a = lkVar;
    }

    @Nullable
    public static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? f(str) : uri;
    }

    public static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<Data> b(@NonNull String str, int i, int i2, @NonNull ah ahVar) {
        Uri uriE = e(str);
        if (uriE == null || !this.a.a(uriE)) {
            return null;
        }
        return this.a.b(uriE, i, i2, ahVar);
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull String str) {
        return true;
    }
}

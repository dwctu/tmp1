package dc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import dc.ih;
import dc.lk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: QMediaStoreUriLoader.java */
@RequiresApi(29)
/* loaded from: classes.dex */
public final class al<DataT> implements lk<Uri, DataT> {
    public final Context a;
    public final lk<File, DataT> b;
    public final lk<Uri, DataT> c;
    public final Class<DataT> d;

    /* compiled from: QMediaStoreUriLoader.java */
    public static abstract class a<DataT> implements mk<Uri, DataT> {
        public final Context a;
        public final Class<DataT> b;

        public a(Context context, Class<DataT> cls) {
            this.a = context;
            this.b = cls;
        }

        @Override // dc.mk
        @NonNull
        public final lk<Uri, DataT> b(@NonNull pk pkVar) {
            return new al(this.a, pkVar.d(File.class, this.b), pkVar.d(Uri.class, this.b), this.b);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    public static final class d<DataT> implements ih<DataT> {
        public static final String[] k = {"_data"};
        public final Context a;
        public final lk<File, DataT> b;
        public final lk<Uri, DataT> c;
        public final Uri d;
        public final int e;
        public final int f;
        public final ah g;
        public final Class<DataT> h;
        public volatile boolean i;

        @Nullable
        public volatile ih<DataT> j;

        public d(Context context, lk<File, DataT> lkVar, lk<Uri, DataT> lkVar2, Uri uri, int i, int i2, ah ahVar, Class<DataT> cls) {
            this.a = context.getApplicationContext();
            this.b = lkVar;
            this.c = lkVar2;
            this.d = uri;
            this.e = i;
            this.f = i2;
            this.g = ahVar;
            this.h = cls;
        }

        @Override // dc.ih
        public void a() {
            ih<DataT> ihVar = this.j;
            if (ihVar != null) {
                ihVar.a();
            }
        }

        @Nullable
        public final lk.a<DataT> b() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.b.b(g(this.d), this.e, this.f, this.g);
            }
            return this.c.b(f() ? MediaStore.setRequireOriginal(this.d) : this.d, this.e, this.f, this.g);
        }

        @Override // dc.ih
        @NonNull
        public sg c() {
            return sg.LOCAL;
        }

        @Override // dc.ih
        public void cancel() {
            this.i = true;
            ih<DataT> ihVar = this.j;
            if (ihVar != null) {
                ihVar.cancel();
            }
        }

        @Override // dc.ih
        public void d(@NonNull of ofVar, @NonNull ih.a<? super DataT> aVar) {
            try {
                ih<DataT> ihVarE = e();
                if (ihVarE == null) {
                    aVar.b(new IllegalArgumentException("Failed to build fetcher for: " + this.d));
                    return;
                }
                this.j = ihVarE;
                if (this.i) {
                    cancel();
                } else {
                    ihVarE.d(ofVar, aVar);
                }
            } catch (FileNotFoundException e) {
                aVar.b(e);
            }
        }

        @Nullable
        public final ih<DataT> e() throws FileNotFoundException {
            lk.a<DataT> aVarB = b();
            if (aVarB != null) {
                return aVarB.c;
            }
            return null;
        }

        public final boolean f() {
            return this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @NonNull
        public final File g(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.a.getContentResolver().query(uri, k, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (TextUtils.isEmpty(string)) {
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                File file = new File(string);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return file;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // dc.ih
        @NonNull
        public Class<DataT> getDataClass() {
            return this.h;
        }
    }

    public al(Context context, lk<File, DataT> lkVar, lk<Uri, DataT> lkVar2, Class<DataT> cls) {
        this.a = context.getApplicationContext();
        this.b = lkVar;
        this.c = lkVar2;
        this.d = cls;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<DataT> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(uri), new d(this.a, this.b, this.c, uri, i, i2, ahVar, this.d));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && vh.b(uri);
    }
}

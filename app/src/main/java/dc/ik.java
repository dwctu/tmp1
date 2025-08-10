package dc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dc.ih;
import dc.lk;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader.java */
/* loaded from: classes.dex */
public final class ik implements lk<Uri, File> {
    public final Context a;

    /* compiled from: MediaStoreFileLoader.java */
    public static final class a implements mk<Uri, File> {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // dc.mk
        @NonNull
        public lk<Uri, File> b(pk pkVar) {
            return new ik(this.a);
        }
    }

    /* compiled from: MediaStoreFileLoader.java */
    public static class b implements ih<File> {
        public static final String[] c = {"_data"};
        public final Context a;
        public final Uri b;

        public b(Context context, Uri uri) {
            this.a = context;
            this.b = uri;
        }

        @Override // dc.ih
        public void a() {
        }

        @Override // dc.ih
        @NonNull
        public sg c() {
            return sg.LOCAL;
        }

        @Override // dc.ih
        public void cancel() {
        }

        @Override // dc.ih
        public void d(@NonNull of ofVar, @NonNull ih.a<? super File> aVar) {
            Cursor cursorQuery = this.a.getContentResolver().query(this.b, c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.e(new File(string));
                return;
            }
            aVar.b(new FileNotFoundException("Failed to find file path for: " + this.b));
        }

        @Override // dc.ih
        @NonNull
        public Class<File> getDataClass() {
            return File.class;
        }
    }

    public ik(Context context) {
        this.a = context;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<File> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(uri), new b(this.a, uri));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return vh.b(uri);
    }
}

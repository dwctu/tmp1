package dc;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import dc.ih;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class wh implements ih<InputStream> {
    public final Uri a;
    public final yh b;
    public InputStream c;

    /* compiled from: ThumbFetcher.java */
    public static class a implements xh {
        public static final String[] b = {"_data"};
        public final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // dc.xh
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    public static class b implements xh {
        public static final String[] b = {"_data"};
        public final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // dc.xh
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    public wh(Uri uri, yh yhVar) {
        this.a = uri;
        this.b = yhVar;
    }

    public static wh b(Context context, Uri uri, xh xhVar) {
        return new wh(uri, new yh(kf.c(context).l().g(), xhVar, kf.c(context).e(), context.getContentResolver()));
    }

    public static wh e(Context context, Uri uri) {
        return b(context, uri, new a(context.getContentResolver()));
    }

    public static wh f(Context context, Uri uri) {
        return b(context, uri, new b(context.getContentResolver()));
    }

    @Override // dc.ih
    public void a() throws IOException {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
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
    public void d(@NonNull of ofVar, @NonNull ih.a<? super InputStream> aVar) throws Throwable {
        try {
            InputStream inputStreamG = g();
            this.c = inputStreamG;
            aVar.e(inputStreamG);
        } catch (FileNotFoundException e) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            aVar.b(e);
        }
    }

    public final InputStream g() throws Throwable {
        InputStream inputStreamD = this.b.d(this.a);
        int iA = inputStreamD != null ? this.b.a(this.a) : -1;
        return iA != -1 ? new lh(inputStreamD, iA) : inputStreamD;
    }

    @Override // dc.ih
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}

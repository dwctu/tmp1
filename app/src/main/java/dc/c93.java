package dc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.google.android.exoplayer2.util.MimeTypes;
import com.j256.ormlite.field.FieldType;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;

/* compiled from: ImageScanner.java */
/* loaded from: classes4.dex */
public class c93 extends b93<MediaFile> {
    public c93(Context context) {
        super(context);
    }

    @Override // dc.b93
    public String a() {
        return "datetaken desc";
    }

    @Override // dc.b93
    public String[] b() {
        return new String[]{"_data", "mime_type", "bucket_id", "bucket_display_name", "datetaken", "date_added", FieldType.FOREIGN_ID_FIELD_SUFFIX};
    }

    @Override // dc.b93
    public Uri c() {
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    @Override // dc.b93
    public String d() {
        return f93.b().e() ? "mime_type=? or mime_type=?" : "mime_type=? or mime_type=? or mime_type=?";
    }

    @Override // dc.b93
    public String[] e() {
        return f93.b().e() ? new String[]{MimeTypes.IMAGE_JPEG, "image/png"} : new String[]{MimeTypes.IMAGE_JPEG, "image/png", "image/gif"};
    }

    @Override // dc.b93
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public MediaFile f(Cursor cursor) {
        MediaFile mediaFile = new MediaFile();
        int columnIndex = cursor.getColumnIndex("_data");
        if (columnIndex >= 0) {
            mediaFile.m(cursor.getString(columnIndex));
        }
        int columnIndex2 = cursor.getColumnIndex("mime_type");
        if (columnIndex2 >= 0) {
            mediaFile.l(cursor.getString(columnIndex2));
        }
        int columnIndex3 = cursor.getColumnIndex("bucket_id");
        if (columnIndex3 >= 0) {
            mediaFile.i(Integer.valueOf(cursor.getInt(columnIndex3)));
        }
        int columnIndex4 = cursor.getColumnIndex("bucket_display_name");
        if (columnIndex4 >= 0) {
            mediaFile.j(cursor.getString(columnIndex4));
        }
        int columnIndex5 = cursor.getColumnIndex("date_added");
        if (columnIndex5 >= 0) {
            mediaFile.g(cursor.getLong(columnIndex5));
        }
        if (cursor.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX) >= 0) {
            mediaFile.k(cursor.getInt(r1));
        }
        return mediaFile;
    }
}

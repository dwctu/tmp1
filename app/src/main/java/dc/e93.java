package dc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.j256.ormlite.field.FieldType;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;

/* compiled from: VideoScanner.java */
/* loaded from: classes4.dex */
public class e93 extends b93<MediaFile> {
    public e93(Context context) {
        super(context);
    }

    @Override // dc.b93
    public String a() {
        return "datetaken desc";
    }

    @Override // dc.b93
    public String[] b() {
        return new String[]{"_data", "mime_type", "bucket_id", "bucket_display_name", TypedValues.TransitionType.S_DURATION, "date_added", "_size", FieldType.FOREIGN_ID_FIELD_SUFFIX};
    }

    @Override // dc.b93
    public Uri c() {
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    @Override // dc.b93
    public String d() {
        return null;
    }

    @Override // dc.b93
    public String[] e() {
        return null;
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
        int columnIndex6 = cursor.getColumnIndex(TypedValues.TransitionType.S_DURATION);
        if (columnIndex6 >= 0) {
            mediaFile.h(cursor.getLong(columnIndex6));
        }
        int columnIndex7 = cursor.getColumnIndex("_size");
        if (columnIndex7 >= 0) {
            mediaFile.n(cursor.getLong(columnIndex7));
        }
        if (cursor.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX) >= 0) {
            mediaFile.k(cursor.getInt(r1));
        }
        return mediaFile;
    }
}

package dc;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: AlbumController.java */
/* loaded from: classes4.dex */
public class mj3 {
    public ContentResolver a;

    public mj3(Context context) {
        this.a = context.getContentResolver();
    }

    public List<rj3> a(String str) {
        Cursor cursorQuery = this.a.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"bucket_display_name", "_data", "date_added", "_size"}, "bucket_display_name = ?", new String[]{str}, "date_added");
        if (cursorQuery == null || !cursorQuery.moveToNext()) {
            if (cursorQuery != null) {
            }
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery.moveToLast();
            do {
                if (cursorQuery.getLong(cursorQuery.getColumnIndex("_size")) > 10240) {
                    rj3 rj3Var = new rj3();
                    rj3Var.c(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                    arrayList.add(rj3Var);
                }
            } while (cursorQuery.moveToPrevious());
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    public List<nj3> b() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        Cursor cursorQuery = this.a.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "bucket_display_name", "_size"}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToNext()) {
            if (cursorQuery != null) {
            }
            return new ArrayList();
        }
        cursorQuery.moveToLast();
        nj3 nj3Var = new nj3("最近照片", 0, cursorQuery.getString(cursorQuery.getColumnIndex("_data")), true);
        arrayList.add(nj3Var);
        do {
            try {
                if (cursorQuery.getInt(cursorQuery.getColumnIndex("_size")) >= 10240) {
                    nj3Var.d();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                    if (map.keySet().contains(string)) {
                        ((nj3) map.get(string)).d();
                    } else {
                        nj3 nj3Var2 = new nj3(string, 1, cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                        map.put(string, nj3Var2);
                        arrayList.add(nj3Var2);
                    }
                }
            } finally {
                cursorQuery.close();
            }
        } while (cursorQuery.moveToPrevious());
        return arrayList;
    }

    public List<rj3> c() {
        Cursor cursorQuery = this.a.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "date_added", "_size"}, null, null, "date_added");
        if (cursorQuery == null || !cursorQuery.moveToNext()) {
            if (cursorQuery != null) {
            }
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery.moveToLast();
            do {
                if (cursorQuery.getLong(cursorQuery.getColumnIndex("_size")) > 10240) {
                    rj3 rj3Var = new rj3();
                    rj3Var.c(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                    arrayList.add(rj3Var);
                }
            } while (cursorQuery.moveToPrevious());
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }
}

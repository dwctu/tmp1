package dc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;

/* compiled from: AbsMediaScanner.java */
/* loaded from: classes4.dex */
public abstract class b93<T> {
    public Context a;

    public b93(Context context) {
        this.a = context;
    }

    public abstract String a();

    public abstract String[] b();

    public abstract Uri c();

    public abstract String d();

    public abstract String[] e();

    public abstract T f(Cursor cursor);

    public ArrayList<T> g() {
        ArrayList<T> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.a.getContentResolver().query(c(), b(), d(), e(), a());
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(f(cursorQuery));
            }
            cursorQuery.close();
        }
        return arrayList;
    }
}

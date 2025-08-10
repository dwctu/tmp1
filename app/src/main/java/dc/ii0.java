package dc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.github.gzuliyujiang.oaid.OAIDException;
import java.util.Objects;

/* compiled from: MeizuImpl.java */
/* loaded from: classes.dex */
public class ii0 implements wh0 {
    public final Context a;

    public ii0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e) {
            xh0.a(e);
            return false;
        }
    }

    @Override // dc.wh0
    public void b(vh0 vh0Var) {
        if (this.a == null || vh0Var == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                xh0.a("OAID query success: " + string);
                vh0Var.a(string);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
            }
        } catch (Exception e) {
            xh0.a(e);
            vh0Var.b(e);
        }
    }
}

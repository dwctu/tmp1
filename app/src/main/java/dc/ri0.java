package dc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.github.gzuliyujiang.oaid.OAIDException;
import java.util.Objects;

/* compiled from: VivoImpl.java */
/* loaded from: classes.dex */
public class ri0 implements wh0 {
    public final Context a;

    public ri0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return yh0.t("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // dc.wh0
    public void b(vh0 vh0Var) {
        if (this.a == null || vh0Var == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
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

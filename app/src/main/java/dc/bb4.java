package dc;

import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: DefaultDatabaseErrorHandler.java */
/* loaded from: classes5.dex */
public final class bb4 implements ya4 {
    public final String a = bb4.class.getSimpleName();

    @Override // dc.ya4
    public void a(SQLiteDatabase sQLiteDatabase) {
        String str = "Corruption reported by sqlite on database, deleting: " + sQLiteDatabase.getPath();
        if (sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            }
        }
        b(sQLiteDatabase.getPath());
    }

    public final void b(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        String str2 = "deleting the database file: " + str;
        try {
            new File(str).delete();
        } catch (Exception e) {
            String str3 = "delete failed: " + e.getMessage();
        }
    }
}

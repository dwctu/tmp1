package dc;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;

/* compiled from: SQLCipherUtils.java */
/* loaded from: classes.dex */
public class dx {

    /* compiled from: SQLCipherUtils.java */
    public enum a {
        DOES_NOT_EXIST,
        UNENCRYPTED,
        ENCRYPTED
    }

    public static void a(Context context, File file, byte[] bArr) throws Throwable {
        SQLiteDatabase.l0(context);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath() + " not found");
        }
        File fileCreateTempFile = File.createTempFile("sqlcipherutils", "tmp", context.getCacheDir());
        SQLiteDatabase sQLiteDatabaseR0 = SQLiteDatabase.r0(file.getAbsolutePath(), "", null, 0);
        int version = sQLiteDatabaseR0.getVersion();
        sQLiteDatabaseR0.close();
        SQLiteDatabase sQLiteDatabaseU0 = SQLiteDatabase.u0(fileCreateTempFile.getAbsolutePath(), bArr, null, 0, null, null);
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabaseU0.compileStatement("ATTACH DATABASE ? AS plaintext KEY ''");
        sQLiteStatementCompileStatement.bindString(1, file.getAbsolutePath());
        sQLiteStatementCompileStatement.execute();
        sQLiteDatabaseU0.z0("SELECT sqlcipher_export('main', 'plaintext')");
        sQLiteDatabaseU0.z0("DETACH DATABASE plaintext");
        sQLiteDatabaseU0.setVersion(version);
        sQLiteStatementCompileStatement.close();
        sQLiteDatabaseU0.close();
        file.delete();
        fileCreateTempFile.renameTo(file);
    }

    public static a b(File file) {
        if (!file.exists()) {
            return a.DOES_NOT_EXIST;
        }
        SQLiteDatabase sQLiteDatabaseR0 = null;
        try {
            try {
                sQLiteDatabaseR0 = SQLiteDatabase.r0(file.getAbsolutePath(), "", null, 1);
                sQLiteDatabaseR0.getVersion();
                a aVar = a.UNENCRYPTED;
                if (sQLiteDatabaseR0 != null) {
                    sQLiteDatabaseR0.close();
                }
                return aVar;
            } catch (Exception unused) {
                a aVar2 = a.ENCRYPTED;
                if (sQLiteDatabaseR0 != null) {
                    sQLiteDatabaseR0.close();
                }
                return aVar2;
            }
        } catch (Throwable th) {
            if (sQLiteDatabaseR0 != null) {
                sQLiteDatabaseR0.close();
            }
            throw th;
        }
    }
}

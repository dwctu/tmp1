package dc;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteQuery;
import net.sqlcipher.database.SQLiteStatement;

/* compiled from: SQLiteClosable.java */
/* loaded from: classes5.dex */
public abstract class cb4 {
    public int a = 1;
    public Object b = new Object();

    public void b() {
        synchronized (this.b) {
            int i = this.a;
            if (i <= 0) {
                throw new IllegalStateException("attempt to re-open an already-closed object: " + e());
            }
            this.a = i + 1;
        }
    }

    public final String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" (");
        if (this instanceof SQLiteDatabase) {
            sb.append("database = ");
            sb.append(((SQLiteDatabase) this).getPath());
        } else if ((this instanceof SQLiteProgram) || (this instanceof SQLiteStatement) || (this instanceof SQLiteQuery)) {
            sb.append("mSql = ");
            sb.append(((SQLiteProgram) this).d);
        }
        sb.append(") ");
        return sb.toString();
    }

    public abstract void f();

    public void j() {
    }

    public void m() {
        synchronized (this.b) {
            int i = this.a - 1;
            this.a = i;
            if (i == 0) {
                f();
            }
        }
    }
}

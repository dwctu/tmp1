package dc;

import android.database.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteQuery;

/* compiled from: SQLiteDirectCursorDriver.java */
/* loaded from: classes5.dex */
public class gb4 implements eb4 {
    public String a;
    public SQLiteDatabase b;
    public va4 c;
    public String d;

    public gb4(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        this.b = sQLiteDatabase;
        this.a = str2;
        this.d = str;
    }

    @Override // dc.eb4
    public void a() {
    }

    @Override // dc.eb4
    public va4 b(SQLiteDatabase.f fVar, String[] strArr) {
        int length;
        int i = 0;
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.b, this.d, 0, strArr);
        if (strArr == null) {
            length = 0;
        } else {
            try {
                length = strArr.length;
            } catch (Throwable th) {
                if (sQLiteQuery != null) {
                    sQLiteQuery.close();
                }
                throw th;
            }
        }
        while (i < length) {
            int i2 = i + 1;
            sQLiteQuery.bindString(i2, strArr[i]);
            i = i2;
        }
        if (fVar == null) {
            this.c = new db4(this.b, this, this.a, sQLiteQuery);
        } else {
            this.c = fVar.a(this.b, this, this.a, sQLiteQuery);
        }
        sQLiteQuery = null;
        return this.c;
    }

    @Override // dc.eb4
    public void c() {
        this.c = null;
    }

    @Override // dc.eb4
    public void d(Cursor cursor) {
    }

    public va4 e(SQLiteDatabase.f fVar, Object[] objArr) {
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.b, this.d, 0, objArr);
        try {
            sQLiteQuery.q(objArr);
            if (fVar == null) {
                this.c = new db4(this.b, this, this.a, sQLiteQuery);
            } else {
                this.c = fVar.a(this.b, this, this.a, sQLiteQuery);
            }
            sQLiteQuery = null;
            return this.c;
        } catch (Throwable th) {
            if (sQLiteQuery != null) {
                sQLiteQuery.close();
            }
            throw th;
        }
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.d;
    }
}

package dc;

import android.content.Context;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: SQLiteOpenHelper.java */
/* loaded from: classes5.dex */
public abstract class hb4 {
    public final Context a;
    public final String b;
    public final SQLiteDatabase.f c;
    public final int d;
    public final fb4 e;
    public final ya4 f;
    public boolean g;
    public boolean h;
    public SQLiteDatabase i;
    public boolean j;

    public hb4(Context context, String str, SQLiteDatabase.f fVar, int i, fb4 fb4Var) {
        this(context, str, fVar, i, fb4Var, new bb4());
    }

    public synchronized void a() {
        if (this.j) {
            throw new IllegalStateException("Closed during initialization");
        }
        SQLiteDatabase sQLiteDatabase = this.i;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.i.close();
            this.i = null;
        }
    }

    public String b() {
        return this.b;
    }

    public synchronized SQLiteDatabase c(byte[] bArr) {
        SQLiteDatabase sQLiteDatabaseY0;
        SQLiteDatabase sQLiteDatabase = this.i;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.i.isReadOnly()) {
            return this.i;
        }
        if (this.j) {
            throw new IllegalStateException("getWritableDatabase called recursively");
        }
        SQLiteDatabase sQLiteDatabase2 = this.i;
        if (sQLiteDatabase2 != null) {
            sQLiteDatabase2.o0();
        }
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
            this.j = true;
            String str = this.b;
            if (str == null) {
                sQLiteDatabaseY0 = SQLiteDatabase.X(null, "");
            } else {
                String path = this.a.getDatabasePath(str).getPath();
                File file = new File(path);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                sQLiteDatabaseY0 = SQLiteDatabase.y0(path, bArr, this.c, this.e, this.f);
            }
            sQLiteDatabase3 = sQLiteDatabaseY0;
            if (this.h) {
                this.g = sQLiteDatabase3.enableWriteAheadLogging();
            }
            d(sQLiteDatabase3);
            int version = sQLiteDatabase3.getVersion();
            if (version != this.d) {
                sQLiteDatabase3.beginTransaction();
                try {
                    if (version == 0) {
                        e(sQLiteDatabase3);
                    } else {
                        int i = this.d;
                        if (version > i) {
                            f(sQLiteDatabase3, version, i);
                        } else {
                            h(sQLiteDatabase3, version, i);
                        }
                    }
                    sQLiteDatabase3.setVersion(this.d);
                    sQLiteDatabase3.setTransactionSuccessful();
                    sQLiteDatabase3.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabase3.endTransaction();
                    throw th;
                }
            }
            g(sQLiteDatabase3);
            this.j = false;
            SQLiteDatabase sQLiteDatabase4 = this.i;
            if (sQLiteDatabase4 != null) {
                try {
                    sQLiteDatabase4.close();
                } catch (Exception unused) {
                }
                this.i.E0();
            }
            this.i = sQLiteDatabase3;
            return sQLiteDatabase3;
        } catch (Throwable th2) {
            this.j = false;
            SQLiteDatabase sQLiteDatabase5 = this.i;
            if (sQLiteDatabase5 != null) {
                sQLiteDatabase5.E0();
            }
            if (sQLiteDatabase3 != null) {
                sQLiteDatabase3.close();
            }
            throw th2;
        }
    }

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void e(SQLiteDatabase sQLiteDatabase);

    public abstract void f(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public abstract void g(SQLiteDatabase sQLiteDatabase);

    public abstract void h(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public void i(boolean z) {
        synchronized (this) {
            if (this.g != z) {
                SQLiteDatabase sQLiteDatabase = this.i;
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || this.i.isReadOnly()) {
                    this.h = z;
                } else {
                    if (z) {
                        this.i.enableWriteAheadLogging();
                    } else {
                        this.i.disableWriteAheadLogging();
                    }
                    this.g = z;
                }
            }
        }
    }

    public hb4(Context context, String str, SQLiteDatabase.f fVar, int i, fb4 fb4Var, ya4 ya4Var) {
        this.i = null;
        this.j = false;
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        if (ya4Var == null) {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        }
        this.a = context;
        this.b = str;
        this.c = fVar;
        this.d = i;
        this.e = fb4Var;
        this.f = ya4Var;
    }
}

package net.sqlcipher.database;

import android.os.SystemClock;
import net.sqlcipher.CursorWindow;

/* loaded from: classes5.dex */
public class SQLiteQuery extends SQLiteProgram {
    public int g;
    public String[] h;
    public Object[] i;

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i, String[] strArr) {
        super(sQLiteDatabase, str);
        this.g = i;
        this.h = strArr;
    }

    private final native int native_column_count();

    private final native String native_column_name(int i);

    private final native int native_fill_window(CursorWindow cursorWindow, int i, int i2, int i3, int i4, int i5);

    public int A(CursorWindow cursorWindow, int i, int i2) {
        int iNative_fill_window;
        SystemClock.uptimeMillis();
        this.c.o0();
        try {
            b();
            try {
                try {
                    cursorWindow.acquireReference();
                    iNative_fill_window = native_fill_window(cursorWindow, cursorWindow.getStartPosition(), cursorWindow.b(), this.g, i, i2);
                    if (SQLiteDebug.a) {
                        String str = "fillWindow(): " + this.d;
                    }
                } catch (IllegalStateException unused) {
                    iNative_fill_window = 0;
                } catch (SQLiteDatabaseCorruptException e) {
                    this.c.q0();
                    throw e;
                }
                return iNative_fill_window;
            } finally {
                cursorWindow.releaseReference();
            }
        } finally {
            m();
            this.c.E0();
        }
    }

    public void C() {
        String[] strArr = this.h;
        if (strArr != null) {
            int length = strArr.length;
            try {
                Object[] objArr = this.i;
                if (objArr != null) {
                    q(objArr);
                    return;
                }
                int i = 0;
                while (i < length) {
                    int i2 = i + 1;
                    super.bindString(i2, this.h[i]);
                    i = i2;
                }
            } catch (SQLiteMisuseException e) {
                StringBuilder sb = new StringBuilder("mSql " + this.d);
                for (int i3 = 0; i3 < length; i3++) {
                    sb.append(" ");
                    sb.append(this.h[i3]);
                }
                sb.append(" ");
                throw new IllegalStateException(sb.toString(), e);
            }
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        this.h[i - 1] = Double.toString(d);
        if (this.f) {
            return;
        }
        super.bindDouble(i, d);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.h[i - 1] = Long.toString(j);
        if (this.f) {
            return;
        }
        super.bindLong(i, j);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.h[i - 1] = null;
        if (this.f) {
            return;
        }
        super.bindNull(i);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        this.h[i - 1] = str;
        if (this.f) {
            return;
        }
        super.bindString(i, str);
    }

    public void q(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                bindNull(i + 1);
            } else if (obj instanceof Double) {
                bindDouble(i + 1, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                bindDouble(i + 1, Double.valueOf(((Number) obj).floatValue()).doubleValue());
            } else if (obj instanceof Long) {
                bindLong(i + 1, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                bindLong(i + 1, Long.valueOf(((Number) obj).intValue()).longValue());
            } else if (obj instanceof Boolean) {
                bindLong(i + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else if (obj instanceof byte[]) {
                bindBlob(i + 1, (byte[]) obj);
            } else {
                bindString(i + 1, obj.toString());
            }
        }
    }

    public String toString() {
        return "SQLiteQuery: " + this.d;
    }

    public int x() {
        b();
        try {
            return native_column_count();
        } finally {
            m();
        }
    }

    public String y(int i) {
        b();
        try {
            return native_column_name(i);
        } finally {
            m();
        }
    }

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i, Object[] objArr) {
        super(sQLiteDatabase, str);
        this.g = i;
        this.i = objArr;
        this.h = new String[objArr != null ? objArr.length : 0];
    }
}

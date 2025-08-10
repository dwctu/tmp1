package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteProgram;
import com.koushikdutta.async.http.AsyncHttpDelete;
import dc.cb4;

/* loaded from: classes5.dex */
public abstract class SQLiteProgram extends cb4 implements SupportSQLiteProgram {

    @Deprecated
    public SQLiteDatabase c;
    public final String d;
    public SQLiteCompiledSql e;
    public boolean f = false;

    public SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str) {
        this.c = sQLiteDatabase;
        String strTrim = str.trim();
        this.d = strTrim;
        sQLiteDatabase.b();
        sQLiteDatabase.x(this);
        long j = sQLiteDatabase.j;
        strTrim = strTrim.length() >= 6 ? strTrim.substring(0, 6) : strTrim;
        if (!strTrim.equalsIgnoreCase("INSERT") && !strTrim.equalsIgnoreCase("UPDATE") && !strTrim.equalsIgnoreCase("REPLAC") && !strTrim.equalsIgnoreCase(AsyncHttpDelete.METHOD) && !strTrim.equalsIgnoreCase("SELECT")) {
            this.e = new SQLiteCompiledSql(sQLiteDatabase, str);
            return;
        }
        SQLiteCompiledSql sQLiteCompiledSqlG0 = sQLiteDatabase.g0(str);
        this.e = sQLiteCompiledSqlG0;
        if (sQLiteCompiledSqlG0 == null) {
            SQLiteCompiledSql sQLiteCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.e = sQLiteCompiledSql;
            sQLiteCompiledSql.a();
            sQLiteDatabase.y(str, this.e);
            if (SQLiteDebug.d) {
                String str2 = "Created DbObj (id#" + this.e.b + ") for sql: " + str;
            }
        } else if (!sQLiteCompiledSqlG0.a()) {
            long j2 = this.e.b;
            this.e = new SQLiteCompiledSql(sQLiteDatabase, str);
            if (SQLiteDebug.d) {
                String str3 = "** possible bug ** Created NEW DbObj (id#" + this.e.b + ") because the previously created DbObj (id#" + j2 + ") was not released for sql:" + str;
            }
        }
        long j3 = this.e.b;
    }

    private final native void native_clear_bindings();

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        }
        if (this.f) {
            throw new IllegalStateException("program already closed");
        }
        if (this.c.isOpen()) {
            b();
            try {
                native_bind_blob(i, bArr);
                return;
            } finally {
                m();
            }
        }
        throw new IllegalStateException("database " + this.c.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        if (this.f) {
            throw new IllegalStateException("program already closed");
        }
        if (this.c.isOpen()) {
            b();
            try {
                native_bind_double(i, d);
                return;
            } finally {
                m();
            }
        }
        throw new IllegalStateException("database " + this.c.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        if (this.f) {
            throw new IllegalStateException("program already closed");
        }
        if (this.c.isOpen()) {
            b();
            try {
                native_bind_long(i, j);
                return;
            } finally {
                m();
            }
        }
        throw new IllegalStateException("database " + this.c.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        if (this.f) {
            throw new IllegalStateException("program already closed");
        }
        if (this.c.isOpen()) {
            b();
            try {
                native_bind_null(i);
                return;
            } finally {
                m();
            }
        }
        throw new IllegalStateException("database " + this.c.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        }
        if (this.f) {
            throw new IllegalStateException("program already closed");
        }
        if (this.c.isOpen()) {
            b();
            try {
                native_bind_string(i, str);
                return;
            } finally {
                m();
            }
        }
        throw new IllegalStateException("database " + this.c.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        if (this.f) {
            throw new IllegalStateException("program already closed");
        }
        if (this.c.isOpen()) {
            b();
            try {
                native_clear_bindings();
                return;
            } finally {
                m();
            }
        }
        throw new IllegalStateException("database " + this.c.getPath() + " already closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f && this.c.isOpen()) {
            this.c.o0();
            try {
                m();
                this.c.E0();
                this.f = true;
            } catch (Throwable th) {
                this.c.E0();
                throw th;
            }
        }
    }

    @Override // dc.cb4
    public void f() {
        p();
        this.c.m();
        this.c.D0(this);
    }

    @Override // dc.cb4
    public void j() {
        p();
        this.c.m();
    }

    public final native void native_bind_blob(int i, byte[] bArr);

    public final native void native_bind_double(int i, double d);

    public final native void native_bind_long(int i, long j);

    public final native void native_bind_null(int i);

    public final native void native_bind_string(int i, String str);

    @Deprecated
    public final native void native_compile(String str);

    @Deprecated
    public final native void native_finalize();

    public final void p() {
        if (this.e == null) {
            return;
        }
        synchronized (this.c.o) {
            if (this.c.o.containsValue(this.e)) {
                this.e.c();
            } else {
                this.e.d();
                this.e = null;
            }
        }
    }
}

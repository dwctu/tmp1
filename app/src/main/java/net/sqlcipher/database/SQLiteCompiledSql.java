package net.sqlcipher.database;

/* loaded from: classes5.dex */
public class SQLiteCompiledSql {
    public SQLiteDatabase a;
    public long b = 0;
    public boolean c = false;

    public SQLiteCompiledSql(SQLiteDatabase sQLiteDatabase, String str) {
        if (sQLiteDatabase.isOpen()) {
            this.a = sQLiteDatabase;
            long j = sQLiteDatabase.j;
            b(str, true);
        } else {
            throw new IllegalStateException("database " + sQLiteDatabase.getPath() + " already closed");
        }
    }

    private final native void native_compile(String str);

    private final native void native_finalize();

    public synchronized boolean a() {
        if (this.c) {
            return false;
        }
        this.c = true;
        if (SQLiteDebug.d) {
            String str = "Acquired DbObj (id#" + this.b + ") from DB cache";
        }
        return true;
    }

    public final void b(String str, boolean z) {
        if (!this.a.isOpen()) {
            throw new IllegalStateException("database " + this.a.getPath() + " already closed");
        }
        if (z) {
            this.a.o0();
            try {
                native_compile(str);
            } finally {
                this.a.E0();
            }
        }
    }

    public synchronized void c() {
        if (SQLiteDebug.d) {
            String str = "Released DbObj (id#" + this.b + ") back to DB cache";
        }
        this.c = false;
    }

    public void d() {
        if (this.b != 0) {
            if (SQLiteDebug.d) {
                String str = "closed and deallocated DbObj (id#" + this.b + ")";
            }
            native_finalize();
            this.b = 0L;
        }
    }

    public void finalize() throws Throwable {
        try {
            if (this.b == 0) {
                return;
            }
            if (SQLiteDebug.d) {
                String str = "** warning ** Finalized DbObj (id#" + this.b + ")";
            }
            d();
        } finally {
            super.finalize();
        }
    }
}

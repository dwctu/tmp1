package net.sqlcipher.database;

import android.os.SystemClock;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes5.dex */
public class SQLiteStatement extends SQLiteProgram implements SupportSQLiteStatement {
    public SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
        super(sQLiteDatabase, str);
    }

    private final native long native_1x1_long();

    private final native String native_1x1_string();

    private final native void native_execute();

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        if (!this.c.isOpen()) {
            throw new IllegalStateException("database " + this.c.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.c.o0();
        b();
        try {
            native_execute();
        } finally {
            m();
            this.c.E0();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        if (!this.c.isOpen()) {
            throw new IllegalStateException("database " + this.c.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.c.o0();
        b();
        try {
            native_execute();
            return this.c.lastChangeCount() > 0 ? this.c.lastInsertRow() : -1L;
        } finally {
            m();
            this.c.E0();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        if (!this.c.isOpen()) {
            throw new IllegalStateException("database " + this.c.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.c.o0();
        b();
        try {
            native_execute();
            return this.c.lastChangeCount();
        } finally {
            m();
            this.c.E0();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        if (!this.c.isOpen()) {
            throw new IllegalStateException("database " + this.c.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.c.o0();
        b();
        try {
            return native_1x1_long();
        } finally {
            m();
            this.c.E0();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        if (!this.c.isOpen()) {
            throw new IllegalStateException("database " + this.c.getPath() + " already closed");
        }
        SystemClock.uptimeMillis();
        this.c.o0();
        b();
        try {
            return native_1x1_string();
        } finally {
            m();
            this.c.E0();
        }
    }
}

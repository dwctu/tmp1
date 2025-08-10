package dc;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import com.j256.ormlite.field.FieldType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.database.DatabaseObjectNotClosedException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDebug;
import net.sqlcipher.database.SQLiteQuery;

/* compiled from: SQLiteCursor.java */
/* loaded from: classes5.dex */
public class db4 extends ta4 {
    public a B;
    public String[] o;
    public SQLiteQuery p;
    public SQLiteDatabase q;
    public eb4 r;
    public Map<String, Integer> v;
    public int s = -1;
    public int t = 0;
    public boolean u = false;
    public int w = Integer.MAX_VALUE;
    public int x = Integer.MAX_VALUE;
    public int y = 0;
    public ReentrantLock z = null;
    public boolean A = false;

    /* compiled from: SQLiteCursor.java */
    public static class a extends Handler {
        public final WeakReference<db4> a;

        public a(db4 db4Var) {
            this.a = new WeakReference<>(db4Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            db4 db4Var = this.a.get();
            if (db4Var != null) {
                db4Var.p();
            }
        }
    }

    /* compiled from: SQLiteCursor.java */
    public final class b implements Runnable {
        public final int a;

        public b(int i) {
            this.a = i;
        }

        public final void a() {
            db4 db4Var = db4.this;
            a aVar = db4Var.B;
            if (aVar == null) {
                db4Var.A = true;
            } else {
                aVar.sendEmptyMessage(1);
                db4.this.A = false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0070, code lost:
        
            r4.b.s = r1;
            a();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.SecurityException, java.lang.IllegalArgumentException {
            /*
                r4 = this;
                dc.db4 r0 = dc.db4.this
                net.sqlcipher.CursorWindow r0 = dc.db4.y(r0)
                int r1 = android.os.Process.myTid()
                r2 = 10
                android.os.Process.setThreadPriority(r1, r2)
            Lf:
                dc.db4 r1 = dc.db4.this
                java.util.concurrent.locks.ReentrantLock r1 = dc.db4.A(r1)
                if (r1 != 0) goto L22
                dc.db4 r1 = dc.db4.this
                java.util.concurrent.locks.ReentrantLock r2 = new java.util.concurrent.locks.ReentrantLock
                r3 = 1
                r2.<init>(r3)
                dc.db4.C(r1, r2)
            L22:
                dc.db4 r1 = dc.db4.this
                java.util.concurrent.locks.ReentrantLock r1 = dc.db4.A(r1)
                r1.lock()
                dc.db4 r1 = dc.db4.this
                int r1 = dc.db4.I(r1)
                int r2 = r4.a
                if (r1 == r2) goto L3f
                dc.db4 r0 = dc.db4.this
                java.util.concurrent.locks.ReentrantLock r0 = dc.db4.A(r0)
                r0.unlock()
                goto L8d
            L3f:
                dc.db4 r1 = dc.db4.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                net.sqlcipher.database.SQLiteQuery r1 = dc.db4.X(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                dc.db4 r2 = dc.db4.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r2 = dc.db4.K(r2)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                dc.db4 r3 = dc.db4.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r3 = dc.db4.L(r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r1 = r1.A(r0, r2, r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                if (r1 == 0) goto L84
                r2 = -1
                if (r1 != r2) goto L70
                dc.db4 r1 = dc.db4.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r2 = dc.db4.K(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                dc.db4.V(r1, r2)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                r4.a()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                dc.db4 r1 = dc.db4.this
                java.util.concurrent.locks.ReentrantLock r1 = dc.db4.A(r1)
                r1.unlock()
                goto Lf
            L70:
                dc.db4 r0 = dc.db4.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                dc.db4.O(r0, r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                r4.a()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                goto L84
            L79:
                r0 = move-exception
                dc.db4 r1 = dc.db4.this
                java.util.concurrent.locks.ReentrantLock r1 = dc.db4.A(r1)
                r1.unlock()
                throw r0
            L84:
                dc.db4 r0 = dc.db4.this
                java.util.concurrent.locks.ReentrantLock r0 = dc.db4.A(r0)
                r0.unlock()
            L8d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.db4.b.run():void");
        }
    }

    public db4(SQLiteDatabase sQLiteDatabase, eb4 eb4Var, String str, SQLiteQuery sQLiteQuery) {
        new DatabaseObjectNotClosedException().fillInStackTrace();
        this.q = sQLiteDatabase;
        this.r = eb4Var;
        this.v = null;
        this.p = sQLiteQuery;
        try {
            sQLiteDatabase.o0();
            int iX = this.p.x();
            this.o = new String[iX];
            for (int i = 0; i < iX; i++) {
                String strY = this.p.y(i);
                this.o[i] = strY;
                if (FieldType.FOREIGN_ID_FIELD_SUFFIX.equals(strY)) {
                    this.e = i;
                }
            }
        } finally {
            sQLiteDatabase.E0();
        }
    }

    public static /* synthetic */ int V(db4 db4Var, int i) {
        int i2 = db4Var.s + i;
        db4Var.s = i2;
        return i2;
    }

    @Override // dc.sa4, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        e0();
        this.p.close();
        this.r.c();
    }

    public int d0(int i, int i2) {
        return Math.max(i - (i2 / 3), 0);
    }

    @Override // dc.sa4, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        e0();
        this.r.a();
    }

    public final void e0() {
        this.y = 0;
        CursorWindow cursorWindow = this.n;
        if (cursorWindow != null) {
            cursorWindow.close();
            this.n = null;
        }
    }

    public final void f0(int i) {
        if (this.n == null) {
            this.n = new CursorWindow(true);
        } else {
            this.y++;
            g0();
            try {
                this.n.clear();
            } finally {
                h0();
            }
        }
        int iD0 = this.u ? i : this.s == -1 ? d0(i, 0) : d0(i, this.t);
        this.n.setStartPosition(iD0);
        this.n.e(i);
        this.s = this.p.A(this.n, this.x, 0);
        if (this.t == 0) {
            this.t = this.n.getNumRows();
        }
        if (this.s == -1) {
            this.s = iD0 + this.x;
            new Thread(new b(this.y), "query thread").start();
        }
    }

    @Override // dc.sa4, android.database.CrossProcessCursor
    public void fillWindow(int i, android.database.CursorWindow cursorWindow) {
        if (this.n == null) {
            this.n = new CursorWindow(true);
        } else {
            this.y++;
            g0();
            try {
                this.n.clear();
            } finally {
                h0();
            }
        }
        int iD0 = this.u ? i : this.s == -1 ? d0(i, 0) : d0(i, this.t);
        this.n.setStartPosition(iD0);
        this.n.e(i);
        this.s = this.p.A(this.n, this.x, 0);
        if (this.t == 0) {
            this.t = this.n.getNumRows();
        }
        if (this.s == -1) {
            this.s = iD0 + this.x;
            new Thread(new b(this.y), "query thread").start();
        }
    }

    @Override // dc.sa4
    public void finalize() {
        try {
            if (this.n != null) {
                this.p.d.length();
                close();
                SQLiteDebug.a();
            }
        } finally {
            super.finalize();
        }
    }

    public final void g0() {
        ReentrantLock reentrantLock = this.z;
        if (reentrantLock != null) {
            reentrantLock.lock();
        }
    }

    @Override // dc.sa4, android.database.Cursor
    public int getColumnIndex(String str) {
        if (this.v == null) {
            String[] strArr = this.o;
            int length = strArr.length;
            HashMap map = new HashMap(length, 1.0f);
            for (int i = 0; i < length; i++) {
                map.put(strArr[i], Integer.valueOf(i));
            }
            this.v = map;
        }
        if (str.lastIndexOf(46) != -1) {
            new Exception();
        }
        Integer num = this.v.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // dc.sa4, android.database.Cursor
    public String[] getColumnNames() {
        return this.o;
    }

    @Override // dc.sa4, android.database.Cursor
    public int getCount() {
        if (this.s == -1) {
            f0(0);
        }
        return this.s;
    }

    public final void h0() {
        ReentrantLock reentrantLock = this.z;
        if (reentrantLock != null) {
            reentrantLock.unlock();
        }
    }

    @Override // dc.sa4, android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        CursorWindow cursorWindow = this.n;
        if (cursorWindow != null && i2 >= cursorWindow.getStartPosition() && i2 < this.n.getStartPosition() + this.n.getNumRows()) {
            return true;
        }
        f0(i2);
        return true;
    }

    @Override // dc.sa4, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        if (!(Integer.MAX_VALUE == this.w && Integer.MAX_VALUE == this.x) && this.B == null) {
            g0();
            try {
                this.B = new a(this);
                if (this.A) {
                    p();
                    this.A = false;
                }
            } finally {
                h0();
            }
        }
    }

    @Override // dc.sa4, android.database.Cursor
    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.q.o0();
        try {
            CursorWindow cursorWindow = this.n;
            if (cursorWindow != null) {
                cursorWindow.clear();
            }
            this.f = -1;
            this.r.d(this);
            this.s = -1;
            this.y++;
            g0();
            try {
                this.p.C();
                this.q.E0();
                return super.requery();
            } finally {
                h0();
            }
        } catch (Throwable th) {
            this.q.E0();
            throw th;
        }
    }
}

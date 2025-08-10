package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import dc.cb4;
import dc.db4;
import dc.eb4;
import dc.fb4;
import dc.gb4;
import dc.ib4;
import dc.o6;
import dc.ua4;
import dc.va4;
import dc.ya4;
import dc.za4;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import net.sqlcipher.SQLException;
import org.apache.commons.codec.net.RFC1522Codec;
import org.bouncycastle.crypto.tls.CipherSuite;

/* loaded from: classes5.dex */
public class SQLiteDatabase extends cb4 implements SupportSQLiteDatabase {
    public static WeakHashMap<SQLiteDatabase, Object> w = new WeakHashMap<>();
    public static final String[] x = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public boolean c;
    public boolean d;
    public ib4 e;
    public String k;
    public int l;
    public f m;
    public WeakHashMap<cb4, Object> n;
    public int q;
    public final ya4 r;
    public int s;
    public int t;
    public final int u;
    public final ReentrantLock f = new ReentrantLock(true);
    public long g = 0;
    public long h = 0;
    public long i = 0;
    public long j = 0;
    public Map<String, SQLiteCompiledSql> o = new HashMap();
    public int p = 250;
    public boolean v = true;

    public class a implements g {
        @Override // net.sqlcipher.database.SQLiteDatabase.g
        public void a(String... strArr) {
            for (String str : strArr) {
                System.loadLibrary(str);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ byte[] a;

        public b(byte[] bArr) {
            this.a = bArr;
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            byte[] bArr = this.a;
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            SQLiteDatabase.this.key(bArr);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ char[] b;

        public c(byte[] bArr, char[] cArr) {
            this.a = bArr;
            this.b = cArr;
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            if (this.a != null) {
                SQLiteDatabase.this.key_mutf8(this.b);
            }
        }
    }

    public class d implements ib4 {
        public final /* synthetic */ SQLiteTransactionListener a;

        public d(SQLiteTransactionListener sQLiteTransactionListener) {
            this.a = sQLiteTransactionListener;
        }

        @Override // dc.ib4
        public void a() {
            this.a.onCommit();
        }

        @Override // dc.ib4
        public void b() {
            this.a.onBegin();
        }

        @Override // dc.ib4
        public void c() {
            this.a.onRollback();
        }
    }

    public class e implements ib4 {
        public final /* synthetic */ SQLiteTransactionListener a;

        public e(SQLiteTransactionListener sQLiteTransactionListener) {
            this.a = sQLiteTransactionListener;
        }

        @Override // dc.ib4
        public void a() {
            this.a.onCommit();
        }

        @Override // dc.ib4
        public void b() {
            this.a.onBegin();
        }

        @Override // dc.ib4
        public void c() {
            this.a.onRollback();
        }
    }

    public interface f {
        va4 a(SQLiteDatabase sQLiteDatabase, eb4 eb4Var, String str, SQLiteQuery sQLiteQuery);
    }

    public interface g {
        void a(String... strArr);
    }

    public enum h {
        Deferred,
        Immediate,
        Exclusive
    }

    static {
        Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    }

    public SQLiteDatabase(String str, f fVar, int i, ya4 ya4Var) {
        new HashMap();
        if (str == null) {
            throw new IllegalArgumentException("path should not be null");
        }
        this.l = i;
        this.k = str;
        this.u = -1;
        new DatabaseObjectNotClosedException().fillInStackTrace();
        this.m = fVar;
        this.n = new WeakHashMap<>();
        this.r = ya4Var;
    }

    public static SQLiteDatabase X(f fVar, String str) {
        return v0(":memory:", str == null ? null : str.toCharArray(), fVar, 268435456);
    }

    public static ArrayList<Pair<String, String>> d0(SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            return null;
        }
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        va4 va4VarB0 = sQLiteDatabase.B0("pragma database_list;", null);
        while (va4VarB0.moveToNext()) {
            arrayList.add(new Pair<>(va4VarB0.getString(1), va4VarB0.getString(2)));
        }
        va4VarB0.close();
        return arrayList;
    }

    private native void dbclose();

    private native void dbopen(String str, int i);

    public static byte[] e0(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        ByteBuffer byteBufferEncode = Charset.forName("UTF-8").encode(CharBuffer.wrap(cArr));
        byte[] bArr = new byte[byteBufferEncode.limit()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    public static char[] f0(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        CharBuffer charBufferDecode = Charset.forName("UTF-8").decode(ByteBuffer.wrap(bArr));
        char[] cArr = new char[charBufferDecode.limit()];
        charBufferDecode.get(cArr);
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void key(byte[] bArr) throws SQLException;

    /* JADX INFO: Access modifiers changed from: private */
    public native void key_mutf8(char[] cArr) throws SQLException;

    public static synchronized void l0(Context context) {
        m0(context, context.getFilesDir());
    }

    public static synchronized void m0(Context context, File file) {
        n0(context, file, new a());
    }

    public static synchronized void n0(Context context, File file, g gVar) {
        gVar.a("sqlcipher");
    }

    private native int native_getDbLookaside();

    private native void native_rawExecSQL(String str);

    private native int native_status(int i, boolean z);

    public static SQLiteDatabase r0(String str, String str2, f fVar, int i) {
        return s0(str, str2, fVar, i, null);
    }

    private native void rekey(byte[] bArr) throws SQLException;

    public static native int releaseMemory();

    public static SQLiteDatabase s0(String str, String str2, f fVar, int i, fb4 fb4Var) {
        return t0(str, str2, fVar, i, fb4Var, null);
    }

    public static native void setICURoot(String str);

    public static SQLiteDatabase t0(String str, String str2, f fVar, int i, fb4 fb4Var, ya4 ya4Var) {
        return w0(str, str2 == null ? null : str2.toCharArray(), fVar, i, fb4Var, ya4Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static net.sqlcipher.database.SQLiteDatabase u0(java.lang.String r2, byte[] r3, net.sqlcipher.database.SQLiteDatabase.f r4, int r5, dc.fb4 r6, dc.ya4 r7) throws java.lang.Throwable {
        /*
            if (r7 == 0) goto L3
            goto L8
        L3:
            dc.bb4 r7 = new dc.bb4
            r7.<init>()
        L8:
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L12
            r1.<init>(r2, r4, r5, r7)     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L12
            r1.x0(r3, r6)     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L13
            goto L1e
        L12:
            r1 = r0
        L13:
            r7.a(r1)
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase
            r1.<init>(r2, r4, r5, r7)
            r1.x0(r3, r6)
        L1e:
            boolean r3 = net.sqlcipher.database.SQLiteDebug.a
            if (r3 == 0) goto L25
            r1.enableSqlTracing(r2)
        L25:
            boolean r3 = net.sqlcipher.database.SQLiteDebug.b
            if (r3 == 0) goto L2c
            r1.enableSqlProfiling(r2)
        L2c:
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r2 = net.sqlcipher.database.SQLiteDatabase.w
            monitor-enter(r2)
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r3 = net.sqlcipher.database.SQLiteDatabase.w     // Catch: java.lang.Throwable -> L36
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            return r1
        L36:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.u0(java.lang.String, byte[], net.sqlcipher.database.SQLiteDatabase$f, int, dc.fb4, dc.ya4):net.sqlcipher.database.SQLiteDatabase");
    }

    public static SQLiteDatabase v0(String str, char[] cArr, f fVar, int i) {
        return w0(str, cArr, fVar, i, null, null);
    }

    public static SQLiteDatabase w0(String str, char[] cArr, f fVar, int i, fb4 fb4Var, ya4 ya4Var) {
        return u0(str, e0(cArr), fVar, i, fb4Var, ya4Var);
    }

    public static SQLiteDatabase y0(String str, byte[] bArr, f fVar, fb4 fb4Var, ya4 ya4Var) {
        return u0(str, bArr, fVar, 268435456, fb4Var, ya4Var);
    }

    public void A(ib4 ib4Var) {
        C(ib4Var, h.Exclusive);
    }

    /* JADX WARN: Finally extract failed */
    public va4 A0(String str, Object[] objArr) {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        long jCurrentTimeMillis = this.u != -1 ? System.currentTimeMillis() : 0L;
        gb4 gb4Var = new gb4(this, str, null);
        try {
            va4 va4VarE = gb4Var.e(this.m, objArr);
            if (this.u != -1) {
                int count = va4VarE != null ? va4VarE.getCount() : -1;
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (jCurrentTimeMillis2 >= this.u) {
                    String str2 = "query (" + jCurrentTimeMillis2 + " ms): " + gb4Var.toString() + ", args are <redacted>, count is " + count;
                }
            }
            return new ua4(va4VarE);
        } catch (Throwable th) {
            if (this.u != -1) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (jCurrentTimeMillis3 >= this.u) {
                    String str3 = "query (" + jCurrentTimeMillis3 + " ms): " + gb4Var.toString() + ", args are <redacted>, count is -1";
                }
            }
            throw th;
        }
    }

    public va4 B0(String str, String[] strArr) {
        return C0(null, str, strArr, null);
    }

    public final void C(ib4 ib4Var, h hVar) {
        p0();
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        try {
            if (this.f.getHoldCount() > 1) {
                if (this.c) {
                    throw new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                }
                return;
            }
            if (hVar == h.Exclusive) {
                execSQL("BEGIN EXCLUSIVE;");
            } else if (hVar == h.Immediate) {
                execSQL("BEGIN IMMEDIATE;");
            } else {
                if (hVar != h.Deferred) {
                    throw new IllegalArgumentException(String.format("%s is an unsupported transaction type", hVar));
                }
                execSQL("BEGIN DEFERRED;");
            }
            this.e = ib4Var;
            this.d = true;
            this.c = false;
            if (ib4Var != null) {
                try {
                    ib4Var.b();
                } catch (RuntimeException e2) {
                    execSQL("ROLLBACK;");
                    throw e2;
                }
            }
        } catch (Throwable th) {
            F0();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    public va4 C0(f fVar, String str, String[] strArr, String str2) {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        long jCurrentTimeMillis = this.u != -1 ? System.currentTimeMillis() : 0L;
        gb4 gb4Var = new gb4(this, str, str2);
        if (fVar == null) {
            try {
                fVar = this.m;
            } catch (Throwable th) {
                if (this.u != -1) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (jCurrentTimeMillis2 >= this.u) {
                        String str3 = "query (" + jCurrentTimeMillis2 + " ms): " + gb4Var.toString() + ", args are <redacted>, count is -1";
                    }
                }
                throw th;
            }
        }
        va4 va4VarB = gb4Var.b(fVar, strArr);
        if (this.u != -1) {
            int count = va4VarB != null ? va4VarB.getCount() : -1;
            long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (jCurrentTimeMillis3 >= this.u) {
                String str4 = "query (" + jCurrentTimeMillis3 + " ms): " + gb4Var.toString() + ", args are <redacted>, count is " + count;
            }
        }
        return new ua4(va4VarB);
    }

    public void D0(cb4 cb4Var) {
        o0();
        try {
            this.n.remove(cb4Var);
        } finally {
            E0();
        }
    }

    public void E0() {
        if (this.v) {
            if (SQLiteDebug.e && this.f.getHoldCount() == 1) {
                K();
            }
            this.f.unlock();
        }
    }

    public final void F0() {
        if (SQLiteDebug.e && this.f.getHoldCount() == 1) {
            K();
        }
        this.f.unlock();
    }

    public int G0(String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("UPDATE ");
        sb.append(x[i]);
        sb.append(str);
        sb.append(" SET ");
        Set<Map.Entry<String, Object>> setValueSet = contentValues.valueSet();
        Iterator<Map.Entry<String, Object>> it = setValueSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getKey());
            sb.append(RFC1522Codec.PREFIX);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        AutoCloseable autoCloseable = null;
        o0();
        try {
            try {
                try {
                    if (!isOpen()) {
                        throw new IllegalStateException("database not open");
                    }
                    SQLiteStatement sQLiteStatementCompileStatement = compileStatement(sb.toString());
                    int size = setValueSet.size();
                    Iterator<Map.Entry<String, Object>> it2 = setValueSet.iterator();
                    int i2 = 1;
                    for (int i3 = 0; i3 < size; i3++) {
                        za4.a(sQLiteStatementCompileStatement, i2, it2.next().getValue());
                        i2++;
                    }
                    if (strArr != null) {
                        for (String str3 : strArr) {
                            sQLiteStatementCompileStatement.bindString(i2, str3);
                            i2++;
                        }
                    }
                    sQLiteStatementCompileStatement.execute();
                    int iLastChangeCount = lastChangeCount();
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    E0();
                    return iLastChangeCount;
                } catch (SQLiteDatabaseCorruptException e2) {
                    q0();
                    throw e2;
                }
            } catch (SQLException e3) {
                throw e3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            E0();
            throw th;
        }
    }

    public final boolean H0(boolean z, long j) throws InterruptedException {
        if (this.f.getQueueLength() == 0) {
            this.g = SystemClock.elapsedRealtime();
            this.h = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        ib4 ib4Var = this.e;
        endTransaction();
        if (z && isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
        }
        if (j > 0) {
            while (j > 0) {
                try {
                    Thread.sleep(j < 1000 ? j : 1000L);
                } catch (InterruptedException unused) {
                    Thread.interrupted();
                }
                j -= 1000;
                if (this.f.getQueueLength() == 0) {
                    break;
                }
            }
        }
        A(ib4Var);
        return true;
    }

    public void I(ib4 ib4Var) {
        C(ib4Var, h.Immediate);
    }

    public final void K() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.g;
        if ((j >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || Log.isLoggable("Database", 2) || jElapsedRealtime - this.i >= SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) && j > 300) {
            int iThreadCpuTimeNanos = (int) ((Debug.threadCpuTimeNanos() - this.h) / 1000000);
            if (iThreadCpuTimeNanos > 100 || j > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                this.i = jElapsedRealtime;
                String str = "lock held on " + this.k + " for " + j + "ms. Thread time was " + iThreadCpuTimeNanos + "ms";
                boolean z = SQLiteDebug.f;
            }
        }
    }

    public final void L() {
        b0();
        Iterator<Map.Entry<cb4, Object>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            cb4 key = it.next().getKey();
            if (key != null) {
                key.j();
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public SQLiteStatement compileStatement(String str) throws SQLException {
        o0();
        try {
            if (isOpen()) {
                return new SQLiteStatement(this, str);
            }
            throw new IllegalStateException("database not open");
        } finally {
            E0();
        }
    }

    public final boolean V(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == 0) {
                return true;
            }
        }
        return false;
    }

    public final void b0() {
        synchronized (this.o) {
            Iterator<SQLiteCompiledSql> it = this.o.values().iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.o.clear();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        A(null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        C(null, h.Immediate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        A(new d(sQLiteTransactionListener));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        I(new e(sQLiteTransactionListener));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (isOpen()) {
            o0();
            try {
                L();
                f();
            } finally {
                E0();
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String str, String str2, Object[] objArr) {
        String str3;
        o0();
        AutoCloseable autoCloseable = null;
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("DELETE FROM ");
                sb.append(str);
                if (TextUtils.isEmpty(str2)) {
                    str3 = "";
                } else {
                    str3 = " WHERE " + str2;
                }
                sb.append(str3);
                SQLiteStatement sQLiteStatementCompileStatement = compileStatement(sb.toString());
                if (objArr != null) {
                    int length = objArr.length;
                    int i = 0;
                    while (i < length) {
                        int i2 = i + 1;
                        za4.a(sQLiteStatementCompileStatement, i2, objArr[i]);
                        i = i2;
                    }
                }
                sQLiteStatementCompileStatement.execute();
                int iLastChangeCount = lastChangeCount();
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                E0();
                return iLastChangeCount;
            } catch (SQLiteDatabaseCorruptException e2) {
                q0();
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            E0();
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        if (inTransaction()) {
            throw new IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
        }
        z0("PRAGMA journal_mode = DELETE;");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        if (inTransaction()) {
            throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
        }
        ArrayList<Pair<String, String>> arrayListD0 = d0(this);
        if ((arrayListD0 != null && arrayListD0.size() > 1) || isReadOnly() || getPath().equals(":memory:")) {
            return false;
        }
        z0("PRAGMA journal_mode = WAL;");
        return true;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        if (!this.f.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        }
        try {
            if (this.c) {
                this.c = false;
            } else {
                this.d = false;
            }
            if (this.f.getHoldCount() != 1) {
                return;
            }
            ib4 ib4Var = this.e;
            if (ib4Var != null) {
                try {
                    if (this.d) {
                        ib4Var.a();
                    } else {
                        ib4Var.c();
                    }
                    e = null;
                } catch (RuntimeException e2) {
                    e = e2;
                    this.d = false;
                }
            } else {
                e = null;
            }
            if (this.d) {
                execSQL("COMMIT;");
            } else {
                try {
                    execSQL("ROLLBACK;");
                    if (e != null) {
                        throw e;
                    }
                } catch (SQLException unused) {
                }
            }
        } finally {
            this.e = null;
            F0();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
        o6.$default$execPerConnectionSQL(this, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str) throws SQLException {
        SystemClock.uptimeMillis();
        o0();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                native_execSQL(str);
            } catch (SQLiteDatabaseCorruptException e2) {
                q0();
                throw e2;
            }
        } finally {
            E0();
        }
    }

    @Override // dc.cb4
    public void f() {
        if (isOpen()) {
            if (SQLiteDebug.c) {
                i0();
            }
            dbclose();
            synchronized (w) {
                w.remove(this);
            }
        }
    }

    public void finalize() {
        if (isOpen()) {
            L();
            f();
        }
    }

    public SQLiteCompiledSql g0(String str) {
        synchronized (this.o) {
            if (this.p == 0) {
                boolean z = SQLiteDebug.c;
                return null;
            }
            SQLiteCompiledSql sQLiteCompiledSql = this.o.get(str);
            boolean z2 = sQLiteCompiledSql != null;
            if (z2) {
                this.s++;
            } else {
                this.t++;
            }
            boolean z3 = SQLiteDebug.c;
            return sQLiteCompiledSql;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return d0(this);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() throws Throwable {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        o0();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            sQLiteStatement = new SQLiteStatement(this, "PRAGMA max_page_count;");
            try {
                long jSimpleQueryForLong = sQLiteStatement.simpleQueryForLong() * getPageSize();
                sQLiteStatement.close();
                E0();
                return jSimpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                E0();
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() throws Throwable {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        o0();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            sQLiteStatement = new SQLiteStatement(this, "PRAGMA page_size;");
            try {
                long jSimpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                E0();
                return jSimpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                E0();
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        return this.k;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() throws Throwable {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        o0();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            sQLiteStatement = new SQLiteStatement(this, "PRAGMA user_version;");
            try {
                int iSimpleQueryForLong = (int) sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                E0();
                return iSimpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                E0();
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    public final Pair<Boolean, String> h0(String str) {
        Pair<Boolean, String> pair = new Pair<>(Boolean.FALSE, "");
        va4 va4VarA0 = A0(str, new Object[0]);
        if (va4VarA0 == null) {
            return pair;
        }
        if (va4VarA0.moveToFirst()) {
            pair = new Pair<>(Boolean.TRUE, va4VarA0.getString(0));
        }
        va4VarA0.close();
        return pair;
    }

    public final String i0() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.f.getHoldCount() > 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String str, int i, ContentValues contentValues) throws android.database.SQLException {
        return j0(str, null, contentValues, i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        Pair<Boolean, String> pairH0 = h0("PRAGMA integrity_check;");
        return ((Boolean) pairH0.first).booleanValue() ? ((String) pairH0.second).equals("ok") : ((Boolean) pairH0.first).booleanValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.f.isHeldByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return o6.$default$isExecPerConnectionSQLSupported(this);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.j != 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return (this.l & 1) == 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        Pair<Boolean, String> pairH0 = h0("PRAGMA journal_mode;");
        return ((Boolean) pairH0.first).booleanValue() ? ((String) pairH0.second).equals("wal") : ((Boolean) pairH0.first).booleanValue();
    }

    public long j0(String str, String str2, ContentValues contentValues, int i) {
        Set<Map.Entry<String, Object>> setValueSet;
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        StringBuilder sb = new StringBuilder(CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA);
        sb.append("INSERT");
        sb.append(x[i]);
        sb.append(" INTO ");
        sb.append(str);
        StringBuilder sb2 = new StringBuilder(40);
        int i2 = 0;
        SQLiteStatement sQLiteStatementCompileStatement = null;
        if (contentValues == null || contentValues.size() <= 0) {
            sb.append("(" + str2 + ") ");
            sb2.append("NULL");
            setValueSet = null;
        } else {
            setValueSet = contentValues.valueSet();
            Iterator<Map.Entry<String, Object>> it = setValueSet.iterator();
            sb.append('(');
            boolean z = false;
            while (it.hasNext()) {
                if (z) {
                    sb.append(", ");
                    sb2.append(", ");
                }
                sb.append(it.next().getKey());
                sb2.append(RFC1522Codec.SEP);
                z = true;
            }
            sb.append(')');
        }
        sb.append(" VALUES(");
        sb.append((CharSequence) sb2);
        sb.append(");");
        o0();
        try {
            try {
                sQLiteStatementCompileStatement = compileStatement(sb.toString());
                if (setValueSet != null) {
                    int size = setValueSet.size();
                    Iterator<Map.Entry<String, Object>> it2 = setValueSet.iterator();
                    while (i2 < size) {
                        i2++;
                        za4.a(sQLiteStatementCompileStatement, i2, it2.next().getValue());
                    }
                }
                sQLiteStatementCompileStatement.execute();
                return lastChangeCount() > 0 ? lastInsertRow() : -1L;
            } catch (SQLiteDatabaseCorruptException e2) {
                q0();
                throw e2;
            }
        } finally {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            E0();
        }
    }

    public final void k0(fb4 fb4Var, Runnable runnable) {
        if (fb4Var != null) {
            fb4Var.b(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        if (fb4Var != null) {
            fb4Var.a(this);
        }
        if (SQLiteDebug.c) {
            i0();
        }
        try {
            va4 va4VarB0 = B0("select count(*) from sqlite_master;", new String[0]);
            if (va4VarB0 != null) {
                va4VarB0.moveToFirst();
                va4VarB0.getInt(0);
                va4VarB0.close();
            }
        } catch (RuntimeException e2) {
            throw e2;
        }
    }

    public native int lastChangeCount();

    public native long lastInsertRow();

    public native void native_execSQL(String str) throws SQLException;

    public native void native_setLocale(String str, int i);

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i) {
        return i > getVersion();
    }

    public void o0() {
        if (this.v) {
            this.f.lock();
            if (SQLiteDebug.e && this.f.getHoldCount() == 1) {
                this.g = SystemClock.elapsedRealtime();
                this.h = Debug.threadCpuTimeNanos();
            }
        }
    }

    public final void p0() {
        this.f.lock();
        if (SQLiteDebug.e && this.f.getHoldCount() == 1) {
            this.g = SystemClock.elapsedRealtime();
            this.h = Debug.threadCpuTimeNanos();
        }
    }

    public void q0() {
        this.r.a(this);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str) {
        return B0(str, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z) throws SQLException {
        if (inTransaction()) {
            throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
        }
        Object[] objArr = new Object[1];
        objArr[0] = z ? "ON" : "OFF";
        execSQL(String.format("PRAGMA foreign_keys = %s;", objArr));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        o0();
        try {
            native_setLocale(locale.toString(), this.l);
        } finally {
            E0();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public synchronized void setMaxSqlCacheSize(int i) {
        if (i > 250 || i < 0) {
            throw new IllegalStateException("expected value between 0 and 250");
        }
        if (i < this.p) {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        }
        this.p = i;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j) throws Throwable {
        o0();
        SQLiteStatement sQLiteStatement = null;
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            long pageSize = getPageSize();
            long j2 = j / pageSize;
            if (j % pageSize != 0) {
                j2++;
            }
            SQLiteStatement sQLiteStatement2 = new SQLiteStatement(this, "PRAGMA max_page_count = " + j2);
            try {
                long jSimpleQueryForLong = sQLiteStatement2.simpleQueryForLong() * pageSize;
                sQLiteStatement2.close();
                E0();
                return jSimpleQueryForLong;
            } catch (Throwable th) {
                th = th;
                sQLiteStatement = sQLiteStatement2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                E0();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j) throws SQLException {
        execSQL("PRAGMA page_size = " + j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        if (!this.f.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        }
        if (this.c) {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        }
        this.c = true;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i) throws SQLException {
        execSQL("PRAGMA user_version = " + i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        String[] strArr = new String[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            strArr[i2] = objArr[i2].toString();
        }
        return G0(str, contentValues, str2, strArr, i);
    }

    public void x(cb4 cb4Var) {
        o0();
        try {
            this.n.put(cb4Var, null);
        } finally {
            E0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x0(byte[] r6, dc.fb4 r7) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = r5.k
            int r1 = r5.l
            r5.dbopen(r0, r1)
            r0 = 0
            r1 = 1
            net.sqlcipher.database.SQLiteDatabase$b r2 = new net.sqlcipher.database.SQLiteDatabase$b     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L15
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L15
            r5.k0(r7, r2)     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L15
            goto L3b
        L12:
            r6 = move-exception
            r0 = 1
            goto L3d
        L15:
            r2 = move-exception
            char[] r3 = f0(r6)     // Catch: java.lang.Throwable -> L12
            boolean r4 = r5.V(r3)     // Catch: java.lang.Throwable -> L12
            if (r4 == 0) goto L3c
            net.sqlcipher.database.SQLiteDatabase$c r2 = new net.sqlcipher.database.SQLiteDatabase$c     // Catch: java.lang.Throwable -> L12
            r2.<init>(r6, r3)     // Catch: java.lang.Throwable -> L12
            r5.k0(r7, r2)     // Catch: java.lang.Throwable -> L12
            if (r6 == 0) goto L30
            int r7 = r6.length     // Catch: java.lang.Throwable -> L12
            if (r7 <= 0) goto L30
            r5.rekey(r6)     // Catch: java.lang.Throwable -> L12
        L30:
            if (r3 == 0) goto L3b
            int r6 = r3.length     // Catch: java.lang.Throwable -> L39
            if (r6 <= 0) goto L3b
            java.util.Arrays.fill(r3, r0)     // Catch: java.lang.Throwable -> L39
            goto L3b
        L39:
            r6 = move-exception
            goto L3d
        L3b:
            return
        L3c:
            throw r2     // Catch: java.lang.Throwable -> L12
        L3d:
            if (r0 == 0) goto L49
            r5.dbclose()
            boolean r7 = net.sqlcipher.database.SQLiteDebug.c
            if (r7 == 0) goto L49
            r5.i0()
        L49:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.x0(byte[], dc.fb4):void");
    }

    public void y(String str, SQLiteCompiledSql sQLiteCompiledSql) {
        if (this.p == 0) {
            boolean z = SQLiteDebug.c;
            return;
        }
        synchronized (this.o) {
            if (this.o.get(str) != null) {
                return;
            }
            if (this.o.size() == this.p) {
                this.q++;
            } else {
                this.o.put(str, sQLiteCompiledSql);
                boolean z2 = SQLiteDebug.c;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        if (isOpen()) {
            return H0(true, -1L);
        }
        return false;
    }

    public void z0(String str) {
        SystemClock.uptimeMillis();
        o0();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                native_rawExecSQL(str);
            } catch (SQLiteDatabaseCorruptException e2) {
                q0();
                throw e2;
            }
        } finally {
            E0();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str, Object[] objArr) {
        return A0(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j) {
        if (isOpen()) {
            return H0(true, j);
        }
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        String sql = supportSQLiteQuery.getSql();
        Object[] objArr = new Object[supportSQLiteQuery.getArgCount()];
        gb4 gb4Var = new gb4(this, sql, null);
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this, sql, 0, objArr);
        supportSQLiteQuery.bindTo(sQLiteQuery);
        return new ua4(new db4(this, gb4Var, null, sQLiteQuery));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr != null) {
            SystemClock.uptimeMillis();
            o0();
            AutoCloseable autoCloseable = null;
            try {
                try {
                    if (isOpen()) {
                        SQLiteStatement sQLiteStatementCompileStatement = compileStatement(str);
                        if (objArr != null) {
                            int length = objArr.length;
                            int i = 0;
                            while (i < length) {
                                int i2 = i + 1;
                                za4.a(sQLiteStatementCompileStatement, i2, objArr[i]);
                                i = i2;
                            }
                        }
                        sQLiteStatementCompileStatement.execute();
                        if (sQLiteStatementCompileStatement != null) {
                            sQLiteStatementCompileStatement.close();
                        }
                        E0();
                        return;
                    }
                    throw new IllegalStateException("database not open");
                } catch (SQLiteDatabaseCorruptException e2) {
                    q0();
                    throw e2;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    autoCloseable.close();
                }
                E0();
                throw th;
            }
        }
        throw new IllegalArgumentException("Empty bindArgs");
    }
}

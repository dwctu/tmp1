package io.agora.utils;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.text.TextUtils;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.Logging;
import java.io.File;

/* loaded from: classes4.dex */
public class SqliteWrapper {
    private static final String TAG = "SQLITE";
    private final Object lock = new Object();
    private SQLiteDatabase db = null;

    public static class StorageItem {
        public long actualSize;
        public byte[] data;
        public long expired;

        public StorageItem() {
            this.data = null;
            this.actualSize = 0L;
            this.expired = 0L;
        }

        public StorageItem(byte[] bArr, long j, long j2) {
            this.data = bArr;
            this.actualSize = j;
            this.expired = j2;
        }

        @CalledByNative("StorageItem")
        public long getActualSize() {
            return this.actualSize;
        }

        @CalledByNative("StorageItem")
        public byte[] getData() {
            return this.data;
        }

        @CalledByNative("StorageItem")
        public long getExpired() {
            return this.expired;
        }
    }

    @CalledByNative
    public SqliteWrapper() {
    }

    private boolean executeCommandOnPath(String str, String str2) {
        if (!isDatabaseValid() || !isPathValid(str)) {
            return false;
        }
        synchronized (this.lock) {
            try {
                try {
                    this.db.execSQL(str2);
                } catch (Exception unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    private boolean isDatabaseValid() {
        SQLiteDatabase sQLiteDatabase = this.db;
        return (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || this.db.isReadOnly()) ? false : true;
    }

    private boolean isPathValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\'' || cCharAt == ';') {
                return false;
            }
        }
        return !str.toLowerCase().contains("sqlite_master");
    }

    @CalledByNative
    public void close() {
        if (isDatabaseValid()) {
            synchronized (this.lock) {
                this.db.close();
                this.db = null;
            }
        }
    }

    @CalledByNative
    public boolean delete(String str, String str2) {
        if (!isDatabaseValid() || !isPathValid(str) || !isPathValid(str2)) {
            return false;
        }
        synchronized (this.lock) {
            try {
                this.db.execSQL("delete from \"" + str + "\" where key = \"" + str2 + "\";");
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    @CalledByNative
    public void dispose() {
        synchronized (this.lock) {
            SQLiteDatabase sQLiteDatabase = this.db;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.db.close();
            }
            this.db = null;
        }
    }

    @CalledByNative
    public boolean drop(String str) {
        return executeCommandOnPath(str, "drop table if exists \"" + str + "\";");
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @io.agora.base.internal.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.agora.utils.SqliteWrapper.StorageItem load(java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            r9 = this;
            boolean r12 = r9.isDatabaseValid()
            if (r12 != 0) goto L13
            java.lang.String r10 = "SQLITE"
            java.lang.String r11 = "database is invalid"
            io.agora.base.internal.Logging.w(r10, r11)
            io.agora.utils.SqliteWrapper$StorageItem r10 = new io.agora.utils.SqliteWrapper$StorageItem
            r10.<init>()
            return r10
        L13:
            boolean r12 = android.text.TextUtils.isEmpty(r10)
            if (r12 == 0) goto L26
            java.lang.String r10 = "SQLITE"
            java.lang.String r11 = "query is invalid"
            io.agora.base.internal.Logging.w(r10, r11)
            io.agora.utils.SqliteWrapper$StorageItem r10 = new io.agora.utils.SqliteWrapper$StorageItem
            r10.<init>()
            return r10
        L26:
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 == 0) goto L39
            java.lang.String r10 = "SQLITE"
            java.lang.String r11 = "cmd is invalid"
            io.agora.base.internal.Logging.w(r10, r11)
            io.agora.utils.SqliteWrapper$StorageItem r10 = new io.agora.utils.SqliteWrapper$StorageItem
            r10.<init>()
            return r10
        L39:
            java.lang.Object r12 = r9.lock
            monitor-enter(r12)
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r3 = r9.db     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r4 = 0
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            android.database.Cursor r10 = r3.rawQuery(r10, r5)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r3 = 1
            if (r10 == 0) goto L59
            int r5 = r10.getCount()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            if (r5 <= 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = 0
        L54:
            r10.close()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            r10 = r0
            goto L5a
        L59:
            r5 = 0
        L5a:
            if (r5 != 0) goto L64
            java.lang.String r11 = "SQLITE"
            java.lang.String r3 = "table is not exist"
            io.agora.base.internal.Logging.w(r11, r3)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            goto L99
        L64:
            android.database.sqlite.SQLiteDatabase r5 = r9.db     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            android.database.Cursor r10 = r5.rawQuery(r11, r4)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            boolean r11 = r10.isClosed()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            if (r11 != 0) goto L99
            boolean r11 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            if (r11 == 0) goto L99
            int r11 = r10.getCount()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            if (r11 == r3) goto L7f
            goto L99
        L7f:
            byte[] r0 = r10.getBlob(r3)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            r11 = 2
            long r3 = r10.getLong(r11)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            int r11 = r0.length     // Catch: java.lang.Throwable -> L96
            r5 = 524288(0x80000, float:7.34684E-40)
            if (r11 <= r5) goto L91
            r5 = 524288(0x80000, double:2.590327E-318)
            goto L93
        L91:
            int r11 = r0.length     // Catch: java.lang.Throwable -> L96
            long r5 = (long) r11
        L93:
            r7 = r3
            r4 = r0
            goto L9c
        L96:
            r10 = move-exception
            goto Lc0
        L98:
            r10 = r0
        L99:
            r4 = r0
            r5 = r1
            r7 = r5
        L9c:
            if (r10 == 0) goto La9
            r10.close()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> La2
            goto La9
        La2:
            java.lang.String r10 = "SQLITE"
            java.lang.String r11 = "cursor close exception"
            io.agora.base.internal.Logging.w(r10, r11)     // Catch: java.lang.Throwable -> L96
        La9:
            int r10 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r10 == 0) goto Lb9
            int r10 = r4.length     // Catch: java.lang.Throwable -> L96
            if (r10 != 0) goto Lb1
            goto Lb9
        Lb1:
            io.agora.utils.SqliteWrapper$StorageItem r10 = new io.agora.utils.SqliteWrapper$StorageItem     // Catch: java.lang.Throwable -> L96
            r3 = r10
            r3.<init>(r4, r5, r7)     // Catch: java.lang.Throwable -> L96
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L96
            return r10
        Lb9:
            io.agora.utils.SqliteWrapper$StorageItem r10 = new io.agora.utils.SqliteWrapper$StorageItem     // Catch: java.lang.Throwable -> L96
            r10.<init>()     // Catch: java.lang.Throwable -> L96
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L96
            return r10
        Lc0:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L96
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.utils.SqliteWrapper.load(java.lang.String, java.lang.String, boolean):io.agora.utils.SqliteWrapper$StorageItem");
    }

    @CalledByNative
    public boolean open(String str) {
        SQLiteDatabase sQLiteDatabaseOpenDatabase;
        if (!isPathValid(str)) {
            return false;
        }
        synchronized (this.lock) {
            try {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        SQLiteDatabase.OpenParams.Builder builder = new SQLiteDatabase.OpenParams.Builder();
                        builder.setOpenFlags(268435456);
                        builder.setJournalMode("off");
                        sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(new File(str), builder.build());
                    } else {
                        sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(str, null, 268435456);
                    }
                    this.db = sQLiteDatabaseOpenDatabase;
                    try {
                        this.db.execSQL("PRAGMA TEMP_STORE = MEMORY;");
                        this.db.execSQL("PRAGMA SYNCHRONOUS = OFF;");
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (this.db.isOpen()) {
                            this.db.close();
                        }
                        this.db = null;
                        Logging.d(TAG, "Can not open database: " + str);
                        return false;
                    }
                } catch (Exception unused) {
                    SQLiteDatabase sQLiteDatabase = this.db;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        this.db.close();
                    }
                    this.db = null;
                    Logging.d(TAG, "Can not open database: " + str);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @CalledByNative
    public long save(String str, String str2, byte[] bArr, long j) {
        long length = 0;
        if (!isPathValid(str) || !isPathValid(str2) || bArr == null || bArr.length == 0 || bArr.length >= 524288 || !touch(str)) {
            return 0L;
        }
        synchronized (this.lock) {
            String str3 = "replace into \"" + str + "\" (key, value, expired) values (\"" + str2 + "\", ?, " + j + ");";
            SQLiteStatement sQLiteStatementCompileStatement = null;
            this.db.beginTransaction();
            try {
                sQLiteStatementCompileStatement = this.db.compileStatement(str3);
                sQLiteStatementCompileStatement.bindBlob(1, bArr);
                sQLiteStatementCompileStatement.execute();
                length = bArr.length;
            } catch (Exception unused) {
            }
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return length;
    }

    @CalledByNative
    public boolean touch(String str) {
        return executeCommandOnPath(str, "create table if not exists \"" + str + "\" (key text primary key, value text, expired INTEGER);");
    }
}

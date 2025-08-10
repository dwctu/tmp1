package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.broadcom.bt.map.FolderInfo;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.SQLException;
import java.sql.Savepoint;

/* loaded from: classes3.dex */
public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String ANDROID_VERSION = "VERSION__4.48__";
    private final boolean cancelQueriesEnabled;
    private final SQLiteDatabase db;
    private final boolean readWrite;
    private static Logger logger = LoggerFactory.getLogger((Class<?>) AndroidDatabaseConnection.class);
    private static final String[] NO_STRING_ARGS = new String[0];

    /* renamed from: com.j256.ormlite.android.AndroidDatabaseConnection$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public static class OurSavePoint implements Savepoint {
        private String name;

        public OurSavePoint(String str) {
            this.name = str;
        }

        @Override // java.sql.Savepoint
        public int getSavepointId() {
            return 0;
        }

        @Override // java.sql.Savepoint
        public String getSavepointName() {
            return this.name;
        }
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions(ANDROID_VERSION);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this(sQLiteDatabase, z, false);
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr == null) {
            return;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                sQLiteStatement.bindNull(i + 1);
            } else {
                SqlType sqlType = fieldTypeArr[i].getSqlType();
                switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        sQLiteStatement.bindString(i + 1, obj.toString());
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        sQLiteStatement.bindLong(i + 1, ((Number) obj).longValue());
                        break;
                    case 9:
                    case 10:
                        sQLiteStatement.bindDouble(i + 1, ((Number) obj).doubleValue());
                        break;
                    case 11:
                    case 12:
                        sQLiteStatement.bindBlob(i + 1, (byte[]) obj);
                        break;
                    case 13:
                    case 14:
                    case 15:
                        throw new SQLException("Invalid Android type: " + sqlType);
                    default:
                        throw new SQLException("Unknown sql argument type: " + sqlType);
                }
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = null;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void close() throws SQLException {
        try {
            this.db.close();
            logger.trace("{}: db {} closed", this, this.db);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems closing the database connection", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void closeQuietly() {
        try {
            close();
        } catch (SQLException unused) {
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems commiting transaction", e);
            }
            throw SqlExceptionUtil.create("problems commiting transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.db, statementType, this.cancelQueriesEnabled);
        logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, str);
        return androidCompiledStatement;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, FolderInfo.VIRTUAL_FOLDER_DELETED);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int executeStatement(String str, int i) throws SQLException {
        return AndroidCompiledStatement.execSql(this.db, str, str, NO_STRING_ARGS);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                sQLiteStatementCompileStatement = this.db.compileStatement(str);
                bindArgs(sQLiteStatementCompileStatement, objArr, fieldTypeArr);
                long jExecuteInsert = sQLiteStatementCompileStatement.executeInsert();
                if (generatedKeyHolder != null) {
                    generatedKeyHolder.addKey(Long.valueOf(jExecuteInsert));
                }
                logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
                return 1;
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("inserting to database failed: " + str, e);
            }
        } finally {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommit() throws SQLException {
        try {
            boolean zInTransaction = this.db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(zInTransaction));
            return !zInTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommitSupported() {
        return true;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isClosed() throws SQLException {
        try {
            boolean zIsOpen = this.db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", this, this.db, Boolean.valueOf(zIsOpen));
            return !zIsOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isTableExists(String str) {
        Cursor cursorRawQuery = this.db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + str + "'", null);
        try {
            boolean z = cursorRawQuery.getCount() > 0;
            logger.trace("{}: isTableExists '{}' returned {}", this, str, Boolean.valueOf(z));
            return z;
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                sQLiteStatementCompileStatement = this.db.compileStatement(str);
                long jSimpleQueryForLong = sQLiteStatementCompileStatement.simpleQueryForLong();
                logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(jSimpleQueryForLong), str);
                return jSimpleQueryForLong;
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("queryForLong from database failed: " + str, e);
            }
        } finally {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    @Override // com.j256.ormlite.support.DatabaseConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.lang.Object queryForOne(java.lang.String r4, java.lang.Object[] r5, com.j256.ormlite.field.FieldType[] r6, com.j256.ormlite.stmt.GenericRowMapper<T> r7, com.j256.ormlite.dao.ObjectCache r8) throws java.lang.Throwable {
        /*
            r3 = this;
            r6 = 0
            android.database.sqlite.SQLiteDatabase r0 = r3.db     // Catch: java.lang.Throwable -> L3d android.database.SQLException -> L3f
            java.lang.String[] r5 = r3.toStrings(r5)     // Catch: java.lang.Throwable -> L3d android.database.SQLException -> L3f
            android.database.Cursor r5 = r0.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L3d android.database.SQLException -> L3f
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            r0.<init>(r5, r8)     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.android.AndroidDatabaseConnection.logger     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            java.lang.String r1 = "{}: queried for one result: {}"
            r8.trace(r1, r3, r4)     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            boolean r8 = r0.first()     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            if (r8 != 0) goto L23
            if (r5 == 0) goto L22
            r5.close()
        L22:
            return r6
        L23:
            java.lang.Object r6 = r7.mapRow(r0)     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            boolean r7 = r0.next()     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            if (r7 == 0) goto L35
            java.lang.Object r4 = com.j256.ormlite.support.DatabaseConnection.MORE_THAN_ONE     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            if (r5 == 0) goto L34
            r5.close()
        L34:
            return r4
        L35:
            if (r5 == 0) goto L3a
            r5.close()
        L3a:
            return r6
        L3b:
            r6 = move-exception
            goto L43
        L3d:
            r4 = move-exception
            goto L5b
        L3f:
            r5 = move-exception
            r2 = r6
            r6 = r5
            r5 = r2
        L43:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r7.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r8 = "queryForOne from database failed: "
            r7.append(r8)     // Catch: java.lang.Throwable -> L59
            r7.append(r4)     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r7.toString()     // Catch: java.lang.Throwable -> L59
            java.sql.SQLException r4 = com.j256.ormlite.misc.SqlExceptionUtil.create(r4, r6)     // Catch: java.lang.Throwable -> L59
            throw r4     // Catch: java.lang.Throwable -> L59
        L59:
            r4 = move-exception
            r6 = r5
        L5b:
            if (r6 == 0) goto L60
            r6.close()
        L60:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForOne(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], com.j256.ormlite.stmt.GenericRowMapper, com.j256.ormlite.dao.ObjectCache):java.lang.Object");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems rolling back transaction", e);
            }
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void setAutoCommit(boolean z) {
        if (!z) {
            if (this.db.inTransaction()) {
                return;
            }
            this.db.beginTransaction();
        } else if (this.db.inTransaction()) {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems beginning transaction " + str, e);
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "updated");
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z, boolean z2) {
        this.db = sQLiteDatabase;
        this.readWrite = z;
        this.cancelQueriesEnabled = z2;
        logger.trace("{}: db {} opened, read-write = {}", this, sQLiteDatabase, Boolean.valueOf(z));
    }

    private int update(String str, Object[] objArr, FieldType[] fieldTypeArr, String str2) throws Throwable {
        int iSimpleQueryForLong;
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                SQLiteStatement sQLiteStatementCompileStatement2 = this.db.compileStatement(str);
                try {
                    bindArgs(sQLiteStatementCompileStatement2, objArr, fieldTypeArr);
                    sQLiteStatementCompileStatement2.execute();
                    if (sQLiteStatementCompileStatement2 != null) {
                        sQLiteStatementCompileStatement2.close();
                    } else {
                        sQLiteStatementCompileStatement = sQLiteStatementCompileStatement2;
                    }
                    try {
                        sQLiteStatementCompileStatement = this.db.compileStatement("SELECT CHANGES()");
                        iSimpleQueryForLong = (int) sQLiteStatementCompileStatement.simpleQueryForLong();
                    } catch (android.database.SQLException unused) {
                        iSimpleQueryForLong = 1;
                        if (sQLiteStatementCompileStatement != null) {
                        }
                    } catch (Throwable th) {
                        if (sQLiteStatementCompileStatement != null) {
                            sQLiteStatementCompileStatement.close();
                        }
                        throw th;
                    }
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    logger.trace("{} statement is compiled and executed, changed {}: {}", str2, Integer.valueOf(iSimpleQueryForLong), str);
                    return iSimpleQueryForLong;
                } catch (android.database.SQLException e) {
                    e = e;
                    sQLiteStatementCompileStatement = sQLiteStatementCompileStatement2;
                    throw SqlExceptionUtil.create("updating database failed: " + str, e);
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteStatementCompileStatement = sQLiteStatementCompileStatement2;
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (android.database.SQLException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    @Override // com.j256.ormlite.support.DatabaseConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long queryForLong(java.lang.String r6, java.lang.Object[] r7, com.j256.ormlite.field.FieldType[] r8) throws java.lang.Throwable {
        /*
            r5 = this;
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r5.db     // Catch: java.lang.Throwable -> L31 android.database.SQLException -> L33
            java.lang.String[] r7 = r5.toStrings(r7)     // Catch: java.lang.Throwable -> L31 android.database.SQLException -> L33
            android.database.Cursor r7 = r0.rawQuery(r6, r7)     // Catch: java.lang.Throwable -> L31 android.database.SQLException -> L33
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            r0.<init>(r7, r8)     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            boolean r8 = r0.first()     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            if (r8 == 0) goto L1c
            r8 = 0
            long r0 = r0.getLong(r8)     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            goto L1e
        L1c:
            r0 = 0
        L1e:
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.android.AndroidDatabaseConnection.logger     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            java.lang.String r2 = "{}: query for long raw query returned {}: {}"
            java.lang.Long r3 = java.lang.Long.valueOf(r0)     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            r8.trace(r2, r5, r3, r6)     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            if (r7 == 0) goto L2e
            r7.close()
        L2e:
            return r0
        L2f:
            r8 = move-exception
            goto L37
        L31:
            r6 = move-exception
            goto L4f
        L33:
            r7 = move-exception
            r4 = r8
            r8 = r7
            r7 = r4
        L37:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = "queryForLong from database failed: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L4d
            r0.append(r6)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L4d
            java.sql.SQLException r6 = com.j256.ormlite.misc.SqlExceptionUtil.create(r6, r8)     // Catch: java.lang.Throwable -> L4d
            throw r6     // Catch: java.lang.Throwable -> L4d
        L4d:
            r6 = move-exception
            r8 = r7
        L4f:
            if (r8 == 0) goto L54
            r8.close()
        L54:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForLong(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[]):long");
    }
}

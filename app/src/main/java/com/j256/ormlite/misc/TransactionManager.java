package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class TransactionManager {
    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TransactionManager.class);
    private static AtomicInteger savePointCounter = new AtomicInteger();
    private ConnectionSource connectionSource;

    public TransactionManager() {
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.debug("committed savePoint transaction");
        } else {
            logger.debug("committed savePoint transaction {}", savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.debug("rolled back savePoint transaction");
        } else {
            logger.debug("rolled back savePoint transaction {}", savepointName);
        }
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return (T) callInTransaction(this.connectionSource, callable);
    }

    public void initialize() {
        if (this.connectionSource != null) {
            return;
        }
        throw new IllegalStateException("dataSource was not set on " + getClass().getSimpleName());
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    public TransactionManager(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        initialize();
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return (T) callInTransaction(readWriteConnection, connectionSource.saveSpecialConnection(readWriteConnection), connectionSource.getDatabaseType(), callable);
        } finally {
            connectionSource.clearSpecialConnection(readWriteConnection);
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return (T) callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018 A[Catch: all -> 0x0093, TRY_LEAVE, TryCatch #1 {all -> 0x0093, blocks: (B:4:0x0009, B:8:0x0012, B:10:0x0018, B:14:0x0029, B:16:0x0046, B:17:0x004e), top: B:46:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[Catch: all -> 0x0093, TryCatch #1 {all -> 0x0093, blocks: (B:4:0x0009, B:8:0x0012, B:10:0x0018, B:14:0x0029, B:16:0x0046, B:17:0x004e), top: B:46:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e A[Catch: all -> 0x0093, TRY_LEAVE, TryCatch #1 {all -> 0x0093, blocks: (B:4:0x0009, B:8:0x0012, B:10:0x0018, B:14:0x0029, B:16:0x0046, B:17:0x004e), top: B:46:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T callInTransaction(com.j256.ormlite.support.DatabaseConnection r6, boolean r7, com.j256.ormlite.db.DatabaseType r8, java.util.concurrent.Callable<T> r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "after commit exception, rolling back to save-point also threw exception"
            r1 = 0
            java.lang.String r2 = "restored auto-commit to true"
            r3 = 1
            r4 = 0
            if (r7 != 0) goto L12
            boolean r7 = r8.isNestedSavePointsSupported()     // Catch: java.lang.Throwable -> L93
            if (r7 == 0) goto L10
            goto L12
        L10:
            r7 = 0
            goto L5b
        L12:
            boolean r7 = r6.isAutoCommitSupported()     // Catch: java.lang.Throwable -> L93
            if (r7 == 0) goto L29
            boolean r7 = r6.isAutoCommit()     // Catch: java.lang.Throwable -> L93
            if (r7 == 0) goto L28
            r6.setAutoCommit(r4)     // Catch: java.lang.Throwable -> L6f
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = "had to set auto-commit to false"
            r8.debug(r1)     // Catch: java.lang.Throwable -> L6f
        L28:
            r4 = r7
        L29:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r7.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = "ORMLITE"
            r7.append(r8)     // Catch: java.lang.Throwable -> L93
            java.util.concurrent.atomic.AtomicInteger r8 = com.j256.ormlite.misc.TransactionManager.savePointCounter     // Catch: java.lang.Throwable -> L93
            int r8 = r8.incrementAndGet()     // Catch: java.lang.Throwable -> L93
            r7.append(r8)     // Catch: java.lang.Throwable -> L93
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L93
            java.sql.Savepoint r1 = r6.setSavePoint(r7)     // Catch: java.lang.Throwable -> L93
            if (r1 != 0) goto L4e
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = "started savePoint transaction"
            r7.debug(r8)     // Catch: java.lang.Throwable -> L93
            goto L59
        L4e:
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = "started savePoint transaction {}"
            java.lang.String r5 = r1.getSavepointName()     // Catch: java.lang.Throwable -> L93
            r7.debug(r8, r5)     // Catch: java.lang.Throwable -> L93
        L59:
            r7 = r4
            r4 = 1
        L5b:
            java.lang.Object r8 = r9.call()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L73 java.sql.SQLException -> L86
            if (r4 == 0) goto L64
            commit(r6, r1)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L73 java.sql.SQLException -> L86
        L64:
            if (r7 == 0) goto L6e
            r6.setAutoCommit(r3)
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.misc.TransactionManager.logger
            r6.debug(r2)
        L6e:
            return r8
        L6f:
            r8 = move-exception
            r4 = r7
            r7 = r8
            goto L94
        L73:
            r8 = move-exception
            if (r4 == 0) goto L7f
            rollBack(r6, r1)     // Catch: java.lang.Throwable -> L6f java.sql.SQLException -> L7a
            goto L7f
        L7a:
            com.j256.ormlite.logger.Logger r9 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L6f
            r9.error(r8, r0)     // Catch: java.lang.Throwable -> L6f
        L7f:
            java.lang.String r9 = "Transaction callable threw non-SQL exception"
            java.sql.SQLException r8 = com.j256.ormlite.misc.SqlExceptionUtil.create(r9, r8)     // Catch: java.lang.Throwable -> L6f
            throw r8     // Catch: java.lang.Throwable -> L6f
        L86:
            r8 = move-exception
            if (r4 == 0) goto L92
            rollBack(r6, r1)     // Catch: java.lang.Throwable -> L6f java.sql.SQLException -> L8d
            goto L92
        L8d:
            com.j256.ormlite.logger.Logger r9 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L6f
            r9.error(r8, r0)     // Catch: java.lang.Throwable -> L6f
        L92:
            throw r8     // Catch: java.lang.Throwable -> L6f
        L93:
            r7 = move-exception
        L94:
            if (r4 == 0) goto L9e
            r6.setAutoCommit(r3)
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.misc.TransactionManager.logger
            r6.debug(r2)
        L9e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.misc.TransactionManager.callInTransaction(com.j256.ormlite.support.DatabaseConnection, boolean, com.j256.ormlite.db.DatabaseType, java.util.concurrent.Callable):java.lang.Object");
    }
}

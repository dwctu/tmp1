package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TableUtils {
    private static Logger logger = LoggerFactory.getLogger((Class<?>) TableUtils.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];

    private TableUtils() {
    }

    private static <T, ID> void addCreateIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, boolean z, boolean z2) {
        HashMap map = new HashMap();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String uniqueIndexName = z2 ? fieldType.getUniqueIndexName() : fieldType.getIndexName();
            if (uniqueIndexName != null) {
                List arrayList = (List) map.get(uniqueIndexName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(uniqueIndexName, arrayList);
                }
                arrayList.add(fieldType.getColumnName());
            }
        }
        StringBuilder sb = new StringBuilder(128);
        for (Map.Entry entry : map.entrySet()) {
            logger.info("creating index '{}' for table '{}", entry.getKey(), tableInfo.getTableName());
            sb.append("CREATE ");
            if (z2) {
                sb.append("UNIQUE ");
            }
            sb.append("INDEX ");
            if (z && databaseType.isCreateIndexIfNotExistsSupported()) {
                sb.append("IF NOT EXISTS ");
            }
            databaseType.appendEscapedEntityName(sb, (String) entry.getKey());
            sb.append(" ON ");
            databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
            sb.append(" ( ");
            boolean z3 = true;
            for (String str : (List) entry.getValue()) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                databaseType.appendEscapedEntityName(sb, str);
            }
            sb.append(" )");
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addCreateTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, List<String> list2, boolean z) throws SQLException {
        boolean z2;
        int i;
        int i2;
        FieldType[] fieldTypeArr;
        StringBuilder sb = new StringBuilder(256);
        sb.append("CREATE TABLE ");
        if (z && databaseType.isCreateIfNotExistsSupported()) {
            sb.append("IF NOT EXISTS ");
        }
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(" (");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        boolean z3 = true;
        int i3 = 0;
        while (i3 < length) {
            FieldType fieldType = fieldTypes[i3];
            if (fieldType.isForeignCollection()) {
                i = i3;
                i2 = length;
                fieldTypeArr = fieldTypes;
            } else {
                if (z3) {
                    z2 = false;
                } else {
                    sb.append(", ");
                    z2 = z3;
                }
                String columnDefinition = fieldType.getColumnDefinition();
                if (columnDefinition == null) {
                    i = i3;
                    i2 = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendColumnArg(tableInfo.getTableName(), sb, fieldType, arrayList, arrayList2, arrayList3, list2);
                } else {
                    i = i3;
                    i2 = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendEscapedEntityName(sb, fieldType.getColumnName());
                    sb.append(' ');
                    sb.append(columnDefinition);
                    sb.append(' ');
                }
                z3 = z2;
            }
            i3 = i + 1;
            length = i2;
            fieldTypes = fieldTypeArr;
        }
        databaseType.addPrimaryKeySql(tableInfo.getFieldTypes(), arrayList, arrayList2, arrayList3, list2);
        databaseType.addUniqueComboSql(tableInfo.getFieldTypes(), arrayList, arrayList2, arrayList3, list2);
        for (String str : arrayList) {
            sb.append(", ");
            sb.append(str);
        }
        sb.append(") ");
        databaseType.appendCreateTableSuffix(sb);
        list.addAll(arrayList2);
        list.add(sb.toString());
        list.addAll(arrayList3);
        addCreateIndexStatements(databaseType, tableInfo, list, z, false);
        addCreateIndexStatements(databaseType, tableInfo, list, z, true);
    }

    private static <T, ID> void addDropIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        HashSet<String> hashSet = new HashSet();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String indexName = fieldType.getIndexName();
            if (indexName != null) {
                hashSet.add(indexName);
            }
            String uniqueIndexName = fieldType.getUniqueIndexName();
            if (uniqueIndexName != null) {
                hashSet.add(uniqueIndexName);
            }
        }
        StringBuilder sb = new StringBuilder(48);
        for (String str : hashSet) {
            logger.info("dropping index '{}' for table '{}", str, tableInfo.getTableName());
            sb.append("DROP INDEX ");
            databaseType.appendEscapedEntityName(sb, str);
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addDropTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            databaseType.dropColumnArg(fieldType, arrayList, arrayList2);
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("DROP TABLE ");
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(' ');
        list.addAll(arrayList);
        list.add(sb.toString());
        list.addAll(arrayList2);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String strExtractTableName = DatabaseTableConfig.extractTableName(cls);
        if (connectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
            strExtractTableName = strExtractTableName.toUpperCase();
        }
        return clearTable(connectionSource, strExtractTableName);
    }

    public static <T> int createTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, (Class) cls, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, (Class) cls, true);
    }

    private static <T, ID> int doCreateTable(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        logger.info("creating table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        addCreateTableStatements(databaseType, tableInfo, arrayList, arrayList2, z);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "create", arrayList, false, databaseType.isCreateTableReturnsNegative(), databaseType.isCreateTableReturnsZero()) + doCreateTestQueries(readWriteConnection, databaseType, arrayList2);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static int doCreateTestQueries(DatabaseConnection databaseConnection, DatabaseType databaseType, List<String> list) throws Throwable {
        int i = 0;
        for (String str : list) {
            CompiledStatement compiledStatement = null;
            try {
                try {
                    CompiledStatement compiledStatementCompileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
                    try {
                        DatabaseResults databaseResultsRunQuery = compiledStatementCompileStatement.runQuery(null);
                        int i2 = 0;
                        for (boolean zFirst = databaseResultsRunQuery.first(); zFirst; zFirst = databaseResultsRunQuery.next()) {
                            i2++;
                        }
                        logger.info("executing create table after-query got {} results: {}", Integer.valueOf(i2), str);
                        if (compiledStatementCompileStatement != null) {
                            compiledStatementCompileStatement.close();
                        }
                        i++;
                    } catch (SQLException e) {
                        e = e;
                        compiledStatement = compiledStatementCompileStatement;
                        throw SqlExceptionUtil.create("executing create table after-query failed: " + str, e);
                    } catch (Throwable th) {
                        th = th;
                        compiledStatement = compiledStatementCompileStatement;
                        if (compiledStatement != null) {
                            compiledStatement.close();
                        }
                        throw th;
                    }
                } catch (SQLException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return i;
    }

    private static <T, ID> int doDropTable(DatabaseType databaseType, ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        logger.info("dropping table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        addDropIndexStatements(databaseType, tableInfo, arrayList);
        addDropTableStatements(databaseType, tableInfo, arrayList);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "drop", arrayList, z, databaseType.isCreateTableReturnsNegative(), false);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d A[DONT_GENERATE, PHI: r3 r4
  0x002d: PHI (r3v4 com.j256.ormlite.support.CompiledStatement) = (r3v3 com.j256.ormlite.support.CompiledStatement), (r3v5 com.j256.ormlite.support.CompiledStatement) binds: [B:18:0x0041, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE]
  0x002d: PHI (r4v3 int) = (r4v1 int), (r4v5 int) binds: [B:18:0x0041, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int doStatements(com.j256.ormlite.support.DatabaseConnection r8, java.lang.String r9, java.util.Collection<java.lang.String> r10, boolean r11, boolean r12, boolean r13) throws java.sql.SQLException {
        /*
            java.util.Iterator r10 = r10.iterator()
            r0 = 0
            r1 = 0
        L6:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto Lb1
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r4 = com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE     // Catch: java.lang.Throwable -> L33 java.sql.SQLException -> L36
            com.j256.ormlite.field.FieldType[] r5 = com.j256.ormlite.table.TableUtils.noFieldTypes     // Catch: java.lang.Throwable -> L33 java.sql.SQLException -> L36
            r6 = -1
            com.j256.ormlite.support.CompiledStatement r3 = r8.compileStatement(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L33 java.sql.SQLException -> L36
            int r4 = r3.runExecute()     // Catch: java.lang.Throwable -> L33 java.sql.SQLException -> L36
            com.j256.ormlite.logger.Logger r5 = com.j256.ormlite.table.TableUtils.logger     // Catch: java.sql.SQLException -> L31 java.lang.Throwable -> L33
            java.lang.String r6 = "executed {} table statement changed {} rows: {}"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch: java.sql.SQLException -> L31 java.lang.Throwable -> L33
            r5.info(r6, r9, r7, r2)     // Catch: java.sql.SQLException -> L31 java.lang.Throwable -> L33
            if (r3 == 0) goto L44
        L2d:
            r3.close()
            goto L44
        L31:
            r5 = move-exception
            goto L38
        L33:
            r8 = move-exception
            goto Lab
        L36:
            r5 = move-exception
            r4 = 0
        L38:
            if (r11 == 0) goto L95
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.table.TableUtils.logger     // Catch: java.lang.Throwable -> L33
            java.lang.String r7 = "ignoring {} error '{}' for statement: {}"
            r6.info(r7, r9, r5, r2)     // Catch: java.lang.Throwable -> L33
            if (r3 == 0) goto L44
            goto L2d
        L44:
            if (r4 >= 0) goto L6d
            if (r12 == 0) goto L49
            goto L91
        L49:
            java.sql.SQLException r8 = new java.sql.SQLException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "SQL statement "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r10 = " updated "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r10 = " rows, we were expecting >= 0"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L6d:
            if (r4 <= 0) goto L91
            if (r13 != 0) goto L72
            goto L91
        L72:
            java.sql.SQLException r8 = new java.sql.SQLException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "SQL statement updated "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r10 = " rows, we were expecting == 0: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L91:
            int r1 = r1 + 1
            goto L6
        L95:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r8.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r9 = "SQL statement failed: "
            r8.append(r9)     // Catch: java.lang.Throwable -> L33
            r8.append(r2)     // Catch: java.lang.Throwable -> L33
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L33
            java.sql.SQLException r8 = com.j256.ormlite.misc.SqlExceptionUtil.create(r8, r5)     // Catch: java.lang.Throwable -> L33
            throw r8     // Catch: java.lang.Throwable -> L33
        Lab:
            if (r3 == 0) goto Lb0
            r3.close()
        Lb0:
            throw r8
        Lb1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.doStatements(com.j256.ormlite.support.DatabaseConnection, java.lang.String, java.util.Collection, boolean, boolean, boolean):int");
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao daoCreateDao = DaoManager.createDao(connectionSource, cls);
        return daoCreateDao instanceof BaseDaoImpl ? doDropTable(databaseType, connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), z) : doDropTable(databaseType, connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), z);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao daoCreateDao = DaoManager.createDao(connectionSource, cls);
        return daoCreateDao instanceof BaseDaoImpl ? addCreateTableStatements(connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), false) : addCreateTableStatements(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), false);
    }

    public static <T> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, (DatabaseTableConfig) databaseTableConfig, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, (DatabaseTableConfig) databaseTableConfig, true);
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        Dao daoCreateDao = DaoManager.createDao(connectionSource, cls);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), z);
        }
        return doCreateTable(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), z);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return clearTable(connectionSource, databaseTableConfig.getTableName());
    }

    private static <T> int clearTable(ConnectionSource connectionSource, String str) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        StringBuilder sb = new StringBuilder(48);
        if (databaseType.isTruncateSupported()) {
            sb.append("TRUNCATE TABLE ");
        } else {
            sb.append("DELETE FROM ");
        }
        databaseType.appendEscapedEntityName(sb, str);
        String string = sb.toString();
        logger.info("clearing table '{}' with '{}", str, string);
        CompiledStatement compiledStatementCompileStatement = null;
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            compiledStatementCompileStatement = readWriteConnection.compileStatement(string, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
            return compiledStatementCompileStatement.runExecute();
        } finally {
            if (compiledStatementCompileStatement != null) {
                compiledStatementCompileStatement.close();
            }
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        Dao daoCreateDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), false);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), false);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao daoCreateDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doDropTable(databaseType, connectionSource, new TableInfo(databaseType, (BaseDaoImpl) null, databaseTableConfig), z);
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        Dao daoCreateDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doCreateTable(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), z);
    }

    private static <T, ID> List<String> addCreateTableStatements(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        ArrayList arrayList = new ArrayList();
        addCreateTableStatements(connectionSource.getDatabaseType(), tableInfo, arrayList, new ArrayList(), z);
        return arrayList;
    }
}

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class StatementExecutor<T, ID> implements GenericRowMapper<String[]> {
    private static Logger logger = LoggerFactory.getLogger((Class<?>) StatementExecutor.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];
    private String countStarQuery;
    private final Dao<T, ID> dao;
    private final DatabaseType databaseType;
    private FieldType[] ifExistsFieldTypes;
    private String ifExistsQuery;
    private MappedDelete<T, ID> mappedDelete;
    private MappedCreate<T, ID> mappedInsert;
    private MappedQueryForId<T, ID> mappedQueryForId;
    private MappedRefresh<T, ID> mappedRefresh;
    private MappedUpdate<T, ID> mappedUpdate;
    private MappedUpdateId<T, ID> mappedUpdateId;
    private PreparedQuery<T> preparedQueryForAll;
    private RawRowMapper<T> rawRowMapper;
    private final TableInfo<T, ID> tableInfo;

    public static class ObjectArrayRowMapper implements GenericRowMapper<Object[]> {
        private final DataType[] columnTypes;

        public ObjectArrayRowMapper(DataType[] dataTypeArr) {
            this.columnTypes = dataTypeArr;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public Object[] mapRow(DatabaseResults databaseResults) throws SQLException {
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            int i = 0;
            while (i < columnCount) {
                DataType[] dataTypeArr = this.columnTypes;
                objArr[i] = (i >= dataTypeArr.length ? DataType.STRING : dataTypeArr[i]).getDataPersister().resultToJava(null, databaseResults, i);
                i++;
            }
            return objArr;
        }
    }

    public static class UserRawRowMapper<UO> implements GenericRowMapper<UO> {
        private String[] columnNames;
        private final RawRowMapper<UO> mapper;
        private final GenericRowMapper<String[]> stringRowMapper;

        public UserRawRowMapper(RawRowMapper<UO> rawRowMapper, GenericRowMapper<String[]> genericRowMapper) {
            this.mapper = rawRowMapper;
            this.stringRowMapper = genericRowMapper;
        }

        private String[] getColumnNames(DatabaseResults databaseResults) throws SQLException {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            String[] columnNames = databaseResults.getColumnNames();
            this.columnNames = columnNames;
            return columnNames;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            return this.mapper.mapRow(getColumnNames(databaseResults), this.stringRowMapper.mapRow(databaseResults));
        }
    }

    public static class UserRawRowObjectMapper<UO> implements GenericRowMapper<UO> {
        private String[] columnNames;
        private final DataType[] columnTypes;
        private final RawRowObjectMapper<UO> mapper;

        public UserRawRowObjectMapper(RawRowObjectMapper<UO> rawRowObjectMapper, DataType[] dataTypeArr) {
            this.mapper = rawRowObjectMapper;
            this.columnTypes = dataTypeArr;
        }

        private String[] getColumnNames(DatabaseResults databaseResults) throws SQLException {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            String[] columnNames = databaseResults.getColumnNames();
            this.columnNames = columnNames;
            return columnNames;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i >= dataTypeArr.length) {
                    objArr[i] = null;
                } else {
                    objArr[i] = dataTypeArr[i].getDataPersister().resultToJava(null, databaseResults, i);
                }
            }
            return this.mapper.mapRow(getColumnNames(databaseResults), this.columnTypes, objArr);
        }
    }

    public StatementExecutor(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        this.databaseType = databaseType;
        this.tableInfo = tableInfo;
        this.dao = dao;
    }

    private void assignStatementArguments(CompiledStatement compiledStatement, String[] strArr) throws SQLException {
        for (int i = 0; i < strArr.length; i++) {
            compiledStatement.setObject(i, strArr[i], SqlType.STRING);
        }
    }

    private void prepareQueryForAll() throws SQLException {
        if (this.preparedQueryForAll == null) {
            this.preparedQueryForAll = new QueryBuilder(this.databaseType, this.tableInfo, this.dao).prepare();
        }
    }

    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, int i, ObjectCache objectCache) throws SQLException {
        prepareQueryForAll();
        return buildIterator(baseDaoImpl, connectionSource, this.preparedQueryForAll, objectCache, i);
    }

    public <CT> CT callBatchTasks(DatabaseConnection databaseConnection, boolean z, Callable<CT> callable) throws Throwable {
        if (this.databaseType.isBatchUseTransaction()) {
            return (CT) TransactionManager.callInTransaction(databaseConnection, z, this.databaseType, callable);
        }
        boolean z2 = false;
        try {
            if (databaseConnection.isAutoCommitSupported()) {
                boolean zIsAutoCommit = databaseConnection.isAutoCommit();
                if (zIsAutoCommit) {
                    try {
                        databaseConnection.setAutoCommit(false);
                        logger.debug("disabled auto-commit on table {} before batch tasks", this.tableInfo.getTableName());
                    } catch (Throwable th) {
                        th = th;
                        z2 = zIsAutoCommit;
                        if (z2) {
                            databaseConnection.setAutoCommit(true);
                            logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
                        }
                        throw th;
                    }
                }
                z2 = zIsAutoCommit;
            }
            try {
                try {
                    CT ctCall = callable.call();
                    if (z2) {
                        databaseConnection.setAutoCommit(true);
                        logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
                    }
                    return ctCall;
                } catch (Exception e) {
                    throw SqlExceptionUtil.create("Batch tasks callable threw non-SQL exception", e);
                }
            } catch (SQLException e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int create(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedInsert == null) {
            this.mappedInsert = MappedCreate.build(this.databaseType, this.tableInfo);
        }
        return this.mappedInsert.insert(this.databaseType, databaseConnection, t, objectCache);
    }

    public int delete(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        return this.mappedDelete.delete(databaseConnection, t, objectCache);
    }

    public int deleteById(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        return this.mappedDelete.deleteById(databaseConnection, id, objectCache);
    }

    public int deleteIds(DatabaseConnection databaseConnection, Collection<ID> collection, ObjectCache objectCache) throws SQLException {
        return MappedDeleteCollection.deleteIds(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
    }

    public int deleteObjects(DatabaseConnection databaseConnection, Collection<T> collection, ObjectCache objectCache) throws SQLException {
        return MappedDeleteCollection.deleteObjects(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
    }

    public int executeRaw(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        logger.debug("running raw execute statement: {}", str);
        if (strArr.length > 0) {
            logger.trace("execute arguments: {}", (Object) strArr);
        }
        CompiledStatement compiledStatementCompileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
        try {
            assignStatementArguments(compiledStatementCompileStatement, strArr);
            return compiledStatementCompileStatement.runExecute();
        } finally {
            compiledStatementCompileStatement.close();
        }
    }

    public int executeRawNoArgs(DatabaseConnection databaseConnection, String str) throws SQLException {
        logger.debug("running raw execute statement: {}", str);
        return databaseConnection.executeStatement(str, -1);
    }

    public RawRowMapper<T> getRawRowMapper() {
        if (this.rawRowMapper == null) {
            this.rawRowMapper = new RawRowMapperImpl(this.tableInfo);
        }
        return this.rawRowMapper;
    }

    public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
        prepareQueryForAll();
        return this.preparedQueryForAll;
    }

    public boolean ifExists(DatabaseConnection databaseConnection, ID id) throws SQLException {
        if (this.ifExistsQuery == null) {
            QueryBuilder queryBuilder = new QueryBuilder(this.databaseType, this.tableInfo, this.dao);
            queryBuilder.selectRaw("COUNT(*)");
            queryBuilder.where().eq(this.tableInfo.getIdField().getColumnName(), new SelectArg());
            this.ifExistsQuery = queryBuilder.prepareStatementString();
            this.ifExistsFieldTypes = new FieldType[]{this.tableInfo.getIdField()};
        }
        long jQueryForLong = databaseConnection.queryForLong(this.ifExistsQuery, new Object[]{id}, this.ifExistsFieldTypes);
        logger.debug("query of '{}' returned {}", this.ifExistsQuery, Long.valueOf(jQueryForLong));
        return jQueryForLong != 0;
    }

    public List<T> query(ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache) throws Throwable {
        SelectIterator<T, ID> selectIteratorBuildIterator = buildIterator(null, connectionSource, preparedStmt, objectCache, -1);
        try {
            ArrayList arrayList = new ArrayList();
            while (selectIteratorBuildIterator.hasNextThrow()) {
                arrayList.add(selectIteratorBuildIterator.nextThrow());
            }
            logger.debug("query of '{}' returned {} results", preparedStmt.getStatement(), Integer.valueOf(arrayList.size()));
            return arrayList;
        } finally {
            selectIteratorBuildIterator.close();
        }
    }

    public List<T> queryForAll(ConnectionSource connectionSource, ObjectCache objectCache) throws SQLException {
        prepareQueryForAll();
        return query(connectionSource, this.preparedQueryForAll, objectCache);
    }

    public long queryForCountStar(DatabaseConnection databaseConnection) throws SQLException {
        if (this.countStarQuery == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("SELECT COUNT(*) FROM ");
            this.databaseType.appendEscapedEntityName(sb, this.tableInfo.getTableName());
            this.countStarQuery = sb.toString();
        }
        long jQueryForLong = databaseConnection.queryForLong(this.countStarQuery);
        logger.debug("query of '{}' returned {}", this.countStarQuery, Long.valueOf(jQueryForLong));
        return jQueryForLong;
    }

    public T queryForFirst(DatabaseConnection databaseConnection, PreparedStmt<T> preparedStmt, ObjectCache objectCache) throws Throwable {
        CompiledStatement compiledStatementCompile = preparedStmt.compile(databaseConnection, StatementBuilder.StatementType.SELECT);
        DatabaseResults databaseResults = null;
        try {
            DatabaseResults databaseResultsRunQuery = compiledStatementCompile.runQuery(objectCache);
            try {
                if (!databaseResultsRunQuery.first()) {
                    logger.debug("query-for-first of '{}' returned at 0 results", preparedStmt.getStatement());
                    if (databaseResultsRunQuery != null) {
                        databaseResultsRunQuery.close();
                    }
                    compiledStatementCompile.close();
                    return null;
                }
                logger.debug("query-for-first of '{}' returned at least 1 result", preparedStmt.getStatement());
                T tMapRow = preparedStmt.mapRow(databaseResultsRunQuery);
                if (databaseResultsRunQuery != null) {
                    databaseResultsRunQuery.close();
                }
                compiledStatementCompile.close();
                return tMapRow;
            } catch (Throwable th) {
                th = th;
                databaseResults = databaseResultsRunQuery;
                if (databaseResults != null) {
                    databaseResults.close();
                }
                compiledStatementCompile.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public T queryForId(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedQueryForId == null) {
            this.mappedQueryForId = MappedQueryForId.build(this.databaseType, this.tableInfo, null);
        }
        return this.mappedQueryForId.execute(databaseConnection, id, objectCache);
    }

    public long queryForLong(DatabaseConnection databaseConnection, PreparedStmt<T> preparedStmt) throws SQLException {
        CompiledStatement compiledStatementCompile = preparedStmt.compile(databaseConnection, StatementBuilder.StatementType.SELECT_LONG);
        DatabaseResults databaseResults = null;
        try {
            DatabaseResults databaseResultsRunQuery = compiledStatementCompile.runQuery(null);
            if (!databaseResultsRunQuery.first()) {
                throw new SQLException("No result found in queryForLong: " + preparedStmt.getStatement());
            }
            long j = databaseResultsRunQuery.getLong(0);
            if (databaseResultsRunQuery != null) {
                databaseResultsRunQuery.close();
            }
            compiledStatementCompile.close();
            return j;
        } catch (Throwable th) {
            if (0 != 0) {
                databaseResults.close();
            }
            compiledStatementCompile.close();
            throw th;
        }
    }

    public GenericRawResults<String[]> queryRaw(ConnectionSource connectionSource, String str, String[] strArr, ObjectCache objectCache) throws SQLException {
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection();
        CompiledStatement compiledStatementCompileStatement = null;
        try {
            compiledStatementCompileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
            assignStatementArguments(compiledStatementCompileStatement, strArr);
            return new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatementCompileStatement, this, objectCache);
        } catch (Throwable th) {
            if (compiledStatementCompileStatement != null) {
                compiledStatementCompileStatement.close();
            }
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public int refresh(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedRefresh == null) {
            this.mappedRefresh = MappedRefresh.build(this.databaseType, this.tableInfo);
        }
        return this.mappedRefresh.executeRefresh(databaseConnection, t, objectCache);
    }

    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedUpdate == null) {
            this.mappedUpdate = MappedUpdate.build(this.databaseType, this.tableInfo);
        }
        return this.mappedUpdate.update(databaseConnection, t, objectCache);
    }

    public int updateId(DatabaseConnection databaseConnection, T t, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedUpdateId == null) {
            this.mappedUpdateId = MappedUpdateId.build(this.databaseType, this.tableInfo);
        }
        return this.mappedUpdateId.execute(databaseConnection, t, id, objectCache);
    }

    public int updateRaw(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        logger.debug("running raw update statement: {}", str);
        if (strArr.length > 0) {
            logger.trace("update arguments: {}", (Object) strArr);
        }
        CompiledStatement compiledStatementCompileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.UPDATE, noFieldTypes, -1);
        try {
            assignStatementArguments(compiledStatementCompileStatement, strArr);
            return compiledStatementCompileStatement.runUpdate();
        } finally {
            compiledStatementCompileStatement.close();
        }
    }

    @Override // com.j256.ormlite.stmt.GenericRowMapper
    public String[] mapRow(DatabaseResults databaseResults) throws SQLException {
        int columnCount = databaseResults.getColumnCount();
        String[] strArr = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            strArr[i] = databaseResults.getString(i);
        }
        return strArr;
    }

    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache, int i) throws Throwable {
        CompiledStatement compiledStatementCompile;
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection();
        CompiledStatement compiledStatement = null;
        try {
            compiledStatementCompile = preparedStmt.compile(readOnlyConnection, StatementBuilder.StatementType.SELECT, i);
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            return new SelectIterator<>(this.tableInfo.getDataClass(), baseDaoImpl, preparedStmt, connectionSource, readOnlyConnection, compiledStatementCompile, preparedStmt.getStatement(), objectCache);
        } catch (Throwable th3) {
            th = th3;
            compiledStatement = compiledStatementCompile;
            if (compiledStatement != null) {
                compiledStatement.close();
            }
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public int delete(DatabaseConnection databaseConnection, PreparedDelete<T> preparedDelete) throws SQLException {
        CompiledStatement compiledStatementCompile = preparedDelete.compile(databaseConnection, StatementBuilder.StatementType.DELETE);
        try {
            return compiledStatementCompile.runUpdate();
        } finally {
            compiledStatementCompile.close();
        }
    }

    public int update(DatabaseConnection databaseConnection, PreparedUpdate<T> preparedUpdate) throws SQLException {
        CompiledStatement compiledStatementCompile = preparedUpdate.compile(databaseConnection, StatementBuilder.StatementType.UPDATE);
        try {
            return compiledStatementCompile.runUpdate();
        } finally {
            compiledStatementCompile.close();
        }
    }

    public long queryForLong(DatabaseConnection databaseConnection, String str, String[] strArr) throws Throwable {
        CompiledStatement compiledStatementCompileStatement;
        logger.debug("executing raw query for long: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseResults databaseResults = null;
        try {
            compiledStatementCompileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
            try {
                assignStatementArguments(compiledStatementCompileStatement, strArr);
                DatabaseResults databaseResultsRunQuery = compiledStatementCompileStatement.runQuery(null);
                if (databaseResultsRunQuery.first()) {
                    long j = databaseResultsRunQuery.getLong(0);
                    if (databaseResultsRunQuery != null) {
                        databaseResultsRunQuery.close();
                    }
                    if (compiledStatementCompileStatement != null) {
                        compiledStatementCompileStatement.close();
                    }
                    return j;
                }
                throw new SQLException("No result found in queryForLong: " + str);
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    databaseResults.close();
                }
                if (compiledStatementCompileStatement != null) {
                    compiledStatementCompileStatement.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatementCompileStatement = null;
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, RawRowMapper<UO> rawRowMapper, String[] strArr, ObjectCache objectCache) throws SQLException {
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection();
        CompiledStatement compiledStatementCompileStatement = null;
        try {
            compiledStatementCompileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
            assignStatementArguments(compiledStatementCompileStatement, strArr);
            return new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatementCompileStatement, new UserRawRowMapper(rawRowMapper, this), objectCache);
        } catch (Throwable th) {
            if (compiledStatementCompileStatement != null) {
                compiledStatementCompileStatement.close();
            }
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String[] strArr, ObjectCache objectCache) throws Throwable {
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection();
        CompiledStatement compiledStatement = null;
        try {
            CompiledStatement compiledStatementCompileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
            try {
                assignStatementArguments(compiledStatementCompileStatement, strArr);
                return new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatementCompileStatement, new UserRawRowObjectMapper(rawRowObjectMapper, dataTypeArr), objectCache);
            } catch (Throwable th) {
                th = th;
                compiledStatement = compiledStatementCompileStatement;
                if (compiledStatement != null) {
                    compiledStatement.close();
                }
                if (readOnlyConnection != null) {
                    connectionSource.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public GenericRawResults<Object[]> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, String[] strArr, ObjectCache objectCache) throws SQLException {
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection();
        CompiledStatement compiledStatementCompileStatement = null;
        try {
            compiledStatementCompileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
            assignStatementArguments(compiledStatementCompileStatement, strArr);
            return new RawResultsImpl(connectionSource, readOnlyConnection, str, Object[].class, compiledStatementCompileStatement, new ObjectArrayRowMapper(dataTypeArr), objectCache);
        } catch (Throwable th) {
            if (compiledStatementCompileStatement != null) {
                compiledStatementCompileStatement.close();
            }
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }
}

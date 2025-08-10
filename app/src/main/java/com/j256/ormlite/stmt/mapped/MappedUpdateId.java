package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class MappedUpdateId<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedUpdateId(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
    }

    public static <T, ID> MappedUpdateId<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField == null) {
            throw new SQLException("Cannot update-id in " + tableInfo.getDataClass() + " because it doesn't have an id field");
        }
        StringBuilder sb = new StringBuilder(64);
        BaseMappedStatement.appendTableName(databaseType, sb, "UPDATE ", tableInfo.getTableName());
        sb.append("SET ");
        BaseMappedStatement.appendFieldColumnName(databaseType, sb, idField, null);
        sb.append("= ? ");
        BaseMappedStatement.appendWhereFieldEq(databaseType, idField, sb, null);
        return new MappedUpdateId<>(tableInfo, sb.toString(), new FieldType[]{idField, idField});
    }

    private Object extractIdToFieldObject(T t) throws SQLException {
        return this.idField.extractJavaFieldToSqlArgValue(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int execute(DatabaseConnection databaseConnection, T t, ID id, ObjectCache objectCache) throws IllegalAccessException, SQLException, IllegalArgumentException, InvocationTargetException {
        Object objUpdateId;
        try {
            Object[] objArr = {convertIdToFieldObject(id), extractIdToFieldObject(t)};
            int iUpdate = databaseConnection.update(this.statement, objArr, this.argFieldTypes);
            if (iUpdate > 0) {
                if (objectCache != 0 && (objUpdateId = objectCache.updateId(this.clazz, this.idField.extractJavaFieldValue(t), id)) != null && objUpdateId != t) {
                    this.idField.assignField(objUpdateId, id, false, objectCache);
                }
                this.idField.assignField(t, id, false, objectCache);
            }
            BaseMappedStatement.logger.debug("updating-id with statement '{}' and {} args, changed {} rows", (Object) this.statement, (Object) 2, (Object) Integer.valueOf(iUpdate));
            BaseMappedStatement.logger.trace("updating-id arguments: {}", (Object) objArr);
            return iUpdate;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run update-id stmt on object " + t + ": " + this.statement, e);
        }
    }
}

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class EnumIntegerType extends BaseEnumType {
    private static final EnumIntegerType singleTon = new EnumIntegerType();

    private EnumIntegerType() {
        super(SqlType.INTEGER, new Class[0]);
    }

    public static EnumIntegerType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Integer.TYPE;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return Integer.valueOf(((Enum) obj).ordinal());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        HashMap map = new HashMap();
        Enum[] enumArr = (Enum[]) fieldType.getType().getEnumConstants();
        if (enumArr == null) {
            throw new SQLException("Field " + fieldType + " improperly configured as type " + this);
        }
        for (Enum r3 : enumArr) {
            map.put(Integer.valueOf(r3.ordinal()), r3);
        }
        return map;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Integer.valueOf(Integer.parseInt(str));
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        return sqlArgToJava(fieldType, Integer.valueOf(Integer.parseInt(str)), i);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        if (fieldType == null) {
            return obj;
        }
        Integer num = (Integer) obj;
        Map map = (Map) fieldType.getDataTypeConfigObj();
        return map == null ? BaseEnumType.enumVal(fieldType, num, null, fieldType.getUnknownEnumVal()) : BaseEnumType.enumVal(fieldType, num, (Enum) map.get(num), fieldType.getUnknownEnumVal());
    }

    public EnumIntegerType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}

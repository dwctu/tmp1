package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDateType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes3.dex */
public class DateStringType extends BaseDateType {
    public static int DEFAULT_WIDTH = 50;
    private static final DateStringType singleTon = new DateStringType();

    private DateStringType() {
        super(SqlType.STRING, new Class[0]);
    }

    public static DateStringType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return byte[].class;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return BaseDateType.convertDateStringConfig(fieldType, BaseDateType.defaultDateFormatConfig).getDateFormat().format((Date) obj);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object makeConfigObject(FieldType fieldType) {
        String format = fieldType.getFormat();
        return format == null ? BaseDateType.defaultDateFormatConfig : new BaseDateType.DateStringFormatConfig(format);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        BaseDateType.DateStringFormatConfig dateStringFormatConfigConvertDateStringConfig = BaseDateType.convertDateStringConfig(fieldType, BaseDateType.defaultDateFormatConfig);
        try {
            return BaseDateType.normalizeDateString(dateStringFormatConfigConvertDateStringConfig, str);
        } catch (ParseException e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default date-string '" + str + "' using '" + dateStringFormatConfigConvertDateStringConfig + "'", e);
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        return sqlArgToJava(fieldType, str, i);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        String str = (String) obj;
        BaseDateType.DateStringFormatConfig dateStringFormatConfigConvertDateStringConfig = BaseDateType.convertDateStringConfig(fieldType, BaseDateType.defaultDateFormatConfig);
        try {
            return BaseDateType.parseDateString(dateStringFormatConfigConvertDateStringConfig, str);
        } catch (ParseException e) {
            throw SqlExceptionUtil.create("Problems with column " + i + " parsing date-string '" + str + "' using '" + dateStringFormatConfigConvertDateStringConfig + "'", e);
        }
    }

    public DateStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}

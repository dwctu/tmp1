package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/* loaded from: classes3.dex */
public class TimeStampType extends DateType {
    private static final TimeStampType singleTon = new TimeStampType();

    private TimeStampType() {
        super(SqlType.DATE, new Class[]{Timestamp.class});
    }

    public static TimeStampType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return field.getType() == Timestamp.class;
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return obj;
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return obj == null ? new Timestamp(jCurrentTimeMillis) : jCurrentTimeMillis == ((Timestamp) obj).getTime() ? new Timestamp(jCurrentTimeMillis + 1) : new Timestamp(jCurrentTimeMillis);
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return obj;
    }

    public TimeStampType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}

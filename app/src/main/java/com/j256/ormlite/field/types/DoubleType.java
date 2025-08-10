package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes3.dex */
public class DoubleType extends DoubleObjectType {
    private static final DoubleType singleTon = new DoubleType();

    private DoubleType() {
        super(SqlType.DOUBLE, new Class[]{Double.TYPE});
    }

    public static DoubleType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public DoubleType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}

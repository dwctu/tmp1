package com.j256.ormlite.android;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.ArrayList;
import org.jivesoftware.smackx.xdata.FormField;

/* loaded from: classes3.dex */
public class DatabaseTableConfigUtil {
    private static final int ALLOW_GENERATED_ID_INSERT = 24;
    private static final int CAN_BE_NULL = 5;
    private static final int COLUMN_DEFINITON = 25;
    private static final int COLUMN_NAME = 1;
    private static final int DATA_TYPE = 2;
    private static final int DEFAULT_VALUE = 3;
    private static final int FOREIGN = 9;
    private static final int FOREIGN_AUTO_CREATE = 26;
    private static final int FOREIGN_AUTO_REFRESH = 21;
    private static final int FOREIGN_COLUMN_NAME = 28;
    private static final int FORMAT = 14;
    private static final int GENERATED_ID = 7;
    private static final int GENERATED_ID_SEQUENCE = 8;
    private static final int ID = 6;
    private static final int INDEX = 17;
    private static final int INDEX_NAME = 19;
    private static final int MAX_FOREIGN_AUTO_REFRESH_LEVEL = 22;
    private static final int PERSISTED = 13;
    private static final int PERSISTER_CLASS = 23;
    private static final int READ_ONLY = 29;
    private static final int THROW_IF_NULL = 12;
    private static final int UNIQUE = 15;
    private static final int UNIQUE_COMBO = 16;
    private static final int UNIQUE_INDEX = 18;
    private static final int UNIQUE_INDEX_NAME = 20;
    private static final int UNKNOWN_ENUM_NAME = 11;
    private static final int USE_GET_SET = 10;
    private static final int VERSION = 27;
    private static final int WIDTH = 4;
    private static Class<?> annotationFactoryClazz;
    private static Class<?> annotationMemberClazz;
    private static final int[] configFieldNums = lookupClasses();
    private static Field elementsField;
    private static Field nameField;
    private static Field valueField;
    private static int workedC;

    public static class DatabaseFieldSample {

        @DatabaseField
        public String field;

        private DatabaseFieldSample() {
        }
    }

    private static void assignConfigField(int i, DatabaseFieldConfig databaseFieldConfig, Field field, Object obj) {
        switch (i) {
            case 1:
                databaseFieldConfig.setColumnName(valueIfNotBlank((String) obj));
                return;
            case 2:
                databaseFieldConfig.setDataType((DataType) obj);
                return;
            case 3:
                String str = (String) obj;
                if (str == null || str.equals(DatabaseField.DEFAULT_STRING)) {
                    return;
                }
                databaseFieldConfig.setDefaultValue(str);
                return;
            case 4:
                databaseFieldConfig.setWidth(((Integer) obj).intValue());
                return;
            case 5:
                databaseFieldConfig.setCanBeNull(((Boolean) obj).booleanValue());
                return;
            case 6:
                databaseFieldConfig.setId(((Boolean) obj).booleanValue());
                return;
            case 7:
                databaseFieldConfig.setGeneratedId(((Boolean) obj).booleanValue());
                return;
            case 8:
                databaseFieldConfig.setGeneratedIdSequence(valueIfNotBlank((String) obj));
                return;
            case 9:
                databaseFieldConfig.setForeign(((Boolean) obj).booleanValue());
                return;
            case 10:
                databaseFieldConfig.setUseGetSet(((Boolean) obj).booleanValue());
                return;
            case 11:
                databaseFieldConfig.setUnknownEnumValue(DatabaseFieldConfig.findMatchingEnumVal(field, (String) obj));
                return;
            case 12:
                databaseFieldConfig.setThrowIfNull(((Boolean) obj).booleanValue());
                return;
            case 13:
                databaseFieldConfig.setPersisted(((Boolean) obj).booleanValue());
                return;
            case 14:
                databaseFieldConfig.setFormat(valueIfNotBlank((String) obj));
                return;
            case 15:
                databaseFieldConfig.setUnique(((Boolean) obj).booleanValue());
                return;
            case 16:
                databaseFieldConfig.setUniqueCombo(((Boolean) obj).booleanValue());
                return;
            case 17:
                databaseFieldConfig.setIndex(((Boolean) obj).booleanValue());
                return;
            case 18:
                databaseFieldConfig.setUniqueIndex(((Boolean) obj).booleanValue());
                return;
            case 19:
                databaseFieldConfig.setIndexName(valueIfNotBlank((String) obj));
                return;
            case 20:
                databaseFieldConfig.setUniqueIndexName(valueIfNotBlank((String) obj));
                return;
            case 21:
                databaseFieldConfig.setForeignAutoRefresh(((Boolean) obj).booleanValue());
                return;
            case 22:
                databaseFieldConfig.setMaxForeignAutoRefreshLevel(((Integer) obj).intValue());
                return;
            case 23:
                databaseFieldConfig.setPersisterClass((Class) obj);
                return;
            case 24:
                databaseFieldConfig.setAllowGeneratedIdInsert(((Boolean) obj).booleanValue());
                return;
            case 25:
                databaseFieldConfig.setColumnDefinition(valueIfNotBlank((String) obj));
                return;
            case 26:
                databaseFieldConfig.setForeignAutoCreate(((Boolean) obj).booleanValue());
                return;
            case 27:
                databaseFieldConfig.setVersion(((Boolean) obj).booleanValue());
                return;
            case 28:
                databaseFieldConfig.setForeignColumnName(valueIfNotBlank((String) obj));
                return;
            case 29:
                databaseFieldConfig.setReadOnly(((Boolean) obj).booleanValue());
                return;
            default:
                throw new IllegalStateException("Could not find support for DatabaseField number " + i);
        }
    }

    private static DatabaseFieldConfig buildConfig(DatabaseField databaseField, String str, Field field) throws Exception {
        Object obj;
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(databaseField);
        if (invocationHandler.getClass() != annotationFactoryClazz || (obj = elementsField.get(invocationHandler)) == null) {
            return null;
        }
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig(field.getName());
        Object[] objArr = (Object[]) obj;
        int i = 0;
        while (true) {
            int[] iArr = configFieldNums;
            if (i >= iArr.length) {
                return databaseFieldConfig;
            }
            Object obj2 = valueField.get(objArr[i]);
            if (obj2 != null) {
                assignConfigField(iArr[i], databaseFieldConfig, field, obj2);
            }
            i++;
        }
    }

    private static int configFieldNameToNum(String str) {
        if (str.equals("columnName")) {
            return 1;
        }
        if (str.equals("dataType")) {
            return 2;
        }
        if (str.equals("defaultValue")) {
            return 3;
        }
        if (str.equals(VideoCaptureFormat.keyWidth)) {
            return 4;
        }
        if (str.equals("canBeNull")) {
            return 5;
        }
        if (str.equals(TtmlNode.ATTR_ID)) {
            return 6;
        }
        if (str.equals("generatedId")) {
            return 7;
        }
        if (str.equals("generatedIdSequence")) {
            return 8;
        }
        if (str.equals("foreign")) {
            return 9;
        }
        if (str.equals("useGetSet")) {
            return 10;
        }
        if (str.equals("unknownEnumName")) {
            return 11;
        }
        if (str.equals("throwIfNull")) {
            return 12;
        }
        if (str.equals("persisted")) {
            return 13;
        }
        if (str.equals(VideoCaptureFormat.keyFormat)) {
            return 14;
        }
        if (str.equals("unique")) {
            return 15;
        }
        if (str.equals("uniqueCombo")) {
            return 16;
        }
        if (str.equals(FirebaseAnalytics.Param.INDEX)) {
            return 17;
        }
        if (str.equals("uniqueIndex")) {
            return 18;
        }
        if (str.equals("indexName")) {
            return 19;
        }
        if (str.equals("uniqueIndexName")) {
            return 20;
        }
        if (str.equals("foreignAutoRefresh")) {
            return 21;
        }
        if (str.equals("maxForeignAutoRefreshLevel")) {
            return 22;
        }
        if (str.equals("persisterClass")) {
            return 23;
        }
        if (str.equals("allowGeneratedIdInsert")) {
            return 24;
        }
        if (str.equals("columnDefinition")) {
            return 25;
        }
        if (str.equals("foreignAutoCreate")) {
            return 26;
        }
        if (str.equals("version")) {
            return 27;
        }
        if (str.equals("foreignColumnName")) {
            return 28;
        }
        if (str.equals("readOnly")) {
            return 29;
        }
        throw new IllegalStateException("Could not find support for DatabaseField " + str);
    }

    private static DatabaseFieldConfig configFromField(DatabaseType databaseType, String str, Field field) throws SQLException {
        if (configFieldNums == null) {
            return DatabaseFieldConfig.fromField(databaseType, str, field);
        }
        DatabaseField databaseField = (DatabaseField) field.getAnnotation(DatabaseField.class);
        DatabaseFieldConfig databaseFieldConfigBuildConfig = null;
        if (databaseField != null) {
            try {
                databaseFieldConfigBuildConfig = buildConfig(databaseField, str, field);
            } catch (Exception unused) {
            }
        }
        if (databaseFieldConfigBuildConfig == null) {
            return DatabaseFieldConfig.fromField(databaseType, str, field);
        }
        workedC++;
        return databaseFieldConfigBuildConfig;
    }

    public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        String strExtractTableName = DatabaseTableConfig.extractTableName(cls);
        ArrayList arrayList = new ArrayList();
        for (Class<T> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                DatabaseFieldConfig databaseFieldConfigConfigFromField = configFromField(databaseType, strExtractTableName, field);
                if (databaseFieldConfigConfigFromField != null && databaseFieldConfigConfigFromField.isPersisted()) {
                    arrayList.add(databaseFieldConfigConfigFromField);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return new DatabaseTableConfig<>(cls, strExtractTableName, arrayList);
    }

    public static int getWorkedC() {
        return workedC;
    }

    private static int[] lookupClasses() throws NoSuchFieldException, ClassNotFoundException, IllegalArgumentException {
        Object obj;
        try {
            annotationFactoryClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationFactory");
            annotationMemberClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationMember");
            Class<?> cls = Class.forName("[Lorg.apache.harmony.lang.annotation.AnnotationMember;");
            Field declaredField = annotationFactoryClazz.getDeclaredField("elements");
            elementsField = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = annotationMemberClazz.getDeclaredField("name");
            nameField = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = annotationMemberClazz.getDeclaredField("value");
            valueField = declaredField3;
            declaredField3.setAccessible(true);
            InvocationHandler invocationHandler = Proxy.getInvocationHandler((DatabaseField) DatabaseFieldSample.class.getDeclaredField(FormField.ELEMENT).getAnnotation(DatabaseField.class));
            if (invocationHandler.getClass() == annotationFactoryClazz && (obj = elementsField.get(invocationHandler)) != null && obj.getClass() == cls) {
                Object[] objArr = (Object[]) obj;
                int[] iArr = new int[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    iArr[i] = configFieldNameToNum((String) nameField.get(objArr[i]));
                }
                return iArr;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | SecurityException unused) {
        }
        return null;
    }

    private static String valueIfNotBlank(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }
}

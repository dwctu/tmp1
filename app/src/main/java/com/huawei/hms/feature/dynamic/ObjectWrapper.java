package com.huawei.hms.feature.dynamic;

import android.os.IBinder;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class ObjectWrapper<T> extends IObjectWrapper.Stub {
    private final T a;

    private ObjectWrapper(T t) {
        this.a = t;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).a;
        }
        IBinder iBinderAsBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        int i = 0;
        for (Field field : declaredFields) {
            if (!field.isSynthetic()) {
                i++;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Got " + declaredFields.length + " fields, The number of field number should be 1.");
        }
        if (declaredFields[0].isAccessible()) {
            throw new IllegalArgumentException("The field is accessible.");
        }
        declaredFields[0].setAccessible(true);
        try {
            return (T) declaredFields[0].get(iBinderAsBinder);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Get binder failed: null or not permitted.");
        }
    }

    public static <T> IObjectWrapper wrap(T t) {
        return new ObjectWrapper(t);
    }
}

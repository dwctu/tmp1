package org.aspectj.internal.lang.reflect;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjTypeSystem;

/* loaded from: classes5.dex */
public class StringToType {
    public static Type[] commaSeparatedListToTypeArray(String str, Class cls) throws ClassNotFoundException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Type[] typeArr = new Type[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            typeArr[i] = stringToType(stringTokenizer.nextToken().trim(), cls);
            i++;
        }
        return typeArr;
    }

    private static Type makeParameterizedType(String str, Class cls) throws ClassNotFoundException {
        int iIndexOf = str.indexOf(60);
        final Class<?> cls2 = Class.forName(str.substring(0, iIndexOf), false, cls.getClassLoader());
        final Type[] typeArrCommaSeparatedListToTypeArray = commaSeparatedListToTypeArray(str.substring(iIndexOf + 1, str.lastIndexOf(62)), cls);
        return new ParameterizedType() { // from class: org.aspectj.internal.lang.reflect.StringToType.1
            @Override // java.lang.reflect.ParameterizedType
            public Type[] getActualTypeArguments() {
                return typeArrCommaSeparatedListToTypeArray;
            }

            @Override // java.lang.reflect.ParameterizedType
            public Type getOwnerType() {
                return cls2.getEnclosingClass();
            }

            @Override // java.lang.reflect.ParameterizedType
            public Type getRawType() {
                return cls2;
            }
        };
    }

    public static Type stringToType(String str, Class cls) throws ClassNotFoundException {
        try {
            return str.indexOf(SimpleComparison.LESS_THAN_OPERATION) == -1 ? AjTypeSystem.getAjType(Class.forName(str, false, cls.getClassLoader())) : makeParameterizedType(str, cls);
        } catch (ClassNotFoundException unused) {
            TypeVariable[] typeParameters = cls.getTypeParameters();
            for (int i = 0; i < typeParameters.length; i++) {
                if (typeParameters[i].getName().equals(str)) {
                    return typeParameters[i];
                }
            }
            throw new ClassNotFoundException(str);
        }
    }
}

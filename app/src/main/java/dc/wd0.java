package dc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: GenericsUtils.java */
/* loaded from: classes.dex */
public class wd0 {
    public static Type a(Class cls) {
        return b(cls, 0);
    }

    public static Type b(Class cls, int i) throws IndexOutOfBoundsException {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        return (i >= actualTypeArguments.length || i < 0) ? Object.class : actualTypeArguments[i];
    }
}

package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

/* loaded from: classes5.dex */
public abstract class FrameworkMember<T extends FrameworkMember<T>> implements Annotatable {
    public abstract Class<?> getDeclaringClass();

    public abstract int getModifiers();

    public abstract String getName();

    public abstract Class<?> getType();

    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public boolean isShadowedBy(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (isShadowedBy((FrameworkMember<T>) it.next())) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean isShadowedBy(T t);

    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }
}

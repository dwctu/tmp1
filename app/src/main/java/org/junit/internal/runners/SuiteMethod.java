package org.junit.internal.runners;

import dc.yx3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes5.dex */
public class SuiteMethod extends JUnit38ClassRunner {
    public SuiteMethod(Class<?> cls) throws Throwable {
        super(testFromSuiteMethod(cls));
    }

    public static yx3 testFromSuiteMethod(Class<?> cls) throws Exception {
        try {
            Method method = cls.getMethod("suite", new Class[0]);
            if (Modifier.isStatic(method.getModifiers())) {
                return (yx3) method.invoke(null, new Object[0]);
            }
            throw new Exception(cls.getName() + ".suite() must be static");
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}

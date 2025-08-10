package dc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ReflectionUtils.java */
/* loaded from: classes3.dex */
public class hg1 {
    public static final Logger a = Logger.getLogger(hg1.class.getName());
    public static final Method b;
    public static final Method c;
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public static final Method g;
    public static final Method h;
    public static final Method i;
    public static final Method j;
    public static Constructor k;

    static {
        Class clsG = g("java.lang.invoke.MethodHandles");
        Class clsG2 = g("java.lang.invoke.MethodHandle");
        Class clsG3 = g("java.lang.invoke.MethodHandles$Lookup");
        Class clsG4 = g("java.lang.invoke.MethodType");
        b = i(Method.class, "isDefault", new Class[0]);
        c = i(clsG, "lookup", new Class[0]);
        d = i(clsG3, "in", Class.class);
        f = i(clsG3, "unreflectSpecial", Method.class, Class.class);
        g = i(clsG3, "findSpecial", Class.class, String.class, clsG4, Class.class);
        h = i(clsG2, "bindTo", Object.class);
        i = i(clsG2, "invokeWithArguments", Object[].class);
        e = i(clsG, "privateLookupIn", Class.class, clsG3);
        j = i(clsG4, "methodType", Class.class, Class[].class);
    }

    public static Object a() throws Exception {
        return c.invoke(null, new Object[0]);
    }

    public static Object b(Class cls, Object obj) throws Exception {
        return e.invoke(null, cls, obj);
    }

    public static Constructor c() {
        if (k == null) {
            k = h(g("java.lang.invoke.MethodHandles$Lookup"), Class.class);
        }
        return k;
    }

    public static Object d(Method method) throws Exception {
        try {
            return j(b(method.getDeclaringClass(), a()), method);
        } catch (Exception unused) {
            return k(c().newInstance(method.getDeclaringClass()), method);
        }
    }

    public static Object e(Object obj, Object obj2, Object... objArr) throws Throwable {
        return i.invoke(h.invoke(obj2, obj), objArr);
    }

    public static boolean f(Method method) {
        Method method2 = b;
        if (method2 == null) {
            return false;
        }
        try {
            return ((Boolean) method2.invoke(method, new Object[0])).booleanValue();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (IllegalArgumentException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static Class g(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            a.log(Level.FINE, "Failed to lookup class: " + str, (Throwable) e2);
            return null;
        }
    }

    public static Constructor h(Class cls, Class... clsArr) throws NoSuchMethodException, SecurityException {
        if (cls == null) {
            a.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[]{cls, Arrays.toString(clsArr)});
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (Exception unused) {
            a.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[]{cls, Arrays.toString(clsArr)});
            return null;
        }
    }

    public static Method i(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            a.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[]{cls, str, Arrays.toString(clsArr)});
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception unused) {
            a.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[]{cls, str, Arrays.toString(clsArr)});
            return null;
        }
    }

    public static Object j(Object obj, Method method) throws Exception {
        return g.invoke(obj, method.getDeclaringClass(), method.getName(), j.invoke(null, method.getReturnType(), method.getParameterTypes()), method.getDeclaringClass());
    }

    public static Object k(Object obj, Method method) throws Exception {
        return f.invoke(d.invoke(obj, method.getDeclaringClass()), method, method.getDeclaringClass());
    }
}

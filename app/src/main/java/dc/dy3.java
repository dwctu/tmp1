package dc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.internal.MethodSorter;

/* compiled from: TestSuite.java */
/* loaded from: classes4.dex */
public class dy3 implements yx3 {
    public String a;
    public Vector<yx3> b = new Vector<>(10);

    /* compiled from: TestSuite.java */
    public static class a extends zx3 {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(str);
            this.b = str2;
        }

        @Override // dc.zx3
        public void h() {
            zx3.e(this.b);
            throw null;
        }
    }

    public dy3() {
    }

    public static yx3 f(Class<?> cls, String str) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        try {
            Constructor<?> constructorI = i(cls);
            try {
                if (constructorI.getParameterTypes().length == 0) {
                    objNewInstance = constructorI.newInstance(new Object[0]);
                    if (objNewInstance instanceof zx3) {
                        ((zx3) objNewInstance).i(str);
                    }
                } else {
                    objNewInstance = constructorI.newInstance(str);
                }
                return (yx3) objNewInstance;
            } catch (IllegalAccessException e) {
                return p("Cannot access test case: " + str + " (" + g(e) + ")");
            } catch (InstantiationException e2) {
                return p("Cannot instantiate test case: " + str + " (" + g(e2) + ")");
            } catch (InvocationTargetException e3) {
                return p("Exception in constructor: " + str + " (" + g(e3.getTargetException()) + ")");
            }
        } catch (NoSuchMethodException unused) {
            return p("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    public static String g(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static Constructor<?> i(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    public static yx3 p(String str) {
        return new a("warning", str);
    }

    @Override // dc.yx3
    public int a() {
        Iterator<yx3> it = this.b.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += it.next().a();
        }
        return iA;
    }

    @Override // dc.yx3
    public void b(cy3 cy3Var) {
        Iterator<yx3> it = this.b.iterator();
        while (it.hasNext()) {
            yx3 next = it.next();
            if (cy3Var.h()) {
                return;
            } else {
                l(next, cy3Var);
            }
        }
    }

    public void c(yx3 yx3Var) {
        this.b.add(yx3Var);
    }

    public final void d(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (list.contains(name)) {
            return;
        }
        if (j(method)) {
            list.add(name);
            c(f(cls, name));
        } else if (k(method)) {
            c(p("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
        }
    }

    public final void e(Class<?> cls) throws SecurityException {
        this.a = cls.getName();
        try {
            i(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                c(p("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = cls; yx3.class.isAssignableFrom(superclass); superclass = superclass.getSuperclass()) {
                for (Method method : MethodSorter.getDeclaredMethods(superclass)) {
                    d(method, arrayList, cls);
                }
            }
            if (this.b.size() == 0) {
                c(p("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            c(p("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public String h() {
        return this.a;
    }

    public final boolean j(Method method) {
        return k(method) && Modifier.isPublic(method.getModifiers());
    }

    public final boolean k(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }

    public void l(yx3 yx3Var, cy3 cy3Var) {
        yx3Var.b(cy3Var);
    }

    public void m(String str) {
        this.a = str;
    }

    public yx3 n(int i) {
        return this.b.get(i);
    }

    public int o() {
        return this.b.size();
    }

    public String toString() {
        return h() != null ? h() : super.toString();
    }

    public dy3(Class<?> cls) throws SecurityException {
        e(cls);
    }

    public dy3(String str) {
        m(str);
    }
}

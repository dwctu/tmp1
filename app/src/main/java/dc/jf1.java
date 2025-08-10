package dc;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ClassFactory.java */
/* loaded from: classes3.dex */
public abstract class jf1<T> {

    /* compiled from: ClassFactory.java */
    public class a extends jf1<T> {
        public final /* synthetic */ Constructor a;
        public final /* synthetic */ Class b;

        public a(Constructor constructor, Class cls) {
            this.a = constructor;
            this.b = cls;
        }

        @Override // dc.jf1
        public T b() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            return (T) this.a.newInstance(null);
        }

        public String toString() {
            return this.b.getName();
        }
    }

    /* compiled from: ClassFactory.java */
    public class b extends jf1<T> {
        public final /* synthetic */ Method a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Class c;

        public b(Method method, Object obj, Class cls) {
            this.a = method;
            this.b = obj;
            this.c = cls;
        }

        @Override // dc.jf1
        public T b() throws IllegalAccessException, InvocationTargetException {
            return (T) this.a.invoke(this.b, this.c);
        }

        public String toString() {
            return this.c.getName();
        }
    }

    /* compiled from: ClassFactory.java */
    public class c extends jf1<T> {
        public final /* synthetic */ Method a;
        public final /* synthetic */ Class b;
        public final /* synthetic */ int c;

        public c(Method method, Class cls, int i) {
            this.a = method;
            this.b = cls;
            this.c = i;
        }

        @Override // dc.jf1
        public T b() throws IllegalAccessException, InvocationTargetException {
            return (T) this.a.invoke(null, this.b, Integer.valueOf(this.c));
        }

        public String toString() {
            return this.b.getName();
        }
    }

    /* compiled from: ClassFactory.java */
    public class d extends jf1<T> {
        public final /* synthetic */ Method a;
        public final /* synthetic */ Class b;

        public d(Method method, Class cls) {
            this.a = method;
            this.b = cls;
        }

        @Override // dc.jf1
        public T b() throws IllegalAccessException, InvocationTargetException {
            return (T) this.a.invoke(null, this.b, Object.class);
        }

        public String toString() {
            return this.b.getName();
        }
    }

    public static <T> jf1<T> a(Class<?> cls) throws NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return new a(declaredConstructor, cls);
        } catch (NoSuchMethodException unused) {
            try {
                Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                Field declaredField = cls2.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return new b(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null), cls);
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused2) {
                try {
                    try {
                        Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                        declaredMethod.setAccessible(true);
                        int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                        Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                        declaredMethod2.setAccessible(true);
                        return new c(declaredMethod2, cls, iIntValue);
                    } catch (IllegalAccessException unused3) {
                        throw new AssertionError();
                    } catch (NoSuchMethodException unused4) {
                        Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                        declaredMethod3.setAccessible(true);
                        return new d(declaredMethod3, cls);
                    } catch (InvocationTargetException e) {
                        cg1.q(e);
                        throw null;
                    }
                } catch (Exception unused5) {
                    throw new IllegalArgumentException("cannot construct instances of " + cls.getName());
                }
            } catch (IllegalAccessException unused6) {
                throw new AssertionError();
            }
        }
    }

    public abstract T b() throws IllegalAccessException, InstantiationException, InvocationTargetException;
}

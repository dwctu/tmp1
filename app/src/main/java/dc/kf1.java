package dc;

import dc.nf1;
import dc.qf1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: ClassJsonAdapter.java */
/* loaded from: classes3.dex */
public final class kf1<T> extends nf1<T> {
    public static final nf1.d d = new a();
    public final jf1<T> a;
    public final b<?>[] b;
    public final qf1.a c;

    /* compiled from: ClassJsonAdapter.java */
    public class a implements nf1.d {
        @Override // dc.nf1.d
        public nf1<?> a(Type type, Set<? extends Annotation> set, yf1 yf1Var) throws NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> clsG = ag1.g(type);
            if (clsG.isInterface() || clsG.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (cg1.i(clsG)) {
                String str = "Platform " + clsG;
                if (type instanceof ParameterizedType) {
                    str = str + " in " + type;
                }
                throw new IllegalArgumentException(str + " requires explicit JsonAdapter to be registered");
            }
            if (clsG.isAnonymousClass()) {
                throw new IllegalArgumentException("Cannot serialize anonymous class " + clsG.getName());
            }
            if (clsG.isLocalClass()) {
                throw new IllegalArgumentException("Cannot serialize local class " + clsG.getName());
            }
            if (clsG.getEnclosingClass() != null && !Modifier.isStatic(clsG.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize non-static nested class " + clsG.getName());
            }
            if (Modifier.isAbstract(clsG.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize abstract class " + clsG.getName());
            }
            if (cg1.h(clsG)) {
                throw new IllegalArgumentException("Cannot serialize Kotlin type " + clsG.getName() + ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapter from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
            }
            jf1 jf1VarA = jf1.a(clsG);
            TreeMap treeMap = new TreeMap();
            while (type != Object.class) {
                b(yf1Var, type, treeMap);
                type = ag1.f(type);
            }
            return new kf1(jf1VarA, treeMap).f();
        }

        public final void b(yf1 yf1Var, Type type, Map<String, b<?>> map) {
            Class<?> clsG = ag1.g(type);
            boolean zI = cg1.i(clsG);
            for (Field field : clsG.getDeclaredFields()) {
                if (c(zI, field.getModifiers())) {
                    Type typeN = cg1.n(type, clsG, field.getGenericType());
                    Set<? extends Annotation> setJ = cg1.j(field);
                    String name = field.getName();
                    nf1<T> nf1VarF = yf1Var.f(typeN, setJ, name);
                    field.setAccessible(true);
                    mf1 mf1Var = (mf1) field.getAnnotation(mf1.class);
                    if (mf1Var != null) {
                        name = mf1Var.name();
                    }
                    b<?> bVar = new b<>(name, field, nf1VarF);
                    b<?> bVarPut = map.put(name, bVar);
                    if (bVarPut != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + bVarPut.b + "\n    " + bVar.b);
                    }
                }
            }
        }

        public final boolean c(boolean z, int i) {
            if (Modifier.isStatic(i) || Modifier.isTransient(i)) {
                return false;
            }
            return Modifier.isPublic(i) || Modifier.isProtected(i) || !z;
        }
    }

    /* compiled from: ClassJsonAdapter.java */
    public static class b<T> {
        public final String a;
        public final Field b;
        public final nf1<T> c;

        public b(String str, Field field, nf1<T> nf1Var) {
            this.a = str;
            this.b = field;
            this.c = nf1Var;
        }

        public void a(qf1 qf1Var, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
            this.b.set(obj, this.c.b(qf1Var));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(vf1 vf1Var, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
            this.c.h(vf1Var, this.b.get(obj));
        }
    }

    public kf1(jf1<T> jf1Var, Map<String, b<?>> map) {
        this.a = jf1Var;
        this.b = (b[]) map.values().toArray(new b[map.size()]);
        this.c = qf1.a.a((String[]) map.keySet().toArray(new String[map.size()]));
    }

    @Override // dc.nf1
    public T b(qf1 qf1Var) throws IOException, IllegalArgumentException {
        try {
            T tB = this.a.b();
            try {
                qf1Var.e();
                while (qf1Var.p()) {
                    int iB0 = qf1Var.b0(this.c);
                    if (iB0 == -1) {
                        qf1Var.g0();
                        qf1Var.h0();
                    } else {
                        this.b[iB0].a(qf1Var, tB);
                    }
                }
                qf1Var.j();
                return tB;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            cg1.q(e2);
            throw null;
        }
    }

    @Override // dc.nf1
    public void h(vf1 vf1Var, T t) throws IOException, IllegalArgumentException {
        try {
            vf1Var.e();
            for (b<?> bVar : this.b) {
                vf1Var.x(bVar.a);
                bVar.b(vf1Var, t);
            }
            vf1Var.m();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.a + ")";
    }
}

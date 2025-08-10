package dc;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.squareup.moshi.JsonDataException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* compiled from: Util.java */
/* loaded from: classes3.dex */
public final class cg1 {
    public static final Set<Annotation> a = Collections.emptySet();
    public static final Type[] b = new Type[0];
    public static final Class<? extends Annotation> c;

    /* compiled from: Util.java */
    public static final class a implements GenericArrayType {
        public final Type a;

        public a(Type type) {
            this.a = cg1.a(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && ag1.d(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return cg1.s(this.a) + "[]";
        }
    }

    /* compiled from: Util.java */
    public static final class b implements ParameterizedType {
        public final Type a;
        public final Type b;
        public final Type[] c;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || ag1.g(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            this.a = type == null ? null : cg1.a(type);
            this.b = cg1.a(type2);
            this.c = (Type[]) typeArr.clone();
            int i = 0;
            while (true) {
                Type[] typeArr2 = this.c;
                if (i >= typeArr2.length) {
                    return;
                }
                Objects.requireNonNull(typeArr2[i]);
                cg1.b(typeArr2[i]);
                Type[] typeArr3 = this.c;
                typeArr3[i] = cg1.a(typeArr3[i]);
                i++;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && ag1.d(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ cg1.f(this.a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.c.length + 1) * 30);
            sb.append(cg1.s(this.b));
            if (this.c.length == 0) {
                return sb.toString();
            }
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(cg1.s(this.c[0]));
            for (int i = 1; i < this.c.length; i++) {
                sb.append(", ");
                sb.append(cg1.s(this.c[i]));
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            return sb.toString();
        }
    }

    /* compiled from: Util.java */
    public static final class c implements WildcardType {
        public final Type a;
        public final Type b;

        public c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                Objects.requireNonNull(typeArr[0]);
                cg1.b(typeArr[0]);
                this.b = null;
                this.a = cg1.a(typeArr[0]);
                return;
            }
            Objects.requireNonNull(typeArr2[0]);
            cg1.b(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.b = cg1.a(typeArr2[0]);
            this.a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && ag1.d(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.b;
            return type != null ? new Type[]{type} : cg1.b;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.a};
        }

        public int hashCode() {
            Type type = this.b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
        }

        public String toString() {
            if (this.b != null) {
                return "? super " + cg1.s(this.b);
            }
            if (this.a == Object.class) {
                return "?";
            }
            return "? extends " + cg1.s(this.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Class cls;
        try {
            cls = Class.forName("kotlin.Metadata");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        c = cls;
        try {
            Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
        } catch (ClassNotFoundException unused2) {
        }
    }

    public static Type a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(a(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            if (type instanceof b) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return type instanceof a ? type : new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType) || (type instanceof c)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static void b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    public static Class<?> c(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static nf1<?> d(yf1 yf1Var, Type type, Class<?> cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Constructor<?> declaredConstructor;
        Object[] objArr;
        of1 of1Var = (of1) cls.getAnnotation(of1.class);
        if (of1Var == null || !of1Var.generateAdapter()) {
            return null;
        }
        try {
            try {
                Class<?> cls2 = Class.forName(ag1.e(cls.getName()), true, cls.getClassLoader());
                if (type instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                    try {
                        declaredConstructor = cls2.getDeclaredConstructor(yf1.class, Type[].class);
                        objArr = new Object[]{yf1Var, actualTypeArguments};
                    } catch (NoSuchMethodException unused) {
                        declaredConstructor = cls2.getDeclaredConstructor(Type[].class);
                        objArr = new Object[]{actualTypeArguments};
                    }
                } else {
                    try {
                        declaredConstructor = cls2.getDeclaredConstructor(yf1.class);
                        objArr = new Object[]{yf1Var};
                    } catch (NoSuchMethodException unused2) {
                        declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                        objArr = new Object[0];
                    }
                }
                declaredConstructor.setAccessible(true);
                return ((nf1) declaredConstructor.newInstance(objArr)).f();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Failed to find the generated JsonAdapter class for " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access the generated JsonAdapter for " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to instantiate the generated JsonAdapter for " + cls, e3);
            } catch (InvocationTargetException e4) {
                q(e4);
                throw null;
            }
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("Failed to find the generated JsonAdapter constructor for " + cls, e5);
        }
    }

    public static Type e(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return e(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return e(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static int f(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int g(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean h(Class<?> cls) {
        Class<? extends Annotation> cls2 = c;
        return cls2 != null && cls.isAnnotationPresent(cls2);
    }

    public static boolean i(Class<?> cls) {
        String name = cls.getName();
        return name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static Set<? extends Annotation> j(AnnotatedElement annotatedElement) {
        return k(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> k(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(pf1.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        return linkedHashSet != null ? Collections.unmodifiableSet(linkedHashSet) : a;
    }

    public static JsonDataException l(String str, String str2, qf1 qf1Var) {
        String path = qf1Var.getPath();
        return new JsonDataException(str2.equals(str) ? String.format("Required value '%s' missing at %s", str, path) : String.format("Required value '%s' (JSON name '%s') missing at %s", str, str2, path));
    }

    public static Type m(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return upperBounds[0];
        }
        throw new IllegalArgumentException();
    }

    public static Type n(Type type, Class<?> cls, Type type2) {
        return o(type, cls, type2, new LinkedHashSet());
    }

    public static Type o(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        while (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            if (collection.contains(typeVariable)) {
                return type2;
            }
            collection.add(typeVariable);
            type2 = p(type, cls, typeVariable);
            if (type2 == typeVariable) {
                return type2;
            }
        }
        if (type2 instanceof Class) {
            Class cls2 = (Class) type2;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type typeO = o(type, cls, componentType, collection);
                return componentType == typeO ? cls2 : ag1.b(typeO);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeO2 = o(type, cls, genericComponentType, collection);
            return genericComponentType == typeO2 ? genericArrayType : ag1.b(typeO2);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeO3 = o(type, cls, ownerType, collection);
            boolean z = typeO3 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i = 0; i < length; i++) {
                Type typeO4 = o(type, cls, actualTypeArguments[i], collection);
                if (typeO4 != actualTypeArguments[i]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i] = typeO4;
                }
            }
            return z ? new b(typeO3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z2 = type2 instanceof WildcardType;
        Type type3 = type2;
        if (z2) {
            WildcardType wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeO5 = o(type, cls, lowerBounds[0], collection);
                type3 = wildcardType;
                if (typeO5 != lowerBounds[0]) {
                    return ag1.k(typeO5);
                }
            } else {
                type3 = wildcardType;
                if (upperBounds.length == 1) {
                    Type typeO6 = o(type, cls, upperBounds[0], collection);
                    type3 = wildcardType;
                    if (typeO6 != upperBounds[0]) {
                        return ag1.j(typeO6);
                    }
                }
            }
        }
        return type3;
    }

    public static Type p(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsC = c(typeVariable);
        if (clsC == null) {
            return typeVariable;
        }
        Type typeE = e(type, cls, clsC);
        if (!(typeE instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeE).getActualTypeArguments()[g(clsC.getTypeParameters(), typeVariable)];
    }

    public static RuntimeException q(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        if (targetException instanceof RuntimeException) {
            throw ((RuntimeException) targetException);
        }
        if (targetException instanceof Error) {
            throw ((Error) targetException);
        }
        throw new RuntimeException(targetException);
    }

    public static String r(Type type, Set<? extends Annotation> set) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        if (set.isEmpty()) {
            str = " (with no annotations)";
        } else {
            str = " annotated " + set;
        }
        sb.append(str);
        return sb.toString();
    }

    public static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static JsonDataException t(String str, String str2, qf1 qf1Var) {
        String path = qf1Var.getPath();
        return new JsonDataException(str2.equals(str) ? String.format("Non-null value '%s' was null at %s", str, path) : String.format("Non-null value '%s' (JSON name '%s') was null at %s", str, str2, path));
    }
}

package dc;

import com.samsung.android.sdk.bt.gatt.BluetoothGatt;
import com.squareup.moshi.JsonDataException;
import dc.nf1;
import dc.qf1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.text.Typography;

/* compiled from: StandardJsonAdapters.java */
/* loaded from: classes3.dex */
public final class zf1 {
    public static final nf1.d a = new c();
    public static final nf1<Boolean> b = new d();
    public static final nf1<Byte> c = new e();
    public static final nf1<Character> d = new f();
    public static final nf1<Double> e = new g();
    public static final nf1<Float> f = new h();
    public static final nf1<Integer> g = new i();
    public static final nf1<Long> h = new j();
    public static final nf1<Short> i = new k();
    public static final nf1<String> j = new a();

    /* compiled from: StandardJsonAdapters.java */
    public class a extends nf1<String> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public String b(qf1 qf1Var) throws IOException {
            return qf1Var.K();
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, String str) throws IOException {
            vf1Var.e0(str);
        }

        public String toString() {
            return "JsonAdapter(String)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[qf1.b.values().length];
            a = iArr;
            try {
                iArr[qf1.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[qf1.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[qf1.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[qf1.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[qf1.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[qf1.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class c implements nf1.d {
        @Override // dc.nf1.d
        public nf1<?> a(Type type, Set<? extends Annotation> set, yf1 yf1Var) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return zf1.b;
            }
            if (type == Byte.TYPE) {
                return zf1.c;
            }
            if (type == Character.TYPE) {
                return zf1.d;
            }
            if (type == Double.TYPE) {
                return zf1.e;
            }
            if (type == Float.TYPE) {
                return zf1.f;
            }
            if (type == Integer.TYPE) {
                return zf1.g;
            }
            if (type == Long.TYPE) {
                return zf1.h;
            }
            if (type == Short.TYPE) {
                return zf1.i;
            }
            if (type == Boolean.class) {
                return zf1.b.f();
            }
            if (type == Byte.class) {
                return zf1.c.f();
            }
            if (type == Character.class) {
                return zf1.d.f();
            }
            if (type == Double.class) {
                return zf1.e.f();
            }
            if (type == Float.class) {
                return zf1.f.f();
            }
            if (type == Integer.class) {
                return zf1.g.f();
            }
            if (type == Long.class) {
                return zf1.h.f();
            }
            if (type == Short.class) {
                return zf1.i.f();
            }
            if (type == String.class) {
                return zf1.j.f();
            }
            if (type == Object.class) {
                return new m(yf1Var).f();
            }
            Class<?> clsG = ag1.g(type);
            nf1<?> nf1VarD = cg1.d(yf1Var, type, clsG);
            if (nf1VarD != null) {
                return nf1VarD;
            }
            if (clsG.isEnum()) {
                return new l(clsG).f();
            }
            return null;
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class d extends nf1<Boolean> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean b(qf1 qf1Var) throws IOException {
            return Boolean.valueOf(qf1Var.x());
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, Boolean bool) throws IOException {
            vf1Var.f0(bool.booleanValue());
        }

        public String toString() {
            return "JsonAdapter(Boolean)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class e extends nf1<Byte> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Byte b(qf1 qf1Var) throws IOException {
            return Byte.valueOf((byte) zf1.a(qf1Var, "a byte", BluetoothGatt.GATT_NO_RESOURCES, 255));
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, Byte b) throws IOException {
            vf1Var.b0(b.intValue() & 255);
        }

        public String toString() {
            return "JsonAdapter(Byte)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class f extends nf1<Character> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Character b(qf1 qf1Var) throws IOException {
            String strK = qf1Var.K();
            if (strK.length() <= 1) {
                return Character.valueOf(strK.charAt(0));
            }
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", "a char", Typography.quote + strK + Typography.quote, qf1Var.getPath()));
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, Character ch) throws IOException {
            vf1Var.e0(ch.toString());
        }

        public String toString() {
            return "JsonAdapter(Character)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class g extends nf1<Double> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Double b(qf1 qf1Var) throws IOException {
            return Double.valueOf(qf1Var.y());
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, Double d) throws IOException {
            vf1Var.X(d.doubleValue());
        }

        public String toString() {
            return "JsonAdapter(Double)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class h extends nf1<Float> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Float b(qf1 qf1Var) throws IOException {
            float fY = (float) qf1Var.y();
            if (qf1Var.q() || !Float.isInfinite(fY)) {
                return Float.valueOf(fY);
            }
            throw new JsonDataException("JSON forbids NaN and infinities: " + fY + " at path " + qf1Var.getPath());
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, Float f) throws IOException {
            Objects.requireNonNull(f);
            vf1Var.d0(f);
        }

        public String toString() {
            return "JsonAdapter(Float)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class i extends nf1<Integer> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer b(qf1 qf1Var) throws IOException {
            return Integer.valueOf(qf1Var.A());
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, Integer num) throws IOException {
            vf1Var.b0(num.intValue());
        }

        public String toString() {
            return "JsonAdapter(Integer)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class j extends nf1<Long> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Long b(qf1 qf1Var) throws IOException {
            return Long.valueOf(qf1Var.C());
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, Long l) throws IOException {
            vf1Var.b0(l.longValue());
        }

        public String toString() {
            return "JsonAdapter(Long)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public class k extends nf1<Short> {
        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Short b(qf1 qf1Var) throws IOException {
            return Short.valueOf((short) zf1.a(qf1Var, "a short", -32768, 32767));
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, Short sh) throws IOException {
            vf1Var.b0(sh.intValue());
        }

        public String toString() {
            return "JsonAdapter(Short)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public static final class l<T extends Enum<T>> extends nf1<T> {
        public final Class<T> a;
        public final String[] b;
        public final T[] c;
        public final qf1.a d;

        public l(Class<T> cls) {
            this.a = cls;
            try {
                T[] enumConstants = cls.getEnumConstants();
                this.c = enumConstants;
                this.b = new String[enumConstants.length];
                int i = 0;
                while (true) {
                    T[] tArr = this.c;
                    if (i >= tArr.length) {
                        this.d = qf1.a.a(this.b);
                        return;
                    }
                    T t = tArr[i];
                    mf1 mf1Var = (mf1) cls.getField(t.name()).getAnnotation(mf1.class);
                    this.b[i] = mf1Var != null ? mf1Var.name() : t.name();
                    i++;
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError("Missing field in " + cls.getName(), e);
            }
        }

        @Override // dc.nf1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public T b(qf1 qf1Var) throws IOException {
            int iD0 = qf1Var.d0(this.d);
            if (iD0 != -1) {
                return this.c[iD0];
            }
            String path = qf1Var.getPath();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.b) + " but was " + qf1Var.K() + " at path " + path);
        }

        @Override // dc.nf1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(vf1 vf1Var, T t) throws IOException {
            vf1Var.e0(this.b[t.ordinal()]);
        }

        public String toString() {
            return "JsonAdapter(" + this.a.getName() + ")";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    public static final class m extends nf1<Object> {
        public final yf1 a;
        public final nf1<List> b;
        public final nf1<Map> c;
        public final nf1<String> d;
        public final nf1<Double> e;
        public final nf1<Boolean> f;

        public m(yf1 yf1Var) {
            this.a = yf1Var;
            this.b = yf1Var.c(List.class);
            this.c = yf1Var.c(Map.class);
            this.d = yf1Var.c(String.class);
            this.e = yf1Var.c(Double.class);
            this.f = yf1Var.c(Boolean.class);
        }

        @Override // dc.nf1
        public Object b(qf1 qf1Var) throws IOException {
            switch (b.a[qf1Var.O().ordinal()]) {
                case 1:
                    return this.b.b(qf1Var);
                case 2:
                    return this.c.b(qf1Var);
                case 3:
                    return this.d.b(qf1Var);
                case 4:
                    return this.e.b(qf1Var);
                case 5:
                    return this.f.b(qf1Var);
                case 6:
                    return qf1Var.I();
                default:
                    throw new IllegalStateException("Expected a value but was " + qf1Var.O() + " at path " + qf1Var.getPath());
            }
        }

        @Override // dc.nf1
        public void h(vf1 vf1Var, Object obj) throws IOException {
            Class<?> cls = obj.getClass();
            if (cls != Object.class) {
                this.a.e(i(cls), cg1.a).h(vf1Var, obj);
            } else {
                vf1Var.e();
                vf1Var.m();
            }
        }

        public final Class<?> i(Class<?> cls) {
            return Map.class.isAssignableFrom(cls) ? Map.class : Collection.class.isAssignableFrom(cls) ? Collection.class : cls;
        }

        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

    public static int a(qf1 qf1Var, String str, int i2, int i3) throws IOException {
        int iA = qf1Var.A();
        if (iA < i2 || iA > i3) {
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", str, Integer.valueOf(iA), qf1Var.getPath()));
        }
        return iA;
    }
}

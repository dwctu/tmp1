package dc;

import com.squareup.moshi.JsonDataException;
import dc.qf1;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.AbstractMap;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinJsonAdapter.kt */
/* loaded from: classes3.dex */
public final class dg1<T> extends nf1<T> {

    @NotNull
    public final KFunction<T> a;

    @NotNull
    public final List<a<T, Object>> b;

    @NotNull
    public final List<a<T, Object>> c;

    @NotNull
    public final qf1.a d;

    /* compiled from: KotlinJsonAdapter.kt */
    public static final class a<K, P> {

        @NotNull
        public final String a;

        @Nullable
        public final String b;

        @NotNull
        public final nf1<P> c;

        @NotNull
        public final KProperty1<K, P> d;

        @Nullable
        public final KParameter e;
        public final int f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull String name, @Nullable String str, @NotNull nf1<P> adapter, @NotNull KProperty1<K, ? extends P> property, @Nullable KParameter kParameter, int i) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(adapter, "adapter");
            Intrinsics.checkParameterIsNotNull(property, "property");
            this.a = name;
            this.b = str;
            this.c = adapter;
            this.d = property;
            this.e = kParameter;
            this.f = i;
        }

        public static /* synthetic */ a b(a aVar, String str, String str2, nf1 nf1Var, KProperty1 kProperty1, KParameter kParameter, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = aVar.a;
            }
            if ((i2 & 2) != 0) {
                str2 = aVar.b;
            }
            String str3 = str2;
            if ((i2 & 4) != 0) {
                nf1Var = aVar.c;
            }
            nf1 nf1Var2 = nf1Var;
            if ((i2 & 8) != 0) {
                kProperty1 = aVar.d;
            }
            KProperty1 kProperty12 = kProperty1;
            if ((i2 & 16) != 0) {
                kParameter = aVar.e;
            }
            KParameter kParameter2 = kParameter;
            if ((i2 & 32) != 0) {
                i = aVar.f;
            }
            return aVar.a(str, str3, nf1Var2, kProperty12, kParameter2, i);
        }

        @NotNull
        public final a<K, P> a(@NotNull String name, @Nullable String str, @NotNull nf1<P> adapter, @NotNull KProperty1<K, ? extends P> property, @Nullable KParameter kParameter, int i) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(adapter, "adapter");
            Intrinsics.checkParameterIsNotNull(property, "property");
            return new a<>(name, str, adapter, property, kParameter, i);
        }

        public final P c(K k) {
            return this.d.get(k);
        }

        @NotNull
        public final nf1<P> d() {
            return this.c;
        }

        @Nullable
        public final String e() {
            return this.b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e)) {
                        if (this.f == aVar.f) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final String f() {
            return this.a;
        }

        @NotNull
        public final KProperty1<K, P> g() {
            return this.d;
        }

        public final int h() {
            return this.f;
        }

        public int hashCode() {
            String str = this.a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            nf1<P> nf1Var = this.c;
            int iHashCode3 = (iHashCode2 + (nf1Var != null ? nf1Var.hashCode() : 0)) * 31;
            KProperty1<K, P> kProperty1 = this.d;
            int iHashCode4 = (iHashCode3 + (kProperty1 != null ? kProperty1.hashCode() : 0)) * 31;
            KParameter kParameter = this.e;
            return ((iHashCode4 + (kParameter != null ? kParameter.hashCode() : 0)) * 31) + this.f;
        }

        public final void i(K k, P p) {
            if (p != fg1.b) {
                KProperty1<K, P> kProperty1 = this.d;
                if (kProperty1 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KMutableProperty1<K, P>");
                }
                ((KMutableProperty1) kProperty1).set(k, p);
            }
        }

        @NotNull
        public String toString() {
            return "Binding(name=" + this.a + ", jsonName=" + this.b + ", adapter=" + this.c + ", property=" + this.d + ", parameter=" + this.e + ", propertyIndex=" + this.f + ")";
        }
    }

    /* compiled from: KotlinJsonAdapter.kt */
    public static final class b extends AbstractMap<KParameter, Object> {
        public final List<KParameter> a;
        public final Object[] b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull List<? extends KParameter> parameterKeys, @NotNull Object[] parameterValues) {
            Intrinsics.checkParameterIsNotNull(parameterKeys, "parameterKeys");
            Intrinsics.checkParameterIsNotNull(parameterValues, "parameterValues");
            this.a = parameterKeys;
            this.b = parameterValues;
        }

        public boolean a(@NotNull KParameter key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return this.b[key.getIndex()] != fg1.b;
        }

        @Nullable
        public Object b(@NotNull KParameter key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Object obj = this.b[key.getIndex()];
            if (obj != fg1.b) {
                return obj;
            }
            return null;
        }

        public /* bridge */ Object c(KParameter kParameter, Object obj) {
            return super.getOrDefault(kParameter, obj);
        }

        @Override // kotlin.collections.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof KParameter) {
                return a((KParameter) obj);
            }
            return false;
        }

        @Override // kotlin.collections.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof KParameter) {
                return b((KParameter) obj);
            }
            return null;
        }

        @Override // kotlin.collections.AbstractMap
        @NotNull
        public Set<Map.Entry<KParameter, Object>> getEntries() {
            List<KParameter> list = this.a;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new AbstractMap.SimpleEntry((KParameter) t, this.b[i]));
                i = i2;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t2 : arrayList) {
                if (((AbstractMap.SimpleEntry) t2).getValue() != fg1.b) {
                    linkedHashSet.add(t2);
                }
            }
            return linkedHashSet;
        }

        @Override // java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return obj instanceof KParameter ? c((KParameter) obj, obj2) : obj2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public dg1(@NotNull KFunction<? extends T> constructor, @NotNull List<a<T, Object>> allBindings, @NotNull List<a<T, Object>> nonTransientBindings, @NotNull qf1.a options) {
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        Intrinsics.checkParameterIsNotNull(allBindings, "allBindings");
        Intrinsics.checkParameterIsNotNull(nonTransientBindings, "nonTransientBindings");
        Intrinsics.checkParameterIsNotNull(options, "options");
        this.a = constructor;
        this.b = allBindings;
        this.c = nonTransientBindings;
        this.d = options;
    }

    @Override // dc.nf1
    public T b(@NotNull qf1 reader) throws IOException {
        Intrinsics.checkParameterIsNotNull(reader, "reader");
        int size = this.a.getParameters().size();
        int size2 = this.b.size();
        Object[] objArr = new Object[size2];
        for (int i = 0; i < size2; i++) {
            objArr[i] = fg1.b;
        }
        reader.e();
        while (reader.p()) {
            int iB0 = reader.b0(this.d);
            if (iB0 == -1) {
                reader.g0();
                reader.h0();
            } else {
                a<T, Object> aVar = this.c.get(iB0);
                int iH = aVar.h();
                if (objArr[iH] != fg1.b) {
                    throw new JsonDataException("Multiple values for '" + aVar.g().getName() + "' at " + reader.getPath());
                }
                objArr[iH] = aVar.d().b(reader);
                if (objArr[iH] == null && !aVar.g().getReturnType().isMarkedNullable()) {
                    JsonDataException jsonDataExceptionT = cg1.t(aVar.g().getName(), aVar.e(), reader);
                    Intrinsics.checkExpressionValueIsNotNull(jsonDataExceptionT, "Util.unexpectedNull(\n   …         reader\n        )");
                    throw jsonDataExceptionT;
                }
            }
        }
        reader.j();
        for (int i2 = 0; i2 < size; i2++) {
            if (objArr[i2] == fg1.b && !this.a.getParameters().get(i2).isOptional()) {
                if (!this.a.getParameters().get(i2).getType().isMarkedNullable()) {
                    String name = this.a.getParameters().get(i2).getName();
                    a<T, Object> aVar2 = this.b.get(i2);
                    JsonDataException jsonDataExceptionL = cg1.l(name, aVar2 != null ? aVar2.e() : null, reader);
                    Intrinsics.checkExpressionValueIsNotNull(jsonDataExceptionL, "Util.missingProperty(\n  …       reader\n          )");
                    throw jsonDataExceptionL;
                }
                objArr[i2] = null;
            }
        }
        T tCallBy = this.a.callBy(new b(this.a.getParameters(), objArr));
        int size3 = this.b.size();
        while (size < size3) {
            a<T, Object> aVar3 = this.b.get(size);
            if (aVar3 == null) {
                Intrinsics.throwNpe();
            }
            aVar3.i(tCallBy, objArr[size]);
            size++;
        }
        return tCallBy;
    }

    @Override // dc.nf1
    public void h(@NotNull vf1 writer, @Nullable T t) throws IOException {
        Intrinsics.checkParameterIsNotNull(writer, "writer");
        Objects.requireNonNull(t, "value == null");
        writer.e();
        for (a<T, Object> aVar : this.b) {
            if (aVar != null) {
                writer.x(aVar.f());
                aVar.d().h(writer, aVar.c(t));
            }
        }
        writer.m();
    }

    @NotNull
    public String toString() {
        return "KotlinJsonAdapter(" + this.a.getReturnType() + ')';
    }
}

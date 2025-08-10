package dc;

import com.broadcom.bt.util.io.FilenameUtils;
import dc.dg1;
import dc.nf1;
import dc.qf1;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinJsonAdapter.kt */
/* loaded from: classes3.dex */
public final class eg1 implements nf1.d {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.Object] */
    @Override // dc.nf1.d
    @Nullable
    public nf1<?> a(@NotNull Type type, @NotNull Set<? extends Annotation> annotations, @NotNull yf1 moshi) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Object next;
        String name;
        String strName;
        mf1 next2;
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(annotations, "annotations");
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        boolean z = true;
        Object obj = null;
        if (!annotations.isEmpty()) {
            return null;
        }
        Class<?> rawType = ag1.g(type);
        Intrinsics.checkExpressionValueIsNotNull(rawType, "rawType");
        if (rawType.isInterface() || rawType.isEnum() || !rawType.isAnnotationPresent(fg1.a) || cg1.i(rawType)) {
            return null;
        }
        try {
            nf1<?> nf1VarD = cg1.d(moshi, type, rawType);
            if (nf1VarD != null) {
                return nf1VarD;
            }
        } catch (RuntimeException e) {
            if (!(e.getCause() instanceof ClassNotFoundException)) {
                throw e;
            }
        }
        if (!(!rawType.isLocalClass())) {
            throw new IllegalArgumentException(("Cannot serialize local class or object expression " + rawType.getName()).toString());
        }
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(rawType);
        if (!(!kotlinClass.isAbstract())) {
            throw new IllegalArgumentException(("Cannot serialize abstract class " + rawType.getName()).toString());
        }
        if (!(!kotlinClass.isInner())) {
            throw new IllegalArgumentException(("Cannot serialize inner class " + rawType.getName()).toString());
        }
        if (!(kotlinClass.getObjectInstance() == null)) {
            throw new IllegalArgumentException(("Cannot serialize object declaration " + rawType.getName()).toString());
        }
        if (!(!kotlinClass.isSealed())) {
            throw new IllegalArgumentException(("Cannot reflectively serialize sealed class " + rawType.getName() + ". Please register an adapter.").toString());
        }
        KFunction primaryConstructor = KClasses.getPrimaryConstructor(kotlinClass);
        if (primaryConstructor == null) {
            return null;
        }
        List<KParameter> parameters = primaryConstructor.getParameters();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10)), 16));
        for (Object obj2 : parameters) {
            linkedHashMap.put(((KParameter) obj2).getName(), obj2);
        }
        KCallablesJvm.setAccessible(primaryConstructor, true);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (KProperty1 kProperty1 : KClasses.getMemberProperties(kotlinClass)) {
            KParameter kParameter = (KParameter) linkedHashMap.get(kProperty1.getName());
            Field javaField = ReflectJvmMapping.getJavaField(kProperty1);
            if (Modifier.isTransient(javaField != null ? javaField.getModifiers() : 0)) {
                if (!(kParameter == null || kParameter.isOptional())) {
                    throw new IllegalArgumentException(("No default value for transient constructor " + kParameter).toString());
                }
            } else {
                if (!(kParameter == null || Intrinsics.areEqual(kParameter.getType(), kProperty1.getReturnType()))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('\'');
                    sb.append(kProperty1.getName());
                    sb.append("' has a constructor parameter of type ");
                    if (kParameter == null) {
                        Intrinsics.throwNpe();
                    }
                    sb.append(kParameter.getType());
                    sb.append(" but a property of type ");
                    sb.append(kProperty1.getReturnType());
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                if ((kProperty1 instanceof KMutableProperty1) || kParameter != null) {
                    KCallablesJvm.setAccessible(kProperty1, z);
                    List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) kProperty1.getAnnotations());
                    Iterator it = kProperty1.getAnnotations().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = obj;
                            break;
                        }
                        next = it.next();
                        if (((Annotation) next) instanceof mf1) {
                            break;
                        }
                    }
                    mf1 mf1Var = (mf1) next;
                    if (kParameter != null) {
                        CollectionsKt__MutableCollectionsKt.addAll(mutableList, kParameter.getAnnotations());
                        if (mf1Var == null) {
                            Iterator it2 = kParameter.getAnnotations().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next2 = 0;
                                    break;
                                }
                                next2 = it2.next();
                                if (((Annotation) next2) instanceof mf1) {
                                    break;
                                }
                            }
                            mf1Var = next2;
                        }
                    }
                    if (mf1Var == null || (name = mf1Var.name()) == null) {
                        name = kProperty1.getName();
                    }
                    String str = name;
                    Type typeN = cg1.n(type, rawType, ReflectJvmMapping.getJavaType(kProperty1.getReturnType()));
                    Object[] array = mutableList.toArray(new Annotation[0]);
                    if (array == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    nf1 adapter = moshi.f(typeN, cg1.k((Annotation[]) array), kProperty1.getName());
                    String name2 = kProperty1.getName();
                    String str2 = (mf1Var == null || (strName = mf1Var.name()) == null) ? str : strName;
                    Intrinsics.checkExpressionValueIsNotNull(adapter, "adapter");
                    if (kProperty1 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, kotlin.Any?>");
                    }
                    linkedHashMap2.put(name2, new dg1.a(str, str2, adapter, kProperty1, kParameter, kParameter != null ? kParameter.getIndex() : -1));
                }
            }
            z = true;
            obj = null;
        }
        ArrayList arrayList = new ArrayList();
        for (KParameter kParameter2 : primaryConstructor.getParameters()) {
            dg1.a aVar = (dg1.a) TypeIntrinsics.asMutableMap(linkedHashMap2).remove(kParameter2.getName());
            if (!(aVar != null || kParameter2.isOptional())) {
                throw new IllegalArgumentException(("No property for required constructor " + kParameter2).toString());
            }
            arrayList.add(aVar);
        }
        int size = arrayList.size();
        Iterator it3 = linkedHashMap2.entrySet().iterator();
        while (true) {
            int i = size;
            if (!it3.hasNext()) {
                break;
            }
            size = i + 1;
            arrayList.add(dg1.a.b((dg1.a) ((Map.Entry) it3.next()).getValue(), null, null, null, null, null, i, 31, null));
        }
        List listFilterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listFilterNotNull, 10));
        Iterator it4 = listFilterNotNull.iterator();
        while (it4.hasNext()) {
            arrayList2.add(((dg1.a) it4.next()).f());
        }
        Object[] array2 = arrayList2.toArray(new String[0]);
        if (array2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array2;
        qf1.a options = qf1.a.a((String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkExpressionValueIsNotNull(options, "options");
        return new dg1(primaryConstructor, arrayList, listFilterNotNull, options).f();
    }
}

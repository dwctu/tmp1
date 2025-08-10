package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FakePureImplementationsProvider.kt */
/* loaded from: classes4.dex */
public final class FakePureImplementationsProvider {

    @NotNull
    public static final FakePureImplementationsProvider INSTANCE;

    @NotNull
    private static final Map<ClassId, ClassId> pureImplementationsClassIds;

    @NotNull
    private static final Map<FqName, FqName> pureImplementationsFqNames;

    static {
        FakePureImplementationsProvider fakePureImplementationsProvider = new FakePureImplementationsProvider();
        INSTANCE = fakePureImplementationsProvider;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        pureImplementationsClassIds = linkedHashMap;
        StandardClassIds standardClassIds = StandardClassIds.INSTANCE;
        fakePureImplementationsProvider.implementedWith(standardClassIds.getMutableList(), fakePureImplementationsProvider.fqNameListOf("java.util.ArrayList", "java.util.LinkedList"));
        fakePureImplementationsProvider.implementedWith(standardClassIds.getMutableSet(), fakePureImplementationsProvider.fqNameListOf("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        fakePureImplementationsProvider.implementedWith(standardClassIds.getMutableMap(), fakePureImplementationsProvider.fqNameListOf("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        ClassId classId = ClassId.topLevel(new FqName("java.util.function.Function"));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(\"java.util.function.Function\"))");
        fakePureImplementationsProvider.implementedWith(classId, fakePureImplementationsProvider.fqNameListOf("java.util.function.UnaryOperator"));
        ClassId classId2 = ClassId.topLevel(new FqName("java.util.function.BiFunction"));
        Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(FqName(\"java.util.function.BiFunction\"))");
        fakePureImplementationsProvider.implementedWith(classId2, fakePureImplementationsProvider.fqNameListOf("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(TuplesKt.to(((ClassId) entry.getKey()).asSingleFqName(), ((ClassId) entry.getValue()).asSingleFqName()));
        }
        pureImplementationsFqNames = MapsKt__MapsKt.toMap(arrayList);
    }

    private FakePureImplementationsProvider() {
    }

    private final List<ClassId> fqNameListOf(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(ClassId.topLevel(new FqName(str)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void implementedWith(ClassId classId, List<ClassId> list) {
        Map<ClassId, ClassId> map = pureImplementationsClassIds;
        for (Object obj : list) {
            map.put(obj, classId);
        }
    }

    @Nullable
    public final FqName getPurelyImplementedInterface(@NotNull FqName classFqName) {
        Intrinsics.checkNotNullParameter(classFqName, "classFqName");
        return pureImplementationsFqNames.get(classFqName);
    }
}

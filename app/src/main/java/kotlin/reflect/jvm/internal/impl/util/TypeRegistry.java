package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayMapOwner.kt */
/* loaded from: classes4.dex */
public abstract class TypeRegistry<K, V> {

    @NotNull
    private final ConcurrentHashMap<KClass<? extends K>, Integer> idPerType = new ConcurrentHashMap<>();

    @NotNull
    private final AtomicInteger idCounter = new AtomicInteger(0);

    public abstract <T extends K> int customComputeIfAbsent(@NotNull ConcurrentHashMap<KClass<? extends K>, Integer> concurrentHashMap, @NotNull KClass<T> kClass, @NotNull Function1<? super KClass<? extends K>, Integer> function1);

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(@NotNull KClass<KK> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new NullableArrayMapAccessor<>(kClass, getId(kClass));
    }

    public final <T extends K> int getId(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return customComputeIfAbsent(this.idPerType, kClass, new Function1<KClass<? extends K>, Integer>(this) { // from class: kotlin.reflect.jvm.internal.impl.util.TypeRegistry.getId.1
            public final /* synthetic */ TypeRegistry<K, V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(@NotNull KClass<? extends K> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(((TypeRegistry) this.this$0).idCounter.getAndIncrement());
            }
        });
    }

    @NotNull
    public final Collection<Integer> getIndices() {
        Collection<Integer> collectionValues = this.idPerType.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "idPerType.values");
        return collectionValues;
    }
}

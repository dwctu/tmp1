package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeParameterUpperBoundEraser.kt */
/* loaded from: classes4.dex */
public final class TypeParameterUpperBoundEraser {

    @NotNull
    private final Lazy erroneousErasedBound$delegate;

    @NotNull
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;

    @NotNull
    private final RawSubstitution rawSubstitution;

    @NotNull
    private final LockBasedStorageManager storage;

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    public static final class DataToEraseUpperBound {
        private final boolean isRaw;

        @NotNull
        private final JavaTypeAttributes typeAttr;

        @NotNull
        private final TypeParameterDescriptor typeParameter;

        public DataToEraseUpperBound(@NotNull TypeParameterDescriptor typeParameter, boolean z, @NotNull JavaTypeAttributes typeAttr) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
            this.typeParameter = typeParameter;
            this.isRaw = z;
            this.typeAttr = typeAttr;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof DataToEraseUpperBound)) {
                return false;
            }
            DataToEraseUpperBound dataToEraseUpperBound = (DataToEraseUpperBound) obj;
            return Intrinsics.areEqual(dataToEraseUpperBound.typeParameter, this.typeParameter) && dataToEraseUpperBound.isRaw == this.isRaw && dataToEraseUpperBound.typeAttr.getFlexibility() == this.typeAttr.getFlexibility() && dataToEraseUpperBound.typeAttr.getHowThisTypeIsUsed() == this.typeAttr.getHowThisTypeIsUsed() && dataToEraseUpperBound.typeAttr.isForAnnotationParameter() == this.typeAttr.isForAnnotationParameter() && Intrinsics.areEqual(dataToEraseUpperBound.typeAttr.getDefaultType(), this.typeAttr.getDefaultType());
        }

        @NotNull
        public final JavaTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        @NotNull
        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public int hashCode() {
            int iHashCode = this.typeParameter.hashCode();
            int i = iHashCode + (iHashCode * 31) + (this.isRaw ? 1 : 0);
            int iHashCode2 = i + (i * 31) + this.typeAttr.getFlexibility().hashCode();
            int iHashCode3 = iHashCode2 + (iHashCode2 * 31) + this.typeAttr.getHowThisTypeIsUsed().hashCode();
            int i2 = iHashCode3 + (iHashCode3 * 31) + (this.typeAttr.isForAnnotationParameter() ? 1 : 0);
            int i3 = i2 * 31;
            SimpleType defaultType = this.typeAttr.getDefaultType();
            return i2 + i3 + (defaultType != null ? defaultType.hashCode() : 0);
        }

        public final boolean isRaw() {
            return this.isRaw;
        }

        @NotNull
        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", isRaw=" + this.isRaw + ", typeAttr=" + this.typeAttr + ')';
        }
    }

    public TypeParameterUpperBoundEraser() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TypeParameterUpperBoundEraser(@Nullable RawSubstitution rawSubstitution) {
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasion results");
        this.storage = lockBasedStorageManager;
        this.erroneousErasedBound$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ErrorType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser$erroneousErasedBound$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ErrorType invoke() {
                return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, this.this$0.toString());
            }
        });
        this.rawSubstitution = rawSubstitution == null ? new RawSubstitution(this) : rawSubstitution;
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> memoizedFunctionToNotNullCreateMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new Function1<DataToEraseUpperBound, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser$getErasedUpperBound$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(TypeParameterUpperBoundEraser.DataToEraseUpperBound dataToEraseUpperBound) {
                return this.this$0.getErasedUpperBoundInternal(dataToEraseUpperBound.getTypeParameter(), dataToEraseUpperBound.isRaw(), dataToEraseUpperBound.getTypeAttr());
            }
        });
        Intrinsics.checkNotNullExpressionValue(memoizedFunctionToNotNullCreateMemoizedFunction, "storage.createMemoizedFu… isRaw, typeAttr) }\n    }");
        this.getErasedUpperBound = memoizedFunctionToNotNullCreateMemoizedFunction;
    }

    private final KotlinType getDefaultType(JavaTypeAttributes javaTypeAttributes) {
        KotlinType kotlinTypeReplaceArgumentsWithStarProjections;
        SimpleType defaultType = javaTypeAttributes.getDefaultType();
        return (defaultType == null || (kotlinTypeReplaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) == null) ? getErroneousErasedBound() : kotlinTypeReplaceArgumentsWithStarProjections;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameterDescriptor, boolean z, JavaTypeAttributes javaTypeAttributes) {
        TypeProjection typeProjectionComputeProjection;
        Set<TypeParameterDescriptor> visitedTypeParameters = javaTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(javaTypeAttributes);
        }
        SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
        Set<TypeParameterDescriptor> setExtractTypeParametersFromUpperBounds = TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(setExtractTypeParametersFromUpperBounds, 10)), 16));
        for (TypeParameterDescriptor typeParameterDescriptor2 : setExtractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(typeParameterDescriptor2)) {
                RawSubstitution rawSubstitution = this.rawSubstitution;
                JavaTypeAttributes javaTypeAttributesWithFlexibility = z ? javaTypeAttributes : javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
                KotlinType erasedUpperBound$descriptors_jvm = getErasedUpperBound$descriptors_jvm(typeParameterDescriptor2, z, javaTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor));
                Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "getErasedUpperBound(it, …Parameter(typeParameter))");
                typeProjectionComputeProjection = rawSubstitution.computeProjection(typeParameterDescriptor2, javaTypeAttributesWithFlexibility, erasedUpperBound$descriptors_jvm);
            } else {
                typeProjectionComputeProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor2, javaTypeAttributes);
            }
            Pair pair = TuplesKt.to(typeParameterDescriptor2.getTypeConstructor(), typeProjectionComputeProjection);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        TypeSubstitutor typeSubstitutorCreate = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(typeSubstitutorCreate, "create(TypeConstructorSu…rsMap(erasedUpperBounds))");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
        KotlinType firstUpperBound = (KotlinType) CollectionsKt___CollectionsKt.first((List) upperBounds);
        if (firstUpperBound.getConstructor().mo1382getDeclarationDescriptor() instanceof ClassDescriptor) {
            Intrinsics.checkNotNullExpressionValue(firstUpperBound, "firstUpperBound");
            return TypeUtilsKt.replaceArgumentsWithStarProjectionOrMapped(firstUpperBound, typeSubstitutorCreate, linkedHashMap, Variance.OUT_VARIANCE, javaTypeAttributes.getVisitedTypeParameters());
        }
        Set<TypeParameterDescriptor> visitedTypeParameters2 = javaTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters2 == null) {
            visitedTypeParameters2 = SetsKt__SetsJVMKt.setOf(this);
        }
        ClassifierDescriptor classifierDescriptorMo1382getDeclarationDescriptor = firstUpperBound.getConstructor().mo1382getDeclarationDescriptor();
        Intrinsics.checkNotNull(classifierDescriptorMo1382getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) classifierDescriptorMo1382getDeclarationDescriptor;
            if (visitedTypeParameters2.contains(typeParameterDescriptor3)) {
                return getDefaultType(javaTypeAttributes);
            }
            List<KotlinType> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds2, "current.upperBounds");
            KotlinType nextUpperBound = (KotlinType) CollectionsKt___CollectionsKt.first((List) upperBounds2);
            if (nextUpperBound.getConstructor().mo1382getDeclarationDescriptor() instanceof ClassDescriptor) {
                Intrinsics.checkNotNullExpressionValue(nextUpperBound, "nextUpperBound");
                return TypeUtilsKt.replaceArgumentsWithStarProjectionOrMapped(nextUpperBound, typeSubstitutorCreate, linkedHashMap, Variance.OUT_VARIANCE, javaTypeAttributes.getVisitedTypeParameters());
            }
            classifierDescriptorMo1382getDeclarationDescriptor = nextUpperBound.getConstructor().mo1382getDeclarationDescriptor();
            Intrinsics.checkNotNull(classifierDescriptorMo1382getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    public final KotlinType getErasedUpperBound$descriptors_jvm(@NotNull TypeParameterDescriptor typeParameter, boolean z, @NotNull JavaTypeAttributes typeAttr) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        return this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameter, z, typeAttr));
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(RawSubstitution rawSubstitution, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : rawSubstitution);
    }
}

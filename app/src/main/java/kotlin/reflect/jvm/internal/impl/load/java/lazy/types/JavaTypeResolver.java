package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes4.dex */
public final class JavaTypeResolver {

    @NotNull
    private final LazyJavaResolverContext c;

    @NotNull
    private final RawSubstitution rawSubstitution;

    @NotNull
    private final TypeParameterResolver typeParameterResolver;

    @NotNull
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public JavaTypeResolver(@NotNull LazyJavaResolverContext c, @NotNull TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        this.c = c;
        this.typeParameterResolver = typeParameterResolver;
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(null, 1, 0 == true ? 1 : 0);
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser;
        this.rawSubstitution = new RawSubstitution(typeParameterUpperBoundEraser);
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        Variance variance;
        if (!JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt___CollectionsKt.lastOrNull((List) javaClassifierType.getTypeArguments()))) {
            return false;
        }
        List<TypeParameterDescriptor> parameters = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt___CollectionsKt.lastOrNull((List) parameters);
        return (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null || variance == Variance.OUT_VARIANCE) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r7, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r8, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r9) {
        /*
            r6 = this;
            boolean r0 = r7.isRaw()
            java.lang.String r1 = "constructor.parameters"
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L25
            java.util.List r0 = r7.getTypeArguments()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L23
            java.util.List r0 = r9.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L23
            goto L25
        L23:
            r0 = 0
            goto L26
        L25:
            r0 = 1
        L26:
            java.util.List r4 = r9.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            if (r0 == 0) goto L34
            java.util.List r7 = r6.computeRawTypeArguments(r7, r4, r9, r8)
            return r7
        L34:
            int r8 = r4.size()
            java.util.List r9 = r7.getTypeArguments()
            int r9 = r9.size()
            r0 = 10
            if (r8 == r9) goto L82
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r4, r0)
            r7.<init>(r8)
            java.util.Iterator r8 = r4.iterator()
        L51:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L7d
            java.lang.Object r9 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER
            java.lang.String[] r4 = new java.lang.String[r3]
            kotlin.reflect.jvm.internal.impl.name.Name r9 = r9.getName()
            java.lang.String r9 = r9.asString()
            java.lang.String r5 = "p.name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            r4[r2] = r9
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r9 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(r1, r4)
            r0.<init>(r9)
            r7.add(r0)
            goto L51
        L7d:
            java.util.List r7 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r7)
            return r7
        L82:
            java.util.List r7 = r7.getTypeArguments()
            java.lang.Iterable r7 = kotlin.collections.CollectionsKt___CollectionsKt.withIndex(r7)
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r7, r0)
            r8.<init>(r9)
            java.util.Iterator r7 = r7.iterator()
        L97:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto Lcc
            java.lang.Object r9 = r7.next()
            kotlin.collections.IndexedValue r9 = (kotlin.collections.IndexedValue) r9
            int r0 = r9.getIndex()
            java.lang.Object r9 = r9.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r9
            int r1 = r4.size()
            java.lang.Object r0 = r4.get(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r1 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r3 = 3
            r5 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r1 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r1, r2, r5, r3, r5)
            java.lang.String r3 = "parameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r9 = r6.transformToTypeProjection(r9, r1, r0)
            r8.add(r9)
            goto L97
        Lcc:
            java.util.List r7 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):java.util.List");
    }

    private final List<TypeProjection> computeRawTypeArguments(final JavaClassifierType javaClassifierType, List<? extends TypeParameterDescriptor> list, final TypeConstructor typeConstructor, final JavaTypeAttributes javaTypeAttributes) {
        TypeProjection typeProjectionComputeProjection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (final TypeParameterDescriptor typeParameterDescriptor : list) {
            if (TypeUtilsKt.hasTypeParameterRecursiveBounds(typeParameterDescriptor, null, javaTypeAttributes.getVisitedTypeParameters())) {
                typeProjectionComputeProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            } else {
                typeProjectionComputeProjection = this.rawSubstitution.computeProjection(typeParameterDescriptor, javaClassifierType.isRaw() ? javaTypeAttributes : javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE), new LazyWrappedType(this.c.getStorageManager(), new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final KotlinType invoke() {
                        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = this.this$0.typeParameterUpperBoundEraser;
                        TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
                        boolean zIsRaw = javaClassifierType.isRaw();
                        JavaTypeAttributes javaTypeAttributes2 = javaTypeAttributes;
                        ClassifierDescriptor classifierDescriptorMo1382getDeclarationDescriptor = typeConstructor.mo1382getDeclarationDescriptor();
                        KotlinType erasedUpperBound$descriptors_jvm = typeParameterUpperBoundEraser.getErasedUpperBound$descriptors_jvm(typeParameterDescriptor2, zIsRaw, javaTypeAttributes2.withDefaultType(classifierDescriptorMo1382getDeclarationDescriptor != null ? classifierDescriptorMo1382getDeclarationDescriptor.getDefaultType() : null));
                        Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "typeParameterUpperBoundE…efaultType)\n            )");
                        return erasedUpperBound$descriptors_jvm;
                    }
                }));
            }
            arrayList.add(typeProjectionComputeProjection);
        }
        return arrayList;
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        TypeAttributes defaultAttributes;
        if (simpleType == null || (defaultAttributes = simpleType.getAttributes()) == null) {
            defaultAttributes = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.c, javaClassifierType, false, 4, null));
        }
        TypeAttributes typeAttributes = defaultAttributes;
        TypeConstructor typeConstructorComputeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        if (typeConstructorComputeTypeConstructor == null) {
            return null;
        }
        boolean zIsNullable = isNullable(javaTypeAttributes);
        return (Intrinsics.areEqual(simpleType != null ? simpleType.getConstructor() : null, typeConstructorComputeTypeConstructor) && !javaClassifierType.isRaw() && zIsNullable) ? simpleType.makeNullableAsSpecified(true) : KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructorComputeTypeConstructor, computeArguments(javaClassifierType, javaTypeAttributes, typeConstructorComputeTypeConstructor), zIsNullable, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (!(classifier instanceof JavaClass)) {
            if (classifier instanceof JavaTypeParameter) {
                TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
                if (typeParameterDescriptorResolveTypeParameter != null) {
                    return typeParameterDescriptorResolveTypeParameter.getTypeConstructor();
                }
                return null;
            }
            throw new IllegalStateException("Unknown classifier kind: " + classifier);
        }
        JavaClass javaClass = (JavaClass) classifier;
        FqName fqName = javaClass.getFqName();
        if (fqName != null) {
            ClassDescriptor classDescriptorMapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
            if (classDescriptorMapKotlinClass == null) {
                classDescriptorMapKotlinClass = this.c.getComponents().getModuleClassResolver().resolveClass(javaClass);
            }
            return (classDescriptorMapKotlinClass == null || (typeConstructor = classDescriptorMapKotlinClass.getTypeConstructor()) == null) ? createNotFoundClass(javaClassifierType) : typeConstructor;
        }
        throw new AssertionError("Class type should have a FQ name: " + classifier);
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor typeConstructor = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt__CollectionsJVMKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "c.components.deserialize…istOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final boolean isConflictingArgumentFor(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        return (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) ? false : true;
    }

    private final boolean isNullable(JavaTypeAttributes javaTypeAttributes) {
        return (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        if (javaTypeAttributes.isForAnnotationParameter() && Intrinsics.areEqual(fqName, JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME)) {
            return this.c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor classDescriptorMapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.c.getModule().getBuiltIns(), null, 4, null);
        if (classDescriptorMapJavaToKotlin$default == null) {
            return null;
        }
        return (javaToKotlinClassMapper.isReadOnly(classDescriptorMapJavaToKotlin$default) && (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, classDescriptorMapJavaToKotlin$default))) ? javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptorMapJavaToKotlin$default) : classDescriptorMapJavaToKotlin$default;
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        boolean z = (javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
        boolean zIsRaw = javaClassifierType.isRaw();
        if (!zIsRaw && !z) {
            SimpleType simpleTypeComputeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, null);
            return simpleTypeComputeSimpleJavaClassifierType != null ? simpleTypeComputeSimpleJavaClassifierType : transformJavaClassifierType$errorType(javaClassifierType);
        }
        SimpleType simpleTypeComputeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (simpleTypeComputeSimpleJavaClassifierType2 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        SimpleType simpleTypeComputeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), simpleTypeComputeSimpleJavaClassifierType2);
        return simpleTypeComputeSimpleJavaClassifierType3 == null ? transformJavaClassifierType$errorType(javaClassifierType) : zIsRaw ? new RawTypeImpl(simpleTypeComputeSimpleJavaClassifierType2, simpleTypeComputeSimpleJavaClassifierType3) : KotlinTypeFactory.flexibleType(simpleTypeComputeSimpleJavaClassifierType2, simpleTypeComputeSimpleJavaClassifierType3);
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType javaClassifierType) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, javaClassifierType.getPresentableText());
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        if (!(javaType instanceof JavaWildcardType)) {
            return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
        }
        JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
        JavaType bound = javaWildcardType.getBound();
        Variance variance = javaWildcardType.isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
        return (bound == null || isConflictingArgumentFor(variance, typeParameterDescriptor)) ? JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes) : TypeUtilsKt.createProjection(transformJavaType(bound, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)), variance, typeParameterDescriptor);
    }

    @NotNull
    public final KotlinType transformArrayType(@NotNull JavaArrayType arrayType, @NotNull JavaTypeAttributes attr, boolean z) {
        Intrinsics.checkNotNullParameter(arrayType, "arrayType");
        Intrinsics.checkNotNullParameter(attr, "attr");
        JavaType componentType = arrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = componentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) componentType : null;
        PrimitiveType type = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.c, arrayType, true);
        if (type != null) {
            SimpleType primitiveArrayKotlinType = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            TypeUtilsKt.replaceAnnotations(primitiveArrayKotlinType, Annotations.Companion.create(CollectionsKt___CollectionsKt.plus((Iterable) lazyJavaAnnotations, (Iterable) primitiveArrayKotlinType.getAnnotations())));
            return attr.isForAnnotationParameter() ? primitiveArrayKotlinType : KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
        }
        KotlinType kotlinTypeTransformJavaType = transformJavaType(componentType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, attr.isForAnnotationParameter(), null, 2, null));
        if (attr.isForAnnotationParameter()) {
            SimpleType arrayType2 = this.c.getModule().getBuiltIns().getArrayType(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, kotlinTypeTransformJavaType, lazyJavaAnnotations);
            Intrinsics.checkNotNullExpressionValue(arrayType2, "c.module.builtIns.getArr…mponentType, annotations)");
            return arrayType2;
        }
        SimpleType arrayType3 = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, kotlinTypeTransformJavaType, lazyJavaAnnotations);
        Intrinsics.checkNotNullExpressionValue(arrayType3, "c.module.builtIns.getArr…mponentType, annotations)");
        return KotlinTypeFactory.flexibleType(arrayType3, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, kotlinTypeTransformJavaType, lazyJavaAnnotations).makeNullableAsSpecified(true));
    }

    @NotNull
    public final KotlinType transformJavaType(@Nullable JavaType javaType, @NotNull JavaTypeAttributes attr) {
        KotlinType kotlinTypeTransformJavaType;
        Intrinsics.checkNotNullParameter(attr, "attr");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            SimpleType primitiveKotlinType = type != null ? this.c.getModule().getBuiltIns().getPrimitiveKotlinType(type) : this.c.getModule().getBuiltIns().getUnitType();
            Intrinsics.checkNotNullExpressionValue(primitiveKotlinType, "{\n                val pr…ns.unitType\n            }");
            return primitiveKotlinType;
        }
        if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, attr);
        }
        if (javaType instanceof JavaArrayType) {
            return transformArrayType$default(this, (JavaArrayType) javaType, attr, false, 4, null);
        }
        if (javaType instanceof JavaWildcardType) {
            JavaType bound = ((JavaWildcardType) javaType).getBound();
            if (bound != null && (kotlinTypeTransformJavaType = transformJavaType(bound, attr)) != null) {
                return kotlinTypeTransformJavaType;
            }
            SimpleType defaultBound = this.c.getModule().getBuiltIns().getDefaultBound();
            Intrinsics.checkNotNullExpressionValue(defaultBound, "c.module.builtIns.defaultBound");
            return defaultBound;
        }
        if (javaType == null) {
            SimpleType defaultBound2 = this.c.getModule().getBuiltIns().getDefaultBound();
            Intrinsics.checkNotNullExpressionValue(defaultBound2, "c.module.builtIns.defaultBound");
            return defaultBound2;
        }
        throw new UnsupportedOperationException("Unsupported type: " + javaType);
    }
}

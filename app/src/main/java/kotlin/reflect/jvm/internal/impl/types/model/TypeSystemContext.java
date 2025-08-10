package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes4.dex */
public interface TypeSystemContext extends TypeSystemOptimizationContext {

    /* compiled from: TypeSystemContext.kt */
    public static final class DefaultImpls {
        @Nullable
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker receiver, @NotNull TypeConstructorMarker constructor) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            return null;
        }

        @NotNull
        public static TypeArgumentMarker get(@NotNull TypeSystemContext typeSystemContext, @NotNull TypeArgumentListMarker receiver, int i) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleTypeMarker) {
                return typeSystemContext.getArgument((KotlinTypeMarker) receiver, i);
            }
            if (receiver instanceof ArgumentList) {
                TypeArgumentMarker typeArgumentMarker = ((ArgumentList) receiver).get(i);
                Intrinsics.checkNotNullExpressionValue(typeArgumentMarker, "get(index)");
                return typeArgumentMarker;
            }
            throw new IllegalStateException(("unknown type argument list type: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static TypeArgumentMarker getArgumentOrNull(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker receiver, int i) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            boolean z = false;
            if (i >= 0 && i < typeSystemContext.argumentsCount(receiver)) {
                z = true;
            }
            if (z) {
                return typeSystemContext.getArgument(receiver, i);
            }
            return null;
        }

        public static boolean hasFlexibleNullability(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(receiver)) != typeSystemContext.isMarkedNullable(typeSystemContext.upperBoundIfFlexible(receiver));
        }

        public static boolean isCapturedType(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            SimpleTypeMarker simpleTypeMarkerAsSimpleType = typeSystemContext.asSimpleType(receiver);
            return (simpleTypeMarkerAsSimpleType != null ? typeSystemContext.asCapturedType(simpleTypeMarkerAsSimpleType) : null) != null;
        }

        public static boolean isClassType(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return typeSystemContext.isClassTypeConstructor(typeSystemContext.typeConstructor(receiver));
        }

        public static boolean isDefinitelyNotNullType(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            SimpleTypeMarker simpleTypeMarkerAsSimpleType = typeSystemContext.asSimpleType(receiver);
            return (simpleTypeMarkerAsSimpleType != null ? typeSystemContext.asDefinitelyNotNullType(simpleTypeMarkerAsSimpleType) : null) != null;
        }

        public static boolean isDynamic(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = typeSystemContext.asFlexibleType(receiver);
            return (flexibleTypeMarkerAsFlexibleType != null ? typeSystemContext.asDynamicType(flexibleTypeMarkerAsFlexibleType) : null) != null;
        }

        public static boolean isIntegerLiteralType(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return typeSystemContext.isIntegerLiteralTypeConstructor(typeSystemContext.typeConstructor(receiver));
        }

        public static boolean isMarkedNullable(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return (receiver instanceof SimpleTypeMarker) && typeSystemContext.isMarkedNullable((SimpleTypeMarker) receiver);
        }

        public static boolean isNothing(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(receiver)) && !typeSystemContext.isNullableType(receiver);
        }

        @NotNull
        public static SimpleTypeMarker lowerBoundIfFlexible(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            SimpleTypeMarker simpleTypeMarkerLowerBound;
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = typeSystemContext.asFlexibleType(receiver);
            if (flexibleTypeMarkerAsFlexibleType != null && (simpleTypeMarkerLowerBound = typeSystemContext.lowerBound(flexibleTypeMarkerAsFlexibleType)) != null) {
                return simpleTypeMarkerLowerBound;
            }
            SimpleTypeMarker simpleTypeMarkerAsSimpleType = typeSystemContext.asSimpleType(receiver);
            Intrinsics.checkNotNull(simpleTypeMarkerAsSimpleType);
            return simpleTypeMarkerAsSimpleType;
        }

        public static int size(@NotNull TypeSystemContext typeSystemContext, @NotNull TypeArgumentListMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleTypeMarker) {
                return typeSystemContext.argumentsCount((KotlinTypeMarker) receiver);
            }
            if (receiver instanceof ArgumentList) {
                return ((ArgumentList) receiver).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            SimpleTypeMarker simpleTypeMarkerAsSimpleType = typeSystemContext.asSimpleType(receiver);
            if (simpleTypeMarkerAsSimpleType == null) {
                simpleTypeMarkerAsSimpleType = typeSystemContext.lowerBoundIfFlexible(receiver);
            }
            return typeSystemContext.typeConstructor(simpleTypeMarkerAsSimpleType);
        }

        @NotNull
        public static SimpleTypeMarker upperBoundIfFlexible(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            SimpleTypeMarker simpleTypeMarkerUpperBound;
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = typeSystemContext.asFlexibleType(receiver);
            if (flexibleTypeMarkerAsFlexibleType != null && (simpleTypeMarkerUpperBound = typeSystemContext.upperBound(flexibleTypeMarkerAsFlexibleType)) != null) {
                return simpleTypeMarkerUpperBound;
            }
            SimpleTypeMarker simpleTypeMarkerAsSimpleType = typeSystemContext.asSimpleType(receiver);
            Intrinsics.checkNotNull(simpleTypeMarkerAsSimpleType);
            return simpleTypeMarkerAsSimpleType;
        }
    }

    boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2);

    int argumentsCount(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Nullable
    FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    RawTypeMarker asRawType(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus);

    @NotNull
    CaptureStatus captureStatus(@NotNull CapturedTypeMarker capturedTypeMarker);

    @Nullable
    List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    TypeArgumentMarker get(@NotNull TypeArgumentListMarker typeArgumentListMarker, int i);

    @NotNull
    TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker kotlinTypeMarker, int i);

    @Nullable
    TypeArgumentMarker getArgumentOrNull(@NotNull SimpleTypeMarker simpleTypeMarker, int i);

    @NotNull
    List<TypeArgumentMarker> getArguments(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeParameterMarker getParameter(@NotNull TypeConstructorMarker typeConstructorMarker, int i);

    @NotNull
    List<TypeParameterMarker> getParameters(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker getType(@NotNull TypeArgumentMarker typeArgumentMarker);

    @Nullable
    TypeParameterMarker getTypeParameter(@NotNull TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker);

    @Nullable
    TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    List<KotlinTypeMarker> getUpperBounds(@NotNull TypeParameterMarker typeParameterMarker);

    @NotNull
    TypeVariance getVariance(@NotNull TypeArgumentMarker typeArgumentMarker);

    @NotNull
    TypeVariance getVariance(@NotNull TypeParameterMarker typeParameterMarker);

    boolean hasFlexibleNullability(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean hasRecursiveBounds(@NotNull TypeParameterMarker typeParameterMarker, @Nullable TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> list);

    boolean isAnyConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isCapturedType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isClassType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isClassTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isDefinitelyNotNullType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isDenotable(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isDynamic(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isError(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isIntegerLiteralType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isIntersection(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isMarkedNullable(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isMarkedNullable(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isNotNullTypeParameter(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isNothing(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isNothingConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isNullableType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isOldCapturedType(@NotNull CapturedTypeMarker capturedTypeMarker);

    boolean isPrimitiveType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isProjectionNotNull(@NotNull CapturedTypeMarker capturedTypeMarker);

    boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isStarProjection(@NotNull TypeArgumentMarker typeArgumentMarker);

    boolean isStubType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isStubTypeForBuilderInference(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isTypeVariableType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker capturedTypeMarker);

    @NotNull
    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    SimpleTypeMarker original(@NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker);

    int parametersCount(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    TypeArgumentMarker projection(@NotNull CapturedTypeConstructorMarker capturedTypeConstructorMarker);

    int size(@NotNull TypeArgumentListMarker typeArgumentListMarker);

    @NotNull
    TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    CapturedTypeConstructorMarker typeConstructor(@NotNull CapturedTypeMarker capturedTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    KotlinTypeMarker withNullability(@NotNull KotlinTypeMarker kotlinTypeMarker, boolean z);

    @NotNull
    SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z);
}

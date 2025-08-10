package com.google.auto.common;

import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;
import javax.lang.model.util.Types;

/* loaded from: classes2.dex */
public final class MoreTypes {
    private static final Method GET_BOUNDS;
    private static final int HASH_MULTIPLIER = 31;
    private static final int HASH_SEED = 17;
    private static final Class<?> INTERSECTION_TYPE;

    /* renamed from: com.google.auto.common.MoreTypes$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$javax$lang$model$type$TypeKind;

        static {
            int[] iArr = new int[TypeKind.values().length];
            $SwitchMap$javax$lang$model$type$TypeKind = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.FLOAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.INT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.SHORT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static final class ArrayTypeVisitor extends CastingTypeVisitor<ArrayType> {
        private static final ArrayTypeVisitor INSTANCE = new ArrayTypeVisitor();

        public ArrayTypeVisitor() {
            super("primitive array");
        }

        public ArrayType visitArray(ArrayType arrayType, Void r2) {
            return arrayType;
        }
    }

    public static final class AsElementVisitor extends SimpleTypeVisitor6<Element, Void> {
        private static final AsElementVisitor INSTANCE = new AsElementVisitor();

        private AsElementVisitor() {
        }

        public Element defaultAction(TypeMirror typeMirror, Void r3) {
            throw new IllegalArgumentException(typeMirror + " cannot be converted to an Element");
        }

        public Element visitDeclared(DeclaredType declaredType, Void r2) {
            return declaredType.asElement();
        }

        public Element visitError(ErrorType errorType, Void r2) {
            return errorType.asElement();
        }

        public Element visitTypeVariable(TypeVariable typeVariable, Void r2) {
            return typeVariable.asElement();
        }
    }

    public static abstract class CastingTypeVisitor<T> extends SimpleTypeVisitor6<T, Void> {
        private final String label;

        public CastingTypeVisitor(String str) {
            this.label = str;
        }

        public T defaultAction(TypeMirror typeMirror, Void r3) {
            throw new IllegalArgumentException(typeMirror + " does not represent a " + this.label);
        }
    }

    public static class ComparedElements {
        public final Element a;
        public final ImmutableList<TypeMirror> aArguments;
        public final Element b;
        public final ImmutableList<TypeMirror> bArguments;

        public ComparedElements(Element element, ImmutableList<TypeMirror> immutableList, Element element2, ImmutableList<TypeMirror> immutableList2) {
            this.a = element;
            this.aArguments = immutableList;
            this.b = element2;
            this.bArguments = immutableList2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ComparedElements) {
                ComparedElements comparedElements = (ComparedElements) obj;
                int size = this.aArguments.size();
                if (this.a.equals(comparedElements.a) && this.b.equals(comparedElements.b) && size == this.bArguments.size()) {
                    for (int i = 0; i < size; i++) {
                        if (this.aArguments.get(i) != this.bArguments.get(i)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    public static final class DeclaredTypeVisitor extends CastingTypeVisitor<DeclaredType> {
        private static final DeclaredTypeVisitor INSTANCE = new DeclaredTypeVisitor();

        public DeclaredTypeVisitor() {
            super("declared type");
        }

        public DeclaredType visitDeclared(DeclaredType declaredType, Void r2) {
            return declaredType;
        }
    }

    public static final class EqualVisitor extends SimpleTypeVisitor6<Boolean, EqualVisitorParam> {
        private static final EqualVisitor INSTANCE = new EqualVisitor();

        private EqualVisitor() {
        }

        private Set<ComparedElements> visitingSetPlus(Set<ComparedElements> set, Element element, Element element2) {
            ImmutableList immutableListOf = ImmutableList.of();
            return visitingSetPlus(set, element, immutableListOf, element2, immutableListOf);
        }

        public Boolean defaultAction(TypeMirror typeMirror, EqualVisitorParam equalVisitorParam) {
            return Boolean.valueOf(typeMirror.getKind().equals(equalVisitorParam.type.getKind()));
        }

        public Boolean visitArray(ArrayType arrayType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.ARRAY)) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(MoreTypes.equal(arrayType.getComponentType(), equalVisitorParam.type.getComponentType(), equalVisitorParam.visiting));
        }

        public Boolean visitDeclared(DeclaredType declaredType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.DECLARED)) {
                return Boolean.FALSE;
            }
            DeclaredType declaredType2 = equalVisitorParam.type;
            Element elementAsElement = declaredType.asElement();
            Element elementAsElement2 = declaredType2.asElement();
            Set<ComparedElements> setVisitingSetPlus = visitingSetPlus(equalVisitorParam.visiting, elementAsElement, declaredType.getTypeArguments(), elementAsElement2, declaredType2.getTypeArguments());
            if (setVisitingSetPlus.equals(equalVisitorParam.visiting)) {
                return Boolean.TRUE;
            }
            return Boolean.valueOf(elementAsElement.equals(elementAsElement2) && MoreTypes.equal(MoreTypes.enclosingType(declaredType), MoreTypes.enclosingType(declaredType2), setVisitingSetPlus) && MoreTypes.equalLists(declaredType.getTypeArguments(), declaredType2.getTypeArguments(), setVisitingSetPlus));
        }

        public Boolean visitError(ErrorType errorType, EqualVisitorParam equalVisitorParam) {
            return Boolean.valueOf(errorType.equals(equalVisitorParam.type));
        }

        public Boolean visitExecutable(ExecutableType executableType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.EXECUTABLE)) {
                return Boolean.FALSE;
            }
            ExecutableType executableType2 = equalVisitorParam.type;
            return Boolean.valueOf(MoreTypes.equalLists(executableType.getParameterTypes(), executableType2.getParameterTypes(), equalVisitorParam.visiting) && MoreTypes.equal(executableType.getReturnType(), executableType2.getReturnType(), equalVisitorParam.visiting) && MoreTypes.equalLists(executableType.getThrownTypes(), executableType2.getThrownTypes(), equalVisitorParam.visiting) && MoreTypes.equalLists(executableType.getTypeVariables(), executableType2.getTypeVariables(), equalVisitorParam.visiting));
        }

        public Boolean visitTypeVariable(TypeVariable typeVariable, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.TYPEVAR)) {
                return Boolean.FALSE;
            }
            TypeVariable typeVariable2 = equalVisitorParam.type;
            TypeParameterElement typeParameterElementAsElement = typeVariable.asElement();
            TypeParameterElement typeParameterElementAsElement2 = typeVariable2.asElement();
            Set<ComparedElements> setVisitingSetPlus = visitingSetPlus(equalVisitorParam.visiting, typeParameterElementAsElement, typeParameterElementAsElement2);
            if (setVisitingSetPlus.equals(equalVisitorParam.visiting)) {
                return Boolean.TRUE;
            }
            return Boolean.valueOf(MoreTypes.equalLists(typeParameterElementAsElement.getBounds(), typeParameterElementAsElement2.getBounds(), setVisitingSetPlus) && MoreTypes.equal(typeVariable.getLowerBound(), typeVariable2.getLowerBound(), setVisitingSetPlus) && typeVariable.asElement().getSimpleName().equals(typeVariable2.asElement().getSimpleName()));
        }

        public Boolean visitUnknown(TypeMirror typeMirror, EqualVisitorParam equalVisitorParam) {
            throw new UnsupportedOperationException();
        }

        public Boolean visitWildcard(WildcardType wildcardType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.WILDCARD)) {
                return Boolean.FALSE;
            }
            WildcardType wildcardType2 = equalVisitorParam.type;
            return Boolean.valueOf(MoreTypes.equal(wildcardType.getExtendsBound(), wildcardType2.getExtendsBound(), equalVisitorParam.visiting) && MoreTypes.equal(wildcardType.getSuperBound(), wildcardType2.getSuperBound(), equalVisitorParam.visiting));
        }

        private Set<ComparedElements> visitingSetPlus(Set<ComparedElements> set, Element element, List<? extends TypeMirror> list, Element element2, List<? extends TypeMirror> list2) {
            ComparedElements comparedElements = new ComparedElements(element, ImmutableList.copyOf((Collection) list), element2, ImmutableList.copyOf((Collection) list2));
            HashSet hashSet = new HashSet(set);
            hashSet.add(comparedElements);
            return hashSet;
        }
    }

    public static final class EqualVisitorParam {
        public TypeMirror type;
        public Set<ComparedElements> visiting;

        private EqualVisitorParam() {
        }
    }

    public static final class ErrorTypeVisitor extends CastingTypeVisitor<ErrorType> {
        private static final ErrorTypeVisitor INSTANCE = new ErrorTypeVisitor();

        public ErrorTypeVisitor() {
            super("error type");
        }

        public ErrorType visitError(ErrorType errorType, Void r2) {
            return errorType;
        }
    }

    public static final class ExecutableTypeVisitor extends CastingTypeVisitor<ExecutableType> {
        private static final ExecutableTypeVisitor INSTANCE = new ExecutableTypeVisitor();

        public ExecutableTypeVisitor() {
            super("executable type");
        }

        public ExecutableType visitExecutable(ExecutableType executableType, Void r2) {
            return executableType;
        }
    }

    public static final class HashVisitor extends SimpleTypeVisitor6<Integer, Set<Element>> {
        private static final HashVisitor INSTANCE = new HashVisitor();

        private HashVisitor() {
        }

        public int hashKind(int i, TypeMirror typeMirror) {
            return (i * 31) + typeMirror.getKind().hashCode();
        }

        public Integer defaultAction(TypeMirror typeMirror, Set<Element> set) {
            return Integer.valueOf(hashKind(17, typeMirror));
        }

        public Integer visitArray(ArrayType arrayType, Set<Element> set) {
            return Integer.valueOf((hashKind(17, arrayType) * 31) + ((Integer) arrayType.getComponentType().accept(this, set)).intValue());
        }

        public Integer visitDeclared(DeclaredType declaredType, Set<Element> set) {
            Element elementAsElement = declaredType.asElement();
            if (set.contains(elementAsElement)) {
                return 0;
            }
            HashSet hashSet = new HashSet(set);
            hashSet.add(elementAsElement);
            return Integer.valueOf((((((hashKind(17, declaredType) * 31) + declaredType.asElement().hashCode()) * 31) + ((Integer) declaredType.getEnclosingType().accept(this, hashSet)).intValue()) * 31) + MoreTypes.hashList(declaredType.getTypeArguments(), hashSet));
        }

        public Integer visitExecutable(ExecutableType executableType, Set<Element> set) {
            return Integer.valueOf((((((((hashKind(17, executableType) * 31) + MoreTypes.hashList(executableType.getParameterTypes(), set)) * 31) + ((Integer) executableType.getReturnType().accept(this, set)).intValue()) * 31) + MoreTypes.hashList(executableType.getThrownTypes(), set)) * 31) + MoreTypes.hashList(executableType.getTypeVariables(), set));
        }

        public Integer visitTypeVariable(TypeVariable typeVariable, Set<Element> set) {
            int iHashKind = (hashKind(17, typeVariable) * 31) + ((Integer) typeVariable.getLowerBound().accept(this, set)).intValue();
            Iterator it = typeVariable.asElement().getBounds().iterator();
            while (it.hasNext()) {
                iHashKind = (iHashKind * 31) + ((Integer) ((TypeMirror) it.next()).accept(this, set)).intValue();
            }
            return Integer.valueOf(iHashKind);
        }

        public Integer visitUnknown(TypeMirror typeMirror, Set<Element> set) {
            throw new UnsupportedOperationException();
        }

        public Integer visitWildcard(WildcardType wildcardType, Set<Element> set) {
            return Integer.valueOf((((hashKind(17, wildcardType) * 31) + (wildcardType.getExtendsBound() == null ? 0 : ((Integer) wildcardType.getExtendsBound().accept(this, set)).intValue())) * 31) + (wildcardType.getSuperBound() != null ? ((Integer) wildcardType.getSuperBound().accept(this, set)).intValue() : 0));
        }
    }

    public static final class IsTypeOf extends SimpleTypeVisitor6<Boolean, Void> {
        private final Class<?> clazz;

        public IsTypeOf(Class<?> cls) {
            this.clazz = cls;
        }

        public Boolean defaultAction(TypeMirror typeMirror, Void r3) {
            throw new IllegalArgumentException(typeMirror + " cannot be represented as a Class<?>.");
        }

        public Boolean visitArray(ArrayType arrayType, Void r2) {
            return Boolean.valueOf(this.clazz.isArray() && MoreTypes.isTypeOf(this.clazz.getComponentType(), arrayType.getComponentType()));
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void r3) {
            try {
                return Boolean.valueOf(MoreElements.asType(declaredType.asElement()).getQualifiedName().contentEquals(this.clazz.getCanonicalName()));
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException(declaredType + " does not represent a class or interface.");
            }
        }

        public Boolean visitNoType(NoType noType, Void r3) {
            if (noType.getKind().equals(TypeKind.VOID)) {
                return Boolean.valueOf(this.clazz.equals(Void.TYPE));
            }
            throw new IllegalArgumentException(noType + " cannot be represented as a Class<?>.");
        }

        public Boolean visitPrimitive(PrimitiveType primitiveType, Void r3) {
            switch (AnonymousClass2.$SwitchMap$javax$lang$model$type$TypeKind[primitiveType.getKind().ordinal()]) {
                case 1:
                    return Boolean.valueOf(this.clazz.equals(Boolean.TYPE));
                case 2:
                    return Boolean.valueOf(this.clazz.equals(Byte.TYPE));
                case 3:
                    return Boolean.valueOf(this.clazz.equals(Character.TYPE));
                case 4:
                    return Boolean.valueOf(this.clazz.equals(Double.TYPE));
                case 5:
                    return Boolean.valueOf(this.clazz.equals(Float.TYPE));
                case 6:
                    return Boolean.valueOf(this.clazz.equals(Integer.TYPE));
                case 7:
                    return Boolean.valueOf(this.clazz.equals(Long.TYPE));
                case 8:
                    return Boolean.valueOf(this.clazz.equals(Short.TYPE));
                default:
                    throw new IllegalArgumentException(primitiveType + " cannot be represented as a Class<?>.");
            }
        }
    }

    public static final class IsTypeVisitor extends SimpleTypeVisitor6<Boolean, Void> {
        private static final IsTypeVisitor INSTANCE = new IsTypeVisitor();

        private IsTypeVisitor() {
        }

        public Boolean defaultAction(TypeMirror typeMirror, Void r2) {
            return Boolean.FALSE;
        }

        public Boolean visitArray(ArrayType arrayType, Void r2) {
            return Boolean.TRUE;
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void r2) {
            return Boolean.valueOf(MoreElements.isType(declaredType.asElement()));
        }

        public Boolean visitNoType(NoType noType, Void r2) {
            return Boolean.valueOf(noType.getKind().equals(TypeKind.VOID));
        }

        public Boolean visitPrimitive(PrimitiveType primitiveType, Void r2) {
            return Boolean.TRUE;
        }
    }

    public static final class NoTypeVisitor extends CastingTypeVisitor<NoType> {
        private static final NoTypeVisitor INSTANCE = new NoTypeVisitor();

        public NoTypeVisitor() {
            super("non-type");
        }

        public NoType visitNoType(NoType noType, Void r2) {
            return noType;
        }
    }

    public static final class NullTypeVisitor extends CastingTypeVisitor<NullType> {
        private static final NullTypeVisitor INSTANCE = new NullTypeVisitor();

        public NullTypeVisitor() {
            super("null");
        }

        public NullType visitNull(NullType nullType, Void r2) {
            return nullType;
        }
    }

    public static final class PrimitiveTypeVisitor extends CastingTypeVisitor<PrimitiveType> {
        private static final PrimitiveTypeVisitor INSTANCE = new PrimitiveTypeVisitor();

        public PrimitiveTypeVisitor() {
            super("primitive type");
        }

        public PrimitiveType visitPrimitive(PrimitiveType primitiveType, Void r2) {
            return primitiveType;
        }
    }

    public static final class ReferencedTypes extends SimpleTypeVisitor6<Void, ImmutableSet.Builder<TypeElement>> {
        private static final ReferencedTypes INSTANCE = new ReferencedTypes();

        private ReferencedTypes() {
        }

        public Void visitArray(ArrayType arrayType, ImmutableSet.Builder<TypeElement> builder) {
            arrayType.getComponentType().accept(this, builder);
            return null;
        }

        public Void visitDeclared(DeclaredType declaredType, ImmutableSet.Builder<TypeElement> builder) {
            builder.add((ImmutableSet.Builder<TypeElement>) MoreElements.asType(declaredType.asElement()));
            Iterator it = declaredType.getTypeArguments().iterator();
            while (it.hasNext()) {
                ((TypeMirror) it.next()).accept(this, builder);
            }
            return null;
        }

        public Void visitTypeVariable(TypeVariable typeVariable, ImmutableSet.Builder<TypeElement> builder) {
            typeVariable.getLowerBound().accept(this, builder);
            typeVariable.getUpperBound().accept(this, builder);
            return null;
        }

        public Void visitWildcard(WildcardType wildcardType, ImmutableSet.Builder<TypeElement> builder) {
            TypeMirror extendsBound = wildcardType.getExtendsBound();
            if (extendsBound != null) {
                extendsBound.accept(this, builder);
            }
            TypeMirror superBound = wildcardType.getSuperBound();
            if (superBound == null) {
                return null;
            }
            superBound.accept(this, builder);
            return null;
        }
    }

    public static final class TypeEquivalence extends Equivalence<TypeMirror> {
        private static final TypeEquivalence INSTANCE = new TypeEquivalence();

        private TypeEquivalence() {
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(TypeMirror typeMirror, TypeMirror typeMirror2) {
            return MoreTypes.equal(typeMirror, typeMirror2, ImmutableSet.of());
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(TypeMirror typeMirror) {
            return MoreTypes.hash(typeMirror, ImmutableSet.of());
        }
    }

    public static final class TypeVariableVisitor extends CastingTypeVisitor<TypeVariable> {
        private static final TypeVariableVisitor INSTANCE = new TypeVariableVisitor();

        public TypeVariableVisitor() {
            super("type variable");
        }

        public TypeVariable visitTypeVariable(TypeVariable typeVariable, Void r2) {
            return typeVariable;
        }
    }

    public static final class WildcardTypeVisitor extends CastingTypeVisitor<WildcardType> {
        private static final WildcardTypeVisitor INSTANCE = new WildcardTypeVisitor();

        public WildcardTypeVisitor() {
            super("wildcard type");
        }

        public WildcardType visitWildcard(WildcardType wildcardType, Void r2) {
            return wildcardType;
        }
    }

    static {
        Method method;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("javax.lang.model.type.IntersectionType");
            method = cls2.getMethod("getBounds", new Class[0]);
            cls = cls2;
        } catch (Exception unused) {
            method = null;
        }
        INTERSECTION_TYPE = cls;
        GET_BOUNDS = method;
    }

    private MoreTypes() {
    }

    public static ArrayType asArray(TypeMirror typeMirror) {
        return (ArrayType) typeMirror.accept(ArrayTypeVisitor.INSTANCE, (Object) null);
    }

    public static DeclaredType asDeclared(TypeMirror typeMirror) {
        return (DeclaredType) typeMirror.accept(DeclaredTypeVisitor.INSTANCE, (Object) null);
    }

    public static Element asElement(TypeMirror typeMirror) {
        return (Element) typeMirror.accept(AsElementVisitor.INSTANCE, (Object) null);
    }

    public static ErrorType asError(TypeMirror typeMirror) {
        return (ErrorType) typeMirror.accept(ErrorTypeVisitor.INSTANCE, (Object) null);
    }

    public static ExecutableType asExecutable(TypeMirror typeMirror) {
        return (ExecutableType) typeMirror.accept(ExecutableTypeVisitor.INSTANCE, (Object) null);
    }

    public static TypeMirror asMemberOf(Types types, DeclaredType declaredType, VariableElement variableElement) {
        if (!variableElement.getKind().equals(ElementKind.PARAMETER)) {
            return types.asMemberOf(declaredType, variableElement);
        }
        ExecutableElement executableElementAsExecutable = MoreElements.asExecutable(variableElement.getEnclosingElement());
        ExecutableType executableTypeAsExecutable = asExecutable(types.asMemberOf(declaredType, executableElementAsExecutable));
        List parameters = executableElementAsExecutable.getParameters();
        List parameterTypes = executableTypeAsExecutable.getParameterTypes();
        Preconditions.checkState(parameters.size() == parameterTypes.size());
        for (int i = 0; i < parameters.size(); i++) {
            if (((VariableElement) parameters.get(i)).equals(variableElement)) {
                return (TypeMirror) parameterTypes.get(i);
            }
        }
        throw new IllegalStateException("Could not find variable: " + variableElement);
    }

    public static NoType asNoType(TypeMirror typeMirror) {
        return (NoType) typeMirror.accept(NoTypeVisitor.INSTANCE, (Object) null);
    }

    public static NullType asNullType(TypeMirror typeMirror) {
        return (NullType) typeMirror.accept(NullTypeVisitor.INSTANCE, (Object) null);
    }

    public static PrimitiveType asPrimitiveType(TypeMirror typeMirror) {
        return (PrimitiveType) typeMirror.accept(PrimitiveTypeVisitor.INSTANCE, (Object) null);
    }

    public static TypeElement asTypeElement(TypeMirror typeMirror) {
        return MoreElements.asType(asElement(typeMirror));
    }

    public static ImmutableSet<TypeElement> asTypeElements(Iterable<? extends TypeMirror> iterable) {
        Preconditions.checkNotNull(iterable);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        Iterator<? extends TypeMirror> it = iterable.iterator();
        while (it.hasNext()) {
            builder.add((ImmutableSet.Builder) asTypeElement(it.next()));
        }
        return builder.build();
    }

    public static TypeVariable asTypeVariable(TypeMirror typeMirror) {
        return (TypeVariable) typeMirror.accept(TypeVariableVisitor.INSTANCE, (Object) null);
    }

    public static WildcardType asWildcard(TypeMirror typeMirror) {
        return (WildcardType) typeMirror.accept(WildcardTypeVisitor.INSTANCE, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeMirror enclosingType(DeclaredType declaredType) {
        TypeMirror enclosingType = declaredType.getEnclosingType();
        if (enclosingType.getKind().equals(TypeKind.NONE) || declaredType.asElement().getModifiers().contains(Modifier.STATIC)) {
            return null;
        }
        return enclosingType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equal(TypeMirror typeMirror, TypeMirror typeMirror2, Set<ComparedElements> set) {
        if (Objects.equal(typeMirror, typeMirror2) && !(typeMirror instanceof ExecutableType)) {
            return true;
        }
        EqualVisitorParam equalVisitorParam = new EqualVisitorParam();
        equalVisitorParam.type = typeMirror2;
        equalVisitorParam.visiting = set;
        if (INTERSECTION_TYPE != null) {
            if (isIntersectionType(typeMirror)) {
                return equalIntersectionTypes(typeMirror, typeMirror2, set);
            }
            if (isIntersectionType(typeMirror2)) {
                return false;
            }
        }
        if (typeMirror != typeMirror2) {
            return (typeMirror == null || typeMirror2 == null || !((Boolean) typeMirror.accept(EqualVisitor.INSTANCE, equalVisitorParam)).booleanValue()) ? false : true;
        }
        return true;
    }

    private static boolean equalIntersectionTypes(TypeMirror typeMirror, TypeMirror typeMirror2, Set<ComparedElements> set) {
        if (!isIntersectionType(typeMirror2)) {
            return false;
        }
        try {
            Method method = GET_BOUNDS;
            return equalLists((List) method.invoke(typeMirror, new Object[0]), (List) method.invoke(typeMirror2, new Object[0]), set);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalLists(List<? extends TypeMirror> list, List<? extends TypeMirror> list2, Set<ComparedElements> set) {
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator<? extends TypeMirror> it = list.iterator();
        Iterator<? extends TypeMirror> it2 = list2.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !equal(it.next(), it2.next(), set)) {
                return false;
            }
        }
        return !it.hasNext();
    }

    public static Equivalence<TypeMirror> equivalence() {
        return TypeEquivalence.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hash(TypeMirror typeMirror, Set<Element> set) {
        if (typeMirror == null) {
            return 0;
        }
        return ((Integer) typeMirror.accept(HashVisitor.INSTANCE, set)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashList(List<? extends TypeMirror> list, Set<Element> set) {
        Iterator<? extends TypeMirror> it = list.iterator();
        int iHash = 17;
        while (it.hasNext()) {
            iHash = (iHash * 31) + hash(it.next(), set);
        }
        return iHash;
    }

    private static boolean isIntersectionType(TypeMirror typeMirror) {
        return typeMirror != null && typeMirror.getKind().name().equals("INTERSECTION");
    }

    public static boolean isType(TypeMirror typeMirror) {
        return ((Boolean) typeMirror.accept(IsTypeVisitor.INSTANCE, (Object) null)).booleanValue();
    }

    public static boolean isTypeOf(Class<?> cls, TypeMirror typeMirror) {
        Preconditions.checkNotNull(cls);
        return ((Boolean) typeMirror.accept(new IsTypeOf(cls), (Object) null)).booleanValue();
    }

    public static Optional<DeclaredType> nonObjectSuperclass(final Types types, Elements elements, DeclaredType declaredType) {
        Preconditions.checkNotNull(types);
        Preconditions.checkNotNull(elements);
        Preconditions.checkNotNull(declaredType);
        final TypeMirror typeMirrorAsType = elements.getTypeElement(Object.class.getCanonicalName()).asType();
        TypeMirror typeMirror = (TypeMirror) Iterables.getOnlyElement(FluentIterable.from(types.directSupertypes(declaredType)).filter(new Predicate<TypeMirror>() { // from class: com.google.auto.common.MoreTypes.1
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeMirror typeMirror2) {
                return typeMirror2.getKind().equals(TypeKind.DECLARED) && MoreElements.asType(MoreTypes.asDeclared(typeMirror2).asElement()).getKind().equals(ElementKind.CLASS) && !types.isSameType(typeMirrorAsType, typeMirror2);
            }
        }), null);
        return typeMirror != null ? Optional.of(asDeclared(typeMirror)) : Optional.absent();
    }

    public static ImmutableSet<TypeElement> referencedTypes(TypeMirror typeMirror) {
        Preconditions.checkNotNull(typeMirror);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        typeMirror.accept(ReferencedTypes.INSTANCE, builder);
        return builder.build();
    }
}

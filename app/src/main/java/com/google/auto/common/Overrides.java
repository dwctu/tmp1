package com.google.auto.common;

import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;
import javax.lang.model.util.Types;

/* loaded from: classes2.dex */
public abstract class Overrides {

    public static class ExplicitOverrides extends Overrides {
        private final Types typeUtils;

        public class TypeSubstVisitor extends SimpleTypeVisitor6<TypeMirror, Void> {
            private final Map<TypeParameterElement, TypeMirror> typeBindings;

            private TypeSubstVisitor() {
                this.typeBindings = Maps.newLinkedHashMap();
            }

            public TypeMirror defaultAction(TypeMirror typeMirror, Void r2) {
                return typeMirror;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public ImmutableList<TypeMirror> erasedParameterTypes(ExecutableElement executableElement, TypeElement typeElement) {
                if (executableElement.getEnclosingElement().equals(typeElement)) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    Iterator it = executableElement.getParameters().iterator();
                    while (it.hasNext()) {
                        builder.add((ImmutableList.Builder) ExplicitOverrides.this.typeUtils.erasure((TypeMirror) visit(((VariableElement) it.next()).asType())));
                    }
                    return builder.build();
                }
                ArrayList arrayListNewArrayList = Lists.newArrayList();
                if (typeElement.getSuperclass().getKind() == TypeKind.DECLARED) {
                    arrayListNewArrayList.add(typeElement.getSuperclass());
                }
                arrayListNewArrayList.addAll(typeElement.getInterfaces());
                Iterator it2 = arrayListNewArrayList.iterator();
                while (it2.hasNext()) {
                    DeclaredType declaredTypeAsDeclared = MoreTypes.asDeclared((TypeMirror) it2.next());
                    TypeElement typeElementAsType = MoreElements.asType(declaredTypeAsDeclared.asElement());
                    List typeArguments = declaredTypeAsDeclared.getTypeArguments();
                    List typeParameters = typeElementAsType.getTypeParameters();
                    Verify.verify(typeArguments.size() == typeParameters.size());
                    for (int i = 0; i < typeArguments.size(); i++) {
                        this.typeBindings.put(typeParameters.get(i), typeArguments.get(i));
                    }
                    ImmutableList<TypeMirror> immutableListErasedParameterTypes = erasedParameterTypes(executableElement, typeElementAsType);
                    if (immutableListErasedParameterTypes != null) {
                        return immutableListErasedParameterTypes;
                    }
                }
                return null;
            }

            public TypeMirror visitArray(ArrayType arrayType, Void r2) {
                return ExplicitOverrides.this.typeUtils.getArrayType((TypeMirror) visit(arrayType.getComponentType()));
            }

            public TypeMirror visitDeclared(DeclaredType declaredType, Void r4) {
                if (declaredType.getTypeArguments().isEmpty()) {
                    return declaredType;
                }
                ArrayList arrayListNewArrayList = Lists.newArrayList();
                Iterator it = declaredType.getTypeArguments().iterator();
                while (it.hasNext()) {
                    arrayListNewArrayList.add(visit((TypeMirror) it.next()));
                }
                return ExplicitOverrides.this.typeUtils.getDeclaredType(ExplicitOverrides.this.asTypeElement(declaredType), (TypeMirror[]) arrayListNewArrayList.toArray(new TypeMirror[0]));
            }

            public TypeMirror visitTypeVariable(TypeVariable typeVariable, Void r3) {
                TypeParameterElement typeParameterElementAsElement = ExplicitOverrides.this.typeUtils.asElement(typeVariable);
                if (typeParameterElementAsElement instanceof TypeParameterElement) {
                    TypeParameterElement typeParameterElement = typeParameterElementAsElement;
                    if (this.typeBindings.containsKey(typeParameterElement)) {
                        return (TypeMirror) visit(this.typeBindings.get(typeParameterElement));
                    }
                }
                return (TypeMirror) visit(ExplicitOverrides.this.typeUtils.erasure(typeVariable.getUpperBound()));
            }
        }

        public ExplicitOverrides(Types types) {
            this.typeUtils = types;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TypeElement asTypeElement(TypeMirror typeMirror) {
            return MoreElements.asType(MoreTypes.asDeclared(typeMirror).asElement());
        }

        private boolean isSubsignature(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            DeclaredType declaredTypeAsDeclared = MoreTypes.asDeclared(typeElement.asType());
            try {
                return this.typeUtils.isSubsignature(MoreTypes.asExecutable(this.typeUtils.asMemberOf(declaredTypeAsDeclared, executableElement)), MoreTypes.asExecutable(this.typeUtils.asMemberOf(declaredTypeAsDeclared, executableElement2)));
            } catch (IllegalArgumentException unused) {
                int size = executableElement.getParameters().size();
                if (executableElement2.getParameters().size() != size) {
                    return false;
                }
                ImmutableList<TypeMirror> immutableListErasedParameterTypes = erasedParameterTypes(executableElement, typeElement);
                ImmutableList<TypeMirror> immutableListErasedParameterTypes2 = erasedParameterTypes(executableElement2, typeElement);
                if (immutableListErasedParameterTypes == null || immutableListErasedParameterTypes2 == null) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (!this.typeUtils.isSameType(immutableListErasedParameterTypes.get(i), immutableListErasedParameterTypes2.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }

        private ExecutableElement methodInType(TypeElement typeElement, ExecutableElement executableElement) {
            int size = executableElement.getParameters().size();
            ImmutableList<TypeMirror> immutableListErasedParameterTypes = erasedParameterTypes(executableElement, typeElement);
            if (immutableListErasedParameterTypes == null) {
                return null;
            }
            for (ExecutableElement executableElement2 : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
                if (executableElement2.getSimpleName().equals(executableElement.getSimpleName()) && executableElement2.getParameters().size() == size) {
                    for (int i = 0; i < size; i++) {
                        if (!this.typeUtils.isSameType(immutableListErasedParameterTypes.get(i), this.typeUtils.erasure(((VariableElement) executableElement2.getParameters().get(i)).asType()))) {
                            break;
                        }
                    }
                    return executableElement2;
                }
            }
            return null;
        }

        private TypeElement superclass(TypeElement typeElement) {
            TypeMirror superclass = typeElement.getSuperclass();
            if (superclass.getKind() == TypeKind.DECLARED) {
                return MoreElements.asType(this.typeUtils.asElement(superclass));
            }
            return null;
        }

        private ImmutableList<TypeElement> superinterfaces(TypeElement typeElement) {
            ImmutableList.Builder builder = ImmutableList.builder();
            Iterator it = typeElement.getInterfaces().iterator();
            while (it.hasNext()) {
                builder.add((ImmutableList.Builder) MoreElements.asType(this.typeUtils.asElement((TypeMirror) it.next())));
            }
            return builder.build();
        }

        public ImmutableList<TypeMirror> erasedParameterTypes(ExecutableElement executableElement, TypeElement typeElement) {
            return executableElement.getParameters().isEmpty() ? ImmutableList.of() : new TypeSubstVisitor().erasedParameterTypes(executableElement, typeElement);
        }

        public ExecutableElement methodFromSuperclasses(TypeElement typeElement, ExecutableElement executableElement) {
            while (typeElement != null) {
                ExecutableElement executableElementMethodInType = methodInType(typeElement, executableElement);
                if (executableElementMethodInType != null) {
                    return executableElementMethodInType;
                }
                typeElement = superclass(typeElement);
            }
            return null;
        }

        public ExecutableElement methodFromSuperinterfaces(TypeElement typeElement, ExecutableElement executableElement) {
            TypeElement typeElementSuperclass;
            TypeElement typeElementAsType = MoreElements.asType(executableElement.getEnclosingElement());
            Preconditions.checkArgument(typeElementAsType.getKind().isInterface());
            TypeMirror typeMirrorErasure = this.typeUtils.erasure(typeElementAsType.asType());
            ImmutableList immutableListOf = ImmutableList.of(typeElement);
            while (!immutableListOf.isEmpty()) {
                ImmutableList.Builder builder = ImmutableList.builder();
                UnmodifiableIterator it = immutableListOf.iterator();
                while (it.hasNext()) {
                    TypeElement typeElement2 = (TypeElement) it.next();
                    if (this.typeUtils.isAssignable(this.typeUtils.erasure(typeElement2.asType()), typeMirrorErasure)) {
                        ExecutableElement executableElementMethodInType = methodInType(typeElement2, executableElement);
                        if (executableElementMethodInType != null) {
                            return executableElementMethodInType;
                        }
                        builder.addAll((Iterable) superinterfaces(typeElement2));
                    }
                    if (typeElement2.getKind().isClass() && (typeElementSuperclass = superclass(typeElement2)) != null) {
                        builder.add((ImmutableList.Builder) typeElementSuperclass);
                    }
                }
                immutableListOf = builder.build();
            }
            return null;
        }

        @Override // com.google.auto.common.Overrides
        public boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            if (!executableElement.getSimpleName().equals(executableElement2.getSimpleName()) || executableElement.getEnclosingElement().equals(executableElement2.getEnclosingElement()) || executableElement2.getModifiers().contains(Modifier.STATIC)) {
                return false;
            }
            Visibility visibilityOfElement = Visibility.ofElement(executableElement2);
            Visibility visibilityOfElement2 = Visibility.ofElement(executableElement);
            if (visibilityOfElement.equals(Visibility.PRIVATE) || visibilityOfElement2.compareTo(visibilityOfElement) < 0 || !isSubsignature(executableElement, executableElement2, typeElement) || !MoreElements.methodVisibleFromPackage(executableElement2, MoreElements.getPackage(executableElement)) || !(executableElement2.getEnclosingElement() instanceof TypeElement)) {
                return false;
            }
            TypeElement typeElementAsType = MoreElements.asType(executableElement2.getEnclosingElement());
            Types types = this.typeUtils;
            if (!types.isSubtype(types.erasure(typeElement.asType()), this.typeUtils.erasure(typeElementAsType.asType()))) {
                return false;
            }
            if (!typeElement.getKind().isClass()) {
                return typeElement.getKind().isInterface();
            }
            if (typeElementAsType.getKind().isClass()) {
                return !executableElement2.getEnclosingElement().equals(methodFromSuperclasses(typeElement, executableElement2).getEnclosingElement());
            }
            if (!typeElementAsType.getKind().isInterface()) {
                return false;
            }
            if (!executableElement.getModifiers().contains(Modifier.ABSTRACT)) {
                return true;
            }
            return !executableElement2.getEnclosingElement().equals(methodFromSuperinterfaces(typeElement, executableElement2).getEnclosingElement());
        }
    }

    public static class NativeOverrides extends Overrides {
        private final Elements elementUtils;

        public NativeOverrides(Elements elements) {
            this.elementUtils = elements;
        }

        @Override // com.google.auto.common.Overrides
        public boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            return this.elementUtils.overrides(executableElement, executableElement2, typeElement);
        }
    }

    public abstract boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement);
}

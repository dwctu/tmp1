package com.google.auto.common;

import com.google.auto.common.Overrides;
import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.SetMultimap;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.lang.model.util.Types;

@Beta
/* loaded from: classes2.dex */
public final class MoreElements {

    /* renamed from: com.google.auto.common.MoreElements$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$auto$common$Visibility;

        static {
            int[] iArr = new int[Visibility.values().length];
            $SwitchMap$com$google$auto$common$Visibility = iArr;
            try {
                iArr[Visibility.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$auto$common$Visibility[Visibility.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class CastingElementVisitor<T> extends SimpleElementVisitor6<T, Void> {
        private final String label;

        public CastingElementVisitor(String str) {
            this.label = str;
        }

        public final T defaultAction(Element element, Void r3) {
            throw new IllegalArgumentException(element + " does not represent a " + this.label);
        }
    }

    public static final class ExecutableElementVisitor extends CastingElementVisitor<ExecutableElement> {
        private static final ExecutableElementVisitor INSTANCE = new ExecutableElementVisitor();

        public ExecutableElementVisitor() {
            super("executable element");
        }

        public ExecutableElement visitExecutable(ExecutableElement executableElement, Void r2) {
            return executableElement;
        }
    }

    public static final class PackageElementVisitor extends CastingElementVisitor<PackageElement> {
        private static final PackageElementVisitor INSTANCE = new PackageElementVisitor();

        public PackageElementVisitor() {
            super("package element");
        }

        public PackageElement visitPackage(PackageElement packageElement, Void r2) {
            return packageElement;
        }
    }

    public static final class TypeElementVisitor extends CastingElementVisitor<TypeElement> {
        private static final TypeElementVisitor INSTANCE = new TypeElementVisitor();

        public TypeElementVisitor() {
            super("type element");
        }

        public TypeElement visitType(TypeElement typeElement, Void r2) {
            return typeElement;
        }
    }

    public static final class VariableElementVisitor extends CastingElementVisitor<VariableElement> {
        private static final VariableElementVisitor INSTANCE = new VariableElementVisitor();

        public VariableElementVisitor() {
            super("variable element");
        }

        public VariableElement visitVariable(VariableElement variableElement, Void r2) {
            return variableElement;
        }
    }

    private MoreElements() {
    }

    public static ExecutableElement asExecutable(Element element) {
        return (ExecutableElement) element.accept(ExecutableElementVisitor.INSTANCE, (Object) null);
    }

    public static PackageElement asPackage(Element element) {
        return (PackageElement) element.accept(PackageElementVisitor.INSTANCE, (Object) null);
    }

    public static TypeElement asType(Element element) {
        return (TypeElement) element.accept(TypeElementVisitor.INSTANCE, (Object) null);
    }

    public static VariableElement asVariable(Element element) {
        return (VariableElement) element.accept(VariableElementVisitor.INSTANCE, (Object) null);
    }

    public static Optional<AnnotationMirror> getAnnotationMirror(Element element, Class<? extends Annotation> cls) {
        String canonicalName = cls.getCanonicalName();
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (asType(annotationMirror.getAnnotationType().asElement()).getQualifiedName().contentEquals(canonicalName)) {
                return Optional.of(annotationMirror);
            }
        }
        return Optional.absent();
    }

    @Deprecated
    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, new Overrides.NativeOverrides(elements));
    }

    public static PackageElement getPackage(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    public static <T extends Element> Predicate<T> hasModifiers(Modifier... modifierArr) {
        return hasModifiers(ImmutableSet.copyOf(modifierArr));
    }

    public static boolean isAnnotationPresent(Element element, Class<? extends Annotation> cls) {
        return getAnnotationMirror(element, cls).isPresent();
    }

    public static boolean isType(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    public static boolean methodVisibleFromPackage(ExecutableElement executableElement, PackageElement packageElement) {
        int i = AnonymousClass2.$SwitchMap$com$google$auto$common$Visibility[Visibility.ofElement(executableElement).ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return true;
        }
        return getPackage(executableElement).equals(packageElement);
    }

    public static <T extends Element> Predicate<T> hasModifiers(final Set<Modifier> set) {
        return (Predicate<T>) new Predicate<T>() { // from class: com.google.auto.common.MoreElements.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // com.google.common.base.Predicate
            public boolean apply(Element element) {
                return element.getModifiers().containsAll(set);
            }
        };
    }

    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Types types, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, new Overrides.ExplicitOverrides(types));
    }

    private static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Overrides overrides) {
        LinkedHashMultimap linkedHashMultimapCreate = LinkedHashMultimap.create();
        getLocalAndInheritedMethods(getPackage(typeElement), typeElement, linkedHashMultimapCreate);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = linkedHashMultimapCreate.asMap().values().iterator();
        while (it.hasNext()) {
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) it.next());
            int i = 0;
            while (i < immutableListCopyOf.size()) {
                ExecutableElement executableElement = (ExecutableElement) immutableListCopyOf.get(i);
                i++;
                for (int i2 = i; i2 < immutableListCopyOf.size(); i2++) {
                    if (overrides.overrides((ExecutableElement) immutableListCopyOf.get(i2), executableElement, typeElement)) {
                        linkedHashSet.add(executableElement);
                    }
                }
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(linkedHashMultimapCreate.values());
        linkedHashSet2.removeAll(linkedHashSet);
        return ImmutableSet.copyOf((Collection) linkedHashSet2);
    }

    private static void getLocalAndInheritedMethods(PackageElement packageElement, TypeElement typeElement, SetMultimap<String, ExecutableElement> setMultimap) {
        Iterator it = typeElement.getInterfaces().iterator();
        while (it.hasNext()) {
            getLocalAndInheritedMethods(packageElement, MoreTypes.asTypeElement((TypeMirror) it.next()), setMultimap);
        }
        if (typeElement.getSuperclass().getKind() != TypeKind.NONE) {
            getLocalAndInheritedMethods(packageElement, MoreTypes.asTypeElement(typeElement.getSuperclass()), setMultimap);
        }
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            if (!executableElement.getModifiers().contains(Modifier.STATIC) && methodVisibleFromPackage(executableElement, packageElement)) {
                setMultimap.put(executableElement.getSimpleName().toString(), executableElement);
            }
        }
    }
}

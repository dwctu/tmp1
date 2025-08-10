package com.google.auto.common;

import com.google.common.base.Ascii;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.tools.Diagnostic;

/* loaded from: classes2.dex */
public abstract class BasicAnnotationProcessor extends AbstractProcessor {
    private Elements elements;
    private Messager messager;
    private ImmutableList<? extends ProcessingStep> steps;
    private final Set<ElementName> deferredElementNames = new LinkedHashSet();
    private final SetMultimap<ProcessingStep, ElementName> elementsDeferredBySteps = LinkedHashMultimap.create();

    public static final class ElementName {
        private final Kind kind;
        private final String name;

        public enum Kind {
            PACKAGE_NAME,
            TYPE_NAME
        }

        private ElementName(Kind kind, String str) {
            this.kind = (Kind) Preconditions.checkNotNull(kind);
            this.name = (String) Preconditions.checkNotNull(str);
        }

        public static ElementName forAnnotatedElement(Element element) {
            return element.getKind() == ElementKind.PACKAGE ? forPackageName(((PackageElement) element).getQualifiedName().toString()) : forTypeName(BasicAnnotationProcessor.getEnclosingType(element).getQualifiedName().toString());
        }

        public static ElementName forPackageName(String str) {
            return new ElementName(Kind.PACKAGE_NAME, str);
        }

        public static ElementName forTypeName(String str) {
            return new ElementName(Kind.TYPE_NAME, str);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ElementName)) {
                return false;
            }
            ElementName elementName = (ElementName) obj;
            return this.kind == elementName.kind && this.name.equals(elementName.name);
        }

        public Optional<? extends Element> getElement(Elements elements) {
            return Optional.fromNullable(this.kind == Kind.PACKAGE_NAME ? elements.getPackageElement(this.name) : elements.getTypeElement(this.name));
        }

        public int hashCode() {
            return Objects.hash(this.kind, this.name);
        }

        public String name() {
            return this.name;
        }
    }

    public interface ProcessingStep {
        Set<? extends Class<? extends Annotation>> annotations();

        Set<? extends Element> process(SetMultimap<Class<? extends Annotation>, Element> setMultimap);
    }

    private ImmutableMap<String, Optional<? extends Element>> deferredElements() {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (ElementName elementName : this.deferredElementNames) {
            builder.put(elementName.name(), elementName.getElement(this.elements));
        }
        return builder.build();
    }

    private static void findAnnotatedElements(Element element, ImmutableSet<? extends Class<? extends Annotation>> immutableSet, ImmutableSetMultimap.Builder<Class<? extends Annotation>, Element> builder) {
        for (Element element2 : element.getEnclosedElements()) {
            if (!element2.getKind().isClass() && !element2.getKind().isInterface()) {
                findAnnotatedElements(element2, immutableSet, builder);
            }
        }
        if (element instanceof ExecutableElement) {
            Iterator it = ((ExecutableElement) element).getParameters().iterator();
            while (it.hasNext()) {
                findAnnotatedElements((Element) it.next(), immutableSet, builder);
            }
        }
        UnmodifiableIterator<? extends Class<? extends Annotation>> it2 = immutableSet.iterator();
        while (it2.hasNext()) {
            Class<? extends Annotation> next = it2.next();
            if (MoreElements.isAnnotationPresent(element, next)) {
                builder.put((ImmutableSetMultimap.Builder<Class<? extends Annotation>, Element>) next, (Class<? extends Annotation>) element);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeElement getEnclosingType(Element element) {
        return (TypeElement) element.accept(new SimpleElementVisitor6<TypeElement, Void>() { // from class: com.google.auto.common.BasicAnnotationProcessor.2
            public TypeElement visitType(TypeElement typeElement, Void r2) {
                return typeElement;
            }

            public TypeElement defaultAction(Element element2, Void r2) {
                return (TypeElement) element2.getEnclosingElement().accept(this, r2);
            }

            public TypeElement visitPackage(PackageElement packageElement, Void r2) {
                throw new IllegalArgumentException();
            }
        }, (Object) null);
    }

    private ImmutableSet<? extends Class<? extends Annotation>> getSupportedAnnotationClasses() {
        Preconditions.checkState(this.steps != null);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<? extends ProcessingStep> it = this.steps.iterator();
        while (it.hasNext()) {
            builder.addAll((Iterable) it.next().annotations());
        }
        return builder.build();
    }

    private ImmutableSetMultimap<Class<? extends Annotation>, Element> indexByAnnotation(Set<ElementName> set) {
        ImmutableSet<? extends Class<? extends Annotation>> supportedAnnotationClasses = getSupportedAnnotationClasses();
        ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        Iterator<ElementName> it = set.iterator();
        while (it.hasNext()) {
            Optional<? extends Element> element = it.next().getElement(this.elements);
            if (element.isPresent()) {
                findAnnotatedElements(element.get(), supportedAnnotationClasses, builder);
            }
        }
        return builder.build();
    }

    private String processingErrorMessage(String str) {
        return String.format("[%s:MiscError] %s was unable to process %s because not all of its dependencies could be resolved. Check for compilation errors or a circular dependency with generated code.", getClass().getSimpleName(), getClass().getCanonicalName(), str);
    }

    private void reportMissingElements(Map<String, ? extends Optional<? extends Element>> map, Collection<ElementName> collection) {
        if (!collection.isEmpty()) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.putAll(map);
            for (ElementName elementName : collection) {
                if (!map.containsKey(elementName.name())) {
                    builder.put(elementName.name(), elementName.getElement(this.elements));
                }
            }
            map = builder.build();
        }
        for (Map.Entry<String, ? extends Optional<? extends Element>> entry : map.entrySet()) {
            Optional<? extends Element> value = entry.getValue();
            if (value.isPresent()) {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, processingErrorMessage("this " + Ascii.toLowerCase(value.get().getKind().name())), value.get());
            } else {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, processingErrorMessage(entry.getKey()));
            }
        }
    }

    private ImmutableSetMultimap<Class<? extends Annotation>, Element> validElements(ImmutableMap<String, Optional<? extends Element>> immutableMap, RoundEnvironment roundEnvironment) {
        ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, Optional<? extends Element>>> it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Optional<? extends Element>> next = it.next();
            Optional<? extends Element> value = next.getValue();
            if (value.isPresent()) {
                findAnnotatedElements(value.get(), getSupportedAnnotationClasses(), builder);
            } else {
                this.deferredElementNames.add(ElementName.forTypeName(next.getKey()));
            }
        }
        ImmutableSetMultimap immutableSetMultimapBuild = builder.build();
        ImmutableSetMultimap.Builder builder2 = ImmutableSetMultimap.builder();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        UnmodifiableIterator<? extends Class<? extends Annotation>> it2 = getSupportedAnnotationClasses().iterator();
        while (it2.hasNext()) {
            Class<? extends Annotation> next2 = it2.next();
            TypeElement typeElement = this.elements.getTypeElement(next2.getCanonicalName());
            UnmodifiableIterator it3 = Sets.union(typeElement == null ? ImmutableSet.of() : roundEnvironment.getElementsAnnotatedWith(typeElement), immutableSetMultimapBuild.get((ImmutableSetMultimap) next2)).iterator();
            while (it3.hasNext()) {
                PackageElement packageElement = (Element) it3.next();
                boolean z = false;
                if (packageElement.getKind().equals(ElementKind.PACKAGE)) {
                    PackageElement packageElement2 = packageElement;
                    ElementName elementNameForPackageName = ElementName.forPackageName(packageElement2.getQualifiedName().toString());
                    if (linkedHashSet.contains(elementNameForPackageName) || (!this.deferredElementNames.contains(elementNameForPackageName) && SuperficialValidation.validateElement(packageElement2))) {
                        z = true;
                    }
                    if (z) {
                        builder2.put((ImmutableSetMultimap.Builder) next2, (Class<? extends Annotation>) packageElement2);
                        linkedHashSet.add(elementNameForPackageName);
                    } else {
                        this.deferredElementNames.add(elementNameForPackageName);
                    }
                } else {
                    TypeElement enclosingType = getEnclosingType(packageElement);
                    ElementName elementNameForTypeName = ElementName.forTypeName(enclosingType.getQualifiedName().toString());
                    if (linkedHashSet.contains(elementNameForTypeName) || (!this.deferredElementNames.contains(elementNameForTypeName) && SuperficialValidation.validateElement(enclosingType))) {
                        z = true;
                    }
                    if (z) {
                        builder2.put((ImmutableSetMultimap.Builder) next2, (Class<? extends Annotation>) packageElement);
                        linkedHashSet.add(elementNameForTypeName);
                    } else {
                        this.deferredElementNames.add(elementNameForTypeName);
                    }
                }
            }
        }
        return builder2.build();
    }

    public final synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.elements = processingEnvironment.getElementUtils();
        this.messager = processingEnvironment.getMessager();
        this.steps = ImmutableList.copyOf(initSteps());
    }

    public abstract Iterable<? extends ProcessingStep> initSteps();

    @Deprecated
    public void postProcess() {
    }

    public void postRound(RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            return;
        }
        postProcess();
    }

    public final boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Preconditions.checkState(this.elements != null);
        Preconditions.checkState(this.messager != null);
        Preconditions.checkState(this.steps != null);
        ImmutableMap<String, Optional<? extends Element>> immutableMapDeferredElements = deferredElements();
        this.deferredElementNames.clear();
        if (roundEnvironment.processingOver()) {
            postRound(roundEnvironment);
            reportMissingElements(immutableMapDeferredElements, this.elementsDeferredBySteps.values());
            return false;
        }
        process(validElements(immutableMapDeferredElements, roundEnvironment));
        postRound(roundEnvironment);
        return false;
    }

    /* renamed from: getSupportedAnnotationTypes, reason: merged with bridge method [inline-methods] */
    public final ImmutableSet<String> m73getSupportedAnnotationTypes() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<? extends Class<? extends Annotation>> it = getSupportedAnnotationClasses().iterator();
        while (it.hasNext()) {
            builder.add((ImmutableSet.Builder) it.next().getCanonicalName());
        }
        return builder.build();
    }

    private void process(ImmutableSetMultimap<Class<? extends Annotation>, Element> immutableSetMultimap) {
        UnmodifiableIterator<? extends ProcessingStep> it = this.steps.iterator();
        while (it.hasNext()) {
            ProcessingStep next = it.next();
            ImmutableSetMultimap immutableSetMultimapBuild = new ImmutableSetMultimap.Builder().putAll((Multimap) indexByAnnotation(this.elementsDeferredBySteps.get((SetMultimap<ProcessingStep, ElementName>) next))).putAll((Multimap) Multimaps.filterKeys((SetMultimap) immutableSetMultimap, Predicates.in(next.annotations()))).build();
            if (immutableSetMultimapBuild.isEmpty()) {
                this.elementsDeferredBySteps.removeAll((Object) next);
            } else {
                this.elementsDeferredBySteps.replaceValues((SetMultimap<ProcessingStep, ElementName>) next, Iterables.transform(next.process(immutableSetMultimapBuild), new Function<Element, ElementName>() { // from class: com.google.auto.common.BasicAnnotationProcessor.1
                    @Override // com.google.common.base.Function
                    public ElementName apply(Element element) {
                        return ElementName.forAnnotatedElement(element);
                    }
                }));
            }
        }
    }
}

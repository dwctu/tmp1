package com.google.auto.service.processor;

import com.google.auto.common.AnnotationMirrors;
import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import com.google.auto.service.AutoService;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedOptions({"debug", "verify"})
/* loaded from: classes2.dex */
public class AutoServiceProcessor extends AbstractProcessor {

    @VisibleForTesting
    public static final String MISSING_SERVICES_ERROR = "No service interfaces provided for element!";
    private Multimap<String, String> providers = HashMultimap.create();

    /* renamed from: com.google.auto.service.processor.AutoServiceProcessor$1, reason: invalid class name */
    public class AnonymousClass1 extends SimpleAnnotationValueVisitor8<ImmutableSet<DeclaredType>, Void> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ Stream b(AnnotationValue annotationValue) {
            return ((ImmutableSet) annotationValue.accept(this, (Object) null)).stream();
        }

        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (Void) obj);
        }

        public ImmutableSet<DeclaredType> visitArray(List<? extends AnnotationValue> list, Void r2) {
            return (ImmutableSet) list.stream().flatMap(new Function() { // from class: dc.sz0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.b((AnnotationValue) obj);
                }
            }).collect(ImmutableSet.toImmutableSet());
        }

        public ImmutableSet<DeclaredType> visitType(TypeMirror typeMirror, Void r2) {
            return ImmutableSet.of(MoreTypes.asDeclared(typeMirror));
        }
    }

    private boolean checkImplementer(TypeElement typeElement, TypeElement typeElement2) {
        String str = (String) this.processingEnv.getOptions().get("verify");
        if (str == null || !Boolean.valueOf(str).booleanValue()) {
            return true;
        }
        return this.processingEnv.getTypeUtils().isSubtype(typeElement.asType(), typeElement2.asType());
    }

    private void error(String str, Element element, AnnotationMirror annotationMirror) {
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, str, element, annotationMirror);
    }

    private void fatalError(String str) {
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR: " + str);
    }

    private void generateConfigFiles() throws Throwable {
        Filer filer = this.processingEnv.getFiler();
        for (String str : this.providers.keySet()) {
            String str2 = "META-INF/services/" + str;
            log("Working on resource file: " + str2);
            try {
                TreeSet treeSetNewTreeSet = Sets.newTreeSet();
                try {
                    FileObject resource = filer.getResource(StandardLocation.CLASS_OUTPUT, "", str2);
                    log("Looking for existing resource file at " + resource.toUri());
                    Set<String> serviceFile = ServicesFiles.readServiceFile(resource.openInputStream());
                    log("Existing service entries: " + serviceFile);
                    treeSetNewTreeSet.addAll(serviceFile);
                } catch (IOException unused) {
                    log("Resource file did not already exist.");
                }
                HashSet hashSet = new HashSet(this.providers.get(str));
                if (treeSetNewTreeSet.containsAll(hashSet)) {
                    log("No new service entries being added.");
                    return;
                }
                treeSetNewTreeSet.addAll(hashSet);
                log("New service file contents: " + treeSetNewTreeSet);
                FileObject fileObjectCreateResource = filer.createResource(StandardLocation.CLASS_OUTPUT, "", str2, new Element[0]);
                OutputStream outputStreamOpenOutputStream = fileObjectCreateResource.openOutputStream();
                ServicesFiles.writeServiceFile(treeSetNewTreeSet, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.close();
                log("Wrote to: " + fileObjectCreateResource.toUri());
            } catch (IOException e) {
                fatalError("Unable to create " + str2 + ", " + e);
                return;
            }
        }
    }

    private String getBinaryName(TypeElement typeElement) {
        return getBinaryNameImpl(typeElement, typeElement.getSimpleName().toString());
    }

    private String getBinaryNameImpl(TypeElement typeElement, String str) {
        PackageElement enclosingElement = typeElement.getEnclosingElement();
        if (!(enclosingElement instanceof PackageElement)) {
            TypeElement typeElement2 = (TypeElement) enclosingElement;
            return getBinaryNameImpl(typeElement2, typeElement2.getSimpleName() + "$" + str);
        }
        PackageElement packageElement = enclosingElement;
        if (packageElement.isUnnamed()) {
            return str;
        }
        return packageElement.getQualifiedName() + "." + str;
    }

    private ImmutableSet<DeclaredType> getValueFieldOfClasses(AnnotationMirror annotationMirror) {
        return (ImmutableSet) AnnotationMirrors.getAnnotationValue(annotationMirror, "value").accept(new AnonymousClass1(), (Object) null);
    }

    private void log(String str) {
        if (this.processingEnv.getOptions().containsKey("debug")) {
            this.processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, str);
        }
    }

    private void processAnnotations(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(AutoService.class);
        log(set.toString());
        log(elementsAnnotatedWith.toString());
        for (Element element : elementsAnnotatedWith) {
            TypeElement typeElement = (TypeElement) element;
            AnnotationMirror annotationMirror = MoreElements.getAnnotationMirror(element, AutoService.class).get();
            ImmutableSet<DeclaredType> valueFieldOfClasses = getValueFieldOfClasses(annotationMirror);
            if (valueFieldOfClasses.isEmpty()) {
                error(MISSING_SERVICES_ERROR, element, annotationMirror);
            } else {
                Iterator<DeclaredType> it = valueFieldOfClasses.iterator();
                while (it.hasNext()) {
                    TypeElement typeElementAsTypeElement = MoreTypes.asTypeElement(it.next());
                    log("provider interface: " + typeElementAsTypeElement.getQualifiedName());
                    log("provider implementer: " + typeElement.getQualifiedName());
                    if (checkImplementer(typeElement, typeElementAsTypeElement)) {
                        this.providers.put(getBinaryName(typeElementAsTypeElement), getBinaryName(typeElement));
                    } else {
                        error("ServiceProviders must implement their service provider interface. " + typeElement.getQualifiedName() + " does not implement " + typeElementAsTypeElement.getQualifiedName(), element, annotationMirror);
                    }
                }
            }
        }
    }

    private boolean processImpl(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) throws Throwable {
        if (roundEnvironment.processingOver()) {
            generateConfigFiles();
            return true;
        }
        processAnnotations(set, roundEnvironment);
        return true;
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        try {
            return processImpl(set, roundEnvironment);
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fatalError(stringWriter.toString());
            return true;
        }
    }

    /* renamed from: getSupportedAnnotationTypes, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<String> m75getSupportedAnnotationTypes() {
        return ImmutableSet.of(AutoService.class.getName());
    }
}

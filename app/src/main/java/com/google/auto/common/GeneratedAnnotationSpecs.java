package com.google.auto.common;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import dc.nz0;
import java.util.Optional;
import java.util.function.Function;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* loaded from: classes2.dex */
public final class GeneratedAnnotationSpecs {
    private GeneratedAnnotationSpecs() {
    }

    @Deprecated
    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, Class<?> cls) {
        return generatedAnnotationSpecBuilder(elements, cls).map(nz0.a);
    }

    private static Optional<AnnotationSpec.Builder> generatedAnnotationSpecBuilder(Elements elements, final Class<?> cls) {
        return GeneratedAnnotations.generatedAnnotation(elements).map(new Function() { // from class: dc.mz0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return AnnotationSpec.builder(ClassName.get((TypeElement) obj)).addMember("value", "$S", new Object[]{cls.getCanonicalName()});
            }
        });
    }

    @Deprecated
    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, Class<?> cls, final String str) {
        return generatedAnnotationSpecBuilder(elements, cls).map(new Function() { // from class: dc.oz0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((AnnotationSpec.Builder) obj).addMember("comments", "$S", new Object[]{str}).build();
            }
        });
    }

    private static Optional<AnnotationSpec.Builder> generatedAnnotationSpecBuilder(Elements elements, SourceVersion sourceVersion, final Class<?> cls) {
        return GeneratedAnnotations.generatedAnnotation(elements, sourceVersion).map(new Function() { // from class: dc.pz0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return AnnotationSpec.builder(ClassName.get((TypeElement) obj)).addMember("value", "$S", new Object[]{cls.getCanonicalName()});
            }
        });
    }

    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, SourceVersion sourceVersion, Class<?> cls) {
        return generatedAnnotationSpecBuilder(elements, sourceVersion, cls).map(nz0.a);
    }

    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, SourceVersion sourceVersion, Class<?> cls, final String str) {
        return generatedAnnotationSpecBuilder(elements, sourceVersion, cls).map(new Function() { // from class: dc.lz0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((AnnotationSpec.Builder) obj).addMember("comments", "$S", new Object[]{str}).build();
            }
        });
    }
}

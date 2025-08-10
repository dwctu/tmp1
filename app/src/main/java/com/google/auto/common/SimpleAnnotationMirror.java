package com.google.auto.common;

import com.google.auto.common.SimpleAnnotationMirror;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.ElementFilter;

/* loaded from: classes2.dex */
public final class SimpleAnnotationMirror implements AnnotationMirror {
    private final TypeElement annotationType;
    private final ImmutableMap<ExecutableElement, ? extends AnnotationValue> elementValues;
    private final ImmutableMap<String, ? extends AnnotationValue> namedValues;

    private SimpleAnnotationMirror(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        Preconditions.checkArgument(typeElement.getKind().equals(ElementKind.ANNOTATION_TYPE), "annotationType must be an annotation: %s", typeElement);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(map);
        ArrayList arrayList = new ArrayList();
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            String string = executableElement.getSimpleName().toString();
            if (linkedHashMap2.containsKey(string)) {
                linkedHashMap.put(string, linkedHashMap2.remove(string));
            } else if (executableElement.getDefaultValue() != null) {
                linkedHashMap.put(string, executableElement.getDefaultValue());
            } else {
                arrayList.add(string);
            }
        }
        Preconditions.checkArgument(linkedHashMap2.isEmpty(), "namedValues has entries for members that are not in %s: %s", typeElement, linkedHashMap2);
        Preconditions.checkArgument(arrayList.isEmpty(), "namedValues is missing entries for: %s", arrayList);
        this.annotationType = typeElement;
        this.namedValues = ImmutableMap.copyOf((Map) map);
        this.elementValues = (ImmutableMap) ElementFilter.methodsIn(typeElement.getEnclosedElements()).stream().collect(ImmutableMap.toImmutableMap(new Function() { // from class: dc.qz0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ExecutableElement executableElement2 = (ExecutableElement) obj;
                SimpleAnnotationMirror.a(executableElement2);
                return executableElement2;
            }
        }, new Function() { // from class: dc.rz0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SimpleAnnotationMirror.b(linkedHashMap, (ExecutableElement) obj);
            }
        }));
    }

    public static /* synthetic */ ExecutableElement a(ExecutableElement executableElement) {
        return executableElement;
    }

    public static /* synthetic */ AnnotationValue b(Map map, ExecutableElement executableElement) {
        return (AnnotationValue) map.get(executableElement.getSimpleName().toString());
    }

    public static AnnotationMirror of(TypeElement typeElement) {
        return of(typeElement, ImmutableMap.of());
    }

    public boolean equals(Object obj) {
        return (obj instanceof AnnotationMirror) && AnnotationMirrors.equivalence().equivalent(this, (AnnotationMirror) obj);
    }

    public DeclaredType getAnnotationType() {
        return MoreTypes.asDeclared(this.annotationType.asType());
    }

    public Map<ExecutableElement, ? extends AnnotationValue> getElementValues() {
        return this.elementValues;
    }

    public int hashCode() {
        return AnnotationMirrors.equivalence().hash(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("@");
        sb.append((CharSequence) this.annotationType.getQualifiedName());
        if (!this.namedValues.isEmpty()) {
            sb.append('(');
            sb.append(Joiner.on(", ").withKeyValueSeparator(" = ").join(this.namedValues));
            sb.append(')');
        }
        return sb.toString();
    }

    public static AnnotationMirror of(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        return new SimpleAnnotationMirror(typeElement, map);
    }
}

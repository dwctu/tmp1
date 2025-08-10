package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes5.dex */
public class FrameworkField extends FrameworkMember<FrameworkField> {
    private final Field field;

    public FrameworkField(Field field) {
        Objects.requireNonNull(field, "FrameworkField cannot be created without an underlying field.");
        this.field = field;
    }

    public Object get(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.field.get(obj);
    }

    @Override // org.junit.runners.model.Annotatable
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.field.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.Annotatable
    public Annotation[] getAnnotations() {
        return this.field.getAnnotations();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public Field getField() {
        return this.field;
    }

    @Override // org.junit.runners.model.FrameworkMember
    public int getModifiers() {
        return this.field.getModifiers();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public String getName() {
        return getField().getName();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getType() {
        return this.field.getType();
    }

    public String toString() {
        return this.field.toString();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public boolean isShadowedBy(FrameworkField frameworkField) {
        return frameworkField.getName().equals(getName());
    }
}

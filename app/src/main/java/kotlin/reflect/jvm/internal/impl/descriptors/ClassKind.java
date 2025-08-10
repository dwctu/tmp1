package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.Nullable;

/* compiled from: ClassKind.kt */
/* loaded from: classes4.dex */
public enum ClassKind {
    CLASS("class"),
    INTERFACE("interface"),
    ENUM_CLASS("enum class"),
    ENUM_ENTRY(null),
    ANNOTATION_CLASS("annotation class"),
    OBJECT("object");


    @Nullable
    private final String codeRepresentation;

    ClassKind(String str) {
        this.codeRepresentation = str;
    }

    public final boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}

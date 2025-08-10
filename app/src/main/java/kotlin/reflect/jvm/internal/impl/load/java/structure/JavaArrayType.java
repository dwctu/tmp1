package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;

/* compiled from: javaTypes.kt */
/* loaded from: classes4.dex */
public interface JavaArrayType extends JavaType {
    @NotNull
    JavaType getComponentType();
}

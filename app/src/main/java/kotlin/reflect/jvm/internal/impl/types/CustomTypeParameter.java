package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: TypeCapabilities.kt */
/* loaded from: classes4.dex */
public interface CustomTypeParameter {
    boolean isTypeParameter();

    @NotNull
    KotlinType substitutionResult(@NotNull KotlinType kotlinType);
}

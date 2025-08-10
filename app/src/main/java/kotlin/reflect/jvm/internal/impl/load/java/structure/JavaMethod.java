package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: javaElements.kt */
/* loaded from: classes4.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {

    /* compiled from: javaElements.kt */
    public static final class DefaultImpls {
        public static boolean getHasAnnotationParameterDefaultValue(@NotNull JavaMethod javaMethod) {
            return javaMethod.getAnnotationParameterDefaultValue() != null;
        }
    }

    @Nullable
    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    @NotNull
    JavaType getReturnType();

    @NotNull
    List<JavaValueParameter> getValueParameters();
}

package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes4.dex */
public interface VariableDescriptor extends ValueDescriptor {
    @Nullable
    /* renamed from: getCompileTimeInitializer */
    ConstantValue<?> mo1377getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}

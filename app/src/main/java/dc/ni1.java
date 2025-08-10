package dc;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: VertexUtil.kt */
/* loaded from: classes3.dex */
public final class ni1 {
    public static final ni1 a = new ni1();

    @NotNull
    public final float[] a(int i, int i2, @NotNull yg1 rect, @NotNull float[] array) {
        Intrinsics.checkParameterIsNotNull(rect, "rect");
        Intrinsics.checkParameterIsNotNull(array, "array");
        float f = i;
        array[0] = b(rect.c() / f);
        float f2 = i2;
        array[1] = c(rect.d() / f2);
        array[2] = b(rect.c() / f);
        array[3] = c((rect.d() + rect.a()) / f2);
        array[4] = b((rect.c() + rect.b()) / f);
        array[5] = c(rect.d() / f2);
        array[6] = b((rect.c() + rect.b()) / f);
        array[7] = c((rect.d() + rect.a()) / f2);
        return array;
    }

    public final float b(float f) {
        return (f * 2.0f) - 1.0f;
    }

    public final float c(float f) {
        return (((f * 2.0f) - 2.0f) * (-1.0f)) - 1.0f;
    }
}

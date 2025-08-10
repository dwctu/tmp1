package dc;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TexCoordsUtil.kt */
/* loaded from: classes3.dex */
public final class li1 {
    public static final li1 a = new li1();

    @NotNull
    public final float[] a(int i, int i2, @NotNull yg1 rect, @NotNull float[] array) {
        Intrinsics.checkParameterIsNotNull(rect, "rect");
        Intrinsics.checkParameterIsNotNull(array, "array");
        float f = i;
        array[0] = rect.c() / f;
        float f2 = i2;
        array[1] = rect.d() / f2;
        array[2] = rect.c() / f;
        array[3] = (rect.d() + rect.a()) / f2;
        array[4] = (rect.c() + rect.b()) / f;
        array[5] = rect.d() / f2;
        array[6] = (rect.c() + rect.b()) / f;
        array[7] = (rect.d() + rect.a()) / f2;
        return array;
    }

    @NotNull
    public final float[] b(@NotNull float[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        float f = array[0];
        float f2 = array[1];
        array[0] = array[2];
        array[1] = array[3];
        array[2] = array[6];
        array[3] = array[7];
        array[6] = array[4];
        array[7] = array[5];
        array[4] = f;
        array[5] = f2;
        return array;
    }
}

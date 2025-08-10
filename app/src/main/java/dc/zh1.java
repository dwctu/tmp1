package dc;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: GlFloatArray.kt */
/* loaded from: classes3.dex */
public final class zh1 {

    @NotNull
    public final float[] a;
    public FloatBuffer b;

    public zh1() {
        float[] fArr = new float[8];
        this.a = fArr;
        FloatBuffer floatBufferPut = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        Intrinsics.checkExpressionValueIsNotNull(floatBufferPut, "ByteBuffer\n            .…)\n            .put(array)");
        this.b = floatBufferPut;
    }

    @NotNull
    public final float[] a() {
        return this.a;
    }

    public final void b(@NotNull float[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        this.b.position(0);
        this.b.put(array);
    }

    public final void c(int i) {
        this.b.position(0);
        GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, (Buffer) this.b);
        GLES20.glEnableVertexAttribArray(i);
    }
}

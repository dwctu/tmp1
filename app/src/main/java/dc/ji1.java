package dc;

import android.opengl.GLES20;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ShaderUtil.kt */
/* loaded from: classes3.dex */
public final class ji1 {
    public static final ji1 a = new ji1();

    public final int a(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                xh1.c.b("AnimPlayer.ShaderUtil", "Error compiling shader: " + GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                iGlCreateShader = 0;
            }
        }
        if (iGlCreateShader != 0) {
            return iGlCreateShader;
        }
        throw new RuntimeException("Error creating shader.");
    }

    public final int b(int i, int i2) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, i);
            GLES20.glAttachShader(iGlCreateProgram, i2);
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                xh1.c.b("AnimPlayer.ShaderUtil", "Error compiling program: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
                GLES20.glDeleteProgram(iGlCreateProgram);
                iGlCreateProgram = 0;
            }
        }
        if (iGlCreateProgram != 0) {
            return iGlCreateProgram;
        }
        throw new RuntimeException("Error creating program.");
    }

    public final int c(@NotNull String vertexSource, @NotNull String fragmentSource) {
        Intrinsics.checkParameterIsNotNull(vertexSource, "vertexSource");
        Intrinsics.checkParameterIsNotNull(fragmentSource, "fragmentSource");
        return b(a(35633, vertexSource), a(35632, fragmentSource));
    }
}

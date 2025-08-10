package dc;

import android.opengl.GLES20;

/* compiled from: MixShader.kt */
/* loaded from: classes3.dex */
public final class qh1 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public qh1() {
        int iC = ji1.a.c("attribute vec4 a_Position;  \nattribute vec2 a_TextureSrcCoordinates;\nattribute vec2 a_TextureMaskCoordinates;\nvarying vec2 v_TextureSrcCoordinates;\nvarying vec2 v_TextureMaskCoordinates;\nvoid main()\n{\n    v_TextureSrcCoordinates = a_TextureSrcCoordinates;\n    v_TextureMaskCoordinates = a_TextureMaskCoordinates;\n    gl_Position = a_Position;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float; \nuniform sampler2D u_TextureSrcUnit;\nuniform samplerExternalOES u_TextureMaskUnit;\nuniform int u_isFill;\nuniform vec4 u_Color;\nvarying vec2 v_TextureSrcCoordinates;\nvarying vec2 v_TextureMaskCoordinates;\nvoid main()\n{\n    vec4 srcRgba = texture2D(u_TextureSrcUnit, v_TextureSrcCoordinates);\n    vec4 maskRgba = texture2D(u_TextureMaskUnit, v_TextureMaskCoordinates);\n    float isFill = step(0.5, float(u_isFill));\n    vec4 srcRgbaCal = isFill * vec4(u_Color.r, u_Color.g, u_Color.b, srcRgba.a) + (1.0 - isFill) * srcRgba;\n    gl_FragColor = vec4(srcRgbaCal.r, srcRgbaCal.g, srcRgbaCal.b, srcRgba.a * maskRgba.r);\n}");
        this.a = iC;
        this.b = GLES20.glGetUniformLocation(iC, "u_TextureSrcUnit");
        this.c = GLES20.glGetUniformLocation(iC, "u_TextureMaskUnit");
        this.d = GLES20.glGetUniformLocation(iC, "u_isFill");
        this.e = GLES20.glGetUniformLocation(iC, "u_Color");
        this.f = GLES20.glGetAttribLocation(iC, "a_Position");
        this.g = GLES20.glGetAttribLocation(iC, "a_TextureSrcCoordinates");
        this.h = GLES20.glGetAttribLocation(iC, "a_TextureMaskCoordinates");
    }

    public final int a() {
        return this.f;
    }

    public final int b() {
        return this.h;
    }

    public final int c() {
        return this.g;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.e;
    }

    public final int f() {
        return this.d;
    }

    public final int g() {
        return this.c;
    }

    public final int h() {
        return this.b;
    }

    public final void i() {
        GLES20.glUseProgram(this.a);
    }
}

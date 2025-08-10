package dc;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import dc.xg1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Render.kt */
/* loaded from: classes3.dex */
public final class zg1 implements xg1 {
    public final zh1 a;
    public final zh1 b;
    public final zh1 c;
    public boolean d;
    public int e;
    public int f;
    public final tg1 g;
    public int h;
    public int[] i;
    public int j;
    public int k;
    public int l;
    public int m;

    public zg1(@NotNull SurfaceTexture surfaceTexture) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "surfaceTexture");
        this.a = new zh1();
        this.b = new zh1();
        this.c = new zh1();
        tg1 tg1Var = new tg1();
        this.g = tg1Var;
        this.i = new int[1];
        tg1Var.e(surfaceTexture);
        j();
    }

    @Override // dc.xg1
    public void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.d = true;
        this.e = i;
        this.f = i2;
    }

    @Override // dc.xg1
    public void b(int i, int i2, @Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        xg1.a.a(this, i, i2, bArr, bArr2, bArr3);
    }

    @Override // dc.xg1
    public void c() {
        int i;
        int i2;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (this.d && (i = this.e) > 0 && (i2 = this.f) > 0) {
            this.d = false;
            GLES20.glViewport(0, 0, i, i2);
        }
        i();
    }

    @Override // dc.xg1
    public void d() {
        g();
        this.g.d();
    }

    @Override // dc.xg1
    public int e() {
        return this.i[0];
    }

    @Override // dc.xg1
    public void f(@NotNull ng1 config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        l(config);
        k(config);
    }

    @Override // dc.xg1
    public void g() {
        int[] iArr = this.i;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    @Override // dc.xg1
    public void h() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.g.f();
    }

    public final void i() {
        GLES20.glUseProgram(this.h);
        this.a.c(this.k);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.i[0]);
        GLES20.glUniform1i(this.j, 0);
        this.b.c(this.l);
        this.c.c(this.m);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void j() {
        int iC = ji1.a.c("attribute vec4 vPosition;\nattribute vec4 vTexCoordinateAlpha;\nattribute vec4 vTexCoordinateRgb;\nvarying vec2 v_TexCoordinateAlpha;\nvarying vec2 v_TexCoordinateRgb;\n\nvoid main() {\n    v_TexCoordinateAlpha = vec2(vTexCoordinateAlpha.x, vTexCoordinateAlpha.y);\n    v_TexCoordinateRgb = vec2(vTexCoordinateRgb.x, vTexCoordinateRgb.y);\n    gl_Position = vPosition;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinateAlpha;\nvarying vec2 v_TexCoordinateRgb;\n\nvoid main () {\n    vec4 alphaColor = texture2D(texture, v_TexCoordinateAlpha);\n    vec4 rgbColor = texture2D(texture, v_TexCoordinateRgb);\n    gl_FragColor = vec4(rgbColor.r, rgbColor.g, rgbColor.b, alphaColor.r);\n}");
        this.h = iC;
        this.j = GLES20.glGetUniformLocation(iC, "texture");
        this.k = GLES20.glGetAttribLocation(this.h, "vPosition");
        this.l = GLES20.glGetAttribLocation(this.h, "vTexCoordinateAlpha");
        this.m = GLES20.glGetAttribLocation(this.h, "vTexCoordinateRgb");
        int[] iArr = this.i;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        GLES20.glBindTexture(36197, this.i[0]);
        GLES20.glTexParameterf(36197, 10241, 9728);
        GLES20.glTexParameterf(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
    }

    public final void k(ng1 ng1Var) {
        li1 li1Var = li1.a;
        int i = ng1Var.i();
        int iH = ng1Var.h();
        yg1 yg1VarA = ng1Var.a();
        float[] fArrA = this.b.a();
        li1Var.a(i, iH, yg1VarA, fArrA);
        int i2 = ng1Var.i();
        int iH2 = ng1Var.h();
        yg1 yg1VarG = ng1Var.g();
        float[] fArrA2 = this.c.a();
        li1Var.a(i2, iH2, yg1VarG, fArrA2);
        this.b.b(fArrA);
        this.c.b(fArrA2);
    }

    public final void l(ng1 ng1Var) {
        zh1 zh1Var = this.a;
        ni1 ni1Var = ni1.a;
        int iJ = ng1Var.j();
        int iD = ng1Var.d();
        yg1 yg1Var = new yg1(0, 0, ng1Var.j(), ng1Var.d());
        float[] fArrA = this.a.a();
        ni1Var.a(iJ, iD, yg1Var, fArrA);
        zh1Var.b(fArrA);
    }

    @Override // dc.xg1
    public void swapBuffers() {
        this.g.f();
    }
}

package dc;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import dc.xg1;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: YUVRender.kt */
/* loaded from: classes3.dex */
public final class ah1 implements xg1 {
    public final zh1 a;
    public final zh1 b;
    public final zh1 c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int[] k;
    public int l;
    public int m;
    public int n;
    public int o;
    public ByteBuffer p;
    public ByteBuffer q;
    public ByteBuffer r;
    public final tg1 s;
    public int t;
    public final float[] u;
    public final float[] v;

    public ah1(@NotNull SurfaceTexture surfaceTexture) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "surfaceTexture");
        this.a = new zh1();
        this.b = new zh1();
        this.c = new zh1();
        this.k = new int[3];
        tg1 tg1Var = new tg1();
        this.s = tg1Var;
        this.t = 4;
        this.u = new float[]{0.0f, -0.5019608f, -0.5019608f};
        this.v = new float[]{1.0f, 1.0f, 1.0f, 0.0f, -0.3441f, 1.772f, 1.402f, -0.7141f, 0.0f};
        tg1Var.e(surfaceTexture);
        j();
    }

    @Override // dc.xg1
    public void a(int i, int i2) {
        xg1.a.b(this, i, i2);
    }

    @Override // dc.xg1
    public void b(int i, int i2, @Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        this.n = i;
        this.o = i2;
        this.p = ByteBuffer.wrap(bArr);
        this.q = ByteBuffer.wrap(bArr2);
        this.r = ByteBuffer.wrap(bArr3);
        int i3 = this.n;
        if ((i3 / 2) % 4 != 0) {
            this.t = (i3 / 2) % 2 != 0 ? 1 : 2;
        }
    }

    @Override // dc.xg1
    public void c() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        i();
    }

    @Override // dc.xg1
    public void d() {
        g();
        this.s.d();
    }

    @Override // dc.xg1
    public int e() {
        return this.k[0];
    }

    @Override // dc.xg1
    public void f(@NotNull ng1 config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        zh1 zh1Var = this.a;
        ni1 ni1Var = ni1.a;
        int iJ = config.j();
        int iD = config.d();
        yg1 yg1Var = new yg1(0, 0, config.j(), config.d());
        float[] fArrA = this.a.a();
        ni1Var.a(iJ, iD, yg1Var, fArrA);
        zh1Var.b(fArrA);
        li1 li1Var = li1.a;
        int i = config.i();
        int iH = config.h();
        yg1 yg1VarA = config.a();
        float[] fArrA2 = this.b.a();
        li1Var.a(i, iH, yg1VarA, fArrA2);
        int i2 = config.i();
        int iH2 = config.h();
        yg1 yg1VarG = config.g();
        float[] fArrA3 = this.c.a();
        li1Var.a(i2, iH2, yg1VarG, fArrA3);
        this.b.b(fArrA2);
        this.c.b(fArrA3);
    }

    @Override // dc.xg1
    public void g() {
        int[] iArr = this.k;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    @Override // dc.xg1
    public void h() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.s.f();
    }

    public final void i() {
        if (this.n <= 0 || this.o <= 0 || this.p == null || this.q == null || this.r == null) {
            return;
        }
        GLES20.glUseProgram(this.d);
        this.a.c(this.e);
        this.b.c(this.g);
        this.c.c(this.f);
        GLES20.glPixelStorei(3317, this.t);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.k[0]);
        GLES20.glTexImage2D(3553, 0, 6409, this.n, this.o, 0, 6409, 5121, this.p);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.k[1]);
        GLES20.glTexImage2D(3553, 0, 6409, this.n / 2, this.o / 2, 0, 6409, 5121, this.q);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.k[2]);
        GLES20.glTexImage2D(3553, 0, 6409, this.n / 2, this.o / 2, 0, 6409, 5121, this.r);
        GLES20.glUniform1i(this.h, 0);
        GLES20.glUniform1i(this.i, 1);
        GLES20.glUniform1i(this.j, 2);
        GLES20.glUniform3fv(this.m, 1, FloatBuffer.wrap(this.u));
        GLES20.glUniformMatrix3fv(this.l, 1, false, this.v, 0);
        GLES20.glDrawArrays(5, 0, 4);
        ByteBuffer byteBuffer = this.p;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.q;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        ByteBuffer byteBuffer3 = this.r;
        if (byteBuffer3 != null) {
            byteBuffer3.clear();
        }
        this.p = null;
        this.q = null;
        this.r = null;
        GLES20.glDisableVertexAttribArray(this.e);
        GLES20.glDisableVertexAttribArray(this.f);
        GLES20.glDisableVertexAttribArray(this.g);
    }

    public void j() {
        int iC = ji1.a.c("attribute vec4 v_Position;\nattribute vec2 vTexCoordinateAlpha;\nattribute vec2 vTexCoordinateRgb;\nvarying vec2 v_TexCoordinateAlpha;\nvarying vec2 v_TexCoordinateRgb;\n\nvoid main() {\n    v_TexCoordinateAlpha = vTexCoordinateAlpha;\n    v_TexCoordinateRgb = vTexCoordinateRgb;\n    gl_Position = v_Position;\n}", "precision mediump float;\nuniform sampler2D sampler_y;\nuniform sampler2D sampler_u;\nuniform sampler2D sampler_v;\nvarying vec2 v_TexCoordinateAlpha;\nvarying vec2 v_TexCoordinateRgb;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main() {\n   highp vec3 yuvColorAlpha;\n   highp vec3 yuvColorRGB;\n   highp vec3 rgbColorAlpha;\n   highp vec3 rgbColorRGB;\n   yuvColorAlpha.x = texture2D(sampler_y,v_TexCoordinateAlpha).r;\n   yuvColorRGB.x = texture2D(sampler_y,v_TexCoordinateRgb).r;\n   yuvColorAlpha.y = texture2D(sampler_u,v_TexCoordinateAlpha).r;\n   yuvColorAlpha.z = texture2D(sampler_v,v_TexCoordinateAlpha).r;\n   yuvColorRGB.y = texture2D(sampler_u,v_TexCoordinateRgb).r;\n   yuvColorRGB.z = texture2D(sampler_v,v_TexCoordinateRgb).r;\n   yuvColorAlpha += offset;\n   yuvColorRGB += offset;\n   rgbColorAlpha = convertMatrix * yuvColorAlpha; \n   rgbColorRGB = convertMatrix * yuvColorRGB; \n   gl_FragColor=vec4(rgbColorRGB, rgbColorAlpha.r);\n}");
        this.d = iC;
        this.e = GLES20.glGetAttribLocation(iC, "v_Position");
        this.f = GLES20.glGetAttribLocation(this.d, "vTexCoordinateRgb");
        this.g = GLES20.glGetAttribLocation(this.d, "vTexCoordinateAlpha");
        this.h = GLES20.glGetUniformLocation(this.d, "sampler_y");
        this.i = GLES20.glGetUniformLocation(this.d, "sampler_u");
        this.j = GLES20.glGetUniformLocation(this.d, "sampler_v");
        this.l = GLES20.glGetUniformLocation(this.d, "convertMatrix");
        this.m = GLES20.glGetUniformLocation(this.d, TypedValues.CycleType.S_WAVE_OFFSET);
        int[] iArr = this.k;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        for (int i : this.k) {
            GLES20.glBindTexture(3553, i);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
        }
    }

    @Override // dc.xg1
    public void swapBuffers() {
        this.s.f();
    }
}

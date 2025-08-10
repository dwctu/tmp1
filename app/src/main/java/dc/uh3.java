package dc;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

/* compiled from: GPUImageFilter.java */
/* loaded from: classes4.dex */
public class uh3 {
    public final LinkedList<Runnable> a;
    public final String b;
    public final String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public FloatBuffer i;
    public FloatBuffer j;

    /* compiled from: GPUImageFilter.java */
    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ float b;

        public a(uh3 uh3Var, int i, float f) {
            this.a = i;
            this.b = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glUniform1f(this.a, this.b);
        }
    }

    /* compiled from: GPUImageFilter.java */
    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ float[] b;

        public b(uh3 uh3Var, int i, float[] fArr) {
            this.a = i;
            this.b = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glUniform2fv(this.a, 1, FloatBuffer.wrap(this.b));
        }
    }

    public uh3() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public final void a() {
        this.h = false;
        GLES20.glDeleteProgram(this.d);
        e();
    }

    public int b() {
        return this.d;
    }

    public void c() {
        j();
        this.h = true;
        k();
    }

    public boolean d() {
        return this.h;
    }

    public void e() {
    }

    public void f(int i, int i2) {
    }

    public void g() {
    }

    public void h() {
    }

    public int i(int i) {
        GLES20.glUseProgram(this.d);
        n();
        if (!this.h) {
            return -1;
        }
        this.i.position(0);
        GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, (Buffer) this.i);
        GLES20.glEnableVertexAttribArray(this.e);
        this.j.position(0);
        GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 0, (Buffer) this.j);
        GLES20.glEnableVertexAttribArray(this.g);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(this.f, 0);
        }
        h();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.e);
        GLES20.glDisableVertexAttribArray(this.g);
        g();
        GLES20.glBindTexture(3553, 0);
        return 1;
    }

    public void j() {
        int iB = ii3.b(this.b, this.c);
        this.d = iB;
        this.e = GLES20.glGetAttribLocation(iB, "position");
        this.f = GLES20.glGetUniformLocation(this.d, "inputImageTexture");
        this.g = GLES20.glGetAttribLocation(this.d, "inputTextureCoordinate");
        this.h = true;
    }

    public void k() {
    }

    public void l(int i, int i2) {
    }

    public void m(Runnable runnable) {
        synchronized (this.a) {
            this.a.addLast(runnable);
        }
    }

    public void n() {
        while (!this.a.isEmpty()) {
            this.a.removeFirst().run();
        }
    }

    public void o(int i, float f) {
        m(new a(this, i, f));
    }

    public void p(int i, float[] fArr) {
        m(new b(this, i, fArr));
    }

    public uh3(String str, String str2) {
        this.a = new LinkedList<>();
        this.b = str;
        this.c = str2;
        float[] fArr = ki3.e;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(ki3.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.j = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(ki3.b(ji3.NORMAL, false, true)).position(0);
    }
}

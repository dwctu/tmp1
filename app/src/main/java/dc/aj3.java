package dc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: TextureRenderer.java */
@TargetApi(16)
/* loaded from: classes4.dex */
public class aj3 {
    public static final float[] k = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public FloatBuffer a;
    public int d;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float[] b = new float[16];
    public float[] c = new float[16];
    public int e = -12345;

    public aj3(int i) {
        this.j = 0;
        this.j = i;
        float[] fArr = k;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.a = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.c, 0);
    }

    public void a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public final int b(String str, String str2) {
        int iE;
        int iE2 = e(35633, str);
        if (iE2 == 0 || (iE = e(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (iGlCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iE2);
        a("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iE);
        a("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public void c(SurfaceTexture surfaceTexture, boolean z) {
        a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.c);
        if (z) {
            float[] fArr = this.c;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glUseProgram(this.d);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.e);
        this.a.position(0);
        GLES20.glVertexAttribPointer(this.h, 3, 5126, false, 20, (Buffer) this.a);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.h);
        a("glEnableVertexAttribArray maPositionHandle");
        this.a.position(3);
        GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 20, (Buffer) this.a);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.i);
        a("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.g, 1, false, this.c, 0);
        GLES20.glUniformMatrix4fv(this.f, 1, false, this.b, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    public int d() {
        return this.e;
    }

    public final int e(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader type=" + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public void f() {
        int iB = b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.d = iB;
        if (iB == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.h = GLES20.glGetAttribLocation(iB, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.h == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.i = GLES20.glGetAttribLocation(this.d, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.i == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.f = GLES20.glGetUniformLocation(this.d, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.f == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.g = GLES20.glGetUniformLocation(this.d, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.g == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.e = i;
        GLES20.glBindTexture(36197, i);
        a("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        a("glTexParameter");
        Matrix.setIdentityM(this.b, 0);
        int i2 = this.j;
        if (i2 != 0) {
            Matrix.rotateM(this.b, 0, i2, 0.0f, 0.0f, 1.0f);
        }
    }
}

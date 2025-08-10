package dc;

import android.content.res.Resources;
import android.opengl.GLES20;
import com.broadcom.bt.util.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: AFilter.java */
/* loaded from: classes4.dex */
public abstract class mh3 {
    public static boolean o = true;
    public static final float[] p = ui3.getOriginalMatrix();
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Resources f;
    public FloatBuffer g;
    public FloatBuffer h;
    public int i = 0;
    public float[] j = Arrays.copyOf(p, 16);
    public int k = 0;
    public int l = 0;
    public float[] m = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
    public float[] n = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    public mh3(Resources resources) {
        this.f = resources;
        k();
    }

    public static void j(int i, Object obj) {
        if (!o || i == 0) {
            return;
        }
        String str = "glError:" + i + "---" + obj;
    }

    public static int w(String str, String str2) {
        int iX;
        int iX2 = x(35633, str);
        if (iX2 == 0 || (iX = x(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, iX2);
            GLES20.glAttachShader(iGlCreateProgram, iX);
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                j(1, "Could not link program:" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
                GLES20.glDeleteProgram(iGlCreateProgram);
                return 0;
            }
        }
        return iGlCreateProgram;
    }

    public static int x(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        j(1, "Could not compile shader:" + i);
        j(1, "GLES20 Error:" + GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static String y(Resources resources, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStreamOpen = resources.getAssets().open(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (-1 == i) {
                    return sb.toString().replaceAll("\\r\\n", IOUtils.LINE_SEPARATOR_UNIX);
                }
                sb.append(new String(bArr, 0, i));
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a() {
        n();
    }

    public final void b(String str, String str2) {
        int iW = w(str, str2);
        this.a = iW;
        this.b = GLES20.glGetAttribLocation(iW, "vPosition");
        this.c = GLES20.glGetAttribLocation(this.a, "vCoord");
        this.d = GLES20.glGetUniformLocation(this.a, "vMatrix");
        this.e = GLES20.glGetUniformLocation(this.a, "vTexture");
    }

    public final void c(String str, String str2) {
        b(y(this.f, str), y(this.f, str2));
    }

    public void d() {
        m();
        r();
        p();
        l();
        o();
    }

    public int e() {
        return this.i;
    }

    public float[] f() {
        return this.j;
    }

    public int g() {
        return -1;
    }

    public final int h() {
        return this.l;
    }

    public final int i() {
        return this.k;
    }

    public void k() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.g = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(this.m);
        this.g.position(0);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        this.h = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(this.n);
        this.h.position(0);
    }

    public void l() {
        GLES20.glActiveTexture(this.k + 33984);
        GLES20.glBindTexture(3553, h());
        GLES20.glUniform1i(this.e, this.k);
    }

    public void m() {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
    }

    public abstract void n();

    public void o() {
        GLES20.glEnableVertexAttribArray(this.b);
        GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 0, (Buffer) this.g);
        GLES20.glEnableVertexAttribArray(this.c);
        GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 0, (Buffer) this.h);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.b);
        GLES20.glDisableVertexAttribArray(this.c);
    }

    public void p() {
        GLES20.glUniformMatrix4fv(this.d, 1, false, this.j, 0);
    }

    public abstract void q(int i, int i2);

    public void r() {
        GLES20.glUseProgram(this.a);
    }

    public void s(int i) {
        this.i = i;
    }

    public final void t(float[] fArr) {
        this.j = fArr;
    }

    public final void u(int i, int i2) {
        q(i, i2);
    }

    public final void v(int i) {
        this.l = i;
    }
}

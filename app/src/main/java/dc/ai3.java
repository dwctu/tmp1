package dc;

import android.opengl.GLES20;
import com.lovense.wear.R;
import com.wear.util.MyApplication;

/* compiled from: MagicFreudFilter.java */
/* loaded from: classes4.dex */
public class ai3 extends uh3 {
    public int k;
    public int l;
    public int[] m;
    public int[] n;
    public int o;

    /* compiled from: MagicFreudFilter.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ai3.this.m[0] = ii3.d(MyApplication.N(), "filter/freud_rand.png");
        }
    }

    /* compiled from: MagicFreudFilter.java */
    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glUniform1f(ai3.this.l, this.a);
            GLES20.glUniform1f(ai3.this.k, this.b);
        }
    }

    public ai3() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", ii3.e(R.raw.freud));
        this.m = new int[]{-1};
        this.n = new int[]{-1};
    }

    @Override // dc.uh3
    public void e() {
        super.e();
        int i = 0;
        GLES20.glDeleteTextures(1, this.m, 0);
        while (true) {
            int[] iArr = this.m;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = -1;
            i++;
        }
    }

    @Override // dc.uh3
    public void g() {
        int i = 0;
        while (true) {
            int[] iArr = this.m;
            if (i >= iArr.length || iArr[i] == -1) {
                return;
            }
            GLES20.glActiveTexture(i + 3 + 33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
            i++;
        }
    }

    @Override // dc.uh3
    public void h() {
        int i = 0;
        while (true) {
            int[] iArr = this.m;
            if (i >= iArr.length || iArr[i] == -1) {
                return;
            }
            int i2 = i + 3;
            GLES20.glActiveTexture(33984 + i2);
            GLES20.glBindTexture(3553, this.m[i]);
            GLES20.glUniform1i(this.n[i], i2);
            i++;
        }
    }

    @Override // dc.uh3
    public void j() {
        super.j();
        this.n[0] = GLES20.glGetUniformLocation(b(), "inputImageTexture2");
        this.l = GLES20.glGetUniformLocation(b(), "inputImageTextureWidth");
        this.k = GLES20.glGetUniformLocation(b(), "inputImageTextureHeight");
        this.o = GLES20.glGetUniformLocation(this.d, "strength");
    }

    @Override // dc.uh3
    public void k() {
        super.k();
        o(this.o, 1.0f);
        m(new a());
    }

    @Override // dc.uh3
    public void l(int i, int i2) {
        super.l(i, i2);
        m(new b(i, i2));
    }
}

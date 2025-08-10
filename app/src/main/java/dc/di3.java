package dc;

import android.opengl.GLES20;
import com.lovense.wear.R;
import com.wear.util.MyApplication;

/* compiled from: MagicInkwellFilter.java */
/* loaded from: classes4.dex */
public class di3 extends uh3 {
    public int[] k;
    public int[] l;
    public int m;

    /* compiled from: MagicInkwellFilter.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            di3.this.k[0] = ii3.d(MyApplication.N(), "filter/inkwellmap.png");
        }
    }

    public di3() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", ii3.e(R.raw.inkwell));
        this.k = new int[]{-1};
        this.l = new int[]{-1};
    }

    @Override // dc.uh3
    public void e() {
        super.e();
        int i = 0;
        GLES20.glDeleteTextures(1, this.k, 0);
        while (true) {
            int[] iArr = this.k;
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
            int[] iArr = this.k;
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
            int[] iArr = this.k;
            if (i >= iArr.length || iArr[i] == -1) {
                return;
            }
            int i2 = i + 3;
            GLES20.glActiveTexture(33984 + i2);
            GLES20.glBindTexture(3553, this.k[i]);
            GLES20.glUniform1i(this.l[i], i2);
            i++;
        }
    }

    @Override // dc.uh3
    public void j() {
        super.j();
        int i = 0;
        while (true) {
            int[] iArr = this.l;
            if (i >= iArr.length) {
                this.m = GLES20.glGetUniformLocation(this.d, "strength");
                return;
            }
            iArr[i] = GLES20.glGetUniformLocation(b(), "inputImageTexture" + (i + 2));
            i++;
        }
    }

    @Override // dc.uh3
    public void k() {
        super.k();
        o(this.m, 1.0f);
        m(new a());
    }
}

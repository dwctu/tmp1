package dc;

import android.opengl.GLES20;
import com.lovense.wear.R;
import com.wear.util.MyApplication;

/* compiled from: MagicHudsonFilter.java */
/* loaded from: classes4.dex */
public class ci3 extends uh3 {
    public int[] k;
    public int[] l;
    public int m;

    /* compiled from: MagicHudsonFilter.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ci3.this.k[0] = ii3.d(MyApplication.N(), "filter/hudsonbackground.png");
            ci3.this.k[1] = ii3.d(MyApplication.N(), "filter/overlaymap.png");
            ci3.this.k[2] = ii3.d(MyApplication.N(), "filter/hudsonmap.png");
        }
    }

    public ci3() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", ii3.e(R.raw.hudson));
        this.k = new int[]{-1, -1, -1};
        this.l = new int[]{-1, -1, -1};
    }

    @Override // dc.uh3
    public void e() {
        super.e();
        int[] iArr = this.k;
        int i = 0;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
        while (true) {
            int[] iArr2 = this.k;
            if (i >= iArr2.length) {
                return;
            }
            iArr2[i] = -1;
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

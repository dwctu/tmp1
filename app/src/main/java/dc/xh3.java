package dc;

import android.opengl.GLES20;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.lovense.wear.R;

/* compiled from: MagicBeautyFilter.java */
/* loaded from: classes4.dex */
public class xh3 extends uh3 {
    public int k;
    public int l;
    public int m;

    public xh3() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", ii3.e(R.raw.beauty));
    }

    @Override // dc.uh3
    public void j() {
        super.j();
        this.k = GLES20.glGetUniformLocation(b(), "singleStepOffset");
        this.l = GLES20.glGetUniformLocation(b(), CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        r(3);
    }

    @Override // dc.uh3
    public void l(int i, int i2) {
        super.l(i, i2);
        s(i, i2);
    }

    public int q() {
        return this.m;
    }

    public void r(int i) {
        this.m = i;
        switch (i) {
            case 0:
                o(this.l, 0.0f);
                break;
            case 1:
                o(this.l, 1.0f);
                break;
            case 2:
                o(this.l, 0.8f);
                break;
            case 3:
                o(this.l, 0.6f);
                break;
            case 4:
                o(this.l, 0.4f);
                break;
            case 5:
                o(this.l, 0.33f);
                break;
            case 6:
                o(this.l, 0.25f);
                break;
            case 7:
                o(this.l, 0.15f);
                break;
            case 8:
                o(this.l, 0.1f);
                break;
            case 9:
                o(this.l, 0.05f);
                break;
        }
    }

    public final void s(float f, float f2) {
        p(this.k, new float[]{2.0f / f, 2.0f / f2});
    }
}

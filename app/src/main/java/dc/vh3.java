package dc;

import android.opengl.GLES20;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.lovense.wear.R;
import java.nio.Buffer;

/* compiled from: MagicCameraInputFilter.java */
/* loaded from: classes4.dex */
public class vh3 extends uh3 {
    public float[] k;
    public int l;
    public int m;
    public int n;
    public int[] o;
    public int[] p;

    public vh3() {
        super(ii3.e(R.raw.default_vertex), ii3.e(R.raw.default_fragment));
        this.o = null;
        this.p = null;
    }

    @Override // dc.uh3
    public void e() {
        super.e();
        q();
    }

    @Override // dc.uh3
    public int i(int i) {
        GLES20.glUseProgram(this.d);
        n();
        if (!d()) {
            return -1;
        }
        this.i.position(0);
        GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, (Buffer) this.i);
        GLES20.glEnableVertexAttribArray(this.e);
        this.j.position(0);
        GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 0, (Buffer) this.j);
        GLES20.glEnableVertexAttribArray(this.g);
        GLES20.glUniformMatrix4fv(this.l, 1, false, this.k, 0);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(this.f, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.e);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glBindTexture(36197, 0);
        return 1;
    }

    @Override // dc.uh3
    public void j() {
        super.j();
        this.l = GLES20.glGetUniformLocation(this.d, "textureTransform");
        this.m = GLES20.glGetUniformLocation(b(), "singleStepOffset");
        this.n = GLES20.glGetUniformLocation(b(), CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        r(3);
    }

    @Override // dc.uh3
    public void l(int i, int i2) {
        super.l(i, i2);
        s(i, i2);
    }

    public void q() {
        int[] iArr = this.p;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.p = null;
        }
        int[] iArr2 = this.o;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.o = null;
        }
    }

    public void r(int i) {
        if (i == 0) {
            o(this.n, 0.0f);
            return;
        }
        if (i == 1) {
            o(this.n, 1.0f);
            return;
        }
        if (i == 2) {
            o(this.n, 0.8f);
            return;
        }
        if (i == 3) {
            o(this.n, 0.6f);
        } else if (i == 4) {
            o(this.n, 0.4f);
        } else {
            if (i != 5) {
                return;
            }
            o(this.n, 0.33f);
        }
    }

    public final void s(float f, float f2) {
        p(this.m, new float[]{2.0f / f, 2.0f / f2});
    }
}

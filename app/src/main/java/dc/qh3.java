package dc;

import android.content.res.Resources;
import android.opengl.GLES20;

/* compiled from: OesFilter.java */
/* loaded from: classes4.dex */
public class qh3 extends mh3 {
    public qh3(Resources resources) {
        super(resources);
    }

    @Override // dc.mh3
    public void l() {
        GLES20.glActiveTexture(i() + 33984);
        GLES20.glBindTexture(36197, h());
        GLES20.glUniform1i(this.e, i());
    }

    @Override // dc.mh3
    public void n() {
        c("shader/oes_base_vertex.sh", "shader/oes_base_fragment.sh");
    }

    @Override // dc.mh3
    public void q(int i, int i2) {
    }
}

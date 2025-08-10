package dc;

import android.content.res.Resources;
import android.opengl.GLES20;

/* compiled from: NoFilter.java */
/* loaded from: classes4.dex */
public class ph3 extends mh3 {
    public ph3(Resources resources) {
        super(resources);
    }

    @Override // dc.mh3
    public void m() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
    }

    @Override // dc.mh3
    public void n() {
        c("shader/base_vertex.sh", "shader/base_fragment.sh");
    }

    @Override // dc.mh3
    public void q(int i, int i2) {
    }
}

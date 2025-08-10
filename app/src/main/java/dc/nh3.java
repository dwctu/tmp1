package dc;

import android.content.res.Resources;

/* compiled from: CameraFilter.java */
/* loaded from: classes4.dex */
public class nh3 extends qh3 {
    public nh3(Resources resources) {
        super(resources);
    }

    @Override // dc.mh3
    public void s(int i) {
        super.s(i);
        float[] fArr = e() == 1 ? new float[]{1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f} : new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        this.h.clear();
        this.h.put(fArr);
        this.h.position(0);
    }
}

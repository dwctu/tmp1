package dc;

import android.graphics.PointF;
import java.io.Serializable;

/* compiled from: ImageViewState.java */
/* loaded from: classes.dex */
public class jg0 implements Serializable {
    private float centerX;
    private float centerY;
    private int orientation;
    private float scale;

    public jg0(float f, PointF pointF, int i) {
        this.scale = f;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i;
    }

    public PointF a() {
        return new PointF(this.centerX, this.centerY);
    }

    public int b() {
        return this.orientation;
    }

    public float c() {
        return this.scale;
    }
}

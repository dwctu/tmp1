package dc;

import android.graphics.Paint;
import android.graphics.Path;
import java.util.LinkedList;

/* compiled from: CurveLineBean.java */
/* loaded from: classes4.dex */
public class xo3 {
    public LinkedList<Float> a = new LinkedList<>();
    public LinkedList<Float> b = new LinkedList<>();
    public Paint c = new Paint();
    public Paint d = new Paint();
    public Path e = new Path();

    public xo3(int i, int i2, int i3) {
        this.a.clear();
        this.b.clear();
        this.c.setColor(i2);
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.STROKE);
        float f = i;
        this.c.setStrokeWidth(f);
        this.d.setColor(i3);
        this.d.setAntiAlias(true);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(f);
    }
}

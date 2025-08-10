package dc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* compiled from: NullLayer.java */
/* loaded from: classes.dex */
public class za extends va {
    public za(h7 h7Var, ya yaVar) {
        super(h7Var, yaVar);
    }

    @Override // dc.va, dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // dc.va
    public void t(Canvas canvas, Matrix matrix, int i) {
    }
}

package dc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class ab extends va {
    public final z7 z;

    public ab(h7 h7Var, ya yaVar) {
        super(h7Var, yaVar);
        z7 z7Var = new z7(h7Var, this, new ra("__container", yaVar.l(), false));
        this.z = z7Var;
        z7Var.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // dc.va
    public void D(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        this.z.d(l9Var, i, list, l9Var2);
    }

    @Override // dc.va, dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        this.z.e(rectF, this.m, z);
    }

    @Override // dc.va
    public void t(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.z.g(canvas, matrix, i);
    }
}

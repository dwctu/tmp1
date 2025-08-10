package dc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class xa extends va {
    public final Rect A;
    public final Rect B;

    @Nullable
    public p8<ColorFilter, ColorFilter> C;
    public final Paint z;

    public xa(h7 h7Var, ya yaVar) {
        super(h7Var, yaVar);
        this.z = new v7(3);
        this.A = new Rect();
        this.B = new Rect();
    }

    @Nullable
    public final Bitmap K() {
        return this.n.u(this.o.k());
    }

    @Override // dc.va, dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        super.c(t, kdVar);
        if (t == m7.E) {
            if (kdVar == null) {
                this.C = null;
            } else {
                this.C = new e9(kdVar);
            }
        }
    }

    @Override // dc.va, dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        if (K() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * hd.e(), r3.getHeight() * hd.e());
            this.m.mapRect(rectF);
        }
    }

    @Override // dc.va
    public void t(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapK = K();
        if (bitmapK == null || bitmapK.isRecycled()) {
            return;
        }
        float fE = hd.e();
        this.z.setAlpha(i);
        p8<ColorFilter, ColorFilter> p8Var = this.C;
        if (p8Var != null) {
            this.z.setColorFilter(p8Var.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.A.set(0, 0, bitmapK.getWidth(), bitmapK.getHeight());
        this.B.set(0, 0, (int) (bitmapK.getWidth() * fE), (int) (bitmapK.getHeight() * fE));
        canvas.drawBitmap(bitmapK, this.A, this.B, this.z);
        canvas.restore();
    }
}

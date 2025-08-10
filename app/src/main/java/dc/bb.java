package dc;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;

/* compiled from: SolidLayer.java */
/* loaded from: classes.dex */
public class bb extends va {
    public final Paint A;
    public final float[] B;
    public final Path C;
    public final ya D;

    @Nullable
    public p8<ColorFilter, ColorFilter> E;
    public final RectF z;

    public bb(h7 h7Var, ya yaVar) {
        super(h7Var, yaVar);
        this.z = new RectF();
        v7 v7Var = new v7();
        this.A = v7Var;
        this.B = new float[8];
        this.C = new Path();
        this.D = yaVar;
        v7Var.setAlpha(0);
        v7Var.setStyle(Paint.Style.FILL);
        v7Var.setColor(yaVar.m());
    }

    @Override // dc.va, dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        super.c(t, kdVar);
        if (t == m7.E) {
            if (kdVar == null) {
                this.E = null;
            } else {
                this.E = new e9(kdVar);
            }
        }
    }

    @Override // dc.va, dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        this.z.set(0.0f, 0.0f, this.D.o(), this.D.n());
        this.m.mapRect(this.z);
        rectF.set(this.z);
    }

    @Override // dc.va
    public void t(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.D.m());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
        this.A.setAlpha(iIntValue);
        p8<ColorFilter, ColorFilter> p8Var = this.E;
        if (p8Var != null) {
            this.A.setColorFilter(p8Var.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.B;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.D.o();
            float[] fArr2 = this.B;
            fArr2[3] = 0.0f;
            fArr2[4] = this.D.o();
            this.B[5] = this.D.n();
            float[] fArr3 = this.B;
            fArr3[6] = 0.0f;
            fArr3[7] = this.D.n();
            matrix.mapPoints(this.B);
            this.C.reset();
            Path path = this.C;
            float[] fArr4 = this.B;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.C;
            float[] fArr5 = this.B;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.C;
            float[] fArr6 = this.B;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.C;
            float[] fArr7 = this.B;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.C;
            float[] fArr8 = this.B;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.C.close();
            canvas.drawPath(this.C, this.A);
        }
    }
}

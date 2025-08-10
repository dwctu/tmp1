package com.wear.main.ninja.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes3.dex */
public class HintTextView extends AppCompatTextView {
    public Paint a;
    public int b;
    public LinearGradient c;
    public Matrix d;
    public int e;

    public HintTextView(Context context) {
        super(context, null);
        this.a = getPaint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = this.d;
        if (matrix != null) {
            int i = this.e;
            int i2 = this.b;
            int i3 = i + (i2 / 8);
            this.e = i3;
            if (i3 > i2 * 2) {
                this.e = -i2;
            }
        }
        matrix.setTranslate(this.e, 0.0f);
        this.c.setLocalMatrix(this.d);
        postInvalidateDelayed(100L);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.b == 0) {
            this.b = getMeasuredWidth();
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.b, 0.0f, new int[]{-7829368, -1, -7829368}, new float[]{0.3f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
            this.c = linearGradient;
            this.a.setShader(linearGradient);
            this.d = new Matrix();
        }
    }

    public HintTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getPaint();
    }
}

package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class FadingRecyclerView extends RecyclerView {
    public Paint a;
    public int b;
    public int c;
    public int d;

    public FadingRecyclerView(Context context) {
        super(context);
        this.d = 30;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, this.c, this.b, null, 31);
        super.draw(canvas);
        canvas.drawRect(0.0f, 0.0f, this.c, this.b, this.a);
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b = i2;
        this.c = i;
        this.a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.b / 2, new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK}, new float[]{0.0f, this.d / (i2 / 4.0f), 1.0f}, Shader.TileMode.MIRROR));
    }

    public void setSpanPixel(int i) {
        this.d = i;
    }

    public FadingRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 30;
        a(context, attributeSet);
    }

    public FadingRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 30;
        a(context, attributeSet);
    }
}

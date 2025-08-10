package com.wear.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes4.dex */
public class TextOverlayImageView extends AppCompatImageView {
    public String a;
    public int b;
    public int c;

    public TextOverlayImageView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.a = "";
        this.b = 24;
        this.c = -1;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.c);
        paint.setTextSize(this.b);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextAlign(Paint.Align.CENTER);
        int width = getWidth();
        int height = getHeight();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.descent;
        float f2 = (width / 2) - 2;
        float f3 = (height / 2) + (((f - fontMetrics.ascent) / 2.0f) - f);
        String str = "textX====" + f2 + "===textY" + f3;
        canvas.drawText(this.a, f2, f3, paint);
    }

    public void setText(String str) {
        this.a = str;
        invalidate();
    }

    public void setTextColor(int i) {
        this.c = i;
        invalidate();
    }

    public void setTextSize(int i) {
        this.b = i;
        invalidate();
    }

    public TextOverlayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TextOverlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}

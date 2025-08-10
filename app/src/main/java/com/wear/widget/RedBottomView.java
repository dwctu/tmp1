package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class RedBottomView extends View {
    public Paint a;
    public Paint b;
    public int c;

    public RedBottomView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.setColor(getResources().getColor(R.color.white));
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setColor(getResources().getColor(R.color.select_text_color));
        this.a.setAntiAlias(true);
        this.a.setDither(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int iMin = Math.min(measuredWidth, measuredHeight);
        int iMax = Math.max(iMin, measuredHeight);
        int i = iMin / 30;
        this.c = i;
        this.b.setStrokeWidth(i);
        int i2 = iMin / 2;
        float f = i2;
        int i3 = iMax / 2;
        canvas.drawCircle(f, i3, f, this.a);
        int i4 = this.c;
        int i5 = iMin / 4;
        Rect rect = new Rect(i2 - (i4 / 2), i3 - i5, i2 + (i4 / 2), i3 + i5);
        int i6 = this.c;
        Rect rect2 = new Rect(i5, i3 - (i6 / 2), i5 * 3, i3 + (i6 / 2));
        canvas.drawRect(rect, this.b);
        canvas.drawRect(rect2, this.b);
    }

    public RedBottomView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedBottomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = new Paint();
        a();
    }
}

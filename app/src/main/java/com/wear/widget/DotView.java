package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class DotView extends AppCompatTextView {
    public int a;
    public boolean b;
    public int c;
    public int d;

    public DotView(Context context) {
        super(context);
        this.a = -1;
        this.b = false;
        this.c = R.color.dot_point_normal_background;
        this.d = R.color.dot_point_choose_background;
    }

    public int getIndex() {
        return this.a;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        if (this.b) {
            paint.setColor(getContext().getResources().getColor(this.d));
        } else {
            paint.setColor(getContext().getResources().getColor(this.c));
        }
        paint.setAntiAlias(true);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, paint);
    }

    public void setIndex(int i) {
        this.a = i;
    }

    public DotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = false;
        this.c = R.color.dot_point_normal_background;
        this.d = R.color.dot_point_choose_background;
    }
}

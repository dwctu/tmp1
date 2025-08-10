package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class CircleView extends RelativeLayout {
    public CircleView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(getContext().getResources().getColor(R.color.window_background_light));
        paint.setAntiAlias(true);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, paint);
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

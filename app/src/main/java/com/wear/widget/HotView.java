package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;

/* loaded from: classes4.dex */
public class HotView extends TextView {
    public int a;
    public int b;
    public boolean c;

    public HotView(Context context) {
        super(context);
        this.a = R.color.color_accent;
        this.b = R.color.transparent;
        this.c = false;
        a();
    }

    public final void a() {
        getId();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (WearUtils.e1(getText().toString())) {
            Paint paint = new Paint();
            if (this.c) {
                paint.setColor(getContext().getResources().getColor(this.b));
            } else {
                paint.setColor(getContext().getResources().getColor(this.a));
            }
            paint.setAntiAlias(true);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, paint);
        }
    }

    public HotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = R.color.color_accent;
        this.b = R.color.transparent;
        this.c = false;
        a();
    }

    public HotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = R.color.color_accent;
        this.b = R.color.transparent;
        this.c = false;
        a();
    }
}

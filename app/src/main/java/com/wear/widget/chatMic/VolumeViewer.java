package com.wear.widget.chatMic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes4.dex */
public class VolumeViewer extends View {
    public Paint a;
    public int b;
    public boolean c;

    public VolumeViewer(Context context) {
        super(context);
        this.b = 0;
        this.c = true;
        a(context);
    }

    public final void a(Context context) {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-1);
        this.b = 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        String str = "height:" + height;
        for (int i = 1; i <= this.b; i++) {
            canvas.drawRect(0.0f, height - (i * 20), (i * 5) + 10, r2 + 12, this.a);
        }
        if (this.c) {
            postInvalidateDelayed(10L);
        }
    }

    public void setVolumeValue(int i) {
        String str = "volume is " + i;
        this.b = i;
        if (this.c) {
            return;
        }
        this.c = true;
    }

    public VolumeViewer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = true;
        a(context);
    }
}

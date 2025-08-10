package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes4.dex */
public class GlassText extends AppCompatTextView {
    public a a;
    public boolean b;

    public interface a {
        void a(int i, int i2);
    }

    public GlassText(Context context) {
        super(context);
        this.b = false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.a;
        if (aVar == null || !this.b) {
            return;
        }
        this.b = false;
        aVar.a(getWidth(), getHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setOnDrawFinish(a aVar) {
        this.a = aVar;
    }

    public void setOneUpdateToDraw(boolean z) {
        this.b = z;
    }

    public GlassText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    public GlassText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
    }
}

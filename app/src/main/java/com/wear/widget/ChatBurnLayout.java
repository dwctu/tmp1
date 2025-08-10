package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import dc.ce3;
import dc.vi1;

/* loaded from: classes4.dex */
public class ChatBurnLayout extends View {
    public Paint a;
    public Rect b;
    public Drawable c;

    public ChatBurnLayout(@NonNull Context context) {
        super(context);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(getResources().getColor(R.color.mosaic_bg));
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float fA = ce3.a(getContext(), 4.0f);
        canvas.drawRoundRect(rectF, fA, fA, this.a);
        this.c.setBounds(this.b);
        this.c.draw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.decodeResource(getResources(), R.drawable.chatting_fire, options);
        int i5 = options.outHeight;
        int i6 = options.outWidth;
        this.b = new Rect((getWidth() - i6) / 2, (getHeight() - i5) / 2, (getWidth() + i6) / 2, (getHeight() + i5) / 2);
    }

    public ChatBurnLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.ChatBurnLayout);
        typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.c = ContextCompat.getDrawable(context, typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.chatting_fire));
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    public ChatBurnLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}

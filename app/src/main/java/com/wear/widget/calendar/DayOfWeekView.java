package com.wear.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.lovense.wear.R;
import dc.ce3;
import dc.th4;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes4.dex */
public class DayOfWeekView extends View {
    public float a;
    public int b;
    public String[] c;
    public int d;
    public TextPaint e;

    public DayOfWeekView(Context context) {
        super(context);
        this.a = 0.0f;
        this.b = ce3.a(getContext(), 20.0f);
        this.c = new String[7];
        this.d = 0;
        b();
    }

    public final void a(Canvas canvas) {
        TextPaint textPaint = this.e;
        int i = this.b;
        float f = this.a;
        float fAscent = (textPaint.ascent() + textPaint.descent()) / 2.0f;
        float paddingTop = (i / 2) + getPaddingTop();
        for (int i2 = 0; i2 < 7; i2++) {
            float paddingLeft = (i2 * f) + (f / 2.0f) + getPaddingLeft();
            String str = this.c[i2];
            if (str != null) {
                canvas.drawText(str, paddingLeft, paddingTop - fAscent, textPaint);
            }
        }
    }

    public final void b() {
        setBackgroundColor(th4.b(getContext(), R.color.search_chat_date_bg));
        TextPaint textPaint = new TextPaint();
        this.e = textPaint;
        textPaint.setAntiAlias(true);
        this.e.setTextSize(ce3.a(getContext(), 14.0f));
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setColor(th4.b(getContext(), R.color.search_chat_date_text_color));
        this.e.setStyle(Paint.Style.FILL);
    }

    public final void c() {
        String[] strArr = {ExifInterface.LATITUDE_SOUTH, "M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_WEST, ExifInterface.GPS_DIRECTION_TRUE, "F", ExifInterface.LATITUDE_SOUTH};
        for (int i = 0; i < 7; i++) {
            this.c[i] = strArr[((this.d + i) - 1) % 7];
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.a = new BigDecimal((View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight()).divide(new BigDecimal(7), 2, RoundingMode.HALF_UP).floatValue();
        setMeasuredDimension(i, View.resolveSize(this.b + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void setParams() {
        this.d = 1;
        c();
        requestLayout();
    }

    public DayOfWeekView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        this.b = ce3.a(getContext(), 20.0f);
        this.c = new String[7];
        this.d = 0;
        b();
    }

    public DayOfWeekView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        this.b = ce3.a(getContext(), 20.0f);
        this.c = new String[7];
        this.d = 0;
        b();
    }
}

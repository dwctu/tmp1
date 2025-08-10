package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.lovense.wear.R;
import dc.ah4;

/* loaded from: classes4.dex */
public class AutoScannerView extends View {
    public Paint a;
    public Paint b;
    public Paint c;
    public Paint d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public Rect q;

    public AutoScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int color = Color.parseColor("#60000000");
        this.e = color;
        int color2 = Color.parseColor("#FFFF2D89");
        this.f = color2;
        int color3 = Color.parseColor("#FFFF2D89");
        this.g = color3;
        int color4 = Color.parseColor("#CCCCCC");
        this.h = color4;
        this.i = a(20);
        int iA = a(4);
        this.j = iA;
        this.k = a(30);
        this.l = 0;
        int iA2 = a(100);
        this.m = iA2;
        this.n = iA2;
        a(10);
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(color);
        Paint paint2 = new Paint(1);
        this.c = paint2;
        paint2.setColor(color2);
        this.c.setStrokeWidth(iA);
        this.c.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        this.b = paint3;
        paint3.setColor(color3);
        Paint paint4 = new Paint(1);
        this.d = paint4;
        paint4.setColor(color4);
        this.d.setTextSize(a(14));
    }

    public final int a(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.q == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, this.q.top, this.a);
        Rect rect = this.q;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.a);
        Rect rect2 = this.q;
        canvas.drawRect(rect2.right + 1, rect2.top, f, rect2.bottom + 1, this.a);
        canvas.drawRect(0.0f, this.q.bottom + 1, f, height, this.a);
        String strE = ah4.e(R.string.qrcode_scan_at_right_position);
        canvas.drawText(strE, (f - this.d.measureText(strE)) / 2.0f, this.q.bottom + this.k, this.d);
        Path path = new Path();
        Rect rect3 = this.q;
        path.moveTo(rect3.left + this.i, rect3.top + (this.j / 2));
        int i = this.q.left;
        int i2 = this.j;
        path.lineTo(i + (i2 / 2), r1.top + (i2 / 2));
        Rect rect4 = this.q;
        path.lineTo(rect4.left + (this.j / 2), rect4.top + this.i);
        canvas.drawPath(path, this.c);
        Path path2 = new Path();
        Rect rect5 = this.q;
        path2.moveTo(rect5.right - this.i, rect5.top + (this.j / 2));
        int i3 = this.q.right;
        int i4 = this.j;
        path2.lineTo(i3 - (i4 / 2), r1.top + (i4 / 2));
        Rect rect6 = this.q;
        path2.lineTo(rect6.right - (this.j / 2), rect6.top + this.i);
        canvas.drawPath(path2, this.c);
        Path path3 = new Path();
        Rect rect7 = this.q;
        path3.moveTo(rect7.left + (this.j / 2), rect7.bottom - this.i);
        int i5 = this.q.left;
        int i6 = this.j;
        path3.lineTo(i5 + (i6 / 2), r1.bottom - (i6 / 2));
        Rect rect8 = this.q;
        path3.lineTo(rect8.left + this.i, rect8.bottom - (this.j / 2));
        canvas.drawPath(path3, this.c);
        Path path4 = new Path();
        Rect rect9 = this.q;
        path4.moveTo(rect9.right - this.i, rect9.bottom - (this.j / 2));
        int i7 = this.q.right;
        int i8 = this.j;
        path4.lineTo(i7 - (i8 / 2), r1.bottom - (i8 / 2));
        Rect rect10 = this.q;
        path4.lineTo(rect10.right - (this.j / 2), rect10.bottom - this.i);
        canvas.drawPath(path4, this.c);
        int i9 = this.l;
        Rect rect11 = this.q;
        if (i9 > (rect11.bottom - rect11.top) - a(10)) {
            this.l = 0;
        } else {
            this.l += 6;
            Rect rect12 = new Rect();
            Rect rect13 = this.q;
            rect12.left = rect13.left;
            rect12.top = rect13.top + this.l;
            rect12.right = rect13.right;
            rect12.bottom = rect13.top + a(5) + this.l;
            canvas.drawBitmap(((BitmapDrawable) getResources().getDrawable(R.drawable.scan_line)).getBitmap(), (Rect) null, rect12, this.b);
        }
        Rect rect14 = this.q;
        postInvalidateDelayed(10L, rect14.left, rect14.top, rect14.right, rect14.bottom);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            this.p = size;
        } else {
            int i3 = this.m;
            this.p = i3;
            if (mode == Integer.MIN_VALUE) {
                this.p = Math.min(i3, size);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            this.o = size2;
        } else {
            int i4 = this.n;
            this.o = i4;
            if (mode2 == Integer.MIN_VALUE) {
                this.o = Math.min(i4, size2);
            }
        }
        this.o = (this.o - getPaddingBottom()) - getPaddingTop();
        int paddingLeft = (this.p - getPaddingLeft()) - getPaddingBottom();
        this.p = paddingLeft;
        setMeasuredDimension(paddingLeft, this.o);
        int i5 = this.p;
        int i6 = i5 / 6;
        int i7 = (i5 / 6) * 4;
        int i8 = this.o;
        int i9 = i8 / 4;
        int i10 = (i8 / 4) + i7;
        if (i8 < i5) {
            i9 = i8 / 8;
            i10 = (i8 / 8) * 6;
            i7 = i10 - i9;
            i6 = (i5 - i7) / 2;
        }
        this.q = new Rect(i6, i9, i7 + i6, i10);
    }
}

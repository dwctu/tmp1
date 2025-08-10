package com.wear.widget.control;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.ek2;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class CurveLineView extends View {
    public int a;
    public LinkedList<Float> b;
    public Paint c;
    public Path d;
    public int e;
    public LinkedList<Float> f;
    public Paint g;
    public Path h;
    public int i;
    public LinkedList<Float> j;
    public Paint k;
    public Path l;
    public int m;
    public float n;
    public float o;
    public int p;
    public int q;
    public Bitmap r;
    public int s;
    public int t;

    public CurveLineView(Context context) throws Resources.NotFoundException {
        super(context);
        this.a = Color.parseColor("#46D9FC");
        this.b = new LinkedList<>();
        this.c = new Paint(1);
        this.d = new Path();
        this.e = Color.parseColor("#F1B40D");
        this.f = new LinkedList<>();
        this.g = new Paint();
        this.h = new Path();
        this.i = Color.parseColor("#00ff00");
        this.j = new LinkedList<>();
        this.k = new Paint();
        this.l = new Path();
        this.m = 20;
        this.p = 0;
        this.q = 0;
        this.s = 1;
        this.t = ek2.SPEED.ordinal();
        b(context);
    }

    private void setLineColor(int i) throws Resources.NotFoundException {
        this.p = ce3.a(getContext(), 2.0f);
        if (i == ek2.POSITION.ordinal()) {
            this.a = getResources().getColor(R.color.color_accent_second);
        } else {
            this.a = getResources().getColor(R.color.buttom_select_background);
        }
        this.c.setColor(this.a);
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.p);
        int color = getResources().getColor(R.color.color_accent_second);
        this.e = color;
        this.g.setColor(color);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setAntiAlias(true);
        this.g.setStrokeWidth(this.p);
        int color2 = getResources().getColor(R.color.color_accent_second);
        this.i = color2;
        this.k.setColor(color2);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setAntiAlias(true);
        this.k.setStrokeWidth(this.p);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.content_bottom_patternplay_selected, options);
        this.r = bitmapDecodeResource;
        int iMax = Math.max(this.p, bitmapDecodeResource.getHeight());
        this.p = iMax;
        this.q = iMax / 2;
    }

    public void a() {
        this.b.clear();
        this.f.clear();
        this.j.clear();
        invalidate();
    }

    public final void b(Context context) throws Resources.NotFoundException {
        setLineColor(this.t);
    }

    public final void c(Path path, Canvas canvas, Paint paint, float f, float f2) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
        paint.setStyle(Paint.Style.FILL);
        int i = this.p;
        canvas.drawCircle(f - (i / 2), f2, i / 2, paint);
    }

    public final void d(Path path, float f, float f2, float f3, float f4) {
        if (this.t == ek2.SPEED.ordinal()) {
            float f5 = (f + f3) / 2.0f;
            path.cubicTo(f5, f2, f5, f4, f3, f4);
        } else {
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.d.reset();
        this.h.reset();
        this.l.reset();
        this.n = getMeasuredWidth() / ((this.m - 1) * 1.0f);
        this.o = (getMeasuredHeight() - this.p) / 100.0f;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < this.b.size(); i++) {
            if (i > 0) {
                int i2 = i - 1;
                float f3 = i2 * this.n;
                float fFloatValue = this.b.get(i2).floatValue() * this.o;
                f = this.n * i;
                float fFloatValue2 = this.b.get(i).floatValue() * this.o;
                int i3 = this.q;
                if (fFloatValue < i3) {
                    fFloatValue = i3;
                }
                float f4 = fFloatValue;
                if (fFloatValue2 < i3) {
                    fFloatValue2 = i3;
                }
                f2 = fFloatValue2;
                d(this.d, f3, f4, f, f2);
            } else {
                float fFloatValue3 = this.b.get(0).floatValue() * this.o;
                int i4 = this.q;
                if (fFloatValue3 < i4) {
                    fFloatValue3 = i4;
                }
                this.d.moveTo(0.0f, fFloatValue3);
                f2 = fFloatValue3;
            }
        }
        if (!this.d.isEmpty()) {
            c(this.d, canvas, this.c, f, f2);
        }
        if (this.s >= 2) {
            this.g.setStyle(Paint.Style.STROKE);
            for (int i5 = 0; i5 < this.f.size(); i5++) {
                if (i5 > 0) {
                    int i6 = i5 - 1;
                    float f5 = i6 * this.n;
                    float fFloatValue4 = this.f.get(i6).floatValue() * this.o;
                    f = this.n * i5;
                    float fFloatValue5 = this.f.get(i5).floatValue() * this.o;
                    int i7 = this.q;
                    if (fFloatValue4 < i7) {
                        fFloatValue4 = i7;
                    }
                    float f6 = fFloatValue4;
                    if (fFloatValue5 < i7) {
                        fFloatValue5 = i7;
                    }
                    f2 = fFloatValue5;
                    d(this.h, f5, f6, f, f2);
                } else {
                    float fFloatValue6 = this.f.get(0).floatValue() * this.o;
                    int i8 = this.q;
                    if (fFloatValue6 < i8) {
                        fFloatValue6 = i8;
                    }
                    this.h.moveTo(0.0f, fFloatValue6);
                    f2 = fFloatValue6;
                }
            }
            if (!this.h.isEmpty()) {
                c(this.h, canvas, this.g, f, f2);
            }
        }
        if (this.s == 3) {
            this.k.setStyle(Paint.Style.STROKE);
            float f7 = f;
            float f8 = f2;
            for (int i9 = 0; i9 < this.j.size(); i9++) {
                if (i9 > 0) {
                    int i10 = i9 - 1;
                    float f9 = i10 * this.n;
                    float fFloatValue7 = this.j.get(i10).floatValue() * this.o;
                    float f10 = this.n * i9;
                    float fFloatValue8 = this.j.get(i9).floatValue() * this.o;
                    int i11 = this.q;
                    if (fFloatValue7 < i11) {
                        fFloatValue7 = i11;
                    }
                    float f11 = fFloatValue7;
                    if (fFloatValue8 < i11) {
                        fFloatValue8 = i11;
                    }
                    f7 = f10;
                    f8 = fFloatValue8;
                    d(this.l, f9, f11, f7, f8);
                } else {
                    float fFloatValue9 = this.j.get(0).floatValue() * this.o;
                    int i12 = this.q;
                    if (fFloatValue9 < i12) {
                        fFloatValue9 = i12;
                    }
                    this.l.moveTo(0.0f, fFloatValue9);
                    f8 = fFloatValue9;
                }
            }
            if (this.l.isEmpty()) {
                return;
            }
            c(this.l, canvas, this.k, f7, f8);
        }
    }

    public void setBothLinePoint(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        float fFloatValue = Float.valueOf(strArrSplit[0]).floatValue();
        if (fFloatValue >= 101.0f) {
            fFloatValue = 100.0f;
        }
        LinkedList<Float> linkedList = this.b;
        if (linkedList == null) {
            return;
        }
        linkedList.add(Float.valueOf(100.0f - fFloatValue));
        if (this.b.size() > this.m) {
            this.b.remove(0);
        }
        if (strArrSplit.length >= 2) {
            float fFloatValue2 = Float.valueOf(strArrSplit[1]).floatValue();
            if (fFloatValue2 >= 101.0f) {
                fFloatValue2 = 100.0f;
            }
            this.f.add(Float.valueOf(100.0f - fFloatValue2));
            if (this.f.size() > this.m) {
                this.f.remove(0);
            }
        }
        if (strArrSplit.length == 3) {
            float fFloatValue3 = Float.valueOf(strArrSplit[2]).floatValue();
            if (fFloatValue3 >= 101.0f) {
                fFloatValue3 = 100.0f;
            }
            LinkedList<Float> linkedList2 = this.j;
            if (linkedList2 == null) {
                return;
            }
            linkedList2.add(Float.valueOf(100.0f - fFloatValue3));
            if (this.j.size() > this.m) {
                this.j.remove(0);
            }
        }
        invalidate();
    }

    public void setOneLineColor(int i) throws Resources.NotFoundException {
        int color = getResources().getColor(i);
        this.a = color;
        this.c.setColor(color);
    }

    public void setPaintModel(int i) throws Resources.NotFoundException {
        this.t = i;
        setLineColor(i);
    }

    public void setSecondLineColor(int i) throws Resources.NotFoundException {
        int color = getResources().getColor(i);
        this.e = color;
        this.g.setColor(color);
    }

    public void setShowBothLine(int i) {
        if (this.s != i) {
            a();
        }
        this.s = i;
    }

    public void setThreeLineColor(int i) throws Resources.NotFoundException {
        int color = getResources().getColor(i);
        this.i = color;
        this.k.setColor(color);
    }

    public void setShowBothLine(boolean z) {
        if (z) {
            setShowBothLine(2);
        } else {
            setShowBothLine(1);
        }
    }

    public CurveLineView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.a = Color.parseColor("#46D9FC");
        this.b = new LinkedList<>();
        this.c = new Paint(1);
        this.d = new Path();
        this.e = Color.parseColor("#F1B40D");
        this.f = new LinkedList<>();
        this.g = new Paint();
        this.h = new Path();
        this.i = Color.parseColor("#00ff00");
        this.j = new LinkedList<>();
        this.k = new Paint();
        this.l = new Path();
        this.m = 20;
        this.p = 0;
        this.q = 0;
        this.s = 1;
        this.t = ek2.SPEED.ordinal();
        b(context);
    }

    public CurveLineView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.a = Color.parseColor("#46D9FC");
        this.b = new LinkedList<>();
        this.c = new Paint(1);
        this.d = new Path();
        this.e = Color.parseColor("#F1B40D");
        this.f = new LinkedList<>();
        this.g = new Paint();
        this.h = new Path();
        this.i = Color.parseColor("#00ff00");
        this.j = new LinkedList<>();
        this.k = new Paint();
        this.l = new Path();
        this.m = 20;
        this.p = 0;
        this.q = 0;
        this.s = 1;
        this.t = ek2.SPEED.ordinal();
        b(context);
    }
}

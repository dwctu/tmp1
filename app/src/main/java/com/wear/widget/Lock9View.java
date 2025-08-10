package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import dc.vi1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class Lock9View extends ViewGroup {
    public List<b> a;
    public float b;
    public float c;
    public Drawable d;
    public Drawable e;
    public float f;
    public float g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public Vibrator n;
    public boolean o;
    public int p;
    public Paint q;
    public StringBuilder r;
    public a s;

    public interface a {
        void a(String str);
    }

    public class b extends View {
        public int a;
        public boolean b;

        public b(Context context, int i) {
            super(context);
            this.b = false;
            this.a = i;
            setBackgroundDrawable(Lock9View.this.d);
        }

        public int a() {
            return (getLeft() + getRight()) / 2;
        }

        public int b() {
            return (getTop() + getBottom()) / 2;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.b;
        }

        public void e(boolean z, boolean z2) {
            if (this.b != z) {
                this.b = z;
                if (Lock9View.this.e != null) {
                    Lock9View lock9View = Lock9View.this;
                    setBackgroundDrawable(z ? lock9View.e : lock9View.d);
                }
                if (Lock9View.this.h != 0) {
                    if (z) {
                        startAnimation(AnimationUtils.loadAnimation(getContext(), Lock9View.this.h));
                    } else {
                        clearAnimation();
                    }
                }
                if (Lock9View.this.o && !z2 && z) {
                    Lock9View.this.n.vibrate(Lock9View.this.p);
                }
            }
        }
    }

    public Lock9View(Context context) {
        super(context);
        this.a = new ArrayList();
        this.r = new StringBuilder();
        i(context, null, 0, 0);
    }

    public final b g(float f, float f2) {
        for (int i = 0; i < getChildCount(); i++) {
            b bVar = (b) getChildAt(i);
            if (bVar != null && f >= bVar.getLeft() - this.g && f < bVar.getRight() + this.g && f2 >= bVar.getTop() - this.g && f2 < bVar.getBottom() + this.g) {
                return bVar;
            }
        }
        return null;
    }

    public final b h(b bVar, b bVar2) {
        if (bVar.c() > bVar2.c()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        if (bVar.c() % 3 == 1 && bVar2.c() - bVar.c() == 2) {
            return (b) getChildAt(bVar.c());
        }
        if (bVar.c() <= 3 && bVar2.c() - bVar.c() == 6) {
            return (b) getChildAt(bVar.c() + 2);
        }
        if ((bVar.c() == 1 && bVar2.c() == 9) || (bVar.c() == 3 && bVar2.c() == 7)) {
            return (b) getChildAt(4);
        }
        return null;
    }

    public final void i(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.Lock9View, i, i2);
        this.d = typedArrayObtainStyledAttributes.getDrawable(8);
        this.e = typedArrayObtainStyledAttributes.getDrawable(6);
        this.f = typedArrayObtainStyledAttributes.getDimension(7, 0.0f);
        this.g = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        this.h = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.i = typedArrayObtainStyledAttributes.getColor(2, Color.argb(0, 0, 0, 0));
        this.j = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        this.k = typedArrayObtainStyledAttributes.getDimension(9, 0.0f);
        this.l = typedArrayObtainStyledAttributes.getDimension(10, 0.0f);
        this.m = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.o = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.p = typedArrayObtainStyledAttributes.getInt(11, 20);
        typedArrayObtainStyledAttributes.recycle();
        if (this.o && !isInEditMode()) {
            this.n = (Vibrator) context.getSystemService("vibrator");
        }
        Paint paint = new Paint(4);
        this.q = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.q.setStrokeWidth(this.j);
        this.q.setColor(this.i);
        this.q.setAntiAlias(true);
        int i3 = 0;
        while (i3 < 9) {
            i3++;
            addView(new b(getContext(), i3));
        }
        setWillNotDraw(false);
    }

    public final int j(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return size;
        }
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i = 1; i < this.a.size(); i++) {
            b bVar = this.a.get(i - 1);
            b bVar2 = this.a.get(i);
            if (bVar != null && bVar2 != null) {
                canvas.drawLine(bVar.a(), bVar.b(), bVar2.a(), bVar2.b(), this.q);
            }
        }
        if (this.a.size() > 0) {
            List<b> list = this.a;
            if (list.get(list.size() - 1) != null) {
                canvas.drawLine(r0.a(), r0.b(), this.b, this.c, this.q);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int i5 = 0;
            if (this.f > 0.0f) {
                float f = (i3 - i) / 3;
                while (i5 < 9) {
                    b bVar = (b) getChildAt(i5);
                    float f2 = this.f;
                    int i6 = (int) (((i5 % 3) * f) + ((f - f2) / 2.0f));
                    int i7 = (int) (((i5 / 3) * f) + ((f - f2) / 2.0f));
                    bVar.layout(i6, i7, (int) (i6 + f2), (int) (i7 + f2));
                    i5++;
                }
                return;
            }
            float f3 = (((i3 - i) - (this.k * 2.0f)) - (this.l * 2.0f)) / 3.0f;
            while (i5 < 9) {
                b bVar2 = (b) getChildAt(i5);
                float f4 = this.k;
                float f5 = this.l;
                int i8 = (int) (((i5 % 3) * (f3 + f5)) + f4);
                int i9 = (int) (f4 + ((i5 / 3) * (f5 + f3)));
                bVar2.layout(i8, i9, (int) (i8 + f3), (int) (i9 + f3));
                i5++;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int iJ = j(i);
        setMeasuredDimension(iJ, iJ);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L63
            if (r0 == r2) goto Lf
            r3 = 2
            if (r0 == r3) goto L63
            goto Lbd
        Lf:
            java.util.List<com.wear.widget.Lock9View$b> r5 = r4.a
            int r5 = r5.size()
            if (r5 <= 0) goto Lbd
            com.wear.widget.Lock9View$a r5 = r4.s
            if (r5 == 0) goto L47
            java.lang.StringBuilder r5 = r4.r
            r5.setLength(r1)
            java.util.List<com.wear.widget.Lock9View$b> r5 = r4.a
            java.util.Iterator r5 = r5.iterator()
        L26:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L3c
            java.lang.Object r0 = r5.next()
            com.wear.widget.Lock9View$b r0 = (com.wear.widget.Lock9View.b) r0
            java.lang.StringBuilder r3 = r4.r
            int r0 = r0.c()
            r3.append(r0)
            goto L26
        L3c:
            com.wear.widget.Lock9View$a r5 = r4.s
            java.lang.StringBuilder r0 = r4.r
            java.lang.String r0 = r0.toString()
            r5.a(r0)
        L47:
            java.util.List<com.wear.widget.Lock9View$b> r5 = r4.a
            r5.clear()
            r5 = 0
        L4d:
            int r0 = r4.getChildCount()
            if (r5 >= r0) goto L5f
            android.view.View r0 = r4.getChildAt(r5)
            com.wear.widget.Lock9View$b r0 = (com.wear.widget.Lock9View.b) r0
            r0.e(r1, r1)
            int r5 = r5 + 1
            goto L4d
        L5f:
            r4.invalidate()
            goto Lbd
        L63:
            float r0 = r5.getX()
            r4.b = r0
            float r5 = r5.getY()
            r4.c = r5
            float r0 = r4.b
            com.wear.widget.Lock9View$b r5 = r4.g(r0, r5)
            if (r5 == 0) goto Lb2
            boolean r0 = r5.d()
            if (r0 != 0) goto Lb2
            java.util.List<com.wear.widget.Lock9View$b> r0 = r4.a
            int r0 = r0.size()
            if (r0 <= 0) goto Laa
            boolean r0 = r4.m
            if (r0 == 0) goto Laa
            java.util.List<com.wear.widget.Lock9View$b> r0 = r4.a
            int r3 = r0.size()
            int r3 = r3 - r2
            java.lang.Object r0 = r0.get(r3)
            com.wear.widget.Lock9View$b r0 = (com.wear.widget.Lock9View.b) r0
            com.wear.widget.Lock9View$b r0 = r4.h(r0, r5)
            if (r0 == 0) goto Laa
            boolean r3 = r0.d()
            if (r3 != 0) goto Laa
            r0.e(r2, r2)
            java.util.List<com.wear.widget.Lock9View$b> r3 = r4.a
            r3.add(r0)
        Laa:
            r5.e(r2, r1)
            java.util.List<com.wear.widget.Lock9View$b> r0 = r4.a
            r0.add(r5)
        Lb2:
            java.util.List<com.wear.widget.Lock9View$b> r5 = r4.a
            int r5 = r5.size()
            if (r5 <= 0) goto Lbd
            r4.invalidate()
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.Lock9View.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCallBack(a aVar) {
        this.s = aVar;
    }

    public Lock9View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList();
        this.r = new StringBuilder();
        i(context, attributeSet, 0, 0);
    }

    public Lock9View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        this.r = new StringBuilder();
        i(context, attributeSet, i, 0);
    }
}

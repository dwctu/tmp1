package com.bigkoo.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import dc.af;
import dc.df;
import dc.ef;
import dc.me;
import dc.re;
import dc.ve;
import dc.we;
import dc.xe;
import dc.ye;
import dc.ze;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class WheelView extends View {
    public float A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public float P;
    public long Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public float V;
    public b a;
    public Context b;
    public Handler c;
    public GestureDetector d;
    public df e;
    public boolean f;
    public boolean g;
    public ScheduledExecutorService h;
    public ScheduledFuture<?> i;
    public Paint j;
    public Paint k;
    public Paint l;
    public ve m;
    public String n;
    public int o;
    public int p;
    public int q;
    public float r;
    public Typeface s;
    public int t;
    public int u;
    public int v;
    public float w;
    public boolean x;
    public float y;
    public float z;

    public enum a {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum b {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.i;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.i.cancel(true);
        this.i = null;
    }

    public final String b(Object obj) {
        return obj == null ? "" : obj instanceof ef ? ((ef) obj).a() : obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    public final int c(int i) {
        return i < 0 ? c(i + this.m.a()) : i > this.m.a() + (-1) ? c(i - this.m.a()) : i;
    }

    public int d(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i = 0; i < length; i++) {
            iCeil += (int) Math.ceil(r2[i]);
        }
        return iCeil;
    }

    public final void e(Context context) {
        this.b = context;
        this.c = new ye(this);
        GestureDetector gestureDetector = new GestureDetector(context, new xe(this));
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.x = true;
        this.B = 0.0f;
        this.C = -1;
        f();
    }

    public final void f() {
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(this.t);
        this.j.setAntiAlias(true);
        this.j.setTypeface(this.s);
        this.j.setTextSize(this.o);
        Paint paint2 = new Paint();
        this.k = paint2;
        paint2.setColor(this.u);
        this.k.setAntiAlias(true);
        this.k.setTextScaleX(1.1f);
        this.k.setTypeface(this.s);
        this.k.setTextSize(this.o);
        Paint paint3 = new Paint();
        this.l = paint3;
        paint3.setColor(this.v);
        this.l.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public void g(Boolean bool) {
        this.g = bool.booleanValue();
    }

    public final ve getAdapter() {
        return this.m;
    }

    public final int getCurrentItem() {
        return this.D;
    }

    public int getItemsCount() {
        ve veVar = this.m;
        if (veVar != null) {
            return veVar.a();
        }
        return 0;
    }

    public final void h() {
        float f = this.w;
        if (f < 1.2f) {
            this.w = 1.2f;
        } else if (f > 2.0f) {
            this.w = 2.0f;
        }
    }

    public final void i() {
        Rect rect = new Rect();
        for (int i = 0; i < this.m.a(); i++) {
            String strB = b(this.m.getItem(i));
            this.k.getTextBounds(strB, 0, strB.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.p) {
                this.p = iWidth;
            }
            this.k.getTextBounds("星期", 0, 2, rect);
            this.q = rect.height() + 2;
        }
        this.r = this.w * this.q;
    }

    public final void j(String str) {
        String str2;
        Rect rect = new Rect();
        this.k.getTextBounds(str, 0, str.length(), rect);
        int i = this.S;
        if (i == 3) {
            this.T = 0;
            return;
        }
        if (i == 5) {
            this.T = (this.L - rect.width()) - ((int) this.V);
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.f || (str2 = this.n) == null || str2.equals("") || !this.g) {
            this.T = (int) ((this.L - rect.width()) * 0.5d);
        } else {
            this.T = (int) ((this.L - rect.width()) * 0.25d);
        }
    }

    public final void k(String str) {
        String str2;
        Rect rect = new Rect();
        this.j.getTextBounds(str, 0, str.length(), rect);
        int i = this.S;
        if (i == 3) {
            this.U = 0;
            return;
        }
        if (i == 5) {
            this.U = (this.L - rect.width()) - ((int) this.V);
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.f || (str2 = this.n) == null || str2.equals("") || !this.g) {
            this.U = (int) ((this.L - rect.width()) * 0.5d);
        } else {
            this.U = (int) ((this.L - rect.width()) * 0.25d);
        }
    }

    public final void l() {
        if (this.e != null) {
            postDelayed(new ze(this), 200L);
        }
    }

    public final void m(String str) {
        Rect rect = new Rect();
        this.k.getTextBounds(str, 0, str.length(), rect);
        int i = this.o;
        for (int iWidth = rect.width(); iWidth > this.L; iWidth = rect.width()) {
            i--;
            this.k.setTextSize(i);
            this.k.getTextBounds(str, 0, str.length(), rect);
        }
        this.j.setTextSize(i);
    }

    public final void n() {
        if (this.m == null) {
            return;
        }
        i();
        int i = (int) (this.r * (this.G - 1));
        this.M = i;
        this.K = (int) ((i * 2) / 3.141592653589793d);
        this.N = (int) (i / 3.141592653589793d);
        this.L = View.MeasureSpec.getSize(this.R);
        int i2 = this.K;
        float f = this.r;
        this.y = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.z = f2;
        this.A = (f2 - ((f - this.q) / 2.0f)) - this.V;
        if (this.C == -1) {
            if (this.x) {
                this.C = (this.m.a() + 1) / 2;
            } else {
                this.C = 0;
            }
        }
        this.E = this.C;
    }

    public final void o(float f) {
        a();
        this.i = this.h.scheduleWithFixedDelay(new we(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x02c8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instructions count: 767
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigkoo.pickerview.lib.WheelView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.R = i;
        n();
        setMeasuredDimension(this.L, this.K);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.d.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Q = System.currentTimeMillis();
            a();
            this.P = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.P - motionEvent.getRawY();
            this.P = motionEvent.getRawY();
            this.B += rawY;
            if (!this.x) {
                float f = (-this.C) * this.r;
                float fA = (this.m.a() - 1) - this.C;
                float f2 = this.r;
                float f3 = fA * f2;
                float f4 = this.B;
                if (f4 - (f2 * 0.25d) < f) {
                    f = f4 - rawY;
                } else if (f4 + (f2 * 0.25d) > f3) {
                    f3 = f4 - rawY;
                }
                if (f4 < f) {
                    this.B = (int) f;
                } else if (f4 > f3) {
                    this.B = (int) f3;
                }
            }
        } else if (!zOnTouchEvent) {
            float y = motionEvent.getY();
            int i = this.N;
            double dAcos = Math.acos((i - y) / i) * this.N;
            float f5 = this.r;
            this.O = (int) (((((int) ((dAcos + (f5 / 2.0f)) / f5)) - (this.G / 2)) * f5) - (((this.B % f5) + f5) % f5));
            if (System.currentTimeMillis() - this.Q > 120) {
                p(a.DAGGLE);
            } else {
                p(a.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public void p(a aVar) {
        a();
        if (aVar == a.FLING || aVar == a.DAGGLE) {
            float f = this.B;
            float f2 = this.r;
            int i = (int) (((f % f2) + f2) % f2);
            this.O = i;
            if (i > f2 / 2.0f) {
                this.O = (int) (f2 - i);
            } else {
                this.O = -i;
            }
        }
        this.i = this.h.scheduleWithFixedDelay(new af(this, this.O), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(ve veVar) {
        this.m = veVar;
        n();
        invalidate();
    }

    public final void setCurrentItem(int i) {
        this.D = i;
        this.C = i;
        this.B = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.x = z;
    }

    public void setDividerColor(int i) {
        if (i != 0) {
            this.v = i;
            this.l.setColor(i);
        }
    }

    public void setDividerType(b bVar) {
        this.a = bVar;
    }

    public void setGravity(int i) {
        this.S = i;
    }

    public void setIsOptions(boolean z) {
        this.f = z;
    }

    public void setLabel(String str) {
        this.n = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.w = f;
            h();
        }
    }

    public final void setOnItemSelectedListener(df dfVar) {
        this.e = dfVar;
    }

    public void setTextColorCenter(int i) {
        if (i != 0) {
            this.u = i;
            this.k.setColor(i);
        }
    }

    public void setTextColorOut(int i) {
        if (i != 0) {
            this.t = i;
            this.j.setColor(i);
        }
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.b.getResources().getDisplayMetrics().density * f);
            this.o = i;
            this.j.setTextSize(i);
            this.k.setTextSize(this.o);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.s = typeface;
        this.j.setTypeface(typeface);
        this.k.setTypeface(this.s);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.g = true;
        this.h = Executors.newSingleThreadScheduledExecutor();
        this.s = Typeface.MONOSPACE;
        this.t = -5723992;
        this.u = -14013910;
        this.v = -2763307;
        this.w = 1.6f;
        this.G = 11;
        this.O = 0;
        this.P = 0.0f;
        this.Q = 0L;
        this.S = 17;
        this.T = 0;
        this.U = 0;
        this.o = getResources().getDimensionPixelSize(me.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.V = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.V = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.V = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.V = 6.0f;
        } else if (f >= 3.0f) {
            this.V = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, re.pickerview, 0, 0);
            this.S = typedArrayObtainStyledAttributes.getInt(re.pickerview_pickerview_gravity, 17);
            this.t = typedArrayObtainStyledAttributes.getColor(re.pickerview_pickerview_textColorOut, this.t);
            this.u = typedArrayObtainStyledAttributes.getColor(re.pickerview_pickerview_textColorCenter, this.u);
            this.v = typedArrayObtainStyledAttributes.getColor(re.pickerview_pickerview_dividerColor, this.v);
            this.o = typedArrayObtainStyledAttributes.getDimensionPixelOffset(re.pickerview_pickerview_textSize, this.o);
            this.w = typedArrayObtainStyledAttributes.getFloat(re.pickerview_pickerview_lineSpacingMultiplier, this.w);
            typedArrayObtainStyledAttributes.recycle();
        }
        h();
        e(context);
    }
}

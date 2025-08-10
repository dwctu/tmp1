package com.wear.widget.iwatcher;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class MaterialProgressView extends View {
    public b a;
    public float b;

    public static class b extends Drawable implements Animatable {
        public static final Interpolator n;
        public static final Interpolator o;
        public final int[] a;
        public final ArrayList<Animation> b = new ArrayList<>();
        public final g c;
        public final Drawable.Callback d;
        public float e;
        public Resources f;
        public View g;
        public Animation h;
        public float i;
        public double j;
        public double k;
        public Animation l;
        public static final Interpolator m = new LinearInterpolator();
        public static final Interpolator p = new AccelerateDecelerateInterpolator();

        public class a implements Drawable.Callback {
            public a() {
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                b.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                b.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                b.this.unscheduleSelf(runnable);
            }
        }

        /* renamed from: com.wear.widget.iwatcher.MaterialProgressView$b$b, reason: collision with other inner class name */
        public class C0159b extends Animation {
            public final /* synthetic */ g a;

            public C0159b(b bVar, g gVar) {
                this.a = gVar;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float fFloor = (float) (Math.floor(this.a.g() / 0.8f) + 1.0d);
                this.a.w(this.a.h() + ((this.a.f() - this.a.h()) * f));
                this.a.u(this.a.g() + ((fFloor - this.a.g()) * f));
                this.a.n(1.0f - f);
            }
        }

        public class c implements Animation.AnimationListener {
            public final /* synthetic */ g a;

            public c(g gVar) {
                this.a = gVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                this.a.j();
                this.a.y();
                this.a.v(false);
                b.this.g.startAnimation(b.this.h);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        public class d extends Animation {
            public final /* synthetic */ g a;

            public d(g gVar) {
                this.a = gVar;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float radians = (float) Math.toRadians(this.a.i() / (this.a.c() * 6.283185307179586d));
                float f2 = this.a.f();
                float fH = this.a.h();
                float fG = this.a.g();
                this.a.s(f2 + ((0.8f - radians) * b.o.getInterpolation(f)));
                this.a.w(fH + (b.n.getInterpolation(f) * 0.8f));
                this.a.u(fG + (0.25f * f));
                b.this.g((f * 144.0f) + ((b.this.i / 5.0f) * 720.0f));
            }
        }

        public class e implements Animation.AnimationListener {
            public final /* synthetic */ g a;

            public e(g gVar) {
                this.a = gVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                this.a.y();
                this.a.j();
                g gVar = this.a;
                gVar.w(gVar.d());
                b bVar = b.this;
                bVar.i = (bVar.i + 1.0f) % 5.0f;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.i = 0.0f;
            }
        }

        public static class f extends AccelerateDecelerateInterpolator {
            public f() {
            }

            @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
            }
        }

        public static class g {
            public final RectF a = new RectF();
            public final Paint b;
            public final Paint c;
            public final Drawable.Callback d;
            public final Paint e;
            public float f;
            public float g;
            public float h;
            public float i;
            public float j;
            public int[] k;
            public int l;
            public float m;
            public float n;
            public float o;
            public boolean p;
            public float q;
            public double r;
            public int s;

            public g(Drawable.Callback callback) {
                Paint paint = new Paint();
                this.b = paint;
                Paint paint2 = new Paint();
                this.c = paint2;
                Paint paint3 = new Paint();
                this.e = paint3;
                this.f = 0.0f;
                this.g = 0.0f;
                this.h = 0.0f;
                this.i = 5.0f;
                this.j = 2.5f;
                this.d = callback;
                paint.setStrokeCap(Paint.Cap.SQUARE);
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                paint2.setStyle(Paint.Style.FILL);
                paint2.setAntiAlias(true);
                paint3.setAntiAlias(true);
            }

            public void a(Canvas canvas, Rect rect) {
                RectF rectF = this.a;
                rectF.set(rect);
                float f = this.j;
                rectF.inset(f, f);
                float f2 = this.f;
                float f3 = this.h;
                float f4 = (f2 + f3) * 360.0f;
                float f5 = ((this.g + f3) * 360.0f) - f4;
                this.b.setColor(this.k[this.l]);
                this.b.setAlpha(this.s);
                canvas.drawArc(rectF, f4, f5, false, this.b);
            }

            public int b() {
                return this.s;
            }

            public double c() {
                return this.r;
            }

            public float d() {
                return this.g;
            }

            public float e() {
                return this.f;
            }

            public float f() {
                return this.n;
            }

            public float g() {
                return this.o;
            }

            public float h() {
                return this.m;
            }

            public float i() {
                return this.i;
            }

            public void j() {
                this.l = (this.l + 1) % this.k.length;
            }

            public final void k() {
                this.d.invalidateDrawable(null);
            }

            public void l() {
                this.m = 0.0f;
                this.n = 0.0f;
                this.o = 0.0f;
                w(0.0f);
                s(0.0f);
                u(0.0f);
            }

            public void m(int i) {
                this.s = i;
            }

            public void n(float f) {
                if (f != this.q) {
                    this.q = f;
                    k();
                }
            }

            public void o(double d) {
                this.r = d;
            }

            public void p(ColorFilter colorFilter) {
                this.b.setColorFilter(colorFilter);
                k();
            }

            public void q(int i) {
                this.l = i;
            }

            public void r(int[] iArr) {
                this.k = iArr;
                q(0);
            }

            public void s(float f) {
                this.g = f;
                k();
            }

            public void t(int i, int i2) {
                float fMin = Math.min(i, i2);
                double d = this.r;
                this.j = (float) ((d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || fMin < 0.0f) ? Math.ceil(this.i / 2.0f) : (fMin / 2.0f) - d);
            }

            public void u(float f) {
                this.h = f;
                k();
            }

            public void v(boolean z) {
                if (this.p != z) {
                    this.p = z;
                    k();
                }
            }

            public void w(float f) {
                this.f = f;
                k();
            }

            public void x(float f) {
                this.i = f;
                this.b.setStrokeWidth(f);
                k();
            }

            public void y() {
                this.m = this.f;
                this.n = this.g;
                this.o = this.h;
            }
        }

        public static class h extends AccelerateDecelerateInterpolator {
            public h() {
            }

            @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return super.getInterpolation(Math.min(1.0f, f * 2.0f));
            }
        }

        static {
            n = new f();
            o = new h();
        }

        public b(Context context, View view) {
            int[] iArr = {-1, -1, -1, -1};
            this.a = iArr;
            a aVar = new a();
            this.d = aVar;
            this.g = view;
            this.f = context.getResources();
            g gVar = new g(aVar);
            this.c = gVar;
            gVar.r(iArr);
            h(30.0d, 30.0d, 8.0d, 2.0d);
            i();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            int iSave = canvas.save();
            canvas.rotate(this.e, bounds.exactCenterX(), bounds.exactCenterY());
            this.c.a(canvas, bounds);
            canvas.restoreToCount(iSave);
        }

        public void g(float f2) {
            this.e = f2;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public int getAlpha() {
            return this.c.b();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return (int) this.k;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return (int) this.j;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public final void h(double d2, double d3, double d4, double d5) {
            g gVar = this.c;
            float f2 = this.f.getDisplayMetrics().density;
            double d6 = f2;
            this.j = d2 * d6;
            this.k = d3 * d6;
            gVar.x(((float) d5) * f2);
            gVar.o(d4 * d6);
            gVar.q(0);
            gVar.t((int) this.j, (int) this.k);
        }

        public final void i() {
            g gVar = this.c;
            C0159b c0159b = new C0159b(this, gVar);
            c0159b.setInterpolator(p);
            c0159b.setDuration(666L);
            c0159b.setAnimationListener(new c(gVar));
            d dVar = new d(gVar);
            dVar.setRepeatCount(-1);
            dVar.setRepeatMode(1);
            dVar.setInterpolator(m);
            dVar.setDuration(1333L);
            dVar.setAnimationListener(new e(gVar));
            this.l = c0159b;
            this.h = dVar;
        }

        @Override // android.graphics.drawable.Animatable
        public boolean isRunning() {
            ArrayList<Animation> arrayList = this.b;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Animation animation = arrayList.get(i);
                if (animation.hasStarted() && !animation.hasEnded()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.c.m(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.c.p(colorFilter);
        }

        @Override // android.graphics.drawable.Animatable
        public void start() {
            this.h.reset();
            this.c.y();
            if (this.c.d() != this.c.e()) {
                this.g.startAnimation(this.l);
                return;
            }
            this.c.q(0);
            this.c.l();
            this.g.startAnimation(this.h);
        }

        @Override // android.graphics.drawable.Animatable
        public void stop() {
            this.g.clearAnimation();
            g(0.0f);
            this.c.v(false);
            this.c.q(0);
            this.c.l();
        }
    }

    public MaterialProgressView(Context context) {
        super(context);
        this.b = 1.0f;
        a();
    }

    public final void a() {
        b bVar = new b(getContext(), this);
        this.a = bVar;
        bVar.setAlpha(255);
        this.a.setCallback(this);
    }

    public void b() {
        this.a.start();
    }

    public void c() {
        this.a.stop();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.a) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        Rect bounds = this.a.getBounds();
        canvas.translate(getPaddingLeft() + ((getMeasuredWidth() - this.a.getIntrinsicWidth()) / 2), getPaddingTop());
        float f = this.b;
        canvas.scale(f, f, bounds.exactCenterX(), bounds.exactCenterY());
        this.a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int intrinsicHeight = this.a.getIntrinsicHeight();
        this.a.setBounds(0, 0, intrinsicHeight, intrinsicHeight);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.a.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom(), 1073741824));
    }

    public MaterialProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 1.0f;
        a();
    }
}

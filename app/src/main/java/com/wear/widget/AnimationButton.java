package com.wear.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.lovense.wear.R;
import dc.ah4;
import dc.ce3;
import dc.de3;
import dc.th4;

/* loaded from: classes4.dex */
public class AnimationButton extends View {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public String i;
    public int j;
    public Paint k;
    public Paint l;
    public int m;
    public Rect n;
    public AnimatorSet o;
    public ValueAnimator p;
    public ValueAnimator q;
    public AnimatorSet r;
    public ValueAnimator s;
    public ValueAnimator t;
    public RectF u;
    public h v;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AnimationButton.this.v != null) {
                AnimationButton.this.v.a();
            }
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (AnimationButton.this.v != null) {
                AnimationButton.this.v.c();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (AnimationButton.this.v != null) {
                AnimationButton.this.v.b();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationButton.this.e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            AnimationButton.this.invalidate();
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationButton.this.g = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            AnimationButton.this.l.setAlpha(255 - ((AnimationButton.this.g * 255) / AnimationButton.this.f));
            AnimationButton.this.invalidate();
        }
    }

    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationButton.this.g = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            AnimationButton.this.l.setAlpha(255 - ((AnimationButton.this.g * 255) / AnimationButton.this.f));
            AnimationButton.this.invalidate();
        }
    }

    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationButton.this.e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            AnimationButton.this.invalidate();
        }
    }

    public interface h {
        void a();

        void b();

        void c();
    }

    public AnimationButton(Context context) {
        this(context, null);
    }

    public final void g(Canvas canvas) {
        Rect rect = this.n;
        rect.left = 0;
        rect.top = 0;
        rect.right = this.b;
        rect.bottom = this.c;
        Paint.FontMetricsInt fontMetricsInt = this.l.getFontMetricsInt();
        Rect rect2 = this.n;
        canvas.drawText(this.i, rect2.centerX(), (((rect2.bottom + rect2.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.l);
    }

    public final void h(Canvas canvas) {
        RectF rectF = this.u;
        rectF.left = this.g;
        rectF.top = 0.0f;
        rectF.right = this.b - r1;
        rectF.bottom = this.c;
        int i = this.e;
        canvas.drawRoundRect(rectF, i, i, this.k);
    }

    public final void i() {
        m();
        n();
        k();
        l();
        this.o.play(this.q).after(this.p);
        this.r.play(this.t).before(this.s);
    }

    public final void j() {
        Paint paint = new Paint();
        this.k = paint;
        paint.setStrokeWidth(4.0f);
        this.k.setStyle(Paint.Style.FILL);
        this.k.setAntiAlias(true);
        this.k.setColor(this.h);
        Paint paint2 = new Paint(1);
        this.l = paint2;
        paint2.setTextSize(de3.b(getContext(), 16.0f));
        this.l.setColor(this.m);
        this.l.setTextAlign(Paint.Align.CENTER);
        this.l.setAntiAlias(true);
    }

    public final void k() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt((this.b - this.c) / 2, 0);
        this.s = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.j);
        this.s.addUpdateListener(new f());
    }

    public final void l() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.c / 2, this.d);
        this.t = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.j / 3);
        this.t.addUpdateListener(new g());
    }

    public final void m() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.c / 2);
        this.p = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.j / 3);
        this.p.addUpdateListener(new d());
    }

    public final void n() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.f);
        this.q = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.j);
        this.q.addUpdateListener(new e());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        h(canvas);
        g(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b = i;
        this.c = i2;
        this.f = (i - i2) / 2;
        i();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.h = th4.b(getContext(), R.color.red_focus_color);
            } else if (action == 1) {
                this.h = th4.b(getContext(), R.color.buttom_select_background);
            }
            j();
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimationButtonListener(h hVar) {
        this.v = hVar;
    }

    public void setColor(boolean z) {
        this.a = z;
        if (z) {
            if (this.h == th4.b(getContext(), R.color.buttom_select_background)) {
                return;
            }
            this.h = th4.b(getContext(), R.color.buttom_select_background);
            this.m = getResources().getColor(R.color.white);
            setBackground(null);
        } else {
            if (this.h == th4.b(getContext(), R.color.buttom_un_select_background)) {
                return;
            }
            this.h = th4.b(getContext(), R.color.buttom_un_select_background);
            this.m = th4.b(getContext(), R.color.text_color_25);
            setBackground(th4.d(getContext(), R.drawable.sign_up_bg));
        }
        j();
        invalidate();
    }

    public AnimationButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        int iA = ce3.a(getContext(), 4.0f);
        this.d = iA;
        this.e = iA;
        this.h = -53879;
        this.i = "";
        this.j = 250;
        this.m = -9670029;
        this.n = new Rect();
        this.o = new AnimatorSet();
        this.r = new AnimatorSet();
        this.u = new RectF();
        this.i = ah4.e(R.string.welcome_login);
        j();
        setOnClickListener(new a());
        this.o.addListener(new b());
        this.r.addListener(new c());
    }
}

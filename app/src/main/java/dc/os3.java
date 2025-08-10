package dc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: ViewState.java */
/* loaded from: classes4.dex */
public class os3 {
    public int a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;

    /* compiled from: ViewState.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ os3 b;
        public final /* synthetic */ os3 c;

        public a(View view, os3 os3Var, os3 os3Var2) {
            this.a = view;
            this.b = os3Var;
            this.c = os3Var2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            View view = this.a;
            float f = this.b.d;
            view.setTranslationX(f + ((this.c.d - f) * fFloatValue));
            View view2 = this.a;
            float f2 = this.b.e;
            view2.setTranslationY(f2 + ((this.c.e - f2) * fFloatValue));
            View view3 = this.a;
            float f3 = this.b.f;
            view3.setScaleX(f3 + ((this.c.f - f3) * fFloatValue));
            View view4 = this.a;
            float f4 = this.b.g;
            view4.setScaleY(f4 + ((this.c.g - f4) * fFloatValue));
            View view5 = this.a;
            float f5 = this.b.h;
            view5.setRotation((f5 + ((this.c.h - f5) * fFloatValue)) % 360.0f);
            View view6 = this.a;
            float f6 = this.b.i;
            view6.setAlpha(f6 + ((this.c.i - f6) * fFloatValue));
            os3 os3Var = this.b;
            int i = os3Var.b;
            os3 os3Var2 = this.c;
            int i2 = os3Var2.b;
            if (i != i2) {
                int i3 = os3Var.c;
                int i4 = os3Var2.c;
                if (i3 == i4 || i2 == 0 || i4 == 0) {
                    return;
                }
                this.a.getLayoutParams().width = (int) (this.b.b + ((this.c.b - r1) * fFloatValue));
                this.a.getLayoutParams().height = (int) (this.b.c + ((this.c.c - r1) * fFloatValue));
                this.a.requestLayout();
            }
        }
    }

    /* compiled from: ViewState.java */
    public static class b {
        public ValueAnimator a;

        public b(ValueAnimator valueAnimator) {
            this.a = valueAnimator;
        }

        public b a(Animator.AnimatorListener animatorListener) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null) {
                valueAnimator.addListener(animatorListener);
            }
            return this;
        }

        public ValueAnimator b() {
            return this.a;
        }
    }

    public os3(int i) {
        this.a = i;
    }

    public static void b(View view, int i) {
        if (view == null) {
            return;
        }
        view.setTag(i, null);
    }

    public static os3 c(os3 os3Var, int i) {
        os3 os3Var2 = new os3(i);
        os3Var2.b = os3Var.b;
        os3Var2.c = os3Var.c;
        os3Var2.d = os3Var.d;
        os3Var2.e = os3Var.e;
        os3Var2.f = os3Var.f;
        os3Var2.g = os3Var.g;
        os3Var2.h = os3Var.h;
        os3Var2.i = os3Var.i;
        return os3Var2;
    }

    public static os3 e(View view, int i) {
        if (view == null || view.getTag(i) == null) {
            return null;
        }
        return (os3) view.getTag(i);
    }

    public static void f(View view, int i) {
        os3 os3VarE = e(view, i);
        if (os3VarE != null) {
            view.setTranslationX(os3VarE.d);
            view.setTranslationY(os3VarE.e);
            view.setScaleX(os3VarE.f);
            view.setScaleY(os3VarE.g);
            view.setRotation(os3VarE.h);
            view.setAlpha(os3VarE.i);
            if (view.getLayoutParams().width == os3VarE.b && view.getLayoutParams().height == os3VarE.c) {
                return;
            }
            view.getLayoutParams().width = os3VarE.b;
            view.getLayoutParams().height = os3VarE.c;
            view.requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static dc.os3.b g(android.view.View r4, int r5) {
        /*
            if (r4 == 0) goto L43
            r0 = 2131364624(0x7f0a0b10, float:1.834909E38)
            dc.os3 r0 = o(r4, r0)
            int r1 = r0.b
            if (r1 != 0) goto L24
            int r1 = r0.c
            if (r1 != 0) goto L24
            r1 = 2131364626(0x7f0a0b12, float:1.8349094E38)
            dc.os3 r1 = e(r4, r1)
            if (r1 == 0) goto L24
            int r2 = r1.b
            r0.n(r2)
            int r1 = r1.c
            r0.d(r1)
        L24:
            dc.os3 r5 = e(r4, r5)
            if (r5 == 0) goto L43
            r1 = 2
            float[] r1 = new float[r1]
            r1 = {x004a: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.animation.ValueAnimator r1 = android.animation.ValueAnimator.ofFloat(r1)
            r2 = 300(0x12c, double:1.48E-321)
            android.animation.ValueAnimator r1 = r1.setDuration(r2)
            dc.os3$a r2 = new dc.os3$a
            r2.<init>(r4, r0, r5)
            r1.addUpdateListener(r2)
            goto L44
        L43:
            r1 = 0
        L44:
            dc.os3$b r4 = new dc.os3$b
            r4.<init>(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.os3.g(android.view.View, int):dc.os3$b");
    }

    public static os3 o(View view, int i) {
        if (view == null) {
            return null;
        }
        os3 os3VarE = e(view, i);
        if (os3VarE == null) {
            os3VarE = new os3(i);
            view.setTag(i, os3VarE);
        }
        os3VarE.b = view.getWidth();
        os3VarE.c = view.getHeight();
        os3VarE.d = view.getTranslationX();
        os3VarE.e = view.getTranslationY();
        os3VarE.f = view.getScaleX();
        os3VarE.g = view.getScaleY();
        os3VarE.h = view.getRotation();
        os3VarE.i = view.getAlpha();
        return os3VarE;
    }

    public os3 a(float f) {
        this.i = f;
        return this;
    }

    public os3 d(int i) {
        this.c = i;
        return this;
    }

    public os3 h(float f) {
        this.f = f;
        return this;
    }

    public os3 i(float f) {
        this.f *= f;
        return this;
    }

    public os3 j(float f) {
        this.g = f;
        return this;
    }

    public os3 k(float f) {
        this.g *= f;
        return this;
    }

    public os3 l(float f) {
        this.d = f;
        return this;
    }

    public os3 m(float f) {
        this.e = f;
        return this;
    }

    public os3 n(int i) {
        this.b = i;
        return this;
    }
}

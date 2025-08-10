package dc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: ViewState.java */
/* loaded from: classes4.dex */
public class ps3 {
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
        public final /* synthetic */ ps3 b;
        public final /* synthetic */ ps3 c;

        public a(View view, ps3 ps3Var, ps3 ps3Var2) {
            this.a = view;
            this.b = ps3Var;
            this.c = ps3Var2;
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
            ps3 ps3Var = this.b;
            int i = ps3Var.b;
            ps3 ps3Var2 = this.c;
            int i2 = ps3Var2.b;
            if (i != i2) {
                int i3 = ps3Var.c;
                int i4 = ps3Var2.c;
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

    public ps3(int i) {
        this.a = i;
    }

    public static ps3 a(ps3 ps3Var, int i) {
        ps3 ps3Var2 = new ps3(i);
        ps3Var2.b = ps3Var.b;
        ps3Var2.c = ps3Var.c;
        ps3Var2.d = ps3Var.d;
        ps3Var2.e = ps3Var.e;
        ps3Var2.f = ps3Var.f;
        ps3Var2.g = ps3Var.g;
        ps3Var2.h = ps3Var.h;
        ps3Var2.i = ps3Var.i;
        return ps3Var2;
    }

    public static ps3 c(View view, int i) {
        if (view == null || view.getTag(i) == null) {
            return null;
        }
        return (ps3) view.getTag(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static dc.ps3.b d(android.view.View r4, int r5) {
        /*
            if (r4 == 0) goto L43
            r0 = 2131364624(0x7f0a0b10, float:1.834909E38)
            dc.ps3 r0 = j(r4, r0)
            int r1 = r0.b
            if (r1 != 0) goto L24
            int r1 = r0.c
            if (r1 != 0) goto L24
            r1 = 2131364626(0x7f0a0b12, float:1.8349094E38)
            dc.ps3 r1 = c(r4, r1)
            if (r1 == 0) goto L24
            int r2 = r1.b
            r0.i(r2)
            int r1 = r1.c
            r0.b(r1)
        L24:
            dc.ps3 r5 = c(r4, r5)
            if (r5 == 0) goto L43
            r1 = 2
            float[] r1 = new float[r1]
            r1 = {x004a: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.animation.ValueAnimator r1 = android.animation.ValueAnimator.ofFloat(r1)
            r2 = 300(0x12c, double:1.48E-321)
            android.animation.ValueAnimator r1 = r1.setDuration(r2)
            dc.ps3$a r2 = new dc.ps3$a
            r2.<init>(r4, r0, r5)
            r1.addUpdateListener(r2)
            goto L44
        L43:
            r1 = 0
        L44:
            dc.ps3$b r4 = new dc.ps3$b
            r4.<init>(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ps3.d(android.view.View, int):dc.ps3$b");
    }

    public static ps3 j(View view, int i) {
        if (view == null) {
            return null;
        }
        ps3 ps3VarC = c(view, i);
        if (ps3VarC == null) {
            ps3VarC = new ps3(i);
            view.setTag(i, ps3VarC);
        }
        ps3VarC.b = view.getWidth();
        ps3VarC.c = view.getHeight();
        ps3VarC.d = view.getTranslationX();
        ps3VarC.e = view.getTranslationY();
        ps3VarC.f = view.getScaleX();
        ps3VarC.g = view.getScaleY();
        ps3VarC.h = view.getRotation();
        ps3VarC.i = view.getAlpha();
        return ps3VarC;
    }

    public ps3 b(int i) {
        this.c = i;
        return this;
    }

    public ps3 e(float f) {
        this.f = f;
        return this;
    }

    public ps3 f(float f) {
        this.g = f;
        return this;
    }

    public ps3 g(float f) {
        this.d = f;
        return this;
    }

    public ps3 h(float f) {
        this.e = f;
        return this;
    }

    public ps3 i(int i) {
        this.b = i;
        return this;
    }
}

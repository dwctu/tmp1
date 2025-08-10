package com.wear.widget.llong;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lovense.wear.R;
import dc.ns3;
import dc.ps3;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes4.dex */
public class GesLayout extends FrameLayout implements GestureDetector.OnGestureListener {
    public int a;
    public int b;
    public RelativeLayout c;
    public ImageView d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final float i;
    public float j;
    public double k;
    public float l;
    public float m;
    public float n;
    public ValueAnimator o;
    public ValueAnimator p;
    public boolean q;
    public final GestureDetector r;
    public List<ns3> s;
    public int t;
    public g u;
    public final AnimatorListenerAdapter v;
    public final TypeEvaluator<Integer> w;
    public int x;
    public e y;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            GesLayout.this.q = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GesLayout.this.q = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            GesLayout.this.q = true;
            GesLayout.this.h = 7;
        }
    }

    public class b implements TypeEvaluator<Integer> {
        public b(GesLayout gesLayout) {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer evaluate(float f, Integer num, Integer num2) {
            int iIntValue = num.intValue();
            int iIntValue2 = num2.intValue();
            return Integer.valueOf(Color.argb((int) (Color.alpha(iIntValue) + ((Color.alpha(iIntValue2) - Color.alpha(iIntValue)) * f)), (int) (Color.red(iIntValue) + ((Color.red(iIntValue2) - Color.red(iIntValue)) * f)), (int) (Color.green(iIntValue) + ((Color.green(iIntValue2) - Color.green(iIntValue)) * f)), (int) (Color.blue(iIntValue) + (f * (Color.blue(iIntValue2) - Color.blue(iIntValue))))));
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (GesLayout.this.d != null) {
                GesLayout.this.d.setVisibility(0);
            }
            GesLayout.this.setVisibility(8);
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            GesLayout gesLayout = GesLayout.this;
            gesLayout.setBackgroundColor(gesLayout.w.evaluate(fFloatValue, Integer.valueOf(this.a), Integer.valueOf(this.b)).intValue());
        }
    }

    public interface e {
        void b();
    }

    public static class f extends Handler {
        public WeakReference<GesLayout> a;

        public f(GesLayout gesLayout) {
            this.a = new WeakReference<>(gesLayout);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a.get() != null) {
                GesLayout gesLayout = this.a.get();
                if (message.what == 1) {
                    gesLayout.l();
                    return;
                }
                throw new RuntimeException("Unknown message " + message);
            }
        }
    }

    public interface g {
        void a();
    }

    public GesLayout(Context context) {
        this(context, null);
    }

    public final void d(int i) {
        if (i == this.g) {
            return;
        }
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i2 = this.g;
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        this.o = duration;
        duration.addUpdateListener(new d(i2, i));
        this.o.start();
    }

    public final void e(View view, ps3 ps3Var) {
        if (view == null) {
            return;
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ps3.b bVarD = ps3.d(view, ps3Var.a);
        bVarD.a(this.v);
        ValueAnimator valueAnimatorB = bVarD.b();
        this.p = valueAnimatorB;
        if (valueAnimatorB != null) {
            if (ps3Var.a == R.id.state_origin) {
                valueAnimatorB.addListener(new c());
            }
            this.p.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[PHI: r11
  0x00a1: PHI (r11v11 float) = (r11v6 float), (r11v17 float), (r11v18 float) binds: [B:27:0x009f, B:14:0x005c, B:17:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(android.view.MotionEvent r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            android.widget.RelativeLayout r0 = r10.c
            if (r0 != 0) goto L5
            return
        L5:
            float r0 = r11.getY()
            float r1 = r12.getY()
            float r0 = r0 - r1
            float r11 = r11.getX()
            float r12 = r12.getX()
            float r11 = r11 - r12
            android.widget.RelativeLayout r12 = r10.c
            r1 = 2131364625(0x7f0a0b11, float:1.8349092E38)
            dc.ps3 r12 = dc.ps3.c(r12, r1)
            if (r12 != 0) goto L23
            return
        L23:
            android.widget.RelativeLayout r1 = r10.c
            r2 = 2131364630(0x7f0a0b16, float:1.8349102E38)
            dc.ps3 r1 = dc.ps3.c(r1, r2)
            if (r1 != 0) goto L2f
            return
        L2f:
            float r2 = r1.d
            r3 = 1070386381(0x3fcccccd, float:1.6)
            float r4 = r11 * r3
            float r2 = r2 + r4
            android.widget.RelativeLayout r4 = r10.c
            r5 = 2131362978(0x7f0a04a2, float:1.8345752E38)
            java.lang.Object r4 = r4.getTag(r5)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "horizontal"
            boolean r5 = r5.equals(r4)
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = 1039516303(0x3df5c28f, float:0.12)
            if (r5 == 0) goto L65
            int r11 = r12.b
            float r11 = (float) r11
            float r12 = r1.f
            r4 = 1065353216(0x3f800000, float:1.0)
            float r12 = r12 - r4
            float r11 = r11 * r12
            float r11 = r11 / r6
            int r12 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r12 <= 0) goto L5f
            goto La1
        L5f:
            float r11 = -r11
            int r12 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r12 >= 0) goto Lae
            goto La1
        L65:
            java.lang.String r5 = "vertical"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto Lae
            int r12 = r12.b
            float r4 = (float) r12
            float r5 = r1.f
            float r4 = r4 * r5
            int r8 = r10.e
            float r9 = (float) r8
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 > 0) goto L8b
            float r11 = java.lang.Math.abs(r11)
            float r12 = java.lang.Math.abs(r0)
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto Lae
            r11 = 4
            r10.h = r11
            goto Lae
        L8b:
            float r11 = (float) r12
            float r11 = r11 * r5
            float r11 = r11 / r6
            int r4 = r12 / 2
            float r4 = (float) r4
            float r11 = r11 - r4
            float r4 = (float) r8
            float r8 = (float) r12
            float r8 = r8 * r5
            float r8 = r8 / r6
            float r4 = r4 - r8
            int r12 = r12 / 2
            float r12 = (float) r12
            float r4 = r4 - r12
            int r12 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r12 <= 0) goto La6
        La1:
            float r2 = r2 - r11
            float r2 = r2 * r7
            float r2 = r2 + r11
            goto Lae
        La6:
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 >= 0) goto Lae
            float r2 = r2 - r4
            float r2 = r2 * r7
            float r2 = r2 + r4
        Lae:
            android.widget.RelativeLayout r11 = r10.c
            r11.setTranslationX(r2)
            android.widget.RelativeLayout r11 = r10.c
            float r12 = r1.e
            float r0 = r0 * r3
            float r12 = r12 + r0
            r11.setTranslationY(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.llong.GesLayout.f(android.view.MotionEvent, android.view.MotionEvent):void");
    }

    public final void g() {
        ps3 ps3VarC;
        float f2;
        float f3;
        float f4;
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null || (ps3VarC = ps3.c(relativeLayout, R.id.state_default)) == null) {
            return;
        }
        ps3 ps3VarJ = ps3.j(this.c, R.id.state_current);
        String str = (String) this.c.getTag(R.id.image_orientation);
        if ("horizontal".equals(str)) {
            f3 = (ps3VarC.b * (ps3VarJ.f - 1.0f)) / 2.0f;
            float f5 = ps3VarJ.d;
            if (f5 <= f3) {
                f3 = -f3;
                if (f5 >= f3) {
                    f3 = f5;
                }
            }
            int i = ps3VarC.c;
            float f6 = ps3VarJ.g;
            float f7 = i * f6;
            int i2 = this.f;
            if (f7 <= i2) {
                f4 = ps3VarC.e;
            } else {
                f4 = ((i * f6) / 2.0f) - (i / 2);
                float f8 = (i2 - ((i * f6) / 2.0f)) - (i / 2);
                float f9 = ps3VarJ.e;
                if (f9 <= f4) {
                    f4 = f9 < f8 ? f8 : f9;
                }
            }
        } else {
            if (!"vertical".equals(str)) {
                return;
            }
            float f10 = (ps3VarC.c * (ps3VarJ.g - 1.0f)) / 2.0f;
            float f11 = ps3VarJ.e;
            if (f11 <= f10) {
                f10 = -f10;
                if (f11 >= f10) {
                    f10 = f11;
                }
            }
            int i3 = ps3VarC.b;
            float f12 = ps3VarJ.f;
            float f13 = i3 * f12;
            int i4 = this.e;
            if (f13 <= i4) {
                f2 = ps3VarC.d;
            } else {
                f2 = ((i3 * f12) / 2.0f) - (i3 / 2);
                float f14 = (i4 - ((i3 * f12) / 2.0f)) - (i3 / 2);
                float f15 = ps3VarJ.d;
                if (f15 <= f2) {
                    f2 = f15 < f14 ? f14 : f15;
                }
            }
            float f16 = f10;
            f3 = f2;
            f4 = f16;
        }
        if (ps3VarJ.d == f3 && ps3VarJ.e == f4) {
            return;
        }
        RelativeLayout relativeLayout2 = this.c;
        ps3 ps3VarJ2 = ps3.j(relativeLayout2, R.id.state_temp);
        ps3VarJ2.g(f3);
        ps3VarJ2.h(f4);
        e(relativeLayout2, ps3VarJ2);
    }

    public final void h(MotionEvent motionEvent, MotionEvent motionEvent2) {
        ps3 ps3VarC;
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null || (ps3VarC = ps3.c(relativeLayout, R.id.state_touch_down)) == null) {
            return;
        }
        this.n = 1.0f;
        float y = motionEvent.getY() - motionEvent2.getY();
        float x = motionEvent.getX() - motionEvent2.getX();
        if (y > 0.0f) {
            this.n -= y / getHeight();
        }
        if (this.n < 0.5f) {
            this.n = 0.5f;
        }
        this.c.setTranslationX(ps3VarC.d + x);
        this.c.setTranslationY(ps3VarC.e + y);
        this.c.setScaleX(ps3VarC.f * this.n);
        this.c.setScaleY(ps3VarC.g * this.n);
        setBackgroundColor(this.w.evaluate(this.n, 0, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK)).intValue());
    }

    public final void i() {
        ns3 ns3Var;
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null) {
            return;
        }
        if (this.n > 0.9f) {
            ps3 ps3VarC = ps3.c(relativeLayout, R.id.state_default);
            if (ps3VarC == null) {
                return;
            }
            e(this.c, ps3VarC);
            d(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        e eVar = this.y;
        if (eVar != null) {
            eVar.b();
        }
        ps3 ps3VarC2 = ps3.c(this.c, R.id.state_origin);
        if (ps3VarC2 == null) {
            return;
        }
        if (ps3VarC2.i == 0.0f) {
            ps3VarC2.g(this.c.getTranslationX());
            ps3VarC2.h(this.c.getTranslationY());
        }
        List<ns3> list = this.s;
        if (list != null) {
            int size = list.size();
            int i = this.x;
            if (size > i && i >= 0 && (ns3Var = this.s.get(i)) != null) {
                ps3VarC2.g(ns3Var.c());
                ps3VarC2.h(ns3Var.d());
                ps3VarC2.i(ns3Var.b());
                ps3VarC2.b(ns3Var.a());
            }
        }
        g gVar = this.u;
        if (gVar != null) {
            gVar.a();
        }
        e(this.c, ps3VarC2);
        d(0);
        ((FrameLayout) this.c.getParent()).getChildAt(2).animate().alpha(0.0f).start();
    }

    public final void j(MotionEvent motionEvent) {
        ps3 ps3VarC;
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null || ps3.c(relativeLayout, R.id.state_default) == null || (ps3VarC = ps3.c(this.c, R.id.state_touch_scale_rotate)) == null || motionEvent.getPointerCount() < 2) {
            return;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        double degrees = Math.toDegrees(Math.atan(x / y));
        if (y < 0.0f) {
            degrees += 180.0d;
        }
        if (this.k == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.k = degrees;
        }
        float f2 = (ps3VarC.h + ((float) (this.k - degrees))) % 360.0f;
        if (f2 > 180.0f) {
            f2 -= 360.0f;
        } else if (f2 < -180.0f) {
            f2 += 360.0f;
        }
        this.c.setRotation(f2);
        float fSqrt = (float) Math.sqrt((x * x) + (y * y));
        if (this.j == 0.0f) {
            this.j = fSqrt;
        }
        float f3 = (this.j - fSqrt) / (this.e * 0.8f);
        float f4 = ps3VarC.f - f3;
        float f5 = 3.8f;
        if (f4 < 0.5f) {
            f4 = 0.5f;
        } else if (f4 > 3.8f) {
            f4 = 3.8f;
        }
        this.c.setScaleX(f4);
        float f6 = ps3VarC.g - f3;
        if (f6 < 0.5f) {
            f5 = 0.5f;
        } else if (f6 <= 3.8f) {
            f5 = f6;
        }
        this.c.setScaleY(f5);
        float x2 = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
        float y2 = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
        if (this.l == 0.0f && this.m == 0.0f) {
            this.l = x2;
            this.m = y2;
        }
        float f7 = ps3VarC.d - (this.l - x2);
        int i = this.a;
        if (f7 > i) {
            f7 = i;
        } else if (f7 < (-i)) {
            i = -i;
            f7 = i;
        }
        this.c.setTranslationX(f7);
        float f8 = ps3VarC.e - (this.m - y2);
        int i2 = this.b;
        if (f8 > i2) {
            f8 = i2;
        } else if (f8 < (-i2)) {
            i2 = -i2;
            f8 = i2;
        }
        this.c.setTranslationY(f8);
    }

    public final void k() {
        ps3 ps3VarC;
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null || (ps3VarC = ps3.c(relativeLayout, R.id.state_default)) == null) {
            return;
        }
        ps3 ps3VarJ = ps3.j(this.c, R.id.state_current);
        String str = "AAA  vsCurrent.scaleX :" + ps3VarJ.f + "###  vsDefault.scaleX:" + ps3VarC.f;
        float f2 = ps3VarJ.f;
        float f3 = ps3VarC.f;
        if (f2 < f3) {
            f2 = f3;
        }
        float f4 = ps3VarJ.g;
        float f5 = ps3VarC.g;
        if (f4 < f5) {
            f4 = f5;
        }
        ps3 ps3VarA = ps3.a(ps3VarC, R.id.state_temp);
        ps3VarA.e(f2);
        ps3VarA.f(f4);
        this.c.setTag(R.id.state_temp, ps3VarA);
        e(this.c, ps3VarA);
        d(ViewCompat.MEASURED_STATE_MASK);
    }

    public boolean l() {
        return false;
    }

    public void m(MotionEvent motionEvent) {
        int i = this.h;
        if (i == 3) {
            i();
            return;
        }
        if (i == 5 || i == 6) {
            k();
        } else if (i == 2) {
            g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.p = null;
        ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.o = null;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.h = 1;
        ps3.j(this.c, R.id.state_touch_down);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        onTouchEvent(motionEvent);
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) getChildAt(0);
            this.c = relativeLayout;
            if (relativeLayout != null) {
                ps3.j(relativeLayout, R.id.state_default);
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x = motionEvent != null ? motionEvent2.getX() - motionEvent.getX() : 0.0f;
        float y = motionEvent != null ? motionEvent2.getY() - motionEvent.getY() : 0.0f;
        if (this.h == 1 && (Math.abs(x) > this.i || Math.abs(y) > this.i)) {
            ps3 ps3VarJ = ps3.j(this.c, R.id.state_current);
            ps3 ps3VarC = ps3.c(this.c, R.id.state_default);
            if (ps3VarC == null) {
                this.h = 4;
            } else if (ps3VarJ.g > ps3VarC.g || ps3VarJ.f > ps3VarC.f) {
                if (this.h != 2) {
                    ps3.j(this.c, R.id.state_touch_drag);
                }
                this.h = 2;
                String str = (String) this.c.getTag(R.id.image_orientation);
                if ("horizontal".equals(str)) {
                    float f4 = (ps3VarC.b * (ps3VarJ.f - 1.0f)) / 2.0f;
                    float f5 = ps3VarJ.d;
                    if (f5 >= f4 && x > 0.0f) {
                        this.h = 4;
                    } else if (f5 <= (-f4) && x < 0.0f) {
                        this.h = 4;
                    }
                } else if ("vertical".equals(str)) {
                    int i = ps3VarC.b;
                    float f6 = ps3VarJ.f;
                    float f7 = i * f6;
                    int i2 = this.e;
                    if (f7 > i2) {
                        float f8 = ((i * f6) / 2.0f) - (i / 2);
                        float f9 = (i2 - ((i * f6) / 2.0f)) - (i / 2);
                        float f10 = ps3VarJ.d;
                        if (f10 >= f8 && x > 0.0f) {
                            this.h = 4;
                        } else if (f10 <= f9 && x < 0.0f) {
                            this.h = 4;
                        }
                    } else if (Math.abs(x) > Math.abs(y)) {
                        this.h = 4;
                    }
                }
            } else {
                float fAbs = Math.abs(x);
                float f11 = this.i;
                if (fAbs < f11 && y > f11 * 3.0f) {
                    this.h = 3;
                } else if (Math.abs(x) > this.i) {
                    this.h = 4;
                }
            }
        }
        int i3 = this.h;
        if (i3 == 4) {
            return false;
        }
        if (i3 == 5) {
            j(motionEvent2);
            return false;
        }
        if (i3 == 3) {
            h(motionEvent2, motionEvent);
            return false;
        }
        if (i3 != 2) {
            return false;
        }
        f(motionEvent2, motionEvent);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = i;
        this.f = i2;
        this.a = i / 2;
        this.b = i2 / 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null || this.q) {
            return true;
        }
        ps3 ps3VarC = ps3.c(relativeLayout, R.id.state_default);
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            m(motionEvent);
        } else if (action != 5) {
            if (action == 6 && ps3VarC != null && this.h != 4 && motionEvent.getPointerCount() - 1 < 2) {
                this.h = 6;
            }
        } else if ((ps3VarC != null && this.h != 4) || this.t == 0) {
            if (this.h != 5) {
                this.j = 0.0f;
                this.k = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                this.l = 0.0f;
                this.m = 0.0f;
                ps3.j(this.c, R.id.state_touch_scale_rotate);
            }
            this.h = 5;
        }
        return this.r.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.g = i;
        super.setBackgroundColor(i);
    }

    public void setGesListener(e eVar) {
        this.y = eVar;
    }

    public GesLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.h = 0;
        this.v = new a();
        this.w = new b(this);
        this.x = 0;
        new f(this);
        this.r = new GestureDetector(context, this);
        this.i = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}

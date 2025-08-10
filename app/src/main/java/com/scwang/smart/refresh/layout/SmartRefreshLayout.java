package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper;
import com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper;
import dc.ae1;
import dc.be1;
import dc.ce1;
import dc.de1;
import dc.ee1;
import dc.fe1;
import dc.ge1;
import dc.ie1;
import dc.je1;
import dc.ke1;
import dc.le1;
import dc.me1;
import dc.ne1;
import dc.pe1;
import dc.se1;
import dc.te1;
import dc.vd1;
import dc.wd1;
import dc.xd1;
import dc.yd1;
import dc.zd1;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes3.dex */
public class SmartRefreshLayout extends ViewGroup implements ae1, NestedScrollingParent {
    public static ie1 R0;
    public static je1 S0;
    public static ke1 T0;
    public static ViewGroup.MarginLayoutParams U0 = new ViewGroup.MarginLayoutParams(-1, -1);
    public int[] A;
    public wd1 A0;
    public boolean B;
    public Paint B0;
    public boolean C;
    public Handler C0;
    public boolean D;
    public zd1 D0;
    public boolean E;
    public ce1 E0;
    public boolean F;
    public ce1 F0;
    public boolean G;
    public long G0;
    public int H0;
    public int I0;
    public boolean J0;
    public boolean K;
    public boolean K0;
    public boolean L;
    public boolean L0;
    public boolean M;
    public boolean M0;
    public boolean N;
    public boolean N0;
    public boolean O;
    public MotionEvent O0;
    public boolean P;
    public Runnable P0;
    public boolean Q;
    public ValueAnimator Q0;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int a;
    public boolean a0;
    public int b;
    public boolean b0;
    public int c;
    public boolean c0;
    public int d;
    public boolean d0;
    public int e;
    public ne1 e0;
    public int f;
    public le1 f0;
    public int g;
    public me1 g0;
    public float h;
    public pe1 h0;
    public float i;
    public int i0;
    public float j;
    public boolean j0;
    public float k;
    public int[] k0;
    public float l;
    public NestedScrollingChildHelper l0;
    public char m;
    public NestedScrollingParentHelper m0;
    public boolean n;
    public int n0;
    public boolean o;
    public be1 o0;
    public boolean p;
    public int p0;
    public int q;
    public be1 q0;
    public int r;
    public int r0;
    public int s;
    public int s0;
    public int t;
    public float t0;
    public int u;
    public float u0;
    public int v;
    public float v0;
    public int w;
    public float w0;
    public Scroller x;
    public float x0;
    public VelocityTracker y;
    public vd1 y0;
    public Interpolator z;
    public vd1 z0;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ce1.values().length];
            a = iArr;
            try {
                iArr[ce1.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ce1.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ce1.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ce1.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ce1.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ce1.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ce1.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ce1.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ce1.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ce1.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ce1.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ce1.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.setStateDirectLoading(this.a);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.G0 = System.currentTimeMillis();
                SmartRefreshLayout.this.A(ce1.Refreshing);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ne1 ne1Var = smartRefreshLayout.e0;
                if (ne1Var != null) {
                    if (this.a) {
                        ne1Var.b(smartRefreshLayout);
                    }
                } else if (smartRefreshLayout.g0 == null) {
                    smartRefreshLayout.s(3000);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                vd1 vd1Var = smartRefreshLayout2.y0;
                if (vd1Var != null) {
                    float f = smartRefreshLayout2.t0;
                    if (f < 10.0f) {
                        f *= smartRefreshLayout2.n0;
                    }
                    vd1Var.i(smartRefreshLayout2, smartRefreshLayout2.n0, (int) f);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                me1 me1Var = smartRefreshLayout3.g0;
                if (me1Var == null || !(smartRefreshLayout3.y0 instanceof yd1)) {
                    return;
                }
                if (this.a) {
                    me1Var.b(smartRefreshLayout3);
                }
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                float f2 = smartRefreshLayout4.t0;
                if (f2 < 10.0f) {
                    f2 *= smartRefreshLayout4.n0;
                }
                smartRefreshLayout4.g0.a((yd1) smartRefreshLayout4.y0, smartRefreshLayout4.n0, (int) f2);
            }
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ce1 ce1Var;
            ce1 ce1Var2;
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.Q0 = null;
                if (smartRefreshLayout.b == 0 && (ce1Var = smartRefreshLayout.E0) != (ce1Var2 = ce1.None) && !ce1Var.isOpening && !ce1Var.isDragging) {
                    smartRefreshLayout.A(ce1Var2);
                    return;
                }
                ce1 ce1Var3 = smartRefreshLayout.E0;
                if (ce1Var3 != smartRefreshLayout.F0) {
                    smartRefreshLayout.setViceState(ce1Var3);
                }
            }
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.D0.c(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            le1 le1Var = smartRefreshLayout.f0;
            if (le1Var != null) {
                le1Var.f(smartRefreshLayout);
            } else if (smartRefreshLayout.g0 == null) {
                smartRefreshLayout.n(2000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            me1 me1Var = smartRefreshLayout2.g0;
            if (me1Var != null) {
                me1Var.f(smartRefreshLayout2);
            }
        }
    }

    public class g implements Runnable {
        public int a = 0;
        public final /* synthetic */ int b;
        public final /* synthetic */ Boolean c;
        public final /* synthetic */ boolean d;

        public g(int i, Boolean bool, boolean z) {
            this.b = i;
            this.c = bool;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ce1 ce1Var = smartRefreshLayout.E0;
                ce1 ce1Var2 = ce1.None;
                if (ce1Var == ce1Var2 && smartRefreshLayout.F0 == ce1.Refreshing) {
                    smartRefreshLayout.F0 = ce1Var2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.Q0;
                    if (valueAnimator != null && ce1Var.isHeader && (ce1Var.isDragging || ce1Var == ce1.RefreshReleased)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.Q0.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.Q0 = null;
                        if (smartRefreshLayout2.D0.b(0) == null) {
                            SmartRefreshLayout.this.A(ce1Var2);
                        } else {
                            SmartRefreshLayout.this.A(ce1.PullDownCanceled);
                        }
                    } else if (ce1Var == ce1.Refreshing && smartRefreshLayout.y0 != null && smartRefreshLayout.A0 != null) {
                        this.a = i + 1;
                        smartRefreshLayout.C0.postDelayed(this, this.b);
                        SmartRefreshLayout.this.A(ce1.RefreshFinish);
                        if (this.c == Boolean.FALSE) {
                            SmartRefreshLayout.this.E(false);
                        }
                    }
                }
                if (this.c == Boolean.TRUE) {
                    SmartRefreshLayout.this.E(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int iF = smartRefreshLayout3.y0.f(smartRefreshLayout3, this.d);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            me1 me1Var = smartRefreshLayout4.g0;
            if (me1Var != null) {
                vd1 vd1Var = smartRefreshLayout4.y0;
                if (vd1Var instanceof yd1) {
                    me1Var.n((yd1) vd1Var, this.d);
                }
            }
            if (iF < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                if (smartRefreshLayout5.n || smartRefreshLayout5.j0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.n) {
                        float f = smartRefreshLayout6.k;
                        smartRefreshLayout6.i = f;
                        smartRefreshLayout6.d = 0;
                        smartRefreshLayout6.n = false;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout6.j, (f + smartRefreshLayout6.b) - (smartRefreshLayout6.a * 2), 0));
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout7.j, smartRefreshLayout7.k + smartRefreshLayout7.b, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.j0) {
                        smartRefreshLayout8.i0 = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout8.j, smartRefreshLayout8.k, 0));
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        smartRefreshLayout9.j0 = false;
                        smartRefreshLayout9.d = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout10.b;
                if (i2 <= 0) {
                    if (i2 < 0) {
                        smartRefreshLayout10.h(0, iF, smartRefreshLayout10.z, smartRefreshLayout10.f);
                        return;
                    } else {
                        smartRefreshLayout10.D0.c(0, false);
                        SmartRefreshLayout.this.D0.f(ce1.None);
                        return;
                    }
                }
                ValueAnimator valueAnimatorH = smartRefreshLayout10.h(0, iF, smartRefreshLayout10.z, smartRefreshLayout10.f);
                SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerE = smartRefreshLayout11.R ? smartRefreshLayout11.A0.e(smartRefreshLayout11.b) : null;
                if (valueAnimatorH == null || animatorUpdateListenerE == null) {
                    return;
                }
                valueAnimatorH.addUpdateListener(animatorUpdateListenerE);
            }
        }
    }

    public class h implements Runnable {
        public int a = 0;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public class a implements Runnable {
            public final /* synthetic */ int a;

            /* renamed from: com.scwang.smart.refresh.layout.SmartRefreshLayout$h$a$a, reason: collision with other inner class name */
            public class C0065a extends AnimatorListenerAdapter {
                public C0065a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator == null || animator.getDuration() != 0) {
                        h hVar = h.this;
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.M0 = false;
                        if (hVar.c) {
                            smartRefreshLayout.E(true);
                        }
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        if (smartRefreshLayout2.E0 == ce1.LoadFinish) {
                            smartRefreshLayout2.A(ce1.None);
                        }
                    }
                }
            }

            public a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerE;
                ValueAnimator valueAnimatorB;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.Q || this.a >= 0) {
                    animatorUpdateListenerE = null;
                } else {
                    animatorUpdateListenerE = smartRefreshLayout.A0.e(smartRefreshLayout.b);
                    if (animatorUpdateListenerE != null) {
                        animatorUpdateListenerE.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                C0065a c0065a = new C0065a();
                h hVar = h.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i = smartRefreshLayout2.b;
                if (i > 0) {
                    valueAnimatorB = smartRefreshLayout2.D0.b(0);
                } else {
                    if (animatorUpdateListenerE != null || i == 0) {
                        ValueAnimator valueAnimator = smartRefreshLayout2.Q0;
                        if (valueAnimator != null) {
                            valueAnimator.setDuration(0L);
                            SmartRefreshLayout.this.Q0.cancel();
                            SmartRefreshLayout.this.Q0 = null;
                        }
                        SmartRefreshLayout.this.D0.c(0, false);
                        SmartRefreshLayout.this.D0.f(ce1.None);
                    } else if (hVar.c && smartRefreshLayout2.K) {
                        int i2 = smartRefreshLayout2.p0;
                        if (i >= (-i2)) {
                            smartRefreshLayout2.A(ce1.None);
                        } else {
                            valueAnimatorB = smartRefreshLayout2.D0.b(-i2);
                        }
                    } else {
                        valueAnimatorB = smartRefreshLayout2.D0.b(0);
                    }
                    valueAnimatorB = null;
                }
                if (valueAnimatorB != null) {
                    valueAnimatorB.addListener(c0065a);
                } else {
                    c0065a.onAnimationEnd(null);
                }
            }
        }

        public h(int i, boolean z, boolean z2) {
            this.b = i;
            this.c = z;
            this.d = z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 327
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.h.run():void");
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.Q0 == null || smartRefreshLayout.y0 == null) {
                    return;
                }
                smartRefreshLayout.D0.c(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.Q0 = null;
                    if (smartRefreshLayout.y0 == null) {
                        smartRefreshLayout.D0.f(ce1.None);
                        return;
                    }
                    ce1 ce1Var = smartRefreshLayout.E0;
                    ce1 ce1Var2 = ce1.ReleaseToRefresh;
                    if (ce1Var != ce1Var2) {
                        smartRefreshLayout.D0.f(ce1Var2);
                    }
                    SmartRefreshLayout.this.setStateRefreshing(!r5.c);
                }
            }
        }

        public i(float f, int i, boolean z) {
            this.a = f;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.F0 != ce1.Refreshing) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.Q0;
            if (valueAnimator != null) {
                valueAnimator.setDuration(0L);
                SmartRefreshLayout.this.Q0.cancel();
                SmartRefreshLayout.this.Q0 = null;
            }
            SmartRefreshLayout.this.j = r0.getMeasuredWidth() / 2.0f;
            SmartRefreshLayout.this.D0.f(ce1.PullDownToRefresh);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i = smartRefreshLayout2.n0;
            float f = i == 0 ? smartRefreshLayout2.v0 : i;
            float f2 = this.a;
            if (f2 < 10.0f) {
                f2 *= f;
            }
            smartRefreshLayout2.Q0 = ValueAnimator.ofInt(smartRefreshLayout2.b, (int) f2);
            SmartRefreshLayout.this.Q0.setDuration(this.b);
            SmartRefreshLayout.this.Q0.setInterpolator(new se1(se1.b));
            SmartRefreshLayout.this.Q0.addUpdateListener(new a());
            SmartRefreshLayout.this.Q0.addListener(new b());
            SmartRefreshLayout.this.Q0.start();
        }
    }

    public class j implements Runnable {
        public int c;
        public float f;
        public int a = 0;
        public int b = 10;
        public float e = 0.0f;
        public long d = AnimationUtils.currentAnimationTimeMillis();

        public j(float f, int i) {
            this.f = f;
            this.c = i;
            SmartRefreshLayout.this.C0.postDelayed(this, this.b);
            if (f > 0.0f) {
                SmartRefreshLayout.this.D0.f(ce1.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.D0.f(ce1.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.P0 != this || smartRefreshLayout.E0.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.b) < Math.abs(this.c)) {
                double d = this.f;
                this.a = this.a + 1;
                this.f = (float) (d * Math.pow(0.949999988079071d, r4 * 2));
            } else if (this.c != 0) {
                double d2 = this.f;
                this.a = this.a + 1;
                this.f = (float) (d2 * Math.pow(0.44999998807907104d, r4 * 2));
            } else {
                double d3 = this.f;
                this.a = this.a + 1;
                this.f = (float) (d3 * Math.pow(0.8500000238418579d, r4 * 2));
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f = this.f * (((jCurrentAnimationTimeMillis - this.d) * 1.0f) / 1000.0f);
            if (Math.abs(f) >= 1.0f) {
                this.d = jCurrentAnimationTimeMillis;
                float f2 = this.e + f;
                this.e = f2;
                SmartRefreshLayout.this.z(f2);
                SmartRefreshLayout.this.C0.postDelayed(this, this.b);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            ce1 ce1Var = smartRefreshLayout2.F0;
            boolean z = ce1Var.isDragging;
            if (z && ce1Var.isHeader) {
                smartRefreshLayout2.D0.f(ce1.PullDownCanceled);
            } else if (z && ce1Var.isFooter) {
                smartRefreshLayout2.D0.f(ce1.PullUpCanceled);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.P0 = null;
            if (Math.abs(smartRefreshLayout3.b) >= Math.abs(this.c)) {
                int iMin = Math.min(Math.max((int) se1.i(Math.abs(SmartRefreshLayout.this.b - this.c)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.h(this.c, 0, smartRefreshLayout4.z, iMin);
            }
        }
    }

    public class k implements Runnable {
        public int a;
        public float c;
        public int b = 10;
        public float d = 0.98f;
        public long e = 0;
        public long f = AnimationUtils.currentAnimationTimeMillis();

        public k(float f) {
            this.c = f;
            this.a = SmartRefreshLayout.this.b;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable a() {
            /*
                r11 = this;
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                dc.ce1 r1 = r0.E0
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto La
                return r3
            La:
                int r2 = r0.b
                if (r2 == 0) goto Lab
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L26
                boolean r1 = r0.W
                if (r1 == 0) goto L59
                boolean r1 = r0.K
                if (r1 == 0) goto L59
                boolean r1 = r0.a0
                if (r1 == 0) goto L59
                boolean r1 = r0.C
                boolean r0 = r0.x(r1)
                if (r0 == 0) goto L59
            L26:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                dc.ce1 r1 = r0.E0
                dc.ce1 r2 = dc.ce1.Loading
                if (r1 == r2) goto L42
                boolean r1 = r0.W
                if (r1 == 0) goto L4b
                boolean r1 = r0.K
                if (r1 == 0) goto L4b
                boolean r1 = r0.a0
                if (r1 == 0) goto L4b
                boolean r1 = r0.C
                boolean r0 = r0.x(r1)
                if (r0 == 0) goto L4b
            L42:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r1 = r0.b
                int r0 = r0.p0
                int r0 = -r0
                if (r1 < r0) goto L59
            L4b:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                dc.ce1 r1 = r0.E0
                dc.ce1 r2 = dc.ce1.Refreshing
                if (r1 != r2) goto Lab
                int r1 = r0.b
                int r0 = r0.n0
                if (r1 <= r0) goto Lab
            L59:
                r0 = 0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r1 = r1.b
                float r2 = r11.c
                r4 = r1
            L61:
                int r5 = r1 * r4
                if (r5 <= 0) goto Lab
                double r5 = (double) r2
                float r2 = r11.d
                double r7 = (double) r2
                int r0 = r0 + 1
                int r2 = r11.b
                int r2 = r2 * r0
                float r2 = (float) r2
                r9 = 1092616192(0x41200000, float:10.0)
                float r2 = r2 / r9
                double r9 = (double) r2
                double r7 = java.lang.Math.pow(r7, r9)
                double r5 = r5 * r7
                float r2 = (float) r5
                int r5 = r11.b
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r2
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto La7
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                dc.ce1 r1 = r0.E0
                boolean r2 = r1.isOpening
                if (r2 == 0) goto La6
                dc.ce1 r2 = dc.ce1.Refreshing
                if (r1 != r2) goto L9f
                int r5 = r0.n0
                if (r4 > r5) goto La6
            L9f:
                if (r1 == r2) goto Lab
                int r0 = r0.p0
                int r0 = -r0
                if (r4 >= r0) goto Lab
            La6:
                return r3
            La7:
                float r4 = (float) r4
                float r4 = r4 + r5
                int r4 = (int) r4
                goto L61
            Lab:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r11.e = r0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.C0
                int r1 = r11.b
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.k.a():java.lang.Runnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.P0 != this || smartRefreshLayout.E0.isFinishing) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j = jCurrentAnimationTimeMillis - this.f;
            float fPow = (float) (this.c * Math.pow(this.d, (jCurrentAnimationTimeMillis - this.e) / (1000.0f / this.b)));
            this.c = fPow;
            float f = fPow * ((j * 1.0f) / 1000.0f);
            if (Math.abs(f) <= 1.0f) {
                SmartRefreshLayout.this.P0 = null;
                return;
            }
            this.f = jCurrentAnimationTimeMillis;
            int i = (int) (this.a + f);
            this.a = i;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.b * i > 0) {
                smartRefreshLayout2.D0.c(i, true);
                SmartRefreshLayout.this.C0.postDelayed(this, this.b);
                return;
            }
            smartRefreshLayout2.P0 = null;
            smartRefreshLayout2.D0.c(0, true);
            se1.d(SmartRefreshLayout.this.A0.f(), (int) (-this.c));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.M0 || f <= 0.0f) {
                return;
            }
            smartRefreshLayout3.M0 = false;
        }
    }

    public class l implements zd1 {
        public l() {
        }

        @Override // dc.zd1
        public zd1 a() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.E0 == ce1.TwoLevel) {
                smartRefreshLayout.D0.f(ce1.TwoLevelFinish);
                if (SmartRefreshLayout.this.b == 0) {
                    c(0, false);
                    SmartRefreshLayout.this.A(ce1.None);
                } else {
                    b(0).setDuration(SmartRefreshLayout.this.e);
                }
            }
            return this;
        }

        @Override // dc.zd1
        public ValueAnimator b(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.h(i, 0, smartRefreshLayout.z, smartRefreshLayout.f);
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00ba  */
        @Override // dc.zd1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public dc.zd1 c(int r19, boolean r20) {
            /*
                Method dump skipped, instructions count: 921
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.l.c(int, boolean):dc.zd1");
        }

        @Override // dc.zd1
        @NonNull
        public ae1 d() {
            return SmartRefreshLayout.this;
        }

        @Override // dc.zd1
        public zd1 e(@NonNull vd1 vd1Var, int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.B0 == null && i != 0) {
                smartRefreshLayout.B0 = new Paint();
            }
            if (vd1Var.equals(SmartRefreshLayout.this.y0)) {
                SmartRefreshLayout.this.H0 = i;
            } else if (vd1Var.equals(SmartRefreshLayout.this.z0)) {
                SmartRefreshLayout.this.I0 = i;
            }
            return this;
        }

        @Override // dc.zd1
        public zd1 f(@NonNull ce1 ce1Var) {
            switch (a.a[ce1Var.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    ce1 ce1Var2 = smartRefreshLayout.E0;
                    ce1 ce1Var3 = ce1.None;
                    if (ce1Var2 != ce1Var3 && smartRefreshLayout.b == 0) {
                        smartRefreshLayout.A(ce1Var3);
                        break;
                    } else if (smartRefreshLayout.b != 0) {
                        b(0);
                        break;
                    }
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.E0.isOpening && smartRefreshLayout2.x(smartRefreshLayout2.B)) {
                        SmartRefreshLayout.this.A(ce1.PullDownToRefresh);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(ce1.PullDownToRefresh);
                        break;
                    }
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.x(smartRefreshLayout3.C)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        ce1 ce1Var4 = smartRefreshLayout4.E0;
                        if (!ce1Var4.isOpening && !ce1Var4.isFinishing && (!smartRefreshLayout4.W || !smartRefreshLayout4.K || !smartRefreshLayout4.a0)) {
                            smartRefreshLayout4.A(ce1.PullUpToLoad);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(ce1.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.E0.isOpening && smartRefreshLayout5.x(smartRefreshLayout5.B)) {
                        SmartRefreshLayout.this.A(ce1.PullDownCanceled);
                        f(ce1.None);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(ce1.PullDownCanceled);
                        break;
                    }
                    break;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.x(smartRefreshLayout6.C)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.E0.isOpening && (!smartRefreshLayout7.W || !smartRefreshLayout7.K || !smartRefreshLayout7.a0)) {
                            smartRefreshLayout7.A(ce1.PullUpCanceled);
                            f(ce1.None);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(ce1.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.E0.isOpening && smartRefreshLayout8.x(smartRefreshLayout8.B)) {
                        SmartRefreshLayout.this.A(ce1.ReleaseToRefresh);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(ce1.ReleaseToRefresh);
                        break;
                    }
                    break;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.x(smartRefreshLayout9.C)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        ce1 ce1Var5 = smartRefreshLayout10.E0;
                        if (!ce1Var5.isOpening && !ce1Var5.isFinishing && (!smartRefreshLayout10.W || !smartRefreshLayout10.K || !smartRefreshLayout10.a0)) {
                            smartRefreshLayout10.A(ce1.ReleaseToLoad);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(ce1.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.E0.isOpening && smartRefreshLayout11.x(smartRefreshLayout11.B)) {
                        SmartRefreshLayout.this.A(ce1.ReleaseToTwoLevel);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(ce1.ReleaseToTwoLevel);
                        break;
                    }
                    break;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.E0.isOpening && smartRefreshLayout12.x(smartRefreshLayout12.B)) {
                        SmartRefreshLayout.this.A(ce1.RefreshReleased);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(ce1.RefreshReleased);
                        break;
                    }
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.E0.isOpening && smartRefreshLayout13.x(smartRefreshLayout13.C)) {
                        SmartRefreshLayout.this.A(ce1.LoadReleased);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(ce1.LoadReleased);
                        break;
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    break;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    break;
                default:
                    SmartRefreshLayout.this.A(ce1Var);
                    break;
            }
            return null;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull ie1 ie1Var) {
        R0 = ie1Var;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull je1 je1Var) {
        S0 = je1Var;
    }

    public static void setDefaultRefreshInitializer(@NonNull ke1 ke1Var) {
        T0 = ke1Var;
    }

    public void A(ce1 ce1Var) {
        ce1 ce1Var2 = this.E0;
        if (ce1Var2 == ce1Var) {
            if (this.F0 != ce1Var2) {
                this.F0 = ce1Var2;
                return;
            }
            return;
        }
        this.E0 = ce1Var;
        this.F0 = ce1Var;
        vd1 vd1Var = this.y0;
        vd1 vd1Var2 = this.z0;
        me1 me1Var = this.g0;
        if (vd1Var != null) {
            vd1Var.h(this, ce1Var2, ce1Var);
        }
        if (vd1Var2 != null) {
            vd1Var2.h(this, ce1Var2, ce1Var);
        }
        if (me1Var != null) {
            me1Var.h(this, ce1Var2, ce1Var);
        }
        if (ce1Var == ce1.LoadFinish) {
            this.M0 = false;
        }
    }

    public void B() {
        ce1 ce1Var = this.E0;
        if (ce1Var == ce1.TwoLevel) {
            if (this.w <= -1000 || this.b <= getHeight() / 2) {
                if (this.n) {
                    this.D0.a();
                    return;
                }
                return;
            } else {
                ValueAnimator valueAnimatorB = this.D0.b(getHeight());
                if (valueAnimatorB != null) {
                    valueAnimatorB.setDuration(this.e);
                    return;
                }
                return;
            }
        }
        ce1 ce1Var2 = ce1.Loading;
        if (ce1Var == ce1Var2 || (this.K && this.W && this.a0 && this.b < 0 && x(this.C))) {
            int i2 = this.b;
            int i3 = this.p0;
            if (i2 < (-i3)) {
                this.D0.b(-i3);
                return;
            } else {
                if (i2 > 0) {
                    this.D0.b(0);
                    return;
                }
                return;
            }
        }
        ce1 ce1Var3 = this.E0;
        ce1 ce1Var4 = ce1.Refreshing;
        if (ce1Var3 == ce1Var4) {
            int i4 = this.b;
            int i5 = this.n0;
            if (i4 > i5) {
                this.D0.b(i5);
                return;
            } else {
                if (i4 < 0) {
                    this.D0.b(0);
                    return;
                }
                return;
            }
        }
        if (ce1Var3 == ce1.PullDownToRefresh) {
            this.D0.f(ce1.PullDownCanceled);
            return;
        }
        if (ce1Var3 == ce1.PullUpToLoad) {
            this.D0.f(ce1.PullUpCanceled);
            return;
        }
        if (ce1Var3 == ce1.ReleaseToRefresh) {
            this.D0.f(ce1Var4);
            return;
        }
        if (ce1Var3 == ce1.ReleaseToLoad) {
            this.D0.f(ce1Var2);
            return;
        }
        if (ce1Var3 == ce1.ReleaseToTwoLevel) {
            this.D0.f(ce1.TwoLevelReleased);
            return;
        }
        if (ce1Var3 == ce1.RefreshReleased) {
            if (this.Q0 == null) {
                this.D0.b(this.n0);
            }
        } else if (ce1Var3 == ce1.LoadReleased) {
            if (this.Q0 == null) {
                this.D0.b(-this.p0);
            }
        } else {
            if (ce1Var3 == ce1.LoadFinish || this.b == 0) {
                return;
            }
            this.D0.b(0);
        }
    }

    public ae1 C(boolean z) {
        this.b0 = true;
        this.C = z;
        return this;
    }

    public ae1 D(boolean z) {
        this.B = z;
        return this;
    }

    public ae1 E(boolean z) {
        ce1 ce1Var = this.E0;
        if (ce1Var == ce1.Refreshing && z) {
            v();
        } else if (ce1Var == ce1.Loading && z) {
            q();
        } else if (this.W != z) {
            this.W = z;
            vd1 vd1Var = this.z0;
            if (vd1Var instanceof xd1) {
                if (((xd1) vd1Var).b(z)) {
                    this.a0 = true;
                    if (this.W && this.K && this.b > 0 && this.z0.getSpinnerStyle() == de1.d && x(this.C) && y(this.B, this.y0)) {
                        this.z0.getView().setTranslationY(this.b);
                    }
                } else {
                    this.a0 = false;
                    new RuntimeException("Footer:" + this.z0 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    public ae1 F(le1 le1Var) {
        this.f0 = le1Var;
        this.C = this.C || !(this.b0 || le1Var == null);
        return this;
    }

    public ae1 G(ne1 ne1Var) {
        this.e0 = ne1Var;
        return this;
    }

    public ae1 H(@NonNull xd1 xd1Var) {
        I(xd1Var, 0, 0);
        return this;
    }

    public ae1 I(@NonNull xd1 xd1Var, int i2, int i3) {
        vd1 vd1Var;
        vd1 vd1Var2 = this.z0;
        if (vd1Var2 != null) {
            super.removeView(vd1Var2.getView());
        }
        this.z0 = xd1Var;
        this.M0 = false;
        this.I0 = 0;
        this.a0 = false;
        this.K0 = false;
        this.q0 = be1.c;
        this.C = !this.b0 || this.C;
        if (i2 == 0) {
            i2 = -1;
        }
        if (i3 == 0) {
            i3 = -2;
        }
        LayoutParams layoutParams = new LayoutParams(i2, i3);
        ViewGroup.LayoutParams layoutParams2 = xd1Var.getView().getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        if (this.z0.getSpinnerStyle().b) {
            super.addView(this.z0.getView(), getChildCount(), layoutParams);
        } else {
            super.addView(this.z0.getView(), 0, layoutParams);
        }
        int[] iArr = this.A;
        if (iArr != null && (vd1Var = this.z0) != null) {
            vd1Var.setPrimaryColors(iArr);
        }
        return this;
    }

    public ae1 J(@NonNull yd1 yd1Var) {
        K(yd1Var, 0, 0);
        return this;
    }

    public ae1 K(@NonNull yd1 yd1Var, int i2, int i3) {
        vd1 vd1Var;
        vd1 vd1Var2 = this.y0;
        if (vd1Var2 != null) {
            super.removeView(vd1Var2.getView());
        }
        this.y0 = yd1Var;
        this.H0 = 0;
        this.J0 = false;
        this.o0 = be1.c;
        if (i2 == 0) {
            i2 = -1;
        }
        if (i3 == 0) {
            i3 = -2;
        }
        LayoutParams layoutParams = new LayoutParams(i2, i3);
        ViewGroup.LayoutParams layoutParams2 = yd1Var.getView().getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        if (this.y0.getSpinnerStyle().b) {
            super.addView(this.y0.getView(), getChildCount(), layoutParams);
        } else {
            super.addView(this.y0.getView(), 0, layoutParams);
        }
        int[] iArr = this.A;
        if (iArr != null && (vd1Var = this.y0) != null) {
            vd1Var.setPrimaryColors(iArr);
        }
        return this;
    }

    public boolean L(float f2) {
        if (f2 == 0.0f) {
            f2 = this.w;
        }
        if (Math.abs(f2) > this.u) {
            int i2 = this.b;
            if (i2 * f2 < 0.0f) {
                ce1 ce1Var = this.E0;
                if (ce1Var == ce1.Refreshing || ce1Var == ce1.Loading || (i2 < 0 && this.W)) {
                    this.P0 = new k(f2).a();
                    return true;
                }
                if (ce1Var.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f2 < 0.0f && ((this.M && (this.C || this.N)) || ((this.E0 == ce1.Loading && i2 >= 0) || (this.O && x(this.C))))) || (f2 > 0.0f && ((this.M && this.B) || this.N || (this.E0 == ce1.Refreshing && this.b <= 0)))) {
                this.N0 = false;
                this.x.fling(0, 0, 0, (int) (-f2), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.x.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    @Override // dc.ae1
    public ae1 a(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.x.getCurrY();
        if (this.x.computeScrollOffset()) {
            int finalY = this.x.getFinalY();
            if ((finalY >= 0 || !((this.B || this.N) && this.A0.g())) && (finalY <= 0 || !((this.C || this.N) && this.A0.i()))) {
                this.N0 = true;
                invalidate();
            } else {
                if (this.N0) {
                    i(finalY > 0 ? -this.x.getCurrVelocity() : this.x.getCurrVelocity());
                }
                this.x.forceFinished(true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00dc, code lost:
    
        if (r2.isFooter == false) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 868
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        Paint paint;
        Paint paint2;
        wd1 wd1Var = this.A0;
        View view2 = wd1Var != null ? wd1Var.getView() : null;
        vd1 vd1Var = this.y0;
        if (vd1Var != null && vd1Var.getView() == view) {
            if (!x(this.B) || (!this.L && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getTop() + view2.getPaddingTop() + this.b, view.getTop());
                int i2 = this.H0;
                if (i2 != 0 && (paint2 = this.B0) != null) {
                    paint2.setColor(i2);
                    if (this.y0.getSpinnerStyle().c) {
                        iMax = view.getBottom();
                    } else if (this.y0.getSpinnerStyle() == de1.d) {
                        iMax = view.getBottom() + this.b;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), iMax, this.B0);
                }
                if ((this.D && this.y0.getSpinnerStyle() == de1.f) || this.y0.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        vd1 vd1Var2 = this.z0;
        if (vd1Var2 != null && vd1Var2.getView() == view) {
            if (!x(this.C) || (!this.L && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.b, view.getBottom());
                int i3 = this.I0;
                if (i3 != 0 && (paint = this.B0) != null) {
                    paint.setColor(i3);
                    if (this.z0.getSpinnerStyle().c) {
                        iMin = view.getTop();
                    } else if (this.z0.getSpinnerStyle() == de1.d) {
                        iMin = view.getTop() + this.b;
                    }
                    canvas.drawRect(0.0f, iMin, getWidth(), view.getBottom(), this.B0);
                }
                if ((this.E && this.z0.getSpinnerStyle() == de1.f) || this.z0.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // dc.ae1
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.m0.getNestedScrollAxes();
    }

    @Nullable
    public xd1 getRefreshFooter() {
        vd1 vd1Var = this.z0;
        if (vd1Var instanceof xd1) {
            return (xd1) vd1Var;
        }
        return null;
    }

    @Nullable
    public yd1 getRefreshHeader() {
        vd1 vd1Var = this.y0;
        if (vd1Var instanceof yd1) {
            return (yd1) vd1Var;
        }
        return null;
    }

    @NonNull
    public ce1 getState() {
        return this.E0;
    }

    public ValueAnimator h(int i2, int i3, Interpolator interpolator, int i4) {
        if (this.b == i2) {
            return null;
        }
        ValueAnimator valueAnimator = this.Q0;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.Q0.cancel();
            this.Q0 = null;
        }
        this.P0 = null;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.b, i2);
        this.Q0 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i4);
        this.Q0.setInterpolator(interpolator);
        this.Q0.addListener(new d());
        this.Q0.addUpdateListener(new e());
        this.Q0.setStartDelay(i3);
        this.Q0.start();
        return this.Q0;
    }

    public void i(float f2) {
        ce1 ce1Var;
        if (this.Q0 == null) {
            if (f2 > 0.0f && ((ce1Var = this.E0) == ce1.Refreshing || ce1Var == ce1.TwoLevel)) {
                this.P0 = new j(f2, this.n0);
                return;
            }
            if (f2 < 0.0f && (this.E0 == ce1.Loading || ((this.K && this.W && this.a0 && x(this.C)) || (this.O && !this.W && x(this.C) && this.E0 != ce1.Refreshing)))) {
                this.P0 = new j(f2, -this.p0);
            } else if (this.b == 0 && this.M) {
                this.P0 = new j(f2, 0);
            }
        }
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.T && (this.N || this.B || this.C);
    }

    public boolean j() {
        return k(this.L0 ? 0 : 400, this.f, (this.t0 + this.v0) / 2.0f, false);
    }

    public boolean k(int i2, int i3, float f2, boolean z) {
        if (this.E0 != ce1.None || !x(this.B)) {
            return false;
        }
        i iVar = new i(f2, i3, z);
        setViceState(ce1.Refreshing);
        if (i2 > 0) {
            this.C0.postDelayed(iVar, i2);
            return true;
        }
        iVar.run();
        return true;
    }

    public ae1 l() {
        ce1 ce1Var;
        ce1 ce1Var2 = this.E0;
        ce1 ce1Var3 = ce1.None;
        if (ce1Var2 == ce1Var3 && ((ce1Var = this.F0) == ce1.Refreshing || ce1Var == ce1.Loading)) {
            this.F0 = ce1Var3;
        }
        if (ce1Var2 == ce1.Refreshing) {
            r();
        } else if (ce1Var2 == ce1.Loading) {
            m();
        } else if (this.D0.b(0) == null) {
            A(ce1Var3);
        } else if (this.E0.isHeader) {
            A(ce1.PullDownCanceled);
        } else {
            A(ce1.PullUpCanceled);
        }
        return this;
    }

    public ae1 m() {
        p(true);
        return this;
    }

    public ae1 n(int i2) {
        o(i2, true, false);
        return this;
    }

    public ae1 o(int i2, boolean z, boolean z2) {
        int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        h hVar = new h(i3, z2, z);
        if (i4 > 0) {
            this.C0.postDelayed(hVar, i4);
        } else {
            hVar.run();
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        vd1 vd1Var;
        je1 je1Var;
        super.onAttachedToWindow();
        boolean z = true;
        this.L0 = true;
        if (!isInEditMode()) {
            if (this.y0 == null && (je1Var = S0) != null) {
                yd1 yd1VarA = je1Var.a(getContext(), this);
                if (yd1VarA == null) {
                    throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
                }
                J(yd1VarA);
            }
            if (this.z0 == null) {
                ie1 ie1Var = R0;
                if (ie1Var != null) {
                    xd1 xd1VarA = ie1Var.a(getContext(), this);
                    if (xd1VarA == null) {
                        throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
                    }
                    H(xd1VarA);
                }
            } else {
                if (!this.C && this.b0) {
                    z = false;
                }
                this.C = z;
            }
            if (this.A0 == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    vd1 vd1Var2 = this.y0;
                    if ((vd1Var2 == null || childAt != vd1Var2.getView()) && ((vd1Var = this.z0) == null || childAt != vd1Var.getView())) {
                        this.A0 = new te1(childAt);
                    }
                }
            }
            if (this.A0 == null) {
                int iC = se1.c(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(fe1.srl_content_empty);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                te1 te1Var = new te1(textView);
                this.A0 = te1Var;
                te1Var.getView().setPadding(iC, iC, iC, iC);
            }
            View viewFindViewById = findViewById(this.q);
            View viewFindViewById2 = findViewById(this.r);
            this.A0.a(this.h0);
            this.A0.d(this.S);
            this.A0.c(this.D0, viewFindViewById, viewFindViewById2);
            if (this.b != 0) {
                A(ce1.None);
                wd1 wd1Var = this.A0;
                this.b = 0;
                wd1Var.h(0, this.s, this.t);
            }
        }
        int[] iArr = this.A;
        if (iArr != null) {
            vd1 vd1Var3 = this.y0;
            if (vd1Var3 != null) {
                vd1Var3.setPrimaryColors(iArr);
            }
            vd1 vd1Var4 = this.z0;
            if (vd1Var4 != null) {
                vd1Var4.setPrimaryColors(this.A);
            }
        }
        wd1 wd1Var2 = this.A0;
        if (wd1Var2 != null) {
            super.bringChildToFront(wd1Var2.getView());
        }
        vd1 vd1Var5 = this.y0;
        if (vd1Var5 != null && vd1Var5.getSpinnerStyle().b) {
            super.bringChildToFront(this.y0.getView());
        }
        vd1 vd1Var6 = this.z0;
        if (vd1Var6 == null || !vd1Var6.getSpinnerStyle().b) {
            return;
        }
        super.bringChildToFront(this.z0.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.L0 = false;
        this.b0 = true;
        this.P0 = null;
        ValueAnimator valueAnimator = this.Q0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.Q0.removeAllUpdateListeners();
            this.Q0.setDuration(0L);
            this.Q0.cancel();
            this.Q0 = null;
        }
        vd1 vd1Var = this.y0;
        if (vd1Var != null && this.E0 == ce1.Refreshing) {
            vd1Var.f(this, false);
        }
        vd1 vd1Var2 = this.z0;
        if (vd1Var2 != null && this.E0 == ce1.Loading) {
            vd1Var2.f(this, false);
        }
        if (this.b != 0) {
            this.D0.c(0, true);
        }
        ce1 ce1Var = this.E0;
        ce1 ce1Var2 = ce1.None;
        if (ce1Var != ce1Var2) {
            A(ce1Var2);
        }
        Handler handler = this.C0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.M0 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        int i2;
        int i3;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i4 = 0;
        int i5 = -1;
        char c2 = 0;
        while (true) {
            i2 = 2;
            if (i4 >= childCount) {
                break;
            }
            View childAt = super.getChildAt(i4);
            if (se1.e(childAt) && (c2 < 2 || i4 == 1)) {
                i5 = i4;
                c2 = 2;
            } else if (!(childAt instanceof vd1) && c2 < 1) {
                c2 = i4 > 0 ? (char) 1 : (char) 0;
                i5 = i4;
            }
            i4++;
        }
        if (i5 >= 0) {
            this.A0 = new te1(super.getChildAt(i5));
            if (i5 != 1) {
                if (childCount == 2) {
                    i3 = -1;
                    i2 = 1;
                }
                i3 = -1;
                i2 = -1;
            } else if (childCount == 3) {
                i3 = 0;
            } else {
                i3 = 0;
                i2 = -1;
            }
        } else {
            i3 = -1;
            i2 = -1;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = super.getChildAt(i6);
            if (i6 == i3 || (i6 != i2 && i3 == -1 && this.y0 == null && (childAt2 instanceof yd1))) {
                this.y0 = childAt2 instanceof yd1 ? (yd1) childAt2 : new RefreshHeaderWrapper(childAt2);
            } else if (i6 == i2 || (i2 == -1 && (childAt2 instanceof xd1))) {
                this.C = this.C || !this.b0;
                this.z0 = childAt2 instanceof xd1 ? (xd1) childAt2 : new RefreshFooterWrapper(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iMax;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(ee1.srl_tag))) {
                wd1 wd1Var = this.A0;
                if (wd1Var != null && wd1Var.getView() == childAt) {
                    boolean z2 = isInEditMode() && this.L && x(this.B) && this.y0 != null;
                    View view = this.A0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : U0;
                    int i7 = marginLayoutParams.leftMargin + paddingLeft;
                    int i8 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i7;
                    int measuredHeight = view.getMeasuredHeight() + i8;
                    if (z2 && y(this.F, this.y0)) {
                        int i9 = this.n0;
                        i8 += i9;
                        measuredHeight += i9;
                    }
                    view.layout(i7, i8, measuredWidth, measuredHeight);
                }
                vd1 vd1Var = this.y0;
                if (vd1Var != null && vd1Var.getView() == childAt) {
                    boolean z3 = isInEditMode() && this.L && x(this.B);
                    View view2 = this.y0.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : U0;
                    int i10 = marginLayoutParams2.leftMargin;
                    int i11 = marginLayoutParams2.topMargin + this.r0;
                    int measuredWidth2 = view2.getMeasuredWidth() + i10;
                    int measuredHeight2 = view2.getMeasuredHeight() + i11;
                    if (!z3 && this.y0.getSpinnerStyle() == de1.d) {
                        int i12 = this.n0;
                        i11 -= i12;
                        measuredHeight2 -= i12;
                    }
                    view2.layout(i10, i11, measuredWidth2, measuredHeight2);
                }
                vd1 vd1Var2 = this.z0;
                if (vd1Var2 != null && vd1Var2.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.L && x(this.C);
                    View view3 = this.z0.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : U0;
                    de1 spinnerStyle = this.z0.getSpinnerStyle();
                    int i13 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.s0;
                    if (this.W && this.a0 && this.K && this.A0 != null && this.z0.getSpinnerStyle() == de1.d && x(this.C)) {
                        View view4 = this.A0.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == de1.h) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.s0;
                    } else {
                        if (z4 || spinnerStyle == de1.g || spinnerStyle == de1.f) {
                            iMax = this.p0;
                        } else if (spinnerStyle.c && this.b < 0) {
                            iMax = Math.max(x(this.C) ? -this.b : 0, 0);
                        }
                        measuredHeight3 -= iMax;
                    }
                    view3.layout(i13, measuredHeight3, view3.getMeasuredWidth() + i13, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x025e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 859
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        return this.l0.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return (this.M0 && f3 > 0.0f) || L(-f3) || this.l0.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        int i4 = this.i0;
        int i5 = 0;
        if (i3 * i4 > 0) {
            if (Math.abs(i3) > Math.abs(this.i0)) {
                int i6 = this.i0;
                this.i0 = 0;
                i5 = i6;
            } else {
                this.i0 -= i3;
                i5 = i3;
            }
            z(this.i0);
        } else if (i3 > 0 && this.M0) {
            int i7 = i4 - i3;
            this.i0 = i7;
            z(i7);
            i5 = i3;
        }
        this.l0.dispatchNestedPreScroll(i2, i3 - i5, iArr, null);
        iArr[1] = iArr[1] + i5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        pe1 pe1Var;
        ViewParent parent;
        pe1 pe1Var2;
        boolean zDispatchNestedScroll = this.l0.dispatchNestedScroll(i2, i3, i4, i5, this.k0);
        int i6 = i5 + this.k0[1];
        if ((i6 < 0 && ((this.B || this.N) && (this.i0 != 0 || (pe1Var2 = this.h0) == null || pe1Var2.a(this.A0.getView())))) || (i6 > 0 && ((this.C || this.N) && (this.i0 != 0 || (pe1Var = this.h0) == null || pe1Var.b(this.A0.getView()))))) {
            ce1 ce1Var = this.F0;
            if (ce1Var == ce1.None || ce1Var.isOpening) {
                this.D0.f(i6 > 0 ? ce1.PullUpToLoad : ce1.PullDownToRefresh);
                if (!zDispatchNestedScroll && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i7 = this.i0 - i6;
            this.i0 = i7;
            z(i7);
        }
        if (!this.M0 || i3 >= 0) {
            return;
        }
        this.M0 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        this.m0.onNestedScrollAccepted(view, view2, i2);
        this.l0.startNestedScroll(i2 & 2);
        this.i0 = this.b;
        this.j0 = true;
        w(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        return (isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0) && (this.N || this.B || this.C);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.m0.onStopNestedScroll(view);
        this.j0 = false;
        this.i0 = 0;
        B();
        this.l0.stopNestedScroll();
    }

    public ae1 p(boolean z) {
        o(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.G0))), 300) << 16 : 0, z, false);
        return this;
    }

    public ae1 q() {
        o(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.G0))), 300) << 16, true, true);
        return this;
    }

    public ae1 r() {
        u(true);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        View viewF = this.A0.f();
        if ((Build.VERSION.SDK_INT >= 21 || !(viewF instanceof AbsListView)) && ViewCompat.isNestedScrollingEnabled(viewF)) {
            this.p = z;
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public ae1 s(int i2) {
        t(i2, true, Boolean.FALSE);
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.T = z;
        this.l0.setNestedScrollingEnabled(z);
    }

    public void setStateDirectLoading(boolean z) {
        ce1 ce1Var = this.E0;
        ce1 ce1Var2 = ce1.Loading;
        if (ce1Var != ce1Var2) {
            this.G0 = System.currentTimeMillis();
            this.M0 = true;
            A(ce1Var2);
            le1 le1Var = this.f0;
            if (le1Var != null) {
                if (z) {
                    le1Var.f(this);
                }
            } else if (this.g0 == null) {
                n(2000);
            }
            vd1 vd1Var = this.z0;
            if (vd1Var != null) {
                float f2 = this.u0;
                if (f2 < 10.0f) {
                    f2 *= this.p0;
                }
                vd1Var.i(this, this.p0, (int) f2);
            }
            me1 me1Var = this.g0;
            if (me1Var == null || !(this.z0 instanceof xd1)) {
                return;
            }
            if (z) {
                me1Var.f(this);
            }
            float f3 = this.u0;
            if (f3 < 10.0f) {
                f3 *= this.p0;
            }
            this.g0.p((xd1) this.z0, this.p0, (int) f3);
        }
    }

    public void setStateLoading(boolean z) {
        b bVar = new b(z);
        A(ce1.LoadReleased);
        ValueAnimator valueAnimatorB = this.D0.b(-this.p0);
        if (valueAnimatorB != null) {
            valueAnimatorB.addListener(bVar);
        }
        vd1 vd1Var = this.z0;
        if (vd1Var != null) {
            float f2 = this.u0;
            if (f2 < 10.0f) {
                f2 *= this.p0;
            }
            vd1Var.j(this, this.p0, (int) f2);
        }
        me1 me1Var = this.g0;
        if (me1Var != null) {
            vd1 vd1Var2 = this.z0;
            if (vd1Var2 instanceof xd1) {
                float f3 = this.u0;
                if (f3 < 10.0f) {
                    f3 *= this.p0;
                }
                me1Var.e((xd1) vd1Var2, this.p0, (int) f3);
            }
        }
        if (valueAnimatorB == null) {
            bVar.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z) {
        c cVar = new c(z);
        A(ce1.RefreshReleased);
        ValueAnimator valueAnimatorB = this.D0.b(this.n0);
        if (valueAnimatorB != null) {
            valueAnimatorB.addListener(cVar);
        }
        vd1 vd1Var = this.y0;
        if (vd1Var != null) {
            float f2 = this.t0;
            if (f2 < 10.0f) {
                f2 *= this.n0;
            }
            vd1Var.j(this, this.n0, (int) f2);
        }
        me1 me1Var = this.g0;
        if (me1Var != null) {
            vd1 vd1Var2 = this.y0;
            if (vd1Var2 instanceof yd1) {
                float f3 = this.t0;
                if (f3 < 10.0f) {
                    f3 *= this.n0;
                }
                me1Var.d((yd1) vd1Var2, this.n0, (int) f3);
            }
        }
        if (valueAnimatorB == null) {
            cVar.onAnimationEnd(null);
        }
    }

    public void setViceState(ce1 ce1Var) {
        ce1 ce1Var2 = this.E0;
        if (ce1Var2.isDragging && ce1Var2.isHeader != ce1Var.isHeader) {
            A(ce1.None);
        }
        if (this.F0 != ce1Var) {
            this.F0 = ce1Var;
        }
    }

    public ae1 t(int i2, boolean z, Boolean bool) {
        int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        g gVar = new g(i3, bool, z);
        if (i4 > 0) {
            this.C0.postDelayed(gVar, i4);
        } else {
            gVar.run();
        }
        return this;
    }

    public ae1 u(boolean z) {
        if (z) {
            t(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.G0))), 300) << 16, true, Boolean.FALSE);
            return this;
        }
        t(0, false, null);
        return this;
    }

    public ae1 v() {
        t(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.G0))), 300) << 16, true, Boolean.TRUE);
        return this;
    }

    public boolean w(int i2) {
        if (i2 == 0) {
            if (this.Q0 != null) {
                ce1 ce1Var = this.E0;
                if (ce1Var.isFinishing || ce1Var == ce1.TwoLevelReleased || ce1Var == ce1.RefreshReleased || ce1Var == ce1.LoadReleased) {
                    return true;
                }
                if (ce1Var == ce1.PullDownCanceled) {
                    this.D0.f(ce1.PullDownToRefresh);
                } else if (ce1Var == ce1.PullUpCanceled) {
                    this.D0.f(ce1.PullUpToLoad);
                }
                this.Q0.setDuration(0L);
                this.Q0.cancel();
                this.Q0 = null;
            }
            this.P0 = null;
        }
        return this.Q0 != null;
    }

    public boolean x(boolean z) {
        return z && !this.P;
    }

    public boolean y(boolean z, @Nullable vd1 vd1Var) {
        return z || this.P || vd1Var == null || vd1Var.getSpinnerStyle() == de1.f;
    }

    public void z(float f2) {
        ce1 ce1Var;
        float f3 = (!this.j0 || this.S || f2 >= 0.0f || this.A0.i()) ? f2 : 0.0f;
        if (f3 > this.g * 5 && getTag() == null) {
            int i2 = ee1.srl_tag;
            if (getTag(i2) == null) {
                float f4 = this.k;
                int i3 = this.g;
                if (f4 < i3 / 6.0f && this.j < i3 / 16.0f) {
                    Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                    setTag(i2, "你这么死拉，臣妾做不到啊！");
                }
            }
        }
        ce1 ce1Var2 = this.E0;
        if (ce1Var2 == ce1.TwoLevel && f3 > 0.0f) {
            this.D0.c(Math.min((int) f3, getMeasuredHeight()), true);
        } else if (ce1Var2 == ce1.Refreshing && f3 >= 0.0f) {
            int i4 = this.n0;
            if (f3 < i4) {
                this.D0.c((int) f3, true);
            } else {
                float f5 = this.t0;
                if (f5 < 10.0f) {
                    f5 *= i4;
                }
                double d2 = f5 - i4;
                int iMax = Math.max((this.g * 4) / 3, getHeight());
                int i5 = this.n0;
                double d3 = iMax - i5;
                double dMax = Math.max(0.0f, (f3 - i5) * this.l);
                double d4 = -dMax;
                if (d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    d3 = 1.0d;
                }
                this.D0.c(((int) Math.min(d2 * (1.0d - Math.pow(100.0d, d4 / d3)), dMax)) + this.n0, true);
            }
        } else if (f3 < 0.0f && (ce1Var2 == ce1.Loading || ((this.K && this.W && this.a0 && x(this.C)) || (this.O && !this.W && x(this.C))))) {
            int i6 = this.p0;
            if (f3 > (-i6)) {
                this.D0.c((int) f3, true);
            } else {
                float f6 = this.u0;
                if (f6 < 10.0f) {
                    f6 *= i6;
                }
                double d5 = f6 - i6;
                int iMax2 = Math.max((this.g * 4) / 3, getHeight());
                int i7 = this.p0;
                double d6 = iMax2 - i7;
                double d7 = -Math.min(0.0f, (i7 + f3) * this.l);
                double d8 = -d7;
                if (d6 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    d6 = 1.0d;
                }
                this.D0.c(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d6)), d7))) - this.p0, true);
            }
        } else if (f3 >= 0.0f) {
            float f7 = this.t0;
            double d9 = f7 < 10.0f ? this.n0 * f7 : f7;
            double dMax2 = Math.max(this.g / 2, getHeight());
            double dMax3 = Math.max(0.0f, this.l * f3);
            double d10 = -dMax3;
            if (dMax2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dMax2 = 1.0d;
            }
            this.D0.c((int) Math.min(d9 * (1.0d - Math.pow(100.0d, d10 / dMax2)), dMax3), true);
        } else {
            float f8 = this.u0;
            double d11 = f8 < 10.0f ? this.p0 * f8 : f8;
            double dMax4 = Math.max(this.g / 2, getHeight());
            double d12 = -Math.min(0.0f, this.l * f3);
            this.D0.c((int) (-Math.min(d11 * (1.0d - Math.pow(100.0d, (-d12) / (dMax4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1.0d : dMax4))), d12)), true);
        }
        if (!this.O || this.W || !x(this.C) || f3 >= 0.0f || (ce1Var = this.E0) == ce1.Refreshing || ce1Var == ce1.Loading || ce1Var == ce1.LoadFinish) {
            return;
        }
        if (this.V) {
            this.P0 = null;
            this.D0.b(-this.p0);
        }
        setStateDirectLoading(false);
        this.C0.postDelayed(new f(), this.f);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 300;
        this.f = 300;
        this.l = 0.5f;
        this.m = 'n';
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = true;
        this.P = false;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = false;
        this.V = false;
        this.W = false;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.k0 = new int[2];
        this.l0 = new NestedScrollingChildHelper(this);
        this.m0 = new NestedScrollingParentHelper(this);
        be1 be1Var = be1.c;
        this.o0 = be1Var;
        this.q0 = be1Var;
        this.t0 = 2.5f;
        this.u0 = 2.5f;
        this.v0 = 1.0f;
        this.w0 = 1.0f;
        this.x0 = 0.16666667f;
        this.D0 = new l();
        ce1 ce1Var = ce1.None;
        this.E0 = ce1Var;
        this.F0 = ce1Var;
        this.G0 = 0L;
        this.H0 = 0;
        this.I0 = 0;
        this.M0 = false;
        this.N0 = false;
        this.O0 = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.C0 = new Handler(Looper.getMainLooper());
        this.x = new Scroller(context);
        this.y = VelocityTracker.obtain();
        this.g = context.getResources().getDisplayMetrics().heightPixels;
        this.z = new se1(se1.b);
        this.a = viewConfiguration.getScaledTouchSlop();
        this.u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.v = viewConfiguration.getScaledMaximumFlingVelocity();
        this.p0 = se1.c(60.0f);
        this.n0 = se1.c(100.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ge1.SmartRefreshLayout);
        if (!typedArrayObtainStyledAttributes.hasValue(ge1.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!typedArrayObtainStyledAttributes.hasValue(ge1.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        ke1 ke1Var = T0;
        if (ke1Var != null) {
            ke1Var.a(context, this);
        }
        this.l = typedArrayObtainStyledAttributes.getFloat(ge1.SmartRefreshLayout_srlDragRate, this.l);
        this.t0 = typedArrayObtainStyledAttributes.getFloat(ge1.SmartRefreshLayout_srlHeaderMaxDragRate, this.t0);
        this.u0 = typedArrayObtainStyledAttributes.getFloat(ge1.SmartRefreshLayout_srlFooterMaxDragRate, this.u0);
        this.v0 = typedArrayObtainStyledAttributes.getFloat(ge1.SmartRefreshLayout_srlHeaderTriggerRate, this.v0);
        this.w0 = typedArrayObtainStyledAttributes.getFloat(ge1.SmartRefreshLayout_srlFooterTriggerRate, this.w0);
        this.B = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableRefresh, this.B);
        this.f = typedArrayObtainStyledAttributes.getInt(ge1.SmartRefreshLayout_srlReboundDuration, this.f);
        int i2 = ge1.SmartRefreshLayout_srlEnableLoadMore;
        this.C = typedArrayObtainStyledAttributes.getBoolean(i2, this.C);
        int i3 = ge1.SmartRefreshLayout_srlHeaderHeight;
        this.n0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i3, this.n0);
        int i4 = ge1.SmartRefreshLayout_srlFooterHeight;
        this.p0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i4, this.p0);
        this.r0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(ge1.SmartRefreshLayout_srlHeaderInsetStart, this.r0);
        this.s0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(ge1.SmartRefreshLayout_srlFooterInsetStart, this.s0);
        this.U = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlDisableContentWhenRefresh, this.U);
        this.V = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlDisableContentWhenLoading, this.V);
        int i5 = ge1.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.F = typedArrayObtainStyledAttributes.getBoolean(i5, this.F);
        int i6 = ge1.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.G = typedArrayObtainStyledAttributes.getBoolean(i6, this.G);
        this.L = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnablePreviewInEditMode, this.L);
        this.O = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableAutoLoadMore, this.O);
        this.M = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableOverScrollBounce, this.M);
        this.P = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnablePureScrollMode, this.P);
        this.Q = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.Q);
        this.R = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.R);
        this.S = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.S);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.K);
        this.K = z;
        this.K = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z);
        this.D = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.D);
        this.E = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.E);
        this.N = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableOverScrollDrag, this.N);
        this.q = typedArrayObtainStyledAttributes.getResourceId(ge1.SmartRefreshLayout_srlFixedHeaderViewId, this.q);
        this.r = typedArrayObtainStyledAttributes.getResourceId(ge1.SmartRefreshLayout_srlFixedFooterViewId, this.r);
        this.s = typedArrayObtainStyledAttributes.getResourceId(ge1.SmartRefreshLayout_srlHeaderTranslationViewId, this.s);
        this.t = typedArrayObtainStyledAttributes.getResourceId(ge1.SmartRefreshLayout_srlFooterTranslationViewId, this.t);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(ge1.SmartRefreshLayout_srlEnableNestedScrolling, this.T);
        this.T = z2;
        this.l0.setNestedScrollingEnabled(z2);
        this.b0 = this.b0 || typedArrayObtainStyledAttributes.hasValue(i2);
        this.c0 = this.c0 || typedArrayObtainStyledAttributes.hasValue(i5);
        this.d0 = this.d0 || typedArrayObtainStyledAttributes.hasValue(i6);
        this.o0 = typedArrayObtainStyledAttributes.hasValue(i3) ? be1.i : this.o0;
        this.q0 = typedArrayObtainStyledAttributes.hasValue(i4) ? be1.i : this.q0;
        int color = typedArrayObtainStyledAttributes.getColor(ge1.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(ge1.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.A = new int[]{color2, color};
            } else {
                this.A = new int[]{color2};
            }
        } else if (color != 0) {
            this.A = new int[]{0, color};
        }
        if (this.P && !this.b0 && !this.C) {
            this.C = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int a;
        public de1 b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.b = null;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ge1.SmartRefreshLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getColor(ge1.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.a);
            int i = ge1.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (typedArrayObtainStyledAttributes.hasValue(i)) {
                this.b = de1.i[typedArrayObtainStyledAttributes.getInt(i, de1.d.a)];
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.b = null;
        }
    }
}

package com.wear.widget.control;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.wear.bean.AnalyticsBean;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.xe3;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public class DSFingerImageView extends RelativeLayout {
    public int A;
    public int B;
    public int C;
    public boolean D;
    public List<String> E;
    public j F;
    public String G;
    public long K;
    public boolean L;
    public boolean M;
    public LayoutInflater a;
    public FingerBackgroundView b;
    public DSFingerTouchView c;
    public FingImageLayout d;
    public FingImageLayout e;
    public FingImageLayout f;
    public int g;
    public int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public View.OnTouchListener m;
    public View.OnTouchListener n;
    public String o;
    public String p;
    public String q;
    public String r;
    public Timer s;
    public boolean t;
    public int u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class a implements Animator.AnimatorListener {
        public final /* synthetic */ FingImageLayout a;

        public a(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FingImageLayout fingImageLayout = this.a;
            DSFingerImageView dSFingerImageView = DSFingerImageView.this;
            if (fingImageLayout == dSFingerImageView.d) {
                dSFingerImageView.b.setOneLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            } else if (fingImageLayout == dSFingerImageView.e) {
                dSFingerImageView.b.setTwoLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            }
            DSFingerImageView.this.b.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FingImageLayout fingImageLayout = this.a;
            DSFingerImageView dSFingerImageView = DSFingerImageView.this;
            if (fingImageLayout == dSFingerImageView.d) {
                dSFingerImageView.b.setOneLastY(-1.0f);
            } else if (fingImageLayout == dSFingerImageView.e) {
                dSFingerImageView.b.setTwoLastY(-1.0f);
            }
            DSFingerImageView.this.b.invalidate();
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            DSFingerImageView dSFingerImageView = DSFingerImageView.this;
            dSFingerImageView.K++;
            dSFingerImageView.s();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DSFingerImageView.this.L = false;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            DSFingerImageView dSFingerImageView = DSFingerImageView.this;
            FingImageLayout fingImageLayout = dSFingerImageView.d;
            dSFingerImageView.t(fingImageLayout, (int) fingImageLayout.getX(), this.a, 1);
            DSFingerImageView dSFingerImageView2 = DSFingerImageView.this;
            FingImageLayout fingImageLayout2 = dSFingerImageView2.e;
            dSFingerImageView2.t(fingImageLayout2, (int) fingImageLayout2.getX(), this.b, 2);
        }
    }

    public class e implements Animator.AnimatorListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ FingImageLayout b;

        public e(int i, FingImageLayout fingImageLayout) {
            this.a = i;
            this.b = fingImageLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a == 1) {
                DSFingerImageView.this.b.setOneLastY(this.b.getY() + (this.b.getHeight() / 2));
            } else {
                DSFingerImageView.this.b.setTwoLastY(this.b.getY() + (this.b.getHeight() / 2));
            }
            DSFingerImageView.this.b.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class f implements View.OnTouchListener {
        public final /* synthetic */ FingImageLayout a;

        public f(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                DSFingerImageView.this.i = motionEvent.getRawX();
                DSFingerImageView.this.j = motionEvent.getRawY();
                if (view instanceof FingerBackgroundView) {
                    DSFingerImageView dSFingerImageView = DSFingerImageView.this;
                    dSFingerImageView.m(dSFingerImageView.d, motionEvent.getRawX() - (DSFingerImageView.this.d.getWidth() / 2), motionEvent.getRawY() - (DSFingerImageView.this.d.getHeight() / 2));
                }
                DSFingerImageView dSFingerImageView2 = DSFingerImageView.this;
                dSFingerImageView2.d(dSFingerImageView2.d);
                DSFingerImageView.this.b.c = true;
                return true;
            }
            if (actionMasked == 1) {
                DSFingerImageView.this.w(this.a);
            } else if (actionMasked == 2) {
                DSFingerImageView.this.r();
                float rawX = DSFingerImageView.this.i - motionEvent.getRawX();
                float y = this.a.getY() - (DSFingerImageView.this.j - motionEvent.getRawY());
                float x = this.a.getX() - rawX;
                String str = "onTouch: nextY=  " + y + "  topAreaLineTopMarginsPx = " + DSFingerImageView.this.B + "   getContainerHeight() = " + DSFingerImageView.this.getContainerHeight() + "  image.getHeight() =" + this.a.getHeight() + "   ADD=" + (DSFingerImageView.this.getContainerHeight() - this.a.getHeight());
                int i = DSFingerImageView.this.B;
                if (y <= i) {
                    y = i;
                } else if (y > r0.getContainerHeight() - this.a.getHeight()) {
                    y = DSFingerImageView.this.getContainerHeight() - this.a.getHeight();
                }
                if (x < 0.0f) {
                    x = 0.0f;
                } else if (x > DSFingerImageView.this.g - this.a.getWidth()) {
                    x = DSFingerImageView.this.g - this.a.getWidth();
                }
                FingImageLayout fingImageLayout = this.a;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(fingImageLayout, FingImageLayout.ObjectAnimatorY, fingImageLayout.getY(), y);
                FingImageLayout fingImageLayout2 = this.a;
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout2, "x", fingImageLayout2.getX(), x);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                animatorSet.setDuration(0L);
                animatorSet.start();
                DSFingerImageView.this.i = motionEvent.getRawX();
                DSFingerImageView.this.j = motionEvent.getRawY();
                DSFingerImageView.this.b.setOneLastY(this.a.getY() + (this.a.getHeight() / 2));
                DSFingerImageView.this.b.invalidate();
            }
            return false;
        }
    }

    public class g implements View.OnTouchListener {
        public final /* synthetic */ FingImageLayout a;

        public g(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                DSFingerImageView.this.k = motionEvent.getRawX();
                DSFingerImageView.this.l = motionEvent.getRawY();
                if (view instanceof FingerBackgroundView) {
                    DSFingerImageView dSFingerImageView = DSFingerImageView.this;
                    dSFingerImageView.m(dSFingerImageView.e, motionEvent.getRawX() - (DSFingerImageView.this.e.getWidth() / 2), motionEvent.getRawY() - (DSFingerImageView.this.e.getHeight() / 2));
                }
                DSFingerImageView dSFingerImageView2 = DSFingerImageView.this;
                dSFingerImageView2.d(dSFingerImageView2.e);
                DSFingerImageView.this.b.e = true;
                return true;
            }
            if (actionMasked == 1) {
                DSFingerImageView.this.w(this.a);
            } else if (actionMasked == 2) {
                DSFingerImageView.this.r();
                float rawX = DSFingerImageView.this.k - motionEvent.getRawX();
                float y = this.a.getY() - (DSFingerImageView.this.l - motionEvent.getRawY());
                float x = this.a.getX() - rawX;
                int i = DSFingerImageView.this.B;
                if (y <= i) {
                    y = i;
                } else if (y > r0.getContainerHeight() - this.a.getHeight()) {
                    y = DSFingerImageView.this.getContainerHeight() - this.a.getHeight();
                }
                if (x < 0.0f) {
                    x = 0.0f;
                } else if (x > DSFingerImageView.this.g - this.a.getWidth()) {
                    x = DSFingerImageView.this.g - this.a.getWidth();
                }
                FingImageLayout fingImageLayout = this.a;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(fingImageLayout, FingImageLayout.ObjectAnimatorY, fingImageLayout.getY(), y);
                FingImageLayout fingImageLayout2 = this.a;
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout2, "x", fingImageLayout2.getX(), x);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                animatorSet.setDuration(0L);
                animatorSet.start();
                DSFingerImageView.this.k = motionEvent.getRawX();
                DSFingerImageView.this.l = motionEvent.getRawY();
                DSFingerImageView.this.b.setTwoLastY(this.a.getY() + (this.a.getHeight() / 2));
                DSFingerImageView.this.b.invalidate();
            }
            return false;
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DSFingerImageView.this.s();
        }
    }

    public class i implements Animator.AnimatorListener {
        public final /* synthetic */ FingImageLayout a;

        public i(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FingImageLayout fingImageLayout = this.a;
            DSFingerImageView dSFingerImageView = DSFingerImageView.this;
            if (fingImageLayout == dSFingerImageView.d) {
                dSFingerImageView.b.setOneLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            } else if (fingImageLayout == dSFingerImageView.e) {
                dSFingerImageView.b.setTwoLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            }
            DSFingerImageView.this.b.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FingImageLayout fingImageLayout = this.a;
            DSFingerImageView dSFingerImageView = DSFingerImageView.this;
            if (fingImageLayout == dSFingerImageView.d) {
                dSFingerImageView.b.setOneLastY(-1.0f);
            } else if (fingImageLayout == dSFingerImageView.e) {
                dSFingerImageView.b.setTwoLastY(-1.0f);
            }
            DSFingerImageView.this.b.invalidate();
        }
    }

    public interface j {
        void a();

        void b(String str, String str2, String str3, boolean z, long j);
    }

    public DSFingerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.t = true;
        this.w = 0;
        this.x = false;
        this.y = false;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.E = new ArrayList();
        this.F = null;
        this.K = 0L;
        this.L = false;
        k(context, attributeSet);
    }

    public synchronized void d(FingImageLayout fingImageLayout) {
        if (this.w == 0) {
            this.f.choosed(false);
            fingImageLayout.choosed(true);
            this.f = fingImageLayout;
        }
        this.E.clear();
        this.A = 0;
        this.z = false;
        this.v = true;
        this.w++;
        j jVar = this.F;
        if (jVar != null) {
            jVar.a();
        }
    }

    public void e(View.OnTouchListener onTouchListener) {
        this.b.setOnTouchListener(onTouchListener);
    }

    public int f() {
        int i2 = this.d.getVisibility() == 0 ? 1 : 0;
        return this.e.getVisibility() == 0 ? i2 + 1 : i2;
    }

    public void g() {
        this.d.setTag(null);
        this.d.setVisibility(8);
        this.b.c = false;
    }

    public int getContainerHeight() {
        return getHeight() != 0 ? getHeight() : this.h;
    }

    public int getContainerWidth() {
        return this.g;
    }

    public synchronized String getFingerTags() {
        this.o = "";
        if (this.d.getVisibility() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.o);
            sb.append(this.d.getTag() == null ? "" : this.d.getTag().toString());
            sb.append(TouchControlView.O);
            this.o = sb.toString();
        }
        if (this.e.getVisibility() == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.o);
            sb2.append(this.e.getTag() == null ? "" : this.e.getTag().toString());
            sb2.append(TouchControlView.O);
            this.o = sb2.toString();
        }
        if (this.o.endsWith(TouchControlView.O)) {
            this.o = this.o.substring(0, r0.length() - 1);
        }
        return this.o;
    }

    public void h() {
        xe3.a("TouchControlView", "hiddenTwoFingerImage");
        this.e.setTag(null);
        this.e.setVisibility(8);
        this.b.e = false;
    }

    public void i(FingImageLayout fingImageLayout) {
        f fVar = new f(fingImageLayout);
        this.m = fVar;
        fingImageLayout.setOnTouchListener(fVar);
    }

    public void j(FingImageLayout fingImageLayout) {
        g gVar = new g(fingImageLayout);
        this.n = gVar;
        fingImageLayout.setOnTouchListener(gVar);
    }

    public final void k(Context context, AttributeSet attributeSet) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_finger_image_ds, (ViewGroup) null);
        addView(viewInflate);
        this.b = (FingerBackgroundView) viewInflate.findViewById(R.id.finger_root);
        this.c = (DSFingerTouchView) viewInflate.findViewById(R.id.finger_touch);
        this.d = new FingImageLayout((RelativeLayout) viewInflate.findViewById(R.id.finger_image_1_layout), (ImageView) viewInflate.findViewById(R.id.finger_image_1_round), (ImageView) viewInflate.findViewById(R.id.finger_image_1_func));
        this.e = new FingImageLayout((RelativeLayout) viewInflate.findViewById(R.id.finger_image_2_layout), (ImageView) viewInflate.findViewById(R.id.finger_image_2_round), (ImageView) viewInflate.findViewById(R.id.finger_image_2_func));
        FingImageLayout fingImageLayout = this.d;
        this.f = fingImageLayout;
        fingImageLayout.choosed(true);
        this.c.setDSFingerImageView(this);
        i(this.d);
        j(this.e);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        e(null);
        Timer timer = new Timer();
        this.s = timer;
        timer.scheduleAtFixedRate(new b(), 1000L, 100L);
    }

    public final void l(String str) {
    }

    public void m(FingImageLayout fingImageLayout, float f2, float f3) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(fingImageLayout, FingImageLayout.ObjectAnimatorY, fingImageLayout.getY(), f3);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), f2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.addListener(new a(fingImageLayout));
        animatorSet.start();
    }

    public final int n(FingImageLayout fingImageLayout) {
        int height = fingImageLayout.getHeight() / 2;
        float y = fingImageLayout.getY() + height;
        int height2 = fingImageLayout.getHeight();
        int containerHeight = getContainerHeight() - height;
        int i2 = 20;
        int i3 = (containerHeight - height2) / 20;
        float f2 = height2;
        if (y < f2) {
            y = f2;
        } else {
            float f3 = containerHeight;
            if (y > f3) {
                y = f3;
            }
        }
        int i4 = (int) (20.0f - ((y - f2) / i3));
        if (i4 == 0 && y < containerHeight - 8) {
            i4 = 1;
        }
        if (i4 < 0) {
            i2 = 0;
        } else if (i4 <= 20) {
            i2 = i4;
        }
        return i2 * 5;
    }

    public void o() {
        p(this.d);
        p(this.e);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.M) {
            return;
        }
        this.M = true;
        o();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.g = ce3.e(i2);
        int iD = ce3.d(i3);
        this.h = iD;
        this.b.setLayoutSize(this.g, iD);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.u == 2) {
            int height = this.d.getHeight();
            float f2 = i5 - height;
            int i6 = i3 - height;
            float f3 = i6;
            int y = (int) ((this.d.getY() / f2) * f3);
            if (y < 0) {
                y = 0;
            } else if (y > i6) {
                y = i6;
            }
            int y2 = (int) ((this.e.getY() / f2) * f3);
            if (y2 < 0) {
                i6 = 0;
            } else if (y2 <= i6) {
                i6 = y2;
            }
            new Handler(Looper.getMainLooper()).post(new d(y, i6));
        }
    }

    public void p(FingImageLayout fingImageLayout) {
        q(fingImageLayout, getContainerHeight() - fingImageLayout.getHeight());
    }

    public void q(FingImageLayout fingImageLayout, float f2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(fingImageLayout, FingImageLayout.ObjectAnimatorY, fingImageLayout.getY(), f2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (this.g / 2) - (fingImageLayout.getWidth() / 2));
        if (f() == 2) {
            if (fingImageLayout == this.d) {
                l("resetPositionBottom:fingerLayoutOne " + f2);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (float) (((this.g * 1) / 3) - (fingImageLayout.getWidth() / 2)));
            } else if (fingImageLayout == this.e) {
                l("resetPositionBottom:fingerLayoutTwo " + f2);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (float) ((this.g * 2) / 3));
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.addListener(new i(fingImageLayout));
        animatorSet.start();
    }

    public final void r() {
        MyApplication myApplication = WearUtils.x;
        AnalyticsBean analyticsBean = myApplication.r;
        if (analyticsBean == null || !analyticsBean.usedTouchPannel) {
            return;
        }
        analyticsBean.usedTouchPannel = false;
        myApplication.q(analyticsBean.getEvenString(), null);
    }

    public final synchronized void s() {
        if (!this.t && this.F != null) {
            this.p = "";
            this.r = "";
            if (!this.z || this.E.isEmpty()) {
                if (this.d.getVisibility() == 0) {
                    this.p += n(this.d) + TouchControlView.O;
                }
                if (this.e.getVisibility() == 0) {
                    this.p += n(this.e) + TouchControlView.O;
                }
                if (this.p.endsWith(TouchControlView.O)) {
                    String str = this.p;
                    this.p = str.substring(0, str.length() - 1);
                }
                if (this.u == 1 && this.v) {
                    this.E.add(this.p);
                }
            } else {
                List<String> list = this.E;
                int i2 = this.A;
                this.A = i2 + 1;
                this.p = list.get(i2 % list.size());
            }
            this.y = this.w > 0;
            String fingerTags = getFingerTags();
            String[] strArrSplit = fingerTags.split(TouchControlView.O);
            String[] strArrSplit2 = this.p.split(TouchControlView.O);
            if (strArrSplit.length != strArrSplit2.length && this.D) {
                this.p = "";
                for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                    if (i3 < strArrSplit2.length) {
                        this.p += strArrSplit2[i3] + ",";
                    } else {
                        this.p += strArrSplit2[0] + ",";
                    }
                }
                String str2 = this.p;
                this.p = str2.substring(0, str2.length() - 1);
            }
            if (this.L) {
                String str3 = "sendChangeListener: " + this.q + "   " + this.p;
            } else {
                this.q = this.p;
            }
            l("tag：" + fingerTags + " group:" + this.p + " lastTag:" + this.G);
            j jVar = this.F;
            String str4 = this.q;
            String str5 = this.r;
            boolean z = this.y;
            if (!z) {
                z = this.x;
            }
            jVar.b(fingerTags, str4, str5, z, this.K);
        }
    }

    public void setChangeListener(j jVar) {
        this.F = jVar;
    }

    public void setControlType(int i2) {
        this.u = i2;
        if (i2 == 2) {
            this.d.choosed(false);
            this.e.choosed(false);
        } else {
            this.d.choosed(true);
            this.f = this.d;
            this.e.choosed(false);
        }
        e(null);
        p(this.d);
        p(this.e);
        FingerBackgroundView fingerBackgroundView = this.b;
        fingerBackgroundView.c = false;
        fingerBackgroundView.e = false;
        fingerBackgroundView.g = false;
        if (i2 != 1) {
            this.z = false;
        }
    }

    public void setLastFunction(String str) {
        this.G = str;
    }

    public void setPause(boolean z) {
        this.t = z;
    }

    public void setShowMore() {
        this.L = true;
        new Handler(Looper.getMainLooper()).postDelayed(new c(), 100L);
    }

    public final void t(FingImageLayout fingImageLayout, int i2, int i3, int i4) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), i2), ObjectAnimator.ofFloat(fingImageLayout, FingImageLayout.ObjectAnimatorY, fingImageLayout.getY(), i3));
        animatorSet.setDuration(0L);
        animatorSet.start();
        animatorSet.addListener(new e(i4, fingImageLayout));
    }

    public void u(String str, int i2) {
        this.d.setTag(str);
        this.d.setImageResource(i2);
        Integer num = Toy.ICON_MAP_CONTROL_BACKGROUND.get(str);
        this.d.setBackgroundImageResource(num == null ? R.drawable.content_button_roundframe_pink : num.intValue());
        this.d.setVisibility(0);
    }

    public void v(String str, int i2) {
        xe3.a("TouchControlView", "showTwoFingerImage");
        this.e.setTag(str);
        this.e.setImageResource(i2);
        Integer num = Toy.ICON_MAP_CONTROL_BACKGROUND.get(str);
        this.e.setBackgroundImageResource(num == null ? R.drawable.content_button_roundframe_pink : num.intValue());
        this.e.setVisibility(0);
    }

    public synchronized void w(FingImageLayout fingImageLayout) {
        int i2 = this.w - 1;
        this.w = i2;
        if (i2 <= 0 && this.u == 1) {
            this.v = false;
            this.z = true;
        } else if (i2 <= 0) {
            int i3 = this.u;
        }
        int i4 = this.u;
        if (i4 != 2) {
            if (fingImageLayout == this.d) {
                this.b.c = false;
            } else if (fingImageLayout == this.e) {
                this.b.e = false;
            }
            p(fingImageLayout);
        } else if (i4 == 2) {
            s();
            postDelayed(new h(), 100L);
        }
    }
}

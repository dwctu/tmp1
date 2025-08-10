package com.wear.widget.control;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
public class FingerImageView extends RelativeLayout {
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public List<String> K;
    public h L;
    public String M;
    public long N;
    public boolean O;
    public LayoutInflater a;
    public FingerBackgroundView b;
    public FingerTouchView c;
    public FingImageLayout d;
    public FingImageLayout e;
    public FingImageLayout f;
    public FingImageLayout g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public View.OnTouchListener p;
    public View.OnTouchListener q;
    public View.OnTouchListener r;
    public String s;
    public String t;
    public String u;
    public Timer v;
    public boolean w;
    public int x;
    public boolean y;
    public int z;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FingerImageView fingerImageView = FingerImageView.this;
            fingerImageView.N++;
            fingerImageView.y();
        }
    }

    public class b implements View.OnTouchListener {
        public final /* synthetic */ FingImageLayout a;

        public b(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00eb  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instructions count: 314
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.FingerImageView.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class c implements View.OnTouchListener {
        public final /* synthetic */ FingImageLayout a;

        public c(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00eb  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instructions count: 314
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.FingerImageView.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class d implements View.OnTouchListener {
        public final /* synthetic */ FingImageLayout a;

        public d(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00eb  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instructions count: 314
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.FingerImageView.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FingerImageView.this.y();
        }
    }

    public class f implements Animator.AnimatorListener {
        public final /* synthetic */ FingImageLayout a;

        public f(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FingImageLayout fingImageLayout = this.a;
            FingerImageView fingerImageView = FingerImageView.this;
            if (fingImageLayout == fingerImageView.d) {
                fingerImageView.b.setOneLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            } else if (fingImageLayout == fingerImageView.e) {
                fingerImageView.b.setTwoLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            }
            FingerImageView.this.b.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FingImageLayout fingImageLayout = this.a;
            FingerImageView fingerImageView = FingerImageView.this;
            if (fingImageLayout == fingerImageView.d) {
                fingerImageView.b.setOneLastY(-1.0f);
            } else if (fingImageLayout == fingerImageView.e) {
                fingerImageView.b.setTwoLastY(-1.0f);
            }
            FingerImageView.this.b.invalidate();
        }
    }

    public class g implements Animator.AnimatorListener {
        public final /* synthetic */ FingImageLayout a;

        public g(FingImageLayout fingImageLayout) {
            this.a = fingImageLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FingImageLayout fingImageLayout = this.a;
            FingerImageView fingerImageView = FingerImageView.this;
            if (fingImageLayout == fingerImageView.d) {
                fingerImageView.b.setOneLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            } else if (fingImageLayout == fingerImageView.e) {
                fingerImageView.b.setTwoLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            } else if (fingImageLayout == fingerImageView.f) {
                fingerImageView.b.setExpLastY(fingImageLayout.getY() + (this.a.getHeight() / 2));
            }
            FingerImageView.this.b.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FingImageLayout fingImageLayout = this.a;
            FingerImageView fingerImageView = FingerImageView.this;
            if (fingImageLayout == fingerImageView.d) {
                fingerImageView.b.setOneLastY(-1.0f);
            } else if (fingImageLayout == fingerImageView.e) {
                fingerImageView.b.setTwoLastY(-1.0f);
            } else if (fingImageLayout == fingerImageView.f) {
                fingerImageView.b.setExpLastY(-1.0f);
            }
            FingerImageView.this.b.invalidate();
        }
    }

    public interface h {
        void a();

        void b(String str, String str2, String str3, boolean z, long j);
    }

    public FingerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = "";
        this.t = "";
        this.u = "";
        this.w = true;
        this.z = 0;
        this.A = false;
        this.B = false;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.K = new ArrayList();
        this.L = null;
        this.N = 0L;
        l(context, attributeSet);
    }

    public void A(String str, int i) {
        this.d.setTag(str);
        this.d.setImageResource(i);
        Integer num = Toy.ICON_MAP_CONTROL_BACKGROUND.get(str);
        this.d.setBackgroundImageResource(num == null ? R.drawable.content_button_roundframe_pink : num.intValue());
        this.d.setVisibility(0);
    }

    public void B(String str, int i) {
        xe3.a("TouchControlView", "showTwoFingerImage");
        this.e.setTag(str);
        this.e.setImageResource(i);
        Integer num = Toy.ICON_MAP_CONTROL_BACKGROUND.get(str);
        this.e.setBackgroundImageResource(num == null ? R.drawable.content_button_roundframe_pink : num.intValue());
        this.e.setVisibility(0);
    }

    public synchronized void C(FingImageLayout fingImageLayout) {
        int i = this.z - 1;
        this.z = i;
        if (i <= 0 && this.x == 1) {
            this.y = false;
            this.C = true;
        } else if (i <= 0) {
            int i2 = this.x;
        }
        int i3 = this.x;
        if (i3 != 2) {
            if (fingImageLayout == this.d) {
                this.b.c = false;
            } else if (fingImageLayout == this.e) {
                this.b.e = false;
            } else if (fingImageLayout == this.f) {
                this.b.g = false;
            }
            u(fingImageLayout);
        } else if (i3 == 2) {
            y();
            postDelayed(new e(), 100L);
        }
    }

    public synchronized void c(FingImageLayout fingImageLayout) {
        if (this.z == 0) {
            this.g.choosed(false);
            fingImageLayout.choosed(true);
            this.g = fingImageLayout;
        }
        this.K.clear();
        this.D = 0;
        this.C = false;
        this.y = true;
        this.z++;
        h hVar = this.L;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void d(View.OnTouchListener onTouchListener) {
        this.b.setOnTouchListener(onTouchListener);
    }

    public int e() {
        int i = this.d.getVisibility() == 0 ? 1 : 0;
        return this.e.getVisibility() == 0 ? i + 1 : i;
    }

    public void f() {
        this.f.setTag(null);
        this.f.setVisibility(8);
        this.b.g = false;
    }

    public void g() {
        this.d.setTag(null);
        this.d.setVisibility(8);
        this.b.c = false;
    }

    public int getContainerHeight() {
        return getHeight() != 0 ? getHeight() : this.i;
    }

    public int getContainerWidth() {
        return this.h;
    }

    public List<String> getDatas() {
        return this.K;
    }

    public synchronized String getFingerTags() {
        this.s = "";
        if (this.d.getVisibility() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.s);
            sb.append(this.d.getTag() == null ? "" : this.d.getTag().toString());
            sb.append(TouchControlView.O);
            this.s = sb.toString();
        }
        if (this.e.getVisibility() == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.s);
            sb2.append(this.e.getTag() == null ? "" : this.e.getTag().toString());
            sb2.append(TouchControlView.O);
            this.s = sb2.toString();
        }
        if (this.f.getVisibility() == 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.s);
            sb3.append(this.f.getTag() == null ? "" : this.f.getTag().toString());
            sb3.append(TouchControlView.O);
            this.s = sb3.toString();
        }
        if (this.s.endsWith(TouchControlView.O)) {
            this.s = this.s.substring(0, r0.length() - 1);
        }
        return this.s;
    }

    public void h() {
        xe3.a("TouchControlView", "hiddenTwoFingerImage");
        this.e.setTag(null);
        this.e.setVisibility(8);
        this.b.e = false;
    }

    public void i(FingImageLayout fingImageLayout) {
        d dVar = new d(fingImageLayout);
        this.r = dVar;
        fingImageLayout.setOnTouchListener(dVar);
    }

    public void j(FingImageLayout fingImageLayout) {
        b bVar = new b(fingImageLayout);
        this.p = bVar;
        fingImageLayout.setOnTouchListener(bVar);
    }

    public void k(FingImageLayout fingImageLayout) {
        c cVar = new c(fingImageLayout);
        this.q = cVar;
        fingImageLayout.setOnTouchListener(cVar);
    }

    public final void l(Context context, AttributeSet attributeSet) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_finger_image, (ViewGroup) null);
        addView(viewInflate);
        this.b = (FingerBackgroundView) viewInflate.findViewById(R.id.finger_root);
        this.c = (FingerTouchView) viewInflate.findViewById(R.id.finger_touch);
        this.d = new FingImageLayout((RelativeLayout) viewInflate.findViewById(R.id.finger_image_1_layout), (ImageView) viewInflate.findViewById(R.id.finger_image_1_round), (ImageView) viewInflate.findViewById(R.id.finger_image_1_func));
        this.e = new FingImageLayout((RelativeLayout) viewInflate.findViewById(R.id.finger_image_2_layout), (ImageView) viewInflate.findViewById(R.id.finger_image_2_round), (ImageView) viewInflate.findViewById(R.id.finger_image_2_func));
        this.f = new FingImageLayout((RelativeLayout) viewInflate.findViewById(R.id.finger_image_expansion_layout), (ImageView) viewInflate.findViewById(R.id.finger_image_expansion_round), (ImageView) viewInflate.findViewById(R.id.finger_image_expansion_func));
        FingImageLayout fingImageLayout = this.d;
        this.g = fingImageLayout;
        fingImageLayout.choosed(true);
        this.c.setFingerImageView(this);
        j(this.d);
        k(this.e);
        i(this.f);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        d(null);
        Timer timer = new Timer();
        this.v = timer;
        timer.scheduleAtFixedRate(new a(), 1000L, 100L);
    }

    public final void m(String str) {
    }

    public void n(int i) {
        o(this.d, i);
        o(this.e, i);
        o(this.f, i);
    }

    public void o(FingImageLayout fingImageLayout, int i) {
        int containerHeight = getContainerHeight() - fingImageLayout.getHeight();
        int i2 = this.E;
        v(fingImageLayout, ((int) ((containerHeight - i2) * (1.0f - (i / 100.0f)))) + i2);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.O) {
            return;
        }
        this.O = true;
        s();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.h = ce3.e(i);
        int iD = ce3.d(i2);
        this.i = iD;
        this.b.setLayoutSize(this.h, iD);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            return;
        }
        int i2 = this.z - 1;
        this.z = i2;
        if (i2 > 0 || this.x != 1) {
            return;
        }
        this.y = false;
        this.C = true;
        FingImageLayout fingImageLayout = this.d;
        if (fingImageLayout != null) {
            this.b.c = false;
            u(fingImageLayout);
        }
        FingImageLayout fingImageLayout2 = this.e;
        if (fingImageLayout2 != null) {
            this.b.e = false;
            u(fingImageLayout2);
        }
        FingImageLayout fingImageLayout3 = this.f;
        if (fingImageLayout3 != null) {
            this.b.g = false;
            u(fingImageLayout3);
        }
    }

    public void p(FingImageLayout fingImageLayout, float f2, float f3) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(fingImageLayout, FingImageLayout.ObjectAnimatorY, fingImageLayout.getY(), f3);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), f2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.addListener(new g(fingImageLayout));
        animatorSet.start();
    }

    public void q() {
        Timer timer = this.v;
        if (timer != null) {
            timer.cancel();
        }
        this.v = null;
    }

    public final int r(FingImageLayout fingImageLayout) {
        int height = fingImageLayout.getHeight() / 2;
        float y = fingImageLayout.getY() + height;
        int height2 = fingImageLayout.getHeight();
        int containerHeight = getContainerHeight() - height;
        int i = 20;
        int i2 = (containerHeight - height2) / 20;
        float f2 = height2;
        if (y < f2) {
            y = f2;
        } else {
            float f3 = containerHeight;
            if (y > f3) {
                y = f3;
            }
        }
        int i3 = (int) (20.0f - ((y - f2) / i2));
        if (i3 == 0 && y < containerHeight - 8) {
            i3 = 1;
        }
        if (i3 < 0) {
            i = 0;
        } else if (i3 <= 20) {
            i = i3;
        }
        return i * 5;
    }

    public void s() {
        u(this.d);
        u(this.e);
        u(this.f);
    }

    public void setChangeListener(h hVar) {
        this.L = hVar;
    }

    public void setControlType(int i) {
        this.x = i;
        this.d.choosed(true);
        this.g = this.d;
        this.e.choosed(false);
        this.f.choosed(false);
        d(null);
        u(this.d);
        u(this.e);
        u(this.f);
        FingerBackgroundView fingerBackgroundView = this.b;
        fingerBackgroundView.c = false;
        fingerBackgroundView.e = false;
        fingerBackgroundView.g = false;
        if (i != 1) {
            this.C = false;
        }
    }

    public void setDatas(List<String> list) {
        if (list != null) {
            this.K.clear();
            this.K.addAll(list);
            this.C = true;
        }
    }

    public void setGroupControl(boolean z) {
        this.G = z;
    }

    public void setLastFunction(String str) {
        this.M = str;
    }

    public void setPause(boolean z) {
        this.w = z;
    }

    public void t(int i) {
        w(this.d, i);
        w(this.e, i);
        w(this.f, i);
        u(this.d);
        u(this.e);
        u(this.f);
    }

    public void u(FingImageLayout fingImageLayout) {
        v(fingImageLayout, getContainerHeight() - fingImageLayout.getHeight());
    }

    public void v(FingImageLayout fingImageLayout, float f2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(fingImageLayout, FingImageLayout.ObjectAnimatorY, fingImageLayout.getY(), f2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (this.h / 2) - (fingImageLayout.getWidth() / 2));
        if (this.f.getVisibility() == 8) {
            if (e() == 2) {
                if (fingImageLayout == this.d) {
                    m("resetPositionBottom:fingerLayoutOne " + f2);
                    objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (float) (((this.h * 1) / 3) - (fingImageLayout.getWidth() / 2)));
                } else if (fingImageLayout == this.e) {
                    m("resetPositionBottom:fingerLayoutTwo " + f2);
                    objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (float) ((this.h * 2) / 3));
                }
            }
        } else if (fingImageLayout == this.d) {
            m("resetPositionBottom:fingerLayoutOne " + f2);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (float) (((this.h * 1) / 4) - (fingImageLayout.getWidth() / 2)));
        } else if (fingImageLayout == this.e) {
            m("resetPositionBottom:fingerLayoutTwo " + f2);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (float) ((this.h * 2) / 4));
        } else if (fingImageLayout == this.f) {
            m("resetPositionBottom:fingerLayoutExpansion " + f2);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fingImageLayout, "x", fingImageLayout.getX(), (float) ((this.h * 3) / 4));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.addListener(new f(fingImageLayout));
        animatorSet.start();
    }

    public void w(FingImageLayout fingImageLayout, int i) {
        fingImageLayout.resetViewSize(i);
    }

    public final void x() {
        MyApplication myApplication = WearUtils.x;
        AnalyticsBean analyticsBean = myApplication.r;
        if (analyticsBean == null || !analyticsBean.usedTouchPannel) {
            return;
        }
        analyticsBean.usedTouchPannel = false;
        myApplication.q(analyticsBean.getEvenString(), null);
    }

    public final synchronized void y() {
        if (!this.w && this.L != null) {
            this.t = "";
            this.u = "";
            if (!this.C || this.K.isEmpty()) {
                if (this.d.getVisibility() == 0) {
                    this.t += r(this.d) + TouchControlView.O;
                }
                if (this.e.getVisibility() == 0) {
                    this.t += r(this.e) + TouchControlView.O;
                }
                if (this.f.getVisibility() == 0) {
                    this.t += r(this.f) + TouchControlView.O;
                }
                if (this.t.endsWith(TouchControlView.O)) {
                    String str = this.t;
                    this.t = str.substring(0, str.length() - 1);
                }
                if (this.x == 1 && this.y) {
                    this.K.add(this.t);
                }
            } else {
                List<String> list = this.K;
                int i = this.D;
                this.D = i + 1;
                this.t = list.get(i % list.size());
            }
            if (this.f.getVisibility() == 0) {
                this.u = this.f.getTag() == null ? "" : this.f.getTag().toString() + TouchControlView.N + r(this.f);
            }
            this.B = this.z > 0;
            String fingerTags = getFingerTags();
            String[] strArrSplit = fingerTags.split(TouchControlView.O);
            String[] strArrSplit2 = this.t.split(TouchControlView.O);
            if (strArrSplit.length != strArrSplit2.length && this.G) {
                this.t = "";
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    if (i2 < strArrSplit2.length) {
                        this.t += strArrSplit2[i2] + ",";
                    } else {
                        this.t += strArrSplit2[0] + ",";
                    }
                }
                String str2 = this.t;
                this.t = str2.substring(0, str2.length() - 1);
            }
            m("tag：" + fingerTags + " group:" + this.t + " lastTag:" + this.M);
            h hVar = this.L;
            String str3 = this.t;
            String str4 = this.u;
            boolean z = this.B;
            if (!z) {
                z = this.A;
            }
            hVar.b(fingerTags, str3, str4, z, this.N);
        }
    }

    public void z(String str, int i) {
        this.f.setTag(str);
        this.f.setImageResource(i);
        Integer num = Toy.ICON_MAP_CONTROL_BACKGROUND.get(str);
        this.f.setBackgroundImageResource(num == null ? R.drawable.content_button_roundframe_pink : num.intValue());
        this.f.setVisibility(0);
    }
}

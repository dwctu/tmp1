package xyz.doikki.videoplayer.controller;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.ek4;
import dc.fk4;
import dc.gk4;
import dc.mj4;
import dc.nj4;
import dc.pj4;
import dc.qj4;
import dc.rj4;
import dc.zj4;
import io.agora.rtc2.Constants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class BaseVideoController extends FrameLayout implements pj4, rj4.a {
    public mj4 a;

    @Nullable
    public Activity b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public rj4 g;
    public boolean h;
    public Boolean i;
    public int j;
    public boolean k;
    public LinkedHashMap<nj4, Boolean> l;
    public Animation m;
    public Animation n;
    public final Runnable o;
    public Runnable p;
    public int q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseVideoController.this.a();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iC = BaseVideoController.this.C();
            if (!BaseVideoController.this.a.isPlaying()) {
                BaseVideoController.this.k = false;
            } else {
                BaseVideoController baseVideoController = BaseVideoController.this;
                baseVideoController.postDelayed(this, (long) ((1000 - (iC % 1000)) / baseVideoController.a.getSpeed()));
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseVideoController.this.g.enable();
        }
    }

    public BaseVideoController(@NonNull Context context) {
        this(context, null);
    }

    public void A() {
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            removeView(it.next().getKey().getView());
        }
        this.l.clear();
    }

    public void B() {
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                it.remove();
            }
        }
    }

    public final int C() {
        int currentPosition = (int) this.a.getCurrentPosition();
        q((int) this.a.getDuration(), currentPosition);
        return currentPosition;
    }

    public void D(int i, int i2) {
    }

    public boolean E() {
        return gk4.d(getContext()) == 4 && !zj4.d().e();
    }

    public void F() {
        this.a.n();
    }

    @Override // dc.pj4
    public void a() {
        if (this.c) {
            h();
            r(false, this.n);
            this.c = false;
        }
    }

    @Override // dc.pj4
    public boolean b() {
        Boolean bool = this.i;
        return bool != null && bool.booleanValue();
    }

    @Override // dc.rj4.a
    @CallSuper
    public void c(int i) {
        Activity activity = this.b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        int i2 = this.q;
        if (i == -1) {
            this.q = -1;
            return;
        }
        if (i > 350 || i < 10) {
            if ((this.b.getRequestedOrientation() == 0 && i2 == 0) || this.q == 0) {
                return;
            }
            this.q = 0;
            v(this.b);
            return;
        }
        if (i > 80 && i < 100) {
            if ((this.b.getRequestedOrientation() == 1 && i2 == 90) || this.q == 90) {
                return;
            }
            this.q = 90;
            w(this.b);
            return;
        }
        if (i <= 260 || i >= 280) {
            return;
        }
        if ((this.b.getRequestedOrientation() == 1 && i2 == 270) || this.q == 270) {
            return;
        }
        this.q = Constants.VIDEO_ORIENTATION_270;
        u(this.b);
    }

    @Override // dc.pj4
    public void e() {
        h();
        postDelayed(this.o, this.e);
    }

    @Override // dc.pj4
    public boolean g() {
        return this.d;
    }

    @Override // dc.pj4
    public int getCutoutHeight() {
        return this.j;
    }

    public abstract int getLayoutId();

    @Override // dc.pj4
    public void h() {
        removeCallbacks(this.o);
    }

    @Override // dc.pj4
    public void i() {
        if (this.k) {
            return;
        }
        post(this.p);
        this.k = true;
    }

    @Override // dc.pj4
    public boolean isShowing() {
        return this.c;
    }

    public void j(nj4 nj4Var, boolean z) {
        this.l.put(nj4Var, Boolean.valueOf(z));
        mj4 mj4Var = this.a;
        if (mj4Var != null) {
            nj4Var.e(mj4Var);
        }
        View view = nj4Var.getView();
        if (view == null || z) {
            return;
        }
        addView(view, 0);
    }

    @Override // dc.pj4
    public void k() {
        if (this.k) {
            removeCallbacks(this.p);
            this.k = false;
        }
    }

    public void l(nj4... nj4VarArr) {
        for (nj4 nj4Var : nj4VarArr) {
            j(nj4Var, false);
        }
    }

    public final void m() {
        if (this.h) {
            Activity activity = this.b;
            if (activity != null && this.i == null) {
                Boolean boolValueOf = Boolean.valueOf(ek4.b(activity));
                this.i = boolValueOf;
                if (boolValueOf.booleanValue()) {
                    this.j = (int) gk4.h(this.b);
                }
            }
            fk4.a("hasCutout: " + this.i + " cutout height: " + this.j);
        }
    }

    public final void n(boolean z) {
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().i(z);
        }
        t(z);
    }

    public final void o(int i) {
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().a(i);
        }
        x(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.a.isPlaying()) {
            if (this.f || this.a.c()) {
                if (z) {
                    postDelayed(new c(), 800L);
                } else {
                    this.g.disable();
                }
            }
        }
    }

    public final void p(int i) {
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().b(i);
        }
        y(i);
    }

    public final void q(int i, int i2) {
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().setProgress(i, i2);
        }
        D(i, i2);
    }

    public final void r(boolean z, Animation animation) {
        if (!this.d) {
            Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().d(z, animation);
            }
        }
        z(z, animation);
    }

    public void s() {
        if (getLayoutId() != 0) {
            LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        }
        this.g = new rj4(getContext().getApplicationContext());
        this.f = zj4.c().b;
        this.h = zj4.c().i;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.m = alphaAnimation;
        alphaAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.n = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.b = gk4.l(getContext());
    }

    public void setAdaptCutout(boolean z) {
        this.h = z;
    }

    public void setDismissTimeout(int i) {
        if (i > 0) {
            this.e = i;
        }
    }

    public void setEnableOrientation(boolean z) {
        this.f = z;
    }

    @Override // dc.pj4
    public void setLocked(boolean z) {
        this.d = z;
        n(z);
    }

    @CallSuper
    public void setMediaPlayer(qj4 qj4Var) {
        this.a = new mj4(qj4Var, this);
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().e(this.a);
        }
        this.g.a(this);
    }

    @CallSuper
    public void setPlayState(int i) {
        o(i);
    }

    @CallSuper
    public void setPlayerState(int i) {
        p(i);
    }

    @Override // dc.pj4
    public void show() {
        if (this.c) {
            return;
        }
        r(true, this.m);
        e();
        this.c = true;
    }

    public void t(boolean z) {
    }

    public void u(Activity activity) {
        activity.setRequestedOrientation(0);
        if (this.a.c()) {
            p(11);
        } else {
            this.a.j();
        }
    }

    public void v(Activity activity) {
        if (!this.d && this.f) {
            activity.setRequestedOrientation(1);
            this.a.f();
        }
    }

    public void w(Activity activity) {
        activity.setRequestedOrientation(8);
        if (this.a.c()) {
            p(11);
        } else {
            this.a.j();
        }
    }

    @CallSuper
    public void x(int i) {
        if (i == -1) {
            this.c = false;
            return;
        }
        if (i != 0) {
            if (i != 5) {
                return;
            }
            this.d = false;
            this.c = false;
            return;
        }
        this.g.disable();
        this.q = 0;
        this.d = false;
        this.c = false;
        B();
    }

    @CallSuper
    public void y(int i) {
        switch (i) {
            case 10:
                if (this.f) {
                    this.g.enable();
                } else {
                    this.g.disable();
                }
                if (b()) {
                    ek4.a(getContext(), false);
                    break;
                }
                break;
            case 11:
                this.g.enable();
                if (b()) {
                    ek4.a(getContext(), true);
                    break;
                }
                break;
            case 12:
                this.g.disable();
                break;
        }
    }

    public void z(boolean z, Animation animation) {
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.e = 4000;
        this.l = new LinkedHashMap<>();
        this.o = new a();
        this.p = new b();
        this.q = 0;
        s();
    }
}

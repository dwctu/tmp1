package dc;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class ed extends ad implements Choreographer.FrameCallback {

    @Nullable
    public f7 j;
    public float c = 1.0f;
    public boolean d = false;
    public long e = 0;
    public float f = 0.0f;
    public int g = 0;
    public float h = -2.1474836E9f;
    public float i = 2.1474836E9f;

    @VisibleForTesting
    public boolean k = false;

    public void A(int i) {
        z(i, (int) this.i);
    }

    public void B(float f) {
        this.c = f;
    }

    public final void C() {
        if (this.j == null) {
            return;
        }
        float f = this.f;
        if (f < this.h || f > this.i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.h), Float.valueOf(this.i), Float.valueOf(this.f)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        s();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        r();
        if (this.j == null || !isRunning()) {
            return;
        }
        e7.a("LottieValueAnimator#doFrame");
        float fK = (this.e != 0 ? j - r1 : 0L) / k();
        float f = this.f;
        if (o()) {
            fK = -fK;
        }
        float f2 = f + fK;
        this.f = f2;
        boolean z = !gd.e(f2, m(), l());
        this.f = gd.c(this.f, m(), l());
        this.e = j;
        e();
        if (z) {
            if (getRepeatCount() == -1 || this.g < getRepeatCount()) {
                c();
                this.g++;
                if (getRepeatMode() == 2) {
                    this.d = !this.d;
                    v();
                } else {
                    this.f = o() ? l() : m();
                }
                this.e = j;
            } else {
                this.f = this.c < 0.0f ? m() : l();
                s();
                b(o());
            }
        }
        C();
        e7.b("LottieValueAnimator#doFrame");
    }

    public void f() {
        this.j = null;
        this.h = -2.1474836E9f;
        this.i = 2.1474836E9f;
    }

    @MainThread
    public void g() {
        s();
        b(o());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float getAnimatedFraction() {
        float fM;
        float fL;
        float fM2;
        if (this.j == null) {
            return 0.0f;
        }
        if (o()) {
            fM = l() - this.f;
            fL = l();
            fM2 = m();
        } else {
            fM = this.f - m();
            fL = l();
            fM2 = m();
        }
        return fM / (fL - fM2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        f7 f7Var = this.j;
        if (f7Var == null) {
            return 0L;
        }
        return (long) f7Var.d();
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float h() {
        f7 f7Var = this.j;
        if (f7Var == null) {
            return 0.0f;
        }
        return (this.f - f7Var.o()) / (this.j.f() - this.j.o());
    }

    public float i() {
        return this.f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.k;
    }

    public final float k() {
        f7 f7Var = this.j;
        if (f7Var == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / f7Var.h()) / Math.abs(this.c);
    }

    public float l() {
        f7 f7Var = this.j;
        if (f7Var == null) {
            return 0.0f;
        }
        float f = this.i;
        return f == 2.1474836E9f ? f7Var.f() : f;
    }

    public float m() {
        f7 f7Var = this.j;
        if (f7Var == null) {
            return 0.0f;
        }
        float f = this.h;
        return f == -2.1474836E9f ? f7Var.o() : f;
    }

    public float n() {
        return this.c;
    }

    public final boolean o() {
        return n() < 0.0f;
    }

    @MainThread
    public void p() {
        s();
    }

    @MainThread
    public void q() {
        this.k = true;
        d(o());
        x((int) (o() ? l() : m()));
        this.e = 0L;
        this.g = 0;
        r();
    }

    public void r() {
        if (isRunning()) {
            t(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void s() {
        t(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.d) {
            return;
        }
        this.d = false;
        v();
    }

    @MainThread
    public void t(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.k = false;
        }
    }

    @MainThread
    public void u() {
        this.k = true;
        r();
        this.e = 0L;
        if (o() && i() == m()) {
            this.f = l();
        } else {
            if (o() || i() != l()) {
                return;
            }
            this.f = m();
        }
    }

    public void v() {
        B(-n());
    }

    public void w(f7 f7Var) {
        boolean z = this.j == null;
        this.j = f7Var;
        if (z) {
            z((int) Math.max(this.h, f7Var.o()), (int) Math.min(this.i, f7Var.f()));
        } else {
            z((int) f7Var.o(), (int) f7Var.f());
        }
        float f = this.f;
        this.f = 0.0f;
        x((int) f);
        e();
    }

    public void x(float f) {
        if (this.f == f) {
            return;
        }
        this.f = gd.c(f, m(), l());
        this.e = 0L;
        e();
    }

    public void y(float f) {
        z(this.h, f);
    }

    public void z(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        f7 f7Var = this.j;
        float fO = f7Var == null ? -3.4028235E38f : f7Var.o();
        f7 f7Var2 = this.j;
        float f3 = f7Var2 == null ? Float.MAX_VALUE : f7Var2.f();
        this.h = gd.c(f, fO, f3);
        this.i = gd.c(f2, fO, f3);
        x((int) gd.c(this.f, f, f2));
    }
}

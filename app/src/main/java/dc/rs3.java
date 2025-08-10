package dc;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* loaded from: classes4.dex */
public class rs3 {
    public static final Interpolator w = new a();
    public int a;
    public int b;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public int p;
    public OverScroller q;
    public final c r;
    public View s;
    public boolean t;
    public final ViewGroup u;
    public int c = -1;
    public final Runnable v = new b();

    /* compiled from: ViewDragHelper.java */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rs3.this.G(0);
        }
    }

    /* compiled from: ViewDragHelper.java */
    public static abstract class c {
        public int a(View view, int i, int i2) {
            return 0;
        }

        public abstract int b(View view, int i, int i2);

        public int c(int i) {
            return i;
        }

        public int d(View view) {
            return 0;
        }

        public abstract int e(View view);

        public void f(int i, int i2) {
        }

        public boolean g(int i) {
            return false;
        }

        public void h(int i, int i2) {
        }

        public abstract void i(View view, int i);

        public abstract void j(int i);

        public abstract void k(View view, int i, int i2, int i3, int i4);

        public abstract void l(View view, float f, float f2);

        public abstract boolean m(View view, int i);
    }

    public rs3(Context context, ViewGroup viewGroup, Interpolator interpolator, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(context, interpolator == null ? w : interpolator);
    }

    public static rs3 m(ViewGroup viewGroup, float f, Interpolator interpolator, c cVar) {
        rs3 rs3VarN = n(viewGroup, interpolator, cVar);
        rs3VarN.b = (int) (rs3VarN.b * (1.0f / f));
        return rs3VarN;
    }

    public static rs3 n(ViewGroup viewGroup, Interpolator interpolator, c cVar) {
        return new rs3(viewGroup.getContext(), viewGroup, interpolator, cVar);
    }

    public boolean A(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void B(MotionEvent motionEvent) {
        int i;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View viewS = s((int) x, (int) y);
            E(x, y, pointerId);
            L(viewS, pointerId);
            int i3 = this.h[pointerId];
            int i4 = this.p;
            if ((i3 & i4) != 0) {
                this.r.h(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.a == 1) {
                C();
            }
            b();
            return;
        }
        if (actionMasked == 2) {
            if (this.a == 1) {
                int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.c);
                float x2 = MotionEventCompat.getX(motionEvent, iFindPointerIndex);
                float y2 = MotionEventCompat.getY(motionEvent, iFindPointerIndex);
                float[] fArr = this.f;
                int i5 = this.c;
                int i6 = (int) (x2 - fArr[i5]);
                int i7 = (int) (y2 - this.g[i5]);
                q(this.s.getLeft() + i6, this.s.getTop() + i7, i6, i7);
                F(motionEvent);
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i2 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i2);
                float x3 = MotionEventCompat.getX(motionEvent, i2);
                float y3 = MotionEventCompat.getY(motionEvent, i2);
                float f = x3 - this.d[pointerId2];
                float f2 = y3 - this.e[pointerId2];
                D(f, f2, pointerId2);
                if (this.a != 1) {
                    View viewS2 = s((int) this.d[pointerId2], (int) this.e[pointerId2]);
                    if (e(viewS2, f, f2) && L(viewS2, pointerId2)) {
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    break;
                }
            }
            F(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.a == 1) {
                o(0.0f, 0.0f);
            }
            b();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x4 = MotionEventCompat.getX(motionEvent, actionIndex);
            float y4 = MotionEventCompat.getY(motionEvent, actionIndex);
            E(x4, y4, pointerId3);
            if (this.a != 0) {
                if (y((int) x4, (int) y4)) {
                    L(this.s, pointerId3);
                    return;
                }
                return;
            } else {
                L(s((int) x4, (int) y4), pointerId3);
                int i8 = this.h[pointerId3];
                int i9 = this.p;
                if ((i8 & i9) != 0) {
                    this.r.h(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
        if (this.a == 1 && pointerId4 == this.c) {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i2);
                if (pointerId5 != this.c) {
                    View viewS3 = s((int) MotionEventCompat.getX(motionEvent, i2), (int) MotionEventCompat.getY(motionEvent, i2));
                    View view = this.s;
                    if (viewS3 == view && L(view, pointerId5)) {
                        i = this.c;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                C();
            }
        }
        i(pointerId4);
    }

    public final void C() {
        this.l.computeCurrentVelocity(1000, this.m);
        o(f(VelocityTrackerCompat.getXVelocity(this.l, this.c), this.n, this.m), f(VelocityTrackerCompat.getYVelocity(this.l, this.c), this.n, this.m));
    }

    public final void D(float f, float f2, int i) {
        int i2 = d(f, f2, i, 1) ? 1 : 0;
        if (d(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (d(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (d(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.f(i2, i);
        }
    }

    public final void E(float f, float f2, int i) {
        r(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = v((int) f, (int) f2);
        this.k |= 1 << i;
    }

    public final void F(MotionEvent motionEvent) {
        float[] fArr;
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float x = MotionEventCompat.getX(motionEvent, i);
            float y = MotionEventCompat.getY(motionEvent, i);
            float[] fArr2 = this.f;
            if (fArr2 != null && (fArr = this.g) != null && fArr2.length > pointerId && fArr.length > pointerId) {
                fArr2[pointerId] = x;
                fArr[pointerId] = y;
            }
        }
    }

    public void G(int i) {
        if (this.a != i) {
            this.a = i;
            this.r.j(i);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    public void H(float f) {
        this.n = f;
    }

    public boolean I(int i, int i2) {
        if (this.t) {
            return t(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.l, this.c), (int) VelocityTrackerCompat.getYVelocity(this.l, this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean J(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.rs3.J(android.view.MotionEvent):boolean");
    }

    public boolean K(View view, int i, int i2, boolean z) {
        this.s = view;
        this.c = -1;
        return u(i, i2, 0, 0, z);
    }

    public boolean L(View view, int i) {
        if (view == this.s && this.c == i) {
            return true;
        }
        if (view == null || !this.r.m(view, i)) {
            return false;
        }
        this.c = i;
        c(view, i);
        return true;
    }

    public void a() {
        b();
        if (this.a == 2) {
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            this.q.abortAnimation();
            int currX2 = this.q.getCurrX();
            int currY2 = this.q.getCurrY();
            this.r.k(this.s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        G(0);
    }

    public void b() {
        this.c = -1;
        h();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void c(View view, int i) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.c = i;
            this.r.i(view, i);
            G(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public final boolean d(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.b;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.r.g(i2)) {
            return (this.i[i] & i2) == 0 && fAbs > ((float) this.b);
        }
        int[] iArr = this.j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    public final boolean e(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.d(view) > 0;
        boolean z2 = this.r.e(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
        }
        float f3 = (f * f) + (f2 * f2);
        int i = this.b;
        return f3 > ((float) (i * i));
    }

    public final float f(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    public final int g(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    public final void h() {
        float[] fArr = this.d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    public final void i(int i) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            return;
        }
        fArr[i] = 0.0f;
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = (~(1 << i)) & this.k;
    }

    public final int j(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f = width / 2;
        float fP = f + (p(Math.min(1.0f, Math.abs(i) / width)) * f);
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fP / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    public final int k(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int iG = g(i3, (int) this.n, (int) this.m);
        int iG2 = g(i4, (int) this.n, (int) this.m);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iG);
        int iAbs4 = Math.abs(iG2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iG != 0) {
            f = iAbs3;
            f2 = i5;
        } else {
            f = iAbs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (iG2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((j(i, iG, this.r.d(view)) * f5) + (j(i2, iG2, this.r.e(view)) * (f3 / f4)));
    }

    public boolean l(boolean z) {
        if (this.s == null) {
            return false;
        }
        if (this.a == 2) {
            boolean zComputeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (!zComputeScrollOffset && top != 0) {
                this.s.setTop(0);
                return true;
            }
            if (left != 0) {
                this.s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.r.k(this.s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                zComputeScrollOffset = this.q.isFinished();
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.u.post(this.v);
                } else {
                    G(0);
                }
            }
        }
        return this.a == 2;
    }

    public final void o(float f, float f2) {
        this.t = true;
        this.r.l(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            G(0);
        }
    }

    public final float p(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    public final void q(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            i = this.r.a(this.s, i, i3);
            this.s.offsetLeftAndRight(i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.r.b(this.s, i2, i4);
            this.s.offsetTopAndBottom(i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.r.k(this.s, i5, i6, i5 - left, i6 - top);
    }

    public final void r(int i) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    public View s(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.u;
            this.r.c(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean t(int i, int i2, int i3, int i4) {
        return u(i, i2, i3, i4, false);
    }

    public final boolean u(int i, int i2, int i3, int i4, boolean z) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.abortAnimation();
            G(0);
            return false;
        }
        if (z) {
            this.q.startScroll(left, top, i5, i6, 0);
        } else {
            this.q.startScroll(left, top, i5, i6, k(this.s, i5, i6, i3, i4));
        }
        this.s.invalidate();
        G(2);
        return true;
    }

    public final int v(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }

    public int w() {
        return this.b;
    }

    public int x() {
        return this.a;
    }

    public boolean y(int i, int i2) {
        return A(this.s, i, i2);
    }

    public boolean z() {
        return this.a == 1;
    }
}

package dc;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes.dex */
public class sh0 implements View.OnTouchListener, View.OnLayoutChangeListener {
    public static float F = 3.0f;
    public static float G = 1.75f;
    public static float K = 1.0f;
    public static int L = 200;
    public static int M = 1;
    public float B;
    public ImageView h;
    public GestureDetector i;
    public jh0 j;
    public lh0 p;
    public nh0 q;
    public mh0 r;
    public rh0 s;
    public View.OnClickListener t;
    public View.OnLongClickListener u;
    public oh0 v;
    public ph0 w;
    public qh0 x;
    public f y;
    public Interpolator a = new AccelerateDecelerateInterpolator();
    public int b = L;
    public float c = K;
    public float d = G;
    public float e = F;
    public boolean f = true;
    public boolean g = false;
    public final Matrix k = new Matrix();
    public final Matrix l = new Matrix();
    public final Matrix m = new Matrix();
    public final RectF n = new RectF();
    public final float[] o = new float[9];
    public int z = 2;
    public int A = 2;
    public boolean C = true;
    public ImageView.ScaleType D = ImageView.ScaleType.FIT_CENTER;
    public kh0 E = new a();

    /* compiled from: PhotoViewAttacher.java */
    public class a implements kh0 {
        public a() {
        }

        @Override // dc.kh0
        public void a(float f, float f2) {
            if (sh0.this.j.e()) {
                return;
            }
            if (sh0.this.x != null) {
                sh0.this.x.a(f, f2);
            }
            sh0.this.m.postTranslate(f, f2);
            sh0.this.B();
            ViewParent parent = sh0.this.h.getParent();
            if (!sh0.this.f || sh0.this.j.e() || sh0.this.g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((sh0.this.z == 2 || ((sh0.this.z == 0 && f >= 1.0f) || ((sh0.this.z == 1 && f <= -1.0f) || ((sh0.this.A == 0 && f2 >= 1.0f) || (sh0.this.A == 1 && f2 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // dc.kh0
        public void b(float f, float f2, float f3) {
            if (sh0.this.M() < sh0.this.e || f < 1.0f) {
                if (sh0.this.v != null) {
                    sh0.this.v.a(f, f2, f3);
                }
                sh0.this.m.postScale(f, f, f2, f3);
                sh0.this.B();
            }
        }

        @Override // dc.kh0
        public void c(float f, float f2, float f3, float f4) {
            sh0 sh0Var = sh0.this;
            sh0Var.y = sh0Var.new f(sh0Var.h.getContext());
            f fVar = sh0.this.y;
            sh0 sh0Var2 = sh0.this;
            int I = sh0Var2.I(sh0Var2.h);
            sh0 sh0Var3 = sh0.this;
            fVar.b(I, sh0Var3.H(sh0Var3.h), (int) f3, (int) f4);
            sh0.this.h.post(sh0.this.y);
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (sh0.this.w == null || sh0.this.M() > sh0.K || motionEvent.getPointerCount() > sh0.M || motionEvent2.getPointerCount() > sh0.M) {
                return false;
            }
            return sh0.this.w.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (sh0.this.u != null) {
                sh0.this.u.onLongClick(sh0.this.h);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fM = sh0.this.M();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (fM < sh0.this.K()) {
                    sh0 sh0Var = sh0.this;
                    sh0Var.i0(sh0Var.K(), x, y, true);
                } else if (fM < sh0.this.K() || fM >= sh0.this.J()) {
                    sh0 sh0Var2 = sh0.this;
                    sh0Var2.i0(sh0Var2.L(), x, y, true);
                } else {
                    sh0 sh0Var3 = sh0.this;
                    sh0Var3.i0(sh0Var3.J(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (sh0.this.t != null) {
                sh0.this.t.onClick(sh0.this.h);
            }
            RectF rectFD = sh0.this.D();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (sh0.this.s != null) {
                sh0.this.s.a(sh0.this.h, x, y);
            }
            if (rectFD == null) {
                return false;
            }
            if (!rectFD.contains(x, y)) {
                if (sh0.this.r == null) {
                    return false;
                }
                sh0.this.r.a(sh0.this.h);
                return false;
            }
            float fWidth = (x - rectFD.left) / rectFD.width();
            float fHeight = (y - rectFD.top) / rectFD.height();
            if (sh0.this.q == null) {
                return true;
            }
            sh0.this.q.a(sh0.this.h, fWidth, fHeight);
            return true;
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public class e implements Runnable {
        public final float a;
        public final float b;
        public final long c = System.currentTimeMillis();
        public final float d;
        public final float e;

        public e(float f, float f2, float f3, float f4) {
            this.a = f3;
            this.b = f4;
            this.d = f;
            this.e = f2;
        }

        public final float a() {
            return sh0.this.a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.c) * 1.0f) / sh0.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f = this.d;
            sh0.this.E.b((f + ((this.e - f) * fA)) / sh0.this.M(), this.a, this.b);
            if (fA < 1.0f) {
                ih0.a(sh0.this.h, this);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public class f implements Runnable {
        public final OverScroller a;
        public int b;
        public int c;

        public f(Context context) {
            this.a = new OverScroller(context);
        }

        public void a() {
            this.a.forceFinished(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            RectF rectFD = sh0.this.D();
            if (rectFD == null) {
                return;
            }
            int iRound3 = Math.round(-rectFD.left);
            float f = i;
            if (f < rectFD.width()) {
                iRound = Math.round(rectFD.width() - f);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = Math.round(-rectFD.top);
            float f2 = i2;
            if (f2 < rectFD.height()) {
                iRound2 = Math.round(rectFD.height() - f2);
                i6 = 0;
            } else {
                i6 = iRound4;
                iRound2 = i6;
            }
            this.b = iRound3;
            this.c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.a.fling(iRound3, iRound4, i3, i4, i5, iRound, i6, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isFinished() && this.a.computeScrollOffset()) {
                int currX = this.a.getCurrX();
                int currY = this.a.getCurrY();
                sh0.this.m.postTranslate(this.b - currX, this.c - currY);
                sh0.this.B();
                this.b = currX;
                this.c = currY;
                ih0.a(sh0.this.h, this);
            }
        }
    }

    public sh0(ImageView imageView) {
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.B = 0.0f;
        this.j = new jh0(imageView.getContext(), this.E);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    public final void A() {
        f fVar = this.y;
        if (fVar != null) {
            fVar.a();
            this.y = null;
        }
    }

    public final void B() {
        if (C()) {
            R(F());
        }
    }

    public final boolean C() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF rectFE = E(F());
        if (rectFE == null) {
            return false;
        }
        float fHeight = rectFE.height();
        float fWidth = rectFE.width();
        float fH = H(this.h);
        float f7 = 0.0f;
        if (fHeight <= fH) {
            int i = d.a[this.D.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f5 = (fH - fHeight) / 2.0f;
                    f6 = rectFE.top;
                } else {
                    f5 = fH - fHeight;
                    f6 = rectFE.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -rectFE.top;
            }
            this.A = 2;
        } else {
            float f8 = rectFE.top;
            if (f8 > 0.0f) {
                this.A = 0;
                f2 = -f8;
            } else {
                float f9 = rectFE.bottom;
                if (f9 < fH) {
                    this.A = 1;
                    f2 = fH - f9;
                } else {
                    this.A = -1;
                    f2 = 0.0f;
                }
            }
        }
        float fI = I(this.h);
        if (fWidth <= fI) {
            int i2 = d.a[this.D.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f3 = (fI - fWidth) / 2.0f;
                    f4 = rectFE.left;
                } else {
                    f3 = fI - fWidth;
                    f4 = rectFE.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -rectFE.left;
            }
            this.z = 2;
        } else {
            float f10 = rectFE.left;
            if (f10 > 0.0f) {
                this.z = 0;
                f7 = -f10;
            } else {
                float f11 = rectFE.right;
                if (f11 < fI) {
                    f7 = fI - f11;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        }
        this.m.postTranslate(f7, f2);
        return true;
    }

    public RectF D() {
        C();
        return E(F());
    }

    public final RectF E(Matrix matrix) {
        if (this.h.getDrawable() == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    public final Matrix F() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    public Matrix G() {
        return this.l;
    }

    public final int H(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int I(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public float J() {
        return this.e;
    }

    public float K() {
        return this.d;
    }

    public float L() {
        return this.c;
    }

    public float M() {
        return (float) Math.sqrt(((float) Math.pow(O(this.m, 0), 2.0d)) + ((float) Math.pow(O(this.m, 3), 2.0d)));
    }

    public ImageView.ScaleType N() {
        return this.D;
    }

    public final float O(Matrix matrix, int i) {
        matrix.getValues(this.o);
        return this.o[i];
    }

    public final void P() {
        this.m.reset();
        f0(this.B);
        R(F());
        C();
    }

    public void Q(boolean z) {
        this.f = z;
    }

    public final void R(Matrix matrix) {
        RectF rectFE;
        this.h.setImageMatrix(matrix);
        if (this.p == null || (rectFE = E(matrix)) == null) {
            return;
        }
        this.p.a(rectFE);
    }

    public void S(float f2) {
        th0.a(this.c, this.d, f2);
        this.e = f2;
    }

    public void T(float f2) {
        th0.a(this.c, f2, this.e);
        this.d = f2;
    }

    public void U(float f2) {
        th0.a(f2, this.d, this.e);
        this.c = f2;
    }

    public void V(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void W(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void X(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
    }

    public void Y(lh0 lh0Var) {
        this.p = lh0Var;
    }

    public void Z(mh0 mh0Var) {
        this.r = mh0Var;
    }

    public void a0(nh0 nh0Var) {
        this.q = nh0Var;
    }

    public void b0(oh0 oh0Var) {
        this.v = oh0Var;
    }

    public void c0(ph0 ph0Var) {
        this.w = ph0Var;
    }

    public void d0(qh0 qh0Var) {
        this.x = qh0Var;
    }

    public void e0(rh0 rh0Var) {
        this.s = rh0Var;
    }

    public void f0(float f2) {
        this.m.postRotate(f2 % 360.0f);
        B();
    }

    public void g0(float f2) {
        this.m.setRotate(f2 % 360.0f);
        B();
    }

    public void h0(float f2) {
        j0(f2, false);
    }

    public void i0(float f2, float f3, float f4, boolean z) {
        if (f2 < this.c || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.h.post(new e(M(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            B();
        }
    }

    public void j0(float f2, boolean z) {
        i0(f2, this.h.getRight() / 2, this.h.getBottom() / 2, z);
    }

    public void k0(float f2, float f3, float f4) {
        th0.a(f2, f3, f4);
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    public void l0(ImageView.ScaleType scaleType) {
        if (!th0.d(scaleType) || scaleType == this.D) {
            return;
        }
        this.D = scaleType;
        o0();
    }

    public void m0(int i) {
        this.b = i;
    }

    public void n0(boolean z) {
        this.C = z;
        o0();
    }

    public void o0() {
        if (this.C) {
            p0(this.h.getDrawable());
        } else {
            P();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        p0(this.h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.C
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lbe
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = dc.th0.c(r0)
            if (r0 == 0) goto Lbe
            int r0 = r12.getAction()
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L7a
        L1b:
            float r0 = r10.M()
            float r3 = r10.c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            android.graphics.RectF r0 = r10.D()
            if (r0 == 0) goto L7a
            dc.sh0$e r9 = new dc.sh0$e
            float r5 = r10.M()
            float r6 = r10.c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L6c
        L44:
            float r0 = r10.M()
            float r3 = r10.e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7a
            android.graphics.RectF r0 = r10.D()
            if (r0 == 0) goto L7a
            dc.sh0$e r9 = new dc.sh0$e
            float r5 = r10.M()
            float r6 = r10.e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L6c:
            r11 = 1
            goto L7b
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            r10.A()
        L7a:
            r11 = 0
        L7b:
            dc.jh0 r0 = r10.j
            if (r0 == 0) goto Lb2
            boolean r11 = r0.e()
            dc.jh0 r0 = r10.j
            boolean r0 = r0.d()
            dc.jh0 r3 = r10.j
            boolean r3 = r3.f(r12)
            if (r11 != 0) goto L9b
            dc.jh0 r11 = r10.j
            boolean r11 = r11.e()
            if (r11 != 0) goto L9b
            r11 = 1
            goto L9c
        L9b:
            r11 = 0
        L9c:
            if (r0 != 0) goto La8
            dc.jh0 r0 = r10.j
            boolean r0 = r0.d()
            if (r0 != 0) goto La8
            r0 = 1
            goto La9
        La8:
            r0 = 0
        La9:
            if (r11 == 0) goto Lae
            if (r0 == 0) goto Lae
            r1 = 1
        Lae:
            r10.g = r1
            r1 = r3
            goto Lb3
        Lb2:
            r1 = r11
        Lb3:
            android.view.GestureDetector r11 = r10.i
            if (r11 == 0) goto Lbe
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lbe
            r1 = 1
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.sh0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void p0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fI = I(this.h);
        float fH = H(this.h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.k.reset();
        float f2 = intrinsicWidth;
        float f3 = fI / f2;
        float f4 = intrinsicHeight;
        float f5 = fH / f4;
        ImageView.ScaleType scaleType = this.D;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.k.postTranslate((fI - f2) / 2.0f, (fH - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.k.postScale(fMax, fMax);
            this.k.postTranslate((fI - (f2 * fMax)) / 2.0f, (fH - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.k.postScale(fMin, fMin);
            this.k.postTranslate((fI - (f2 * fMin)) / 2.0f, (fH - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fI, fH);
            if (((int) this.B) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i = d.a[this.D.ordinal()];
            if (i == 1) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        P();
    }
}

package com.wear.ui.longDistance.imagepicker.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes4.dex */
public class PinchImageView extends AppCompatImageView {
    public View.OnClickListener a;
    public View.OnLongClickListener b;
    public Matrix c;
    public RectF d;
    public int e;
    public List<g> f;
    public List<g> g;
    public int h;
    public c i;
    public PointF j;
    public PointF k;
    public float l;
    public i m;
    public b n;
    public GestureDetector o;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (PinchImageView.this.e == 1 && (PinchImageView.this.m == null || !PinchImageView.this.m.isRunning())) {
                PinchImageView.this.m(motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (PinchImageView.this.e != 0) {
                return true;
            }
            if (PinchImageView.this.m != null && PinchImageView.this.m.isRunning()) {
                return true;
            }
            PinchImageView.this.n(f, f2);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PinchImageView.this.b != null) {
                PinchImageView.this.b.onLongClick(PinchImageView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (PinchImageView.this.a == null) {
                return true;
            }
            PinchImageView.this.a.onClick(PinchImageView.this);
            return true;
        }
    }

    public class b extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        public float[] a;

        public b(float f, float f2) {
            setFloatValues(0.0f, 1.0f);
            setDuration(1000000L);
            addUpdateListener(this);
            this.a = new float[]{f, f2};
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PinchImageView pinchImageView = PinchImageView.this;
            float[] fArr = this.a;
            boolean zX = pinchImageView.x(fArr[0], fArr[1]);
            float[] fArr2 = this.a;
            fArr2[0] = fArr2[0] * 0.9f;
            fArr2[1] = fArr2[1] * 0.9f;
            if (!zX || d.b(0.0f, 0.0f, fArr2[0], fArr2[1]) < 1.0f) {
                valueAnimator.cancel();
            }
        }
    }

    public class c extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
    }

    public static class d {
        public static e a = new e(16);
        public static h b = new h(16);

        public static float[] a(float f, float f2, float f3, float f4) {
            return new float[]{(f + f3) / 2.0f, (f2 + f4) / 2.0f};
        }

        public static float b(float f, float f2, float f3, float f4) {
            float f5 = f - f3;
            float f6 = f2 - f4;
            return (float) Math.sqrt((f5 * f5) + (f6 * f6));
        }

        public static float[] c(Matrix matrix) {
            if (matrix == null) {
                return new float[2];
            }
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            return new float[]{fArr[0], fArr[4]};
        }

        public static float[] d(float[] fArr, Matrix matrix) {
            if (fArr == null || matrix == null) {
                return new float[2];
            }
            float[] fArr2 = new float[2];
            Matrix matrixF = f();
            matrix.invert(matrixF);
            matrixF.mapPoints(fArr2, fArr);
            e(matrixF);
            return fArr2;
        }

        public static void e(Matrix matrix) {
            a.a(matrix);
        }

        public static Matrix f() {
            return a.d();
        }

        public static Matrix g(Matrix matrix) {
            Matrix matrixD = a.d();
            if (matrix != null) {
                matrixD.set(matrix);
            }
            return matrixD;
        }

        public static void h(RectF rectF) {
            b.a(rectF);
        }

        public static RectF i() {
            return b.d();
        }

        public static RectF j(float f, float f2, float f3, float f4) {
            RectF rectFD = b.d();
            rectFD.set(f, f2, f3, f4);
            return rectFD;
        }
    }

    public static class e extends f<Matrix> {
        public e(int i) {
            super(i);
        }

        @Override // com.wear.ui.longDistance.imagepicker.view.PinchImageView.f
        public /* bridge */ /* synthetic */ Matrix c(Matrix matrix) {
            Matrix matrix2 = matrix;
            f(matrix2);
            return matrix2;
        }

        @Override // com.wear.ui.longDistance.imagepicker.view.PinchImageView.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Matrix b() {
            return new Matrix();
        }

        public Matrix f(Matrix matrix) {
            matrix.reset();
            return matrix;
        }
    }

    public static abstract class f<T> {
        public int a;
        public Queue<T> b = new LinkedList();

        public f(int i) {
            this.a = i;
        }

        public void a(T t) {
            if (t == null || this.b.size() >= this.a) {
                return;
            }
            this.b.offer(t);
        }

        public abstract T b();

        public abstract T c(T t);

        public T d() {
            return this.b.size() == 0 ? b() : c(this.b.poll());
        }
    }

    public interface g {
        void a(PinchImageView pinchImageView);
    }

    public static class h extends f<RectF> {
        public h(int i) {
            super(i);
        }

        @Override // com.wear.ui.longDistance.imagepicker.view.PinchImageView.f
        public /* bridge */ /* synthetic */ RectF c(RectF rectF) {
            RectF rectF2 = rectF;
            f(rectF2);
            return rectF2;
        }

        @Override // com.wear.ui.longDistance.imagepicker.view.PinchImageView.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public RectF b() {
            return new RectF();
        }

        public RectF f(RectF rectF) {
            rectF.setEmpty();
            return rectF;
        }
    }

    public class i extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        public float[] a;
        public float[] b;
        public float[] c;

        public i(PinchImageView pinchImageView, Matrix matrix, Matrix matrix2) {
            this(matrix, matrix2, 200L);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.c;
                float[] fArr2 = this.a;
                fArr[i] = fArr2[i] + ((this.b[i] - fArr2[i]) * fFloatValue);
            }
            PinchImageView.this.c.setValues(this.c);
            PinchImageView.this.l();
            PinchImageView.this.invalidate();
        }

        public i(Matrix matrix, Matrix matrix2, long j) {
            this.a = new float[9];
            this.b = new float[9];
            this.c = new float[9];
            setFloatValues(0.0f, 1.0f);
            setDuration(j);
            addUpdateListener(this);
            matrix.getValues(this.a);
            matrix2.getValues(this.b);
        }
    }

    public PinchImageView(Context context) {
        super(context);
        this.c = new Matrix();
        this.e = 0;
        this.j = new PointF();
        this.k = new PointF();
        this.l = 0.0f;
        this.o = new GestureDetector(getContext(), new a());
        r();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.e == 2) {
            return true;
        }
        RectF rectFP = p(null);
        if (rectFP == null || rectFP.isEmpty()) {
            return false;
        }
        return i2 > 0 ? rectFP.right > ((float) getWidth()) : rectFP.left < 0.0f;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        if (this.e == 2) {
            return true;
        }
        RectF rectFP = p(null);
        if (rectFP == null || rectFP.isEmpty()) {
            return false;
        }
        return i2 > 0 ? rectFP.bottom > ((float) getHeight()) : rectFP.top < 0.0f;
    }

    public RectF getMask() {
        if (this.d != null) {
            return new RectF(this.d);
        }
        return null;
    }

    public float getMaxScale() {
        return 3.0f;
    }

    public int getPinchMode() {
        return this.e;
    }

    public float j(float f2, float f3) {
        if (f3 * f2 < 3.0f) {
            return 3.0f;
        }
        return f2;
    }

    public final void k() {
        i iVar = this.m;
        if (iVar != null) {
            iVar.cancel();
            this.m = null;
        }
        b bVar = this.n;
        if (bVar != null) {
            bVar.cancel();
            this.n = null;
        }
    }

    public final void l() {
        List<g> list;
        List<g> list2 = this.f;
        if (list2 == null) {
            return;
        }
        this.h++;
        Iterator<g> it = list2.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        int i2 = this.h - 1;
        this.h = i2;
        if (i2 != 0 || (list = this.g) == null) {
            return;
        }
        this.f = list;
        this.g = null;
    }

    public final void m(float f2, float f3) {
        if (s()) {
            Matrix matrixF = d.f();
            q(matrixF);
            float f4 = d.c(matrixF)[0];
            float f5 = d.c(this.c)[0];
            float f6 = f4 * f5;
            float width = getWidth();
            float height = getHeight();
            float maxScale = getMaxScale();
            float fJ = j(f4, f5);
            if (fJ <= maxScale) {
                maxScale = fJ;
            }
            if (maxScale >= f4) {
                f4 = maxScale;
            }
            Matrix matrixG = d.g(this.c);
            float f7 = f4 / f6;
            matrixG.postScale(f7, f7, f2, f3);
            float f8 = width / 2.0f;
            float f9 = height / 2.0f;
            matrixG.postTranslate(f8 - f2, f9 - f3);
            Matrix matrixG2 = d.g(matrixF);
            matrixG2.postConcat(matrixG);
            float f10 = 0.0f;
            RectF rectFJ = d.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            matrixG2.mapRect(rectFJ);
            float f11 = rectFJ.right;
            float f12 = rectFJ.left;
            float f13 = f11 - f12 < width ? f8 - ((f11 + f12) / 2.0f) : f12 > 0.0f ? -f12 : f11 < width ? width - f11 : 0.0f;
            float f14 = rectFJ.bottom;
            float f15 = rectFJ.top;
            if (f14 - f15 < height) {
                f10 = f9 - ((f14 + f15) / 2.0f);
            } else if (f15 > 0.0f) {
                f10 = -f15;
            } else if (f14 < height) {
                f10 = height - f14;
            }
            matrixG.postTranslate(f13, f10);
            k();
            i iVar = new i(this, this.c, matrixG);
            this.m = iVar;
            iVar.start();
            d.h(rectFJ);
            d.e(matrixG2);
            d.e(matrixG);
            d.e(matrixF);
        }
    }

    public final void n(float f2, float f3) {
        if (s()) {
            k();
            b bVar = new b(f2 / 60.0f, f3 / 60.0f);
            this.n = bVar;
            bVar.start();
        }
    }

    public Matrix o(Matrix matrix) {
        Matrix matrixQ = q(matrix);
        matrixQ.postConcat(this.c);
        return matrixQ;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (s()) {
            Matrix matrixF = d.f();
            setImageMatrix(o(matrixF));
            d.e(matrixF);
        }
        if (this.d == null) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(this.d);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i iVar;
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.e == 2) {
                w();
            }
            this.e = 0;
        } else if (action == 6) {
            if (this.e == 2 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    u(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    u(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 0) {
            i iVar2 = this.m;
            if (iVar2 == null || !iVar2.isRunning()) {
                k();
                this.e = 1;
                this.j.set(motionEvent.getX(), motionEvent.getY());
            }
        } else if (action == 5) {
            k();
            this.e = 2;
            u(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2 && ((iVar = this.m) == null || !iVar.isRunning())) {
            int i2 = this.e;
            if (i2 == 1) {
                x(motionEvent.getX() - this.j.x, motionEvent.getY() - this.j.y);
                this.j.set(motionEvent.getX(), motionEvent.getY());
            } else if (i2 == 2 && motionEvent.getPointerCount() > 1) {
                float fB = d.b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                float[] fArrA = d.a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                this.j.set(fArrA[0], fArrA[1]);
                v(this.k, this.l, fB, this.j);
            }
        }
        this.o.onTouchEvent(motionEvent);
        return true;
    }

    public RectF p(RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        } else {
            rectF.setEmpty();
        }
        if (!s()) {
            return rectF;
        }
        Matrix matrixF = d.f();
        o(matrixF);
        rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        matrixF.mapRect(rectF);
        d.e(matrixF);
        return rectF;
    }

    public Matrix q(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        } else {
            matrix.reset();
        }
        if (s()) {
            RectF rectFJ = d.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            RectF rectFJ2 = d.j(0.0f, 0.0f, getWidth(), getHeight());
            matrix.setRectToRect(rectFJ, rectFJ2, Matrix.ScaleToFit.CENTER);
            d.h(rectFJ2);
            d.h(rectFJ);
        }
        return matrix;
    }

    public final void r() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final boolean s() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0 && getWidth() > 0 && getHeight() > 0;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b = onLongClickListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    public void t() {
        this.c.reset();
        l();
        this.d = null;
        this.e = 0;
        this.j.set(0.0f, 0.0f);
        this.k.set(0.0f, 0.0f);
        this.l = 0.0f;
        c cVar = this.i;
        if (cVar != null) {
            cVar.cancel();
        }
        k();
        invalidate();
    }

    public final void u(float f2, float f3, float f4, float f5) {
        this.l = d.c(this.c)[0] / d.b(f2, f3, f4, f5);
        float[] fArrD = d.d(d.a(f2, f3, f4, f5), this.c);
        this.k.set(fArrD[0], fArrD[1]);
    }

    public final void v(PointF pointF, float f2, float f3, PointF pointF2) {
        if (s()) {
            float f4 = f2 * f3;
            Matrix matrixF = d.f();
            matrixF.postScale(f4, f4, pointF.x, pointF.y);
            matrixF.postTranslate(pointF2.x - pointF.x, pointF2.y - pointF.y);
            this.c.set(matrixF);
            d.e(matrixF);
            l();
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w() {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.longDistance.imagepicker.view.PinchImageView.w():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean x(float r9, float r10) {
        /*
            r8 = this;
            boolean r0 = r8.s()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.graphics.RectF r0 = com.wear.ui.longDistance.imagepicker.view.PinchImageView.d.i()
            r8.p(r0)
            int r2 = r8.getWidth()
            float r2 = (float) r2
            int r3 = r8.getHeight()
            float r3 = (float) r3
            float r4 = r0.right
            float r5 = r0.left
            float r6 = r4 - r5
            r7 = 0
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 >= 0) goto L26
        L24:
            r9 = 0
            goto L3e
        L26:
            float r6 = r5 + r9
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L32
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L24
            float r9 = -r5
            goto L3e
        L32:
            float r5 = r4 + r9
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 >= 0) goto L3e
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 <= 0) goto L24
            float r9 = r2 - r4
        L3e:
            float r2 = r0.bottom
            float r4 = r0.top
            float r5 = r2 - r4
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 >= 0) goto L4a
        L48:
            r10 = 0
            goto L62
        L4a:
            float r5 = r4 + r10
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L56
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 >= 0) goto L48
            float r10 = -r4
            goto L62
        L56:
            float r4 = r2 + r10
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 >= 0) goto L62
            int r10 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r10 <= 0) goto L48
            float r10 = r3 - r2
        L62:
            com.wear.ui.longDistance.imagepicker.view.PinchImageView.d.h(r0)
            android.graphics.Matrix r0 = r8.c
            r0.postTranslate(r9, r10)
            r8.l()
            r8.invalidate()
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 != 0) goto L7a
            int r9 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r9 == 0) goto L79
            goto L7a
        L79:
            return r1
        L7a:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.longDistance.imagepicker.view.PinchImageView.x(float, float):boolean");
    }

    public PinchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Matrix();
        this.e = 0;
        this.j = new PointF();
        this.k = new PointF();
        this.l = 0.0f;
        this.o = new GestureDetector(getContext(), new a());
        r();
    }

    public PinchImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new Matrix();
        this.e = 0;
        this.j = new PointF();
        this.k = new PointF();
        this.l = 0.0f;
        this.o = new GestureDetector(getContext(), new a());
        r();
    }
}

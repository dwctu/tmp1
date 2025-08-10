package com.wear.util.clipImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class ClipZoomImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static final String o = ClipZoomImageView.class.getSimpleName();
    public static float p = 4.0f;
    public static float q = 2.0f;
    public float a;
    public boolean b;
    public final float[] c;
    public ScaleGestureDetector d;
    public final Matrix e;
    public GestureDetector f;
    public boolean g;
    public int h;
    public float i;
    public float j;
    public boolean k;
    public int l;
    public int m;
    public int n;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ClipZoomImageView.this.g) {
                return true;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (ClipZoomImageView.this.getScale() < ClipZoomImageView.q) {
                ClipZoomImageView clipZoomImageView = ClipZoomImageView.this;
                clipZoomImageView.postDelayed(clipZoomImageView.new b(ClipZoomImageView.q, x, y), 16L);
                ClipZoomImageView.this.g = true;
            } else {
                ClipZoomImageView clipZoomImageView2 = ClipZoomImageView.this;
                clipZoomImageView2.postDelayed(clipZoomImageView2.new b(clipZoomImageView2.a, x, y), 16L);
                ClipZoomImageView.this.g = true;
            }
            return true;
        }
    }

    public class b implements Runnable {
        public float a;
        public float b;
        public float c;
        public float d;

        public b(float f, float f2, float f3) {
            this.a = f;
            this.c = f2;
            this.d = f3;
            if (ClipZoomImageView.this.getScale() < this.a) {
                this.b = 1.07f;
            } else {
                this.b = 0.93f;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = ClipZoomImageView.this.e;
            float f = this.b;
            matrix.postScale(f, f, this.c, this.d);
            ClipZoomImageView.this.g();
            ClipZoomImageView clipZoomImageView = ClipZoomImageView.this;
            clipZoomImageView.setImageMatrix(clipZoomImageView.e);
            float scale = ClipZoomImageView.this.getScale();
            float f2 = this.b;
            if ((f2 > 1.0f && scale < this.a) || (f2 < 1.0f && this.a < scale)) {
                ClipZoomImageView.this.postDelayed(this, 16L);
                return;
            }
            float f3 = this.a / scale;
            ClipZoomImageView.this.e.postScale(f3, f3, this.c, this.d);
            ClipZoomImageView.this.g();
            ClipZoomImageView clipZoomImageView2 = ClipZoomImageView.this;
            clipZoomImageView2.setImageMatrix(clipZoomImageView2.e);
            ClipZoomImageView.this.g = false;
        }
    }

    public ClipZoomImageView(Context context) {
        this(context, null);
    }

    private RectF getMatrixRectF() {
        Matrix matrix = this.e;
        RectF rectF = new RectF();
        if (getDrawable() != null) {
            rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    public final void g() {
        float f;
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        String str = "rect.width() =  " + matrixRectF.width() + " , width - 2 * mHorizontalPadding =" + (width - (this.m * 2));
        double dWidth = matrixRectF.width() + 0.01d;
        int i = this.m;
        if (dWidth >= width - (i * 2)) {
            float f2 = matrixRectF.left;
            f = f2 > ((float) i) ? (-f2) + i : 0.0f;
            float f3 = matrixRectF.right;
            if (f3 < width - i) {
                f = (width - i) - f3;
            }
        } else {
            f = 0.0f;
        }
        double dHeight = matrixRectF.height() + 0.01d;
        int i2 = this.n;
        if (dHeight >= height - (i2 * 2)) {
            float f4 = matrixRectF.top;
            f = f4 > ((float) i2) ? (-f4) + i2 : 0.0f;
            float f5 = matrixRectF.bottom;
            if (f5 < height - i2) {
                f = (height - i2) - f5;
            }
        }
        this.e.postTranslate(f, f);
    }

    public final float getScale() {
        this.e.getValues(this.c);
        return this.c[0];
    }

    public Bitmap h() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(bitmapCreateBitmap));
        return Bitmap.createBitmap(bitmapCreateBitmap, this.m, this.n, getWidth() - (this.m * 2), getWidth() - (this.m * 2));
    }

    public final boolean i(float f, float f2) {
        return Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.h);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        if (!this.b || (drawable = getDrawable()) == null) {
            return;
        }
        this.n = (getHeight() - (getWidth() - (this.m * 2))) / 2;
        int width = getWidth();
        int height = getHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float width2 = (intrinsicWidth >= getWidth() - (this.m * 2) || intrinsicHeight <= getHeight() - (this.n * 2)) ? 1.0f : ((getWidth() * 1.0f) - (this.m * 2)) / intrinsicWidth;
        if (intrinsicHeight < getHeight() - (this.n * 2) && intrinsicWidth > getWidth() - (this.m * 2)) {
            width2 = ((getHeight() * 1.0f) - (this.n * 2)) / intrinsicHeight;
        }
        if (intrinsicWidth < getWidth() - (this.m * 2) && intrinsicHeight < getHeight() - (this.n * 2)) {
            width2 = Math.max(((getWidth() * 1.0f) - (this.m * 2)) / intrinsicWidth, ((getHeight() * 1.0f) - (this.n * 2)) / intrinsicHeight);
        }
        this.a = width2;
        q = 2.0f * width2;
        p = 4.0f * width2;
        this.e.postTranslate((width - intrinsicWidth) / 2, (height - intrinsicHeight) / 2);
        this.e.postScale(width2, width2, getWidth() / 2, getHeight() / 2);
        setImageMatrix(this.e);
        this.b = false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        float f = p;
        if ((scale < f && scaleFactor > 1.0f) || (scale > this.a && scaleFactor < 1.0f)) {
            float f2 = scaleFactor * scale;
            float f3 = this.a;
            if (f2 < f3) {
                scaleFactor = f3 / scale;
            }
            if (scaleFactor * scale > f) {
                scaleFactor = f / scale;
            }
            this.e.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            g();
            setImageMatrix(this.e);
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            android.view.GestureDetector r10 = r9.f
            boolean r10 = r10.onTouchEvent(r11)
            r0 = 1
            if (r10 == 0) goto La
            return r0
        La:
            android.view.ScaleGestureDetector r10 = r9.d
            r10.onTouchEvent(r11)
            int r10 = r11.getPointerCount()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L18:
            if (r3 >= r10) goto L27
            float r6 = r11.getX(r3)
            float r4 = r4 + r6
            float r6 = r11.getY(r3)
            float r5 = r5 + r6
            int r3 = r3 + 1
            goto L18
        L27:
            float r3 = (float) r10
            float r4 = r4 / r3
            float r5 = r5 / r3
            int r3 = r9.l
            if (r10 == r3) goto L34
            r9.k = r1
            r9.i = r4
            r9.j = r5
        L34:
            r9.l = r10
            int r10 = r11.getAction()
            if (r10 == r0) goto L9c
            r11 = 2
            if (r10 == r11) goto L43
            r11 = 3
            if (r10 == r11) goto L9c
            goto L9e
        L43:
            float r10 = r9.i
            float r10 = r4 - r10
            float r1 = r9.j
            float r1 = r5 - r1
            boolean r3 = r9.k
            if (r3 != 0) goto L55
            boolean r3 = r9.i(r10, r1)
            r9.k = r3
        L55:
            boolean r3 = r9.k
            if (r3 == 0) goto L97
            android.graphics.drawable.Drawable r3 = r9.getDrawable()
            if (r3 == 0) goto L97
            android.graphics.RectF r3 = r9.getMatrixRectF()
            float r6 = r3.width()
            int r7 = r9.getWidth()
            int r8 = r9.m
            int r8 = r8 * 2
            int r7 = r7 - r8
            float r7 = (float) r7
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 > 0) goto L76
            r10 = 0
        L76:
            float r3 = r3.height()
            int r6 = r9.getHeight()
            int r7 = r9.n
            int r7 = r7 * 2
            int r6 = r6 - r7
            float r11 = (float) r6
            int r11 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r11 > 0) goto L89
            goto L8a
        L89:
            r2 = r1
        L8a:
            android.graphics.Matrix r11 = r9.e
            r11.postTranslate(r10, r2)
            r9.g()
            android.graphics.Matrix r10 = r9.e
            r9.setImageMatrix(r10)
        L97:
            r9.i = r4
            r9.j = r5
            goto L9e
        L9c:
            r9.l = r1
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.util.clipImage.ClipZoomImageView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setHorizontalPadding(int i) {
        this.m = i;
    }

    public ClipZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1.0f;
        this.b = true;
        this.c = new float[9];
        this.d = null;
        this.e = new Matrix();
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f = new GestureDetector(context, new a());
        this.d = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
    }
}

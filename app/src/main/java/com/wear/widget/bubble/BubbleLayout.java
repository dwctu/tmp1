package com.wear.widget.bubble;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import dc.ce3;
import dc.vi1;

/* loaded from: classes4.dex */
public class BubbleLayout extends FrameLayout {
    public int A;
    public c B;
    public Region C;
    public int D;
    public Bitmap E;
    public RectF F;
    public Rect G;
    public Paint K;
    public Paint L;
    public int M;
    public int N;
    public Paint O;
    public Paint a;
    public Path b;
    public b c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);

        public int value;

        b(int i) {
            this.value = i;
        }

        public static b getType(int i) {
            return i != 1 ? i != 2 ? i != 3 ? BOTTOM : RIGHT : TOP : LEFT;
        }
    }

    public interface c {
        void a();
    }

    public BubbleLayout(Context context) {
        this(context, null);
    }

    public final void a(TypedArray typedArray) {
        this.c = b.getType(typedArray.getInt(16, b.BOTTOM.value));
        this.k = typedArray.getDimensionPixelOffset(18, 0);
        this.l = typedArray.getDimensionPixelOffset(19, ce3.a(getContext(), 13.0f));
        this.m = typedArray.getDimensionPixelOffset(17, ce3.a(getContext(), 12.0f));
        this.o = typedArray.getDimensionPixelOffset(15, ce3.a(getContext(), 3.3f));
        this.p = typedArray.getDimensionPixelOffset(20, ce3.a(getContext(), 1.0f));
        this.q = typedArray.getDimensionPixelOffset(21, ce3.a(getContext(), 1.0f));
        this.r = typedArray.getDimensionPixelOffset(11, ce3.a(getContext(), 8.0f));
        this.t = typedArray.getDimensionPixelOffset(9, -1);
        this.u = typedArray.getDimensionPixelOffset(13, -1);
        this.v = typedArray.getDimensionPixelOffset(12, -1);
        this.w = typedArray.getDimensionPixelOffset(8, -1);
        this.x = typedArray.getDimensionPixelOffset(2, ce3.a(getContext(), 3.0f));
        this.y = typedArray.getDimensionPixelOffset(3, ce3.a(getContext(), 3.0f));
        this.z = typedArray.getDimensionPixelOffset(0, ce3.a(getContext(), 6.0f));
        this.A = typedArray.getDimensionPixelOffset(1, ce3.a(getContext(), 6.0f));
        this.d = typedArray.getDimensionPixelOffset(10, ce3.a(getContext(), 8.0f));
        this.n = typedArray.getColor(14, -7829368);
        this.s = typedArray.getColor(7, -1);
        int resourceId = typedArray.getResourceId(4, -1);
        this.D = resourceId;
        if (resourceId != -1) {
            this.E = BitmapFactory.decodeResource(getResources(), this.D);
        }
        this.M = typedArray.getColor(5, ViewCompat.MEASURED_STATE_MASK);
        this.N = typedArray.getDimensionPixelOffset(6, 0);
        typedArray.recycle();
    }

    public final void b() {
        this.a.setShadowLayer(this.o, this.p, this.q, this.n);
        this.O.setColor(this.M);
        this.O.setStrokeWidth(this.N);
        this.O.setStyle(Paint.Style.STROKE);
        int i = this.o;
        int i2 = this.p;
        int i3 = (i2 < 0 ? -i2 : 0) + i;
        b bVar = this.c;
        this.g = i3 + (bVar == b.LEFT ? this.m : 0);
        int i4 = this.q;
        this.h = (i4 < 0 ? -i4 : 0) + i + (bVar == b.TOP ? this.m : 0);
        this.i = ((this.e - i) + (i2 > 0 ? -i2 : 0)) - (bVar == b.RIGHT ? this.m : 0);
        this.j = ((this.f - i) + (i4 > 0 ? -i4 : 0)) - (bVar == b.BOTTOM ? this.m : 0);
        this.a.setColor(this.s);
        this.b.reset();
        int i5 = this.k;
        int i6 = this.m + i5;
        int i7 = this.j;
        if (i6 > i7) {
            i5 = i7 - this.l;
        }
        int iMax = Math.max(i5, this.o);
        int i8 = this.k;
        int i9 = this.m + i8;
        int i10 = this.i;
        if (i9 > i10) {
            i8 = i10 - this.l;
        }
        int iMax2 = Math.max(i8, this.o);
        int i11 = a.a[this.c.ordinal()];
        if (i11 == 1) {
            if (iMax2 >= getLDR() + this.A) {
                this.b.moveTo(iMax2 - r2, this.j);
                Path path = this.b;
                int i12 = this.A;
                int i13 = this.l;
                int i14 = this.m;
                path.rCubicTo(i12, 0.0f, i12 + ((i13 / 2.0f) - this.y), i14, (i13 / 2.0f) + i12, i14);
            } else {
                this.b.moveTo(iMax2 + (this.l / 2.0f), this.j + this.m);
            }
            int i15 = this.l + iMax2;
            int rdr = this.i - getRDR();
            int i16 = this.z;
            if (i15 < rdr - i16) {
                Path path2 = this.b;
                float f = this.x;
                int i17 = this.l;
                int i18 = this.m;
                path2.rCubicTo(f, 0.0f, i17 / 2.0f, -i18, (i17 / 2.0f) + i16, -i18);
                this.b.lineTo(this.i - getRDR(), this.j);
            }
            Path path3 = this.b;
            int i19 = this.i;
            path3.quadTo(i19, this.j, i19, r5 - getRDR());
            this.b.lineTo(this.i, this.h + getRTR());
            this.b.quadTo(this.i, this.h, r2 - getRTR(), this.h);
            this.b.lineTo(this.g + getLTR(), this.h);
            Path path4 = this.b;
            int i20 = this.g;
            path4.quadTo(i20, this.h, i20, r5 + getLTR());
            this.b.lineTo(this.g, this.j - getLDR());
            if (iMax2 >= getLDR() + this.A) {
                this.b.quadTo(this.g, this.j, r1 + getLDR(), this.j);
            } else {
                this.b.quadTo(this.g, this.j, iMax2 + (this.l / 2.0f), r3 + this.m);
            }
        } else if (i11 == 2) {
            if (iMax2 >= getLTR() + this.z) {
                this.b.moveTo(iMax2 - r2, this.h);
                Path path5 = this.b;
                int i21 = this.z;
                int i22 = this.l;
                int i23 = this.m;
                path5.rCubicTo(i21, 0.0f, i21 + ((i22 / 2.0f) - this.x), -i23, (i22 / 2.0f) + i21, -i23);
            } else {
                this.b.moveTo(iMax2 + (this.l / 2.0f), this.h - this.m);
            }
            int i24 = this.l + iMax2;
            int rtr = this.i - getRTR();
            int i25 = this.A;
            if (i24 < rtr - i25) {
                Path path6 = this.b;
                float f2 = this.y;
                int i26 = this.l;
                int i27 = this.m;
                path6.rCubicTo(f2, 0.0f, i26 / 2.0f, i27, (i26 / 2.0f) + i25, i27);
                this.b.lineTo(this.i - getRTR(), this.h);
            }
            Path path7 = this.b;
            int i28 = this.i;
            path7.quadTo(i28, this.h, i28, r5 + getRTR());
            this.b.lineTo(this.i, this.j - getRDR());
            this.b.quadTo(this.i, this.j, r2 - getRDR(), this.j);
            this.b.lineTo(this.g + getLDR(), this.j);
            Path path8 = this.b;
            int i29 = this.g;
            path8.quadTo(i29, this.j, i29, r5 - getLDR());
            this.b.lineTo(this.g, this.h + getLTR());
            if (iMax2 >= getLTR() + this.z) {
                this.b.quadTo(this.g, this.h, r1 + getLTR(), this.h);
            } else {
                this.b.quadTo(this.g, this.h, iMax2 + (this.l / 2.0f), r3 - this.m);
            }
        } else if (i11 == 3) {
            if (iMax >= getLTR() + this.A) {
                this.b.moveTo(this.g, iMax - r2);
                Path path9 = this.b;
                int i30 = this.A;
                int i31 = this.m;
                int i32 = this.l;
                path9.rCubicTo(0.0f, i30, -i31, ((i32 / 2.0f) - this.y) + i30, -i31, (i32 / 2.0f) + i30);
            } else {
                this.b.moveTo(this.g - this.m, iMax + (this.l / 2.0f));
            }
            int i33 = this.l + iMax;
            int ldr = this.j - getLDR();
            int i34 = this.z;
            if (i33 < ldr - i34) {
                Path path10 = this.b;
                float f3 = this.x;
                int i35 = this.m;
                int i36 = this.l;
                path10.rCubicTo(0.0f, f3, i35, i36 / 2.0f, i35, (i36 / 2.0f) + i34);
                this.b.lineTo(this.g, this.j - getLDR());
            }
            this.b.quadTo(this.g, this.j, r2 + getLDR(), this.j);
            this.b.lineTo(this.i - getRDR(), this.j);
            Path path11 = this.b;
            int i37 = this.i;
            path11.quadTo(i37, this.j, i37, r5 - getRDR());
            this.b.lineTo(this.i, this.h + getRTR());
            this.b.quadTo(this.i, this.h, r2 - getRTR(), this.h);
            this.b.lineTo(this.g + getLTR(), this.h);
            if (iMax >= getLTR() + this.A) {
                Path path12 = this.b;
                int i38 = this.g;
                path12.quadTo(i38, this.h, i38, r3 + getLTR());
            } else {
                this.b.quadTo(this.g, this.h, r2 - this.m, iMax + (this.l / 2.0f));
            }
        } else if (i11 == 4) {
            if (iMax >= getRTR() + this.z) {
                this.b.moveTo(this.i, iMax - r2);
                Path path13 = this.b;
                int i39 = this.z;
                int i40 = this.m;
                int i41 = this.l;
                path13.rCubicTo(0.0f, i39, i40, ((i41 / 2.0f) - this.x) + i39, i40, (i41 / 2.0f) + i39);
            } else {
                this.b.moveTo(this.i + this.m, iMax + (this.l / 2.0f));
            }
            int i42 = this.l + iMax;
            int rdr2 = this.j - getRDR();
            int i43 = this.A;
            if (i42 < rdr2 - i43) {
                Path path14 = this.b;
                float f4 = this.y;
                int i44 = this.m;
                int i45 = this.l;
                path14.rCubicTo(0.0f, f4, -i44, i45 / 2.0f, -i44, (i45 / 2.0f) + i43);
                this.b.lineTo(this.i, this.j - getRDR());
            }
            this.b.quadTo(this.i, this.j, r2 - getRDR(), this.j);
            this.b.lineTo(this.g + getLDR(), this.j);
            Path path15 = this.b;
            int i46 = this.g;
            path15.quadTo(i46, this.j, i46, r5 - getLDR());
            this.b.lineTo(this.g, this.h + getLTR());
            this.b.quadTo(this.g, this.h, r2 + getLTR(), this.h);
            this.b.lineTo(this.i - getRTR(), this.h);
            if (iMax >= getRTR() + this.z) {
                Path path16 = this.b;
                int i47 = this.i;
                path16.quadTo(i47, this.h, i47, r3 + getRTR());
            } else {
                this.b.quadTo(this.i, this.h, r2 + this.m, iMax + (this.l / 2.0f));
            }
        }
        this.b.close();
    }

    public void c() {
        int i = this.d + this.o;
        int i2 = a.a[this.c.ordinal()];
        if (i2 == 1) {
            setPadding(i, i, this.p + i, this.m + i + this.q);
            return;
        }
        if (i2 == 2) {
            setPadding(i, this.m + i, this.p + i, this.q + i);
        } else if (i2 == 3) {
            setPadding(this.m + i, i, this.p + i, this.q + i);
        } else {
            if (i2 != 4) {
                return;
            }
            setPadding(i, i, this.m + i + this.p, this.q + i);
        }
    }

    public int getArrowDownLeftRadius() {
        return this.z;
    }

    public int getArrowDownRightRadius() {
        return this.A;
    }

    public int getArrowTopLeftRadius() {
        return this.x;
    }

    public int getArrowTopRightRadius() {
        return this.y;
    }

    public int getBubbleColor() {
        return this.s;
    }

    public int getBubbleRadius() {
        return this.r;
    }

    public int getLDR() {
        int i = this.w;
        return i == -1 ? this.r : i;
    }

    public int getLTR() {
        int i = this.t;
        return i == -1 ? this.r : i;
    }

    public b getLook() {
        return this.c;
    }

    public int getLookLength() {
        return this.m;
    }

    public int getLookPosition() {
        return this.k;
    }

    public int getLookWidth() {
        return this.l;
    }

    public Paint getPaint() {
        return this.a;
    }

    public Path getPath() {
        return this.b;
    }

    public int getRDR() {
        int i = this.v;
        return i == -1 ? this.r : i;
    }

    public int getRTR() {
        int i = this.u;
        return i == -1 ? this.r : i;
    }

    public int getShadowColor() {
        return this.n;
    }

    public int getShadowRadius() {
        return this.o;
    }

    public int getShadowX() {
        return this.p;
    }

    public int getShadowY() {
        return this.q;
    }

    @Override // android.view.View
    public void invalidate() {
        b();
        super.invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.b, this.a);
        if (this.E != null) {
            this.b.computeBounds(this.F, true);
            int iSaveLayer = canvas.saveLayer(this.F, null, 31);
            canvas.drawPath(this.b, this.L);
            float fWidth = this.F.width() / this.F.height();
            if (fWidth > (this.E.getWidth() * 1.0f) / this.E.getHeight()) {
                int height = (int) ((this.E.getHeight() - (this.E.getWidth() / fWidth)) / 2.0f);
                this.G.set(0, height, this.E.getWidth(), ((int) (this.E.getWidth() / fWidth)) + height);
            } else {
                int width = (int) ((this.E.getWidth() - (this.E.getHeight() * fWidth)) / 2.0f);
                this.G.set(width, 0, ((int) (this.E.getHeight() * fWidth)) + width, this.E.getHeight());
            }
            canvas.drawBitmap(this.E, this.G, this.F, this.K);
            canvas.restoreToCount(iSaveLayer);
        }
        if (this.N != 0) {
            canvas.drawPath(this.b, this.O);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.k = bundle.getInt("mLookPosition");
        this.l = bundle.getInt("mLookWidth");
        this.m = bundle.getInt("mLookLength");
        this.n = bundle.getInt("mShadowColor");
        this.o = bundle.getInt("mShadowRadius");
        this.p = bundle.getInt("mShadowX");
        this.q = bundle.getInt("mShadowY");
        this.r = bundle.getInt("mBubbleRadius");
        this.t = bundle.getInt("mLTR");
        this.u = bundle.getInt("mRTR");
        this.v = bundle.getInt("mRDR");
        this.w = bundle.getInt("mLDR");
        this.d = bundle.getInt("mBubblePadding");
        this.x = bundle.getInt("mArrowTopLeftRadius");
        this.y = bundle.getInt("mArrowTopRightRadius");
        this.z = bundle.getInt("mArrowDownLeftRadius");
        this.A = bundle.getInt("mArrowDownRightRadius");
        this.e = bundle.getInt("mWidth");
        this.f = bundle.getInt("mHeight");
        this.g = bundle.getInt("mLeft");
        this.h = bundle.getInt("mTop");
        this.i = bundle.getInt("mRight");
        this.j = bundle.getInt("mBottom");
        int i = bundle.getInt("mBubbleBgRes");
        this.D = i;
        if (i != -1) {
            this.E = BitmapFactory.decodeResource(getResources(), this.D);
        }
        this.N = bundle.getInt("mBubbleBorderSize");
        this.M = bundle.getInt("mBubbleBorderColor");
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mLookPosition", this.k);
        bundle.putInt("mLookWidth", this.l);
        bundle.putInt("mLookLength", this.m);
        bundle.putInt("mShadowColor", this.n);
        bundle.putInt("mShadowRadius", this.o);
        bundle.putInt("mShadowX", this.p);
        bundle.putInt("mShadowY", this.q);
        bundle.putInt("mBubbleRadius", this.r);
        bundle.putInt("mLTR", this.t);
        bundle.putInt("mRTR", this.u);
        bundle.putInt("mRDR", this.v);
        bundle.putInt("mLDR", this.w);
        bundle.putInt("mBubblePadding", this.d);
        bundle.putInt("mArrowTopLeftRadius", this.x);
        bundle.putInt("mArrowTopRightRadius", this.y);
        bundle.putInt("mArrowDownLeftRadius", this.z);
        bundle.putInt("mArrowDownRightRadius", this.A);
        bundle.putInt("mWidth", this.e);
        bundle.putInt("mHeight", this.f);
        bundle.putInt("mLeft", this.g);
        bundle.putInt("mTop", this.h);
        bundle.putInt("mRight", this.i);
        bundle.putInt("mBottom", this.j);
        bundle.putInt("mBubbleBgRes", this.D);
        bundle.putInt("mBubbleBorderColor", this.M);
        bundle.putInt("mBubbleBorderSize", this.N);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = i;
        this.f = i2;
        b();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        if (motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            this.b.computeBounds(rectF, true);
            this.C.setPath(this.b, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            if (!this.C.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && (cVar = this.B) != null) {
                cVar.a();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void postInvalidate() {
        b();
        super.postInvalidate();
    }

    public void setArrowDownLeftRadius(int i) {
        this.z = i;
    }

    public void setArrowDownRightRadius(int i) {
        this.A = i;
    }

    public void setArrowTopLeftRadius(int i) {
        this.x = i;
    }

    public void setArrowTopRightRadius(int i) {
        this.y = i;
    }

    public void setBubbleBorderColor(int i) {
        this.M = i;
    }

    public void setBubbleBorderSize(int i) {
        this.N = i;
    }

    public void setBubbleColor(int i) {
        this.s = i;
    }

    public void setBubbleImageBg(Bitmap bitmap) {
        this.E = bitmap;
    }

    public void setBubbleImageBgRes(int i) {
        this.E = BitmapFactory.decodeResource(getResources(), i);
    }

    public void setBubblePadding(int i) {
        this.d = i;
    }

    public void setBubbleRadius(int i) {
        this.r = i;
    }

    public void setLDR(int i) {
        this.w = i;
    }

    public void setLTR(int i) {
        this.t = i;
    }

    public void setLook(b bVar) {
        this.c = bVar;
        c();
    }

    public void setLookLength(int i) {
        this.m = i;
        c();
    }

    public void setLookPosition(int i) {
        this.k = i;
    }

    public void setLookWidth(int i) {
        this.l = i;
    }

    public void setOnClickEdgeListener(c cVar) {
        this.B = cVar;
    }

    public void setRDR(int i) {
        this.v = i;
    }

    public void setRTR(int i) {
        this.u = i;
    }

    public void setShadowColor(int i) {
        this.n = i;
    }

    public void setShadowRadius(int i) {
        this.o = i;
    }

    public void setShadowX(int i) {
        this.p = i;
    }

    public void setShadowY(int i) {
        this.q = i;
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.C = new Region();
        this.D = -1;
        this.E = null;
        this.F = new RectF();
        this.G = new Rect();
        this.K = new Paint(5);
        this.L = new Paint(5);
        this.M = ViewCompat.MEASURED_STATE_MASK;
        this.N = 0;
        this.O = new Paint(5);
        setWillNotDraw(false);
        a(context.obtainStyledAttributes(attributeSet, vi1.BubbleLayout, i, 0));
        Paint paint = new Paint(5);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.b = new Path();
        this.K.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        c();
        setLayerType(1, null);
    }
}

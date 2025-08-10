package com.wear.widget.shadow;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import com.zhy.autolayout.AutoFrameLayout;
import dc.aj4;
import dc.dj4;
import dc.dt3;
import dc.vi1;
import java.util.Objects;

/* loaded from: classes4.dex */
public class ShadowLayout extends AutoFrameLayout implements aj4 {
    public Drawable A;
    public Drawable B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int K;
    public int L;
    public float M;
    public int N;
    public int O;
    public float P;
    public float Q;
    public boolean R;
    public Drawable S;
    public int T;
    public int U;
    public TextView V;
    public int W;
    public int a0;
    public Paint b;
    public String b0;
    public int c;
    public String c0;
    public float d;
    public Paint d0;
    public float e;
    public Path e0;
    public float f;
    public View.OnClickListener f0;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public RectF t;
    public View u;
    public boolean v;
    public boolean w;
    public dj4 x;
    public int y;
    public GradientDrawable z;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ShadowLayout.this.removeOnLayoutChangeListener(this);
            ShadowLayout shadowLayout = ShadowLayout.this;
            shadowLayout.setSelected(shadowLayout.isSelected());
        }
    }

    public ShadowLayout(Context context) {
        this(context, null);
    }

    public static int c(String str) throws IllegalArgumentException {
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        return Color.parseColor(str);
    }

    @Override // dc.aj4
    public void P1() {
        x();
        t(this.c);
        y();
        r(this.C);
    }

    public final void b() {
        View view;
        if (this.y != 1 || (view = this.u) == null) {
            return;
        }
        if (this.R) {
            Drawable drawable = this.A;
            if (drawable != null) {
                w(drawable, "changeSwitchClickable");
            } else if (view.getBackground() != null) {
                this.u.getBackground().setAlpha(0);
            }
            GradientDrawable gradientDrawable = this.z;
            int i = this.C;
            gradientDrawable.setColors(new int[]{i, i});
            postInvalidate();
            return;
        }
        if (this.T != -101) {
            if (this.A != null) {
                view.getBackground().setAlpha(0);
            }
            GradientDrawable gradientDrawable2 = this.z;
            int i2 = this.T;
            gradientDrawable2.setColors(new int[]{i2, i2});
            postInvalidate();
            return;
        }
        Drawable drawable2 = this.S;
        if (drawable2 != null) {
            w(drawable2, "changeSwitchClickable");
            this.z.setColors(new int[]{Color.parseColor("#00000000"), Color.parseColor("#00000000")});
            postInvalidate();
        }
    }

    public final Bitmap d(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        float f5 = f3 / 4.0f;
        float f6 = f4 / 4.0f;
        int i5 = i / 4;
        if (i5 == 0) {
            i5 = 1;
        }
        int i6 = i2 / 4;
        if (i6 == 0) {
            i6 = 1;
        }
        float f7 = f / 4.0f;
        float f8 = f2 / 4.0f;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(this.l ? f8 : Math.max(Math.max(Math.max(f7, this.h), Math.max(f7, this.j)), f8) / 2.0f, this.n ? f8 : Math.max(Math.max(Math.max(f7, this.h), Math.max(f7, this.i)), f8) / 2.0f, this.m ? i5 - f8 : i5 - (Math.max(Math.max(Math.max(f7, this.i), Math.max(f7, this.k)), f8) / 2.0f), this.o ? i6 - f8 : i6 - (Math.max(Math.max(Math.max(f7, this.j), Math.max(f7, this.k)), f8) / 2.0f));
        if (this.v) {
            if (f6 > 0.0f) {
                rectF.top += f6;
                rectF.bottom -= f6;
            } else if (f6 < 0.0f) {
                rectF.top += Math.abs(f6);
                rectF.bottom -= Math.abs(f6);
            }
            if (f5 > 0.0f) {
                rectF.left += f5;
                rectF.right -= f5;
            } else if (f5 < 0.0f) {
                rectF.left += Math.abs(f5);
                rectF.right -= Math.abs(f5);
            }
        } else {
            rectF.top -= f6;
            rectF.bottom -= f6;
            rectF.right -= f5;
            rectF.left -= f5;
        }
        this.b.setColor(i4);
        if (!isInEditMode()) {
            this.b.setShadowLayer(f8 / 2.0f, f5, f6, i3);
        }
        if (this.j == -1.0f && this.h == -1.0f && this.i == -1.0f && this.k == -1.0f) {
            canvas.drawRoundRect(rectF, f7, f7, this.b);
        } else {
            RectF rectF2 = this.t;
            rectF2.left = this.p;
            rectF2.top = this.q;
            rectF2.right = getWidth() - this.r;
            this.t.bottom = getHeight() - this.s;
            this.b.setAntiAlias(true);
            float f9 = this.h;
            int i7 = f9 == -1.0f ? ((int) this.g) / 4 : ((int) f9) / 4;
            float f10 = this.j;
            int i8 = f10 == -1.0f ? ((int) this.g) / 4 : ((int) f10) / 4;
            float f11 = this.i;
            int i9 = f11 == -1.0f ? ((int) this.g) / 4 : ((int) f11) / 4;
            float f12 = this.k;
            float f13 = i7;
            float f14 = i9;
            float f15 = f12 == -1.0f ? ((int) this.g) / 4 : ((int) f12) / 4;
            float f16 = i8;
            float[] fArr = {f13, f13, f14, f14, f15, f15, f16, f16};
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, this.b);
        }
        return bitmapCreateBitmap;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        RectF rectF = this.t;
        int i = (int) (rectF.bottom - rectF.top);
        if (getChildAt(0) != null) {
            if (this.h == -1.0f && this.j == -1.0f && this.i == -1.0f && this.k == -1.0f) {
                float f = i / 2;
                if (this.g > f) {
                    Path path = new Path();
                    path.addRoundRect(this.t, f, f, Path.Direction.CW);
                    canvas.clipPath(path);
                } else {
                    Path path2 = new Path();
                    RectF rectF2 = this.t;
                    float f2 = this.g;
                    path2.addRoundRect(rectF2, f2, f2, Path.Direction.CW);
                    canvas.clipPath(path2);
                }
            } else {
                float[] fArrH = h(i);
                Path path3 = new Path();
                path3.addRoundRect(this.p, this.q, getWidth() - this.r, getHeight() - this.s, fArrH, Path.Direction.CW);
                canvas.clipPath(path3);
            }
        }
        super.dispatchDraw(canvas);
    }

    public final int e(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void f(Canvas canvas, RectF rectF, float[] fArr) {
        this.z.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        if (this.N != -101) {
            if (this.P != -1.0f) {
                this.z.setStroke(Math.round(this.M), this.L, this.P, this.Q);
            } else {
                this.z.setStroke(Math.round(this.M), this.L);
            }
        }
        this.z.setCornerRadii(fArr);
        this.z.draw(canvas);
    }

    public void g(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width > height) {
            this.d0.setStrokeWidth(height);
            this.e0.reset();
            float f = height / 2;
            this.e0.moveTo(0.0f, f);
            this.e0.lineTo(width, f);
        } else {
            this.d0.setStrokeWidth(width);
            this.e0.reset();
            float f2 = width / 2;
            this.e0.moveTo(f2, 0.0f);
            this.e0.lineTo(f2, height);
        }
        canvas.drawPath(this.e0, this.d0);
    }

    public float getCornerRadius() {
        return this.g;
    }

    public float getShadowLimit() {
        return this.d;
    }

    public final float[] h(int i) {
        float f = this.h;
        if (f == -1.0f) {
            f = this.g;
        }
        int i2 = (int) f;
        int i3 = i / 2;
        if (i2 > i3) {
            i2 = i3;
        }
        float f2 = this.i;
        if (f2 == -1.0f) {
            f2 = this.g;
        }
        int i4 = (int) f2;
        if (i4 > i3) {
            i4 = i3;
        }
        float f3 = this.k;
        if (f3 == -1.0f) {
            f3 = this.g;
        }
        int i5 = (int) f3;
        if (i5 > i3) {
            i5 = i3;
        }
        float f4 = this.j;
        int i6 = f4 == -1.0f ? (int) this.g : (int) f4;
        if (i6 <= i3) {
            i3 = i6;
        }
        float f5 = i2;
        float f6 = i4;
        float f7 = i5;
        float f8 = i3;
        return new float[]{f5, f5, f6, f6, f7, f7, f8, f8};
    }

    public final void i(GradientDrawable gradientDrawable) {
        if (this.R) {
            int i = this.F;
            gradientDrawable.setColors(i == -101 ? new int[]{this.E, this.G} : new int[]{this.E, i, this.G});
            int i2 = this.K;
            if (i2 < 0) {
                this.K = (i2 % 360) + 360;
            }
            switch ((this.K % 360) / 45) {
                case 0:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    break;
                case 1:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.BL_TR);
                    break;
                case 2:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                    break;
                case 3:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.BR_TL);
                    break;
                case 4:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                    break;
                case 5:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
                    break;
                case 6:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                    break;
                case 7:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
                    break;
            }
        }
    }

    public final void j(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, vi1.ShadowLayout);
        this.y = typedArrayObtainStyledAttributes.getInt(23, 1);
        if (n()) {
            this.N = typedArrayObtainStyledAttributes.getColor(25, -101);
            this.P = typedArrayObtainStyledAttributes.getDimension(29, -1.0f);
            float dimension = typedArrayObtainStyledAttributes.getDimension(28, -1.0f);
            this.Q = dimension;
            if (this.N == -101) {
                throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE,需设置stroke_color值");
            }
            float f = this.P;
            if (f == -1.0f) {
                throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE,需设置stroke_dashWidth值");
            }
            if ((f == -1.0f && dimension != -1.0f) || (f != -1.0f && dimension == -1.0f)) {
                throw new UnsupportedOperationException("使用了虚线边框,必须设置以下2个属性：ShadowLayout_hl_stroke_dashWidth，ShadowLayout_hl_stroke_dashGap");
            }
            k();
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        this.w = !typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.l = !typedArrayObtainStyledAttributes.getBoolean(16, false);
        this.m = !typedArrayObtainStyledAttributes.getBoolean(17, false);
        this.o = !typedArrayObtainStyledAttributes.getBoolean(15, false);
        this.n = !typedArrayObtainStyledAttributes.getBoolean(18, false);
        this.g = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        this.h = typedArrayObtainStyledAttributes.getDimension(6, -1.0f);
        this.j = typedArrayObtainStyledAttributes.getDimension(5, -1.0f);
        this.i = typedArrayObtainStyledAttributes.getDimension(8, -1.0f);
        this.k = typedArrayObtainStyledAttributes.getDimension(7, -1.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(19, 0.0f);
        this.d = dimension2;
        if (dimension2 == 0.0f) {
            this.w = false;
        }
        this.e = typedArrayObtainStyledAttributes.getDimension(20, 0.0f);
        this.f = typedArrayObtainStyledAttributes.getDimension(21, 0.0f);
        dj4 dj4Var = new dj4(this);
        this.x = dj4Var;
        dj4Var.e(attributeSet, i);
        x();
        this.v = typedArrayObtainStyledAttributes.getBoolean(22, true);
        this.C = getResources().getColor(R.color.lvs_ui_standard_systemShadowBackground);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(10);
        if (drawable != null) {
            if (drawable instanceof ColorDrawable) {
                y();
            } else {
                this.A = drawable;
            }
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(12);
        if (drawable2 != null) {
            if (drawable2 instanceof ColorDrawable) {
                this.D = ((ColorDrawable) drawable2).getColor();
            } else {
                this.B = drawable2;
            }
        }
        if (this.D != -101 && this.A != null) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，必须先设置ShadowLayout_hl_layoutBackground属性。且设置颜色时，必须保持都为颜色");
        }
        if (this.A == null && this.B != null) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，必须先设置ShadowLayout_hl_layoutBackground属性。且设置图片时，必须保持都为图片");
        }
        this.N = typedArrayObtainStyledAttributes.getColor(25, -101);
        int color = typedArrayObtainStyledAttributes.getColor(26, -101);
        this.O = color;
        if (this.N == -101 && color != -101) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_strokeColor_true属性，必须先设置ShadowLayout_hl_strokeColor属性");
        }
        this.M = typedArrayObtainStyledAttributes.getDimension(27, e(1.0f));
        this.P = typedArrayObtainStyledAttributes.getDimension(29, -1.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(28, -1.0f);
        this.Q = dimension3;
        float f2 = this.P;
        if ((f2 == -1.0f && dimension3 != -1.0f) || (f2 != -1.0f && dimension3 == -1.0f)) {
            throw new UnsupportedOperationException("使用了虚线边框,必须设置以下2个属性：ShadowLayout_hl_stroke_dashWidth，ShadowLayout_hl_stroke_dashGap");
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(11);
        if (drawable3 != null) {
            if (drawable3 instanceof ColorDrawable) {
                this.T = ((ColorDrawable) drawable3).getColor();
            } else {
                this.S = drawable3;
            }
        }
        this.E = typedArrayObtainStyledAttributes.getColor(24, -101);
        this.F = typedArrayObtainStyledAttributes.getColor(3, -101);
        int color2 = typedArrayObtainStyledAttributes.getColor(9, -101);
        this.G = color2;
        if (this.E != -101 && color2 == -101) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_startColor渐变起始色，必须搭配终止色ShadowLayout_hl_endColor");
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(1, 0);
        this.K = i2;
        if (i2 % 45 != 0) {
            throw new IllegalArgumentException("Linear gradient requires 'angle' attribute to be a multiple of 45");
        }
        if (this.y == 3) {
            if (this.C == -101 || this.D == -101) {
                throw new NullPointerException("使用了ShadowLayout的水波纹，必须设置使用了ShadowLayout_hl_layoutBackground和使用了ShadowLayout_hl_layoutBackground_true属性，且为颜色值");
            }
            if (this.A != null) {
                this.y = 1;
            }
        }
        this.U = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.W = typedArrayObtainStyledAttributes.getColor(31, -101);
        this.a0 = typedArrayObtainStyledAttributes.getColor(32, -101);
        this.b0 = typedArrayObtainStyledAttributes.getString(30);
        this.c0 = typedArrayObtainStyledAttributes.getString(33);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.R = z;
        setClickable(z);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void k() {
        Paint paint = new Paint();
        this.d0 = paint;
        paint.setAntiAlias(true);
        this.d0.setColor(this.N);
        this.d0.setStyle(Paint.Style.STROKE);
        this.d0.setPathEffect(new DashPathEffect(new float[]{this.P, this.Q}, 0.0f));
        this.e0 = new Path();
    }

    public final void l(Context context, AttributeSet attributeSet, int i) {
        j(attributeSet, i);
        if (n()) {
            return;
        }
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.z = gradientDrawable;
        int i2 = this.C;
        gradientDrawable.setColors(new int[]{i2, i2});
        int i3 = this.N;
        if (i3 != -101) {
            this.L = i3;
        }
        s();
    }

    public final void m(int i) {
        if (Color.alpha(i) == 255) {
            String hexString = Integer.toHexString(Color.red(i));
            String hexString2 = Integer.toHexString(Color.green(i));
            String hexString3 = Integer.toHexString(Color.blue(i));
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            if (hexString2.length() == 1) {
                hexString2 = "0" + hexString2;
            }
            if (hexString3.length() == 1) {
                hexString3 = "0" + hexString3;
            }
            this.c = c("#2a" + hexString + hexString2 + hexString3);
        }
    }

    public final boolean n() {
        return this.y == 4;
    }

    public final void o() {
        if (n()) {
            throw new RuntimeException("shapeMode为MODE_DASHLINE,不允许设置此属性");
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (n()) {
            g(canvas);
            return;
        }
        RectF rectF = this.t;
        rectF.left = this.p;
        rectF.top = this.q;
        rectF.right = getWidth() - this.r;
        this.t.bottom = getHeight() - this.s;
        RectF rectF2 = this.t;
        int i = (int) (rectF2.bottom - rectF2.top);
        if (this.N != -101) {
            float f = i / 2;
            if (this.M > f) {
                this.M = f;
            }
        }
        if (this.A == null && this.B == null) {
            float[] fArrH = h(i);
            if (this.y != 3) {
                f(canvas, this.t, fArrH);
            } else {
                p(fArrH);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (n()) {
            if (getChildAt(0) != null) {
                throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE，不支持子view");
            }
            return;
        }
        int i = this.U;
        if (i != -1) {
            TextView textView = (TextView) findViewById(i);
            this.V = textView;
            Objects.requireNonNull(textView, "ShadowLayout找不到hl_bindTextView，请确保绑定的资源id在ShadowLayout内");
            if (this.W == -101) {
                this.W = textView.getCurrentTextColor();
            }
            if (this.a0 == -101) {
                this.a0 = this.V.getCurrentTextColor();
            }
            this.V.setTextColor(this.W);
            if (!TextUtils.isEmpty(this.b0)) {
                this.V.setText(this.b0);
            }
        }
        this.u = getChildAt(0);
        if (this.A != null && this.w && this.d > 0.0f && getChildAt(0) == null) {
            throw new UnsupportedOperationException("使用了图片又加上阴影的情况下，必须加上子view才会生效!~");
        }
        if (this.u == null) {
            this.u = this;
            this.w = false;
        }
        if (this.u != null) {
            if (this.y == 2) {
                w(this.A, "onFinishInflate");
                return;
            }
            if (this.R) {
                w(this.A, "onFinishInflate");
                return;
            }
            w(this.S, "onFinishInflate");
            int i2 = this.T;
            if (i2 != -101) {
                this.z.setColors(new int[]{i2, i2});
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (n()) {
            setBackgroundColor(Color.parseColor("#00000000"));
            return;
        }
        if (i <= 0 || i2 <= 0) {
            return;
        }
        q(i, i2);
        if (this.E != -101) {
            i(this.z);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TextView textView;
        int i = this.y;
        if (i == 3) {
            if (this.R) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    TextView textView2 = this.V;
                    if (textView2 != null) {
                        textView2.setTextColor(this.a0);
                        if (!TextUtils.isEmpty(this.c0)) {
                            this.V.setText(this.c0);
                        }
                    }
                } else if ((action == 1 || action == 3) && (textView = this.V) != null) {
                    textView.setTextColor(this.W);
                    if (!TextUtils.isEmpty(this.b0)) {
                        this.V.setText(this.b0);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        if ((this.D != -101 || this.O != -101 || this.B != null) && this.R && i == 1) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                int i2 = this.D;
                if (i2 != -101) {
                    this.z.setColors(new int[]{i2, i2});
                }
                int i3 = this.O;
                if (i3 != -101) {
                    this.L = i3;
                }
                Drawable drawable = this.B;
                if (drawable != null) {
                    w(drawable, "onTouchEvent");
                }
                postInvalidate();
                TextView textView3 = this.V;
                if (textView3 != null) {
                    textView3.setTextColor(this.a0);
                    if (!TextUtils.isEmpty(this.c0)) {
                        this.V.setText(this.c0);
                    }
                }
            } else if (action2 == 1 || action2 == 3) {
                GradientDrawable gradientDrawable = this.z;
                int i4 = this.C;
                gradientDrawable.setColors(new int[]{i4, i4});
                if (this.E != -101) {
                    i(this.z);
                }
                int i5 = this.N;
                if (i5 != -101) {
                    this.L = i5;
                }
                Drawable drawable2 = this.A;
                if (drawable2 != null) {
                    w(drawable2, "onTouchEvent");
                }
                postInvalidate();
                TextView textView4 = this.V;
                if (textView4 != null) {
                    textView4.setTextColor(this.W);
                    if (!TextUtils.isEmpty(this.b0)) {
                        this.V.setText(this.b0);
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p(float[] fArr) {
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[]{android.R.attr.state_activated}, new int[0]};
        int i = this.C;
        int i2 = this.D;
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{i2, i2, i2, i});
        RoundRectShape roundRectShape = new RoundRectShape(fArr, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(roundRectShape);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        if (this.N != -101) {
            if (this.P != -1.0f) {
                this.z.setStroke(Math.round(this.M), this.L, this.P, this.Q);
            } else {
                this.z.setStroke(Math.round(this.M), this.L);
            }
        }
        this.z.setCornerRadii(fArr);
        if (this.E != -101) {
            i(this.z);
        }
        this.u.setBackground(new RippleDrawable(colorStateList, this.z, shapeDrawable));
    }

    public final void q(int i, int i2) {
        if (this.w) {
            m(this.c);
            setBackground(new BitmapDrawable(d(i, i2, this.g, this.d, this.e, this.f, this.c, 0)));
            return;
        }
        if (getChildAt(0) != null) {
            setBackgroundColor(Color.parseColor("#00000000"));
            return;
        }
        Drawable drawable = this.A;
        if (drawable == null) {
            setBackgroundColor(Color.parseColor("#00000000"));
            return;
        }
        this.u = this;
        if (this.R) {
            w(drawable, "setBackgroundCompat");
        } else {
            b();
        }
    }

    public ShadowLayout r(int i) {
        o();
        if (!this.R) {
            return this;
        }
        if (this.B != null) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，要与ShadowLayout_hl_layoutBackground属性统一为颜色");
        }
        this.C = i;
        this.E = -101;
        this.F = -101;
        this.G = -101;
        if (this.y != 2) {
            this.z.setColors(new int[]{i, i});
        } else if (!isSelected()) {
            GradientDrawable gradientDrawable = this.z;
            int i2 = this.C;
            gradientDrawable.setColors(new int[]{i2, i2});
        }
        postInvalidate();
        return this;
    }

    public final void s() {
        if (this.w) {
            float f = this.d;
            if (f > 0.0f) {
                if (this.v) {
                    int iAbs = (int) (f + Math.abs(this.e));
                    int iAbs2 = (int) (this.d + Math.abs(this.f));
                    if (this.l) {
                        this.p = iAbs;
                    } else {
                        this.p = 0;
                    }
                    if (this.n) {
                        this.q = iAbs2;
                    } else {
                        this.q = 0;
                    }
                    if (this.m) {
                        this.r = iAbs;
                    } else {
                        this.r = 0;
                    }
                    if (this.o) {
                        this.s = iAbs2;
                    } else {
                        this.s = 0;
                    }
                } else {
                    float fAbs = Math.abs(this.f);
                    float f2 = this.d;
                    if (fAbs > f2) {
                        if (this.f > 0.0f) {
                            this.f = f2;
                        } else {
                            this.f = 0.0f - f2;
                        }
                    }
                    float fAbs2 = Math.abs(this.e);
                    float f3 = this.d;
                    if (fAbs2 > f3) {
                        if (this.e > 0.0f) {
                            this.e = f3;
                        } else {
                            this.e = 0.0f - f3;
                        }
                    }
                    if (this.n) {
                        this.q = (int) (f3 - this.f);
                    } else {
                        this.q = 0;
                    }
                    if (this.o) {
                        this.s = (int) (this.f + f3);
                    } else {
                        this.s = 0;
                    }
                    if (this.m) {
                        this.r = (int) (f3 - this.e);
                    } else {
                        this.r = 0;
                    }
                    if (this.l) {
                        this.p = (int) (f3 + this.e);
                    } else {
                        this.p = 0;
                    }
                }
                setPadding(this.p, this.q, this.r, this.s);
            }
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        o();
        super.setClickable(z);
        this.R = z;
        b();
        if (this.R) {
            super.setOnClickListener(this.f0);
        }
        GradientDrawable gradientDrawable = this.z;
        if (gradientDrawable == null || this.E == -101 || this.G == -101) {
            return;
        }
        i(gradientDrawable);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f0 = onClickListener;
        if (this.R) {
            super.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (getWidth() == 0) {
            addOnLayoutChangeListener(new a());
            return;
        }
        if (this.y == 2) {
            if (z) {
                int i = this.D;
                if (i != -101) {
                    this.z.setColors(new int[]{i, i});
                }
                int i2 = this.O;
                if (i2 != -101) {
                    this.L = i2;
                }
                Drawable drawable = this.B;
                if (drawable != null) {
                    w(drawable, "setSelected");
                }
                TextView textView = this.V;
                if (textView != null) {
                    textView.setTextColor(this.a0);
                    if (!TextUtils.isEmpty(this.c0)) {
                        this.V.setText(this.c0);
                    }
                }
            } else {
                GradientDrawable gradientDrawable = this.z;
                int i3 = this.C;
                gradientDrawable.setColors(new int[]{i3, i3});
                if (this.E != -101) {
                    i(this.z);
                }
                int i4 = this.N;
                if (i4 != -101) {
                    this.L = i4;
                }
                Drawable drawable2 = this.A;
                if (drawable2 != null) {
                    w(drawable2, "setSelected");
                }
                TextView textView2 = this.V;
                if (textView2 != null) {
                    textView2.setTextColor(this.W);
                    if (!TextUtils.isEmpty(this.b0)) {
                        this.V.setText(this.b0);
                    }
                }
            }
            postInvalidate();
        }
    }

    public ShadowLayout t(int i) {
        o();
        this.c = i;
        if (getWidth() != 0 && getHeight() != 0) {
            q(getWidth(), getHeight());
        }
        return this;
    }

    public ShadowLayout u(int i) {
        o();
        this.d = i;
        if (this.w) {
            s();
        }
        return this;
    }

    public ShadowLayout v(float f) {
        o();
        if (this.w) {
            float fAbs = Math.abs(f);
            float f2 = this.d;
            if (fAbs <= f2) {
                this.f = f;
            } else if (f > 0.0f) {
                this.f = f2;
            } else {
                this.f = -f2;
            }
            s();
        }
        return this;
    }

    public final void w(Drawable drawable, String str) {
        this.u.setTag(R.id.action_container, str);
        View view = this.u;
        if (view == null || drawable == null) {
            return;
        }
        float f = this.h;
        if (f == -1.0f && this.j == -1.0f && this.i == -1.0f && this.k == -1.0f) {
            dt3.b(view, drawable, this.g, str);
            return;
        }
        if (f == -1.0f) {
            f = this.g;
        }
        int i = (int) f;
        float f2 = this.j;
        if (f2 == -1.0f) {
            f2 = this.g;
        }
        int i2 = (int) f2;
        float f3 = this.i;
        if (f3 == -1.0f) {
            f3 = this.g;
        }
        dt3.a(view, drawable, i, i2, (int) f3, this.k == -1.0f ? (int) this.g : (int) r5, str);
    }

    public final void x() {
        dj4 dj4Var = this.x;
        if (dj4Var != null) {
            dj4Var.b();
            this.c = this.x.d();
        }
    }

    public final void y() {
        dj4 dj4Var = this.x;
        if (dj4Var != null) {
            dj4Var.b();
            this.C = this.x.c();
        }
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = new RectF();
        this.w = true;
        this.D = -101;
        this.P = -1.0f;
        this.Q = -1.0f;
        this.T = -101;
        this.U = -1;
        l(context, attributeSet, i);
    }
}

package dc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import com.wear.widget.seekbar.RangeSeekBar;
import java.text.DecimalFormat;

/* compiled from: SeekBar.java */
/* loaded from: classes4.dex */
public class ys3 {
    public boolean A;
    public Bitmap B;
    public Bitmap C;
    public Bitmap D;
    public ValueAnimator E;
    public String F;
    public RangeSeekBar I;
    public String J;
    public DecimalFormat O;
    public int P;
    public int Q;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public boolean z;
    public float y = 0.0f;
    public boolean G = false;
    public boolean H = true;
    public Path K = new Path();
    public Rect L = new Rect();
    public Rect M = new Rect();
    public Paint N = new Paint(1);

    /* compiled from: SeekBar.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ys3.this.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RangeSeekBar rangeSeekBar = ys3.this.I;
            if (rangeSeekBar != null) {
                rangeSeekBar.invalidate();
            }
        }
    }

    /* compiled from: SeekBar.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ys3 ys3Var = ys3.this;
            ys3Var.y = 0.0f;
            RangeSeekBar rangeSeekBar = ys3Var.I;
            if (rangeSeekBar != null) {
                rangeSeekBar.invalidate();
            }
        }
    }

    public ys3(RangeSeekBar rangeSeekBar, AttributeSet attributeSet, boolean z) {
        this.I = rangeSeekBar;
        this.A = z;
        A(attributeSet);
        B();
        C();
    }

    public final void A(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = d().obtainStyledAttributes(attributeSet, vi1.RangeSeekBar);
        this.d = (int) typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.e = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.a = typedArrayObtainStyledAttributes.getInt(11, 1);
        this.b = typedArrayObtainStyledAttributes.getLayoutDimension(4, -1);
        this.c = typedArrayObtainStyledAttributes.getLayoutDimension(14, -1);
        this.g = (int) typedArrayObtainStyledAttributes.getDimension(13, at3.b(d(), 14.0f));
        this.h = typedArrayObtainStyledAttributes.getColor(12, -1);
        this.j = typedArrayObtainStyledAttributes.getColor(2, ContextCompat.getColor(d(), R.color.colorAccent));
        this.k = (int) typedArrayObtainStyledAttributes.getDimension(7, 0.0f);
        this.l = (int) typedArrayObtainStyledAttributes.getDimension(8, 0.0f);
        this.m = (int) typedArrayObtainStyledAttributes.getDimension(9, 0.0f);
        this.n = (int) typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
        this.f = (int) typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        this.o = typedArrayObtainStyledAttributes.getResourceId(32, R.drawable.rsb_default_thumb);
        this.p = typedArrayObtainStyledAttributes.getResourceId(34, 0);
        this.q = (int) typedArrayObtainStyledAttributes.getDimension(36, at3.b(d(), 26.0f));
        this.r = (int) typedArrayObtainStyledAttributes.getDimension(33, at3.b(d(), 26.0f));
        this.s = typedArrayObtainStyledAttributes.getFloat(35, 1.0f);
        this.i = typedArrayObtainStyledAttributes.getDimension(10, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void B() {
        L(this.e);
        Q(this.o, this.q, this.r);
        R(this.p, this.q, this.r);
    }

    public void C() {
        this.P = this.q;
        this.Q = this.r;
        if (this.b == -1) {
            this.b = at3.g("8", this.g).height() + this.m + this.n;
        }
        if (this.f <= 0) {
            this.f = this.q / 4;
        }
    }

    public void D() {
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.y, 0.0f);
        this.E = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new a());
        this.E.addListener(new b());
        this.E.start();
    }

    public void E(Canvas canvas, Paint paint, String str) {
        int iWidth;
        if (str == null) {
            return;
        }
        paint.setTextSize(this.g);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.j);
        paint.getTextBounds(str, 0, str.length(), this.L);
        int iWidth2 = this.L.width() + this.k + this.l;
        int i = this.c;
        if (i > iWidth2) {
            iWidth2 = i;
        }
        int iHeight = this.L.height() + this.m + this.n;
        int i2 = this.b;
        if (i2 > iHeight) {
            iHeight = i2;
        }
        Rect rect = this.M;
        int i3 = this.P;
        int i4 = (int) ((i3 / 2.0f) - (iWidth2 / 2.0f));
        rect.left = i4;
        int i5 = ((this.w - iHeight) - this.Q) - this.d;
        rect.top = i5;
        rect.right = i4 + iWidth2;
        int i6 = i5 + iHeight;
        rect.bottom = i6;
        if (this.D == null) {
            int i7 = this.f;
            this.K.reset();
            this.K.moveTo(i3 / 2, i6);
            float f = i6 - i7;
            this.K.lineTo(r3 - i7, f);
            this.K.lineTo(i7 + r3, f);
            this.K.close();
            canvas.drawPath(this.K, paint);
            Rect rect2 = this.M;
            int i8 = rect2.bottom;
            int i9 = this.f;
            rect2.bottom = i8 - i9;
            rect2.top -= i9;
        }
        int iB = at3.b(d(), 1.0f);
        int iWidth3 = (((this.M.width() / 2) - ((int) (this.I.getProgressWidth() * this.x))) - this.I.getProgressLeft()) + iB;
        int iWidth4 = (((this.M.width() / 2) - ((int) (this.I.getProgressWidth() * (1.0f - this.x)))) - this.I.getProgressPaddingRight()) + iB;
        if (iWidth3 > 0) {
            Rect rect3 = this.M;
            rect3.left += iWidth3;
            rect3.right += iWidth3;
        } else if (iWidth4 > 0) {
            Rect rect4 = this.M;
            rect4.left -= iWidth4;
            rect4.right -= iWidth4;
        }
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            at3.c(canvas, paint, bitmap, this.M);
        } else if (this.i > 0.0f) {
            RectF rectF = new RectF(this.M);
            float f2 = this.i;
            canvas.drawRoundRect(rectF, f2, f2, paint);
        } else {
            canvas.drawRect(this.M, paint);
        }
        int i10 = this.k;
        if (i10 > 0) {
            iWidth = this.M.left + i10;
        } else {
            int i11 = this.l;
            iWidth = i11 > 0 ? (this.M.right - i11) - this.L.width() : ((iWidth2 - this.L.width()) / 2) + this.M.left;
        }
        int iHeight2 = this.m > 0 ? this.M.top + this.L.height() + this.m : this.n > 0 ? (this.M.bottom - this.L.height()) - this.n : (this.M.bottom - ((iHeight - this.L.height()) / 2)) + 1;
        paint.setColor(this.h);
        canvas.drawText(str, iWidth, iHeight2, paint);
    }

    public void F(Canvas canvas) {
        Bitmap bitmap = this.C;
        if (bitmap != null && !this.G) {
            canvas.drawBitmap(bitmap, 0.0f, this.I.getProgressTop() + ((this.I.getProgressHeight() - this.Q) / 2.0f), (Paint) null);
            return;
        }
        Bitmap bitmap2 = this.B;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, this.I.getProgressTop() + ((this.I.getProgressHeight() - this.Q) / 2.0f), (Paint) null);
        }
    }

    public void G(int i, int i2) {
        C();
        B();
        float f = i;
        this.t = (int) (f - (y() / 2.0f));
        this.u = (int) (f + (y() / 2.0f));
        this.v = i2 - (v() / 2);
        this.w = i2 + (v() / 2);
    }

    public void H() {
        this.P = z();
        this.Q = v();
        int progressBottom = this.I.getProgressBottom();
        int i = this.Q;
        this.v = progressBottom - (i / 2);
        this.w = progressBottom + (i / 2);
        Q(this.o, this.P, i);
    }

    public void I() {
        this.P = (int) y();
        this.Q = (int) w();
        int progressBottom = this.I.getProgressBottom();
        int i = this.Q;
        this.v = progressBottom - (i / 2);
        this.w = progressBottom + (i / 2);
        Q(this.o, this.P, i);
    }

    public void J(boolean z) {
        this.G = z;
    }

    public void K(@ColorInt int i) {
        this.j = i;
    }

    public void L(@DrawableRes int i) {
        if (i != 0) {
            this.e = i;
            this.D = BitmapFactory.decodeResource(u(), i);
        }
    }

    public void M(String str) {
        this.F = str;
    }

    public void N(String str) {
        this.O = new DecimalFormat(str);
    }

    public void O(String str) {
        this.J = str;
    }

    public void P(boolean z) {
        int i = this.a;
        if (i == 0) {
            this.z = z;
            return;
        }
        if (i == 1) {
            this.z = false;
        } else if (i == 2 || i == 3) {
            this.z = true;
        }
    }

    public void Q(@DrawableRes int i, int i2, int i3) {
        if (i == 0 || u() == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.o = i;
        if (Build.VERSION.SDK_INT >= 21) {
            this.B = at3.e(i2, i3, u().getDrawable(i, null));
        } else {
            this.B = at3.e(i2, i3, u().getDrawable(i));
        }
    }

    public void R(@DrawableRes int i, int i2, int i3) {
        if (i == 0 || u() == null) {
            return;
        }
        this.p = i;
        if (Build.VERSION.SDK_INT >= 21) {
            this.C = at3.e(i2, i3, u().getDrawable(i, null));
        } else {
            this.C = at3.e(i2, i3, u().getDrawable(i));
        }
    }

    public void S(boolean z) {
        this.H = z;
    }

    public void T(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.x = f;
    }

    public boolean a(float f, float f2) {
        int progressWidth = (int) (this.I.getProgressWidth() * this.x);
        return f > ((float) (this.t + progressWidth)) && f < ((float) (this.u + progressWidth)) && f2 > ((float) this.v) && f2 < ((float) this.w);
    }

    public void b(Canvas canvas) {
        if (this.H) {
            int progressWidth = (int) (this.I.getProgressWidth() * this.x);
            canvas.save();
            canvas.translate(progressWidth, 0.0f);
            canvas.translate(this.t, 0.0f);
            if (this.z) {
                E(canvas, this.N, c(this.F));
            }
            F(canvas);
            canvas.restore();
        }
    }

    public String c(String str) {
        zs3[] rangeSeekBarState = this.I.getRangeSeekBarState();
        if (TextUtils.isEmpty(str)) {
            if (this.A) {
                DecimalFormat decimalFormat = this.O;
                str = decimalFormat != null ? decimalFormat.format(rangeSeekBarState[0].b) : rangeSeekBarState[0].a;
            } else {
                DecimalFormat decimalFormat2 = this.O;
                str = decimalFormat2 != null ? decimalFormat2.format(rangeSeekBarState[1].b) : rangeSeekBarState[1].a;
            }
        }
        String str2 = this.J;
        return str2 != null ? String.format(str2, str) : str;
    }

    public Context d() {
        return this.I.getContext();
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.j;
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return this.d;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.k;
    }

    public int k() {
        return this.l;
    }

    public int l() {
        return this.m;
    }

    public float m() {
        return this.i;
    }

    public int n() {
        int i;
        int iHeight = this.b;
        if (iHeight > 0) {
            if (this.D != null) {
                i = this.d;
            } else {
                iHeight += this.f;
                i = this.d;
            }
        } else if (this.D != null) {
            iHeight = at3.g("8", this.g).height() + this.m + this.n;
            i = this.d;
        } else {
            iHeight = at3.g("8", this.g).height() + this.m + this.n + this.d;
            i = this.f;
        }
        return iHeight + i;
    }

    public int o() {
        return this.a;
    }

    public int p() {
        return this.h;
    }

    public int q() {
        return this.g;
    }

    public int r() {
        return this.c;
    }

    public float s() {
        return this.I.getMinProgress() + ((this.I.getMaxProgress() - this.I.getMinProgress()) * this.x);
    }

    public float t() {
        return g() + e() + h() + w();
    }

    public Resources u() {
        if (d() != null) {
            return d().getResources();
        }
        return null;
    }

    public int v() {
        return this.r;
    }

    public float w() {
        return this.r * this.s;
    }

    public float x() {
        return this.s;
    }

    public float y() {
        return this.q * this.s;
    }

    public int z() {
        return this.q;
    }
}

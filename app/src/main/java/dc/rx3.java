package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: RoundedCornersTransformation.java */
/* loaded from: classes4.dex */
public class rx3 extends px3 {
    public final int b;
    public final int c;
    public final int d;
    public final b e;

    /* compiled from: RoundedCornersTransformation.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[b.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[b.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[b.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[b.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[b.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[b.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* compiled from: RoundedCornersTransformation.java */
    public enum b {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public rx3(int i, int i2, b bVar) {
        this.b = i;
        this.c = i * 2;
        this.d = i2;
        this.e = bVar;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.RoundedCornersTransformation.1" + this.b + this.c + this.d + this.e).getBytes(xg.a));
    }

    @Override // dc.px3
    public Bitmap d(@NonNull Context context, @NonNull cj cjVar, @NonNull Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapD = cjVar.d(width, height, Bitmap.Config.ARGB_8888);
        bitmapD.setHasAlpha(true);
        c(bitmap, bitmapD);
        Canvas canvas = new Canvas(bitmapD);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        p(canvas, paint, width, height);
        return bitmapD;
    }

    public final void e(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.d, f2 - this.c, r1 + r3, f2);
        int i = this.b;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.d;
        canvas.drawRect(new RectF(i2, i2, i2 + this.c, f2 - this.b), paint);
        canvas.drawRect(new RectF(this.b + r1, this.d, f, f2), paint);
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (obj instanceof rx3) {
            rx3 rx3Var = (rx3) obj;
            if (rx3Var.b == this.b && rx3Var.c == this.c && rx3Var.d == this.d && rx3Var.e == this.e) {
                return true;
            }
        }
        return false;
    }

    public final void f(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        RectF rectF = new RectF(f - i, f2 - i, f, f2);
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.d;
        canvas.drawRect(new RectF(i3, i3, f - this.b, f2), paint);
        int i4 = this.b;
        canvas.drawRect(new RectF(f - i4, this.d, f, f2 - i4), paint);
    }

    public final void g(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.d, f2 - this.c, f, f2);
        int i = this.b;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.d;
        canvas.drawRect(new RectF(i2, i2, f, f2 - this.b), paint);
    }

    public final void h(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.d;
        int i2 = this.c;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.b;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.c;
        RectF rectF2 = new RectF(f - i4, f2 - i4, f, f2);
        int i5 = this.b;
        canvas.drawRoundRect(rectF2, i5, i5, paint);
        canvas.drawRect(new RectF(this.d, r1 + r3, f - this.b, f2), paint);
        canvas.drawRect(new RectF(r1 + r2, this.d, f, f2 - this.b), paint);
    }

    @Override // dc.xg
    public int hashCode() {
        return 425235636 + (this.b * 10000) + (this.c * 1000) + (this.d * 100) + (this.e.ordinal() * 10);
    }

    public final void i(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        RectF rectF = new RectF(f - i, this.d, f, r3 + i);
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.d, f2 - this.c, r1 + r3, f2);
        int i3 = this.b;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        int i4 = this.d;
        int i5 = this.b;
        canvas.drawRect(new RectF(i4, i4, f - i5, f2 - i5), paint);
        int i6 = this.d;
        int i7 = this.b;
        canvas.drawRect(new RectF(i6 + i7, i6 + i7, f, f2), paint);
    }

    public final void j(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.d;
        RectF rectF = new RectF(i, i, i + this.c, f2);
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.drawRect(new RectF(this.b + r1, this.d, f, f2), paint);
    }

    public final void k(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.d;
        RectF rectF = new RectF(i, i, f, i + this.c);
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(f - this.c, this.d, f, f2);
        int i3 = this.b;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        canvas.drawRect(new RectF(this.d, r1 + r3, f - this.b, f2), paint);
    }

    public final void l(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.d;
        RectF rectF = new RectF(i, i, f, i + this.c);
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.d;
        RectF rectF2 = new RectF(i3, i3, i3 + this.c, f2);
        int i4 = this.b;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        int i5 = this.d;
        int i6 = this.b;
        canvas.drawRect(new RectF(i5 + i6, i5 + i6, f, f2), paint);
    }

    public final void m(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.d, f2 - this.c, f, f2);
        int i = this.b;
        canvas.drawRoundRect(rectF, i, i, paint);
        RectF rectF2 = new RectF(f - this.c, this.d, f, f2);
        int i2 = this.b;
        canvas.drawRoundRect(rectF2, i2, i2, paint);
        int i3 = this.d;
        int i4 = this.b;
        canvas.drawRect(new RectF(i3, i3, f - i4, f2 - i4), paint);
    }

    public final void n(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.d;
        RectF rectF = new RectF(i, i, i + this.c, f2);
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.d, f2 - this.c, f, f2);
        int i3 = this.b;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        canvas.drawRect(new RectF(r1 + r2, this.d, f, f2 - this.b), paint);
    }

    public final void o(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - this.c, this.d, f, f2);
        int i = this.b;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.d;
        canvas.drawRect(new RectF(i2, i2, f - this.b, f2), paint);
    }

    public final void p(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.d;
        float f3 = f - i;
        float f4 = f2 - i;
        switch (a.a[this.e.ordinal()]) {
            case 1:
                int i2 = this.d;
                RectF rectF = new RectF(i2, i2, f3, f4);
                int i3 = this.b;
                canvas.drawRoundRect(rectF, i3, i3, paint);
                break;
            case 2:
                q(canvas, paint, f3, f4);
                break;
            case 3:
                r(canvas, paint, f3, f4);
                break;
            case 4:
                e(canvas, paint, f3, f4);
                break;
            case 5:
                f(canvas, paint, f3, f4);
                break;
            case 6:
                s(canvas, paint, f3, f4);
                break;
            case 7:
                g(canvas, paint, f3, f4);
                break;
            case 8:
                j(canvas, paint, f3, f4);
                break;
            case 9:
                o(canvas, paint, f3, f4);
                break;
            case 10:
                m(canvas, paint, f3, f4);
                break;
            case 11:
                n(canvas, paint, f3, f4);
                break;
            case 12:
                k(canvas, paint, f3, f4);
                break;
            case 13:
                l(canvas, paint, f3, f4);
                break;
            case 14:
                h(canvas, paint, f3, f4);
                break;
            case 15:
                i(canvas, paint, f3, f4);
                break;
            default:
                int i4 = this.d;
                RectF rectF2 = new RectF(i4, i4, f3, f4);
                int i5 = this.b;
                canvas.drawRoundRect(rectF2, i5, i5, paint);
                break;
        }
    }

    public final void q(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.d;
        int i2 = this.c;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.b;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.d;
        int i5 = this.b;
        canvas.drawRect(new RectF(i4, i4 + i5, i4 + i5, f2), paint);
        canvas.drawRect(new RectF(this.b + r1, this.d, f, f2), paint);
    }

    public final void r(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        RectF rectF = new RectF(f - i, this.d, f, r3 + i);
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.d;
        canvas.drawRect(new RectF(i3, i3, f - this.b, f2), paint);
        canvas.drawRect(new RectF(f - this.b, this.d + r1, f, f2), paint);
    }

    public final void s(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.d;
        RectF rectF = new RectF(i, i, f, i + this.c);
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.drawRect(new RectF(this.d, r1 + this.b, f, f2), paint);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.b + ", margin=" + this.d + ", diameter=" + this.c + ", cornerType=" + this.e.name() + ")";
    }
}

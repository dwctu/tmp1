package dc;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.HashSet;

/* compiled from: RoundedDrawable.java */
/* loaded from: classes3.dex */
public class bd1 extends Drawable {
    public final RectF a = new RectF();
    public final RectF b = new RectF();
    public final RectF c;
    public final Bitmap d;
    public final Paint e;
    public final int f;
    public final int g;
    public final RectF h;
    public final Paint i;
    public final Matrix j;
    public final RectF k;
    public Shader.TileMode l;
    public Shader.TileMode m;
    public boolean n;
    public float o;
    public final boolean[] p;
    public boolean q;
    public float r;
    public ColorStateList s;
    public ImageView.ScaleType t;

    /* compiled from: RoundedDrawable.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public bd1(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.c = rectF;
        this.h = new RectF();
        this.j = new Matrix();
        this.k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = tileMode;
        this.m = tileMode;
        this.n = true;
        this.o = 0.0f;
        this.p = new boolean[]{true, true, true, true};
        this.q = false;
        this.r = 0.0f;
        this.s = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.t = ImageView.ScaleType.FIT_CENTER;
        this.d = bitmap;
        int width = bitmap.getWidth();
        this.f = width;
        int height = bitmap.getHeight();
        this.g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.s.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.r);
    }

    public static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static bd1 d(Bitmap bitmap) {
        if (bitmap != null) {
            return new bd1(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable == null || (drawable instanceof bd1)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapC = c(drawable);
            return bitmapC != null ? new bd1(bitmapC) : drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i = 0; i < numberOfLayers; i++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), e(layerDrawable.getDrawable(i)));
        }
        return layerDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.d, this.l, this.m);
            Shader.TileMode tileMode = this.l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.q) {
            if (this.r <= 0.0f) {
                canvas.drawOval(this.b, this.e);
                return;
            } else {
                canvas.drawOval(this.b, this.e);
                canvas.drawOval(this.h, this.i);
                return;
            }
        }
        if (!b(this.p)) {
            canvas.drawRect(this.b, this.e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.h, this.i);
                return;
            }
            return;
        }
        float f = this.o;
        if (this.r <= 0.0f) {
            canvas.drawRoundRect(this.b, f, f, this.e);
            f(canvas);
        } else {
            canvas.drawRoundRect(this.b, f, f, this.e);
            canvas.drawRoundRect(this.h, f, f, this.i);
            f(canvas);
            g(canvas);
        }
    }

    public final void f(Canvas canvas) {
        if (a(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.b;
        float f = rectF.left;
        float f2 = rectF.top;
        float fWidth = rectF.width() + f;
        float fHeight = this.b.height() + f2;
        float f3 = this.o;
        if (!this.p[0]) {
            this.k.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.k, this.e);
        }
        if (!this.p[1]) {
            this.k.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.k, this.e);
        }
        if (!this.p[2]) {
            this.k.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.k, this.e);
        }
        if (this.p[3]) {
            return;
        }
        this.k.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.k, this.e);
    }

    public final void g(Canvas canvas) {
        float f;
        if (a(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.b;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float fWidth = rectF.width() + f2;
        float fHeight = f3 + this.b.height();
        float f4 = this.o;
        float f5 = this.r / 2.0f;
        if (!this.p[0]) {
            canvas.drawLine(f2 - f5, f3, f2 + f4, f3, this.i);
            canvas.drawLine(f2, f3 - f5, f2, f3 + f4, this.i);
        }
        if (!this.p[1]) {
            canvas.drawLine((fWidth - f4) - f5, f3, fWidth, f3, this.i);
            canvas.drawLine(fWidth, f3 - f5, fWidth, f3 + f4, this.i);
        }
        if (this.p[2]) {
            f = f4;
        } else {
            f = f4;
            canvas.drawLine((fWidth - f4) - f5, fHeight, fWidth + f5, fHeight, this.i);
            canvas.drawLine(fWidth, fHeight - f, fWidth, fHeight, this.i);
        }
        if (this.p[3]) {
            return;
        }
        canvas.drawLine(f2 - f5, fHeight, f2 + f, fHeight, this.i);
        canvas.drawLine(f2, fHeight - f, f2, fHeight, this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public bd1 h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.i.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public bd1 i(float f) {
        this.r = f;
        this.i.setStrokeWidth(f);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    public bd1 j(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (hashSet.isEmpty()) {
            this.o = 0.0f;
        } else {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: " + fFloatValue);
            }
            this.o = fFloatValue;
        }
        boolean[] zArr = this.p;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public bd1 k(boolean z) {
        this.q = z;
        return this;
    }

    public bd1 l(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            o();
        }
        return this;
    }

    public bd1 m(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public bd1 n(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public final void o() {
        float fWidth;
        float fHeight;
        int i = a.a[this.t.ordinal()];
        if (i == 1) {
            this.h.set(this.a);
            RectF rectF = this.h;
            float f = this.r;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.j.reset();
            this.j.setTranslate((int) (((this.h.width() - this.f) * 0.5f) + 0.5f), (int) (((this.h.height() - this.g) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.h.set(this.a);
            RectF rectF2 = this.h;
            float f2 = this.r;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.j.reset();
            float fWidth2 = 0.0f;
            if (this.f * this.h.height() > this.h.width() * this.g) {
                fWidth = this.h.height() / this.g;
                fWidth2 = (this.h.width() - (this.f * fWidth)) * 0.5f;
                fHeight = 0.0f;
            } else {
                fWidth = this.h.width() / this.f;
                fHeight = (this.h.height() - (this.g * fWidth)) * 0.5f;
            }
            this.j.setScale(fWidth, fWidth);
            Matrix matrix = this.j;
            float f3 = this.r;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.j.reset();
            float fMin = (((float) this.f) > this.a.width() || ((float) this.g) > this.a.height()) ? Math.min(this.a.width() / this.f, this.a.height() / this.g) : 1.0f;
            float fWidth3 = (int) (((this.a.width() - (this.f * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.a.height() - (this.g * fMin)) * 0.5f) + 0.5f);
            this.j.setScale(fMin, fMin);
            this.j.postTranslate(fWidth3, fHeight2);
            this.h.set(this.c);
            this.j.mapRect(this.h);
            RectF rectF3 = this.h;
            float f4 = this.r;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.h);
            RectF rectF4 = this.h;
            float f5 = this.r;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
            this.j.mapRect(this.h);
            RectF rectF5 = this.h;
            float f6 = this.r;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
            this.j.mapRect(this.h);
            RectF rectF6 = this.h;
            float f7 = this.r;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else {
            this.h.set(this.a);
            RectF rectF7 = this.h;
            float f8 = this.r;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.j.reset();
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        }
        this.b.set(this.h);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.e.setFilterBitmap(z);
        invalidateSelf();
    }
}

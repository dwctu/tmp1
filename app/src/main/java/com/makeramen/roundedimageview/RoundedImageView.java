package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewCompat;
import dc.ad1;
import dc.bd1;

/* loaded from: classes3.dex */
public class RoundedImageView extends ImageView {
    public static final Shader.TileMode p = Shader.TileMode.CLAMP;
    public static final ImageView.ScaleType[] q = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public final float[] a;
    public Drawable b;
    public ColorStateList c;
    public float d;
    public ColorFilter e;
    public boolean f;
    public Drawable g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public ImageView.ScaleType m;
    public Shader.TileMode n;
    public Shader.TileMode o;

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
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.a = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.c = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.d = 0.0f;
        this.e = null;
        this.f = false;
        this.h = false;
        this.i = false;
        this.j = false;
        Shader.TileMode tileMode = p;
        this.n = tileMode;
        this.o = tileMode;
    }

    public static Shader.TileMode b(int i) {
        if (i == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    public final void a() {
        Drawable drawable = this.g;
        if (drawable == null || !this.f) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.g = drawableMutate;
        if (this.h) {
            drawableMutate.setColorFilter(this.e);
        }
    }

    public final Drawable c() throws Resources.NotFoundException {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.l;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception unused) {
                String str = "Unable to find resource: " + this.l;
                this.l = 0;
            }
        }
        return bd1.e(drawable);
    }

    public final Drawable d() throws Resources.NotFoundException {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.k;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception unused) {
                String str = "Unable to find resource: " + this.k;
                this.k = 0;
            }
        }
        return bd1.e(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public final void e(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof bd1)) {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    e(layerDrawable.getDrawable(i), scaleType);
                }
                return;
            }
            return;
        }
        bd1 bd1Var = (bd1) drawable;
        bd1Var.l(scaleType);
        bd1Var.i(this.d);
        bd1Var.h(this.c);
        bd1Var.k(this.i);
        bd1Var.m(this.n);
        bd1Var.n(this.o);
        float[] fArr = this.a;
        if (fArr != null) {
            bd1Var.j(fArr[0], fArr[1], fArr[2], fArr[3]);
        }
        a();
    }

    public final void f(boolean z) {
        if (this.j) {
            if (z) {
                this.b = bd1.e(this.b);
            }
            e(this.b, ImageView.ScaleType.FIT_XY);
        }
    }

    public final void g() {
        e(this.g, this.m);
    }

    @ColorInt
    public int getBorderColor() {
        return this.c.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.c;
    }

    public float getBorderWidth() {
        return this.d;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.a) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.m;
    }

    public Shader.TileMode getTileModeX() {
        return this.n;
    }

    public Shader.TileMode getTileModeY() {
        return this.o;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.b = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.b = drawable;
        f(true);
        super.setBackgroundDrawable(this.b);
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) throws Resources.NotFoundException {
        if (this.l != i) {
            this.l = i;
            Drawable drawableC = c();
            this.b = drawableC;
            setBackgroundDrawable(drawableC);
        }
    }

    public void setBorderColor(@ColorInt int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderWidth(@DimenRes int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.e != colorFilter) {
            this.e = colorFilter;
            this.h = true;
            this.f = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f) {
        setCornerRadius(f, f, f, f);
    }

    public void setCornerRadiusDimen(@DimenRes int i) throws Resources.NotFoundException {
        float dimension = getResources().getDimension(i);
        setCornerRadius(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.k = 0;
        this.g = bd1.d(bitmap);
        g();
        super.setImageDrawable(this.g);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.k = 0;
        this.g = bd1.e(drawable);
        g();
        super.setImageDrawable(this.g);
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        if (this.k != i) {
            this.k = i;
            this.g = d();
            g();
            super.setImageDrawable(this.g);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.i = z;
        g();
        f(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.m != scaleType) {
            this.m = scaleType;
            switch (a.a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            g();
            f(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.n == tileMode) {
            return;
        }
        this.n = tileMode;
        g();
        f(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.o == tileMode) {
            return;
        }
        this.o = tileMode;
        g();
        f(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.c.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.c = colorStateList;
        g();
        f(false);
        if (this.d > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f) {
        if (this.d == f) {
            return;
        }
        this.d = f;
        g();
        f(false);
        invalidate();
    }

    public void setCornerRadius(int i, float f) {
        float[] fArr = this.a;
        if (fArr[i] == f) {
            return;
        }
        fArr[i] = f;
        g();
        f(false);
        invalidate();
    }

    public void setCornerRadiusDimen(int i, @DimenRes int i2) {
        setCornerRadius(i, getResources().getDimensionPixelSize(i2));
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        float[] fArr = this.a;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        g();
        f(false);
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.a = fArr;
        this.c = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.d = 0.0f;
        this.e = null;
        this.f = false;
        this.h = false;
        this.i = false;
        this.j = false;
        Shader.TileMode tileMode = p;
        this.n = tileMode;
        this.o = tileMode;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad1.RoundedImageView, i, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(ad1.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(q[i2]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(ad1.RoundedImageView_riv_corner_radius, -1);
        fArr[0] = typedArrayObtainStyledAttributes.getDimensionPixelSize(ad1.RoundedImageView_riv_corner_radius_top_left, -1);
        fArr[1] = typedArrayObtainStyledAttributes.getDimensionPixelSize(ad1.RoundedImageView_riv_corner_radius_top_right, -1);
        fArr[2] = typedArrayObtainStyledAttributes.getDimensionPixelSize(ad1.RoundedImageView_riv_corner_radius_bottom_right, -1);
        fArr[3] = typedArrayObtainStyledAttributes.getDimensionPixelSize(ad1.RoundedImageView_riv_corner_radius_bottom_left, -1);
        int length = fArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            float[] fArr2 = this.a;
            if (fArr2[i3] < 0.0f) {
                fArr2[i3] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.a.length;
            for (int i4 = 0; i4 < length2; i4++) {
                this.a[i4] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(ad1.RoundedImageView_riv_border_width, -1);
        this.d = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.d = 0.0f;
        }
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(ad1.RoundedImageView_riv_border_color);
        this.c = colorStateList;
        if (colorStateList == null) {
            this.c = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.j = typedArrayObtainStyledAttributes.getBoolean(ad1.RoundedImageView_riv_mutate_background, false);
        this.i = typedArrayObtainStyledAttributes.getBoolean(ad1.RoundedImageView_riv_oval, false);
        int i5 = typedArrayObtainStyledAttributes.getInt(ad1.RoundedImageView_riv_tile_mode, -2);
        if (i5 != -2) {
            setTileModeX(b(i5));
            setTileModeY(b(i5));
        }
        int i6 = typedArrayObtainStyledAttributes.getInt(ad1.RoundedImageView_riv_tile_mode_x, -2);
        if (i6 != -2) {
            setTileModeX(b(i6));
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(ad1.RoundedImageView_riv_tile_mode_y, -2);
        if (i7 != -2) {
            setTileModeY(b(i7));
        }
        g();
        f(true);
        if (this.j) {
            super.setBackgroundDrawable(this.b);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}

package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

/* loaded from: classes3.dex */
public class RoundedBitmapDisplayer implements BitmapDisplayer {
    public final int cornerRadius;
    public final int margin;

    public static class RoundedDrawable extends Drawable {
        public final BitmapShader bitmapShader;
        public final float cornerRadius;
        public final RectF mBitmapRect;
        public final RectF mRect = new RectF();
        public final int margin;
        public final Paint paint;

        public RoundedDrawable(Bitmap bitmap, int i, int i2) {
            this.cornerRadius = i;
            this.margin = i2;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.bitmapShader = bitmapShader;
            float f = i2;
            this.mBitmapRect = new RectF(f, f, bitmap.getWidth() - i2, bitmap.getHeight() - i2);
            Paint paint = new Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.mRect;
            float f = this.cornerRadius;
            canvas.drawRoundRect(rectF, f, f, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.mRect;
            int i = this.margin;
            rectF.set(i, i, rect.width() - this.margin, rect.height() - this.margin);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.paint.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    public RoundedBitmapDisplayer(int i) {
        this(i, 0);
    }

    @Override // com.nostra13.universalimageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        imageAware.setImageDrawable(new RoundedDrawable(bitmap, this.cornerRadius, this.margin));
    }

    public RoundedBitmapDisplayer(int i, int i2) {
        this.cornerRadius = i;
        this.margin = i2;
    }
}

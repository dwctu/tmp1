package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import dc.ah4;
import dc.ce3;
import dc.th4;
import dc.vi1;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes4.dex */
public class ChatBurnedLayout extends GifImageView {
    public Paint a;
    public Paint b;
    public Matrix c;
    public int d;

    public ChatBurnedLayout(@NonNull Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.a = new Paint();
        Paint paint = new Paint();
        this.b = paint;
        paint.setTextSize(ce3.g(getContext(), 13.0f));
        this.b.setColor(th4.b(getContext(), R.color.chat_f_pattern_all_text_color));
        this.b.setAntiAlias(true);
        this.b.setTextAlign(Paint.Align.CENTER);
        this.c = new Matrix();
        setImageDrawable(th4.d(getContext(), this.d));
    }

    public Bitmap b(float f, float f2, Bitmap bitmap) {
        int i;
        int i2;
        int i3;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i4 = 0;
        if (width <= height ? height <= width || height * 4 <= width * 9 : width * 4 <= height * 9) {
            this.c.postScale(((int) f) / bitmap.getWidth(), ((int) f2) / bitmap.getHeight());
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, this.c, true);
        }
        int i5 = width * height2;
        int i6 = width2 * height;
        if (i5 <= i6) {
            float f3 = width2 / width;
            int i7 = (int) ((height2 - (height * f3)) * 0.5f);
            this.c.setScale(f3, f3);
            if (i7 >= 0) {
                return Bitmap.createBitmap(bitmap, 0, i7, width, i7 + height2 > height ? height - i7 : height2, this.c, true);
            }
            int i8 = (i6 / height2) / 2;
            int i9 = width / 2;
            int i10 = i9 - i8;
            int i11 = i9 + i8;
            if (i10 >= 0 && i11 <= width) {
                return Bitmap.createBitmap(bitmap, i10, 0, i11, height, this.c, true);
            }
            int i12 = (i5 / width2) / 2;
            int i13 = height / 2;
            int i14 = i13 - i12;
            int i15 = i13 + i12;
            if (i14 < 0 || i15 > height) {
                i = height;
            } else {
                i = i15;
                i4 = i14;
            }
            return Bitmap.createBitmap(bitmap, 0, i4, width, i, this.c, true);
        }
        float f4 = height2 / height;
        int i16 = (int) ((width2 - (width * f4)) * 0.5f);
        this.c.setScale(f4, f4);
        if (i16 >= 0) {
            if (width + i16 > width) {
                width -= i16;
            }
            return Bitmap.createBitmap(bitmap, i16, 0, width, height2 > height ? height : height2, this.c, true);
        }
        int i17 = (i5 / width2) / 2;
        int i18 = height / 2;
        int i19 = i18 - i17;
        int i20 = i17 + i18;
        if (i19 >= 0 && i20 <= height) {
            return Bitmap.createBitmap(bitmap, 0, i19, width, i20, this.c, true);
        }
        int i21 = (i6 / height2) / 2;
        int i22 = width / 2;
        int i23 = i22 - i21;
        int i24 = i22 + i21;
        if (i23 < 0 || i24 > width) {
            i2 = width;
            i3 = 0;
        } else {
            i2 = i24;
            i3 = i23;
        }
        return Bitmap.createBitmap(bitmap, i3, 0, i2, height, this.c, true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        BitmapDrawable bitmapDrawable = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable)) ? null : (BitmapDrawable) getDrawable();
        if (bitmapDrawable == null) {
            super.onDraw(canvas);
            return;
        }
        this.c.reset();
        Bitmap bitmapB = b(getWidth(), getHeight(), bitmapDrawable.getBitmap());
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        this.a.setShader(new BitmapShader(bitmapB, tileMode, tileMode));
        canvas.drawPaint(this.a);
        canvas.drawText(ah4.e(R.string.picture_burned), getWidth() / 2, ce3.a(getContext(), 65.0f), this.b);
    }

    public ChatBurnedLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.ChatBurnedLayout);
        typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.d = typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.chatting_burned_photo);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    public ChatBurnedLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}

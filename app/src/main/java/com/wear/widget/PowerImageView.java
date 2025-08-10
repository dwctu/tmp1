package com.wear.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.lovense.wear.R;
import dc.vi1;
import java.io.InputStream;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class PowerImageView extends ImageView implements View.OnClickListener {
    public Movie a;
    public Bitmap b;
    public long c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;

    public PowerImageView(Context context) {
        super(context);
    }

    public final int a(TypedArray typedArray, Context context, AttributeSet attributeSet) {
        try {
            try {
                Field declaredField = TypedArray.class.getDeclaredField("mValue");
                declaredField.setAccessible(true);
                int i = ((TypedValue) declaredField.get(typedArray)).resourceId;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                return i;
            } catch (Exception e) {
                e.printStackTrace();
                if (typedArray == null) {
                    return 0;
                }
                typedArray.recycle();
                return 0;
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    public final boolean b(Canvas canvas) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.c == 0) {
            this.c = jUptimeMillis;
        }
        int iDuration = this.a.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        long j = iDuration;
        this.a.setTime((int) ((jUptimeMillis - this.c) % j));
        this.a.draw(canvas, 0.0f, 0.0f);
        if (jUptimeMillis - this.c < j) {
            return false;
        }
        this.c = 0L;
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == getId()) {
            this.f = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Movie movie = this.a;
        if (movie == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.g) {
            b(canvas);
            invalidate();
        } else if (this.f) {
            if (b(canvas)) {
                this.f = false;
            }
            invalidate();
        } else {
            movie.setTime(0);
            this.a.draw(canvas, 0.0f, 0.0f);
            canvas.drawBitmap(this.b, (this.d - this.b.getWidth()) / 2, (this.e - this.b.getHeight()) / 2, (Paint) null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a != null) {
            setMeasuredDimension(this.d, this.e);
        }
    }

    public PowerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PowerImageView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.PowerImageView);
        this.g = typedArrayObtainStyledAttributes.getBoolean(0, false);
        int iA = a(typedArrayObtainStyledAttributes, context, attributeSet);
        if (iA != 0) {
            InputStream inputStreamOpenRawResource = getResources().openRawResource(iA);
            Movie movieDecodeStream = Movie.decodeStream(inputStreamOpenRawResource);
            this.a = movieDecodeStream;
            if (movieDecodeStream != null) {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenRawResource);
                this.d = bitmapDecodeStream.getWidth();
                this.e = bitmapDecodeStream.getHeight();
                bitmapDecodeStream.recycle();
                if (this.g) {
                    return;
                }
                this.b = BitmapFactory.decodeResource(getResources(), R.drawable.start_play);
                setOnClickListener(this);
            }
        }
    }
}

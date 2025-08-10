package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: CornerTransform.java */
/* loaded from: classes4.dex */
public class ln3 implements eh<Bitmap> {
    public cj b;
    public float c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    public ln3(Context context, float f) {
        this.b = kf.c(context).f();
        this.c = f;
    }

    @Override // dc.eh
    @NonNull
    public ti<Bitmap> a(@NonNull Context context, @NonNull ti<Bitmap> tiVar, int i, int i2) {
        int height;
        int width;
        Bitmap bitmap = tiVar.get();
        if (i > i2) {
            float f = i2;
            float f2 = i;
            height = bitmap.getWidth();
            width = (int) (bitmap.getWidth() * (f / f2));
            if (width > bitmap.getHeight()) {
                width = bitmap.getHeight();
                height = (int) (bitmap.getHeight() * (f2 / f));
            }
        } else if (i < i2) {
            float f3 = i;
            float f4 = i2;
            int height2 = bitmap.getHeight();
            int height3 = (int) (bitmap.getHeight() * (f3 / f4));
            if (height3 > bitmap.getWidth()) {
                height = bitmap.getWidth();
                width = (int) (bitmap.getWidth() * (f4 / f3));
            } else {
                height = height3;
                width = height2;
            }
        } else {
            height = bitmap.getHeight();
            width = height;
        }
        this.c *= width / i2;
        Bitmap bitmapD = this.b.d(height, width, Bitmap.Config.ARGB_8888);
        if (bitmapD == null) {
            bitmapD = Bitmap.createBitmap(height, width, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapD);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        int width2 = (bitmap.getWidth() - height) / 2;
        int height4 = (bitmap.getHeight() - width) / 2;
        if (width2 != 0 || height4 != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width2, -height4);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        float f5 = this.c;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        if (this.d) {
            float f6 = this.c;
            canvas.drawRect(0.0f, 0.0f, f6, f6, paint);
        }
        if (this.e) {
            canvas.drawRect(canvas.getWidth() - this.c, 0.0f, canvas.getWidth(), this.c, paint);
        }
        if (this.f) {
            float height5 = canvas.getHeight();
            float f7 = this.c;
            canvas.drawRect(0.0f, height5 - f7, f7, canvas.getHeight(), paint);
        }
        if (this.g) {
            canvas.drawRect(canvas.getWidth() - this.c, canvas.getHeight() - this.c, canvas.getWidth(), canvas.getHeight(), paint);
        }
        return jl.d(bitmapD, this.b);
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
    }

    public void c(boolean z, boolean z2, boolean z3, boolean z4) {
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
    }
}

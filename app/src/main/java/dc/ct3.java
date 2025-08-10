package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: GlideRoundTransform.java */
/* loaded from: classes4.dex */
public class ct3 implements eh<Bitmap> {
    public cj b;
    public float c;
    public float d;
    public float e;
    public float f;

    public ct3(Context context, float f, float f2, float f3, float f4) {
        this.b = kf.c(context).f();
        this.c = f;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        this.d = f2;
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        this.e = f3;
        int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        this.f = f4;
        int i4 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
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
        float f5 = width / i2;
        this.c *= f5;
        this.d *= f5;
        this.e *= f5;
        this.f *= f5;
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
        float f6 = this.c;
        float f7 = this.e;
        float f8 = this.f;
        float f9 = this.d;
        float[] fArr = {f6, f6, f7, f7, f8, f8, f9, f9};
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return jl.d(bitmapD, this.b);
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
    }
}

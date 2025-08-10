package dc;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import java.security.MessageDigest;

/* compiled from: CornersTranform.java */
/* loaded from: classes4.dex */
public class dj3 extends kl {
    public float b;

    public dj3(float f) {
        this.b = f;
    }

    @Override // dc.xg
    public void b(MessageDigest messageDigest) {
    }

    @Override // dc.kl
    public Bitmap c(cj cjVar, Bitmap bitmap, int i, int i2) {
        return d(cjVar, bitmap);
    }

    public final Bitmap d(cj cjVar, Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = null;
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapD = cjVar.d(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmapD == null || bitmapD.isRecycled()) {
            bitmapCreateBitmap = bitmapD;
        } else {
            bitmapD.recycle();
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float f = this.b;
        canvas.drawRoundRect(rectF, f, f, paint);
        return bitmapCreateBitmap;
    }
}

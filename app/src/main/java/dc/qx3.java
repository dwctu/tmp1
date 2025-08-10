package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: BlurTransformation.java */
/* loaded from: classes4.dex */
public class qx3 extends px3 {
    public final int b;
    public final int c;

    public qx3() {
        this(25, 1);
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.BlurTransformation.1" + this.b + this.c).getBytes(xg.a));
    }

    @Override // dc.px3
    public Bitmap d(@NonNull Context context, @NonNull cj cjVar, @NonNull Bitmap bitmap, int i, int i2) throws Throwable {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.c;
        Bitmap bitmapD = cjVar.d(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        c(bitmap, bitmapD);
        Canvas canvas = new Canvas(bitmapD);
        int i4 = this.c;
        canvas.scale(1.0f / i4, 1.0f / i4);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            tx3.a(context, bitmapD, this.b);
            return bitmapD;
        } catch (RSRuntimeException unused) {
            return sx3.a(bitmapD, this.b, true);
        }
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (obj instanceof qx3) {
            qx3 qx3Var = (qx3) obj;
            if (qx3Var.b == this.b && qx3Var.c == this.c) {
                return true;
            }
        }
        return false;
    }

    @Override // dc.xg
    public int hashCode() {
        return 737513610 + (this.b * 1000) + (this.c * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.b + ", sampling=" + this.c + ")";
    }

    public qx3(int i) {
        this(i, 1);
    }

    public qx3(int i, int i2) {
        this.b = i;
        this.c = i2;
    }
}

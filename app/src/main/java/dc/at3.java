package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: Utils.java */
/* loaded from: classes4.dex */
public class at3 {
    public static int a(float f, float f2) {
        int iRound = Math.round(f * 1000000.0f);
        int iRound2 = Math.round(f2 * 1000000.0f);
        if (iRound > iRound2) {
            return 1;
        }
        return iRound < iRound2 ? -1 : 0;
    }

    public static int b(Context context, float f) {
        if (context == null || a(0.0f, f) == 0) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void c(Canvas canvas, Paint paint, Bitmap bitmap, Rect rect) {
        try {
            if (NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk())) {
                d(canvas, bitmap, rect);
                return;
            }
        } catch (Exception unused) {
        }
        canvas.drawBitmap(bitmap, rect.left, rect.top, paint);
    }

    public static void d(Canvas canvas, Bitmap bitmap, Rect rect) {
        NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk());
        new NinePatch(bitmap, bitmap.getNinePatchChunk(), null).draw(canvas, rect);
    }

    public static Bitmap e(int i, int i2, Drawable drawable) {
        Bitmap bitmap;
        try {
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && bitmap.getHeight() > 0) {
                Matrix matrix = new Matrix();
                matrix.postScale((i * 1.0f) / bitmap.getWidth(), (i2 * 1.0f) / bitmap.getHeight());
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap f(Context context, int i, int i2, int i3) {
        if (context == null || i <= 0 || i2 <= 0 || i3 == 0) {
            return null;
        }
        return e(i, i2, th4.d(context, i3));
    }

    public static Rect g(String str, float f) {
        Paint paint = new Paint();
        Rect rect = new Rect();
        paint.setTextSize(f);
        paint.getTextBounds(str, 0, str.length(), rect);
        paint.reset();
        return rect;
    }

    public static float h(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    public static boolean i(Bitmap bitmap) {
        return bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0;
    }
}
